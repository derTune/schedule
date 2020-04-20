package kg.tune.AppStudent.repository;

import kg.tune.AppStudent.entity.Payment;
import kg.tune.AppStudent.enums.PaymentTypeEnum;
import kg.tune.AppStudent.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    @Query("FROM Payment where status = :status")
    List<Payment> findByStatus(@Param("status") StatusEnum status);
    List<Payment> findByPaymentType(PaymentTypeEnum type);
    @Query("FROM Payment where account_from_id = :accountFromId")
    List<Payment> findByAccountFrom_Student_Id(@Param("accountFromId") Long id);
    @Query("FROM Payment where account_to_id = :accountToId")
    List<Payment> findByAccountTo_Student_Id(@Param("accountToId") Long id);
}
