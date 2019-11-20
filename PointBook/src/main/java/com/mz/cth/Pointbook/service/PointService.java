package com.mz.cth.Pointbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.cth.Pointbook.interfaces.IPointBook;
import com.mz.cth.Pointbook.model.PointBook;

@Service
public class PointService {

	@Autowired
	IPointBook ipoint;

	public boolean save(PointBook pointBook) {
		try {
			ipoint.save(pointBook);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	

	}

	public List<PointBook> findAll() {
           List<PointBook> pointbooks=  ipoint.findAll();
		return pointbooks;
	}

	public boolean delete(Long id) {
		try {
			
			ipoint.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
}
