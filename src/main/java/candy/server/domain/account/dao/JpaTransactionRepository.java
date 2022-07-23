package candy.server.domain.account.dao;

import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.account.entity.CaTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTransactionRepository extends JpaRepository<CaTransactionEntity ,Long> {
    Optional<CaTransactionEntity> findCaTransactionEntityByCaReceiverEntity_UserSpecificId(String name);
}
