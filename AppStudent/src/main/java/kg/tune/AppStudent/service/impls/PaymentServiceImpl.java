package kg.tune.AppStudent.service.impls;

import kg.tune.AppStudent.entity.Payment;
import kg.tune.AppStudent.enums.PaymentTypeEnum;
import kg.tune.AppStudent.enums.StatusEnum;
import kg.tune.AppStudent.repository.PaymentRepo;
import kg.tune.AppStudent.service.PaymentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepo.findById(id);
        return payment.get();
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        if(paymentRepo.findById(id).isPresent()) {
            Payment existingPayment = paymentRepo.findById(id).get();
            existingPayment.setPaymentSum(payment.getPaymentSum());
            existingPayment.setPaymentDate(payment.getPaymentDate());
            existingPayment.setPaymentStatus(payment.getPaymentStatus());
            existingPayment.setPaymentType(payment.getPaymentType());
            existingPayment.setFromAccount(payment.getFromAccount());
            existingPayment.setToAccount(payment.getToAccount());
            Payment updatedPayment = paymentRepo.save(existingPayment);
            return updatedPayment;
        }
        else return null;
    }

    @Override
    public String deletePaymentById(Long id) {
        String result = "deleted " + paymentRepo.findById(id);
        paymentRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Payment> getPaymentByStatus(StatusEnum status) {
        return paymentRepo.findByStatus(status);
    }

    @Override
    public List<Payment> getPaymentByType(PaymentTypeEnum type) {
        return paymentRepo.findByPaymentType(type);
    }

    @Override
    public List<Payment> getPaymentByAccountFrom(Long id) {
        return paymentRepo.findByAccountFrom_Student_Id(id);
    }

    @Override
    public List<Payment> getPaymentByAccountTo(Long id) {
        return paymentRepo.findByAccountTo_Student_Id(id);
    }


}
