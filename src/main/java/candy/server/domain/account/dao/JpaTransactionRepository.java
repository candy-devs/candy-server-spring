package candy.server.domain.account.dao;

import candy.server.domain.account.entity.CaAccountEntity;
import candy.server.domain.account.entity.CaTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTransactionRepository extends JpaRepository<CaTransactionEntity ,Long> {
}
