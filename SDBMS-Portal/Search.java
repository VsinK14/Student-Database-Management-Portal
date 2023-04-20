import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Search extends JFrame implements ActionListener
{  

JButton b1, b2;
JTextArea ta1;
JLabel l1;
JTextField t1;
public Search()
{  
l1=new JLabel("For Which Roll Number");
t1=new JTextField(20);

b1=new JButton("View Student Records");
b1.addActionListener(this);

b2 = new JButton("Update Record");
b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        new formupdate();
        dispose();
    }
});

ta1=new JTextArea(10,70);

setLayout(new FlowLayout(FlowLayout.CENTER, 800, 20));
add(l1);add(t1);
add(b1);
add(ta1);
add(b2);

setSize(500,500);
setVisible(true);

}

public void actionPerformed(ActionEvent ae){
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studentdetails","root","Sin@1412"); 
        
        long RollNumber= Long.parseLong(t1.getText());
        
        String sql = "select * from st where RollNumber=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setLong(1,RollNumber);
        ResultSet rs=stmt.executeQuery();  
        ta1.append("Roll Number"+"\t  "+"Student Name"+"\t"+"CGPA"+"     "+"Backlogs"+"   "+"Attendance"+"\t"+"Phone Number"+"\n");
        
        while(rs.next())  
        {System.out.println(rs.getLong(1)+"  "+rs.getString(2)+"      "+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t  "+rs.getLong(6));  
        ta1.append(rs.getLong(1)+"  "+rs.getString(2)+"      "+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t  "+rs.getLong(6)+"\n");}
        con.close();  
        }catch(Exception e){ System.out.println(e);}  
        }  
        
        
        
        public static void main(String args[])
        {
        new Search();
        }
}
