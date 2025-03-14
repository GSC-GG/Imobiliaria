package view;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;

import banco.DataVisita;
import banco.DataVistoria;
import banco.DataAgenda;
//import banco.DataImovel;
import banco.DataImobiliaria;
import model.Visita;
import model.Vistoria;
import model.Agenda;
import model.ImovelLivre;
import model.Imobiliaria;

public class CorView extends MaeView {

	protected Table tableVisitas;
	protected Table tableVistorias;
	
	protected DataAgenda dataAgenda;
	protected DataImobiliaria dataImo;
	protected DataVisita dataVisita;
	protected DataVistoria dataVistoria;
	protected Imobiliaria imobiliaria;
	protected Agenda agenda;

	protected void createContents() {
		
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Imobiliária - Corretor");
		
		Label lblVisitasMarcadas = new Label(shell, SWT.NONE);
		lblVisitasMarcadas.setBounds(10, 10, 93, 15);
		lblVisitasMarcadas.setText("Visitas Marcadas");
		
		tableVisitas = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableVisitas.setLinesVisible(true);
		tableVisitas.setHeaderVisible(true);
		tableVisitas.setBounds(10, 31, 205, 191);
		
		TableColumn tblclmnId = new TableColumn(tableVisitas, SWT.NONE);
		tblclmnId.setWidth(36);
		tblclmnId.setText("Id");
		
		TableColumn tblclmnNome = new TableColumn(tableVisitas, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Endereço");
		
		TableColumn tblclmnTelefone = new TableColumn(tableVisitas, SWT.NONE);
		tblclmnTelefone.setWidth(69);
		tblclmnTelefone.setText("Data");
		
		Label lblVistoriasMarcadas = new Label(shell, SWT.NONE);
		lblVistoriasMarcadas.setText("Vistorias Marcadas");
		lblVistoriasMarcadas.setBounds(221, 10, 93, 15);
		
		tableVistorias = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableVistorias.setLinesVisible(true);
		tableVistorias.setHeaderVisible(true);
		tableVistorias.setBounds(221, 31, 205, 191);
		
		TableColumn tblclmnId_1 = new TableColumn(tableVistorias, SWT.NONE);
		tblclmnId_1.setWidth(36);
		tblclmnId_1.setText("Id");
		
		TableColumn tblclmnNome_1 = new TableColumn(tableVistorias, SWT.NONE);
		tblclmnNome_1.setWidth(100);
		tblclmnNome_1.setText("Endereço");
		
		TableColumn tblclmnTelefone_1 = new TableColumn(tableVistorias, SWT.NONE);
		tblclmnTelefone_1.setWidth(69);
		tblclmnTelefone_1.setText("Data");
		
		try {
			dataAgenda = new DataAgenda();
			dataImo = new DataImobiliaria();
			dataVisita = new DataVisita();
			dataVistoria = new DataVistoria();
			imobiliaria = new Imobiliaria(1);
			
			imobiliaria = dataImo.listaImovelLivre(imobiliaria);
			ImovelLivre imovel;
			
			for(int i = 0; i < imobiliaria.getListaImovelLivre().size(); i++) {
				imovel = new ImovelLivre(imobiliaria.getListaImovelLivre().get(i).getIdImovel());
				agenda = new Agenda(imovel.getIdAgenda());
				agenda = dataAgenda.listaVisita(agenda);
				
				for(int j = 0; j < agenda.getListaVisita().size(); j++) {
					Visita visita = new Visita(agenda.getListaVisita().get(j).getIdVisita());
					visita = dataVisita.consultarVisita(visita);
					
					if(visita.getStatus() != "Pendente") {
						continue;
					}
					String[] texto = {
						String.valueOf(visita.getIdVisita()),
						imovel.getEndereco(),
						String.valueOf(visita.getDataVisita())
					};
					TableItem tableItem = new TableItem(tableVisitas, SWT.NONE);
					tableItem.setText(texto);
				}
			}
			
			for(int i = 0; i < imobiliaria.getListaImovelLivre().size(); i++) {
				imovel = new ImovelLivre(imobiliaria.getListaImovelLivre().get(i).getIdImovel());
				agenda = new Agenda(imovel.getIdAgenda());
				agenda = dataAgenda.listaVistoria(agenda);
				
				for(int j = 0; j < agenda.getListaVistoria().size(); j++) {
					Vistoria vistoria = new Vistoria(agenda.getListaVistoria().get(j).getIdVistoria());
					vistoria = dataVistoria.consultarVistoria(vistoria);
					
					if(vistoria.getResultado() != "Aprovado") {
						continue;
					}
					String[] texto = {
						String.valueOf(vistoria.getIdVistoria()),
						imovel.getEndereco(),
						String.valueOf(vistoria.getDataVistoria())
					};
					TableItem tableItem = new TableItem(tableVistorias, SWT.NONE);
					tableItem.setText(texto);
				}
			}
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
}
