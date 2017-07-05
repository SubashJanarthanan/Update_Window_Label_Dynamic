package update_window_label_dynamic;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.e4.ui.workbench.UIEvents.ToolItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class dsfsdfsd {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			dsfsdfsd window = new dsfsdfsd();
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
		shell.setSize(569, 371);
		shell.setText("SWT Application");
		
		SashForm sashForm = new SashForm(shell, SWT.BORDER);
		sashForm.setBounds(26, 87, 495, 212);
		
		StackLayout stackLayout = new StackLayout();
		Composite composite = new Composite(sashForm, SWT.BORDER);
		composite.setLayout(stackLayout);
		
		Composite horizontal = new Composite(composite, SWT.BORDER);
		horizontal.setLayout(new GridLayout(3, false));
		new Label(horizontal, SWT.NONE);
		
		Label lblNewLabel = new Label(horizontal, SWT.NONE);
		lblNewLabel.setText("User Applications");
		
		Label lblNewLabel_1 = new Label(horizontal, SWT.NONE);
		lblNewLabel_1.setText("Project Applications");
		new Label(horizontal, SWT.NONE);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(horizontal, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(horizontal, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		
		ScrolledComposite vertical = new ScrolledComposite(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		vertical.setExpandHorizontal(true);
		vertical.setExpandVertical(true);
		
		Composite composite_2 = new Composite(vertical, SWT.BORDER);
		composite_2.setLayout(new GridLayout(8, false));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblUserApplicayions = new Label(composite_2, SWT.NONE);
		lblUserApplicayions.setText("User Applicayions");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Composite composite_3 = new Composite(composite_2, SWT.BORDER);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblProjectAoolications = new Label(composite_2, SWT.NONE);
		lblProjectAoolications.setText("Project Aoolications");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Composite composite_4 = new Composite(composite_2, SWT.BORDER);
		vertical.setContent(composite_2);
		vertical.setMinSize(composite_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		//sashForm.setWeights(new int[] {1});
		
		//StackLayout stackLayout = (StackLayout) composite.getLayout();
		
		Button btnClickHere = new Button(shell, SWT.NONE);
		
		btnClickHere.setBounds(403, 31, 75, 25);
		btnClickHere.setText("Click here");
		btnClickHere.setToolTipText("Horizontal");
		
		btnClickHere.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				
				if(((Button)event.widget).getToolTipText().equals("Horizontal")){
					
					stackLayout.topControl = horizontal;
					composite.layout();
					btnClickHere.setToolTipText("Vertical");
				} else{
					stackLayout.topControl = vertical;
					composite.layout();
					btnClickHere.setToolTipText("Horizontal");
				}
					
				
			}
		});

	}
}
