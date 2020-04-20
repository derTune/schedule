package kg.tune.AppStudent.repository;

import kg.tune.AppStudent.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findByStudent_Id(Long id);
}
