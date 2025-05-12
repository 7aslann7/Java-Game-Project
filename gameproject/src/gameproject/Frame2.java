package gameproject;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class Frame2 extends JFrame implements ActionListener  {	JList<String> options;
JButton btn;
JButton next;
public int inta;
public int click=0;
public int skipint=0;

questions Questions = new questions();

public Frame2(int a) {
	
	DefaultListModel<String> list =new DefaultListModel<>();
	JLabel q = new JLabel();
	JLabel info1 = new JLabel();
	JLabel info2 = new JLabel();
	JLabel point= new JLabel();
	 options =new JList<>(list);
	 btn = new JButton("Select");
	 next = new JButton("Part II");
	
	this.setTitle("Questions");
	this.setSize(500,500);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);

	
	
	btn.setBounds(250,200,200,50);
	next.setBounds(20,20,80,60);
	q.setBounds(20, 100, 480, 100);
	info1.setBounds(10,300,480,100);
	info2.setBounds(10,350,480,100);
	options.setBounds(0, 200, 200, 100);
	point.setBounds(420, 10, 100,50);
	
	info1.setText("If you want to pass the question, click the 'Select' button without chosing an option.");
	info1.setFont(new Font("Calibri", Font.BOLD, 10));
	info2.setText("If you want to skip  Part I, click the 'Part II' button.");
	info2.setFont(new Font("Calibri", Font.BOLD, 10));
	
	q.setFont(new Font("Calibri", Font.BOLD, 12));
	
	
	
	
	
	
	btn.addActionListener(this);
	
	btn.setActionCommand("actionName1");
	next.setActionCommand("actionName2");
	this.add(btn);
	this.add(next);

	
	this.inta=a;
	int no1=0;
	int no2=0;
	int no3=0;
   int b1[] = new int[4];
   int b2[] = new int[4];
   int b3[] = new int[4];
   String s;
   List<Integer> randomquestion = new ArrayList<Integer>(b1.length);
   
   
   
   for(int x=0;x<12;x++) {
		Questions.questiongetter(x);
		if(Questions.getQuestionCategory().equals("1")) {
			s=(Questions.questionNo.trim());
			int y = Integer.parseInt(s.replaceAll("[^\\d-]", ""));
			b1[no1]=y;
			no1++;

		}
		else if(Questions.getQuestionCategory().equals("2")) {
			s=(Questions.questionNo.trim());
			int y = Integer.parseInt(s.replaceAll("[^\\d-]", ""));
			b2[no2]=y;
			no2++;
		}
		else if(Questions.getQuestionCategory().equals("3")) {
			s=(Questions.questionNo.trim());
			int y = Integer.parseInt(s.replaceAll("[^\\d-]", ""));
			b3[no3]=y;
			no3++;
		}
		
	}
   if(a==1) {
		
		for (int i: b1)
	{
	    randomquestion.add(i);
	}
	}
	else if(a==2){
		for (int i: b2)
		{
			randomquestion.add(i);
		}
	}
	else if(a==3) {
		for (int i: b3)
		{
			randomquestion.add(i);
		}
	}
   next.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           
          skipint++;
          click++;
          
          
          
	}
   });
	
	
	for(int i=0;i<4;i++) {
		
		
		
if(skipint==0) {
	Questions.getRandomQuestions(randomquestion);
		         
		
	
	
    point.setText("Points:"+Questions.points);
	
	q.setText(Questions.questiontext);
   
	list.addElement(Questions.optiona);
	list.addElement(Questions.optionb);
	list.addElement(Questions.optionc);
	list.addElement(Questions.optiond);
	
	this.add(q);
	this.add(options);
	this.setVisible(true);
	this.add(info1);
	this.add(info2);
	this.add(point);
	
			while(click==0) {
				Thread.onSpinWait();
				
			}
    list.clear();
    click--;


}
if(skipint==1) {
	break;
}

	}

	this.dispose();
	System.out.println(Questions.points);

	
	
}	



public void actionPerformed(ActionEvent e) {
        
        	String selection= Questions.optionCorrect;
    		
    		if(options.getSelectedIndex() !=-1) {
    		   if(options.getSelectedValue().equalsIgnoreCase(selection)) {
    			 if(inta==1){
    				 Questions.points+=10;
    			 }
    			 else if(inta==2){
    				 Questions.points+=30;
    				 
    			 }
    			 else if (inta==3) {
    				 Questions.points+=50;
    			 }
    			 
    				 
    			 }
    		}
	click++;    
	
}
 
}