package com.univ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univ.model.Placement;
import com.univ.service.PlacementService;

@RestController
@CrossOrigin(origins= {"http://localhost:3000"})
@RequestMapping("student")
public class PlacementController {
	
	@Autowired
	PlacementService placementService;
	
	@PostMapping("/{studentId}/placement")
	public ResponseEntity<Placement> addCompany(@PathVariable(value="studentId")int studentId,@RequestBody Placement placement){
		if(placementService.isPlacementExists(placement.getCompanyId(), studentId)){
			return new ResponseEntity<Placement>(HttpStatus.CONFLICT);
		}
		else {
			placementService.addPlacement(placement,studentId);
			return new ResponseEntity<Placement>(HttpStatus.CREATED);
		 
		}
	}
	@GetMapping("/{studentId}/placement/{companyId}")
	public ResponseEntity<Placement> getCompany(@PathVariable(value="studentId")int studentId,@PathVariable(value="companyId")int companyId){
		Placement placement=new Placement();
		if(placementService.isPlacementExists(placement.getCompanyId(), studentId)){
			
			placement=placementService.getPlacement(companyId,studentId);
			return new ResponseEntity<Placement>(placement,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Placement>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/{studentId}/placement")
	public ResponseEntity<List<Placement>> getAllCompany(@PathVariable(value="studentId")int studentId){
		
			List<Placement>placements=placementService.getAllPlacement(studentId);
			return new ResponseEntity<List<Placement>>(placements,HttpStatus.OK);
		
	}
	@DeleteMapping("/{studentId}/placement/{companyId}")
	public ResponseEntity<String> deleteCompany(@PathVariable(value="studentId")int studentId,@PathVariable(value="companyId")int companyId){
		if(placementService.isPlacementExists(companyId, studentId)){
			placementService.deletePlacement(companyId, studentId);
			return new ResponseEntity<String>("company is deleted successsfully",HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);
		 
		}
	
	}
	@PutMapping("/{studentId}/placement")
	public ResponseEntity<Placement> updateCompany(@PathVariable(value="studentId")int studentId,@RequestBody Placement placement){
		if(placementService.isPlacementExists(placement.getCompanyId(), studentId)){
			placementService.updatePlacement(studentId,placement);
			return new ResponseEntity<Placement>(HttpStatus.CREATED);
		}
		else {
			
			return new ResponseEntity<Placement>(HttpStatus.CONFLICT);
		 
		}
	}
	
	
	
}
