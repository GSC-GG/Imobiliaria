package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import model.Contrato;
import model.Imovel;
import banco.DataContrato;

public class InserirContratoView {

	protected Shell shell;


	//Open the window.
	public void open(Integer idImovel) {
		Display display = Display.getDefault();
		createContents(idImovel);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	//Create contents of the window.
	protected void createContents(Integer idImovel) {
		shell = new Shell();
		shell.setSize(450, 130);
		shell.setText("Inserir_Contrato");
		
		Label labelvalor = new Label(shell, SWT.NONE);
		labelvalor.setBounds(10, 15, 50, 25);
		labelvalor.setText("Valor de aluguel:");
		
		Text valor = new Text(shell, SWT.BORDER);
        valor.setBounds(70, 10, 300, 25);
        
        Button botaoInserir = new Button(shell, SWT.NONE);
		botaoInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoInserir.setText("carregando");
				Contrato contrato = new Contrato(null, Double.parseDouble(valor.getText()), idImovel, null, null);
				DataContrato dataContrato = new DataContrato();
				dataContrato.incluirContrato(contrato, idImovel);
				Imovel imovelSaida = new Imovel(null, null, null, null, null, null);
				shell.close();
				ConsultarImovelView suaOutraView = new ConsultarImovelView();
				suaOutraView.open(imovelSaida);
			}
		});;
		botaoInserir.setBounds(175, 50, 100, 25);
		botaoInserir.setText("Inserir");
	}

}
