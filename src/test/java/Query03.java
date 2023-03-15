import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbj",
                "postgres",
                "6789");

        Statement st = con.createStatement();

        /*
        Bugun burada "execute" komutunu kullandik
           execute() -> create, drop, alter table (DDL) icin kullanılır.
           con.close();
           st.close();

         */

        //Soru:1 "workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.

        //String sql01 = "Create Table workers (worker_id int, worker_name varchar (20), worker_salary int)";
        //st.execute(sql01);

        /* Soru:2 Tabloya worker_address sutunu ekleyelim
                  bu kodu calistirirken yukariyi yoruma aliyorum
                  cunku tabloyu tekrardan olusturacagi icin hata alirim

         */

        //String sql02 = "Alter Table workers add worker_address varchar (50)";
        //st.execute(sql02);

        //Soru: Workers tablosunu silelim
          String sql03 = "Drop Table workers";
          st.execute(sql03);


    }
}

