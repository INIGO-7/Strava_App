package client.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.controller.LoginExternalController;
import client.controller.LoginStravaController;
import client.controller.RegisterExternalController;
import client.controller.RegisterStravaController;

public class LoginExternal {

	private JFrame frame;
	private JTextField textEmail;
	private JTextField textFieldPassword;
	private LoginExternalController controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceLocator serviceLocator = new ServiceLocator();
					LoginExternalController loginExternalController = new LoginExternalController(serviceLocator); 
					LoginExternal window = new LoginExternal(loginExternalController);
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
	public LoginExternal(LoginExternalController loginGoogleController) {
		this.controller = loginGoogleController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(333, 333, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textEmail = new JTextField();
		textEmail.setBounds(85, 107, 150, 19);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblIdentifier = new JLabel("Google/Facebook email:");
		lblIdentifier.setBounds(85, 80, 180, 13);
		frame.getContentPane().add(lblIdentifier);
		
		JLabel lblRegister1 = new JLabel("Login with Google");
		lblRegister1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegister1.setBounds(85, 40, 200, 30);
		frame.getContentPane().add(lblRegister1);
		
		JLabel lblRegister = new JLabel("Dont have an account?");
		lblRegister.setBounds(88, 220, 200, 23);
		frame.getContentPane().add(lblRegister);
		
		JButton btnLogIn = new JButton("Log In.");
		btnLogIn.setBounds(88, 170, 85, 21);
		frame.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						
						
					}
				});
		
		
		JButton btnLogStrava = new JButton("Log In with Strava");
		btnLogStrava.setBounds(188, 170, 150, 21);
		frame.getContentPane().add(btnLogStrava);
		btnLogStrava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginStravaController lsc = new LoginStravaController(controller.getServiceLocator());
				LoginStrava loginExternal = new LoginStrava(lsc);
				frame.dispose();
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(248, 220, 89, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] registrationWay = {
						"Register with gmail",
						"Register with google/fecebook account"
					};
				String resp = (String) JOptionPane.showInputDialog( null, "How do you want to register?", "Registration", JOptionPane.QUESTION_MESSAGE, null, registrationWay, "" );
				if (resp != null) {
					if (resp.equals(registrationWay[0])) {
						RegisterStravaController rsc = new RegisterStravaController(controller.getServiceLocator());
						RegisterStrava registerStrava = new RegisterStrava(rsc);
						frame.dispose();
					} else if (resp.equals(registrationWay[1])) {
						RegisterExternalController rec = new RegisterExternalController(controller.getServiceLocator());
						RegisterExternal registerExternal = new RegisterExternal(rec);
						frame.dispose();
					}
				}
				
				
				
			}
		});
		
		frame.setVisible(true);
	}
	
	public boolean externalLogin() {
		//String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex(textFieldPassword.getText());
		boolean result = this.controller.externalLogin(textEmail.getText());

		return result;
	}
	
}
