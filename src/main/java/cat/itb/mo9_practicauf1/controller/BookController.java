package cat.itb.mo9_practicauf1.controller;

import cat.itb.mo9_practicauf1.model.entity.Book;
import cat.itb.mo9_practicauf1.model.entity.User;
import cat.itb.mo9_practicauf1.model.service.BookService;
import cat.itb.mo9_practicauf1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {

    private BookService bookService;

    @GetMapping("/book/list")
    public String list(Model m){
        m.addAttribute("listBooks", bookService.listBook());
        return "booklist";
    }
    @GetMapping("/book/new")
    public String addBook(Model m){
        m.addAttribute("bookForm",new Book());
        return "add";
    }
    @GetMapping("/book/edit")
    public String editBook(@RequestParam(value = "id", required = false) int id, @RequestParam(value = "name", required = false) String name,@RequestParam(value = "description", required = false)String description,@RequestParam(value = "isbn",required = false)String isbn,Model m){
        Book b = new Book();
        b.setIdBook(id);
        b.setName(name);
        b.setDescription(description);
        b.setIsbn(isbn);
        m.addAttribute("bookForm", b);
        m.addAttribute("id", id);
        m.addAttribute("name",name);
        m.addAttribute("description",description);
        m.addAttribute("isbn",isbn);
        return "add";
    }

    @PostMapping("book/new/submit")
    public String addSubmit(@ModelAttribute("bookForm")Book book){
        bookService.addBook(book);
        return "redirect:/book/list";
    }
    @PostMapping("book/new/submit")
    public String editSubmit(@ModelAttribute("bookForm")Book book){
        bookService.update(book);
        return "redirect:/book/list";
    }
    @PostMapping("book/delete")
    public String deleteBook(@RequestParam(value = "id",required = false) int id){
        bookService.deletePerId(id);
        return "redirect:/book/list";
    }
}
