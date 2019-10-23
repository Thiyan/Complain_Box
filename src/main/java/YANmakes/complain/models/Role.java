package YANmakes.complain.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_description")
    private String role;

//    @ManyToOne
//    private List<Accounts> accounts;

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<Accounts> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Accounts> accounts) {
//        this.accounts = accounts;
//    }
}
