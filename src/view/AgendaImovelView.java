package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import model.*;
import banco.*;

public class AgendaImovelView {

	protected Shell shell;


	//Open the window.
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

	//Create contents of the window.
	protected void createContents(Imovel imovel) {
		shell = new Shell();
		shell.setSize(450, 350);
		shell.setText("Agenda");
		
		if(imovel.getStatus() == "Indisponivel") {
			Button botaoagendavistoria = new Button(shell, SWT.NONE);
			botaoagendavistoria.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					botaoagendavistoria.setText("agendando Vistoria...");
					
					Label labelidcorretor = new Label(shell, SWT.NONE);
					labelidcorretor.setBounds(10, 95, 130, 25);
					labelidcorretor.setText("Insira o ID do Corretor:");
					
					Text idCorretor = new Text(shell, SWT.BORDER);
			        idCorretor.setBounds(140, 90, 280, 25);
			        
					Label labeldata = new Label(shell, SWT.NONE);
					labeldata.setBounds(10, 135, 120, 25);
					labeldata.setText("Selecione uma data:");
			        
			        DateTime dateTime = new DateTime(shell, SWT.DATE | SWT.DROP_DOWN);
			        dateTime.setBounds(140, 130, 100, 25);;
			        
			        Button botaoagendar = new Button(shell, SWT.NONE);
					botaoagendar.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							botaoagendar.setText("carregando");
							
							int dia = dateTime.getDay();
							int mes = dateTime.getMonth();
							int ano = dateTime.getYear();
							LocalDate localDate = LocalDate.of(ano, mes + 1, dia);
							
							DataVistoria dataVistoria = new DataVistoria();
							Vistoria vistoria = new Vistoria(null, imovel.getIdAgenda(), Integer.parseInt(idCorretor.getText()), localDate, null);
							dataVistoria.incluirVistoria(vistoria);
							
							shell.close();
							
							AgendaImovelView suaOutraView = new AgendaImovelView();
							suaOutraView.open(imovel);
						}
					});;
					botaoagendar.setBounds(125, 200, 200, 25);
					botaoagendar.setText("Agendar");
				}
			});;
			botaoagendavistoria.setBounds(125, 10, 200, 25);
			botaoagendavistoria.setText("Agendar Vistoria");
			
			
			
			Button botaovervistoria = new Button(shell, SWT.NONE);
			botaovervistoria.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					botaovervistoria.setText("carregando");
					DataVistoria dataVistoria = new DataVistoria();
					Vistoria vistoria = dataVistoria.consultarVistoriaAgenda(imovel.getIdAgenda());
					
					Label labeltitle1 = new Label(shell, SWT.NONE);
					labeltitle1.setBounds(10, 100, 200, 20);
					labeltitle1.setText("Dados da VISTORIA:");
					
					Label labelidvistoria = new Label(shell, SWT.NONE);
					labelidvistoria.setBounds(10, 120, 80, 20);
					labelidvistoria.setText("- ID Vistoria:");
					
					Label idvistoria = new Label(shell, SWT.NONE);
			        idvistoria.setBounds(100, 120, 300, 20);
			        if(vistoria.getIdVistoria() != null) {
			        	idvistoria.setText(String.valueOf(vistoria.getIdVistoria()));
			        }else{
			        	idvistoria.setText("xxx");
			        }
			        
			        Label labelidcorretor = new Label(shell, SWT.NONE);
					labelidcorretor.setBounds(10, 140, 80, 20);
					labelidcorretor.setText("- ID Corretor:");
					
					Label idcorretor = new Label(shell, SWT.NONE);
					idcorretor.setBounds(100, 140, 300, 20);
			        if(vistoria.getIdCorretor() != null) {
			        	DataCorretor dataCorretor = new DataCorretor();
			        	Corretor corretor = new Corretor(vistoria.getIdCorretor());
			        	corretor = dataCorretor.consultarCorretor(corretor);
			        	idcorretor.setText(String.valueOf(vistoria.getIdCorretor()) + " - " + corretor.getNome());
			        }else{
			        	idcorretor.setText("xxx - vazio");
			        }
			        
			        Label labeldata = new Label(shell, SWT.NONE);
					labeldata.setBounds(10, 160, 80, 20);
					labeldata.setText("- Data:");
					
					Label data = new Label(shell, SWT.NONE);
			        data.setBounds(100, 160, 300, 20);
			        if(vistoria.getIdVistoria() != null) {
			        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			        	data.setText(vistoria.getDataVistoria().format(formatter));
			        }else{
			        	data.setText("xx/xx/xxxx");
			        }
			        
			        Label labelresultado = new Label(shell, SWT.NONE);
					labelresultado.setBounds(10, 180, 80, 20);
					labelresultado.setText("- Resultado:");
					
					Label resultado = new Label(shell, SWT.NONE);
			        resultado.setBounds(100, 180, 300, 20);
			        if(vistoria.getResultado() != null) {
			        	resultado.setText(vistoria.getResultado());
			        }else{
			        	resultado.setText("vazio");
			        }
			        
			        Button botaoresultabom = new Button(shell, SWT.NONE);
					botaoresultabom.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							botaoresultabom.setText("Vistoria Concluida");
							DataVistoria dataVistoria = new DataVistoria();
							dataVistoria.avaliarImovel(vistoria.getIdVistoria(), "Aprovado");
							Imovel imovelSaida = new Imovel(null, null, null, null, null, null);
							shell.close();
							ConsultarImovelView suaOutraView = new ConsultarImovelView();
							suaOutraView.open(imovelSaida);
						}
					});;
					botaoresultabom.setBounds(10, 210, 200, 25);
					botaoresultabom.setText("\"APROVAR\"");
					
					Button botaoresultamau = new Button(shell, SWT.NONE);
					botaoresultamau.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							botaoresultamau.setText("Vistoria Concluida");
							DataVistoria dataVistoria = new DataVistoria();
							dataVistoria.avaliarImovel(vistoria.getIdVistoria(), "Reprovado");
							Imovel imovelSaida = new Imovel(null, null, null, null, null, null);
							shell.close();
							ConsultarImovelView suaOutraView = new ConsultarImovelView();
							suaOutraView.open(imovelSaida);
						}
					});;
					botaoresultamau.setBounds(220, 210, 200, 25);
					botaoresultamau.setText("\"REPROVAR\"");
				}
			});;
			botaovervistoria.setBounds(125, 50, 200, 25);
			botaovervistoria.setText("Consultar Vistoria");
		}
		
		if(imovel.getStatus() == "Disponivel") {
			Button botaoagendavisita = new Button(shell, SWT.NONE);
			botaoagendavisita.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					botaoagendavisita.setText("agendando Visita...");
					
					Label labelidcorretor = new Label(shell, SWT.NONE);
					labelidcorretor.setBounds(10, 95, 130, 25);
					labelidcorretor.setText("Insira o ID do Corretor:");
					
					Text idCorretor = new Text(shell, SWT.BORDER);
			        idCorretor.setBounds(140, 90, 280, 25);
			        
					Label labeldata = new Label(shell, SWT.NONE);
					labeldata.setBounds(10, 135, 120, 25);
					labeldata.setText("Selecione uma data:");
			        
			        DateTime dateTime = new DateTime(shell, SWT.DATE | SWT.DROP_DOWN);
			        dateTime.setBounds(140, 130, 100, 25);;
			        
			        Button botaoagendar = new Button(shell, SWT.NONE);
					botaoagendar.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							botaoagendar.setText("carregando");
							
							int dia = dateTime.getDay();
							int mes = dateTime.getMonth();
							int ano = dateTime.getYear();
							LocalDate localDate = LocalDate.of(ano, mes + 1, dia);
							
							DataVisita dataVisita = new DataVisita();
							Visita visita = new Visita(null, imovel.getIdAgenda(), Integer.parseInt(idCorretor.getText()), localDate, null);
							dataVisita.incluirVisita(visita);
							
							shell.close();
							
							AgendaImovelView suaOutraView = new AgendaImovelView();
							suaOutraView.open(imovel);
						}
					});;
					botaoagendar.setBounds(125, 200, 200, 25);
					botaoagendar.setText("Agendar");
				}
			});;
			botaoagendavisita.setBounds(125, 10, 200, 25);
			botaoagendavisita.setText("Agendar Visita");
			
			
			
			Button botaovervisita = new Button(shell, SWT.NONE);
			botaovervisita.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					botaovervisita.setText("carregando");
					DataVisita dataVisita = new DataVisita();
					Visita visita = dataVisita.consultarVisitaAgenda(imovel.getIdAgenda());
					
					Label labeltitle1 = new Label(shell, SWT.NONE);
					labeltitle1.setBounds(10, 100, 200, 20);
					labeltitle1.setText("Dados da VISITA:");
					
					Label labelidvisita = new Label(shell, SWT.NONE);
					labelidvisita.setBounds(10, 120, 80, 20);
					labelidvisita.setText("- ID Visita:");
					
					Label idvisita = new Label(shell, SWT.NONE);
			        idvisita.setBounds(100, 120, 300, 20);
			        if(visita.getIdVisita() != null) {
			        	idvisita.setText(String.valueOf(visita.getIdVisita()));
			        }else{
			        	idvisita.setText("xxx");
			        }
			        
			        Label labelidcorretor = new Label(shell, SWT.NONE);
					labelidcorretor.setBounds(10, 140, 80, 20);
					labelidcorretor.setText("- ID Corretor:");
					
					Label idcorretor = new Label(shell, SWT.NONE);
					idcorretor.setBounds(100, 140, 300, 20);
			        if(visita.getIdCorretor() != null) {
			        	DataCorretor dataCorretor = new DataCorretor();
			        	Corretor corretor = new Corretor(visita.getIdCorretor());
			        	corretor = dataCorretor.consultarCorretor(corretor);
			        	idcorretor.setText(String.valueOf(visita.getIdCorretor()) + " - " + corretor.getNome());
			        }else{
			        	idcorretor.setText("xxx - vazio");
			        }
			        
			        Label labeldata = new Label(shell, SWT.NONE);
					labeldata.setBounds(10, 160, 80, 20);
					labeldata.setText("- Data:");
					
					Label data = new Label(shell, SWT.NONE);
			        data.setBounds(100, 160, 300, 20);
			        if(visita.getIdVisita() != null) {
			        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			        	data.setText(visita.getDataVisita().format(formatter));
			        }else{
			        	data.setText("xx/xx/xxxx");
			        }
			        
			        Label labelresultado = new Label(shell, SWT.NONE);
					labelresultado.setBounds(10, 180, 80, 20);
					labelresultado.setText("- Resultado:");
					
					Label resultado = new Label(shell, SWT.NONE);
			        resultado.setBounds(100, 180, 300, 20);
			        if(visita.getStatus() != null) {
			        	resultado.setText(visita.getStatus());
			        }else{
			        	resultado.setText("vazio");
			        }
			        
			        
			        
			        Button botaorealiza = new Button(shell, SWT.NONE);
					botaorealiza.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							botaorealiza.setText("Visita Realizada!");
							DataVisita dataVisita = new DataVisita();
							dataVisita.realizarVisita(visita.getIdVisita());
							Imovel imovelSaida = new Imovel(null, null, null, null, null, null);
							shell.close();
							ConsultarImovelView suaOutraView = new ConsultarImovelView();
							suaOutraView.open(imovelSaida);
						}
					});;
					botaorealiza.setBounds(125, 210, 200, 25);
					botaorealiza.setText("\"Realizar Visita\"");
					
				}
			});;
			botaovervisita.setBounds(125, 50, 200, 25);
			botaovervisita.setText("Consultar Visita");
			
		}
		
		Button botaoVoltar = new Button(shell, SWT.NONE);
		botaoVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoVoltar.setText("carregando");
				Imovel imovelSaida = new Imovel(null, null, null, null, null, null);
				shell.close();
				ConsultarImovelView suaOutraView = new ConsultarImovelView();
				suaOutraView.open(imovelSaida);
			}
		});;
		botaoVoltar.setBounds(125, 250, 200, 25);
		botaoVoltar.setText("Voltar");
		
	}

}
