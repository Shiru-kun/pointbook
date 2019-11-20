package com.mz.cth.Pointbook.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.cth.Pointbook.model.PointBook;

@Repository
public interface IPointBook  extends JpaRepository <PointBook, Long >{
	
	

}
