package com.example.amit_training.controller;
import com.example.amit_training.model.Student;
import com.example.amit_training.model.response.BaseResponse;
import com.example.amit_training.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student")
    public ResponseEntity<BaseResponse> findAllStudent() {
        return new ResponseEntity<BaseResponse>(studentService.findAll(), HttpStatus.OK);
    }
    //get id
    @GetMapping("/student/{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable int id) {
        return new ResponseEntity<BaseResponse>(studentService.findById(id), HttpStatus.OK);
    }
    //create new class
    @PostMapping("/student")
    public ResponseEntity<BaseResponse> create(@RequestBody Student aSt) {
        return new ResponseEntity<BaseResponse>(studentService.create(aSt), HttpStatus.OK);
    }
    @PutMapping("/student")
    public ResponseEntity<BaseResponse> update(@RequestBody Student aSt) {
        return new ResponseEntity<BaseResponse>(studentService.update(aSt), HttpStatus.OK);
    }
    @DeleteMapping("/student")
    public ResponseEntity<BaseResponse> delete(@RequestBody DeleteClass request) {
        return new ResponseEntity<BaseResponse>(studentService.delete(request.getId()), HttpStatus.OK);
    }
}

