package fr.acme.beauregardproject.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Le champ 'Prénom' ne peut être vide.")
    @Column(nullable = false)
    private String firstname;

    @NotEmpty(message = "Le champ 'Nom' ne peut être vide.")
    @Column(nullable = false)
    private String lastname;

    @NotEmpty(message = "Le champ email ne peut être vide.")
    @Column(nullable = false,unique = true)
    @Pattern(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")
    private String email;

    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" , message="Le mot de passe doit comporter au minimum 8 caractères dont une lettre, un chiffre, une majuscule et un caractère spécial.")
    @NotEmpty(message = "Le champ password ne peut être vide")
    @Column(nullable = false)
    private String password;

    private String phoneNumber;
    private Boolean isAdmin;
    private Boolean isLoggedIn;

    @OneToMany(mappedBy = "user")
    private List<Client> clients= new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(String firstname, String lastname, String email, String password, String phoneNumber, Boolean isAdmin, Boolean isLoggedIn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        this.isLoggedIn= isLoggedIn;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isAdmin=" + isAdmin +
                ", isLoggedIn=" + isLoggedIn +
             //   ", clients=" + clients +
                '}';
    }
}