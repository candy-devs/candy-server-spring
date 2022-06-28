package candy.server.domain.user.dto;

import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListsResponseDto {
    private String id;
    private String nickname;

    public UserListsResponseDto(CaUserEntity entity) {
        this.id = entity.getUserIdid();
        this.nickname = entity.getUserNickname();
    }
}