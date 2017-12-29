package sec.project.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sec.project.repository.UserRepository;

public class UserController {
    
    /*@Autowired
    public UserRepository userRepository;
    
    @RequestMapping(value= "/users")
    public String showUsers(Authentication authentication, Model model){
        //ArrayList<User> userList = new ArrayList<User>();
        model.addAttribute("files", userRepository.findByName(authentication.getName()));
        return "users";
    }
*/
}
