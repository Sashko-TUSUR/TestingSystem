package com.dreamteam.TestingSystemNew.service;

import com.dreamteam.TestingSystemNew.payload.QuestionDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class ConverterJSON{

    public QuestionDTO parseJSON(String json){
        Type type = new TypeToken<QuestionDTO>(){}.getType();
        return new Gson().fromJson(json, type);
    }

    public String converterToJSON(QuestionDTO questionDTO){
        return new Gson().toJson(questionDTO, QuestionDTO.class);
    }

    public String arrayConverterToJSON(ArrayList<QuestionDTO> questionDTO){
        Type listType = new TypeToken<List<QuestionDTO>>() {}.getType();
        return new Gson().toJson(questionDTO, listType);
    }

    public String mapConverterToJSON(Map<String, String> template){
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return new Gson().toJson(template, type);
    }

    public ArrayList<QuestionDTO> parseArrayFromJSON(String json){
        Type listType = new TypeToken<List<QuestionDTO>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }

    public Map<String, String> parseMapFromJSON(String json){
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return new Gson().fromJson(json, type);
    }


}
