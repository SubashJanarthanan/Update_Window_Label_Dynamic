 
package update_window_label_dynamic;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.SideValue;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

/**
 * The Class DynamicToolItem.
 */
public class DynamicToolItem {
	
	
	/** The m trimmed window. */
	@Inject
	private MTrimmedWindow mTrimmedWindow;
	
	
	/**
	 * Inject of {@link EModelService}
	 */
	@Inject
	private EModelService modelService;
	
	/**
	 * Inject of {@link MApplication}
	 */
	@Inject
	private MApplication application;
	
	@AboutToShow
	public void execute(List<MToolBarElement> items) {

		for (int i = 0; i <= 2; i++) {
			MDirectToolItem dynamicItem = MMenuFactory.INSTANCE.createDirectToolItem();
			MHandledToolItem handledToolItem = MMenuFactory.INSTANCE.createHandledToolItem();
			handledToolItem.setIconURI("platform:/plugin/Update_Window_Label_Dynamic/icons/sample.png");
			dynamicItem.setIconURI("platform:/plugin/Update_Window_Label_Dynamic/icons/sample.png");
			items.add(dynamicItem);
			items.add(handledToolItem);
		}


			MTrimBar trim = modelService.getTrim(mTrimmedWindow, SideValue.TOP);
			List<MTrimElement> children = trim.getChildren();
			for (MTrimElement child : children) {
				if (child instanceof MToolBar) {
					MToolBar mToolBar = (MToolBar) child;
					List<MToolBarElement> toolItems = mToolBar.getChildren();
					final MHandledToolItem mItem = modelService.createModelElement(MHandledToolItem.class);
					mItem.setIconURI("platform:/plugin/com.magna.xmsystem.xmenu.ui/icons/save_edit.png");
					mItem.setTooltip("Lock Table Scrollbar");
					mItem.setEnabled(true);
					toolItems.add(mItem);
				}
			}


	}
		
}