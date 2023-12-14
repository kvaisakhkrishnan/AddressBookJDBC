import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to Address Book");
            System.out.println("------------------------");
            System.out.println("[1] Add Address Book");
            System.out.println("[2] Add Address to Address Book");
            System.out.println("[3] Edit Address");
            System.out.println("[4] Delete Address");
            System.out.println("[5] Display Address");
            System.out.println("[6] No Of Contacts By City");
            System.out.println("[7] No Of Contacts By State");
            System.out.println("CHOICE: ");
            int choice = scanner.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("Enter Address Book Name: ");
                    String name = scanner.next();
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "insert into AddressBook (name) values (?)";
                        PreparedStatement statement = jdbc.connection.prepareStatement(sql);
                        statement.setString(1, name);
                        statement.executeUpdate();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Added Succesfully");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    catch(SQLException err){
                        err.printStackTrace();
                    }
                    break;
                case 2 :
                    System.out.println("Enter Address Book Id: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Enter Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("Enter Address: ");
                    String address = scanner.next();
                    System.out.println("Enter City: ");
                    String city = scanner.next();
                    System.out.println("Enter State: ");
                    String state = scanner.next();
                    System.out.println("Enter Zip: ");
                    String zip = scanner.next();
                    System.out.println("Enter Phonenumber: ");
                    String phone = scanner.next();
                    System.out.println("Enter Email: ");
                    String email = scanner.next();
                    System.out.println("Enter Contact Type: ");
                    String type = scanner.next();
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "insert into address (firstName, lastName, address, city, state, zip, phonenumber, email, bookid, type) values (?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement statement = jdbc.connection.prepareStatement(sql);
                        statement.setString(1, firstName);
                        statement.setString(2, lastName);
                        statement.setString(3, address);
                        statement.setString(4, city);
                        statement.setString(5, state);
                        statement.setString(6, zip);
                        statement.setString(7, phone);
                        statement.setString(8, email);
                        statement.setInt(9, id);
                        statement.setString(10, type);
                        statement.executeUpdate();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Added To Address Book Succesfully");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    }
                    catch(SQLException err){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Not Found");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }


                    break;
                case 3:
                    System.out.println("Enter Address Book Id: ");
                    int id2 = scanner.nextInt();
                    System.out.println("Enter First Name: ");
                    String firstName2 = scanner.next();
                    System.out.println("Enter Last Name: ");
                    String lastName2 = scanner.next();
                    System.out.println("Enter Address: ");
                    String address2 = scanner.next();
                    System.out.println("Enter City: ");
                    String city2 = scanner.next();
                    System.out.println("Enter State: ");
                    String state2 = scanner.next();
                    System.out.println("Enter Zip: ");
                    String zip2 = scanner.next();
                    System.out.println("Enter Phonenumber: ");
                    String phone2 = scanner.next();
                    System.out.println("Enter Email: ");
                    String email2 = scanner.next();
                    System.out.println("Enter Contact Type: ");
                    String type2 = scanner.next();
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "update address set address = ?, city = ?, state = ?, zip = ?, phonenumber = ?, email = ?, type = ? where bookid = ? and firstName = ? and lastName = ?";
                        PreparedStatement statement = jdbc.connection.prepareStatement(sql);
                        statement.setString(1, address2);
                        statement.setString(2, city2);
                        statement.setString(3, state2);
                        statement.setString(4, zip2);
                        statement.setString(5, phone2);
                        statement.setString(6, email2);
                        statement.setString(7, type2);
                        statement.setInt(8, id2);
                        statement.setString(9, firstName2);
                        statement.setString(10,lastName2);
                        int result = statement.executeUpdate();
                        if(result == 0){
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Address Book Not Found");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                            break;
                        }
                        System.out.println("~~~~~~~~~~~~~~~~");
                        System.out.println("Address Deleted");
                        System.out.println("~~~~~~~~~~~~~~~~~");

                    }
                    catch(SQLException err){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Not Found");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    break;
                case 4:
                    System.out.println("Enter Address Book Id: ");
                    int id3 = scanner.nextInt();
                    System.out.println("Enter First Name: ");
                    String firstName3 = scanner.next();
                    System.out.println("Enter Last Name: ");
                    String lastName3 = scanner.next();
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "delete from address where bookid = ? and firstName = ? and lastName = ?";
                        PreparedStatement statement = jdbc.connection.prepareStatement(sql);
                        statement.setInt(1, id3);
                        statement.setString(2, firstName3);
                        statement.setString(3,lastName3);
                        int result = statement.executeUpdate();
                        if(result == 0){
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Address Book Not Found");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                            break;
                        }
                        System.out.println("~~~~~~~~~~~~~~~~");
                        System.out.println("Address Updated");
                        System.out.println("~~~~~~~~~~~~~~~~~");

                    }
                    catch(SQLException err){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Not Found");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    break;
                case 5:
                    System.out.println("Enter Address Book Id: ");
                    int id4 = scanner.nextInt();
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "select * from address where bookid = ?";
                        PreparedStatement statement = jdbc.connection.prepareStatement(sql);
                        statement.setInt(1, id4);
                        ResultSet result = statement.executeQuery();
                        while(result.next()){
                            System.out.println("ID: [" + result.getString("id") + "], Name: [" + result.getString("firstName") + " " + result.getString("lastName") + "]");
                        }

                    }
                    catch(SQLException err){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Not Found");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    break;
                case 6:
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "select count(*) as count, city from address group by city";
                        Statement statement = jdbc.connection.createStatement();
                        ResultSet result = statement.executeQuery(sql);
                        while(result.next()){
                            System.out.println("City: [" + result.getString("city") + "], Count: [" + result.getString("count") + "]");
                        }

                    }
                    catch(SQLException err){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Not Found");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    break;
                case 7:
                    try{
                        JDBC jdbc = new JDBC();
                        jdbc.getConnection();
                        String sql = "select count(*) as count, state from address group by state";
                        Statement statement = jdbc.connection.createStatement();
                        ResultSet result = statement.executeQuery(sql);
                        while(result.next()){
                            System.out.println("State: [" + result.getString("state") + "], Count: [" + result.getString("count") + "]");
                        }

                    }
                    catch(SQLException err){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Address Book Not Found");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    break;

                default :
                    break;
            }
        }


    }
}
