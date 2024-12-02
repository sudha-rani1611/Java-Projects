package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.dao.IDAO;
import com.nt.modal.Hospital;

@Component
public class Service01 implements IService 
{

	@Autowired
	private IDAO dao;
	@Override
	public List<Hospital> getHospitalRecords(String c1,String c2) throws Exception
	{
		List<Hospital> li =dao.getRecords(c1, c2);
		
		li.sort((t1,t2)->{
			return t1.getId().compareTo(t2.getId());
		});
		return li;
	}

}
