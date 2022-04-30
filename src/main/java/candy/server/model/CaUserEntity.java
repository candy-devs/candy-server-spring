package candy.server.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CA_USER", schema = "PUBLIC", catalog = "TEST")
public class CaUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "USER_IDID")
    private String userIdid;
    @Basic
    @Column(name = "USER_PW")
    private String userPw;
    @Basic
    @Column(name = "USER_NICKNAME")
    private String userNickname;
    @Basic
    @Column(name = "USER_SIGNUP_TIME")
    private Timestamp userSignupTime;
    @Basic
    @Column(name = "USER_LAST_LOGIN_TIME")
    private Timestamp userLastLoginTime;
    @Basic
    @Column(name = "USER_REST")
    private int userRest;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIdid() {
        return userIdid;
    }

    public void setUserIdid(String userIdid) {
        this.userIdid = userIdid;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Timestamp getUserSignupTime() {
        return userSignupTime;
    }

    public void setUserSignupTime(Timestamp userSignupTime) {
        this.userSignupTime = userSignupTime;
    }

    public Timestamp getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Timestamp userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

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
