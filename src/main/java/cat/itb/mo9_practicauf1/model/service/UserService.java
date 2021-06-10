package cat.itb.mo9_practicauf1.model.service;

import cat.itb.mo9_practicauf1.model.entity.User;
import cat.itb.mo9_practicauf1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public class UserService {

    @Autowired
    private UserRepo repo;

    @PostConstruct
    public void init(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        repo.saveAll(
                Arrays.asList(
                        new User("Kashir", passwordEncoder.encode("kashir123"), "ADMIN"),
                        new User("Jorge", passwordEncoder.encode("jorge123"),"USER"),
                        new User("Paco", passwordEncoder.encode("paco123"),"USER")
                )
        );
    }

    public User searchById(String id){
        return repo.findById(Long.valueOf(id)).orElse(null);
    }
    public void addUser(User user){
        repo.save(user);
    }
}
