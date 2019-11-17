package com.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supp_id")
	private int suppID;
	
	@Column(name = "supp_name")
	private String suppName;
	
	@Column(name = "supp_address")
	private String suppAddress;
	
	public Supplier() {
		
	}

	public int getSuppID() {
		return suppID;
	}

	public void setSuppID(int suppID) {
		this.suppID = suppID;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppAddress() {
		return suppAddress;
	}

	public void setSuppAddress(String suppAddress) {
		this.suppAddress = suppAddress;
	}

	
}
