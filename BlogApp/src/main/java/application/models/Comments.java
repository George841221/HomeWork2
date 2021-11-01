package application.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Comments {

    @Id
    private int commentId;

    @ManyToOne
    private AllUsers commenterName;

    @ManyToOne
    private Blogs commentText;

    @CreationTimestamp
    private LocalDateTime wroteOnDate;

    public Comments(){}

    public Comments(int commentId, AllUsers commenterName, Blogs commentText, LocalDateTime wroteOnDate) {
        this.commentId = commentId;
        this.commenterName = commenterName;
        this.commentText = commentText;
        this.wroteOnDate = wroteOnDate;
    }
}
