package com.dreamteam.TestingSystemNew.service;

import com.dreamteam.TestingSystemNew.enumeration.ComplexityName;
import com.dreamteam.TestingSystemNew.model.*;
import com.dreamteam.TestingSystemNew.payload.*;
import com.dreamteam.TestingSystemNew.repository.*;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConverterJSON converterJSON;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ComplexityRepository complexityRepository;

    @Autowired
    TestRepository templateRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository seminarRepository;

    @Autowired
    TeacherRepository teacherRepository;
    /*это я добавил(саня)*/
    @Autowired
    DidacticUnitRepository didacticUnitRepository;

    Logger log = LoggerFactory.getLogger(UserService.class);
    private Object DidacticUnit;

    /*Получение списка тем по дисциплинам*/
    /* public List<SubjectResponse> getSubjectsAndTopics(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with id: " + id)
                );
        List<TopicResponse> topics = new ArrayList<>();
        List<SubjectResponse> subjects = new ArrayList<>();
        List<Template> templates = templateRepository.findAll();
        for (Subject e : user.getSubjects()){
            for (Topic t : e.getTopics()){
                topics.add(new TopicResponse(t.getTopicId(), t.getName(),getDateTimeOfTemplate(templates, t)));
            }
            subjects.add(new SubjectResponse(e.getSubjectId(), e.getName(), topics));
            topics = new ArrayList<>();
        }
        return subjects;
    }

    /*получение дидактической еденицы*/
    //  public List<DidacticUnitResponse> getDidacticUnit(Long id,String name){
  // DidacticUnit didacticUnit =didacticUnitRepository.findById(id)
    //    .orElseThrow(() ->
       // new UsernameNotFoundException("DidacticUnit not found with id: " + id)
       // );
   // }




    /*Сохранение дисциплины*/
    public void saveSubject(String subjectResponse){
        Subject subject = new Subject();
        subject.setName(subjectResponse);
        subjectRepository.save(subject);
    }

    /*Сохранение темы*/
    public void saveTopic(TopicRequest topicRequest){
        Topic topic = new Topic();
        topic.setName(topicRequest.getTitleTopic());
        topic.setCount(topicRequest.getCountQuestion());
        Topic newTopic =  topicRepository.save(topic);
        Subject subject = subjectRepository.getByName(topicRequest.getTitleSubject());
        subject.getTopics().add(topic);
        subjectRepository.save(subject);
    }

    /*Список групп для администратора*/
    public List<Group> getGroupForAdmin(){
        return groupRepository.findAll();
    }

    /*Список групп по дисциплинам для преподователя*/
    public List<GroupResponse> getGroupForTeacher(Long userId){
        List<GroupResponse> groupResponseList = new ArrayList<>();
        User user = userRepository.findById(userId).orElseThrow();
        for (Teacher t : user.getTeachers()){
            groupResponseList.add(new GroupResponse(t.getSubject().getName(), t.getGroupList()));
        }
        return groupResponseList;
    }

    /*Добавление нагрузки для преподователя*/
    public void setUserTeacher(TeacherRequest teacherRequest){
        Teacher teacher = new Teacher();
        List<Group> groupList = new ArrayList<>();
        teacher.setSeminar(seminarRepository.findByNumber(teacherRequest.getSeminarNumber()));
        teacher.setSubject(subjectRepository.getBySubjectId(teacherRequest.getSubjectId()));
        for (Long i : teacherRequest.getGroupsId()){
            groupList.add(groupRepository.getByGroupId(i));
        }
        teacher.setGroupList(groupList);
        Teacher teacher1 = teacherRepository.save(teacher);
        User user = userRepository.findById(teacherRequest.getUserId()).orElseThrow();
        user.getTeachers().add(teacher1);
        userRepository.save(user);
    }

    /*Добавление семестра*/
    public void saveSeminar(int number){
        Seminar seminar = new Seminar();
        seminar.setNumber(number);
        seminarRepository.save(seminar);
    }

    /*Установка сложности по определенной теме для пользователя*/
    public void setComplexityForUser(ComplexityRequest complexityRequest){
        Complexity complexity = new Complexity();
        complexity.setName(ComplexityName.values()[complexityRequest.getIndexComplexity()].toString());
        complexity.getTopics().add(topicRepository.findById(complexityRequest.getTopicId()).orElseThrow());
        User user = userRepository.findById(complexityRequest.getUserId()).orElseThrow();
        user.getComplexity().add(complexity);
        complexityRepository.save(complexity);
        userRepository.save(user);
    }

    /*Добавление группы*/
    public void saveGroup(String number){
        Group group = new Group();
        group.setName(number);
        groupRepository.save(group);
    }

    /*Получениеи даты и время из шаблона*/
    public DateTime getDateTimeOfTemplate(List<Test> templates, Topic topic){
        DateTime dateTime = new DateTime();
        for (Test template : templates){
            if (template.getTopic().equals(topic)){
                dateTime.setYear(template.getOpeningDate().getYear());
                dateTime.setMonth(template.getOpeningDate().getMonth());
                dateTime.setDay(template.getOpeningDate().getDay());
                dateTime.setHours(template.getOpeningDate().getHours());
                dateTime.setMin(template.getOpeningDate().getMinutes());
            }
        }
        return dateTime;
    }

    /*Сохранение вопроса*/
    public void saveQuestion(QuestionRequest questionRequest){
        Topic topic = topicRepository.findById(questionRequest.getTopic_id()).orElseThrow();
        Complexity complexity = complexityRepository.findById(questionRequest.getComplexity_id()).orElseThrow();
        Question question = new Question(converterJSON.converterToJSON(questionRequest.getQuestionDTO()), complexity, topic);

        questionRepository.save(question);
    }

    public UserProfile getUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return new UserProfile(userId, user.getUserName(), user.getName(), user.getLastName(), user.getMiddleName());
    }

    /*Сохранение шаблона*/
    public void saveTemplate(TemplateRequest templateRequest){
        Test template = new Test();
        template.setTopic(topicRepository.findById(templateRequest.getTopicId()).orElseThrow());

        template.setOpeningDate(Timestamp.valueOf(
                templateRequest.getOpeningTime().getYear() + "-" +
                        templateRequest.getOpeningTime().getMonth() + "-" +
                        templateRequest.getOpeningTime().getDay() + " " +
                        templateRequest.getOpeningTime().getHours() + ":" +
                        templateRequest.getOpeningTime().getMin() + ":00.0"
        ));

        template.setClosingDate(Timestamp.valueOf(
                templateRequest.getClosingTime().getYear() + "-" +
                        templateRequest.getClosingTime().getMonth() + "-" +
                        templateRequest.getClosingTime().getDay() + " " +
                        templateRequest.getClosingTime().getHours() + ":" +
                        templateRequest.getClosingTime().getMin() + ":00.0"
        ));

        template.setSettings(converterJSON.mapConverterToJSON(templateRequest.getStringMap()));
        template.setUser(userRepository.findById(templateRequest.getUserId()).orElseThrow());
        templateRepository.save(template);
    }

    /*Получение варианта для пользователя в зависимости от сложности и темы*/
    public ArrayList<QuestionDTO> getOption(Long userId, Long topicId){
        Random rand = new Random();
        Complexity complexity = new Complexity();
        int randomIndex;
        int countEasy;
        int countMiddle;
        int countHard;

        ArrayList<QuestionDTO> questionDTOArrayList = new ArrayList<>();
        Topic topic = topicRepository.findById(topicId).orElseThrow();

        Template template = templateRepository.getByTopic(topic);
        User user = userRepository.findById(userId).orElseThrow();
        List<Complexity> complexityList = user.getComplexity();
        TemplateJSON templateJSON = new TemplateJSON(converterJSON.parseMapFromJSON(template.getSettings()));

        for (Complexity c : complexityList){
            if (c.getTopics().contains(topic)) complexity = c;
        }

        countEasy = Integer.parseInt(templateJSON.getTemplate().get(complexity.getName()).split(" ")[0]);
        countMiddle = Integer.parseInt(templateJSON.getTemplate().get(complexity.getName()).split(" ")[1]);
        countHard = Integer.parseInt(templateJSON.getTemplate().get(complexity.getName()).split(" ")[2]);

        ArrayList<Question> questionArrayListEasy = questionRepository.getByTopicAndComplexity(topic, ComplexityName.COMPLEXITY_EASY.toString());
        ArrayList<Question> questionArrayListMiddle = questionRepository.getByTopicAndComplexity(topic, ComplexityName.COMPLEXITY_EASY.toString());
        ArrayList<Question> questionArrayListHard = questionRepository.getByTopicAndComplexity(topic, ComplexityName.COMPLEXITY_EASY.toString());

        for (int i = 0; i < countEasy; i++) {
            randomIndex = rand.nextInt(questionArrayListEasy.size());
            questionDTOArrayList.add(converterJSON.parseJSON(questionArrayListEasy.get(randomIndex).getQuestionJSON()));
            questionArrayListEasy.remove(randomIndex);
        }
        for (int i = 0; i < countMiddle; i++) {
            randomIndex = rand.nextInt(questionArrayListMiddle.size());
            questionDTOArrayList.add(converterJSON.parseJSON(questionArrayListMiddle.get(randomIndex).getQuestionJSON()));
            questionArrayListMiddle.remove(randomIndex);
        }
        for (int i = 0; i < countHard; i++) {
            randomIndex = rand.nextInt(questionArrayListHard.size());
            questionDTOArrayList.add(converterJSON.parseJSON(questionArrayListHard.get(randomIndex).getQuestionJSON()));
            questionArrayListHard.remove(randomIndex);
        }

        Result result = new Result();
        result.setVariant(converterJSON.arrayConverterToJSON(questionDTOArrayList));
        result.setUser(user);
        result.setResult(null);

        return questionDTOArrayList;
    }



}

