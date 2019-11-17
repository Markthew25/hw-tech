package com.tech.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("P")
public class Peripheral extends Item {

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name="date_bought")
	private Date dateBought;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name="date_warranty")
	private Date dateWarranty;

	public Peripheral() {
		super();
	}

	public Date getDateBought() {
		return dateBought;
	}

	public void setDateBought(Date dateBought) {
		this.dateBought = dateBought;
	}

	public Date getDateWarranty() {
		return dateWarranty;
	}

	public void setDateWarranty(Date dateWarranty) {
		this.dateWarranty = dateWarranty;
	}
	
	
	
}
