# Kutuphane
## Geliştirilme Ortamı
Java Geliştirme Ortamı Bulunan **NetBeans** ile yazıldı.<br>
![NetBeans Resmi](https://github.com/ulusoyomer/Kutuphane/blob/master/img/netbeans11.PNG)
### Kullanılan Kütüphaneler
JAVA dilinde bulunan ve grafiksel kullanıcı ara yüzü geliştirmekte kullanılan **SWING** kütüphanesi ve Java Programlama dilinin, 
platformdan bağımsız, görsel kullanıcı arayüzü üretimini sağlayan araç kütüphanesi olan **AWT**
Kullanıldı.Ayrıca veritabanı baglantısı için **mysql-connector** kütüphanesi ve kullanım kolaylığı saglamak için **jcalendar** kütüphaneleri
eklendi.
#### VeriTabanı
![VeriTabanı](https://github.com/ulusoyomer/Kutuphane/blob/master/img/xampp.PNG)<br>
Veritabanı olarak mysql phpmyadmin kullanıldı. Xampp programını kullanarak veritabanımızı oluşturduk.
#### Giriş Ekranı
![Giriş Ekranı](https://github.com/ulusoyomer/Kutuphane/blob/master/img/giris.PNG)<br>
Giriş Ekranımızda kullanıcı adımız ve şifremiz bulunmakta kayıtlı admin tablomuzdaki kullanıcılar ile eşleşerek giriş yapılmaktadır.<br>
![Giriş Ekranı](https://github.com/ulusoyomer/Kutuphane/blob/master/img/ghata.PNG)<br>
Kullanıcı Bulunamadığında görseldeki gibi uyarı mesajları çıkmaktadır.
### Ana Pencere
![Ana Pencere](https://github.com/ulusoyomer/Kutuphane/blob/master/img/first.PNG)<br>
Girişimizi yaptıktan sonra karşımıza böyle bir ekran gelmektedir.Yukarıdaki Kitap Üyeler ve Alınmış Kitaplar butonlarına tıklayarak 
tablolarına ulaşılabilmektedir.Butonların altındaki beyaz kutu ise tablolarda arama yapmamızı saglar. Sol taraftaki kısım ise yeni bir 
üye eklemek, kitap eklmeek, kitap silmek, üye silmek, veya üye ve kitap güncelleme işlemleri yapılabilir.Bir üyeye kitap verme veya 
kitabın geri alınıp kütüphaneye konulması işlemleride yapılmaktadır.
### İşlemler
![Seçim Ekranı](https://github.com/ulusoyomer/Kutuphane/blob/master/img/secim.PNG)<br>
Bir kitabı üyeye vermek için üye tablosundan bir üye ve kitap tablosundan bir kitap seçilir. Seçilen kitap ve üye bilgileri sol taraftaki
kutulara aktarılır. Burada istenirse kitap veya üye hakkında güncellemede yapılabilir. Kitap ve üyeyi seçtikten sonra kitap ver butonuna
tıklandıktan sonra şöyle bir ekran karşımıza gelir. <br>
![Kitap Ver](https://github.com/ulusoyomer/Kutuphane/blob/master/img/kitapverme.PNG)<br>
Burada gireceğimiz tarih uygun formatta ve bugunden sonraki bir gun olmak zorundadır.<br>
![Kitap Ver](https://github.com/ulusoyomer/Kutuphane/blob/master/img/hata.PNG)<br>
Uygun şekilde giriş yapılmassa hata mesajları çıkacaktır. Kitap verilme işlemi tamamlandıktan sonra bir kitap birden fazla kişide olamayacagı
için kitap tablosunda gözükmez. Verilen Kitap tablosunda alan üyenin bilgileri ve geri veriş tarihi ile görüntülenir.<br>
![Alınmıs Kitap](https://github.com/ulusoyomer/Kutuphane/blob/master/img/al%C4%B1nm%C4%B1skitap.PNG)<br>
Bu tabloda alınış ve geri veriş tarihide bulunmaktadır. Eğer geri veriş tarihinin günü geçmiş ise durum kısmında süre dolmuş olarak gözükür.
Geri verme işlemi için gerekli kayıdın üstüne tıklanır ve sol taraftan geri al butonuna tıklanarak kitabın üyeyle baglantısı kesilmiş olur.

