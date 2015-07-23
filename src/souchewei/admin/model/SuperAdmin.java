package souchewei.admin.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 超级管理员
 */
@Entity()
@Table(name="admin")
public class SuperAdmin implements Serializable{
	@Id @Column(name="amdin_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long amdinId;
	private String username;
	private String password;
	private int[] slat;
	public Long getAmdinId() {
		return amdinId;
	}
	public void setAmdinId(Long amdinId) {
		this.amdinId = amdinId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int[] getSlat() {
		return slat;
	}
	public void setSlat(int[] slat) {
		this.slat = slat;
	}
	
}
