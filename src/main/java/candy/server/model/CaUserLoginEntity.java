package candy.server.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_USER_LOGIN", schema = "PUBLIC", catalog = "TEST")
public class CaUserLoginEntity {
    private int loginId;
    private int userId;
    private Integer oauthId;
    private Timestamp loginTime;
    private Object loginIp;
    private int loginType;
    private int loginLoc;
    private int loginSucc;

    @Basic
    @Column(name = "LOGIN_ID")
    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "OAUTH_ID")
    public Integer getOauthId() {
        return oauthId;
    }

    public void setOauthId(Integer oauthId) {
        this.oauthId = oauthId;
    }

    @Basic
    @Column(name = "LOGIN_TIME")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "LOGIN_IP")
    public Object getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(Object loginIp) {
        this.loginIp = loginIp;
    }

    @Basic
    @Column(name = "LOGIN_TYPE")
    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    @Basic
    @Column(name = "LOGIN_LOC")
    public int getLoginLoc() {
        return loginLoc;
    }

    public void setLoginLoc(int loginLoc) {
        this.loginLoc = loginLoc;
    }

    @Basic
    @Column(name = "LOGIN_SUCC")
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
