package calcolaRadice;

public class Complesso {
    double reale;
    double immaginario;

    static public Complesso calcolaRadice(Complesso termine, int n, int i) {
        double modulo = Math.sqrt(termine.reale*termine.reale + termine.immaginario*termine.immaginario);
        double r = Math.pow(modulo, (double) 1/n);
        double radianti = Math.acos(termine.reale/modulo);
        Complesso radice = new Complesso();

        double coseno = Math.cos(radianti/n + i*2*Math.PI/n);
        double seno = Math.sin(radianti/n + i*2*Math.PI/n);
        radice.reale = r * coseno;
        radice.immaginario = r * seno;

        if(Math.abs(Math.abs(radice.reale) - Math.abs(Math.round(radice.reale))) < Double.MIN_VALUE) {
            radice.reale = Math.round(radice.reale);
        }
        if(Math.abs(Math.abs(radice.immaginario) - Math.abs(Math.round(radice.immaginario))) < Double.MIN_VALUE) {
            radice.immaginario = Math.round(radice.immaginario);
        } 

        return radice;

    }
}
