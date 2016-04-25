import java.util.ArrayList;
import java.util.List;

import models.Message;
import models.Post;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class BlogTest extends UnitTest
{
  private User bob;
  private Post post1, post2;

  @BeforeClass
  public static void loadDB()
  {
    Fixtures.deleteAllModels();
  }

  @Before
  public void setup()
  {
    bob   = new User("bob", "jones", "bob@jones.com", "secret", 20, "irish");
    post1 = new Post(bob,"Post Title 1", "This is the first post content");
    post2 = new Post(bob,"Post Title 2", "This is the second post content");
    bob.save();
    post1.save();
    post2.save();
  }

  @After
  public void teardown()
  {
   // bob.delete();
    post1.delete();
    post2.delete();
  }

  @Test
  public void testCreatePost()
  {
	    User bob = new User("bob", "jones", "bob@jones.com", "secret", 20, "irish").save();
	    
	    new Post(bob, "My first post", "Hello world").save();
	    
	    assertEquals(3, Post.count());
	    
	    List<Post> bobPosts = Post.find("byAuthor", bob).fetch();
	 
	    assertEquals(1, bobPosts.size());
	    Post firstPost = bobPosts.get(0);
	    assertNotNull(firstPost);
	    assertEquals(bob, firstPost.author);
	    assertEquals("My first post", firstPost.title);
	    assertEquals("Hello world", firstPost.content);
  }

  @Test
  public void testCreateMultiplePosts()
  {
    bob.posts.add(post1);
    bob.posts.add(post2);
    bob.save();

    User user = User.findByEmail("bob@jones.com");
    List<Post> posts = user.posts;
    assertEquals(2, posts.size());
    Post posta = posts.get(0);
    assertEquals(posta.title, "Post Title 1");
    assertEquals(posta.content, "This is the first post content");

    Post postb = posts.get(1);
    assertEquals(postb.title, "Post Title 2");
    assertEquals(postb.content, "This is the second post content");
  }
  
  @Test
  public void testDeletePost()
  {
    Post post3 = new Post(bob,"Post Title 3", "This is the third post content");
    post3.save();
    bob.posts.add(post3);
    bob.save();
    
    User user = User.findByEmail("bob@jones.com");
    assertEquals(2, user.posts.size());  
    Post post = user.posts.get(0);

    user.posts.remove(0);
    user.save();
    //post.delete();
    
    User anotherUser = User.findByEmail("bob@jones.com");
    assertEquals(1, anotherUser.posts.size());   
   } 
  
}