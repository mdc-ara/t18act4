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

import static org.mockito.Mockito.*;
import javax.sql.DataSource;
import java.sql.*;

/**
 *
 * @author asier.ruiz
 */
public class SaborDAOTest {
    private SaborDAO saborDAO;
    private DataSource mockDataSource;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    
    public SaborDAOTest() {
    }
    
    /**
     * Test of agregarSabor method, of class SaborDAO.
     */
    @Test
    public void testAgregarSabor() throws SQLException {
        // Crear mocks
        mockDataSource = mock(DataSource.class);
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

         // Configurar el comportamiento común de los mocks
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Inyección del mock DataSource en SaborDAO
        saborDAO = new SaborDAO(mockDataSource);

        System.out.println("agregarSabor");
        String sabor = "Tutti Frutti";
        double precio = 1.10;

        saborDAO.agregarSabor(sabor, precio);

        // Verificar que se preparó el statement con los argumentos pasados y se invocó executeUpdate
        verify(mockPreparedStatement, times(1)).setString(1, sabor);
        verify(mockPreparedStatement, times(1)).setDouble(2, precio);
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
    @Test
    public void testListarSabores() throws SQLException {
        // Crear mocks
        mockDataSource = mock(DataSource.class);
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Configurar el comportamiento común de los mocks
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Inyección del mock DataSource en SaborDAO
        saborDAO = new SaborDAO(mockDataSource);
        
        // Configurar el comportamiento esperado para listarSabores
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getInt("id")).thenReturn(1, 2);
        when(mockResultSet.getString("sabor")).thenReturn("Chocolate", "Vainilla");
        when(mockResultSet.getDouble("precio")).thenReturn(1.50, 1.20);
        
        List<Sabor> sabores = saborDAO.listarSabores();
        
        assertEquals(2, sabores.size(), "Debería haber dos sabores en la lista");
    }
    public void testActualizarSabor() throws SQLException {
        // Crear mocks
        mockDataSource = mock(DataSource.class);
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Configurar el comportamiento común de los mocks
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Inyección del mock DataSource en SaborDAO
        saborDAO = new SaborDAO(mockDataSource);
        
        int id = 1;
        String sabor="Chocolate";
        Double precio=1.40;
        saborDAO.actualizarSabor(id,sabor,precio);
        
        // Verificar que se preparó el statement con los argumentos pasados y se invocó executeUpdate
        verify(mockPreparedStatement, times(1)).setString(1, sabor);
        verify(mockPreparedStatement, times(1)).setDouble(2, precio);
        verify(mockPreparedStatement, times(1)).setInt(3, id);
        verify(mockPreparedStatement, times(1)).executeUpdate();        
    }
    public void testEliminarSabor() throws SQLException {
        // Crear mocks
        mockDataSource = mock(DataSource.class);
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Configurar el comportamiento común de los mocks
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Inyección del mock DataSource en SaborDAO
        saborDAO = new SaborDAO(mockDataSource);
        
        int id = 1;
        saborDAO.eliminarSabor(id);
        
        // Verificar que se preparó el statement con los argumentos pasados y se invocó executeUpdate
        verify(mockPreparedStatement, times(1)).setInt(1, id);
        verify(mockPreparedStatement, times(1)).executeUpdate();  
    }
}
