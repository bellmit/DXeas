/**
 * output package name
 */
package com. kingdee.eas.custom.tocloud.client;

import java.lang.reflect.Field;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.tabbedtable.KDTabbedTable;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDataStyle;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.editor.ICellEditor;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.cbos.process.vm.internal.Feature;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASAppException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.tocloud.BizTypeInfo;
import com.kingdee.eas.custom.tocloud.DataSynPlateformFacadeFactory;
import com.kingdee.eas.custom.tocloud.DeleteCloudBillFactory;
import com.kingdee.eas.custom.tocloud.ISynDateLog;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.SynDateLogFactory;
import com.kingdee.eas.custom.tocloud.SynDateLogInfo;
import com.kingdee.eas.custom.tocloud.TargetSystemFactory;
import com.kingdee.eas.custom.tocloud.TargetSystemInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonResult;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonResultResponseStatus;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonResultResponseStatusError;
import com.kingdee.eas.custom.tocloud.utils.K3CloudUtil;
import com.kingdee.eas.custom.wlhllicensemanager.util.JUtils;
import com.kingdee.eas.ep.client.editor.kdtable.KDTTableView;
import com.kingdee.eas.farm.stocking.basedata.StockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;


/**
 * output class name
 */
public class DataSynPlateformUI extends AbstractDataSynPlateformUI
{
	private static final Logger logger = CoreUIObject.getLogger(DataSynPlateformUI.class);

