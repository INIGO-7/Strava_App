package client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import client.remote.ServiceLocator;

public class RegisterStravaController {

	private ServiceLocator serviceLocator;
	private long token = -1L;
	
	public RegisterStravaController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public void stravaRegister(String email, String name, Date birthDate, int weight, int height, int maxRate, int restRate, String password) {
		try {
			this.token = this.serviceLocator.getService().stravaRegister(email, name, birthDate, weight, height, maxRate, restRate, password);
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
		}
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
	public long getToken() {
		return this.token;
	}
	
}
