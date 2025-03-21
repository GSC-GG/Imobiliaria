package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ImovelLivre;
import model.Visita;
import model.Vistoria;

public class DataImovelLivre extends DataImovel {

	public DataImovelLivre() {
		super();
	}

    public ImovelLivre listaVisita(ImovelLivre imovelLivre) {
    	try {
    		List<Visita> visitas = new ArrayList<Visita>();
    		String sql = "CALL listar_Visitas("+imovelLivre.getIdImovel()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Visita visita = new Visita(
							rs.getInt("idVisita"),
							rs.getObject("dataVisita", LocalDate.class),
							rs.getString("resultado")
							);
					visitas.add(visita);
				}
				imovelLivre.setListaVisita(visitas);
			}
			return imovelLivre;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
    	return null;
    }

    public ImovelLivre listaVistoria(ImovelLivre imovelLivre) {
    	try {
    		List<Vistoria> vistorias = new ArrayList<Vistoria>();
    		String sql = "CALL listar_Vistorias("+imovelLivre.getIdImovel()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Vistoria vistoria = new Vistoria(
							rs.getInt("idVistoria"),
							rs.getObject("dataVistoria", LocalDate.class),
							rs.getString("resultado")
							);
					vistorias.add(vistoria);
				}
				imovelLivre.setListaVistoria(vistorias);
			}
			return imovelLivre;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
    	return null;
    }
}
