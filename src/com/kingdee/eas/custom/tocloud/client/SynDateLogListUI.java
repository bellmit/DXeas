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
import com.ibm.db2.jcc.t4.tb;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.tocloud.DeleteCloudBillFactory;
import com.kingdee.eas.custom.tocloud.ISynDateLog;
import com.kingdee.eas.custom.tocloud.ISynDateLogEntry;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryFactory;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.SynDateLogFactory;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.custom.tocloud.utils.K3CloudUtil;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SynDateLogListUI extends AbstractSynDateLogListUI
{
	private static final Logger logger = CoreUIObject.getLogger(SynDateLogListUI.class);

	/**
	 * output class constructor
	 */
	public SynDateLogListUI() throws Exception
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



	/**
	 * 删除cloud对应单据，删除数据同步日志分录
	 */
	@Override
	public void actionDeleteEntry_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		//获取所选的行号
		//遍历行号List获取 分录id，表单id，单据编号

		List<Integer> selectList = new ArrayList<Integer>();
		selectList = getSelectList();
		System.out.println(selectList);

		//定义一个List存放分录id
		String eid = null;
		List<String> entryid = new ArrayList<String>();

		//定义一个List存放cloud的单据编号
		String eNum = null;
		List<String> billNumber = new ArrayList<String>();

		//定义一个cloud表单id
		String billid = null;

		for(int i=0,size=selectList.size();i<size;i++){
			if("true".equalsIgnoreCase(tblMain.getCell(selectList.get(i),"entrys.isSuccess").getValue().toString())
					&& !UIRuleUtil.isNull(tblMain.getCell(selectList.get(i),"entrys.CloudNum").getValue())
					&& !UIRuleUtil.isNull(tblMain.getCell(selectList.get(i),"entrys.house").getValue())
			){
				eid = tblMain.getCell(selectList.get(i),"entrys.id").getValue().toString();
				entryid.add(eid);
				eNum = tblMain.getCell(selectList.get(i),"entrys.CloudNum").getValue().toString();
				billNumber.add(eNum);
				billid = tblMain.getCell(selectList.get(i),"entrys.house").getValue().toString();
			}
			//			else if("false".equalsIgnoreCase(tblMain.getCell(selectList.get(i),"entrys.isSuccess").getValue().toString())
			//					&& !UIRuleUtil.isNull(tblMain.getCell(selectList.get(i),"entrys.billNumber").getValue())){
			//				eid = tblMain.getCell(selectList.get(i),"entrys.id").getValue().toString();
			//				List<String> entryid1 = new ArrayList<String>();
			//				entryid1.add(eid);
			//				deleteEntryRow(entryid1);
			//				selectList.remove(i);
			//			}
		}


		//新建一个数组，将单据编号放进去
		String[]  billArray = new String[billNumber.size()];
		//遍历List排除NUll元素
		for(int k=0,listSize=billNumber.size();k<listSize;k++){
			billArray[k] = billNumber.get(k);
		}

		if(billArray.length != 0){
			JSONObject obj = new JSONObject();
			obj.put("formid", billid);
			JSONObject dataObject = new JSONObject();
			dataObject.put("CreateOrgId", "0");
			dataObject.put("Numbers",billArray);
			obj.put("data", dataObject);

			//将参数传入Cloud系统
			String res = DeleteCloudBillFactory.getRemoteInstance().deleteCloudBill(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));

			//将结果解析返回
			JSONObject json1 = JSONObject.parseObject(res);
			//获取result
			JSONObject json2 = json1.getJSONObject("Result");
			//获取ResponseStatus
			JSONObject json3 = json2.getJSONObject("ResponseStatus");
			//获取
			String isSuccess = json3.getString("IsSuccess");
			//如果是true就执行删除操作，如果是false就不执行删除操作
			if(isSuccess.equalsIgnoreCase("true")){
				MsgBox.showWarning("删除成功！");
				//删除该单据对应的分录
				deleteEntryRow(entryid);
			}else{
				MsgBox.showWarning("删除失败，请检查CLOUD系统中的单据是否存在！");
			}
		}else{
			for(int j=0,length=selectList.size();j<length;j++){
				String dataid = tblMain.getCell(selectList.get(j),"id").getValue().toString();
				//将空的数据同步日志删掉
				ISynDateLog synData = SynDateLogFactory.getRemoteInstance();
				IObjectPK pk = new ObjectStringPK(dataid);
				synData.delete(pk);
			}
		}

		super.actionDeleteEntry_actionPerformed(e);
	}


	/**
	 * 删除数据同步日志对应的分录
	 * @param entryid
	 */
	private void deleteEntryRow(List<String> entrylist) {
		// TODO Auto-generated method stub

		try {
			ISynDateLogEntry synData = SynDateLogEntryFactory.getRemoteInstance();
			for(int i=0,size=entrylist.size();i<size;i++){
				String entryid = entrylist.get(i);
				IObjectPK pk = new ObjectStringPK(entryid);
				synData.delete(pk);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * 设置列表界面的组织隔离
	 */
	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0,
			EntityViewInfo arg1) {
		return super.getQueryExecutor(arg0, arg1);


	}






	@Override
	protected EntityViewInfo getDefaultEntityViewInfo() {
		// TODO Auto-generated method stub
		return super.getDefaultEntityViewInfo();
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub

		FilterInfo filter = new FilterInfo(); 

		//获取表头公司(F7)字段的id
		StorageOrgUnitInfo saleOrgUnitInfo = SysContext.getSysContext().getCurrentStorageUnit();

		//添加新的筛选条件，按照当前组织过滤
		filter.getFilterItems().add(new FilterItemInfo("entrys_storage.id", saleOrgUnitInfo.getId(),CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("storareBill.id", saleOrgUnitInfo.getId(),CompareType.EQUALS));
		filter.setMaskString("#0 or #1");

		return filter;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub

		super.onLoad();

		//方法一
		SorterItemCollection sc = new SorterItemCollection();
		SorterItemInfo sorterItem = new SorterItemInfo("entrys.synDateTime");
		sorterItem.setSortType(SortType.DESCEND);
		sc.add(sorterItem);
		mainQuery.setSorter(sc);

		//设置删除按钮隐藏
		btnRemove.setVisible(false);


		//数据同步日志添加组织过滤
		//		EntityViewInfo view = new EntityViewInfo(); 
		//		//设置过滤条件
		//		FilterInfo filter = new FilterInfo(); 
		//
		//		//获取表头公司(F7)字段的id
		//		StorageOrgUnitInfo saleOrgUnitInfo = SysContext.getSysContext().getCurrentStorageUnit();
		//
		//		//添加新的筛选条件，按照当前组织过滤
		//		filter.getFilterItems().add(new FilterItemInfo("entrys_storage.id", saleOrgUnitInfo.getId(),CompareType.EQUALS));
		//		filter.getFilterItems().add(new FilterItemInfo("storareBill.id", saleOrgUnitInfo.getId(),CompareType.EQUALS));
		//		filter.setMaskString("#0 or #1");
		//
		//		//筛选条件
		//		view.setFilter(filter);



	}


	@Override
	public ArrayList getSelectList() {
		// TODO Auto-generated method stub

		return super.getSelectList();
	}

	/**
	 * 列表界面删除数据同步日志
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		//		List<Integer> selectList = new ArrayList<Integer>();
		//		selectList = getSelectList();
		//
		//		for(int i=0,size=selectList.size();i<size;i++){
		//			if(!UIRuleUtil.isNull(tblMain.getCell(selectList.get(i),"entrys.isSuccess").getValue())){
		//				tblMain.getCell(selectList.get(i),"entrys.house").getValue();
		//
		//			}
		//		}

		super.actionRemove_actionPerformed(e);

	}

	//列表界面排序  ----方法二
	@Override
	protected void beforeExcutQuery(EntityViewInfo arg0) {
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.tocloud.SynDateLogFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.tocloud.SynDateLogInfo objectValue = new com.kingdee.eas.custom.tocloud.SynDateLogInfo();

		return objectValue;
	}

}