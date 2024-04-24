package com.digicert.library.controller;

import com.digicert.library.entity.Book;
import com.digicert.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Tag(name = "Book", description = "Book Crud Operations")
@RequestMapping("api/books")
public class BookController {

    public static final String BOOK_WAS_DELETED_SUCCESSFULLY = "Book was deleted successfully";
    public static final String MESSAGE_KEY = "message";

    private final BookService bookService;

    @Operation(summary = "Create book")
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
      Book savedBook = bookService.createBook(book);
      return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve book by id")
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId) {
      Book book =  bookService.getBookById(bookId);
      return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve All books")
    @GetMapping
    public ResponseEntity<List<Book>>getAllBooks() {
      List<Book> bookList = bookService.getAllBooks();
      return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @Operation(summary = "Update book by Id")
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long bookId,@RequestBody Book book) {
          book.setId(bookId);
          Book updatedBook =  bookService.updateBook(book);
          return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @Operation(summary = "Delete book by id")
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(Collections.singletonMap(MESSAGE_KEY, BOOK_WAS_DELETED_SUCCESSFULLY), HttpStatus.OK);
    }

}
