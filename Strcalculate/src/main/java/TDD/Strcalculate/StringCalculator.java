package TDD.Strcalculate;

import java.util.ArrayList;

public class StringCalculator {
	static int count=0;
	StringCalculator()
	{
		count+=1;
	}
	public int Add(String numbers)
	{
			String no= numbers.replaceAll("[^0-9]", "");
			int sum=0;
			if(no.length()<=0)return 0;	

			for(int i=0;i<no.length();i++)
			{
			
				int num = Character.getNumericValue(no.charAt(i));
				sum=sum+num;	
				
			}
			
			return sum;
	}
}


