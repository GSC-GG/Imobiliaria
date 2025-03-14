package banco;

import model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataFuncionario {
    private DBConnection connection;

    public DataFuncionario() {
        this.connection = new DBConnection();
    }
    
    public void incluirFuncionario(Funcionario funcionario) {
        try {
            String sql = "CALL inserir_Funcionario(?, ?, ?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getEmail());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Funcionario consultarFuncionario(Funcionario funcionario) {
        try {
        	String sql = "CALL consultar_Funcionario(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, funcionario.getIdFuncionario());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
            } else {
            	return null;
            }
        return funcionario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}