package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.KeyEvent;

public class TesteView {

	protected Shell shell;
	private Text txtInsiraSeuId;
	private Table table;


	//Open the window.
	public void open() {
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

	//Create contents of the window.
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		toolBar.setBounds(49, 31, 346, 23);
		
		ToolItem tltmFuncionrios = new ToolItem(toolBar, SWT.RADIO);
		tltmFuncionrios.setText("Funcionários");
		
		ToolItem tltmLocatrios = new ToolItem(toolBar, SWT.RADIO);
		tltmLocatrios.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		tltmLocatrios.setText("Locatários");
		
		ToolItem tltmProprietrios = new ToolItem(toolBar, SWT.RADIO);
		tltmProprietrios.setText("Proprietários");
		
		ToolItem tltmCorretores = new ToolItem(toolBar, SWT.RADIO);
		tltmCorretores.setText("Corretores");
		
		ToolItem tltmImveis = new ToolItem(toolBar, SWT.RADIO);
		tltmImveis.setText("Imóveis");
		
		Label lblListagem = new Label(shell, SWT.NONE);
		lblListagem.setAlignment(SWT.CENTER);
		lblListagem.setBounds(196, 10, 55, 15);
		lblListagem.setText("Listagem");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(49, 60, 346, 191);
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
		tblclmnTelefone.setWidth(85);
		tblclmnTelefone.setText("Data");
		
		TableColumn tblclmnStatus = new TableColumn(table, SWT.NONE);
		tblclmnStatus.setWidth(86);
		tblclmnStatus.setText("Status");

	}
}
