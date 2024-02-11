package com.ashokit.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ashokit.entity.City;
import com.ashokit.entity.State;

public interface MyCollection {

	//static method
	public static Map<Integer,String> convertListToMap(List<Object[]> list){
		System.out.println("MyCollection.convertListToMap()");
		//java 8 stream API
		return list.stream().collect(Collectors.toMap(ob -> Integer.valueOf(ob[0].toString()), ob -> ob[1].toString()));
	}
	public static Map<Integer,String> convertListToMap2(List<State> list){
		System.out.println("MyCollection.convertListToMap()2");		
		//java 8 stream API
		return list.stream().collect(Collectors.toMap( State :: getStateId ,State :: getStateName ));
	}
	public static Map<Integer, String> convertListToMap3(List<City> list) {
		return list.stream().collect(Collectors.toMap(City :: getCityId, City :: getCityName ));
	}
	
}
