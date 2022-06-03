package candy.server.domains.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter @Setter
@Table(name = "CA_USER_LOGIN", schema = "PUBLIC", catalog = "TEST")
public class CaUserLoginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LOGIN_ID")
    private long loginId;
//    @Basic
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private CaUserEntity userId;
    @Basic
    @Column(name = "OAUTH_ID")
    private Integer oauthId;
    @Basic
    @Column(name = "LOGIN_TIME")
    private Timestamp loginTime;
    @Basic
    @Column(name = "LOGIN_IP")
    private String loginIp;
    @Basic
    @Column(name = "LOGIN_TYPE", length = 64)
    private CaUserLoginTypeEnum loginType;
    @Basic
    @Column(name = "LOGIN_LOC")
    private CaUserLoginLocEnum loginLoc;
    @Basic
    @Column(name = "LOGIN_SUCC")
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
