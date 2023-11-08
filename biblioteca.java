package string;
import java.util.ArrayList;
import java.util.Scanner;

public class biblioteca {
    private ArrayList<Libro> biblioteca = new ArrayList<>();

    public void afegirLlibre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix el títol del llibre:");
        String titol = scanner.nextLine();
        System.out.println("Introdueix l'autor del llibre:");
        String autor = scanner.nextLine();
        System.out.println("Introdueix el número de pàgines:");
        int pagines = scanner.nextInt();

        for (Libro libro : biblioteca) {
            if (libro.getTitol().equalsIgnoreCase(titol)) {
                System.out.println("Aquest llibre ja existeix a la biblioteca.");
                return;
            }
        }

        biblioteca.add(new Libro(titol, autor, pagines));
        System.out.println("Llibre afegit amb èxit!");
    }

    public void llistarLlibres() {
        if (biblioteca.isEmpty()) {
            System.out.println("No hi ha llibres a la biblioteca.");
        } else {
            for (Libro libro : biblioteca) {
                System.out.println("Títol: " + libro.getTitol() + ", Autor: " + libro.getAutor() + ", Pàgines: " + libro.getPagines());
            }
        }
    }

    public void cercarPerAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'autor a cercar:");
        String autor = scanner.nextLine();
        boolean trobat = false;

        for (Libro libro : biblioteca) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("Títol: " + libro.getTitol() + ", Autor: " + libro.getAutor() + ", Pàgines: " + libro.getPagines());
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No s'ha trobat cap llibre de l'autor " + autor);
        }
    }

    public void cercarPerTitol() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix el títol a cercar:");
        String titol = scanner.nextLine();
        boolean trobat = false;

        for (Libro libro : biblioteca) {
            if (libro.getTitol().equalsIgnoreCase(titol)) {
                System.out.println("Títol: " + libro.getTitol() + ", Autor: " + libro.getAutor() + ", Pàgines: " + libro.getPagines());
                trobat = true;
                break; // No cal seguir buscant si ja hem trobat el llibre
            }
        }

        if (!trobat) {
            System.out.println("No s'ha trobat cap llibre amb el títol " + titol);
        }
    }

    public void eliminarLlibre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix el títol del llibre a eliminar:");
        String titol = scanner.nextLine();

        for (Libro libro : biblioteca) {
            if (libro.getTitol().equalsIgnoreCase(titol)) {
                biblioteca.remove(libro);
                System.out.println("Llibre eliminat amb èxit!");
                return;
            }
        }

        System.out.println("No s'ha trobat cap llibre amb el títol " + titol);
    }

    public static void main(String[] args) {
        biblioteca biblioteca = new biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcio = 0;

        System.out.println("-------- GESTIÓ DE BIBLIOTECA --------");

        while (opcio != 6) {
            System.out.println("Accions disponibles:");
            System.out.println("1. Afegir llibre");
            System.out.println("2. Llistar llibres");
            System.out.println("3. Cercar llibre per autor");
            System.out.println("4. Cercar llibre per títol");
            System.out.println("5. Eliminar llibre");
            System.out.println("6. Sortir");
            System.out.print("Introdueix el número associat a l'acció a realitzar: ");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    biblioteca.afegirLlibre();
                    break;
                case 2:
                    biblioteca.llistarLlibres();
                    break;
                case 3:
                    biblioteca.cercarPerAutor();
                    break;
                case 4:
                    biblioteca.cercarPerTitol();
                    break;
                case 5:
                    biblioteca.eliminarLlibre();
                    break;
                case 6:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a intentar.");
                    break;
            }
        }
    }
}

class Libro {
    private String titol;
    private String autor;
    private int pagines;

    public Libro(String titol, String autor, int pagines) {
        this.titol = titol;
        this.autor = autor;
        this.pagines = pagines;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getPagines() {
        return pagines;
    }
}