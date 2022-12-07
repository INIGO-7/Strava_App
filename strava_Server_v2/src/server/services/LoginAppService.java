package server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import server.data.domain.User;
import server.services.LoginAppService;

public class LoginAppService {

	private static LoginAppService instance;
	
	public LoginAppService() {}
	
	public static synchronized LoginAppService getInstance() {	//synchronized so even if various threads call this function, only one instance will be created.
		if(instance == null) {									//using synchronized may decrease the performance of the program, but if optimal speed is not required this is a good solution.
			instance = new LoginAppService();
			return instance;
		}
		else return instance;
	}
	
	public User stravaLogin(String email, String password) {
		//TODO: Get User using DAO and check 		
		/*User user = new User();		
		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}*/
		System.out.print("soy el user de strava");
		try {
			return new User("RAmon", "pasa", "ramon@hotmail.com", new SimpleDateFormat("dd/MM/yyyy").parse("12/07/1991"), 11, 68, 176, 200, 60);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User externalLogin(String email) {
		//TODO: Get User using DAO and check 		
		/*
		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");	
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}*/
		
		System.out.print("soy el user externo");
		return null;
	}
	
	public User stravaRegister(String email, String name, Date birthDate, int weight, int height, int maxRate, int restRate, String password) {
		//TODO: Get User using DAO and check 	
		/*
		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}*/
		System.out.print("soy el user strava registrándose");
		return null;
	}
	
	public User externalRegister(String email, String name, Date birthDate, int weight, int height, int maxRate, int restRate) {
		//TODO: Get User using DAO and check 	
		/*
		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");		
		//Generate the hash of the password
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}*/
		
		System.out.print("soy el user externo registrándose");
		return null;
	}
	
}
