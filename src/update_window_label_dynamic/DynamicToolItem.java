 
package update_window_label_dynamic;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;

public class DynamicToolItem {
	@AboutToShow
	public void execute(List<MToolBarElement> items) {
		
		for(int i=0;i<=2;i++){
			MDirectToolItem dynamicItem = MMenuFactory.INSTANCE.createDirectToolItem();
			MHandledToolItem handledToolItem = MMenuFactory.INSTANCE.createHandledToolItem();
			handledToolItem.setIconURI("platform:/plugin/Update_Window_Label_Dynamic/icons/sample.png");
			dynamicItem.setIconURI("platform:/plugin/Update_Window_Label_Dynamic/icons/sample.png");
			items.add(dynamicItem);
			items.add(handledToolItem);
		}
		
	}
		
}