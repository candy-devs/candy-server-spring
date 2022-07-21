package candy.server.domain.account.service;

import candy.server.domain.account.dao.JpaAccountRepository;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.user.dao.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class AccountSendService {
    private final JpaUserRepository userRepository;
    private final JpaAccountRepository accountRepository;

    public AccountSendRequestDto sendCandy(AccountSendRequestDto dto){

        Optional<CaAccountEntity> sender = accountRepository.findByAccountId(dto.getAccountSenderId());
        Optional<CaAccountEntity> receiver = accountRepository.findByAccountId(dto.getAccountReceiverId());
        if(receiver.isEmpty()){
            return AccountSendRequestDto.builder().accountErrorMessage("받는사람의 id가 없습니다.").build();
        }
        if(sender.get().getAccountUserCandyCnt()-dto.getAccountCandyCnt()<0||sender.get().getAccountUserCandyCnt()==0){
            return AccountSendRequestDto.builder().accountErrorMessage("Candy가 부족합니다.").build();
        }
        sender.get().setAccountUserCandyCnt(sender.get().getAccountUserCandyCnt()-dto.getAccountCandyCnt());
        receiver.get().setAccountUserCandyCnt(receiver.get().getAccountUserCandyCnt()+dto.getAccountCandyCnt());
        return AccountSendRequestDto.builder().accountErrorMessage("success").build();

    }
}
