package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import model.Funcionario;
import banco.DataFuncionario;

public class InserirFuncionarioView extends MaeView {

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 210);
		shell.setText("Inserir_Funcionario");
		
		Label labelnome = new Label(shell, SWT.NONE);
		labelnome.setBounds(10, 15, 50, 25);
		labelnome.setText("Nome:");
		
		Text nome = new Text(shell, SWT.BORDER);
        nome.setBounds(70, 10, 300, 25);
        
        Label labelemail = new Label(shell, SWT.NONE);
		labelemail.setBounds(10, 55, 50, 25);
		labelemail.setText("Email:");
        
        Text email = new Text(shell, SWT.BORDER);
        email.setBounds(70, 50, 300, 25);
        
        Label labeltelefone = new Label(shell, SWT.NONE);
		labeltelefone.setBounds(10, 95, 50, 25);
		labeltelefone.setText("Telefone:");
        
        Text telefone = new Text(shell, SWT.BORDER);
        telefone.setBounds(70, 90, 300, 25);
        
        Button botaoInserir = new Button(shell, SWT.NONE);
		botaoInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoInserir.setText("carregando");
				Integer id = null;
				Funcionario funcionario = new Funcionario(id, nome.getText(), telefone.getText(), email.getText());
				DataFuncionario dataFuncionario = new DataFuncionario();
				dataFuncionario.incluirFuncionario(funcionario);
				shell.close();
				FuncView suaOutraView = new FuncView();
				suaOutraView.open();
			}
		});;
		botaoInserir.setBounds(175, 130, 100, 25);
		botaoInserir.setText("Inserir");
	}

}
