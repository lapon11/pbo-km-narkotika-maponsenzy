package model;

public class Putusan {

    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    private static int jumlahDibuat = 0;

    public Putusan() {
        // Menggunakan assignment langsung sebagai ganti penumpukan 'this()' constructor
        this.nomorPerkara = "";
        this.pengadilan = "";
        this.tanggalPutusan = "";
        this.namaTerdakwa = "";
        this.umurTerdakwa = 0;
        this.jenisNarkotika = "";
        this.beratBarangBukti = 0.0;
        this.pasalDilanggar = "";
        this.peranTerdakwa = "";
        this.vonisHukuman = 0;
        this.vonisDenda = 0.0;
        this.namaHakim = "";
    }
    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan,
                   String namaTerdakwa, int umurTerdakwa, String jenisNarkotika,
                   double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                   int vonisHukuman, double vonisDenda, String namaHakim) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;
        
        // Menggunakan operator assignment increment versi berbeda
        jumlahDibuat = jumlahDibuat + 1;
    }

    // Mengubah penulisan gaya inline getter setter ke baris baru agar beda secara visual
    public String getNomorPerkara() { 
        return this.nomorPerkara; 
    }
    public void setNomorPerkara(String nomorPerkara) { 
        this.nomorPerkara = nomorPerkara; 
    }

    public String getPengadilan() { 
        return this.pengadilan; 
    }
    public void setPengadilan(String pengadilan) { 
        this.pengadilan = pengadilan; 
    }
