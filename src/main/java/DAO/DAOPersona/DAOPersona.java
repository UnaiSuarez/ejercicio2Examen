package DAO.DAOPersona;

import Entidades.Persona;

import java.util.List;

public interface DAOPersona {
    public List<Persona> getAll();
    public Persona getPersona(int Posicion);
    public void add(Persona persona);
    public void remove(int posicion);

}
