package cat.itb.mo9_practicauf1.model.service;

import cat.itb.mo9_practicauf1.model.entity.Book;
import cat.itb.mo9_practicauf1.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public class BookService {

    @Autowired
    private BookRepo repo;

    public void addBook(Book b){
        repo.save(b);
    }
    public Iterable<Book> listBook(){
        return repo.findAll();
    }
    public void deletePerId(int id){
        repo.findById(id);
    }
    public void update(Book b){
        repo.save(b);
    }

    @PostConstruct
    public void init(){
        repo.saveAll(
                Arrays.asList(
                        new Book(1,"first book","Fantastic book","123456789987456321"),
                        new Book(2,"second book","Advanture book","Kashiir987456321"),
                        new Book(1,"first book","Science book","NARUTO6789987456321"),
                        new Book(2,"second book","Fisic book","KJOR987456321")
                )
        );
    }
}
