package com.proj.domain;

public class MyProject {

	private int id;
	private String ptitle, type, pabstract, status, feedback, team;

	public MyProject(int id, String ptitle, String type, String pabstract, String status, String feedback,
			String team) {
		super();
		this.id = id;
		this.ptitle = ptitle;
		this.type = type;
		this.pabstract = pabstract;
		this.status = status;
		this.feedback = feedback;
		this.team = team;
	}

	public MyProject(String ptitle, String type, String pabstract, String team) {
		super();
		this.ptitle = ptitle;
		this.type = type;
		this.pabstract = pabstract;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public String getPtitle() {
		return ptitle;
	}

	public String getType() {
		return type;
	}

	public String getPabstract() {
		return pabstract;
	}

	public String getStatus() {
		return status;
	}

	public String getFeedback() {
		return feedback;
	}

	public String getTeam() {
		return team;
	}
	
	

}
