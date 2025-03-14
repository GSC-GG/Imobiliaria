package banco;

import model.Aluguel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataAluguel {
    private DBConnection connection;
    
    public DataAluguel() {
        this.connection = new DBConnection();
    }

    public void incluirAluguel(Aluguel aluguel, Integer idLocatario, Double valorAluguel) {
        try {
            String sql = "CALL inserir_Aluguel(?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idLocatario);
            statement.setDouble(2, valorAluguel);
            statement.setDate(3, java.sql.Date.valueOf(aluguel.getDataVencimento())); // Convertendo LocalDate para java.sql.Date
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Aluguel consultarAluguel(Integer idAluguel) {
        Aluguel aluguel = null;
        try {
            String sql = "SELECT * FROM Aluguel WHERE idAluguel = ?;";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, idAluguel);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
                aluguel = new Aluguel(
                    rs.getInt("idAluguel"),
                    rs.getInt("idLocatario"),
                    rs.getDouble("valor"),
                    rs.getObject("dataVencimento", LocalDate.class),
                    rs.getObject("dataPagamento", LocalDate.class),
                    rs.getString("situacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aluguel;
    }
    
    public void pagarAluguel(Integer idAluguel) {
    	try {
    		String sql = "CALL pagar_Aluguel("+idAluguel+");";
    		PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.execute();
            statement.close();
    		
    	} catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void viraMesAluguel(Integer idAluguel) {
    	try {
    		String sql = "CALL mes_Aluguel("+idAluguel+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null && rs.next()) {
            	LocalDate dataVencimento = rs.getObject("dataVencimento", LocalDate.class);
            	LocalDate dataAtual = rs.getObject("CURDATE()", LocalDate.class);
            	String status = rs.getString("situacao");
            	
            	if(dataAtual.isAfter(dataVencimento)) {
            		Aluguel aluguelAntigo = consultarAluguel(idAluguel);
            		Aluguel aluguelNovo = null;
            		incluirAluguel(aluguelNovo, aluguelAntigo.getIdLocatario(), aluguelAntigo.getValorAluguel());
            		
            		if(status == "Pendente") {
            			pagamentoAtrasado(idAluguel);
            		}
            	}
            }
    		
    	} catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void pagamentoAtrasado(Integer idAluguel) {
    	try {
    		String sql = "CALL mes_Aluguel("+idAluguel+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.execute();
            statement.close();
    	} catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}