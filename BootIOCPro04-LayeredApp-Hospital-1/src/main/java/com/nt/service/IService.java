package com.nt.service;

import java.util.List;

import com.nt.modal.Hospital;

public interface IService 
{
       public List<Hospital> getHospitalRecords(String c1, String c2) throws Exception;
}
