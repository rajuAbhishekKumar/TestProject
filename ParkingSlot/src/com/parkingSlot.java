package com;
import com.slotInfo;
import java.util.ArrayList;
import java.util.Collections;

public class parkingSlot {
	
	public static int count,totalNumberOfSlots = 0;
	ArrayList<slotInfo> list=new ArrayList<slotInfo>();
	ArrayList<Integer> freelist = new ArrayList<Integer>();
	
	public void parkingLot(int n) {
		
		totalNumberOfSlots =n;
		System.out.println("Created parking lot with "+ n +" slots");
		
	}
	
	public void allotParking(String reg , String color ) {
		
		if(freelist.size()>0) {
		int minIndex = freelist.indexOf(Collections.min(freelist));
		int minSlotValue=(freelist.get(minIndex));
		
		slotInfo SI = new slotInfo();
		SI.setColour(color);
		SI.setRegNo(reg);
		list.add(SI);
		count++;
		SI.setSlotNo(minSlotValue);
		freelist.remove(minIndex);
		System.out.println("Allocated Slot number: "+SI.getSlotNo());
		return;
		}
		if(count+1<=totalNumberOfSlots) {
			
					
			slotInfo SI = new slotInfo();
			SI.setColour(color);
			SI.setRegNo(reg);
			list.add(SI);
			count++;
			SI.setSlotNo(count);
			System.out.println("Allocated Slot number: "+SI.getSlotNo());
			
				
		}else {
			System.out.println("Sorry,Parking lot is full");
		}
	    
	}
	
	
	public void dellotSlot(int slotNumber) {

		list.remove(slotNumber-1);
		count--;
		System.out.println("Slot number "+slotNumber+" is free");
		freelist.add(slotNumber);
		}
	
	public void displayFullList() {
		
		System.out.println("Slot No. Registration_Number  Colour");
		for(slotInfo si : list) {
			System.out.println(si.getSlotNo()+"        "+si.getRegNo()+"        "+si.getColour());
			
		}
	 
	} 
	
	public void displayRegNoBasedOnColours(String colour) {
		for(slotInfo si: list) {
			if(si.getColour()==colour) {
				System.out.print(si.getRegNo()+" ");
			}
		}
		
	}
	
	public void slotBasedOnColours(String colour) {
		System.out.println();
      		for(slotInfo si: list) {
			if(si.getColour()==colour) {
				System.out.print(si.getSlotNo()+" ");
			}
		}
	}
	
	public void slotNumberForRegistration(String regNo) {
		System.out.println();
  		for(slotInfo si: list) {
		if(si.getRegNo()==regNo) {
			System.out.print(si.getSlotNo()+" ");
			return;
		}
	 }
			System.out.println("Not found");
			return;
			
	}
	
	
	public static void main(String[] args) {
		

		parkingSlot PS = new parkingSlot();
		PS.parkingLot(6);
		
		PS.allotParking("KA-01-HH-1234", "white");
		PS.allotParking("KA-01-HH-9999", "white");
		PS.allotParking("KA-01-BB-0001", "black");
		PS.allotParking("KA-01-HH-7777", "red");
		PS.allotParking("KA-01-HH-2701", "blue");
		PS.allotParking("KA-01-HH-3141", "black");
		
		PS.dellotSlot(4);//leave 4
		PS.displayFullList();//status
		PS.allotParking("KA-01-P-333", "white");
		PS.allotParking("DL-12-AA-9999", "white");

		PS.displayRegNoBasedOnColours("white");
		PS.slotBasedOnColours("white");
		PS.slotNumberForRegistration("KA-01-HH-3141");
		PS.slotNumberForRegistration("MH-04-AY-1111");

	}

}
