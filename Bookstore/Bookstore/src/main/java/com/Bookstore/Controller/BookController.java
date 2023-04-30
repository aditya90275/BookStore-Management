package com.Bookstore.Controller;

import com.Bookstore.Entity.Book;
import com.Bookstore.Entity.MyBook;
import com.Bookstore.Service.BookService;
import com.Bookstore.Service.MyBookService;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @Autowired
    private MyBookService myservice;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/bookRegister")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/availableBooks")
    public ModelAndView availableBooks(){
        List<Book> list=service.getAllBooks();
        return new ModelAndView("bookList","book",list);
    }

    @GetMapping("/myBooks")
    public ModelAndView getMyBooks(){
        List<MyBook> list=myservice.getMyBooks();
        return new ModelAndView("myBookList","myBook",list);
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/availableBooks";
    }

    @RequestMapping("/addMyList/{id}")
    public String addMyBook(@PathVariable("id") int id){
        Book b=service.getBookById(id);
        MyBook b1=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myservice.saveMyBooks(b1);
        return "redirect:/myBooks";
    }

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        myservice.deleteBookById(id);
        return "redirect:/myBooks";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteBookById(id);
        return "redirect:/availableBooks";
    }

    @RequestMapping("editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "editBook";
    }
}
