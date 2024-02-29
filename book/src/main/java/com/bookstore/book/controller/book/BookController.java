package com.bookstore.book.controller.book;

import com.bookstore.book.model.book.Book;
import com.bookstore.book.services.book.BookService;
import com.bookstore.book.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<CustomResponse> addBook(@RequestBody Book book) {
        return bookService.insert(book);
    }
    @PostMapping(value = "/", produces = "application/json")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity<CustomResponse> update(@RequestBody Book book){
        return bookService.update(book);
    }
    @PostMapping(value = "/delete", produces = "application/json")
    public ResponseEntity<CustomResponse> delete(@RequestBody Integer id){
        return bookService.deleteOne(id);
    }

    @PostMapping(value = "/autor",produces = "application/json")
    public ResponseEntity<CustomResponse> getBookByAutor(@RequestBody String autor){
        return bookService.findByAutor(autor);
    }

    @GetMapping(value = "/dateDesc",produces = "application/json")
    public ResponseEntity<CustomResponse> getBookByDateDesc(){
        return bookService.findBooksByDateDesc()    ;
    }
}
