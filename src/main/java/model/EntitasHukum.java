package model;

// Kelas abstrak sebagai induk untuk memenuhi syarat inheritance
public abstract class EntitasHukum {
    protected String pengadilan; // [cite: 63]

    public EntitasHukum(String pengadilan) {
        this.pengadilan = pengadilan;
    }

    public String getPengadilan() {
        return pengadilan;
    }

    // Method abstrak yang wajib di-override oleh kelas turunan
    public abstract void tampilkanRingkasan();
}