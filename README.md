# Reflection 1
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


# Reflection 2
1. Setelah mencoba membuat unit-test, saya memahami inti dari fungsionalitas program. Kasus-kasus yang dibuat menjadi indikator seberapa berfungsi kode. Jumlah unit-test yang dibuat bergantung pada kompleksitas dan ukuran program. Saya menggunakan kasus negatif dan positif untuk mengecek program, namun masih ada kemungkinan adanya bug atau error.

2. Pembuatan functional test yang baru dengn setup procedures and instance variables yang sama bisa menimbulkan masalah clean code seperti duplikasi kode dan pelanggaran Single Responsibility Principle. Untuk mengatasi hal ini, solusi yang dilakukan yakni dengan melakukan pemisahan setup procedure di file yang berbeda.
