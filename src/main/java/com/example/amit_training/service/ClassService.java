package com.example.amit_training.service;

import com.example.amit_training.model.Class;
import com.example.amit_training.model.response.BaseResponse;
import com.example.amit_training.repository.ClassRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public BaseResponse findAll() {
        BaseResponse result = new BaseResponse();
        result.setData(classRepository.findAll());
        return result;
    }
    public BaseResponse findById(int id) {
        BaseResponse result = new BaseResponse();
        Class aClass = classRepository.findById(id).orElse(null);
        result.setData(aClass);
        return result;
    }
    public BaseResponse create(Class aClass) {
        BaseResponse result = new BaseResponse();
        result.setData(classRepository.save(aClass));
        return result;
    }
    public BaseResponse update(Class aClass) {
        BaseResponse result = new BaseResponse();
        if (!classRepository.findById(aClass.getId()).isPresent()) {

            result.setMessage("Class Not Found");
        } else {
            result.setData(classRepository.save(aClass));
        }
        return result;
    }
    public BaseResponse delete(int id) {
        BaseResponse result = new BaseResponse();
        Class aClass = classRepository.findById(id).orElse(null);
        if (aClass == null) {
            result.setMessage("Class Not Found");
        } else {
            classRepository.delete(aClass);
            result.setMessage("success");
        }
        return result;
    }
}

