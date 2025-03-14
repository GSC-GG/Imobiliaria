package banco;

import model.Locatario;
import model.Locatario;
import model.Aluguel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLocatario {
    private DBConnection connection;
    
    public DataLocatario() {
        this.connection = new DBConnection();
    }

    public void incluirLocatario(Locatario locatario) {
        try {
            String sql = "CALL inserir_Locatario(?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, locatario.getNome());
            statement.setString(2, locatario.getTelefone());
            statement.setString(3, locatario.getEmail());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Locatario consultarLocatario(Locatario locatario) {
        try {
            String sql = "CALL consultar_Locatario(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, locatario.getIdLocatario());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
            	locatario.setIdLocatario(rs.getInt("idLocatario"));
            	locatario.setNome(rs.getString("nome"));
            	locatario.setEmail(rs.getString("email"));
            	locatario.setTelefone(rs.getString("telefone"));
            	locatario.setEmail(rs.getString("email"));
            	locatario.setStatus(rs.getString("status"));
            } else {
            	return null;
            }
            return locatario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Locatario listaVisita(Locatario locatario) {
    	try {
    		List<Aluguel> alugueis = new ArrayList<Aluguel>();
    		String sql = "CALL listar_Alugueis("+locatario.getIdLocatario()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Aluguel visita = new Aluguel(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getObject(4, LocalDate.class), rs.getObject(5, LocalDate.class), rs.getString(6));
					alugueis.add(visita);
				}
				locatario.setListaAluguel(alugueis);
			}
			return locatario;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
    	return null;
    }
}