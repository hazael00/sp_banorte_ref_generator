package com.srpago.bref.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
	
	public static String fillString(String s,Integer size) {
		if(s==null)
			return null;
		String newS = s;
		for(int i=0;i<size;i++) {
			newS= " "+newS;
		}
		return newS;
	}

	public  static <T> List<T> revertList(List<T> list){
		if(list==null) {
			return null;
		}
		List<T> clonList=null ;
		Collections.copy(clonList, list);
		Collections.reverse(clonList);
		return clonList;
	}
	
	public static List<String> stringToList(String s){
		if(s==null)
			return null;
		List<String> list = new ArrayList<String>();
		for(int i=0;i<s.length();i++) {
			list.add(String.valueOf(s.charAt(i)));
		}
		return list;
	}
}
