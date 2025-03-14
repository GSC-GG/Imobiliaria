package banco;

import model.Corretor;
import model.Imovel;
import model.ImovelLivre;
import model.Imobiliaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DataImobiliaria {
    private DBConnection connection;
    
    public DataImobiliaria() {
        this.connection = new DBConnection();
    }

    public void incluirImobiliaria(Imobiliaria imobiliaria) {
        try {
            String sql = "CALL inserir_Imobiliaria(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, imobiliaria.getCnpj());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Imobiliaria consultarImobiliaria(Imobiliaria imobiliaria) {
        try {
        	String sql = "CALL consultar_Imobiliaria(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, imobiliaria.getIdImobiliaria());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                imobiliaria.setIdImobiliaria(rs.getInt("idImobiliaria"));
                imobiliaria.setCnpj(rs.getString("cnpj"));
            } else {
            	return null;
            }
        return imobiliaria;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Imobiliaria listaCorretor(Imobiliaria imobiliaria) {
    	try {
    		List<Corretor> corretores = new ArrayList<Corretor>();
    		String sql = "CALL listar_Corretores();";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Corretor corretor = new Corretor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					corretores.add(corretor);
				}
				imobiliaria.setListaCorretor(corretores);
			}
			return imobiliaria;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
    	return null;
    }

    public Imobiliaria listaImovel(Imobiliaria imobiliaria) {
    	try {
    		List<Imovel> imoveis = new ArrayList<Imovel>();
    		String sql = "CALL listar_Imoveis("+imobiliaria.getIdImobiliaria()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Imovel imovel = new Imovel(
							rs.getInt("idImovel"),
							rs.getString("situacao"), 
							rs.getString("endereco"), 
							rs.getInt("idAgenda"), 
							rs.getInt("idImobiliaria"),
							rs.getInt("idProprietario")
							);
					imoveis.add(imovel);
				}
				imobiliaria.setListaImovel(imoveis);
			}
			//return imobiliaria;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
		return imobiliaria;
    	//return null;
    }

    public Imobiliaria listaImovelLivre(Imobiliaria imobiliaria) {
    	try {
    		List<ImovelLivre> imoveisLivres = new ArrayList<ImovelLivre>();
    		String sql = "CALL listar_ImoveisLivres("+imobiliaria.getIdImobiliaria()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {

					ImovelLivre imovelLivre = new ImovelLivre(
							rs.getInt("idImovel"),
							rs.getString("situacao"), 
							rs.getString("endereco"), 
							rs.getInt("idAgenda"), 
							rs.getInt("idImobiliaria"),
							rs.getInt("idProprietario")
							);
					System.out.println(imovelLivre.getStatus());
					imoveisLivres.add(imovelLivre);
				}
				imobiliaria.setListaImovelLivre(imoveisLivres);
			}
			//return imobiliaria;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
		return imobiliaria;
    	//return null;
    }
}