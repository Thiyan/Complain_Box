package YANmakes.complain.utils;

public enum Location {

    COLOMBO_1 ("Colombo 1"),
    COLOMBO_2("Colombo 2"),
    COLOMBO_3("Colombo 3"),
    COLOMBO_4("Colombo 4"),
    COLOMBO_5("Colombo 5"),
    COLOMBO_6("Colombo 6"),
    COLOMBO_7("Colombo 7"),
    COLOMBO_8("Colombo 8"),
    COLOMBO_9("Colombo 9"),
    COLOMBO_10("Colombo 10"),
    COLOMBO_11("Colombo 11"),
    COLOMBO_12("Colombo 12"),
    COLOMBO_13("Colombo 13"),
    COLOMBO_14("Colombo 14"),
    COLOMBO_15("Colombo 15");

    private String value;

    Location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
