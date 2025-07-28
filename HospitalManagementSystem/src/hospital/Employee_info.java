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

public class Employee_info extends JFrame{
	
	Employee_info(){
		
		JPanel panel = new JPanel();
        panel.setBounds(5,5,750,450);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);
        
        JTable table = new JTable();
        table.setBounds(10,34,700,360);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);
        
        try{
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel label1 = new JLabel("Name");
        label1.setBounds(41,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(150,9,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(250,9,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);
        
        JLabel label4 = new JLabel("Salary");
        label4.setBounds(390,9,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(500,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar Number");
        label6.setBounds(593,9,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);
        
        JButton button = new JButton("BACK");
        button.setBounds(300,400,130,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				
			}
        	
        });
        
        setUndecorated(true);
        setSize(750,450);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);

		
	}

	public static void main(String[] args) {
		new Employee_info();
	}

}
