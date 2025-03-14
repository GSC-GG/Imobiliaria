package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

import model.*;
import banco.*;

public class ConsultarImovelView extends MaeView {

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
		shell.setSize(450, 600);
		shell.setText("Consultar_Imovel");
		
		Label labelsearchid = new Label(shell, SWT.NONE);
		labelsearchid.setBounds(10, 15, 120, 25);
		labelsearchid.setText("Insira o ID do Imovel:");
		
		Text searchid = new Text(shell, SWT.BORDER);
        searchid.setBounds(130, 10, 80, 25);
        
        Button botaoBuscar = new Button(shell, SWT.NONE);
		botaoBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoBuscar.setText("carregando");
				DataImovel dataImovel = new DataImovel();
				Imovel imovelBase = new Imovel(Integer.parseInt(searchid.getText()));
				Imovel imovelResultado = dataImovel.consultarImovel(imovelBase);
				imovelResultado = dataImovel.consultarImovel(imovelResultado);
				
				shell.dispose();
					ConsultarImovelView suaOutraView = new ConsultarImovelView();
					suaOutraView.open(imovelResultado);
			}
		});;
		botaoBuscar.setBounds(220, 10, 200, 25);
		botaoBuscar.setText("Buscar");
		
		Label labeltitle1 = new Label(shell, SWT.NONE);
		labeltitle1.setBounds(10, 60, 200, 20);
		labeltitle1.setText("Resultado para a busca IMOVEL:");
		
		Label labelimovel = new Label(shell, SWT.NONE);
		labelimovel.setBounds(10, 80, 80, 20);
		labelimovel.setText("- ID Imovel:");
		
		Label idImovel = new Label(shell, SWT.NONE);
        idImovel.setBounds(100, 80, 50, 20);
        if(imovel != null) {
        	idImovel.setText(String.valueOf(imovel.getIdImovel()));
        }else{
        	idImovel.setText("xxx");
        }
        
        Label labelimobiliaria2 = new Label(shell, SWT.NONE);
		labelimobiliaria2.setBounds(10, 100, 80, 20);
		labelimobiliaria2.setText("- ID Imobiliaria:");
		
		Label idImobiliaria2 = new Label(shell, SWT.NONE);
        idImobiliaria2.setBounds(100, 100, 50, 20);
        if(imovel != null) {
        	idImobiliaria2.setText(String.valueOf(imovel.getIdImobiliaria()));
        }else{
        	idImobiliaria2.setText("xxx");
        }
        
        Label labelidagenda = new Label(shell, SWT.NONE);
		labelidagenda.setBounds(10, 120, 80, 20);
		labelidagenda.setText("- ID Agenda:");
		
		Label idagenda = new Label(shell, SWT.NONE);
        idagenda.setBounds(100, 120, 50, 20);
        if(imovel != null) {
        	idagenda.setText(String.valueOf(imovel.getIdAgenda()));
        }else{
        	idagenda.setText("xxx");
        }
        
        Label labelendereco = new Label(shell, SWT.NONE);
		labelendereco.setBounds(10, 140, 80, 20);
		labelendereco.setText("- Endereco:");
		
		Label endereco = new Label(shell, SWT.NONE);
        endereco.setBounds(100, 140, 300, 20);
        if(imovel != null) {
        	endereco.setText(imovel.getEndereco());
        }else{
        	endereco.setText("vazio");
        }
        
        Label labelstatus = new Label(shell, SWT.NONE);
		labelstatus.setBounds(10, 160, 80, 20);
		labelstatus.setText("- Status:");
		
		Label status = new Label(shell, SWT.NONE);
        status.setBounds(100, 160, 100, 20);
        if(imovel != null) {
        	status.setText(imovel.getStatus());
        }else{
        	status.setText("vazio");
        }
        
        //ADMINISTRA AGENDA DO IMOVEL
        if(imovel.getIdAgenda() == null && imovel.getIdImovel() != null) {
        	Button botaoCriaAgenda = new Button(shell, SWT.NONE);
    		botaoCriaAgenda.addSelectionListener(new SelectionAdapter() {
    			@Override
    			public void widgetSelected(SelectionEvent e) {
    				botaoCriaAgenda.setText("carregando");
    				DataImovel dataImovel = new DataImovel();
    				DataAgenda dataAgenda = new DataAgenda();
    				dataAgenda.incluir(imovel);
    				Imovel imovelResultado = dataImovel.consultarImovel(imovel);
    				shell.close();
    				ConsultarImovelView suaOutraView = new ConsultarImovelView();
    				suaOutraView.open(imovelResultado);
    			}
    		});;
    		botaoCriaAgenda.setBounds(125, 200, 150, 25);
    		botaoCriaAgenda.setText("Criar Agenda");
		}  else {
			if(imovel != null) {
				Button botaoconsultaagenda = new Button(shell, SWT.NONE);
    			botaoconsultaagenda.addSelectionListener(new SelectionAdapter() {
    				@Override
    				public void widgetSelected(SelectionEvent e) {
    					botaoconsultaagenda.setText("carregando");
    					shell.close();
    					AgendaImovelView suaOutraView = new AgendaImovelView();
    					suaOutraView.open(imovel);
    				}
    			});;
    			botaoconsultaagenda.setBounds(125, 200, 150, 25);
    			botaoconsultaagenda.setText("Abrir Agenda");
			}
		}
        
	}

}
