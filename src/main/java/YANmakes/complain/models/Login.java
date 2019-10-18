package YANmakes.complain.models;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int loginId;

    private String email;

    private String password;

    @ManyToOne
    private Role role;

    @OneToOne(mappedBy = "login")
    private User user;

    public Login() {
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
