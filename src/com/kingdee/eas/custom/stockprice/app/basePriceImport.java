package com.kingdee.eas.custom.stockprice.app;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.ctrl.analysis.olap.ModelFactory;
import com.kingdee.bos.ctrl.common.util.StringUtil;
import com.kingdee.bos.ctrl.data.engine.script.beanshell.function.datetime.GETDATE;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.Currency;
import com.kingdee.eas.basedata.assistant.CurrencyCollection;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitCollection;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.app.DataImportUtils;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.app.DataImportTools;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.cp.bc.ExpenseTypeCollection;
import com.kingdee.eas.cp.bc.ExpenseTypeFactory;
import com.kingdee.eas.cp.bc.OperationTypeCollection;
import com.kingdee.eas.cp.bc.OperationTypeFactory;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyCollection;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyEntryFactory;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyEntryInfo;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyFactory;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo;
import com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompany;
import com.kingdee.eas.custom.stockprice.IBasePriceOfOtherCompanyEntry;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.scm.common.SCMBillException;
import com.kingdee.eas.scm.common.util.SCMUtils;
import com.kingdee.eas.tools.datatask.AbstractDataTransmission;
import com.kingdee.eas.tools.datatask.core.TaskExternalException;
import com.kingdee.eas.tools.datatask.runtime.DataToken;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.StringUtils;

public class basePriceImport extends AbstractDataTransmission{

	private BasePriceOfOtherCompanyInfo invInit=null;

	private static String resource = "com.kingdee.eas.scm.im.inv.WarehsManageResource";

	private static String RESOURCE = "com.kingdee.eas.scm.im.inv.InvInitBillResource";

	@Override
	protected  IBasePriceOfOtherCompany getController(Context ctx)
	throws TaskExternalException {
		// TODO Auto-generated method stub
		try {
			return BasePriceOfOtherCompanyFactory.getLocalInstance(ctx);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			throw new TaskExternalException("",e);
		}
	}

	protected   ICoreBillEntryBase getEntyController(Context ctx)
	throws TaskExternalException {
		// TODO Auto-generated method stub
		try {
			return BasePriceOfOtherCompanyEntryFactory.getLocalInstance(ctx);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			throw new TaskExternalException("",e);
		}
	}




	public int getSubmitType()
	{
		return 1;
	}

