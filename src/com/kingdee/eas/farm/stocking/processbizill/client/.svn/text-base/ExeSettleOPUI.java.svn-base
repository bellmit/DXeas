/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Component;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.IParser;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox.DefaultParser;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.framework.IBaseDataParser;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.processbizill.SettleBreedStageEnum;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class ExeSettleOPUI extends AbstractExeSettleOPUI
{
    private static final Logger logger = CoreUIObject.getLogger(ExeSettleOPUI.class);
	private JSONObject jsonObject=new JSONObject();
	FilterInfo mainFilter;
	com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
    /**
     * output class constructor
     */
    public ExeSettleOPUI() throws Exception
    {
        super();
        this.setUITitle("养殖结算");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnExe_actionPerformed method
     */
    protected void btnExe_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	if(MsgBox.showConfirm2("执行结算将删除本期阶段已经结算的数据，是否继续执行？")==MsgBox.OK){
    		
    		if(prmtCompany.getValue()==null) {
    			MsgBox.showWarning("财务组织不能为空！");
    			return;
    		}
    		if(prmtPeriod.getValue()==null) {
    			MsgBox.showWarning("期间不能为空！");
    			return;
    		}
    		if(cmbSettleType.getSelectedItem()==null) {
    			MsgBox.showWarning("结算类型不能为空！");
    			return;
    		}
	    	jsonObject.put("companyID", ((IObjectValue) prmtCompany.getValue()).getString("id"));
	    	jsonObject.put("periodID", ((IObjectValue) prmtPeriod.getValue()).getString("id"));
	    	jsonObject.put("settleType", ((StockingSettlementTypeEnum) cmbSettleType.getSelectedItem()).getValue());
	    	jsonObject.put("settleBreedStage",((SettleBreedStageEnum) cmbBreedStage.getSelectedItem()).getValue());
	    	
    		LongTimeDialog dialog = new LongTimeDialog((UIModelDialog) SwingUtilities.getWindowAncestor(this)); 
    				dialog.setLongTimeTask(new ILongTimeTask() {
    				public Object exec() throws Exception { 
    					Object obj = "12345"; 
	    				// 查询的数据赋值与表格 
	    				StatementsBillFactory.getRemoteInstance().exeAllCal(jsonObject.toString());
	    				return obj; 
    				} 

    				public void afterExec(Object result) throws Exception {
    					MsgBox.showInfo("结算执行完成！"); 
    				} 
			}); 
			Component[] cps=dialog.getContentPane().getComponents(); 
			for(Component cp:cps){ 
				if(cp instanceof JLabel){ 
					((JLabel) cp).setText("结算执行中......."); 
				} 
			} 
			dialog.show(); 
    		
//	        StatementsBillFactory.getRemoteInstance().allExeCal(jsonObject);
//	        MsgBox.showInfo("结算执行完成！");
    	}
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnCancel_actionPerformed(e);
        this.destroyWindow();
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtCompany.setSelector(cf7);
		this.prmtCompany.setRequired(true);
		this.prmtPeriod.setRequired(true);
		this.cmbSettleType.setRequired(true);
		
		this.cmbSettleType.setSelectedIndex(1);
		
		this.prmtCompany.setDisplayFormat("$name$");
		this.prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		
		
		/*DayRateBaseSettingInfo bdsys = DayrateUtils.getBaseSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(bdsys==null) {
			MsgBox.showWarning("成本设置尚未设置！");
			SysUtil.abort();
		}
		if(bdsys.getCurrentPeriod()!=null) {
			prmtPeriod.setValue(PeriodUtils.getNextPeriodInfo(bdsys.getCurrentPeriod()));
		}*/
		
		
	/*	//*****************
		mainFilter=new FilterInfo();
		mainFilter.getFilterItems().add(new FilterItemInfo("name","%V1%",CompareType.LIKE));
		
		SelectorListener[] ls = prmtPeriod.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtPeriod.removeSelectorListener(ls[i]);
		}
		prmtPeriod.setSelector(null);
		prmtPeriod.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
		prmtPeriod.setEditable(true);		
		prmtPeriod.setDisplayFormat("$name$");		
		prmtPeriod.setEditFormat("$name$");		
		prmtPeriod.setCommitFormat("$number$;$name$");	
		prmtPeriod.setRequired(true);

		
		EntityViewInfo ev=new EntityViewInfo();
		ev.setFilter(mainFilter);
		prmtPeriod.setQuickQureyEntityViewInfo(ev);
		prmtPeriod.setQuickQuery(true);
		

		StockingBaseDataParser sd = new StockingBaseDataParser(prmtPeriod);
		sd.setQuickFilter(mainFilter);
		sd.setQuickQureyEntityViewInfo(ev);
		this.prmtPeriod.setCommitParser(sd);
		
		this.prmtPeriod.setEntityViewInfo(ev);
		
		setSelector();
		setSelectorLisenter();*/
	}
	
	private void setSelectorLisenter(){
		for(int i=0;i<prmtPeriod.getSelectorListeners().length;i++) {
			this.prmtPeriod.removeSelectorListener(prmtPeriod.getSelectorListeners()[i]);
		}
		
		this.prmtPeriod.addSelectorListener(new SelectorListener(){
			public void willShow(SelectorEvent paramSelectorEvent) {
			try {
				setSelector();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
	}
	
	private void setSelector() {
		try {
			prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI(){
				@Override
				protected FilterInfo getDefaultFilterForQuery() {
	
					return  (FilterInfo) mainFilter.clone();
				}
				@Override
				protected boolean isIgnoreCUFilter() {
						return true;
				}
				@Override
				protected boolean isIgnoreTreeCUFilter() {
						return true;
				}
				protected String getF7ListClassName() {
					return "com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI";
				}
			};
			HashMap ctx = new HashMap();
			ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
			prmtfarmer_F7ListUI.setF7Use(true,ctx);
			prmtPeriod.setSelector(prmtfarmer_F7ListUI);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * farm parse
	 * @author QYDEP2
	 *
	 */
	public class  StockingBaseDataParser extends DefaultParser implements IBaseDataParser,IParser {
		public StockingBaseDataParser(KDBizPromptBox prmt) {
			super(prmt);
			// TODO Auto-generated constructor stub
		}
		EntityViewInfo ev;
		private FilterInfo filter;
		private boolean isEnter;
		public FilterInfo getQuickFilter() {
			return filter;
		}

		public boolean isCommitByEnter() {
			return isEnter;
		}

		public void setCommitByEnter(boolean isEnter) {
			this.isEnter=isEnter;
		}

		public void setQuickFilter(FilterInfo filter) {
			this.filter=filter;
		}

		public void applyPattern(String paramString) {
			// TODO Auto-generated method stub

		}

		public IRowSet getRowSetForPopupF8(String paramString) {
			// TODO Auto-generated method stub
			return null;
		}

		public void setQuickQureyEntityViewInfo(EntityViewInfo paramEntityViewInfo) {
			// TODO Auto-generated method stub
			ev=paramEntityViewInfo;
		}

		public Object stringToValue(String paramString) {
			// TODO Auto-generated method stub
//			Object obj=null;
//			try {
//				EntityViewInfo ev=new EntityViewInfo();
//				ev.setFilter(filter);
//				obj=PeriodFactory.getRemoteInstance().getCollection(ev).get(0);
//			}catch(Exception err) {
//				err.printStackTrace();
//			}
			mainFilter=new FilterInfo();
			mainFilter.getFilterItems().add(new FilterItemInfo("name","%"+paramString+"%",CompareType.LIKE));
		   Object obj=null;
		/*   IRowSet equalRowSet = this.prompt.getQueryAgent().executeQuery(0, 2);
		
		   obj = buildReturnValue(this.prompt.getQueryAgent(), equalRowSet, 1)[0];*/
		   
//		   this.prompt.show(true);
		   this.prompt.getSelector().show();
//		   this.prompt.setEntityViewInfo(ev);
//		   this.prompt.getQueryAgent().setEntityViewInfo(ev);  
			return obj;
		}

	}

}