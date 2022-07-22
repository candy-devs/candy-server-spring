package candy.server.domain.account.controller;

import candy.server.domain.account.dao.JpaTransactionRepository;
import candy.server.domain.account.dto.AccountResponseDto;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.account.entity.CaTransactionEntity;
import candy.server.domain.account.service.AccountSendService;
import candy.server.security.model.LoginUser;
import candy.server.security.model.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccountController {
    private final AccountSendService accountService;

    @PostMapping("/send")
    public ResponseEntity<AccountResponseDto> send(@LoginUser SessionUser user, @RequestBody AccountSendRequestDto dto){
        AccountResponseDto response = accountService.sendCandy(user,dto);
        //return 값을 dto , input output , get은 paratmeter , userSpecificId ,
        return ResponseEntity.ok().body(response);
    }
}
