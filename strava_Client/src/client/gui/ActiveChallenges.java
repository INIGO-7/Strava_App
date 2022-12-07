package client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import client.controller.ActiveChallengesController;
import client.controller.LoginStravaController;
import client.controller.SetUpChallengeController;
import client.controller.TrainingSessionController;
import client.remote.ServiceLocator;
import server.data.dto.ChallengeDTO;
import server.data.dto.ChallengeAssembler;
//import server.data.domain.Challenge;


import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActiveChallenges {

	private JFrame frame;
	private JScrollPane  panel;
	private ActiveChallengesController controller;
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceLocator serviceLocator = new ServiceLocator();
					ActiveChallengesController activeChallengesController = new ActiveChallengesController(serviceLocator); 
					ActiveChallenges window = new ActiveChallenges(activeChallengesController);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
		
	public ActiveChallenges(ActiveChallengesController activeChallengesController) {
		this.controller = activeChallengesController;
		initialize();
	}
		
		
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(333, 233, 450, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		String challenges[] = {"challenge1 Text ..... Challenge.exe","challenge2 Text ..... Challenge.exe","challenge3 Text ..... Challenge.exe",
				"challenge4 Text ..... Challenge.exe","challenge5 Text ..... Challenge.exe","challenge6 Text ..... Challenge.exe",
				"challenge7 Text ..... Challenge.exe","challenge8 Text ..... Challenge.exe","challenge9 Text ..... Challenge.exe","challenge10 Text ..... Challenge.exe",
				"challenge11 Text ..... Challenge.exe","challenge12 Text ..... Challenge.exe","challenge13 Text ..... Challenge.exe"};
		
		List<ChallengeDTO> challenge = this.getActiveChallenges();
		List<String> challengeNames = new ArrayList<String>();
		
		for (ChallengeDTO c : challenge) challengeNames.add(c.getName());
		
		
		JList<String> list = new JList(challengeNames.toArray());
		//JList<String> list = new JList<String>(challenges);
		
		panel = new JScrollPane(list);
		panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setBounds(40, 68, 350, 400);
		frame.getContentPane().add(panel);
		
		JButton btnAcceptChallenge = new JButton("Accept Challenge");
		btnAcceptChallenge.setBounds(40, 480, 160, 30);
		btnAcceptChallenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ChallengeAssembler assembler = ChallengeAssembler.getInstance();
//				try {
//					Challenge c = new Challenge("hola", new Date(), new Date(), true, 1);
//					acceptChallenge(controller.getToken(),
//						assembler.challengeToDTO(c));
//				}catch(Exception e1){
//					e1.printStackTrace();
//				}
				//we have to get from a scrollpane thte challenge selected. 0 is ID
			}
		});
		frame.getContentPane().add(btnAcceptChallenge);
		
		JButton btnCreateChallenge = new JButton("Create Challenge");
		btnCreateChallenge.setBounds(220, 480, 160, 30);
		btnCreateChallenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetUpChallengeController suc = new SetUpChallengeController(controller.getServiceLocator(), controller.getToken());
				new SetUpChallenge(suc);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCreateChallenge);
		
		JButton btnStartTraining = new JButton("Start Training");
		btnStartTraining.setBounds(40, 550, 220, 30);
		btnStartTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingSessionController tsc = new TrainingSessionController(controller.getServiceLocator(), controller.getToken());
				new TrainingSession(tsc);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnStartTraining);
		
		JButton btnLogOff = new JButton("LogOff");
		btnLogOff.setBounds(40, 590, 80, 30);
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
				//if we logout, then we go to the main login screen.
				LoginStravaController loginStravaController = new LoginStravaController(controller.getServiceLocator());
				new LoginStrava(loginStravaController);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnLogOff);	
		
		frame.setVisible(true);

	}
	
	public List<ChallengeDTO> getActiveChallenges(){
		
		return (List<ChallengeDTO>) this.controller.getActiveChallenges();
		
	 
	}
	
	public boolean acceptChallenge(long token, ChallengeDTO challenge) {
		return this.controller.acceptChallenge(token, challenge.getID());
	}
	
	
	public void logout() {
		this.controller.logout();
		
	}
	
	
	
}

