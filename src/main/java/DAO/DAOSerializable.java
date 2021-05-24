package DAO;

import Entidades.Tarea;
import Entidades.Urgencia;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class DAOSerializable {

    private final String file;

    public DAOSerializable(String file){
        this.file = file;
    }

    public void save(Object oject){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(oject);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Object load() {
        Object object = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("no hay datos");
        }
        return object;
    }

}
