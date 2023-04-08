package com.app.client;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	  void login(String username, String password, AsyncCallback<String> callback) throws IllegalArgumentException;
	}


