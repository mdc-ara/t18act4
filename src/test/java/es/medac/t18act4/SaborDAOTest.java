package es.medac.t18act4;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import javax.sql.DataSource;
import java.sql.*;

public class SaborDAOTest {
    private SaborDAO saborDAO;
    private DataSource mockDataSource;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    
    public SaborDAOTest() {
    }

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

        // Definir los parámetros para el método agregarSabor
        String sabor = "Chocolate";
        double precio = 1.50;

        // Llamar al método bajo prueba
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

        // Aserciones de Junit
        assertNotNull(sabores, "La lista de sabores no debería ser nula");
        assertEquals(2, sabores.size(), "Debería haber dos sabores en la lista");
        
        verify(mockPreparedStatement, times(1)).close();
        verify(mockConnection, times(1)).close();
    }
    @Test
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
        String nuevoSabor = "Fresa";
        double nuevoPrecio = 1.50;

        saborDAO.actualizarSabor(id, nuevoSabor, nuevoPrecio);

        verify(mockPreparedStatement, times(1)).setString(1, nuevoSabor);
        verify(mockPreparedStatement, times(1)).setDouble(2, nuevoPrecio);
        verify(mockPreparedStatement, times(1)).setInt(3, id);
        verify(mockPreparedStatement, times(1)).executeUpdate();

        verify(mockPreparedStatement, times(1)).close();
        verify(mockConnection, times(1)).close();
    }
    @Test
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

        verify(mockPreparedStatement, times(1)).setInt(1, id);
        verify(mockPreparedStatement, times(1)).executeUpdate();

        verify(mockPreparedStatement, times(1)).close();
        verify(mockConnection, times(1)).close();
    }
}