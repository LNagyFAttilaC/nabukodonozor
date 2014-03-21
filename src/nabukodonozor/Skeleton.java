package nabukodonozor;

public class Skeleton
{
	private static int tab = 0; //tabulatorok szama
	
	//objectName: az objektum neve
	//className: az objektum osztalyanak neve
	//methodName: a meghivott metodus neve
	//methodParamsID: a meghivott metodus parametereinek azonositoi egy tombben
	public static void entry(String objectName, String className, String methodName, String[] methodParamsID)
	{
		//tabulator(ok) kiirasa
		for (int i=1; i<=Skeleton.tab; i++)
		{
			System.out.print("\t");
		}
		
		//objektum:osztaly.metodus kiirasa
		System.out.print(objectName + ":" + className + "." + methodName);
		
		System.out.print("(");
		
		//parameterek kiirasa
		for (int i=0; i<methodParamsID.length; i++)
		{
			System.out.print(methodParamsID[i]);
			
			if (i<methodParamsID.length-1)
			{
				System.out.print(", ");
			}
		}
		
		System.out.println(")");
		
		Skeleton.tab++;
	}
	
	//returnValue: visszateresi ertek
	public static void exit(String returnValue)
	{
		Skeleton.tab--;
		
		//tabulator(ok) kiirasa
		for (int i=1; i<=Skeleton.tab; i++)
		{
			System.out.print("\t");
		}
		
		//visszateresi ertek kiirasa
		System.out.println("return " + returnValue);
	}
	
	public static void sd01()
	{
		System.out.println("sd01()");
	}
	
	public static void sd02()
	{
		System.out.println("sd02()");
	}
	
	public static void sd03()
	{
		System.out.println("sd03()");
	}
	
	public static void sd04()
	{
		System.out.println("sd04()");
	}
	
	public static void sd05()
	{
		System.out.println("sd05()");
	}
	
	public static void sd06()
	{
		System.out.println("sd06()");
	}
	
	public static void sd07()
	{
		System.out.println("sd07()");
	}
	
	public static void sd08()
	{
		System.out.println("sd08()");
	}
	
	public static void sd09()
	{
		System.out.println("sd09()");
	}
	
	public static void sd10()
	{
		System.out.println("sd10()");
	}
	
	public static void sd11()
	{
		System.out.println("sd11()");
	}
	
	public static void sd12()
	{
		System.out.println("sd12()");
	}
	
	public static void sd13()
	{
		System.out.println("sd13()");
	}
	
	public static void sd14()
	{
		System.out.println("sd14()");
	}
	
	public static void sd15()
	{
		System.out.println("sd15()");
	}
	
	public static void sd16()
	{
		System.out.println("sd16()");
	}
}
