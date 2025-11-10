import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class jdbc4 implements ActionListener
{
int no;
Frame f1,f2,f3,f4,f5,f6,f7;
Label l1,l2,l3,l4,l5,l6,l7;
TextField t1,t2,t3,t4,t5,t6,t7;
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
TextArea tx;
Connection co;
Statement st,st1;
ResultSet rs,rs1,rs2,rs3,rs8;
jdbc4()
{

f1=new Frame("Login");
f2=new Frame("page");
f3=new Frame("Amount");
f4=new Frame("Deposit");
f5=new Frame("Withdrawal");
f6=new Frame("Transaction");
f7=new Frame("Transfer");


l1=new Label("Name/Accno");
l2=new Label("Password");
l3=new Label("Amount");
l4=new Label("Amount");
l5=new Label("Amount");
l6=new Label("Accno");
l7=new Label("Amount");

t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
tx=new TextArea();
t6=new TextField();
t7=new TextField();

b1=new Button("Sign in");
b2=new Button("Sign up");
b3=new Button("Deposit");
b4=new Button("Withdrawal");
b5=new Button("Amount");
b6=new Button("Give");
b7=new Button("Take");
b8=new Button("Back");
b9=new Button("Back");
b10=new Button("Back");
b11=new Button("history");
b12=new Button("transfer");
b13=new Button("transfered");

f1.setLayout(null);
f2.setLayout(null);
f3.setLayout(null);
f4.setLayout(null);
f5.setLayout(null);
f6.setLayout(null);
f7.setLayout(null);


l1.setBounds(20,40,80,20);
l2.setBounds(20,80,80,20);
l3.setBounds(20,80,80,20);
l4.setBounds(20,80,80,20);
l5.setBounds(20,80,80,20);
l6.setBounds(20,40,80,20);
l7.setBounds(20,80,80,20);



t1.setBounds(120,40,80,20);
t2.setBounds(120,80,80,20);
t3.setBounds(120,80,80,20);
t4.setBounds(120,80,80,20);
t5.setBounds(120,80,80,20);
tx.setBounds(40,70,200,200);
t6.setBounds(120,40,80,20);
t7.setBounds(120,80,80,20);


b1.setBounds(20,160,50,20);
b2.setBounds(90,160,50,20);
b3.setBounds(120,40,80,20);
b4.setBounds(120,80,80,20);
b5.setBounds(120,120,80,20);
b12.setBounds(120,160,80,20);
b6.setBounds(90,160,50,20);
b7.setBounds(90,160,50,20);
b8.setBounds(180,160,50,20);
b9.setBounds(180,160,50,20);
b10.setBounds(90,160,50,20);
b11.setBounds(180,160,50,20);
b13.setBounds(20,160,50,20);



f1.add(l1);
f1.add(l2);
f1.add(t1);
f1.add(t2);
f1.add(b1);
f1.add(b2);
f2.add(b3);
f2.add(b4);
f2.add(b5);
f2.add(b12);
f3.add(b6);
f3.add(b8);
f3.add(l3);
f3.add(t3);
f4.add(b7);
f4.add(b9);
f4.add(l4);
f4.add(t4);
f5.add(l5);
f5.add(t5);
f5.add(b10);
f5.add(b11);
f6.add(tx);
f7.add(b13);
f7.add(l6);
f7.add(l7);
f7.add(t6);
f7.add(t7);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
b10.addActionListener(this);
b11.addActionListener(this);
b12.addActionListener(this);
b13.addActionListener(this);


f1.setSize(300,350);
f2.setSize(300,350);
f3.setSize(300,350);
f4.setSize(300,350);
f5.setSize(300,350);
f6.setSize(300,350);
f7.setSize(300,350);

f1.setVisible(true);
f2.setVisible(false);
f3.setVisible(false);
f4.setVisible(false);
f5.setVisible(false);
f6.setVisible(false);
f7.setVisible(false);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root",null);

}catch(Exception e)
{
System.out.print(e);
}
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2){
try{
 String s1=t1.getText();
 String s2=t2.getText();

PreparedStatement ps;
ps=co.prepareStatement("insert into login(name,password) values(?,?)");
ps.setString(1,s1);
ps.setString(2,s2);

ps.executeUpdate();
ps.close();
}catch(SQLException ee)
{
System.out.print(ee);
}
}

else if(e.getSource()==b1) 
{
try
{
int c=0;
PreparedStatement ps;
String s1=t1.getText();
String s2=t2.getText();
ps=co.prepareStatement("select * from login where accno=? and password=?");
ps.setInt(1,Integer.parseInt(s1));
ps.setString(2,s2);
rs=ps.executeQuery();
while(rs.next())
{
c=c+1;
}

if(c>0)
{

f1.setVisible(false);
f2.setVisible(true);
f3.setVisible(false);
f4.setVisible(false);
f5.setVisible(false);
}

else
{
t1.setText("");
t2.setText("");
}

}catch(SQLException ee)
{
System.out.print(ee);
}
}

else if(e.getSource()==b3) 
{
f2.setVisible(false);
f3.setVisible(true);
}

