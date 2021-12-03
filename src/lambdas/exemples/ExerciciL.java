package lambdas.exemples;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciL {

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
        Persona p1 = new Persona("Arya", Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Genere.DONA, LocalDate.parse("12/11/1992",format));
        Persona p9 = new Persona("Davos", Genere.HOME, LocalDate.parse("12/11/1965",format));
        Persona p10 = new Persona("Jon Neu", Genere.HOME, LocalDate.parse("12/11/1986",format));
        Persona p11 = new Persona("Brienne", Genere.DONA, LocalDate.parse("12/11/1989",format));

        Persona[] lpers = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11};
        List<Persona> llista_persones;
        llista_persones = new ArrayList<>(Arrays.asList(lpers));
        Map<Integer,Integer> mapPersones = new HashMap<>();

        // 1 - Canviar a lambda
        System.out.println("\n1-2");
        /*Collections.sort(llista_persones, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });*/
        Stream<Persona> stream = Arrays.stream(lpers);
        /*stream2.sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getNom(), o2.getNom()))*/
        stream.sorted((o1,o2) -> o1.getNom().compareTo(o2.getNom()))

        // 2 - Canviar a Lambda
        /*for(Persona p: llista_persones) {
            System.out.println(p);
        }*/
        .forEach(persona -> System.out.println(persona));


        // 3 - Canvia a classe anònima
        System.out.println("\n3-4");
        //ordenació alfabètica inversa del nom
        Stream<Persona> stream2 = Arrays.stream(lpers);
            stream2.sorted((o1,o2) -> o2.getNom().compareTo(o1.getNom()))

        // 4 - Canvia per una crida al mètode per referència
        /*for(Persona p: llista_persones) {
            System.out.println(p);
        };*/
                    .forEach(System.out::println);

        // 5 - Omplir map. Canviar per un forEach amb lambda
        System.out.println("\n5-6");
        /*for(Persona per : llista_persones) {
            mapPersones.put(per.getAge(),1);
        }*/
       /* llista_persones.forEach((k) -> mapPersones.put(k.getAge(),1));*/

        // 6 - Canvia per un recorregut forEach amb lambda
        mapPersones.forEach((k,v) -> System.out.println(k + " : " + v));

        /*for(Map.Entry entry : mapPersones.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/


        /* 7 -
            Esbrina com s'utilitzen els mètodes de map següents
                map.putIfAbsent
                map.computeIfAbsent
                map.computeIfPresent

             per tal d'afegir correctament la feqüència d'edat de les persones.

             Si vols fes-ho primer sense els mètodes anomenats i sense lambdes
             i després amb els mètodes i amb lambdes

             Exemple de sortida:
                34 anys -> 1
                38 anys -> 1
                39 anys -> 2
                26 anys -> 2
                44 anys -> 1
                15 anys -> 1
         */
        System.out.println("\n7");

        llista_persones.forEach((p) -> {
            mapPersones.computeIfPresent(p.getAge(), (k,v) -> v+1);
            mapPersones.putIfAbsent(p.getAge(),1);
        });
        mapPersones.forEach((k,v) -> System.out.println(k + " : " + v));

        // 8 - llistat de persones DONA amb lambda (stream)
        System.out.println("\n8");
        Stream<Persona> stream8 = Arrays.stream(lpers);
        stream8.filter((o1) -> o1.getGenere().equals(Genere.DONA))
                .forEach(System.out::println);

        // 9 - Llistat dels dos HOMES més joves (stream)
        System.out.println("\n9");
        Stream<Persona> stream9 = Arrays.stream(lpers);
        stream9.filter((o1) -> o1.getGenere().equals(Genere.HOME))
                .sorted((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()))
                .limit(2)
                .forEach(System.out::println);

        // 10- Esborrar (no filtrar o imprimir) del llistat les persones entre 30 i 40 anys (amb lambda)

    }
}