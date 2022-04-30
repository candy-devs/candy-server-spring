package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_USER_LOGIN", schema = "PUBLIC", catalog = "TEST")
public class CaUserLoginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LOGIN_ID")
    private long loginId;
    @Basic
    @Column(name = "USER_ID")
    private int userId;
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
    @Column(name = "LOGIN_TYPE")
    private int loginType;
    @Basic
    @Column(name = "LOGIN_LOC")
    private int loginLoc;
    @Basic
    @Column(name = "LOGIN_SUCC")
    private int loginSucc;

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getLoginLoc() {
        return loginLoc;
    }

    public void setLoginLoc(int loginLoc) {
        this.loginLoc = loginLoc;
    }

    public int getLoginSucc() {
        return loginSucc;
    }

    public void setLoginSucc(int loginSucc) {
        this.loginSucc = loginSucc;
    }

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
