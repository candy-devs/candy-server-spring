package candy.server.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserProfileAccountResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PaginationItem {
        private long id;
        private String transactionSenderName, transactionReceiverName;
//        private String thumbnail, authorImage;
        private Timestamp writeTime;
        private Long candyCnt;
//        private int up, down, view, comments, bookmark;
//        private String[] tags;
    }

    private List<UserProfileAccountResponseDto.PaginationItem> accounts;
}
