package Lab1;

import java.io.*;
public class ReversinganInteger
{
  void revers(int x) {
    if(x==0) return;
    else {
            System.out.print(x%10);
            revers(x/10);}
          }

  public static void main(String args[]) throws IOException  {
       	ReversinganInteger Digit = new ReversinganInteger();
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String h;
        int n;
        System.out.print("Integer: ");
        h=bf.readLine();
        n=Integer.parseInt(h);
        System.out.print("Reversed Integer: ");
        Digit.revers(n); } }
