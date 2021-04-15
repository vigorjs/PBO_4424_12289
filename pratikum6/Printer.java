package pratikum6;
import java.util.Scanner;
import java.util.Stack;

public class Printer {
    Stack<String> daftarPrinter;
    Printer(){
        daftarPrinter = new Stack<String>();
    }

    public String tambahHandphone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan merk Printer (jika selesai input, kosongkan!!) [*PUSH]= ");
        String merkPrinter = scanner.nextLine();
        if(merkPrinter.equals("")) {
            return merkPrinter;
        }
        this.daftarPrinter.push(merkPrinter);
        return  merkPrinter;
    }

    public void hapusPrinter() {
        String mantanPrinter = this.daftarPrinter.pop();
        System.out.println(mantanPrinter + " baru saja dihapus dari Daftar Printer [*POP]");
    }

    public boolean cekPrinter() {
        if(this.daftarPrinter.empty()) {
            System.out.println("Daftar Printer Kosong !!! [*EMPTY]");
            return false;
        }
        System.out.println("Daftar Printer ada " + this.daftarPrinter.size() + " Printer [*EMPTY]");
        return true;
    }

    public void peekPrinter() {
        String newHandphone = this.daftarPrinter.peek();
        System.out.println(newHandphone + " adalah Printer yang paling terbaru (PEEK)");
    }

    public void cariPrinter(String namaPrinter) {
        Integer pos = (Integer) daftarPrinter.search(namaPrinter);
        if(pos == -1) {
            System.out.println(namaPrinter + " tidak tersedia [*SEARCH]");
            return;
        }
        System.out.println(namaPrinter + " ditemukan [*SEARCH]");
    }

}
