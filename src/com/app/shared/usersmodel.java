package com.app.shared;

public class usersmodel {

	private String Username;
	private String Password;	
	
    public usersmodel(String Username, String Password) {
    	this.Username = Username;
    	this.Password = Password;
    }
    public String getpassword() {
    	return this.Password;    	
    }
    public String getusername() {
    	return this.Username;    	
    }
    public void setpassword(String Password) {
    	this.Password = Password;    	
    }
    public String setusername(String Username) {
    	return this.Username = Username;    	
    }

}
