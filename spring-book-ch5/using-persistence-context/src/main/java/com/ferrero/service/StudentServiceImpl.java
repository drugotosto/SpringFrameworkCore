package com.ferrero.service;

import com.ferrero.dao.StudentDao;
import com.ferrero.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by drugo on 31/05/2017.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }
}
