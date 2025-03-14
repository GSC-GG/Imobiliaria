package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;

import model.Imovel;
import model.Vistoria;
import model.Proposta;
import model.Contrato;
import model.Agenda;
import model.Proprietario;
import banco.DataImovel;
import banco.DataAgenda;
import banco.DataProprietario;
import banco.DataContrato;

public class PropView {

	protected Shell shell;
	private Table tableVis;
	private Table tableProp;
	
	private Imovel imovel;
	private Agenda agenda;
	private DataImovel dataImovel;
	private DataAgenda dataAgenda;
	

	/**
	 * Open the window.
	 */
	public void open(Proprietario proprietario) {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Imobiliária - Proprietário");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 106, 15);
		lblNewLabel.setText("Vistorias do imóvel");
		
		tableVis = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableVis.setBounds(10, 31, 236, 80);
		tableVis.setHeaderVisible(true);
		tableVis.setLinesVisible(true);
		
		TableColumn tblclmnIdvistoria = new TableColumn(tableVis, SWT.NONE);
		tblclmnIdvistoria.setWidth(60);
		tblclmnIdvistoria.setText("idVistoria");
		
		TableColumn tblclmnData = new TableColumn(tableVis, SWT.NONE);
		tblclmnData.setWidth(82);
		tblclmnData.setText("Data");
		
		TableColumn tblclmnResultado = new TableColumn(tableVis, SWT.NONE);
		tblclmnResultado.setWidth(91);
		tblclmnResultado.setText("Resultado");
		
		Button btnEncomendarNovaVistoria = new Button(shell, SWT.NONE);
		btnEncomendarNovaVistoria.setBounds(252, 31, 149, 25);
		btnEncomendarNovaVistoria.setText("Encomendar nova vistoria");
		
		Label lblPropostasDeAluguel = new Label(shell, SWT.NONE);
		lblPropostasDeAluguel.setBounds(10, 117, 115, 15);
		lblPropostasDeAluguel.setText("Propostas de aluguel");
		
		tableProp = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableProp.setBounds(10, 138, 236, 95);
		tableProp.setHeaderVisible(true);
		tableProp.setLinesVisible(true);
		
		TableColumn tblclmnIdproposta = new TableColumn(tableProp, SWT.NONE);
		tblclmnIdproposta.setWidth(60);
		tblclmnIdproposta.setText("idProposta");
		
		TableColumn tblclmnValor = new TableColumn(tableProp, SWT.NONE);
		tblclmnValor.setWidth(82);
		tblclmnValor.setText("Valor");
		
		TableColumn tblclmnStatus = new TableColumn(tableProp, SWT.NONE);
		tblclmnStatus.setWidth(94);
		tblclmnStatus.setText("Status");
		
		Button btnAceitarProposta = new Button(shell, SWT.NONE);
		btnAceitarProposta.setEnabled(false);
		btnAceitarProposta.setBounds(252, 143, 99, 25);
		btnAceitarProposta.setText("Aceitar proposta");
		
		Button btnRecusarProposta = new Button(shell, SWT.NONE);
		btnRecusarProposta.setEnabled(false);
		btnRecusarProposta.setBounds(252, 174, 99, 25);
		btnRecusarProposta.setText("Recusar proposta");
		
		Button btnRemoverImvel = new Button(shell, SWT.NONE);
		btnRemoverImvel.setBounds(252, 62, 99, 25);
		btnRemoverImvel.setText("Remover imóvel");
		
		Button btnCancelarContrato = new Button(shell, SWT.NONE);
		btnCancelarContrato.setEnabled(false);
		btnCancelarContrato.setBounds(252, 93, 99, 25);
		btnCancelarContrato.setText("Cancelar contrato");
		
		/*
		dataImovel = new DataImovel();
		//imovel = new Imovel();
		imovel = dataImovel.consultarImovel(imovel);
		
		dataAgenda = new DataAgenda();
		agenda = dataAgenda.consultar(agenda);
		*/
	}
}
