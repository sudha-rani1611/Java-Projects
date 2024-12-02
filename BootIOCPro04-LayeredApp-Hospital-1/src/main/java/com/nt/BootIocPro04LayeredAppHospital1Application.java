package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.HospitalController;
import com.nt.modal.Hospital;

@SpringBootApplication
public class BootIocPro04LayeredAppHospital1Application 
{

	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(BootIocPro04LayeredAppHospital1Application.class, args);
		HospitalController h = ctx.getBean("ctlr",HospitalController.class);
		
		System.out.println("Enter any 2 cities [Bidar,Hyderabad,Bengaluru,Chennai,Mumbai]");
		Scanner s = new Scanner(System.in);
		String c1 = s.next();
		String c2 = s.next();
		try
		{
			List<Hospital> l =h.getData(c1,c2);
			l.forEach((o)->{
				System.out.println(o);
				System.out.println();
			}
			);
		}
		catch(Exception e)
		{
			System.out.println("Failed To Fetch Records Try Again............");
		}
		s.close();
	}

}
