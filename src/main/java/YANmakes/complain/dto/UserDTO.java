package YANmakes.complain.dto;

import YANmakes.complain.utils.Gender;
import YANmakes.complain.utils.Role;
import org.springframework.stereotype.Component;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class UserDTO {

    private int userId;

    @NotNull
    public String name;

    @NotNull
    private Gender gender;

    @NotNull
    private String email;

    @NotNull
    private String contactNo;

    @NotNull
    private String city;

    @Size(min = 6, max = 15, message = "Give a valid password")
    private String password;


    public UserDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
