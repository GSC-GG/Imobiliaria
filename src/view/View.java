package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import model.*;

public class View extends MaeView {

	public static void main(String[] args) {
		try {
			View window = new View();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button butao = new Button(shell, SWT.NONE);
		butao.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				butao.setText("carregando");
				Imovel imovel = new Imovel(null, null, null, null, null, null);
				shell.close();
				ConsultarImovelView suaOutraView = new ConsultarImovelView();
				suaOutraView.open(imovel);
			}
		});;
		butao.setBounds(10, 50, 75, 25);
		butao.setText("Teste");
		
		//botão para a tela de inserções
		Button botaoInserir = new Button(shell, SWT.NONE);
		botaoInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				botaoInserir.setText("carregando");
				Imovel imovel = new Imovel(null, null, null, null, null, null);
				shell.close();
				ConsultarImovelViewTESTE suaOutraView = new ConsultarImovelViewTESTE();
				suaOutraView.open(imovel);
			}
		});;
		botaoInserir.setBounds(10, 10, 100, 25);
		botaoInserir.setText("Inserir");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(187, 167, 55, 15);
		lblNewLabel.setText("New Label");

	}
}
