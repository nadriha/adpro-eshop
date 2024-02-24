<details>

<summary>Tutorial 1</summary>

## Reflection 1
### Implementasi Clean Code
1. Penamaan variabel
    - Memberikan nama pada variabel yang mencerminkan tujuan dan fungsinya, sehingga mudah dipahami.
    - Menggunakan penamaan yang sesuai dengan peran variabel atau fungsi, seperti menggunakan PascalCase untuk class dan camelCase untuk variabel.

2. Function
    - Membuat fungsi yang pendek, hanya mengerjakan satu task dan terstruktur dengan baik.
    - Memilih nama yang mencerminkan tujuan dan fungsi.
    - Membuat fungsi yang tidak memiliki side effects kepada program.

3. Secure Coding
    - ID produk menggunakan UUID yang dibuat unik dan sulit ditebak


## Reflection 2
1. Setelah mencoba membuat unit-test, saya memahami inti dari fungsionalitas program. Kasus-kasus yang dibuat menjadi indikator seberapa berfungsi kode. Jumlah unit-test yang dibuat bergantung pada kompleksitas dan ukuran program. Saya menggunakan kasus negatif dan positif untuk mengecek program, namun masih ada kemungkinan adanya bug atau error.

2. Pembuatan functional test yang baru dengn setup procedures and instance variables yang sama bisa menimbulkan masalah clean code seperti duplikasi kode dan pelanggaran Single Responsibility Principle. Untuk mengatasi hal ini, solusi yang dilakukan yakni dengan melakukan pemisahan setup procedure di file yang berbeda.

</details>

<details>
<summary>Tutorial 2</summary>

## Reflection
### Code Quality Issue(s)
1.  Remove unnecessary modifier  
    ProductService sebelumnya terdapat menuliskan modifier public untuk setiap method. Tetapi karena ProductService adalah interface, maka by default semua method yang dimiliki ProductService adalah public abstract

2.  Change unused import 'org.springframework.web.bind.annotation.*'
    Karena annotation yang digunakan tidak terlalu banyak, tidak harus mengimport semua annotation

3.  Returning the value vs storing it in local variables
    Menghindari pembuatan variabel lokal yang tidak perlu.

### CI/CD workflows
Menurut pendapat saya, kode yang telah saya buat telah memenuhi definisi CI/CD. Saat mengintegrasikan perubahan kode ke dalam repositori, CI adalah proses di mana kita melakukan pengujian terhadap kode tersebut. Sedangkan CD adalah proses deployment. Dengan menggunakan GitHub workflows, program saya dapat menjalani testing setiap kali ada push ke suatu branch. Sebagai contoh, pada alur kerja CI workflow, testing pada kode dilakukan dengan unit test menggunakan Gradle. Selain itu, PMD workflow sebagai code analysis tool juga menjalankan testing pada kode dengan melakukan analisis kode. Kode yang telah lulus semua tes tersebut, jika dipush dan digabungkan ke branch main akan secara otomatis di deploy ke PaaS Koyeb.

</details>

# Tutorial 3
## Reflection
### SOLID Principles
-   **Single Responsibility Principle (SRP)**  
    Sebuah kelas hanya memiliki satu tugas, atau fokus pada satu tujuan tertentu  
    Implementasi: Pemisahan code `CarController.java` pada package `controller` 
-   **Open-Closed Principle (OCP)**  
    Objek atau entitas harus terbuka untuk ekstensi tetapi ditutup untuk modifikasi  
    Implementasi:
-   **Interface Segregation Principle (ISP)**  
    Implementasi: Pemisahan interface `CarService.java` dan `ProductService.java` yag dipisahkan sesuai dengan penggunaannya.
-   **Dependency Inversions Principle (DIP)**  
    Modul tingkat tinggi tidak boleh tergantung pada modul tingkat rendah. Keduanya harus bergantung pada abstraksi.
    Implementasi: Pada `CarController.java`, penggunaan `carService` dari class `CarServiceImpl` diganti menjadi dari intervace `CarService`
      

### SOLID Principles Advantages  
SOLID Principle membantu dalam membuat kode yang lebih terstruktur dan mudah dipahami. Selain itu, SOLID Principle memudahkan penambahan fungsi baru tanpa perlu mengubah fungsi yang sudah ada, sehingga mengurangi risiko munculnya masalah pada kode dan juga memudahkan proses testing, karena setiap komponen dapat diuji secara independen. SOLID Principle juga membuat kode yang kita tulis dapat lebih mudah dipahami sehingga membuat kode yang ditulis lebih mudah dikembangkan oleh developer lain. 

### SOLID Principles Disadvantages
Kekurangan yang terdapat pada SOLID Principles adalah membuat kode menjadi terlalu kompleks dan lebih *strict*. Contohnya, jika ingin mengubah fungsionalitas suatu kelas, abstract class/interface yang memiliki tanggung jawab untuk menangani perilaku tersebut juga harus diubah. Selain itu, jika SOLID Principle belum diterapkan, bisa menjadi sulit untuk menggunakan dan mengembangkan kode pengembang lain.


