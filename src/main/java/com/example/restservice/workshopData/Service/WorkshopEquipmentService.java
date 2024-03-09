package com.example.restservice.workshopData.Service;

import com.example.restservice.workshopData.workshopDomain.WorkshopEquipment;
import com.example.restservice.workshopData.workshopRepos.WorkshopEquipmentRepo;
import org.springframework.stereotype.Service;

@Service
public class WorkshopEquipmentService {

	private WorkshopEquipment createWorkshopEquipment() {
		return new WorkshopEquipment();
	}

	public static WorkshopEquipment fullWorkshopEquipment(
			WorkshopEquipment workshopEquipment,
			WorkshopEquipmentRepo workshopEquipmentRepo,
			Long id, String name

	) {
		workshopEquipment.setId(id);
		workshopEquipment.setName(name);
		workshopEquipmentRepo.save(workshopEquipment);

		return workshopEquipment;
	}

	private WorkshopEquipment fullWorkshopEquipment(
			WorkshopEquipmentRepo wer,
			Long id, String name
	) {
		WorkshopEquipment workshopEquipment = createWorkshopEquipment();
		return fullWorkshopEquipment(wer, id, name);
	}

	public static WorkshopEquipment fullWorkshopEquipment(
			WorkshopEquipment equipment, Long id, String name
	) {
		equipment.setId(id);
		equipment.setName(name);
		return equipment;
	}
}
