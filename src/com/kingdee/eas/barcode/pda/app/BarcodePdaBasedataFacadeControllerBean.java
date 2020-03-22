package com.kingdee.eas.barcode.pda.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTMappingUtil;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.kingdee.eas.barcode.pda.BarcodeLicenseUtils;
import com.kingdee.eas.barcode.pda.BarcodePDARecodeInfo;
import com.kingdee.eas.barcode.pda.BarcodePDAScanning;
import com.kingdee.eas.barcode.pda.BarcodeServiceConstants;
import com.kingdee.eas.barcode.pda.FileObject;
import com.kingdee.eas.barcode.pda.QuantityUtil;
import com.kingdee.eas.barcode.pda.XmlSerHelper;
import com.kingdee.eas.barcode.scm.BarcodeAnalysisResult;
import com.kingdee.eas.barcode.scm.BarcodeAnalysisResultItem;
import com.kingdee.eas.barcode.scm.BarcodeConfigFactory;
import com.kingdee.eas.barcode.scm.BarcodeConfigInfo;
import com.kingdee.eas.barcode.scm.BarcodeConfigXML;
import com.kingdee.eas.barcode.scm.BarcodeConfigXMLDetail;
import com.kingdee.eas.barcode.scm.BarcodeConfigXMLProperty;
import com.kingdee.eas.barcode.scm.BarcodeDefaultSolutionFactory;
import com.kingdee.eas.barcode.scm.BarcodeDefaultSolutionInfo;
import com.kingdee.eas.barcode.scm.BarcodeDefaultXMLInfo;
import com.kingdee.eas.barcode.scm.BarcodeDefaultXMLItem;
import com.kingdee.eas.barcode.scm.BarcodeScanningFactory;
import com.kingdee.eas.barcode.scm.BarcodeScanningRecodeInfo;
import com.kingdee.eas.barcode.scm.BarcodeUploadFacadeFactory;
import com.kingdee.eas.barcode.scm.BarcodeWSException;
import com.kingdee.eas.barcode.scm.BarcodeXMLHelper;
import com.kingdee.eas.barcode.scm.IBarcodeScanning;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.form.ide.utils.EntityObjectInfoHelp;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.IBizType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.framework.IObjectBase;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.scm.im.inv.TaskStatusEnum;
import com.kingdee.eas.scm.util.constant.BizConstant;
import com.kingdee.eas.util.ResourceBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

