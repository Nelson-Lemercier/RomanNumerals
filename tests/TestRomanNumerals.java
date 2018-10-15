import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.AssertionFailedError;

public class TestRomanNumerals {
	
	
	//---------------------------------------------------
	//Simple tests : one letter

	@Test
	public void test_I() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(1, rn.letterValue('I'));
	}
	
	@Test
	public void test_V() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(5, rn.letterValue('V'));
	}
	
	@Test
	public void test_X() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(10, rn.letterValue('X'));
	}
	
	@Test
	public void test_L() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(50, rn.letterValue('L'));
	}
	
	@Test
	public void test_C() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(100, rn.letterValue('C'));
	}
	
	@Test
	public void test_D() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(500, rn.letterValue('D'));
	}
	
	@Test
	public void test_M() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(1000, rn.letterValue('M'));
	}
	
	//---------------------------------------------------
	// The symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row
	
	// I
	
	@Test
	public void test_I_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("II"));
	}
	
	@Test
	public void test_I_three_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("III"));
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_I_four_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_IXCM_3_times("IIII");
	}
	
	//____________________________________
	
	// X
	
	@Test
	public void test_X_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("XX"));
	}
	
	@Test
	public void test_X_three_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("XXX"));
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_X_four_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_IXCM_3_times("XXXX");
	}
	
	//____________________________________
	
	// C
	
	@Test
	public void test_C_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("CC"));
	}
	
	@Test
	public void test_C_three_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("CCC"));
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_C_four_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_IXCM_3_times("CCCC");
	}
	
	//____________________________________
	
	// M
	
	@Test
	public void test_M_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("MM"));
	}
	
	@Test
	public void test_M_three_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_IXCM_3_times("MMM"));
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_M_four_times() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_IXCM_3_times("MMMM");
	}
	
	//---------------------------------------------------
	// The symbols 'V', 'L' and 'D' can never be repeated
	
	@Test(expected = RomanNumeralsException.class)
	public void test_V_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_VLD_Once("VV");
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_L_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_VLD_Once("LL");
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_D_twice() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_VLD_Once("DD");
	}

	//---------------------------------------------------
	// The '1' symbols ('I', 'X', and 'C') can only be subtracted from the next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM')

	@Test
	public void test_IV() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_substraction_rule("IV"));
	}
	
	@Test
	public void test_IX() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_substraction_rule("IX"));
	}
	
	@Test
	public void test_XL() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_substraction_rule("XL"));
	}
	
	@Test
	public void test_XC() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_substraction_rule("XC"));
	}
	
	@Test
	public void test_CD() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_substraction_rule("CD"));
	}
	
	@Test
	public void test_CM() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_substraction_rule("CM"));
	}
	
	//---------------------------------------------------
	// Only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not)
	
	@Test
	public void test_1_substraction() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.check_one_substraction("XC"));
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_2_substraction() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_one_substraction("XXC");
	}
	
	//---------------------------------------------------
	// The '5' symbols ('V', 'L' and 'D') can never be subtracted
	
	@Test(expected = RomanNumeralsException.class)
	public void test_V_substraction() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_substraction_rule("VX");
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_L_substraction() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_substraction_rule("LC");
	}
	
	@Test(expected = RomanNumeralsException.class)
	public void test_D_substraction() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.check_substraction_rule("DM");
	}
	
	//---------------------------------------------------
	// Test inputs
	
	@Test
	public void test_correct_input() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(true, rn.checkInput("MCMLXXXIV"));
	}
		
	@Test(expected = RomanNumeralsException.class)
	public void test_wrong_input() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		rn.checkInput("X12XC");
	}

	//---------------------------------------------------
	// Test convertToInteger
	
	@Test
	public void convertToInteger1() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(1984, rn.convertToInteger("MCMLXXXIV"));
	}
	
	@Test
	public void convertToInteger2() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(2014, rn.convertToInteger("MMXIV"));
	}
	
	@Test
	public void convertToInteger3() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(666, rn.convertToInteger("DCLXVI"));
	}
	
	@Test
	public void convertToInteger4() throws RomanNumeralsException {
		RomanNumerals rn = new RomanNumerals();
		assertEquals(1515, rn.convertToInteger("MDXV"));
	}
	
}
