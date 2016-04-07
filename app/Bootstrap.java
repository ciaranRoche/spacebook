import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import play.*;
import play.db.jpa.Blob;
import play.jobs.*;
import play.libs.MimeTypes;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job 
{ 
  public void doJob() throws FileNotFoundException
  {
    if (User.count() == 0)
    {
      Fixtures.deleteDatabase();
      Fixtures.loadModels("data.yml");
  
      String photoName = "public/images/homer.gif";
      Blob blob = new Blob();
      blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
      User homer = User.findByEmail("homer@simpson.com");
      homer.profilePicture = blob;
      homer.save();
      
      String photoName1 = "public/images/abe.gif";
      Blob blob1 = new Blob();
      blob1.set(new FileInputStream(photoName1), MimeTypes.getContentType(photoName1));
      User abe = User.findByEmail("abe@simpson.com");
      abe.profilePicture = blob1;
      abe.save();
      
      String photoName2 = "public/images/bart.gif";
      Blob blob2 = new Blob();
      blob2.set(new FileInputStream(photoName2), MimeTypes.getContentType(photoName2));
      User bart = User.findByEmail("bart@simpson.com");
      bart.profilePicture = blob2;
      bart.save();
    
      String photoName3 = "public/images/comic.gif";
      Blob blob3 = new Blob();
      blob3.set(new FileInputStream(photoName3), MimeTypes.getContentType(photoName3));
      User comic = User.findByEmail("worstwebsiteever@simpson.com");
      comic.profilePicture = blob3;
      comic.save(); 
      
      String photoName4 = "public/images/duffman.gif";
      Blob blob4 = new Blob();
      blob4.set(new FileInputStream(photoName4), MimeTypes.getContentType(photoName4));
      User duff = User.findByEmail("duff@simpson.com");
      duff.profilePicture = blob4;
      duff.save();
      
      String photoName5 = "public/images/krusty.gif";
      Blob blob5 = new Blob();
      blob5.set(new FileInputStream(photoName5), MimeTypes.getContentType(photoName5));
      User krusty = User.findByEmail("krusty@simpson.com");
      krusty.profilePicture = blob5;
      krusty.save();
      
      String photoName6 = "public/images/maggie.gif";
      Blob blob6 = new Blob();
      blob6.set(new FileInputStream(photoName6), MimeTypes.getContentType(photoName6));
      User maggie = User.findByEmail("maggie@simpson.com");
      maggie.profilePicture = blob6;
      maggie.save();
      
      String photoName7 = "public/images/marge.gif";
      Blob blob7 = new Blob();
      blob7.set(new FileInputStream(photoName7), MimeTypes.getContentType(photoName7));
      User marge = User.findByEmail("marge@simpson.com");
      marge.profilePicture = blob7;
      marge.save();
      
      String photoName8 = "public/images/moe.gif";
      Blob blob8 = new Blob();
      blob8.set(new FileInputStream(photoName8), MimeTypes.getContentType(photoName8));
      User moe = User.findByEmail("moe@simpson.com");
      moe.profilePicture = blob8;
      moe.save();
      
      String photoName9 = "public/images/ned.gif";
      Blob blob9 = new Blob();
      blob9.set(new FileInputStream(photoName9), MimeTypes.getContentType(photoName9));
      User ned = User.findByEmail("ned@simpson.com");
      ned.profilePicture = blob9;
      ned.save();
      
      String photoName10 = "public/images/peter.gif";
      Blob blob10 = new Blob();
      blob10.set(new FileInputStream(photoName10), MimeTypes.getContentType(photoName10));
      User peter = User.findByEmail("peter@simpson.com");
      peter.profilePicture = blob10;
      peter.save();
      
      String photoName11 = "public/images/lisa.gif";
      Blob blob11 = new Blob();
      blob11.set(new FileInputStream(photoName11), MimeTypes.getContentType(photoName11));
      User lisa = User.findByEmail("lisa@simpson.com");
      lisa.profilePicture = blob11;
      lisa.save();
      
      /*--- Thumbnail preloads ---*/
      
      String thumbnail = "public/images/homer.gif";
      Blob blob12 = new Blob();
      blob12.set(new FileInputStream(thumbnail), MimeTypes.getContentType(thumbnail));
      User homer2 = User.findByEmail("homer@simpson.com");
      homer2.thumbnailPicture = blob12;
      homer2.save();
    }
  }
}