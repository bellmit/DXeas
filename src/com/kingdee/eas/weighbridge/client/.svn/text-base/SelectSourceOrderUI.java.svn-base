/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.IweightbridgeFacade;
import com.kingdee.eas.weighbridge.weightbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import com.kingdee.eas.wlhlcomm.DateCommon;

/**
 * output class name
 */
public class SelectSourceOrderUI extends AbstractSelectSourceOrderUI
{
    private static final Logger logger = CoreUIObject.getLogger(SelectSourceOrderUI.class);
    // 候选订单
    Map<String,OrderWeightInfo> orderMaps ;
    public static String PUR_ORDER = "purOrder";
    public static String SALE_ORDER = "saleOrder";
    public static String recCK_bill = "recCKBill";
    public static String QC_bill = "QCBill";
    // 订单类别
    String orderType = "";
    
    Date currDate = null;
    /**
     * output class constructor
     */
    public SelectSourceOrderUI() throws Exception
    {
        super();
    }

    /**
     * 界面初始化  加载 列表内容 和 查询条件
     */
    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// 
		this.kDTable1.checkParsed();
//		this.kDTable1.setEditable(false);
		this.kDTable1.getStyleAttributes().setLocked(true);
//		this.kDTable1.getEditManager().
		// 单行选中
		this.kDTable1.getSelectManager().setSelectMode(2);
		// 释放entrer相应
//		KDTableHelper.releaseEnter(kDTable1);
		
		currDate = (Date) this.getUIContext().get("currDate");
		orderMaps = (Map<String, OrderWeightInfo>) this.getUIContext().get("orderMaps");
		
		String searchOrderNum = (String) this.getUIContext().get("searchOrderNum");
		orderType = (String) this.getUIContext().get("orderType");
		
		this.kDTable1.getColumn("isSelected").getStyleAttributes().setHided(true);
		
		if(orderType!=null&&orderType.equals(SALE_ORDER)) {
			this.kDTable1.getColumn("bagQty").getStyleAttributes().setHided(false);
			this.kDTable1.getColumn("isSelected").getStyleAttributes().setHided(false);
		}
		
		// 设置默认查询条件
		this.tfOrderNumber.setText(searchOrderNum);
		this.pkBeginDate.setValue(currDate);
		this.pkEndDate.setValue(currDate);
		this.tfCarNumber.setText("");
		
		KDCheckBox cmb=new KDCheckBox();
		cmb.setName("isSelected");
		cmb.setSelected(false);
		KDTDefaultCellEditor editor=new KDTDefaultCellEditor(cmb);
		this.kDTable1.getColumn("isSelected").setEditor(editor);
		this.kDTable1.getColumn("isSelected").getStyleAttributes().setLocked(false);
		
