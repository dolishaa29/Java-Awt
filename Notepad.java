import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class notepad implements ActionListener{
	String s;
	int siz = 10;
	int sty = 0;
	
	Frame f;
	MenuBar mb;
	Menu fi, ed, fo, fon, st, si, co;
	MenuItem ne, op, sa, ex, cu, cp, pa, bo, it, pl, tn, tw, th, back, forg;
	TextArea ta;
	
	notepad(){
		f = new Frame("Notepad");
		mb = new MenuBar();
		fi = new Menu("File");
		ed = new Menu("Edit");
		fo = new Menu("Format");
		fon = new Menu("Font");
		st = new Menu("Style");
		si = new Menu("Size");
		co = new Menu("Color");
		
		ne = new MenuItem("New");
		op = new MenuItem("Open");
		sa = new MenuItem("Save");
		ex = new MenuItem("Exit");
		cu = new MenuItem("Cut");
		cp = new MenuItem("Copy");
		pa = new MenuItem("Paste");
		bo = new MenuItem("Bold");
		it = new MenuItem("Italic");
		pl = new MenuItem("Plain");
		tn = new MenuItem("10%");
		tw = new MenuItem("20%");
		th = new MenuItem("30%");
		bac = new MenuItem("Background");
		for = new MenuItem("Forground");
				
		ta = new TextArea();
		
		
		
		fi.add(ne);
		fi.add(op);
		fi.add(sa);
		fi.add(ex);
		
		ed.add(cu);
		ed.add(cp);
		ed.add(pa);
		
		st.add(bo);
		st.add(it);
		st.add(pl);
		
		si.add(tn);
		si.add(tw);
		si.add(th);
		
		co.add(back);
		co.add(forg);
		
		fon.add(st);
		fon.add(si);
		
		fo.add(fon);
		fo.add(co);
		
		mb.add(fi);
		mb.add(ed);
		mb.add(fo);
		
		f.setMenuBar(mb);
		f.add(ta);
		
		
		
		ne.addActionListener(this);
		op.addActionListener(this);
		sa.addActionListener(this);
		ex.addActionListener(this);
		cu.addActionListener(this);
		cp.addActionListener(this);
		pa.addActionListener(this);
		bo.addActionListener(this);
		it.addActionListener(this);
		pl.addActionListener(this);
		tn.addActionListener(this);
		tw.addActionListener(this);
		th.addActionListener(this);
		back.addActionListener(this);
		forg.addActionListener(this);
		
		
		f.setSize(300, 300);
		f.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == ne){
			ta.setText("");
			
			
		}else if(e.getSource() == op){
			JFileChooser jc = new JFileChooser();
			jc.showOpenDialog(f);
			
			
		}else if(e.getSource() == sa){
			JFileChooser jc = new JFileChooser();
			jc.showSaveDialog(f);
			
			
		}else if(e.getSource() == ex){
			System.exit(0);
			
			
		}else if(e.getSource() == cu){
			s = ta.getSelectedText();
			int i = ta.getSelectionStart();
			int j = ta.getSelectionEnd();
			ta.replaceRange("", i, j);
			
			
		}else if(e.getSource() == cp){
			s = ta.getSelectedText();
			
			
		}else if(e.getSource() == pa){
			ta.insert(s, ta.getSelectionStart());
			
			
		}else if(e.getSource() == bo){
			sty = 1;
			Font fo = new Font("Arial", sty, siz);
			ta.setFont(fo);
			
			
		}else if(e.getSource() == it){
			sty = 2;
			Font fo = new Font("Arial", sty, siz);
			ta.setFont(fo);
			
		}else if(e.getSource() == pl){
			sty = 0;
			Font fo = new Font("Arial", sty, siz);
			ta.setFont(fo);
			
			
		}else if(e.getSource() == tn){
			siz = 10;
			Font fo = new Font("Arial", sty, siz);
			ta.setFont(fo);
			
			
		}else if(e.getSource() == tw){
			siz = 20;
			Font fo = new Font("Arial", sty, siz);
			ta.setFont(fo);
			
			
		}else if(e.getSource() == th){
			siz = 30;
			Font fo = new Font("Arial", sty, siz);
			ta.setFont(fo);
			
			
		}else if(e.getSource() == back){
			JColorChooser jc = new JColorChooser();
			Color c = jc.showDialog(f, "Background Color", Color.white);
			ta.setBackground(c);
		
			
		}else if(e.getSource() == forg){
			JColorChooser jc = new JColorChooser();
			Color c = jc.showDialog(f, "Foreground Color", Color.white);
			ta.setForeground(c);
		}
	}
	public static void main(String ar[]){
		notepad np = new notepad();
	}
}