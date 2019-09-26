package com.enRoute.demo.controller;

import com.enRoute.demo.model.User;
import com.enRoute.demo.security.JwtGenerator;
import com.enRoute.demo.service.UserService;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JODY
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class UserController{
    @Autowired
    private UserService userService;
 
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/secured/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();               
    }
    
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @RequestMapping(method=RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPermission("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }
   
    @RequestMapping(method=RequestMethod.PUT,value="/updateUser")
    public void updateUser(@RequestBody User user){
        /*User example = userService.getUser(user.getUser_id());
        user.setPassword(example.getPassword());*/
        userService.updateUser(user);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.DELETE,value="secured/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    private JwtGenerator jwtGenerator;

    public UserController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }
    

   @RequestMapping(method=RequestMethod.POST,value="/login")
    public String login(@RequestBody User user) throws ServletException{
		if (user.getEmail1() == null || user.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                
		String email = user.getEmail1();
		String password = user.getPassword();

		User creden = userService.findByEmail1(email);

		if (creden == null) {
			throw new ServletException("Email name not found.");
		}

		String pwd = creden.getPassword();

		if (!encoder.matches(password,pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}
                 return jwtGenerator.generate(creden);
		
	}

    }
