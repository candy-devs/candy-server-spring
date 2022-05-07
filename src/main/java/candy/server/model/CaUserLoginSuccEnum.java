package candy.server.model;

public enum CaUserLoginSuccEnum {
    FAIL(0), SUCCESS(1)
    ;

    private final int value;
    CaUserLoginSuccEnum(int value) { this.value = value; }
    public int getValue() { return value; }
}
