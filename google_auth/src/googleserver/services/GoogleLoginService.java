package googleserver.services;

import java.rmi.RemoteException;

public class GoogleLoginService {

	//as we cannot implement a real google login yet, just return true.
	
	private GoogleLoginService instance;
	
	private GoogleLoginService() {
		
	}
	
	public GoogleLoginService getInstance() {
		if(instance == null) {
			instance = new GoogleLoginService();
		}
		return instance;
	}
	
	public boolean login(String email, String password) throws RemoteException {
		return true;
	}

	public boolean register(String email, String password) throws RemoteException {
		return true;
	}
	
}
