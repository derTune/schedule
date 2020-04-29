package kg.company.blogProject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "text_body")
    String textBody;

    @ManyToOne
    @Column(name = "user_id")
    User user;

    @ManyToMany
    @JoinTable(name = "Post_Tag",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    List<Tag> tags;

    @ManyToOne
    @Column(name = "category_id")
    Category category;

    @DateTimeFormat
    @Column(name = "publication_time")
    Date publicationTime;

    @Column(name = "short_description")
    String shortDescription;
}
