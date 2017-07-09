package update_window_label_dynamic;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.services.internal.events.EventBroker;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.nebula.widgets.tablecombo.TableCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * The Class MainWindowPart.
 * 
 * @author Subash
 * 
 */
public class MainWindowPart {
	
	/** The table combo. */
	private TableCombo tableCombo;
	
	@Inject
	private EventBroker eventBroker;
	
	/** The label. */
	private Label label;
	
	/** The listener results. */
	private static Text txtListenerGroup;
	
	/** The listener group. */
	private static Group grpListener;
	
	/** The application. */
	@Inject
	private MApplication application;
	
	/** The model service. */
	@Inject
	private EModelService modelService;
	
	/**
	 * Creates the UI.
	 *
	 * @param parent the parent
	 */
	@PostConstruct
	public void createUI(Composite parent){
		
		List<MMenuElement> items = null;
		
		final Composite childComposite = new Composite(parent, SWT.NONE);
		childComposite.setLayout(new GridLayout(2 , false));
		
		label = new Label(childComposite, SWT.NONE | SWT.BOLD);
		label.setText("Nebula Table Combo ");
		
		tableCombo = new TableCombo(childComposite, SWT.BORDER | SWT.READ_ONLY);
		tableCombo.setLayoutData(new GridData(125, SWT.DEFAULT));
		loadSampleData(tableCombo.getTable());
		
		tableCombo.addSelectionListener(new SelectedItemAdapter(tableCombo, "sample"));
		tableCombo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = tableCombo.getSelectionIndex();
				TableItem item = tableCombo.getTable().getItem(selectionIndex);
				String selectedText = item.getText();
				
				//Update window label dynamic
				MWindow mWindow = (MWindow) modelService.find("org.eclipse.e4.window.main", application);
				mWindow.setLabel(selectedText);
				
				MMenu mainMenu = mWindow.getMainMenu();
				List<MMenuElement> children = mainMenu.getChildren();
				MMenuElement mMenuElement = mainMenu.getChildren().get(1);
				
				MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
						.createDirectMenuItem();
				
				dynamicItem.setLabel("New Dynamic Menu Item");
				mMenuElement.getParent().getChildren().add(dynamicItem);
				
				for(int i = 0; i<=2;i++ ){
					MDirectMenuItem menuItem1 = modelService.createModelElement(MDirectMenuItem.class); 
					menuItem1.setLabel("Hello");
					//mainMenu.getChildren().add(menuItem1);
					children.add(menuItem1);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		grpListener = new Group(childComposite, SWT.NONE);
		grpListener.setLayout(new GridLayout(1, false));
		grpListener.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		grpListener.setText("Listener Results");
		
		txtListenerGroup = new Text(grpListener, SWT.BORDER | SWT.MULTI | SWT.COLOR_CYAN);
		GridData gridData = new GridData(SWT.FILL, SWT.DEFAULT, true, false);
		gridData.heightHint = 40;
		gridData.widthHint = 60;
		txtListenerGroup.setLayoutData(gridData);
		txtListenerGroup.setEditable(false);
		

	}
	
	@AboutToShow
	public void aboutToShow(List<MMenuElement> items) {
		for (int i = 0; i < 3; i++) {
			MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
					.createDirectMenuItem();
			dynamicItem.setLabel("Dynamic Menu Item (" + new Date() + ")");
			System.out.println("Entered");
			items.add(dynamicItem);
		}
	}

	/**
	 * Load single dataset.
	 *
	 * @param table the table
	 * @return the list
	 */
	private static List<TableItem> loadSampleData(Table table) {
		
		List<TableItem> sampleReturnList = new ArrayList<>();
		
		TableItem apple = new TableItem(table, SWT.NONE);
		TableItem orange = new TableItem(table, SWT.NONE);
		TableItem pinapple = new TableItem(table, SWT.NONE);
		TableItem banana = new TableItem(table, SWT.NONE);
		TableItem dates = new TableItem(table, SWT.NONE);
		
		apple.setText("Apple");
		orange.setText("Orange");
		pinapple.setText("Pinapple");
		banana.setText("Banana");
		dates.setText("Dates");
		
		sampleReturnList.add(apple);
		sampleReturnList.add(orange);
		sampleReturnList.add(pinapple);
		sampleReturnList.add(banana);
		sampleReturnList.add(dates);

		return sampleReturnList;
	}
	
	/**
	 * The Class ItemSelected.
	 */
	private static class SelectedItemAdapter extends SelectionAdapter {
		
		/** The table combo selected. */
		private TableCombo tableComboSelected;
		
		/** The sample text. */
		private String sampleText;
		
		/**
		 * Instantiates a new item selected.
		 *
		 * @param tableComboSelected the table combo selected
		 * @param sampleText the sample text
		 */
		public SelectedItemAdapter(TableCombo tableComboSelected, String sampleText) {
			this.tableComboSelected = tableComboSelected;
			this.sampleText = sampleText;
		}

		public void widgetSelected(SelectionEvent selectionEvent) {
			grpListener.setText("Listener Results - (" + sampleText + ")");
			txtListenerGroup.setText(tableComboSelected.getText() == null ? "null" : tableComboSelected.getText());
		}
	}
}
