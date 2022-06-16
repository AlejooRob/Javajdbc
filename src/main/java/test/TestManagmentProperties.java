package test;

import data.ConecctionJDBC;
import data.PropertieDao;
import data.PropertieDaoJDBC;
import domain.PropertieDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class TestManagmentProperties {
    public static void main(String[] args) {
        Connection connect = null;
        try {
            connect = ConecctionJDBC.getConnection();
            if(connect.getAutoCommit()) {
                connect.setAutoCommit(false);
            }
            //Interface = new  implements Class
            PropertieDao propertieDao = new PropertieDaoJDBC(connect);
            List<PropertieDTO> properties = propertieDao.selection();
            /*
            propertieDAO.selection();
            Date date = new Date();
            PropertieDTO propertieNew = new PropertieDTO("Nuevo elemento", 325000.00, "76e058855a6a1c72f67ed46c252fadee.jpg", "Hermoso departamento", 2, 2, 2, date, 2);
            propertieJDBC.insert(propertieNew);
            propertieJDBC propertieUpdate = new PropertieDTO( 20, "PruebaJava Modificado", 325000.00, "76e058855a6a1c72f67ed46c252fadee.jpg", "Hermoso departamento Modificado", 2, 2, 2, date, 2);
            propertieJDBC.update(propertieUpdate);
            */
            properties.forEach(propertie -> {
                System.out.println("propertie = " + propertie);
            });
            connect.commit();
            System.out.println("Commit ok");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("rollback");
            try {
                connect.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
}
