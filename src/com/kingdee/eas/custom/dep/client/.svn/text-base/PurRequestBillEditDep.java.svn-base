package com.kingdee.eas.custom.dep.client;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.util.PropertyContainer;

public class PurRequestBillEditDep {
	public static void beforeLoadFieldsAddDataChangeListener(final UIParam param){
		DataChangeListener[] ls = param.getKDBizPromptBox("prmtProposer").getListeners(DataChangeListener.class);
		for(int i=0;i<ls.length;i++) {
			 param.getKDBizPromptBox("prmtProposer").removeDataChangeListener(ls[i]);
		}
	}
	
	public static void afterLoadFieldsAddDataChangeListener(final UIParam param){
		final KDBizPromptBox prmt = param.getKDBizPromptBox("prmtProposer");
		prmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				if(prmt.getValue()!=null){
					param.getKDTextField("txtpersonNumber").setStringValue(((PropertyContainer)prmt.getValue()).getString("cell"));
				}else{
					param.getKDTextField("txtpersonNumber").setStringValue(null);
				}
			}

		});
	}
}
