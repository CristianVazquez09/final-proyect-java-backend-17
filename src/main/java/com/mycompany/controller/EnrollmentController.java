package com.mycompany.controller;

import com.mycompany.dto.EnrollmentDTO;
import com.mycompany.model.Enrollment;
import com.mycompany.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;

    @Qualifier ("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity< List<EnrollmentDTO>> readAll () throws Exception {


        List<EnrollmentDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById ( @PathVariable("id") Integer id) throws Exception {
        Enrollment enrollment= service.readById(id);
        EnrollmentDTO enrollmentDTO = convertToDTO(enrollment);

        return new ResponseEntity<>(enrollmentDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create (@Valid @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {

        Enrollment enrollment= service.save(convertToEntity(enrollmentDTO));

        return new ResponseEntity<>(convertToDTO(enrollment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update (@Valid @RequestBody EnrollmentDTO enrollmentDTO ,@PathVariable("id") Integer id) throws Exception {
        Enrollment enrollment =service.update(convertToEntity(enrollmentDTO),id);

        return new ResponseEntity<>(convertToDTO(enrollment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/group")
    public ResponseEntity<Map <String, List<String>>> group () throws Exception {


        Map<String , List<String>> list= service.groupStudentsByCourse();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }




    //-- * -- * -- * -- * -- * -- * -- *    UTILITARIOS   *-- * -- * -- * -- * -- * -- * -- * --

    private EnrollmentDTO convertToDTO (Enrollment obj){
        return mapper.map(obj, EnrollmentDTO.class);
    }

    private Enrollment convertToEntity (EnrollmentDTO dto){
        return mapper.map(dto, Enrollment.class);
    }
}
