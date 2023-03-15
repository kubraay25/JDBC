import java.sql.*;

public class Query01 {

     /*     --> intellijde "main" kismini developerlar "test" kismini "qa" lar kullaniyorlar :))

            --> "pom.xml" dosyasi: butun projelerde bu dosya mevcuttur
    projenin kalbidir

    */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // exception'larimizi atariz.

        /* 1. Adım:Driver 'a kaydol
                   Driver Tanimlama: Burda hangi sorgu dili programini kullandigimizi tanimlariz */

        Class.forName("org.postgresql.Driver");

        /* 2. Adım:Database 'e bağlan:(DriverManager)
                   Kullandigimiz sorgulama programindaki databace bilgilerini
                   cekmek icin kullaniriz.(pgADMIN'e baglandigimiz kisim)
                   DriverManager:database ile iletisimimizi saglar
                   */


        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbj",
                "postgres",
                "6789");

        /* 3. Adım:Statement oluştur.
                  Statement: Hangi tablodaki bilgileri cekmek istersek o tabloyu "select"
                             ifadesiyle cekmeye caliisiriz ve tablodaki sutunlarimizda girmis oldugumuz
                             bilgileri aldigimiz yerdir */

        Statement st = con.createStatement();


        /* 4. Adim: ResultSet */

        ResultSet veri = st.executeQuery("select * from ogrenciler");

        /*  --> Asagida while'in icine (veri.next) deyip butun datalarimi pgAdminimden cekiyorum
            --> getString kullaniyorum cunku sutundaki datalarim stringi ifadeler
            --> getInt kullaniyorum cunku o sutundaki ifadeler sayili ifadeler
            --> "columindex" icerisinde belirttigimiz rakam kacinci sutun oldugunu gosterir
            --> "columindex" buraya kacinci sutun yazabilecegimiz gibi sutunun adinida yazabiliriz
            --> Burada "veri" olarak tanimladigimiz pgAdminde tablomuzda olan tum bilgilerimizdir
            --> Her "next" dedigimizde satirdaki bilgileri topladiktan sonra diger satirdaki
            bilgileri toplamaya gecer ve butun bilgileri bu sekilde toplar
            --> printf: '\n' yeni bir satıra geçmek için kullanılır.
         */

        while (veri.next()) {

            System.out.println('\n' + veri.getInt(1)+" "
                    + '\n' + veri.getString(2)
                    + '\n' + veri.getString(3)
                    + '\n' + veri.getString(4));

        }

        // asagidaki ifadeleri yazdigimizda connectionlari(baglantilarimizi) kapatmis olacagiz
        con.close();
        st.close();
        veri.close();


    }
}
