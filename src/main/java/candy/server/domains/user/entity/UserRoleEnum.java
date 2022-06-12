package candy.server.domains.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRoleEnum {
    ADMIN("ROLE_ADMIN", "ADMIN"),
    USER("ROLE_USER", "USER"),
    GUEST("ROLE_GUEST", "GUEST");

    private final String key;
    private final String title;
}
