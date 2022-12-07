package server.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Challenge {

    private static int IDGlobal=1;
    private int ID;
    private String name;
    private Date startDate;
    private Date endDate;
    private boolean targetType;
    private int target;
    private Sport sport;

    public Challenge(String name, Date startDate, Date endDate, boolean targetType, int target) {
		super();
        this.ID = IDGlobal;
        IDGlobal++;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.targetType = targetType;
		this.target = target;
	}

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

    public String toString() {
        return "Challenge [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", targetType=" + targetType + ", target=" + target + "]";
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.name.equals(((Challenge) obj).getName());
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
