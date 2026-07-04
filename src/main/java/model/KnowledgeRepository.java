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

