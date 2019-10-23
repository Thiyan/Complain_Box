package YANmakes.complain.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contactNo;

    @Column(name = "city")
    private String city;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "accounts_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Complain> userComplains;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Complain> policeComplains;



    public Account() {
    }

    public Account(Account account) {

        this.accountId=account.getAccountId();
        this.name=account.getName();
        this.email=account.getEmail();
        this.password=account.getPassword();
        this.roles=account.getRoles();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Complain> getUserComplains() {
        return userComplains;
    }

    public void setUserComplains(List<Complain> userComplains) {
        this.userComplains = userComplains;
    }

    public List<Complain> getPoliceComplains() {
        return policeComplains;
    }

    public void setPoliceComplains(List<Complain> policeComplains) {
        this.policeComplains = policeComplains;
    }
}
