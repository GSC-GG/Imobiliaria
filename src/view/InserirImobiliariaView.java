package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import model.Imobiliaria;
import banco.DataImobiliaria;

public class InserirImobiliariaView extends MaeView {

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 130);
		shell.setText("Inserir_Imobiliaria");
		
		Label labelcnpj = new Label(shell, SWT.NONE);
		labelcnpj.setBounds(10, 15, 50, 25);
		labelcnpj.setText("CNPJ:");
		
		Text cnpj = new Text(shell, SWT.BORDER);
        cnpj.setBounds(70, 10, 300, 25);
        
        Button botaoInserir = new Button(shell, SWT.NONE);
		botaoInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoInserir.setText("carregando");
				Integer id = null;
				Imobiliaria imobiliaria = new Imobiliaria(id, cnpj.getText());
				DataImobiliaria dataImobiliaria = new DataImobiliaria();
				dataImobiliaria.incluirImobiliaria(imobiliaria);
				shell.close();
				View suaOutraView = new View();
				suaOutraView.open();
			}
		});;
		botaoInserir.setBounds(175, 50, 100, 25);
		botaoInserir.setText("Inserir");
	}

}
