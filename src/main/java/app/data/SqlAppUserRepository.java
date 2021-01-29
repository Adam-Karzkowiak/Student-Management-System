package app.data;


import app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlAppUserRepository extends JpaRepository<AppUser, Integer>, AppUserRepository {
    @Override
    AppUser findByUsername(String username);
}
