package kg.tune.AppStudent.entity;


import kg.tune.AppStudent.enums.CurrencyEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "bank_details")
    String bankDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    Student student;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    CurrencyEnum currency;
}

