package candy.server.domains.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "CA_USER_ROLE", schema = "PUBLIC")
public class CaUserRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name ="ROLE_ID")
    private Long roleId;

    @Column(name ="USER_ID")
    private Long userId;

    @Column(name = "ROLE_NAME")
    private String roleName;
}
