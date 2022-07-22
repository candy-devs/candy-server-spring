package candy.server.domain.account.service;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.dto.AccountResponseDto;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class AccountSendService {
    private final JpaUserRepository userRepository;
    private final JpaAccountRepository accountRepository;

    public AccountResponseDto sendCandy(SessionUser user, AccountSendRequestDto dto){
        Optional<CaAccountEntity> sender = accountRepository.findByAccountId(user.getId());
        Optional<CaAccountEntity> receiver = accountRepository.findByCaUserEntity_UserSpecificId(dto.getReceiver());
        Long receiverAccountCount;
        try {
            receiverAccountCount = receiver.get().getAccountCount();
        }
        catch(Exception e){
            return AccountResponseDto.builder().message("받는 사람이 존재하지 않습니다.").build();
        }
        Long senderAccountCount = sender.get().getAccountCount();

        if(senderAccountCount-dto.getCount()<0||senderAccountCount==0){
            return AccountResponseDto.builder().message("보유하신 캔디보다 많이 보낼 수 없습니다.").build();
        }
        sender.get().setAccountCount(senderAccountCount-dto.getCount());
        receiver.get().setAccountCount(receiverAccountCount+dto.getCount());
        return AccountResponseDto.builder().message("success").build();

    }
}
