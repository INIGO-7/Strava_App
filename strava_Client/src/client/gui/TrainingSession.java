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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JTextField;

import client.controller.ActiveChallengesController;
import client.controller.TrainingSessionController;
import java.util.Date;

public class TrainingSession {

    private JFrame frame;
	private JTextField textTittle;
    private JTextField textDistance;
    private JTextField textDuration;
    private JButton btnCreateTrainingSession;
    private JButton btnGoBack;
    private TrainingSessionController controller;

    /**
     * Launch the application.
     */
    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrainingSession window = new TrainingSession();
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
    
    public TrainingSession(TrainingSessionController trainingSessionController) {
    	this.controller = trainingSessionController;
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
        
        JLabel lblTittle = new JLabel("Tittle");
        lblTittle.setBounds(79, 40, 155, 13);
        frame.getContentPane().add(lblTittle);
        
        JLabel lblDistance = new JLabel("Distance");
        lblDistance.setBounds(79, 63, 155, 13);
        frame.getContentPane().add(lblDistance);
        
        JLabel lblDuration = new JLabel("Duration");
        lblDuration.setBounds(79, 86, 155, 13);
        frame.getContentPane().add(lblDuration);
        
        textTittle = new JTextField();
        textTittle.setBounds(244, 37, 96, 19);
        frame.getContentPane().add(textTittle);
        textTittle.setColumns(10);
        
        textDistance = new JTextField();
        textDistance.setBounds(244, 60, 96, 19);
        frame.getContentPane().add(textDistance);
        textDistance.setColumns(10);
        
        textDuration = new JTextField();
        textDuration.setBounds(244, 83, 96, 19);
        frame.getContentPane().add(textDuration);
        textDuration.setColumns(10);
        
        btnCreateTrainingSession = new JButton("Create Training Session");
        btnCreateTrainingSession.setBounds(130, 120, 150, 21);
        
        ActionListener actionListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tittleField = textTittle.getText();
                String distanceField = textDistance.getText();
                String durationField = textDuration.getText();
                //no blank fields
                if (tittleField.equals("") || distanceField == "" || distanceField == "0" || durationField == "" || durationField == "0") {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                } else {
                    // try to convert the input parameters to the correct type. If it fails createTrainingSession shouldn't be called, then --> exception
                    try {
                    	//title = tittleField;
                        Float.parseFloat(textDistance.getText());
                        Float.parseFloat(textDuration.getText());
                        
                        createTrainingSession(controller.getToken());
                        
                        //when we create the session, then go back to activeChallenges
                        ActiveChallengesController acc = new ActiveChallengesController(controller.getServiceLocator(), controller.getToken());
                    	new ActiveChallenges(acc);
        				frame.dispose();
                        
                    } catch (NumberFormatException e1) {
                    	e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }
        };
        
        btnCreateTrainingSession.addActionListener( actionListener1 );
        frame.getContentPane().add(btnCreateTrainingSession);
        
        
        btnGoBack = new JButton("<----- Go back");
        btnGoBack.setBounds(130, 145, 150, 21);
        btnGoBack.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	ActiveChallengesController acc = new ActiveChallengesController(controller.getServiceLocator(), controller.getToken());
            	new ActiveChallenges(acc);
				frame.dispose();
            }
        });
        frame.getContentPane().add(btnGoBack);
        
        frame.setVisible(true);
    
    }
        
    
    public void createTrainingSession(long token) {
    	this.controller.createTrainingSession(token, textTittle.getText(), Float.parseFloat(textDistance.getText()), Long.parseLong(textDuration.getText()));
    }
    
}
