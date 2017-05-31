package com.ferrero.service;

import com.ferrero.dao.CourseDao;
import com.ferrero.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by drugo on 31/05/2017.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;

    @Override
    public void save(Course course) {courseDao.save(course);}
}
