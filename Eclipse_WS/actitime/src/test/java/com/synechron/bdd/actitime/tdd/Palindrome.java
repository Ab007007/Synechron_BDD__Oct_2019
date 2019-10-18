package com.synechron.bdd.actitime.tdd;

public class Palindrome {
	
	
	public boolean isPalindrome(String str)
	{
		
		
		if(str==null)
		{
			return false;
		}
		StringBuffer sb = new StringBuffer(str);
		if(str.length()!=0 )
		{
			if(sb.toString().equals(sb.reverse().toString()))
			{
				System.out.println("Valid");
				return true;
			}
			else
			{
				System.out.println("Invalid");
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}

}
