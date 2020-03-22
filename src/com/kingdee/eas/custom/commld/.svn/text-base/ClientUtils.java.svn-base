package com.kingdee.eas.custom.commld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Icon;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.LanguageInfo;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.kscript.debug.ObjectValue;
import com.kingdee.bos.rpc.ObjectFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.WfException;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.HROrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.ProfitCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.QualityOrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.TransportOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.client.CoreUI;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.ExceptionHandler;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericException;
import com.kingdee.util.NumericExceptionSubItem;

public class ClientUtils {


	public static final Icon AuditIcon=EASResource.getIcon("imgTbtn_audit"); 
	public static final Icon UnAuditIcon=EASResource.getIcon("imgTbtn_unaudit");


	public static boolean checkBillInWorkflow(CoreUIObject ui, String id) {  
		ProcessInstInfo instInfo = null;  
		ProcessInstInfo procInsts[] = null;  
		try {  
			IEnactmentService service2 = EnactmentServiceFactory.createRemoteEnactService();  
			procInsts = service2.getProcessInstanceByHoldedObjectId(id);  
		} catch(BOSException e) {  
			ExceptionHandler.handle(e);  
			return false;  
		}  
		int i = 0;  
		for (int n = procInsts.length; i < n; i++)  
			if("open.running".equals(procInsts[i].getState()) || "open.not_running.suspended".equals(procInsts[i].getState()))  
				instInfo = procInsts[i];  
		if (instInfo != null) {  
			return true;  
		}  
		return false;  
	} 


