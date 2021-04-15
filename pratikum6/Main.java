package pratikum6;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        // Perulangan untuk menambahkan printer
        while (true) {
            String merkPrinter = printer.tambahPrinter();
            if(merkPrinter.equals("")) {
                break;
            }
        }

        // Cek Jumlah Printer [EMPTY]
        if(!printer.cekPrinter()){
            return;
        }

        // Cek Data Teratas [PEEK]
        printer.peekPrinter();

        // hapus printer [DELETE]
        printer.hapusPrinter();

        // Perulangan untuk mencari printer [SEARCH]
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukan merk printer yang akan dicari (jika selesai input, kosongkan!!) [*SEARCH]= ");
            String namaPrinter = scanner.nextLine();
            if(namaPrinter.equals("")) {
                break;
            }
            laptop.cariPrinter(namaPrinter);
        }
    }
}
