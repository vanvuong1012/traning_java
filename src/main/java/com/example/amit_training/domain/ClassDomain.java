package com.example.amit_training.domain;

import com.example.amit_training.model.Class;
import com.example.amit_training.model.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClassDomain {
    private Map<String, Class> cacheByName = new HashMap<>();
    private Map<Integer, Class> cacheById = new HashMap<>();
    private static int IDD = 0;

    private synchronized int getIDD(){
        IDD ++;
        return IDD;
    }

    public Class findByName(String name){
        return cacheByName.get(name);
    }
    public Class findId(Integer id){
        return cacheById.get(id);
    }

    public List<Class> getAllClass(){
        return new ArrayList<>(cacheById.values());
    }


    public void createdClass(String name){
        Class newClass = new Class();
        newClass.setId(this.getIDD());
        newClass.setName(name);
        newClass.setStudents(new HashSet<Student>());
        cacheByName.put(name , newClass);
        cacheById.put(newClass.getId() , newClass);
    }
    public void updateClass(int id, String update){
        Class classUpdate = findId(id);
        classUpdate.setName(update);
        cacheByName.put(update, classUpdate);
    }
    public void deleteClass(int id,String name)
    {
        Class classDelete = findId(id);
        cacheById.remove(id);
        cacheByName.remove(name);
    }
}



