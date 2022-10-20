package hu.petrik.versenyeredmenyek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Map<String, List<Eredmeny>> sportagEredmeny = new HashMap<>();
    public static void main(String[] args) {
	String faljnev = "eredmenyek.txt";
    try {
        beolvas(faljnev);
    }catch (FileNotFoundException e){
        System.err.printf("Nem található a(z) %s fálj.",faljnev);
    }

    kiiras();

    }

    private static void kiiras(){
        for (Map.Entry<String, List<Eredmeny>> entry: sportagEredmeny.entrySet()){
            String sportag = entry.getKey();
            List<Eredmeny> eredmenyek = entry.getValue();
            System.out.println(sportag);
            for (Eredmeny e : eredmenyek){
                System.out.println("\t"+e);
            }
        }
    }

    private static void beolvas(String faljnev) throws FileNotFoundException {
        Scanner file = new Scanner(new File(faljnev));
        while (file.hasNext()){
            String[] sor = file.nextLine().split(" ");
            String sportag = sor[0];
            String reszido = sor[1];
            String nev = sor[2] + " " + sor[3];
            sportagEredmeny.putIfAbsent(sportag, new ArrayList<>());
            Eredmeny eredmeny = new Eredmeny(reszido, nev);
            sportagEredmeny.get(sportag).add(eredmeny);
        }
        file.close();
    }
}
