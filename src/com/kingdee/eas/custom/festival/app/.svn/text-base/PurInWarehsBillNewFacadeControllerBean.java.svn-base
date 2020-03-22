package com.kingdee.eas.custom.festival.app;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.ejb.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.festival.Constant.PurInWarehsBillConstant;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.util.ResourceUtils;
import com.kingdee.eas.scm.customize.storeage.IPurInWarehsBillExtendFacade;
import com.kingdee.eas.scm.customize.storeage.PurInWarehsBillExtendFacadeFactory;
import com.kingdee.eas.scm.im.inv.IPurInWarehsBill;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsEntryInfo;
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

public class PurInWarehsBillNewFacadeControllerBean extends AbstractPurInWarehsBillNewFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.festival.app.PurInWarehsBillNewFacadeControllerBean");

	protected String[] _importData(Context ctx, String xmlData)
	throws BOSException {
		String[] msg = new String[2];
		ImportException excep;
		try {
			Document doc = XMLUtil.builderDocument(xmlData);
			if (doc != null) {
				Element rootElement = doc.getDocumentElement();
				if (!(rootElement.getTagName().equals("PurInWarehsBill"))) {
					throw new ImportException(
							ImportException.BILLXMLFORMATEXCEPTION);
				}
				PurInWarehsBillInfo purInBillInfo = new PurInWarehsBillInfo();
				HashMap billHeadMap = XMLUtil.getBillHead(doc);
				if (billHeadMap == null) {
					throw new ImportException(
							ImportException.XMLBILHEADEXCEPTION);
				}
				ArrayList billEntriesList = XMLUtil.getBillEntries(doc);
				if (billEntriesList == null) {
					throw new ImportException(
							ImportException.XMLBUILDENTRYEXCEPTION);
				}

				validateProperty(billHeadMap, billEntriesList);
				CtrlUnitInfo cuInfo = InfoUtil.getCtrolUnitInfo(ctx,
						(String) billHeadMap.get("CU"));
				if (cuInfo == null) {
					throw new ImportException(ImportException.CUEXCEPTION);
				}
				ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);
				buildBillHead(ctx, purInBillInfo, billHeadMap, cuInfo.getId()
						.toString());

				builBillEntries(ctx, purInBillInfo, billEntriesList, cuInfo
						.getId().toString());

				IPurInWarehsBillExtendFacade extend = PurInWarehsBillExtendFacadeFactory
				.getLocalInstance(ctx);
				extend.handleExtendField(purInBillInfo, xmlData);

				IPurInWarehsBill iPurInWarehsBill = PurInWarehsBillFactory
				.getLocalInstance(ctx);
				
				/*----------------------------------------计算单据头上的总金额和总数量--------------------------------------*/
				BigDecimal totalLocal=BigDecimal.ZERO;
				BigDecimal totalQty=BigDecimal.ZERO;
				BigDecimal totalAmount=BigDecimal.ZERO;
				BigDecimal totalStdCost=BigDecimal.ZERO;
				BigDecimal totalActCost=BigDecimal.ZERO;
				for(int i=0;i<purInBillInfo.getEntry().size();i++){
					if(UIRuleUtil.isNotNull(purInBillInfo.getEntry().get(i).getLocalAmount()))
						totalLocal=totalLocal.add(purInBillInfo.getEntry().get(i).getLocalAmount());
					if(UIRuleUtil.isNotNull(purInBillInfo.getEntry().get(i).getAmount()))
						totalAmount=totalAmount.add(purInBillInfo.getEntry().get(i).getAmount());
					if(UIRuleUtil.isNotNull(purInBillInfo.getEntry().get(i).getQty()))
						totalQty=totalQty.add(purInBillInfo.getEntry().get(i).getQty());
					if(UIRuleUtil.isNotNull(purInBillInfo.getEntry().get(i).getStandardCost()))
						totalStdCost=totalStdCost.add(purInBillInfo.getEntry().get(i).getStandardCost());
					if(UIRuleUtil.isNotNull(purInBillInfo.getEntry().get(i).getActualCost()))
						totalActCost=totalActCost.add(purInBillInfo.getEntry().get(i).getActualCost());
				}
				purInBillInfo.setTotalLocalAmount(totalLocal);
				purInBillInfo.setTotalAmount(totalAmount);
				purInBillInfo.setTotalQty(totalQty);
				purInBillInfo.setTotalStandardCost(totalStdCost);
				purInBillInfo.setTotalActualCost(totalActCost);
				/*----------------------------------------计算单据头上的总金额和总数量--------------------------------------*/

				ctx.put("disablePermissionForKScript", Boolean.TRUE);
				if ((rootElement.getAttribute("isSubmit") != null)
						&& (rootElement.getAttribute("isSubmit")
								.equalsIgnoreCase("true")))
					iPurInWarehsBill.submit(purInBillInfo);
				else {
					iPurInWarehsBill.save(purInBillInfo);
				}
				msg[0] = "0";
				msg[1] = EASResource.getString(
						"com.kingdee.eas.scm.im.inv.ws.WebserviceResource",
				"IMPORTSUCCESSMSG");
			}
		} catch (EASBizException e) {
			msg[0] = e.getCode();
			msg[1] = e.getMessage();
			logger.error(e);
		} catch (SAXException e) {
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
			excep = new ImportException(new NumericExceptionSubItem(
					"bosException", e.getMessage()));
			msg[0] = excep.getCode();
			msg[1] = excep.getMessage();
			logger.error(excep);
		}

		return msg;
	}

	private void validateProperty(HashMap billHeadMap, ArrayList billEntriesList)
	throws EASBizException {
		String[] bilHeadProps = PurInWarehsBillConstant
		.getMustValidateHeadProperties();
		HashMap errorMap = ErrorCodeUtil.getHeadErrorMap();

		for (int i = 0; i < bilHeadProps.length; ++i) {
			if (!(InfoUtil.validateProperty(billHeadMap, bilHeadProps[i]))) {
				NumericExceptionSubItem numberExc = (NumericExceptionSubItem) errorMap
				.get(bilHeadProps[i]);
				if (numberExc == null) {
					numberExc = new NumericExceptionSubItem(bilHeadProps[i],
							bilHeadProps[i] + " must fill!!");
				}
				throw new ImportException(numberExc);
			}

		}

		HashMap entryMap = null;

		errorMap = ErrorCodeUtil.getEntryErrorMap();
		String[] bilEntriesProps = PurInWarehsBillConstant
		.getMustValidateEntryProperties();
		for (int i = 0; i < billEntriesList.size(); ++i) {
			entryMap = (HashMap) billEntriesList.get(i);
			for (int j = 0; j < bilEntriesProps.length; ++j) {
				if (InfoUtil.validateProperty(entryMap, bilEntriesProps[j]))
					continue;
				NumericExceptionSubItem numberExc = (NumericExceptionSubItem) errorMap
				.get(bilEntriesProps[j]);
				if (numberExc == null) {
					numberExc = new NumericExceptionSubItem(bilEntriesProps[j],
							bilEntriesProps[j] + " must fill!!");
				}
				throw new ImportException(numberExc);
			}
		}
	}

	private void buildBillHead(Context ctx, PurInWarehsBillInfo info,
			HashMap billHeadMap, String cuId) throws EASBizException {
		setStrProperties(info, billHeadMap, true);

		setBooleanProperties(info, billHeadMap, true);

		setIntProperties(info, billHeadMap, true);

		setDeciamlProperties(info, billHeadMap, true);

		seTimeStampProperties(info, billHeadMap, true);

		setDateProperties(info, billHeadMap, true);

		setLinkProperties(ctx, info, billHeadMap, cuId, true);
	}

	private void builBillEntries(Context ctx, PurInWarehsBillInfo info,
			ArrayList entriesList, String cuNumber) throws EASBizException {
		if (entriesList == null) {
			return;
		}
		for (int i = 0; i < entriesList.size(); ++i) {
			HashMap entryMap = (HashMap) entriesList.get(i);
			PurInWarehsEntryInfo entryInfo = new PurInWarehsEntryInfo();

			setStrProperties(entryInfo, entryMap, false);

			setBooleanProperties(entryInfo, entryMap, false);

			setIntProperties(entryInfo, entryMap, false);

			setDeciamlProperties(entryInfo, entryMap, false);

			seTimeStampProperties(entryInfo, entryMap, false);

			setDateProperties(entryInfo, entryMap, false);

			setLinkProperties(ctx, entryInfo, entryMap, null, false);
			entryInfo.setParent(info);
			info.getEntry().add(entryInfo);
		}
	}

	private void setStrProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) {
		String[] strProperties = null;
		if (isBillHead)
			strProperties = PurInWarehsBillConstant.getHeadStrProperties();
		else
			strProperties = PurInWarehsBillConstant.getEntryStrProperties();
		for (int i = 0; i < strProperties.length; ++i)
			info.setString(strProperties[i], (String) billHeadMap
					.get(strProperties[i]));
	}

	private void setBooleanProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String[] booleanProperties = null;
		HashMap erroMap = null;

		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			booleanProperties = PurInWarehsBillConstant
			.getHeadBooleanProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			booleanProperties = new String[0];
		}
		try {
			boolean boolValue = false;
			String propValue = null;
			for (int i = 0; i < booleanProperties.length; ++i) {
				propertyName = booleanProperties[i];
				propValue = (String) billHeadMap.get(propertyName);
				if ((propValue != null)
						&& (((propValue.equals("1")) || (propValue
								.equals("true")))))
					boolValue = true;
				else {
					boolValue = false;
				}
				info.setBoolean(propertyName, boolValue);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
			.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void setIntProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String[] intProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			intProperties = PurInWarehsBillConstant.getHeadintProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			intProperties = PurInWarehsBillConstant.getEntryintProperties();
		}
		try {
			String value = null;
			for (int i = 0; i < intProperties.length; ++i) {
				propertyName = intProperties[i];
				if (billHeadMap.get(propertyName) == null)
					value = "0";
				else {
					value = (String) billHeadMap.get(propertyName);
				}
				info.setInt(propertyName, Integer.parseInt(value));
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
			.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void setDeciamlProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws ImportException {
		String[] decimalProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			decimalProperties = PurInWarehsBillConstant
			.getHeadDecimalProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			decimalProperties = PurInWarehsBillConstant
			.getEntryDecimalProperties();
		}
		try {
			String value = null;
			for (int i = 0; i < decimalProperties.length; ++i) {
				propertyName = decimalProperties[i];
				if (billHeadMap.get(propertyName) == null)
					value = "0";
				else {
					value = (String) billHeadMap.get(propertyName);
				}
				info.setBigDecimal(propertyName, new BigDecimal(value));
			}

		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
			.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void seTimeStampProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws EASBizException {
		String[] stampProperties = null;
		Timestamp timeStamp = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			stampProperties = PurInWarehsBillConstant
			.getHeadTimeStampProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			stampProperties = new String[0];
		}
		try {
			for (int i = 0; i < stampProperties.length; ++i) {
				propertyName = stampProperties[i];
				timeStamp = InfoUtil.getTimeStampFromStr((String) billHeadMap
						.get(propertyName));

				info.setTimestamp(propertyName, timeStamp);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
			.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void setDateProperties(CoreBaseInfo info, HashMap billHeadMap,
			boolean isBillHead) throws EASBizException {
		String[] dateProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			dateProperties = PurInWarehsBillConstant.getHeadDatetProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			dateProperties = PurInWarehsBillConstant.getEntryDatetProperties();
		}
		Date date = null;
		try {
			for (int i = 0; i < dateProperties.length; ++i) {
				propertyName = dateProperties[i];
				date = InfoUtil.convertStrToDate((String) billHeadMap
						.get(propertyName), "yyyy-MM-dd");

				info.setDate(propertyName, date);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
			.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private void setLinkProperties(Context ctx, CoreBaseInfo info,
			HashMap billHeadMap, String cuId, boolean isBillHead)
	throws EASBizException {
		String[] linkProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			linkProperties = PurInWarehsBillConstant.getHeadLinkProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			linkProperties = PurInWarehsBillConstant.getEntryLinkProperties();
		}

		CoreBaseInfo linkBaseInfo = null;
		try {
			for (int i = 0; i < linkProperties.length; ++i) {
				propertyName = linkProperties[i];

				linkBaseInfo = InfoUtil.getLinkPropCoreBaseInfo(ctx, info,
						propertyName, (String) billHeadMap.get(propertyName),
						null);

				if ((linkBaseInfo == null)
						&& (isMustValidateProperty(propertyName, isBillHead))) {
					throw new Exception(ResourceUtils.getMessageInOrder(
							"com.kingdee.eas.scm.im.inv.ws.WebserviceResource",
							"NUMBERNOTFOUND", new String[] { propertyName }));
				}
				info.put(propertyName, linkBaseInfo);
			}
		} catch (Exception e) {
			NumericExceptionSubItem numberExc = (NumericExceptionSubItem) erroMap
			.get(propertyName);
			if (numberExc == null) {
				numberExc = new NumericExceptionSubItem(propertyName, e
						.getMessage());
			}
			throw new ImportException(numberExc);
		}
	}

	private boolean isMustValidateProperty(String propName, boolean isHeadBill) {
		String[] musValidateProp = null;
		if (isHeadBill)
			musValidateProp = PurInWarehsBillConstant
			.getMustValidateHeadProperties();
		else {
			musValidateProp = PurInWarehsBillConstant
			.getMustValidateEntryProperties();
		}
		for (int i = 0; i < musValidateProp.length; ++i) {
			if (musValidateProp[i].equals(propName)) {
				return true;
			}
		}
		return false;
	}
}