package TDD.Strcalculate;

import java.util.ArrayList;

public class StringCalculator {
	static int count=0;
	public int Add(String numbers)
	{		count++;
			String no= numbers.replaceAll("[^0-9]", "");
			int sum=0;
			if(numbers.length()<=0)return 0;	

			for(int i=0;i<no.length();i++)
			{		
				int num = Character.getNumericValue(no.charAt(i));
				sum=sum+num;	
			}	
			return sum;
	}

	public int GetCalledCount()
	{	
		return count;
	}

	public int Add2(String str)
	{	count++;
		ArrayList<Integer> neg = new ArrayList<Integer>();
		int sum=0;
		try {
				str = str.replaceAll("\\s", "");
				String[] arr = str.split("\\+|,");
			for(String s:arr)
			{	int a=Integer.parseInt(s);
				if(a>=1000)
				{
					continue;
				}
				if(a<0)
				{			
					neg.add(a);
				}
				sum=sum+a;		
			}
			if(!neg.isEmpty())
				throw new MyException(neg);
		}
		catch(MyException e)
		{
		System.out.println("negatives not allowed");
		}	
		return sum;
	}
}
class MyException extends Exception
{
public MyException(ArrayList<Integer> neg)
{

System.out.println(neg);
}
}