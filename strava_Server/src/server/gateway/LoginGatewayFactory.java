package server.gateway;

public class LoginGatewayFactory {
	private static LoginGatewayFactory loginGatewayFactory;
	
	private LoginGatewayFactory() {
		
	}
	
	public static LoginGatewayFactory getInstance() {
		if(loginGatewayFactory==null) {
			loginGatewayFactory = new LoginGatewayFactory();
		}
		return loginGatewayFactory;
	}
	
	public ILoginGateway createFactory(boolean which) {
		if(which) {
			return FacebookGateway.getInstance();
		}else{
			return GoogleGateway.getInstance();
		}
	}
}
