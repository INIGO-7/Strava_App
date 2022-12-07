package server.test;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import server.data.dto.ChallengeDTO;
import server.data.dto.TrainingSessionDTO;
import server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		List<ChallengeDTO> challenges = null;
		ChallengeDTO challenge = null;
		List<TrainingSessionDTO> trainingSessions = null;
		TrainingSessionDTO trainingSession = null;
		long token = 0l;
		
		try {
			facade = new RemoteFacade();
			
					
						
			//Get training sessions
			/*sessions = facade.;
			article = articles.get(0);
			
			for (ArticleDTO a : articles) {
				System.out.println("\t- " + a);
			}*/
			
			//set up a challenge
			
			facade.setUpChallenge(token, "buenas", new SimpleDateFormat("dd/MM/yyyy").parse("18/11/2022"), new SimpleDateFormat("dd/MM/yyyy").parse("18/11/2022"), token, token);
			
			//Get Active Challenges
			challenges = facade.getActiveChallenges();
			challenge = challenges.get(0);
			
			for (ChallengeDTO c : challenges) {
				System.out.println("\t- " + c);
			}	
			
			//Make a bid (fails because no login has been done)
			//facade.makeBid(0, article.getNumber(), article.getActualPrice()+1);						
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		
		try {
			//Login
			
			//String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			//token = facade.login("thomas.e2001@gmail.com", sha1);			
			//Make a bid
			//facade.makeBid(token, article.getNumber(), article.getActualPrice()+1);
			//Logout
			//facade.logout(token);
			//Get articles again to check if the bid has been registered
			//articles = facade.getArticles(category.getName());
			//article = articles.get(0); 			
			//System.out.println("\t- " + article);
			} catch (Exception e) {
				System.out.println("\t# Error: " + e.getMessage());	
			}
		
		//Force exit to stop RMI Server
			//System.exit(0);
		
	}
}