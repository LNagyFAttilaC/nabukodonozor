package nabukodonozor;

public class Skeleton {
	private static int tab = 0; //tabul�torok sz�ma
	
	//objectName: az objektum neve
	//className: az objektum oszt�ly�nak neve
	//methodName: a megh�vott met�dus neve
	//methodParamsID: a megh�vott met�dus param�tereinek azonos�t�i egy t�mbben
	public  static void entry(String objectName, String className, String methodName, String[] methodParamsID)
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
	public  static void exit(String returnValue)
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
}
