package com.kingdee.eas.wlhlcomm;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTMergeManager;
import com.kingdee.bos.ctrl.kdf.table.KDTStyleConstants;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.CostObjectCollection;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.CurrencyCollection;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.ExchangeRateFactory;
import com.kingdee.eas.basedata.assistant.ExchangeRateInfo;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.assistant.ICurrency;
import com.kingdee.eas.basedata.assistant.IExchangeRate;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.IMeasureUnitGroup;
import com.kingdee.eas.basedata.assistant.IPaymentType;
import com.kingdee.eas.basedata.assistant.IPeriod;
import com.kingdee.eas.basedata.assistant.ISettlementType;
import com.kingdee.eas.basedata.assistant.MeasureUnitCollection;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitGroupCollection;
import com.kingdee.eas.basedata.assistant.MeasureUnitGroupFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitGroupInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PaymentTypeCollection;
import com.kingdee.eas.basedata.assistant.PaymentTypeFactory;
import com.kingdee.eas.basedata.assistant.PaymentTypeInfo;
import com.kingdee.eas.basedata.assistant.PeriodCollection;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SettlementTypeCollection;
import com.kingdee.eas.basedata.assistant.SettlementTypeFactory;
import com.kingdee.eas.basedata.assistant.SettlementTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeCollection;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeCollection;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupCollection;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupFactory;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.IAsstActType;
import com.kingdee.eas.basedata.master.auxacct.IGeneralAsstActType;
import com.kingdee.eas.basedata.master.auxacct.IGeneralAsstActTypeGroup;
import com.kingdee.eas.basedata.master.cssp.CustomerCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.ICustomer;
import com.kingdee.eas.basedata.master.cssp.ISupplier;
import com.kingdee.eas.basedata.master.cssp.SupplierCollection;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.IMaterialGroup;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupCollection;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitCollection;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitCollection;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IAdminOrgUnit;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.basedata.org.ICtrlUnit;
import com.kingdee.eas.basedata.org.IPurchaseOrgUnit;
import com.kingdee.eas.basedata.org.IStorageOrgUnit;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitCollection;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitCollection;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.IPerson;
import com.kingdee.eas.basedata.person.PersonCollection;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeCollection;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeCollection;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.IBillType;
import com.kingdee.eas.basedata.scm.common.IBizType;
import com.kingdee.eas.basedata.scm.common.IRowType;
import com.kingdee.eas.basedata.scm.common.ITransactionType;
import com.kingdee.eas.basedata.scm.common.RowTypeCollection;
import com.kingdee.eas.basedata.scm.common.RowTypeFactory;
import com.kingdee.eas.basedata.scm.common.RowTypeInfo;
import com.kingdee.eas.basedata.scm.common.TransactionTypeCollection;
import com.kingdee.eas.basedata.scm.common.TransactionTypeFactory;
import com.kingdee.eas.basedata.scm.common.TransactionTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.IStoreState;
import com.kingdee.eas.basedata.scm.im.inv.IStoreType;
import com.kingdee.eas.basedata.scm.im.inv.IWarehouse;
import com.kingdee.eas.basedata.scm.im.inv.StoreStateCollection;
import com.kingdee.eas.basedata.scm.im.inv.StoreStateFactory;
import com.kingdee.eas.basedata.scm.im.inv.StoreStateInfo;
import com.kingdee.eas.basedata.scm.im.inv.StoreTypeCollection;
import com.kingdee.eas.basedata.scm.im.inv.StoreTypeFactory;
import com.kingdee.eas.basedata.scm.im.inv.StoreTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ar.IOtherBill;
import com.kingdee.eas.fi.ar.OtherBillCollection;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.fi.ar.OtherBillInfo;

/**
 * 通用方法
 * <p>Title: CommonMethod</p>
 * <p>Description: </p>
 * <p>Company: kindee</p> 
 * @author    kevin_gj_wang
 * @date       2011-9-22
 */
public class CommonMethod {

	/**
	 * 根据显示内容设置 单元格颜色
	 * <p>Title: setCellColor</p>
	 * <p>Description: </p>
	 * 
	 * @param cellStrValue
	 * @param cell
	 */
	public static void setCellColor(String cellStrValue,ICell cell){
		if(cellStrValue != null ){
			if("已导入".equals(cellStrValue)){
				cell.getStyleAttributes().setBackground(Color.GREEN);
			}else if("未导入".equals(cellStrValue)){
				cell.getStyleAttributes().setBackground(Color.YELLOW);
			}else {
				cell.getStyleAttributes().setBackground(Color.ORANGE);
			}
		}
	}
	/**
	 * 组织id范围语句
	 * <p>Title: getIDRange</p>
	 * <p>Description: </p>
	 *  组织id查询条件格式如传入 [1,2,3],则返回('1','2','3')
	 * @param ids
	 * @return
	 */
	public static StringBuffer getIDRange(String[] ids,String field){
		
		StringBuffer idBuffer = new StringBuffer();
		if(ids != null && ids.length > 0){
			for (int i = 0; i < ids.length; i++) {
			 
			  if(i == 0) {
				  
				  idBuffer.append(" ").append(field).append(" IN ( '").append(ids[i]).append("'");
			  }else if (i%1000 == 999){
				  idBuffer.append(") or ").append(field).append(" in('").append(ids[i]).append("'");
			  }else  {
				  idBuffer.append(",'").append(ids[i]).append("'");
			  }
			  if (i == ids.length -1){
				  idBuffer.append(",'").append(ids[i]).append("') ");
			  }
			}
		}
		return idBuffer;
		
	}
	
