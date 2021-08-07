package com.example.amit_training.controller;

import com.example.amit_training.model.Class;
import com.example.amit_training.model.response.BaseResponse;
import com.example.amit_training.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ClassController {

    @Autowired
    private ClassService classService;
    //get all
    @GetMapping("/class")
    public ResponseEntity<BaseResponse> findAllClass() {
        return new ResponseEntity<BaseResponse>(classService.findAll(), HttpStatus.OK);
    }
    //get id
    @GetMapping("/class/{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable int id) {
        return new ResponseEntity<BaseResponse>(classService.findById(id), HttpStatus.OK);
    }
    //create new class
    @PostMapping("/class")
    public ResponseEntity<BaseResponse> create(@RequestBody Class aClass) {
        return new ResponseEntity<BaseResponse>(classService.create(aClass), HttpStatus.OK);
    }
    @PutMapping("/class")
    public ResponseEntity<BaseResponse> update(@RequestBody Class aClass) {
        return new ResponseEntity<BaseResponse>(classService.update(aClass), HttpStatus.OK);
    }
    @DeleteMapping("/class")
    public ResponseEntity<BaseResponse> delete(@RequestBody DeleteClass request) {
        return new ResponseEntity<BaseResponse>(classService.delete(request.getId()), HttpStatus.OK);
    }
}

