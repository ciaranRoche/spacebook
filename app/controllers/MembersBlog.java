package controllers;

import java.util.List;

import models.Message;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

public class MembersBlog  extends Controller
{
	 public static void visit(Long id)
	  {
		 
		User currentUser = Accounts.getLoggedInUser(); 
	    
		User user = User.findById(id);
		Logger.info("Just visiting the blog for " + user.firstName + ' ' + user.lastName);
		render(user);
	  }
	 
}