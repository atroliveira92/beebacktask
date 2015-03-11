package com.beebacktask.model;

public class UserProfile {

	 private int UserProfileDetailId;
	 private int UserId;
	 private String Email;
	 private boolean Ativo;
	 private String UserName;
	 private String Nome;
	 
	public int getUserProfileDetailId() {
		return UserProfileDetailId;
	}
	public void setUserProfileDetailId(int userProfileDetailId) {
		this.UserProfileDetailId = userProfileDetailId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		this.UserId = userId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public boolean isAtivo() {
		return Ativo;
	}
	public void setAtivo(boolean ativo) {
		this.Ativo = ativo;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
}
