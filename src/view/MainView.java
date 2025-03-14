package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import banco.DataLocatario;
import banco.DataProprietario;
import banco.DataCorretor;
import banco.DataFuncionario;

import model.Locatario;
import model.Proprietario;
import model.Corretor;
import model.Funcionario;

public class MainView extends MaeView {

	public static void main(String[] args) {
		try {
			MainView window = new MainView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 340);
		shell.setText("Imobiliária");
		
		Label lblInsiraSeuId = new Label(shell, SWT.NONE);
		lblInsiraSeuId.setAlignment(SWT.RIGHT);
		lblInsiraSeuId.setBounds(106, 65, 76, 15);
		lblInsiraSeuId.setText("Insira seu id");
		
		Button btnEntrarComoLoc = new Button(shell, SWT.RADIO);
		btnEntrarComoLoc.setSelection(true);
		btnEntrarComoLoc.setBounds(121, 101, 158, 16);
		btnEntrarComoLoc.setText("Entrar como Locatário");
		
		Button btnEntrarComoProprietario = new Button(shell, SWT.RADIO);
		btnEntrarComoProprietario.setText("Entrar como Proprietário");
		btnEntrarComoProprietario.setBounds(121, 123, 158, 16);
		
		Button btnEntrarComoCorretor = new Button(shell, SWT.RADIO);
		btnEntrarComoCorretor.setText("Entrar como Corretor");
		btnEntrarComoCorretor.setBounds(121, 145, 158, 16);
		
		Button btnEntrarComoFuncionrio = new Button(shell, SWT.RADIO);
		btnEntrarComoFuncionrio.setText("Entrar como Funcionário");
		btnEntrarComoFuncionrio.setBounds(121, 167, 158, 16);

		Text txtInsiraSeuId = new Text(shell, SWT.BORDER);
		txtInsiraSeuId.setBounds(188, 59, 76, 21);
		txtInsiraSeuId.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
					
					if(txtInsiraSeuId.getText() == "") {
						txtInsiraSeuId.setText("0");
					}
					
					if(btnEntrarComoLoc.getSelection()) {
						DataLocatario dataLoc = new DataLocatario();
						Locatario loc = new Locatario(Integer.parseInt(txtInsiraSeuId.getText()));
						loc = dataLoc.consultarLocatario(loc);
						
						if(loc == null) {
							Label lblIdInvlido = new Label(shell, SWT.NONE);
							lblIdInvlido.setBounds(270, 65, 63, 15);
							lblIdInvlido.setText("Id inválido!");
						} else {
							shell.dispose();
							LocView locView = new LocView();
							locView.open();
						}
					}
					if(btnEntrarComoProprietario.getSelection()) {
						DataProprietario dataProp = new DataProprietario();
						Proprietario prop = new Proprietario(Integer.parseInt(txtInsiraSeuId.getText()));
						prop = dataProp.consultarProprietario(prop);
						
						if(prop == null) {
							Label lblIdInvlido = new Label(shell, SWT.NONE);
							lblIdInvlido.setBounds(270, 65, 63, 15);
							lblIdInvlido.setText("Id inválido!");
						} else {
							shell.dispose();
							PropView propView = new PropView();
							propView.open(prop);
						}
					}
					if(btnEntrarComoCorretor.getSelection()) {
						DataCorretor dataCor = new DataCorretor();
						Corretor cor = new Corretor(Integer.parseInt(txtInsiraSeuId.getText()));
						cor = dataCor.consultarCorretor(cor);
						
						if(cor == null) {
							Label lblIdInvlido = new Label(shell, SWT.NONE);
							lblIdInvlido.setBounds(270, 65, 63, 15);
							lblIdInvlido.setText("Id inválido!");
						} else {
							shell.dispose();
							CorView corView = new CorView();
							corView.open();
						}
					}
					if(btnEntrarComoFuncionrio.getSelection()) {
						DataFuncionario dataFunc = new DataFuncionario();
						Funcionario func = new Funcionario(Integer.parseInt(txtInsiraSeuId.getText()));
						func = dataFunc.consultarFuncionario(func);
						
						if(func == null) {
							Label lblIdInvlido = new Label(shell, SWT.NONE);
							lblIdInvlido.setBounds(270, 65, 63, 15);
							lblIdInvlido.setText("Id inválido!");
						} else {
							shell.dispose();
							FuncView funcView = new FuncView();
							funcView.open();
						}
					}
				}
			};
			
			public void keyReleased(KeyEvent e) {
				
			};
		});
		

		Button btnEntrarComoCliente = new Button(shell, SWT.NONE);
		btnEntrarComoCliente.setBounds(149, 206, 126, 25);
		btnEntrarComoCliente.setText("Alugar Imóvel");
		
		btnEntrarComoCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				ClienteView viewCliente = new ClienteView();
				viewCliente.open();
			}
		});
		
		Button btnCadastrarImvel = new Button(shell, SWT.NONE);
		btnCadastrarImvel.setText("Cadastrar Imóvel");
		btnCadastrarImvel.setBounds(149, 253, 126, 25);
		
		/*btnCadastrarImvel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				InserirImovelView viewProp = new InserirImovelView();
				viewProp.open();
			}
		});*/
	}
}
