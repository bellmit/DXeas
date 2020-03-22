package com.kingdee.eas.wlhlcomm.job;

import java.util.Map;

import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.util.AbortException;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;

public class JobUtil {
	/**
     * 执行后台事务
     */
	public static void ExeJob(String[] jobName){
		
		UIContext uiContext = new UIContext();
		IUIWindow window = null;
		try{
			String openType = UIFactoryName.MODEL;
			String oprtState = OprtState.ADDNEW;
			uiContext.put("jobNames", jobName);
			window = UIFactory.createUIFactory(openType).create("com.kingdee.eas.wlhlcomm.client.ExecJobUI", uiContext, null, oprtState);
			window.show();
			
			
		}catch(AbortException ae){
			MsgBox.showInfo(ae.getCause().getMessage());
			
		}catch(UIException uie){
			if(uie != null && uie.getCause() != null && !AbortException.class.equals(uie.getCause().getClass()) ){
				MsgBox.showInfo(uie.getCause().getMessage());
			}
		}
		
	}
}
