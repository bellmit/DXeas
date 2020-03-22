package com.kingdee.eas.custom.festival.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.*;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.kingdee.eas.basedata.assistant.AccountBankCollection;
import com.kingdee.eas.basedata.assistant.AccountBankFactory;
import com.kingdee.eas.basedata.assistant.AccountBankInfo;
import com.kingdee.eas.basedata.assistant.BankFactory;
import com.kingdee.eas.basedata.assistant.BankInfo;
import com.kingdee.eas.basedata.assistant.IBank;
import com.kingdee.eas.basedata.master.account.AccountViewFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.master.account.IAccountView;
import com.kingdee.eas.basedata.master.cssp.SupplierCollection;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.CtrlUnitCollection;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.festival.Constant.PaymentConstant;
import com.kingdee.eas.fi.ar.app.webservice.util.BillProertiesConvertor;
import com.kingdee.eas.fi.cas.IPaymentBill;
import com.kingdee.eas.fi.cas.PaymentBillCollection;
import com.kingdee.eas.fi.cas.PaymentBillEntryInfo;
import com.kingdee.eas.fi.cas.PaymentBillFactory;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillCollection;
import com.kingdee.eas.fi.cas.ReceivingBillFactory;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.util.ResourceUtils;
import com.kingdee.eas.scm.im.inv.ws.util.ErrorCodeUtil;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.scm.im.inv.ws.util.XMLUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

import java.io.IOException;
import java.lang.String;
import java.math.BigDecimal;

import java.lang.String;

