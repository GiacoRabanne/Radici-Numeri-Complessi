package calcolaRadice;
import java.lang.*;
import fond.io.*;

public class Radici {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        Complesso radicando = new Complesso();
        radicando.reale = in.readDouble("Inserisci la parte reale del radicando:");
        radicando.immaginario = in.readDouble("Inserisci la parte complessa del radicando:");
        int n = in.readInt("Inserisci il grado della radice da calcolare");
        Complesso radice = new Complesso();
        OutputWindow out = new OutputWindow("Radici Calcolate");
        out.setFont("SF Pro Display", 20);
        out.writeln("Radici calcolate:\n");

        for(int i = 0; i < n; i++) {
            out.write("X"+ (i+1) + " = ");
            boolean trovato = false;
            if(Math.abs(radice.calcolaRadice(radicando, n, i).reale) > 0.001){
                out.write(radice.calcolaRadice(radicando, n, i).reale);
                trovato = true;
            }

            if(Math.abs(radice.calcolaRadice(radicando, n, i).immaginario) > 0.001){
                if(radice.calcolaRadice(radicando, n, i).immaginario < 0) {
                    out.write(" -");
                } else if(trovato) {
                    out.write(" +");
                }
                out.write("i");
                if(Math.abs(radice.calcolaRadice(radicando, n, i).immaginario) != 1.0 ) {
                    out.write("*(" + Math.abs(radice.calcolaRadice(radicando, n, i).immaginario) + ")");
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
