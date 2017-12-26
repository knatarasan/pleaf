package com.kara.datagen;
import java.util.*;

public class Feeder {
	
	public static void main(String st[]){
		System.out.println("** Welcome to DataGen application **");
		boolean mthreaded=false;
		
		WearableDataGenerator wdatagen=new WearableDataGenerator();
		System.out.println("This app would start with mthreaded : "+mthreaded);
		
		ArrayList generated=wdatagen.gen(10);
		Iterator it=generated.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}
