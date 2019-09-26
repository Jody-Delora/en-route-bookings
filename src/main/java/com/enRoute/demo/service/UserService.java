package com.enRoute.demo.service;

import com.enRoute.demo.model.User;
import com.enRoute.demo.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author JODY
 */
@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    private List<User> users = new ArrayList<>();

	public List<User> getAllUsers() {
            return (List<User>) userRepository.findAll();
	}
 
	public User getUser(Long id) {
               return userRepository.findById(id).orElse(null);
	}
 
	public void addUser(@RequestBody User user) {
                userRepository.save(user);

	}
       
	public void updateUser(@RequestBody User user) {
                userRepository.save(user);
	}
 
	public void deleteUser(Long id) {
                userRepository.deleteById(id);
	}
 
        public User findByEmail1(String email1) {
		return userRepository.findByEmail1(email1);
	}   
}
	

