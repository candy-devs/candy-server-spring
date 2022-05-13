package candy.server.user.repository;

import candy.server.model.CaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

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
