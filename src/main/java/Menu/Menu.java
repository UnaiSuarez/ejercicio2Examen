package Menu;

import DAO.DAOFactory;
import DAO.DAOPersona.DAOPersona;
import Entidades.Persona;
import Entidades.Tarea;
import Entidades.Urgencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void menuPrincipal(){
        System.out.println("Menu principal:");
        System.out.println("1. Personas");
        System.out.println("2. Tareas");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion==1){
            menuPersonas();
        }else if (opcion==2){
            menuTareas();
        }else if (opcion==3){
            System.out.println("Gracias por su tiempo");
        }else {
            menuPrincipal();
        }
    }

    private void menuPersonas(){
        System.out.println("---");
        System.out.println("Menú de personas:");
        System.out.println("1. Introducir");
        System.out.println("2. Mostar");
        System.out.println("3. Eliminar");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion==1){
            menuAddPersona();
        }else if (opcion==2){
            mostrarPersonas();
        }else if (opcion==3){
            eliminarpersona();
        }else {
            menuPrincipal();
        }
    }

    private void menuAddPersona(){
        System.out.println("---");
        System.out.println("Nueva persona:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String tlf = scanner.nextLine();
        DAOFactory.getInstance().daoPersona().add(new Persona(nombre,tlf));
        System.out.println("\n\n");
        menuPrincipal();
    }

    private void mostrarPersonas(){
        List<Persona> personas = DAOFactory.getInstance().daoPersona().getAll();
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i));
        }
        System.out.println("\n\n");
        menuPrincipal();
    }

    private void eliminarpersona(){
        List<Persona> personas = DAOFactory.getInstance().daoPersona().getAll();
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(i+" "+personas.get(i));
        }
        int opcion = Integer.parseInt(scanner.nextLine());
        DAOFactory.getInstance().daoPersona().remove(opcion);
        System.out.println("\n\n");
        menuPrincipal();
    }

    private void menuTareas(){
        System.out.println("---");
        System.out.println("Menú de tareas:");
        System.out.println("1. Introducir");
        System.out.println("2. Mostar");
        System.out.println("3. Eliminar");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion==1){
            insertarTarea();
        }else if (opcion==2){
            mostrarTareas();
        }else if (opcion==3){
            eliminarTareas();
        }else {
            System.out.println("\n\n");
            menuPrincipal();
        }
    }

    private void insertarTarea(){
        System.out.println("¿A quién vas a encargar la tarea?");
        List<Persona> personas = DAOFactory.getInstance().daoPersona().getAll();
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(i+" "+personas.get(i));
        }
        int opcion = Integer.parseInt(scanner.nextLine());
        System.out.print("Urgencia (alta|meida|baja): ");
        Urgencia urgencia = Urgencia.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        DAOFactory.getInstance().daoTarea().add(new Tarea(personas.get(opcion),urgencia,nombre,descripcion));
        System.out.println("\n\n");
        menuPrincipal();
    }

    private void mostrarTareas(){
        HashMap<Urgencia, List<Tarea>> tareas = DAOFactory.getInstance().daoTarea().getAll();
        System.out.println("ALTA");
        System.out.println(tareas.get(Urgencia.ALTA));
        System.out.println("MEDIA");
        System.out.println(tareas.get(Urgencia.MEDIA));
        System.out.println("BAJA");
        System.out.println(tareas.get(Urgencia.BAJA));
        System.out.println("\n\n");
        menuPrincipal();
    }

    private void eliminarTareas(){
        System.out.println("Esta funcionalidad aun se encuentra en desarrollo, puede intenténtarlo otro día,\nGracias");
        menuTareas();
    }
}
