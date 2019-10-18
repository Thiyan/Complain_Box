package YANmakes.complain.utils;

public enum Role {

    ADMIN("Admin"),
    POLICE("Police"),
    UER("User");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
