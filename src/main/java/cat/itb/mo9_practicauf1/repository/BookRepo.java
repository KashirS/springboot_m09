package cat.itb.mo9_practicauf1.repository;

import cat.itb.mo9_practicauf1.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
