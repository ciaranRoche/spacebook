package models;
 
import java.util.*;
import javax.persistence.*;

import controllers.Accounts;
import play.db.jpa.*;
 
@Entity
public class Post extends Model {
 
    public String title;
    public Date postedAt;
    
    @Lob
    public String content;
    
    @ManyToOne
    public User author;
    
    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;
    
    public Post(User author, String title, String content) { 
        this.comments = new ArrayList<Comment>();
        this.author = author;
        this.title = title;
        this.content = content;
        
        this.postedAt = new Date();
    }    
   
  public String toString()
  {
    return title;
  }

  public void addComment(Comment comment) {
	comment.post = this;
	comments.add(comment);
}

  

}