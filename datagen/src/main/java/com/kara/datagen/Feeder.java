package com.kara.datagen;
import java.util.*;
import java.io.*;

public class Feeder {
	
	public static int debug=0;  // 0 - no debug, 1-info , 2 - verbose
	public static boolean mthreaded=false;
	
	public static void main(String st[]){
		System.out.println("** Welcome to DataGen application **");
		System.out.println("This app would start with mthreaded : "+mthreaded);
		
		int numOfSubscribers=10;
		int portNumber=9088;
		
		if(st.length!=2){
			System.out.println("Please supply numOfSubcribers,portNumber");
		}else{
			numOfSubscribers=Integer.parseInt(st[0]);
			portNumber=Integer.parseInt(st[1]);
		}
		Feeder feed=new Feeder();
		WearableDataGenerator wdatagen=new WearableDataGenerator();
		
		ArrayList generated=wdatagen.gen(numOfSubscribers);
		System.out.println("Num of rows generated:"+generated.size());

		DataFeedOutChannel feedOut=new DataFeedOutChannel(portNumber);
		feed.writeOutput(feedOut.pw,generated);
		
		feedOut.conclude();
	}
	
	public void writeOutput(PrintWriter pw,ArrayList generated){

			if (this.debug ==1){
				System.out.println(generated.size());
			}else if(this.debug == 2){
				System.out.println(generated.size());
			}
			
			Iterator it=generated.iterator();
			while(it.hasNext()){
				//pw.write(it.next());
				System.out.println("Here "+it.next());
			}
	}
	
}
