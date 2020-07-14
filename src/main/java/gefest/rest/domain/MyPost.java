package gefest.rest.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MyPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_gen")
    @SequenceGenerator(name = "post_seq_gen", sequenceName = "post_id_seq", allocationSize=1)

    private Long postId;

    private String postName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public void setPostName(String name) {
        this.postName = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        comment.setPost(null);
        this.comments.remove(comment);
    }


    public Long getId() {
        return postId;
    }

    public void setId(Long postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }
}

