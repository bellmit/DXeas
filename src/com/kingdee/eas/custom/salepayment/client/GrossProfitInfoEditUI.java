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
     * �����ʼ��
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ����ȫ��
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
     * ���У��  ָ�����ͺ� ���� ѡ��ֵ
     */
    public void beforeStoreFields(ActionEvent e) throws Exception{
    	super.beforeStoreFields(e);
    	// 
    	IndexType selType =  (IndexType) this.indexType.getSelectedItem();
    	if(selType != null){
    		Quarter selQuarter = (Quarter) this.quarter.getSelectedItem();
    		// У�� ���� �Ƿ��� ָ������ƥ��
    		if(selQuarter != null){
    			if(IndexType.YEAR_VALUE.equals(selType.getValue()) && !Quarter.WHOLEYEAR_VALUE.equals(selQuarter.getValue())){
    				MsgBox.showInfo("ָ������Ϊ���꡿ʱ������ֻ��ѡ�����꡿");
    				SysUtil.abort();
    			}else if(IndexType.QUARTER_VALUE.equals(selType.getValue()) && Quarter.WHOLEYEAR_VALUE.equals(selQuarter.getValue())){
    				MsgBox.showInfo("ָ������Ϊ�����ȡ�ʱ�����Ȳ���ѡ�����꡿");
    				SysUtil.abort();
    			}
    		}
    	}
    	
    }
    /**
     * ָ�����ͱ仯ʱ  ���� �����б��ѡ��仯Ĭ��
     * @param e
     */
    public void indexType_actionPerformed(ActionEvent e){
    	
    }
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	// У��¼������Ƿ�Ϸ�
    	checkYear();
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// У��¼����� �Ƿ�Ϸ�
		checkYear();
		super.actionSave_actionPerformed(e);
	}
	/**
	 * У�����ʽ
	 */
	public void checkYear(){
		int year = this.txtyear.getIntegerValue();
		if(year < 2016 || year > 2030){
			MsgBox.showInfo("������2016 �� 2030 ���Ժ�ĺϷ����");
			SysUtil.abort();
		}
	}

}