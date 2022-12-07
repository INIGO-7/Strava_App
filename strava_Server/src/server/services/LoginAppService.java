package server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import server.data.domain.Challenge;
import server.data.domain.TrainingSession;
import server.data.domain.User;
import server.gateway.ILoginGateway;
import server.gateway.LoginGatewayFactory;
import server.services.LoginAppService;

public class LoginAppService {

	private static LoginAppService instance;
	
	private List<User> users = new ArrayList<User>();
	
	private LoginAppService() {
		this.initializeData();
	}
	
	public static synchronized LoginAppService getInstance() {	//synchronized so even if various threads call this function, only one instance will be created.
		if(instance == null) {									//using synchronized may decrease the performance of the program, but if optimal speed is not required this is a good solution.
			instance = new LoginAppService();
			return instance;
		}
		else return instance;
	}
	
	private void initializeData() {
		
		//temporal hasta que haya un repositorio en el que se guarden todos los usuarios
		
		User user1 = new User();
		user1.setName("Inigo");
		user1.setEmail("inigo@gmail.com");
		user1.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("pwd1"));
		
		User user2 = new User();
		user2.setName("Jorge");
		user2.setEmail("jorge@gmail.com");
		user2.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("pwd2"));
		
		User user3 = new User();
		user3.setName("Unai");
		user3.setEmail("unai@gmail.com");
		user3.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("pwd3"));
		
		User user4 = new User();
		user4.setName("Nico");
		user4.setEmail("nico@gmail.com");
		user4.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("pwd4"));
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}
	
	public User stravaLogin(String email, String password) {
		//TODO: Get User using DAO and check 		
		
		for(User u : users) {
			
			if( u.getEmail().equals(email) ) {
				
				if( u.checkPassword(password) ) {
					return u;
				}
				else {
					JOptionPane.showMessageDialog(null, "The given password is incorrect for that account.");
					return null;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "There isn't any account registered with that email.");
		return null;
	}
	
	public User externalLogin(String email, String password) {
		//TODO: Get User using DAO and check 		


		
		//LoginGatewayFactory.getInstance().createFactory( true ).login(email, password);
		return null;
		
	}
	
	public User stravaRegister(String email, String name, Date birthDate, int weight, int height, int maxRate, int restRate, String password) {
		//TODO: Get User using DAO and check 	
		
		User user = new User();
		
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setBirthDate(birthDate);
		user.setWeight(weight);
		user.setHeight(height);
		user.setMaxRate(maxRate);
		user.setRestRate(restRate);
		
		users.add(user);
		
		return user;
	}
	
	public User externalRegister(String email, String name, Date birthDate, int weight, int height, int maxRate, int restRate) {
		//TODO: Get User using DAO and check 	
		
		//do with facebook or google.
		
		System.out.print("soy el user externo registrándose");
		return null;
	}
	
}
