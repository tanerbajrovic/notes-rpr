package ba.unsa.etf.rpr;

public class Sat {
    private int sati, minute, sekunde;
    public static void main(String[] args) {
        Sat s = new Sat(15, 30, 45);
        s.ispisi();
        s.sljedeci();
        s.ispisi();
        s.pomjeriZa(-48);
        s.ispisi();
        s.postavi(0,0,0);
        s.ispisi();
    }

    /** Konstrutkor za Sat */
    Sat(int sati, int minute, int sekunde) {
        postavi(sati, minute, sekunde);
    }

    /** Postavlja sate, minute i sekunde kao vrijeme */
    public void postavi(int sati, int minute, int sekunde) {
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }

    /** Povecava broj sekundi za 1*/
    public void sljedeci() {
        sekunde = sekunde + 1;
        if (sekunde == 60) {
            sekunde = 0;
            minute = minute + 1;
        }
        if (minute == 60) {
            minute = 0;
            sati = sati + 1;
        }
        if (sati == 24)
            sati = 0;
    }

    /** Smanjuje broj sekundi za 1 */
    public void prethodni() {
        sekunde = sekunde - 1;
        if (sekunde == -1) {
            sekunde = 59;
            minute = minute - 1;
        }
        if (minute == -1) {
            minute = 59;
            sati = sati - 1;
        }
        if (sati == -1) {
            sati = 23;
        }
    }

    /** Pomjera za proizvoljan broj sekundi kao 'pomak' */
    public void pomjeriZa(int pomak) {
        if (pomak > 0) {
            for (int i = 0; i < pomak; i++)
                sljedeci();
        }
        else {
            for (int i = 0; i < -pomak; i++)
                prethodni();
        }
    }

    /** Vraca broj sati */
    public int dajSate() {
        return sati;
    }

    /** Vraca broj minuta */
    public int dajMinute() {
        return minute;
    }

    /** Vraca broj sekundi */
    public int dajSekunde() {
        return sekunde;
    }

    /** Ispisuje vrijeme sata u satima, minutama, i sekundama */
    public void ispisi() {
        System.out.println("Sati: " + dajSate() + " Minute: "
            + dajMinute() + " Sekunde: " + dajSekunde());
    }
}


