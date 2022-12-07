package client.controller;

import java.rmi.RemoteException;

import client.remote.ServiceLocator;

import java.util.Date;

public class SetUpChallengeController {

	private ServiceLocator serviceLocator;
	private long token = -1;
	
	public SetUpChallengeController(ServiceLocator serviceLocator, long token) {
		this.serviceLocator = serviceLocator;
		this.token = token;
	}
	
	public boolean setUpChallenge(long token, String name, Date startDate, Date endDate, long startTime, long duration) {
    	try {
			return this.serviceLocator.getService().setUpChallenge(token, name, startDate, endDate, startTime, duration);
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
