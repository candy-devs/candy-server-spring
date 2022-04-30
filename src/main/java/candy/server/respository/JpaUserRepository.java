package candy.server.respository;

import candy.server.model.CaUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {
    private final EntityManager em;

    @Autowired
    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Optional<CaUserEntity> findByUserNickName(String name) {
        return Optional.empty();
    }

    @Override
    public CaUserEntity save(CaUserEntity caUserEntity) {
        em.persist(caUserEntity);
        return caUserEntity;
    }

    @Override
    public List<CaUserEntity> findAll() {
        return em.createQuery("select u from CaUserEntity u", CaUserEntity.class).getResultList();
    }
}
