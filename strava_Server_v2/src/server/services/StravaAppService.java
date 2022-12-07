package server.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.data.domain.*;

public class StravaAppService {

	private static StravaAppService instance;
	private List<Challenge> challenges = new ArrayList<Challenge>();
	private List<TrainingSession> trainingSessions = new ArrayList<TrainingSession>();
	
	private StravaAppService() {
		this.initializeData();
	}
	
	public static synchronized StravaAppService getInstance() {	//synchronized so even if various threads call this function, only one instance will be created.
		if(instance == null) {									//using synchronized may decrease the performance of the program, but if optimal speed is not required this is a good solution.
			instance = new StravaAppService();
			return instance;
		}
		else return instance;
	}
	
	private void initializeData() {
		try {
			Challenge challenge1 = new Challenge("testChallenge1", new SimpleDateFormat("dd/MM/yyyy").parse("11/12/1992"), 
					new SimpleDateFormat("dd/MM/yyyy").parse("11/12/2022"), false, 75);
			
			Challenge challenge2 = new Challenge("testChallenge1", new SimpleDateFormat("dd/MM/yyyy").parse("07/02/1992"), 
					new SimpleDateFormat("dd/MM/yyyy").parse("07/02/2022"), true, 27);
			
			Challenge challenge3 = new Challenge("testChallenge1", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1992"), 
					new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2022"), false, 200);
			
			this.challenges.add(challenge1);
			this.challenges.add(challenge2);
			this.challenges.add(challenge3);
			
			TrainingSession trainingSession1 = new TrainingSession("training 1", 4.5F, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1992"), 500, 120);
			TrainingSession trainingSession2 = new TrainingSession("training 1", 4.5F, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1992"), 500, 120);
			TrainingSession trainingSession3 = new TrainingSession("training 1", 4.5F, new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1992"), 500, 120);
			
			this.trainingSessions.add(trainingSession1);
			this.trainingSessions.add(trainingSession2);
			this.trainingSessions.add(trainingSession3);
			
		} catch (ParseException e) {
			
			System.out.print("Error initializing application data. Error: " + e);
		}
	}
	
	public boolean setUpChallenge(User user, String name, Date startDate, Date endDate, long startTime, long duration) {
		
	try {
			
			challenges.add(new Challenge(name, startDate, endDate, false, 1));
			
			return true;
			
		} catch (NumberFormatException e) {
			
			System.out.print("An error parsing training session data has ocurred. Error: " + e);
			return false;
		}
	}
	
	public boolean createTrainingSession(User user, String title, float distance, long duration) {
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String[] dateAndTime = formatter.format(date).split(" ");
			trainingSessions.add(new TrainingSession(title, distance, new SimpleDateFormat("dd/MM/yyyy").parse(dateAndTime[0]), Integer.parseInt(dateAndTime[1]), duration));
			
			return true;
			
		} catch (NumberFormatException | ParseException e) {
			
			System.out.print("An error parsing training session data has ocurred. Error: " + e);
			return false;
		}
	}
	
	public List<Challenge> getActiveChallenges(){
		return this.challenges;
	}
	
	public boolean acceptChallenge(User user, Challenge challenge) {
		System.out.print("you have accepted a challenge");
		//user.addActiveChallenge(challenge);
		return true;
	}
	
}
