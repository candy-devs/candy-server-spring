package candy.server.model;

public enum CaArticleTypeEnum {
    ANON(0), LOGIN(1), LOGIN_ANON(2)
    ;

    private final int value;
    CaArticleTypeEnum(int value) { this.value = value; }
    public int getValue() { return value; }
}
