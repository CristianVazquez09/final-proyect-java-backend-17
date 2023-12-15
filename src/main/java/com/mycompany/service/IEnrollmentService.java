package com.mycompany.service;

import com.mycompany.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer> {


    Map <String, List<String>> groupStudentsByCourse();



}
