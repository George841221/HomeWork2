package application.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Blogs {

    @Id
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

    public Blogs(int blogId, String blogTitle, LocalDateTime wroteOnDate,
                 AllUsers author, List<Comments> blogComments) {
        this();
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.wroteOnDate = wroteOnDate;
        this.author = author;
        this.blogComments = blogComments;
    }
}
