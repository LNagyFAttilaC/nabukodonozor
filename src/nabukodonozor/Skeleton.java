package nabukodonozor;

public class Skeleton {
	private static int tab = 0; //tabul�torok sz�ma
	
	//objectName: az objektum neve
	//className: az objektum oszt�ly�nak neve
	//methodName: a megh�vott met�dus neve
	//methodParamsID: a megh�vott met�dus param�tereinek azonos�t�i egy t�mbben
	public static void entry(String objectName, String className, String methodName, String[] methodParamsID)
	{
		//tabul�tor(ok) ki�r�sa
		for (int i=1; i<=Skeleton.tab; i++)
		{
			System.out.print("\t");
		}
		
		//objektum:oszt�ly.met�dus
		System.out.print(objectName + ":" + className + "." + methodName);
		
		System.out.print("(");
		
		//param�tere ki�r�sa
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
	
	//returnValue: visszat�r�si �rt�k
	public static void exit(String returnValue)
	{
		Skeleton.tab--;
		
		//tabul�tor(ok) ki�r�sa
		for (int i=1; i<=Skeleton.tab; i++)
		{
			System.out.print("\t");
		}
		
		//visszat�r�si �rt�k ki�r�sa
		System.out.println("return " + returnValue);
	}
	
	public static void uc01()
	{
		System.out.println("uc01()");
	}
	
	public static void uc02()
	{
		System.out.println("uc02()");
	}
	
	public static void uc03()
	{
		System.out.println("uc03()");
	}
	
	public static void uc04()
	{
		System.out.println("uc04()");
	}
	
	public static void uc05()
	{
		System.out.println("uc05()");
	}
	
	public static void uc06()
	{
		System.out.println("uc06()");
	}
	
	public static void uc07()
	{
		System.out.println("uc07()");
	}
	
	public static void uc08()
	{
		System.out.println("uc08()");
	}
	
	public static void uc09()
	{
		System.out.println("uc09()");
	}
	
	public static void uc10()
	{
		System.out.println("uc10()");
	}
	
	public static void uc11()
	{
		System.out.println("uc11()");
	}
	
	public static void uc12()
	{
		System.out.println("uc12()");
	}
	
	public static void uc13()
	{
		System.out.println("uc13()");
	}
	
	public static void uc14()
	{
		System.out.println("uc14()");
	}
	
	public static void uc15()
	{
		System.out.println("uc15()");
	}
	
	public static void uc16()
	{
		System.out.println("uc16()");
	}
}
