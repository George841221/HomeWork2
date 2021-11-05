package application.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Blogs {

    @Id
    @GeneratedValue
    private int blogId;
    private String blogTitle;

    @ManyToOne
    private AllUsers author;

    @OneToMany(mappedBy = "commentText")
    private List<Comments> blogComments;

    @CreationTimestamp
    private LocalDateTime wroteOnDate;

    public Blogs() {
        blogComments = new ArrayList<>();
    }

    public Blogs(String blogTitle, AllUsers author) {
        this.blogTitle = blogTitle;
        this.author = author;
    }

    public Blogs(String blogTitle,
                 AllUsers author, List<Comments> blogComments) {
        this( blogTitle, author);
        this.blogComments = blogComments;
    }
}
