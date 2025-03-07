package com.mycompany.sample6;
import java.util.Scanner;

public class Sample6 {

    public static void CRC(char[] a, String gen,int msglength,int genlength,char[] rem)
    {
        for(int i=0;i<msglength;i++)
        {
            if(a[i]=='1')
            {
                for(int j=0;j<=genlength;j++)
                {
                    if(a[i+j]==gen.charAt(j)) a[i+j]='0';
                    else a[i+j]='1';
                }
            }
        }
        for(int i=0;i<genlength;i++)
        {
            rem[i]=a[i+msglength];
        }
    }
    public static void main(String[] args) {
       Scanner r = new Scanner(System.in);
       System.out.println("SENDER SIDE");
       System.out.println("Enter Message Polynomial: ");
       String msg = r.nextLine();
       System.out.println("Enter Generator Polynomial: ");
       String gen = r.nextLine();
       
       int msglength = msg.length();
       int genlength = gen.length()-1;
       char a[] = new char[msglength+genlength];

       for(int i=0;i<msglength;i++)
       {
           a[i] = msg.charAt(i);
       }
       for(int i=msglength;i<msglength+genlength;i++)
       {
           a[i] = '0';
       }
       char[] rem = new char[genlength];
       CRC(a,gen,msglength,genlength,rem);
       System.out.println("Checksum calcuated is: "+String.valueOf(rem));

       System.out.println("\n\nRECEVER SIDE");
       System.out.println("Enter Receved Polynomial: ");
       String receved = r.nextLine();
       char b[] = new char[msglength+genlength];
       for(int i=0;i<receved.length();i++)
       {
           b[i] = receved.charAt(i);
       }
       for(int i=msglength,j=0;i<msglength+genlength;i++,j++)
       {
           b[i] = rem[j];
       }
       CRC(b,gen,msglength,genlength,rem);
       System.out.println("Checksum calculated is: "+String.valueOf(rem));
       int flag = 1;
       for(int i=0;i<genlength;i++)
       {
           if(rem[i]!='0') flag=0;
       }
       if(flag==1) System.out.println("There is no error..");
       else System.out.println("There is a error..");
    }
}

