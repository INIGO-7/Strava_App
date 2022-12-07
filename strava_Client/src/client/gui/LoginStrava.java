package client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import client.controller.ActiveChallengesController;
import client.controller.LoginExternalController;
import client.controller.LoginStravaController;
import client.controller.RegisterExternalController;
import client.controller.RegisterStravaController;
import client.remote.ServiceLocator;

public class LoginStrava {

	private JFrame frame;
	private JTextField textEmail;
	private JTextField textFieldPassword;
	private LoginStravaController controller;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceLocator serviceLocator = new ServiceLocator();
					LoginStravaController loginStravaController = new LoginStravaController(serviceLocator); 
					LoginStrava window = new LoginStrava(loginStravaController);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LoginStrava(LoginStravaController loginController) {
		this.controller = loginController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(333, 333, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Login with Strava");
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogIn.setBounds(88, 26, 300, 30);
		frame.getContentPane().add(lblLogIn);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(89, 100, 45, 13);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(89, 140, 80, 13);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRegister = new JLabel("Dont have an account?");
		lblRegister.setBounds(88, 240, 200, 23);
		frame.getContentPane().add(lblRegister);
		
		
		
		textEmail = new JTextField();
		textEmail.setBounds(211, 97, 96, 19);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(211, 137, 96, 19);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(88, 190, 85, 21);
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//if this is selected, we are in the correct screen and want to log in normally.
				
				if(stravaLogin()) {
					//if we manage to log in, the token will be stored in the controller.
					//we initialize the main activeChallenges window, and exit the current one:
					ActiveChallengesController acc = new ActiveChallengesController(controller.getServiceLocator(), controller.getToken());
					new ActiveChallenges(acc);
					frame.dispose();
				}else {
					//if the login has failed the data fields may be wrong, then try again.
					JOptionPane.showMessageDialog(null, "There has been an error logging in. TRY AGAIN");
				}
			}
			
		});
		
		frame.getContentPane().add(btnLogIn);
		
		JButton btnLogGoogle = new JButton("Log In with Google");
		btnLogGoogle.setBounds(188, 190, 150, 21);
		frame.getContentPane().add(btnLogGoogle);
		btnLogGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If we would like to login with facebook or google, then switch to the appropiate window:
				
				LoginExternalController lec = new LoginExternalController(controller.getServiceLocator());
				new LoginExternal(lec);
				frame.dispose();
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(248, 240, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//if we don't have an account, then we will need to register in the system by creating one with facebook, google or gmail.
				
				String[] registrationWay = {
						"Register with gmail",
						"Register with google/fecebook account"
					};
				
				String resp = (String) JOptionPane.showInputDialog( null, "How do you want to register?", "Registration", 
						JOptionPane.QUESTION_MESSAGE, null, registrationWay, "" );
				
				if (resp != null) {
					if (resp.equals(registrationWay[0])) {
						
						//if we have selected to register with gmail (with strava), then we go to the register with strava screen and exit the current window.
						RegisterStravaController rsc = new RegisterStravaController(controller.getServiceLocator());
						new RegisterStrava(rsc);
						frame.dispose();
						
					} else if (resp.equals(registrationWay[1])) {
						
						//else we have selected to register with google or facebook (external), then we go to the external register screen and exit the current window.
						RegisterExternalController rec = new RegisterExternalController(controller.getServiceLocator());
						new RegisterExternal(rec);
						frame.dispose();
						
					}
				}
			}
		});	
		frame.setVisible(true);
	}
	
	public boolean stravaLogin() {
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(textFieldPassword.getText());
		return this.controller.stravaLogin(textEmail.getText(), sha1);
	}
	
}
