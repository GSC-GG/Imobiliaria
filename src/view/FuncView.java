package view;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Table;

import model.Corretor;
import model.Funcionario;
import model.Imovel;
//import model.Locatario;
//import model.Proprietario;
import banco.DataCorretor;
import banco.DataFuncionario;
import banco.DataImovel;
//import banco.DataLocatario;
//import banco.DataProprietario;
import org.eclipse.swt.widgets.TableColumn;

public class FuncView extends MaeView{
	
	private Table table;
	private TableItem tableItens;
	private Button btnAgenda;
	private Label lblConsultar;
	private Label lblNoEncontrado;
	private TableColumn tblclmn_1;
	private TableColumn tblclmn_2;
	private TableColumn tblclmn_3;
	private TableColumn tblclmn_4;
	private TableColumn tblclmn_5;
	private TableColumn tblclmn_6;
	private String[] tableInicio = {"", "", "", "", ""};
	private String classe;
	KeyListener keyLis;

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 400);
		shell.setText("Imobiliária - Funcionário");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 0, 0);
		tblclmn_1 = new TableColumn(table, SWT.NONE);
		tblclmn_2 = new TableColumn(table, SWT.NONE);
		tblclmn_3 = new TableColumn(table, SWT.NONE);
		tblclmn_4 = new TableColumn(table, SWT.NONE);
		tblclmn_5 = new TableColumn(table, SWT.NONE);
		tblclmn_6 = new TableColumn(table, SWT.NONE);
		tableItens = new TableItem(table, SWT.NONE);

		lblConsultar = new Label(shell, SWT.NONE);
		lblConsultar.setBounds(100, 200, 100, 15);
		
		lblNoEncontrado = new Label(shell, SWT.NONE);

		/*Label lblConsultar = new Label(shell, SWT.NONE);
		lblConsultar.setAlignment(SWT.RIGHT);
		lblConsultar.setBounds(87, 200, 113, 15);
		lblConsultar.setText("Id do corretor:");

		Text textConsulta = new Text(shell, SWT.BORDER);
		textConsulta.setBounds(206, 197, 76, 21);*/
		
		Label lblCorretores = new Label(shell, SWT.NONE);
		lblCorretores.setBounds(39, 43, 55, 15);
		lblCorretores.setText("Corretores");
		
		Button btnConsultarCorretor = new Button(shell, SWT.NONE);
		btnConsultarCorretor.setBounds(123, 28, 75, 25);
		btnConsultarCorretor.setText("Consultar");
		
		btnConsultarCorretor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(btnAgenda != null) {
					btnAgenda.dispose();
				}
				
				table.setBounds(10, 228, 414, 45);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				tblclmn_1.setWidth(38);
				tblclmn_1.setText("Id");
				
				tblclmn_2.setWidth(79);
				tblclmn_2.setText("Nome");
				
				tblclmn_3.setWidth(80);
				tblclmn_3.setText("Email");
				
				tblclmn_4.setWidth(135);
				tblclmn_4.setText("Telefone");
				
				tblclmn_5.setWidth(0);
				tblclmn_5.setText("");
				
				tblclmn_6.setWidth(0);
				tblclmn_6.setText("");

				tableItens.setText(tableInicio);

				lblConsultar.setText("Id do corretor:");

				Text textConsulta = new Text(shell, SWT.BORDER);
				textConsulta.setBounds(206, 197, 76, 21);
				
				classe = "corretor";
			}
		});
		
		Button btnCadastrarCorretor = new Button(shell, SWT.NONE);
		btnCadastrarCorretor.setBounds(123, 59, 75, 25);
		btnCadastrarCorretor.setText("Cadastrar");
		
		btnCadastrarCorretor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				InserirCorretorView newView = new InserirCorretorView();
				newView.open();
			}
		});
		
		Label lblImveis = new Label(shell, SWT.NONE);
		lblImveis.setText("Imóveis");
		lblImveis.setBounds(238, 43, 55, 15);
		
		Button btnConsultarImovel = new Button(shell, SWT.NONE);
		btnConsultarImovel.setText("Consultar");
		btnConsultarImovel.setBounds(322, 28, 75, 25);
		
		btnConsultarImovel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(btnAgenda != null) {
					btnAgenda.dispose();
				}
				
				table.setBounds(10, 228, 414, 45);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				tblclmn_1.setWidth(38);
				tblclmn_1.setText("Id");
				
				tblclmn_2.setWidth(79);
				tblclmn_2.setText("IdImobiliaria");
				
				tblclmn_3.setWidth(70);
				tblclmn_3.setText("Status");
				
				tblclmn_4.setWidth(125);
				tblclmn_4.setText("Endereço");
				
				tblclmn_5.setWidth(70);
				tblclmn_5.setText("idAgenda");
				
				tblclmn_6.setWidth(50);
				tblclmn_6.setText("IdProprietario");

				tableItens.setText(tableInicio);
				
				lblConsultar.setText("Id do imóvel:");
				
				classe = "imovel";

			}
		});
		
		Button btnCadastrarImovel = new Button(shell, SWT.NONE);
		btnCadastrarImovel.setText("Cadastrar");
		btnCadastrarImovel.setBounds(322, 59, 75, 25);

		btnCadastrarImovel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				InserirImovelView newView = new InserirImovelView();
				newView.open();
			}
		});
		
		Label lblFuncionrios = new Label(shell, SWT.NONE);
		lblFuncionrios.setText("Funcionários");
		lblFuncionrios.setBounds(26, 125, 68, 15);
		
		Button btnConsultarFunc = new Button(shell, SWT.NONE);
		btnConsultarFunc.setText("Consultar");
		btnConsultarFunc.setBounds(123, 110, 75, 25);
		
		btnConsultarFunc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(btnAgenda != null) {
					btnAgenda.dispose();
				}
				
				table.setBounds(10, 228, 414, 45);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				tblclmn_1.setWidth(38);
				tblclmn_1.setText("Id");
				
				tblclmn_2.setWidth(79);
				tblclmn_2.setText("Nome");
				
				tblclmn_3.setWidth(80);
				tblclmn_3.setText("Email");
				
				tblclmn_4.setWidth(135);
				tblclmn_4.setText("Telefone");
				
				tblclmn_5.setWidth(0);
				tblclmn_5.setText("");
				
				tblclmn_6.setWidth(0);
				tblclmn_6.setText("");
				
				tableItens.setText(tableInicio);

				lblConsultar.setText("Id do Funcionário:");

				Text textConsulta = new Text(shell, SWT.BORDER);
				textConsulta.setBounds(206, 197, 76, 21);
				
				classe = "funcionario";
			}
		});
		
		
		Button btnCadastrarFunc = new Button(shell, SWT.NONE);
		btnCadastrarFunc.setText("Cadastrar");
		btnCadastrarFunc.setBounds(123, 141, 75, 25);

		btnCadastrarFunc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				InserirFuncionarioView newView = new InserirFuncionarioView();
				newView.open();
			}
		});
		Text textConsulta = new Text(shell, SWT.BORDER);
		textConsulta.setBounds(206, 197, 76, 21);
		
		keyLis = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
					
					if(textConsulta.getText() == "") {
						textConsulta.setText("0");
					}
					
					atualizarTabela(Integer.parseInt(textConsulta.getText()));
					
				}
			};
			
			public void keyReleased(KeyEvent e) {

			};
		};
		textConsulta.addKeyListener(keyLis);

	}
	
	
	protected void atualizarTabela(Integer id) {
			
        lblNoEncontrado.setBounds(0, 0, 0, 0);
        lblNoEncontrado.setText("");
    
        if (table.getItemCount() == 0) {
            tableItens = new TableItem(table, SWT.NONE);
        }
        
        if(classe == "corretor") {
			
			DataCorretor dataCorretor = new DataCorretor();
			Corretor corretor = new Corretor(id);
			corretor = dataCorretor.consultarCorretor(corretor);
			
			if(corretor == null) {
				
				lblNoEncontrado.setBounds(288, 200, 100, 15);
				lblNoEncontrado.setText("Não encontrado");
				return;
			}

			lblNoEncontrado.setBounds(0, 0, 0, 0);
			lblNoEncontrado.setText("");
			
			String[] itensFunc = {
				String.valueOf(corretor.getIdCorretor()), 
				String.valueOf(corretor.getNome()), 
				corretor.getEmail(), 
				corretor.getTelefone()
			};
			
			tableItens.setText(itensFunc);
        }
        
        if(classe == "imovel") {
        	
        	DataImovel dataImovel = new DataImovel();
        	Imovel imovel = new Imovel(id);
        	imovel = dataImovel.consultarImovel(imovel);
			
			if(imovel == null) {
				
				lblNoEncontrado.setBounds(288, 200, 100, 15);
				lblNoEncontrado.setText("Não encontrado");
				return;
			}

			lblNoEncontrado.setBounds(0, 0, 0, 0);
			lblNoEncontrado.setText("");
			
			String[] itensFunc = {
				String.valueOf(imovel.getIdImovel()), 
				String.valueOf(imovel.getIdImobiliaria()), 
				imovel.getStatus(), imovel.getEndereco(), 
				String.valueOf(imovel.getIdAgenda()),
				String.valueOf(imovel.getIdProprietario())
			};
			
			tableItens.setText(itensFunc);
			System.out.println(imovel.getIdProprietario());
        }
        
        if(classe == "funcionario") {
        	
        	DataFuncionario dataFunc = new DataFuncionario();
			Funcionario funcionario = new Funcionario(id);
			funcionario = dataFunc.consultarFuncionario(funcionario);
			
			if(funcionario == null) {
				
				lblNoEncontrado.setBounds(288, 200, 100, 15);
				lblNoEncontrado.setText("Não encontrado");
				return;
			}

			lblNoEncontrado.setBounds(0, 0, 0, 0);
			lblNoEncontrado.setText("");
			
			String[] itensFunc = {
				String.valueOf(funcionario.getIdFuncionario()), 
				String.valueOf(funcionario.getNome()), 
				funcionario.getEmail(), 
				funcionario.getTelefone()
			};
			
			tableItens.setText(itensFunc);
	    }
	}
}

