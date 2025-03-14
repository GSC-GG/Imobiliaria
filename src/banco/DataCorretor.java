package banco;

import model.Corretor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataCorretor {
    private DBConnection connection;
    
    public DataCorretor() {
        this.connection = new DBConnection();
    }

    public void incluirCorretor(Corretor corretor) {
        try {
            String sql = "CALL inserir_Corretor(?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, corretor.getNome());
            statement.setString(2, corretor.getTelefone());
            statement.setString(3, corretor.getEmail());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Corretor consultarCorretor(Corretor corretor) {
        try {
        	String sql = "CALL consultar_Corretor(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, corretor.getIdCorretor());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                corretor.setIdCorretor(rs.getInt("idCorretor"));
                corretor.setNome(rs.getString("nome"));
                corretor.setEmail(rs.getString("email"));
                corretor.setTelefone(rs.getString("telefone"));
            } else {
            	return null;
            }
            return corretor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
