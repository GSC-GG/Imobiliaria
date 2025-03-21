package banco;

import model.Imobiliaria;
import model.Imovel;
import model.ImovelAlugado;
import model.Locatario;
import model.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;

public class DataImovel {
	protected DBConnection connection;
	
	public DataImovel() {
		this.connection = new DBConnection();
	}
	
	public void incluirImovel(Imovel imovel, Imobiliaria imobiliaria) {
		try {
			String sql = "CALL inserir_Imovel (?,?,?);";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			statement.setInt(1, imobiliaria.getIdImobiliaria());
			statement.setString(2, imovel.getEndereco());
			statement.setInt(3, imovel.getProprietario().getIdProprietario());
			statement.execute();
			statement.close();
		}
		catch (SQLException u) { 
            throw new RuntimeException(u);         
        }
	}
	
	public Imovel consultarImovel(Imovel imovel) {
	    try {
	        String sql = "CALL consultar_Imovel("+imovel.getIdImovel()+");";
	        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
	        ResultSet rs = statement.executeQuery();
	        if (rs != null && rs.next()) {
				Proprietario proprietario = new Proprietario(rs.getInt("idProprietario"));
				proprietario = new DataProprietario().consultarProprietario(proprietario);
				
				imovel = new Imovel(
					rs.getInt("idImovel"),
					rs.getString("endereco"),
					proprietario
				);
	        } else {
	        	return null;
	        }
	        return imovel;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public Imovel consultarImovelPorProp(Proprietario proprietario) {
	    try {
	        String sql = "CALL consultar_ImovelProp("+proprietario.getIdProprietario()+");";
	        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
	        ResultSet rs = statement.executeQuery();
			Imovel imovel;
	        if (rs != null && rs.next()) {
				
				imovel = new Imovel(
					rs.getInt("idImovel"),
					rs.getString("endereco"),
					proprietario
				);
	        } else {
	        	return null;
	        }
	        return imovel;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	/*
	 * Realmente necessário?
	 * 
	public ImovelAlugado consultarImovelAlugado(ImovelAlugado imovel) {
        try {
            String sql = "CALL consultar_Imovel("+imovel.getIdImovel()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
				Proprietario proprietario = new Proprietario(rs.getInt("idProprietario"));
				proprietario = new DataProprietario().consultarProprietario(proprietario);
				Locatario locatario = new Locatario(rs.getInt("idLocatario"));
				locatario = new DataLocatario().consultarLocatario(locatario);
				
				imovel = new ImovelAlugado(
					rs.getInt("idImovel"),
					rs.getString("endereco"),
					proprietario,
					locatario
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
    */
}
