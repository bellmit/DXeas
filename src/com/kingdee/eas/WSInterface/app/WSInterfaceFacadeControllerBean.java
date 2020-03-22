package com.kingdee.eas.WSInterface.app;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.WSInterface.BaseQueryBean;
import com.kingdee.eas.WSInterface.basedataFacade.IImportBaseData;
import com.kingdee.eas.WSInterface.basedataFacade.WMImportBase;
import com.kingdee.eas.WSInterface.billFacade.IImportBill;
import com.kingdee.eas.WSInterface.billFacade.WMImportBill;
import com.kingdee.eas.WSInterface.common.JSONUtils;
import com.kingdee.eas.WSInterface.common.JSONWithXML;
import com.kingdee.eas.WSInterface.common.WSBosType;
import com.kingdee.eas.WSInterface.common.WsCommonExportUtil;
import com.kingdee.eas.WSInterface.common.WsCommonImportUtil;
import com.kingdee.eas.WSInterface.common.WsCommonUtil;
import com.kingdee.eas.basedata.assistant.IAccountBank;
import com.kingdee.eas.basedata.assistant.IBank;
import com.kingdee.eas.basedata.assistant.IExchangeRate;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ar.app.webservice.ReceiveBillFacadeFactory;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBase;

/**
 * webServices�ӿڵ��ù�����
 * 
 * @author DAD
 * 
 */
