package hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame{
	
	Department(){
		
		JPanel panel=new JPanel();
		panel.setBounds(5,5,750,450);
		panel.setLayout(null);
		panel.setBackground(new Color(90,156,163));
		add(panel);
		
		JTable table= new JTable();
		table.setBounds(0, 30, 700, 350);
		table.setBackground(new Color(90,156,163));
		table.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(table);
		

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel label1 = new JLabel("Department");
        label1.setBounds(120,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(400,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);
        panel.add(label2);

        JButton b1 = new JButton("BACK");
        b1.setBounds(300,410,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
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
		new Department();
	}

}
