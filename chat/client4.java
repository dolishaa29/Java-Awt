import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class client4 implements ActionListener
{
Frame f1;
Label l1,l2;
TextArea tx;
TextField t1;
Button b1;
Socket so1,so2;
ServerSocket soc;
DataOutputStream dou;
DataInputStream din;
String s;
Choice c1;
client4()
{
f1=new Frame("client 4");
l1=new Label("message recieved");
l2=new Label("message");
tx=new TextArea();
t1=new TextField();
b1=new Button("send");
c1=new Choice();


f1.setLayout(null);
l1.setBounds(20,20,120,70);
l2.setBounds(20,240,80,90);
tx.setBounds(20,100,190,150);
t1.setBounds(20,280,180,20);
b1.setBounds(200,300,50,50);
c1.setBounds(70,350,100,100);

f1.add(l1);
f1.add(l2);
f1.add(tx);
f1.add(t1);
f1.add(b1);
f1.add(c1);
c1.add("1001");
c1.add("1002");
c1.add("1003");
c1.add("1005");

b1.addActionListener(this);
f1.setSize(400,450);
f1.setVisible(true);

try
{
soc=new ServerSocket(1004);
while(true)
{

so1=soc.accept();

din= new DataInputStream(so1.getInputStream());
s=din.readUTF();
tx.append(s+"\n");
}
}
catch(Exception e)
{
System.out.print(e);
}
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
try
{
String s1=c1.getSelectedItem();
if(s1.equals("1001"))
{
so2=new Socket("localhost",1001);
}
else if(s1.equals("1002"))
{
so2=new Socket("localhost",1002);
}
else if(s1.equals("1003"))
{
so2=new Socket("localhost",1003);
}
else if(s1.equals("1005"))
{
so2=new Socket("localhost",1005);
}
dou=new DataOutputStream(so2.getOutputStream());
dou.writeUTF(t1.getText());
}
catch(Exception ee)
{
System.out.print(ee);
}
}
}
public static void main(String ar[])
{
new client4();
}
}