public class BarcodePdaBasedataFacadeControllerBean extends AbstractBarcodePdaBasedataFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.barcode.pda.app.BarcodePdaBasedataFacadeControllerBean");
    
    private String resourceBaseStr="com.kingdee.eas.barcode.scm.BARCODEAutoGenerateResource";
    /**
     * csName 类名
     * methodName 方法名
     * argumenAry   参数数组
     * return String（<Header>UWBCDtResponse</Header><Return>1|2|</Return><Tailer>UWBCEnd</Tailer>）
     */
    protected String _getMethod(Context ctx, String argumentXml) throws BOSException, EASBizException
    {    	
    	logger.info("_getMethod,argumentXML:"+argumentXml);
    	Map<String,String> argumentMap=parseXml(argumentXml);
    	String CsName=argumentMap.get("CsName");
    	String function=argumentMap.get("Function");
    	String paramsStr=argumentMap.get("Params");
    	Object[] arrStr=paramsStr.split("\\|");
    	try {
			Class<?>  barcodeBaseDataClass=Class.forName(CsName);
			Object object=PrivateUtil.invoke(barcodeBaseDataClass.newInstance(), function, 
					new Class[]{Context.class,Object[].class}, new Object[]{ctx,arrStr});
			return object==null?"":object.toString();
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(new NumericExceptionSubItem("",e.fillInStackTrace().getMessage()));
		} catch (IllegalArgumentException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(BarcodeWSException.DATABULL);
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(new NumericExceptionSubItem("",e.getTargetException().getMessage()));
		} catch (SecurityException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(BarcodeWSException.DATABULL);
		} catch (NoSuchMethodException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(BarcodeWSException.METHODNULL);
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(BarcodeWSException.DATABULL);
		} catch (InstantiationException e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(BarcodeWSException.DATABULL);
		} catch (Exception e) {
			logger.info(e.getMessage(),e);
			throw new BarcodeWSException(new NumericExceptionSubItem("",e.getMessage()));
		}
    }
    
    private Map<String,String> parseXml(String argumentStr){
	    Map<String,String>  xmlMap=new HashMap<String, String>();
	    	Reader strR = null;
			SAXBuilder builder = new SAXBuilder();
			Document doc = null;
			strR = new StringReader(argumentStr);
			try {
				doc = builder.build(strR);
				Element  root = doc.getRootElement();
				List cNodes = root.getChildren();
				List paremList=root.getChildren("Params");
				 for(int j=0;j<cNodes.size();j++){
					 Element xet = (Element) cNodes.get(j);
					 for(int i=0,size=xet.getContent().size();i<size;i++){
						Object content=xet.getContent().get(i);
						if(content instanceof org.jdom.Text){
							String key=xet.getName();
							String value=((org.jdom.Text)xet.getContent().get(i)).getText();
							if(!xmlMap.containsKey(key)){
								xmlMap.put(key, value);
							}
						}
					 }
				 }
				StringBuffer sbf=new StringBuffer();
				 for(int j=0;j<paremList.size();j++){
					 Element xet = (Element) paremList.get(j);
					 for(int i=0,size=xet.getContent().size();i<size;i++){
							Object content=xet.getContent().get(i);
							if(content instanceof Element){
								Element paEle=(Element)content;
								if(paEle.getContent().size()>0){
									String value=((org.jdom.Text)paEle.getContent().get(0)).getText();
									if(sbf.length()>0){
										sbf.append("|").append(value);
									}else{
										sbf.append(value);
									}
								}
							}
					 }
				 }
				 xmlMap.put("Params", sbf.toString());
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return xmlMap;
	
    }
    /**
     * PDA数据生成EAS业务单据
     */
	protected String _importBill(Context ctx, String xmlStr)throws BOSException, EASBizException {
			String rtnMsg = null;
			EASBizException ex = null;
			Locale locale = ctx.getLocale();
			
			logger.info("PDA传过来xml格式:");
			logger.info(xmlStr);
			try {
				rtnMsg = parseXmlSaveInfo(ctx, xmlStr);
			} catch (BarcodeWSException e) {
				logger.info(" biz exception, failed",e);
				throw new BarcodeWSException(BarcodeWSException.BILLFAILE,new Object[]{e.getMessage()});
			} catch (Exception e) {
				logger.info(" failed, unknown exception ", e);
				throw new BarcodeWSException(BarcodeWSException.BILLFAILE,new Object[]{e.getMessage()});
			}
			logger.info("rtnMsg: " + rtnMsg);
	
			return rtnMsg;
	}
	/*
	 * --生成单据XML
	<BarcodeScanningRecodeInfo>
	<userNumber>用户名称</userNumber>
	<BarcodeConfigId></BarcodeConfigId>--扫描配置ID
	<billInfoList>
		<parentProperties>--表头属性
		--<barcode></barcode>
		<表头属性名>value</表头属性名>
		</parentProperties>
		<details>
		<Row>
		<fsrcBillId>源单ID</fsrcBillId>
		<fsrcEntryId>源单分录ID</fsrcEntryId>
		<barcodeList>
		<barcode></barcode>
		<barcode></barcode>
		</barcodeList>
		<表体属性名>value</表体属性名>
		</Row>
		<Row>
		<fsrcBillId>源单ID</fsrcBillId>
		<fsrcEntryId>源单分录ID</fsrcEntryId>
		<barcodeList>
		<barcode></barcode>
		<barcode></barcode>
		</barcodeList>
		</Row>
		</details>
	</billInfoList>
	</BarcodeScanningRecodeInfo>
	 */
	private String parseXmlSaveInfo(Context ctx, String xmlStr)throws BarcodeWSException, Exception {
	
		if (StringUtils.isEmpty(xmlStr)) {
			logger.info(" xmlStr is null");
			throw new BarcodeWSException(BarcodeWSException.NULL_XML);
		}
		
		long time = System.currentTimeMillis();
		logger.info(" parseRecodeXml begin："+time);
		List<BarcodePDARecodeInfo>  barcodePDARecodeInfoList=XmlSerHelper.parseRecodeXml(ctx,xmlStr);
		BarcodeConfigInfo barcodeConfigInfo=null;
		List<BarcodeScanningRecodeInfo>  recodeList=new ArrayList<BarcodeScanningRecodeInfo>();
		String defaultSolutionId=null;
		String srcBosType=null;
		String bosType=null;
		String botpId=null;
		for(int i=0,size=barcodePDARecodeInfoList.size();i<size;i++){
			BarcodePDARecodeInfo pdaRecodeInfo=barcodePDARecodeInfoList.get(i);
			defaultSolutionId=pdaRecodeInfo.getDefaultSolutionId();
			barcodeConfigInfo=pdaRecodeInfo.getConfigInfo();
			srcBosType=barcodeConfigInfo.getSrcBosType();
			bosType=barcodeConfigInfo.getDestBosType();
			botpId=barcodeConfigInfo.getBotMapping()!=null?barcodeConfigInfo.getBotMapping().getId().toString():null;
			recodeList.add(pdaRecodeInfo.getScanningRecodeInfo());
		}
		time=System.currentTimeMillis() - time;
		logger.info(" parseRecodeXml end,totalTime=："+time);
		String number=null;
		if(recodeList.size()>0){
			number=BarcodeUploadFacadeFactory.getLocalInstance(ctx).uploadBarcodeBill(recodeList, defaultSolutionId,srcBosType, bosType, botpId);
		}
		 
		if(number!=null && !"".equals(number)){
			String billStr=getMassege(ctx, "211_PDABILL")+"【"+number+"】"+getMassege(ctx, "210_PDABILL");
			return billStr;
		}else{
			return null;
		}
	}

    /**
     * 源单查询 1、扫描配置ID，2、源单编码，3、仓库的编码（盘点（bosType：D9D2CA5D）的时候
     *return  <BarcodeScanningRecodeInfo>
	 * <BarcodeConfigId></BarcodeConfigId>--扫描配置ID
	 * <表头属性名 value='' ,alias='',isUnVisable=''>value</表头属性名>
	 * <b_entry_bostype>
	 *  <Row>
			<表体属性名 value='' alias='表体列名称' isUnVisable='是否显示' isScanQty='是否扫描数量' aliasName='别名' >value</表体属性名>
		</Row>
	  </<b_entry_bostype>>
	 </BarcodeScanningRecodeInfo>
     * @param argumentStr
     * @return
     * @throws BOSException 
     */
    public String getSrcBillList(Context ctx,Object[] argumentArg)throws EASBizException, BOSException{
    	if(argumentArg.length<-1){
    		return null;
    	}
    	String barcodeConfigID=argumentArg[0].toString();//扫描配置
    	String billNumber=argumentArg[1].toString();//源单编码
    	
		BarcodeConfigInfo configInfo;
		configInfo = BarcodeConfigFactory.getLocalInstance(ctx).getBarcodeConfigInfo(new ObjectUuidPK(barcodeConfigID));
		if(configInfo==null){
			throw new BarcodeWSException(BarcodeWSException.CONFIGISNULL);
		}
		String warehouseNumber=null;
		if(QuantityUtil.COUNTINGTABLE_BOSTYPE.equalsIgnoreCase(configInfo.getDestBosType())){
			if(argumentArg.length>2){
				warehouseNumber=argumentArg[2].toString();
			}
		}
		IObjectCollection objectColl = (IObjectCollection)getDestBill(ctx,configInfo,billNumber,warehouseNumber);//获取目标单数据
		
		if (objectColl != null && objectColl.size() > 0) {
			IObjectValue billValue=(IObjectValue) objectColl.getObject(0);
			String srcBillStr=fillBilldata(ctx,billValue,configInfo);
			return srcBillStr;
		}else{
			//没数据
			throw new BarcodeWSException(BarcodeWSException.QUERYNULL,new Object[]{billNumber});
		}
    }
    
    /**
     * 源单数据传给PDA
     * @param ctx
     * @param billValue
     * @param configInfo
     * @return
     * @throws EASBizException
     * @throws BOSException
     */
    private String fillBilldata(Context ctx,IObjectValue billValue,BarcodeConfigInfo configInfo) throws EASBizException, BOSException{
    	StringBuffer parentXml=new StringBuffer();
    	parentXml.append(getXmlStr("id",billValue.get("id"),"id",false,false,"id")).append("\n");
    	String bosType="";
    	IBarcodeScanning  barcodeScanning= BarcodeScanningFactory.getLocalInstance(ctx);
    	BarcodeConfigXML xmlInfo = BarcodeXMLHelper.toBarcodeConfigXML(configInfo.getDetailsXML());
    	StringBuffer detailsXml=new StringBuffer();
		for(int i=0,size=xmlInfo.getDetails().size();i<2;i++){
			BarcodeConfigXMLDetail  xmlDetail=xmlInfo.getDetails().get(i);
			String parentBosType=xmlDetail.getParentBosType();
			List<BarcodeConfigXMLProperty>  xmlPropertys=xmlDetail.getProperties();
			boolean isEntryBoType=false;
			if(parentBosType!=null && !"".equals(parentBosType)){//分录
				isEntryBoType=true;
				bosType="b_"+xmlDetail.getName()+"_"+xmlDetail.getBosType();
			}
			if(!isEntryBoType){
				getLinkedPropertyXML(ctx,xmlPropertys, billValue,barcodeScanning, parentXml,configInfo.getDestBosType());
			}else{
				IObjectCollection entryColl = (IObjectCollection) billValue.get(xmlDetail.getName());
				detailsXml.append("<").append(bosType).append("> \n");
				for(int k=0,m=entryColl.size();k<m;k++){
					IObjectValue entryValue = entryColl.getObject(k);
					detailsXml.append("<Row>").append("\n");
					getLinkedPropertyXML(ctx,xmlPropertys, entryValue,barcodeScanning, detailsXml,configInfo.getDestBosType());
					
					detailsXml.append("</Row>").append("\n");
			}
			detailsXml.append("</").append(bosType).append(">\n");
		}
	}
		StringBuffer xmlStr=new StringBuffer();
    	xmlStr.append("<SrcBillInfo>").append("\n");
    	xmlStr.append(parentXml).append("\n");
        xmlStr.append(detailsXml).append("\n");
    	xmlStr.append("</SrcBillInfo>").append("\n");
		return packageReturnXml(xmlStr.toString());
   }
		
	private void getLinkedPropertyXML(Context ctx,List<BarcodeConfigXMLProperty>  xmlPropertys,IObjectValue entryValue,
			IBarcodeScanning  barcodeScanning,StringBuffer detailsXml,String destBosType) throws EASBizException, BOSException{
		for (int j = 0; j < xmlPropertys.size(); j++) {
			BarcodeConfigXMLProperty property = xmlPropertys.get(j);
			String fullName=property.getFullName();
			String key = fullName;
			key = key.substring(key.lastIndexOf(".") + 1);
			if (property.isLinkedProperty()) {// 连接属性显示编码和名称
				String filedNumber = key + "_" + "number";
				String filedName = key + "_" + "name";
				Object linkValue = entryValue.get(property.getName());
				if (linkValue != null) {
					IObjectValue objectValue = (IObjectValue) linkValue;
					Object number = objectValue.get("number");
					boolean isMaterialInfo=false;
					if (number == null && objectValue.get("id") != null) {
						//TODO 
						objectValue = (IObjectValue)barcodeScanning.getIObjectValueById(objectValue.get("id").toString());
					}
					if(objectValue instanceof MaterialInfo){
						isMaterialInfo=true;
					}
					String numberAlias=(property.getAlias() + getMassege(ctx, "145_BarcodeScanningEditUI"));
					String nameAlias=(property.getAlias() + getMassege(ctx, "103_BarcodeDefaultTablePanel"));
					
					detailsXml.append(getXmlStr(filedNumber,objectValue.get("number"),numberAlias,property.isUnVisable(),property.isScanQty(),
							isMaterialInfo?QuantityUtil.MATERIALNUMBER:filedNumber)).append("\n");
					detailsXml.append(getXmlStr(filedName,objectValue.get("name"),nameAlias,property.isUnVisable(),property.isScanQty(),
							isMaterialInfo?QuantityUtil.MATERIALNAME:filedName)).append("\n");
				
			}else{
				detailsXml.append(getXmlStr(fullName,entryValue.get(key),property.getAlias(),property.isUnVisable(),property.isScanQty(),key)).append("\n");
			}
		}else if (property.isScanQty()){
			String srcQtyStr=getMassege(ctx, "146_BarcodeScanningEditUI");
			if(entryValue.get(key) instanceof BigDecimal){
				if(entryValue.get(key)!=null){
					BigDecimal	qty=(BigDecimal)entryValue.get(key);
					if(qty.compareTo(BigDecimal.ZERO)==0){
						entryValue.put(key, BigDecimal.ZERO);
					}
				}
			}
			if(QuantityUtil.COUNTINGTABLE_BOSTYPE.equalsIgnoreCase(destBosType)){
				detailsXml.append(getXmlStr("fsrcQty",entryValue.get("accountQty"),srcQtyStr,true,false,"fsrcQty")).append("\n");//来源数量=账面数量
				detailsXml.append(getXmlStr(fullName,entryValue.get(key),property.getAlias(),true,property.isScanQty(),fullName)).append("\n");//扫描数量
			}else{
				detailsXml.append(getXmlStr(fullName,BigDecimal.ZERO,property.getAlias(),true,property.isScanQty(),fullName)).append("\n");//扫描数量
				detailsXml.append(getXmlStr("fsrcQty",entryValue.get(key),srcQtyStr,true,false,"fsrcQty")).append("\n");//来源数量
			}
			//初始化差异数量
			String difQtyStr=getMassege(ctx, "148_BarcodeScanningEditUI");
			detailsXml.append(getXmlStr("fdifQty",entryValue.get(key),difQtyStr,true,false,"fdifQty")).append("\n");
		} else {
			detailsXml.append(getXmlStr(fullName,entryValue.get(key),property.getAlias(),property.isUnVisable(),property.isScanQty(),fullName)).append("\n");
		}
	}
	detailsXml.append(getXmlStr("fid",entryValue.get("id"),"fid",false,false,"fid")).append("\n");
	detailsXml.append(getXmlStr("fsrcBillId",entryValue.get("sourceBillId"),"sourceBillId",false,false,"fsrcBillId")).append("\n");
	detailsXml.append(getXmlStr("fsrcEntryId",entryValue.get("sourceBillEntryId"),"sourceBillEntryId",false,false,"fsrcEntryId")).append("\n");
}
    
    private String getXmlStr(String propertyName,Object value,String alias,boolean isUnVisable,boolean isScanQty,String aliasName){
    	if(value==null){
    		value="";
    	}
    	StringBuffer xmlStr=new StringBuffer();
    	xmlStr.append("<").append(propertyName).append(" value='").append(value).append("' alias='").append(alias).append("' isUnVisable='")
    	.append(isUnVisable).append("' isScanQty='").append(isScanQty).append("' aliasName='").append(aliasName).append("'/>");
    	return xmlStr.toString();
    }
	
    /**
     * 按照源单条码生成目标单
     * @param ctx
     * @param configInfo
     * @param billNumber
     * @return
     * @throws BOSException
     * @throws EASBizException
     */
    private Object getDestBill(Context ctx,BarcodeConfigInfo configInfo,String billNumber,String warehouseNumber)throws BOSException, EASBizException {
    	String botpID=null;
    	if(configInfo.getBotMapping()!=null){
    		botpID=configInfo.getBotMapping().getId().toString();
    	}
		String srcBosType=configInfo.getSrcBosType();
		ICoreBillBase iCoreBase;
		try {
			if(QuantityUtil.COUNTINGTABLE_BOSTYPE.equalsIgnoreCase(configInfo.getDestBosType())){
				if(warehouseNumber==null || "".equals(warehouseNumber)){//盘点仓库不能为空
					throw new BarcodeWSException(BarcodeWSException.CONTINGERROR);
				}
				srcBosType=QuantityUtil.COUNTINGTASK_BOSTYPE;
			}
			iCoreBase = (ICoreBillBase)BOSObjectFactory.createBOSObject(ctx,BOSObjectType.create(srcBosType));
		} catch (BOSException e) {
			throw new BarcodeWSException(BarcodeWSException.BOSTYPENULL,new Object[]{srcBosType});//
		}//源单对象
		
		IObjectCollection destBillColl = new ObjectBaseCollection();
		EntityViewInfo view=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number",billNumber,CompareType.EQUALS));
		view.setFilter(filter);
		CoreBillBaseCollection coll;
		
		coll = iCoreBase.getCoreBillBaseCollection(view);
		if(coll==null || coll.size()==0){
			//没有符合条件的记录
			throw new BarcodeWSException(BarcodeWSException.SRCBILLNUMBERNULL);//扫描条码不存在
		}
		CoreBillBaseInfo info = coll.get(0);
		if (srcBosType != null && !srcBosType.equals("")) {
			if (!srcBosType.toString().equals(QuantityUtil.COUNTINGTASK_BOSTYPE)) {
				// 有来源单,根据botp取目标单
				IBTPManager ibtp = BTPManagerFactory.getLocalInstance(ctx);
				BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getBOTMappingInfo(new ObjectUuidPK(botpID));
				BTPTransformResult result = ibtp.transform(info, botMappingInfo);
				IObjectCollection resultCol = result.getBills();
				destBillColl.addObject(resultCol.getObject(0));
			}else{
				// 如果是盘点任务，则取盘点任务+仓库确定唯一的对应的开始盘点的盘点表
				StringBuffer sql=new StringBuffer();
				sql.append(getSelectFields());
				sql.append("  where countingTask.id = '").append(info.getId().toString()).append("'");
				sql.append(" and countingTask.taskStatus=").append(TaskStatusEnum.BEGINCOUNTING_VALUE);
				sql.append(" and warehouse.number='").append(warehouseNumber).append("'");
				IObjectCollection collCount = ((IObjectBase) BOSObjectFactory.createBOSObject(ctx, BOSObjectType.create(QuantityUtil.COUNTINGTABLE_BOSTYPE))).getObjectBaseCollection(sql.toString());
				destBillColl.addObjectCollection(collCount);
		   }
		}
		
		return destBillColl;
    }
    /**
	 * 为了性能更好，请确定字段，不要用*代替
	 * @return
	 */
	private String getSelectFields() {
		String select = "select *,storageOrgUnit.number,storageOrgUnit.name,warehouse.number,warehouse.name,countingPerson.number,countingPerson.name"
				+ ",countingAgainPerson.number,countingAgainPerson.name,countingMonitorer.number,entry.*,entry.location.number,entry.location.name,entry.material.number"
				+ ",entry.material.name,entry.storeType.number,entry.storeType.name,entry.unit.number,entry.unit.name,entry.assistUnit.number,entry.assistUnit.name"
				+ ",entry.storeStatus.number,entry.storeStatus.name";
		return select;
	}
    
    /**
     * 条码集合（解析条码）
     * @param argumentStr
     * @return
     * @throws BOSException 
     */
    public String getBarcodeList(Context ctx,Object[] argumentArg) throws BOSException,EASBizException{
    	if(argumentArg.length<-1){
    		throw new BarcodeWSException(BarcodeWSException.BARCOEDNULLDATA);//扫描条码不存在
    	}
    	String barcode=argumentArg[0].toString();
    	String configId=argumentArg[1].toString();
    	
		BarcodePDAScanning pdaScanning=new BarcodePDAScanning();
		//BarcodeAnalysisResult  analysisResult=pdaScanning.executeBarcode(ctx, barcode,configId);//加扫描配置ID
		
//		if(analysisResult==null){
//			throw new BarcodeWSException(BarcodeWSException.BARCODENULL);//扫描条码不存在
//		}
//		
//		List<BarcodeAnalysisResultItem>  resultItem=analysisResult.getItems();
//		StringBuffer valueStr=new  StringBuffer();
//		for(int i=0,size=resultItem.size();i<size;i++){
//			BarcodeAnalysisResultItem item=resultItem.get(i);
//			if(i==0){
//				valueStr.append(getBarcodeStr("barcode",barcode,false,ResourceBase.getString(resourceBaseStr,"barcode",ctx.getLocale())));
//				valueStr.append(getBarcodeStr("barcodeRuleId",item.getBarcodeRuleId(),false,
//						ResourceBase.getString(resourceBaseStr,"barcodeRuleId",ctx.getLocale())));
//				valueStr.append(getBarcodeStr("isCumsumQty",Boolean.toString(analysisResult.isCumsumQty()),false,
//						ResourceBase.getString(resourceBaseStr,"isCumsumQty",ctx.getLocale())));
//				valueStr.append(getBarcodeStr("isBarcodeRepeat",Boolean.toString(analysisResult.isBarcodeRepeat()),false,
//						ResourceBase.getString(resourceBaseStr,"isBarcodeRepeat",ctx.getLocale())));
//			}
//			if(item.getValue()==null){
//				item.setValue("");
//			}
//			
//			if(item.isLinkedProperty()){
//				valueStr.append(getBarcodeStr(item.getNumberProperty(),item.getValue(),item.getIsMatchItem(),item.getAlias()));
//				valueStr.append(getBarcodeStr(item.getNameProperty(),item.getValue(),false,item.getAlias()));
//				
//			}else{
//				valueStr.append(getBarcodeStr(item.getField(),item.getValue(),item.getIsMatchItem(),item.getAlias()));
//			}
//			
//		}
		 //return packageReturnXml(valueStr.toString());
		 return "";
    }
    
    private String getBarcodeStr(String properyName,Object properyValue,boolean isMatchItem,String alias){
    	StringBuffer valueStr=new StringBuffer();
    	valueStr.append("<").append(properyName).
    	append("  value='").append(properyValue).append("'").
		append("  isMatchItem='").append(isMatchItem).append("'").
		append("  aliasName='").append(alias).append("'").
		append("/>").append("\n");
    	return valueStr.toString();
    	
    }
    /**
     * 校验基础资料
     * @param ctx
     * @param argumentArg   1、 //编码值，2、属性名称 3、属性名对应的BosType
     * @return
     * @throws BOSException
     * @throws EASBizException
     */
    public String getBaseData(Context ctx,Object[] argumentArg) throws BOSException,EASBizException{
    	if(argumentArg.length<2){
    		//参数输入错误！
    		throw new BarcodeWSException(new NumericExceptionSubItem("",getMassege(ctx, "argumentError")));
    	}
    	String number=argumentArg[0].toString();//编码
    	String name=argumentArg[1].toString();//属性名称
    	String bosType=argumentArg[2].toString();//属性名对应的BosType
    	
    	if(number==null || name==null || bosType==null){
    		////参数输入错误！
    		throw new BarcodeWSException(new NumericExceptionSubItem("",getMassege(ctx, "argumentError")));
    	}
    	EntityObjectInfo entity = EntityObjectInfoHelp.getEntity(BOSObjectType.create(bosType));
    	String key=name.substring(0,name.indexOf("_"));
    	PropertyInfo property = entity.getPropertyByName(key);
		if (property != null) {
			if(property instanceof LinkPropertyInfo){
				EntityObjectInfo entryEntity=((LinkPropertyInfo)property).getRelationship().getSupplierObject();
				ICoreBase	iCoreBase = (ICoreBase)BOSObjectFactory.createBOSObject(
						ctx,BOSObjectType.create(entryEntity.getType().toString()));
				EntityViewInfo view=new EntityViewInfo();
				SelectorItemCollection coll=new SelectorItemCollection();
				coll.add(new SelectorItemInfo("id"));
				coll.add(new SelectorItemInfo("name"));
				coll.add(new SelectorItemInfo("number"));
				view.setSelector(coll);
				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("number",number,CompareType.EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("name",number,CompareType.EQUALS));
				filter.setMaskString("#0 or #1");
				view.setFilter(filter);
				CoreBaseCollection  coreBaseCol=iCoreBase.getCollection(view);
				if(coreBaseCol.size()>0){
					CoreBaseInfo info=coreBaseCol.get(0);
					 StringBuffer sqlStr=new StringBuffer();
					 sqlStr.append("<").append(name).append("  value='").append(info.get("number")).append("'/>").append("\n");
					 sqlStr.append("<").append(key+"_name").append("  value='").append(info.get("name")).append("'/>").append("\n");
					return packageReturnXml(sqlStr.toString());
				}else{
					//找不到数据！
					throw new BarcodeWSException(new NumericExceptionSubItem("","【"+number+"】"+getMassege(ctx, "dataNotfund")));
				}
			}
		} 
		return null;
    }
    
 
	/**
	 * 事物类型
	 * @param ctx
	 * @param argumentArg
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
    public  String  getTransactionType(Context ctx,Object[] argumentArg) throws BOSException, EASBizException{
    	if(argumentArg.length<-1){
    		//"参数输入错误！"
    		throw new BarcodeWSException(new NumericExceptionSubItem("",getMassege(ctx, "argumentError")));
    	}
    	    String bosType = argumentArg[0].toString();//单据BOSTYPE 如：采购入库单单头BOTYPE而不是分录的
    	    String defaultSolutionId=null;
    	    if(argumentArg.length>1){
    	    	defaultSolutionId=argumentArg[1].toString();//默认方案
    	    }
    	    BillTypeInfo billType =  BillTypeFactory.getLocalInstance(ctx).getBillTypeInfo("where bosType='"+bosType+"'");;
    		if(billType==null){
    			return null;
    		}
    		String bizTypeNumber=null;
    		if(defaultSolutionId!=null && !"".equals(defaultSolutionId)){
    			BarcodeDefaultSolutionInfo solInfo=BarcodeDefaultSolutionFactory.getLocalInstance(ctx).getBarcodeDefaultSolutionInfo(new ObjectUuidPK(defaultSolutionId));
    			BarcodeDefaultXMLInfo defaultXmlInfo=BarcodeXMLHelper.toBarcodeDefaultXMLInfo(solInfo.getDetailsXML());
    			for(int i=0;i<defaultXmlInfo.getItems().size();i++){
    				BarcodeDefaultXMLItem item=defaultXmlInfo.getItems().get(i);
    				String fullField=item.getField();
    				if("bizType".equalsIgnoreCase(fullField)){
    					bizTypeNumber=item.getValue();
    					break;
    				}
    			}
    		}
    	    StringBuffer sqlStr=new StringBuffer();
     	    sqlStr.append("select distinct type.fnumber fnumber,type.fname_l2 fname_l2 ").append("\n");
     	    sqlStr.append("from T_SCM_TransactionType type").append("\n");
     	    sqlStr.append("left join T_SCM_TransBizType tranBizType on  tranBizType.FTransactionTypeID=type.fid").append("\n");
     	    sqlStr.append("left join T_SCM_BizType bizType on bizType.fid=tranBizType.FBizTypeID").append("\n");
     	    sqlStr.append("where 1=1 ").append("\n");
     	    sqlStr.append("and type.fstatus=1").append("\n");
     	    sqlStr.append("and type.fbillTypeId='").append(billType.getId()).append("' \n");
     	    if(bizTypeNumber!=null && !"".equals(bizTypeNumber)){
     	    	sqlStr.append("and bizType.fnumber='").append(bizTypeNumber).append("' \n");
     	    }
     	    
     	   IRowSet  rs=DbUtil.executeQuery(ctx, sqlStr.toString());
     	   
     	  StringBuffer valueStr=new StringBuffer();
		  try {
			 ResultSetMetaData rsd= rs.getMetaData();
			while(rs.next()){
				valueStr.append("<transactionInfo ");
				for(int i=1,size=rsd.getColumnCount();i<=size;i++){
					String columnName=rsd.getColumnName(i);
					String value=rs.getString(columnName);
					valueStr.append(columnName).append("='").append(value).append("' ").append("\n");
				}
				valueStr.append("/>").append("\n");
			}
		} catch (SQLException e) {
			throw new BarcodeWSException(BarcodeWSException.DATABULL);
		}
		
		return packageReturnXml(valueStr.toString());
    }
   
    /**
     * 辅助属性
     * @param ctx
     * @param argumentStr
     * @return
     * @throws BOSException 
     * @throws BOSException
     * @throws EASBizException 
     */
    public String  getAsstAttrValue(Context ctx,Object[] argumentArg) throws BOSException, EASBizException {
    	if(argumentArg.length<-1)return null;
        String asstAttrNumber=argumentArg[0].toString();    	
    	 if(asstAttrNumber==null || "".equals(asstAttrNumber))return null;
    	 StringBuffer sql=new StringBuffer();
    	 sql.append(" select fid,fnumber from T_BD_AsstAttrValue where fnumber='").append(asstAttrNumber).append("'");
		  IRowSet  rs=DbUtil.executeQuery(ctx, sql.toString());
		  return packageReturnXml(getValueStr(rs,asstAttrNumber));
    }
    
    /**
     * 检查是否启用批次
     * @param ctx
     * @param argumentStr
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    public String checkMaterialInventory(Context ctx,Object[] argumentArg) throws BOSException, EASBizException{
    	if(argumentArg.length<-1)return null;
    	 String materialID=argumentArg[0].toString();     //物料ID	
    	 String orgUnit=argumentArg[1].toString();   //组织ID
    	 StringBuffer sql=new StringBuffer();
    	 sql.append(" select FIsBatchNo from T_BD_MaterialInventory").append("\t\n");
    	 sql.append(" where 1=1").append("\t\n");
    	 sql.append(" and fmaterialid ='").append(materialID).append("' \t\n");
    	 sql.append(" and FOrgUnit ='").append(orgUnit).append("' \t\n");
    	 
		 IRowSet  rs=DbUtil.executeQuery(ctx, sql.toString());
		 return packageReturnXml(getValueStr(rs,materialID));
    }
    
    /**
     * 查询仓库
     * @param ctx
     * @param argumentStr
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    public String getWareHouse(Context ctx,Object[] argumentArg) throws BOSException, EASBizException{
    	if(argumentArg.length<-1)return null;
    	 String warehouseNumber=argumentArg[0].toString();    //仓库ID
    	 StringBuffer sql=new StringBuffer();
    	 sql.append(" select fid,fnumber as warehouse_number ,fname_l2 as warehouse_name, fhaslocation from T_DB_WAREHOUSE ").append("\t\n"); 
    	 sql.append(" where 1=1").append("\t\n");
    	 sql.append(" and FNumber ='").append(warehouseNumber).append("' \t\n");
    	 
    	 
    	 
		 IRowSet  rs=DbUtil.executeQuery(ctx, sql.toString());
		 return packageReturnXml(getValueStr(rs,warehouseNumber));
    }
    
    /**
     * 查询仓位
     * @param ctx
     * @param argumentStr
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    public String getLocation(Context ctx,Object[] argumentArg) throws BOSException, EASBizException{
    	if(argumentArg.length<-1)return null;
    	 String warehouseNumber=argumentArg[0].toString();    //仓库编码
    	 String warehouseID=argumentArg[1].toString();    //仓库ID
    	 StringBuffer sql=new StringBuffer();
    	 sql.append("select FID,fnumber as location_number,fname_l2 as location_name from T_DB_LOCATION ").append("\t\n"); 
    	 sql.append(" where 1=1").append("\t\n");
    	 sql.append(" and FNumber ='").append(warehouseNumber).append("' \t\n");
    	 sql.append(" and FWarehouseID ='").append(warehouseID).append("' \t\n");
    	 
		 IRowSet  rs=DbUtil.executeQuery(ctx, sql.toString());
		
		return packageReturnXml(getValueStr(rs,warehouseNumber));
    }
    
    private String getValueStr(IRowSet  rs,String number) throws EASBizException{
    	 StringBuffer valueStr=new StringBuffer();
		  try {
			 ResultSetMetaData rsd= rs.getMetaData();
			while(rs.next()){
				for(int i=1,size=rsd.getColumnCount();i<=size;i++){
					String columnName=rsd.getColumnName(i);
					String value=rs.getString(columnName);
					valueStr.append("<").append(columnName).append("  value='").append(value).append("'/>").append("\n");
					
				}
			}
		} catch (SQLException e) {
			throw new BarcodeWSException(BarcodeWSException.DATABULL);
		}
		return valueStr.toString();
    }
    private String  packageReturnXml(String valueStr){
    	StringBuffer  returnStr=new StringBuffer();
    	returnStr.append("<Header>UWBCDtResponse</Header>").append("\n");
    	returnStr.append("<Return>").append("\n").append(valueStr).append("\n").append("</Return>").append("\n");
    	
    	returnStr.append("<Tailer>UWBCEnd</Tailer>").append("\n");
    	return returnStr.toString();
    }
    
    private String getMassege(Context ctx,String key){
    	return ResourceBase.getString(resourceBaseStr,key,ctx.getLocale());
    }
    
    /**
     *下载菜单配置 
     */
    public String getMenuConfig(Context ctx,Object[] argumentArg) throws BOSException{
    	//获取主菜单的配置
     	String sqlMainConfig = " select CFMenuXml,CFMD5Value from CT_BC_PDAMainMenu";
    	IRowSet  rsMainConfig = DbUtil.executeQuery(ctx, sqlMainConfig.toString());
    	logger.info("获取PDA菜单SQl："+sqlMainConfig);
    	//获取菜单项的配置
    	String sqlItemConfig = " select CFXMLByteData,CFXmlMD5,CFXmlFileName  from CT_BC_BARCODEPDACONFIG";
    	IRowSet  rsItemConfig = DbUtil.executeQuery(ctx, sqlItemConfig.toString());
    	logger.info("获取PDA界面SQl："+sqlMainConfig);
    	String jsonStr =  getConfigJsonStr(rsMainConfig, rsItemConfig);
    	
    	return jsonStr;
    }

	private String getConfigJsonStr(IRowSet rsMainConfig, IRowSet rsItemConfig) {
		FileObject fo = new FileObject();
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		try {
			//boolean a = rsMainConfig.next();
			logger.info("获取PDA菜单开始：");
			while(rsMainConfig.next()){
				jo = new JSONObject();
				String fileName = "UWBCConfig.xml";
				String md5Code = rsMainConfig.getString("CFMD5Value");
				String fileContent = rsMainConfig.getString("CFMenuXml");
				fo.setFileContent(fileContent);
				fo.setFileName(fileName);
				fo.setMD5Code(md5Code);
				jo.fromObject(fo);
				jo = jo.fromObject(fo);
				ja.add(jo);
			}
			logger.info("获取PDA菜单结束："+ja.toString());
			
			logger.info("获取PDA界面开始：");
			while(rsItemConfig.next()){
				jo = new JSONObject();
				String fileName = rsItemConfig.getString("CFXmlFileName");
				String md5Code = rsItemConfig.getString("CFXmlMD5");
				String fileContent = rsItemConfig.getString("CFXMLByteData");
				
				fo.setFileContent(fileContent);
				fo.setFileName(fileName);
				fo.setMD5Code(md5Code);
				
				jo = jo.fromObject(fo);
				ja.add(jo);
			}
			
			logger.info("获取PDA界面结束："+ja.toString());
	    	
	    	return ja.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ja.toString();
	}
	private void requestLicenseOrReleaseLicense(Context ctx, Object[] argumentArg)
    throws BOSException, EASBizException
  {
    try
    {
      String sessionID = argumentArg[0].toString();
      boolean flag = Boolean.valueOf(argumentArg[1].toString()).booleanValue();
      
      logger.info("PDA license CallerID='" + ctx.getCaller().toString() + "'");
      logger.info("PDA license sessionID='" + sessionID + "'");
      BarcodeLicenseUtils.requestLicenseOrReleaseLicense(ctx, flag, sessionID);
    }
    catch (LicenseException e)
    {
      throw new BarcodeWSException(new NumericExceptionSubItem("", e.fillInStackTrace().getMessage()));
    }
  }

	@Override
	protected byte[] _uploadData(Context arg0, String arg1)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
}