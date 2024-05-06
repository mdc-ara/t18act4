package es.medac.t18act4;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.*;
import javax.sql.DataSource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.InitialContext;

/**
 *
 * @author asier.ruiz
 */
public class SaborDAOTest {
    
    public SaborDAOTest() {
    }
    
    /**
     * Test of agregarSabor method, of class SaborDAO.
     */
    @Test
    public void testAgregarSabor() {
        
        System.out.println("agregarSabor");
        String sabor = "";
        double precio = 0.0;
        SaborDAO instance = new SaborDAO();
        instance.agregarSabor(sabor, precio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
