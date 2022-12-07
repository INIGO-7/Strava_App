package client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JTextField;

import client.controller.ActiveChallengesController;
import client.controller.RegisterStravaController;
import client.controller.SetUpChallengeController;
import client.remote.ServiceLocator;

public class SetUpChallenge{

    private JFrame frame;
	private JTextField textName;
    private JTextField textStartDate;
    private JTextField textEndDate;
    private JTextField textStartTime;
    private JTextField textDuration;
    private JButton btnCreateChallenge;
    private JButton btnGoBack;
    private SetUpChallengeController controller;

    /**
     * Launch the application.
     */
    
    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ServiceLocator serviceLocator = new ServiceLocator();
                	SetUpChallengeController setUpChallengeController = new SetUpChallengeController(serviceLocator); 
                	SetUpChallenge window = new SetUpChallenge(setUpChallengeController);
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

    public SetUpChallenge(SetUpChallengeController controller) {
    	this.controller = controller;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    private void initialize() {
        frame = new JFrame();
		frame.setBounds(333, 333, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane() ;
		contentPane.setLayout(null);

        
        JLabel lblName = new JLabel("Name");
		lblName.setBounds(79, 40, 155, 13);
		contentPane.add(lblName);

        JLabel lblStartDate = new JLabel("Start Date (dd/MM/yyyy)");
        lblStartDate.setBounds(79, 63, 155, 13);
        contentPane.add(lblStartDate);

        JLabel lblEndDate = new JLabel("End Date (dd/MM/yyyy)");
        lblEndDate.setBounds(79, 86, 155, 13);
        contentPane.add(lblEndDate);

        JLabel lblStartTime = new JLabel("Start Time");
        lblStartTime.setBounds(79, 109, 155, 13);
        contentPane.add(lblStartTime);

        JLabel lblDuration = new JLabel("Duration");
        lblDuration.setBounds(79, 132, 155, 13);
        contentPane.add(lblDuration);

        textName = new JTextField();
        textName.setBounds(244, 37, 96, 19);
        contentPane.add(textName);
        textName.setColumns(10);

        textStartDate = new JTextField();
        textStartDate.setBounds(244, 60, 96, 19);
        contentPane.add(textStartDate);
        textStartDate.setColumns(10);

        textEndDate = new JTextField();
        textEndDate.setBounds(244, 83, 96, 19);
        contentPane.add(textEndDate);
        textEndDate.setColumns(10);

        textStartTime = new JTextField();
        textStartTime.setBounds(244, 106, 96, 19);
        contentPane.add(textStartTime);
        textStartTime.setColumns(10);

        textDuration = new JTextField();
        textDuration.setBounds(244, 129, 96, 19);
        contentPane.add(textDuration);
        textDuration.setColumns(10);

        btnCreateChallenge = new JButton("Create Challenge");
        btnCreateChallenge.setBounds(130, 158, 150, 21);
        btnCreateChallenge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String name = textName.getText();
                String startDate = textStartDate.getText();
                String endDate = textEndDate.getText();
                String startTime = textStartTime.getText();
                String duration = textDuration.getText();
                
                if (name.equals("") || startDate.equals("") || endDate.equals("") || startTime.equals("") || duration.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    try {
                        // try to convert the input parameters to the correct type
                    	//long token
                    	Long token = controller.getToken();
                    	//String name 
                    	name = textName.getText();
                    	//Date startDate
                    	new SimpleDateFormat("dd/MM/yyyy").parse(textStartDate.getText());
                    	//Date endDate
                    	new SimpleDateFormat("dd/MM/yyyy").parse(textEndDate.getText());
                    	//long startTime
                    	Long.parseLong(startTime);
                    	//long duration
                    	Float.parseFloat(duration);
                        
                        //then create the challenge
                        setUpChallenge(token);

                        //when we create the challenge, then go back to activeChallenges
                        ActiveChallengesController acc = new ActiveChallengesController(controller.getServiceLocator(), controller.getToken());
                    	new ActiveChallenges(acc);
        				frame.dispose();
                        
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields correctly");
                    }
                    
                }
            }
        });
        contentPane.add(btnCreateChallenge);
        
        btnGoBack = new JButton("<----- Go back");
        btnGoBack.setBounds(130, 180, 150, 21);
        btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	ActiveChallengesController acc = new ActiveChallengesController(controller.getServiceLocator(), controller.getToken());
            	new ActiveChallenges(acc);
				frame.dispose();
                
            }
        });
        contentPane.add(btnGoBack);
        
        frame.setVisible(true);
    
    }

      
    public boolean setUpChallenge(long token) {
    	try {
			return this.controller.setUpChallenge(token, textName.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(textStartDate.getText()), 
			new SimpleDateFormat("dd/MM/yyyy").parse(textEndDate.getText()), Long.parseLong(textStartTime.getText()), Long.parseLong(textDuration.getText()));
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
			return false;	//couldn't create challenge
		}

    }

}