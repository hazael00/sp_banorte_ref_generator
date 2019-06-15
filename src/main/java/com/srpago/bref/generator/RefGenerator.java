package com.srpago.bref.generator;

import com.srpago.bref.utils.Constants;
import com.srpago.bref.utils.Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RefGenerator {

	public String generateReference(String ref,Date expirationDate,BigDecimal amount) {
		String formed =ref;
		String expDate= formatNumber(processDate(expirationDate),4);
		Integer rezisedAm = resizedAmount(amount);
		formed = formed + expDate;
		formed = formed + rezisedAm.toString();
		formed = formed + "2";
		Integer validDigits = validatorDigits(formed);
		formed = formed + formatNumber(validDigits,2);
		return formed;
	}
	
	public Integer processDate(Date expDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(expDate);
		Integer year,month,day;
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		//como calendar regresa el mes empezando con 0 enero se agrega 1
		month++;
		day = cal.get(Calendar.DAY_OF_MONTH);
		//primero restar el año
		Integer substractedYear = year - Constants.SUBSTRAC_TO_YEAR;
		substractedYear*=372;
		//el mes
		Integer substractedMonth = month -1;
		substractedMonth*=31;
		//el dia
		day-=1;
		Integer condensedDate = substractedYear+ substractedMonth +day;
		return condensedDate;
	}
	
	public Integer resizedAmount(BigDecimal amount) {
		Integer digits;
		Integer sum=0;
		amount.setScale(2,BigDecimal.ROUND_HALF_UP);
		DecimalFormat df = new DecimalFormat("###,###.##");
		String result = df.format(amount);
		System.out.println("numero convertido:"+result);
		digits = result.length();
		//invertir la lista
		List<String> numbers = Utils.stringToList(result);
		Collections.reverse(numbers);
		//ahora iterar el numero
		for(int i=0;i<digits;i++) {
			String n = numbers.get(i);
			if(n.equals(",") || n.equals(".")){
				continue;
			}
			Integer numEq = Constants.amountEqvOrder[i%3];
			Integer currentNumber = Integer.parseInt(n);
			sum+=(numEq*currentNumber);
		}
		
		return sum%10;
	}
	
	public String formatNumber(Integer number,Integer expectedLength) {
		String formatted = number.toString();
		while(formatted.length()<expectedLength) {
			formatted = "0"+formatted;
		}
		
		return formatted;
	}
	
	public Integer validatorDigits(String finalStr) {
		Integer sum = 0;
		List<String> stringList = Utils.stringToList(finalStr);
		Collections.reverse(stringList);
		for(int i=0;i<stringList.size();i++) {
			if(!Constants.LETTER_NUMBER_EQV.containsKey(stringList.get(i))) {
				continue;
			}
			Integer num = Constants.LETTER_NUMBER_EQV.get(stringList.get(i));
			Integer toAdd = num * Constants.pounders[i];
			sum+=toAdd;
		}
		sum+=330;
		Integer remaining = sum % 97;
		return ++remaining;
	}
	
	
}
