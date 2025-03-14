package banco;

import model.Contrato;
import model.Aluguel;
import banco.DataAluguel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class DataContrato {
    private DBConnection connection;
    
    public DataContrato() {
        this.connection = new DBConnection();
    }

    public void incluirContrato(Contrato contrato, Integer idImovel) {
        try {
            String sql = "CALL inserir_Contrato(?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idImovel);
            statement.setDouble(2, contrato.getValorAluguel());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Contrato consultarPorIdContrato(Integer idContrato) {
        Contrato contrato = null;
        try {
        	String sql = "CALL consultar_Contrato(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idContrato);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                contrato = new Contrato(
                    rs.getInt("idContrato"),
                    rs.getDouble("valorAluguel"),
                    rs.getInt("idImovel"),
                    rs.getObject("dataAssinatura", LocalDate.class),
                    rs.getString("situacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrato;
    }

    public Contrato consultarPorIdImovel(Integer idImovel) {
        Contrato contrato = null;
        try {
        	String sql = "CALL consultar_Contrato_Imovel(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idImovel);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                contrato = new Contrato(
                    rs.getInt("idContrato"),
                    rs.getDouble("valorAluguel"),
                    rs.getInt("idImovel"),
                    rs.getObject("dataAssinatura", LocalDate.class),
                    rs.getString("situacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrato;
    }

    public void fecharContrato(Integer idContrato, Integer idLocatario, Integer idAluguel) {
    	try {
            String sql = "CALL fechar_Contrato(?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idContrato);
            statement.setInt(2, idLocatario);
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }   	
    	
    	
    	// incluirAluguel(aluguel, idLocatario, valorAluguel); //como que faz?
    	
    	Contrato contrato = consultarPorIdContrato(idContrato);
    	DataAluguel dataAluguel = new DataAluguel();
    	Aluguel aluguel = null;
    	Double valorAluguel = contrato.getValorAluguel();
    	dataAluguel.incluirAluguel(aluguel, idLocatario, valorAluguel);
    }
    
    /*só vou saber o que fazer com essa daqui quando tiver views
    public void assinarContrato(Integer idContrato, Integer idLocatario) {	//redundante?
    	fecharContrato(idContrato, idLocatario);
    }
    */
    public void encerrarContrato(Integer idContrato) {
    	try {
            String sql = "CALL encerrar_Contrato(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idContrato);
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
