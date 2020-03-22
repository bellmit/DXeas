package com.kingdee.eas.custom.festival.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.org.CtrlUnitCollection;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeCollection;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.util.ResourceUtils;
import com.kingdee.eas.scm.customize.storeage.IManufactureRecBillExtendFacade;
import com.kingdee.eas.scm.customize.storeage.ManufactureRecBillExtendFacadeFactory;
import com.kingdee.eas.scm.im.inv.IManufactureRecBill;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillCollection;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillEntryInfo;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillFactory;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillCollection;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import com.kingdee.eas.scm.im.inv.ws.util.ErrorCodeUtil;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.scm.im.inv.ws.util.XMLUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import com.kingdee.eas.custom.festival.Constant.ManuFactureConstant;

import java.lang.String;

public class ManufactureRecBillNewFacadeControllerBean extends AbstractManufactureRecBillNewFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.festival.app.ManufactureRecBillNewFacadeControllerBean");
	protected String[] _importData(Context ctx, String xmlData) throws BOSException
	{
		String[] msg = new String[2];
		ImportException excep;     try
		{
			Document doc = XMLUtil.builderDocument(xmlData);
			if (doc != null)
			{
				Element rootElement = doc.getDocumentElement();
				if (!(rootElement.getTagName().equals("ManufactureRecBill"))) {
					throw new ImportException(ImportException.BILLXMLFORMATEXCEPTION);
				}
				ManufactureRecBillInfo manufactureRecBillInfo = new ManufactureRecBillInfo();
				HashMap billHeadMap = XMLUtil.getBillHead(doc);
				if (billHeadMap == null) {
					throw new ImportException(ImportException.XMLBILHEADEXCEPTION);
				}
				ArrayList billEntriesList = XMLUtil.getBillEntries(doc);
				if (billEntriesList == null) {
					throw new ImportException(ImportException.XMLBUILDENTRYEXCEPTION);
				}

				validateProperty(billHeadMap, billEntriesList);
				CtrlUnitCollection collCU = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitCollection("where number='"+(String)billHeadMap.get("CU")+"'");
				CtrlUnitInfo cuInfo;
				if(collCU.size()==0){
					throw new ImportException(ImportException.CUEXCEPTION);
				}else
					cuInfo=collCU.get(0);
				ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);
				buildBillHead(ctx, manufactureRecBillInfo, billHeadMap, cuInfo.getId().toString());
				if(!StringUtils.isEmpty(manufactureRecBillInfo.getNumber())){
					ManufactureRecBillCollection coll = ManufactureRecBillFactory.getLocalInstance(ctx).getManufactureRecBillCollection("where number='"+manufactureRecBillInfo.getNumber()+"'");
					if(coll.size()>0){
						return new String[] {"N","number","head","±àÂëÖØ¸´"};
					}
				}

				builBillEntries(ctx, manufactureRecBillInfo, billEntriesList, cuInfo.getId().toString());

				IManufactureRecBillExtendFacade extend = ManufactureRecBillExtendFacadeFactory.getLocalInstance(ctx);
				extend.handleExtendField(manufactureRecBillInfo, xmlData);
				ctx.put("disablePermissionForKScript", Boolean.TRUE);

				IManufactureRecBill iManufacutureBill = ManufactureRecBillFactory.getLocalInstance(ctx);

				if(billHeadMap.get("bizType")!=null){
					BizTypeCollection coll = BizTypeFactory.getLocalInstance(ctx).getBizTypeCollection("where number='"+billHeadMap.get("bizType")+"'");
					if(coll.size()>0)
						manufactureRecBillInfo.setBizType(coll.get(0));
				}
				if ((rootElement.getAttribute("isSubmit") != null) && (rootElement.getAttribute("isSubmit").equalsIgnoreCase("true")))
					iManufacutureBill.submit(manufactureRecBillInfo);
				else {
					iManufacutureBill.save(manufactureRecBillInfo);
				}

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
		}

		return msg;
	}








	private void validateProperty(HashMap billHeadMap, ArrayList billEntriesList)
	throws EASBizException
	{
		String[] bilHeadProps = ManuFactureConstant.getMustValidateHeadProperties();
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
		String[] bilEntriesProps = ManuFactureConstant.getMustValidateEntryProperties();
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










	private void buildBillHead(Context ctx, ManufactureRecBillInfo info, HashMap billHeadMap, String cuId)
	throws EASBizException
	{
		setStrProperties(info, billHeadMap, true);

		setBooleanProperties(info, billHeadMap, true);

		setIntProperties(info, billHeadMap, true);

		setDeciamlProperties(info, billHeadMap, true);

		seTimeStampProperties(info, billHeadMap, true);

		setDateProperties(info, billHeadMap, true);

		setLinkProperties(ctx, info, billHeadMap, cuId, true);
	}








	private void builBillEntries(Context ctx, ManufactureRecBillInfo info, ArrayList entriesList, String cuID)
	throws EASBizException
	{
		if (entriesList == null) {
			return;
		}
		for (int i = 0; i < entriesList.size(); ++i) {
			HashMap entryMap = (HashMap)entriesList.get(i);
			ManufactureRecBillEntryInfo entryInfo = new ManufactureRecBillEntryInfo();

			setStrProperties(entryInfo, entryMap, false);

			setBooleanProperties(entryInfo, entryMap, false);

			setIntProperties(entryInfo, entryMap, false);

			setDeciamlProperties(entryInfo, entryMap, false);

			seTimeStampProperties(entryInfo, entryMap, false);

			setDateProperties(entryInfo, entryMap, false);

			setLinkProperties(ctx, entryInfo, entryMap, cuID, false);
			entryInfo.setParent(info);
			info.getEntry().add(entryInfo);
		}
	}








	private void setStrProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	{
		String[] strProperties = null;
		if (isBillHead)
			strProperties = ManuFactureConstant.getHeadStrProperties();
		else
			strProperties = ManuFactureConstant.getEntryStrProperties();
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
			booleanProperties = ManuFactureConstant.getHeadBooleanProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			booleanProperties = ManuFactureConstant.getEntryBooleanProperties();
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
			intProperties = ManuFactureConstant.getHeadintProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			intProperties = ManuFactureConstant.getEntryintProperties();
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
			decimalProperties = ManuFactureConstant.getHeadDecimalProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			decimalProperties = ManuFactureConstant.getEntryDecimalProperties();
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
			stampProperties = ManuFactureConstant.getHeadTimeStampProperties();
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
			dateProperties = ManuFactureConstant.getHeadDatetProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			dateProperties = ManuFactureConstant.getEntryDatetProperties();
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
			linkProperties = ManuFactureConstant.getHeadLinkProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			linkProperties = ManuFactureConstant.getEntryLinkProperties();
		}
		CoreBaseInfo linkBaseInfo = null;
		try {
			for (int i = 0; i < linkProperties.length; ++i) {
				propertyName = linkProperties[i];
				if (isNoCuFilterProperties(propertyName))
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), null);
				else {
					if(propertyName.equals("costObject"))
						linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), cuId);
					else
						linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), null);

				}
				if(propertyName.equals("")){

				}

				if ((linkBaseInfo == null) && (isMustValidateProperty(propertyName, isBillHead))) {
					throw new Exception(ResourceUtils.getMessageInOrder("com.kingdee.eas.scm.im.inv.ws.WebserviceResource", "NUMBERNOTFOUND", new String[] { propertyName }));
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
			musValidateProp = ManuFactureConstant.getMustValidateHeadProperties();
		else {
			musValidateProp = ManuFactureConstant.getMustValidateEntryProperties();
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
		String[] noCuProp = ManuFactureConstant.getNOTCUFILTERPROPERTIES();
		for (int i = 0; i < noCuProp.length; ++i) {
			if (noCuProp[i].equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}