package com.SpringAPI.SpringAPI.Controllers;

import com.SpringAPI.SpringAPI.Entities.Book;
import com.SpringAPI.SpringAPI.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
public class BookController {

    //    @RequestMapping(value = "/books",method = RequestMethod.GET)
//    @ResponseBody
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List <Book>> getBooks(){

//        Book book=new Book();
//
//        book.setId(121);
//        book.setName("Geeta");
//        book.setAuthor("XYZ");
        List<Book> list=bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/books/{id}")
    public  ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book=bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //create new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b=null;
        try {
            b=this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    //delete book
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    //update book
    @PutMapping("/books/{bookid}")
    public  ResponseEntity<Book> updateBook(@RequestBody Book book , @PathVariable("bookid") int bookid){
        try {
            this.bookService.updateBook(book,bookid);
            return ResponseEntity.ok().body(book);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }



    }

}