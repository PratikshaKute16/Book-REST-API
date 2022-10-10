package com.SpringAPI.SpringAPI.Controllers;

import com.SpringAPI.SpringAPI.Entities.Book;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class BookController {

//    @RequestMapping(value = "/books",method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/books")
    public Book getBooks(){

        Book book=new Book();

        book.setId(121);
        book.setName("Geeta");
        book.setAuthor("XYZ");

        return book;
    }
}
