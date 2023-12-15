package com.mycompany.service.impl;

import com.mycompany.model.Course;
import com.mycompany.model.Enrollment;
import com.mycompany.model.EnrollmentDetail;
import com.mycompany.repo.IEnrollmentRepo;
import com.mycompany.repo.IGenericRepo;
import com.mycompany.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment,Integer> implements IEnrollmentService {

    private final IEnrollmentRepo  repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }


    @Override
    public Map<String, List<String>> groupStudentsByCourse() {

        return repo.findAll().stream()
                .flatMap(enrollment -> enrollment.getDetails().stream()
                        .map(EnrollmentDetail::getCourse)
                        .map(Course::getName)
                        .collect(Collectors.toMap(
                                courseName -> courseName,
                                courseName -> enrollment.getStudent().getName()
                        )).entrySet().stream()
                )
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }




}
