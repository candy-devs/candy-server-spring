package candy.server.domain.auth.entity;

public enum CaOauthTypeEnum {
    NONE(0), GOOGLE(1), NAVER(2), KAKAO(3)
    ;

    private final int value;
    CaOauthTypeEnum(int value) { this.value = value; }
    public int getValue() { return value; }
}
