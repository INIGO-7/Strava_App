package server.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class User {	
	private String name;
	private String password;
	private String email;
    private Date birthDate;
    private int weight;
    private int height;
    private int maxRate;
    private int restRate;
    private List<TrainingSession> trainingSessions;
    private List<Challenge> challenges;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean checkPassword(String password) {
    	System.err.println("first password: " + password);
    	System.err.println("second password: " + this.password);
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(int maxRate) {
        this.maxRate = maxRate;
    }

    public int getRestRate() {
        return restRate;
    }

    public void setRestRate(int restRate) {
        this.restRate = restRate;
    }

    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    public void setTrainingSessions(List<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    public void addTrainingSession(TrainingSession trainingSession) {
        this.trainingSessions.add(trainingSession);
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public void addActiveChallenge(Challenge challenge) {
        this.challenges.add(challenge);
    }

    public String toString() {
        return "User [name=" + name + ", password=" + password + ", email=" + email + ", birthDate=" + birthDate
                + ", weight=" + weight + ", height=" + height + ", maxRate=" + maxRate + ", restRate=" + restRate
                + ", trainingSessions=" + trainingSessions + ", challenges=" + challenges + "]";
    }

    public boolean equals(Object obj) {
        if (this.getClass().getName().equals(obj.getClass().getName())){
            return this.email.equals(((User)obj).getName());
        }else{
            return false;
        }
    }

}
