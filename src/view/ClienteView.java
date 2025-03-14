package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;

import banco.DataImobiliaria;
import model.Imobiliaria;
import model.ImovelLivre;

public class ClienteView {

	protected Shell shell;
	protected Imobiliaria imobiliaria;
	protected DataImobiliaria dataImobiliaria;
	
	private Table table;

	/**
	 * Open the window.
	 */
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

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Imobiliária - Imóveis Disponíveis");
		
		Label lblImveisDisponveis = new Label(shell, SWT.NONE);
		lblImveisDisponveis.setBounds(10, 10, 111, 15);
		lblImveisDisponveis.setText("Imóveis disponíveis");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 31, 414, 220);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnEndereo = new TableColumn(table, SWT.NONE);
		tblclmnEndereo.setWidth(413);
		tblclmnEndereo.setText("Endereço");
		
		try {
			imobiliaria = new Imobiliaria(1);
			dataImobiliaria = new DataImobiliaria();
			
			if(imobiliaria != null) {
				
				imobiliaria = dataImobiliaria.consultarImobiliaria(imobiliaria);
				imobiliaria = dataImobiliaria.listaImovelLivre(imobiliaria);
				
				if(imobiliaria.getListaImovelLivre() != null) {

					for(int i = 0; i < imobiliaria.getListaImovelLivre().size(); i++) {
						
						ImovelLivre imovel = imobiliaria.getListaImovelLivre().get(i);
						TableItem item = new TableItem(table, SWT.NONE);
						
						String texto = imovel.getEndereco();
						item.setText(texto);
					}
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}

	}

}
