package view;

import org.eclipse.swt.widgets.Shell;

import banco.DataAluguel;

public class LocView extends MaeView {

	DataAluguel dataAluguel = new DataAluguel();

	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Imobiliária - Locatário");

	}

}
