import java.io.*;
public class dbtijfs
{
    public static void main()throws IOException
    {
        System.out.println("New User : 1");
        System.out.println("Existing User : 2");
        System.out.println("Delete an existing account : 3");
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        int a1=Integer.parseInt(ob.readLine());
        System.out.print("\f");
        if(a1==1)
        {
            System.out.println("Enter Username");
            String s1=ob.readLine();
            System.out.println("Enter a password");
            String s2=ob.readLine();
            FileWriter f = new FileWriter(s1+"_"+s2+".txt");
            System.out.print("\f");
            System.out.println("Account Successfully Created");        
            System.out.println("Enter the amount in bank");
            String s3=ob.readLine();
            System.out.println("Enter the amount in wallet");
            String s4=ob.readLine();
            PrintWriter out = new PrintWriter(f);
            out.print("Total amount in bank : "+s3);
            out.println("");
            out.print("Total amount in wallet : "+s4);
            out.close();
            f.close();
        }
        if(a1==2)
        {
            System.out.println("Enter Your username");
            String s5=ob.readLine();
            System.out.println("Enter your password");
            String s6=ob.readLine();
            while(true)
            {
                try
                {
                    FileReader f = new FileReader(s5+"_"+s6+".txt");
                    BufferedReader in = new BufferedReader(f);
                    System.out.println("Welcome User");
                    System.out.println("");
                    System.out.println("Enter the choice of your action");
                    System.out.println("1:Show balance");
                    System.out.println("2:From atm to wallet");
                    System.out.println("3:Calculate Daily Expenditure");
                    System.out.println("4:Logout");
                    System.out.println("");
                    int a2=Integer.parseInt(ob.readLine());
                    System.out.print("\f");
                    if(a2==1)
                    {
                        System.out.println("Account Details:");
                        System.out.println();
                        String line="j";
                        while (line != null) 
                        {
                            line = in.readLine();
                            if(line!=null)
                                System.out.println(line);
                        }
                        f.close();
                        System.out.println();
                    }

                    if(a2==2)
                    {
                        String s[]=new String[2];
                        int k=0;

                        String line="j";
                        while (k<2) 
                        {
                            line = in.readLine();
                            if(line!=null)
                            {
                                s[k]=line.substring(line.indexOf(":")+2);
                                k+=1;
                            }
                        }
                        f.close();
                        System.out.println(s[0]+" "+s[1]);
                        System.out.println("Enter the amount credited from atm to wallet");
                        int amt=Integer.parseInt(ob.readLine());
                        s[0]=String.valueOf(Integer.valueOf(s[0])-amt);
                        s[1]=String.valueOf(Integer.valueOf(s[1])+amt);
                        FileWriter f1 = new FileWriter(s5+"_"+s6+".txt");
                        PrintWriter out = new PrintWriter(f1);
                        out.print("Total amount in bank : "+s[0]);
                        out.println("");
                        out.print("Total amount in wallet : "+s[1]);
                        out.close();
                        f1.close();
                        System.out.println("Account balance updated");
                        System.out.println();
                    }

                    if(a2==3)
                    {
                        FileReader f1 = new FileReader("C:/Users/ARPIT/Google Drive/budjet.txt");
                        BufferedReader ini = new BufferedReader(f1);
                        String s1[]=new String[2];
                        int k1=0;
                        String line1="j";
                        while (k1<2) 
                        {
                            line1 = in.readLine();
                            if(line1!=null)
                            {
                                s1[k1]=line1.substring(line1.indexOf(":")+2);
                                k1+=1;
                            }
                        }
                        f.close();
                        String s[]=new String[10000];
                        int k=0;
                        String line="j";
                        int sum=0;
                        while (line!=null) 
                        {
                            line = ini.readLine();
                            if(line!=null)
                            {
                                s[k]=line.substring(line.indexOf(":")+2);
                                sum=sum+Integer.valueOf(s[k]);
                                k=k+1;
                            }
                        }
                        f1.close();
                        s1[1]=String.valueOf(Integer.valueOf(s1[1])-sum);
                        FileWriter f11 = new FileWriter(s5+"_"+s6+".txt");
                        PrintWriter out = new PrintWriter(f11);
                        out.print("Total amount in bank : "+s1[0]);
                        out.println("");
                        out.print("Total amount in wallet : "+s1[1]);
                        out.close();
                        f11.close();
                        System.out.println("Account balance updated");
                        System.out.println();
                    }
                    if(a2==4)
                    {
                        f.close();
                        System.out.print("\f");
                        System.out.println("Successfully logged out");
                        break;
                    }
                }
                catch(FileNotFoundException f)
                {
                    System.out.print("\f");
                    System.out.println("No File Found");
                }
            }
        }
        if(a1==3)
        {
            System.out.print("\f");
            System.out.println("Enter the user name of the account to be deleted");
            String s7=ob.readLine();
            System.out.println("Enter the password");
            String s8=ob.readLine();
            File f=new File(s7+"_"+s8+".txt");
            f.delete();
        }
    }
}