package com.ferrero;

import com.ferrero.config.Ch5Configuration;
import com.ferrero.model.Book;
import com.ferrero.model.Course;
import com.ferrero.service.BookService;
import com.ferrero.service.CourseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by drugo on 31/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch5Configuration.class);

        BookService bookService = applicationContext.getBean(BookService.class);
        CourseService courseService =applicationContext.getBean(CourseService.class);
//        StudentService studentService =applicationContext.getBean(StudentService.class);
//
//        Student student = new Student();
//        student.setFirstName("Maury");
//        student.setLastName("Maaaa");
//        studentService.save(student);

        Book book = new Book();
        book.setName("Il libro della giungla 2");
        bookService.save(book);

        Course course = new Course();
        course.setTitle("DataBase 2");
        courseService.save(course);
    }

}
