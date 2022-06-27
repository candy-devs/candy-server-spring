package candy.server.domain.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
public class CaUserLoginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long loginId;
//    @Basic
    @ManyToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;
    private Integer oauthId;
    private Timestamp loginTime;
    private String loginIp;
    @Column(length = 64)
    private CaUserLoginTypeEnum loginType;
    private CaUserLoginLocEnum loginLoc;
    private CaUserLoginSuccEnum loginSucc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaUserLoginEntity that = (CaUserLoginEntity) o;
        return loginId == that.loginId && userId == that.userId && loginType == that.loginType && loginLoc == that.loginLoc && loginSucc == that.loginSucc && Objects.equals(oauthId, that.oauthId) && Objects.equals(loginTime, that.loginTime) && Objects.equals(loginIp, that.loginIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, userId, oauthId, loginTime, loginIp, loginType, loginLoc, loginSucc);
    }
}
