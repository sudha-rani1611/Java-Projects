package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.modal.Hospital;

@Component
public class DAO01 implements IDAO 
{

	private final String q = "select * from Hospital where city in(?,?)";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Hospital> getRecords(String c1, String c2) throws Exception
	{
		List<Hospital> li = new ArrayList<Hospital>();
		try(Connection con = ds.getConnection();
		    PreparedStatement ps = con.prepareStatement(q); 	
			)
		{
			ps.setString(1, c1);
			ps.setString(2, c2);
			try(ResultSet rs = ps.executeQuery())
			{
				while(rs.next())
				{
					Hospital h = new Hospital();
					h.setId(rs.getInt(1));
					h.setName(rs.getString(2));
					h.setSpeciality(rs.getString(3));
					h.setBeds(rs.getInt(4));
					h.setCity(rs.getString(5));
					
					li.add(h);
				}
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			System.out.println("Some Internal DB Problem");
		}
		catch(Exception e)
		{

			e.printStackTrace();
			System.out.println("Some Internal DB Problem");
		}
		return li;
	}

}
