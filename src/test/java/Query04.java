import javax.xml.transform.Result;
import java.sql.*;

public class Query04 {

    /*
    ResultSetMetaData:Bu arayüzü kullanarak, ResultSet hakkında daha fazla bilgi alabiliriz.
                      Her ResultSet nesnesi,bir ResultSetMetaData nesnesiyle ilişkilendirilir.
                      Bu  nesne,  sütunun  veri  türü,  sütun  adı,  sütun  sayısı,  tablo  adı,
                      şema  adı  gibi  sütun  özelliklerinin  ayrıntılarına  verir.
                      ResultSet'in,  getMetaData() yöntemini kullanarak ResultSetMetaData nesnesini alabiliriz
     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbj",
                "postgres",
                "6789");

        Statement st = con.createStatement();
        ResultSet rs= st.executeQuery(("select * from ogrenciler"));

        ResultSetMetaData rsmd=rs.getMetaData();

        /* getColumnName(1)--> bize 1.sutunun ismini verecektir
                           --> sutun ismini ogrenmek istiyorsak bunu kullaniriz */

        System.out.println("Sutun Sayisi: " + rsmd.getColumnCount());
        System.out.println(rsmd.getColumnName(1));
        System.out.println(rsmd.getColumnName(2));
        System.out.println(rsmd.getColumnName(3));
        System.out.println(rsmd.getColumnName(4));


        /*getTableName()--> burda bize tablo adi verir. herhangi bir sutun numarasi veririz farketmez
                            sadece verecegimiz sutun numarasinin mevcut olmasi gerekir */
        System.out.println(rsmd.getTableName(2));

        /* getColumnTypeName()--> burda sutun turunu verir */

        System.out.println(rsmd.getColumnTypeName(1));//int4
    }



}
