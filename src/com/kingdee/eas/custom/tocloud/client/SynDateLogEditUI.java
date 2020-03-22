/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.tocloud.utils.K3CloudUtil;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDTextField;

/**
 * output class name
 */
public class SynDateLogEditUI extends AbstractSynDateLogEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SynDateLogEditUI.class);

	/**
	 * output class constructor
	 */
	public SynDateLogEditUI() throws Exception
	{
		super();
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


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		//		this.kdtEntrys_detailPanel.addRemoveListener(new IDetailPanelListener(){
		//			public void afterEvent(DetailPanelEvent arg0) throws Exception {
		//
		//				 KDTSelectBlock w1 = kdtEntrys.getSelectManager().get();
		//				
		//				int activeRowIndex = kdtEntrys.getSelectManager().getActiveRowIndex();
		//				System.out.println(activeRowIndex);
		//				
		//				List<Integer> entryList = getSelectedIdForPrint();
		//				System.out.println(entryList);
		//
		//			}
		//			public void beforeEvent(DetailPanelEvent arg0) throws Exception {
		//				// TODO Auto-generated method stub
		//				
		//				
		//			}
		//		});
		super.onLoad();
		this.btnRemove.setVisible(false);
	}


	/**
	 * 删除整张单据，遍历分录，删除cloud里面对应的单据
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		//获取cloud表单id
		//		String billid = null;
		//		//获取所生成单据的编码
		//		String billNum = null;
		//		//新建一个List，将单据编号放进去
		//		List<String> numList = new ArrayList<String>();
		//		for(int i=0,size=kdtEntrys.getRowCount();i<size;i++){
		//			if("true".equalsIgnoreCase(kdtEntrys.getCell(i,"isSuccess").getValue().toString())
		//					&& !UIRuleUtil.isNull(kdtEntrys.getCell(i,"house").getValue())
		//					&& !UIRuleUtil.isNull(kdtEntrys.getCell(i,"CloudNum").getValue())
		//			){
		//				billid = kdtEntrys.getCell(i,"house").getValue().toString();
		//				billNum = kdtEntrys.getCell(i,"CloudNum").getValue().toString();
		//				numList.add(billNum);
		//			}
		//		}
		//
		//
		//		//新建一个数组，将单据编号放进去
		//		String[]  billArray = new String[numList.size()];
		//		//遍历List排除NUll元素
		//		for(int k=0,listSize=numList.size();k<listSize;k++){
		//			billArray[k] = numList.get(k);
		//		}
		//
		//		JSONObject obj = new JSONObject();
		//		obj.put("formid", billid);
		//		JSONObject dataObject = new JSONObject();
		//		dataObject.put("CreateOrgId", "0");
		//		dataObject.put("Numbers",billArray);
		//		obj.put("data", dataObject);
		//
		//		//将参数传入Cloud系统
		//		String res = K3CloudUtil.Delete(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
		//
		//		
		//		//将结果解析返回
		//		JSONObject json1 = JSONObject.parseObject(res);
		//		//获取result
		//		JSONObject json2 = json1.getJSONObject("Result");
		//		//获取ResponseStatus
		//		JSONObject json3 = json2.getJSONObject("ResponseStatus");
		//		//获取
		//		String isSuccess = json3.getString("IsSuccess");
		//		//如果是true就执行删除操作，如果是false就不执行删除操作
		//		if(isSuccess.equalsIgnoreCase("true")){
		//			super.actionRemove_actionPerformed(e);
		//			MsgBox.showWarning("删除成功！");
		//		}else{
		//			MsgBox.showWarning("删除失败，请检查CLOUD系统中的单据是否存在！");
		//		}
		super.actionRemove_actionPerformed(e);

	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.tocloud.SynDateLogFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.tocloud.SynDateLogInfo objectValue = new com.kingdee.eas.custom.tocloud.SynDateLogInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}