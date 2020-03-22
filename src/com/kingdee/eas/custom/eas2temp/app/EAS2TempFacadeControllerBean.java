package com.kingdee.eas.custom.eas2temp.app;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.IStorageOrgUnit;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.eas2temp.EAS2TempOPTypeEnum;
import com.kingdee.eas.custom.eas2temp.EAS2TempSourceTypeEnum;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.custom.eas2temp.interfaces.ExportBOM;
import com.kingdee.eas.custom.eas2temp.interfaces.ExportManufactureOrder;
import com.kingdee.eas.custom.eas2temp.interfaces.ExportMaterial;
import com.kingdee.eas.custom.eas2temp.interfaces.ExportProduct;
import com.kingdee.eas.custom.eas2temp.interfaces.ExportSaleIssue;
import com.kingdee.eas.custom.eas2temp.interfaces.IExport2Temp;
import com.kingdee.eas.custom.eas2temp.interfaces.IImport2EAS;
import com.kingdee.eas.custom.eas2temp.interfaces.ImportCollMaterialReqBill;
import com.kingdee.eas.custom.eas2temp.interfaces.ImportMaterialReqBill;

//import com.kingdee.eas.ma.biz.BizException;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class EAS2TempFacadeControllerBean extends
		AbstractEAS2TempFacadeControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.custom.eas2temp.app.EAS2TempFacadeControllerBean");

	/**
	 * EAS导出单据到中间库 companynum 公司编码 jsonStr （opType（要导出的单据类型）） sourceType 资源类型
	 */
	@Override
	protected String _exportBill(Context ctx, String companyNum,
			String jsonStr, int sourceType) throws BOSException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(companyNum)) {// 公司编码
			return "公司不能为空";
		}
		System.out.println("####################beginExportFacade");;
		String msg = "";
		try {
			String companyID = EASWUtils.getCompanyIDByNumber(ctx, companyNum);// 通过公司编码获得公司ID
			JSONObject jo = new JSONObject(jsonStr);
			if (jo.isNull("opType")) {// 单据类型为空
				return null;
			}
			Integer opType = jo.getInt("opType");
			IExport2Temp ie = null;
			switch (opType) {
			case EAS2TempOPTypeEnum.MANUFACTUREORDER_VALUE:// 导出生产订单
				ie = new ExportProduct();
				break;
			case EAS2TempOPTypeEnum.EXPORTSALEISSUE_VALUE:// 导出销售出库单
				ie = new ExportSaleIssue();
				break;
			case EAS2TempOPTypeEnum.EXPORTBOM_VALUE:// 导出BOM
				ie = new ExportBOM();
				break;
			case EAS2TempOPTypeEnum.EXPORTMATERIAL_VALUE:// 导出物料
				ie = new ExportMaterial();
				break;
			default:
				break;
			}
			if (sourceType == EAS2TempSourceTypeEnum.CLIENT_VALUE)
				msg = ie.export2TempByID(ctx, companyID, jo.getString("billID"));
			else
				msg = ie.export2TempByID(ctx, companyID, null);
		} catch (Exception e) {
			logger.error(e);
			return "执行失败" + e.getMessage();
		}
		return msg;
	}

	/**
	 * 导入到EAS
	 */
	@Override
	protected String _importBill(Context ctx, String companyNum,
			String jsonStr, int sourceType) throws BOSException {
		if (StringUtils.isBlank(companyNum)) {
			return "公司不能为空";
		}
		String msg = "";
		try {
			String companyID = EASWUtils.getCompanyIDByNumber(ctx, companyNum);
			JSONObject jo = new JSONObject(jsonStr);
			if (jo.isNull("opType")) {// 单据类型为空
				return null;
			}
			Integer opType = jo.getInt("opType");
			IImport2EAS ie = null;
			// 根据单据类型来进行导入
			switch (opType) {
//			case EAS2TempOPTypeEnum.PURINWAREHOUSE_VALUE:// 导入采购入库单
//				ie = new ImportPurInwarehouseBill();
//				break;
			case EAS2TempOPTypeEnum.MATERIALREQ_VALUE:// 导入领料出库单
				ie = new ImportMaterialReqBill();
				break;
				
			case EAS2TempOPTypeEnum.MATERIALCOLLREQ_VALUE:// 导入按日期汇总领料出库单
				ie = new ImportCollMaterialReqBill();
				break;
					
//			case EAS2TempOPTypeEnum.PRODUCTIN_VALUE:// 导入生产入库单
//				ie = new ImportProductInBill();
//				break;
//			case EAS2TempOPTypeEnum.IMPORTSTOCKTRANSFERBILL_VALUE:// 导入库存调拨单
//				ie = new ImportStockTransferBill();
//				break;
			default:
				break;
			}
			if (sourceType == EAS2TempSourceTypeEnum.CLIENT_VALUE)
				msg = ie.importBillByBotp(ctx, companyID, jo
						.getString("beginDate"), jo.getString("endDate"),jo.getString("TempClass"));
			else
				msg = ie.importBillByBotp(ctx, companyID, null, null,null);
		} catch (Exception e) {
			logger.error(e);
			return "执行失败" + e.getMessage();
		}
		return msg;
	}

	@Override
	protected boolean _testConn(Context ctx, String companyID,int targetSystem)
			throws BOSException {
//
		Boolean result = false;
		Connection conn;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID,
					targetSystem);// 得到连接
			if (conn != null) {
				result = true;
				if (!conn.isClosed()) {
					conn.close();
				}
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
		
		//0116临时方法
//		String sql = "select distinct FSrcObjectID purid from T_BOT_Relation where FDestEntityID='52D6BAC2' and FSrcEntityID = '3171BFAD' ";
//		try {
//			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
//			while(rs.next()){
//				String Purid = rs.getString("purid");
//				//String inid = rs.getString("inid");
//				String sqls = "select  FDestObjectID inid from T_BOT_Relation where  FSrcObjectID = '"+Purid+"' and FDestEntityID='52D6BAC2' and FSrcEntityID = '3171BFAD'";
//				IRowSet rss = SQLExecutorFactory.getLocalInstance(ctx,sqls.toString()).executeSQL();
//				BigDecimal sumweight = new BigDecimal("0");
//				while(rss.next()){
//					String sqlss = "select sum(t2.CFSuttle) CFSuttle  from CT_WHB_InStorageBill t1 inner join CT_WHB_InStorageBillEntry t2 on t2.FParentID = t1.FID  where t1.fid ='"+rss.getString("inid")+"'";
//					IRowSet rsss = SQLExecutorFactory.getLocalInstance(ctx,sqlss.toString()).executeSQL();
//					if(rsss.next()){
//						sumweight = sumweight.add(new BigDecimal(rsss.getString("CFSuttle")));
//					}
//				}
//				String updatesql = "update T_SM_PurOrder set CFSumWeight = '"+sumweight.toString()+"' where fid = '"+Purid+"'";
//				CommFacadeFactory.getLocalInstance(ctx).excuteUpdateSql(updatesql);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		
		return result;
	}

	/**
	 * 初始化物料对应关系
	 */
	@Override
	protected void _initBarEASRel(Context ctx, String easMaterialID,
			String storageUnitOrgID) throws BOSException {
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		MaterialInfo easMaterialInfo;
		try {
			easMaterialInfo = ims.getMaterialInfo(new ObjectUuidPK(
					easMaterialID));
			IStorageOrgUnit iof = StorageOrgUnitFactory.getLocalInstance(ctx);
			StorageOrgUnitInfo storageOrgUnitInfo = iof
					.getStorageOrgUnitInfo(new ObjectUuidPK(storageUnitOrgID));

			if (!EASWUtils.checkHasMaterialRel(ctx, easMaterialInfo.getId()
					.toString(), storageOrgUnitInfo.getId().toString())) {// 如果已经存在eas物料编码对应关系则继续
				EASWUtils.insertBarEASRel(ctx, easMaterialInfo,
						storageOrgUnitInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 删除条码和牧羊系统中的生产订单，传入pk
	 */
	@Override
	protected String _deleteBarAndMyData(Context ctx, Object obj) throws BOSException {

		Connection conn = null;
		Connection connMY=null;
		try {
			IObjectPK pk = new ObjectUuidPK(obj.toString());
			SelectorItemCollection slr=new SelectorItemCollection();
			slr.add(new SelectorItemInfo("*"));
			slr.add(new SelectorItemInfo("CU.*"));
			ManufactureOrderInfo info = ManufactureOrderFactory.getLocalInstance(
					ctx).getManufactureOrderInfo(pk,slr);
			if (info.getCU().getNumber().equals("07")) {
				try {
					
					//----条码系统删除开始-------
					conn = EASWUtils.getTempConnection(ctx, info.getCU().getId().toString(), TargetSystem.BARSYSTEM_VALUE);
					if (conn == null) {
						throw new Exception("请确认连接参数设置正确");
					}
					conn.setAutoCommit(false);
					StringBuffer sql = new StringBuffer();
					sql.append(" delete from sc_pfjh where pldh='").append(
							info.getNumber()).append("'");
					PreparedStatement ptm = conn.prepareStatement(sql.toString());
					ptm.execute();
					conn.commit();
					//------条码系统删除结束------
					//------牧羊系统删除开始-----
					connMY=EASWUtils.getTempConnection(ctx, info.getCU().getId().toString(), TargetSystem.MUYANGSYSTEM_VALUE);
					if (connMY == null) {
						throw new Exception("请确认连接参数设置正确");
					}
					connMY.setAutoCommit(false);
					StringBuffer sqlMY=new StringBuffer();
					sqlMY.append(" delete from bomOrders where number='").append(
							info.getNumber()).append("'");
					PreparedStatement ptmMY = connMY.prepareStatement(sqlMY.toString());
					ptmMY.execute();
					connMY.commit();
					//------牧羊系统删除结束-----
					return "true";
				} catch (Exception e) {
					e.printStackTrace();
					LogBean logBean = new LogBean();
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
							.getId().toString());
					logBean
							.setBosType("");
					logBean.setEasBillID("");
					logBean.setDirection("deleteTMMY");
					logBean.setSuccess(false);
					logBean.setMsg(e.getMessage());
					EASWUtils.insertLogs(ctx, logBean);// 插入日志
					throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
				} finally {// 最终都要关闭数据库连接
					try {
						if (conn != null && !conn.isClosed()) {
							conn.close();
						}
						if(connMY!=null&&!connMY.isClosed()){
							connMY.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			 return e.getMessage();
		}
		return "true";
		
	}
/**
 * 采购订单重算过磅数据
 */
	@Override
	protected void _retryWeight(Context ctx, String PurId) throws BOSException {
		// TODO Auto-generated method stub
		String sql = "select distinct FDestObjectid purid from T_BOT_Relation where FSrcObjectID = '"+PurId+"' ";
		BigDecimal sumweight = new BigDecimal("0");
		BigDecimal sumQty = new BigDecimal("0");
		BigDecimal fprice = new BigDecimal("0");
		BigDecimal fightprice = new BigDecimal("0");
		String sqlQty = "select  t2.FQTY,t2.FPrice,t1.cffprice from T_SM_PurOrder t1 inner join T_SM_PurOrderEntry t2 on t2.FParentID = t1.FID where t1.FID = '"+PurId+"' ";

		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
			IRowSet rss = SQLExecutorFactory.getLocalInstance(ctx,sqlQty.toString()).executeSQL();
			while(rs.next()){
				String weightid = rs.getString("purid");
				//String inid = rs.getString("inid");
				
				String sqlss = "/*dialect*/ select sum(nvl(t2.CFSuttle,0)) CFSuttle  from CT_WHB_InStorageBill t1 inner join CT_WHB_InStorageBillEntry t2 on t2.FParentID = t1.FID  where t1.fid ='"+weightid+"'";
				IRowSet rsss = SQLExecutorFactory.getLocalInstance(ctx,sqlss.toString()).executeSQL();
				if(rsss.next()){
					if(rsss.getString("CFSuttle")!=null){
						sumweight = sumweight.add(new BigDecimal(rsss.getString("CFSuttle")));
					}
					
				}
			}
			while(rss.next()){
				sumQty = sumQty.add(new BigDecimal(rss.getString("FQTY")));
				fprice = fprice.add(new BigDecimal(rss.getString("FPrice")));
				fightprice = fightprice.add(new BigDecimal(rss.getString("cffprice")));
			}
			//运费
			fightprice = fightprice.multiply(sumweight).setScale(2,BigDecimal.ROUND_HALF_UP);
			fightprice = fightprice.divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
			BigDecimal diffqty = sumQty.subtract(sumweight);
			sumQty = sumQty.multiply(new BigDecimal("2"));
			sumQty = sumQty.divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
			BigDecimal shf = BigDecimal.ZERO;
			diffqty = diffqty.subtract(sumQty);
			if(diffqty.compareTo(BigDecimal.ZERO)>0){
				shf = diffqty.multiply(fprice).setScale(2,BigDecimal.ROUND_HALF_UP);
			}
			String updatesql = "update T_SM_PurOrder set CFSumWeight = '"+sumweight.toString()+"',CFkccshf='"+shf+"',cfsumkfreight ='"+fightprice+"'  where fid = '"+PurId+"'";
			CommFacadeFactory.getLocalInstance(ctx).excuteUpdateSql(updatesql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super._retryWeight(ctx, PurId);
	}
	
	

}