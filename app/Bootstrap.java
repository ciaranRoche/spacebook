/*import java.io.FileInputStream;
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
      //Fixtures.deleteDatabase();
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
      /*
      String thumbnail = "public/images/thumbnails/homer.gif";
      Blob blob12 = new Blob();
      blob12.set(new FileInputStream(thumbnail), MimeTypes.getContentType(thumbnail));
      User homer2 = User.findByEmail("homer@simpson.com");
      homer2.thumbnailPicture = blob12;
      homer2.save();
      
      String thumbnail1 = "public/images/thumbnails/abe.gif";
      Blob blob13 = new Blob();
      blob13.set(new FileInputStream(thumbnail1), MimeTypes.getContentType(thumbnail1));
      User abe2 = User.findByEmail("abe@simpson.com");
      abe2.thumbnailPicture = blob13;
      abe2.save();
      
      String thumbnail21 = "public/images/thumbnails/bart.gif";
      Blob blob141 = new Blob();
      blob141.set(new FileInputStream(thumbnail21), MimeTypes.getContentType(thumbnail21));
      User bart2 = User.findByEmail("bart@simpson.com");
      bart2.thumbnailPicture = blob141;
      bart2.save();
      
      String thumbnail3 = "public/images/thumbnails/ComicBookGuy.gif";
      Blob blob15 = new Blob();
      blob15.set(new FileInputStream(thumbnail3), MimeTypes.getContentType(thumbnail3));
      User comic2 = User.findByEmail("worstwebsiteever@simpson.com");
      comic2.thumbnailPicture = blob15;
      comic2.save();
      
      String thumbnail4 = "public/images/thumbnails/duff.gif";
      Blob blob16 = new Blob();
      blob16.set(new FileInputStream(thumbnail4), MimeTypes.getContentType(thumbnail4));
      User duff2 = User.findByEmail("duff@simpson.com");
      duff2.thumbnailPicture = blob16;
      duff2.save();
      
      String thumbnail5 = "public/images/thumbnails/krusty.gif";
      Blob blob17 = new Blob();
      blob17.set(new FileInputStream(thumbnail5), MimeTypes.getContentType(thumbnail5));
      User krusty2 = User.findByEmail("krusty@simpson.com");
      krusty2.thumbnailPicture = blob17;
      krusty2.save();
      
      String thumbnail6 = "public/images/thumbnails/lisa.gif";
      Blob blob18 = new Blob();
      blob18.set(new FileInputStream(thumbnail6), MimeTypes.getContentType(thumbnail6));
      User lisa2 = User.findByEmail("lisa@simpson.com");
      lisa2.thumbnailPicture = blob18;
      lisa2.save();
      
      String thumbnail7 = "public/images/thumbnails/maggie.gif";
      Blob blob19 = new Blob();
      blob19.set(new FileInputStream(thumbnail7), MimeTypes.getContentType(thumbnail7));
      User maggie2 = User.findByEmail("maggie@simpson.com");
      maggie2.thumbnailPicture = blob19;
      maggie2.save();
      
      String thumbnail8 = "public/images/thumbnails/marge.gif";
      Blob blob20 = new Blob();
      blob20.set(new FileInputStream(thumbnail8), MimeTypes.getContentType(thumbnail8));
      User marge2 = User.findByEmail("marge@simpson.com");
      marge2.thumbnailPicture = blob20;
      marge2.save();
      
      String thumbnail9 = "public/images/thumbnails/moe.gif";
      Blob blob21 = new Blob();
      blob21.set(new FileInputStream(thumbnail9), MimeTypes.getContentType(thumbnail9));
      User moe2 = User.findByEmail("moe@simpson.com");
      moe2.thumbnailPicture = blob21;
      moe2.save();
      
      String thumbnail10 = "public/images/thumbnails/ned.gif";
      Blob blob22 = new Blob();
      blob22.set(new FileInputStream(thumbnail10), MimeTypes.getContentType(thumbnail10));
      User ned2 = User.findByEmail("ned@simpson.com");
      ned2.thumbnailPicture = blob22;
      ned2.save();
      
      String thumbnail11 = "public/images/thumbnails/peter.gif";
      Blob blob23 = new Blob();
      blob23.set(new FileInputStream(thumbnail11), MimeTypes.getContentType(thumbnail11));
      User peter2 = User.findByEmail("peter@simpson.com");
      peter2.thumbnailPicture = blob23;
      peter2.save();
    }
  }
}*/