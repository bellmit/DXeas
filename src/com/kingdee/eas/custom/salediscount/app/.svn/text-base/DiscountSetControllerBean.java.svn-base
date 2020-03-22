package com.kingdee.eas.custom.salediscount.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ContextUtils;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSObjectTypeFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.param.IParamControl;
import com.kingdee.eas.base.param.ParamControlFactory;
import com.kingdee.eas.basedata.framework.util.EntityControlTypeUtil;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.ICSSPGroup;
import com.kingdee.eas.basedata.master.cssp.ICustomer;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.IMaterialGroup;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CUBDControlFactory;
import com.kingdee.eas.basedata.org.CUBDControlInfo;
import com.kingdee.eas.basedata.org.ICUBDControl;
import com.kingdee.eas.basedata.org.ISaleOrgUnit;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum;
import com.kingdee.eas.basedata.scm.common.PriceCompositionEnum;
import com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum;
import com.kingdee.eas.basedata.scm.sd.sale.IMaterialBasePrice;
import com.kingdee.eas.basedata.scm.sd.sale.IPriceParam;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceFactory;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.PriceParamException;
import com.kingdee.eas.basedata.scm.sd.sale.PriceParamFactory;
import com.kingdee.eas.basedata.scm.sd.sale.PriceParamInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountSetException;
import com.kingdee.eas.custom.salediscount.DiscountSetFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.custom.salediscount.EntryState;
import com.kingdee.eas.custom.salediscount.IDiscountSetEntry;
import com.kingdee.eas.framework.CheckedStatusEnum;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ObjectBaseInfo;
import com.kingdee.eas.scm.common.loadmass.app.DataLoaderHelper;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.db.SQLUtils;


public class DiscountSetControllerBean extends AbstractDiscountSetControllerBean
{
  private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.salediscount.app.DiscountSetControllerBean");
  private static final String true_str = "1";

  protected IObjectPK _save(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    DiscountSetInfo DiscountSetInfo = (DiscountSetInfo)model;
    DiscountSetInfo.setEffectiveDate(getOutDate("start", DiscountSetInfo.getEffectiveDate()));

    DiscountSetInfo.setExpireDate(getOutDate("end", DiscountSetInfo.getExpireDate()));

    DiscountSetEntryCollection pricePolicyCollection = DiscountSetInfo.getEntries();

    DiscountSetEntryInfo entryInfo = null;
    int i = 0; for (int size = pricePolicyCollection.size(); i < size; ++i) {
      entryInfo = pricePolicyCollection.get(i);
      entryInfo.setEffectiveDate(getOutDate("start", entryInfo.getEffectiveDate()));

      entryInfo.setExpireDate(getOutDate("end", entryInfo.getExpireDate()));
      
      // 校验  实物折扣数量1 实物折扣数量2 不能为0
      BigDecimal swqty1 = entryInfo.getSwQty1();
      BigDecimal swqty2 = entryInfo.getSwQty2();
      BigDecimal qty1 = entryInfo.getQty1();
      if(qty1 == null) qty1 = new BigDecimal("0");
      BigDecimal qty2 = entryInfo.getQty2();
      BigDecimal standard1 = entryInfo.getStandard1();
      BigDecimal standard2 = entryInfo.getStandard2();
      DiscountTypeEnum dsTypeEnum = DiscountSetInfo.getDiscountType();
      if(!DiscountTypeEnum.ShiWu.equals(dsTypeEnum)){
    	  
    	  if(qty2 != null &&
    			  qty1 != null &&
    			  (standard2 != null && standard2.compareTo(new BigDecimal("0")) > 0) && 
    			  qty2.compareTo(qty1) <= 0){
    		  	throw new BOSException("【数量2】不能小于【数量1】");
    	  }
      }	
      
      
      if(DiscountTypeEnum.ShiWu.equals(dsTypeEnum)){
    	  if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
    		  throw new BOSException("实物折扣分录【实物折扣量一(吨)】字段不能为空或0");
    	  }else if((qty2 != null && qty2.compareTo(new BigDecimal("0")) > 0 )
    			  && (swqty2 == null || swqty2.compareTo(new BigDecimal("0")) == 0)){
    		  throw new BOSException("实物折扣分录【实物折扣量二(吨)】字段不能为空或0");
    	  }else if((swqty2 != null && swqty2.compareTo(new BigDecimal("0")) >  0) && (qty2 == null ||  qty2.compareTo(qty1) <= 0 )){
    		  throw new BOSException("【数量2】不能小于【数量1】");
    	  }
      }
      
    }

    return super._save(ctx, model);
  }
  
  /**
   * 校验五个数量 的 数据是否规范
   * @param entryInfo
   */
  private void checkEntryStandardSet(DiscountSetEntryInfo entryInfo){
	  // 从数量一 循环到数量五校验设置内容
	  for(int i = 1; i < 6; i++){
		  
	  }
	  
  }

  private Date getOutDate(String s, Date d)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d);

