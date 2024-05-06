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
    public SaborDAO(DataSource ds){
        dataSource = ds;
    }
    
    public List<Sabor> listarSabores() {
        List<Sabor> sabores = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM sabores");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sabor sabor = new Sabor(rs.getInt("id"), rs.getString("sabor"), rs.getDouble("precio"));
                sabores.add(sabor);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sabores;
    }
    // Métodos para Create, Update y Delete.
    public void agregarSabor(String sabor, double precio) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO sabores (sabor, precio) VALUES (?, ?)");
            ps.setString(1, sabor);
            ps.setDouble(2, precio);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void actualizarSabor(int id, String sabor, double precio) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE sabores SET sabor = ?, precio = ? WHERE id = ?");
            ps.setString(1, sabor);
            ps.setDouble(2, precio);
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarSabor(int id) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM sabores WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
