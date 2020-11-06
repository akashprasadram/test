
package com.fresco;



public class Aided extends Student{

    
    
    public String result(String allMarks) {
        
      String str[]=allMarks.split("|");
      String subject[]=str[0].split(",");
      String Ncc[]=str[1].split(",");
      String sports=str[2].split(",");
      int creditpoint=0;
      int gradepoint=0;
      for(int i=0;i<subject.length;i++)
      {
        String individulaSubject[]=subject[i].split(" ");
        gradepoint=gradepoint+(GradePoint(Integer.parseInt(individulaSubject[0]))*Integer.parseInt(individulaSubject[1]));
        creditpoint=creditpoint+Integer.parseInt(individulaSubject[1]);
      }
      for(int i=0;i<Ncc.length;i++)
      {
        if(!Ncc[0].equals("0"))
        {
          gradepoint=gradepoint+(GradePoint(Integer.parseInt(Ncc[0]))*Integer.parseInt(Ncc[1]));
          creditpoint=creditpoint+Integer.parseInt(Ncc[1]);
        }
      }
      for(int i=0;i<ports.length;i++)
      {
        if(!sports[0].equals("0"))
        {
          gradepoint=gradepoint+(GradePoint(Integer.parseInt(sports[0]))*Integer.parseInt(sports[1]));
          creditpoint=creditpoint+Integer.parseInt(sports[1]);
        }
      }
      DecimalFormat df=new DecimalFormat("#.##");
      df.setRoundingMode(RoundingMode.CEILING);
      String st=df.format(gradepoint/creditpoint);
      return st;
		
    }
   
}