	/**
	 * 组织id范围语句
	 * <p>Title: getIDRange</p>
	 * <p>Description: </p>
	 *  组织id查询条件格式如传入 [1,2,3],则返回('1','2','3')
	 *  
	 *  没一千条记录组织成一条 条件
	 * @param ids
	 * @return
	 */
	public static String[] getIDRanges(String[] ids,String field){
	
		
		if(ids != null && ids.length > 0){
			StringBuffer idBuffer = new StringBuffer();
			String[] idArray = new String[(ids.length/500) + 1];
			for (int i = 0; i < ids.length; i++) {
			 
			  if(i == 0) {
				  
				  idBuffer.append(" ").append(field).append(" IN ( '").append(ids[i]).append("'");
			  }else if (i%500 == 499){
				  idBuffer.append(",'").append(ids[i]).append("'").append(" ) ");
				  idArray[i/500] = idBuffer.toString();
				  idBuffer = new StringBuffer();
				  idBuffer = idBuffer.append(" ").append(field).append(" in ('").append(ids[i]).append("'");
			  }else  {
				  idBuffer.append(",'").append(ids[i]).append("'");
			  }
			  if (i == ids.length -1 ){
				  if(i%500 != 499){
					  idBuffer.append(",'").append(ids[i]).append("') ");
					  idArray[i/500] = idBuffer.toString();
				  }else{
					  idBuffer.append(")");
					  idArray[i/500] = idBuffer.toString();
				  }
			  }
			}
			return idArray;
		}else{
			return null;
		}
		
	}
	
	 /**
     * 根据物料编码获得对应的物料信息
     * <p>Title: getMaterialByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param materialNumber
     * @return 找不到时返回null
	 * @throws BOSException 
     */
    public MaterialInfo getMaterialByNumber(Context ctx,String materialNumber) throws BOSException{
    	if(materialNumber == null || StringUtils.isBlank(materialNumber)){
    		return null;
    	}
    	// 查找对应的 物料
    	IMaterial Material = null;
    	if(ctx != null){
    		Material = MaterialFactory.getLocalInstance(ctx);
    	}else{
    		Material = MaterialFactory.getRemoteInstance();
    	}
    	
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", materialNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		MaterialCollection muc = Material.getMaterialCollection(evi);
		if(muc != null && muc.size() > 0){
			return muc.get(0);
		}else{
			return null;
			
		}
		
    }
	
