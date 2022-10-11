package com.SpringAPI.SpringAPI.Service;

import com.SpringAPI.SpringAPI.Entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
     private static List<Book> list=new ArrayList<>();
     static {
         list.add(new Book(1,"Geeta","xyz"));
         list.add(new Book(2,"Ramayan","abc"));
         list.add(new Book(3,"java","lmn"));

     }
     //get all books

    public static List<Book> getAllBooks() {
        return list;
    }
    //get single book by id
                public Book getBookById(int id){
                     Book book = null;
                    book = list.stream().filter(e->e.getId()==id).findFirst().get();
                    return book;
                }

                //Adding the book
    public Book addBook(Book book){
         list.add(book);
         return book;
    }

    //delete the book

    public void deleteBook(int id){

         list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
    }


    // update book
               public void updateBook(Book book,int bookid) {
                   list = list.stream().map(b -> {
                       if (b.getId() == bookid) {
                           b.setName(book.getName());
                           b.setAuthor((book.getAuthor()));
                       }
                       return b;
                   }).collect(Collectors.toList());
               }
}
