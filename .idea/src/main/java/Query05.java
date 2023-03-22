import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

        public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbj",
                    "postgres",
                    "6789");

            Statement st = con.createStatement();

            //SORU: Öğrenciler tablosuna yeni bir kayıt ekleyin (300, 'Sena Can', 12, 'K')
            String sql01= "insert into ogrenciler values (304, 'Sena Can', 12, 'K')";

        /*  executeUpdate() : SQL Statement’ın etkilemiş olduğu satır
            sayısını integer cinsinden döner. INSERT, DELETE veya
            UPDATE SQL Statement’ları kullanılacaksa bu metod
            kullanılmalıdır.
            guncelleme yapacagimiz icin ""executeUpdate" komutunu kullanacagiz
            burda bilerek ResultSet kullanmadik cunku karsi taraftan bir data alacagimiz zaman kullaniriz
            yani sorgu gondericez karsi tarafa bir cevap gelirse ResultSeti kullanacagiz

         */
          int s1 = st.executeUpdate(sql01);
          System.out.println(s1 + " satir database eklendi");


          /* SORU: Öğrenciler tablosuna birden fazla veri ekleyin
                   (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
        1. YOL
        asagidaki gibi birden fazla data gonderebiliriz */

    //    String [] veri = {"insert into ogrenciler values (510, 'Sena Can', 12, 'K')",
    //           "insert into ogrenciler values (511, 'Sena Can', 12, 'K')",
    //         "insert into ogrenciler values (522, 'Sena Can', 12, 'K')"};
    //
    //    int count=0;
    //    for(String each:veri){
    //        count = count+ st.executeUpdate(each);
    //    }
    //       System.out.println(count + " satir eklendi");
    //
            //2. YOL

           /*  "addBatch" kelimesi genellikle veritabanı işlemleri için kullanılır. "Addbatch",
                          bir dizi işlemi aynı anda ya da topluca veritabanına eklemek anlamına gelir.
                          Bu yöntem, tek tek her işlemi eklemek yerine, birçok işlemi grup olarak ekleme
                          imkanı sağlar ve böylece işlem süresini azaltır  ve verimliliği arttırır.
                          Özellikle büyük veri işlemlerinde sıkça kullanılır.

          "executeBatch"  Java programlama dilinde JDBC (Java Database Connectivity) API'si   aracılığıyla
                          veritabanı işlemleri yaparken kullanılan bir metoddur.SQL ifadelerinin toplu halde
                          yürütülmesini  sağlar ve sorguların sonucunda etkilenen  satır sayısını döndürür.
                          Bu metot, aynı türden veya farklı türlerde birden fazla SQL ifadesinin toplu halde
                          çalıştırılmasına imkan tanır. Örneğin, INSERT INTO sorguları gibi benzer işlemler için
                          kullanılabilir. Bu şekilde, her bir sorgudan oluşan bir dizi işlemi tek seferde veritabanına
                          göndererek, işlem süresini kısaltmak ve performansı arttırmak mümkündür
                          Bu yöntem aynı zamanda birçok sorgunun işlenmesi sırasında oluşabilecek hataları
                          da algılayabilir ve bu hataların raporlanmasını sağlayabilir. Bu nedenle, büyük
                          ölçekli uygulamalarda sıkça kullanılan bir yöntemdir.   */


           String [] veri = {"insert into ogrenciler values (610, 'Sena Can', 12, 'K')",
                  "insert into ogrenciler values (611, 'Sena Can', 12, 'K')",
                    "insert into ogrenciler values (622, 'Sena Can', 12, 'K')"};

           for(String each: veri){
            st.addBatch(each);          //yukarıdaki dataların hepsini birleştirir
        }
           st.executeBatch();              //Dataları tek seferde gönderir.

            st.close();
            con.close();
        }
    }


