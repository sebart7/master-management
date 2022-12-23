package com.mastermanagement.mastermanagement.controller;

import com.mastermanagement.mastermanagement.dto.TeacherDTO;
import com.mastermanagement.mastermanagement.service.ITeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Validated
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll(){
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> create(@Valid @RequestBody TeacherDTO teacherDTO){
        TeacherDTO teacher = null;
        teacher = teacherService.save(teacherDTO);
        return new ResponseEntity<>(teacher,HttpStatus.CREATED);
    }

}
