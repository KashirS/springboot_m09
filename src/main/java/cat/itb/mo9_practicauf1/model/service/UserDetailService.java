package cat.itb.mo9_practicauf1.model.service;

import cat.itb.mo9_practicauf1.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService us;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User u = us.searchById(s);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;

        if (u != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }else throw new UsernameNotFoundException("User not Found!");
        return  builder.build();
    }
}
