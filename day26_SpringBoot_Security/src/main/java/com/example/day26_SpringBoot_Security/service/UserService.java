package com.example.day26_SpringBoot_Security.service;

import com.example.day26_SpringBoot_Security.domain.User;
import com.example.day26_SpringBoot_Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    //for encryption of password
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        //for encryption of password
        this.passwordEncoder = passwordEncoder;
    }

    //make addUser method -> initially for default user account
    public User addUser(User user){
        //set the password to encryption
        //.encode(CharSeq charSeq) -> output : String
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //.isEmpty(Object str) -> output : boolean
        if (StringUtils.isEmpty(user.getAuthorities())){
            //setting authority to user
            //.setAuthority(String authority) -> output : void
            user.setAuthority("USER");
        }
        //saving user to userRepository
        return userRepository.save(user);
    }

    //The PostConstruct annotation is used on a method that needs to be executed after dependency injection is done to perform any initialization.
    //This method MUST be invoked before the class is put into service.
    //This annotation MUST be supported on all classes that support dependency injection
    @PostConstruct //will be executed first -> make a default user account
    public void init(){
        if (userRepository.count()==0){
            addUser(new User(1L,"john doe","username","pwd","ADMIN"));
        }
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //note that the default input parameter is String s
        return userRepository.findByUsername(s);
    }
}
