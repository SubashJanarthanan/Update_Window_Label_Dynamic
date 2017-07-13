 
package update_window_label_dynamic;

import java.util.Date;
import java.util.List;

import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

import update_window_label_dynamic.handlers.ExitHandler;

public class DynamicMenu {
	
	
	
	@AboutToShow
	public void aboutToShow(List<MMenuElement> items) {
		for(int i=0;i<=2;i++){
			
			MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
					.createDirectMenuItem();
			
			dynamicItem.setLabel("Dynamic Menu Item (" + new Date() + ")");
			dynamicItem.setIconURI("platform:/plugin/Update_Window_Label_Dynamic/icons/sample.png");
			dynamicItem.setContributionURI("bundleclass://Update_Window_Label_Dynamic/" + ExitHandler.class.getName());
			
			items.add(dynamicItem);
		}
	}
	
	
	@AboutToHide
	public void aboutToHide(List<MMenuElement> items) {
		
	}
		
}