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
    public String getTanggalPutusan() { 
        return this.tanggalPutusan; 
    }
    public void setTanggalPutusan(String tanggalPutusan) { 
        this.tanggalPutusan = tanggalPutusan; 
    }

    public String getNamaTerdakwa() { 
        return this.namaTerdakwa; 
    }
    public void setNamaTerdakwa(String namaTerdakwa) { 
        this.namaTerdakwa = namaTerdakwa; 
    }

    public int getUmurTerdakwa() { 
        return this.umurTerdakwa; 
    }
    public void setUmurTerdakwa(int umurTerdakwa) {
        if (umurTerdakwa > 0) {
            this.umurTerdakwa = umurTerdakwa;
        }
    }

    public String getJenisNarkotika() { 
        return this.jenisNarkotika; 
    }
    public void setJenisNarkotika(String jenisNarkotika) { 
        this.jenisNarkotika = jenisNarkotika; 
    }

    public double getBeratBarangBukti() { 
        return this.beratBarangBukti; 
    }
    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti > 0) {
            this.beratBarangBukti = beratBarangBukti;
        }
    }
public String getPasalDilanggar() { 
        return this.pasalDilanggar; 
    }
    public void setPasalDilanggar(String pasalDilanggar) { 
        this.pasalDilanggar = pasalDilanggar; 
    }

    public String getPeranTerdakwa() { 
        return this.peranTerdakwa; 
    }
    public void setPeranTerdakwa(String peranTerdakwa) { 
        this.peranTerdakwa = peranTerdakwa; 
    }

    public int getVonisHukuman() { 
        return this.vonisHukuman; 
    }
    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman >= 0) {
            this.vonisHukuman = vonisHukuman;
        }
    }

    public double getVonisDenda() { 
        return this.vonisDenda; 
    }
    public void setVonisDenda(double vonisDenda) {
        if (vonisDenda >= 0) {
            this.vonisDenda = vonisDenda;
        }
    }

    public String getNamaHakim() { 
        return this.namaHakim; 
    }
    public void setNamaHakim(String namaHakim) { 
        this.namaHakim = namaHakim; 
    }

    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    public void tampilkan() {
        // Memanfaatkan printf sebagai pengganti konkatenasi string biasa (+)
        System.out.printf("%s | %s | %s\n", this.nomorPerkara, this.namaTerdakwa, this.jenisNarkotika);
    }

    public void tampilkan(boolean detail) {
        if (detail) {
            System.out.println("Nomor Perkara   : " + this.nomorPerkara);
            System.out.println("Pengadilan      : " + this.pengadilan);
            System.out.println("Tanggal Putusan : " + this.tanggalPutusan);
            System.out.println("Nama Terdakwa   : " + this.namaTerdakwa + " (" + this.umurTerdakwa + " tahun)");
            System.out.println("Jenis Narkotika : " + this.jenisNarkotika);
