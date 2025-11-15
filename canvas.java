import java.awt.*;
import java.awt.event.*;

class can extends Canvas
{
int v=0,l,t,w,h,x1,x2,y1,y2;
public void update(Graphics g)
{
if(v==0)
{
}
else if(v==1)
g.drawRect(l,t,w,h);
else if(v==2)
g.drawOval(l,t,w,h);
else if(v==3)
g.drawLine(x1,y1,x2,y2);
}
}


class paint extends MouseAdapter implements ActionListener
{
Frame f;
can c;
Button b1,b2,b3;
Panel p;

paint()
{
f=new Frame();
b1=new Button("R");
b2=new Button("O");
b3=new Button("L");
c=new can();
p=new Panel();
p.setLayout(new GridLayout(3,1));
p.add(b1);
p.add(b2);
p.add(b3);
f.add(p,BorderLayout.WEST);
f.add(c);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
c.addMouseListener(this);
f.setSize(800,600);
f.setVisible(true);	
}
public void mousePressed(MouseEvent e)
{
c.l=c.x1=e.getX();
c.t=c.y1=e.getY();

}
public void mouseReleased(MouseEvent e)
{
	
	c.x2=e.getX();
	c.y2=e.getY();
	if(e.getX()>c.l && e.getY()>c.t)
	{
	c.w=e.getX()-c.l;
	c.h=e.getY()-c.t;
	}
	else if(e.getX()<c.l && e.getY()>c.t)
	{
	c.w=c.l-e.getX();
	c.h=e.getY()-c.t;
	c.l=c.l-c.w;
	}
	else if(e.getX()>c.l && e.getY()<c.t)
	{
	c.w=e.getX()-c.l;
	c.h=c.t-e.getY();
	c.t=c.t-c.h;
	}
	else
	{
	c.w=c.l-e.getX();
	c.h=c.t-e.getY();
	c.t=c.t-c.h;
	c.l=c.l-c.w;
	}
	c.repaint();
	
}


public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
c.v=1;
else if(e.getSource()==b2)
c.v=2;
else if(e.getSource()==b3)
c.v=3;

}
public static void main(String ar[])
{
paint p=new paint();
}
}