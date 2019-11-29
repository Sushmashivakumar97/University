package com.univ.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.univ.model.Placement;

@Repository
public class PlacementDAOImpl implements PlacementDAO {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	public boolean addPlacement(Placement placement,int studentId) {
		Student student =mongoTemplate.findById(studentId,Student.class,"student");
		System.out.println(student);
		
		student.getPlacement().add(placement);
		mongoTemplate.save(student);
		return false;
	}
	
	public List<Placement> getAllPlacement(int studentId){
		Student student==mongoTemplate.findById(studentId,Student.class,"student");
		List<Placement> placement=student.getPlacement();
		return placement;
		
	}
	
	public Placement getPlacement(int companyId,int studentId)
	{
		Student student==mongoTemplate.findById(studentId,Student.class,"student");
		List<Placement> placement=student.getPlacement();
		for(Placement x:placement) {
			if(x.getCompanyId()==companyId) {
				return x;
			}
		}
		return null;
		
	}
	public boolean deletePlacement(int companyId,int studentId) {
		Student student=mongoTemplate.findById(studentId,Student.class,"student");
		List<Placement> placement=student.getPlacement();
		for(Placement x:placement) {
			if(x.getCompanyId()==companyId) {
				placement.remove(x);
				student.setPlacement(placement);
				mongoTemplate.save(student);
			}
		}
		return false;
	}
	
	public boolean updatePlacement(int studentId,Placement placement) {
		Query query=new Query();
		query.addCriteria(new Criteria().andOperator(Criteria.where("_id").is(studentId),
				Criteria.where("companyId").is(placement.getCompanyId())));
		Student student=mongoTemplate.findById(studentId,Student.class,"student");
		List<Placement> p=student.getPlacement();
		
		for(Placement x:p) {
			if(x.getCompanyId()==placement.getCompanyId(){
				p.remove(x);
				p.add(placement);
				student.setPlacement(p);
				mongoTemplate.save(student);
				return true;
			}
		}
		return false;
		
	}
	public boolean isPlacementExists(int companyId,int studentId) {
		Student student=mongoTemplate.findById(studentId,Student.class,"student");
		List<Placement> placement=student.getPlacement();
		for(Placement x:placement) {
			if(x.getCompanyId()==companyId) {
				return true;
			}
		}
		return false;
	}
	
}