		fillTable();
	}
    @Override
	public void onShow() throws Exception {
		
		super.onShow();
		this.kDTable1.requestFocusInWindow();
//		this.kDTable1.registerKeyboardAction(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                beforeActionPerformed(e);
//                try {
//                	// 回车执行 确认事件
//                	btnConfirm_actionPerformed(e);
//                } catch (Exception exc) {
//                    handUIException(exc);
//                } finally {
//                    afterActionPerformed(e);
//                }
//            }
//        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
//                JComponent.WHEN_FOCUSED);
		
		this.kDTable1.addKeyListener(new KeyAdapter()//键盘监听按钮
	             {
	                  public void keyPressed(KeyEvent e)
	                  {
	                      if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
	                         System.exit(0);
	                      //组合键
	                      else if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER)
	                         System.exit(0);
	                      else if(e.getKeyCode()==KeyEvent.VK_ENTER)
	                      {
	                    	  try {
	                          	// 回车执行 确认事件
	                          	btnConfirm_actionPerformed(null);
	                          } catch (Exception exc) {
	                              handUIException(exc);
	                          } finally {
	                              
	                          }
	                      }
	                  }
	                  
	              });
	}

	@Override
	public boolean requestFocusInWindow() {
		// TODO Auto-generated method stub
		return super.requestFocusInWindow();
	}

	/**
     * 填充table
     */
    private void fillTable(){
    	this.kDTable1.removeRows();
    	if(orderMaps != null && orderMaps.size() > 0){
    		Set<String> keySet = orderMaps.keySet();
    		Iterator<String> keyIte = keySet.iterator();
    		while(keyIte.hasNext()){
    			String key = keyIte.next();
    			OrderWeightInfo orderWeiInfo = orderMaps.get(key);
    			IRow newRow = this.kDTable1.addRow();
    			newRow.getCell("billID").setValue(orderWeiInfo.getOrderID());
    			newRow.getCell("orderNumber").setValue(orderWeiInfo.getOrderNumber());
    		//	newRow.getCell("baseStatus").setValue(orderWeiInfo.getBaseStatusEnum());
    			newRow.getCell("orderDate").setValue(orderWeiInfo.getBizDate());
    			//newRow.getCell("cusSuppName").setValue(orderWeiInfo.getCusSuppName());
    			newRow.getCell("carNumber").setValue(orderWeiInfo.getCarNumber());
    			//newRow.getCell("materialName").setValue(orderWeiInfo.getMaterialName());
    			newRow.getCell("baseQty").setValue(orderWeiInfo.getOrderBaseQty());
    			//newRow.getCell("bagQty").setValue(orderWeiInfo.getBagQty());
    		//	newRow.getCell("isSelected").setValue(false);
    			//newRow.getCell("entryID").setValue(orderWeiInfo.getEntryID());
    		}
    		
    		this.kDTable1.getSelectManager().select(0, 5);
    		this.kDTable1.requestFocusInWindow();
    		
    		this.pkEndDate.setRequestFocusEnabled(false);
    		this.pkBeginDate.setRequestFocusEnabled(false);
    		
    	}
    }
	/**
	 * 查询 订单信息
     * output btnSearch_actionPerformed method
     */
    protected void btnSearch_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        String orderNumber = StringUtils.trim(this.tfOrderNumber.getText());
        String carNumber = StringUtils.trim(this.tfCarNumber.getText());
        
        Date beginDate = this.pkBeginDate.getSqlDate();
        Date endDate = this.pkEndDate.getSqlDate();
        
        if(beginDate == null || endDate == null){
        	MsgBox.showInfo("查询开票日期不能为空");
        	SysUtil.abort();
        }else{
        	int dateDiff = DateCommon.dateDiff(beginDate, endDate);
        	if(dateDiff < 0){
        		MsgBox.showInfo("结束日期不能小于开始日期");
            	SysUtil.abort();
        	}else if(dateDiff > 10){
        		MsgBox.showInfo("查询日期跨度范围不能大于10天");
            	SysUtil.abort();
        	}
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String beginDateStr = sdf.format(beginDate);
        	String endDateStr = sdf.format(endDate);
        	// 根据 订单类型调用查询 方法
        	IweightbridgeFacade facade = weightbridgeFacadeFactory.getRemoteInstance();
        	if(PUR_ORDER.equals(orderType)){
				orderMaps = facade.getPurorderInfoByNumber(orderNumber,carNumber,beginDateStr,endDateStr);
				
        	}else if(SALE_ORDER.equals(orderType)){
        		// TODO 
        		orderMaps = facade.getSaleorderInfoByNumber(orderNumber,carNumber,beginDateStr,endDateStr);
        	}else if(QC_bill.equals(orderType)){
        		orderMaps = facade.getQCInfoByNumber(orderNumber,carNumber,beginDateStr,endDateStr);
        	}
        	// 重新加载 列表
        	this.fillTable();
        }
    }
    
    
    
    /**
     * output kDWorkButton1_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	//采购订单
    	if(PUR_ORDER.equals(orderType)){
	       	KDTSelectBlock block = this.kDTable1.getSelectManager().get();
	       	if(block != null){
	       		int rowIndex = block.getBeginRow();
	       		String billID = (String) this.kDTable1.getCell(rowIndex, "billID").getValue();
	       		//String entryID = (String) this.kDTable1.getCell(rowIndex, "entryID").getValue();
	       		if(StringUtils.isNotBlank(billID) && orderMaps != null){//billID
	       			// 获取 订单信息 返回
	       			OrderWeightInfo orderInfo = orderMaps.get(billID);//billID
	       			this.getUIContext().put("OrderInfo", orderInfo);
	       			
	       		}
	       	}
	       	this.getUIContext().put("isCancel", Boolean.FALSE);
	       	this.destroyWindow();
    	}else if(SALE_ORDER.equals(orderType)){//销售订单
    		IRow row;
    		ArrayList<OrderWeightInfo> orderInfoList=new ArrayList<OrderWeightInfo> ();
    		String customerName=null;
    		for(int rowIndex=0;rowIndex<this.kDTable1.getRowCount();rowIndex++) {
    			row=this.kDTable1.getRow(rowIndex);
    			if(row.getCell("isSelected").getValue()!=null&&row.getCell("isSelected").getValue().equals(true)) {
    				
    				if(customerName==null) {
    					customerName=row.getCell("cusSuppName").getValue().toString();
    				}else{
    					if(!customerName.equals(row.getCell("cusSuppName").getValue().toString())) {
//    						MsgBox.showWarning("非同一客户不支持合并！");
//    						SysUtil.abort();
    					}
    				}
    				OrderWeightInfo orderInfo = orderMaps.get(row.getCell("entryID").getValue().toString());
    				orderInfoList.add(orderInfo);
    			}
    		}
    		this.getUIContext().put("orderInfoList",orderInfoList);
    		this.destroyWindow();
    	}else if(QC_bill.equals(orderType)){//采购订单
    		KDTSelectBlock block = this.kDTable1.getSelectManager().get();
	       	if(block != null){
	       		int rowIndex = block.getBeginRow();
	       		String billID = (String) this.kDTable1.getCell(rowIndex, "billID").getValue();
	       		//String entryID = (String) this.kDTable1.getCell(rowIndex, "entryID").getValue();
	       		if(StringUtils.isNotBlank(billID) && orderMaps != null){//billID
	       			// 获取 订单信息 返回
	       			OrderWeightInfo orderInfo = orderMaps.get(billID);//billID
	       			this.getUIContext().put("OrderInfo", orderInfo);
	       			
	       		}
	       	}
	       	this.getUIContext().put("isCancel", Boolean.FALSE);
	       	this.destroyWindow();
    	}
    }

    
    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	this.getUIContext().put("isCancel", Boolean.TRUE);
//    	selectUICtx.get("isCancel");
        this.uiWindow.close();
    }


}