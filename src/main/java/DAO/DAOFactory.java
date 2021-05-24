package DAO;

import DAO.DAOPersona.DAOPersona;
import DAO.DAOPersona.DAOPersonaORM;
import DAO.DAOPersona.DAOPersonaSQL;
import DAO.DAOTarea.DAOTarea;
import DAO.DAOTarea.DAOTareaSerializable;
import Entidades.Tarea;
import Entidades.Urgencia;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOPersona daoPersona;
    private DAOTarea daoTarea;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOPersona daoPersona(){
        if (daoPersona == null){
            daoPersona = new DAOPersonaSQL();
            /*
            try {
                daoPersona = new DAOPersonaORM();
            }catch (SQLException throwables){

            }

             */
        }
        return daoPersona;
    }

    public DAOTarea daoTarea(){
        if (daoTarea == null){
            daoTarea = new DAOTareaSerializable();
        }
        return daoTarea;
    }

}
