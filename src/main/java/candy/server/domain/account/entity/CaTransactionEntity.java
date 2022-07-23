package candy.server.domain.account.entity;

import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

//거래내역정리 포함되어야할 것들 정리 , Bucket (장바구니,펀딩) , id , from user(Foreign key , userId) , to user (Foreign key, userId  ) , time , CandyCnt
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor()
@Accessors(chain = true)
@AllArgsConstructor
@Builder
public class CaTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName="userId",name="transactionSenderId")
    private CaUserEntity caSenderEntity;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName="userId",name="transactionReceiverId")
    private CaUserEntity caReceiverEntity;
    @Column
    private Long CandyCnt;
    @CreationTimestamp
    private Timestamp transactionTime;

}
