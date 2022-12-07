package server.gateway;

public class GoogleGateway implements ILoginGateway{
	
	private static GoogleGateway googleGateway;
	
	private GoogleGateway() {
		
	}
	
	public static GoogleGateway getInstance() {
		if(googleGateway==null) {
			googleGateway = new GoogleGateway();
		}
		return googleGateway;
	}

	@Override
	public String register(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
