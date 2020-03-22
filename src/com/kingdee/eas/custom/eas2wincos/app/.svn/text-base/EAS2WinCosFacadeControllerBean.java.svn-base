package com.kingdee.eas.custom.eas2wincos.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.org.OrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.EAS2WinCosOPTypeEnum;
import com.kingdee.eas.custom.eas2wincos.EAS2WinCosSourceTypeEnum;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportBOM;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportPurInwarehouse;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportSaleIssue;
import com.kingdee.eas.custom.eas2wincos.interfaces.IExport2WinCos;
import com.kingdee.eas.custom.eas2wincos.interfaces.IImport2EAS;
import com.kingdee.eas.custom.eas2wincos.interfaces.ImportMaterialReqBill;
import com.kingdee.eas.custom.eas2wincos.interfaces.ImportProductIn;

public class EAS2WinCosFacadeControllerBean extends AbstractEAS2WinCosFacadeControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.eas2wincos.app.EAS2WinCosFacadeControllerBean");
	
	/**
	 * 导出单据到wincos
	 */
	protected String _exportBill(Context ctx, String companyNum, String jsonStr, int sourceType) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(companyNum)) {// 公司编码
			return "公司不能为空";
		}
		
		try {
			String companyID=EASWUtils.getCompanyIDByNumber(ctx, companyNum);
			JSONObject jo = new JSONObject(jsonStr);
			if (jo.isNull("opType")) {// 单据类型为空
				return null;
			}
			Integer opType=jo.getInt("opType");
			IExport2WinCos ie=null;
			switch (opType) {
			case EAS2WinCosOPTypeEnum.PURINWAREHOUSE_VALUE://导出采购入库单
				ie=new ExportPurInwarehouse();
				break;
			case EAS2WinCosOPTypeEnum.SALEISSUE_VALUE://导出销售出库单
				ie=new ExportSaleIssue();
				break;
			case EAS2WinCosOPTypeEnum.MANUFACTUREORDER_VALUE://导出生产订单
				ie=new ExportBOM();
				break;
			default:
				break;
			}
			if(sourceType==EAS2WinCosSourceTypeEnum.CLIENT_VALUE) 
				ie.export2WinCos(ctx, companyID,jo.getString("beginDate"),jo.getString("endDate"));
			else 
				ie.export2WinCos(ctx, companyID,null,null);
		} catch (Exception e) {
			logger.error(e);
			return "失败"+e.getMessage();
		}
		return "成功";
	}

	@Override
	protected String _importBill(Context ctx, String companyNum, String jsonStr, int sourceType) throws BOSException,EASBizException {
		if (StringUtils.isBlank(companyNum)) {
			return "公司不能为空";
		}
		try {
			String companyID=null;
			OrgUnitCollection org = OrgUnitFactory.getLocalInstance(ctx).getOrgUnitCollection("where number='"+companyNum+"'");
			if(org!=null&&org.size()>0) {
				companyID=org.get(0).getString("id");
			}
			JSONObject jo = new JSONObject(jsonStr);
			if (jo.isNull("opType")) {// 单据类型为空
				return null;
			}
			Integer opType=jo.getInt("opType");
			IImport2EAS ie=null;
			switch (opType) {
			case EAS2WinCosOPTypeEnum.MATERIALREQ_VALUE://导入领料出库单
				ie=new ImportMaterialReqBill();
				break;
			case EAS2WinCosOPTypeEnum.PRODUCTIN_VALUE://导入生产入库单
				ie=new ImportProductIn();
				break;
			default:
				break;
			}
			if(sourceType==EAS2WinCosSourceTypeEnum.CLIENT_VALUE) 
				ie.importBill(ctx, companyID,jo.getString("beginDate"),jo.getString("endDate"));
			else 
				ie.importBill(ctx, companyID,null,null);
		} catch (Exception e) {
			logger.error(e);
			return "失败"+e.getMessage();
		}
		return "成功";
	}

}