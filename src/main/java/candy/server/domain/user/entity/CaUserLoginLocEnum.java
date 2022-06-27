package candy.server.domain.user.entity;

public enum CaUserLoginLocEnum {
    WEB(0), APP(1),
    ;

    private final int value;
    CaUserLoginLocEnum(int value) { this.value = value; }
    public int getValue() { return value; }
}
