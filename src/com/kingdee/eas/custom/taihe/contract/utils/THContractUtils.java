package com.kingdee.eas.custom.taihe.contract.utils;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;

public class THContractUtils {

	
	public static void setFilter(final KDBizPromptBox prmtbailPolicy,final String companyID) {
		SelectorListener[] ls = prmtbailPolicy.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtbailPolicy.removeSelectorListener(ls[i]);
		}
		
		 prmtbailPolicy.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.AssureAmtPolicyQuery");		
	        prmtbailPolicy.setVisible(true);		
	        prmtbailPolicy.setEditable(true);		
	        prmtbailPolicy.setDisplayFormat("$name$");		
	        prmtbailPolicy.setEditFormat("$number$");		
	        prmtbailPolicy.setCommitFormat("$number$");		
	        prmtbailPolicy.setRequired(false);
	        		prmtbailPolicy.addSelectorListener(new SelectorListener() {
				com.kingdee.eas.custom.taihe.contract.client.AssureAmtPolicyListUI prmtbailPolicy_F7ListUI = null;
				public void willShow(SelectorEvent e) {
					if (prmtbailPolicy_F7ListUI == null) {
						try {
							prmtbailPolicy_F7ListUI = new com.kingdee.eas.custom.taihe.contract.client.AssureAmtPolicyListUI(){
								protected FilterInfo getDefaultFilterForQuery() {
									FilterInfo filter=new FilterInfo();
									if(StringUtils.isNotEmpty(companyID)) {
										filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
									}
									filter.getFilterItems().add(new FilterItemInfo("billStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
									return filter;
								}
							};
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						HashMap ctx = new HashMap();
						ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbailPolicy_F7ListUI));
						prmtbailPolicy_F7ListUI.setF7Use(true,ctx);
						prmtbailPolicy.setSelector(prmtbailPolicy_F7ListUI);
					}
				}
			});
	}
}
