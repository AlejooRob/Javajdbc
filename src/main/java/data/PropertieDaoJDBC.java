package data;

import static data.ConecctionJDBC.*;
import domain.PropertieDTO;
import java.sql.*;
import java.util.*;


public class PropertieDaoJDBC implements PropertieDao{
    
    private Connection transactionalConnection;
    
    private static final String SQL_SELECT = "SELECT id, titulo, precio, imagen, descripcion, habitaciones, wc, estacionamiento, creado, vendedorId FROM propiedades";
    private static final String SQL_INSERT = "INSERT INTO propiedades( titulo, precio, imagen, descripcion, habitaciones, wc, estacionamiento, creado, vendedorId) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE propiedades SET titulo = ?, precio = ?, imagen = ?, descripcion = ?, habitaciones = ?, wc = ?, estacionamiento = ?, creado = ?, vendedorId = ?  WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM propiedades WHERE id = ?";
    
    
    public PropertieDaoJDBC() {}
    
    public PropertieDaoJDBC(Connection transactionalConnection) {
        this.transactionalConnection = transactionalConnection;
    }
    
    @Override
    public List<PropertieDTO> selection() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PropertieDTO propertie = null;
        List<PropertieDTO> properties = new ArrayList<>();
        
        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while( rs.next() ) {
                int idPropertie = rs.getInt("id");
                String title = rs.getString("titulo");
                double price = rs.getDouble("precio");
                String picture = rs.getString("imagen");
                String description = rs.getString("descripcion");
                int rooms = rs.getInt("habitaciones");
                int wc = rs.getInt("wc");
                int parking = rs.getInt("estacionamiento");
                java.sql.Date created = new java.sql.Date(rs.getDate("creado").getTime());
                int salerId = rs.getInt("vendedorId");
                
                propertie = new PropertieDTO(idPropertie, title, price, picture, description, rooms, wc, parking, created, salerId);
                
                properties.add(propertie);
            }
        } finally {
            try {
                close(rs);
                close(stmt);
                if(this.transactionalConnection == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        
        return properties;
    }
    
    @Override
    public int insert(PropertieDTO propertie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        java.util.Date date = propertie.getCreated();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, propertie.getTitle());
            stmt.setDouble(2, propertie.getPrice());
            stmt.setString(3, propertie.getPicture());
            stmt.setString(4, propertie.getDescription());
            stmt.setInt(5, propertie.getRooms());
            stmt.setInt(6, propertie.getWc());
            stmt.setInt(7, propertie.getParking());
            stmt.setDate(8, sqlDate);
            stmt.setInt(9, propertie.getSellerId());
            records = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if(this.transactionalConnection == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return records;
    }
    
    @Override
    public int update(PropertieDTO propertie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        java.util.Date date = propertie.getCreated();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, propertie.getTitle());
            stmt.setDouble(2, propertie.getPrice());
            stmt.setString(3, propertie.getPicture());
            stmt.setString(4, propertie.getDescription());
            stmt.setInt(5, propertie.getRooms());
            stmt.setInt(6, propertie.getWc());
            stmt.setInt(7, propertie.getParking());
            stmt.setDate(8, sqlDate);
            stmt.setInt(9, propertie.getSellerId());
            stmt.setInt(10, propertie.getIdPropertie());
            records = stmt.executeUpdate();
        }  finally {
            try {
                close(stmt);
                if(this.transactionalConnection == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return records;
    }
    
    @Override
    public int delete(PropertieDTO propertie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int records = 0;
        try {
            conn = this.transactionalConnection != null ? this.transactionalConnection : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, propertie.getIdPropertie());
            records = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if(this.transactionalConnection == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return records;
    }
}