	public CoreBaseInfo transmit(Hashtable hsData, Context ctx)
	throws TaskExternalException {
		// TODO Auto-generated method stub
		this.invInit = null;
		int keyCursor = 0;
		for (int i = 0; i < hsData.size(); ++i) {
			Hashtable lineData = (Hashtable)hsData.get(new Integer(i));
			if (keyCursor == 0) {
				this.invInit = transmitHead(lineData, ctx);

				if (this.invInit == null) {
					return null;
				}
			}		       
			BasePriceOfOtherCompanyEntryInfo entry = null;
			try {
				entry = transmitEntry(lineData, ctx);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int seq = this.invInit.getEntrys().size() + 1;
			entry.setSeq(seq);
			entry.setParent(this.invInit);
			this.invInit.getEntrys().add(entry);
			++keyCursor;
		}
//		try {
//			BasePriceOfOtherCompanyFactory.getLocalInstance(ctx).save(invInit);
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return this.invInit;
	}


	private BasePriceOfOtherCompanyInfo transmitHead(Hashtable lineData, Context ctx) throws TaskExternalException {
		this.invInit = new BasePriceOfOtherCompanyInfo();
		String message="";

		//编码
		Object number = ((DataToken)lineData.get("FNumber")).data;
		if ((number != null) && (number.toString().trim().length() > 0)) {
			this.invInit.setNumber(number.toString().trim());
			String existId = getIdFromNumber(number.toString().trim(), ctx);
			if(existId!=null&&!existId.equals("")){
				try {
					BasePriceOfOtherCompanyCollection coll = BasePriceOfOtherCompanyFactory.getLocalInstance(ctx).getBasePriceOfOtherCompanyCollection(" where fnumber='"+number.toString()+"'");
					if(coll.size()>0){
						invInit=coll.get(0);
						return invInit;
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		//公司
		Object company = ((DataToken)lineData.get("FCompany")).data;
		if(company!=null&&!company.toString().equals(""))
			this.invInit.setCompany(company.toString());
		else{
			message="公司为空";
			throw new TaskExternalException(message);
		}

		//业务日期
		Object bizDate = ((DataToken)lineData.get("FBizDate")).data;
		if(bizDate==null){
			message="业务日期为空";
			throw new TaskExternalException(message);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			invInit.setBizDate(sdf.parse(bizDate.toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			message="日期转换失败";
			throw new TaskExternalException(message);
		}
		return this.invInit;
	}

	private BasePriceOfOtherCompanyEntryInfo transmitEntry(Hashtable hsData, Context ctx) throws TaskExternalException, BOSException {
		if (hsData == null) {
			return null;
		}
		BasePriceOfOtherCompanyEntryInfo entryInfo = new BasePriceOfOtherCompanyEntryInfo();
		String message="";
		String materialNum="";
		MaterialInfo materialInfo=null;

		//物料编码
		Object data = ((DataToken)hsData.get("FEntrys$material_number")).data;
		if ((data != null) && (data.toString().length() > 0)) {
			materialNum = data.toString();
			if ((materialNum != null) && (materialNum.trim().length() > 0)) {
				try {
					CoreBaseCollection coll = MaterialFactory.getLocalInstance(ctx).getCollection(" where number='"+materialNum+"'");
					if(coll.size()==0){
						message="不存在编码为"+materialNum+"的物料";
						throw new TaskExternalException(message);
					}
					materialInfo=(MaterialInfo)coll.get(0);
					//					entryInfo.setMaterial((MaterialInfo)coll.get(0));
					entryInfo.setMaterial(materialInfo);
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			message="物料编码为空";
			throw new TaskExternalException(message);
		}
		//物料名称
		Object materialData = ((DataToken)hsData.get("FEntrys$material_name_l2")).data;
		if(materialData!=null&&materialData.toString().trim().length()>0){
			String materialName = materialData.toString();
			if(!materialInfo.getName().equals(materialName)){
				message="物料的编码和名称不匹配";
				throw new TaskExternalException(message);
			}
		}
		else{
			message="物料名称为空";
			throw new TaskExternalException(message);
		}

		//分录——物料编码
		Object materialNumData = ((DataToken)hsData.get("FEntrys_materialNum")).data;
		if(materialNumData!=null&&materialNumData.toString().trim().length()>0){
			String EntryMaterialNum=materialNumData.toString();
			if(!EntryMaterialNum.equals(materialInfo.getNumber())){
				message="两次输入的编码不一致";
				throw new TaskExternalException(message);
			}
			entryInfo.setMaterialNum(EntryMaterialNum);
		}
		else{
			message="分录物料编码为空";
			throw new TaskExternalException(message);
		}
		//规格型号
		Object modelData = ((DataToken)hsData.get("FEntrys_model")).data;
		if(modelData!=null&&modelData.toString().trim().length()>0){
			String model=modelData.toString();
			if(!materialInfo.getModel().equals(model)){
				message="物料规格型号不匹配";
				throw new TaskExternalException(message);
			}
//			entryInfo.setModel(model);
		}

		//价格
		Object priceData = ((DataToken)hsData.get("FEntrys_price")).data;
		if(priceData!=null&&priceData.toString().trim().length()>0){
			try{
			entryInfo.setPrice(new BigDecimal(priceData.toString().trim()));
			}
			catch (Exception e){
				throw new TaskExternalException("价格字段不是有效的数值，无法转换成数值");
			}
		}
		else{
			message="价格为空";
			throw new TaskExternalException(message);
		}
		//币别
		Object currencyData = ((DataToken)hsData.get("FEntrys$currency_name_l2")).data;
		if(currencyData!=null&&currencyData.toString().trim().length()>0){
			String currency=currencyData.toString();
			CoreBaseCollection coll;
			try {
				coll = CurrencyFactory.getLocalInstance(ctx).getCollection(" where name='"+currency+"'");
				if(coll.size()<=0){
					message="不存在名称为"+currency+"的币别";
					throw new TaskExternalException(message);
				}
				entryInfo.setCurrency((CurrencyInfo) coll.get(0));
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			message="分录币别为空";
			throw new TaskExternalException(message);
		}
		//基本计量单位
		Object unitData = ((DataToken)hsData.get("FEntrys$unit_name_l2")).data;
		if(unitData!=null&&unitData.toString().trim().length()>0){
			String unit=unitData.toString();
			CoreBaseCollection coll = null;
			String id = materialInfo.getBaseUnit().getId().toString();
			try {
				coll = MeasureUnitFactory.getLocalInstance(ctx).getCollection(" where id='"+id+"'");
				if(coll.size()<=0){
					message="不存在名称为"+unit+"的计量单位";
					throw new TaskExternalException(message);
				}
				entryInfo.setUnit( (MeasureUnitInfo) coll.get(0));
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!(coll.get(0).toString()).equals(unit)){
				message="物料编码为"+materialNum+"的物料与基本计量单位不匹配";
				throw new TaskExternalException(message);
			}
		}
		else{
			message="分录基本计量单位为空";
			throw new TaskExternalException(message);
		}
		return entryInfo;
	}
	private String getDataString(Hashtable hsData,String fieldName)
	{
		return DataImportTools.getDataString(hsData, fieldName);
	}

	//导入按钮事件
	public void submit(CoreBaseInfo arg0, Context arg1)
	throws TaskExternalException {
		try {
			BasePriceOfOtherCompanyFactory.getLocalInstance(arg1).save(this.invInit);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getController(arg1).addnew(invInit);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}
	/**
	 *查询当前编码的单据是否存在，存在的话返回id，否则 返回空值
	 * @param number                                单据编码
	 * @return                                      单据id
	 */
	private String getIdFromNumber(String number, Context ctx)
	throws TaskExternalException
	{
		BasePriceOfOtherCompanyCollection collection;
		try
		{
			collection = BasePriceOfOtherCompanyFactory.getLocalInstance(ctx).getBasePriceOfOtherCompanyCollection("where number ='" + number + "'");
		}
		catch (BOSException e) {
			throw new TaskExternalException(e.getMessage(), e.getCause());
		}

		if ((collection != null) && (collection.size() > 0)) {
			return collection.get(0).getId().toString();
		}
		return null;
	}
}
