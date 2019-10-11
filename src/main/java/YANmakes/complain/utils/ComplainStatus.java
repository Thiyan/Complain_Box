package YANmakes.complain.utils;

public enum ComplainStatus {

    NEW("New"),
    PENDING("Pending"),
    REJECTED("Rejected"),
    CLOSED("Closed");

    private String value;

    ComplainStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
