package com.SpringAPI.SpringAPI.Service;

import com.SpringAPI.SpringAPI.Entities.Book;
import com.SpringAPI.SpringAPI.dao.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepo bookRepo;
     //private static List<Book> list=new ArrayList<>();
//     static {
//         list.add(new Book(1,"Geeta","xyz"));
//         list.add(new Book(2,"Ramayan","abc"));
//         list.add(new Book(3,"java","lmn"));
//
//     }
     //get all books

    public List<Book> getAllBooks() {
       List<Book> list = (List<Book>)this.bookRepo.findAll();
        return list;
    }
    //get single book by id
                public Book getBookById(int id){
                     Book book = null;
                     book=this.bookRepo.findById(id);
                   // book = list.stream().filter(e->e.getId()==id).findFirst().get();
                    return book;
                }

                //Adding the book
    public Book addBook(Book book){
//         list.add(book);
        Book result = bookRepo.save(book);
         return result;
    }

    //delete the book

    public void deleteBook(int id){
        bookRepo.deleteById((id));

//         list=list.stream().filter(book->book.getId()!=id).
//                 collect(Collectors.toList());
    }


    // update book
               public void updateBook(Book book,int bookid) {
                              book.setId(bookid);
                             bookRepo.save(book);
//                   list = list.stream().map(b -> {
//                       if (b.getId() == bookid) {
//                           b.setName(book.getName());
//                           b.setAuthor((book.getAuthor()));
//                       }
//                       return b;
//                   }).collect(Collectors.toList());
               }
}