	@SuppressWarnings("unchecked")
	public static void openUIFromParentUI(Map<String,Object> map,CoreUI obj,String UIName,String src,Object objParam) throws UIException{
		String destBillEditUIClassName =UIName;
		Map hashMap = new UIContext(obj);
		if(src!=null&&!src.equals(""))
			hashMap.put(src, objParam);
		else
			hashMap.put("src", map);

		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.NEWTAB).create(destBillEditUIClassName, hashMap, null,OprtState.ADDNEW);
		//开始展现UI
		uiWindow.show();
	}

	public static void openChildUIFromParentUI(String UIFactoryName, String destBillEditUIClassName,HashMap<Object,Object> hashMap,Object strNull,String OprtState){ 
		IUIWindow uiWindow = null ;
		try {
			uiWindow = UIFactory.createUIFactory(UIFactoryName).create(destBillEditUIClassName, hashMap, null,OprtState);
		} catch (UIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//开始展现UI
		uiWindow.show();
	}
	/**
	 * 判断当前单据ID对应的单据是否在流程中
	 * @param keyIDs
	 * @return
	 * @throws BOSException
	 */
	public static boolean checkBillInWorkFlow(String[] keyIDs)  throws BOSException {
		IEnactmentService service = EnactmentServiceFactory.createRemoteEnactService();

		ArrayList<String> idList = new ArrayList<String>();

		for (int i = 0; i < keyIDs.length; ++i) {
			ProcessInstInfo instInfo = null;
			ProcessInstInfo[] procInsts;
			try {
				procInsts = service.getProcessInstanceByHoldedObjectId(keyIDs[i]);
				int j = 0; for (int n = procInsts.length; j < n; ++j) {
					if ("open.running".equals(procInsts[j].getState())) {
						instInfo = procInsts[j];
					}
				}
				if (instInfo != null) {
					idList.add(keyIDs[i]);
					return true;
				}
			} catch (WfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	/**
	 * 获取根组织的名称
	 * @return
	 * @throws Exception
	 */
	public static String getRootOrgUnitName(Context ctx) throws Exception{
		IRowSet rs = null;
		if(ctx == null)
			rs = SQLExecutorFactory.getRemoteInstance("select fname_l2 fname from T_ORG_CtrlUnit where FLevel=1").executeSQL();
		else
			rs = DbUtil.executeQuery(ctx, "select fname_l2 fname from T_ORG_CtrlUnit where FLevel=1");
		if(rs.next()){
			return rs.getString("fname").replace("集团", "");
		}else
			return "";
	}

	/**
	 * 校验字段必录
	 * 未完
	 * @param list
	 * @throws EASBizException 
	 */
	public static void checkRequiredFields(ArrayList<Object> list,ArrayList<String> alias) throws EASBizException{
		Object obj;
		for(int i=0;i<list.size();i++){
			obj = list.get(i);
			if(obj instanceof KDTextField ){
				if(UIRuleUtil.isNull(((KDTextField)obj).getText()))
					throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{alias.get(i)});
			}else if(obj instanceof KDBizMultiLangBox ){
				if(UIRuleUtil.isNull(((KDBizMultiLangBox)obj).getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale()))))
					throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{alias.get(i)});
			}else if(obj instanceof KDBizPromptBox ){
				if(UIRuleUtil.isNull(((KDBizPromptBox)obj).getData()))
					throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{alias.get(i)});
			}else if(obj instanceof KDBizPromptBox ){
				if(UIRuleUtil.isNull(((KDBizPromptBox)obj).getData()))
					throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{alias.get(i)});
			}else if(obj instanceof KDDatePicker ){
				if(UIRuleUtil.isNull(((KDDatePicker)obj).getValue()))
					throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{alias.get(i)});
			}else if(obj instanceof KDFormattedTextField ){
				if(UIRuleUtil.isNull(((KDFormattedTextField)obj).getText()))
					throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{alias.get(i)});
			}			
		}
	}










	/**
	 * 
	 * @return
	 */
	public static  SysContext getCurrentParam(){
		return SysContext.getSysContext();
	}

	public static String getClientIP(){
		return getCurrentParam().getClientIP();
	}
	public static String getClientName(){
		return getCurrentParam().getClientName();
	}
	public static  AdminOrgUnitInfo getCurrentAdminUnit(){
		return getCurrentParam().getCurrentAdminUnit();
	}
	public static CostCenterOrgUnitInfo getCurrentCostUnit(){
		return getCurrentParam().getCurrentCostUnit();
	}
	public static CtrlUnitInfo getCurrentCtrlUnit(){
		return getCurrentParam().getCurrentCtrlUnit();
	}
	public static CompanyOrgUnitInfo getCurrentFIUnit(){
		return getCurrentParam().getCurrentFIUnit();
	}
	public static HROrgUnitInfo getCurrentHRUnit(){
		return getCurrentParam().getCurrentHRUnit();
	}
	public static CompanyOrgUnitInfo getCurrentOrgUnit(){
		return (CompanyOrgUnitInfo) getCurrentParam().getCurrentOrgUnit();
	}
	public static  OrgUnitInfo getCurrentOrgUnit(OrgType orgType ){
		return getCurrentParam().getCurrentOrgUnit(orgType);
	}
	public static ProfitCenterOrgUnitInfo getCurrentProfitUnit(){
		return getCurrentParam().getCurrentProfitUnit();
	}
	public static PurchaseOrgUnitInfo getCurrentPurchaseUnit(){
		return getCurrentParam().getCurrentPurchaseUnit();
	}
	public static QualityOrgUnitInfo getCurrentQualityUnit(){
		return getCurrentParam().getCurrentQualityUnit();
	}
	public static SaleOrgUnitInfo getCurrentSaleUnit(){
		return getCurrentParam().getCurrentSaleUnit();
	}
	public static StorageOrgUnitInfo getCurrentStorageUnit(){
		return getCurrentParam().getCurrentStorageUnit();
	}
	public static TransportOrgUnitInfo getCurrentTransportUnit(){
		return getCurrentParam().getCurrentTransportUnit();
	}
	public static UserInfo getCurrentUserInfo(){
		return getCurrentParam().getCurrentUserInfo();
	}
	public static String getDcAlias(){
		return getCurrentParam().getDcAlias();
	}
	public static String getDcName(){
		return getCurrentParam().getDcName();
	}
	public static String getDCNumber(){
		return getCurrentParam().getDCNumber();
	}
	public static String getSessionID(){
		return getCurrentParam().getSessionID();
	}
	public static String getSlnName(){
		return getCurrentParam().getSlnName();
	}
	public static String getUserName(){
		return getCurrentParam().getUserName();
	}
	public static Locale getLocale(){
		return getCurrentParam().getLocale();
	}
	public static Locale getOriginLocale(){
		return getCurrentParam().getOriginLocale();
	}


}
