package com.kara.datagen;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class WearableDataGenerator {
/*
 * This class is responsible to generate data with an argument of number of subscribers
 */
	
	
/*
 * row : timeStamp deviceId personId pulseRate breathRate
 * 
 * http://www.heart.org/HEARTORG/HealthyLiving/PhysicalActivity/FitnessBasics/Target-Heart-Rates_UCM_434341_Article.jsp#
 * The figures are averages, so use them as general guidelines.
 
Age	Target HR Zone 50-85%	Average Maximum Heart Rate, 100%
20 years	100-170 beats per minute	200 beats per minute
30 years	95-162 beats per minute	190 beats per minute
35 years	93-157 beats per minute	185 beats per minute
40 years	90-153 beats per minute	180 beats per minute
45 years	88-149 beats per minute	175 beats per minute
50 years	85-145 beats per minute	170 beats per minute
55 years	83-140 beats per minute	165 beats per minute
60 years	80-136 beats per minute	160 beats per minute
65 years	78-132 beats per minute	155 beats per minute
70 years	75-128 beats per minute	150 beats per minute

 */
	
	String timeStamp;
	String deviceId="fitbit-one-"+"00000";
	String personId="person-40-"+"00000";
	ArrayList row=new ArrayList();
	Random rand=new Random();
	int pulserate=0;
	
	public ArrayList gen(int num){
		Calendar cal=new GregorianCalendar();
		timeStamp=""+cal.getTimeInMillis();
		
		for(int i=0;i<num;i++){

			pulserate=ThreadLocalRandom.current().nextInt(90,110);
			row.add(
						timeStamp+","
						+deviceId+Integer.toString(i)+","
						+personId+Integer.toString(i)+","
						+pulserate);
		}
		return row;
	}
}
