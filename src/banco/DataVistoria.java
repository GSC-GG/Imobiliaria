package banco;

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
    
    public void incluirVistoria(Vistoria vistoria) {
        try {
            String sql = "CALL inserir_Vistoria(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(vistoria.getDataVistoria()));
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
            statement.setInt(1, vistoria.getIdVistoria());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                vistoria = new Vistoria();
                /*    rs.getInt("idVistoria"),
                    rs.getObject("Agenda"),
                    rs.getObject("idCorretor"),
                    rs.getObject("dataVistoria", LocalDate.class),
                    rs.getString("resultado")
                );*/
                vistoria.setIdVistoria(rs.getInt("idVistoria"));
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
    public Vistoria consultarVistoriaAgenda(Integer idAgenda) {
        Vistoria vistoria = null;
        try {
            String sql = "CALL consultar_Vistoria_Agenda(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idAgenda);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                vistoria = new Vistoria(
                    rs.getInt("idVistoria"),
                    rs.getInt("idAgenda"),
                    rs.getInt("idCorretor"),
                    rs.getObject("dataVistoria", LocalDate.class),
                    rs.getString("resultado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vistoria;
    }
    */
    
    public void avaliarImovel(Integer idVistoria, String resultado) {
    	try {
    		String sql = "CALL avaliar_Imovel("+idVistoria+", "+resultado+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.execute();
            statement.close();
    	} catch (SQLException u) {
            throw new RuntimeException(u);
        } 
    }
}