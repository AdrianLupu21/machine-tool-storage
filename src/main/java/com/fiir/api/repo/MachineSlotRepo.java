package com.fiir.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiir.api.model.MachineSlot;

public interface MachineSlotRepo extends JpaRepository<MachineSlot, Integer> {

}
