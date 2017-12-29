package sec.project.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class User extends AbstractPersistable<Long> {
    
    @Column(unique = true)
    public String name;
    public String password;
    public String address;
    public String description;
    
    public User(){
        name = "name";
        password = "password";
        address = "Test Street";
        description = "Example";
    }
    public User(String newName, String newPass, String newAdd, String newDesc){
        name = newName;
        password = newPass;
        address = newAdd;
        description = newDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
