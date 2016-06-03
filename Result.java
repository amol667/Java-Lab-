package ResultPackage;
import StudentPackage.RegisterStudent;
import java.util.*;
class InvalidCGPA extends Exception
{
    InvalidCGPA(float a)
    {
        System.out.println(a+":Exceeds 10!");
    }
}
public class Result
{
    Scanner sc=new Scanner(System.in);
    float sgpa;
    public void calcSGPA(RegisterStudent o)
    {
        sgpa=0;
        System.out.println("Enter Grades");
        for(int i=0;i<o.subno;i++)
        {
            System.out.println(o.subjects[i]+":");
            sgpa=sgpa+getGrade()*o.credits[i];
        }
        sgpa=sgpa/o.totCred;
        System.out.println("SGPA:"+sgpa);
    }
    public void calcCGPA()
    {
        float cgpa=0;
        System.out.println("Enter Your Semister");
        int sem=sc.nextInt();
        float temp=0;
        String sTemp;
        System.out.println("Enter SGPAs Of All The Sems:");
        if(sem>=4)
        {
        for(int i=0;i<sem;i++)
        {
            try
            {
                sTemp=sc.next();
                temp=Float.parseFloat(sTemp);
                try
                {
                    if(temp>10)
                        throw new InvalidCGPA(temp);
                }
                catch(InvalidCGPA p)
                {
                    System.out.println(p+"Invalid SGPA");
                    System.exit(0);
                }
            }
            catch(NumberFormatException n)
            {
                System.out.println("Invalid Number Format");
                System.exit(0);
            }
            cgpa=cgpa+temp;
            
        }
        cgpa=cgpa/sem;
        System.out.println("CGPA:"+cgpa);
        }
        else
        {
            System.out.println("Minimum Limit Is 4:");
            calcCGPA();
        }
    }
    int getGrade()
    {
        String s=sc.next();
        s=s.toUpperCase();
        switch(s.charAt(0))
        {
            case 'S':return 10;
            case 'A':return 9;
            case 'B':return 8;
            case 'C':return 7;
            case 'D':return 6;
            case 'E':return 5;
            default:System.out.println("Unable To Process!");
                System.exit(0);
                return 0;
        }
    }
}