package com.anytest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Bus implements Vehicle {

	@Id
	@GeneratedValue
	Long id;
	Long buyingPrice;
	String modelNo;
	Long engineCapacity;
	int seatCount;
	boolean acAvailable;
	
	public Bus(){}
	
	public Bus(final Long buyingPrice, final String modelNo, final Long engineCapacity, final int seatCount, final boolean acAvailable)
	{
		this.buyingPrice=buyingPrice;
		this.modelNo=modelNo;
		this.engineCapacity=engineCapacity;
		this.seatCount=seatCount;
		this.acAvailable=acAvailable;
	}
}
