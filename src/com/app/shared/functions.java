package com.app.shared;

import java.util.LinkedList;

public class functions {

	public static String checklogindetails(String username,String password, LinkedList<usersmodel> users){
		  for(int i = 0; i<users.size();i++) {
			  
			  if(users.get(i).getusername().equals(username.toString())){
				  if(users.get(i).getpassword().equals(password.toString())){
					  return("Welcome "+username);
				  }
				  else {
						return("Incorrect Password");
				  }

			  }			  
		  }
			return("Incorrect Username");


	}
}
