package candy.server.repository;

import candy.server.model.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<CaUserEntity, UserRepository>, UserRepository {
//    private final EntityManager em;
//
//    @Autowired
//    public JpaUserRepository(EntityManager em) {
//        this.em = em;
//    }


//    @Override
//    public Optional<CaUserEntity> findByUserNickName(String name) {
//        return Optional.empty();
//    }

//    @Override
//    public CaUserEntity save(CaUserEntity caUserEntity) {
//        em.persist(caUserEntity);
//        return caUserEntity;
//    }

//    @Override
//    public List<CaUserEntity> findAll() {
//        return em.createQuery("select u from CaUserEntity u", CaUserEntity.class).getResultList();
//    }
}
