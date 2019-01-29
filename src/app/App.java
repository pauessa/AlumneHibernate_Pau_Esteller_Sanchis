package app;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import model.Alumne;
import model.Aula;
import model.Grup;
import model.Nivell;
import model.Sexe;
import model.Telefon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Sandra
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        Alumne alum = null;
        Grup grup = null;
        Query query = null;
        //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        do {
            menu();
            op = teclado.nextInt();

            //CREAR UNA SESION
            Session session = factory.openSession();
            switch (op) {

                case 1:
                    //CREAR OBJETO
                    session.beginTransaction();

                    alum = new Alumne ("Juanito", new Telefon(2221457), Sexe.Hombre, Calendar.getInstance().getTime(), 4, null);

                    grup = new Grup("2ESO", Nivell.CF, alum);
                    Aula aula = new Aula(grup.getCodi(), "segundo eso");
                    grup.setAula(aula);
                    
//                    Set<Alumnes> listaAlumnes = new HashSet<>();
//                    listaAlumnes.add(alum);
//                    grup.setAlumnes(listaAlumnes);
                  
                    alum.setGrup(grup);

                    session.saveOrUpdate(alum);
                    session.saveOrUpdate(grup);
                    session.saveOrUpdate(aula);
                    session.getTransaction().commit();
                    break;

                case 2:
                    //BORRAR OBJETO ALUMNO
                    session.beginTransaction();
                    session.delete(alum);
                    session.getTransaction().commit();
                    break;

                case 3:
                    //MODIFICAR UN OBJETO GRUPO
                    session.beginTransaction();
                    grup = new Grup("2ESO", Nivell.Baxiller, alum);
                    session.saveOrUpdate(grup);
                    session.getTransaction().commit();
                    break;

                case 4: //CONSULTAS

                    //NOM ALUMNES HOMES MAJORS DE 18 ANYS
                    System.out.println("\n NOM ALUMNES HOMES MAJORS DE 18 ANYS");

                    query = session.createQuery("SELECT a FROM Alumne a WHERE sexe=1 AND datanaix <'2001-01-01' ");
                    List<Alumne>Homes = query.list();
                    for (Alumne datos : Homes) {
                        
                            System.out.println(datos.getNom());
                       
                        
                    }

                    //NOM ALUMNES QUE HAN SUSPES LA MATEIXA ASIGNATURA I AMB CONGNOMS QUE COMENÇEN AMB 'F'
                    System.out.println("\n NOM ALUMNES QUE HAN SUSPES LA MATEIXA ASIGNATURA I AMB CONGNOMS QUE COMENÇEN AMB 'F'");
                    query = session.createQuery("SELECT a FROM Alumne a WHERE susp IN (SELECT susp FROM Alumne a ) AND a.nom LIKE 'F%'");

                    List<Alumne>SupesNom = query.list();
                    for (Alumne a: SupesNom) {
                        System.out.println(a.getNom());
                        System.out.println(a.getSusp());
                    }

                    //NEXP I NOM D'ALUMNES I CODI DE GRUP EN QUE SON DELEGATS
                    System.out.println("\n NEXP I NOM D'ALUMNES I CODI DE GRUP EN QUE SON DELEGATS");
                    query = session.createQuery("SELECT a.nexp, a.nom, g.codi FROM Alumne a, Grup g WHERE a.grup=g.codi");

                    List<Object[]> listDelegats = query.list();
                    for (Object[] d : listDelegats) {
                        System.out.println(d[0] + " -- " + d[1] + " -- " + d[2]);
                    }

                    //ALUMNES QUE HAN SUSPES MES QUE LA MITJA
                    System.out.println("\n ALUMNES QUE HAN SUSPES MES QUE LA MITJA");
                    query = session.createQuery("SELECT a.nom FROM Alumne a WHERE susp > (SELECT AVG(susp) FROM Alumne)");

                    List<Object> listSuperiorMedia = query.list();
                    for (Object a : listSuperiorMedia) {
                        System.out.println(a);
                    }

                    //ALUMNES QUE HAN SUSPES MES QUE 2 ASSIGNATURES
                    System.out.println("\n ALUMNES QUE HAN SUSPES MES QUE 2 ASSIGNATURES");
                    query = session.createQuery("SELECT a.nom FROM Alumne a WHERE susp > 2");

                    List<Object> listSuspesos = query.list();
                    for (Object a : listSuspesos) {
                        System.out.println(a);
                    }

                    //GRUPS I NUMERO D'ALUMNES MATRICULATS
                    System.out.println("\n GRUPS I NUMERO D'ALUMNES MATRICULATS");
                    query = session.createQuery("SELECT g.codi , COUNT(*) FROM Alumne a, Grup g WHERE g.codi=a.grup GROUP BY codi");

                    List<Object[]> listAlumnesGrup = query.list();
                    for (Object[] dato : listAlumnesGrup) {
                        System.out.println(dato[0] + " -- " + dato[1]);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    session.close();
                    factory.close();
                    break;
            }
        } while (op != 0);
    }

    private static void menu() {
        System.out.print("--MENU--\n"
                + "1. Crear objeto\n"
                + "2. Borrar objeto\n"
                + "3. Modificar objeto\n"
                + "4. Consultas\n"
                + "0. Salir\n"
                + "Elige una opción: ");
    }

}