else if(e.getSource()==b4) 
{
f2.setVisible(false);
f4.setVisible(true);
}

else if(e.getSource()==b5) 
{
f2.setVisible(false);
f5.setVisible(true);
try
{
String s1=t1.getText();
st=co.createStatement();
rs8=st.executeQuery("select * from login where accno= '"+s1+"'");
String s="";
while(rs8.next())
{
s=s+rs8.getString(4);
}
t5.setText(s);

}catch(SQLException ee)
{
System.out.print(ee);
}
}

else if(e.getSource()==b6) 
{
try
{
String s1=t1.getText();
String s2=t3.getText();
PreparedStatement ps;
ps=co.prepareStatement("update login set amount=amount+? where accno=? ");
ps.setInt(1,Integer.parseInt(s2));
ps.setInt(2,Integer.parseInt(s1));
ps.executeUpdate();
ps.close();

PreparedStatement ps2;
ps2=co.prepareStatement("insert into transaction(accno , transaction, type,fromm) values(?,?,?)");
ps2.setInt(1,Integer.parseInt(s1));
ps2.setInt(2,Integer.parseInt(s2));
ps2.setString(3,"credit");
ps2.executeUpdate();
ps2.close();
}catch(SQLException ee)
{
System.out.print(ee);
}
}


else if(e.getSource()==b7) 
{
try
{
String s1=t1.getText();
String s2=t4.getText();
PreparedStatement ps;
ps=co.prepareStatement("update login set amount=amount-? where accno=? ");
ps.setInt(1,Integer.parseInt(s2));
ps.setInt(2,Integer.parseInt(s1));
ps.executeUpdate();
ps.close();
PreparedStatement ps2;
ps2=co.prepareStatement("insert into transaction(accno , transaction, type) values(?,?,?)");
ps2.setInt(1,Integer.parseInt(s1));
ps2.setInt(2,Integer.parseInt(s2));
ps2.setString(3,"debit");
ps2.executeUpdate();
ps2.close();


}catch(SQLException ee)
{
System.out.print(ee);
}
}

else if(e.getSource()==b8)
{
f3.setVisible(false);
f2.setVisible(true);
}

else if(e.getSource()==b9)
{
f4.setVisible(false);
f2.setVisible(true);
}

else if(e.getSource()==b10)
{
f5.setVisible(false);
f2.setVisible(true);
}

else if(e.getSource()==b11)
{
f2.setVisible(false);
f6.setVisible(true);
try
{
String s1=t1.getText();
st=co.createStatement();
rs=st.executeQuery("select * from transaction where accno= '"+s1+"'");
String s="";
while(rs.next())
{
s=s+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"\n";
}
tx.setText(s);
}catch(SQLException x)
{
System.out.print(x);
}
}

else if(e.getSource()==b12)
{
f2.setVisible(false);
f7.setVisible(true);
}

else if(e.getSource()==b13)
{
try
{
String fro=t1.getText();
String too=t6.getText();
String amt=t7.getText();
PreparedStatement ps;
ps=co.prepareStatement("select * from login where accno=?");
ps.setInt(1,Integer.parseInt(too));
rs=ps.executeQuery();
int c=0;
while(rs.next())
{
c=c+1;
}
if(c>0)
{
st1=co.createStatement();
rs1=st1.executeQuery("select amount from login where accno="+fro);
int bal=0,a=0;
while(rs1.next())
{
a=a+1;
bal=rs1.getInt(1);
		}
if(a>0)
{
if(bal-Integer.parseInt(amt)<0)
{
System.out.print("error1");
}
else
{
PreparedStatement ps2;
PreparedStatement ps3;
ps2=co.prepareStatement("update login set amount=amount-? where accno=?");
ps2.setInt(1,Integer.parseInt(amt));
ps2.setInt(2,Integer.parseInt(fro));
ps2.executeUpdate();
PreparedStatement ps5;
ps5=co.prepareStatement("insert into transaction(accno , transaction, type ,fromm) values(?,?,?,?)");
ps5.setInt(1,Integer.parseInt(fro));
ps5.setInt(2,Integer.parseInt(amt));
ps5.setString(3,"debit");
ps5.setString(4,"transfer");
ps5.executeUpdate();
ps5.close();
ps2.close();
ps3=co.prepareStatement("update login set amount=amount+? where accno=?");
ps3.setInt(1,Integer.parseInt(amt));
ps3.setInt(2,Integer.parseInt(too));
ps3.executeUpdate();
ps3.close();

PreparedStatement ps6;
ps6=co.prepareStatement("insert into transaction(accno , transaction, type,fromm) values(?,?,?,?)");
ps6.setInt(1,Integer.parseInt(too));
ps6.setInt(2,Integer.parseInt(amt));
ps6.setString(3,"credit");
ps6.setInt(4,Integer.parseInt(fro));
ps6.executeUpdate();
ps6.close();		
}
}
else
{
System.out.print("error2");
}
}
else
{
System.out.print("error3");
}
}
catch(SQLException ee)
{
System.out.print(ee);
}
}                                                                                                                                                     
}


public static void main(String ar[])
{
jdbc4 a1=new jdbc4();
}
}