package calcolaRadice;

public class Complesso {
    double reale;
    double immaginario;

    public Complesso calcolaRadice(int n, int i) {
        double modulo = Math.sqrt(reale*reale + immaginario*immaginario); //il modulo di un vettore lo calcolo con pitagora
        double r = Math.pow(modulo, (double) 1/n); //ottengo il valore di r, facendo una semplice radice n-esima di un numero positivo.
        double radianti = Math.acos(reale/modulo); // termine_reale = modulo * cos(angolo) -> angolo = arcocoseno(termine_reale/modulo)
        Complesso radice = new Complesso();

        double coseno = Math.cos(radianti/n + i*2*Math.PI/n); //i rappresenta la classe di resto i in modulo n (è un valore che va da 0 a n-1)
        double seno = Math.sin(radianti/n + i*2*Math.PI/n);
        radice.reale = r * coseno; 
        radice.immaginario = r * seno;

        //la parte che segue serve solo per arrotondare il valore ottenuto.

        if(Math.abs(Math.abs(radice.reale) - Math.abs(Math.round(radice.reale))) < 0.001) {
            radice.reale = Math.round(radice.reale);
        }
        if(Math.abs(Math.abs(radice.immaginario) - Math.abs(Math.round(radice.immaginario))) < 0.001) {
            radice.immaginario = Math.round(radice.immaginario);
        } 

        return radice;

    }
}
