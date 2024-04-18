package es.medac.t18act4;

/**
 *
 * @author asier.ruiz
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.*;
import javax.sql.DataSource;

public class SaborDAO {
    private DataSource dataSource;

    public SaborDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/HeladeriaDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    
}
