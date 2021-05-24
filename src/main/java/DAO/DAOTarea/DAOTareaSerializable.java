package DAO.DAOTarea;

import DAO.DAOSerializable;
import Entidades.Tarea;
import Entidades.Urgencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOTareaSerializable extends DAOSerializable implements DAOTarea{
    HashMap<Urgencia, List<Tarea>> tareas = new HashMap<>();

    public DAOTareaSerializable() {
        super("tareas.txt");
        Object obj = this.load();
        if (obj == null){
            tareas = new HashMap<>();
        }else {
            tareas = (HashMap<Urgencia, List<Tarea>>) obj;
        }

    }

    @Override
    public void add(Tarea tarea){
        tareas = getAll();
        if (tareas == null){
            tareas.put(Urgencia.ALTA,new ArrayList<>());
            tareas.put(Urgencia.MEDIA,new ArrayList<>());
            tareas.put(Urgencia.BAJA,new ArrayList<>());
        }
        tareas.get(tarea.getUrgencia()).add(tarea);
        this.save(tareas);
    }

    @Override
    public HashMap<Urgencia, List<Tarea>> getAll() {
        return tareas;
    }

}
