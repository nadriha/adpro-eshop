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

# Tutorial 2
## Reflection 1
### Code Quality Issue(s)
1.  Remove unnecessary modifier  
    ProductService sebelumnya terdapat menuliskan modifier public untuk setiap method. Tetapi karena ProductService adalah interface, maka by default semua method yang dimiliki ProductService adalah public abstract

2.  Change unused import 'org.springframework.web.bind.annotation.*'
    Karena annotation yang digunakan tidak terlalu banyak, tidak harus mengimport semua annotation

3.  Returning the value vs storing it in local variables
    Menghindari pembuatan variabel lokal yang tidak perlu.

### CI/CD workflows
Menurut pendapat saya, kode yang telah saya buat telah memenuhi definisi CI/CD. Saat mengintegrasikan perubahan kode ke dalam repositori, CI adalah proses di mana kita melakukan pengujian terhadap kode tersebut. Sedangkan CD adalah proses deployment. Dengan menggunakan GitHub workflows, program saya dapat menjalani testing setiap kali ada push ke suatu branch. Sebagai contoh, pada alur kerja CI workflow, testing pada kode dilakukan dengan unit test menggunakan Gradle. Selain itu, PMD workflow sebagai code analysis tool juga menjalankan testing pada kode dengan melakukan analisis kode. Kode yang telah lulus semua tes tersebut, jika dipush dan digabungkan ke branch main akan secara otomatis di deploy ke PaaS Koyeb.




