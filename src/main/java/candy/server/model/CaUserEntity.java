package candy.server.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@Getter
@Setter
@Table(name = "CA_USER", schema = "PUBLIC", catalog = "TEST")
@NoArgsConstructor(access  = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(builderMethodName = "UserBuilder")
public class CaUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    private long userId;
    @Basic
    @Column(name = "USER_IDID", length = 255)
    private String userIdid;
    @Basic
    @Column(name = "USER_PW", length = 512)
    private String userPw;
    @Basic
    @Column(name = "USER_NICKNAME", length = 20)
    private String userNickname;
    @Basic
    @Column(name = "USER_SIGNUP_TIME")
    @CreationTimestamp
    private Timestamp userSignupTime;
    @Basic
    @Column(name = "USER_LAST_LOGIN_TIME")
    @CreationTimestamp
    private Timestamp userLastLoginTime;
    @Basic
    @Column(name = "USER_REST")
    private int userRest;

    @OneToMany(mappedBy = "userId")
    private List<CaUserLoginEntity> caUserLoginEntityList;


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
