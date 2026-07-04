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

