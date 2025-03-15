package banco;

import model.Corretor;
import model.Funcionario;
import model.Imovel;
import model.ImovelLivre;
import model.Imobiliaria;
import model.Proprietario;

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
        	String sql = "CALL consultar_Imobiliaria("+imobiliaria.getIdImobiliaria()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
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
    		String sql = "CALL listar_Corretores("+imobiliaria.getIdImobiliaria()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Corretor corretor = new Corretor(
							rs.getInt("idCorretor"),
							rs.getString("nome"),
							rs.getString("telefone"),
							rs.getString("email")
					);
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
    
    public Imobiliaria listaFuncionario(Imobiliaria imobiliaria) {
    	try {
    		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    		String sql = "CALL listar_Funcionarios("+imobiliaria.getIdImobiliaria()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Funcionario funcionario = new Funcionario(
							rs.getInt("idFuncionario"),
							rs.getString("nome"),
							rs.getString("telefone"),
							rs.getString("email")
					);
					funcionarios.add(funcionario);
				}
				imobiliaria.setListaFuncionario(funcionarios);
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
				Proprietario proprietario;
				while (rs.next()) {
					proprietario = new Proprietario();
					proprietario.setIdProprietario(rs.getInt("idProprietario"));
					proprietario = new DataProprietario().consultarProprietario(proprietario);
					
					if(rs.getString("situacao") != "Disponivel") {

						Imovel imovel = new Imovel(
								rs.getInt("idImovel"),
								rs.getString("endereco"), 
								proprietario
								);
						imoveis.add(imovel);
						
					} else {

						ImovelLivre imovel = new ImovelLivre(
								rs.getInt("idImovel"),
								rs.getString("endereco"), 
								proprietario
								);
						imoveis.add(imovel);
					}
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

}