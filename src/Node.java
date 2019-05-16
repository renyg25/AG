
public class Node<T> {
	public void A(Object obj)
	{
		System.out.println("obj");
	}
	
	public void A(Node n)
	{
		System.out.println("node");
	}
	
	
	public boolean equals(Object o)
	{
		System.out.println("equals o");
		return false;		
	}
	
	public String equals(Double o)
	{
		System.out.println("equals o");
		return "";		
	}
	
	public T equals()
	{
		return null;		
	}
	
	/*
	public boolean equals(Node<T> n)
	{
		System.out.println("equals n");
		return false;
	}*/
	
	public boolean equals(Node<String> n)
	{
		System.out.println("equals n");
		return false;
	}

	public boolean equals(String n)
	{
		System.out.println("equals string");
		return false;
	}
}
