package com.app.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;


public class loginpages implements EntryPoint {

	private static String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";
	  @SuppressWarnings("unused")
	private final LoginServiceAsync loginService = GWT.create(LoginService.class);

		@Override
		public void onModuleLoad() {
		  TextBox usernameBox = new TextBox();
		  PasswordTextBox passwordBox = new PasswordTextBox();
	    
			// Create the popup dialog box
			final DialogBox dialogBox = new DialogBox();
			dialogBox.setText("Remote Procedure Call");
			dialogBox.setAnimationEnabled(true);
			final Button closeButton = new Button("Close");
			// We can set the id of a widget by accessing its Element
			closeButton.getElement().setId("closeButton");
			final Label textToServerLabel = new Label();
			final HTML serverResponseLabel = new HTML();
			VerticalPanel dialogVPanel = new VerticalPanel();
			dialogVPanel.addStyleName("dialogVPanel");
			dialogVPanel.add(new HTML("<b>Logging in the server:</b>"));
			dialogVPanel.add(textToServerLabel);
			dialogVPanel.add(serverResponseLabel);
			dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
			dialogVPanel.add(closeButton);
			dialogBox.setWidget(dialogVPanel);
	    

			class MyHandler implements ClickHandler{

				public void onClick(ClickEvent event) {
					sendtoserver();
				}
			    private void sendtoserver(){
			    	String username = usernameBox.getValue();
			        String password = passwordBox.getValue();
			        
			        LoginServiceAsync loginService = GWT.create(LoginService.class);
			        loginService.login(username, password, new AsyncCallback<String>() {
			        	  public void onSuccess(String result) {
							dialogBox.setText("Remote Procedure Call");
							serverResponseLabel.removeStyleName("serverResponseLabelError");
							serverResponseLabel.setHTML(result);
							dialogBox.center();
							closeButton.setFocus(true);
			        	    System.out.println(result);
			        	  }

			        	  public void onFailure(Throwable caught) {
				        	    System.out.println(caught);

			        		  dialogBox.setText("Remote Procedure Call - Failure");
								serverResponseLabel.addStyleName("serverResponseLabelError");
								SERVER_ERROR = caught.toString();
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
			        	  }
			        	});		
			    }
			}
			MyHandler handler = new MyHandler();
			

	    Button loginButton = new Button("Login");
	    loginButton.addClickHandler(handler);
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				loginButton.setEnabled(true);
				loginButton.setFocus(true);
			}
		});

		RootPanel.get("nameFieldContainer").add(usernameBox);
		RootPanel.get("passFieldContainer").add(passwordBox);

		RootPanel.get("sendButtonContainer").add(loginButton);
	  }



}
