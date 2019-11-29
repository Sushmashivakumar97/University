package com.univ.service;

import java.util.List;

import com.univ.model.Placement;

public interface PlacementService {
	public boolean addPlacement(Placement placement,int studentId);
	public List<Placement> getAllPlacement(int studentId);
	public Placement getPlacement(int companyId,int studentId);
	public boolean deletePlacement(int companyId,int studentId);
	public boolean updatePlacement(int studentId,Placement placement);
	public boolean isPlacementExists(int companyId,int studentId);

}
