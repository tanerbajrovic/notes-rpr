package ba.unsa.etf.rpr;

public class Sat {
    int sati, minute, sekunde;

    public static void main(String[] args) {
        Sat s = new Sat(15, 30, 45);
        // s.Ispisi();
        // s.Sljedeci();
    }

    Sat(int sati, int minute, int sekunde) {
        Postavi(sati, minute, sekunde);
    }

    public void Sljedeci() {
        sekunde++;
        if (sekunde == 60) {
            sekunde = 0;
            minute++;
        }
        if (minute == 60) {
            minute = 0;
            sati++;
        }
        if (sati == 24)
            sati = 0;
    }

    void Prethodni() {
        sekunde--;
        if (sekunde == -1) {

        }
    }

    public void Postavi(int sati, int minute, int sekunde) {
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }
}


