package com.piyal.controller;

import com.piyal.data.BookData;
import com.piyal.model.Book;
import com.piyal.service.BookService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

import java.util.List;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/api/v1/book")
public class BookController {
    @Inject
    BookService bookService;

    @Get("/all")
    List<Book> books() {
        return bookService.findAll();
    }

    @Get("/{id}")
    Book book(Long id) {
        return bookService.findById(id);
    }

    @Post("/{id}/delete")
    void deleteBook(Long id) {
        bookService.deleteById(id);
    }

    @Post("/save")
    Book saveBook(@Body BookData bookData) {
        return bookService.save(bookData);
    }

    @Post("/{id}/update")
    Book updateBook(Long id, @Body BookData bookData) {
        return bookService.update(id, bookData) ;
    }
}