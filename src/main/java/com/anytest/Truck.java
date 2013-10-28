package com.anytest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Truck implements Vehicle {

	@Id
	@GeneratedValue
	Long id;
	Long buyingPrice;
	String modelNo;
	Long engineCapacity;
	Long trunkVolumeCapacity;
	
	public Truck(){}
	
	public Truck(final Long buyingPrice, final String modelNo, final Long engineCapacity, final Long trunkVolumeCapacity)
	{
		this.buyingPrice=buyingPrice;
		this.modelNo=modelNo;
		this.engineCapacity=engineCapacity;
		this.trunkVolumeCapacity=trunkVolumeCapacity;
	}
}
