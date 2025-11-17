import java.net.*;
import java.io.*;
import java.util.*;

class client
{
Socket so;
Scanner sc;
DataOutputStream dou;
DataInputStream din;
String s;
client()
{
try
{
so=new Socket("localhost",100);
sc=new Scanner(System.in);
dou=new DataOutputStream(so.getOutputStream());
din=new DataInputStream(so.getInputStream());
do
{
s=sc.next();
dou.writeUTF(s);
String a=din.readUTF();
System.out.print("Server msg"+a);
}while(!s.equals("stop"));
}catch(IOException e)
{
System.out.print(e);
}
}

public static void main(String ar[])
{
new client();
}
}