package app;

import controller.KnowledgeController;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        KnowledgeController mainController = new KnowledgeController();
        mainController.muatDataAwal();

        ConsoleView mainView = new ConsoleView(mainController);
        mainView.mulai();
    }
}

package view;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;
import util.DataTidakValidException;
import java.util.ArrayList;

public class ConsoleView {

    private final KnowledgeController controller;
    private final InputHandler input;

    public ConsoleView(KnowledgeController controller) {
        this.controller = controller;
        this.input = new InputHandler();
    }

    public void mulai() {
        int pilihan;
        do {
            this.tampilkanMenu();
            pilihan = this.input.bacaPilihanMenu("Pilih menu", 1, 7);
            
            // Re-strukturisasi pemanggilan metode didalam switch-case block
            switch (pilihan) {
                case 1 -> this.prosesTambahData();
                case 2 -> this.prosesLihatSemua();
                case 3 -> this.prosesCariData();
                case 4 -> this.prosesFilterData();
                case 5 -> this.prosesHapusData();
                case 6 -> this.prosesStatistik();
                case 7 -> System.out.println("Sampai jumpa!");
            }
        } while (pilihan != 7);
    }

    private void tampilkanMenu() {
        System.out.print("\n===== KMS PUTUSAN NARKOTIKA =====\n" +
                "1. Tambah Data\n" +
                "2. Lihat Semua Data\n" +
                "3. Cari Data\n" +
                "4. Filter Data\n" +
                "5. Hapus Data\n" +
                "6. Lihat Statistik\n" +
                "7. Keluar\n");
    }

    private void tampilkanDaftar(ArrayList<Putusan> daftar) {
        if (daftar == null || daftar.isEmpty()) {
            System.out.println("Tidak ada data.");
            return;
        }
        // Menggunakan method reference `forEach` sebagai bentuk variasi perulangan list
        daftar.forEach(Putusan::tampilkan);
    }

    private void prosesTambahData() {
        String nomorPerkara = this.input.bacaTeks("Nomor Perkara");
        String pengadilan = this.input.bacaTeks("Pengadilan");
        String tanggalPutusan = this.input.bacaTeks("Tanggal Putusan");
        String namaTerdakwa = this.input.bacaTeks("Nama Terdakwa");
        int umurTerdakwa = this.input.bacaAngka("Umur Terdakwa");
        String jenisNarkotika = this.input.bacaTeks("Jenis Narkotika");
        double beratBarangBukti = this.input.bacaDesimal("Berat Barang Bukti (gram)");
        String pasalDilanggar = this.input.bacaTeks("Pasal Dilanggar");
        String peranTerdakwa = this.input.bacaTeks("Peran Terdakwa");
        int vonisHukuman = this.input.bacaAngka("Vonis Hukuman (bulan)");
        double vonisDenda = this.input.bacaDesimal("Vonis Denda (rupiah)");
        String namaHakim = this.input.bacaTeks("Nama Hakim");

        Putusan p = new Putusan(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa,
                umurTerdakwa, jenisNarkotika, beratBarangBukti, pasalDilanggar,
                peranTerdakwa, vonisHukuman, vonisDenda, namaHakim);

        try {
            this.controller.tambahData(p);
            System.out.println("Data berhasil ditambahkan.");
        } catch (DataTidakValidException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
    }

    private void prosesLihatSemua() {
        ArrayList<Putusan> semuaData = this.controller.getSemuaData();
        this.tampilkanDaftar(semuaData);
    }

    private void prosesCariData() {
        System.out.println("Cari berdasarkan: 1) Nomor Perkara  2) Nama Terdakwa");
        int opsi = this.input.bacaPilihanMenu("Pilih", 1, 2);
        
        if (opsi == 1) {
            String nomor = this.input.bacaTeks("Nomor Perkara");
            Putusan hasil = this.controller.cariData(nomor);
            if (hasil == null) {
                System.out.println("Data tidak ditemukan.");
            } else {
                hasil.tampilkan(true);
            }
        } else {
            String nama = this.input.bacaTeks("Nama Terdakwa");
            ArrayList<Putusan> hasilNama = this.controller.cariByNama(nama);
            this.tampilkanDaftar(hasilNama);
        }
    }

    private void prosesFilterData() {
        System.out.println("Filter berdasarkan: 1) Jenis Narkotika  2) Pengadilan");
        int kriteria = this.input.bacaPilihanMenu("Pilih", 1, 2);
        
        if (kriteria == 1) {
            String jenis = this.input.bacaTeks("Jenis Narkotika");
            this.tampilkanDaftar(this.controller.filterByJenis(jenis));
        } else {
            String pengadilan = this.input.bacaTeks("Nama Pengadilan");
            this.tampilkanDaftar(this.controller.filterByPengadilan(pengadilan));
        }
    }

    private void prosesHapusData() {
        String nomor = this.input.bacaTeks("Nomor Perkara yang dihapus");
        boolean statusHapus = this.controller.hapusData(nomor);
        if (statusHapus) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private void prosesStatistik() {
        StatistikPutusan statistik = this.controller.getStatistik();
        statistik.tampilkanLaporan();
    }
}
