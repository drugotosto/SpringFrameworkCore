package com.ferrero.service;

import com.ferrero.dao.BookDao;
import com.ferrero.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by drugo on 31/05/2017.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

}

