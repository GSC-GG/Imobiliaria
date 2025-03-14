package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import banco.DataAgenda;
import banco.DataVisita;
import banco.DataVistoria;

import model.Agenda;
import model.Visita;
import model.Vistoria;

public class ListarVisView extends MaeView {

	protected DataAgenda dataAgenda = new DataAgenda();
	protected Table table;
	
	public void open(Integer idAgenda) {
		
		Agenda agenda = new Agenda(idAgenda);
		agenda = dataAgenda.listaVisita(agenda);
		agenda = dataAgenda.listaVistoria(agenda);
		
		Display display = Display.getDefault();
		createContents(agenda);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createContents(Agenda agenda) {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(169, 22, 99, 23);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 60, 414, 191);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(36);
		tblclmnId.setText("Id");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(67);
		tblclmnNome.setText("IdAgenda");
		
		TableColumn tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(69);
		tblclmnEmail.setText("IdCorretor");
		
		TableColumn tblclmnTelefone = new TableColumn(table, SWT.NONE);
		tblclmnTelefone.setWidth(102);
		tblclmnTelefone.setText("Data");
		
		TableColumn tblclmnStatus = new TableColumn(table, SWT.NONE);
		tblclmnStatus.setWidth(137);
		tblclmnStatus.setText("Status");
		
		
		ToolItem tltmVisitas= new ToolItem(toolBar, SWT.RADIO);
		tltmVisitas.setText("Visitas");
		tltmVisitas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				table.dispose();
				Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
				table.setBounds(10, 60, 414, 191);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				for(int i = 0; i < agenda.getListaVisita().size(); i++) {

					TableItem tableItem = new TableItem(table, SWT.NONE);
					Visita visita = agenda.getListaVisita().get(i);
					String[] texto = {
						String.valueOf(visita.getIdVisita()),
						String.valueOf(visita.getIdAgenda()),
						String.valueOf(visita.getIdCorretor()),
						String.valueOf(visita.getDataVisita()),
						visita.getStatus()
					};
					tableItem.setText(texto);
				}
			}
		});
		
		ToolItem tltmVistorias= new ToolItem(toolBar, SWT.RADIO);
		tltmVistorias.setText("Vistorias");
		tltmVistorias.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				table.dispose();
				Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
				table.setBounds(10, 60, 414, 191);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				for(int i = 0; i < agenda.getListaVistoria().size(); i++) {

					TableItem tableItem = new TableItem(table, SWT.NONE);
					Vistoria vistoria = agenda.getListaVistoria().get(i);
					String[] texto = {
						String.valueOf(vistoria.getIdVistoria()),
						String.valueOf(vistoria.getIdAgenda()),
						String.valueOf(vistoria.getIdCorretor()),
						String.valueOf(vistoria.getDataVistoria()),
						vistoria.getResultado()
					};
					tableItem.setText(texto);
				}
			}
		});
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.setBounds(10, 22, 67, 25);
		btnVoltar.setText("Voltar");
		
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				FuncView funcView = new FuncView();
				funcView.open();
			};
		});

	}
}