public class PaymentImportFacadeControllerBean extends AbstractPaymentImportFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.festival.app.PaymentImportFacadeControllerBean");
	@SuppressWarnings("unchecked")
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
				if (!(rootElement.getTagName().equals("PaymentBill"))) {
					throw new ImportException(ImportException.BILLXMLFORMATEXCEPTION);
				}
				PaymentBillInfo paymentBillInfo = new PaymentBillInfo();
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


				if(cuInfo==null||cuInfo.getId()==null){
					String CUNum = (String)billHeadMap.get("CU");
					CtrlUnitCollection coll = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitCollection("where number='"+CUNum+"'");
					if(coll.size()>0)
						cuInfo=coll.get(0);
				}


				buildBillHead(ctx, paymentBillInfo, billHeadMap, cuInfo.getId().toString());
				if(!StringUtils.isEmpty(paymentBillInfo.getNumber())){
					PaymentBillCollection coll = PaymentBillFactory.getLocalInstance(ctx).getPaymentBillCollection("where number='"+paymentBillInfo.getNumber()+"'");
					if(coll.size()>0){
						return new String[] {"µ¼ÈëÊ§°Ü","±àÂëÖØ¸´"};
					}
				}

				builBillEntries(ctx, paymentBillInfo, billEntriesList, null);

				//          Ipaymentbill extend = ManufactureRecBillExtendFacadeFactory.getLocalInstance(ctx);
				//          extend.handleExtendField(paymentBillInfo, xmlData);
				ctx.put("disablePermissionForKScript", Boolean.TRUE);



				if(billHeadMap.get("payeeid")!=null){
					SupplierCollection coll = SupplierFactory.getLocalInstance(ctx).getSupplierCollection("where number='"+billHeadMap.get("payeeid")+"'");
					if(coll.size()>0){
						paymentBillInfo.setPayeeID((coll.get(0)).getId().toString());
						paymentBillInfo.setPayeeNumber((coll.get(0)).getNumber());
						paymentBillInfo.setPayeeName((coll.get(0)).getName());
					}else
						paymentBillInfo.setPayeeID(null);
				}


				if(billHeadMap.get("payeraccountbank")!=null){
					AccountBankCollection coll = AccountBankFactory.getLocalInstance(ctx).getAccountBankCollection("where number='"+billHeadMap.get("payeraccountbank")+"'");
					if(coll.size()>0){
						AccountBankInfo accountBankInfo = coll.get(0);
						paymentBillInfo.setPayerAccountBank(accountBankInfo);
						if(accountBankInfo.getBank()!=null){
							paymentBillInfo.setPayerBank(accountBankInfo.getBank());
						}
						if(accountBankInfo.getAccount()!=null)
							paymentBillInfo.setPayerAccount(accountBankInfo.getAccount());
					}
				}




				IPaymentBill iPaymentBill = PaymentBillFactory.getLocalInstance(ctx);

				if ((rootElement.getAttribute("isSubmit") != null) && (rootElement.getAttribute("isSubmit").equalsIgnoreCase("true")))
					iPaymentBill.submit(paymentBillInfo);
				else {
					iPaymentBill.save(paymentBillInfo);
				}
				
				
				String str;
				for (int i = 0; i < billEntriesList.size(); ++i) {
					HashMap entryMap = (HashMap)billEntriesList.get(i);
					if(entryMap.get("deposit")!=null){
						str="update T_CAS_PaymentBillEntry set CFDeposit='"+(String)entryMap.get("deposit")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback1")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback1='"+(String)entryMap.get("chargeback1")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback2")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback2='"+(String)entryMap.get("chargeback2")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback3")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback3='"+(String)entryMap.get("chargeback3")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback4")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback4='"+(String)entryMap.get("chargeback4")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback5")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback5='"+(String)entryMap.get("chargeback5")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback6")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback6='"+(String)entryMap.get("chargeback6")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback7")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback7='"+(String)entryMap.get("chargeback7")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback8")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback4='"+(String)entryMap.get("chargeback8")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback9")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback9='"+(String)entryMap.get("chargeback9")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
					if(entryMap.get("chargeback4")!=null){
						str="update T_CAS_PaymentBillEntry set CFchargeback4='"+(String)entryMap.get("chargeback4")+"' where FPaymentBillID='"+paymentBillInfo.getId().toString()+"' and FSEQ="+entryMap.get("seq");
						DbUtil.execute(ctx, str);
					}
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








	@SuppressWarnings("unchecked")
	private void validateProperty(HashMap billHeadMap, ArrayList billEntriesList)
	throws EASBizException
	{
		String[] bilHeadProps = PaymentConstant.getMustValidateHeadProperties();
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
		String[] bilEntriesProps = PaymentConstant.getMustValidateEntryProperties();
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










	@SuppressWarnings("unchecked")
	private void buildBillHead(Context ctx, PaymentBillInfo paymentBillInfo, HashMap billHeadMap, String cuId)
	throws EASBizException
	{
		setStrProperties(paymentBillInfo, billHeadMap, true);

		setBooleanProperties(paymentBillInfo, billHeadMap, true);

		setIntProperties(paymentBillInfo, billHeadMap, true);

		setDeciamlProperties(paymentBillInfo, billHeadMap, true);

		seTimeStampProperties(paymentBillInfo, billHeadMap, true);

		setDateProperties(paymentBillInfo, billHeadMap, true);

		setLinkProperties(ctx, paymentBillInfo, billHeadMap, cuId, true);
	}








	@SuppressWarnings("unchecked")
	private void builBillEntries(Context ctx, PaymentBillInfo paymentBillInfo, ArrayList entriesList, String cuID)
	throws EASBizException
	{
		if (entriesList == null) {
			return;
		}
		for (int i = 0; i < entriesList.size(); ++i) {
			HashMap entryMap = (HashMap)entriesList.get(i);
			PaymentBillEntryInfo entryInfo = new PaymentBillEntryInfo();

			setStrProperties(entryInfo, entryMap, false);

			setBooleanProperties(entryInfo, entryMap, false);

			setIntProperties(entryInfo, entryMap, false);

			setDeciamlProperties(entryInfo, entryMap, false);

			seTimeStampProperties(entryInfo, entryMap, false);

			setDateProperties(entryInfo, entryMap, false);

			setLinkProperties(ctx, entryInfo, entryMap, cuID, false);
			entryInfo.setPaymentBill(paymentBillInfo);
			paymentBillInfo.getEntries().add(entryInfo);
		}
	}








	@SuppressWarnings("unchecked")
	private void setStrProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	{
		String[] strProperties = null;
		if (isBillHead)
			strProperties = PaymentConstant.getHeadStrProperties();
		else
			strProperties = PaymentConstant.getEntryStrProperties();
		for (int i = 0; i < strProperties.length; ++i)
			info.setString(strProperties[i], (String)billHeadMap.get(strProperties[i]));
	}








	@SuppressWarnings("unchecked")
	private void setBooleanProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] booleanProperties = null;
		HashMap erroMap = null;

		String propertyName = null;
		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			booleanProperties = PaymentConstant.getHeadBooleanProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			booleanProperties = PaymentConstant.getEntryBooleanProperties();
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







	@SuppressWarnings("unchecked")
	private void setIntProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] intProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			intProperties = PaymentConstant.getHeadintProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			intProperties = PaymentConstant.getEntryintProperties();
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







	@SuppressWarnings("unchecked")
	private void setDeciamlProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] decimalProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			decimalProperties = PaymentConstant.getHeadDecimalProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			decimalProperties = PaymentConstant.getEntryDecimalProperties();
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

				//				if(propertyName.equals("deposit")||propertyName.equals("chargeback1")||propertyName.equals("chargeback2")||propertyName.equals("chargeback3")||propertyName.equals("chargeback4")){
				//					if(billHeadMap.get(propertyName)!=null)
				//						info.put(propertyName,new BigDecimal((String)billHeadMap.get(propertyName)));
				//				}
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







	@SuppressWarnings("unchecked")
	private void seTimeStampProperties(CoreBaseInfo info, HashMap billHeadMap, boolean isBillHead)
	throws ImportException
	{
		String[] stampProperties = null;
		HashMap erroMap = null;

		String propertyName = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			stampProperties = PaymentConstant.getHeadTimeStampProperties();
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
			dateProperties = PaymentConstant.getHeadDatetProperties();
		} else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			dateProperties = PaymentConstant.getEntryDatetProperties();
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







	@SuppressWarnings("unchecked")
	private void setLinkProperties(Context ctx, CoreBaseInfo info, HashMap billHeadMap, String cuId, boolean isBillHead)
	throws ImportException
	{
		String[] linkProperties = null;
		String propertyName = null;
		HashMap erroMap = null;

		if (isBillHead) {
			erroMap = ErrorCodeUtil.getHeadErrorMap();
			linkProperties = PaymentConstant.getHeadLinkProperties();
		}
		else {
			erroMap = ErrorCodeUtil.getEntryErrorMap();
			linkProperties = PaymentConstant.getEntryLinkProperties();
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

				if ((linkBaseInfo == null) && (isMustValidateProperty(propertyName, isBillHead))) {
					throw new Exception(ResourceUtils.getMessageInOrder("com.kingdee.eas.scm.im.inv.ws.WebserviceResource", "NUMBERNOTFOUND", new String[] { propertyName }));
				}
				info.put(propertyName, linkBaseInfo);
			}
			if(propertyName.equals("payeraccountbank")){
				PaymentBillInfo paymentBillInfo = ((PaymentBillInfo)info);

				FilterItemInfo companyQueryFilter = new FilterItemInfo("company.id", paymentBillInfo.getCompany().getId().toString(), CompareType.EQUALS);
				AccountBankInfo payeeaccountbank = (AccountBankInfo)BillProertiesConvertor.getValueObject(billHeadMap.get("payeraccountbank"), AccountBankInfo.class, null, ctx);


				info.put("payerAccountBank", payeeaccountbank);


				BankInfo payeeBank = (BankInfo)BillProertiesConvertor.getValueObject(billHeadMap.get("payerbank"), BankInfo.class, null, ctx);

				if (payeeBank != null) {
					info.put("payerBank",payeeBank);
				} else if ((payeeaccountbank != null) && (payeeaccountbank.getBank() != null) && (payeeaccountbank.getBank().getId() != null)) {
					String bankId = payeeaccountbank.getBank().getId().toString();
					IBank iBank = null;
					if (ctx != null)
						iBank = BankFactory.getLocalInstance(ctx);
					else
						iBank = BankFactory.getRemoteInstance();
					try
					{
						payeeBank = iBank.getBankInfo(new ObjectUuidPK(bankId));
					}
					catch (EASBizException e) {
						logger.error(e);
					}
					info.put("payerBank",payeeBank);

				}

				AccountViewInfo payeeaccount = (AccountViewInfo)BillProertiesConvertor.getValueObject(billHeadMap.get("payeraccount"), AccountViewInfo.class, new FilterItemInfo("CU.id", paymentBillInfo.getCU().getId(), CompareType.EQUALS), ctx);


				if (payeeaccount != null) {
					info.put("payerAccount",payeeaccount);
				} else if ((payeeaccountbank != null) && (payeeaccountbank.getAccount() != null) && (payeeaccountbank.getAccount().getId() != null)) {
					String accountId = payeeaccountbank.getAccount().getId().toString();
					IAccountView iAccountView = null;
					if (ctx != null)
						iAccountView = AccountViewFactory.getLocalInstance(ctx);
					else
						iAccountView = AccountViewFactory.getRemoteInstance();
					try
					{
						payeeaccount = iAccountView.getAccountViewInfo(new ObjectUuidPK(accountId));
					}
					catch (EASBizException e) {
						logger.error(e);
					}
					info.put("payerAccount",payeeaccount);

				}




			}
			if(propertyName.equals("payeeid")){
				SupplierInfo payee = (SupplierInfo)BillProertiesConvertor.getValueObject(billHeadMap.get("payeeid"), SupplierInfo.class, new FilterItemInfo("CU.id", null, CompareType.EQUALS), ctx);
				if(payee!=null){
					info.put("payeeID", payee.getId().toString());
					info.put("payeeNumber", payee.getNumber());
					info.put("payeeName", payee.getName());
				}
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
			musValidateProp = PaymentConstant.getMustValidateHeadProperties();
		else {
			musValidateProp = PaymentConstant.getMustValidateEntryProperties();
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
		String[] noCuProp = PaymentConstant.getNOTCUFILTERPROPERTIES();
		for (int i = 0; i < noCuProp.length; ++i) {
			if (noCuProp[i].equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}