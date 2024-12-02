package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.modal.Hospital;
import com.nt.service.IService;

@Component("ctlr")
public class HospitalController 
{
	@Autowired
	private IService service;
		
    public List<Hospital> getData(String c1,String c2) throws Exception
    {
    	   List<Hospital> li =service.getHospitalRecords(c1, c2); 
    	   return li;
    }
}
