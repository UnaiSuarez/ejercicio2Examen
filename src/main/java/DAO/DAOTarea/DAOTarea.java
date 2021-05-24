package DAO.DAOTarea;

import Entidades.Tarea;
import Entidades.Urgencia;

import java.util.HashMap;
import java.util.List;

public interface DAOTarea {
    public void add(Tarea tarea);
    public HashMap<Urgencia, List<Tarea>> getAll();
}
