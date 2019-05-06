package com.steveneck.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoomServices {
	 private static List<Room> rooms = new ArrayList<>();

	    static{
	        for(int i=0;i<10;i++){
	            rooms.add(new Room(i, "Room " + i, "R"+i, "King Size"));
	        }
	    }
	    
	   

		public List<Room> getAllRooms() {
			// TODO Auto-generated method stub
			return rooms;
		}
	
}
