import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.List;

public class Main {
    public static List<Sklep> produkty;
    public static int licznik;
    public static void main(String[] args) throws IOException{
        WczytajDane();
        Menu();
    }
    public static void Menu() throws IOException {
        System.out.println("1 Kup produkt");
        System.out.println("2 Magazyn");
        System.out.println("3 Wyjdz");
        Scanner wczytywanie = new Scanner(System.in);
        int opcja;
        opcja = wczytywanie.nextInt();
        switch(opcja) {
            case 1:
                Kup();
                break;
            case 2:
                Magazyn();
                break;
            case 3:
                Wyjdz();
        }
    }
    public static void WczytajDane() throws IOException {
        File file = new File("src/main/resources/sklep.txt");
        Scanner in = new Scanner(file);
        licznik = 0;
        Sklep tymczas;
        produkty = new ArrayList<Sklep>();
        while(in.hasNext() != false) {
            tymczas = new Sklep(in.nextLine(), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
            produkty.add(tymczas);
            licznik++;
        }
        in.close();
    }
    public static void Wyjdz(){
        System.exit(0);
    }
    public static void Magazyn() throws IOException{
        for(int i=0; i<licznik; i++) {
            System.out.println(produkty.get(i).getNazwa() + " " + produkty.get(i).getCena() + " " + produkty.get(i).getIlosc() + "szt");
        }
        System.out.println("0 Wroc do menu");
        Scanner wczytaj = new Scanner(System.in);
        int opcja;
        opcja = wczytaj.nextInt();
        while(opcja != 0){
            System.out.println("Nieprawidlowy numer");
            System.out.println("0 Wroc do menu");
            opcja = wczytaj.nextInt();
        }
        Menu();
    }
    public static void Kup() throws IOException {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Wybierz produkt");
        for(int i =0; i<licznik; i++) {
            System.out.println(i + " " + produkty.get(i).getNazwa() + " " + produkty.get(i).getCena() + " " + produkty.get(i).getIlosc() + "szt");
        }
        int opcja = wczytaj.nextInt();
        if(opcja < licznik && opcja >= 0)
        {
            if(produkty.get(opcja).getIlosc() != 0) {
                produkty.get(opcja).setIlosc(produkty.get(opcja).getIlosc() - 1);
                System.out.println("Zakupiono: " + produkty.get(opcja).getNazwa() + " za " + produkty.get(opcja).getCena());
                PrintWriter zakup = new PrintWriter("src/main/resources/sklep.txt");
                for(int i=0; i<licznik; i++){
                    zakup.println(produkty.get(i).getNazwa() + "\n" + produkty.get(i).getIlosc() + "\n" + produkty.get(i).getZl() + "\n" + produkty.get(i).getGr());
                }
                zakup.close();
            }
            else{
                System.out.println("Chwilowy brak towaru");
            }
        }
        else
        {
            System.out.println("Nieprawidlowy numer produktu");
        }
        System.out.println("0 Wroc do menu");
        int opcja2 = wczytaj.nextInt();
        while(opcja2 != 0){
            System.out.println("Nieprawidlowy numer");
            System.out.println("[0] - Powrot do menu glownego");
            opcja2 = wczytaj.nextInt();
        }
        Menu();
    }
}
