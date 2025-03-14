package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

import model.Imovel;
import banco.DataImovel;

public class ConsultarImovelViewTESTE extends MaeView {

	public void open(Imovel imovel) {
		Display display = Display.getDefault();
		createContents(imovel);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents(Imovel imovel) {
		shell = new Shell();
		shell.setSize(450, 360);
		shell.setText("Consultar_Imovel_TESTE");
		
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
				Imovel imovelBase = new Imovel(id, vazio, endereco, id, Integer.parseInt(idImobiliaria.getText()), id);
				shell.close();
				ConsultarImovelViewTESTE suaOutraView = new ConsultarImovelViewTESTE();
				suaOutraView.open(imovelBase);
			}
		});;
		botaoInserir.setBounds(175, 170, 100, 25);
		botaoInserir.setText("Inserir");
		
		Label labelimovel = new Label(shell, SWT.NONE);
		labelimovel.setBounds(10, 210, 80, 20);
		labelimovel.setText("ID Imovel:");
		
		Label idImovel = new Label(shell, SWT.NONE);
        idImovel.setBounds(90, 210, 50, 20);
        if(imovel.getIdImovel() != null) {
        	idImovel.setText(String.valueOf(imovel.getIdImovel()));
        }else{
        	idImovel.setText("xxx");
        }
        
        Label labelimobiliaria2 = new Label(shell, SWT.NONE);
		labelimobiliaria2.setBounds(10, 230, 80, 20);
		labelimobiliaria2.setText("ID Imobiliaria:");
		
		Label idImobiliaria2 = new Label(shell, SWT.NONE);
        idImobiliaria2.setBounds(90, 230, 50, 20);
        if(imovel.getIdImobiliaria() != null) {
        	idImobiliaria2.setText(String.valueOf(imovel.getIdImobiliaria()));
        }else{
        	idImobiliaria2.setText("xxx");
        }
        
        Label labelidagenda = new Label(shell, SWT.NONE);
		labelidagenda.setBounds(10, 250, 80, 20);
		labelidagenda.setText("ID Agenda:");
		
		Label idagenda = new Label(shell, SWT.NONE);
        idagenda.setBounds(90, 250, 50, 20);
        if(imovel.getIdAgenda() != null) {
        	idagenda.setText(String.valueOf(imovel.getIdAgenda()));
        }else{
        	idagenda.setText("xxx");
        }
        
        Label labelendereco = new Label(shell, SWT.NONE);
		labelendereco.setBounds(10, 270, 80, 20);
		labelendereco.setText("Endereco:");
		
		Label endereco = new Label(shell, SWT.NONE);
        endereco.setBounds(90, 270, 300, 20);
        if(imovel.getEndereco() != null) {
        	endereco.setText(imovel.getEndereco());
        }else{
        	endereco.setText("vazio");
        }
        
        Label labelstatus = new Label(shell, SWT.NONE);
		labelstatus.setBounds(10, 290, 80, 20);
		labelstatus.setText("Status:");
		
		Label status = new Label(shell, SWT.NONE);
        status.setBounds(90, 290, 50, 20);
        if(imovel.getStatus() != null) {
        	status.setText(imovel.getStatus());
        }else{
        	status.setText("vazio");
        }
	}

}
