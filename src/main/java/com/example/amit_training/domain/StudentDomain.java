package com.example.amit_training.domain;

import com.example.amit_training.model.Student;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class StudentDomain {
    private Map<String, Student> cacheStByName = new HashMap<>();
    private Map<Integer, Student> cacheStById = new HashMap<>();
    private static int IDD = 0;

    private synchronized int getIDD(){
        IDD ++;
        return IDD;
    }
    public List<Student> getAllStudent(){
        return new ArrayList<>(cacheStById.values());
    }
    public Student findId(Integer id){
        return cacheStById.get(id);
    }
    public Student findByName(String name){
        return cacheStByName.get(name);
    }





}
