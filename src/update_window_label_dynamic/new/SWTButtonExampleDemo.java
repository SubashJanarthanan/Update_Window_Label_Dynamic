package com.magna.xmsystem.xmenu.ui.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * The Class SWTButtonExampleDemo.
 */
public class SWTButtonExampleDemo { 
	
	public static void main(String[] args) {
		Display display = new Display();
		Image image = new Image(display, "./icons/sample.png");
		final Color customSelectionColor = new Color(display, 0, 230, 255);
		final Color customMouseHoverColor = new Color(display, 255, 137, 0);

		Shell shell = new Shell(display);
		shell.setSize(300, 200);
		shell.setText("Button Example");
		shell.setLayout(new GridLayout());
		
		CustomButton cbButton = new CustomButton(shell, SWT.NONE);
		CustomButton cbButton2 = new CustomButton(shell, SWT.NONE);
		
		GridData btnlayoutDataForApp = new GridData(SWT.FILL, SWT.FILL, true, false);
		cbButton.setLayoutData(btnlayoutDataForApp);
		
		cbButton.setImage(image);
		cbButton.setText("Sample Button 1");
		cbButton.setArrow(true);
		
		// Set menu
		Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem helloMenuItem = new MenuItem(menu, SWT.PUSH);
		helloMenuItem.setText("Menu Sub Item 1");
		MenuItem helloMenuItem2 = new MenuItem(menu, SWT.PUSH);
		helloMenuItem2.setText("Menu Sub Item 2");
		cbButton.setMenu(menu);

		cbButton.setSelectionBGColor(customSelectionColor);
		cbButton.setMouseEnterBGColor(customMouseHoverColor);

		cbButton2.setArrow(true);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}