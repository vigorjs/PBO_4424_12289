/*
Virgo Fajar Pamungkas - A11.2019.12289
*/
package com.a11_2019_12289;
public class Operasi
{
    public void menu()
    {
        System.out.println("\n====================");
        System.out.println("Kalkulator Sederhana");
        System.out.println("1.Penjumlahan");
        System.out.println("2.Pengurangan");
        System.out.println("3.Perkalian");
        System.out.println("4.Pembagian");
        System.out.println("5.Modulus");
        System.out.print("Masukan Pilihan Anda = ");
    }


    public float operasiAritmatika(int pilihan, float nom1, float nom2)
    {
        float total = 0;
        switch (pilihan)
        {
            case 1:
                System.out.println(+nom1 + " + " + nom2);
                System.out.print("Hasilnya = ");
                total = nom1 + nom2;
                break;
            case 2:
                System.out.println(+nom1 + " - " + nom2);
                System.out.print("Hasilnya = ");
                total = nom1 - nom2;
                break;
            case 3:
                System.out.println(+nom1 + " x " + nom2);
                System.out.print("Hasilnya = ");
                total = nom1 * nom2;
                break;
            case 4:
                System.out.println(+nom1 + " : " + nom2);
                System.out.print("Hasilnya = ");
                total = nom1 / nom2;
                break;
            case 5:
                System.out.println(+nom1 + " % " + nom2);
                System.out.print("Hasilnya = ");
                total = nom1 % nom2;
                break;

        }
        return total;
    }

}
