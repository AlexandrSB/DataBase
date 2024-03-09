package com.example.restservice.workshopData.Service;

import com.example.restservice.workshopData.workshopDomain.SparePart;
import com.example.restservice.workshopData.workshopDomain.TypeOfSparePart;
import com.example.restservice.workshopData.workshopDomain.WorkshopElement;
import com.example.restservice.workshopData.workshopDomain.WorkshopUnit;
import com.example.restservice.workshopData.workshopRepos.SparePartRepo;

public class SparePartService {

	private SparePart createSparePart() {

		return new SparePart();
	}

	private SparePart fullSparePart(SparePart sp, SparePartRepo spr, Long id, String name,
	                                WorkshopUnit wu, TypeOfSparePart tosp) {

		sp.setId(id);
		sp.setName(name);
		sp.setWorkshopUnit(wu);
		sp.addTypeOfSparePart(tosp);
		spr.save(sp);

		return sp;
	}

	private SparePart fullSparePart(SparePartRepo spr, Long id, String name,
	                                WorkshopUnit wu, TypeOfSparePart tosp) {
		SparePart sp = createSparePart();
		return fullSparePart(sp, spr, id, name, wu, tosp);
	}

}
