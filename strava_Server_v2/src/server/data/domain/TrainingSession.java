package server.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import server.data.domain.Sport;

public class TrainingSession {
	private String title;
    private float distance;
    private Date startDate;
    private long startTime;
    private float duration;
    private Sport sport;
     
    public TrainingSession(String title, float distance, Date startDate, long startTime, float duration) {
		
		this.title = title;
		this.distance = distance;
		this.startDate = startDate;
		this.startTime = startTime;
		this.duration = duration;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String toString() {
        return "TrainingSession [title=" + title + ", distance=" + distance + ", startDate=" + startDate + ", startTime=" + startTime + ", duration=" + duration + "]";
    }

    public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.title.equals(((TrainingSession)obj).title);
		}
		
		return false;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}