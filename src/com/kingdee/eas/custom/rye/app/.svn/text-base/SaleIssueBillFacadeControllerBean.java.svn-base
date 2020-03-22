package com.kingdee.eas.custom.rye.app;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.kingdee.bos.*;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.rye.Constant.SaleIssueBillConstant;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.util.ResourceUtils;
import com.kingdee.eas.scm.customize.storeage.ISaleIssueBillExtendFacade;
import com.kingdee.eas.scm.customize.storeage.SaleIssueBillExtendFacadeFactory;
import com.kingdee.eas.scm.im.inv.ISaleIssueBill;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.SaleIssueEntryInfo;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import com.kingdee.eas.scm.im.inv.ws.util.ErrorCodeUtil;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.scm.im.inv.ws.util.XMLUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.util.NumericExceptionSubItem;

import java.io.IOException;
import java.lang.String;
import java.math.BigDecimal;

public class SaleIssueBillFacadeControllerBean extends AbstractSaleIssueBillFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.rye.app.SaleIssueBillFacadeControllerBean");
	protected String[] _importData(Context ctx, String xmlData) throws BOSException
	{
		String[] msg = new String[2];
		ImportException excep;
		try
		{
			Document doc = XMLUtil.builderDocument(xmlData);
			if (doc != null)
			{
				Element rootElement = doc.getDocumentElement();
				if (!(rootElement.getTagName().equals("SaleIssueBill"))) {
					throw new ImportException(ImportException.BILLXMLFORMATEXCEPTION);
				}
				SaleIssueBillInfo issueInfo = new SaleIssueBillInfo();
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
				buildBillHead(ctx, issueInfo, billHeadMap);
				builBillEntries(ctx, issueInfo, billEntriesList, null);

				ISaleIssueBillExtendFacade extend = SaleIssueBillExtendFacadeFactory.getLocalInstance(ctx);
				extend.handleExtendField(issueInfo, xmlData);

				ctx.put("disablePermissionForKScript", Boolean.TRUE);
				ISaleIssueBill iSaleIssue = SaleIssueBillFactory.getLocalInstance(ctx);

				if ((rootElement.getAttribute("isSubmit") != null) && (rootElement.getAttribute("isSubmit").equalsIgnoreCase("true")))
					iSaleIssue.submit(issueInfo);
				else {
					iSaleIssue.save(issueInfo);
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

	private void buildBillHead(Context ctx, SaleIssueBillInfo info, HashMap billHeadMap)
	throws EASBizException
	{
		setStrProperties(info, billHeadMap, true);

		setBooleanProperties(info, billHeadMap, true);

		setIntProperties(info, billHeadMap, true);

		setDeciamlProperties(info, billHeadMap, true);

		seTimeStampProperties(info, billHeadMap, true);

		setDateProperties(info, billHeadMap, true);

		setLinkProperties(ctx, info, billHeadMap, null, true);
	}

	private void builBillEntries(Context ctx, SaleIssueBillInfo info, ArrayList entriesList, String cuNumber)
	throws EASBizException
	{
		if (entriesList == null) {
			return;
		}
		for (int i = 0; i < entriesList.size(); ++i) {
			HashMap entryMap = (HashMap)entriesList.get(i);
			SaleIssueEntryInfo entryInfo = new SaleIssueEntryInfo();

			setStrProperties(entryInfo, entryMap, false);

			setBooleanProperties(entryInfo, entryMap, false);

			setIntProperties(entryInfo, entryMap, false);

			setDeciamlProperties(entryInfo, entryMap, false);

			seTimeStampProperties(entryInfo, entryMap, false);

			setDateProperties(entryInfo, entryMap, false);

			setLinkProperties(ctx, entryInfo, entryMap, cuNumber, false);
			entryInfo.setParent(info);
			info.getEntry().add(entryInfo);
		}
	}

	private void setStrProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	{
		String[] strProperties = null;
		if (isBillHead)
			strProperties = SaleIssueBillConstant.getHeadStrProperties();
		else
			strProperties = SaleIssueBillConstant.getEntryStrProperties();
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
			booleanProperties = SaleIssueBillConstant.getHeadBooleanProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			booleanProperties = new String[0];
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
		HashMap erroMap = null;

		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			intProperties = SaleIssueBillConstant.getHeadintProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			intProperties = SaleIssueBillConstant.getEntryintProperties();
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
		catch (Exception e)
		{
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
		HashMap erroMap = null;

		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			decimalProperties = SaleIssueBillConstant.getHeadDecimalProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			decimalProperties = SaleIssueBillConstant.getEntryDecimalProperties();
		}
		try
		{
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
		catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void seTimeStampProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws EASBizException
	{
		String[] stampProperties = null;
		String propertyName = null;
		Timestamp timeStamp = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			stampProperties = SaleIssueBillConstant.getHeadTimeStampProperties();
		}
		else {
			stampProperties = new String[0];
		}
		try {
			for (int i = 0; i < stampProperties.length; ++i) {
				propertyName = stampProperties[i];
				timeStamp = InfoUtil.getTimeStampFromStr((String)billHeadMap.get(propertyName));
				info.setTimestamp(propertyName, timeStamp);
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
	throws ImportException
	{
		String[] dateProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			dateProperties = SaleIssueBillConstant.getHeadDatetProperties();
		}
		else {
			dateProperties = SaleIssueBillConstant.getEntryDatetProperties();
			erroMap = ErrorCodeUtil.getEntryErrorMap();
		}

		Date date = null;
		try {
			for (int i = 0; i < dateProperties.length; ++i) {
				propertyName = dateProperties[i];
				date = InfoUtil.convertStrToDate((String)billHeadMap.get(propertyName), "yyyy-MM-dd");

				info.setDate(propertyName, date);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem)erroMap.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void setLinkProperties(Context ctx, CoreBaseInfo info, HashMap billHeadMap, String cuNumber, boolean isBillHead)
	throws ImportException
	{
		String[] linkProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			linkProperties = SaleIssueBillConstant.getHeadLinkProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			linkProperties = SaleIssueBillConstant.getEntryLinkProperties();
		}

		CoreBaseInfo linkBaseInfo = null;
		try {
			for (int i = 0; i < linkProperties.length; ++i) {
				propertyName = linkProperties[i];
				if (isNoCuFilterProperties(propertyName))
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), null);
				else {
					linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info, propertyName, (String)billHeadMap.get(propertyName), cuNumber);
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

	private void validateProperty(HashMap billHeadMap, ArrayList billEntriesList)
	throws ImportException
	{
		String[] bilHeadProps = SaleIssueBillConstant.getMustValidateHeadProperties();
		HashMap errorMap = ErrorCodeUtil.getHeadErrorMap();

		for (int i = 0; i < bilHeadProps.length; ++i) {
			if (!(InfoUtil.validateProperty(billHeadMap, bilHeadProps[i]))) {
				NumericExceptionSubItem numberExc = (NumericExceptionSubItem)errorMap.get(bilHeadProps[i]);
				if (numberExc == null) {
					numberExc = new NumericExceptionSubItem(bilHeadProps[i], bilHeadProps[i] + " must fill!");
				}
				throw new ImportException(numberExc);
			}

		}

		errorMap = ErrorCodeUtil.getEntryErrorMap();
		String[] bilEntriesProps = SaleIssueBillConstant.getMustValidateEntryProperties();
		HashMap entryMap = null;
		for (int i = 0; i < billEntriesList.size(); ++i) {
			entryMap = (HashMap)billEntriesList.get(i);
			for (int j = 0; j < bilEntriesProps.length; ++j)
				if (!(InfoUtil.validateProperty(entryMap, bilEntriesProps[j]))) {
					NumericExceptionSubItem numberExc = (NumericExceptionSubItem)errorMap.get(bilEntriesProps[j]);
					if (numberExc == null) {
						numberExc = new NumericExceptionSubItem(bilEntriesProps[j], bilEntriesProps[j] + " must fill!");
					}
					throw new ImportException(numberExc);
				}
		}
	}

	private boolean isMustValidateProperty(String propName, boolean isHeadBill)
	{
		String[] musValidateProp = null;
		if (isHeadBill)
			musValidateProp = SaleIssueBillConstant.getMustValidateHeadProperties();
		else {
			musValidateProp = SaleIssueBillConstant.getMustValidateEntryProperties();
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
		String[] noCuProp = SaleIssueBillConstant.getNOTCUFILTERPROPERTIES();
		for (int i = 0; i < noCuProp.length; ++i) {
			if (noCuProp[i].equals(propertyName)) {
				return true;
			}
		}
		return false;
	}

}