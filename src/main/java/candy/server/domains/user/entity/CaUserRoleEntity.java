package candy.server.domains.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CaUserRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roleId;

    @OneToOne
    @JoinColumn(name = "userId")
    private CaUserEntity userId;

    private String roleName;
}
