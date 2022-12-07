package server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class ChallengeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int ID;
	private String name;
	private Date startDate;
	private Date endDate;
	private boolean targetType;
	private int target;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getTargetType() {
		return targetType;
	}

	public void setTargetType(boolean targetType) {
		this.targetType = targetType;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "ChallengeDTO [name=" + name + "id=" + ID + ", startDate=" + startDate + ", endDate=" + endDate + ", targetType="
				+ targetType + ", target=" + target + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}
