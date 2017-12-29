package sec.project.config;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sec.project.controller.User;
import sec.project.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    public UserRepository userRepository;

    private Map<String, String> accountDetails;

    @PostConstruct
    public void init() {
        // this data would typically be retrieved from a database
        this.accountDetails = new TreeMap<>();
        this.accountDetails.put("ted", "$2a$06$rtacOjuBuSlhnqMO2GKxW.Bs8J6KI0kYjw/gtF0bfErYgFyNTZRDm");
        User user = new User("Jack Bauer", "Power", "Baddass St.", "Tough guy");
        userRepository.save(user);
        User user2 = new User("SuperCaesar", "BuiltRomeInADay", "Rome", "Rules with an iron first");
        userRepository.save(user2);
        User user3 = new User("Agent Mandarin", "Juiceman", "Juice Street", "Makes punch in every mission");
        userRepository.save(user3);
        User user4 = new User("Dupelle", "FunnyJoke", "Circus Road", "Funny person");
        userRepository.save(user4);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!this.accountDetails.containsKey(username)) {
            throw new UsernameNotFoundException("No such user: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                username,
                this.accountDetails.get(username),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
