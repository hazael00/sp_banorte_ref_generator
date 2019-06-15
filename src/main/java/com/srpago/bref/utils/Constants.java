package com.srpago.bref.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final Integer SUBSTRAC_TO_YEAR = 2013;
	
	public static final Integer[] amountEqvOrder = {7,3,1};
 	
	public static final Integer[] pounders = {0,13,17,19,23,11,13,17,19,23,11,13,17,19,23,11,13,17};

	public static final Map<String,Integer> LETTER_NUMBER_EQV;
	static {
		LETTER_NUMBER_EQV = new HashMap<String,Integer>();
		LETTER_NUMBER_EQV.put("A",1);
		LETTER_NUMBER_EQV.put("B",2);
		LETTER_NUMBER_EQV.put("C",3);
		LETTER_NUMBER_EQV.put("D",4);
		LETTER_NUMBER_EQV.put("E",5);
		LETTER_NUMBER_EQV.put("F",6);
		LETTER_NUMBER_EQV.put("G",7);
		LETTER_NUMBER_EQV.put("H",8);
		LETTER_NUMBER_EQV.put("I",9);
		LETTER_NUMBER_EQV.put("J",1);
		LETTER_NUMBER_EQV.put("K",2);
		LETTER_NUMBER_EQV.put("L",3);
		LETTER_NUMBER_EQV.put("M",4);
		LETTER_NUMBER_EQV.put("N",5);
		LETTER_NUMBER_EQV.put("O",6);
		LETTER_NUMBER_EQV.put("P",7);
		LETTER_NUMBER_EQV.put("Q",8);
		LETTER_NUMBER_EQV.put("R",9);
		LETTER_NUMBER_EQV.put("S",2);
		LETTER_NUMBER_EQV.put("T",3);
		LETTER_NUMBER_EQV.put("U",4);
		LETTER_NUMBER_EQV.put("V",5);
		LETTER_NUMBER_EQV.put("W",6);
		LETTER_NUMBER_EQV.put("X",7);
		LETTER_NUMBER_EQV.put("Y",8);
		LETTER_NUMBER_EQV.put("Z",9);
		LETTER_NUMBER_EQV.put("1",1);
		LETTER_NUMBER_EQV.put("2",2);
		LETTER_NUMBER_EQV.put("3",3);
		LETTER_NUMBER_EQV.put("4",4);
		LETTER_NUMBER_EQV.put("5",5);
		LETTER_NUMBER_EQV.put("6",6);
		LETTER_NUMBER_EQV.put("7",7);
		LETTER_NUMBER_EQV.put("8",8);
		LETTER_NUMBER_EQV.put("9",9);
		LETTER_NUMBER_EQV.put("0",0);
	}
}
