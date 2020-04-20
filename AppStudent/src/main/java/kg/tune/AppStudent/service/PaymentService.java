package kg.tune.AppStudent.service;

import kg.tune.AppStudent.entity.Payment;
import kg.tune.AppStudent.enums.PaymentTypeEnum;
import kg.tune.AppStudent.enums.StatusEnum;
import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    Payment updatePayment(Long id, Payment payment);
    String deletePaymentById(Long id);
    List<Payment> getPaymentByStatus(StatusEnum status);
    List<Payment> getPaymentByType(PaymentTypeEnum type);
    List<Payment> getPaymentByAccountFrom(Long id);
    List<Payment> getPaymentByAccountTo(Long id);
}
