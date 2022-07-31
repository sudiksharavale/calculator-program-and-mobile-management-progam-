import java.io.*;
import java.util.*;

class Declare
{
    Vector<Integer> v_mno = new Vector<Integer>();
 Vector<String> v_brand = new Vector<String>();
       Vector<Float> v_price = new Vector<Float>();
Vector<String>v_add=new Vector<String>();
}

class login
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String username="admin";
    static String password="1234";
    String user;
    String pass;
    
    void accept()
    {
        try{
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("\n\t\tWelcome To mobile Management System\n");
            System.out.println("\nEnter The Username : ");
            user = br.readLine();
            System.out.println("Enter The Password : ");
            pass = br.readLine();

        }
        catch(Exception e)
        {}
    }

    void check()
    {
        for(int i = 2; i >= 0 ; i--)
        {
            accept();
            if(username.compareTo(user) == 0 && password.compareTo(pass) == 0)
            {
                System.out.println("\n\n Login Successfull....\n\n");
                mobile.mainmenu();
                break;
            }
            else
            {
                System.out.println("\n\n Login Unsuccessfull !!!");
                System.out.println(" The Entered username Or Passord May Be Incorrect !!!");
                if(i > 0)
                    System.out.println(" You Have "+i+" Chance(s) Remaining....\n Please Enter Valid Credentials & Try Logging In Again....\n");
                else
                    System.out.println(" You Have Exhausted All Your Chances To Successfully Login Into The System !!!\n Please Restart The Program....");
            }
        }
    }

}

class mobile
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Declare d = new Declare();
     
    public static void main(String args[])
    {
        login lg = new login();
        lg.check();
        
    }

    static void mainmenu()
    {
        try{
            int choice = -1;
            do{
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("\t\t\tmobile Management System");
                System.out.println("-------------------------------------------------------------------------------\n\n");
                System.out.println("\t1. Add mobile");
             
                System.out.println("\t2. Display All mobiles");
               
                System.out.println("\t3. Search mobile");
                System.out.println("\t4. Exit");
                System.out.println("\n\n\tEnter Your Choice : ");
                choice = Integer.parseInt(br.readLine());
                System.out.println("--------------------------------------------------------------------------------");
                switch(choice)
                {
                    case 1 : addmobile();
                    break;
                    case 2 : displayAllmobiles();
                    break;
                    
                    case 3 : searchmobile();
                    break;
                    case 4 : System.out.println("Are You Sure (y/n) : ");
                             if(br.readLine().equalsIgnoreCase("y"))
                                choice = -1;
                    break;
                    default : System.out.println("INVALID CHOICE !!!");
                    break;
                }
            } while(choice != -1);
        }
        catch (Exception e)
        {}
    }

    static void addmobile()
    {
        try{
            System.out.println("Enter The mobile Number : ");
            Integer mno = new Integer(br.readLine());
            if(d.v_mno.contains(mno))
            {
                System.out.println("mobile data Already Exists !!!");
            }
            else
            {
                System.out.println("Enter The mobile Holder brand : ");
                String brand = br.readLine();
                System.out.println("Enter address:");
                String add=br.readLine();
                d.v_add.addElement(add);
                d.v_mno.addElement(mno);
                d.v_brand.addElement(brand);
                d.v_price.addElement(new Float(10000.0f));
                System.out.println("\n\n mobile Added Successfully....\n\n");
                System.out.println("\n\n|------------------------------------------------------------------------------|");
                System.out.println("|------------------------------------------------------------------------------|\n");
                System.out.println(" mobile Details Are As Follows : \n");
                display(d.v_mno.indexOf(mno));
            }
        }
        catch(Exception e)
        {}
    }

    static void displayAllmobiles()
    {
        System.out.println("      mobile No.       |       mobile Holder brand       |       Price    |   Address");
        System.out.println("-------------------------------------------------------------------------------");
        if(d.v_mno.size()>0)
        {
            for(int i=0;i<d.v_mno.size();i++)
            {
                System.out.printf("      %-17d |       %-25s |       %.2f |       %-20s",d.v_mno.elementAt(i),d.v_brand.elementAt(i),d.v_price.elementAt(i),d.v_add.elementAt(i));
                System.out.println();
            }
        }
        else
        {
            System.out.println("\n\n\n\t\t  No mobiles To Display !!!\n\n\n");
        }
    }


    static int searchmobile()
    {
        int mno;
        System.out.println("Enter The mobile Number To Search : ");
        try{
            mno=Integer.parseInt(br.readLine());
            if (d.v_mno.contains(new Integer(mno)))
            {
                int index = d.v_mno.indexOf(new Integer(mno));
                display(index);
                return index;
            }
            else
                System.out.println("mobile Does Not Exists !!!");
        }catch(Exception e)
        {}
        return -1;
    }


 

    static void display(int index)
    {
        System.out.println("mobile Address :"+d.v_add.elementAt(index));
        System.out.println("mobile Number : "+d.v_mno.elementAt(index));
        System.out.println("mobile Holder brand : "+d.v_brand.elementAt(index));
        System.out.println("Available price : "+d.v_price.elementAt(index));
    }


}
