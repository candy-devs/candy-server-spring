package candy.server.domain.account.controller;

import candy.server.domain.account.dao.JpaTransactionRepository;
import candy.server.domain.account.dto.AccountSendRequestDto;
import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.account.entity.CaTransactionEntity;
import candy.server.domain.account.service.AccountSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<AccountSendRequestDto> send(@RequestBody AccountSendRequestDto dto){
        AccountSendRequestDto response = accountService.sendCandy(dto);
        //return 값을 dto , input output , get은 paratmeter , userSpecificId ,
        return ResponseEntity.ok()
                .body(response);
    }
}
