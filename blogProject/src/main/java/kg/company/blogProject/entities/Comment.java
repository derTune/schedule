package kg.company.blogProject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "comment_text")
    String commentText;

    @ManyToOne
    @Column(name = "user_id")
    User user;

    @ManyToOne
    @Column(name = "post_id")
    Post post;
}
