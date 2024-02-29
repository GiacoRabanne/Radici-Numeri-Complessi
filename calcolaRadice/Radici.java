package calcolaRadice;
import fond.io.*;


public class Radici {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        Complesso radicando = new Complesso();
        radicando.reale = in.readDouble("Inserisci la parte reale del radicando:");
        
        radicando.immaginario = in.readDouble("Inserisci la parte complessa del radicando:");

        int n = in.readInt("Inserisci il grado della radice da calcolare");
        OutputWindow out = new OutputWindow("Radici Calcolate");
        out.setFont("SF Pro Display", 20);
        out.writeln("Radici calcolate:\n");

        for(int i = 0; i < n; i++) {
            out.write("X"+ (i+1) + " = ");
            boolean trovato = false;
            if(Math.abs(radicando.calcolaRadice(n, i).reale) > 0.001){
                out.write(radicando.calcolaRadice(n, i).reale);
                trovato = true;
            }

            if(Math.abs(radicando.calcolaRadice(n, i).immaginario) > 0.001){
                if(radicando.calcolaRadice(n, i).immaginario < 0) {
                    out.write(" -");
                } else if(trovato) {
                    out.write(" +");
                }
                out.write("i");
                if(Math.abs(radicando.calcolaRadice(n, i).immaginario) != 1.0 ) {
                    out.write("*(" + Math.abs(radicando.calcolaRadice(n, i).immaginario) + ")");
                }
                
                trovato = true;
            }
            if(!trovato) {
                out.write("0");
            }
            out.writeln("");
            
        }
        
    }
}
