package gameproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class Frame extends JFrame implements ActionListener{

	JButton button1;
	JButton button2;
	JButton button3;
	JLabel diff;
	static int decider=0;
	int click=0;
	
	Frame(){
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(50, 150, 400, 30);
		
		
		diff = new JLabel();
		diff.setText("Choose Your Difficulty");
		
		
		button1 = new JButton("Easy");
		button2 = new JButton("Medium");
		button3 = new JButton("Hard");
		button1.setBounds(100, 300, 80, 50);
		button2.setBounds(210, 300, 80, 50);
		button3.setBounds(320, 300, 80, 50);
		
		
		button1.addActionListener(this); 
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		
		this.getContentPane().setBackground(Color.DARK_GRAY);;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(panel);
		panel.add(diff);
		
		while(click==0) {
			Thread.onSpinWait();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			this.dispose();
			decider=1;
		}
		else if(e.getSource()==button2) {
			this.dispose();
			decider=2;
		}
		else if(e.getSource()==button3) {
			this.dispose();
			decider=3;
		}
		click++;	
}
}