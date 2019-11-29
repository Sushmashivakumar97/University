package com.univ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.dao.PlacementDAO;
import com.univ.model.Placement;

@Service
public class PlacementServiceImpl implements PlacementService {
	
	@Autowired
	PlacementDAO placementDAO;

	@Override
	public boolean addPlacement(Placement placement, int studentId) {
		// TODO Auto-generated method stub
		return placementDAO.addPlacement(placement, studentId);
	}

	@Override
	public List<Placement> getAllPlacement(int studentId) {
		// TODO Auto-generated method stub
		return placementDAO.getAllPlacement(studentId);
	}

	@Override
	public Placement getPlacement(int companyId, int studentId) {
		// TODO Auto-generated method stub
		return placementDAO.getPlacement(companyId, studentId);
	}

	@Override
	public boolean deletePlacement(int companyId, int studentId) {
		// TODO Auto-generated method stub
		return placementDAO.deletePlacement(companyId, studentId);
	}

	@Override
	public boolean updatePlacement(int studentId, Placement placement) {
		// TODO Auto-generated method stub
		return placementDAO.updatePlacement(studentId, placement);
	}

	@Override
	public boolean isPlacementExists(int companyId, int studentId) {
		// TODO Auto-generated method stub
		return placementDAO.isPlacementExists(companyId, studentId);
	}

}
