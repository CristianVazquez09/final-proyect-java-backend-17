package com.mycompany.controller;

import com.mycompany.dto.CourseDTO;
import com.mycompany.model.Course;
import com.mycompany.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    @Qualifier ("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity< List<CourseDTO>> readAll () throws Exception {

        List<CourseDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readById ( @PathVariable("id") Integer id) throws Exception {
        Course course= service.readById(id);
        CourseDTO courseDTO = convertToDTO(course);

        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create (@Valid @RequestBody CourseDTO courseDTO) throws Exception {

        Course course= service.save(convertToEntity(courseDTO));

        return new ResponseEntity<>(convertToDTO(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update (@Valid @RequestBody CourseDTO courseDTO ,@PathVariable("id") Integer id) throws Exception {
        Course course =service.update(convertToEntity(courseDTO),id);

        return new ResponseEntity<>(convertToDTO(course),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    //-- * -- * -- * -- * -- * -- * -- *    UTILITARIOS   *-- * -- * -- * -- * -- * -- * -- * --

    private CourseDTO convertToDTO (Course obj){
        return mapper.map(obj, CourseDTO.class);
    }

    private Course convertToEntity (CourseDTO dto){
        return mapper.map(dto, Course.class);
    }
}
