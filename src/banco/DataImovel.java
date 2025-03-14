package banco;

import model.Imovel;
import model.ImovelAlugado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataImovel {
	private DBConnection connection;
	
	public DataImovel() {
		this.connection = new DBConnection();
	}
	
	public void incluirImovel(Imovel imovel) {
		try {
			String sql = "CALL inserir_Imovel (?,?,?);";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			statement.setInt(1, imovel.getIdImobiliaria());
			statement.setString(2, imovel.getEndereco());
			statement.setInt(3, imovel.getIdProprietario());
			statement.execute();
			statement.close();
		}
		catch (SQLException u) { 
            throw new RuntimeException(u);         
        }
	}
	
	public Imovel consultarImovel(Imovel imovel) {
	    try {
	        String sql = "CALL consultar_Imovel(?);";
	        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
	        statement.setInt(1, imovel.getIdImovel());
	        ResultSet rs = statement.executeQuery();
	        if (rs != null && rs.next()) {
	            imovel.setIdImovel(rs.getInt("idImovel"));
	            imovel.setIdImobiliaria(rs.getInt("IdImobiliaria"));
	            imovel.setStatus(rs.getString("situacao"));
	            imovel.setEndereco(rs.getString("endereco"));
	            imovel.setIdAgenda(rs.getInt("idAgenda"));
	            imovel.setIdProprietario(rs.getInt("idProprietario"));
	        } else {
	        	return null;
	        }
	        return imovel;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public Imovel consultarImovelPorIdProp(Imovel imovel) {
	    try {
	        String sql = "CALL consultar_ImovelIdProp(?);";
	        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
	        statement.setInt(1, imovel.getIdProprietario());
	        ResultSet rs = statement.executeQuery();
	        if (rs != null && rs.next()) {
	            imovel.setIdImovel(rs.getInt("idImovel"));
	            imovel.setIdImobiliaria(rs.getInt("IdImobiliaria"));
	            imovel.setStatus(rs.getString("situacao"));
	            imovel.setEndereco(rs.getString("endereco"));
	            imovel.setIdAgenda(rs.getInt("idAgenda"));
	            imovel.setIdProprietario(rs.getInt("idProprietario"));
	        } else {
	        	return null;
	        }
	        return imovel;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public ImovelAlugado consultarImovelAlugado(ImovelAlugado imovel) {
        try {
            String sql = "CALL consultar_Imovel(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, imovel.getIdImovel());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                imovel = new ImovelAlugado(
                    rs.getInt("idImovel"),
                    rs.getString("situacao"),
                    rs.getString("endereco"),
                    rs.getInt("idAgenda"),
                    rs.getInt("idImobiliaria"),
                    rs.getInt("idLocatario"),
                    rs.getInt("idProprietario")
                );
            }else {
            	return null;
            }
            return imovel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
