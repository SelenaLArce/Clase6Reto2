package Clase6Reto2;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

// clase Tema y ordenar por título
class Tema implements Comparable<Tema> {
    String titulo;
    int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareTo(otro.titulo); 
        // Orden alfabéticamente
    }

    @Override
    public String toString() {
        return "Tema: " + titulo + " | Prioridad: " + prioridad;
    }
}

public class PlaneacionEducativa {
    public static void main(String[] args) {

        // Lista concurrente de temas 
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();
        temas.add(new Tema("Español", 3));
        temas.add(new Tema("Matemáticas", 1));
        temas.add(new Tema("Biología", 2));

        // Ordenar alfabéticamente
        Collections.sort(temas);
        System.out.println("Por orden alfbaético:");
        for (Tema t : temas) {
            System.out.println(t);
        }

        // Por Prioridad con Comparator
        temas.sort(new Comparator<Tema>() {
            @Override
            public int compare(Tema a, Tema b) {
                return Integer.compare(a.prioridad, b.prioridad); // Prioridad ascendente
            }
        });

        System.out.println("Por prioridad (siendo 1 = urgente): ");
        for (Tema t : temas) {
            System.out.println(t);
        }

        // Mapa concurrente de recursos usando ConcurrentHashMap
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Español", "https://recursos.edu/español");
        recursos.put("Matemáticas", "https://recursos.edu/matematicas");
        recursos.put("Biología", "https://recursos.edu/biologia");

        // Repositorio de recursos por tema
        System.out.println("Repositorio de recursos por tema:");
        for (String tema : recursos.keySet()) {
            System.out.println(tema + " --> " + recursos.get(tema));
        }
    }
}