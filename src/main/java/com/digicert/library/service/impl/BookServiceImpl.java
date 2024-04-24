package com.digicert.library.service.impl;

import com.digicert.library.entity.Book;
import com.digicert.library.enums.ResponseCodesEnum;
import com.digicert.library.exception.GlobalRuntimeException;
import com.digicert.library.repository.BookRepository;
import com.digicert.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new GlobalRuntimeException(ResponseCodesEnum.BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID, ResponseCodesEnum.BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID.getResponseMessage() + " " + bookId);
        }
        return optionalBook.get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Book updateBook(Book book) {
        Optional<Book> existingBookOptional = bookRepository.findById(book.getId());
        if (existingBookOptional.isEmpty()) {
            throw new GlobalRuntimeException(ResponseCodesEnum.BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID, ResponseCodesEnum.BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID.getResponseMessage() + " " + book.getId());
        }
        Book existingBook = existingBookOptional.get();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        Book updatedBook = bookRepository.save(existingBook);
        return updatedBook;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new GlobalRuntimeException(ResponseCodesEnum.BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID, ResponseCodesEnum.BOOK_RECORD_NOT_FOUND_FOR_GIVEN_ID.getResponseMessage() + " " + bookId);
        }
        bookRepository.delete(optionalBook.get());
    }
}
