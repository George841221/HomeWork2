package application.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comments {

    @Id
    @GeneratedValue
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
