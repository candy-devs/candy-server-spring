package candy.server.domains.user.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaUserProfileEntity implements Serializable {
    @Id
    @Column(name = "userId")
    private long profileId;
    @MapsId
    @OneToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;
    @Column(length = 512)
    private String description;
    private Long writeArticleCount;
    private Long writeCommentCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaUserProfileEntity that = (CaUserProfileEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(description, that.description) && Objects.equals(writeArticleCount, that.writeArticleCount) && Objects.equals(writeCommentCount, that.writeCommentCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, description, writeArticleCount, writeCommentCount);
    }
}
