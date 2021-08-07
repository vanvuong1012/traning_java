package com.example.amit_training.service;

import com.example.amit_training.model.Class;
import com.example.amit_training.model.Student;
import com.example.amit_training.model.response.BaseResponse;
import com.example.amit_training.repository.ClassRepository;
import com.example.amit_training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public BaseResponse findAll() {
        BaseResponse result = new BaseResponse();
        result.setData(studentRepository.findAll());
        return result;
    }
    public BaseResponse findById(int id) {
        BaseResponse result = new BaseResponse();
        Student aStudent = studentRepository.findById(id).orElse(null);
        result.setData(aStudent);
        return result;
    }
    public BaseResponse create(Student aStudent) {
        BaseResponse result = new BaseResponse();
        result.setData(studentRepository.save(aStudent));
        return result;
    }
    public BaseResponse update(Student aStudent) {
        BaseResponse result = new BaseResponse();
        if (!studentRepository.findById(aStudent.getId()).isPresent()) {

            result.setMessage("Class Not Found");
        } else {
            result.setData(studentRepository.save(aStudent));
        }
        return result;
    }
    public BaseResponse delete(int id) {
        BaseResponse result = new BaseResponse();
        Student aStudent = studentRepository.findById(id).orElse(null);
        if (aStudent == null) {
            result.setMessage("Class Not Found");
        } else {
            studentRepository.delete(aStudent);
            result.setMessage("success");
        }
        return result;
    }
}


