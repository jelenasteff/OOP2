package rs.ac.ni.pmf.oop2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Komentar : Nisam shvatila da NE treba da radimo upis u fajl, pa sam uradila celokupan kod pre nego
// da preslusam predavanja do kraja...

public class FileStorage implements Storage{
    @Override
    public void store(final String input){
        System.out.println("Upisite naziv fajla u koji zelite da sacuvate fajl.");
        Scanner in = new Scanner(System.in);
        String naziv;
        naziv = in.nextLine().trim() + ".txt";
        try {
            writing : while(true) {
                File file = new File(naziv);
                if (file.length()>0) {
                    System.out.println("Fajl vec sadrzi upisane informacije.");
                    System.out.println("Unesite 0 za promenu fajla ili 1 za overwrite postojeceg fajla.");
                    int izbor = in.nextInt();
                    if (izbor == 0) {
                        System.out.println("Unesite novi naziv");
                        in.nextLine();
                        naziv = in.nextLine().trim() + ".txt";
                        continue writing;
                    } else if (izbor == 1) {
                        FileWriter upis = new FileWriter(naziv);
                        upis.write(input);
                        upis.close();
                        break;
                    } else {
                        System.out.println("Neispravan unos, probaj ponovo!");
                        break;
                    }
                } else {
                    FileWriter upis = new FileWriter(naziv);
                    upis.write(input);
                    upis.close();
                    break;
                }
            }

            File provera = new File(naziv);
            if (provera.length()>0){
                System.out.println("File storage : Successful");
            }
            else System.out.println("Neuspesan upis u fajl.");

        } catch (IOException e) {
            throw new RuntimeException(e); // java sama generisala
        }
    }
}


