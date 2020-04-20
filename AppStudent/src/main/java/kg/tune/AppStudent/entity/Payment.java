package kg.tune.AppStudent.entity;

import kg.tune.AppStudent.enums.PaymentTypeEnum;
import kg.tune.AppStudent.enums.StatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @CreatedDate
    @Column(name = "payment_date")
    Date paymentDate;

    @Column(name = "payment_sum")
    Integer paymentSum;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    PaymentTypeEnum paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id")
    Account fromAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id")
    Account toAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    StatusEnum paymentStatus;
}
