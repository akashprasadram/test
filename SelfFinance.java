public class SelfFinance extends Student{

    public String result(String allMarks) {
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
		for(int i=0;i<sports.length;i++)
		{
			if(!sports[0].equals("0"))
			{
				gradepoint=gradepoint+(GradePoint(Integer.parseInt(sports[0]))*Integer.parseInt(sports[1]));
				creditpoint=creditpoint+5;
			}
		}
		DecimalFormat df=new DecimalFormat("#.##");
		String st=df.format(gradepoint/creditpoint);
		return st;
		
	}
}
