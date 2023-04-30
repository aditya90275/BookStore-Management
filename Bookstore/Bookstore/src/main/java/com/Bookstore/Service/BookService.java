package com.Bookstore.Service;

import com.Bookstore.Entity.Book;
import com.Bookstore.Entity.MyBook;
import com.Bookstore.Repository.MyBookRepository;
import com.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public void save(Book b){
        bookRepo.save(b);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).get();
    }

    public void deleteBookById(int id){
        bookRepo.deleteById(id);
    }
}
