package com.nt.modal;

import java.io.Serializable;

import lombok.Data;

@Data
public class Hospital implements Serializable
{
   private Integer id;
   private String name;
   private String speciality;
   private Integer beds;
   private String city;
}
