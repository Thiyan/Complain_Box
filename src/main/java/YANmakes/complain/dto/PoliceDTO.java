package YANmakes.complain.dto;

import YANmakes.complain.utils.Gender;

public class PoliceDTO {

    private int accountId;

    private String name;

    private Gender gender;

    private String email;

    private String contactNo;

    private String city;

    public PoliceDTO() {
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

    @Override
    public String toString() {
        return "PoliceDTO{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
