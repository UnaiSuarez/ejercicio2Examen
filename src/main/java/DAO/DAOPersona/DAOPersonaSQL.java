package DAO.DAOPersona;

import Entidades.Persona;
import db.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaSQL implements DAOPersona{
    @Override
    public List<Persona> getAll() {
        List<Persona> personas = new ArrayList<>();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from personas");
            while (resultSet.next()){
                String nombre = resultSet.getNString("nombre");
                String telefono = resultSet.getNString("telefono");
                personas.add(new Persona(nombre,telefono));
            }
        }catch (SQLException throwables){
            System.out.println("eroor al sacar lista de personas");
        }
        return personas;
    }

    @Override
    public Persona getPersona(int Posicion) {
        return null;
    }

    @Override
    public void add(Persona persona) {
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("insert into personas values('"+persona.getNombre()+"','"+persona.getTelefono()+"')");
        }catch (SQLException exception){
            if (exception.getErrorCode() == 1062) {
                System.err.println("Ya existe un jugador con ese nombre");
            } else {
                System.err.println(exception.getMessage());
            }
        }
    }

    @Override
    public void remove(int posicion) {
        List<Persona> personas = getAll();
        try {
            Statement statement = DBConnection.getIstance().createStatement();
            statement.execute("delete from personas where nombre = '"+personas.get(posicion).getNombre()+"' and telefono = '"+personas.get(posicion).getTelefono()+"'");
        }catch (SQLException throwables){
            System.out.println("no ha sido posible borrar");
        }
    }
}
