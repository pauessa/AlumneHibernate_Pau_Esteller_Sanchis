/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import model.Alumnes;
import model.Grups;
import model.Nivell;
import model.Sexe;
import model.Telefon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Maite
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // CREAMOS UN OBJETO
               
        Alumnes a = new Alumnes("pepe", new Telefon(968958958), Sexe.Mujer, new Date(1994, 20, 12), 0, null);
        
        Set<Alumnes>alumnes= new HashSet<>();
        alumnes.add(a);
        Grups g = new Grups("2DAM", Nivell.CF, a, alumnes);


//CREAR UNA SESION
        Session session = factory.openSession();
        session.beginTransaction();

        //GUARDAR OBJETO
        session.save(a);
        //session.save(g);
        //session.saveOrUpdate(profesor);
        //CERRAR CONEXION
        session.getTransaction().commit();
        session.close();
        factory.close();

    }

}
