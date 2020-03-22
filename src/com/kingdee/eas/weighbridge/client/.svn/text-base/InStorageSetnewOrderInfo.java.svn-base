/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.InStorageBillEntryFactory;
import com.kingdee.eas.weighbridge.InStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;

/**
 * output class name
 */
public class InStorageSetnewOrderInfo extends AbstractInStorageSetnewOrderInfo
{
    private static final Logger logger = CoreUIObject.getLogger(InStorageSetnewOrderInfo.class);
    // 修改后的订单信息
    private OrderWeightInfo newOrderWeightInfo;
    // 需要修改的过磅单
    private InStorageBillInfo editData;
    /**
     * output class constructor
     */
    public InStorageSetnewOrderInfo() throws Exception
    {
        super();
    }
    /**
     * 初始化界面内  需要更新内容设置 
     * 如果 未传入相关信息则 自动关闭
     */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置控件不可编辑
		this.tfNewOrderNumber.setEnabled(false);
		this.tfNewOrderNumber.setEditable(false);
		this.tfOldOrderNumber.setEnabled(false);
		this.tfOldOrderNumber.setEditable(false);
		this.tfOldGrossWeight.setEnabled(false);
		this.tfOldGrossWeight.setEditable(false);
		this.tfOldTareWeight.setEnabled(false);
		this.tfOldTareWeight.setEditable(false);
		// 订单
		newOrderWeightInfo = (OrderWeightInfo) this.getUIContext().get("orderWeightInfo");
		editData = (InStorageBillInfo) this.getUIContext().get("instorageBill");
		
		
		
		if(newOrderWeightInfo == null || editData == null){
			MsgBox.showInfo("未获得更新后订单信息与需更新过磅单信息，不能完成更新操作");
			this.uiWindow.close();
			SysUtil.abort();
		}
		// 加载 数据
		loadOldData();
	}
	/**
	 * 
	 * @param newOrderWeightInfo
	 * @param editData
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void loadOldData() throws EASBizException, BOSException{
		this.tfOldOrderNumber.setText( editData.getPurOrderNumber());
		this.tfNewOrderNumber.setText(newOrderWeightInfo.getOrderNumber());
		
		if(editData.getEntrys() != null && editData.getEntrys().size() == 1 ){
			// 
			InStorageBillEntryInfo entryInfo = editData.getEntrys().get(0);
			if(entryInfo.getMaterial() == null){
				entryInfo = InStorageBillEntryFactory.getRemoteInstance().getInStorageBillEntryInfo(new ObjectUuidPK(entryInfo.getId()));
				
			}
			// 毛重
			if(entryInfo.getGross() == null){
				this.tfNewGrossWeight.setEditable(false);
				this.tfNewGrossWeight.setEnabled(false);
			}else{
				this.tfOldGrossWeight.setValue(entryInfo.getGross());
				this.tfNewGrossWeight.setEditable(true);
				this.tfNewGrossWeight.setEnabled(true);
			}
			
			// 皮重
			if(entryInfo.getTare() == null){
				this.tfNewTareWeight.setEditable(false);
				this.tfNewTareWeight.setEnabled(false);
			}else{
				this.tfOldTareWeight.setValue(entryInfo.getTare());
				this.tfNewTareWeight.setEditable(true);
				this.tfNewTareWeight.setEnabled(true);
			}
			
			
		}else{
			MsgBox.showInfo("需修改的过磅单没有明细行或者明细行多于一行，不能修改，请联系管理员处理");
			this.uiWindow.close();
			SysUtil.abort();
		}
		
//		BigDecimal oldGrossWeight = 
		
//		this.tfOldGrossWeight.setValue(arg0)
	}
	/**
	 * 不保存数据  直接关闭
	 */
	@Override
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		
		if(MsgBox.showConfirm2("取消后将不做任何更新，确定取消？") == MsgBox.OK){
			this.uiWindow.close();
		}
	}

	/**
	 * 提交修改后的数据，更新订单、过磅单  并生成修改日志
	 */
	@Override
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		String newOrderNumber = StringUtils.trim(this.tfNewOrderNumber.getText());
		BigDecimal newGross = this.tfNewGrossWeight.getBigDecimalValue();
		BigDecimal newTare = this.tfNewTareWeight.getBigDecimalValue();
		// 至少有一项改动 才允许 提交
		if(StringUtils.isNotBlank(newOrderNumber) || newGross != null ||newTare != null){
			this.getUIContext().put("newGross", newGross);
			this.getUIContext().put("newTare", newTare);
			this.getUIContext().put("newOrderNumber", newOrderNumber);
			
			this.uiWindow.close();
			
		}else{
			MsgBox.showInfo("没有任何改动");
		}
	}


}