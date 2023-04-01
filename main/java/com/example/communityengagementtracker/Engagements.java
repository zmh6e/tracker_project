package com.example.communityengagementtracker;

public class Engagements {
    private String username;
    private String name;
    private String partner;
    private String agency;
    private String location;
    private String comments;
    private Integer date;
    private Integer startTime;
    private Integer endTime;

    public Engagements() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String Partner) {
        this.partner = Partner;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String Agency) {
        this.agency = Agency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String Comments) {
        this.comments = Comments;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(int Date) {
        this.date = Date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(int StartTime) {
        this.startTime = StartTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(int EndTime) {
        this.endTime = EndTime;
    }
}
