/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.event.*;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class AddDriverUI extends AbstractAddDriverUI
{
	private static final Logger logger = CoreUIObject.getLogger(AddDriverUI.class);

	/**
	 * output class constructor
	 */
	public AddDriverUI() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		final String billID=getUIContext().get("srcBillID").toString();


		btnConfirm.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				dealWithDriver(billID);
			}
		});

		btnConfirm.addKeyListener(new KeyAdapter(){

			public void keyPressed(KeyEvent paramKeyEvent) {
				// TODO Auto-generated method stub
				super.keyPressed(paramKeyEvent);
				dealWithDriver(billID);
			}});


		toolBar.setVisible(false);

		prmtDriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
		prmtDriver.setVisible(true);
		prmtDriver.setEditable(true);
		prmtDriver.setDisplayFormat("$drivername$");
		prmtDriver.setEditFormat("$drivername$");
		prmtDriver.setCommitFormat("$drivername$");
		prmtDriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtEntrys_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_driver_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI(){

							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return true;
							}

							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								// TODO Auto-generated method stub
								FilterInfo filter = super.getDefaultFilterForQuery();
								String maskString = filter.getMaskString();
								int size = filter.getFilterItems().size();
								filter.getFilterItems().add(new FilterItemInfo("CompanyOrgUnit.name",SysContext.getSysContext().getCurrentFIUnit().getString("name"),CompareType.EQUALS));
								if(size>0)
									filter.setMaskString("("+maskString+") AND (#"+size+")");
								else
									filter.setMaskString("#0");
								return filter;
							}


						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_driver_PromptBox_F7ListUI));
					kdtEntrys_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					prmtDriver.setSelector(kdtEntrys_driver_PromptBox_F7ListUI);
				}
			}
		});
	}
	/**
	 * 处理司机信息
	 * @param billID 
	 */
	private void dealWithDriver(String billID) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(billID))
			return;
		int n=4;
		String DriverID = "";
		if(prmtDriver.getValue()==null)
			n=MsgBox.showConfirm2("是否将原有单据的司机清空？");
		else{
			n=MsgBox.showConfirm2("是否将当前司机设置为原雏苗领用单的司机？");
			DriverID=((IPropertyContainer)prmtDriver.getValue()).getString("id");
		}

		if(n==0){
			try {
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_BreedSeedReceiveBill set FDriverID='"+DriverID+"' where FID='"+billID+"'");
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destroyWindow();
		}
	}

}