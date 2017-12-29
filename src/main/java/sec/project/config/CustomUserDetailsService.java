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
        User user = new User("Jack Bauer", "Power", "Baddass St.", "Tought agent");
        userRepository.save(user);
        User user2 = new User("Pornokeisari69", "Milontissit17", "Normikatu", "Kova tyyppi tekee pornoo");
        userRepository.save(user2);
        User user3 = new User("Agentti Appelsiini", "Mehumies", "Mehukatu", "Tekee aina mehuu hommis");
        userRepository.save(user3);
        User user4 = new User("Swedupelle", "OlemmeMulkkuja", "Ruotsitie", "Mielii poikia");
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
