package googleserver.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogleServerFacade extends Remote{

	public boolean login(String email, String password) throws RemoteException;
	
	public boolean register(String email, String password) throws RemoteException;	
	
}
