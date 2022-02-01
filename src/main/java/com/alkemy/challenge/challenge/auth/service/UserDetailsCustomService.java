package com.alkemy.challenge.challenge.auth.service;

import com.alkemy.challenge.challenge.auth.dto.UserDTO;
import com.alkemy.challenge.challenge.auth.entity.User;
import com.alkemy.challenge.challenge.repository.UserRepository;
import com.alkemy.challenge.challenge.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    public Boolean save(UserDTO userDTO){
        User user=new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user=this.userRepository.save(user);
        if(user!=null){
        emailService.sendWelcomeEmailTo(user.getUsername());
        }
        return user!=null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(user.getUsername(),user.getPassword(), Collection.emptyList());
    }
}
