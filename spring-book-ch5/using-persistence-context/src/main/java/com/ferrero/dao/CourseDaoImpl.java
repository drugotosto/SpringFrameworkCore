package com.ferrero.dao;

import com.ferrero.model.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by drugo on 31/05/2017.
 */
@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Course course)  { entityManager.persist(course); }

}
