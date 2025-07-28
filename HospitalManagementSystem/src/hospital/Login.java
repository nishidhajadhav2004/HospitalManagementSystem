package hospital;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField textField;
	JPasswordField jPasswordField;
	JButton b1,b2;
	
	Login(){
		
		JLabel namelabel = new JLabel("Username: ");
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        namelabel.setBounds(50, 50, 100, 30); 
        namelabel.setForeground(Color.BLACK);
        add(namelabel);
        
        
        JLabel password = new JLabel("Password: ");
        password.setFont(new Font("Tahoma", Font.BOLD, 18));
        password.setBounds(50, 100, 100, 30); 
        password.setForeground(Color.BLACK);
        add(password);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(150, 50, 150, 30); 
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        add(textField);
        
        jPasswordField = new JPasswordField();
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jPasswordField.setBounds(150, 100, 150, 30); 
        jPasswordField.setForeground(Color.BLACK);
        jPasswordField.setBackground(Color.WHITE);
        add(jPasswordField);
        
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/hospital/login.png"));
        Image i1 = icon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(330, -40, 400, 300);
        add(label);
        

        
        b1= new JButton("Login");
        b1.setBounds(40, 140,  120,  30);
        b1.setFont(new Font("serif", Font. BOLD, 10));
        b1.addActionListener(this);
        add(b1);
        

        b2= new JButton("Cancel");
        b2.setBounds(180, 140,  120,  30);
        b2.setFont(new Font("serif", Font. BOLD, 10));
        b2.addActionListener(this);
        add(b2);
        



        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(800, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			try {
				conn c=new conn();
				String User= textField.getText();
				String Pass=jPasswordField.getText();
				
				String q = "select * from login where ID = ? and PW = ?";
				PreparedStatement pst = c.connection.prepareStatement(q);
				pst.setString(1, User);
				pst.setString(2, Pass);

				ResultSet resultSet = pst.executeQuery();

				
				if(resultSet.next()) {
					new Reception();
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null,"Invalid");
				}
				
				
				
			}
			catch(Exception E) {
				E.printStackTrace();
			}
		}else {
			System.exit(10);
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

	

}
