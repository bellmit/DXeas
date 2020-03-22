package com.kingdee.eas.basedata.master.cssp.client;

import java.awt.Component;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.KDLabelContainer;
import com.kingdee.bos.ctrl.swing.KDPanel;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;

public class CustomerSaleUICTEx extends CustomerSaleUI {

	public CustomerSaleUICTEx() throws Exception {
		super();
	}

	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		Component[] cps = this.getComponents();
		for(int i=0;i<cps.length;i++) {
			checkComponents(cps[i]);
		}
	}
	
	private  void checkComponents(Component cmp) {
		System.out.println(cmp.getClass().toString()+"&&&&&&&&"+cmp.getName());
		if(cmp instanceof KDPanel) {
			KDPanel panel=(KDPanel) cmp;
			for(int i=0;i<panel.getComponents().length;i++) {
					this.checkComponents(panel.getComponent(i));
			}
		}else if(cmp instanceof KDLabelContainer) {
			for(int i=0;i<((KDLabelContainer)cmp).getComponents().length;i++) {
				this.checkComponents(((KDLabelContainer)cmp).getComponent(i));
			}
		} else if(cmp instanceof KDBizPromptBox &&StringUtils.isNotBlank(cmp.getName())&& cmp.getName().equalsIgnoreCase("prmtDeliveryLine")) {
			((KDBizPromptBox)cmp).setQueryInfo("com.kingdee.eas.scm.im.dt.client.F7DeliveryLineQuery");
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("entry.seq","1",CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("entry.id",null,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("status","2",CompareType.EQUALS));
			filter.setMaskString("(#0 OR #1) AND #2");
			ev.setFilter(filter);
			((KDBizPromptBox)cmp).setEntityViewInfo(ev);
		}
	}
}