public class WSInterfaceFacadeControllerBean extends AbstractWSInterfaceFacadeControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.app.WSInterfaceFacadeControllerBean");

	/**
	 * ��ȡ��������
	 */
	@Override
	protected String _getBaseData(Context ctx, String queryStr) throws BOSException {
		logger.info("---------------��ʼ���û������Ͻӿ�-------------");
		System.out.println(queryStr);
		logger.info("���� dataJSON==" + queryStr.toString());
		BaseQueryBean obj = (BaseQueryBean) JSONUtils.convertJsonToObject(ctx, queryStr, BaseQueryBean.class);

		logger.info("��������� ��֯ID��" + obj.getOrgNumber() + "	���ڣ�" + obj.getDate() + "   �������ͣ�" + obj.getBosType() + "��");

		if (!(WSBosType.DataBosTypes.containsKey(obj.getBosType()))) {
			logger.error("-------------------�����ڵ������ͣ�-----------------");
			return null;
		}
		String BosType = WSBosType.DataBosTypes.get(obj.getBosType());
		// �ҵ�bostype�Ķ���
		EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx, BosType);
		if (eo != null) {
			Map headMap = WsCommonImportUtil.getBillHeadProperties(eo);
			String tableName = eo.getTable().getName();
			ICoreBase iLinkCoreBase = null;
			iLinkCoreBase = WsCommonUtil.getLocalInstance(ctx, eo);
			String ids = "";
			String dateStr = obj.getDate();
			String orgNum = obj.getOrgNumber();
			try {
					ids = WsCommonExportUtil.getIDsByOrgNum(ctx, tableName, orgNum, dateStr);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (StringUtils.isNotBlank(ids)) {
				EntityViewInfo view = WsCommonExportUtil.getQueryView(ctx, headMap, ids, BosType, eo, 0);

				if (iLinkCoreBase instanceof IExchangeRate) {// ���ʴ������ʶһ���ϵ
					SelectorItemCollection sic = view.getSelector();
					sic.add(new SelectorItemInfo("exchangeAux.*"));
					view.setSelector(sic);
				}

				CoreBaseCollection coreBaseCollection = iLinkCoreBase.getCollection(view);
				logger.info("��ѯ ����==" + coreBaseCollection);
				StringBuffer jsonBuffer = new StringBuffer();

				if (iLinkCoreBase instanceof IBank) {// �������⴦��
					coreBaseCollection.clear();
					String[] id = ids.split(",");
					try {
						for (int i = 0; i < ids.length(); i++) {
							coreBaseCollection.add(((IBank) iLinkCoreBase).getBankInfo(new ObjectUuidPK(id[i].replace(
									"'", ""))));
						}
					} catch (Exception e3) {

					}
				} else if (iLinkCoreBase instanceof IExchangeRate) {

					/*
					 * SelectorItemCollection sic=view.getSelector();
					 * sic.add(new SelectorItemInfo("*"));
					 * 
					 * coreBaseCollection.clear(); String[] id = ids.split(",");
					 * try { SelectorItemInfo si=new SelectorItemInfo(); si. for
					 * (int i = 0; i < ids.length(); i++) {
					 * coreBaseCollection.add(((IExchangeRate)
					 * iLinkCoreBase).getExchangeRateInfo(new
					 * ObjectUuidPK(id[i].replace( "'", "")),null)); } } catch
					 * (Exception e3) {
					 * 
					 * }
					 */
				}

				/*
				 * CoreBaseCollection coreBaseCollection =
				 * iLinkCoreBase.getCollection(view); logger.info("��ѯ ����==" +
				 * coreBaseCollection); StringBuffer jsonBuffer = new
				 * StringBuffer();
				 */
				jsonBuffer.append("[");
				for (int nIndex = 0; nIndex < coreBaseCollection.size(); ++nIndex) {
					IObjectValue objectValue = coreBaseCollection.getObject(nIndex);
					// String ss=new Gson().toJson(objectValue);
					String objectValueJson = JSONUtils.convertObjectToJson(ctx, objectValue);
					jsonBuffer.append(objectValueJson);
					if (nIndex < coreBaseCollection.size() - 1) {
						jsonBuffer.append(",");
					}

				}

				jsonBuffer.append("]");
				logger.info("���� jsonBuffer==" + jsonBuffer);
				logger.info("-----------------�ӿڵ��óɹ�------------------------------");
				logger.info("---------------�������û������Ͻӿ�-------------");

				return jsonBuffer.toString();
			}
		}
		return null;
	}

	@Override
	protected String _getBaseDataByOrgNum(Context ctx, String queryStr) throws BOSException {
		logger.info("---------------��ʼ���û������Ͻӿ�-------------");
		System.out.println(queryStr);
		logger.info("���� dataJSON==" + queryStr.toString());

		BaseQueryBean obj = (BaseQueryBean) JSONUtils.convertJsonToObject(ctx, queryStr, BaseQueryBean.class);

		logger.info("��������� ��֯ID��" + obj.getOrgNumber() + "	���ڣ�" + obj.getDate() + "   �������ͣ�" + obj.getBosType() + "��");

		if (!(WSBosType.DataBosTypes.containsKey(obj.getBosType()))) {
			logger.error("-------------------�����ڵ������ͣ�-----------------");
			return null;
		}
		String BosType = (String) WSBosType.DataBosTypes.get(obj.getBosType());
		// �ҵ�bostype�Ķ���
		EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx, BosType);
		if (eo != null) {
			Map headMap = WsCommonImportUtil.getBillHeadProperties(eo);
			String tableName = eo.getTable().getName();
			ICoreBase iLinkCoreBase = null;
			iLinkCoreBase = WsCommonUtil.getLocalInstance(ctx, eo);
			String ids = "";
			String dateStr = obj.getDate();
			String orgNum = obj.getOrgNumber();
			try {
				if (iLinkCoreBase instanceof IAccountBank) {// �����˻���COMPANYid����
					ids = WsCommonExportUtil.getIDsByOrgNum(ctx, tableName, orgNum, dateStr);
				}else{
					ids = WsCommonExportUtil.getIDsByOrgNum(ctx, tableName, orgNum, dateStr);
				}
				logger.info("��ȡ ids==" + ids);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (StringUtils.isNotBlank(ids)) {
				EntityViewInfo view = WsCommonExportUtil.getQueryView(ctx, headMap, ids, BosType, eo, 0);

				if (iLinkCoreBase instanceof IExchangeRate) {// ���ʴ������ʶһ���ϵ
					SelectorItemCollection sic = view.getSelector();
					sic.add(new SelectorItemInfo("exchangeAux.*"));
					view.setSelector(sic);
				}

				CoreBaseCollection coreBaseCollection = iLinkCoreBase.getCollection(view);
				logger.info("��ѯ ����==" + coreBaseCollection);
				StringBuffer jsonBuffer = new StringBuffer();

				if (iLinkCoreBase instanceof IBank) {// �������⴦��
					coreBaseCollection.clear();
					String[] id = ids.split(",");
					try {
						for (int i = 0; i < ids.length(); i++) {
							coreBaseCollection.add(((IBank) iLinkCoreBase).getBankInfo(new ObjectUuidPK(id[i].replace(
									"'", ""))));
						}
					} catch (Exception e3) {

					}
				} else if (iLinkCoreBase instanceof IExchangeRate) {
					 
				}


				jsonBuffer.append("[");
				for (int nIndex = 0; nIndex < coreBaseCollection.size(); ++nIndex) {
					IObjectValue objectValue = coreBaseCollection.getObject(nIndex);
					// String ss=new Gson().toJson(objectValue);
					String objectValueJson = JSONUtils.convertObjectToJson(ctx, objectValue);
					jsonBuffer.append(objectValueJson);
					if (nIndex < coreBaseCollection.size() - 1) {
						jsonBuffer.append(",");
					}

				}

				jsonBuffer.append("]");
				logger.info("���� jsonBuffer==" + jsonBuffer);
				logger.info("-----------------�ӿڵ��óɹ�------------------------------");
				logger.info("---------------�������û������Ͻӿ�-------------");

				return jsonBuffer.toString();
			}
		}
		return null;
	}


	/**
	 * ���뵥��
	 */
	@Override
	protected String _importBill(Context ctx, String BillType, String BillJSON, int BillStatus) throws BOSException {
		System.out.println();
		System.out.println(ctx.toString());
		System.out.println("���� billType��" + BillType);
		System.out.println("���� json��������������������������������������������������������������������������������������������������");
		System.out.println(BillJSON);
		System.out.println("���� json��������������������������������������������������������������������������������������������������");
		
		logger.info("��ʼ����ҵ�񵥾ݵ�,��������" + BillType);
//		BillJSON=BillJSON.substring(1, BillJSON.length()-1);
		if (BillType.equals("ReceiveBill")) {
//			return this.importReceiveBill(ctx, BillJSON);
		} else if (BillType.equals("AROtherBill")) {
//			return this.importAROtherBill(ctx, BillJSON);
		} else if (BillType.equals("APOtherBill")) {
			//return this.importAPOtherBill(ctx, BillJSON);
		}else if (BillType.equals("CostAdjustBill")) {
			
		}
		IImportBill importBill = getImporter(ctx);
		try {
			/*
			 * String ss = JSONUtils.convertObjectToJson(ctx,
			 * ReceivingBillFactory.getLocalInstance(ctx)
			 * .getReceivingBillInfo(new
			 * ObjectUuidPK("MLZiXCfxTfGKomjcWrzL7fpE/Vs="))); return ss;
			 */
			return importBill.importing(ctx, BillType, BillJSON, BillStatus);
			
		} catch (Exception e) {
			throw new BOSException(e.getMessage());
			// return null;
		}
	}

	public IImportBill getImporter(Context ctx) {
		return new WMImportBill();
	}


	/**
	 * �������ϵ���
	 * 
	 * @param ctx
	 * @param billType
	 * @param dataJSON
	 * @param billStatus
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	// 0 ���� 3���� 4 �ύ
	protected String _ImpBaseData(Context ctx, String billType, String dataJSON, int billStatus) throws BOSException {
		IImportBaseData importBill = getImporterBaseData(ctx);
		try {
			return importBill.importing(ctx, billType, dataJSON, billStatus);
		} catch (EASBizException e) {
			throw new BOSException(e.getMessage());
		}
	}

	public IImportBaseData getImporterBaseData(Context ctx) {
		return new WMImportBase();
	}

	/**
	 * �����տ
	 * 
	 * @param ctx
	 * @param json
	 * @return
	 * @throws BOSException
	 */
	private String importReceiveBill(Context ctx, String BillJSON) throws BOSException {
		logger.info("��ʼ�����տ" + BillJSON);
		String xmlData = JSONWithXML.json2XML(BillJSON,"ReceivingBill");
		String[] resultStr = ReceiveBillFacadeFactory.getLocalInstance(ctx).submit(xmlData);
		// String[] resultStr=new
		// ReceiveBillCustomControllerBean().submit(ctx,xmlData);
		String resultJson = null;
		String code = "", tag = "", message = "";
		if (resultStr.length == 1) {
		} else if (resultStr.length > 1) {
			code = resultStr[1];
			tag = resultStr[2];
			message = resultStr[3];
		} else {
			code = "9999";
			tag = "����ʧ��";
			message = "δ֪����";
		}
		resultJson = "{\"result\":\"" + resultStr[0] + "\",\"code\":\"" + code + "\",\"tag\":\"" + tag
				+ "\",\"message\":\"" + message + "\"}";
		logger.info("�տ�������");
		return resultJson;
	}

	/**
	 * ����Ӧ�յ�
	 * 
	 * @param ctx
	 * @param json
	 * @return
	 * @throws BOSException
	 */
	private String importAROtherBill(Context ctx, String BillJSON) throws BOSException {
		logger.info("��ʼ����Ӧ�յ�" + BillJSON);
		String xmlData = JSONWithXML.json2XML(BillJSON,"OtherBill");
		// String[]
		// resultStr=ReceiveBillFacadeFactory.getLocalInstance(ctx).submit
		// (xmlData);
		String[] resultStr = com.kingdee.eas.fi.ar.app.webservice.OtherBillFacadeFactory.getLocalInstance(ctx).submit(
				xmlData);
		String resultJson = null;
		String code = "", tag = "", message = "";
		if (resultStr.length == 1) {
		} else if (resultStr.length > 1) {
			code = resultStr[1];
			tag = resultStr[2];
			message = resultStr[3];
		} else {
			code = "9999";
			tag = "����ʧ��";
			message = "δ֪����";
		}
		resultJson = "{\"result\":\"" + resultStr[0] + "\",\"code\":\"" + code + "\",\"tag\":\"" + tag
				+ "\",\"message\":\"" + message + "\"}";
		logger.info("Ӧ�����������");
		return resultJson;
	}

	/**
	 * ����Ӧ����
	 * 
	 * @param ctx
	 * @param json
	 * @return
	 * @throws BOSException
	 */
	private String importAPOtherBill(Context ctx, String BillJSON) throws BOSException {
		logger.info("��ʼ����Ӧ����" + BillJSON);
		String xmlData = JSONWithXML.json2XML(BillJSON,"POtherBill");
		// String[]
		// resultStr=ReceiveBillFacadeFactory.getLocalInstance(ctx).submit
		// (xmlData);
		String[] resultStr = com.kingdee.eas.fi.ap.app.webservice.OtherBillFacadeFactory.getLocalInstance(ctx).submit(
				xmlData);
		String resultJson = null;
		String code = "", tag = "", message = "";
		if (resultStr.length == 1) {
		} else if (resultStr.length > 1) {
			code = resultStr[1];
			tag = resultStr[2];
			message = resultStr[3];
		} else {
			code = "9999";
			tag = "����ʧ��";
			message = "δ֪����";
		}
		resultJson = "{\"result\":\"" + resultStr[0] + "\",\"code\":\"" + code + "\",\"tag\":\"" + tag
				+ "\",\"message\":\"" + message + "\"}";
		logger.info("Ӧ�����������");
		return resultJson;
	}
}