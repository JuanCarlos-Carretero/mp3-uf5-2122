package a2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CompteEstalvi compteEstalvi = new CompteEstalvi("CuentaJuanka");

        compteEstalvi.addUser(new Client("Lorenzo","Pinares","46823975N"));
        compteEstalvi.addUser(new Client("Pepe","Tijeras","59473492M"));
        compteEstalvi.addUser(new Client("Juan Carlos","Carretero","54038770V"));


        // Aqui intento ver si el dni es correcto
        System.out.println("Nombre del cliente");
        String nombre = scan.nextLine();
        System.out.println("Apellido del cliente");
        String apellido = scan.nextLine();
        System.out.println("DNI del cliente (8 numeros y 1 letra al final)");
        String dni = scan.nextLine();

        Client client = new Client(nombre,apellido,dni);
        try{
            client.validarDNI(dni);
            compteEstalvi.addUser(client);
        } catch(ClientAccountException e){
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println();

        // Dinero es = 0
        compteEstalvi.ingressar(50);
        System.out.println("¿Cuanto dinero quiere sacar?" + "Actualmente tiene 50 BITCOINS");
        int dinero = scan.nextInt();
        scan.nextLine();
        try {
            compteEstalvi.treure(dinero);
            System.out.println("Su saldo actual es de: " + compteEstalvi.getSaldo() + " BITCOINS");
        } catch (BankAccountException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println();


        // Si usuario es < 1 que de un error al querer borrarlo
        while(true){
            System.out.println("¿Quieres borrar un usuario?");
            System.out.println("Tienes " + compteEstalvi.getLlista_usuaris().size() + "usuarios");
            String opcion = scan.nextLine();
            if ("si".equals(opcion) || "Si".equals(opcion) || "s".equals(opcion) || "S".equals(opcion) || "1".equals(opcion)){
                try{
                    compteEstalvi.removeUser(client.getDNI());
                    System.out.println("Usuario eliminado");
                }catch(BankAccountException e){
                    e.printStackTrace();
                    System.exit(0);
                }
            } else {
                System.out.println("Terminando sesion");
                try {
                    Thread.sleep(2000);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
