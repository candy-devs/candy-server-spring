package candy.server.domain.auth.dto;

public enum AuthSignupResponseDtoCode {
    SUCCESS(0), NICKNAME_ALREADY_EXISTS(1), USERID_ALREADY_EXISTS(2),
    INVALID_ID_FORMAT(3), INVALID_PW_FORMAT(4),
    ;

    private final int value;
    AuthSignupResponseDtoCode(int value) { this.value = value; }
    public int getValue() { return value; }
}
