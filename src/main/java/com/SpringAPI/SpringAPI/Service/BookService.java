package com.SpringAPI.SpringAPI.Service;

import com.SpringAPI.SpringAPI.Entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
     private static List<Book> list=new ArrayList<>();
     static {
         list.add(new Book(1,"Geeta","xyz"));
         list.add(new Book(2,"Ramayan","abc"));
         list.add(new Book(3,"java","lmn"));

     }
     //get all books

    public static List<Book> getAllList() {
        return list;
    }
    //get single book by id
                public Book getBookById(int id){
                     Book book=null;
                     list.stream().filter(e->e.getId()==id).findFirst().get();
                    return book;
                }

}
