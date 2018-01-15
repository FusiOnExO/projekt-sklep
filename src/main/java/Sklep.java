public class Sklep {
    String Nazwa;
    int Ilosc;
    int CenaZl;
    int CenaGr;
    public Sklep(){}
    public Sklep(String n, int i, int cz, int cg){
        Nazwa = n;
        Ilosc = i;
        CenaZl = cz;
        CenaGr = cg;
    }
    public String getNazwa(){
        return Nazwa;
    }
    public int getIlosc(){
        return Ilosc;
    }
    public String getCena(){
        return CenaZl + "," + CenaGr + "PLN";
    }
    public int getZl(){
        return CenaZl;
    }
    public int getGr(){
        return CenaGr;
    }
    public void setIlosc(int il){
        if(Ilosc <= 0){
            System.out.println("Ilosc produktu nie moze byc mniejsza lub rowna 0");
        }
        else{
            Ilosc = il;
        }
    }
}
