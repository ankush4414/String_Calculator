package TDD.Strcalculate;

import java.util.ArrayList;

public class StringCalculator {
	static int count=0;				//to count how many times add method was called 
	ArrayList<Integer> negativenum = new ArrayList<Integer>();//negativenum to store negative values and later print them
	
	
	public int Add(String numbers)
	{	count++;
		String removesym= numbers.replaceAll("[^0-9|-]", ",");//main part:this regex remove all(except digits and minus symbol)characters 
														//and replaces with ","
		int sum=0;
		String[] arr = removesym.split(",");	//to split with comma
		
		try{							//to throw when negative no 
			for(String n:arr)
			{
		
				if(!n.isEmpty())		//may have spaces we neglet that 
				{
					int intnum=Integer.parseInt(n);//convert string to int 
					if(intnum<0)				//check for negative no if the skip
					{			
						
						negativenum.add(intnum);
					}
					if(intnum>1000)			//check condition no above 1000
					{
						continue;
					}

				}
				if(!n.isEmpty())
				{
					int intnum=Integer.parseInt(n);
					
					sum=sum+intnum;			//calculate the sum 
				}	

			}
			if(!negativenum.isEmpty())
				throw new MyException(negativenum);
	
	}

	catch(MyException e)		//catches and prints the msg
	{
	System.out.println("negatives not allowed");
	}
		return sum;
	}

	public int GetCalledCount()
	{	
		return count;
	}

}	
class MyException extends Exception
	{
		public MyException(ArrayList<Integer> negtivearray)
		{

				System.out.println(negtivearray);//printing the negative array value 
		}
}