//    if (s.equals("start")) {
//      calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
//    }
//    else if (s.equals("end")) {
//      calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
//    }

    return calendar.getTime();
  }

  protected void _addnew(Context ctx, IObjectPK pk, IObjectValue model)
    throws BOSException, EASBizException
  {
    DiscountSetInfo info = (DiscountSetInfo)model;
    info.setCU(super.getCU(ctx, info));
    checkAll(ctx, info);

    info.setPriceCompositionPriority(getPriceCompositionPriority(ctx, info.getPriceComposition(), info.getSaleOrgUnit().getId().toString()));

    autoAudit(ctx, info);
    info.setId(BOSUuid.read(pk.toString()));

    IDiscountSetEntry ientry = DiscountSetEntryFactory.getLocalInstance(ctx);
    int i = 0; for (int c = info.getEntries().size(); i < c; ++i) {
      if (info.getEntries().get(i).getId() == null) {
        info.getEntries().get(i).setParent(info);
        ientry.addnew(info.getEntries().get(i));
      } else {
        ientry.update(new ObjectUuidPK(info.getEntries().get(i).getId()), info.getEntries().get(i));
      }
    }
    super._addnew(ctx, pk, info);
  }

  protected IObjectPK _addnew(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    DiscountSetInfo info = (DiscountSetInfo)model;
    info.setCU(super.getCU(ctx, info));
    checkAll(ctx, info);

    info.setPriceCompositionPriority(getPriceCompositionPriority(ctx, info.getPriceComposition(), info.getSaleOrgUnit().getId().toString()));

    autoAudit(ctx, info);
    IObjectPK pk = super._addnew(ctx, info);
    info.setId(BOSUuid.read(pk.toString()));

    IDiscountSetEntry ientry = DiscountSetEntryFactory.getLocalInstance(ctx);
    int i = 0; for (int c = info.getEntries().size(); i < c; ++i) {
      if (info.getEntries().get(i).getId() == null) {
        info.getEntries().get(i).setParent(info);
        ientry.addnew(info.getEntries().get(i));
      } else {
        ientry.update(new ObjectUuidPK(info.getEntries().get(i).getId()), info.getEntries().get(i));
      }
    }
    return pk;
  }

  protected void _update(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException
  {
    DiscountSetInfo info = (DiscountSetInfo)model;
    info.setCU(super.getCU(ctx, info));
//    checkAll(ctx, info);
//
//    info.setPriceCompositionPriority(getPriceCompositionPriority(ctx, info.getPriceComposition(), info.getSaleOrgUnit().getId().toString()));
//
//    autoAudit(ctx, info);

    IDiscountSetEntry ientry = DiscountSetEntryFactory.getLocalInstance(ctx);
    DiscountSetEntryInfo entryInfo = null;
    int i = 0; for (int c = info.getEntries().size(); i < c; ++i) {
      entryInfo = info.getEntries().get(i);
      if ((info.getEntries().get(i).getId() == null) && (checkBusiEntryOnlyOne(ctx, info, entryInfo))) {
        info.getEntries().get(i).setParent(info);
        ientry.addnew(info.getEntries().get(i));
      } else {
        ientry.update(new ObjectUuidPK(info.getEntries().get(i).getId()), info.getEntries().get(i));
      }
    }
    super._update(ctx, pk, info);
  }

  protected void _delete(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    StringBuffer sql = new StringBuffer();
    if (!(_isCanDelete(ctx, pk.toString()))) {
      throw new DiscountSetException(DiscountSetException.PRICENOTDELETE);
    }
    sql.append(" delete CT_NDI_DiscountSetEntry where FParentid = '").append(pk.toString()).append("'");

    DbUtil.execute(ctx, sql.toString());
    super._delete(ctx, pk);
  }

  protected void _delete(Context ctx, IObjectPK[] arrayPK)
    throws BOSException, EASBizException
  {
    int i = 0; for (int n = arrayPK.length; i < n; ++i)
      super.delete(ctx, arrayPK[i]);
  }

  private String convertToString(Object[] objs)
  {
    if ((objs == null) || (objs.length == 0)) {
      return "";
    }

    StringBuffer sb = new StringBuffer();
    int i = 0; for (int count = objs.length; i < count; ++i) {
      if (objs[i] == null) {
        continue;
      }
      if (i > 0) {
        sb.append(",");
      }
      sb.append("'");
      sb.append(objs[i].toString());
      sb.append("'");
    }

    return sb.toString();
  }

  private void autoAudit(Context ctx, DiscountSetInfo info) throws BOSException
  {
    String cuId = info.getSaleOrgUnit().getId().toString();
    if (!(isAutoAudit(ctx, cuId))) {
      return;
    }
    info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

    info.setAuditDate(new Date());

    info.setCheckedStatus(CheckedStatusEnum.AUDITED);
  }

  private boolean isAutoAudit(Context ctx, String cuId)
    throws BOSException
  {
    IPriceParam pp = PriceParamFactory.getLocalInstance(ctx);
    PriceParamInfo info = null;
    try
    {
      info = pp.getItemParameter(cuId, "PricePa003");
    }
    catch (PriceParamException e) {
      logger.error(e);
    }
    if (info != null) {
      return info.isAutoAudit();
    }

    return false;
  }

  private short getPriceCompositionPriority(Context ctx, PriceCompositionEnum priceComp, String saleid) throws BOSException
  {
    IPriceParam pp = PriceParamFactory.getLocalInstance(ctx);
    short priValue = -1;
    PriceParamInfo info = null;
    try
    {
      switch (priceComp.getValue()) {
      case 2:
        info = pp.getItemParameter(saleid, "PricePa014");
        priValue = (short)info.getCusMatPri();
        break;
      case 1:
        info = pp.getItemParameter(saleid, "PricePa016");
        priValue = (short)info.getCusGrpMatPri();
        break;
      case 5:
        info = pp.getItemParameter(saleid, "PricePa015");
        priValue = (short)info.getCusMatGrpPri();
        break;
      case 6:
        info = pp.getItemParameter(saleid, "PricePa017");
        priValue = (short)info.getCusGrpMatGrpPri();
      case 3:
      case 4:
      }
    }
    catch (Exception e) {
      logger.error(e);
      throw new BOSException("获取价格组合优先级失败。");
    }
    return priValue;
  }

  private void checkAll(Context ctx, DiscountSetInfo info)
    throws BOSException, EASBizException
  {
    if (info == null)
    {
      throw new DiscountSetException(DiscountSetException.NUMBERISNULL);
    }
    checkName(ctx, info);
    checkNumber(ctx, info);
    checkIntegrity(info);
//    checkBusiOnlyOne(ctx, info);
    checkHasBasePrice(ctx, info);
  }

  private void checkHasBasePrice(Context ctx, DiscountSetInfo info) throws BOSException, EASBizException {
    SaleOrgUnitInfo saleInfo = info.getSaleOrgUnit();
    String cuid = null;
    if (saleInfo.getCU() != null) {
      cuid = saleInfo.getCU().getId().toString();
    } else {
      ISaleOrgUnit isale = SaleOrgUnitFactory.getLocalInstance(ctx);
      saleInfo = isale.getSaleOrgUnitInfo(new ObjectUuidPK(saleInfo.getId()));
      cuid = saleInfo.getCU().getId().toString();
    }
    StringBuffer materialIds = new StringBuffer();
    int row = 0; for (int nrow = info.getEntries().size(); row < nrow; ++row) {
      DiscountSetEntryInfo entryinfo = info.getEntries().get(row);
      if (entryinfo.getMaterial() instanceof MaterialInfo) {
        if (materialIds.length() > 0) {
          materialIds.append(",");
        }
        materialIds.append(entryinfo.getMaterial().getId().toString());
      }
    }
    ICUBDControl iCUBDControl = CUBDControlFactory.getLocalInstance(ctx);
    CUBDControlInfo controlInfo = iCUBDControl.getBDCtrlInfo(BOSObjectType.create("6ADDC7FB").toString(), cuid);
    boolean flag = (controlInfo == null) ? false : controlInfo.isIsSubordinateAddnewable();
    if (!(flag)) {
      IMaterialBasePrice iBasePrice = MaterialBasePriceFactory.getLocalInstance(ctx);
      Map result = iBasePrice.existsBasePrice(materialIds.toString().split(","), cuid);
      if (!(result.isEmpty())) {
        int row1 = 0; for (int nrow = info.getEntries().size(); row1 < nrow; ++row1) {
          DiscountSetEntryInfo entryinfo = info.getEntries().get(row1);
          if ((!(entryinfo.getMaterial() instanceof MaterialInfo)) || 
            (!(result.get(entryinfo.getMaterial().getId().toString()) instanceof Boolean))) continue;
          throw new DiscountSetException(DiscountSetException.HASNOBASEPRICE, new String[] { info.getNumber(), entryinfo.getMaterial().getNumber() });
        }
      }
    }
  }

  private void checkName(Context ctx, DiscountSetInfo info)
    throws BOSException, EASBizException
  {
    if ((info.getName() != null) && (!(info.getName().equals(""))))
      return;
    throw new DiscountSetException(DiscountSetException.NAMEISNULL);
  }

  private void checkNumber(Context ctx, DiscountSetInfo info)
    throws BOSException, EASBizException
  {
    if ((info.getNumber() == null) || (info.getNumber().equals("")))
    {
      throw new DiscountSetException(DiscountSetException.NUMBERISNULL);
    }
    _checkNumberDup(ctx, info);
  }

  private void _checkNameDup(Context ctx, DiscountSetInfo dataBaseInfo) throws BOSException, EASBizException
  {
    FilterInfo filter = new FilterInfo();
    FilterItemInfo filterItem = new FilterItemInfo("name", dataBaseInfo.getName(), CompareType.EQUALS);

    filter.getFilterItems().add(filterItem);
    if (dataBaseInfo.getId() != null)
    {
      filterItem = new FilterItemInfo("id", dataBaseInfo.getId(), CompareType.NOTEQUALS);
      filter.getFilterItems().add(filterItem);
      filter.setMaskString("#0 and #1");
    }
    EntityViewInfo view = new EntityViewInfo();
    view.setFilter(filter);
    SorterItemCollection sorter = new SorterItemCollection();
    sorter.add(new SorterItemInfo("id"));
    if (!(super._exists(ctx, filter)))
      return;
    String name = _getPropertyAlias(ctx, dataBaseInfo, "name") + dataBaseInfo.getName();

    throw new EASBizException(EASBizException.CHECKDUPLICATED, new Object[] { name });
  }

  private void _checkNumberDup(Context ctx, DiscountSetInfo dataBaseInfo)
    throws BOSException, EASBizException
  {
    FilterInfo filter = new FilterInfo();
    FilterItemInfo filterItem = new FilterItemInfo("number", dataBaseInfo.getNumber(), CompareType.EQUALS);

    filter.getFilterItems().add(filterItem);
    if (dataBaseInfo.getId() != null)
    {
      filterItem = new FilterItemInfo("id", dataBaseInfo.getId(), CompareType.NOTEQUALS);
      filter.getFilterItems().add(filterItem);
    }

    if ((getFilterForCheckNumber(dataBaseInfo) != null) && (getFilterForCheckNumber(dataBaseInfo).size() > 0))
    {
      filter.mergeFilter(getFilterForCheckNumber(dataBaseInfo), "AND");
    }

    EntityViewInfo view = new EntityViewInfo();
    view.setFilter(filter);
    SorterItemCollection sorter = new SorterItemCollection();
    sorter.add(new SorterItemInfo("id"));

    if (!(super._exists(ctx, filter)))
      return;
    String number = _getPropertyAlias(ctx, dataBaseInfo, "number") + dataBaseInfo.getNumber();

    throw new EASBizException(EASBizException.CHECKDUPLICATED, new Object[] { number });
  }

  private FilterInfo getFilterForCheckNumber(IObjectValue model)
  {
    FilterInfo filter = new FilterInfo();
    ObjectBaseInfo info = (ObjectBaseInfo)model;
    if (info.getCU() == null)
    {
      filter.getFilterItems().add(new FilterItemInfo("CU.id", super.getCU(ContextUtils.getContextFromSession(), info).getId().toString(), CompareType.EQUALS));

      return filter;
    }
    filter.getFilterItems().add(new FilterItemInfo("CU.id", info.getCU().getId().toString(), CompareType.EQUALS));

    return filter;
  }

  private String _getPropertyAlias(Context ctx, ObjectBaseInfo dataBaseInfo, String propertyName)
  {
    IMetaDataLoader loader = MetaDataLoaderFactory.getMetaDataLoader(ctx);
    EntityObjectInfo entity = null;
    entity = loader.getEntity(dataBaseInfo.getBOSType());
    PropertyInfo property = null;

    property = entity.getPropertyByName(propertyName);
    if (property == null)
    {
      return "";
    }

    return property.getAlias();
  }

  private void checkBusiOnlyOne(Context ctx, DiscountSetInfo info)
    throws BOSException, EASBizException
  {
    FilterInfo filter = new FilterInfo();
    FilterItemInfo filterItemInfo = null;
    if (info.getId() != null)
    {
      filterItemInfo = new FilterItemInfo("id", info.getId().toString(), CompareType.NOTEQUALS);
      filter.getFilterItems().add(filterItemInfo);
    }

//    filterItemInfo = new FilterItemInfo("priority", new Integer(info.getPriority()), CompareType.EQUALS);
//    filter.getFilterItems().add(filterItemInfo);

    filterItemInfo = new FilterItemInfo("priceCompDetailCustomer", info.getPriceCompDetailCustomer(), CompareType.EQUALS);

    filter.getFilterItems().add(filterItemInfo);

    filterItemInfo = new FilterItemInfo("priceCompDetailmaterial", info.getPriceCompDetailmaterial(), CompareType.EQUALS);

    filter.getFilterItems().add(filterItemInfo);

    filterItemInfo = new FilterItemInfo("saleOrgUnit.id", info.getSaleOrgUnit().getId().toString(), CompareType.EQUALS);

    filter.getFilterItems().add(filterItemInfo);

    boolean exist = _exists(ctx, filter);
    if (!(exist))
      return;
    throw new DiscountSetException(DiscountSetException.NOTONLYONE);
  }

  private boolean checkBusiEntryOnlyOne(Context ctx, DiscountSetInfo info, DiscountSetEntryInfo entryInfo)
    throws BOSException, EASBizException
  {
    boolean isExistEntryInfo = false;
    FilterInfo filter = new FilterInfo();
    FilterItemInfo filterItemInfo = null;
    if (info.getId() != null)
    {
      filterItemInfo = new FilterItemInfo("parent", info.getId().toString(), CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);
    }

    String customer = null;
    String material = null;
    String customerGroup = null;
    String materialGroup = null;
    String priceType = null;

    String measureUnit = null;
    String asistProperty = null;
    String currency = null;
    int discountCondition = -1;
    BigDecimal qtyMin = null;
    BigDecimal qtyMax = null;
    BigDecimal amtMin = null;
    BigDecimal amtMax = null;
    EntryState entryState = null;

    if (entryInfo.getCustomer() != null) {
      customer = entryInfo.getCustomer().getId().toString();
    }
    if (entryInfo.getMaterial() != null) {
      material = entryInfo.getMaterial().getId().toString();
    }
//    if (entryInfo.getCustomerGroup() != null) {
//      customerGroup = entryInfo.getCustomerGroup().getId().toString();
//    }
//    if (entryInfo.getMaterialGroup() != null) {
//      materialGroup = entryInfo.getMaterialGroup().getId().toString();
//    }
//    if (entryInfo.getPriceType() != null) {
//      priceType = entryInfo.getPriceType().getId().toString();
//    }
    if (entryInfo.getDiscountCondition() != null) {
      discountCondition = entryInfo.getDiscountCondition().getValue();
    }
    if (entryInfo.getMeasureUnit() != null) {
      measureUnit = entryInfo.getMeasureUnit().getId().toString();
    }
    if (entryInfo.getAsistProperty() != null) {
      asistProperty = entryInfo.getAsistProperty().getId().toString();
    }
    if (entryInfo.getCurrency() != null) {
      currency = entryInfo.getCurrency().getId().toString();
    }
//    if (entryInfo.getQtyMin() != null) {
//      qtyMin = entryInfo.getQtyMin();
//    }
//    if (entryInfo.getQtyMax() != null) {
//      qtyMax = entryInfo.getQtyMax();
//    }
//    if (entryInfo.getAmtMin() != null) {
//      amtMin = entryInfo.getAmtMin();
//    }
//    if (entryInfo.getAmtMax() != null) {
//      amtMax = entryInfo.getAmtMax();
//    }

    if (entryInfo.getLockedState() != null) {
    	entryState = entryInfo.getLockedState();
      }
    
    switch (info.getPriceComposition().getValue())
    {
    case 1:
      filterItemInfo = new FilterItemInfo("customerGroup.id", customerGroup, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("material.id", material, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("measureUnit.id", measureUnit, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("asistProperty.id", asistProperty, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);
      break;
    case 9:
      filterItemInfo = new FilterItemInfo("material.id", material, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("customerGroup.id", customerGroup, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("measureUnit.id", measureUnit, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("asistProperty.id", asistProperty, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      break;
    case 2:
      filterItemInfo = new FilterItemInfo("material.id", material, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("customer.id", customer, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("measureUnit.id", measureUnit, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("asistProperty.id", asistProperty, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);
      break;
    case 7:
      filterItemInfo = new FilterItemInfo("material.id", material, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("customer.id", customer, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("measureUnit.id", measureUnit, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("asistProperty.id", asistProperty, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);
      break;
    case 5:
      filterItemInfo = new FilterItemInfo("customer.id", customer, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);

//      filterItemInfo = new FilterItemInfo("materialGroup.id", materialGroup, CompareType.EQUALS);
//      filter.getFilterItems().add(filterItemInfo);
      break;
    case 8:
//      filterItemInfo = new FilterItemInfo("materialGroup.id", materialGroup, CompareType.EQUALS);
//      filter.getFilterItems().add(filterItemInfo);

      filterItemInfo = new FilterItemInfo("customer.id", customer, CompareType.EQUALS);
      filter.getFilterItems().add(filterItemInfo);
      break;
    case 6:
//      filterItemInfo = new FilterItemInfo("customerGroup.id", customerGroup, CompareType.EQUALS);
//      filter.getFilterItems().add(filterItemInfo);

//      filterItemInfo = new FilterItemInfo("materialGroup.id", materialGroup, CompareType.EQUALS);
//      filter.getFilterItems().add(filterItemInfo);
      break;
    case 10:
//      filterItemInfo = new FilterItemInfo("customerGroup.id", customerGroup, CompareType.EQUALS);
//      filter.getFilterItems().add(filterItemInfo);
//
//      filterItemInfo = new FilterItemInfo("materialGroup.id", materialGroup, CompareType.EQUALS);
//      filter.getFilterItems().add(filterItemInfo);
    case 3:
    case 4:
    }
//    filterItemInfo = new FilterItemInfo("priceType", priceType, CompareType.EQUALS);
//    filter.getFilterItems().add(filterItemInfo);

    filterItemInfo = new FilterItemInfo("currency.id", currency, CompareType.EQUALS);
    filter.getFilterItems().add(filterItemInfo);

    filterItemInfo = new FilterItemInfo("discountCondition", new Integer(discountCondition), CompareType.EQUALS);
    filter.getFilterItems().add(filterItemInfo);

//    filterItemInfo = new FilterItemInfo("qtyMin", qtyMin, CompareType.EQUALS);
//    filter.getFilterItems().add(filterItemInfo);

//    filterItemInfo = new FilterItemInfo("qtyMax", qtyMax, CompareType.EQUALS);
//    filter.getFilterItems().add(filterItemInfo);

//    filterItemInfo = new FilterItemInfo("amtMin", amtMax, CompareType.EQUALS);
//    filter.getFilterItems().add(filterItemInfo);

//    filterItemInfo = new FilterItemInfo("amtMax", amtMax, CompareType.EQUALS);
//    filter.getFilterItems().add(filterItemInfo);

    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setFilter(filter);
    CoreBaseCollection collection = DiscountSetEntryFactory.getLocalInstance(ctx).getCollection(entityViewInfo);

    if ((((collection != null) ? 1 : 0) & ((collection.size() > 0) ? 1 : 0)) != 0) {
//      DiscountSetEntryInfo tempInfo = (DiscountSetEntryInfo)collection.get(0);
//      if (tempInfo != null && entryState.equals(EntryState.UnLocked) ) {
//        isExistEntryInfo = true;
//        entryInfo.setId(tempInfo.getId());
//      } else {
//        isExistEntryInfo = false;
//      }
    } else {
      isExistEntryInfo = false;
    }
    return (!(isExistEntryInfo));
  }

  private void checkIntegrity(DiscountSetInfo info) throws EASBizException
  {
    if (info.getPriceCompDetailCustomer() == null)
    {
      throw new DiscountSetException(DiscountSetException.PRICECOMPDETAILCUSTOMERISNULL);
    }
    if (info.getPriceCompDetailmaterial() == null)
    {
      throw new DiscountSetException(DiscountSetException.PRICECOMPDETAILMATERIALISNULL);
    }
    if (info.getEffectiveDate() == null)
    {
      throw new DiscountSetException(DiscountSetException.EFFECTIVEDATEISNULL);
    }

    if (info.getExpireDate() != null)
      return;
    throw new DiscountSetException(DiscountSetException.EXPIREDATEISNULL);
  }

  protected void _audit(Context ctx, IObjectPK[] pks)
    throws BOSException, DiscountSetException, EASBizException
  {
    if ((pks == null) || (pks.length <= 0))
    {
      throw new DiscountSetException(DiscountSetException.PKSISNULL);
    }
    DiscountSetInfo[] infos = new DiscountSetInfo[pks.length];

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i] = ((DiscountSetInfo)_getValue(ctx, pks[i]));

      if ((!(infos[i].getBlockedStatus().equals(ForbidStatusEnum.FORBID))) && (!(infos[i].getCheckedStatus().equals(CheckedStatusEnum.AUDITED)))) {
        continue;
      }
      throw new DiscountSetException(DiscountSetException.CANNOTAUDIT);
    }

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i].setAuditor(ContextUtil.getCurrentUserInfo(ctx));

      infos[i].setAuditDate(new Date());

      infos[i].setCheckedStatus(CheckedStatusEnum.AUDITED);

      _update(ctx, pks[i], infos[i]);
    }
  }

  protected void _auditForEntries(Context ctx, IObjectPK[] pks)
    throws BOSException, DiscountSetException, EASBizException
  {
    if ((pks == null) || (pks.length <= 0))
    {
      throw new DiscountSetException(DiscountSetException.PKSISNULL);
    }
    IDiscountSetEntry pp = DiscountSetEntryFactory.getLocalInstance(ctx);

    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("checkedStatus"));

    for (int i = 0; i < pks.length; ++i)
    {
      DiscountSetEntryInfo info = (DiscountSetEntryInfo)pp.getValue(pks[i]);

      info.setCheckedStatus(CheckedStatusEnum.AUDITED);
      pp.updatePartial(info, sic);
    }
  }

  protected void _unAudit(Context ctx, IObjectPK[] pks) throws BOSException, DiscountSetException, EASBizException
  {
    if ((pks == null) || (pks.length <= 0))
    {
      throw new DiscountSetException(DiscountSetException.PKSISNULL);
    }
    DiscountSetInfo[] infos = new DiscountSetInfo[pks.length];

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i] = ((DiscountSetInfo)_getValue(ctx, pks[i]));

      if ((!(ForbidStatusEnum.FORBID.equals(infos[i].getBlockedStatus()))) && (!(CheckedStatusEnum.UNAUDITED.equals(infos[i].getCheckedStatus())))) {
        continue;
      }
      throw new DiscountSetException(DiscountSetException.CANNOTUNAUDIT);
    }

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i].setAuditor(null);

      infos[i].setAuditDate(null);

      infos[i].setCheckedStatus(CheckedStatusEnum.UNAUDITED);
      super._update(ctx, pks[i], infos[i]);
    }
  }

  protected void _unAuditForEntries(Context ctx, IObjectPK[] pks)
    throws BOSException, DiscountSetException, EASBizException
  {
    if ((pks == null) || (pks.length <= 0))
    {
      throw new DiscountSetException(DiscountSetException.PKSISNULL);
    }
    IDiscountSetEntry pp = DiscountSetEntryFactory.getLocalInstance(ctx);

    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("checkedStatus"));

    for (int i = 0; i < pks.length; ++i)
    {
      DiscountSetEntryInfo info = (DiscountSetEntryInfo)pp.getValue(pks[i]);

      info.setCheckedStatus(CheckedStatusEnum.UNAUDITED);
      pp.updatePartial(info, sic);
    }
  }

  protected void _block(Context ctx, IObjectPK[] pks) throws BOSException, DiscountSetException, EASBizException
  {
    if ((pks == null) || (pks.length <= 0))
    {
      throw new DiscountSetException(DiscountSetException.PKSISNULL);
    }

    DiscountSetInfo[] infos = new DiscountSetInfo[pks.length];

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i] = ((DiscountSetInfo)_getValue(ctx, pks[i]));

      if ((!(CheckedStatusEnum.UNAUDITED.equals(infos[i].getCheckedStatus()))) && (!(ForbidStatusEnum.FORBID.equals(infos[i].getBlockedStatus())))) {
        continue;
      }
      throw new DiscountSetException(DiscountSetException.CANNOTBLOCK);
    }

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i].setBlockedStatus(ForbidStatusEnum.FORBID);
      _update(ctx, pks[i], infos[i]);
    }
  }

  protected void _unBlock(Context ctx, IObjectPK[] pks) throws BOSException, DiscountSetException, EASBizException
  {
    if ((pks == null) || (pks.length <= 0))
    {
      throw new DiscountSetException(DiscountSetException.PKSISNULL);
    }
    DiscountSetInfo[] infos = new DiscountSetInfo[pks.length];

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i] = ((DiscountSetInfo)_getValue(ctx, pks[i]));

      if ((!(CheckedStatusEnum.UNAUDITED.equals(infos[i].getCheckedStatus()))) && (!(ForbidStatusEnum.UNFORBID.equals(infos[i].getBlockedStatus())))) {
        continue;
      }
      throw new DiscountSetException(DiscountSetException.CANNOTUNBLOCK);
    }

    for (int i = 0; i < pks.length; ++i)
    {
      infos[i].setBlockedStatus(ForbidStatusEnum.UNFORBID);
      _update(ctx, pks[i], infos[i]);
    }
  }

  protected boolean _isUniquePriceDetialForPolicy(Context ctx, IObjectPK pk)
    throws BOSException, DiscountSetException
  {
    return false;
  }

  protected boolean _isUniquePriceDetial(Context ctx, IObjectPK pk) throws BOSException, DiscountSetException
  {
    return false;
  }

  protected ArrayList _getCustomerCollection(Context ctx, String groupStandardId, String parentId, boolean isCustomerGroup)
    throws BOSException, DiscountSetException
  {
    StringBuffer sql = new StringBuffer();

    String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();

    String localeFix = ctx.getLocale().toString();
    if (isCustomerGroup)
    {
      sql.append("select csspgroup.fid as id ,csspgroup.FName_").append(localeFix).append(" as name,csspgroup.FNumber as number1,csspgroup.FIsLeaf as isLeaf,0 as customerType,csspgroup.FLongNumber longnumber1 from t_bd_csspgroup csspgroup ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = csspgroup.FControlUnitID ").append("  where csspgroup.FDeletedStatus =1 and  csspgroup.FCSSPGroupStandardID = '").append(groupStandardId).append("'");

      if (parentId == null)
      {
        sql.append(" and csspgroup.FParentId is null ");
      }
      else {
        sql.append(" and csspgroup.FParentId = '").append(parentId).append("'");
      }

    }
    else
    {
      sql.append("select csspgroup.fid as id ,csspgroup.FName_").append(localeFix).append(" as name,csspgroup.FNumber as number1,csspgroup.FIsLeaf as isLeaf,0 as customerType,csspgroup.FLongNumber longnumber1 from t_bd_csspgroup csspgroup ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = csspgroup.FControlUnitID ").append("  where csspgroup.FDeletedStatus =1 and  csspgroup.FCSSPGroupStandardID = '").append(groupStandardId).append("'");

      if (parentId == null)
      {
        sql.append(" and csspgroup.FParentId is null ");
      }
      else
      {
        sql.append(" and csspgroup.FParentId = '").append(parentId).append("'");

        sql.append(" union ");
        sql.append(" select a.fid as id,a.FName_").append(localeFix).append(" as name,a.FNumber as number1, 1 as isLeaf,1 as customerType ,null as longnumber1 from T_BD_Customer a ").append(" inner join T_BD_CustomerGroupDetail b on a.FID = b.FCustomerID ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = a.FControlUnitID").append(" where b.FCustomerGroupStandardID = '").append(groupStandardId).append("'").append(" and b.FCustomerGroupID = '").append(parentId).append("' ");
      }

    }

    IRowSet rs = null;
    ArrayList result = new ArrayList();
    try
    {
      rs = DbUtil.executeQuery(ctx, sql.toString());

      PriceCompositionInfo info = null;

      while (rs.next())
      {
        info = new PriceCompositionInfo();
        info.setId(rs.getString("id"));

        String tmp = rs.getString("isLeaf");
        if ("1".equals(tmp))
        {
          info.setIsLeaf(true);
        }
        else {
          info.setIsLeaf(false);
        }

        tmp = rs.getString("customerType");

        if ("1".equals(tmp))
        {
          info.setCompType(PriceCompDetailEnum.CUSTOMER);
          info.setIsCustomerGroup(false);
        }
        else
        {
          info.setCompType(PriceCompDetailEnum.CUSTOMERGROUP);
          info.setIsCustomerGroup(true);
          info.setGroupLongnumber(rs.getString("longnumber1"));
        }

        info.setName(rs.getString("name"));
        info.setNumber(rs.getString("number1"));

        result.add(info);
      }
    }
    catch (Exception e)
    {
      logger.error(e);
    }
    finally {
      SQLUtils.cleanup(rs);
    }
    return result;
  }

  private String formatInputStrWithEntityProperty(Context ctx, String str, String bostype, String linkname) {
    IMetaDataLoader metaDataLoader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
    EntityObjectInfo entity = metaDataLoader.getEntity(BOSObjectTypeFactory.getBOSType(bostype));

    for (int i = 0; i < entity.getInheritedProperties().size(); ++i) {
      str = str.replaceAll(linkname + entity.getInheritedProperties().get(i).getName(), linkname + entity.getInheritedProperties().get(i).getMappingField().getName());
    }
    if ((str != null) && (str.trim().equals(""))) {
      str = null;
    }
    return str;
  }

  protected ArrayList _getMaterialCollection(Context ctx, String parentId, boolean isMaterialGroup)
    throws BOSException, DiscountSetException
  {
    StringBuffer sql = new StringBuffer();

    String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
    String cuLongNumber = ContextUtil.getCurrentCtrlUnit(ctx).getLongNumber();
    PriceCompDetailEnum compType = PriceCompDetailEnum.CUSTOMER;
    String localeFix = ctx.getLocale().toString();
    if (isMaterialGroup) {
      sql.append("select fid as id ,FName_").append(localeFix).append(" as name,FNumber as number1,FIsLeaf as isLeaf,0 as materialType from T_BD_MaterialGroup ").append(" where  FDeletedStatus =1 ");

      if (parentId == null)
        sql.append(" and FParentId is null ");
      else {
        sql.append(" and FParentId = '").append(parentId).append("'");
      }
      compType = PriceCompDetailEnum.MATERIALGROUP;
    } else {
      sql.append("select fid as id ,FName_").append(localeFix).append(" as name,FNumber as number1,FIsLeaf as isLeaf,0 as materialType  from T_BD_MaterialGroup ").append(" where  FDeletedStatus = 1 ");

      if (parentId == null) {
        sql.append(" and FParentId is null ");
      }
      else
      {
        sql.append(" and FParentId = '").append(parentId).append("'");
        sql.append(" union ");
        sql.append("select a.fid as id ,a.FName_").append(localeFix).append(" as name,a.FNumber as number1,1 as isLeaf,1 as materialType from T_BD_Material a, ").append(getCuTableName()).append(" b").append(" where FMaterialGroupID = '").append(parentId).append("'").append(" and ").append(getS4Filter("b", "FControlUnitID", cuid, cuLongNumber));
      }

      compType = PriceCompDetailEnum.MATERIAL;
    }

    IRowSet rs = null;
    ArrayList result = new ArrayList();
    try {
      rs = DbUtil.executeQuery(ctx, sql.toString());

      PriceCompositionInfo info = null;

      while (rs.next()) {
        info = new PriceCompositionInfo();
        info.setId(rs.getString("id"));

        String tmp = rs.getString("isLeaf");
        if ("1".equals(tmp))
          info.setIsLeaf(true);
        else {
          info.setIsLeaf(false);
        }

        tmp = rs.getString("materialType");
        if ("1".equals(tmp)) {
          info.setCompType(PriceCompDetailEnum.MATERIAL);
          info.setIsCustomerGroup(false);
        } else {
          info.setCompType(PriceCompDetailEnum.MATERIALGROUP);
          info.setIsCustomerGroup(true);
        }

        info.setName(rs.getString("name"));
        info.setNumber(rs.getString("number1"));

        result.add(info);
      }
    }
    catch (Exception e) {
      logger.error(e);
    } finally {
      SQLUtils.cleanup(rs);
    }
    return result;
  }

  private String getCuTableName() {
    return "T_ORG_CtrlUnit";
  }

  private String getS4Filter(String tableAlias, String cuFieldName, String cuId, String cuLongNumber) {
    StringBuffer filter = new StringBuffer();
    filter.append(tableAlias).append(".").append(cuFieldName);
    if ((cuLongNumber == null) || (cuLongNumber.equals(""))) {
      return " = " + "'" + cuId + "'";
    }
    String[] longNumberArray = cuLongNumber.split("!");
    int size = longNumberArray.length;
    if (size > 0) {
      filter.append(" in (").append("'").append(cuId).append("'");
    }
    for (int i = 0; i < size; ++i) {
      filter.append(",").append("'").append(longNumberArray[i]).append("'");
    }

    filter.append(")");

    return filter.toString();
  }

  protected boolean _isCanDelete(Context ctx, String pricePolicyId)
    throws BOSException, DiscountSetException
  {
    IObjectPK pk = new ObjectUuidPK(BOSUuid.read(pricePolicyId));
    DiscountSetInfo pp = null;
    try
    {
      pp = (DiscountSetInfo)getValue(ctx, pk);
    }
    catch (EASBizException e) {
      logger.error(e);
    }

    return ((!(ForbidStatusEnum.FORBID.equals(pp.getBlockedStatus()))) && (!(CheckedStatusEnum.AUDITED.equals(pp.getCheckedStatus()))));
  }

  protected ArrayList _getCustomerCollection(Context ctx, HashMap params)
    throws BOSException, EASBizException
  {
    StringBuffer sql = new StringBuffer();
    String parentId = null;
    if (params.get("customerparentId") != null) {
      parentId = params.get("customerparentId").toString();
    }
    boolean isCustomerGroup = Boolean.valueOf(params.get("isCustomerGroup").toString()).booleanValue();
    String groupStandardId = params.get("customergroupStandardId").toString();
    String saleorgId = null;
    String cuid = null;
    String strS4 = "";
    SaleOrgUnitInfo saleOrgInfo = null;
    if (params.get("saleorgid") != null) {
      saleorgId = params.get("saleorgid").toString();
      SelectorItemCollection sic = new SelectorItemCollection();
      sic.add(new SelectorItemInfo("id"));
      sic.add(new SelectorItemInfo("isBizUnit"));
      sic.add(new SelectorItemInfo("cu.*"));
      saleOrgInfo = SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(new ObjectStringPK(saleorgId), sic);

      FilterInfo filterInfoCU = EntityControlTypeUtil.getFilterInfoForControlTypeS4(saleOrgInfo.getCU().getId().toString(), saleOrgInfo.getCU().getLongNumber());

      StringBuffer buffS4 = new StringBuffer();
      filterInfoCU.output(buffS4);
      cuid = saleOrgInfo.getCU().getId().toString();
      strS4 = formatInputStrWithEntityProperty(ctx, buffS4.toString(), "7A2569A2", "CU.");
    }
    String localeFix = ctx.getLocale().toString();
    if (cuid != null) {
      cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
    }

    if (isCustomerGroup) {
      sql.append("select csspgroup.fid as id ,csspgroup.FName_").append(localeFix).append(" as name,csspgroup.FNumber as number1,csspgroup.FIsLeaf as isLeaf,0 as customerType,csspgroup.FLongNumber longnumber1 from t_bd_csspgroup csspgroup ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = csspgroup.FControlUnitID ").append("  where csspgroup.FDeletedStatus =1 and  csspgroup.FCSSPGroupStandardID = '").append(groupStandardId).append("'");

      if (parentId == null)
        sql.append(" and csspgroup.FParentId is null ");
      else {
        sql.append(" and csspgroup.FParentId = '").append(parentId).append("'");
      }

      if ((strS4 != null) && (!(strS4.equals(""))))
        sql.append(" and " + strS4);
    }
    else {
      sql.append("select csspgroup.fid as id ,csspgroup.FName_").append(localeFix).append(" as name,csspgroup.FNumber as number1,csspgroup.FIsLeaf as isLeaf,0 as customerType,csspgroup.FLongNumber longnumber1 from t_bd_csspgroup csspgroup ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = csspgroup.FControlUnitID ").append("  where csspgroup.FDeletedStatus =1 and  csspgroup.FCSSPGroupStandardID = '").append(groupStandardId).append("'");

      if (parentId == null) {
        sql.append(" and csspgroup.FParentId is null ");
        if ((strS4 != null) && (!(strS4.equals(""))))
          sql.append(" and " + strS4);
      }
      else {
        String strD = "";
        try {
          strD = getCustomerDFilter(cuid, ctx);
        } catch (Exception e) {
          logger.error(e.getMessage());
        }
        sql.append(" and csspgroup.FParentId = '").append(parentId).append("'");
        if ((strS4 != null) && (!(strS4.equals("")))) {
          sql.append(" and " + strS4);
        }
        sql.append(" union ");
        sql.append(" select a.fid as id,a.FName_").append(localeFix).append(" as name,a.FNumber as number1, 1 as isLeaf,1 as customerType ,null as longnumber1 from T_BD_Customer a ").append(" inner join T_BD_CustomerGroupDetail b on a.FID = b.FCustomerID ");

        if ((saleOrgInfo != null) && (saleOrgInfo.isIsBizUnit())) {
          sql.append(" inner join T_BD_CustomerSaleInfo customersale on customersale.fcustomerid = a.fid ");
        }
        sql.append(" inner join T_ORG_CtrlUnit adminCU on adminCU.fid = a.FAdminCUId").append(" where b.FCustomerGroupStandardID = '").append(groupStandardId).append("'").append(" and b.FCustomerGroupID = '").append(parentId).append("' ");

        if ((saleorgId != null) && (saleOrgInfo.isIsBizUnit())) {
          sql.append(" and customersale.FSaleOrgID = '").append(saleorgId).append("' ");
        }
        if ((strD != null) && (!(strD.equals("")))) {
          sql.append(" and " + strD);
        }
      }
    }

    IRowSet rs = null;
    ArrayList result = new ArrayList();
    try {
      rs = DbUtil.executeQuery(ctx, sql.toString());

      PriceCompositionInfo info = null;

      while (rs.next()) {
        info = new PriceCompositionInfo();
        info.setId(rs.getString("id"));

        String tmp = rs.getString("isLeaf");
        if ("1".equals(tmp))
          info.setIsLeaf(true);
        else {
          info.setIsLeaf(false);
        }

        tmp = rs.getString("customerType");

        if ("1".equals(tmp)) {
          info.setCompType(PriceCompDetailEnum.CUSTOMER);
          info.setIsCustomerGroup(false);
        }
        else {
          info.setCompType(PriceCompDetailEnum.CUSTOMERGROUP);
          info.setIsCustomerGroup(true);
          info.setGroupLongnumber(rs.getString("longnumber1"));
        }

        info.setName(rs.getString("name"));
        info.setNumber(rs.getString("number1"));

        result.add(info);
      }
    }
    catch (Exception e) {
      logger.error(e);
    } finally {
      SQLUtils.cleanup(rs);
    }
    return result;
  }

  private String getCustomerDFilter(String cuid, Context ctx) throws Exception {
    ICustomer iCustomer = CustomerFactory.getLocalInstance(ctx);
    ObjectUuidPK pk = null;
    pk = new ObjectUuidPK(cuid);
    FilterInfo filterInfoD = null;
    StringBuffer buffD = new StringBuffer();
    String strD = "";
    filterInfoD = iCustomer.getDatabaseDFilter(pk, "a.FID", "a.FAdminCUID");
    if (filterInfoD != null) {
      filterInfoD.output(buffD);
    }
    strD = buffD.toString();

    return strD;
  }

  private String getMaterialDFilter(String cuid, Context ctx) throws Exception {
    IMaterial iMaterial = MaterialFactory.getLocalInstance(ctx);
    ObjectUuidPK pk = null;
    pk = new ObjectUuidPK(cuid);
    FilterInfo filterInfoD = null;
    StringBuffer buffD = new StringBuffer();
    String strD = "";
    filterInfoD = iMaterial.getDatabaseDFilter(pk, "a.FID", "a.FAdminCUID");
    if (filterInfoD != null) {
      filterInfoD.output(buffD);
    }
    strD = buffD.toString();

    return strD;
  }

  protected ArrayList _getMaterialCollection(Context ctx, HashMap params) throws BOSException, EASBizException {
    StringBuffer sql = new StringBuffer();
    String parentId = null;
    if (params.get("materialparentId") != null) {
      parentId = params.get("materialparentId").toString();
    }
    boolean isMaterialGroup = Boolean.valueOf(params.get("isMaterialGroup").toString()).booleanValue();
    String saleOrgId = null;
    if (params.get("saleorgid") != null) {
      saleOrgId = params.get("saleorgid").toString();
    }
    String saleorgId = null;
    String strS4 = "";
    String cuid = null;
    SaleOrgUnitInfo saleOrgInfo = null;
    if (params.get("saleorgid") != null) {
      saleorgId = params.get("saleorgid").toString();
      SelectorItemCollection sic = new SelectorItemCollection();
      sic.add(new SelectorItemInfo("id"));
      sic.add(new SelectorItemInfo("cu.*"));
      saleOrgInfo = SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(new ObjectStringPK(saleorgId), sic);

      FilterInfo filterInfoCU = EntityControlTypeUtil.getFilterInfoForControlTypeS4(saleOrgInfo.getCU().getId().toString(), saleOrgInfo.getCU().getLongNumber());

      StringBuffer buffS4 = new StringBuffer();
      filterInfoCU.output(buffS4);
      strS4 = formatInputStrWithEntityProperty(ctx, buffS4.toString(), "C79FC042", "CU.");
      cuid = saleOrgInfo.getCU().getId().toString();
    }

    PriceCompDetailEnum compType = PriceCompDetailEnum.CUSTOMER;
    if (cuid != null) {
      cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
    }
    String localeFix = ctx.getLocale().toString();
    if (isMaterialGroup) {
      sql.append("select materialgroup.fid as id ,materialgroup.FName_").append(localeFix).append(" as name,materialgroup.FNumber as number1,materialgroup.FIsLeaf as isLeaf,0 as materialType ").append(" from T_BD_MaterialGroup materialgroup ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = materialgroup.FControlUnitID ").append(" where materialgroup.FDeletedStatus =1 ");

      if (parentId == null)
        sql.append(" and materialgroup.FParentId is null ");
      else {
        sql.append(" and materialgroup.FParentId = '").append(parentId).append("'");
      }
      if ((strS4 != null) && (!(strS4.equals("")))) {
        sql.append(" and " + strS4);
      }
      compType = PriceCompDetailEnum.MATERIALGROUP;
    } else {
      sql.append("select materialgroup.fid as id ,materialgroup.FName_").append(localeFix).append(" as name,materialgroup.FNumber as number1,materialgroup.FIsLeaf as isLeaf,0 as materialType ").append("  from T_BD_MaterialGroup materialgroup ").append(" inner join T_ORG_CtrlUnit CU on CU.fid = materialgroup.FControlUnitID ").append(" where materialgroup.FDeletedStatus = 1 ");

      if (parentId == null) {
        sql.append(" and materialgroup.FParentId is null ");
        if ((strS4 != null) && (!(strS4.equals("")))) {
          sql.append(" and " + strS4);
        }

      }
      else
      {
        String strD = "";
        try {
          strD = getMaterialDFilter(cuid, ctx);
        } catch (Exception e) {
          logger.error(e.getMessage());
        }
        sql.append(" and materialgroup.FParentId = '").append(parentId).append("'");
        if ((strS4 != null) && (!(strS4.equals("")))) {
          sql.append(" and " + strS4);
        }
        sql.append(" union ");
        sql.append("select a.fid as id ,a.FName_").append(localeFix).append(" as name,a.FNumber as number1,1 as isLeaf,1 as materialType from T_BD_Material a ").append(" inner join T_BD_MaterialGroup b on b.fid = a.FMaterialGroupID ").append(" inner join T_ORG_CtrlUnit adminCU on adminCU.fid = a.FAdminCUId");

        if ((saleOrgInfo != null) && (saleOrgInfo.isIsBizUnit())) {
          sql.append(" inner join T_BD_MaterialSales msale on msale.FMaterialID = a.fid ");
        }
        sql.append(" where b.fid = '").append(parentId).append("'");
        if ((saleorgId != null) && (saleOrgInfo.isIsBizUnit())) {
          sql.append(" and msale.FOrgUnit = '").append(saleorgId).append("' ");
        }
        if ((strD != null) && (!(strD.equals("")))) {
          sql.append(" and " + strD);
        }
      }
      compType = PriceCompDetailEnum.MATERIAL;
    }

    IRowSet rs = null;
    ArrayList result = new ArrayList();
    try
    {
      rs = DbUtil.executeQuery(ctx, sql.toString());

      PriceCompositionInfo info = null;

      while (rs.next())
      {
        info = new PriceCompositionInfo();
        info.setId(rs.getString("id"));

        String tmp = rs.getString("isLeaf");
        if ("1".equals(tmp))
        {
          info.setIsLeaf(true);
        }
        else {
          info.setIsLeaf(false);
        }

        tmp = rs.getString("materialType");
        if ("1".equals(tmp))
        {
          info.setCompType(PriceCompDetailEnum.MATERIAL);
          info.setIsCustomerGroup(false);
        }
        else {
          info.setCompType(PriceCompDetailEnum.MATERIALGROUP);
          info.setIsCustomerGroup(true);
        }

        info.setName(rs.getString("name"));
        info.setNumber(rs.getString("number1"));

        result.add(info);
      }
    }
    catch (Exception e)
    {
      logger.error(e);
    }
    finally {
      SQLUtils.cleanup(rs);
    }
    return result;
  }
