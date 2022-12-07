package client.controller;

import java.rmi.RemoteException;

import client.remote.ServiceLocator;
import server.remote.IRemoteFacade;

public class LoginStravaController {

	private ServiceLocator serviceLocator;
	private long token = -1L;
	
	
	public LoginStravaController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean stravaLogin(String email, String password) {
		try {
			this.token = this.serviceLocator.getService().stravaLogin(email, password);
			if(this.token == -1L) return false;
			else return true;
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
			this.token = -1;
			return false;
		}
	}
	
	public long getToken() {
		return token;
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}

