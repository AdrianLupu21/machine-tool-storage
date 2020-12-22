package com.fiir.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MachineContainer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//TODO add Part to the system
	private int idPart;
	
	@ManyToOne
	private MachineSlot machineSlot;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPart() {
		return idPart;
	}

	public void setIdPart(int idPart) {
		this.idPart = idPart;
	}
	
	

}
