import java.util.*;
abstract class Color
{
    abstract void getColor();
    abstract void putColor();
}
class PullOver extends Color
{
    Scanner sc=new Scanner(System.in);
    String color;
    PullOver()
    {
        System.out.println("This Is PullOver Class");
    }
    void getColor()
    {
        System.out.println("Enter The Color");
        color=sc.next();
    }
    void putColor()
    {
        System.out.println("Color Is:"+color);
    }
}
final class FormalShirt extends Color
{
    Scanner sc=new Scanner(System.in);
    String color;
    FormalShirt()
    {
        System.out.println("This Is FormalShirt Class");
    }
    void getColor()
    {
        System.out.println("Enter The Color");
        color=sc.next();
    }
    void putColor()
    {
        System.out.println("Color Is:"+color);
    }
    
}
class PartyWear extends PullOver
{
    Scanner sc=new Scanner(System.in);
    String color;
    PartyWear()
    {
        System.out.println("This IS PartyWear Class");
    }
    void getColor()
    {
        System.out.println("Enter Color For PartyWear");
        color=sc.next();
        System.out.println("Enter Color For PullOver");
        super.color=sc.next();
    }
    void putColor()
    {
        System.out.println("PartyWear Color:"+color+"\nPullOver Color:"+super.color);
    }
}
class Inherit
{
    public static void main(String[] args)
    {
        PullOver p=new PullOver();
        p.getColor();
        p.putColor();
        FormalShirt f=new FormalShirt();
        f.getColor();
        f.putColor();
        PartyWear pw=new PartyWear();
        pw.getColor();
        pw.putColor();
    }
}