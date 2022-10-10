package com.SpringAPI.SpringAPI.Controllers;

import com.SpringAPI.SpringAPI.Entities.Book;
import com.SpringAPI.SpringAPI.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class BookController {

//    @RequestMapping(value = "/books",method = RequestMethod.GET)
//    @ResponseBody
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List <Book> getBooks(){

//        Book book=new Book();
//
//        book.setId(121);
//        book.setName("Geeta");
//        book.setAuthor("XYZ");
        return this.bookService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public  Book getBook(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    //craete new book
    @PostMapping("/books")
           public Book addBook(@RequestBody Book book){
        Book b =this.bookService.addBook(book);
        return book;
    }
    //delete book
    @DeleteMapping("/books/{bookID}")
    public  void deleteBook(@PathVariable("/bookID") int bookID){
        this.bookService.deleteBook(bookID);

    }

    //update book
    @PutMapping("/books/{bookid}")
    public  Book updateBook(@RequestBody Book book ,@PathVariable("/bookid") int bookid){
        this.bookService.updateBook(book,bookid);
        return book;

    }

}
