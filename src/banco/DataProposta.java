package banco;

import model.Proposta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProposta {
    private DBConnection connection;

    public DataProposta() {
        this.connection = new DBConnection();
    }
    
    public void incluirProposta(Proposta proposta, Integer idContrato) {
        try {
            String sql = "CALL inserir_Proposta(?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idContrato);
            statement.setDouble(2, proposta.getValorAluguel());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Proposta consultarProposta(Integer idProposta) {
        Proposta proposta = null;
        try {
            String sql = "CALL consultar_Proposta(?)";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idProposta);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                proposta = new Proposta(
                    rs.getInt("idProposta"),
                    rs.getInt("idContrato"),
                    rs.getDouble("valorAluguel")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proposta;
    }

    public void aceitarProposta(Integer idProposta) {
        try {
            String sql = "CALL aceitar_Proposta(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idProposta);
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void recusarProposta(Integer idProposta) {
        try {
            String sql = "CALL recusar_Proposta(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idProposta);
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}