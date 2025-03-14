package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import model.Imovel;

public class InserirImovelView extends MaeView {

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 250);
		shell.setText("Inserir_Imovel");
		
		Label labelimobiliaria = new Label(shell, SWT.NONE);
		labelimobiliaria.setBounds(10, 15, 80, 25);
		labelimobiliaria.setText("ID Imobiliaria:");
		
		Text idImobiliaria = new Text(shell, SWT.BORDER);
        idImobiliaria.setBounds(100, 10, 320, 25);
        
		Label labelrua = new Label(shell, SWT.NONE);
		labelrua.setBounds(10, 55, 30, 25);
		labelrua.setText("Rua:");
		
		Text rua = new Text(shell, SWT.BORDER);
        rua.setBounds(60, 50, 240, 25);
        
        Label labelnum = new Label(shell, SWT.NONE);
		labelnum.setBounds(310, 55, 50, 25);
		labelnum.setText("Numero:");
		
		Text num = new Text(shell, SWT.BORDER);
        num.setBounds(370, 50, 50, 25);
        
        Label labelbairro = new Label(shell, SWT.NONE);
		labelbairro.setBounds(10, 95, 50, 25);
		labelbairro.setText("Bairro:");
		
		Text bairro = new Text(shell, SWT.BORDER);
        bairro.setBounds(60, 90, 360, 25);
        
        Label labelcidade = new Label(shell, SWT.NONE);
		labelcidade.setBounds(10, 135, 50, 25);
		labelcidade.setText("Cidade:");
		
		Text cidade = new Text(shell, SWT.BORDER);
        cidade.setBounds(60, 130, 240, 25);
        
        Label labelestado = new Label(shell, SWT.NONE);
		labelestado.setBounds(310, 135, 40, 25);
		labelestado.setText("Estado:");
		
		Text estado = new Text(shell, SWT.BORDER);
        estado.setBounds(360, 130, 60, 25);
        
        Button botaoInserir = new Button(shell, SWT.NONE);
		botaoInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoInserir.setText("carregando");
				Integer id = null;
				String vazio = null;
				String endereco = rua.getText() + ", " + num.getText() + ", " + bairro.getText() + ", " + cidade.getText() + " - " + estado.getText();
				Imovel imovel = new Imovel(1, vazio, endereco, id, Integer.parseInt(idImobiliaria.getText()), id);
				shell.dispose();
				InserirProprietarioView suaOutraView = new InserirProprietarioView();
				suaOutraView.open(imovel);
			}
		});;
		botaoInserir.setBounds(175, 170, 100, 25);
		botaoInserir.setText("Inserir");
	}

}
