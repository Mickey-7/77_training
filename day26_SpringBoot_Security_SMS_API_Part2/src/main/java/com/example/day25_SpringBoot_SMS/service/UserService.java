package com.example.day25_SpringBoot_SMS.service;

import com.example.day25_SpringBoot_SMS.domain.User;
import com.example.day25_SpringBoot_SMS.repository.UserRepository;
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
    //for fucking encryption!!!!!!!!
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //addUser
    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(StringUtils.isEmpty(user.getAuthority())){
            user.setAuthority("USER");
        }
        return userRepository.save(user);
    }

    @PostConstruct
    public void init(){
        if (userRepository.count()==0){
            addUser(new User(1L,"name","username","pwd","ADMIN"));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