//
//  protected Map _batchGetPricePolicyWithCM(Context ctx, PriceCondition[] priceConditions, String[] pricePolicyIds)
//    throws BOSException, EASBizException
//  {
//    Map result = new HashMap();
//    int length = pricePolicyIds.length;
//    String[] customerIds = new String[length];
//    String[] materialIds = new String[length];
//    for (int i = 0; i < length; ++i) {
//      if ((priceConditions[i] == null) || (priceConditions[i].getCustomerInfo() == null) || (priceConditions[i].getMaterialInfo() == null) || (pricePolicyIds[i] == null))
//        continue;
//      customerIds[i] = priceConditions[i].getCustomerInfo().getId().toString();
//      materialIds[i] = priceConditions[i].getMaterialInfo().getId().toString();
//    }
//
//    SelectorItemCollection sicCustomer = new SelectorItemCollection();
//    sicCustomer.add(new SelectorItemInfo("*"));
//    sicCustomer.add(new SelectorItemInfo("browseGroup.*"));
//    SelectorItemCollection sicMaterial = new SelectorItemCollection();
//    sicMaterial.add(new SelectorItemInfo("*"));
//    sicMaterial.add(new SelectorItemInfo("materialGroup.*"));
//    Map mapCustomer = DataLoaderHelper.loadCustomer(ctx, customerIds, sicCustomer);
//    Map mapMaterial = DataLoaderHelper.loadMaterial(ctx, materialIds, sicMaterial);
//    
//    
//    Map mapPP = DataLoaderHelper.loadPricePolicy(ctx, pricePolicyIds,getPriceSelectorItemCol());
//    
//    
//    String[] arrayCustomer = null;
//    String[] arrayMaterial = null;
//    DiscountSetInfo ppInfo = null;
//
//    for (int i = 0; i < length; ++i) {
//      if ((priceConditions[i] == null) || (pricePolicyIds[i] == null)) continue; if (mapPP.get(pricePolicyIds[i]) == null) {
//        continue;
//      }
//      ppInfo = (DiscountSetInfo)mapPP.get(pricePolicyIds[i]);
//      DiscountSetEntryCollection entryCol = ppInfo.getEntries();
//      String customerId = priceConditions[i].getCustomerInfo().getId().toString();
//      String materialId = priceConditions[i].getMaterialInfo().getId().toString();
//      PriceCompositionEnum pcEnum = ppInfo.getPriceComposition();
//      int m = 0; for (int n = entryCol.size(); m < n; ++m) {
//        if ((pcEnum.equals(PriceCompositionEnum.CM)) || (pcEnum.equals(PriceCompositionEnum.MC))) {
//          if (hasPriceByCondition(priceConditions[i], entryCol.get(m), null, null))
//            result.put(customerId + materialId, entryCol.get(m));
//        }
//        else if ((pcEnum.equals(PriceCompositionEnum.CMG)) || (pcEnum.equals(PriceCompositionEnum.MGC))) {
//          MaterialInfo materInfo = (MaterialInfo)mapMaterial.get(materialId);
//          arrayMaterial = materInfo.getMaterialGroup().getLongNumber().split("!");
//          for (int a = arrayMaterial.length - 1; a >= 0; --a) {
//            if (hasPriceByCondition(priceConditions[i], entryCol.get(m), null, arrayMaterial[a]))
//              result.put(customerId + materialId, entryCol.get(m));
//          }
//        }
//        else if ((pcEnum.equals(PriceCompositionEnum.CGM)) || (pcEnum.equals(PriceCompositionEnum.MCG))) {
//          CustomerInfo customerInfo = (CustomerInfo)mapCustomer.get(customerId);
//          arrayCustomer = customerInfo.getBrowseGroup().getLongNumber().split("!");
//          for (int a = arrayCustomer.length - 1; a >= 0; --a) {
//            if (hasPriceByCondition(priceConditions[i], entryCol.get(m), arrayCustomer[a], null))
//              result.put(customerId + materialId, entryCol.get(m));
//          }
//        }
//        else if ((pcEnum.equals(PriceCompositionEnum.CGMG)) || (pcEnum.equals(PriceCompositionEnum.MGCG))) {
//          CustomerInfo customerInfo = (CustomerInfo)mapCustomer.get(customerId);
//          MaterialInfo materInfo = (MaterialInfo)mapMaterial.get(materialId);
//          arrayMaterial = materInfo.getMaterialGroup().getLongNumber().split("!");
//          arrayCustomer = customerInfo.getBrowseGroup().getLongNumber().split("!");
//          for (int a = arrayCustomer.length - 1; a >= 0; --a) {
//            for (int b = arrayMaterial.length - 1; b >= 0; --b) {
//              if (hasPriceByCondition(priceConditions[i], entryCol.get(m), arrayCustomer[a], arrayMaterial[b])) {
//                result.put(customerId + materialId, entryCol.get(m));
//              }
//            }
//          }
//        }
//      }
//    }
//    return result;
//  }
  private SelectorItemCollection getPriceSelectorItemCol() {
	  /* 2003 */     SelectorItemCollection sic = new SelectorItemCollection();
	  /* 2004 */     sic.add(new SelectorItemInfo("id"));
	  /* 2005 */     sic.add(new SelectorItemInfo("name"));
	  /* 2006 */     sic.add(new SelectorItemInfo("number"));
	  /* 2007 */     sic.add(new SelectorItemInfo("priority"));
	  /* 2008 */     sic.add(new SelectorItemInfo("effectiveDate"));
	  /* 2009 */     sic.add(new SelectorItemInfo("expireDate"));
	  /* 2010 */     sic.add(new SelectorItemInfo("checkedStatus"));
	  /* 2011 */     sic.add(new SelectorItemInfo("blockedStatus"));
	  /* 2012 */     sic.add(new SelectorItemInfo("groupStandardCustomer.id"));
	  /* 2013 */     sic.add(new SelectorItemInfo("priceCompDetailCustomer"));
	  /* 2014 */     sic.add(new SelectorItemInfo("priceCompDetailMaterial"));
	  /* 2015 */     sic.add(new SelectorItemInfo("priceComposition"));
	  /* 2016 */     sic.add(new SelectorItemInfo("saleOrgUnit.id"));
	  /* 2017 */     sic.add(new SelectorItemInfo("saleOrgUnit.name"));
	  /* 2018 */     sic.add(new SelectorItemInfo("saleOrgUnit.number"));
	  /* 2019 */     sic.add(new SelectorItemInfo("entries.id"));
	  /* 2020 */     sic.add(new SelectorItemInfo("entries.price"));
	  /* 2021 */     sic.add(new SelectorItemInfo("entries.discount"));
	  /* 2022 */     sic.add(new SelectorItemInfo("entries.effectiveDate"));
	  /* 2023 */     sic.add(new SelectorItemInfo("entries.expireDate"));
	  /* 2024 */     sic.add(new SelectorItemInfo("entries.asistProperty"));
	  /* 2025 */     sic.add(new SelectorItemInfo("entries.asistProperty.name"));
	  /* 2026 */     sic.add(new SelectorItemInfo("entries.asistProperty.number"));
	  /* 2027 */     sic.add(new SelectorItemInfo("entries.qtyMin"));
	  /* 2028 */     sic.add(new SelectorItemInfo("entries.qtyMax"));
	  /* 2029 */     sic.add(new SelectorItemInfo("entries.amtMin"));
	  /* 2030 */     sic.add(new SelectorItemInfo("entries.amtMax"));
	  /* 2031 */     sic.add(new SelectorItemInfo("entries.priceMin"));
	  /* 2032 */     sic.add(new SelectorItemInfo("entries.priceMax"));
	  /* 2033 */     sic.add(new SelectorItemInfo("entries.remark"));
	  /* 2034 */     sic.add(new SelectorItemInfo("entries.saleLeadTime"));
	  /* 2035 */     sic.add(new SelectorItemInfo("entries.checkedStatus"));
	  /* 2036 */     sic.add(new SelectorItemInfo("entries.discountCondition"));
	  /* 2037 */     sic.add(new SelectorItemInfo("entries.discountMode"));
	  /* 2038 */     sic.add(new SelectorItemInfo("entries.basicUnit"));
	  /* 2039 */     sic.add(new SelectorItemInfo("entries.priceSource"));
	  /* 2040 */     sic.add(new SelectorItemInfo("entries.currency.id"));
	  /* 2041 */     sic.add(new SelectorItemInfo("entries.customerGroupStandardNumber"));
	  /* 2042 */     sic.add(new SelectorItemInfo("entries.currency.number"));
	  /* 2043 */     sic.add(new SelectorItemInfo("entries.currency.name"));
	  /* 2044 */     sic.add(new SelectorItemInfo("entries.customerGroup.id"));
	  /* 2045 */     sic.add(new SelectorItemInfo("entries.customerGroup.number"));
	  /* 2046 */     sic.add(new SelectorItemInfo("entries.customerGroup.name"));
	  /* 2047 */     sic.add(new SelectorItemInfo("entries.customerGroup.longNumber"));
	  /* 2048 */     sic.add(new SelectorItemInfo("entries.customer.id"));
	  /* 2049 */     sic.add(new SelectorItemInfo("entries.customer.number"));
	  /* 2050 */     sic.add(new SelectorItemInfo("entries.customer.name"));
	  /* 2051 */     sic.add(new SelectorItemInfo("entries.customer.customerGroupDetails.*"));
	  /* 2052 */     sic.add(new SelectorItemInfo("entries.materialGroup.id"));
	  /* 2053 */     sic.add(new SelectorItemInfo("entries.materialGroup.number"));
	  /* 2054 */     sic.add(new SelectorItemInfo("entries.materialGroup.name"));
	  /* 2055 */     sic.add(new SelectorItemInfo("entries.materialGroup.longNumber"));
	  /* 2056 */     sic.add(new SelectorItemInfo("entries.material.id"));
	  /* 2057 */     sic.add(new SelectorItemInfo("entries.material.number"));
	  /* 2058 */     sic.add(new SelectorItemInfo("entries.material.name"));
	  /* 2059 */     sic.add(new SelectorItemInfo("entries.material.model"));
	  /* 2060 */     sic.add(new SelectorItemInfo("entries.material.pricePrecision"));
	  /* 2061 */     sic.add(new SelectorItemInfo("entries.material.baseUnit"));
	  /* 2062 */     sic.add(new SelectorItemInfo("entries.material.assistAttr"));
	  /* 2063 */     sic.add(new SelectorItemInfo("entries.material.materialGroup"));
	  /* 2064 */     sic.add(new SelectorItemInfo("entries.material.baseUnit.id"));
	  /* 2065 */     sic.add(new SelectorItemInfo("entries.material.baseUnit.name"));
	  /* 2066 */     sic.add(new SelectorItemInfo("entries.material.baseUnit.number"));
	  /* 2067 */     sic.add(new SelectorItemInfo("entries.priceType.id"));
	  /* 2068 */     sic.add(new SelectorItemInfo("entries.priceType.name"));
	  /* 2069 */     sic.add(new SelectorItemInfo("entries.priceType.number"));
	  /* 2070 */     sic.add(new SelectorItemInfo("entries.measureUnit.id"));
	  /* 2071 */     sic.add(new SelectorItemInfo("entries.measureUnit.number"));
	  /* 2072 */     sic.add(new SelectorItemInfo("entries.measureUnit.name"));
	  /* 2073 */     return sic;
	  /*      */   }
	  /*      */ 
  protected Map _getPricePolicyWithCM(Context ctx, PriceCondition[] priceCondition, String pricepolicyid)
    throws BOSException, EASBizException
  {
    Map result = new HashMap();
    IDiscountSetEntry ientry = DiscountSetEntryFactory.getLocalInstance(ctx);
    EntityViewInfo viewentry = new EntityViewInfo();
    FilterInfo tmpfilter = new FilterInfo();
    tmpfilter.getFilterItems().add(new FilterItemInfo("parent.id", pricepolicyid, CompareType.EQUALS));
    viewentry.setFilter(tmpfilter);
    DiscountSetEntryCollection entrycollection = ientry.getDiscountSetEntryCollection(viewentry);
    DiscountSetInfo info = DiscountSetFactory.getLocalInstance(ctx).getDiscountSetInfo(new ObjectStringPK(pricepolicyid));
    ICustomer iCustomer = CustomerFactory.getLocalInstance(ctx);
    IMaterial iMaterial = MaterialFactory.getLocalInstance(ctx);
    SelectorItemCollection sicCustomer = new SelectorItemCollection();
    sicCustomer.add(new SelectorItemInfo("*"));
    sicCustomer.add(new SelectorItemInfo("browseGroup.*"));
    SelectorItemCollection sicMaterial = new SelectorItemCollection();
    sicMaterial.add(new SelectorItemInfo("*"));
    sicMaterial.add(new SelectorItemInfo("materialGroup.*"));
    String[] arrayCustomer = null;
    String[] arrayMaterial = null;
    int i = 0; for (int c = priceCondition.length; i < c; ++i) {
      int m = 0; for (int n = entrycollection.size(); m < n; ++m) {
        if ((info.getPriceComposition().equals(PriceCompositionEnum.CM)) || (info.getPriceComposition().equals(PriceCompositionEnum.MC)))
        {
          if (hasPriceByCondition(priceCondition[i], entrycollection.get(m), null, null)) {
            result.put(priceCondition[i].getCustomerInfo().getId().toString() + priceCondition[i].getMaterialInfo().getId().toString(), entrycollection.get(m));
          }

        }
        else if ((info.getPriceComposition().equals(PriceCompositionEnum.CMG)) || (info.getPriceComposition().equals(PriceCompositionEnum.MGC)))
        {
          MaterialInfo materInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(priceCondition[i].getMaterialInfo().getId()), sicMaterial);
          arrayMaterial = materInfo.getMaterialGroup().getLongNumber().split("!");
          for (int a = arrayMaterial.length - 1; a >= 0; --a) {
            if (hasPriceByCondition(priceCondition[i], entrycollection.get(m), null, arrayMaterial[a])) {
              result.put(priceCondition[i].getCustomerInfo().getId().toString() + priceCondition[i].getMaterialInfo().getId().toString(), entrycollection.get(m));
            }
          }
        }
        else if ((info.getPriceComposition().equals(PriceCompositionEnum.CGM)) || (info.getPriceComposition().equals(PriceCompositionEnum.MCG)))
        {
          CustomerInfo customerInfo = iCustomer.getCustomerInfo(new ObjectUuidPK(priceCondition[i].getCustomerInfo().getId()), sicCustomer);
          arrayCustomer = customerInfo.getBrowseGroup().getLongNumber().split("!");
          for (int a = arrayCustomer.length - 1; a >= 0; --a)
            if (hasPriceByCondition(priceCondition[i], entrycollection.get(m), arrayCustomer[a], null))
              result.put(priceCondition[i].getCustomerInfo().getId().toString() + priceCondition[i].getMaterialInfo().getId().toString(), entrycollection.get(m));
        }
        else
        {
          if ((!(info.getPriceComposition().equals(PriceCompositionEnum.CGMG))) && (!(info.getPriceComposition().equals(PriceCompositionEnum.MGCG))))
            continue;
          CustomerInfo customerInfo = iCustomer.getCustomerInfo(new ObjectUuidPK(priceCondition[i].getCustomerInfo().getId()), sicCustomer);
          MaterialInfo materInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(priceCondition[i].getMaterialInfo().getId()), sicMaterial);
          arrayMaterial = materInfo.getMaterialGroup().getLongNumber().split("!");
          arrayCustomer = customerInfo.getBrowseGroup().getLongNumber().split("!");
          for (int a = arrayCustomer.length - 1; a >= 0; --a) {
            for (int b = arrayMaterial.length - 1; b >= 0; --b) {
              if (hasPriceByCondition(priceCondition[i], entrycollection.get(m), arrayCustomer[a], arrayMaterial[b])) {
                result.put(priceCondition[i].getCustomerInfo().getId().toString() + priceCondition[i].getMaterialInfo().getId().toString(), entrycollection.get(m));
              }
            }
          }
        }
      }
    }

    return result;
  }

  private boolean hasPriceByCondition(PriceCondition condition, DiscountSetEntryInfo infoE, String customergroupnum, String materialgroupnum)
  {
	  return false;
//    return (((customergroupnum == null) && (infoE.getCustomer().getId().equals(condition.getCustomerInfo().getId()))) || ((customergroupnum != null) && (customergroupnum.equals(infoE.getCustomerGroup().getNumber())) && ((((materialgroupnum == null) && (infoE.getMaterial().getId().equals(condition.getMaterialInfo().getId()))) || ((materialgroupnum != null) && (materialgroupnum.equals(infoE.getMaterialGroup().getNumber())) && ((((infoE.getMeasureUnit() != null) && (infoE.getMeasureUnit().getId().toString().equals(condition.getMeasureUnit()))) || ((infoE.getMeasureUnit().isIsBaseUnit()) && ((((condition.getCurDate() != null) && (infoE.getEffectiveDate() != null) && (infoE.getEffectiveDate().after(condition.getCurDate())) && (infoE.getExpireDate().before(condition.getCurDate()))) || ((condition.getCurDate() == null) && ((((condition.getOrderQty() != null) && (infoE.getQtyMax() != null) && (infoE.getQtyMax().compareTo(condition.getOrderQty()) == 1) && (infoE.getQtyMin() != null) && (infoE.getQtyMin().compareTo(condition.getOrderQty()) == -1)) || ((condition.getOrderQty() != null) && (infoE.getQtyMin() == null) && (infoE.getQtyMax() == null) && ((((condition.getPriceTypeID() != null) && (infoE.getPriceType() != null) && (condition.getPriceTypeID().equals(infoE.getPriceType().getId().toString()))) || (condition.getPriceTypeID() == null)))))))))))))))));
  }

  protected IObjectCollection _getPriceEntrys(Context ctx, PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params)
    throws BOSException, EASBizException
  {
    DiscountSetEntryCollection collection = null;
    ICSSPGroup icsspgroup = CSSPGroupFactory.getLocalInstance(ctx);
    IMaterialGroup imaterialgroup = MaterialGroupFactory.getLocalInstance(ctx);
    IDiscountSetEntry ipriceentry = DiscountSetEntryFactory.getLocalInstance(ctx);
    String databaseid = null;
    boolean isIncluded = ((Boolean)params.get("isincluded")).booleanValue();
    String csspgroupstandardid = params.get("customergroupStandardId").toString();
    EntityViewInfo view = new EntityViewInfo();
    if (isIncluded) {
      databaseid = priceCompositionInfo.getId();
      if (PriceCompDetailEnum.CUSTOMER.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        boolean isgroup = priceCompositionInfo.isCustomerGroup();
        if (params.get("saleorgid") instanceof SaleOrgUnitInfo) {
          if (isgroup)
          {
            String customerids = getCustomerIds(ctx, databaseid, csspgroupstandardid, (SaleOrgUnitInfo)params.get("saleorgid"));
            if (!(customerids.equals("")))
              tmpFilter.getFilterItems().add(new FilterItemInfo("customer.id", customerids, CompareType.INNER));
            else
              tmpFilter.getFilterItems().add(new FilterItemInfo("id", null, CompareType.EQUALS));
          }
          else
          {
            tmpFilter.getFilterItems().add(new FilterItemInfo("customer.id", databaseid, CompareType.EQUALS));
          }
          view.setFilter(tmpFilter);
        }
      } else if (PriceCompDetailEnum.CUSTOMERGROUP.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        if (databaseid != null) {
          CSSPGroupInfo groupInfo = icsspgroup.getCSSPGroupInfo(new ObjectStringPK(databaseid));
          tmpFilter.getFilterItems().add(new FilterItemInfo("customerGroup.longnumber", groupInfo.getLongNumber() + "%", CompareType.LIKE));
        } else {
          tmpFilter.getFilterItems().add(new FilterItemInfo("customerGroup.longnumber", "%", CompareType.LIKE));
        }
        view.setFilter(tmpFilter);
      } else if (PriceCompDetailEnum.MATERIAL.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        boolean isgroup = priceCompositionInfo.isCustomerGroup();
        if (params.get("saleorgid") instanceof SaleOrgUnitInfo) {
          if (isgroup)
          {
            String materialids = getMaterialIds(ctx, databaseid, null, (SaleOrgUnitInfo)params.get("saleorgid"));
            if (!(materialids.equals("")))
              tmpFilter.getFilterItems().add(new FilterItemInfo("material.id", materialids, CompareType.INNER));
            else
              tmpFilter.getFilterItems().add(new FilterItemInfo("id", null, CompareType.EQUALS));
          }
          else {
            tmpFilter.getFilterItems().add(new FilterItemInfo("material.id", databaseid, CompareType.EQUALS));
          }
          view.setFilter(tmpFilter);
        }
      } else if (PriceCompDetailEnum.MATERIALGROUP.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        if (databaseid != null) {
          MaterialGroupInfo groupInfo = imaterialgroup.getMaterialGroupInfo(new ObjectStringPK(databaseid));
          tmpFilter.getFilterItems().add(new FilterItemInfo("materialGroup.longnumber", groupInfo.getLongNumber() + "%", CompareType.LIKE));
        } else {
          tmpFilter.getFilterItems().add(new FilterItemInfo("materialGroup.longnumber", "%", CompareType.LIKE));
        }
        view.setFilter(tmpFilter);
      }
    } else {
      databaseid = priceCompositionInfo.getId();
      if (PriceCompDetailEnum.CUSTOMER.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        tmpFilter.getFilterItems().add(new FilterItemInfo("customer.id", databaseid, CompareType.EQUALS));
        view.setFilter(tmpFilter);
      } else if (PriceCompDetailEnum.CUSTOMERGROUP.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        tmpFilter.getFilterItems().add(new FilterItemInfo("customerGroup.id", databaseid, CompareType.EQUALS));
        tmpFilter.getFilterItems().add(new FilterItemInfo("customerGroupStandard.id", csspgroupstandardid, CompareType.EQUALS));
        view.setFilter(tmpFilter);
      } else if (PriceCompDetailEnum.MATERIAL.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        tmpFilter.getFilterItems().add(new FilterItemInfo("material.id", databaseid, CompareType.EQUALS));
        view.setFilter(tmpFilter);
      } else if (PriceCompDetailEnum.MATERIALGROUP.equals(priceCompDetail)) {
        FilterInfo tmpFilter = new FilterInfo();
        tmpFilter.getFilterItems().add(new FilterItemInfo("materialGroup.id", databaseid, CompareType.EQUALS));
        view.setFilter(tmpFilter);
      }
    }
    String pricepolicyid = null;
    if (params.get("pricepolicyid") != null) {
      pricepolicyid = params.get("pricepolicyid").toString();
    }
    view.getFilter().getFilterItems().add(new FilterItemInfo("parent.priceCompDetailCustomer", new Integer(priceCompDetail.getValue()), CompareType.EQUALS));
    view.getFilter().getFilterItems().add(new FilterItemInfo("parent.id", pricepolicyid, CompareType.EQUALS));

    if (params.get("customerId") != null) {
        String customerID = params.get("customerId").toString();
        view.getFilter().getFilterItems().add(new FilterItemInfo("customer.id", customerID, CompareType.EQUALS));
      }
    if (params.get("pricepolicy_customercomp") instanceof PriceCompDetailEnum) {
      PriceCompDetailEnum detailEnumInfo = (PriceCompDetailEnum)params.get("pricepolicy_customercomp");
      SorterItemInfo sort = getSortItemInfo(detailEnumInfo);
      if (sort != null) view.getSorter().add(sort);
    }
    if (params.get("pricepolicy_materialcomp") instanceof PriceCompDetailEnum) {
      PriceCompDetailEnum detailEnumInfo = (PriceCompDetailEnum)params.get("pricepolicy_materialcomp");
      SorterItemInfo sort = getSortItemInfo(detailEnumInfo);
      if (sort != null) view.getSorter().add(sort);
    }
    collection = getDiscountSetEntryCollection(ipriceentry, view);
    return collection;
  }

  private SorterItemInfo getSortItemInfo(PriceCompDetailEnum detailEnumInfo) {
    SorterItemInfo sort = null;
    switch (detailEnumInfo.getValue())
    {
    case 1:
      sort = new SorterItemInfo("customer.number");
      sort.setSortType(SortType.ASCEND);
      break;
    case 2:
      sort = new SorterItemInfo("customerGroup.number");
      sort.setSortType(SortType.ASCEND);
      break;
    case 4:
      sort = new SorterItemInfo("materialGroup.number");
      sort.setSortType(SortType.ASCEND);
      break;
    case 3:
      sort = new SorterItemInfo("material.number");
      sort.setSortType(SortType.ASCEND);
    }

    return sort;
  }

  private String getCustomerIds(Context ctx, String groupid, String csspgroupstandardid, SaleOrgUnitInfo saleOrgInfo)
    throws BOSException, EASBizException
  {
    StringBuffer sql = new StringBuffer();
    sql.append(" select a.fid as id from T_BD_Customer a ").append(" inner join T_BD_CustomerGroupDetail b on a.FID = b.FCustomerID ").append(" inner join T_BD_CSSPGroup csspgroup on csspgroup.FID = b.FCustomerGroupID ").append(" inner join T_ORG_CtrlUnit adminCU on adminCU.fid = a.FAdminCUId");

    if ((saleOrgInfo != null) && (saleOrgInfo.isIsBizUnit())) {
      sql.append(" inner join T_BD_CustomerSaleInfo customersale on customersale.fcustomerid = a.fid ");
    }
    sql.append(" where b.FCustomerGroupStandardID = '").append(csspgroupstandardid).append("'");
    if (groupid != null) {
      ICSSPGroup icsspgroup = CSSPGroupFactory.getLocalInstance(ctx);
      CSSPGroupInfo groupinfo = icsspgroup.getCSSPGroupInfo(new ObjectStringPK(groupid));
      sql.append(" and (csspgroup.FLongNumber like '").append(groupinfo.getLongNumber() + "!%'").append(" or csspgroup.FNumber ='").append(groupinfo.getNumber() + "') ");
    }
    else {
      sql.append(" and csspgroup.FLongNumber like '%'");
    }
    if (saleOrgInfo.isIsBizUnit()) {
      sql.append(" and customersale.FSaleOrgID = '").append(saleOrgInfo.getId().toString()).append("' ");
    }
    String strD = "";
    try {
      strD = getCustomerDFilter(saleOrgInfo.getCU().getId().toString(), ctx);
    } catch (Exception e) {
      throw new BOSException(e);
    }
    if ((strD != null) && (!(strD.equals("")))) {
      sql.append(" and " + strD);
    }
    IRowSet rs = null;
    StringBuffer strBuffer = new StringBuffer();
    try {
      rs = DbUtil.executeQuery(ctx, sql.toString());
      while (rs.next()) {
        if (strBuffer.length() > 0) {
          strBuffer.append(",");
        }
        strBuffer.append("'");
        strBuffer.append(rs.getString("id"));
        strBuffer.append("'");
      }
    } catch (Exception e) {
    }
    finally {
      SQLUtils.cleanup(rs);
    }
    return strBuffer.toString();
  }

  private String getMaterialIds(Context ctx, String groupid, String groupstandardid, SaleOrgUnitInfo saleOrgInfo)
    throws BOSException, EASBizException
  {
    StringBuffer sql = new StringBuffer();
    sql.append("select a.fid as id  from T_BD_Material a ").append(" inner join T_BD_MaterialGroup b on b.fid = a.FMaterialGroupID ").append(" inner join T_ORG_CtrlUnit adminCU on adminCU.fid = a.FAdminCUId");

    if ((saleOrgInfo != null) && (saleOrgInfo.isIsBizUnit())) {
      sql.append(" inner join T_BD_MaterialSales msale on msale.FMaterialID = a.fid ");
    }
    sql.append(" WHERE ");
    if (groupid != null) {
      IMaterialGroup icsspgroup = MaterialGroupFactory.getLocalInstance(ctx);
      MaterialGroupInfo groupinfo = icsspgroup.getMaterialGroupInfo(new ObjectStringPK(groupid));
      sql.append(" (b.FLongNumber like '").append(groupinfo.getLongNumber() + "!%' ").append(" or b.FNumber = '").append(groupinfo.getNumber() + "') ");
    }
    else {
      sql.append(" b.FLongNumber like '%'");
    }
    if (saleOrgInfo.isIsBizUnit()) {
      sql.append(" and msale.FOrgUnit = '").append(saleOrgInfo.getId().toString()).append("' ");
    }
    String strD = "";
    try {
      strD = getMaterialDFilter(saleOrgInfo.getCU().getId().toString(), ctx);
    } catch (Exception e) {
      throw new BOSException(e);
    }
    if ((strD != null) && (!(strD.equals("")))) {
      sql.append(" and " + strD);
    }
    IRowSet rs = null;
    StringBuffer strBuffer = new StringBuffer();
    try {
      rs = DbUtil.executeQuery(ctx, sql.toString());
      while (rs.next()) {
        if (strBuffer.length() > 0) {
          strBuffer.append(",");
        }
        strBuffer.append("'");
        strBuffer.append(rs.getString("id"));
        strBuffer.append("'");
      }
    } catch (Exception e) {
    }
    finally {
      SQLUtils.cleanup(rs);
    }
    return strBuffer.toString();
  }

  private DiscountSetEntryCollection getDiscountSetEntryCollection(IDiscountSetEntry ipriceentry, EntityViewInfo view) throws BOSException, EASBizException
  {
    DiscountSetEntryCollection collection = null;
    view.getSelector().add(new SelectorItemInfo("*"));
    view.getSelector().add(new SelectorItemInfo("priceType.number"));
    view.getSelector().add(new SelectorItemInfo("priceType.name"));
    view.getSelector().add(new SelectorItemInfo("material.*"));
    view.getSelector().add(new SelectorItemInfo("currency.*"));
    view.getSelector().add(new SelectorItemInfo("measureUnit.number"));
    view.getSelector().add(new SelectorItemInfo("measureUnit.name"));
    view.getSelector().add(new SelectorItemInfo("customerGroup.number"));
    view.getSelector().add(new SelectorItemInfo("customerGroup.name"));
    view.getSelector().add(new SelectorItemInfo("customer.number"));
    view.getSelector().add(new SelectorItemInfo("customer.name"));
    view.getSelector().add(new SelectorItemInfo("materialGroup.number"));
    view.getSelector().add(new SelectorItemInfo("materialGroup.name"));
    view.getSelector().add(new SelectorItemInfo("asistProperty.number"));
    view.getSelector().add(new SelectorItemInfo("asistProperty.name"));
    collection = ipriceentry.getDiscountSetEntryCollection(view);
    return collection;
  }

  protected Map _getPriceParam(Context ctx, String saleorgid)
    throws BOSException, EASBizException
  {
    SaleOrgUnitInfo saleorginfo = SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(new ObjectStringPK(saleorgid));
    Map params = new HashMap();
    IParamControl ipc = ParamControlFactory.getLocalInstance(ctx);
    IPriceParam pp = PriceParamFactory.getLocalInstance(ctx);
    ICUBDControl iCUBDControl = CUBDControlFactory.getLocalInstance(ctx);
    ObjectUuidPK cuid = new ObjectUuidPK(saleorginfo.getCU().getId().toString());

    params.put("price_f7DisplayMode", Integer.valueOf(ipc.getParamValue(cuid, "F7DISPLAYMODE")));

    params.put("price_discountRatePrecision", Integer.valueOf(ipc.getParamValue(cuid, "DISCOUNTRATEPRECISION")));

    PriceParamInfo priceinfo = pp.getParameterInfo(saleorgid);
    params.put("PricePa021", Boolean.valueOf(priceinfo.getBoolValue("PricePa021")));

    CUBDControlInfo controlInfo = iCUBDControl.getBDCtrlInfo(BOSObjectType.create("6ADDC7FB").toString(), saleorginfo.getCU().getId().toString());
    params.put("price_IsSubordinateAddnewable", Boolean.valueOf((controlInfo == null) ? false : controlInfo.isIsSubordinateAddnewable()));
    return params;
  }
}
