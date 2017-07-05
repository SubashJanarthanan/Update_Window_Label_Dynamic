package update_window_label_dynamic;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridLayout;

public class ExampleStack {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExampleStack window = new ExampleStack();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(651, 381);
		shell.setText("SWT Application");
		
		Button btnClickHere = new Button(shell, SWT.NONE);
		btnClickHere.setBounds(520, 10, 75, 25);
		btnClickHere.setText("CLick Here");
		
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(10, 86, 615, 246);
		composite.setLayout(new StackLayout());

	}
}
