package com.dreamteam.TestingSystemNew.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotEmpty(message = "*Пожалуйста, введите ваш логин")
    private String userName;


    @NotEmpty(message = "*Пожалуйста, введите ваш пароль")
    private String password;


    @NotEmpty(message = "*Пожалуйста, введите ваше имя")
    private String name;


    @NotEmpty(message = "*Пожалуйста, введите вашу фамилию")
    private String lastName;


    @NotEmpty(message = "*Пожалуйста, введите ваш отчество")
    private String middleName;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    @ManyToMany
    @JoinTable(name = "users_subjects", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    @ManyToMany
    @JoinTable(name = "users_complexity", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "complexity_id"))
    private List<Complexity> complexity;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Result> results;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Test> test;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Teacher> teachers;

    public User(@Length(min = 5, message = "*Ваш логин должен содержать не менее 5 символов")
                @NotEmpty(message = "*Пожалуйста, введите ваш логин") String userName,
                @Length(min = 5, message = "*Ваш пароль должен содержать не менее 5 символов")
                @NotEmpty(message = "*Пожалуйста, введите ваш пароль") String password,
                @NotEmpty(message = "*Пожалуйста, введите ваше имя") String name,
                @NotEmpty(message = "*Пожалуйста, введите вашу фамилию") String lastName,
                @NotEmpty(message = "*Пожалуйста, введите ваше отчество") String middleName,
                Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.roles = roles;
    }
}
