import ResultPackage.Result;
import StudentPackage.RegisterStudent;
import java.util.*;
interface Student
    {
        void getDetails();
    }
class Details implements Student
{
    Scanner sc=new Scanner(System.in);
    String name,branch;
    public void getDetails()
    {
        System.out.println("Enter Student Name And Branch");
        name=sc.next();
        branch=sc.next();
    }
}
class Packages
{
    
    public static void main(String[] args)
    {
        Details d=new Details();
        d.getDetails();
        RegisterStudent r=new RegisterStudent();
        r.register();
        Result res=new Result();
        res.calcSGPA(r);
        res.calcCGPA();
    }
}