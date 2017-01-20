package javapack;
class Z
{
	void sum()
	{
		System.out.println("Default method");
	}
	void sum(int x,int y)
	{
		System.out.println("Sum of x & y is:"+(x+y));
	}
	void sum(int x,int y,int z)
	{
		System.out.println("Sum of x, y & z is:"+(x+y+y));
	}
}

public class methodOverloading {

	public static void main(String[] args) {
		Z b=new Z();
		b.sum();
		/*b.sum(10,20);
		b.sum(10, 20, 30);*/

	}

}
