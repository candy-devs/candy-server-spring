package candy.server.domain.user.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor(access  = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(builderMethodName = "UserBuilder")
public class CaUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long userId;
    @Column(length = 255, unique = true)
    private String userSpecificId;
    @Column(length = 255, unique = true)
    private String userIdid;
    @Column( length = 512)
    private String userPw;
    @Column(length = 255)
    private String userEmail;
    @Column(length = 20, unique = true)
    private String userNickname;
    @CreationTimestamp
    private Timestamp userSignupTime;
    @CreationTimestamp
    private Timestamp userLastLoginTime;
    private int userRest;
    private String userImage;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum userRole;

    @OneToMany(mappedBy = "userId")
    private List<CaUserLoginEntity> caUserLoginEntityList;

    public CaUserEntity update(String name, String picture) {
        this.userNickname = name;
        this.userImage = picture;

        return this;
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

    public void createAndSetUserSpecificIfNotExists() {
        if (userSpecificId != null) return;
        
        String uuid = UUID.randomUUID().toString();
        userSpecificId = uuid.replaceAll("-", "");
    }
}
