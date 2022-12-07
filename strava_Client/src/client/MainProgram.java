package client;

import java.util.List;


import client.controller.LoginStravaController;
import client.controller.ActiveChallengesController;
import client.controller.LoginExternalController;
import client.controller.RegisterExternalController;
import client.controller.RegisterStravaController;
import client.gui.LoginStrava;
import client.gui.ActiveChallenges;
import client.gui.LoginExternal;
import client.gui.RegisterExternal;
import client.gui.RegisterStrava;
import client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		//// ###################################################
		
		LoginStravaController loginStravaController = new LoginStravaController(serviceLocator);
		LoginStrava loginStrava = new LoginStrava(loginStravaController);
		
		
		//Login
		
		//se inicializan las ventanas y se les mete un controller
		
		//controller initialization:
		/*
		LoginStravaController loginController = new LoginStravaController(serviceLocator);
		LoginExternalController loginGoogleController = new LoginExternalController(serviceLocator);
		RegisterExternalController registerGoogleController = new RegisterExternalController(serviceLocator);
		RegisterStravaController registerStravaController = new RegisterStravaController(serviceLocator);
		*/
		
		
		
		//window initialization:
		/*
		LoginStrava loginDialog = new LoginStrava(loginController);
		LoginExternal loginGoogle = new LoginExternal(loginGoogleController);	
		RegisterExternal registerGoogle = new RegisterExternal(registerGoogleController);	
		RegisterStrava registerStrava = new RegisterStrava(registerStravaController);	
		*/
		
		
		
		//Login
		//loginDialog.login();	
		
		
		/*
		 * 
		//Get Categories
		List<CategoryDTO> categories = bidWindow.getCategories();
		//Get Articles of a category (first category is selected)
		List<ArticleDTO> articles = bidWindow.getArticles(categories.get(0).getName());
		//Convert currency to GBP
		bidWindow.currencyToGBP(articles);
		//Convert currency to USD
		bidWindow.currencyToUSD(articles);
		//Place a bid (first article of the category is selected; the token is stored in the BidController)
		bidWindow.makeBid(loginController.getToken(), articles.get(0));
		//Get Articles to check if the bid has been done
		articles = bidWindow.getArticles(categories.get(0).getName());
		
		*/
		
		//Logout
		//loginDialog.logout();
	}
}