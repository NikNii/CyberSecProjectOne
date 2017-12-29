package sec.project.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;
import sec.project.repository.UserRepository;

@Controller
public class SignupController {

    @Autowired
    public UserRepository userRepository;
    
    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String password, @RequestParam String address, @RequestParam String description) {
        //signupRepository.save(new Signup(name, address));
        User newUser = new User(name, password, address, description);
        userRepository.save(newUser);
        /*User newUser2 = userRepository.findByName(newUser.getName());
        System.out.println("name: " + newUser2.getName() + ", password: " + newUser2.getPassword() + ", address: " + newUser2.getAddress() + ", and desc: " + newUser2.getDescription());
*/
        return "home";
    }
    
    @RequestMapping(value= "/home")
    public String home(){
        return "home";
    }
    
    @RequestMapping(value= "/users")
    public String showUsers(Authentication authentication, Model model){
        //ArrayList<User> userList = new ArrayList<User>();
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
    @RequestMapping(value= "/userdata")
    public String showUserdata(Authentication authentication, Model model){
        //ArrayList<User> userList = new ArrayList<User>();
        model.addAttribute("userdata", userRepository.findAll());
        return "userdata";
    }
    
    @RequestMapping(value= "/search")
    public String showUser(@RequestParam String name, Authentication authentication, Model model){
        //ArrayList<User> userList = new ArrayList<User>();
        model.addAttribute("userdata", userRepository.findByName(name));
        return "userdata";
    }
    

}
