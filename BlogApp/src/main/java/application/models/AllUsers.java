package application.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class AllUsers {

    @Id
    private String displayName;
    private String firstName;
    private String surName;
    private String password;
    private String eMail;
    private Gender gender;
    private Status status;

    @CreationTimestamp
    private LocalDateTime regTime;

    @OneToMany(mappedBy = "author")
    private List<Blogs> title;

    @OneToMany(mappedBy = "commenterName")
    private List<Comments> blogComment;

    public AllUsers() {
        title = new ArrayList<>();
        blogComment = new ArrayList<>();
    }

    public AllUsers(String displayName, String firstName,
                    String surName, String password, String eMail, Gender gender,
                    Status status, LocalDateTime regTime, List<Blogs> title, List<Comments> blogComment) {
        this();
        this.displayName = displayName;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
        this.eMail = eMail;
        this.gender = gender;
        this.status = status;
        this.regTime = regTime;
        this.title = title;
        this.blogComment = blogComment;
    }
}
