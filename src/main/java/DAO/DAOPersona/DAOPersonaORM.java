package DAO.DAOPersona;

import Entidades.Persona;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import db.DBConnectionORM;

import java.sql.SQLException;
import java.util.List;

public class DAOPersonaORM implements DAOPersona{

    Dao<Persona, String> daoPersonaORM;

    public DAOPersonaORM() throws SQLException{
        this.daoPersonaORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Persona.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daoPersonaORM
        );
    }


    @Override
    public List<Persona> getAll() {
        try {
            return daoPersonaORM.queryForAll();
        }catch (SQLException throwables){
            return null;
        }
    }

    @Override
    public Persona getPersona(int Posicion) {
        return null;
    }

    @Override
    public void add(Persona persona) {
        try {
            daoPersonaORM.create(persona);
        }catch (SQLException throwables){

        }
    }

    @Override
    public void remove(int posicion) {
        List<Persona> personas = getAll();
        try {
            daoPersonaORM.deleteById(personas.get(posicion).getNombre());
        }catch (SQLException throwables){

        }
    }
}
