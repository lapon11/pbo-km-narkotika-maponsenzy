package util;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String bacaTeks(String label) {
        while (true) {
            System.out.print(label + ": ");
            String input = this.scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong, coba lagi.");
        }
    }

    public int bacaAngka(String label) {
        int angka;
        while (true) {
            System.out.print(label + ": ");
            try {
                angka = Integer.parseInt(this.scanner.nextLine().trim());
                return angka;
            } catch (NumberFormatException e) {
                System.out.println("Itu bukan angka yang valid, coba lagi.");
            }
        }
    }

    public double bacaDesimal(String label) {
        while (true) {
            System.out.print(label + ": ");
            try {
                return Double.parseDouble(this.scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Itu bukan angka desimal yang valid, coba lagi.");
            }
        }
    }

    public int bacaPilihanMenu(String label, int min, int max) {
        boolean valid = false;
        int pilihan = 0;
        while (!valid) {
            pilihan = this.bacaAngka(label);
            if (pilihan >= min && pilihan <= max) {
                valid = true;
            } else {
                System.out.println("Pilihan harus antara " + min + " - " + max + ".");
            }
        }
        return pilihan;
    }
}
