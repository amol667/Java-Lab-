package StudentPackage;
import java.util.*;
class CreditLimit extends Exception
{
    CreditLimit(int s)
    {
        System.out.println("Credit Limit Exceded!!"+s);
    }
}
public class RegisterStudent
{
    Scanner sc=new Scanner(System.in);
    public int[] credits=new int[10];
    public int totCred,subno;
    public String[] subjects=new String[10];
    public void register()
    {
        totCred=0;
        System.out.println("Enter The No Of Subjects");
        subno=sc.nextInt();
        
        for(int i=0;i<subno;i++)
        {
            System.out.println("Enter Subject And Credits:");
            subjects[i]=sc.next();
            try
            {
                credits[i]=sc.nextInt();
                totCred=totCred+credits[i];
                if(totCred>30)
                    throw new CreditLimit(totCred);
            }
            catch(CreditLimit c)
            {
                System.out.println("Re-Register");
                register();
                break;
            }
        }
        
        
    }
}