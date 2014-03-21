package nabukodonozor;

public class Skeleton {
	private static int tab = 0; //tabulátorok száma
	
	//objectName: az objektum neve
	//className: az objektum osztályának neve
	//methodName: a meghívott metódus neve
	//methodParamsID: a meghívott metódus paramétereinek azonosítói egy tömbben
	public  static void entry(String objectName, String className, String methodName, String[] methodParamsID)
	{
		//tabulátor(ok) kiírása
		for (int i=1; i<=Skeleton.tab; i++)
		{
			System.out.print("\t");
		}
		
		//objektum:osztály.metódus
		System.out.print(objectName + ":" + className + "." + methodName);
		
		System.out.print("(");
		
		//paramétere kiírása
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
	
	//returnValue: visszatérési érték
	public  static void exit(String returnValue)
	{
		Skeleton.tab--;
		
		//tabulátor(ok) kiírása
		for (int i=1; i<=Skeleton.tab; i++)
		{
			System.out.print("\t");
		}
		
		//visszatérési érték kiírása
		System.out.println("return " + returnValue);
	}
}
