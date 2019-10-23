//package YANmakes.complain.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "police")
//public class Police {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private int policeId;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "gender")
//    private String gender;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "contact")
//    private String contactNo;
//
//    @Column(name = "city")
//    private String city;
//
//    @Column(name = "password")
//    private String password;
//
//    @OneToMany
//    @JoinColumn(name = "police_id")
//    private List<Complain> complains;
//
//    public Police() {
//    }
//
//    public Police(String name, String gender, String email, String contactNo, String city, String password) {
//        this.name = name;
//        this.gender = gender;
//        this.email = email;
//        this.contactNo = contactNo;
//        this.city = city;
//        this.password = password;
//    }
//
//    public int getPoliceId() {
//        return policeId;
//    }
//
//    public void setPoliceId(int policeId) {
//        this.policeId = policeId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
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
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
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
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "Police{" +
//                "policeId=" + policeId +
//                ", name='" + name + '\'' +
//                ", gender='" + gender + '\'' +
//                ", email='" + email + '\'' +
//                ", contactNo='" + contactNo + '\'' +
//                ", city='" + city + '\'' +
//                '}';
//    }
//}
