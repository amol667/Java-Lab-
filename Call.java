import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
//can import java.util.*;
class Helper
{
    int i,z;
    ArrayList names = new ArrayList();
    ArrayList numbers = new ArrayList();
    ArrayList dates = new ArrayList();
    ArrayList savedNumbers = new ArrayList();
    ArrayList savedNames = new ArrayList();
    Date d;
    Scanner sc = new Scanner(System.in);
    Helper()
    {
        i=0;
        z=0;
    }
    public void delete(int n)
    {
        if(n<0||n>=i)
        {
            System.out.println("Invalid Input!");
            return;
        }
        names.remove(n);
        numbers.remove(n);
        dates.remove(n);
        i--;
    }
    public void giveMissCall(String number)
    {
        if(i>9)
        {
            delete(0);
            i=9;
        }
        numbers.add(i,number);
        d  = new Date();
        search(number);
        dates.add(i++,d);
    }
    public void display(int j)
    {
        if(i==0)
        {
            System.out.println("No Missed Calls To Show");
            return;
        }
        System.out.println(j+1+"."+numbers.get(j++));
        System.out.println("1.Delete Call 2.Go To Next Miss Call 3.Complete Call Details");
        int input=sc.nextInt();
        if(input==1)
            delete(j-1);
        else if(input==2)
        {
            if(j<i)
                display(j);
            else
                System.out.println("No More Missed Calls To Show");
        }
        else if(input==3)
            System.out.println("Number:"+numbers.get(j-1)+"\tName:"+names.get(j-1)+"\tTime:"+dates.get(j-1));
        else
            System.out.println("Invalid Input!");
    }
    public void addNos()
    {
        while(true)
        {
            System.out.println("Enter Name And Number");
            String name = sc.next();
            String number = sc.next();
            savedNames.add(z,name);
            savedNumbers.add(z++,number);
            System.out.println("1.Create More Contacts\t2.Exit");
            if(sc.nextInt()!=1)
                return;
        }
    }
    void search(String number)
    {
        Iterator itr = savedNumbers.iterator();
        int x=0;
        boolean flag = false;
        while(itr.hasNext())
        {
            Object temp = itr.next();
            if(number.equals(temp))
            {
                flag=true;
                break;
            }
            x++;
        }
        if(flag)
            names.add(i,savedNames.get(x));
        else
            names.add(i,"PRIVATE NUMBER");
    }
}
class Call
{
    public static void main(String[] args)
    {
        Scanner sc2 = new Scanner(System.in);
        Helper h = new Helper();
        System.out.println("Would You Wish To Create Some Contacts? If 'Yes' Press 1");
        if(sc2.nextInt()==1)
            h.addNos();
        while(true)
        {
            System.out.println("1.GiveMissCall\t2.Display\t3.DeleteParticularCall\t4.Exit");
            int g=sc2.nextInt();
            if(g==1)
            {
                System.out.println("Enter A Number");
                String p=sc2.next();
                h.giveMissCall(p);
            }
            else if(g==2)
            {
                h.display(0);
            }
            else if(g==3)
            {
                System.out.println("Enter The Call Number");
                int p=sc2.nextInt();
                h.delete(p-1);
            }
            else
                break;
        }
    }
}