	 /**
     * 根据转换编码获得对应的转换规则
     * <p>Title: getMaterialByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param botNumber
     * @return 找不到时返回null
	 * @throws BOSException 
     */
    public BOTMappingInfo getBOTMappingByNumber(Context ctx,String botNumber) throws BOSException{
    	if(botNumber == null || StringUtils.isBlank(botNumber)){
    		return null;
    	}
    	// 查找对应的 物料
    	IBOTMapping mapping = null;
    	if(ctx != null){
    		mapping = BOTMappingFactory.getLocalInstance(ctx);
    	}else{
    		mapping = BOTMappingFactory.getRemoteInstance();
    	}
    	
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("name", botNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	BOTMappingCollection muc = mapping.getBOTMappingCollection(evi);
		if(muc != null && muc.size() > 0){
			return muc.get(0);
		}else{
			return null;
			
		}
		
    }
    /**
     * 根据物料编码获得对应的成本对象
     * <p>Title: getMaterialByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param costObjectNumber
     * @return 找不到时返回null
	 * @throws BOSException 
     */
    public CostObjectInfo getCostObjectInfoByNumber(Context ctx,String costObjectNumber) throws BOSException{
    	if(costObjectNumber == null || StringUtils.isBlank(costObjectNumber)){
    		return null;
    	}
    	// 查找对应的 物料
    	ICostObject costObject = null;
    	if(ctx != null){
    		costObject = CostObjectFactory.getLocalInstance(ctx);
    	}else{
    		costObject = CostObjectFactory.getRemoteInstance();
    	}
    	
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", costObjectNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		CostObjectCollection muc = costObject.getCostObjectCollection(evi);
		if(muc != null && muc.size() > 0){
			return muc.get(0);
		}else{
			return null;
			
		}
		
    }

    /**
     * 根据编号获得计量单位组信息
     * <p>Title: getMeasureUnitInfoByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param unitNumber
     * @return 查找不到时返回null
     * @throws BOSException 
     */
    public MeasureUnitGroupInfo getMeasureUnitGroupInfoByNumber(Context ctx,String UnitGroupNumber) throws BOSException{
    	if(ctx == null || UnitGroupNumber == null || StringUtils.isBlank(UnitGroupNumber)){
    		return null;
    	}
    	// 查找对应的 基本计量单位
    	
		MeasureUnitGroupInfo measureUnitGroupInfo = new MeasureUnitGroupInfo();
		IMeasureUnitGroup measureUnitGroup = MeasureUnitGroupFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", UnitGroupNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		MeasureUnitGroupCollection muc = measureUnitGroup.getMeasureUnitGroupCollection(evi);
		if(muc != null && muc.size() > 0){
			measureUnitGroupInfo = muc.get(0);
			return measureUnitGroupInfo;
		}else{
			return null;
		}
		
    }
    /**
     * 根据编号获得计量单位
     * <p>Title: getMeasureUnitInfoByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param unitNumber
     * @return 查找不到时返回null
     * @throws BOSException 
     */
    public MeasureUnitInfo getMeasureUnitInfoByNumber(Context ctx,String unitNumber) throws BOSException{
    	if(unitNumber == null || StringUtils.isBlank(unitNumber)){
    		return null;
    	}
    	// 查找对应的 基本计量单位
    	
		MeasureUnitInfo measureUnitInfo = new MeasureUnitInfo();
		IMeasureUnit measureUnit = null;
		if(ctx != null){
			measureUnit = MeasureUnitFactory.getLocalInstance(ctx);
		}else{
			measureUnit = MeasureUnitFactory.getRemoteInstance();
		}
//		IMeasureUnit measureUnit = MeasureUnitFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", unitNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		MeasureUnitCollection muc = measureUnit.getMeasureUnitCollection(evi);
		if(muc != null && muc.size() > 0){
			measureUnitInfo = muc.get(0);
			return measureUnitInfo;
		}else{
			return null;
		}
		
    }
    /**
     * 根据编码或者仓库
     * <p>Title: getWareHouseByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param warehouseNumber
     * @return
     * @throws BOSException
     */
    public WarehouseInfo getWareHouseByNumber(Context ctx, String warehouseNumber) throws BOSException{
    	
    	if(warehouseNumber == null || StringUtils.isBlank(warehouseNumber)){
    		return null;
    	}
    	// 查找对应的 基本计量单位
    	
    	WarehouseInfo whi = new WarehouseInfo();
    	IWarehouse warehouseUnit ;
    	if(ctx != null){
    		warehouseUnit = WarehouseFactory.getLocalInstance(ctx);
    	}else{
    		warehouseUnit = WarehouseFactory.getRemoteInstance();
    	}
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", warehouseNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		WarehouseCollection wc = warehouseUnit.getWarehouseCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
    /**
     * 根据编码或者对应的  自定义核算项目组
     * <p>Title: getGeneralAsstActTypeGroupByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param generalAsstActTypeGroupNumber
     * @return 找不到时返回null
	 * @throws BOSException 
     */
    public GeneralAsstActTypeGroupInfo getGAATGInfoByNumber(Context ctx,String generalAsstActTypeGroupNumber) throws BOSException{
    	if(ctx == null || generalAsstActTypeGroupNumber == null || StringUtils.isBlank(generalAsstActTypeGroupNumber)){
    		return null;
    	}
    	// 查找对应的 物料
		IGeneralAsstActTypeGroup GeneralAsstActTypeGroup = GeneralAsstActTypeGroupFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", generalAsstActTypeGroupNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		GeneralAsstActTypeGroupCollection muc = GeneralAsstActTypeGroup.getGeneralAsstActTypeGroupCollection(evi);
		if(muc != null && muc.size() > 0){
			return muc.get(0);
		}else{
			return null;
			
		}
		
    }
    
    /**
     * 根据编码或者对应的  自定义核算项目
     * <p>Title: getGeneralAsstActTypeByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param generalAsstActTypeNumber
     * @return 找不到时返回null
	 * @throws BOSException 
     */
    public GeneralAsstActTypeInfo getGAATInfoByNumber(Context ctx,String generalAsstActTypeNumber) throws BOSException{
    	if(ctx == null || generalAsstActTypeNumber == null || StringUtils.isBlank(generalAsstActTypeNumber)){
    		return null;
    	}
    	// 查找对应的 物料
		IGeneralAsstActType GeneralAsstActType = GeneralAsstActTypeFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", generalAsstActTypeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		GeneralAsstActTypeCollection muc = GeneralAsstActType.getGeneralAsstActTypeCollection(evi);
		if(muc != null && muc.size() > 0){
			return muc.get(0);
		}else{
			return null;
			
		}
		
    }
    /**
     * 获取指定 财务组织单元 
     * <p>Title: getCompanyOrgUnitInfo</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param orgUnitCode 编号
     * @return
     * @throws BOSException
     */
    public CompanyOrgUnitInfo getCompanyOrgUnitInfo(Context ctx, String orgUnitCode) throws BOSException{
    	
    	CompanyOrgUnitInfo whi = new CompanyOrgUnitInfo();
    	ICompanyOrgUnit companyOrgUnit = null;
    	if(ctx != null){
    		companyOrgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx);
    	}else{
    		companyOrgUnit = CompanyOrgUnitFactory.getRemoteInstance();
    	}
    	
//		ICompanyOrgUnit companyOrgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", orgUnitCode, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	CompanyOrgUnitCollection wc = companyOrgUnit.getCompanyOrgUnitCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
    /**
     * 获取指定 管理控制单元 
     * <p>Title: getCommCtrlUnitInfo</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param orgUnitCode 编号
     * @return
     * @throws BOSException
     */
    public CtrlUnitInfo getCtrlUnitInfo(Context ctx, String orgUnitCode) throws BOSException{
    	
    	CtrlUnitInfo whi = new CtrlUnitInfo();
		ICtrlUnit warehouseUnit = CtrlUnitFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", orgUnitCode, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		CtrlUnitCollection wc = warehouseUnit.getCtrlUnitCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
    
    /**
     * 获取通用的 库存组织
     * <p>Title: getCommCtrlUnitInfo</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @return
     * @throws BOSException
     */
    public StorageOrgUnitInfo getStorageUnitInfo(Context ctx,String unitCode) throws BOSException{
    	
    	StorageOrgUnitInfo whi = new StorageOrgUnitInfo();
    	IStorageOrgUnit warehouseUnit = null;
    	if(ctx != null){
    		warehouseUnit = StorageOrgUnitFactory.getLocalInstance(ctx);
    	}else{
    		warehouseUnit = StorageOrgUnitFactory.getRemoteInstance();
    	}
//		IStorageOrgUnit warehouseUnit = StorageOrgUnitFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", unitCode, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		StorageOrgUnitCollection wc = warehouseUnit.getStorageOrgUnitCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
    /**
     * 获取通用的 采购组织
     * <p>Title: getCommCtrlUnitInfo</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @return
     * @throws BOSException
     */
    public PurchaseOrgUnitInfo getPurchaseOrgUnitInfo(Context ctx,String unitCode) throws BOSException{
    	
    	PurchaseOrgUnitInfo whi = new PurchaseOrgUnitInfo();
    	IPurchaseOrgUnit warehouseUnit = null;
    	if(ctx != null){
    		warehouseUnit = PurchaseOrgUnitFactory.getLocalInstance(ctx);
    	}else{
    		warehouseUnit = PurchaseOrgUnitFactory.getRemoteInstance();
    	}
//		IStorageOrgUnit warehouseUnit = StorageOrgUnitFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", unitCode, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	PurchaseOrgUnitCollection wc = warehouseUnit.getPurchaseOrgUnitCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
   
    
    /**
     * 根据部门名称获得部门
     * <p>Title: getAdminOrgUnitByNumber</p>
     * <p>Description: </p>
     * 
     * @param adminOrgUnitNuame
     * @param ctx
     * @return
     * @throws BOSException 
     */
    public AdminOrgUnitInfo getAdminOrgUnitByName(String adminOrgUnitNuame,Context ctx) throws BOSException{
    	
    	AdminOrgUnitInfo si = new AdminOrgUnitInfo();
		IAdminOrgUnit adminOrgUnit = AdminOrgUnitFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("name", adminOrgUnitNuame, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		AdminOrgUnitCollection sc = adminOrgUnit.getAdminOrgUnitCollection(evi);
		if(sc != null && sc.size() > 0){
			si = sc.get(0);
			return si;
		}else{
			return null;
		}
    }
    
    /**
     * 根据部门编码获得部门
     * <p>Title: getAdminOrgUnitByNumber</p>
     * <p>Description: </p>
     * 
     * @param adminOrgUnitNumber
     * @param ctx
     * @return
     * @throws BOSException 
     */
    public AdminOrgUnitInfo getAdminOrgUnitByNumber(String adminOrgUnitNumber,Context ctx) throws BOSException{
    	
    	AdminOrgUnitInfo si = new AdminOrgUnitInfo();
    	IAdminOrgUnit adminOrgUnit;
    	if(ctx != null){
			adminOrgUnit = AdminOrgUnitFactory.getLocalInstance(ctx);
    	}else{
    		adminOrgUnit = AdminOrgUnitFactory.getRemoteInstance();
    	}
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", adminOrgUnitNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		AdminOrgUnitCollection sc = adminOrgUnit.getAdminOrgUnitCollection(evi);
		if(sc != null && sc.size() > 0){
			si = sc.get(0);
			return si;
		}else{
			return null;
		}
    }
    
    /**
     * 根据供应商编号获得供应商信息
     * <p>Title: getSupplierByNumber</p>
     * <p>Description: </p>
     * 
     * @param supplierNumber
     * @param ctx
     * @return
     * @throws BOSException 
     */
    public SupplierInfo getSupplierByNumber(String supplierNumber,Context ctx) throws BOSException{
    	
    	SupplierInfo si = new SupplierInfo();
    	ISupplier supplier = null;
    	if(ctx != null){
    		supplier = SupplierFactory.getLocalInstance(ctx);
    	}else{
    		supplier = SupplierFactory.getRemoteInstance();
    	}
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", supplierNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		SupplierCollection sc = supplier.getSupplierCollection(evi);
		if(sc != null && sc.size() > 0){
			si = sc.get(0);
			return si;
		}else{
			return null;
		}
    }
    /**
     * 根据客户编号获得客户信息
     * <p>Title: getCustomerByNumber</p>
     * <p>Description: </p>
     * 
     * @param customerNumber
     * @param ctx
     * @return
     * @throws BOSException 
     */
    public CustomerInfo getCustomerByNumber(String customerNumber,Context ctx) throws BOSException{
    	
    	CustomerInfo ci = new CustomerInfo();
    	ICustomer customer = null;
    	if(ctx != null){
    		customer = CustomerFactory.getLocalInstance(ctx);
    	}else{
    		customer = CustomerFactory.getRemoteInstance();
    	}
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", customerNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		CustomerCollection sc = customer.getCustomerCollection(evi);
		if(sc != null && sc.size() > 0){
			ci = sc.get(0);
			return ci;
		}else{
			return null;
		}
    }
    /**
     * 根据单据编号获得 指定的应收单
     * <p>Title: getCustomerByNumber</p>
     * <p>Description: </p>
     * 
     * @param arBillNumber
     * @param ctx
     * @return
     * @throws BOSException 
     */
    public OtherBillInfo getARBillByNumber(String arBillNumber,Context ctx) throws BOSException{
    	
    	OtherBillInfo ci = new OtherBillInfo();
    	IOtherBill orhteBill = null;
    	if(ctx != null){
    		orhteBill = OtherBillFactory.getLocalInstance(ctx);
    	}else{
    		orhteBill = OtherBillFactory.getRemoteInstance();
    	}
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", arBillNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
		OtherBillCollection sc = orhteBill.getOtherBillCollection(evi);
		if(sc != null && sc.size() > 0){
			ci = sc.get(0);
			return ci;
		}else{
			return null;
		}
    }
    
    
  
    /**
     * 根据编号取得 币别信息
     * <p>Title: getDefaultCI</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @return
     * @throws BOSException 
     */
    public CurrencyInfo getCurrencyInfo(Context ctx, String currencyNumber) throws BOSException{
    	if(StringUtils.isNotBlank(currencyNumber)){
	    	CurrencyInfo ci = new CurrencyInfo();
	    	ICurrency currency = null;
	    	if(ctx != null){
	    		currency = CurrencyFactory.getLocalInstance(ctx);
	    	}else{
	    		currency = CurrencyFactory.getRemoteInstance();
	    	}
			
			EntityViewInfo evi = new EntityViewInfo();
			FilterInfo fi = new FilterInfo();//建立过滤条件
	    	fi.getFilterItems().add(
	    			new FilterItemInfo("isoCode", currencyNumber, CompareType.EQUALS));
	    	
	//    	i. setMaskString(" (#0 )");
	    	evi.setFilter(fi);//添加过滤条件
	    	// 获取所有属性
	    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
	    	evi.getSelector().add(new SelectorItemInfo("*"));
	    	
	    	
			
			CurrencyCollection cc = currency.getCurrencyCollection(evi);
			if(cc != null && cc.size() > 0){
				ci = cc.get(0);
				return ci;
			}else{
				return null;
			}
    	}else{
    		return null;
    	}
    }
    /**
     * 获取
     * <p>Title: getCompanyPeriodExchangeRateInfo</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param exchangeTableID
     * @param sourceCurrencyID
     * @param destCurrencyNum
     * @param date
     * @return
     * @throws BOSException 
     * @throws EASBizException 
     */
    public ExchangeRateInfo getCompanyPeriodExchangeRateInfo(Context ctx, String exchangeTableID,String scNumber, String destCurrencyNum,Date date) throws BOSException, EASBizException{
//    	ExchangeRateInfo exchangeRate = new ExchangeRateInfo();
    	IExchangeRate iexchangRate = null;
    	if(ctx != null){
    		iexchangRate = ExchangeRateFactory.getLocalInstance(ctx);
    	}else
    	{
    		iexchangRate = ExchangeRateFactory.getRemoteInstance();
    	}
		 	
		CurrencyInfo srcCurr = this.getCurrencyInfo(ctx, scNumber);
		CurrencyInfo destCurr = this.getCurrencyInfo(ctx, destCurrencyNum);
		if(srcCurr != null && destCurr!= null){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			Date bizDate = dateFormat.parse(source);
			//获取当前公司汇率表
			ExchangeRateInfo erInfo = iexchangRate.getExchangeRate(
					new ObjectUuidPK(exchangeTableID),
					new ObjectUuidPK(srcCurr.getId()),
					new ObjectUuidPK(destCurr.getId()),
					date);
//			try{
//				erInfo = iexchangRate.getExchangeRateInfo(new ObjectUuidPK(erInfo.getId()));
//			}catch(Exception e){
//				
//				e.printStackTrace();
////				erInfo = null;
//			}
	    	return erInfo;
		}else{
			return null;
		}
    }
   
    /**
     * 根据事务类型编码获得事务类型
     * <p>Title: getTTByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param ttNumber
     * @return
     * @throws BOSException 
     */
    public TransactionTypeInfo getTTByNumber(Context ctx, String ttNumber) throws BOSException{
    	TransactionTypeInfo tti = new TransactionTypeInfo();
		ITransactionType currency = TransactionTypeFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", ttNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	TransactionTypeCollection ttC = currency.getTransactionTypeCollection(evi);
		if(ttC != null && ttC.size() > 0){
			tti = ttC.get(0);
			return tti;
		}else{
			return null;
		}
    }
    /**
     * 根据职员编码或者助记码 获取职员信息
     * <p>Title: getTTByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param personNumber
     * @param 
     * @return
     * @throws BOSException 
     */
    public PersonInfo getPersonByNumOrIdnum(Context ctx, String personNumber,String idNumber) throws BOSException{
    	PersonInfo tti = new PersonInfo();
		IPerson currency = PersonFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
		if(StringUtils.isNotBlank(personNumber)){
	    	fi.getFilterItems().add(
	    			new FilterItemInfo("number", personNumber, CompareType.EQUALS));
		}else{
			fi.getFilterItems().add(
	    			new FilterItemInfo("idNum", idNumber, CompareType.EQUALS));
		}
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	PersonCollection ttC = currency.getPersonCollection(evi);
		if(ttC != null && ttC.size() > 0){
			tti = ttC.get(0);
			return tti;
		}else{
			return null;
		}
    }
    
    /**
     * 根据编码获得付款方式
     * <p>Title: getPaymentTypeByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param paymentTypeNumber
     * @return
     * @throws BOSException
     */
    public PaymentTypeInfo getPaymentTypeByNumber(Context ctx, String paymentTypeNumber) throws BOSException{
//    	
//    	if(ctx == null || paymentTypeNumber == null || StringUtils.isBlank(paymentTypeNumber)){
//    		return null;
//    	}
    	// 查找对应的 基本计量单位
    	
    	PaymentTypeInfo whi = new PaymentTypeInfo();
    	IPaymentType paymentType = null;
    	if(ctx != null){
    		paymentType = PaymentTypeFactory.getLocalInstance(ctx);
    	}else{
    		paymentType = PaymentTypeFactory.getRemoteInstance();
    	}
//		IPaymentType paymentType = PaymentTypeFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", paymentTypeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	PaymentTypeCollection wc = paymentType.getPaymentTypeCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }

    /**
     * 根据编码获得往来类型
     * <p>Title: getPaymentTypeByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param paymentTypeNumber
     * @return
     * @throws BOSException
     */
    public AsstActTypeInfo getAsstActTypeByNumber(Context ctx, String asstActTypeNumber) throws BOSException{
    	
//    	if(ctx == null || asstActTypeNumber == null || StringUtils.isBlank(asstActTypeNumber)){
//    		return null;
//    	}
    	// 查找对应的 基本计量单位
    	
    	AsstActTypeInfo whi = new AsstActTypeInfo();
    	IAsstActType asstActType = null;
    	if(ctx != null){
    		asstActType = AsstActTypeFactory.getLocalInstance(ctx);
    	}else{
    		asstActType = AsstActTypeFactory.getRemoteInstance();
    	}
//		IAsstActType asstActType = AsstActTypeFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", asstActTypeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	AsstActTypeCollection wc = asstActType.getAsstActTypeCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
    /**
     * 根据编码获得单据类型
     * <p>Title: getBillTypeByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param paymentTypeNumber
     * @return
     * @throws BOSException
     */
    public BillTypeInfo getBillTypeByNumber(Context ctx, String billTypeNumber) throws BOSException{
    	
//    	if(ctx == null || billTypeNumber == null || StringUtils.isBlank(billTypeNumber)){
//    		return null;
//    	}
    	// 查找对应的 基本计量单位
    	
    	BillTypeInfo whi = new BillTypeInfo();
		IBillType asstActType = BillTypeFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", billTypeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	BillTypeCollection wc = asstActType.getBillTypeCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
    /**
     * 根据编码获得业务类型
     * <p>Title: getBillTypeByNumber</p>
     * <p>Description: </p>
     * 
     * @param ctx
     * @param paymentTypeNumber
     * @return
     * @throws BOSException
     */
    public BizTypeInfo getBizTypeByNumber(Context ctx, String bizTypeNumber) throws BOSException{
    	
//    	if(ctx == null || billTypeNumber == null || StringUtils.isBlank(billTypeNumber)){
//    		return null;
//    	}
    	// 查找对应的 基本计量单位
    	
    	BizTypeInfo whi = new BizTypeInfo();
    	
    	IBizType biztype = null;
    	if(ctx !=null){
    		biztype = BizTypeFactory.getLocalInstance(ctx);
    	}else{
    		biztype = BizTypeFactory.getRemoteInstance();
    	}
//		IBillType asstActType = BillTypeFactory.getLocalInstance(ctx);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();//建立过滤条件
    	fi.getFilterItems().add(
    			new FilterItemInfo("number", bizTypeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi.setFilter(fi);//添加过滤条件
    	// 获取所有属性
    	evi.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi.getSelector().add(new SelectorItemInfo("*"));
    	
    	
		
    	BizTypeCollection wc = biztype.getBizTypeCollection(evi);
		if(wc != null && wc.size() > 0){
			whi = wc.get(0);
			return whi;
		}else{
			return null;
		}
    }
   
    /**
     * table:表格;
     * reference:参考列;
     * col:需要融合的列;,
     * beginRow:开始行数;
     * endRow:结束行数。
     * (开始行和结束行可用于虚模式获取数据时融合，使得虚模式取数时每次只融合刚取的数据，而非全部数据。)
	 **例如：相同id的编码、名称进行融合：meregeTable(0,12,table,"id",new String[]{"number","name"})
	 *
	 *     * <p>Title: meregeTable</p>
     * <p>Description: </p>
     * 
     * @param beginRow
     * @param endRow
     * @param table
     * @param reference
     * @param col
     */
    public static void meregeTable(int beginRow,int endRow,com.kingdee.bos.ctrl.kdf.table.KDTable table,String reference,String[] col){
        if(beginRow<0){
            beginRow=0;
        }
        if(endRow<0){
            endRow=table.getRowCount()-1;
        }
        if(endRow<1||endRow-beginRow<1) return;
        KDTMergeManager kmm = table.getMergeManager();
        int[] indexs=new int[col.length];
        for(int j=0,m=col.length;j<m;j++){
            indexs[j]=table.getColumnIndex(col[j]);
        }
        int i=beginRow,temp=-1;
        Object begin=null;
        Object cur=null;
        for(;i<=endRow;i++){
            if(i==beginRow){
                begin=table.getCell(i,reference).getValue();
                cur=table.getCell(i,reference).getValue();
                temp=i;
                continue;
            }
            cur=table.getCell(i,reference).getValue();
            if(cur!=null&&cur.equals(begin)){
                continue;
            }
            for(int j=0,m=col.length;j<m;j++){
                kmm.mergeBlock(temp, indexs[j], i-1, indexs[j], KDTMergeManager.SPECIFY_MERGE);
            }
            begin=table.getCell(i,reference).getValue();
            temp=i;
        }
        for(int j=0,m=col.length;j<m;j++){
            kmm.mergeBlock(temp, indexs[j], i-1, indexs[j], KDTMergeManager.SPECIFY_MERGE);
        }
    }

    /**
     * 鼠标点击事件    复选框表头单击时切换 所有数据选中状态
     * <p>Title: tableHeaderClicked</p>
     * <p>Description: </p>
     * 
     * @param e
     * @param allSelected
     * @param table
     * @param selCol
     */
	public void tableHeaderClicked(KDTMouseEvent e,boolean allSelected,KDTable table,String selCol) {
		// 单击表头的选择列时 设置全选状态
		if(e.getClickCount() == 1 && e.getType() == KDTStyleConstants.HEAD_ROW){
			
			int colIndex = e.getColIndex();
			if(colIndex == 0 ){
				if(allSelected == false){
					for(int i = 0 ; i < table.getRowCount(); i++){
						table.getCell(i, selCol).setValue(true);
					}
					
					allSelected = true;
				}else{
					for(int i = 0 ; i < table.getRowCount(); i++){
						table.getCell(i, selCol).setValue(false);
					}
					allSelected = false;
				}
			}
			
		}
		
	}
	
	/**
	 * 获得物料分组
	 * @param ctx
	 * @param groupNumber
	 * @return
	 * @throws BOSException
	 */
	public  MaterialGroupInfo getMaterialGroupInfoByNumber(Context ctx,String groupNumber) throws BOSException{
		String materialGroupNumber = groupNumber;
		IMaterialGroup materialGroup  = null;
		if(ctx != null){
			materialGroup = MaterialGroupFactory.getLocalInstance(ctx);
		}else{
			materialGroup = MaterialGroupFactory.getRemoteInstance();
		}
		EntityViewInfo evi1 = new EntityViewInfo();
		FilterInfo fi1 = new FilterInfo();//建立过滤条件
    	fi1.getFilterItems().add(
    			new FilterItemInfo("number", materialGroupNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi1.setFilter(fi1);//添加过滤条件
    	// 获取所有属性
    	evi1.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi1.getSelector().add(new SelectorItemInfo("*"));
    	MaterialGroupCollection mgc= materialGroup.getMaterialGroupCollection(evi1);
    
    	MaterialGroupInfo mgInfo = null;
    	
    	if(mgc != null && mgc.size() > 0){
    		MaterialGroupInfo mgi = mgc.get(0);
    		mgInfo = mgi;
    		
    	}
    	return mgInfo;
	}
	
	/**
	 * 获得库存类型 
	 * @param ctx
	 * @param storeTypeNumber
	 * @return
	 * @throws BOSException
	 */
	public  StoreTypeInfo getStoreTypeInfoByNumber(Context ctx,String storeTypeNumber) throws BOSException{
		String typeNumber = storeTypeNumber;
		IStoreType storetype  = null;
		if(ctx != null){
			storetype = StoreTypeFactory.getLocalInstance(ctx);
		}else{
			storetype = StoreTypeFactory.getRemoteInstance();
		}
		EntityViewInfo evi1 = new EntityViewInfo();
		FilterInfo fi1 = new FilterInfo();//建立过滤条件
    	fi1.getFilterItems().add(
    			new FilterItemInfo("number", typeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi1.setFilter(fi1);//添加过滤条件
    	// 获取所有属性
    	evi1.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi1.getSelector().add(new SelectorItemInfo("*"));
    	StoreTypeCollection mgc= storetype.getStoreTypeCollection(evi1);
    
    	StoreTypeInfo mgInfo = null;
    	
    	if(mgc != null && mgc.size() > 0){
    		StoreTypeInfo mgi = mgc.get(0);
    		mgInfo = mgi;
    		
    	}
    	return mgInfo;
	}
	
	/**
	 * 获得库存状态 
	 * @param ctx
	 * @param StoreStateNumber
	 * @return
	 * @throws BOSException
	 */
	public StoreStateInfo getStoreStateInfoByNumber(Context ctx,String storeStateNumber) throws BOSException{
		String typeNumber = storeStateNumber;
		IStoreState storetype  = null;
		if(ctx != null){
			storetype = StoreStateFactory.getLocalInstance(ctx);
		}else{
			storetype = StoreStateFactory.getRemoteInstance();
		}
		EntityViewInfo evi1 = new EntityViewInfo();
		FilterInfo fi1 = new FilterInfo();//建立过滤条件
    	fi1.getFilterItems().add(
    			new FilterItemInfo("number", typeNumber, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi1.setFilter(fi1);//添加过滤条件
    	// 获取所有属性
    	evi1.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi1.getSelector().add(new SelectorItemInfo("*"));
    	StoreStateCollection mgc= storetype.getStoreStateCollection(evi1);
    
    	StoreStateInfo mgInfo = null;
    	
    	if(mgc != null && mgc.size() > 0){
    		StoreStateInfo mgi = mgc.get(0);
    		mgInfo = mgi;
    		
    	}
    	return mgInfo;
	}
	/**
	 * 截取字符串的 指定字符数量
	 * 
	 * 输入为一个字符串和字节数，输出为按字节截取的字符串。 
	 * 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，
	 * 输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
	 * @param str
	 * @param byteNum
	 * @return
	 */
	public static String splitString(String str, int byteNum){
		if(StringUtils.isNotBlank(str) && byteNum > 0){
			
			
			byte bt[] = str.getBytes();
			
			if(byteNum > bt.length){
				return str;
			}
			if (byteNum >= 1 )
			{
				if (bt[byteNum] < 0 )
				{
					String substrx = new String(bt, 0 , -- byteNum);
					return substrx;
				} else
				{
					String substrex = new String(bt, 0 ,byteNum);
					return substrex;
				}

			} else
			{
				return StringUtils.EMPTY;
			}
		}else{
			return StringUtils.EMPTY;
		}
	}
	
	/**
	 * 获取行类型  根据编号
	 * @param ctx
	 * @param number
	 * @return
	 * @throws BOSException 
	 */
	public RowTypeInfo getRowTypeInfoByNumber(Context ctx, String number) throws BOSException{
//		String typeNumber = storeStateNumber;
		IRowType storetype  = null;
		if(ctx != null){
			storetype = RowTypeFactory.getLocalInstance(ctx);
		}else{
			storetype = RowTypeFactory.getRemoteInstance();
		}
		EntityViewInfo evi1 = new EntityViewInfo();
		FilterInfo fi1 = new FilterInfo();//建立过滤条件
    	fi1.getFilterItems().add(
    			new FilterItemInfo("number", number, CompareType.EQUALS));
    	
//    	i. setMaskString(" (#0 )");
    	evi1.setFilter(fi1);//添加过滤条件
    	// 获取所有属性
    	evi1.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
    	evi1.getSelector().add(new SelectorItemInfo("*"));
    	RowTypeCollection mgc= storetype.getRowTypeCollection(evi1);
    
    	RowTypeInfo mgInfo = null;
    	
    	if(mgc != null && mgc.size() > 0){
    		RowTypeInfo mgi = mgc.get(0);
    		mgInfo = mgi;
    		
    	}
    	return mgInfo;
	}
	
	
	
	/**
	 * 获取结算方式 根据编号
	 * @param ctx
	 * @param number
	 * @return
	 * @throws BOSException 
	 */
	public SettlementTypeInfo getSettleTypeByNumber(Context ctx, String number) throws BOSException{
//		String typeNumber = storeStateNumber;
		if(StringUtils.isNotBlank(number)){
			ISettlementType settleType  = null;
			if(ctx != null){
				settleType = SettlementTypeFactory.getLocalInstance(ctx);
			}else{
				settleType = SettlementTypeFactory.getRemoteInstance();
			}
			EntityViewInfo evi1 = new EntityViewInfo();
			FilterInfo fi1 = new FilterInfo();//建立过滤条件
	    	fi1.getFilterItems().add(
	    			new FilterItemInfo("number", number, CompareType.EQUALS));
	    	
	//    	i. setMaskString(" (#0 )");
	    	evi1.setFilter(fi1);//添加过滤条件
	    	// 获取所有属性
	    	evi1.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
	    	evi1.getSelector().add(new SelectorItemInfo("*"));
	    	SettlementTypeCollection mgc= settleType.getSettlementTypeCollection(evi1);
	    
	    	SettlementTypeInfo mgInfo = null;
	    	
	    	if(mgc != null && mgc.size() > 0){
	    		SettlementTypeInfo mgi = mgc.get(0);
	    		mgInfo = mgi;
	    		
	    	}
			
	    	return mgInfo;
		}else{
			return null;
		}
	}
	
	
	/**
	 * 根据期间编码获得 期间信息
	 * @param ctx
	 * @param periodNumber
	 * @return
	 * @throws BOSException 
	 */
	public static PeriodInfo getPeriodInfoByNumber(Context ctx,int periodNumber) throws BOSException{
//		StringBuilder sb = new StringBuilder("/*dialect*/");
		
			IPeriod settleType  = null;
			if(ctx != null){
				settleType = PeriodFactory.getLocalInstance(ctx);
			}else{
				settleType = PeriodFactory.getRemoteInstance();
			}
			EntityViewInfo evi1 = new EntityViewInfo();
			FilterInfo fi1 = new FilterInfo();//建立过滤条件
	    	fi1.getFilterItems().add(
	    			new FilterItemInfo("number", periodNumber, CompareType.EQUALS));
	    	
	//    	i. setMaskString(" (#0 )");
	    	evi1.setFilter(fi1);//添加过滤条件
	    	// 获取所有属性
	    	evi1.getSelector().add(new SelectorItemInfo("id"));//添加获取属性
	    	evi1.getSelector().add(new SelectorItemInfo("*"));
	    	PeriodCollection mgc= settleType.getPeriodCollection(evi1);
	    
	    	PeriodInfo mgInfo = null;
	    	
	    	if(mgc != null && mgc.size() > 0){
	    		PeriodInfo mgi = mgc.get(0);
	    		mgInfo = mgi;
	    		
	    	}
			
	    	return mgInfo;
		
	}
	 /**  
     * 计算两个日期之间相差的天数   
     * @param smdate 
     * @param bdate  
     * @return 相差天数 
	 * @throws BOSException 
     */    
    public static int daysBetween(Date smdate,Date bdate) throws BOSException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        try{
//        	if(bdate.before(smdate)){
//        		throw new BOSException("养殖日期不能早于入栏日期");
//        	}
        	
	        smdate=sdf.parse(sdf.format(smdate));  
	        bdate=sdf.parse(sdf.format(bdate));  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	        return Math.abs(Integer.parseInt(String.valueOf(between_days)));    
        }catch(ParseException pe){
        	throw new BOSException("计算日期差值报错",pe);
        }
    }    
		
	
}
