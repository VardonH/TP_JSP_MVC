/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

package DAO;

/**
 *
 * @author pedago
 */
public class DAO {
    
    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }
    
    /**
     *
     * @param Discount
     * @return
     * @throws DAOException
     */
    public void supprimerCode(String codeId) throws DAOException{
    // Une requête SQL paramétrée
		String sql = "DELETE FROM Discount_Code WHERE discount_code = ?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, codeId);
			
			stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
    }
    
     public int  add (String a,float b ) throws DAOException, SQLException {
            String sql = "INSERT INTO DISCOUNT_CODE (DISCOUNT_CODE,RATE) VALUE (?,?)";
            try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
		) {
                    stmt.setString(1, a);
                    stmt.setFloat(2, b);
                    return stmt.executeUpdate();
                    
                }
           catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        }
    
}
