
/*
 * A SER APAGADA
 */

package banco;

import model.Agenda;
import model.Corretor;
import model.Imovel;
import model.Visita;
import model.Vistoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class DataAgenda {
    private DBConnection connection;
    
    public DataAgenda() {
        this.connection = new DBConnection();
    }

    public void incluir(Imovel imovel) {
        try {
            String sql = "CALL inserir_Agenda(?);";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, imovel.getIdImovel());
            statement.execute();
            statement.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    

    public Agenda consultar(Agenda agenda) {
        try {
            String sql = "CALL consultar_Agenda("+agenda.getIdAgenda()+");";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setInt(1, agenda.getIdAgenda());
            ResultSet rs = statement.executeQuery();
            if (rs != null && rs.next()) {
                agenda = new Agenda(
                    rs.getInt("idAgenda")
                );
            } else {
            	return null;
            }
        return agenda;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Agenda listaVisita(Agenda agenda) {
    	try {
    		List<Visita> visitas = new ArrayList<Visita>();
    		String sql = "CALL listar_Visitas("+agenda.getIdAgenda()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Visita visita = new Visita(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getObject(4, LocalDate.class), rs.getString(5));
					visitas.add(visita);
				}
				agenda.setListaVisita(visitas);
			}
			return agenda;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
    	return null;
    }

    public Agenda listaVistoria(Agenda agenda) {
    	try {
    		List<Vistoria> vistorias = new ArrayList<Vistoria>();
    		String sql = "CALL listar_Vistorias("+agenda.getIdAgenda()+");";
			PreparedStatement statement = connection.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs != null && rs.next()) {
				while (rs.next()) {

					Vistoria vistoria = new Vistoria(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getObject(4, LocalDate.class), rs.getString(5));
					vistorias.add(vistoria);
				}
				agenda.setListaVistoria(vistorias);
			}
			return agenda;
    	}
    	catch(SQLException e) {
			e.printStackTrace();
    	}
    	return null;
    }
}