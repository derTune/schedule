package kg.company.blogProject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "value")
    Integer value;

    @ManyToOne
    @Column(name = "post_id")
    Post post;

    @ManyToOne
    @Column(name = "user_id")
    User user;
}
