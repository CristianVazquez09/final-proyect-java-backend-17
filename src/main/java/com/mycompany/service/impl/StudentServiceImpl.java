package com.mycompany.service.impl;

import com.mycompany.model.Student;
import com.mycompany.repo.IGenericRepo;
import com.mycompany.repo.IStudentRepo;
import com.mycompany.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  extends CRUDImpl<Student,Integer> implements IStudentService {

    private final IStudentRepo  repo;


    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Student> sortByAge() {
        return  repo.findAll().stream()
                .sorted( Comparator.comparing(Student::getAge).reversed())
                .toList();
    }
}
