package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

//essa é a tela para selecionar qual classe vai sofrer uma inserção
public class InserirView {
	
	protected Shell shell;


	//Open the window.
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

	//Create contents of the window.
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}

}
