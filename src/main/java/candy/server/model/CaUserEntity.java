package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_USER", schema = "PUBLIC", catalog = "TEST")
public class CaUserEntity {
    private int userId;
    private Object userIdid;
    private Object userPw;
    private Object userNickname;
    private Timestamp userSignupTime;
    private Timestamp userLastLoginTime;
    private int userRest;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_IDID")
    public Object getUserIdid() {
        return userIdid;
    }

    public void setUserIdid(Object userIdid) {
        this.userIdid = userIdid;
    }

    @Basic
    @Column(name = "USER_PW")
    public Object getUserPw() {
        return userPw;
    }

    public void setUserPw(Object userPw) {
        this.userPw = userPw;
    }

    @Basic
    @Column(name = "USER_NICKNAME")
    public Object getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(Object userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "USER_SIGNUP_TIME")
    public Timestamp getUserSignupTime() {
        return userSignupTime;
    }

    public void setUserSignupTime(Timestamp userSignupTime) {
        this.userSignupTime = userSignupTime;
    }

    @Basic
    @Column(name = "USER_LAST_LOGIN_TIME")
    public Timestamp getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Timestamp userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    @Basic
    @Column(name = "USER_REST")
    public int getUserRest() {
        return userRest;
    }

    public void setUserRest(int userRest) {
        this.userRest = userRest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaUserEntity that = (CaUserEntity) o;
        return userId == that.userId && userRest == that.userRest && Objects.equals(userIdid, that.userIdid) && Objects.equals(userPw, that.userPw) && Objects.equals(userNickname, that.userNickname) && Objects.equals(userSignupTime, that.userSignupTime) && Objects.equals(userLastLoginTime, that.userLastLoginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userIdid, userPw, userNickname, userSignupTime, userLastLoginTime, userRest);
    }
}
