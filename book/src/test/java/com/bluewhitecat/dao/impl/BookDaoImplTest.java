package com.bluewhitecat.dao.impl;

import com.bluewhitecat.dao.BookDao;
import com.bluewhitecat.pojo.Book;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "佛系喝水", "你猜", new BigDecimal(123.44), 100000, 0, null));
    }

    @Test
    public void deleteBookById() {
        int deleteBookById = bookDao.deleteBookById(22);
        Assert.assertEquals(1, deleteBookById);
    }

    @Test
    public void updateBook() {
        int updateBook = bookDao.updateBook(new Book(23, "躺平", "你猜", new BigDecimal(123.44), 100000, 110, null));
        Assert.assertEquals(1, updateBook);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(23);
        Assert.assertNotNull(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        Assert.assertNotNull(books);
    }
}