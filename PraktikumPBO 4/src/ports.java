class MotherBoard {

    // static nested class
    static class USB{
        int usb2 = 2; // usb2 = 2
        int usb3 = 1; // usb3 = 1
        int getTotalPorts(){
            return usb2 + usb3;
        }
    }
 
 }

public class ports {
    public static void main(String[] args) {

       // Membuat objek dari kelas bertingkat statis
       // Menggunakan nama kelas luar
       MotherBoard.USB usb = new MotherBoard.USB();
       System.out.println("" + usb.usb2);
       System.out.println("" + usb.usb3);
       System.out.println("Total Ports = " + usb.getTotalPorts()); // getTotalPorts = usb2 + usb3 (2+1)
   }
    
}
