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
	    User user = User.findById(id);
	    render(user);
	  }

}