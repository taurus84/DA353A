package readWrite;

public class Person
{
	public String a;
	public int b;
	public float c;
	public String d;
	
	
	public Person(String a_, int b_, float c_, String d_)
	{
		a = a_;
		b = b_;
		c = c_;
		d = d_;
	}
	
	public String toString()
	{
		return a + " "+ b + " " + c + " " + d;
	}
}
