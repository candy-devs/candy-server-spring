package candy.server.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountSendRequestDto {
    private Long accountCandyCnt;
    private Long accountSenderId;
    private Long accountReceiverId;
    private String accountErrorMessage;

}
