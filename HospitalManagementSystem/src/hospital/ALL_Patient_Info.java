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

public class ALL_Patient_Info extends JFrame{
	
	ALL_Patient_Info(){
		
		JPanel panel = new JPanel();
        panel.setBounds(5,5,750,450);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);
        
        JTable table = new JTable();
        table.setBounds(10,40,740,320);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
		
        JLabel label1 = new JLabel("ID");
        label1.setBounds(31,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(100,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(200,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(300,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(390,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setBounds(500,11,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(600,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.white);
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(650,11,100,14);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        label8.setForeground(Color.white);
        panel.add(label8);

        JButton button = new JButton("BACK");
        button.setBounds(300,400,130,30);
        button.setBackground(Color.black);
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
		new ALL_Patient_Info();
	}

}
