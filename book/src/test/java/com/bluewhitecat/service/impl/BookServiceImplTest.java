package com.bluewhitecat.service.impl;

import com.bluewhitecat.pojo.Book;
import com.bluewhitecat.service.BookService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "多喝热水", "你猜", new BigDecimal(123.44), 1000, 1000, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(6, "多喝热水", "你猜", new BigDecimal(123.44), 1000, 1000, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(6);
        Assert.assertNotNull(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        Assert.assertNotNull(books);
    }
}