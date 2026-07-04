package model;

public abstract class EntitasHukum {
    protected String pengadilan; // [cite: 63]

    public EntitasHukum(String pengadilan) {
        this.pengadilan = pengadilan;
    }

    public String getPengadilan() {
        return pengadilan;
    }

    public abstract void tampilkanRingkasan();
}
