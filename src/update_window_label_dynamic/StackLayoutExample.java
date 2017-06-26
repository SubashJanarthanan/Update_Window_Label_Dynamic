package update_window_label_dynamic;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * The Class StackLayoutExample.
 */
public class StackLayoutExample {

	/** The page num. */
	static int pageNum = -1;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		Rectangle clientArea = shell.getClientArea();
		shell.setBounds(clientArea.x + 10, clientArea.y + 10, 300, 200);

		// create the composite that the pages will share
		final Composite contentPanel = new Composite(shell, SWT.BORDER);
		contentPanel.setBounds(clientArea.x + 100, clientArea.y + 10, 400, 300);
		final StackLayout layout = new StackLayout();
		contentPanel.setLayout(layout);

		// create the first page's content
		final Composite page0 = new Composite(contentPanel, SWT.NONE);
		page0.setLayout(new GridLayout(2, false));

		ScrolledComposite scrolledComposite = new ScrolledComposite(page0, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setSize(50, 50);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Composite composite_1 = new Composite(scrolledComposite, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));

		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(page0, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);

		Composite composite_2 = new Composite(scrolledComposite_1, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		
		horizontal(composite_1, composite_2);

		scrolledComposite.setContent(composite_1);
		scrolledComposite.setMinSize(composite_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		scrolledComposite_1.setContent(composite_2);
		scrolledComposite_1.setMinSize(composite_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// create the second page's content
		final ScrolledComposite page1 = new ScrolledComposite(contentPanel, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		page1.setLayout(new GridLayout());
		page1.setExpandHorizontal(true);
		page1.setExpandVertical(true);

		Composite composite = new Composite(page1, SWT.NONE);
		composite.setLayout(new GridLayout());

		final Composite vUserComposite = new Composite(composite, SWT.BORDER);
		vUserComposite.setLayout(new GridLayout(1, false));

		final Composite vProjectCOmp = new Composite(composite, SWT.BORDER);
		vProjectCOmp.setLayout(new GridLayout(1, false));

		vertical(vUserComposite, vProjectCOmp);

		page1.setContent(composite);
		page1.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// create the button that will switch between the pages
		Button pageButton = new Button(shell, SWT.PUSH);
		pageButton.setText("Push");
		pageButton.setToolTipText("Push");
		pageButton.setBounds(clientArea.x + 10, clientArea.y + 10, 80, 25);
		layout.topControl = page0;
		pageButton.addListener(SWT.Selection, event -> {

			if (((Button) event.widget).getToolTipText().equals("Push")) {
				layout.topControl = page0;
				pageButton.setToolTipText("Pop");
				contentPanel.layout();
			} else {
				layout.topControl = page1;
				pageButton.setToolTipText("Push");
				contentPanel.layout();

			}

			/*
			 * pageNum = ++pageNum % 2; layout.topControl = pageNum == 0 ? page0
			 * : page1; contentPanel.layout ();
			 */
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * Horizontal.
	 *
	 * @param page0comp
	 *            the page 0 comp
	 * @param page0comp1
	 *            the page 0 comp 1
	 */
	private static void horizontal(Composite page0comp, Composite page0comp1) {
		for (int i = 0; i <= 2; i++) {
			Button page0ScrolledBurtton = new Button(page0comp, SWT.NONE);
			page0ScrolledBurtton.setText("Page 1 Button1");
			page0ScrolledBurtton.pack();	
			
			Button page0ScrolledBurtton1 = new Button(page0comp1, SWT.NONE);
			page0ScrolledBurtton1.setText("Page 0 Button1");
			page0ScrolledBurtton1.pack();
		}
	}

	/**
	 * Vertical.
	 *
	 * @param vUserComposite
	 *            the v user composite
	 * @param vProjectCOmp
	 *            the v project C omp
	 */
	private static void vertical(Composite vUserComposite, Composite vProjectCOmp) {

		for (int i = 0; i <= 15; i++) {

			Button button = new Button(vUserComposite, SWT.NONE);
			button.setText("Button on page 2");
			button.pack();

			Button button1 = new Button(vProjectCOmp, SWT.NONE);
			button1.setText("Button on page 2");
			button1.pack();
		}

	}
}
