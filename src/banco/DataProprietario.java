package banco;

import model.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProprietario {
    private DBConnection connection;

    public DataProprietario() {
        this.connection = new DBConnection();
    }
    
    public void incluirProprietario(Proprietario proprietario) {
        try {
            String sql = "CALL inserir_Proprietario(?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, proprietario.getNome());
            statement.setString(2, proprietario.getTelefone());
            statement.setString(3, proprietario.getEmail());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Proprietario consultarProprietario(Proprietario proprietario) {
        try {
            String sql = "CALL consultar_Proprietario(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, proprietario.getIdProprietario());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
            	proprietario.setIdProprietario(rs.getInt("idProprietario"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setEmail(rs.getString("email"));
            } else {
            	return null;
            }
        return proprietario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Proprietario consultarUltimoProprietario(Proprietario proprietario) {
    	try {
    		String sql = "CALL consultar_Ultimo_Proprietario();";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	proprietario.setIdProprietario(rs.getInt("idProprietario"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setEmail(rs.getString("email"));
            } else {
            	return null;
            }
        return proprietario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
