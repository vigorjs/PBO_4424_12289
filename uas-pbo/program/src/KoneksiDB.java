import java.sql.*;
public class KoneksiDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/perpus_sekolah";
    static final String USER="root";
    static final String PASS="";


    static Connection sambungkan;
    static Statement statmt;



    public static void main(String[] args) throws SQLException{
        try {
            //register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            //menyambungkan ke database
            sambungkan=DriverManager.getConnection(DB_URL,USER,PASS);

            //membuat objek statement
            statmt=sambungkan.createStatement();

            if (sambungkan!=null){
                sambungkan.close();
            }

        }catch (SQLException eksepsi){
            System.out.println(eksepsi.getMessage());
            eksepsi.getSQLState();
            eksepsi.getErrorCode();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
