import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //1. Adim:Driver 'a kaydol
        Class.forName("org.postgresql.Driver");


        //2. Adim:Driver'a kaydol
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbj",
                "postgres",
                "6789");

        //3. Adim: Statement olustur
        Statement st = con.createStatement();

        // SORU:Region id'si 1 olan "country name" degerlerini cagirin.

        String sql01 = "select country_name from countries where region_id=1";

        /* 4. Adim: ResultSet */

        ResultSet veri = st.executeQuery(sql01);

        while (veri.next()) {

          // System.out.println(veri.getString(2));
          // yukardaki ifadeyi yazdigimizda exception atti
          // sutun sayisi bir sen iki yazdin
          // String sql01= "select * from countries" yazmis olsaydik yukardaki sout
          //ifadesinden hata almamis olurduk

            System.out.println(veri.getString(1));
        }

        //soru:2 "region_id"nin 2'den buyuk oldugu "country_id", "country_name" degerlerini cagirin

        String sql02="select country_name,country_id from countries where region_id>2";

        ResultSet veri02=st.executeQuery(sql02);

        while(veri02.next()){

            System.out.println(veri02.getString("country_name")+" "
                               +veri02.getString("country_id"));
        }
    }
}