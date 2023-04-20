import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class viewdata extends JFrame implements ActionListener
{  

JButton b1, b2;
JTextArea ta1;

public viewdata()
{  

b1=new JButton("View Student Records");
ta1=new JTextArea(20,80);
setLayout(new FlowLayout());

add(b1);
b1.addActionListener(this);

b2 = new JButton("Search Records");
b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        new Search();
        dispose();
    }
});
add(b2);

add(ta1);
setSize(500,500);
setVisible(true);

}

public void actionPerformed(ActionEvent ae)
{
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/studentdetails","root","Sin@1412"); 


Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from st");  
ta1.append("Roll Number"+"\t\t"+"Student Name"+"\t\t"+"CGPA"+"\t\t"+"Backlogs"+"\t\t"+"Attendance"+"\t\t"+"Phone Number"+"\n");

while(rs.next())  
{System.out.println(rs.getLong(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getLong(6));  
ta1.append(rs.getLong(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getLong(6)+"\n");}
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  



public static void main(String args[])
{
new viewdata();
}

} 