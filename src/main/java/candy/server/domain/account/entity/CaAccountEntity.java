package candy.server.domain.account.entity;


import candy.server.domain.user.entity.CaUserEntity;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor()
@Accessors(chain = true)
@AllArgsConstructor
@Builder
public class CaAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column
    private Long accountUserCandyCnt;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="userSpecificId")
    private CaUserEntity caUserEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaAccountEntity that = (CaAccountEntity) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(accountUserCandyCnt, that.accountUserCandyCnt) && Objects.equals(caUserEntity, that.caUserEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountUserCandyCnt, caUserEntity);
    }
}
