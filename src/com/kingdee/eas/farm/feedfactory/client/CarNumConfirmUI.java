/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class CarNumConfirmUI extends AbstractCarNumConfirmUI
{
    private static final Logger logger = CoreUIObject.getLogger(CarNumConfirmUI.class);
    
    // 对应销售订单
    private SaleOrderInfo editData;
    // 订单车牌号
    private String oldCarNumber;
    
    
    
    /**
     * output class constructor
     */
    public CarNumConfirmUI() throws Exception
    {
        super();
    }


    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		
		if(this.getUIContext().get("editData") != null){
			editData = (SaleOrderInfo) this.getUIContext().get("editData");
			
			oldCarNumber = editData.getString("carNumber");
			this.tfCarnumber.setText(oldCarNumber);
			
			// 日期
			this.dpDate.setValue(new Date());
			
			tfCarnumber_actionPerformed(null);
//			this.lbDate.setForeground(Color.BLUE);
		}else{
			throw new BOSException("业务单据尚未传入");
		}
	}

    @Override
	protected void dpDate_dataChanged(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.dpDate_dataChanged(e);
		
		tfCarnumber_actionPerformed(null);
	}
	/**
     * 车牌号修改 重新取数
     */
    protected void tfCarnumber_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        String currCarNum = this.tfCarnumber.getText();
        Date weiDate = this.dpDate.getSqlDate();
        if(StringUtils.isNotBlank(currCarNum)){
        	if(weiDate != null){
	        	// 获取 当天已过皮重出库过磅单
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        	String dateStr = sdf.format(weiDate);
	        	StringBuilder sb = new StringBuilder();
	        	sb.append("/*dialect*/select cftareweight from CT_WHB_OutStorageBill where to_char(fbizdate,'yyyy-MM-dd') = '");
	        	sb.append(dateStr);
	        	sb.append("' and cfcarnum='");
	        	sb.append(StringUtils.trim(currCarNum));
	        	sb.append("' and cfbillstatus='1' ");
	        	
	        	ISQLExecutor sqlexe = SQLExecutorFactory.getRemoteInstance(sb.toString());
	        	IRowSet rs = sqlexe.executeSQL();
	        	if(rs.next()){
	        		BigDecimal weight = rs.getBigDecimal("cftareweight");
	        		this.lbWeight.setText(weight.toPlainString());
	        		this.lbWeight.setForeground(new Color(0,187,0));
	        	}else{
	        		this.lbWeight.setText("未查到车辆皮重");
	        		this.lbWeight.setForeground(Color.RED);
	        	}
        	}else{
        		this.lbWeight.setText("过皮日期为空");
            	this.lbWeight.setForeground(Color.RED);
        	}
        }else{
        	this.lbWeight.setText("车牌号为空");
        	this.lbWeight.setForeground(Color.RED);
        }
    }
    /**
     * 确认后，保存车牌号   打印
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        this.getUIContext().put("isAbort", Boolean.FALSE);
        this.uiWindow.close();
    }

    /**
     * 关闭 界面  终止打印
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	this.getUIContext().put("isAbort", Boolean.TRUE);
        this.uiWindow.close();
    }


	
}