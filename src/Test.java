import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test  extends Exception{
    Test() {
        System.out.println("gmail is not valid");
    }
}
class test1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        Statement st = con.createStatement();
        // creation of the table..
        Scanner readme = new Scanner(System.in);
        // String s=readme.nextLine();
        Pattern p = Pattern.compile("[a-z A-Z 0-9 _ \\.\\-]+[@][a-z A-Z 0-9]+([\\.][a-z A-Z 0-9]{2,3})+");
        PreparedStatement ps = con.prepareStatement("insert into database.info values (?,?)");
        ResultSet rs = ps.executeQuery("select *from database.info");
        System.out.println("Enter the srno");
        int a = readme.nextInt();
        System.out.println("Enter the Email");
        String b = readme.next();
        ps.setInt(1, a);// here we are set the value
        ps.setString(2,b);
        ps.executeUpdate();
        System.out.println("do you want add new recard");
        Matcher m = p.matcher(rs.getString(2));
        try{
            if(m.matches() == true){
                System.out.println("gmail successfully matched ");
            } else {
                throw new Test();
            }
        } catch (Test e) {
            e.printStackTrace();
            System.out.println(" now  program is narmally  terminated");
        }
        while(m.find())
        {
            System.out.println(m.group());
        }
        ps.close();
        con.close();

        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));

        }

    }
}






