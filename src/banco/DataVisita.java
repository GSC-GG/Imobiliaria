package banco;

import model.ImovelLivre;
import model.Visita;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataVisita {
    private DBConnection connection;

    public DataVisita() {
        this.connection = new DBConnection();
    }
    
    public void incluirVisita(ImovelLivre imovel, Visita visita) {
        try {
            String sql = "CALL inserir_Visita(?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, imovel.getIdImovel());
            statement.setDate(2, java.sql.Date.valueOf(visita.getDataVisita()));
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Visita consultarVisita(Visita visita) {
        try {
            String sql = "CALL consultar_Visita("+visita.getIdVisita()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                visita = new Visita(
                    rs.getInt("idVisita"),
                    rs.getObject("dataVisita", LocalDate.class),
                    rs.getString("situacao")
                );
            } else {
            	return null;
            }
        return visita;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /*
    public Visita consultarVisitaAgenda(Agenda agenda) {
        Visita visita = null;
        try {
            String sql = "CALL consultar_Visita_Agenda("+agenda.getIdAgenda()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                visita = new Visita(
                    rs.getInt("idVisita"),
                    rs.getObject("dataVisita", LocalDate.class),
                    rs.getString("situacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visita;
    }
    */
    
    public void realizarVisita(Integer idVisita) {
    	try {
    		String sql = "CALL realizar_Visita("+idVisita+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.execute();
            statement.close();
    	} catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}