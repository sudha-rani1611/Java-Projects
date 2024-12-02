package com.nt.dao;

import java.util.List;

import com.nt.modal.Hospital;

public interface IDAO 
{
     public List<Hospital> getRecords(String c1,String c2) throws Exception;
}
