package kg.tune.StudProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "e_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "fullname")
    String fullname;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @CreatedDate
    @Column(name = "created_date")
    Date registrationDate;

    @Column(name = "tuition_fee")
    BigDecimal tuitionFee;
}
