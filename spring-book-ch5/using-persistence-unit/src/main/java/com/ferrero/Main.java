package com.ferrero;

/**
 * Created by drugo on 31/05/2017.
 */
import com.ferrero.config.Ch5Configuration;
import com.ferrero.dao.StudentDaoJpaImpl;
import com.ferrero.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch5Configuration.class);

        StudentDaoJpaImpl dao = applicationContext.getBean(StudentDaoJpaImpl.class);

        Student student = new Student();
        student.setFirstName("Salvo");
        student.setLastName("Silvio");

        dao.save(student);
    }

}