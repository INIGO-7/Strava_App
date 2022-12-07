package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import server.data.domain.*;
import server.data.dto.*;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long stravaLogin(String email, String password) throws RemoteException;
	
	public long externalLogin(String email) throws RemoteException; 
	
	public void logout(long token) throws RemoteException;
	
	public long stravaRegister(String email, String name, Date birthDate, int weight, int heigth, int maxRate, int restRate, String password ) throws RemoteException;
	
	public long externalRegister (String email, String name, Date birthDate, int weight, int heigth, int maxRate, int restRate ) throws RemoteException;
	
	public List<ChallengeDTO> getActiveChallenges() throws RemoteException;
	
	//public boolean acceptChallenge(long token, Challenge challenge) throws RemoteException;
	
	public boolean setUpChallenge ( long token, String name, Date startDate, Date endDate, long startTime, long duration) throws RemoteException;
	
	public boolean createTrainingSession (long token, String title, float distance, long duration) throws RemoteException; 

}