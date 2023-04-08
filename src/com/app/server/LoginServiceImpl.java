package com.app.server;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.LinkedList;

import javax.servlet.annotation.WebServlet;
import com.app.client.LoginService;
import com.app.shared.usersmodel;

@WebServlet("/app/login")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

  private static final long serialVersionUID = 1L;
  public String login(String username, String password) throws IllegalArgumentException {
//	  adding dummy data to the list of users
	  LinkedList<usersmodel> users = new LinkedList<usersmodel> ();
	  users.add(new usersmodel("abdullah","12345"));
	  users.add(new usersmodel("noman","12345"));
	  users.add(new usersmodel("admin","admin"));
	  String result = com.app.shared.functions.checklogindetails(username,password,users);
	  return result;
	}

  
}



