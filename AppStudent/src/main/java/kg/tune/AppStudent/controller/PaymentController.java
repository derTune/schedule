package kg.tune.AppStudent.controller;

import kg.tune.AppStudent.entity.Payment;
import kg.tune.AppStudent.enums.PaymentTypeEnum;
import kg.tune.AppStudent.enums.StatusEnum;
import kg.tune.AppStudent.service.PaymentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/add")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }

    @PutMapping("/modify/{id}")
    public Payment update(@PathVariable("id") Long id, @RequestBody Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        paymentService.deletePaymentById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/byStatus/{status}")
    public List<Payment> getByStatus(@PathVariable("status") StatusEnum status) {
        return paymentService.getPaymentByStatus(status);
    }

    @GetMapping("/byType/{type}")
    public List<Payment> getByType(@PathVariable("type") PaymentTypeEnum type) {
        return paymentService.getPaymentByType(type);
    }

    @GetMapping("/byAccountFrom/{accountFrom_id}")
    public List<Payment> getByAccountFrom(@PathVariable("accountFrom_id") Long id) {
        return paymentService.getPaymentByAccountFrom(id);
    }

    @GetMapping("/byAccountTo/{accountTo_id}")
    public List<Payment> getByAccountTo(@PathVariable("accountTo_id") Long id) {
        return paymentService.getPaymentByAccountTo(id);
    }
}
