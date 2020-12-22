package com.fiir.api.dto;

public class MachineSlotRequest {
	
	private boolean isBusy;
	
	private int idMachineTool;

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}

	public int getIdMachineTool() {
		return idMachineTool;
	}

	public void setIdMachineTool(int idMachineTool) {
		this.idMachineTool = idMachineTool;
	}
	
	
}
