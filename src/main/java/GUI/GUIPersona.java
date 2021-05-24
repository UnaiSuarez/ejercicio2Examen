package GUI;

import DAO.DAOFactory;
import Entidades.Persona;

import javax.swing.*;

public class GUIPersona extends JFrame{
    private JList listaPersonas;
    private JTextField inpoutNombre;
    private JTextField inpoutTlf;
    private JButton botonAñadir;
    private JPanel panelPrincipal;

    public GUIPersona(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panelPrincipal);
        listaPersonas.setListData(DAOFactory.getInstance().daoPersona().getAll().toArray());
        botonAñadir.addActionListener(e -> {
            String nombre = inpoutNombre.getText();
            String tlf = inpoutTlf.getText();
            DAOFactory.getInstance().daoPersona().add(new Persona(nombre,tlf));
            listaPersonas.setListData(DAOFactory.getInstance().daoPersona().getAll().toArray());
        });
    }
}
