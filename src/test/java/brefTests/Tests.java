package brefTests;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.srpago.bref.generator.RefGenerator;

import junit.framework.Assert;

public class Tests {
	
	RefGenerator generator;
	
	@Before
	public void init() {
		generator=new RefGenerator();
	}
	
	@Test
	public void testSampleDateEncoding() {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 6, 15);
		Integer resultantNumber= generator.processDate(cal.getTime());
		System.out.println("El numero resultante es:"+generator.formatNumber(resultantNumber, 4));
		Assert.assertEquals(resultantNumber,new Integer(572));
	}
	
	@Test
	@Ignore
	public void testDateEncoding() {
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 5, 16);
		Integer resultantNumber= generator.processDate(cal.getTime());
		String formated = generator.formatNumber(resultantNumber, 4);
		System.out.println("El numero resultante es:"+ formated);
		Assert.assertEquals(resultantNumber,new Integer(4115));
	}
	
	@Test
	public void testAmountEncoding() {
		BigDecimal amountEncoded = new BigDecimal(250);
		Integer resultantAmount = generator.resizedAmount(amountEncoded);
		Assert.assertEquals(new Integer(7), resultantAmount);
	}
	
	
	@Test 
	public void testValidatorDigits() {
		String testString = "999999999999057272";
		Integer expected = 43;
		Integer gotten =generator.validatorDigits(testString);
		Assert.assertEquals(expected,gotten);
	}
	
	
	@Test
	public void testRefGeneration() {
		String ref = "999999999999";
		BigDecimal amount = new BigDecimal(250);
		
		String expected = "99999999999905727243";
		Calendar cal = Calendar.getInstance();
		cal.set(2014,6, 15);
		String actual = generator.generateReference(ref, cal.getTime(), amount);
		Assert.assertEquals(expected, actual);
	}
}
