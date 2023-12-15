package com.mycompany.controller;

import com.mycompany.dto.StudentDTO;
import com.mycompany.dto.StudentSortDTO;
import com.mycompany.model.Student;
import com.mycompany.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    // Atributo del model mapper que tiene una inyección de dependencia
    @Qualifier ("studentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity< List<StudentDTO>> readAll () throws Exception {

        List<StudentDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById (@PathVariable("id") Integer id) throws Exception {
        Student student= service.readById(id);
        StudentDTO studentDTO = convertToDTO(student);

        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create ( @Valid @RequestBody StudentDTO studentDTO) throws Exception {


        Student student= service.save(convertToEntity(studentDTO));

        return new ResponseEntity<>(convertToDTO(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update (@Valid @RequestBody StudentDTO studentDTO ,@PathVariable("id") Integer id) throws Exception {
        Student student =service.update(convertToEntity(studentDTO),id);

        return new ResponseEntity<>(convertToDTO(student),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/sort")
    public ResponseEntity<List<StudentDTO>> sortByAge () throws Exception {


        List<StudentDTO> list= service.sortByAge().stream()
                .map(e -> new StudentDTO(e.getName(),e.getAge()))
                .toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }




    //-- * -- * -- * -- * -- * -- * -- *    UTILITARIOS   *-- * -- * -- * -- * -- * -- * -- * --

    private StudentDTO convertToDTO (Student obj){
        return mapper.map(obj, StudentDTO.class);
    }

    private Student convertToEntity (StudentDTO dto){
        return mapper.map(dto, Student.class);
    }
}
