package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KnowledgeRepository {

    private final ArrayList<Putusan> daftarPutusan;

    public KnowledgeRepository() {
        this.daftarPutusan = new ArrayList<>();
    }

    public void simpan(Putusan p) {
        this.daftarPutusan.add(p);
    }

    public Putusan cariByNomor(String nomor) {
        // Menggunakan Stream API untuk mencari berdasarkan nomor perkara
        return daftarPutusan.stream()
                .filter(p -> p.getNomorPerkara().equalsIgnoreCase(nomor))
                .findFirst()
                .orElse(null);
    }
    public ArrayList<Putusan> cariByNama(String nama) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        int i = 0;
        // Menggunakan while loop konvensional sebagai variasi
        while (i < daftarPutusan.size()) {
            Putusan p = daftarPutusan.get(i);
            if (p.getNamaTerdakwa().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(p);
            }
            i++;
        }
        return hasil;
    }

    public ArrayList<Putusan> filterByJenis(String jenis) {
        // Menggunakan Stream API untuk melakukan penyaringan data
        List<Putusan> filtered = daftarPutusan.stream()
                .filter(p -> p.getJenisNarkotika().equalsIgnoreCase(jenis))
                .collect(Collectors.toList());
        return new ArrayList<>(filtered);
    }

    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        // Menggunakan perulangan indeks tradisional (for-i)
        for (int i = 0; i < daftarPutusan.size(); i++) {
            Putusan p = daftarPutusan.get(i);
            if (p.getPengadilan().equalsIgnoreCase(pengadilan)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public boolean hapus(String nomor) {
        Putusan target = this.cariByNomor(nomor);
        if (target == null) {
            return false;
        }
        return this.daftarPutusan.remove(target);
    }

    public ArrayList<Putusan> getDaftarSemua() {
        return this.daftarPutusan;
    }

    public int getTotalData() {
        return this.daftarPutusan.size();
    }
    public void muatDataSampel() {
        String[] nama = {
                "Budi Santoso","Siti Aminah","Andi Wijaya","Rina Kartika","Joko Susanto",
                "Dewi Lestari","Agus Pratama","Maya Sari","Hendra Gunawan","Yuni Astuti",
                "Rudi Hartono","Lina Marlina","Tono Saputra","Wati Suryani","Bambang Setiawan",
                "Indah Permata","Eko Nugroho","Fitri Handayani","Dedi Kurniawan","Ratna Sari",
                "Slamet Riyadi","Putri Anggraini","Hadi Wibowo","Yanti Susilowati","Aris Munandar",
                "Lia Oktaviani","Wahyu Hidayat","Sri Wahyuni","Fajar Ramadhan","Nita Kurniasih",
                "Iwan Setiabudi","Diah Puspita","Yusuf Rahman","Erna Wulandari","Dani Firmansyah",
                "Wulan Sari","Bayu Aji","Tika Maharani","Anto Sucipto","Ika Nuraini",
                "Reza Pratama","Sinta Dewi","Gilang Ramadhan","Mira Yulianti","Doni Saputra",
                "Lestari Wulandari","Asep Hidayat","Ningsih Astuti","Firman Syah","Citra Permata"
        };
        String[] kotaArr = {"PN Surabaya","PN Jakarta Pusat","PN Bandung","PN Medan","PN Semarang",
                "PN Makassar","PN Denpasar","PN Yogyakarta","PN Malang","PN Palembang"};
        String[] jenisArr = {"Sabu-sabu","Ganja","Ekstasi","Heroin","Lainnya"};
        String[] peranArr = {"Bandar","Kurir","Pengguna","Penyimpan","Lainnya"};
        String[] pasalArr = {"Pasal 114 ayat (1) UU No. 35/2009","Pasal 112 ayat (1) UU No. 35/2009",
                "Pasal 127 ayat (1) UU No. 35/2009","Pasal 111 ayat (1) UU No. 35/2009"};
        String[] hakimArr = {"Hakim Andi Saputra","Hakim Maria Christina","Hakim Bambang Sutrisno",
                "Hakim Diah Permatasari","Hakim Rudi Wijaya"};

        for (int i = 0; i < nama.length; i++) {
            // Modifikasi perhitungan matematis (fungsi ekuivalen namun susunannya diubah)
            int umur = 19 + ((i * 3) % 36);
            double berat = 1.0 + (double)(i % 25) * 2.0;
            int vonis = 6 + (i % 20) * 6;
            double denda = 5000000.0 + (double)(i % 15) * 10000000.0;
            
            int day = (i % 28) + 1;
            int month = (i % 12) + 1;
            int year = 2023 + (i % 2);
            
            // Menggabungkan teks tanggal menggunakan concat / manual penulisan String format
            String tanggal = (day < 10 ? "0" : "") + day + "-" + (month < 10 ? "0" : "") + month + "-" + year;
            String nomor = String.format("%03d/Pid.Sus/%4d/PN", (i + 1), year);

            String kota = kotaArr[i % kotaArr.length];
            String jenis = jenisArr[i % jenisArr.length];
            String peran = peranArr[i % peranArr.length];
            String pasal = pasalArr[i % pasalArr.length];
            String hakim = hakimArr[i % hakimArr.length];

            Putusan p = new Putusan(nomor, kota, tanggal, nama[i], umur, jenis,
                    berat, pasal, peran, vonis, denda, hakim);
            this.daftarPutusan.add(p);
        }
    }
}

