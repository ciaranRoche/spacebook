package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Comment extends Model {
	
	@ManyToOne
    public User author;
     
    @Lob
    public String content;
    
    @ManyToOne
    public Post post;
    
    public Comment(Post post, User author, String comment) {
        this.post = post;
        this.author = author;
        this.content = comment;
    }
 
}