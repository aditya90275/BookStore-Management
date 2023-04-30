package com.Bookstore.Service;

import com.Bookstore.Entity.Book;
import com.Bookstore.Entity.MyBook;
import com.Bookstore.Repository.BookRepository;
import com.Bookstore.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

    @Autowired
    private MyBookRepository myBookRepo;

    public void saveMyBooks(MyBook b) {
        myBookRepo.save(b);
    }

    public void deleteBookById(int id){
        myBookRepo.deleteById(id);
    }

    public List<MyBook> getMyBooks(){
        return myBookRepo.findAll();
    }
}
