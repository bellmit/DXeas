/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salepayment.IndexType;
import com.kingdee.eas.custom.salepayment.Quarter;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.DecimalFormatEx;
import com.kingdee.bos.ctrl.swing.NumberFormatterEx;

/**
 * output class name
 */
public class GrossProfitInfoEditUI extends AbstractGrossProfitInfoEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(GrossProfitInfoEditUI.class);
    
    /**
     * output class constructor
     */
    public GrossProfitInfoEditUI() throws Exception
    {
        super();
        DecimalFormatEx dfEx = new DecimalFormatEx("##");
        NumberFormatterEx formatter = new NumberFormatterEx();
        formatter.setFormat(dfEx);
        this.txtyear.setDisplayFormatter(formatter);
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salepayment.GrossProfitInfoFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo objectValue = new com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        return objectValue;
    }
    /**
     * 界面初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.indexType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
//                    indexType_actionPerformed(e);
                	
                	
                	
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
//		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
//		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
//		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		
	}
    
    /**
     * 添加校验  指标类型和 季度 选中值
     */
    public void beforeStoreFields(ActionEvent e) throws Exception{
    	super.beforeStoreFields(e);
    	// 
    	IndexType selType =  (IndexType) this.indexType.getSelectedItem();
    	if(selType != null){
    		Quarter selQuarter = (Quarter) this.quarter.getSelectedItem();
    		// 校验 季度 是否与 指标类型匹配
    		if(selQuarter != null){
    			if(IndexType.YEAR_VALUE.equals(selType.getValue()) && !Quarter.WHOLEYEAR_VALUE.equals(selQuarter.getValue())){
    				MsgBox.showInfo("指标类型为【年】时，季度只能选【整年】");
    				SysUtil.abort();
    			}else if(IndexType.QUARTER_VALUE.equals(selType.getValue()) && Quarter.WHOLEYEAR_VALUE.equals(selQuarter.getValue())){
    				MsgBox.showInfo("指标类型为【季度】时，季度不能选【整年】");
    				SysUtil.abort();
    			}
    		}
    	}
    	
    }
    /**
     * 指标类型变化时  季度 下拉列表候选项变化默认
     * @param e
     */
    public void indexType_actionPerformed(ActionEvent e){
    	
    }
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	// 校验录入的年是否合法
    	checkYear();
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// 校验录入的年 是否合法
		checkYear();
		super.actionSave_actionPerformed(e);
	}
	/**
	 * 校验年格式
	 */
	public void checkYear(){
		int year = this.txtyear.getIntegerValue();
		if(year < 2016 || year > 2030){
			MsgBox.showInfo("请输入2016 到 2030 及以后的合法年份");
			SysUtil.abort();
		}
	}

}