1. Deskripsi Aplikasi

Aplikasi ini bernama “KMS (Knowledge Management System) Putusan Narkotika”. Aplikasi ini dibangun menggunakan bahasa pemrograman Java dengan menerapkan arsitektur MVC (Model-View-Controller) berbasis teks (Console/CLI Interface).

Tujuan utama dari sistem ini adalah untuk mengelola, menyaring (filter), mengarsipkan, serta menghitung analisis statistik data putusan pengadilan terkait kasus narkotika secara dinamis di dalam memori komputer.

2. Cara Kompilasi 

Proses kompilasi manual menggunakan Terminal/Command Prompt mengharuskan struktur folder Anda sesuai dengan nama deklarasi package pada kode.

Langkah 1: Persiapan Struktur Folder

Pastikan file-file .java Anda berada di dalam folder yang bernama sama persis dengan nama package-nya:

projek-kms
 ┣ app
 ┃ ┗ Main.java
 ┣ controller
 ┃ ┗ KnowledgeController.java
 ┣ model
 ┃ ┣ KnowledgeRepository.java
 ┃ ┣ Putusan.java
 ┃ ┗ StatistikPutusan.java
 ┣ util
 ┃ ┣ DataTidakValidException.java
 ┃ ┗ InputHandler.java
 ┗ view
   ┗ ConsoleView.java

Langkah 2: Eksekusi Perintah Javac

Buka Terminal/Command Prompt, arahkan directory aktif ke folder utama (projek-kms), lalu ketik perintah kompilasi berikut sesuai dengan sistem operasi Anda:

• Windows (Command Prompt):
cmd
javac app/Main.java controller/KnowledgeController.java model/.java util/.java view/ConsoleView.java


* Linux / macOS / Git Bash:
bash
javac app/Main.java controller/KnowledgeController.java model/.java util/.java view/ConsoleView.java


Catatan: Jika berhasil, perintah di atas tidak akan memunculkan teks pesan apa pun, namun akan menciptakan file biner berkstensi .class di samping setiap file .java.

3. Cara Menjalankan (Running)

Setelah proses kompilasi sukses, jalankan aplikasi dari posisi folder utama (projek-kms) menggunakan perintah java diikuti dengan nama package dan kelas utamanya:

bash
java app.Main

Jalur Pintas (Menggunakan IDE)
1) Buat projek baru dan letakkan folder-folder package di atas ke dalam direktori utama kode sumber (src).
2) Buka file Main.java di dalam folder package app.
3) Klik tombol hijau berikon Run atau klik kanan lalu pilih Run 'Main.main()'.

4. Link Youtube
https://youtu.be/xF1JEfaCnsQ?si=uTtsCr-X9ZIw5-CL

5. Anggota Kelompok 
• Fincensius Palloti Dou 202510370110019
• ⁠Lalu Muhammad Nauval Aulia Hanzain 202510370110047
• ⁠Amanda Dwi Syahyeti 202510370110054
