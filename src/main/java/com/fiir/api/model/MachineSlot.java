package com.fiir.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MachineSlot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private MachineTool machineTool;
		
	private boolean isBusy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MachineTool getMachineTool() {
		return machineTool;
	}

	public void setMachineTool(MachineTool machineTool) {
		this.machineTool = machineTool;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
}
