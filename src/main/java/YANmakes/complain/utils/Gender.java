package YANmakes.complain.utils;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String value;


    Gender(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
