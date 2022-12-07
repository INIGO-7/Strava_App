package server.data.dto;

import server.data.domain.Sport;
import java.io.Serializable;
import java.util.Date;

public class TrainingSessionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String title;
	private float distance;
	private Date startDate;
	private long startTime;
	private float duration;
	private Sport sport;
	
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

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	@Override
	public String toString() {
		return "TrainingSessionDTO [title=" + title + ", distance=" + distance + ", startDate=" + startDate + ", startTime="
				+ startTime + ", duration=" + duration + ", sport=" + sport + "]";
	}
}
