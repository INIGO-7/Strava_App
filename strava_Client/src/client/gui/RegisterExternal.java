package client.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import client.controller.LoginStravaController;
import client.controller.RegisterExternalController;
import client.controller.RegisterStravaController;

import javax.swing.JLabel;
import java.awt.Font;

public class RegisterExternal {

	private JFrame frame;
	private JTextField textFieldIdentifier;
	private RegisterExternalController controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceLocator serviceLocator = new ServiceLocator();
					RegisterExternalController registerExternalController = new RegisterExternalController(serviceLocator); 
					RegisterExternal window = new RegisterExternal(registerExternalController);
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
	public RegisterExternal(RegisterExternalController registerGoogleController) {
		this.controller = registerGoogleController;
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
		

		
		textFieldIdentifier = new JTextField();
		textFieldIdentifier.setBounds(85, 107, 150, 19);
		frame.getContentPane().add(textFieldIdentifier);
		textFieldIdentifier.setColumns(10);
		
		JLabel lblIdentifier = new JLabel("Google/Facebook email:");
		lblIdentifier.setBounds(85, 80, 180, 13);
		frame.getContentPane().add(lblIdentifier);
		
		JLabel lblRegister = new JLabel("Register with Google");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegister.setBounds(85, 40, 200, 30);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblLogin = new JLabel("Already have an account?");
		lblLogin.setBounds(85, 200, 200, 30);
		frame.getContentPane().add(lblLogin);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(250, 205, 85, 21);
		frame.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginStravaController lsc = new LoginStravaController(controller.getServiceLocator());
				new LoginStrava(lsc);
				frame.dispose();
				
			}
		});
		
		JButton btnRegisterStrava = new JButton("Register with Strava");
		btnRegisterStrava.setBounds(207, 164, 190, 21);
		frame.getContentPane().add(btnRegisterStrava);
		btnRegisterStrava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterStravaController rsc = new RegisterStravaController(controller.getServiceLocator());
				new RegisterStrava(rsc);
				//controller.externalRegister(null, null, null, 0, 0, 0, 0);
				frame.dispose();
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(85, 163, 90, 23);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		frame.setVisible(true);
	}
	
	public void externalRegister() {
		//this.controller.externalRegister(email, name, birthDate, weight, height, maxRate, restRate);	//where do i get these attributes from.
	}
	
}
