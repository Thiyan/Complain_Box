//package YANmakes.complain.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private int userId;
//
//    @Column(name = "gender")
//    private String gender;
//
//    @Column(name = "contact")
//    private String contactNo;
//
//    @Column(name = "city")
//    private String city;
//
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<Complain> complains;
//
//
//    public User() {
//    }
//
//    public User(String name, String gender, String email, String contactNo, String city, String password,
//                List<Complain> complains) {
//        this.gender = gender;
//        this.contactNo = contactNo;
//        this.city = city;
//        this.complains = complains;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getContactNo() {
//        return contactNo;
//    }
//
//    public void setContactNo(String contactNo) {
//        this.contactNo = contactNo;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public List<Complain> getComplains() {
//        return complains;
//    }
//
//    public void setComplains(List<Complain> complains) {
//        this.complains = complains;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", gender='" + gender + '\'' +
//                ", contactNo='" + contactNo + '\'' +
//                ", city='" + city + '\'' +
//                ", complains=" + complains +
//                '}';
//    }
//}
