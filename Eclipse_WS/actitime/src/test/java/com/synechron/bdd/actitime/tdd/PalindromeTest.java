package com.synechron.bdd.actitime.tdd;



import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

	Palindrome p = null;
	
	@Before
	public void setup()
	{
		p = new Palindrome();
	}
	
	@Test
	public void testValidPalindrome()
	{
		assertTrue(p.isPalindrome("nitin"));
	}
	
	@Test
	public void testInvalidPalindrom()
	{
	//	assertFalse(p.isPalindrome("ABC"));
	}
	
	@Test
	public void testEmptyString()
	{
	//	assertFalse(p.isPalindrome(""));
	}
	
	@Test
	public void testNullString()
	{
		String str = null;
//		assertFalse(p.isPalindrome(str));
	}
	
	
}
