package data;

import domain.PropertieDTO;
import java.sql.SQLException;
import java.util.List;

public interface PropertieDao {
    
    public List<PropertieDTO> selection() throws SQLException;
    
    public int insert(PropertieDTO propertie) throws SQLException;
    
    public int update(PropertieDTO propertie) throws SQLException;
    
    public int delete(PropertieDTO propertie) throws SQLException;
}