	/**
	 * output class constructor
	 */
	public DataSynPlateformUI() throws Exception
	{
		super();
	}
	/**
	 * 
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		//20181126 macheng add  设置目标系统
		this.kDBizPromptBoxTargetSystem.setQueryInfo("com.kingdee.eas.custom.tocloud.app.TargetSystemQuery");
		this.kDBizPromptBoxTargetSystem.setVisible(true);		
		this.kDBizPromptBoxTargetSystem.setEditable(true);		
		this.kDBizPromptBoxTargetSystem.setDisplayFormat("$name$");		
		this.kDBizPromptBoxTargetSystem.setEditFormat("$number$");		
		this.kDBizPromptBoxTargetSystem.setCommitFormat("$number$");		
		this.kDBizPromptBoxTargetSystem.setRequired(true);



		//设置业务类型的Query
		this.kDBizPromptBoxBizType.setQueryInfo("com.kingdee.eas.custom.tocloud.app.BizTypeQuery");
		this.kDBizPromptBoxBizType.setVisible(true);		
		this.kDBizPromptBoxBizType.setEditable(true);		
		this.kDBizPromptBoxBizType.setDisplayFormat("$name$");		
		this.kDBizPromptBoxBizType.setEditFormat("$number$");		
		this.kDBizPromptBoxBizType.setCommitFormat("$number$");		
		this.kDBizPromptBoxBizType.setRequired(true);
		//业务类型添加过滤
		//获取当前组织id
		//		StorageOrgUnitInfo storInfo = SysContext.getSysContext().getCurrentStorageUnit();
		//		EntityViewInfo viewInfo1 = new EntityViewInfo();
		//		FilterInfo filterInfo1 = new FilterInfo();
		//		filterInfo1.getFilterItems().add(new FilterItemInfo("STORAGEORANIZATION.id",storInfo.getId(),CompareType.EQUALS));
		//		viewInfo1.setFilter(filterInfo1);
		//		this.kDBizPromptBoxBizType.setEntityViewInfo(viewInfo1);





		//设置组织的Query
		this.kDBizPromptBoxCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageOrgUnitQuery");
		this.kDBizPromptBoxCompany.setVisible(true);		
		this.kDBizPromptBoxCompany.setEditable(true);	
		this.kDBizPromptBoxCompany.setDisplayFormat("$name$");		
		this.kDBizPromptBoxCompany.setEditFormat("$number$");		
		this.kDBizPromptBoxCompany.setCommitFormat("$number$");		
		this.kDBizPromptBoxCompany.setRequired(true);

		//组织添加过滤
		//定义一个过滤视图
		EntityViewInfo viewInfo = new EntityViewInfo();
		//设置过滤条件
		FilterInfo filterInfo = new FilterInfo();
		//参数
		filterInfo.getFilterItems().add(new FilterItemInfo("number","TYZQ",CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","ZQ08",CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","ZL1",CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","ZLQL",CompareType.EQUALS));
		filterInfo.setMaskString("#0 or #1 or #2 or #3");
		viewInfo.setFilter(filterInfo);
		kDBizPromptBoxCompany.setEntityViewInfo(viewInfo);





		//同步按钮添加监听事件
		kDButtonSyn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent paramMouseEvent) {

				//遍历KDTable的每一行分录
				String entryid = null;
				String billid = null;
				String stcokingBizDate = null;
				JSONObject jsonElement = null;
				String result = null;
				TargetSystemInfo targetSystemInfo = new TargetSystemInfo();
				String targetSysid = null;
				BizTypeInfo boxBizTypeInfo = new BizTypeInfo();
				String bizTypeid = null;
				if(kDBizPromptBoxTargetSystem.getValue() != null){
					targetSystemInfo = (TargetSystemInfo) kDBizPromptBoxTargetSystem.getValue();
					targetSysid = targetSystemInfo.getId().toString();
				}else{
					MsgBox.showWarning("目标系统不能为空！");
					SysUtil.abort();
				}
				if(kDBizPromptBoxBizType.getValue() != null){
					boxBizTypeInfo = (BizTypeInfo) kDBizPromptBoxBizType.getValue();
					bizTypeid = boxBizTypeInfo.getId().toString();
				}else{
					MsgBox.showWarning("业务类型不能为空！");
					SysUtil.abort();
				}

				//定义一个数据通同步日志
				SynDateLogInfo synDateLogInfo = new SynDateLogInfo();
				synDateLogInfo.setBizDate(new Date());
				ISynDateLog iSynDateLog = null;
				for(int i=0,length=kDTableEntry.getRowCount();i<length;i++){
					//如果分录中的某一行被选中了，就执行，否则返回
					if(kDTableEntry.getCell(i,"isSelect").getValue().equals(true)){

						//数据同步平台分录，记录所有的导入情况
						SynDateLogEntryInfo synDateLogEntryInfo = new SynDateLogEntryInfo();

						jsonElement = new JSONObject();
						entryid = kDTableEntry.getCell(i,"id").getValue().toString();
						billid = kDTableEntry.getCell(i, "stockingid").getValue().toString();
						stcokingBizDate = kDTableEntry.getCell(i, "bizdate").getValue().toString();

						SimpleDateFormat q2 = new SimpleDateFormat("yy-MM-dd");
						Date w1 = null;
						String w2 = null;
						String endDate = null;
						try {
							w1 = q2.parse(kDTableEntry.getCell(i, "bizdate").getValue().toString());
							w2 = q2.format(w1);
							endDate = "20"+w2;
						} catch (ParseException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}


						jsonElement.put("entryid",entryid );
						jsonElement.put("billid",billid );
						jsonElement.put("targetSysid",targetSysid );
						jsonElement.put("bizTypeid",bizTypeid );
						//获取目标系统编码
						TargetSystemInfo targetSysInfo = null;
						//获取业务类型的编码
						BizTypeInfo bizTypeInfo = null;
						try {
							iSynDateLog = SynDateLogFactory.getRemoteInstance();
							targetSysInfo = TargetSystemFactory.getRemoteInstance().getTargetSystemInfo(new ObjectUuidPK(targetSysid));
							bizTypeInfo = com.kingdee.eas.custom.tocloud.BizTypeFactory.getRemoteInstance().getBizTypeInfo(new ObjectUuidPK(bizTypeid));
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							synDateLogEntryInfo.setSynDateInformation(e.getMessage());
						}


						//数据同步日志
						synDateLogEntryInfo.setBillid(billid);
						//设置批次
						synDateLogEntryInfo.setBatchName(kDTableEntry.getCell(i,"batch").getValue().toString());

						synDateLogEntryInfo.setEntryid(entryid);
						//获取当前时间
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sysTime  = sdf.format(new Date());
						//设置目标系统名称
						synDateLogEntryInfo.setTargetSystemName(targetSysInfo.getName());
						//设置业务类型id
						synDateLogEntryInfo.setBizTypeid(bizTypeInfo.getId().toString());
						//设置业务类型名称
						synDateLogEntryInfo.setBizTypeName(bizTypeInfo.getName());
						//设置业务类型简称（设置到棚舍，用于删除cloud的对应单据）
						synDateLogEntryInfo.setHouse(bizTypeInfo.getSimpleName());
						//设置日志分录中的源单据编号
						synDateLogEntryInfo.setBillNumber(kDTableEntry.getCell(i,"billNum").getValue().toString());
						//设置源单据的业务日期
						synDateLogEntryInfo.setStockingBizDateStocking(endDate);

						//设置数据同步时间
						synDateLogEntryInfo.setSynDateTime(sysTime);
						//设置组织名称 
						StorageOrgUnitInfo strogeInfo = null;
						try {
							strogeInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(((StorageOrgUnitInfo) kDBizPromptBoxCompany.getValue()).getId()));
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						synDateLogEntryInfo.setCompanyName(strogeInfo.getName());
						//设置分录库存组织
						synDateLogEntryInfo.setStorage(strogeInfo);
						//设置表头库存组织
						synDateLogInfo.setStorareBill(strogeInfo);

						long time1=System.currentTimeMillis();
						try {
							result = DataSynPlateformFacadeFactory.getRemoteInstance().synData(jsonElement.toString());
							//设置数据同步结果
							//同步失败
							if(result == null){
								continue;
							}
							List<String> resultList = new ArrayList<String>();
							JSONObject jsonResult = JSONObject.parseObject(result);

							//重新定义异常
							//将 字符串转化为实体
							JSONObject jsonRe = JSONObject.parseObject(result);
							String ResultStr = jsonRe.getJSONObject("Result").toString();
							CloudCommonResult commonResult = JSONObject.parseObject(ResultStr, CloudCommonResult.class);
							CloudCommonResultResponseStatus responseResult = commonResult.getResponseStatus();

							if("false".equalsIgnoreCase(responseResult.getIsSuccess())){
								CloudCommonResultResponseStatusError[] errorArr = responseResult.getErrors();
								resultList.add("【数据同步失败】");
								for(int k=0,size=errorArr.length;k<size;k++){
									CloudCommonResultResponseStatusError error2 = errorArr[k];
									String q1 = error2.getMessage();
									resultList.add(q1);
								}

								synDateLogEntryInfo.setIsSuccess(false);
								synDateLogEntryInfo.setSynDateInformation(resultList.toString());	
								kDTableEntry.getCell(i, "synResult").setValue(resultList.toString());
							}//同步成功
							else{
								synDateLogEntryInfo.setIsSuccess(true);
								resultList.add("【数据同步成功】");
								resultList.add("   对应Cloud系统单据的ID为：");
								resultList.add(commonResult.getId());
								resultList.add("   编号为：");
								resultList.add(commonResult.getNumber());
								synDateLogEntryInfo.setCloudid(commonResult.getId());
								synDateLogEntryInfo.setCloudNum(commonResult.getNumber());
								synDateLogEntryInfo.setSynDateInformation(resultList.toString());
								kDTableEntry.getCell(i, "synResult").setValue(resultList.toString());
								//为了防止数据被重复同步，需要设置已经导入的行记录不可用，且不是已选择的 
								kDTableEntry.getRow(i).getStyleAttributes().setLocked(true);
								kDTableEntry.getRow(i).getStyleAttributes().setBackground(Color.GREEN);
								kDTableEntry.getCell(i, "isSelect").setValue(false);

								if("yLw5xdPdR4ydwEvS9HrWcYDbubQ=".equalsIgnoreCase(bizTypeInfo.getId().toString())
										|| "7PwJwEZaTZuxVoYnjPbBO4DbubQ=".equalsIgnoreCase(bizTypeInfo.getId().toString())){
									JSONArray numArray = new JSONArray();
									numArray.add(commonResult.getNumber());
									JSONObject obj = new JSONObject();
									obj.put("formid", "SP_PickMtrl");
									JSONObject dataObject = new JSONObject();
									dataObject.put("CreateOrgId", "0");
									dataObject.put("Numbers", numArray);
									obj.put("data", dataObject);
									try {
										//										String submitRes = K3CloudUtil.Submit(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
										String submitRes = DeleteCloudBillFactory.getRemoteInstance().submitBill(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
										System.out.println(submitRes);
										String res = DeleteCloudBillFactory.getRemoteInstance().auditBill(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
										//										String res = K3CloudUtil.Audit(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
										System.out.println(res);

										//如果审核不成功，就返回，并且删除cloud里面对应的领料出库单
										JSONObject json = JSONObject.parseObject(res);
										String ResultStr1 = json.getJSONObject("Result").toString();
										CloudCommonResult commonResult1 = JSONObject.parseObject(ResultStr1, CloudCommonResult.class);
										CloudCommonResultResponseStatus responseResult1 = commonResult1.getResponseStatus();
										if("false".equalsIgnoreCase(responseResult1.getIsSuccess())){
											JSONObject obj1 = new JSONObject();
											obj1.put("formid", billid);
											JSONObject dataObject1 = new JSONObject();
											dataObject1.put("CreateOrgId", "0");
											dataObject1.put("Numbers",numArray);
											obj1.put("data", dataObject1);

											//将参数传入Cloud系统
											String res1 = DeleteCloudBillFactory.getRemoteInstance().deleteCloudBill(JSONObject.toJSONString(obj1, SerializerFeature.WriteNullStringAsEmpty));
											System.out.println(res1);											
										}


									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}



							}
							long time2=System.currentTimeMillis();
							//数据同步日志设置耗时，并保存
							long costTime = (time2-time1);
							synDateLogEntryInfo.setCostTime(Long.toString(costTime)+"ms");
							synDateLogInfo.getEntrys().add(synDateLogEntryInfo);
						} catch (EASAppException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							kDTableEntry.getCell(i, "synResult").setValue(e.getMessage());
							synDateLogEntryInfo.setSynDateInformation(e.getMessage());
							long time2=System.currentTimeMillis();
							//数据同步日志设置耗时，并保存
							long costTime = (time2-time1);
							synDateLogEntryInfo.setCostTime(Long.toString(costTime)+"ms");
							synDateLogInfo.getEntrys().add(synDateLogEntryInfo);
						} catch (BOSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							kDTableEntry.getCell(i, "synResult").setValue(e.getMessage());
							synDateLogEntryInfo.setSynDateInformation(e.getMessage());
							long time2=System.currentTimeMillis();
							//数据同步日志设置耗时，并保存
							long costTime = (time2-time1);
							synDateLogEntryInfo.setCostTime(Long.toString(costTime)+"ms");
							synDateLogInfo.getEntrys().add(synDateLogEntryInfo);
						}
					}else{
						continue;
					}
				}
				try {
					iSynDateLog.save(synDateLogInfo);
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		//业务类型添加监听事件
		this.kDBizPromptBoxBizType.addDataChangeListener(new DataChangeListener(){

			@Override
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub

				if(kDBizPromptBoxCompany.getValue() != null){
					BizTypeInfo bizTypeInfo = null;
					if(kDBizPromptBoxBizType.getValue() != null){
						bizTypeInfo = (BizTypeInfo) kDBizPromptBoxBizType.getValue();

						//设置批次Query
						kDBizPromptBox1.setQueryInfo(bizTypeInfo.getBatchQuery());
						kDBizPromptBox1.setVisible(true);		
						kDBizPromptBox1.setEditable(true);		
						kDBizPromptBox1.setDisplayFormat("$name$");		
						kDBizPromptBox1.setEditFormat("$number$");		
						kDBizPromptBox1.setCommitFormat("$number$");		
						kDBizPromptBox1.setRequired(true);
					}
				}else{
					MsgBox.showWarning("请先维护组织！");
					kDBizPromptBoxBizType.setValue(null);
					//					SysUtil.abort();
				}


			}
		});



		//组织添加监听事件
		this.kDBizPromptBoxCompany.addDataChangeListener( new DataChangeListener(){

			@Override
			public void dataChanged(DataChangeEvent arg0) { 
				// TODO Auto-generated method stub
				kDBizPromptBoxBizType.setValue(null);
				StorageOrgUnitInfo storInfo = null;
				try {
					storInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(((StorageOrgUnitInfo) kDBizPromptBoxCompany.getValue()).getId()));
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				EntityViewInfo viewInfo1 = new EntityViewInfo();
				FilterInfo filterInfo1 = new FilterInfo();
				filterInfo1.getFilterItems().add(new FilterItemInfo("STORAGEORANIZATION.id",storInfo.getId(),CompareType.EQUALS));
				viewInfo1.setFilter(filterInfo1);
				kDBizPromptBoxBizType.setEntityViewInfo(viewInfo1);
			}

		});






		//目标系统监听事件，过滤业务类型
		this.kDBizPromptBoxTargetSystem.addDataChangeListener(new DataChangeListener(){
			@Override
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub

				String targetid = "";
				TargetSystemInfo targetSystem = null;
				if(kDBizPromptBoxTargetSystem.getValue() != null){
					targetSystem = (TargetSystemInfo) kDBizPromptBoxTargetSystem.getValue();
					targetid = targetSystem.getId().toString();
				}else{
					MsgBox.showWarning("目标系统不能为空！");
				}
				//获取目标系统对应业务类型的id
				String sql = "/*dialect*/ select t2.fid   bizType from  CT_CLD_TargetSystem  t1 inner join CT_CLD_BizType t2 on t2.CFTargetSystemID=t1.fid where t1.fid='"+targetid+"'";
				ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sql);
				IRowSet rs = null;
				List<String> list  = new ArrayList<String>();
				try {
					rs = executor.executeSQL();
					while(rs.next()){
						list.add(rs.getString("bizType"));
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//新定义视图
				EntityViewInfo view = new EntityViewInfo(); 
				//设置过滤条件
				FilterInfo filter = new FilterInfo(); 
				filter.getFilterItems().add(new FilterItemInfo("id", list.toString(),CompareType.INCLUDE)); 
				view.setFilter(filter);
				kDBizPromptBoxBizType.setEntityViewInfo(view);
			}
		});


		//设置目标系统的默认值
		String defaultValue = "T9K4ek3LSR6z2FZWYhgPPZQCSLk=";
		TargetSystemInfo targetSystemInfo = TargetSystemFactory.getRemoteInstance().getTargetSystemInfo(new ObjectUuidPK(defaultValue));
		this.kDBizPromptBoxTargetSystem.setValue(targetSystemInfo);

		//设置默认日期
		//获取当前月第一天：
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.MONTH, 0);
		//本月第一天 
		c.set(Calendar.DAY_OF_MONTH,1);
		//开始日期为本月第一天
		kDDatePickerDateS.setValue(c.getTime());
		//结束日期为当天
		kDDatePickerDateE.setValue(new Date());

	}


	//全选按钮添加监听事件

	@Override
	protected void kDWorkButton1_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton1_actionPerformed(e);
		kDWorkButton1(e);		
	}

	//全选按钮添加监听事件
	private void kDWorkButton1(ActionEvent e) {
		// TODO Auto-generated method stub
		if(kDTableEntry.getRowCount()>0){
			for(int i=0,entrySize = kDTableEntry.getRowCount();i<entrySize;i++){
				//如果这一行是锁定状态，直接跳过
				if(kDTableEntry.getRow(i).getStyleAttributes().isLocked() == true){
					continue;
				}else{
					kDTableEntry.getCell(i, "isSelect").setValue(true);
				}
			}
		}
	}



	//全不选按钮添加监听事件
	@Override
	protected void kDWorkButton2_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton2_actionPerformed(e);
		kDWorkButton2(e);		
	}

	//全不选按钮添加监听事件
	private void kDWorkButton2(ActionEvent e) {
		// TODO Auto-generated method stub

		if(kDTableEntry.getRowCount()>0){
			for(int i=0,entrySize = kDTableEntry.getRowCount();i<entrySize;i++){
				//如果该行是锁定状态，直接跳过
				if(kDTableEntry.getRow(i).getStyleAttributes().isLocked() == true){
					continue;
				}else{
					kDTableEntry.getCell(i, "isSelect").setValue(false);
				}
			}
		}


	}





	//查询按钮添加监听事件
	@Override
	protected void kDButtonQuery_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		//查询按钮必录校验
		if(kDBizPromptBoxTargetSystem.getValue() == null){
			MsgBox.showWarning("目标系统不能为空！");
			SysUtil.abort();
		}
		if(kDBizPromptBoxBizType.getValue() == null){
			MsgBox.showWarning("业务类型不能为空！");
			SysUtil.abort();
		}
		if(kDBizPromptBoxCompany.getValue() == null){
			MsgBox.showWarning("组织不能为空！");
			SysUtil.abort();
		}
		if(kDDatePickerDateS.getValue() == null){
			MsgBox.showWarning("开始日期不能为空！");
			SysUtil.abort();
		}
		if(kDDatePickerDateE.getValue() == null){
			MsgBox.showWarning("结束日期不能为空！");
			SysUtil.abort();
		}




		//根据单据的BosType和Query将单据信息加载到表格中
		//获取单据的BosType和Query
		BizTypeInfo bizTypeInfo = null;
		if(kDBizPromptBoxBizType.getValue() != null){
			bizTypeInfo = (BizTypeInfo) kDBizPromptBoxBizType.getValue();
		}
		if(bizTypeInfo.isIsBatchFilter()){
			if(kDBizPromptBox1.getValue() == null){
				MsgBox.showWarning("批次不能为空！");
				SysUtil.abort();
			}
		}


		String typeBosdtype = bizTypeInfo.getBosType();
		String typeQuery = bizTypeInfo.getQuery();
		boolean isReplaceSplit = true;
		com.alibaba.fastjson.JSONArray result = null;
		boolean isShowHeader = false;
		String[] queryCols = null;
		int beginRow = 0;
		int length = 0;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = sd.format(kDDatePickerDateS.getValue());
		String endDate = sd.format(kDDatePickerDateE.getValue());
		//获取库存组织
		StorageOrgUnitInfo storageInfo = (StorageOrgUnitInfo) kDBizPromptBoxCompany.getValue();
		String companyid = storageInfo.getId().toString();


		String queryStr  = null;
		//如果是按照批次过滤
		if(bizTypeInfo.isIsBatchFilter()){
			//获取批次通过强转coreBaseInfo实现
			CoreBaseInfo batchInfo = (CoreBaseInfo) kDBizPromptBox1.getValue();
			String batchid = batchInfo.getId().toString();
			queryStr = "where bizdate>={ ts '"+beginDate+" 00:00:00'} "+" and bizdate<={ ts '"+endDate+" 23:59:59'}  and companyid='"+companyid+"' and bateStatus=4 and batchid='"+batchid+"'";
		}else{//如果不按照批次过滤
			//如果是普通出料0或者1
			if(!bizTypeInfo.isIsReturn()){
				queryStr = "where bizdate>={ ts '"+beginDate+" 00:00:00'} "+" and bizdate<={ ts '"+endDate+" 23:59:59'}  and companyid='"+companyid+"' and bateStatus=4 and  isReturn in (0,1)";
			}
			//如果是退料 2或者3
			else{ 
				queryStr = "where bizdate>={ ts '"+beginDate+" 00:00:00'} "+" and bizdate<={ ts '"+endDate+" 23:59:59'}  and companyid='"+companyid+"' and bateStatus=4 and isReturn in (2,3)";
			}

		}
		//如果表头行已经存在了，点击查询的时候就删掉所有的表头行
		if(kDTableEntry.getHeadRowCount()>0){
			kDTableEntry.removeHeadRows();
		}
		//如果分录中已经存在表列，就删掉所有的表列
		if(kDTableEntry.getColumnCount()>0){
			kDTableEntry.removeColumns();
		}
		// 创建列
		JSONObject json = new JSONObject();
		json.put("bosType",typeBosdtype);
		json.put("queryInfo",typeQuery);
		json.put("isReplaceSplit",false);
		json.put("queryStr", queryStr);
		try {
			String headerStr = DataSynPlateformFacadeFactory.getRemoteInstance().getBillHeader(json.toString());
			JSONArray array = JSONArray.parseArray(headerStr);
			//增加一行表头行
			RptTableHeader header = createHeader(array);
			//设置表头字段的显示字段
			KDTableUtil.setHeader(header, kDTableEntry);

			//获取表列
			String headerList = DataSynPlateformFacadeFactory.getRemoteInstance().getBillList(json.toString());
			JSONArray arrayList = JSONArray.parseArray(headerList);
			JSONObject jsonObj = null;
			IRow row = null;

			//遍历表列数组，数据有多大就代表有多少行记录
			for(int i=0,size = arrayList.size();i < size;i++){

				//获得单个的jsonObject
				jsonObj = arrayList.getJSONObject(i);


				//以业务类型id，分录ID，养殖日报ID作为筛选条件，筛选数据同步日志
				//如果数据同步日志中存在记录，就删掉这一行，如果不存在就不做任何处理
				//业务类型id
				BizTypeInfo bzInfo = (BizTypeInfo) kDBizPromptBoxBizType.getValue();
				String biztryeid = bzInfo.getId().toString();
				//分录id
				String entryID = jsonObj.getString("id");
				//养殖日报id
				String billid = jsonObj.getString("stockingid");
				StringBuffer sql = new StringBuffer();
				sql.append("/*dialect*/ select max(t1.fid) entryid  from  CT_CLD_SynDateLogEntry  t1 where t1.CFIsSuccess = 1");sql.append("\n");
				sql.append("and t1.CFBizTypeid = '");
				sql.append(biztryeid);
				sql.append("'");sql.append("\n");
				sql.append(" and t1.CFEntryid = '");
				sql.append(entryID);
				sql.append("'");sql.append("\n");
				sql.append(" and t1.CFBillid = '");
				sql.append(billid);
				sql.append("'");
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				if(rs.next()){
					String eid = rs.getString("entryid");
					if(eid != null){
						continue;
					}else{
						//每一次遍历都要新增一行
						row = kDTableEntry.addRow(); 
						for(int j = 0,size2 = kDTableEntry.getColumnCount();j < size2;j++){
							//kDTableEntry.getColumnKey(j)----获取KDTable的第j列字段名称
							if(kDTableEntry.getColumnKey(j).equalsIgnoreCase("isSelect")){
								KDCheckBox kdtEntrys_isSelect_CheckBox = new KDCheckBox();
								kdtEntrys_isSelect_CheckBox.setName("kdtEntrys_isSelect_CheckBox");
								KDTDefaultCellEditor kdtEntrys_isSelect_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isSelect_CheckBox);
								row.getCell(j).setEditor(kdtEntrys_isSelect_CellEditor);
								row.getCell(j).setValue(false);
							}else{
								row.getCell(j).setValue(JUtils.getString(jsonObj, kDTableEntry.getColumnKey(j)));
							}
						}
					}
				}else{
					//每一次遍历都要新增一行
					row = kDTableEntry.addRow(); 
					for(int j = 0,size2 = kDTableEntry.getColumnCount();j < size2;j++){
						//kDTableEntry.getColumnKey(j)----获取KDTable的第j列字段名称
						if(kDTableEntry.getColumnKey(j).equalsIgnoreCase("isSelect")){
							KDCheckBox kdtEntrys_isSelect_CheckBox = new KDCheckBox();
							kdtEntrys_isSelect_CheckBox.setName("kdtEntrys_isSelect_CheckBox");
							KDTDefaultCellEditor kdtEntrys_isSelect_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isSelect_CheckBox);
							row.getCell(j).setEditor(kdtEntrys_isSelect_CellEditor);
							row.getCell(j).setValue(false);
						}else{
							row.getCell(j).setValue(JUtils.getString(jsonObj, kDTableEntry.getColumnKey(j)));
						}
					}
				}

			}
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}


		List cloumnNameList = new ArrayList();
		for(int n = 0,size3 = kDTableEntry.getColumnCount();n < size3;n++){
			if(kDTableEntry.getColumnKey(n).toLowerCase().contains("hjh")){	
				cloumnNameList.add(kDTableEntry.getColumnKey(n));
			}
		}

		String[] cloumnName = new String[cloumnNameList.size()];

		for(int n = 0,size3 = cloumnNameList.size();n < size3;n++){
			cloumnName[n] = cloumnNameList.get(n).toString();
		}

		//添加合计行
		apendFootRow(kDTableEntry, cloumnName);


		super.kDButtonQuery_actionPerformed(e);
	}
	/**
	 * 设置表头
	 * @param param
	 * @return
	 */
	protected RptTableHeader createHeader(JSONArray param) {
		RptTableHeader header = new RptTableHeader();
		StringBuffer headerLabel=new StringBuffer();
		JSONObject colJson = null;
		RptTableColumn col = null;

		//设置是否选择Boolean类型
		headerLabel.append("是否选择");
		header.addColumn(new RptTableColumn("isSelect"));

		for(int i=0,size = param.size();i < size;i++){
			headerLabel.append(",");
			//获得jsonArray数组中的各个jsonObject对象
			colJson = param.getJSONObject(i);
			//获取jsonObject对象对应的值
			col = new RptTableColumn(colJson.getString("name"));
			try {
				col.setHided(!JUtils.getBoolean(colJson, "isVisible"));
				if(colJson.getString("name").toLowerCase().contains("id")){
					col.setHided(true);
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(StringUtils.isEmpty(colJson.getString("displayName"))){
				headerLabel.append(col.getName());
			}else{
				headerLabel.append(colJson.getString("displayName"));
			}
			header.addColumn(col);
		}
		headerLabel.append(",");
		headerLabel.append("同步结果");
		//设置同步结果的显示宽度
		col = new RptTableColumn();
		col.setWidth(300);
		col.setName("synResult");
		header.addColumn(col);


		header.setLabels(new Object[][] { headerLabel.toString().split(",") });
		return header;

	}

	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  
	public  void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount();  
		if(count == 0){
			count = table.getRowCount1();
		}
		if(count == 0){
			count = table.getRowCount3();
		}
		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0.00"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);  
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = com.kingdee.eas.util.client.EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}  

	private  void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (UIRuleUtil.isNotNull(obj) && obj != "") {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}



}