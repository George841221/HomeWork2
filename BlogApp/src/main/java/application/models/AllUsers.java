package application.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class AllUsers implements UserDetails {

    @Id
    private String displayName;
    private String firstName;
    private String surName;
    private String password;
    private String eMail;

    private String authority;
    @Transient
    private boolean isLocked;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    private LocalDateTime regTime;

    /*@OneToMany(mappedBy = "author")
    private List<Blogs> title;

    @OneToMany(mappedBy = "commenterName")
    private List<Comments> blogComment;*/

    public AllUsers() {
     //   title = new ArrayList<>();
     //   blogComment = new ArrayList<>();
    }

    public AllUsers(String displayName,String firstName,
                    String surName, String password, String eMail, String authority,
                    Gender gender) {
        this();
        this.displayName = displayName;
        this.firstName = firstName;
        this.surName = surName;
        this.password = password;
        this.eMail = eMail;
        this.authority = authority;
        this.gender = gender;
    }

    public AllUsers(String displayName, String firstName,
                    String surName, String password, String eMail, String authority, boolean isLocked, Gender gender) {
        this(displayName, firstName, surName, password, eMail, authority, gender);
        this.isLocked = isLocked;
        /*this.title = title;
        this.blogComment = blogComment;*/
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(authority));
        return list;
    }

    @Override
    public String getUsername() {
        return displayName;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }


}