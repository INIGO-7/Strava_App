package googleserver.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GoogleServerFacade extends UnicastRemoteObject implements IGoogleServerFacade{
	
	private static final long serialVersionUID = 1L;

	public GoogleServerFacade() throws RemoteException {
		super();
	}

	@Override
	public boolean login(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
