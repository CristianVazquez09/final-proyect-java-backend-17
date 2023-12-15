package com.mycompany.service;

import com.mycompany.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {


    List<Student> sortByAge ();


}
