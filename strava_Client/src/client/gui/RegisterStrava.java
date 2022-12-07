 package client.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.controller.ActiveChallengesController;
import client.controller.LoginStravaController;
import client.controller.RegisterExternalController;
import client.controller.RegisterStravaController;
import client.remote.ServiceLocator;

public class RegisterStrava {

	private JFrame frame;
	private JTextField tfEmail;
	private JTextField tfName;
	private JTextField tfBirthDay;
	private JTextField tfWeight;
	private JTextField tfHeight;
	private JTextField tfMHR;
	private JTextField tfHRR;
	private JTextField tfPassword;
	
	private RegisterStravaController controller;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceLocator serviceLocator = new ServiceLocator();
					RegisterStravaController registerStravaController = new RegisterStravaController(serviceLocator); 
					RegisterStrava window = new RegisterStrava(registerStravaController);
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
	public RegisterStrava(RegisterStravaController registerStravaController) {
		this.controller = registerStravaController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(333, 333, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(79, 40, 155, 13);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(79, 63, 155, 13);
		frame.getContentPane().add(lblName);
		
		JLabel lblBirth_date = new JLabel("Birth date (dd/MM/yyyy)");
		lblBirth_date.setBounds(79, 86, 155, 13);
		frame.getContentPane().add(lblBirth_date);
		
		JLabel lblWeight = new JLabel("Weight (kg)");
		lblWeight.setBounds(79, 109, 155, 13);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblHRR = new JLabel("Heart rate at rest (bpm)");
		lblHRR.setBounds(79, 178, 155, 13);
		frame.getContentPane().add(lblHRR);
		
		JLabel lblHeight = new JLabel("Height (cm)");
		lblHeight.setBounds(79, 132, 155, 13);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblPassword = new JLabel("User password");
		lblPassword.setBounds(79, 201, 155, 13);
		frame.getContentPane().add(lblPassword);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(247, 34, 150, 19);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(247, 57, 150, 19);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfBirthDay = new JTextField();
		tfBirthDay.setBounds(247, 80, 150, 19);
		frame.getContentPane().add(tfBirthDay);
		tfBirthDay.setColumns(10);
		
		tfWeight = new JTextField();
		tfWeight.setBounds(247, 103, 150, 19);
		frame.getContentPane().add(tfWeight);
		tfWeight.setColumns(10);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(247, 126, 150, 19);
		frame.getContentPane().add(tfHeight);
		tfHeight.setColumns(10);
		
		tfMHR = new JTextField();
		tfMHR.setBounds(247, 149, 150, 19);
		frame.getContentPane().add(tfMHR);
		tfMHR.setColumns(10);
		
		tfHRR = new JTextField();
		tfHRR.setBounds(247, 172, 150, 19);
		frame.getContentPane().add(tfHRR);
		tfHRR.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(247, 195, 150, 19);
		frame.getContentPane().add(tfPassword);
		tfPassword.setColumns(10);
		
		JLabel lblLogin = new JLabel("Already have an account?");
		lblLogin.setBounds(79, 265, 155, 13);
		frame.getContentPane().add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(255, 260, 85, 21);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginStravaController lstc = new LoginStravaController(controller.getServiceLocator());
				new LoginStrava(lstc);
				frame.dispose();
			}
		});
		
		JButton btnRegGoogle = new JButton("Register with Google/Facebook");
		btnRegGoogle.setBounds(190, 217, 220, 21);
		frame.getContentPane().add(btnRegGoogle);
		btnRegGoogle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterExternalController rec = new RegisterExternalController(controller.getServiceLocator());
				new RegisterExternal(rec);
				frame.dispose();
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
        
			@Override
			public void actionPerformed(ActionEvent e) {
	            
	            if (tfEmail.getText().equals("") || tfName.getText().equals("") || tfBirthDay.getText().equals("") || tfWeight.getText().equals("") || 
	            		tfHeight.getText().equals("") || tfMHR.getText().equals("") || tfHRR.getText().equals("") || tfPassword.getText().equals("")) {
	            	
	                JOptionPane.showMessageDialog(null, "Please fill all the fields");
	                
	            } else {
	                try {
	                    // try to convert the input parameters to the correct type. It this fails then we cannot call stravaRegister, so it will throw an exception.
	                	
	                	//String email 
	                	//String email = stringEmail;
	                	//String name 
	                	//String name = stringName;
	                	//Date birthDate
	                	new SimpleDateFormat("dd/MM/yyyy").parse(tfBirthDay.getText());
	                	//int weight
	                	Integer.parseInt(tfWeight.getText());
	                	//int height
	                	Integer.parseInt(tfHeight.getText());
	                	//int maxRate
	                	Integer.parseInt(tfMHR.getText());
	                	//int restRate
	                	Integer.parseInt(tfHRR.getText());
	                	//String password
	                	//String password = stringPassword;
	                	
	                	stravaRegister();
	                	
	                	//when registered in the system, we log in automatically, so we are redirected to the activeChallenges (main) screen.
	                	
	                	ActiveChallengesController acc = new ActiveChallengesController(controller.getServiceLocator(), controller.getToken());
	                	new ActiveChallenges(acc);
						frame.dispose();
	                	
	                } catch (Exception e1) {
	                    JOptionPane.showMessageDialog(null, "Please fill all the fields with the appropiate data");
	                    e1.printStackTrace();
	                }
	                
	            }
			}
		});
		
		btnRegister.setBounds(79, 217, 85, 21);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegister.setBounds(79, 0, 150, 30);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblMHR = new JLabel("Maximum heart rate (bpm)");
		lblMHR.setBounds(79, 155, 155, 13);
		frame.getContentPane().add(lblMHR);
		
		frame.setVisible(true);
	}
	
	public void stravaRegister() throws NumberFormatException, ParseException {
		
		this.controller.stravaRegister(tfEmail.getText(), tfName.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(tfBirthDay.getText()), 
				Integer.parseInt(tfWeight.getText()), Integer.parseInt(tfHeight.getText()), Integer.parseInt(tfMHR.getText()), 
				Integer.parseInt(tfHRR.getText()), org.apache.commons.codec.digest.DigestUtils.sha1Hex(tfPassword.getText()));
	}
	
}
