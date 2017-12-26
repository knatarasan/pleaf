package com.kara.datagen;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.*;

public class WearableDataGenerator {

/*
 * row : timeStamp deviceId personId pulseRate breathRate
 */
	
	String timeStamp;
	String deviceId="fitbit-one-"+"000001";
	String personId="person-A-"+"000001";
	ArrayList row=new ArrayList();

	public ArrayList gen(int num){
		
		for(int i=0;i<num;i++){
			Calendar cal=new GregorianCalendar();
			timeStamp=""+cal.getTimeInMillis();
			row.add(timeStamp+","+deviceId+","+personId);
			
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
		}
		return row;
	}
}
