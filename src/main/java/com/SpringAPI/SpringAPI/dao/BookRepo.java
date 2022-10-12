package com.SpringAPI.SpringAPI.dao;

import com.SpringAPI.SpringAPI.Entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
