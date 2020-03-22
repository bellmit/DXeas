package com.kingdee.eas.custom.festival.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ar.OtherBillCollection;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.customize.storeage.IMaterialReqBillExtendFacade;
import com.kingdee.eas.scm.customize.storeage.MaterialReqBillExtendFacadeFactory;
import com.kingdee.eas.scm.im.inv.IMaterialReqBill;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillCollection;
import com.kingdee.eas.scm.im.inv.MaterialReqBillEntryCollection;
import com.kingdee.eas.scm.im.inv.MaterialReqBillEntryInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.ws.util.ErrorCodeUtil;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.scm.im.inv.ws.util.XMLUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.ejb.*;
import java.rmi.RemoteException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.custom.festival.Constant.MaterialReqConstant;
import com.kingdee.eas.scm.im.inv.ws.ImportException;

import java.lang.String;

public class MaterialReqBillFacadeControllerBean extends AbstractMaterialReqBillFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.festival.app.MaterialReqBillFacadeControllerBean");

	@SuppressWarnings("unchecked")
	protected String[] _importData(Context ctx, String xmlData) throws BOSException
	{
		String[] msg = new String[2];
		ImportException excep;     try
		{
			Document doc = XMLUtil.builderDocument(xmlData);
			if (doc != null)
			{
				Element rootElement = doc.getDocumentElement();
				if (!(rootElement.getTagName().equals("MaterialReqBill"))) {
					throw new ImportException(ImportException.BILLXMLFORMATEXCEPTION);
				}
				MaterialReqBillInfo materialReqBillInfo = new MaterialReqBillInfo();
				HashMap billHeadMap = XMLUtil.getBillHead(doc);
				if (billHeadMap == null) {
					throw new ImportException(ImportException.XMLBILHEADEXCEPTION);
				}
				ArrayList billEntriesList = XMLUtil.getBillEntries(doc);
				if (billEntriesList == null) {
					throw new ImportException(ImportException.XMLBUILDENTRYEXCEPTION);
				}

				validateProperty(billHeadMap, billEntriesList);
				CtrlUnitInfo cuInfo = InfoUtil.getCtrolUnitInfo(ctx, (String)billHeadMap.get("CU"));
				if (cuInfo == null) {
					throw new ImportException(ImportException.CUEXCEPTION);
				}
				ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);
				buildBillHead(ctx, materialReqBillInfo, billHeadMap, cuInfo.getId().toString());
				if(!StringUtils.isEmpty(materialReqBillInfo.getNumber())){
					MaterialReqBillCollection coll = MaterialReqBillFactory.getLocalInstance(ctx).getMaterialReqBillCollection("where number='"+materialReqBillInfo.getNumber()+"'");
					if(coll.size()>0){
						return new String[] {"N","number","head","编码重复"};
					}
				}

				builBillEntries(ctx, materialReqBillInfo, billEntriesList, null,cuInfo.getId().toString());

				IMaterialReqBillExtendFacade extend = MaterialReqBillExtendFacadeFactory.getLocalInstance(ctx);
				extend.handleExtendField(materialReqBillInfo, xmlData);
				ctx.put("disablePermissionForKScript", Boolean.TRUE);

				IMaterialReqBill iMaterialReqBill = MaterialReqBillFactory.getLocalInstance(ctx);

				IObjectPK pk = null;
				if ((rootElement.getAttribute("isSubmit") != null) && (rootElement.getAttribute("isSubmit").equalsIgnoreCase("true")))
					pk = iMaterialReqBill.submit(materialReqBillInfo);
				else {
					pk = iMaterialReqBill.save(materialReqBillInfo);
				}
//				if(pk != null){
//					DbUtil.execute(ctx,WsUtil.getUpSql("T_IM_MaterialReqBill", pk.toString(), "oaoqwFhdTmS5kKApNL2h0hO33n8="));
//				}


				msg[0] = "0";
				msg[1] = EASResource.getString("com.kingdee.eas.scm.im.inv.ws.WebserviceResource", "IMPORTSUCCESSMSG");
			}
		}
		catch (EASBizException e)
		{
			msg[0] = e.getCode();
			msg[1] = e.getMessage();
			logger.error(e);
		}
		catch (SAXException e) {
			excep = new ImportException(ImportException.PRASERXMLEXCEPTION);
			msg[0] = excep.getCode();
			msg[1] = excep.getMessage();
			logger.error(excep);
		} catch (IOException e) {
			excep = new ImportException(ImportException.READXMLIOEXCEPTION);
			msg[0] = excep.getCode();
			msg[1] = excep.getMessage();
		} catch (ParserConfigurationException e) {
			excep = new ImportException(ImportException.CONVERFORMATEXCEPTION);
			msg[0] = excep.getCode();
			msg[1] = excep.getMessage();
			logger.error(excep);
		} catch (TransformerException e) {
			excep = new ImportException(ImportException.WRITERXMLEXCEPTION);
			msg[0] = excep.getCode();
			msg[1] = excep.getMessage();
			logger.error(excep);
		} catch (BOSException e) {
			excep = new ImportException(new NumericExceptionSubItem("bosException", e.getMessage()));
			msg[0] = excep.getCode();
			msg[1] = excep.getMessage();
			logger.error(excep);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}








	private void validateProperty(HashMap billHeadMap, ArrayList billEntriesList)
	throws EASBizException
	{
		String[] bilHeadProps = MaterialReqConstant.getMustValidateHeadProperties();
		HashMap errorMap = ErrorCodeUtil.getHeadErrorMap();

		for (int i = 0; i < bilHeadProps.length; ++i) {
			if (!(InfoUtil.validateProperty(billHeadMap, bilHeadProps[i]))) {
				NumericExceptionSubItem numberExc = (NumericExceptionSubItem)errorMap.get(bilHeadProps[i]);
				if (numberExc == null) {
					numberExc = new NumericExceptionSubItem(bilHeadProps[i], bilHeadProps[i] + " must fill!!");
				}
				throw new ImportException(numberExc);
			}

		}

		HashMap entryMap = null;

		errorMap = ErrorCodeUtil.getEntryErrorMap();
		String[] bilEntriesProps = MaterialReqConstant.getMustValidateEntryProperties();
		for (int i = 0; i < billEntriesList.size(); ++i) {
			entryMap = (HashMap)billEntriesList.get(i);
			for (int j = 0; j < bilEntriesProps.length; ++j) {
				if (InfoUtil.validateProperty(entryMap, bilEntriesProps[j]))
					continue;
				NumericExceptionSubItem numberExc = (NumericExceptionSubItem)errorMap.get(bilEntriesProps[j]);
				if (numberExc == null) {
					numberExc = new NumericExceptionSubItem(bilEntriesProps[j], bilEntriesProps[j] + " must fill!!");
				}
				throw new ImportException(numberExc);
			}
		}
	}










	private void buildBillHead(Context ctx, MaterialReqBillInfo info, HashMap billHeadMap, String cuId)
	throws EASBizException
	{
		setStrProperties(info, billHeadMap, true);

		setBooleanProperties(info, billHeadMap, true);

		setIntProperties(info, billHeadMap, true);

		setDeciamlProperties(info, billHeadMap, true);

		seTimeStampProperties(info, billHeadMap, true);

		setDateProperties(info, billHeadMap, true);

		setLinkProperties(ctx, info, billHeadMap, cuId, true);
		if(info.getSupplyStoreOrgUnit()==null){
			info.setSupplyStoreOrgUnit(info.getStorageOrgUnit());
		}
		if(info.getSupplyCompanyOrgUnit()==null){
			info.setSupplyCompanyOrgUnit(info.getDemandCompanyOrgUnit());
		}
	}








	private void builBillEntries(Context ctx, MaterialReqBillInfo info, ArrayList entriesList, String cuID,String  cuIDA)
	throws EASBizException, BOSException, SQLException
	{
		if (entriesList == null) {
			return;
		}
		for (int i = 0; i < entriesList.size(); ++i) {
			HashMap entryMap = (HashMap)entriesList.get(i);
			MaterialReqBillEntryInfo entryInfo = new MaterialReqBillEntryInfo();

			setStrProperties(entryInfo, entryMap, false);

			setBooleanProperties(entryInfo, entryMap, false);

			setIntProperties(entryInfo, entryMap, false);

			setDeciamlProperties(entryInfo, entryMap, false);

			seTimeStampProperties(entryInfo, entryMap, false);

			setDateProperties(entryInfo, entryMap, false);

			setLinkProperties(ctx, entryInfo, entryMap, cuID, false);
			if(entryInfo.getCostCenterOrgUnit()==null){
				entryInfo.setCostCenterOrgUnit(info.getCostCenterOrgUnit());
			}
			if(entryInfo.getSupplyWarehouse()==null){
				entryInfo.setSupplyWarehouse(entryInfo.getWarehouse());
			}
			logger.error("领料出库单开始");
			if(entryInfo.getCostObject()!= null){
				logger.error("成本对象IdA:"+entryInfo.getCostObject().getId());
				StringBuffer sql=new StringBuffer();
				sql.append(" select fid from t_bd_costobject  ");
				sql.append(" where fcompanyid='"+cuIDA+"' and fnumber=(select fnumber from t_bd_costobject where fid='"+entryInfo.getCostObject().getId().toString()+"' )");
				logger.error("领料出库单Asql:"+sql.toString());
				IRowSet rs=DbUtil.executeQuery(ctx,sql.toString());
				if(rs.next()){
					ObjectUuidPK pk=new ObjectUuidPK(rs.getString("fid"));
					CostObjectInfo costobject=CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(pk);
					entryInfo.setCostObject(costobject);
					logger.error("成本对象IdB:"+pk.toString());
				}else{
					entryInfo.setCostObject(null);
				}
			}
			if(entryInfo.getMaterial()!=null && entryInfo.getCostObject() == null){
				StringBuffer sql=new StringBuffer();
				sql.append(" select fid from t_bd_costobject where FSTDPRODUCTIDID='"+entryInfo.getMaterial().getId().toString()+"' ");
				sql.append(" and fcompanyid='"+cuIDA+"' ");
				logger.error("领料出库单Bsql:"+sql.toString());
				IRowSet rs=DbUtil.executeQuery(ctx,sql.toString());
				if(rs.next()){
					ObjectUuidPK pk=new ObjectUuidPK(rs.getString("fid"));
					CostObjectInfo costobject=CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(pk);
					entryInfo.setCostObject(costobject);
					logger.error("成本对象IdC:"+pk.toString());
				}
			}
			entryInfo.setParent(info);
			info.getEntry().add(entryInfo);
		}
	}








	private void setStrProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	{
		String[] strProperties = null;
		if (isBillHead)
			strProperties = MaterialReqConstant.getHeadStrProperties();
		else
			strProperties = MaterialReqConstant.getEntryStrProperties();
		for (int i = 0; i < strProperties.length; ++i)
			info.setString(strProperties[i], (String)billHeadMap.get(strProperties[i]));
	}








	private void setBooleanProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] booleanProperties = null;
		HashMap erroMap = null;

		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			booleanProperties = MaterialReqConstant.getHeadBooleanProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			booleanProperties = MaterialReqConstant.getEntryBooleanProperties();
		}
		try {
			boolean boolValue = false;
			String propValue = null;
			for (int i = 0; i < booleanProperties.length; ++i) {
				propertyName = booleanProperties[i];
				propValue = (String)billHeadMap.get(propertyName);
				if ((propValue != null) && (((propValue.equals("1")) || (propValue.equals("true")))))
					boolValue = true;
				else {
					boolValue = false;
				}
				info.setBoolean(propertyName, boolValue);
			}
		}
		catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}







	private void setIntProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] intProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			intProperties = MaterialReqConstant.getHeadintProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			intProperties = MaterialReqConstant.getEntryintProperties();
		}
		try {
			String value = null;
			for (int i = 0; i < intProperties.length; ++i) {
				propertyName = intProperties[i];
				if (billHeadMap.get(propertyName) == null)
					value = "0";
				else {
					value = (String)billHeadMap.get(propertyName);
				}
				info.setInt(propertyName, Integer.parseInt(value));
			}
		}
		catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}







	private void setDeciamlProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] decimalProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			decimalProperties = MaterialReqConstant.getHeadDecimalProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			decimalProperties = MaterialReqConstant.getEntryDecimalProperties();
		}
		try {
			String value = null;
			for (int i = 0; i < decimalProperties.length; ++i) {
				propertyName = decimalProperties[i];
				if (billHeadMap.get(propertyName) == null)
					value = "0";
				else {
					value = (String)billHeadMap.get(propertyName);
				}
				info.setBigDecimal(propertyName, new BigDecimal(value));
			}
		}
		catch (Exception e)
		{
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}







	private void seTimeStampProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] stampProperties = null;
		HashMap erroMap = null;

		String propertyName = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			stampProperties = MaterialReqConstant.getHeadTimeStampProperties();
		} else {
			stampProperties = new String[0];
		}
		try {
			for (int i = 0; i < stampProperties.length; ++i) {
				propertyName = stampProperties[i];
				Timestamp timeStamp = InfoUtil.getTimeStampFromStr((String)billHeadMap.get(propertyName));

				info.setTimestamp(stampProperties[i], timeStamp);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}








	private void setDateProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws EASBizException
	{
		String[] dateProperties = null;

		HashMap erroMap = null;
		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			dateProperties = MaterialReqConstant.getHeadDatetProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			dateProperties = MaterialReqConstant.getEntryDatetProperties();
		}
		Date date = null;
		try
		{
			for (int i = 0; i < dateProperties.length; ++i) {
				propertyName = dateProperties[i];
				date = InfoUtil.convertStrToDate((String)billHeadMap.get(dateProperties[i]), "yyyy-MM-dd");

				info.setDate(dateProperties[i], date);
			}
		}
		catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}







	private void setLinkProperties(Context ctx, CoreBaseInfo info, HashMap billHeadMap, String cuId, boolean isBillHead)
	throws ImportException
	{
		String[] linkProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			linkProperties = MaterialReqConstant.getHeadLinkProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			linkProperties = MaterialReqConstant.getEntryLinkProperties();
		}
		CoreBaseInfo linkBaseInfo = null;
		try {
			for (int i = 0; i < linkProperties.length; ++i) {
				propertyName = linkProperties[i];
				if (isNoCuFilterProperties(propertyName))
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), null);
				else {
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), cuId);

				}
				if("bizType".equals(propertyName) && linkBaseInfo == null){
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, "340", null);
				}
				//    			      if("costCenterOrgUnit".equals(propertyName) && linkBaseInfo == null){
				//    						linkBaseInfo = ((MaterialReqBillInfo)info).getCostCenterOrgUnit();
				//    					}
				if ((linkBaseInfo == null) && (isMustValidateProperty(propertyName, isBillHead))) {
					throw new Exception(propertyName + " " + EASResource.getString("com.kingdee.eas.scm.im.inv.ws.WebserviceResource", "NUMBERNOTFOUND"));
				}
				info.put(propertyName, linkBaseInfo);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}






	private boolean isMustValidateProperty(String propName, boolean isHeadBill)
	{
		String[] musValidateProp = null;
		if (isHeadBill)
			musValidateProp = MaterialReqConstant.getMustValidateHeadProperties();
		else {
			musValidateProp = MaterialReqConstant.getMustValidateEntryProperties();
		}
		for (int i = 0; i < musValidateProp.length; ++i) {
			if (musValidateProp[i].equals(propName)) {
				return true;
			}
		}
		return false;
	}





	private boolean isNoCuFilterProperties(String propertyName)
	{
		String[] noCuProp = MaterialReqConstant.getNOTCUFILTERPROPERTIES();
		for (int i = 0; i < noCuProp.length; ++i) {
			if (noCuProp[i].equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}