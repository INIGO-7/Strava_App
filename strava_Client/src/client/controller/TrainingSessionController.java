package client.controller;

import java.rmi.RemoteException;
import java.util.Date;

import client.remote.ServiceLocator;

public class TrainingSessionController {

	private ServiceLocator serviceLocator;
	private long token = -1;
	
	public TrainingSessionController(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public boolean createTrainingSession(long token, String title, float distance, long duration) {
    	try {
			return this.serviceLocator.getService().createTrainingSession(token, title, distance, duration);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
	
	public ServiceLocator getServiceLocator() {
		return this.serviceLocator;
	}
	
	public long getToken() {
		return this.token;
	}
	
}
