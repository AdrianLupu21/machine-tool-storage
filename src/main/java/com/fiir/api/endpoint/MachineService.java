package com.fiir.api.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiir.api.dto.MachineRequest;
import com.fiir.api.dto.MachineSlotRequest;
import com.fiir.api.model.MachineContainer;
import com.fiir.api.model.MachineSlot;
import com.fiir.api.model.MachineTool;
import com.fiir.api.repo.MachineContainerRepo;
import com.fiir.api.repo.MachineSlotRepo;
import com.fiir.api.repo.MachineToolRepo;

@RestController
@RequestMapping("/machine")
public class MachineService {

	private static final Logger logger = LoggerFactory.getLogger(MachineService.class);
	
	@Autowired
	MachineToolRepo machineRepo;
	
	@Autowired
	MachineSlotRepo machineSlotRepo;
	
	@Autowired
	MachineContainerRepo containerRepo;
	
	@RequestMapping(value="/machines", method= RequestMethod.GET)
	public List<MachineTool> getMachines() {
		logger.debug("Request getMachines was initaited");
		return machineRepo.findAll();
	}
	
	@RequestMapping(value="/machines", method=RequestMethod.POST, consumes="application/json")
	public void postMachine(@RequestBody MachineRequest machineRequest) {
		logger.info("Request postMachine was made with name:{} and isBusy:{}", machineRequest.getName(), machineRequest.isBusy());
		MachineTool machineTool = new MachineTool();
		machineTool.setBusy(machineRequest.isBusy());
		machineTool.setName(machineRequest.getName());
		machineRepo.save(machineTool);
	}
	
	@RequestMapping(value="/machine-slot", method=RequestMethod.POST, consumes="applicaton/json")
	public void postMachineSlot(@RequestBody MachineSlotRequest request) {
		logger.debug("Request postMachineSlot was made with idMachineTool:{}, isBusy:{}", request.getIdMachineTool(), request.isBusy());
		MachineSlot machineSlot = new MachineSlot();
		MachineTool machineTool = machineRepo.findById(request.getIdMachineTool()).get();
		machineSlot.setBusy(request.isBusy());
		machineSlot.setMachineTool(machineTool);
		machineSlotRepo.save(machineSlot);
	}
	
	@RequestMapping(value="/machineSlots", method = RequestMethod.GET)
	public List<MachineSlot> getMachineSlots(){
		logger.debug("Request getMachineSlots was initiated");
		return machineSlotRepo.findAll();
	}
	
	@RequestMapping(value="/containers", method = RequestMethod.GET)
	public List<MachineContainer> getContainers(){
		logger.debug("Request getContainers was initiated");
		return containerRepo.findAll();
	}
	
	
}
