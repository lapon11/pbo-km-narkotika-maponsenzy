package app;

import model.KnowledgeRepository;
import model.Putusan;
import view.ConsoleView;
import controller.KnowledgeController;
import util.InputHandler;

public class Main {
    // Method main dibuat seminimal mungkin hanya sebagai entry point utama [cite: 195, 196, 436]
    public static void main(String[] args) {
        // Instansiasi komponen MVC [cite: 380]
        KnowledgeRepository repository = new KnowledgeRepository();
        ConsoleView view = new ConsoleView();
        KnowledgeController controller = new KnowledgeController(repository, view);
        InputHandler inputHandler = new InputHandler();

        // Data Sampel Awal (Hand-coded sample minimal untuk keperluan demo kelompok) [cite: 90, 353, 354]
        repository.tambah(new Putusan("No.01/Pid.Sus/2026/PN.Sby", "PN Surabaya", "10-01-2026", "Budi Narkoba", 34, "Pasal 112 UU No.35/2009", "Penyimpan", 5.0, 1000000000.0)); // [cite: 52, 61, 74]
        repository.tambah(new Putusan("No.02/Pid.Sus/2026/PN.Sby", "PN Surabaya", "15-02-2026", "Siti Pengedar", 28, "Pasal 114 UU No.35/2009", "Bandar", 12.0, 2000000000.0)); // [cite: 52, 61, 74]

        int pilihan = 0;
        // Loop menu utama sistem (Tugas Controller/Main) [cite: 380]
        do {
            view.tampilkanMenuUtama();
            pilihan = inputHandler.readInt(""); // Membaca dengan proteksi try-catch util [cite: 401]

            switch (pilihan) {
                case 1:
                    controller.prosesTambahPutusan();
                    break;
                case 2:
                    controller.prosesTampilkanSemua();
                    break;
                case 3:
                    controller.prosesCariPutusan();
                    break;
                case 4:
                    controller.prosesHapusPutusan();
                    break;
                case 5:
                    controller.prosesTampilkanStatistik();
                    break;
                case 6:
                    view.cetakPesan("Terima kasih! Program KMS Narkotika ditutup.");
                    break;
                default:
                    view.cetakPesan("[Peringatan] Pilihan tidak valid! Masukkan angka 1 sampai 6.");
            }
        } while (pilihan != 6);
    }
}
