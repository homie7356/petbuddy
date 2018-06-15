package com.pet.buddy.domain;

public class User {
	private int id;
	private String petemail;
	private String petpw;
	private String petimg;
	private String nickname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetemail() {
		return petemail;
	}
	public void setPetemail(String petemail) {
		this.petemail = petemail;
	}
	public String getPetpw() {
		return petpw;
	}
	public void setPetpw(String petpw) {
		this.petpw = petpw;
	}
	public String getPetimg() {
		return petimg;
	}
	public void setPetimg(String petimg) {
		this.petimg = petimg;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", petemail=" + petemail + ", petpw=" + petpw + ", petimg=" + petimg + ", nickname="
				+ nickname + "]";
	}
	
	
	
	
	
	
	
	
	
}
	