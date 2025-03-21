package banco;

import model.ImovelLivre;
import model.Vistoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataVistoria {
    private DBConnection connection;

    public DataVistoria() {
        this.connection = new DBConnection();
    }
    
    public void incluirVistoria(ImovelLivre imovel, Vistoria vistoria) {
        try {
            String sql = "CALL inserir_Vistoria(?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, imovel.getIdImovel());
            statement.setDate(2, java.sql.Date.valueOf(vistoria.getDataVistoria()));
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Vistoria consultarVistoria(Vistoria vistoria) {
        try {
            String sql = "CALL consultar_Vistoria("+vistoria.getIdVistoria()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                vistoria = new Vistoria(
                    rs.getInt("idVistoria"),
                    rs.getObject("dataVistoria", LocalDate.class),
                    rs.getString("situacao")
                );
            } else {
            	return null;
            }
        return vistoria;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /*
    public Vistoria consultarVistoriaAgenda(Agenda agenda) {
        Vistoria vistoria = null;
        try {
            String sql = "CALL consultar_Vistoria_Agenda("+agenda.getIdAgenda()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                vistoria = new Vistoria(
                    rs.getInt("idVistoria"),
                    rs.getObject("dataVistoria", LocalDate.class),
                    rs.getString("situacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vistoria;
    }
    */
    
    public void avaliarImovel(Vistoria vistoria, String resultado) {
    	try {
    		String sql = "CALL avaliar_Imovel("+vistoria.getIdVistoria()+", "+resultado+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.execute();
            statement.close();
    	} catch (SQLException u) {
            throw new RuntimeException(u);
        } 
    }
}