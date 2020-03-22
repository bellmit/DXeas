package com.kingdee.eas.farm.stocking.dep.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.SwingConstants;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.fileUtils.excelUtils;
import com.kingdee.eas.custom.commonld.CommFacade;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.commonld.ICommFacade;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.hatch.HatchHouseCollection;
import com.kingdee.eas.farm.hatch.IncubatorCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.fi.fa.manage.client.FaCurCardEditUI;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 固定资产卡片dep
 * @author 戴安东
 *
 */
public class FACardEditUIDep {
	//销售订单
	private FaCurCardEditUI ui;
	private KDBizPromptBox prmtFarmer,prmtFarm,prmtHouse,prmtStockingBatch,prmtBreedBatch;
	private String curCompanyID;

	public void afterOnload(final UIParam pluginCtx) {
		ui=(FaCurCardEditUI) pluginCtx.getUI();




		prmtFarmer=pluginCtx.getKDBizPromptBox("prmtfarmer");
		prmtFarm=pluginCtx.getKDBizPromptBox("prmtfarm");
		prmtHouse=pluginCtx.getKDBizPromptBox("prmthouse");
		prmtStockingBatch=pluginCtx.getKDBizPromptBox("prmtstockingBatch");
		prmtBreedBatch=pluginCtx.getKDBizPromptBox("prmtbreedBatch");
		
		

		if(prmtFarmer!=null&&prmtFarm!=null&&prmtHouse!=null&&prmtStockingBatch!=null) {
			if(pluginCtx.getKDBizPromptBox("bizPromptCurCompany").getValue()!=null) {
				curCompanyID=((IPropertyContainer) pluginCtx.getKDBizPromptBox("bizPromptCurCompany").getValue()).getString("id");
			}else{
				curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
			}
			curCompanyID=null;
			prmtFarmer.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					farmer_changed();
					setFilter();
				}});
			prmtFarm.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					setFilter();
				}});
			prmtHouse.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					setFilter();
				}});
			prmtStockingBatch.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					batch_changed();
					setFilter();
				}});
			prmtBreedBatch.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					prmtStockingBatch.setValue(prmtBreedBatch.getValue());
					batch_changed();
					setFilter();
				}});

			setFilter();
		}
	}
	/**
	 * 过滤条件
	 * @param table
	 */
	private void setFilter() {
		StockingClientComm.setFarmerFilter(prmtFarmer, curCompanyID,false);

		String farmerID=null,batchID=null,farmID=null,houseID=null;
		if(prmtStockingBatch.getValue()!=null) {
			batchID=((IPropertyContainer)prmtStockingBatch.getValue()).getString("id");
		}
		if(prmtFarmer.getValue()!=null) {
			farmerID=((IPropertyContainer)prmtFarmer.getValue()).getString("id");
		}
		if(prmtFarm.getValue()!=null) {
			farmID=((IPropertyContainer)prmtFarm.getValue()).getString("id");
		}
		if(prmtHouse.getValue()!=null) {
			houseID=((IPropertyContainer)prmtHouse.getValue()).getString("id");
		}

		StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
		StockingClientComm.setStockingBatchFilter(prmtStockingBatch, curCompanyID,farmerID,farmID,houseID);
		StockingClientComm.setStockingBatchFilter(prmtBreedBatch, curCompanyID,farmerID,farmID,houseID);

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(curCompanyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("parent.baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.id",farmID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id",StockingComm.getAllOutHouseIDsByBatchID(null, batchID, farmID),CompareType.INCLUDE));
		ev.setFilter(filter);
		prmtHouse.setEntityViewInfo(ev);
	}


	private void farmer_changed() {
		if(prmtFarmer.getValue()!=null) {
			try {
				prmtFarm.setValue(StockingComm.getFarmInfoByFarmerID(null,((IPropertyContainer)prmtFarmer.getValue()).getString("id")));
				//				if(prmtHouse.getValue()!=null&&!((IObjectValue)UIRuleUtil.getProperty((IObjectValue) prmtHouse.getValue(), "parent")).getString("id").equals(((IPropertyContainer)prmtFarmer).getString("id"))) {
				prmtHouse.setValue(null);
				//				}
				//				if(prmtStockingBatch.getValue()!=null&&!((IObjectValue)UIRuleUtil.getProperty((IObjectValue) prmtStockingBatch.getValue(), "farmer")).getString("id").equals(((IPropertyContainer)prmtFarmer).getString("id"))) {
				prmtStockingBatch.setValue(null);
				//				}
			}catch(Exception err) {
				err.printStackTrace();
			}
		}else {
			prmtFarm.setValue(null);
			prmtHouse.setValue(null);
			prmtStockingBatch.setValue(null);
		}
	}

	private void batch_changed() {
		if(prmtStockingBatch.getValue()!=null) {
			try {
				prmtBreedBatch.setValue(prmtStockingBatch.getValue());				//				prmtFarm.setValue(UIRuleUtil.getProperty((IObjectValue) prmtStockingBatch.getValue(), "farm"));
				prmtFarmer.setValue(UIRuleUtil.getProperty((IObjectValue) prmtStockingBatch.getValue(), "farmer"));
				//				prmtHouse.setValue(null);
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	/**
	 * 校验数据
	 * @throws BOSException 
	 * @throws DataAccessException 
	 * @throws EASBizException 
	 */
	public void verifyData(final UIParam pluginCtx) throws DataAccessException, BOSException, EASBizException {
		prmtFarmer=pluginCtx.getKDBizPromptBox("prmtfarmer");
		prmtFarm=pluginCtx.getKDBizPromptBox("prmtfarm");
		prmtHouse=pluginCtx.getKDBizPromptBox("prmthouse");
		prmtStockingBatch=pluginCtx.getKDBizPromptBox("prmtstockingBatch");

		if(prmtFarmer!=null&&prmtFarm!=null&&prmtHouse!=null&&prmtStockingBatch!=null) {
			if(prmtFarmer.getValue()==null) {
				//				MsgBox.showWarning("养殖户不能为空！");
				throw new EASBizException(new NumericExceptionSubItem("001","养殖户不能为空！"));
			}
			if(prmtFarm.getValue()==null) {
				//				MsgBox.showWarning("养殖场不能为空！");
				//				SysUtil.abort();
				throw new EASBizException(new NumericExceptionSubItem("001","养殖场不能为空！"));
			}
			if(prmtStockingBatch.getValue()==null) {
				//				MsgBox.showWarning("养殖批次不能为空！");
				//				SysUtil.abort();
				throw new EASBizException(new NumericExceptionSubItem("001","养殖批次不能为空！"));
			}
			if(UIRuleUtil.getProperty((IObjectValue) prmtFarm.getValue(), "isHouseManager")!=null&&(Boolean) UIRuleUtil.getProperty((IObjectValue) prmtFarm.getValue(), "isHouseManager")&&prmtHouse.getValue()==null) {
				//				MsgBox.showWarning("该养殖场已启用棚舍管理，棚舍不能为空！");
				//				SysUtil.abort();
				throw new EASBizException(new NumericExceptionSubItem("001","该养殖场已启用棚舍管理，棚舍不能为空！"));
			}
		}
	}

	/**
	 * 加载费用冲减明细
	 */
	public  void loadOffsetDetail(UIParam pluginCtx) {
		try {
			KDTable table = pluginCtx.getKDTable("kdtOffsetDetail");
			if(table==null) {
				return;
			}
			if(pluginCtx.getDataObject().get("id")==null) {
				return;
			}
			String id=(String) pluginCtx.getDataObject().get("id");
			table.removeRows();

			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select FFaCardID,fsettlebillid,fsettlebillNum,famount,to_char(fbizdate,'yyy-MM-dd') FBizDate,tp.fname_l2 fuserName")
			.append(" from T_FM_ArAODBE t1")
			.append(" left join t_pm_user tp on tp.fid=t1.fuserid")
			.append(" where FFaCardID='").append(id).append("'")
			.append(" order by FBizDate asc")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IRow row;
			while(rs.next()) {
				row=table.addRow();
				row.getCell("billNum").setValue(rs.getString("fsettlebillNum"));
				row.getCell("bizDate").setValue(rs.getDate("fbizdate"));
				row.getCell("amount").setValue(rs.getBigDecimal("famount"));
				row.getCell("user").setValue(rs.getString("fuserName"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 
	 * @param pluginCtx
	 */
	public void intCardAfterOnload(final UIParam pluginCtx) {
		
		//设置新增的金额字段显示两位小数
		pluginCtx.getKDFormattedTextField("txtinitUseArAmount").setPrecision(2);
		pluginCtx.getKDFormattedTextField("txtallArAmount").setPrecision(2);
		pluginCtx.getKDFormattedTextField("txtallApAmount").setPrecision(2);
		pluginCtx.getKDFormattedTextField("txtinitUseApAmount").setPrecision(2);
		pluginCtx.getKDFormattedTextField("txtcurrentTXAmt").setPrecision(2);
		pluginCtx.getKDFormattedTextField("txttotalTXAmt").setPrecision(2);
		pluginCtx.getKDFormattedTextField("txtremainTXAmt").setPrecision(2);
		
		pluginCtx.getKDFormattedTextField("txtinitUseArAmount").setHorizontalAlignment(SwingConstants.RIGHT);
		pluginCtx.getKDFormattedTextField("txtallArAmount").setHorizontalAlignment(SwingConstants.RIGHT);
		pluginCtx.getKDFormattedTextField("txtallApAmount").setHorizontalAlignment(SwingConstants.RIGHT);
		pluginCtx.getKDFormattedTextField("txtinitUseApAmount").setHorizontalAlignment(SwingConstants.RIGHT);
		pluginCtx.getKDFormattedTextField("txtcurrentTXAmt").setHorizontalAlignment(SwingConstants.RIGHT);
		pluginCtx.getKDFormattedTextField("txttotalTXAmt").setHorizontalAlignment(SwingConstants.RIGHT);
		pluginCtx.getKDFormattedTextField("txtremainTXAmt").setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		
		
		
		
//		HashMap<Object,Object> result=excelUtils.readExcelFile(1,1,1,278,1,18,null);
//		Iterator<Map.Entry<Object, Object>> entries = result.entrySet().iterator();
//		StockingBatchCollection coll;
//		StringBuffer sb=new StringBuffer();
//
//		try {
//			IStockingBatch IStockingBatch = StockingBatchFactory.getRemoteInstance();
//			if(entries.hasNext()) {  
//				Map.Entry<Object, Object> entry = entries.next();
//				HashMap<Integer,Object> rowValue=(HashMap<Integer, Object>) entry.getValue();
//				Iterator<Map.Entry<Integer, Object>> entries1 = rowValue.entrySet().iterator(); 
//				while(entries1.hasNext()){
//					Map.Entry<Integer, Object> entry1 = entries1.next();
//					HashMap<Integer,Object> cellValue=(HashMap<Integer, Object>) entry1.getValue();
//					coll = IStockingBatch.getStockingBatchCollection("where number='"+cellValue.get(0).toString()+"'");
//					sb.setLength(0);
//					if(coll.size()>0){
//						sb.append("update T_FA_FaMonCard set CFFarmerID='").append(coll.get(0).getFarmer().getString("id")).append("'");
//						sb.append(",CFstockingBatchID='").append(coll.get(0).getString("id")).append("'");
//						sb.append(",CFFarmID='").append(coll.get(0).getFarm().getString("id")).append("'");
//						sb.append(",CFAllArAmount=").append(cellValue.get(12));
//						sb.append(",CFinitUseApAmount=").append(cellValue.get(13));
//						sb.append(",CFremainTXAmt=").append(cellValue.get(14));
//						sb.append(",CFtotalTXAmt=").append(cellValue.get(15));
//						sb.append(",CFinitUseArAmount=").append(cellValue.get(16));
//						sb.append(",CFallApAmount=").append(cellValue.get(17));
//						sb.append(" where FAssetName='").append(cellValue.get(0).toString()).append("'");
//						System.out.println(sb.toString());
//						CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sb.toString());
//					}
//				}
//			}
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		HashMap<Object, Object> result=excelUtils.readExcelFile(1,1,1,278,1,21,null);
//		Iterator<Map.Entry<Object, Object>> entries = result.entrySet().iterator();
//		IRowSet rs;
//		StockingBatchCollection coll;
//		StringBuffer sb=new StringBuffer();
//		String endStr="";
//		try {
//			ICommFacade ICommFacadeFactory = CommFacadeFactory.getRemoteInstance();
//			IStockingBatch IStockingBatch = StockingBatchFactory.getRemoteInstance();
//			if(entries.hasNext()) {  
//				Map.Entry<Object, Object> entry = entries.next();
//				HashMap<Integer,Object> rowValue=(HashMap<Integer, Object>) entry.getValue();
//				Iterator<Map.Entry<Integer, Object>> entries1 = rowValue.entrySet().iterator(); 
//				while(entries1.hasNext()){
//					Map.Entry<Integer, Object> entry1 = entries1.next();
//					HashMap<Integer,Object> cellValue=(HashMap<Integer, Object>) entry1.getValue();
//					if(UIRuleUtil.isNotNull(cellValue.get(0))){
//						sb.setLength(0);
//						String str="select * from T_FA_FaMonCard where fassetname='"+(cellValue.get(0)).toString()+"'";
//						rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
//						if(rs.size()>0){
//							System.out.println(cellValue.get(0).toString());
//							coll = IStockingBatch.getStockingBatchCollection("where number='"+cellValue.get(0).toString()+"'");
//							if(coll.size()>0){
//								endStr=" where fassetname='"+(cellValue.get(0)).toString()+"'";
//								sb.append("update T_FA_FaMonCard set CFStockingBatchID='"+(coll.get(0).getString("id"))+"'");
//								sb.append(",CFFarmerID='"+coll.get(0).getFarmer().getString("id")+"'");
//								sb.append(",CFFarmID='"+coll.get(0).getFarm().getString("id")+"'");
//								sb.append(",CFAllArAmount="+cellValue.get(15)+"");
//								sb.append(",CFInitUseApAmount="+cellValue.get(16)+"");
//								sb.append(",CFRemainTXAmt="+cellValue.get(17)+"");
//								sb.append(",CFAllApAmount="+cellValue.get(18)+"");
//								sb.append(",CFInitUseArAmount="+cellValue.get(19)+"");
//								sb.append(endStr);
//								System.out.println(sb.toString());
//								ICommFacadeFactory.excuteUpdateSql(sb.toString());
//							}
//						}
//					}
//
//				}
//			}
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
