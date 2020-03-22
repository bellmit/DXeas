package com.kingdee.eas.custom.tocloud.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONSerializer;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.query.PropertyUnitInfo;
import com.kingdee.bos.metadata.query.QueryFieldInfo;
import com.kingdee.bos.metadata.query.QueryInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASAppException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.tocloud.BizTypeInfo;
import com.kingdee.eas.custom.tocloud.ISynDateLog;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.SynDateLogFactory;
import com.kingdee.eas.custom.tocloud.SynDateLogInfo;
import com.kingdee.eas.custom.tocloud.TargetSystemFactory;
import com.kingdee.eas.custom.tocloud.TargetSystemInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDeption;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudKeyValue;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecBean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecEntryBean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqBean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqEntryBean;
import com.kingdee.eas.custom.tocloud.bean.OtherInWarehsBillRecBean;
import com.kingdee.eas.custom.tocloud.bean.OtherInWarehsBillRecEntryBean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillBean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillEntry;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.custom.tocloud.utils.K3CloudUtil;
import com.kingdee.eas.custom.wlhllicensemanager.util.JUtils;
import com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillEntryFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillEntryInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DataSynPlateformFacadeControllerBean extends AbstractDataSynPlateformFacadeControllerBean
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2220573646144864459L;
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.tocloud.app.DataSynPlateformFacadeControllerBean");


	@Override
	protected String _login(Context ctx) throws BOSException {

		//通用保存
//		try {
//			String dataj = "{\"formId\":\"SP_InStock\",\"data\":{\"Creator\":\"\",\"Model\":{\"FID\":\"0\",\"FBillNo\":\"\",\"FStockerGroupId\":{},\"FStockerId\":{},\"FStockOrgId\":{\"FNumber\":\"ZL1\"},\"FOwnerId0\":{\"FNumber\":\"ZL1\"},\"FOwnerTypeId0\":\"BD_OwnerOrg\",\"FTransferBizTypeId\":{\"FNumber\":\"OverOrgPrdIn\"},\"FBillType\":{\"FNumber\":\"JDSCRK01_SYS\"},\"FPrdOrgId\":{\"FNumber\":\"ZL1\"},\"FDate\":\"2019-03-20\",\"F_BANZ2\":{\"FNumber\":\"01\"},\"FCurrId\":{\"FNumber\":\"PRE001\"},\"FDescription\":\"结算单同步cloud生产入库单\",\"FEntity\":[{\"FEntryID\":\"0\",\"FMaterialId\":{\"FNumber\":\"06.03.01.005\"},\"FInStockType\":\"1\",\"FUnitID\":{\"FNumber\":\"mei\"},\"FMustQty\":\"58589\",\"FRealQty\":\"58589\",\"FStockId\":{\"FNumber\":\"ZL08\"},\"FStockLocId\":{},\"FLot\":{\"FNumber\":\"姜英杰-20181211\"},\"FWorkShopId1\":{\"FNumber\":\"LK015\"},\"FShiftGroupId\":{},\"FProductNo\":\"姜英杰-20181211\",\"FIsAffectCost\":\"true\",\"FOwnerTypeId\":\"BD_OwnerOrg\",\"FOwnerId\":{\"FNumber\":\"ZL1\"},\"FStockUnitId\":{\"FNumber\":\"mei\"},\"FStockRealQty\":\"58589\",\"FBaseUnitId\":{\"FNumber\":\"mei\"},\"FExtAuxUnitId\":{},\"FBaseRealQty\":\"58589\",\"F_abc_Qty\":\"21755\",\"F_abc_Qty1\":\"2.693\",\"FStockStatusId\":{\"FNumber\":\"KCZT01_SYS\"},\"FBomId\":{},\"FBaseMustQty\":\"58589\",\"FKeeperTypeId\":\"BD_KeeperOrg\",\"FKeeperId\":{\"FNumber\":\"ZL1\"},\"FAuxpropId\":{},\"FSecUnitId\":{}}]}}}";
//		    String datas = "{\"formId\":\"SP_InStock\",\"data\":{\"Creator\":\"\",\"Model\":{\"FID\":\"0\",\"FBillNo\":\"\",\"FStockerGroupId\":{},\"FStockerId\":{},\"FStockOrgId\":{\"FNumber\":\"ZL1\"},\"FOwnerId0\":{\"FNumber\":\"ZL1\"},\"FOwnerTypeId0\":\"BD_OwnerOrg\",\"FTransferBizTypeId\":{\"FNumber\":\"OverOrgPrdIn\"},\"FBillType\":{\"FNumber\":\"JDSCRK01_SYS\"},\"FPrdOrgId\":{\"FNumber\":\"ZL1\"},\"FDate\":\"2019-01-05\",\"F_BANZ2\":{\"FNumber\":\"01\"},\"FCurrId\":{\"FNumber\":\"PRE001\"},\"FDescription\":\"结算单同步cloud生产入库单\",\"FEntity\":[{\"FEntryID\":\"0\",\"FMaterialId\":{\"FNumber\":\"06.03.01.005\"},\"FInStockType\":\"1\",\"FUnitID\":{\"FNumber\":\"mei\"},\"FMustQty\":\"19766.5\",\"FRealQty\":\"19766.5\",\"FStockId\":{\"FNumber\":\"ZL08\"},\"FStockLocId\":{},\"FLot\":{\"FNumber\":\"隋明培-20181122\"},\"FWorkShopId1\":{\"FNumber\":\"ZY003\"},\"FShiftGroupId\":{},\"FProductNo\":\"隋明培-20181122\",\"FIsAffectCost\":\"true\",\"FOwnerTypeId\":\"BD_OwnerOrg\",\"FOwnerId\":{\"FNumber\":\"ZL1\"},\"FStockUnitId\":{\"FNumber\":\"mei\"},\"FStockRealQty\":\"19766.5\",\"FBaseUnitId\":{\"FNumber\":\"mei\"},\"FExtAuxUnitId\":{},\"FBaseRealQty\":\"19766.5\",\"F_abc_Qty\":\"6426\",\"F_abc_Qty1\":\"3.076\",\"FStockStatusId\":{\"FNumber\":\"KCZT01_SYS\"},\"FBomId\":{},\"FBaseMustQty\":\"19766.5\",\"FKeeperTypeId\":\"BD_KeeperOrg\",\"FKeeperId\":{\"FNumber\":\"ZL1\"},\"FAuxpropId\":{},\"FSecUnitId\":{}}]}}}";
//			String res = K3CloudUtil.Draft(datas);
//			System.out.println(res);
//			return res;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		//生产入库单查询
//		JSONObject obj = new JSONObject();
//		obj.put("formId", "SP_InStock");
//		JSONObject dataObject = new JSONObject();
//		dataObject.put("FormId", "SP_InStock");
//		dataObject.put("FieldKeys", "FLot,FAuxpropId,FMtoNo,FStockId,FStockLocId,FBomId,FStockRealQty,FSecUnitId,FSecRealQty,FWorkShopId1,FMemo,FStockUnitId,FOwnerId,FSpecification,FInStockType,FUnitID,FIsInterLegalPerson,FMaterialId,FMaterialName,FRealQty,FBaseRealQty,FOwnerTypeId,FBaseUnitId,FMustQty,FBaseMustQty,FPrice,FExtAuxUnitQty,FJoinQty,FBASEJOINQTY,FSNQty,FIsAffectCost,FExtAuxUnitId,FSerialNo,FSerialId,FSerialNote,FSECJOINQTY,F_abc_Qty,F_abc_Qty1,FSNUnitID,FKeeperId,FProduceDate,FExpiryDate,FAmount,FStockStatusId,FKeeperTypeId,FIsPick,FProductNo,FShiftGroupId,FExpperiodUnitId,FExpperiod,FStockFlag,FStockOrgId,FPrdOrgId,FBillType,FDate,FApproveDate,FModifierId,FCreateDate,FBillNo,FDocumentStatus,FApproverId,FCanceler,FCancelStatus,FDescription,FCreatorId,FModifyDate,FCancelDate,FStockerId,FTransferBizTypeId,FStockerGroupId,FCurrId,FOwnerTypeId0,FOwnerId0");
//		dataObject.put("FilterString", "FBillNo=''");
//		dataObject.put("OrderString", "");
//		dataObject.put("TopRowCount", "0");
//		dataObject.put("StartRow", "0");
//		dataObject.put("Limit", "0");
//		obj.put("data", dataObject);
//		
//		try {
//			String res = K3CloudUtil.ExecuteBillQuery(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
//			System.out.println(res);
//			return res;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return e.getMessage();
//		}
		
		
		
		//凭证查询
		JSONObject obj = new JSONObject();
		obj.put("formId", "GL_VOUCHER");
		JSONObject dataObject = new JSONObject();
		dataObject.put("FormId", "GL_VOUCHER");
		dataObject.put("FieldKeys", "FVOUCHERGROUPNO,FBillNo");//查询字段
		dataObject.put("FilterString", "FVOUCHERID='102328'");//凭证id
//		dataObject.put("FilterString", "FBillNo='656'");
		dataObject.put("OrderString", "");
		dataObject.put("TopRowCount", "0");
		dataObject.put("StartRow", "0");
		dataObject.put("Limit", "0");
		obj.put("data", dataObject);
		
		try {
			String res = K3CloudUtil.ExecuteBillQuery(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
			System.out.println(res);
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		
		
		
		
		
		//领料出库单
//				JSONObject obj = new JSONObject();
//				obj.put("formId", "SP_PickMtrl");
//				JSONObject dataObject = new JSONObject();
//				dataObject.put("FormId", "SP_PickMtrl");
//				dataObject.put("FieldKeys", "FAmount,FMaterialId");
//				dataObject.put("FilterString", "FBillNo='JDSCLL00005417',FMaterialId='105209'"); //过滤条件是单据编码
//				dataObject.put("OrderString", "");
//				dataObject.put("TopRowCount", "0");
//				dataObject.put("StartRow", "0");
//				dataObject.put("Limit", "0");
//				obj.put("data", dataObject);
//				
//				try {
//					//		String data = "{\"formId\":\"STK_Inventory\",\"data\":{\"FormId\":\"STK_Inventory\",\"FieldKeys\":\"FMaterialId.FNumber,FMaterialId.FName,FBaseUnitId.FNumber,FBaseUnitId.FName,FBaseQty,FStockUnitId.FNumber,\",\"FilterString\":\"\",\"OrderString\":\"\",\"TopRowCount\":\"0\",\"StartRow\":\"0\",\"Limit\":\"0\"}}";
//					String res = K3CloudUtil.ExecuteBillQuery(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
//					System.out.println(res);
//					return res;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					return e.getMessage();
//				}

		//		JSONObject obj = new JSONObject();
		//		obj.put("formId", "GL_VOUCHER");
		//		JSONObject dataObject = new JSONObject();
		//		dataObject.put("CreateOrgId", "");
		//		dataObject.put("Number", "1");
		//		dataObject.put("Id", "");
		//		
		//		obj.put("data", dataObject);
		//		
		//		try {
		//			String res = K3CloudUtil.View(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
		//			System.out.println(res);
		//			return res;
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		//凭证
		//		try {
		//			String data = "{\"formId\"\":\"GL_VOUCHER\",\"data\":{\"Creator\":\"\",\"NeedUpDateFields\":[],\"NeedReturnFields\":[],\"IsDeleteEntry\":\"True\",\"SubSystemId\":\"\",\"IsVerifyBaseDataField\":\"false\",\"Model\":{\"FVOUCHERID\":\"0\",\"FAccountBookID\":{\"FNumber\":\"TYZQ\"},\"FDate\":\"2018-12-25\",\"FVOUCHERGROUPID\":{\"FNumber\":\"PRE001\"},\"FVOUCHERGROUPNO\":\"\",\"FISFOREIGNCUR\":\"false\",\"FBASECURRENCYID\":{\"FNumber\":\"PRE001\"},\"FCancleRecheck\":\"false\",\"FACCBOOKORGID\":{\"FNumber\":\"TYZQ\"},\"FIsSplit\":\"0\",\"FCashierRecheck\":\"false\",\"FAuditDate\":\"1900-01-01\",\"FDocumentStatus\":\"A\",\"FCreateDate\":\"2019-02-16\",\"FIsQty\":\"false\",\"FModifierId\":{\"FUserID\":\"0\"},\"FModifyDate\":\"2019-02-16\",\"FEntity\":[{\"FEntryID\":\"0\",\"FEXPLANATION\":\"testaa\",\"FACCOUNTID\":{\"FNumber\":\"1122.02\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"3702.02.01.01\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":\"1\",\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":\"0\",\"FQty\":\"0\",\"FAMOUNTFOR\":\"111\",\"FDEBIT\":\"111\",\"FCREDIT\":\"0\",\"FISMULTICOLLECT\":\"true\",\"FOldEntryId\":\"0\"},{\"FEntryID\":\"0\",\"FEXPLANATION\":\"testbb\",\"FACCOUNTID\":{\"FNumber\":\"6001.02.01\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"3702.02.01.01\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":\"1\",\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":\"0\",\"FQty\":\"0\",\"FAMOUNTFOR\":\"111\",\"FDEBIT\":\"0\",\"FCREDIT\":\"111\",\"FISMULTICOLLECT\":\"true\",\"FOldEntryId\":\"0\"}]}}}";
		//			String res = K3CloudUtil.Save(data);
		//			System.out.println(res);
		//			return res;
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}


		//生产退库单
		//		try {
		//			String data = "{\"formId\"\":\"SP_OUTSTOCK\",\"data\":{\"Creator\":\"\",\"NeedUpDateFields\":[],\"NeedReturnFields\":[],\"IsDeleteEntry\":\"True\",\"SubSystemId\":\"\",\"IsVerifyBaseDataField\":\"false\",\"Model\":{\"FID\":\"0\",\"FBillNo\":\"\",\"FBillType\":{\"FNumber\":\"JDSCTK01_SYS\"},\"FDate\":\"2019-02-21 00:00:00\",\"FStockOrgId\":{\"FNumber\":\"TYZQ\"},\"FBizType\":\"NORMAL\",\"FPrdOrgId\":{\"FNumber\":\"TYZQ\"},\"FStockerGroupId\":{\"FNumber\":\"\"},\"FStockerId\":{\"FNumber\":\"\"},\"FCurrId\":{\"FNumber\":\"PRE001\"},\"FOwnerTypeId0\":\"BD_OwnerOrg\",\"FOwnerId0\":{\"FNumber\":\"TYZQ\"},\"FDescription\":\"\",\"FTransferBizTypeId\":{\"FNumber\":\"OverOrgPrdOut\"},\"FScanBox\":\"\",\"FEntity\":[{\"FEntryID\":null,\"FMaterialId\":{\"FNumber\":\"06.03.01.001\"},\"FOutStockType\":\"2\",\"FUnitID\":{\"FNumber\":\"mei\"},\"FOutQty\":1000.0,\"FStockId\":{\"FNumber\":\"ZQ06\"},\"FLot\":{\"FNumber\":\"20180925\"},\"FWorkShopId1\":{\"FNumber\":\"ZQ08\"},\"FShiftGroupId\":{\"FNumber\":\"\"},\"FProductNo\":\"20180925\",\"FIsAffectCost\":true,\"FOwnerTypeId\":\"BD_OwnerOrg\",\"FOwnerId\":{\"FNumber\":\"TYZQ\"},\"FStockUnitId\":{\"FNumber\":\"mei\"},\"FStockOutQty\":1000.0,\"FBaseUnitId\":{\"FNumber\":\"mei\"},\"FBaseOutQty\":1000.0,\"FExtAuxUnitId\":{\"FNumber\":\"\"},\"FExtAuxUnitQty\":0.0,\"FMtoNo\":null,\"FStockStatusId\":{\"FNumber\":\"KCZT01_SYS\"},\"FBomId\":{\"FNumber\":\"\"},\"FProduceDate\":null,\"FExpiryDate\":null,\"FSecUnitId\":{\"FNumber\":\"\"},\"FSecOutQty\":0.0,\"FMemo\":\"\",\"FKeeperTypeId\":\"BD_KeeperOrg\",\"FKeeperId\":{\"FNumber\":\"TYZQ\"}}]}}}";
		//			String res = K3CloudUtil.Save(data);
		//			System.out.println(res);
		//			return res;
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}


		//		//凭证
		//		try {
		//			String data = "{\"formId\"\":\"GL_VOUCHER\",\"data\":{\"Creator\":\"\",\"NeedUpDateFields\":[],\"NeedReturnFields\":[],\"IsDeleteEntry\":\"True\",\"SubSystemId\":\"\",\"IsVerifyBaseDataField\":\"false\",\"Model\":{\"FVOUCHERID\":\"0\",\"FAccountBookID\":{\"FNumber\":\"TYZQ\"},\"FDate\":\"2018-12-25 00:00:00\",\"FVOUCHERGROUPID\":{\"FNumber\":\"PRE001\"},\"FVOUCHERGROUPNO\":\"4\",\"FISFOREIGNCUR\":false,\"FBASECURRENCYID\":{\"FNumber\":\"PRE001\"},\"FCancleRecheck\":false,\"FACCBOOKORGID\":{\"FNumber\":\"TYZQ\"},\"FIsSplit\":0,\"FCashierRecheck\":false,\"FAuditDate\":\"1900-01-01\",\"FDocumentStatus\":\"Z\",\"FCreateDate\":\"2019-02-26 09:48:18\",\"FIsQty\":false,\"FModifierId\":{\"FUserID\":\"\"},\"FModifyDate\":\"1900-01-01\",\"FEntity\":[{\"FEntryID\":null,\"FEXPLANATION\":\"This is a Test\",\"FACCOUNTID\":{\"FNumber\":\"1421.01.02\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":1000.0,\"FDEBIT\":1000.0,\"FCREDIT\":0.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0},{\"FEntryID\":null,\"FEXPLANATION\":null,\"FACCOUNTID\":{\"FNumber\":\"1421.02.01.01\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":100.0,\"FDEBIT\":0.0,\"FCREDIT\":100.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0},{\"FEntryID\":null,\"FEXPLANATION\":null,\"FACCOUNTID\":{\"FNumber\":\"1421.02.01.02\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":100.0,\"FDEBIT\":0.0,\"FCREDIT\":100.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0},{\"FEntryID\":null,\"FEXPLANATION\":null,\"FACCOUNTID\":{\"FNumber\":\"1421.02.01.03\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":100.0,\"FDEBIT\":0.0,\"FCREDIT\":100.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0},{\"FEntryID\":null,\"FEXPLANATION\":null,\"FACCOUNTID\":{\"FNumber\":\"1421.02.01.04\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":100.0,\"FDEBIT\":0.0,\"FCREDIT\":100.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0},{\"FEntryID\":null,\"FEXPLANATION\":null,\"FACCOUNTID\":{\"FNumber\":\"1421.02.01.05\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":100.0,\"FDEBIT\":0.0,\"FCREDIT\":100.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0},{\"FEntryID\":null,\"FEXPLANATION\":null,\"FACCOUNTID\":{\"FNumber\":\"1421.02.01.06\"},\"FDetailID\":{\"FDETAILID__FF100002\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100003\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX10\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100004\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX11\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100005\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX4\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100006\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX5\":{\"FNUMBER\":\"ZQ08\"},\"FDETAILID__FF100007\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX6\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100008\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX7\":{\"FSTAFFNUMBER\":\"\"},\"FDETAILID__FF100009\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX8\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100010\":{\"FNUMBER\":\"\"},\"FDETAILID__FFLEX9\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100011\":{\"FNUMBER\":\"\"},\"FDETAILID__FF100012\":{\"FNUMBER\":\"\"}},\"FCURRENCYID\":{\"FNumber\":\"PRE001\"},\"FEXCHANGERATETYPE\":{\"FNumber\":\"HLTX01_SYS\"},\"FEXCHANGERATE\":1.0,\"FUnitId\":{\"FNumber\":\"\"},\"FPrice\":0.0,\"FQty\":0.0,\"FAMOUNTFOR\":500.0,\"FDEBIT\":0.0,\"FCREDIT\":500.0,\"FISMULTICOLLECT\":true,\"FOldEntryId\":0}]}}}";
		//			String res = K3CloudUtil.Save(data);
		//			System.out.println(res);
		//			return res;
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		//cloud的销售出库单
//				try {
//				String date = "{\"formId\":\"SAL_OUTSTOCK\",\"data\":{\"Creator\":\"\",\"Model\":{\"FID\":\"0\",\"FBillTypeID\":{\"FNumber\":\"XSCKD01_SYS\"},\"FBillNo\":\"\",\"FDate\":\"2019-03-06\",\"FSaleOrgId\":{\"FNumber\":\"ZL1\"},\"FSaleDeptID\":{\"FNumber\":\"\"},\"FCustomerID\":{\"FNumber\":\"3706.01.01.01\"},\"FHeadLocationId\":{\"FNUMBER\":\"\"},\"FCorrespondOrgId\":{\"FNumber\":\"\"},\"FCarrierID\":{\"FNumber\":\"\"},\"FCarriageNO\":\"\",\"FSalesGroupID\":{\"FNumber\":\"\"},\"FSalesManID\":{\"FNumber\":\"\"},\"FStockOrgId\":{\"FNumber\":\"ZL1\"},\"FDeliveryDeptID\":{\"FNumber\":\"\"},\"FStockerGroupID\":{\"FNumber\":\"\"},\"FStockerID\":{\"FNumber\":\"\"},\"FNote\":\"\",\"FReceiverID\":{\"FNumber\":\"3706.01.01.01\"},\"FReceiveAddress\":\"\",\"FSettleID\":{\"FNumber\":\"3706.01.01.01\"},\"FReceiverContactID\":{\"FName\":\"\"},\"FPayerID\":{\"FNumber\":\"3706.01.01.01\"},\"FOwnerTypeIdHead\":\"BD_OwnerOrg\",\"FOwnerIdHead\":{\"FNumber\":\"\"},\"FScanBox\":\"\",\"FCDateOffsetUnit\":\"\",\"FCDateOffsetValue\":\"0\",\"FPlanRecAddress\":\"\",\"F_abc_Text\":\"\",\"FIsTotalServiceOrCost\":\"false\",\"F_abc_Text1\":\"\",\"F_abc_Text2\":\"\",\"SubHeadEntity\":{\"FSettleCurrID\":{\"FNumber\":\"PRE001\"},\"FSettleOrgID\":{\"FNumber\":\"ZL1\"},\"FSettleTypeID\":{\"FNumber\":\"\"},\"FReceiptConditionID\":{\"FNumber\":\"\"},\"FPriceListId\":{\"FNumber\":\"\"},\"FDiscountListId\":{\"FNumber\":\"\"},\"FIsIncludedTax\":\"true\",\"FLocalCurrID\":{\"FNumber\":\"PRE001\"},\"FExchangeTypeID\":{\"FNumber\":\"HLTX01_SYS\"},\"FExchangeRate\":\"1\"},\"FEntity\":[{\"FENTRYID\":null,\"FCustMatID\":{\"FNumber\":\"\"},\"FMaterialID\":{\"FNumber\":\"06.03.01.008\"},\"FUnitID\":{\"FNumber\":\"yu\"},\"FInventoryQty\":\"\",\"FRealQty\":\"135\",\"FPrice\":\"\",\"FTaxPrice\":\"\",\"FIsFree\":\"false\",\"FBomID\":{\"FNumber\":\"\"},\"FProduceDate\":\"\",\"FOwnerTypeID\":\"BD_OwnerOrg\",\"FOwnerID\":{\"FNumber\":\"ZL1\"},\"FLot\":{\"FNumber\":\"\"},\"FExpiryDate\":\"\",\"FTaxCombination\":{\"FNumber\":\"\"},\"FEntryTaxRate\":0.0,\"FAuxUnitQty\":\"\",\"FExtAuxUnitId\":{\"FNumber\":\"\"},\"FExtAuxUnitQty\":\"\",\"FStockID\":{\"FNumber\":\"ZL01\"},\"FStockStatusID\":{\"FNumber\":\"KCZT01_SYS\"},\"FQualifyType\":\"\",\"FMtoNo\":null,\"FEntrynote\":null,\"FDiscountRate\":0.0,\"FActQty\":0.0,\"FSalUnitID\":{\"FNumber\":\"kg\"},\"FSALUNITQTY\":243.0,\"FSALBASEQTY\":243.0,\"FPRICEBASEQTY\":243.0,\"FProjectNo\":null,\"FOUTCONTROL\":false,\"FRepairQty\":0.0,\"FIsCreateProDoc\":\"\",\"FEOwnerSupplierId\":{\"FNumber\":\"\"},\"FIsOverLegalOrg\":false,\"FESettleCustomerId\":{\"FNumber\":\"\"},\"FPriceListEntry\":{\"FNumber\":\"\"},\"FARNOTJOINQTY\":243.0,\"FQmEntryID\":0,\"FSOEntryId\":0,\"FConvertEntryID\":0,\"F_abc_Qty\":100.0,\"F_abc_Qty1\":2.5}]}}}";
//				String data = "{\"formId\":\"SAL_OUTSTOCK\",\"data\":{\"Creator\":\"\",\"Model\":{\"FID\":\"0\",\"FBillTypeID\":{\"FNumber\":\"XSCKD01_SYS\"},\"FBillNo\":\"\",\"FDate\":\"2019-02-27\",\"FSaleOrgId\":{\"FNumber\":\"ZL1\"},\"FSaleDeptID\":{\"FNumber\":\"\"},\"FCustomerID\":{\"FNumber\":\"3706.01.01.01\"},\"FHeadLocationId\":{\"FNumber\":\"\"},\"FCorrespondOrgId\":{\"FNumber\":\"\"},\"FCarrierID\":{\"FNumber\":\"\"},\"FCarriageNO\":\"\",\"FSalesGroupID\":{\"FNumber\":\"\"},\"FSalesManID\":{\"FNumber\":\"\"},\"FStockOrgId\":{\"FNumber\":\"ZL1\"},\"FDeliveryDeptID\":{\"FNumber\":\"\"},\"FStockerGroupID\":{\"FNumber\":\"\"},\"FStockerID\":{\"FNumber\":\"\"},\"FNote\":\"\",\"FReceiverID\":{\"FNumber\":\"3706.01.01.01\"},\"FReceiveAddress\":\"\",\"FSettleID\":{\"FNumber\":\"3706.01.01.01\"},\"FReceiverContactID\":{\"FName\":\"\"},\"FPayerID\":{\"FNumber\":\"3706.01.01.01\"},\"FOwnerTypeIdHead\":\"BD_OwnerOrg\",\"FOwnerIdHead\":{\"FNumber\":\"\"},\"FScanBox\":\"\",\"FCDateOffsetUnit\":\"\",\"FCDateOffsetValue\":\"0\",\"FPlanRecAddress\":\"\",\"F_abc_Text\":\"\",\"FIsTotalServiceOrCost\":\"false\",\"F_abc_Text1\":\"\",\"F_abc_Text2\":\"\",\"SubHeadEntity\":{\"FSettleCurrID\":{\"FNumber\":\"PRE001\"},\"FSettleOrgID\":{\"FNumber\":\"ZL1\"},\"FSettleTypeID\":{\"FNumber\":\"\"},\"FReceiptConditionID\":{\"FNumber\":\"\"},\"FPriceListId\":{\"FNumber\":\"\"},\"FDiscountListId\":{\"FNumber\":\"\"},\"FIsIncludedTax\":\"true\",\"FLocalCurrID\":{\"FNumber\":\"PRE001\"},\"FExchangeTypeID\":{\"FNumber\":\"HLTX01_SYS\"},\"FExchangeRate\":\"1\"},\"FEntity\":[{\"FENTRYID\":null,\"FCustMatID\":{\"FNumber\":\"\"},\"FMaterialID\":{\"FNumber\":\"06.03.01.008\"},\"FUnitID\":{\"FNumber\":\"yu\"},\"FInventoryQty\":\"\",\"FRealQty\":\"135\",\"FPrice\":\"\",\"FTaxPrice\":\"\",\"FIsFree\":\"false\",\"FBomID\":{\"FNumber\":\"\"},\"FProduceDate\":\"\",\"FOwnerTypeID\":\"BD_OwnerOrg\",\"FOwnerID\":{\"FNumber\":\"ZL1\"},\"FLot\":{\"FNumber\":\"\"},\"FExpiryDate\":\"\",\"FTaxCombination\":{\"FNumber\":\"\"},\"FEntryTaxRate\":0.0,\"FAuxUnitQty\":\"\",\"FExtAuxUnitId\":{\"FNumber\":\"\"},\"FExtAuxUnitQty\":\"\",\"FStockID\":{\"FNumber\":\"ZL01\"},\"FStockStatusID\":{\"FNumber\":\"KCZT01_SYS\"},\"FQualifyType\":\"\",\"FMtoNo\":\"\",\"FDiscountRate\":\"0\",\"FActQty\":\"\",\"FSalUnitID\":{\"FNumber\":\"kg\"},\"FSALUNITQTY\":\"135\",\"FSALBASEQTY\":\"135\",\"FPRICEBASEQTY\":\"135\",\"FProjectNo\":\"\",\"FOUTCONTROL\":\"false\",\"FRepairQty\":\"0\",\"FIsCreateProDoc\":\"\",\"FEOwnerSupplierId\":{\"FNumber\":\"\"},\"FIsOverLegalOrg\":\"false\",\"FESettleCustomerId\":{\"FNumber\":\"\"},\"FPriceListEntry\":{\"FNumber\":\"\"},\"FARNOTJOINQTY\":\"135\",\"FQmEntryID\":\"\",\"FSOEntryId\":\"\",\"FConvertEntryID\":\"\",\"F_abc_Qty\":\"127\",\"F_abc_Qty1\":\"2.5\"}]}}}";
//				String res = K3CloudUtil.Save(data);
//				System.out.println(res);
//				return res;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				return null;

		//部门
//				try {
//					String data = "{\"formId\":\"BD_Department\", \"data\":{\"Creator\":\"\",\"NeedUpDateFields\":[],\"NeedReturnFields\":[],\"IsDeleteEntry\":\"True\",\"SubSystemId\":\"\",\"IsVerifyBaseDataField\":\"false\",\"Model\":{\"FDEPTID\":\"0\",\"FCreateOrgId\":{\"FNumber\":\"ZL1\"},\"FNumber\":\"123124\",\"FUseOrgId\":{\"FNumber\":\"ZL1\"},\"FName\":\"王正志\",\"FHelpCode\":\"\",\"FParentID\":{\"FNumber\":\"\"},\"FFullName\":\"\",\"FEffectDate\":\"2019-02-28 00:00:00\",\"FLapseDate\":\"9999-12-31 00:00:00\",\"FDeptProperty\":{\"FNumber\":\"DP01_SYS\"},\"FDescription\":\"\",\"FGroup\":{\"FNumber\":\"\"},\"FIsCopyFlush\":false}}}";
//					String res = K3CloudUtil.Save(data);
//					System.out.println(res);
//					return res;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

		//销售出库单查询
		//		JSONObject obj = new JSONObject();
		//		obj.put("formId", "SAL_OUTSTOCK");//
		//		JSONObject dataObject = new JSONObject();
		//		dataObject.put("FormId", "SAL_OUTSTOCK");
		//		dataObject.put("FieldKeys", "F_abc_Qty,F_abc_Qty1");
		//		dataObject.put("FilterString", "FBillNo='XSCKD000002'"); //过滤条件是单据编码
		//		dataObject.put("OrderString", "");
		//		dataObject.put("TopRowCount", "0");
		//		dataObject.put("StartRow", "0");
		//		dataObject.put("Limit", "0");
		//		obj.put("data", dataObject);
		//		
		//		try {
		//			//		String data = "{\"formId\":\"STK_Inventory\",\"data\":{\"FormId\":\"STK_Inventory\",\"FieldKeys\":\"FMaterialId.FNumber,FMaterialId.FName,FBaseUnitId.FNumber,FBaseUnitId.FName,FBaseQty,FStockUnitId.FNumber,\",\"FilterString\":\"\",\"OrderString\":\"\",\"TopRowCount\":\"0\",\"StartRow\":\"0\",\"Limit\":\"0\"}}";
		//			String res = K3CloudUtil.ExecuteBillQuery(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
		//			System.out.println(res);
		//			return res;
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//			return e.getMessage();
		//		}



		//生产退料单测试数据
//		try {
//			String data = "{\"formId\"\":\"SP_ReturnMtrl\",\"data\":{\"Creator\":\"\",\"NeedUpDateFields\":[],\"NeedReturnFields\":[],\"IsDeleteEntry\":\"True\",\"SubSystemId\":\"\",\"IsVerifyBaseDataField\":\"false\",\"Model\":{\"FID\":\"0\",\"FBillNo\":\"\",\"FBillType\":{\"FNumber\":\"JDSCTL01_SYS\"},\"FDate\":\"2019-03-05 00:00:00\",\"FDescription\":\"\",\"FStockOrgId\":{\"FNumber\":\"ZL1\"},\"FStockerGroupId\":{\"FNumber\":\"\"},\"FStockerId\":{\"FNumber\":\"\"},\"FReturnerId\":{\"FStaffNumber\":\"\"},\"FCurrId\":{\"FNumber\":\"PRE001\"},\"FOwnerTypeId0\":\"BD_OwnerOrg\",\"FOwnerId0\":{\"FNumber\":\"ZL1\"},\"FPrdOrgId\":{\"FNumber\":\"ZL1\"},\"FWorkShopId\":{\"FNumber\":\"ZY015\"},\"FPloidyQty\":0.0,\"FTransferBizTypeId\":{\"FNumber\":\"OverOrgPick\"},\"FScanBox\":\"\",\"FBizType\":\"NORMAL\",\"FEntity\":[{\"FEntryID\":null,\"FMaterialId\":{\"FNumber\":\"01.01.01.01.005\"},\"FUnitID\":{\"FNumber\":\"kg\"},\"FAPPQty\":100.0,\"FQty\":100.0,\"FReturnType\":\"1\",\"FReturnReason\":{\"FNumber\":\"\"},\"FStockId\":{\"FNumber\":\"ZL01\"},\"FLot\":{\"FNumber\":\"\"},\"FProductId\":{\"FNumber\":\"\"},\"FProductNo\":null,\"FIsAffectCost\":false,\"FPRODUCTGROUPID\":{\"FNumber\":\"\"},\"FMtoNo\":null,\"FStockUnitId\":{\"FNumber\":\"UOM001\"},\"FStockQty\":3.0,\"FPrice\":0.0,\"FAmount\":0.0,\"FBaseUnitId\":{\"FNumber\":\"kg\"},\"FBaseAppQty\":100.0,\"FBaseQty\":100.0,\"FOwnerTypeId\":\"BD_OwnerOrg\",\"FExtAuxUnitId\":{\"FNumber\":\"\"},\"FOwnerId\":{\"FNumber\":\"ZL1\"},\"FExtAuxUnitQty\":0.0,\"FParentOwnerTypeId\":\"BD_OwnerOrg\",\"FParentOwnerId\":{\"FNumber\":\"ZL1\"},\"FBomId\":{\"FNumber\":\"\"},\"FKeeperTypeId\":\"BD_KeeperOrg\",\"FKeeperId\":{\"FNumber\":\"ZL1\"},\"FEntrtyMemo\":\"\",\"FStockStatusId\":{\"FNumber\":\"KCZT01_SYS\"},\"FProduceDate\":null,\"FExpiryDate\":null,\"FSecUnitId\":{\"FNumber\":\"\"},\"FSecStockQty\":0.0}]}}}";
//			String res = K3CloudUtil.Save(data);
//			System.out.println(res);
//			return res;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//		return null;


		//即时库存查询
//		JSONObject obj = new JSONObject();
//		obj.put("formId", "STK_Inventory");
//		JSONObject dataObject = new JSONObject();
//		dataObject.put("FormId", "STK_Inventory");
//		dataObject.put("FieldKeys", "FQty,FProduceDate,FExpiryDate");
//		dataObject.put("FilterString", "FMaterialId.FNumber='02.01.07.032' and  FStockId.FNumber='ZL04'");
//		dataObject.put("OrderString", "FProduceDate");
//		dataObject.put("TopRowCount", "0");
//		dataObject.put("StartRow", "0");
//		dataObject.put("Limit", "0");
//		obj.put("data", dataObject);
//		try {
//			String res = K3CloudUtil.ExecuteBillQuery(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;





	}

	@Override
	protected String _getBillHeader(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject jsonObj = JSONObject.parseObject(param);
		return UIRuleUtil.getString(getBillListHeader(ctx, JUtils.getString(jsonObj, "bosType"), JUtils.getString(jsonObj, "queryInfo"), JUtils.getBoolean(jsonObj, "isReplaceSplit")));
	}

	@Override
	protected String _getBillList(Context ctx, String param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject jsonObj = JSONObject.parseObject(param); 
		return UIRuleUtil.getString(getBillList(ctx,JUtils.getString(jsonObj, "bosType"),JUtils.getString(jsonObj, "queryInfo"),JUtils.getString(jsonObj, "queryStr"),0,Integer.MAX_VALUE,false,false,null));
	}

	public  JSONArray getBillList(Context ctx, String bosType,
			String queryInfo, String queryStr, int beginRow, int length,
			boolean isReplaceSplit, boolean isShowHeader, String[] queryCols) throws BOSException {

		SimpleDateFormat sdf = new SimpleDateFormat();

		if(StringUtils.isEmpty(queryStr)) {
			try {
				throw new BOSException("过滤条件不能为空！");
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(StringUtils.isEmpty(queryInfo)) {
			EntityObjectInfo eo = getEntityObject(ctx, bosType);
			queryInfo = eo.getExtendedProperty("defaultF7Query");
		}
		JSONArray ja=new JSONArray();

		if(isShowHeader) {
			ja.add(getBillListHeader(ctx, bosType, queryInfo,isReplaceSplit));
		}

		if(StringUtils.isNotEmpty(queryInfo)) {
			IMetaDataPK pk=new MetaDataPK(queryInfo);
			if(beginRow == 0&&length == 0) {
				beginRow=0;
				length=500;
			}

			IQueryExecutor iexec = QueryExecutorFactory.getLocalInstance(ctx, pk);

			try {
				//过滤条件
				iexec.setObjectView(queryStr);
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			iexec.option().isAutoTranslateBoolean = true;
			iexec.option().isAutoTranslateEnum = true;
			iexec.option().isIgnoreOrder=true;
			iexec.option().topCount = 100000;
			iexec.option().isIgnoreRowCount = true;
			iexec.option().isIgnoreBillCount=true;
			iexec.option().isIgnorePermissionCheck = true;

			//虚模式,8.0显示100条，8.2限制500条
			Map execMap = null;
			try {
				execMap = iexec.doAllQueryTask(iexec.openQuery(), beginRow, length, null, true);
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new BOSException(e1.getMessage());
			}
			IRowSet rs  = (IRowSet)execMap.get("rowSet");
			//			//iexec.releaseQueryCache(iexec.openQuery());
			//实模式 没有数量限制
			//			IRowSet rs=iexec.executeQueryForRealPage(beginRow, length);
			int size = 0;
			IRowSet rsA = null;

			try {
				rsA = DbUtil.executeQuery(ctx, "SELECT　count(*)  count  " +iexec.getSQL().substring(iexec.getSQL().indexOf("FROM "),iexec.getSQL().indexOf("ORDER BY ") != -1 ?iexec.getSQL().indexOf("ORDER BY "):iexec.getSQL().length()));
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(rsA.next()){
					size = UIRuleUtil.getIntValue(rsA.getString("count"));
				}
				if(rsA != null){
					rsA.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//			System.out.println("#############"+rs.size());
			JSONObject jo;
			Object obj;
			try {
				while(rs.next()) {
					jo = new JSONObject();
					jo.put("count", size);
					//设置值
					if(queryCols!=null && queryCols.length>0) {
						for(String s:queryCols) {
							if(isReplaceSplit){
								s=s.replaceAll("\\.","_");
							}
							jo.put(s,String.valueOf(rs.getObject(s)));
						}
					}else {
						String s;
						for(int colIndex=1;colIndex<=rs.getMetaData().getColumnCount();colIndex++) {
							obj=rs.getObject(colIndex);//字段值
							if(obj instanceof Date&&obj!=null) {
								obj=sdf.format(rs.getObject(colIndex));
							}//字段名称
							s=rs.getMetaData().getColumnName(colIndex);
							if(isReplaceSplit){
								s=s.replaceAll("\\.","_");
							}
							jo.put(s,UIRuleUtil.getString(obj));
						}
					}
					ja.add(jo);
				}
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}
		return ja;


	}


	private JSONArray getBillListHeader(Context ctx, String bosType,
			String queryInfo, boolean isReplaceSplit) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(queryInfo)) {
			EntityObjectInfo eo = getEntityObject(ctx, bosType);
			queryInfo = eo.getExtendedProperty("defaultF7Query");
		}
		IMetaDataPK pk = new MetaDataPK(queryInfo);
		QueryInfo qi = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx).getQuery(pk);
		JSONObject jo = new JSONObject();
		Iterator itr = qi.getUnits().iterator();
		PropertyUnitInfo pInfo;
		String name;
		JSONArray array = new JSONArray();

		JSONObject tempJO = null;

		while(itr.hasNext()){
			pInfo = (PropertyUnitInfo) itr.next();
			name = pInfo.getName();

			if(!(pInfo instanceof QueryFieldInfo)) {
				continue;
			}

			if(isReplaceSplit){
				name = name.replaceAll("\\.","_");
			}

			tempJO = new JSONObject();
			try {
				tempJO.put("name", name);
				tempJO.put("returnType", pInfo.getReturnType() == null ? "" : pInfo.getReturnType().getAlias());
				tempJO.put("displayName", pInfo.getDisplayName());
				tempJO.put("isVisible", pInfo.isIsSelector());
				array.add(tempJO);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return array;




	}

	private EntityObjectInfo getEntityObject(Context ctx, String bosType) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 同步数据到cloud
	 * @jsonParam--json字符串
	 * 键--分录id
	 * 值--分录对应表头的id
	 * 返回值可以是导入的结果如：成功，失败原因
	 */
	@Override
	protected String _synData(Context ctx, String jsonParam)
	throws BOSException, EASAppException {
		// TODO Auto-generated method stub

		//json字符串转化为json对象
		JSONObject jsonObject = JSONObject.parseObject(jsonParam);
		String entryid = jsonObject.getString("entryid");
		String billid = jsonObject.getString("billid");
		String targetSysid = jsonObject.getString("targetSysid");
		String bizTypeid = jsonObject.getString("bizTypeid");
		String	result = null;
		//获取目标系统编码
		TargetSystemInfo targetSysInfo = null;
		//获取业务类型的编码
		BizTypeInfo bizTypeInfo = null;
		try {
			targetSysInfo = TargetSystemFactory.getLocalInstance(ctx).getTargetSystemInfo(new ObjectUuidPK(targetSysid));
			bizTypeInfo = com.kingdee.eas.custom.tocloud.BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK(bizTypeid));
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//数据同步平台分录
		SynDateLogEntryInfo synDateLogEntryInfo = new SynDateLogEntryInfo();
		List<String> errorMessage = new ArrayList<String>();

		ISynData iSynData = null;
		String res = null;
		try {
			//classname 放到业务类型 加一个实现类字段配置
			Class iSynDataClass = Class.forName(bizTypeInfo.getImplClass());
			iSynData = (ISynData) iSynDataClass.newInstance();
			result = iSynData.synData(ctx, billid, entryid, targetSysid, bizTypeid,errorMessage,synDateLogEntryInfo);
			res = K3CloudUtil.Save(result);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e.getMessage());
		}
		return res;
	}
}