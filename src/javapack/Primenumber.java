package javapack;

public class Primenumber {
public boolean isPrimeNumber()
{
	
      int i,n,num=100;
     for(i=1;1<num/2;i++)
    {
	if(num%i == 0)
	{
		return  false;
	}
    }
	return true;
}
public static void main(String[] args) 
{

System.out.println("is 15 prime number?");
	}

}
