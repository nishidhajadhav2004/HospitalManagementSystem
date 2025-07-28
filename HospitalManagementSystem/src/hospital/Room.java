package hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;



public class Room extends JFrame{
	JTable table;
	
	Room(){
		JPanel panel=new JPanel();
		panel.setBounds(5,5,750,450);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		 
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/hospital/roomm.png")); 
		Image image=imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon imageIcon1=new ImageIcon(image);
		JLabel label=new JLabel(imageIcon1);
		label.setBounds(500, 150, 200, 200);
		panel.add(label);
		
		table= new JTable();
		table.setBounds(10, 50, 500, 300);
		table.setBackground(new Color(90,156,163));
		panel.add(table);
		
		try {
			conn c=new conn();
			String q="select*from room";
			ResultSet resultSet=c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
		
		JLabel label1=new JLabel ("Room No");
		label1.setBounds(12, 15, 80, 15);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
		panel.add(label1);
		
		JLabel label2=new JLabel ("Availability");
		label2.setBounds(140, 15, 80, 15);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
		panel.add(label2);
		
		JLabel label3=new JLabel ("Price");
		label3.setBounds(280, 15, 80, 15);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
		panel.add(label3);
		
		JLabel label4=new JLabel ("Bed Type");
		label4.setBounds(400, 15, 80, 15);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
		panel.add(label4);
		
		JButton back=new JButton("Back");
		back.setBounds(200,380,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		panel.add(back);
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
		setUndecorated(true);
		setSize(750,450);
		setLayout(null);
		setLocation(300,200);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new Room();
	}

}
