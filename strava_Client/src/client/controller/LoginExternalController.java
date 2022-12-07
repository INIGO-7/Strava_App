package client.controller;

import java.rmi.RemoteException;
import client.remote.ServiceLocator;

public class LoginExternalController {

	private ServiceLocator serviceLocator;
	private long token = -1;
	
	public LoginExternalController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean externalLogin(String email) {
		try {
			token = this.serviceLocator.getService().externalLogin(email);
			return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			return false;
		}
	}
	
	public long getToken() {
		return this.token;
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}
