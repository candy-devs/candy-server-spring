package candy.server.domain.user.entity;

public enum CaUserLoginTypeEnum {
    ID_PW(0), OAUTH(1)
    ;

    private final int value;
    CaUserLoginTypeEnum(int value) { this.value = value; }
    public int getValue() { return value; }
}
