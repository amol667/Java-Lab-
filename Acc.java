import java.util.*;

class Account
{
    int accno,phno;
    String name;
    float blcamt;
    Scanner sc=new Scanner(System.in);
    
    void getInput()
    {
        System.out.println("Enter Name,Account No,Phno No");
        name=sc.next();
        accno=sc.nextInt();
        phno=sc.nextInt();
        blcamt=0;
    }
    void deposit()
    {
        System.out.println("ENTER THE AMOUNT TO BE DEPOSITED");
        blcamt=blcamt+sc.nextFloat();
        System.out.println("AVAILABLE BALANCE:"+blcamt);
    }
    void withdraw()
    {
        System.out.println("ENTER AMOUNT TO WITHDRAW");
        float temp=sc.nextFloat();
        if(temp>blcamt)
            System.out.println("AMOUNT EXCEEDS BALANCE AMOUNT");
        else
        {
            blcamt=blcamt-temp;
            System.out.println("Amount Withdrawn:"+temp+"Balance Amount:"+blcamt);
        }
        
    }
}
class Acc
{
    public static void main(String args[])
    {
        Account a=new Account();
        a.getInput();
        Scanner sc1=new Scanner(System.in);
        int t;
        while (true)
        {
            System.out.println("1.Deposit\t2.Withdraw\t3.Exit");
            t=sc1.nextInt();
            if(t==1)
                a.deposit();
            else if(t==2)
                a.withdraw();
            else
                break;
        }
    }
}
