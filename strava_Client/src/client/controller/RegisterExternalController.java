package client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import client.remote.ServiceLocator;

public class RegisterExternalController {

	private ServiceLocator serviceLocator;
	
	public RegisterExternalController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public void externalRegister(String email, String name, Date birthDate, int weight, int height, int maxRate, int restRate) {
		try {
			this.serviceLocator.getService().externalRegister(email, name, birthDate, weight, height, maxRate, restRate);
		} catch (RemoteException e) {
			System.out.println("# Error during login: " + e);
		}
	}
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
}
