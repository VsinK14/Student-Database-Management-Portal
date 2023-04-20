import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import javax.swing.*;

public class forminsert extends JFrame implements ActionListener
{  

JButton b1, b2;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2,t3,t4,t5,t6;

public forminsert()
{ 
b1=new JButton("Insert Student Records");
b1.addActionListener(this);

b2 = new JButton("View Records");
b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        new viewdata();
        dispose();
    }
});
JLabel.setBackground(new Color(206, 168, 138, 1));
l1=new JLabel("Roll Number");
l2=new JLabel("Student Name");
l3=new JLabel("Current CGPA");
l4=new JLabel("Number of Backlogs");
l5=new JLabel("Attendance (%)");
l6=new JLabel("Phone Number");

t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
t5=new JTextField(20);
t6=new JTextField(20);

setLayout(new FlowLayout(FlowLayout.CENTER, 550, 20));
add(l1);add(t1);
add(l2);add(t2);
add(l3);add(t3);
add(l4);add(t4);
add(l5);add(t5);
add(l6);add(t6);

add(b1);
add(b2);
setSize(500,500);
setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/studentdetails","root","Sin@1412");  
 

long RollNumber= Long.parseLong(t1.getText());
String StudentName=t2.getText();
Float CGPA= Float.parseFloat(t3.getText());
int Backlogs=Integer.parseInt(t4.getText());
int Attendance=Integer.parseInt(t5.getText());
long PhoneNumber=Long.parseLong(t6.getText());

PreparedStatement stmt=con.prepareStatement("insert into st values(?,?,?,?,?,?)");  
stmt.setLong(1,RollNumber);//1 specifies the first parameter in the query  
stmt.setString(2,StudentName);
stmt.setFloat(3,CGPA);
stmt.setInt(4,Backlogs);
stmt.setInt(5,Attendance);
stmt.setLong(6,PhoneNumber);

int i=stmt.executeUpdate();  
System.out.println(i+"Records Inserted"); 
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  


public static void main(String args[])
{
    forminsert f = new forminsert();
}

} 