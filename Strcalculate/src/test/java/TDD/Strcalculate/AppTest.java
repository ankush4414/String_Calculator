package TDD.Strcalculate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//from Ankush have covered all the test case 
//with cases which give meaning to the calculator 
//The time complexity stands for O(n);
public class AppTest 
{
	StringCalculator sc=new StringCalculator();
    @Test
    public void test1()
    {	//case1:“” == 0 , “1” == 1 , “1,2” == 3
    	String number1="";
    	String number2="1";
    	String number3="1,2";
    	
    	int output,output1,output2;
    	output=sc.Add(number1);
    	output1=sc.Add(number2);
    	output2=sc.Add(number3);
    	
    	assertEquals(0, output);
    	assertEquals(1, output1);
    	assertEquals(3, output2);
    	
    }
    @Test
    public void test2()
    {//case2: unknown amount of numbers
    	String number1="10,20,30,40,50,100,999,";
    	int output;
    	output=sc.Add(number1);
    	assertEquals(1249, output);
    	
    }
    @Test
    public void test3()
    {//case3: new lines between numbers“1\n2,3”
    	String number1="1\\n2,3";
    	int output;
    	output=sc.Add(number1);
    	assertEquals(6, output);
    	
    }
    @Test
    public void test4()
    {//case4:Support different delimiters:”
    	String number1="//;\\n1;2";
    	int output;
    	output=sc.Add(number1);
    	assertEquals(3, output);
    	
    }
 
    @Test
    public void test5()
    {//case5:Calling Add with a negative number will throw an exception “negatives not allowed” -
    	String number1="1,-8,";
    	sc.Add(number1);
    	
    	
    }
    @Test
    public void test6()
    { // MULTIPLE NEGATIVE YET TO BE DONE 
    	String number1="1,-8,-7";
    	
    	sc.Add(number1);
    	
    	
    }
    @Test
    public void test7()
    { //  how many times Add() was invoked
    	
    	int output;
    	output=sc.GetCalledCount();
    	System.out.println("Add method was called "+output+" times");	
    }
    //test 8 for .net 
    @Test
    public void test9()
    { //  Numbers bigger than 1000 should be ignored,
    	String number1="1 + 1001";
    	int output;
    	output=sc.Add(number1);
    	
    	assertEquals(1, output);
    		
    }
    @Test
    public void test10()
    { //Delimiters can be of any length with the following format:“//[delimiter]\n” 
    	String number1="//[***]\\n1***2***3";
    	int output;
    	output=sc.Add(number1);
    	assertEquals(6, output);	
    }
    @Test
    public void test11()
    { //Allow multiple delimiters like this:“//[delim1][delim2]\n” 
    	String number1="//[*][%]\\n1*2%3";
    	int output;
    	output=sc.Add(number1);
    	assertEquals(6, output);	
    }
    @Test
    public void test12()
    { //make sure you can also handle multiple delimiters with length longer than one char“//[**][%%]\n1**2%%3” == 6. 
    	String number1="//[**][%%]\\n1**2%%3";
    	int output;
    	output=sc.Add(number1);
    	assertEquals(6, output);	
    }
    
    
    
    
    
}
