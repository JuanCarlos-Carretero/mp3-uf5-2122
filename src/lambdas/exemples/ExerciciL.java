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
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992",format));

        Persona[] lpers = {p1,p2,p3,p4,p5,p6,p7,p8};
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
        .forEach(System.out::println);


        // 3 - Canvia a classe anònima
        System.out.println("\n3-4");
        //ordenació alfabètica inversa del nom
        Stream<Persona> stream2 = Arrays.stream(lpers);
            stream2.sorted((o1,o2) -> o2.getNom().compareTo(o1.getNom()))

        // 4 - Canvia per una crida al mètode per referència
        /*for(Persona p: llista_persones) {
            System.out.println(p);
        };*/
                    .forEach(new Consumer<Persona>() {
                        @Override
                        public void accept(Persona p) {
                            System.out.println(p);
                        }
                    });


        // 5 - Omplir map. Canviar per un forEach amb lambda
        System.out.println("\n5-6");
        /*for(Persona per : llista_persones) {
            mapPersones.put(per.getAge(),1);
        }*/

        Stream<Persona> stream3 = Arrays.stream(lpers);
        stream3.map(Persona::getAge).distinct().collect(Collectors.toList())

        // 6 - Canvia per un recorregut forEach amb lambda
                .forEach((o1) -> System.out.println(o1 + " : " + 1));

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

        // 8 - llistat de persones DONA amb lambda (stream)

        // 9 - Llistat dels dos HOMES més joves (stream)

        // 10- Esborrar (no filtrar o imprimir) del llistat les persones entre 30 i 40 anys (amb lambda)

    }


}
