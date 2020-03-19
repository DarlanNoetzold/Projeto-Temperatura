package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Temperatura;

public class TemperaturaDAO {

    public boolean save (Temperatura t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO temperatura (valortemp) VALUES (?)");
            stmt.setDouble(1, t.getValor());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.err.println("Erro ao salvar: "+ex);
            return false;
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    

}
