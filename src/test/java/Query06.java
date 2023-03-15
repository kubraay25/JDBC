import java.sql.*;

public class Query06 {
  /*
    PreparedStatement: Yazdığımız herhangi bir SQL sorgusunu Statement
    ile  çalıştırdığımızda;  veri  tabanının  belleğinde  bu  sorgunun  bir  örneği
    saklanır. Bu sorgunun binlerce kere çalıştırıldığını düşünürsek; bu durum
    veritabanı performansını düşürür veya bağlantı kopmaları yaşanabilir.
    Bu  durumda  PreparedStatement  kullanmak  faydalı  olabilir.  Herhangi  bir
    SQL  sorgusunu  PreparedStatement  ile  çalıştırdığımızda;  veri  tabanında
    bu sorgusunun sadece bir kere örneği saklanır ve bin kere de çalıştırsak
    bu  sorgunun  veri  tabanının  belleğinde  sadece  bir  örneği  tutulur.  Böylece
    PreparedStatement daha performanslı olur*/
  public static void main(String[] args) throws ClassNotFoundException, SQLException {

      Class.forName("org.postgresql.Driver");

      Connection con = DriverManager.getConnection(
              "jdbc:postgresql://localhost:5432/jdbj",
              "postgres",
              "6789");

      Statement st = con.createStatement();
      //Statement st = con.createStatement();
      //st.executeUpdate("insert into ogrenciler values (850, 'Ali Can', 11, 'E')");


      /* PreparedStatement
         sorgunun birden fazla kez yürütülmesi gerektiğinde özellikle yararlıdır,
         çünkü sorgunun derlenmesi yalnızca bir kez gerçekleştirilir ve daha sonra birden
         fazla kez yürütülür. Bu da ağ trafiği ve sunucu yükü açısından tasarruf sağlar.*/

      PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?, ?, ?, ?)");
      ps.setInt(1, 951);
      ps.setString(2, "Ali Can");
      ps.setInt(3, 11);
      ps.setString(4, "E");
      ps.executeUpdate();

      ps.close();

  }
}








