package com.mycompany.service.impl;

import com.mycompany.model.Course;
import com.mycompany.repo.IGenericRepo;
import com.mycompany.repo.ICourseRepo;
import com.mycompany.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {

    private final ICourseRepo  repo;


    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }


}
