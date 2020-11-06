import java.util.*;
import java.text.*;

public class Main{
	public static void main(String args[])
	{
		SelfFinance obj1=new SelfFinance();
		Aided obj2=new Aided();
		/*String result=obj.result("100 5,100 2,100 5|0,100,5|1,100,5");
		System.out.println("result="+result);*/

		String result1=obj1.result("100 5,100 5,53 5,76 3|0,100,5|0,100,5");
		System.out.println("result="+result1);

		String result2=obj2.result("100 5,100 5,100 5|1,100,5|0,100,5");
		System.out.println("result="+result2);
	}
}

class Aided extends Student{
    public String result(String allMarks) {
        
      System.out.println("Input: "+allMarks);
      String str[]=allMarks.split("\\|");
      String subject[]=str[0].split(",");
      String Ncc[]=str[1].split(",");
      String sports[]=str[2].split(",");
      double creditpoint=0;
      double gradepoint=0;
      for(int i=0;i<subject.length;i++)
      {
        String individulaSubject[]=subject[i].split(" ");
		gradepoint=gradepoint+(GradePoint(Integer.parseInt(individulaSubject[0]))*Integer.parseInt(individulaSubject[1]));
		creditpoint=creditpoint+5;
      }

        if(Ncc[0].equals("1"))
        {
          gradepoint=gradepoint+(GradePoint(Integer.parseInt(Ncc[1]))*Integer.parseInt(Ncc[2]));
          creditpoint=creditpoint+5;
        }


        if(sports[0].equals("1"))
        {
          gradepoint=gradepoint+(GradePoint(Integer.parseInt(sports[1]))*Integer.parseInt(sports[2]));
          creditpoint=creditpoint+5;
        }

      double result=gradepoint/creditpoint;
      DecimalFormat df=new DecimalFormat("0.00");
      String st=df.format(result);
      return st;
		
    }
   
}


class SelfFinance extends Student{

    public String result(String allMarks) {
		
    	System.out.println("Input: "+allMarks);
		String[] str=allMarks.split("\\|");
		String subject[]=str[0].split(",");
		String Ncc[]=str[1].split(",");
		String sports[]=str[2].split(",");
		double creditpoint=0;
		double gradepoint=0;
		
		for(int i=0;i<subject.length;i++)
		{
			String individulaSubject[]=subject[i].split(" ");
			gradepoint=gradepoint+(GradePoint(Integer.parseInt(individulaSubject[0]))*Integer.parseInt(individulaSubject[1]));
			creditpoint=creditpoint+5;
		}

			if(!sports[0].equals("0"))
			{
				gradepoint=gradepoint+(GradePoint(Integer.parseInt(sports[1]))*Integer.parseInt(sports[2]));
				creditpoint=creditpoint+5;
			}

      double result=gradepoint/creditpoint;
      DecimalFormat df=new DecimalFormat("0.00");
      String st=df.format(result);
		return st;
	}
}



abstract class Student {

	//Write your code. Use this class as abstract class.
	public abstract String result(String MarksOfStudent);
	public double GradePoint(int mark)
	{
		double grade=0;
		if(mark<40)
		{
			grade=0;
		}
		else if(mark>=40 && mark<=49)
		{
			if(mark==40)
				grade=6.0;
			else if(mark==49)
				grade=6.9;
			else
				grade=6.0+(0.1*(mark-40));
		}
		else if(mark>=50 && mark<=59)
		{
			if(mark==50)
				grade=7.0;
			else if(mark==59)
				grade=7.9;
			else
				grade=7.0+(0.1*(mark-50));
		}
		else if(mark>=60 && mark<=74)
		{
			if(mark==60)
				grade=8.0;
			else if(mark==74)
				grade=8.9;
			else
				grade=8.0+((0.1/(1.5))*(mark-60));
		}
		else if(mark>=75 && mark<=100)
		{
			if(mark==75)
				grade=9.0;
			else if(mark==100)
				grade=10.0;
			else
				grade=9.0+((0.1/(2.36))*(mark-75));
		}
		//return grade;
		DecimalFormat df=new DecimalFormat("#.#");
		double ans=Double.parseDouble(df.format(grade));
		return ans;
	}

}
