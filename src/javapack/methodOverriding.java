package javapack;
class P
{
	void show()
	{
		System.out.println("Parent show method");
	}
}
class Q extends P
{
	void show()
	{
		System.out.println("child show method");
	}
}

public class methodOverriding {

	public static void main(String[] args) {
		Q b=new Q();
		b.show();

	}

}
