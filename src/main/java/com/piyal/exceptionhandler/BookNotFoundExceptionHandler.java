package com.piyal.exceptionhandler;

import com.piyal.exception.BookNotFoundException;
import com.piyal.model.error.CustomError;
import com.piyal.model.error.ErrorMessage;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = { BookNotFoundException.class, ExceptionHandler.class })
public class BookNotFoundExceptionHandler
        implements ExceptionHandler<BookNotFoundException, HttpResponse<ErrorMessage>> {

    @Override
    public HttpResponse<ErrorMessage> handle(HttpRequest request, BookNotFoundException exception) {
        CustomError notFound = new CustomError(HttpStatus.NOT_FOUND.getReason(), HttpStatus.NOT_FOUND.getCode());
        System.out.println("Test");
        return HttpResponse.notFound(new ErrorMessage(notFound));
    }
}
