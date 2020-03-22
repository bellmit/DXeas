package com.kingdee.eas.mm.mo.app;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSLocaleUtil;
import com.kingdee.bos.Context;
import com.kingdee.bos.SQLDataException;
import com.kingdee.bos.dao.DataLimitExceedException;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ObjectNotFoundException;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.db.TempTablePool;
import com.kingdee.bos.framework.batch.BatchExecuteParamsEntry;
import com.kingdee.bos.framework.batch.BatchExecuteResult;
import com.kingdee.bos.framework.bp.BPOption;
import com.kingdee.bos.framework.bp.DynamicBackground;
import com.kingdee.bos.framework.ejb.EJBFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.service.ServiceStateManager;
import com.kingdee.bos.sql.util.StringUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.core.util.EqualsUtil;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.base.log.app.adapter.LogControllManager;
import com.kingdee.eas.base.param.util.ParamManager;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.master.material.MaterialIssueModeEnum;
import com.kingdee.eas.basedata.master.material.MaterialPlanCollection;
import com.kingdee.eas.basedata.master.material.MaterialPlanFactory;
import com.kingdee.eas.basedata.master.material.MaterialPlanInfo;
import com.kingdee.eas.basedata.master.material.MaterialProductEnum;
import com.kingdee.eas.basedata.master.material.MaterialProvideTypeEnum;
import com.kingdee.eas.basedata.master.material.MaterialScrapRateExpressionEnum;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitCollection;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.org.AdminOrgFacadeFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IAdminOrgFacade;
import com.kingdee.eas.basedata.org.IOrgUnitRelation;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitRelationFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.IBillType;
import com.kingdee.eas.basedata.scm.common.TransactionTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.ILocation;
import com.kingdee.eas.basedata.scm.im.inv.IMaterialStorageAssign;
import com.kingdee.eas.basedata.scm.im.inv.LocationFactory;
import com.kingdee.eas.basedata.scm.im.inv.LocationInfo;
import com.kingdee.eas.basedata.scm.im.inv.LotFrame;
import com.kingdee.eas.basedata.scm.im.inv.LotRuleFactory;
import com.kingdee.eas.basedata.scm.im.inv.LotRuleInfo;
import com.kingdee.eas.basedata.scm.im.inv.MaterialStorageAssignFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.im.inv.app.LotFrameManu;
import com.kingdee.eas.basedata.scm.im.inv.app.LotRuleServerUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.dynbusiness.IBatchExecute;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ObjectBaseInfo;
import com.kingdee.eas.framework.batchaction.BatchActionEnum;
import com.kingdee.eas.framework.batchaction.BatchActionResults;
import com.kingdee.eas.mm.basedata.BOMExtend2FacadeFactory;
import com.kingdee.eas.mm.basedata.BOMExtendFacadeFactory;
import com.kingdee.eas.mm.basedata.BOMTypeEnum;
import com.kingdee.eas.mm.basedata.BomEntryCollection;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.CSEntrustTypeEnum;
import com.kingdee.eas.mm.basedata.ConsumeTypeEnum;
import com.kingdee.eas.mm.basedata.ControlStrategyInfo;
import com.kingdee.eas.mm.basedata.FactoryCalendarFactory;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.mm.basedata.IFactoryCalendar;
import com.kingdee.eas.mm.basedata.IMRWorkProcesEntry;
import com.kingdee.eas.mm.basedata.MMBasedataStatusEnum;
import com.kingdee.eas.mm.basedata.MRWorkProcesEntryFactory;
import com.kingdee.eas.mm.basedata.MRWorkProcesEntryInfo;
import com.kingdee.eas.mm.basedata.OperationFactory;
import com.kingdee.eas.mm.basedata.OperationInfo;
import com.kingdee.eas.mm.basedata.OprTimeUnitEnum;
import com.kingdee.eas.mm.basedata.OverRunMeasureEnum;
import com.kingdee.eas.mm.basedata.PBOMEntryCollection;
import com.kingdee.eas.mm.basedata.PBOMEntryInfo;
import com.kingdee.eas.mm.basedata.PBOMFactory;
import com.kingdee.eas.mm.basedata.PBOMInfo;
import com.kingdee.eas.mm.basedata.ProductTransactionTypeFactory;
import com.kingdee.eas.mm.basedata.ProductTransactionTypeInfo;
import com.kingdee.eas.mm.basedata.ScheduleTypeEnum;
import com.kingdee.eas.mm.basedata.StandardRootingFactory;
import com.kingdee.eas.mm.basedata.StandardRootingInfo;
import com.kingdee.eas.mm.basedata.TrackNumberInfo;
import com.kingdee.eas.mm.basedata.WPControlStrategyEnum;
import com.kingdee.eas.mm.basedata.WorkCenterCollection;
import com.kingdee.eas.mm.basedata.WorkCenterFactory;
import com.kingdee.eas.mm.basedata.WorkCenterInfo;
import com.kingdee.eas.mm.basedata.app.EntrustTypeEnum;
import com.kingdee.eas.mm.common.app.BillUpdater;
import com.kingdee.eas.mm.common.app.CodingRulerSrvHelper;
import com.kingdee.eas.mm.common.app.CommonUtils;
import com.kingdee.eas.mm.common.app.DBBatchUtil;
import com.kingdee.eas.mm.common.app.verify.IMMVerify;
import com.kingdee.eas.mm.common.app.verify.IMMVerifyManager;
import com.kingdee.eas.mm.common.app.verify.MMVerifyManager;
import com.kingdee.eas.mm.common.util.MMCommonUtils;
import com.kingdee.eas.mm.common.util.MMUtils;
import com.kingdee.eas.mm.common.util.ResourceUtils;
import com.kingdee.eas.mm.common.util.SQLUtil;
import com.kingdee.eas.mm.lot.LotFacadeFactory;
import com.kingdee.eas.mm.lot.LotParamValueInfo;
import com.kingdee.eas.mm.mo.IManufactureOrder;
import com.kingdee.eas.mm.mo.MOBirthTypeEnum;
import com.kingdee.eas.mm.mo.MOUtil;
import com.kingdee.eas.mm.mo.ManufactureOrderAgent;
import com.kingdee.eas.mm.mo.ManufactureOrderCollection;
import com.kingdee.eas.mm.mo.ManufactureOrderException;
import com.kingdee.eas.mm.mo.ManufactureOrderExpectOutputCollection;
import com.kingdee.eas.mm.mo.ManufactureOrderExpectOutputInfo;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.mm.mo.ManufactureOrderStockCollection;
import com.kingdee.eas.mm.mo.ManufactureOrderStockFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderStockInfo;
import com.kingdee.eas.mm.mo.ManufactureOrderSyncException;
import com.kingdee.eas.mm.mo.ManufactureOrderTechnicsCollection;
import com.kingdee.eas.mm.mo.ManufactureOrderTechnicsFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderTechnicsInfo;
import com.kingdee.eas.mm.mo.MaterialReplaceTypeEnum;
import com.kingdee.eas.mm.mo.OrderStockTransferTypeEnum;
import com.kingdee.eas.mm.mo.PickTypeEnum;
import com.kingdee.eas.mm.mo.app.util.MOAutoCloseUtil;
import com.kingdee.eas.mm.mo.app.util.MOCostObjectUtil;
import com.kingdee.eas.mm.mo.app.util.MOMultiMeasureUnitUtil;
import com.kingdee.eas.mm.mo.util.LotFrames;
import com.kingdee.eas.mm.mo.util.MOProductTransactionTypeUtil;
import com.kingdee.eas.mm.mo.util.MORootingUtil;
import com.kingdee.eas.mm.mo.util.MOStockUtil;
import com.kingdee.eas.mm.mo.util.MOUntil;
import com.kingdee.eas.mm.mo.util.NumericUtil;
import com.kingdee.eas.mm.mo.util.calculateDateUtil;
import com.kingdee.eas.mm.planning.IReqPlanReceiveReqDataFacade;
import com.kingdee.eas.mm.planning.MRPCalcFacadeFactory;
import com.kingdee.eas.mm.planning.PlannedOrderFactory;
import com.kingdee.eas.mm.planning.PlannedOrderInfo;
import com.kingdee.eas.mm.planning.PlannedOrderOutputsEntryCollection;
import com.kingdee.eas.mm.planning.PlannedOrderOutputsEntryInfo;
import com.kingdee.eas.mm.planning.PlannedOrderTypeEnum;
import com.kingdee.eas.mm.planning.ReqPlanReceiveReqDataFacadeFactory;
import com.kingdee.eas.mm.planning.app.mrp.MRPUtil;
import com.kingdee.eas.mm.project.ProjectInfo;
import com.kingdee.eas.mm.project.WBSTypeEnum;
import com.kingdee.eas.mm.project.app.WriteBackWBSFacadeControllerBean;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillParam;
import com.kingdee.eas.scm.common.SCMBillException;
import com.kingdee.eas.scm.common.SCMBillParamFactory;
import com.kingdee.eas.scm.common.SCMGroupFacadeFactory;
import com.kingdee.eas.scm.common.loadmass.SCMEntryDataVO;
import com.kingdee.eas.scm.common.service.SCMServiceFactory;
import com.kingdee.eas.scm.common.util.SCMConstant;
import com.kingdee.eas.scm.common.util.SCMUtils;
import com.kingdee.eas.scm.common.util.SortUtil;
import com.kingdee.eas.util.ResourceBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.BaseException;
import com.kingdee.util.DateTimeUtils;
import com.kingdee.util.LocaleUtils;
import com.kingdee.util.StringUtils;
import com.kingdee.util.db.SQLUtils;

public class ManufactureOrderControllerBean
  extends AbstractManufactureOrderControllerBean
  implements IBatchExecute, IMMVerify
{
  private static final long serialVersionUID = -379652924873210188L;
  private static Logger logger = Logger.getLogger("com.kingdee.eas.mm.mo.app.ManufactureOrderControllerBean");
  public static final String cr = "\r\n";
  private static final int NEW_GENERATED_INFO_TAG = -99999;
  private static final String REGEX_L = "\\{";
  private static final String REGEX_R = "\\}";
  private static final String SUBMIT_FROM_LIST_KEY = "isFromList";
  private static final int eachExecuteSize = 2000;
  
  protected IObjectValue _createNewMO(Context ctx, boolean isUseAgent, StorageOrgUnitInfo storageOrgUnitInfo)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo mo = null;
    if (isUseAgent) {
      mo = ManufactureOrderAgent.create();
    } else {
      mo = new ManufactureOrderInfo();
    }
    Calendar cal = Calendar.getInstance();
    java.util.Date curDate = cal.getTime();
    mo.setBizDate(curDate);
    mo.setCreateTime(new Timestamp(cal.getTimeInMillis()));
    IBillType iBillType = BillTypeFactory.getLocalInstance(ctx);
    BillTypeInfo billTypeInfo = iBillType.getBillTypeInfo(new ObjectUuidPK("B2aZSVXaSx6qxdfekgCmrEY+1VI="));
    mo.setBillType(billTypeInfo);
    Calendar calDate = Calendar.getInstance();
    if (storageOrgUnitInfo == null)
    {
      OrgUnitInfo[] mainOrgs = SCMServiceFactory.getLocalInstance(ctx).getAuthorizedBizOrgUnits(ctx.getCaller(), OrgType.Storage, "mm_mo_addnew");
      if ((mainOrgs != null) && (mainOrgs.length > 0))
      {
        mainOrgs = (OrgUnitInfo[])SortUtil.sortDataByNumber(mainOrgs, true);
        storageOrgUnitInfo = (StorageOrgUnitInfo)mainOrgs[0];
      }
    }
    if (storageOrgUnitInfo != null)
    {
      mo.setStorageOrgUnit(storageOrgUnitInfo);
      java.util.Date workDate = MRPCalcFacadeFactory.getLocalInstance(ctx).getNextWorkDay(storageOrgUnitInfo.getId().toString());
      
      calDate.setTime(workDate);
    }
    calDate.set(11, 0);
    calDate.set(12, 0);
    calDate.set(13, 0);
    calDate.set(14, 0);
    Timestamp ts = new Timestamp(calDate.getTimeInMillis());
    mo.setPlanBeginDate(ts);
    mo.setPlanEndDate(ts);
    return mo;
  }
  
  protected IObjectPK _submit(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo mo = (ManufactureOrderInfo)model;
    
    updateStock(mo);
    
    IBillType iBillType = BillTypeFactory.getLocalInstance(ctx);
    BillTypeInfo billTypeInfo = iBillType.getBillTypeInfo(new ObjectUuidPK("B2aZSVXaSx6qxdfekgCmrEY+1VI="));
    mo.setBillType(billTypeInfo);
    if (StringUtils.isEmpty(mo.getLot())) {
      lotNumberCheck(ctx, mo);
    }
    if (mo.getLot() != null) {
      mo.setLot(mo.getLot().trim());
    }
    IObjectPK pk = null;
    String tempTableName = null;
    TempTablePool pool = TempTablePool.getInstance(ctx);
    try
    {
      if (mo.getId() != null)
      {
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append("create table t_tmpstock(fid varchar(44),fstorageorgunitid varchar(44))");
        try
        {
          tempTableName = pool.createTempTable(sqlBuf.toString());
          StringBuffer insertSql = new StringBuffer();
          insertSql.append("insert into ").append(tempTableName).append("(fid,fstorageorgunitid)").append(" select fid,fstorageorgunitid from t_mm_mftorderstock where fparentid = ?");
          
          DbUtil.execute(ctx, insertSql.toString(), new Object[] { mo.getId().toString() });
        }
        catch (Exception e1)
        {
          throw new BOSException(e1);
        }
      }
      try
      {
        Boolean isPORelease = (Boolean)ctx.get("isPlannedOrderRelease");
        if ((isPORelease == null) || (!isPORelease.booleanValue()))
        {
          pk = super._submit(ctx, model);
        }
        else
        {
          LogControllManager.getInstance().disableLog();
          pk = super._submit(ctx, model);
          LogControllManager.getInstance().enableLog();
        }
      }
      catch (Exception exception)
      {
        Throwable throwable = exception.getCause();
        if ((throwable instanceof DataLimitExceedException)) {
          throw new ManufactureOrderException(ManufactureOrderException.NUMERIC_VALUE_OUT_OF_RANGE);
        }
        throw new BOSException(exception);
      }
      String orgUnitID = mo.getStorageOrgUnit().getId().toString();
      Boolean isPORelease;
      if (isAuditAfterSubmit(ctx, mo, orgUnitID, 4))
      {
        logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "0_ManufactureOrderControllerBean", ctx.getLocale()) + mo.getId().toString() + ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "1_ManufactureOrderControllerBean", ctx.getLocale()));
        isPORelease = (Boolean)ctx.get("isPlannedOrderRelease");
        logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "2_ManufactureOrderControllerBean", ctx.getLocale()) + isPORelease);
        if ((isPORelease == null) || (!isPORelease.booleanValue()))
        {
          try
          {
            BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
            
            entry.add(pk);
            BatchExecuteParamsEntry[] entries = { entry };
            updateReqPlanData(ctx, entries, 102, tempTableName);
          }
          catch (Exception exc)
          {
            throw new BOSException(exc);
          }
          ctx.put("isAutoAudit", new Boolean(true));
          auditAndLog(ctx, pk, mo.getBOSType(), mo.getNumber(), "mm_manufactureOrder_audit");
        }
      }
      else
      {
        logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "0_ManufactureOrderControllerBean", ctx.getLocale()) + mo.getId().toString() + ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "3_ManufactureOrderControllerBean", ctx.getLocale()));
        isPORelease = (Boolean)ctx.get("isPlannedOrderRelease");
        logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "2_ManufactureOrderControllerBean", ctx.getLocale()) + isPORelease);
        if ((isPORelease == null) || (!isPORelease.booleanValue())) {
          try
          {
            BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
            entry.add(pk);
            BatchExecuteParamsEntry[] entries = { entry };
            updateReqPlanData(ctx, entries, 102, tempTableName);
          }
          catch (Exception exc)
          {
            throw new BOSException(exc);
          }
        }
      }
      logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "4_ManufactureOrderControllerBean", ctx.getLocale()) + mo.getId().toString() + ",isAutoAudit is :" + ctx.get("isAutoAudit"));
      return pk;
    }
    finally
    {
      if (tempTableName != null) {
        pool.releaseTable(tempTableName);
      }
    }
  }
  
  protected void auditAndLog(Context ctx, IObjectPK pk, BOSObjectType bosType, String billNum, String logItemName)
    throws BOSException, EASBizException
  {
    LogControllManager.getInstance().enableLog();
    ServiceStateManager.getInstance().enableNextCallService("LOG_SERVICE");
    
    audit(ctx, pk);
  }
  
  protected boolean _checkAudit(Context ctx, IObjectValue model, boolean isOk)
    throws EASBizException, BOSException
  {
    return super._checkAudit(ctx, model, isOk);
  }
  
  protected void _delete(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
    entry.add(pk);
    BatchExecuteParamsEntry[] entries = { entry };
    try
    {
      updateReqPlanData(ctx, entries, 104, null);
      super._delete(ctx, pk);
    }
    catch (Exception exc)
    {
      exc = 
      
        exc;throw new BOSException(exc);
    }
    finally {}
  }
  
  protected void _audit(Context ctx, IObjectPK objPK)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
    entry.add(objPK);
    BatchExecuteParamsEntry[] entrys = { entry };
    
    BatchActionResults result = batchAudit(ctx, entrys);
    result.throwExceptions();
  }
  
  protected void _unAudit(Context ctx, IObjectPK objPK)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
    entry.add(objPK);
    BatchExecuteParamsEntry[] entrys = { entry };
    batchUnAudit(ctx, entrys);
  }
  
  public BatchActionResults batchDelete(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    BatchActionResults results = batchExecute(ctx, entries, BatchActionEnum.DELETE);
    
    List ids = results.getToDoIdsList();
    if (ids.size() > 0)
    {
      IReqPlanReceiveReqDataFacade reqPlanReceiveReqDataFacade = ReqPlanReceiveReqDataFacadeFactory.getLocalInstance(ctx);
      
      reqPlanReceiveReqDataFacade.receiveReqPlanDate("B2aZSVXaSx6qxdfekgCmrEY+1VI=", MMUtils.listToString(ids), 104);
    }
    return results;
  }
  
  public BatchActionResults batchAudit(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    BatchActionResults results = batchExecute(ctx, entries, BatchActionEnum.AUDIT);
    
    BillUpdater billUpdater = new MOUpdaterSaleOrder(ctx);
    billUpdater.setBatchResults(results);
    billUpdater.setAuditAction(true);
    billUpdater.execute();
    billUpdater = new MOUpdaterMOOrder(ctx);
    billUpdater.setBatchResults(results);
    billUpdater.setAuditAction(true);
    billUpdater.execute();
    
    Boolean isPORelease = (Boolean)ctx.get("isPlannedOrderRelease");
    if ((isPORelease == null) || (!isPORelease.booleanValue())) {
      try
      {
        updateReqPlanData(ctx, results.getToDoIdsList(), 103, null);
      }
      catch (Exception exc)
      {
        throw new BOSException(exc);
      }
    }
    ctx.put("isPlannedOrderRelease", null);
    
    return results;
  }
  
  public BatchActionResults batchUnAudit(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    BatchActionResults results = batchExecute(ctx, entries, BatchActionEnum.UNAUDIT);
    
    BillUpdater billUpdater = new MOUpdaterSaleOrder(ctx);
    billUpdater.setBatchResults(results);
    billUpdater.setAuditAction(false);
    billUpdater.execute();
    billUpdater = new MOUpdaterMOOrder(ctx);
    billUpdater.setBatchResults(results);
    billUpdater.setAuditAction(false);
    billUpdater.execute();
    try
    {
      updateReqPlanData(ctx, results.getToDoIdsList(), 109, null);
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    return results;
  }
  
  protected IObjectValue _createNewData(Context ctx, boolean isUseAgent)
    throws BOSException, EASBizException
  {
    return _createNewMO(ctx, isUseAgent, null);
  }
  
  protected String getBillTypeId()
  {
    return "B2aZSVXaSx6qxdfekgCmrEY+1VI=";
  }
  
  protected String getXmlFileName(BatchActionEnum batchActionEnum)
  {
    return "com.kingdee.eas.mm.mo.app.mobizprocess.xml";
  }
  
//  public void batchCheck(Context ctx, BatchActionEnum batchAction, BatchActionResults batchResults)
//    throws BOSException, EASBizException
//  {
//    Set idSet = batchResults.getToDoIdsSet();
//    if (idSet.size() <= 0) {
//      return;
//    }
//    boolean isFromList = isFromListUI(ctx);
//    if ((isFromList) || (batchResults.getObjCollection() == null) || (batchResults.getObjCollection().size() <= 0))
//    {
//      ManufactureOrderCollection col = null;
//      col = getMMCollectionByIdSet(ctx, idSet);
//      batchResults.setObjCollection(col);
//    }
//    if (batchAction.equals(BatchActionEnum.SUBMIT))
//    {
//      submitBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equalsIgnoreCase("ALERT"))
//    {
//      alertBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.equals(BatchActionEnum.AUDIT))
//    {
//      lotNumberCheck(ctx, batchResults);
//      auditBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.equals(BatchActionEnum.UNAUDIT))
//    {
//      unAuditBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equalsIgnoreCase("CLOSED"))
//    {
//      if (ctx.get("CHECK") != null)
//      {
//        Boolean check = (Boolean)ctx.get("CHECK");
//        if (!check.booleanValue())
//        {
//          ctx.put("CHECK", new Boolean(true));
//          return;
//        }
//      }
//      MOAutoCloseUtil.moCloseCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equalsIgnoreCase("FINISH"))
//    {
//      manualFinishBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equalsIgnoreCase("UNFINISH"))
//    {
//      manualFinishBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.equals(BatchActionEnum.DELETE))
//    {
//      deleteBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equals("RELEASED"))
//    {
//      updateCostObject(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equals("UNRELEASED"))
//    {
//      unReleasedBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equals("FREEZING"))
//    {
//      freezingBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equals("THAWING"))
//    {
//      thawingBatchCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equals("SYNCSTOCK"))
//    {
//      syncStockCheck(ctx, batchResults);
//    }
//    else if (batchAction.getBizAction().equals("UNCLOSED"))
//    {
//      IMMVerifyManager vm = getVerifyManager(ctx, "MOUnCloseManager", null, batchResults);
//      vm.verify();
//    }
//  }
  
  private void syncStockCheck(Context ctx, BatchActionResults batchResults)
    throws EASBizException, BOSException
  {
    List ids = batchResults.getToDoIdsList();
    if ((ids != null) && (ids.size() > 0))
    {
      String moid = null;
      String msg = null;
      for (int i = 0; i < ids.size(); i++)
      {
        moid = ids.toArray()[i].toString();
        ManufactureOrderInfo moInfo = (ManufactureOrderInfo)getValue(ctx, new ObjectUuidPK(BOSUuid.read(moid)));
        if (moInfo.getBomID() == null)
        {
          msg = getString(ctx, "SYNC_BOM_ISNULL");
          batchResults.addError(moid, msg);
        }
      }
    }
  }
  
  private void unReleasedBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    List ids = batchResults.getToDoIdsList();
    if ((ids != null) && (ids.size() > 0))
    {
      String moid = null;
      String msg = null;
      for (int i = 0; i < ids.size(); i++)
      {
        moid = ids.toArray()[i].toString();
        ManufactureOrderInfo moInfo = (ManufactureOrderInfo)getValue(ctx, new ObjectUuidPK(BOSUuid.read(moid)));
        if (moInfo.getBaseStatus() != BillBaseStatusEnum.RELEASED)
        {
          msg = getString(ctx, "NotReleasedForUnReleased");
          throw new SCMBillException(SCMBillException.EX_MSG_FOR_RPC, new String[] { msg });
        }
        Set excluded = new HashSet();
        excluded.add("6F0D8519");
        if (ifHaveDestBills(ctx, moid, excluded))
        {
          msg = getString(ctx, "Exists_BOTP_bill_noUnReleased");
          
          throw new SCMBillException(SCMBillException.EX_MSG_FOR_RPC, new String[] { msg });
        }
      }
    }
  }
  
  private void freezingBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    List ids = batchResults.getToDoIdsList();
    if ((ids != null) && (ids.size() > 0))
    {
      String moid = null;
      String msg = null;
      for (int i = 0; i < ids.size(); i++)
      {
        moid = ids.toArray()[i].toString();
        ManufactureOrderInfo moInfo = (ManufactureOrderInfo)getValue(ctx, new ObjectUuidPK(BOSUuid.read(moid)));
        if ((moInfo.getBaseStatus() != BillBaseStatusEnum.AUDITED) && (moInfo.getBaseStatus() != BillBaseStatusEnum.RELEASED) && (moInfo.getBaseStatus() != BillBaseStatusEnum.COMPLETE))
        {
          msg = getString(ctx, "NOTSTATUSFORTFREEZING");
          
          batchResults.addError(moid, msg);
        }
      }
    }
  }
  
  private void thawingBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    List ids = batchResults.getToDoIdsList();
    if ((ids != null) && (ids.size() > 0))
    {
      String moid = null;
      String msg = null;
      for (int i = 0; i < ids.size(); i++)
      {
        moid = ids.toArray()[i].toString();
        ManufactureOrderInfo moInfo = (ManufactureOrderInfo)getValue(ctx, new ObjectUuidPK(BOSUuid.read(moid)));
        if (moInfo.getBaseStatus() != BillBaseStatusEnum.BLOCKED)
        {
          msg = getString(ctx, "NOTFREEZING");
          
          batchResults.addError(moid, msg);
        }
      }
    }
  }
  
  private void manualFinishBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    List ids = batchResults.getToDoIdsList();
    if ((ids != null) && (ids.size() > 0)) {
      for (int i = 0; i < ids.size(); i++)
      {
        String moid = null;
        String msg = null;
        moid = ids.toArray()[i].toString();
        SelectorItemCollection selectorItemCollection = new SelectorItemCollection();
        
        selectorItemCollection.add(new SelectorItemInfo("transactionType.isWPManagement"));
        selectorItemCollection.add(new SelectorItemInfo("id"));
        ManufactureOrderInfo moInfo = (ManufactureOrderInfo)getValue(ctx, new ObjectUuidPK(BOSUuid.read(moid)), selectorItemCollection);
        if (!moInfo.getTransactionType().isIsWPManagement())
        {
          msg = getString(ctx, "MO_NOTWPMANAGE_CANNOTFINISH");
          batchResults.addError(moid, msg);
        }
      }
    }
  }
  
  private void deleteBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    IObjectCollection col = batchResults.getObjCollection();
    if ((col != null) && (col.size() > 0))
    {
      List todos = batchResults.getToDoIdsList();
      for (int i = 0; i < col.size(); i++)
      {
        String moid = null;
        String msg = null;
        List ids = new ArrayList();
        ManufactureOrderInfo mo = (ManufactureOrderInfo)col.getObject(i);
        if (mo.getId() == null) {
          moid = "NEWID";
        } else {
          moid = mo.getId().toString();
        }
        StringBuffer ksqlBuf = new StringBuffer();
        ksqlBuf.append("SELECT  mo.FID as FID, ");
        ksqlBuf.append("   mo.FBaseStatus as FBaseStatus, ");
        ksqlBuf.append("   mo.FBirthType as FBirthType, ");
        ksqlBuf.append("   bt.FDestObjectID  as FDestObjectID ");
        ksqlBuf.append("FROM  T_mm_manufactureorder  mo  ");
        ksqlBuf.append("   LEFT  JOIN  T_bot_Relation  bt  ");
        ksqlBuf.append("     ON  mo.fid = bt.FSrcObjectID  ");
        ksqlBuf.append("WHERE  mo.flongnumber  LIKE  '%").append(mo.getId().toString()).append("!%'");
        
        IRowSet rs = DbUtil.executeQuery(ctx, ksqlBuf.toString());
        try
        {
          while ((rs != null) && (rs.next()))
          {
            String childId = rs.getString("FID");
            int status = rs.getInt("FBaseStatus");
            int birthtype = rs.getInt("FBirthType");
            String destObjectID = rs.getString("FDestObjectID");
            if ((status != 1) && (status != 2))
            {
              msg = getString(ctx, "Exists_ModifiedChild_noDelete");
              break;
            }
            if (birthtype != 30)
            {
              msg = getString(ctx, "Exists_otherChild_noDelete");
              break;
            }
            if (!StringUtils.isEmpty(destObjectID))
            {
              msg = getString(ctx, "Exists_BOTPChild_noDelete");
              break;
            }
            ids.add(childId);
          }
        }
        catch (SQLException e)
        {
          throw new SQLDataException(e);
        }
        if (StringUtils.isEmpty(msg))
        {
          if (batchResults.isToDo(moid))
          {
            IManufactureOrder iManufactureOrder = ManufactureOrderFactory.getLocalInstance(ctx);
            for (int k = 0; k < ids.size(); k++)
            {
              IObjectPK moPK = new ObjectUuidPK((String)ids.get(k));
              if (!todos.contains(moPK)) {
                iManufactureOrder.deleteNoCheck(moPK);
              }
            }
          }
        }
        else {
          batchResults.addError(moid, msg);
        }
      }
    }
  }
  
  private void submitBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    IObjectCollection col = batchResults.getObjCollection();
    if ((col != null) && (col.size() > 0))
    {
      Map mMap = batchGetMaterialRelationInfos(ctx, col);
      for (int i = 0; i < col.size(); i++)
      {
        ManufactureOrderInfo mo = (ManufactureOrderInfo)col.getObject(i);
        submitCheck(ctx, batchResults, mo, mMap);
      }
    }
  }
  
  private void alertBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    IObjectCollection col = batchResults.getObjCollection();
    if ((col != null) && (col.size() > 0))
    {
      Map mMap = batchGetMaterialRelationInfos(ctx, col);
      for (int i = 0; i < col.size(); i++)
      {
        ManufactureOrderInfo mo = (ManufactureOrderInfo)col.getObject(i);
        synchronizeMOInfo(ctx, mo);
        col.setObject(i, mo);
        submitCheck(ctx, batchResults, mo, mMap);
      }
    }
  }
  
  private void submitCheck(Context ctx, BatchActionResults batchResults, ManufactureOrderInfo mo, Map mMap)
    throws BOSException, EASBizException
  {
    String msg = null;
    Map crossOrgMap = new HashMap();
    Set crossOrgSet = new HashSet();
    
    MaterialInfo materialInfo = mo.getMaterial();
    StorageOrgUnitInfo stor = mo.getStorageOrgUnit();
    String materialID = materialInfo.getId().toString();
    String storageOrgUnitID = stor.getId().toString();
    String mapKey = storageOrgUnitID + "&" + materialID;
    String id = null;
    if (mo.getId() == null) {
      id = "NEWID";
    } else {
      id = mo.getId().toString();
    }
    boolean isRootSuccess = true;
    if ((mo.getRouting() == null) && ((mo.getTechnics() == null) || (mo.getTechnics().size() < 1))) {
      isRootSuccess = MORootingUtil.autoGenDefaultRooting(ctx, mo, true);
    }
    if ((mo.getTechnics() == null) || (mo.getTechnics().size() < 1)) {
      isRootSuccess = false;
    } else {
      MORootingUtil.setOprNo4Entry(mo);
    }
    boolean isStocksEmpty = false;
    if ((MOBirthTypeEnum.SPLIT != mo.getBirthType()) && (MOBirthTypeEnum.REFORM != mo.getBirthType())) {
      if ((mo.getStocks() == null) || (mo.getStocks().size() < 1)) {
        isStocksEmpty = true;
      }
    }
    if ((batchResults.isToDo(id)) && (!isRootSuccess))
    {
      msg = getString(ctx, "Technics_IsNotNull");
      batchResults.addError(id, msg);
    }
    else if ((batchResults.isToDo(id)) && (isStocksEmpty))
    {
      msg = getString(ctx, "Stock_IsNotNull");
      batchResults.addError(id, msg);
    }
    else if (batchResults.isToDo(id))
    {
      ManufactureOrderTechnicsCollection tecCol = mo.getTechnics();
      MMCommonUtils.objectValueSort(tecCol, true, "operationNo");
      
      ProductTransactionTypeInfo transType = mo.getTransactionType();
      AdminOrgUnitInfo adInfo = mo.getAdminOrgUnit();
      boolean adorgInTechadsFlag = false;
      
      String cheAdminInTEOrg = ParamManager.getParamValue(ctx, new ObjectUuidPK(storageOrgUnitID), "CheAdminIsInTecEntryOrg");
      boolean cheAdminInTEOrgFlag = Boolean.valueOf(cheAdminInTEOrg).booleanValue();
      
      boolean entryAdmOrgNullFlag = false;
      for (int j = 0; j < tecCol.size(); j++)
      {
        ManufactureOrderTechnicsInfo entry = tecCol.get(j);
        if ((entry.getEntrustType() != null) && (entry.getEntrustType().equals(CSEntrustTypeEnum.INNERCOOPERATE)))
        {
          if ((j > 0) && (!mo.getTechnics().get(j - 1).isIsReportPoint()))
          {
            msg = getString(ctx, "OUTWP_LAS_OR_NEXT_ISNOT_REPORPOINT");
            batchResults.addError(id, msg);
          }
          if ((j < mo.getTechnics().size() - 1) && (!mo.getTechnics().get(j + 1).isIsReportPoint()))
          {
            msg = getString(ctx, "OUTWP_LAS_OR_NEXT_ISNOT_REPORPOINT");
            batchResults.addError(id, msg);
          }
        }
        if ((transType != null) && (transType.isIsWPManagement()))
        {
          if (entry.getWorkcenter() == null)
          {
            msg = getString(ctx, "WORKCENTER");
            batchResults.addError(id, msg);
          }
          if ((entry.getEntrustType() != null) && (entry.getEntrustType().equals(CSEntrustTypeEnum.OPERATIONENTRUST)) && (!entry.isIsReportPoint()))
          {
            msg = getString(ctx, "OUTWP_ISNOT_REPORPOINT");
            batchResults.addError(id, msg);
          }
        }
        if ((transType != null) && (EqualsUtil.equals(transType.getWPControlStrategy(), WPControlStrategyEnum.ORDER_CON_STRATEGY))) {
          if (entry.getControlStrategy() == null)
          {
            msg = getString(ctx, "CONTROLSTRATEGY_IS_NULL");
            batchResults.addError(id, msg);
          }
        }
        if ((!entryAdmOrgNullFlag) && (entry.getAdminOrgUnit() == null)) {
          entryAdmOrgNullFlag = true;
        }
        if ((cheAdminInTEOrgFlag) && (!adorgInTechadsFlag) && 
          (adInfo != null) && (entry.getAdminOrgUnit() != null) && (adInfo.getId().toString().equals(entry.getAdminOrgUnit().getId().toString()))) {
          adorgInTechadsFlag = true;
        }
      }
      if (entryAdmOrgNullFlag)
      {
        msg = getString(ctx, "TECH_ADMIN_ORG_MUST_NOT_NULL");
        batchResults.addError(id, msg);
      }
      if ((cheAdminInTEOrgFlag) && (!adorgInTechadsFlag))
      {
        msg = getString(ctx, "AdOrgInTechAds");
        batchResults.addError(id, msg);
      }
    }
    if (batchResults.isToDo(id))
    {
      ManufactureOrderStockCollection stockCol = mo.getStocks();
      BizTypeInfo bizType = mo.getBizType();
      for (int j = 0; j < stockCol.size(); j++)
      {
        ManufactureOrderStockInfo entry = stockCol.get(j);
        if (("vGXRx5fFSsCYz9Zv7CzzgyQHQ1w=".equalsIgnoreCase(bizType.getId().toString())) && (materialID.equals(entry.getMaterial().getId().toString())))
        {
          Integer seq = new Integer(entry.getSeq());
          //batchResults.addError(id, getMessage(ctx, "STOCKERROR", new String[] { seq.toString() }));
        }
        if ((entry.getMaterial().isUseAsstAttrRelation()) && (entry.isIsBackflush()))
        {
          Integer seq = new Integer(entry.getSeq());
          batchResults.addError(id, getMessage(ctx, "REFUSEBACKFLUSH", new String[] { seq.toString() }));
        }
      }
    }
    if (batchResults.isToDo(id))
    {
      ManufactureOrderStockCollection stockCol = mo.getStocks();
      for (int j = 0; j < stockCol.size(); j++)
      {
        ManufactureOrderStockInfo entry = stockCol.get(j);
        if ((entry.getProvideType() == MaterialProvideTypeEnum.SPANORGPROVIDE) || (entry.getProvideType() == MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE))
        {
          String keyID = entry.getMaterial().getId().toString() + "_" + entry.getStorageOrgUnit().getId().toString();
          if (crossOrgMap.containsKey(keyID))
          {
            List seqList = (List)crossOrgMap.get(keyID);
            seqList.add(String.valueOf(entry.getProvideType().getValue()));
          }
          else
          {
            List seqList = new ArrayList();
            seqList.add(String.valueOf(entry.getProvideType().getValue()));
            crossOrgMap.put(keyID, seqList);
          }
          if (!crossOrgSet.contains(keyID)) {
            crossOrgSet.add(keyID);
          }
        }
      }
    }
    if (batchResults.isToDo(id))
    {
      ManufactureOrderExpectOutputCollection outCol = mo.getExpectOutputs();
      int rowCount = outCol.size();
      if (rowCount > 1)
      {
        Set opMaterial = new HashSet();
        ManufactureOrderExpectOutputInfo outInfo = null;
        for (int j = 0; j < rowCount; j++)
        {
          outInfo = outCol.get(j);
          String outKey = outInfo.getOperationNo() + "-" + outInfo.getMaterial().getId().toString();
          if (opMaterial.contains(outKey))
          {
            msg = getString(ctx, "OUTPUT_MATERIAL_DUP");
            batchResults.addError(id, msg);
            break;
          }
          opMaterial.add(outKey);
        }
      }
    }
    if ((mMap != null) && (mMap.get(mapKey) != null))
    {
      List lst = (List)mMap.get(mapKey);
      int isConfig = lst.get(0) != null ? ((Integer)lst.get(0)).intValue() : 0;
      if ((isConfig == 1) && 
        (mo.getProject() == null) && (mo.getTrackNumber() == null))
      {
        msg = getMessage(ctx, "PROJECT_TRACKNUM_NOT_NULL", new String[] { lst.get(2) != null ? (String)lst.get(2) : "" });
        
        batchResults.addError(id, msg);
      }
      if (((mo.getSourceBillType() != null) && (!"9XXvbVGlRtym/0qtqeIXXrhE1B8=".equals(mo.getSourceBillType().getId().toString()))) || (mo.getSourceBillType() == null)) {
        if (lst.get(1) != null)
        {
          String strategy = (String)lst.get(1);
          String strategyNumber = (String)lst.get(2);
          String materialName = (String)lst.get(3);
          String isolatedRule = (String)lst.get(4);
          if ((strategy.equals("GE2FIa4GQ6uhdx0RDGuibtg0uEU=")) || (strategy.equals("qAXoUB/uBg/gQKjAYj0WQ9g0uEU=")))
          {
            if ((isolatedRule.equals("ITEM")) && (mo.getProject() == null))
            {
              msg = getMessage(ctx, "ETO_PROJECT_NOT_NULL", new String[] { materialName, strategyNumber });
              batchResults.addError(id, msg);
            }
            else if (isolatedRule.equals("ITEM_TRACKNO"))
            {
              if (mo.getProject() == null)
              {
                msg = getMessage(ctx, "ETO_PROJECT_NOT_NULL", new String[] { materialName, strategyNumber });
                batchResults.addError(id, msg);
              }
              if (mo.getTrackNumber() == null)
              {
                msg = getMessage(ctx, "MTO_TRACKNUMBER_NOT_NULL", new String[] { materialName, strategyNumber });
                batchResults.addError(id, msg);
              }
            }
          }
          else if ((strategy.equals("fpPxtypCS/ihJ30GjB/UJtg0uEU=")) || (strategy.equals("qAXoUB/tBg/gQKjAYj0WQ9g0uEU=")) || (strategy.equals("qAYbemEdG9ngQKjAYj0V1dg0uEU=")) || (strategy.equals("qAYfaBzTrmLgQKjAYj0f3dg0uEU="))) {
            if (mo.getTrackNumber() == null)
            {
              msg = getMessage(ctx, "MTO_TRACKNUMBER_NOT_NULL", new String[] { materialName, strategyNumber });
              batchResults.addError(id, msg);
            }
          }
        }
      }
    }
    if (batchResults.isToDo(id))
    {
      ScheduleTypeEnum scheduleType = mo.getScheduleType();
      if ((scheduleType != null) && (scheduleType.getValue() != 10))
      {
        boolean isSupplyClassTerm = isSupplyClassTerm(ctx, mo);
        if (!isSupplyClassTerm)
        {
          msg = getString(ctx, "Not_SupplyClassTerm");
          batchResults.addError(id, msg);
        }
        boolean hasCalendar = hasProjectCalendar(ctx, mo.getStorageOrgUnit().getId().toString());
        if (!hasCalendar)
        {
          msg = getString(ctx, "Not_FACTORYCALENDAR");
          batchResults.addError(id, msg);
        }
      }
      Set outSet = MMUtils.getCrossOrgMaterialSupplyOrgSet(ctx, crossOrgSet);
      Iterator materialOrgs = outSet.iterator();
      while (materialOrgs.hasNext())
      {
        String materialOrg = (String)materialOrgs.next();
        String[] array = materialOrg.split("_");
        
        String sqlMaterialName = "select fname_" + getLocale() + " as name from T_BD_Material where fid='" + array[0] + "'";
        String sqlOrgName = "select fname_" + getLocale() + " as name from T_ORG_Storage where fid='" + array[1] + "'";
        String materialName = "";
        String orgName = "";
        
        IRowSet rs_m = DbUtil.executeQuery(ctx, sqlMaterialName);
        IRowSet rs_o = DbUtil.executeQuery(ctx, sqlOrgName);
        try
        {
          while ((rs_m != null) && (rs_m.next())) {
            materialName = rs_m.getString("name");
          }
          while ((rs_o != null) && (rs_o.next())) {
            orgName = rs_o.getString("name");
          }
        }
        catch (SQLException e)
        {
          throw new SQLDataException(e);
        }
        List tmpList = (List)crossOrgMap.get(materialOrg);
        for (int k = 0; k < tmpList.size(); k++)
        {
          String provideTypeName = MaterialProvideTypeEnum.getEnum(Integer.parseInt(tmpList.get(k).toString())).getAlias();
          String msgInfo = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.mo.ManufactureOrderResource", "MID_AUDIT_CHECK", new String[] { provideTypeName, materialName, orgName });
          
          batchResults.addError(id, msgInfo);
        }
      }
    }
  }
  
  private Map batchGetMaterialRelationInfos(Context ctx, IObjectCollection col)
    throws BOSException, EASBizException
  {
    Map rtnMap = new HashMap();
    
    Map mMap = new HashMap();
    for (int i = 0; i < col.size(); i++)
    {
      ManufactureOrderInfo mo = (ManufactureOrderInfo)col.getObject(i);
      String keyVal = mo.getStorageOrgUnit().getId().toString() + "&" + mo.getMaterial().getId().toString();
      List lst = new ArrayList();
      lst.add(mo.getStorageOrgUnit().getId().toString());
      lst.add(mo.getMaterial().getId().toString());
      if (!mMap.containsKey(keyVal)) {
        mMap.put(keyVal, lst);
      }
    }
    StringBuffer strBuf = new StringBuffer();
    strBuf.append("select a.fOrgUnit,a.fmaterialid,a.FISCONFIGABLE,a.FMANUFACTURESTRATEGYID,mst.fnumber as FMANUFACTURESTRATEGYNum,b.fname_");
    strBuf.append(ctx.getLocale()).append(" as fmaterialName,a.FIsolatedRule ");
    strBuf.append(" from t_bd_materialplan a inner join t_bd_material b on a.fmaterialid = b.fid ");
    strBuf.append(" inner join T_BD_ManufactureStrategy mst on a.FMANUFACTURESTRATEGYID = mst.fid ");
    strBuf.append(" where ");
    int inner = 0;
    int allCnt = 0;
    StringBuffer sbf = new StringBuffer();
    Iterator it = mMap.keySet().iterator();
    while (it.hasNext())
    {
      inner++;
      allCnt++;
      String key = (String)it.next();
      List mu = (List)mMap.get(key);
      if (inner == 1) {
        sbf.append("(a.forgunit = '").append(mu.get(0)).append("' and a.fmaterialid = '").append(mu.get(1)).append("')");
      } else {
        sbf.append(" or (a.forgunit = '").append(mu.get(0)).append("' and a.fmaterialid = '").append(mu.get(1)).append("')");
      }
      if (((inner == 500) && (allCnt < mMap.size())) || (allCnt == mMap.size()))
      {
        IRowSet rows = DbUtil.executeQuery(ctx, strBuf.toString() + sbf.toString());
        try
        {
          while (rows.next())
          {
            String keyString = rows.getString("fOrgUnit") + "&" + rows.getString("fmaterialid");
            List vLst = new ArrayList();
            vLst.add(new Integer(rows.getInt("FISCONFIGABLE")));
            vLst.add(rows.getString("FMANUFACTURESTRATEGYID"));
            vLst.add(rows.getString("FMANUFACTURESTRATEGYNum"));
            vLst.add(rows.getString("fmaterialName"));
            vLst.add(rows.getString("FIsolatedRule"));
            rtnMap.put(keyString, vLst);
          }
        }
        catch (SQLException e)
        {
          throw new BOSException(e);
        }
        inner = 0;
        sbf.setLength(0);
      }
    }
    return rtnMap;
  }
  
  private static Locale getLocale()
  {
    try
    {
      return SysContext.getSysContext().getLocale();
    }
    catch (Throwable e) {}
    return new Locale("L2");
  }
  
  private void updateCostObject(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    HashSet orderSet = (HashSet)batchResults.getToDoIdsSet();
    
    MOCostObjectUtil.updateCostObject(ctx, orderSet);
    
    MOCostObjectUtil.updateOutputCostObject(ctx, orderSet);
  }
  
  private void auditBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    batchResults = MOUtil.checkMOClose(ctx, batchResults, idStr, "T_MM_ManufactureOrder", BatchActionEnum.AUDIT);
  }
  
  private void lotNumberCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    HashSet orderSet = (HashSet)batchResults.getToDoIdsSet();
    IObjectCollection col = batchResults.getObjCollection();
    String msg = null;
    
    ManufactureOrderCollection orderCollection = null;
    IManufactureOrder order = ManufactureOrderFactory.getLocalInstance(ctx);
    EntityViewInfo ev = new EntityViewInfo();
    FilterInfo filter = new FilterInfo();
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("material.*"));
    sic.add(new SelectorItemInfo("storageOrgUnit.*"));
    ev.setSelector(sic);
    filter.getFilterItems().add(new FilterItemInfo("id", orderSet, CompareType.INCLUDE));
    ev.setFilter(filter);
    if (col != null) {
      orderCollection = (ManufactureOrderCollection)col;
    } else {
      orderCollection = order.getManufactureOrderCollection(ev);
    }
    MaterialInfo materialInfo = null;
    ManufactureOrderInfo mo = null;
    StorageOrgUnitInfo storageOrgUnit = null;
    for (int i = 0; i < orderCollection.size(); i++)
    {
      mo = (ManufactureOrderInfo)orderCollection.getObject(i);
      materialInfo = mo.getMaterial();
      storageOrgUnit = mo.getStorageOrgUnit();
      String id = mo.getId().toString();
      if (storageOrgUnit != null) {
        if (materialInfo != null)
        {
          boolean isIsLotNumber = getIsIsLotNumber(ctx, materialInfo, storageOrgUnit);
          
          LotFrame lotFrame = new LotFrame();
          lotFrame.setMainBizOrg(storageOrgUnit.getId().toString());
          lotFrame.setMaterial(materialInfo.getId().toString());
          List<LotFrame> lotList = new ArrayList();
          lotList.add(lotFrame);
          lotList = LotRuleFactory.getLocalInstance(ctx).fillLotFramesNoSerial(lotList);
          if ((lotList != null) && (lotList.size() > 0)) {
            lotFrame = (LotFrame)lotList.get(0);
          }
          boolean isLotRule = false;
          if ((lotFrame != null) && (lotFrame.getLotRule() != null)) {
            isLotRule = true;
          }
          LotParamValueInfo lotParamInfo = LotFacadeFactory.getLocalInstance(ctx).getLotParamValueByOrg(storageOrgUnit.getId().toString());
          
          boolean isManufacturePlan = lotParamInfo.isManufacturePlan();
          
          boolean isManufactureOrder = lotParamInfo.isManufactureOrder();
          if (isIsLotNumber) {
            if (isLotRule)
            {
              if (isManufacturePlan)
              {
                if ((mo.getLot() == null) || (mo.getLot().trim().equals("")))
                {
                  msg = getString(ctx, "LOT_NOT_NULL");
                  batchResults.addError(id, msg);
                }
              }
              else if ((isManufactureOrder) && (
                (mo.getLot() == null) || (mo.getLot().trim().equals(""))))
              {
                msg = getString(ctx, "LOT_NOT_NULL");
                batchResults.addError(id, msg);
              }
            }
            else if (isManufacturePlan)
            {
              if ((mo.getLot() == null) || (mo.getLot().trim().equals("")))
              {
                msg = getString(ctx, "LOT_NOT_NULL");
                batchResults.addError(id, msg);
              }
            }
            else if ((isManufactureOrder) && (
              (mo.getLot() == null) || (mo.getLot().trim().equals(""))))
            {
              msg = getString(ctx, "LOT_NOT_NULL");
              batchResults.addError(id, msg);
            }
          }
        }
      }
    }
  }
  
  private void lotNumberCheck(Context ctx, ManufactureOrderInfo mo)
    throws BOSException, EASBizException
  {
    StorageOrgUnitInfo storageOrgUnit = null;
    MaterialInfo materialInfo = null;
    materialInfo = mo.getMaterial();
    storageOrgUnit = mo.getStorageOrgUnit();
    if (storageOrgUnit == null) {
      return;
    }
    if (materialInfo == null) {
      return;
    }
    boolean isIsLotNumber = getIsIsLotNumber(ctx, materialInfo, storageOrgUnit);
    if (!isIsLotNumber) {
      return;
    }
    LotFrame lotFrame = new LotFrame();
    lotFrame.setMainBizOrg(storageOrgUnit.getId().toString());
    lotFrame.setMaterial(materialInfo.getId().toString());
    List<LotFrame> lotList = new ArrayList();
    lotList.add(lotFrame);
    lotList = LotRuleFactory.getLocalInstance(ctx).fillLotFramesNoSerial(lotList);
    if ((lotList != null) && (lotList.size() > 0)) {
      lotFrame = (LotFrame)lotList.get(0);
    }
    boolean isLotRule = false;
    if ((lotFrame != null) && (lotFrame.getLotRule() != null)) {
      isLotRule = true;
    }
    LotParamValueInfo lotParamInfo = LotFacadeFactory.getLocalInstance(ctx).getLotParamValueByOrg(storageOrgUnit.getId().toString());
    
    boolean isManufacturePlan = lotParamInfo.isManufacturePlan();
    
    boolean isManufactureOrder = lotParamInfo.isManufactureOrder();
    
    boolean isManufactureProseee = lotParamInfo.isManufactureProseee();
    
    PlannedOrderInfo planorderinfo = null;
    if (mo.getSourceBillId() != null) {
      try
      {
        planorderinfo = (PlannedOrderInfo)PlannedOrderFactory.getLocalInstance(ctx).getCoreBillBaseInfo(new ObjectUuidPK(BOSUuid.read(mo.getSourceBillId())));
      }
      catch (ObjectNotFoundException e)
      {
        planorderinfo = null;
      }
    }
    if (isIsLotNumber) {
      if (isManufacturePlan)
      {
        if (isManufactureOrder)
        {
          if (isManufactureProseee)
          {
            if ((planorderinfo != null) && (planorderinfo.getLot() != null)) {
              mo.setLot(planorderinfo.getLot().trim());
            } else if (isLotRule) {
              dealLotRule(ctx, mo);
            } else {
              mo.setLot(null);
            }
          }
          else if (isLotRule) {
            dealLotRule(ctx, mo);
          } else {
            mo.setLot(null);
          }
        }
        else if ((planorderinfo != null) && (planorderinfo.getLot() != null)) {
          mo.setLot(planorderinfo.getLot().trim());
        } else if (isLotRule) {
          dealLotRule(ctx, mo);
        } else {
          mo.setLot(null);
        }
      }
      else if (isManufactureOrder) {
        if (isLotRule) {
          dealLotRule(ctx, mo);
        } else {
          mo.setLot(null);
        }
      }
    }
  }
  
  private boolean getIsIsLotNumber(Context ctx, MaterialInfo materialInfo, StorageOrgUnitInfo storageOrgUnit)
    throws EASBizException, BOSException
  {
    SCMEntryDataVO vo = new SCMEntryDataVO();
    SCMEntryDataVO voResult = new SCMEntryDataVO();
    vo.setMaterialInfos(new MaterialInfo[] { materialInfo });
    vo.setStorageOrgUnitInfos(new StorageOrgUnitInfo[] { storageOrgUnit });
    vo.setIsLoadingMaterialPlan(true);
    vo.setIsLoadingMaterialInventory(true);
    vo.setIsLoadingMaterialInfo(false);
    voResult = SCMGroupFacadeFactory.getLocalInstance(ctx).loadComplexData(vo);
    String key = materialInfo.getId().toString() + storageOrgUnit.getId().toString();
    Map miInfoMap = voResult.getMaterialInventoryInfos();
    if ((miInfoMap != null) && (miInfoMap.get(key) != null))
    {
      MaterialInventoryInfo materialInv = (MaterialInventoryInfo)voResult.getMaterialInventoryInfos().get(key);
      if (materialInv.isIsLotNumber()) {
        return true;
      }
    }
    return false;
  }
  
  private void dealLotRule(Context ctx, ManufactureOrderInfo manuorderInfo)
    throws EASBizException, BOSException
  {
    LotFrame lotFrame = LotRuleFactory.getLocalInstance(ctx).getLotFrameExtend(manuorderInfo.getMaterial().getId().toString(), manuorderInfo.getStorageOrgUnit().getId().toString());
    if ((lotFrame != null) && (lotFrame.getLotRule() != null))
    {
      LotFrameManu lot = new LotFrameManu();
      lot.setSeq(lotFrame.getSeq());
      lot.setSysDate(lotFrame.getSysDate());
      lot.setCurrentSerial(lotFrame.getCurrentSerial());
      lot.setLotRule(lotFrame.getLotRule());
      lot.setBillNumber(manuorderInfo.getNumber());
      lot.setMainBizOrg(manuorderInfo.getStorageOrgUnit().getNumber());
      lot.setMaterial(manuorderInfo.getMaterial().getNumber());
      
      lot.setMfg(manuorderInfo.getPlanEndDate());
      lot.setBizDate(manuorderInfo.getBizDate());
      String lotNo = lot.getLotNumber();
      manuorderInfo.setLot(lotNo);
    }
    else
    {
      manuorderInfo.setLot(null);
    }
  }
  
  private void unAuditBatchCheck(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String[] allIDs = batchResults.getAllIDs();
    if ((allIDs != null) && (allIDs.length > 0)) {
      for (int i = 0; i < allIDs.length; i++)
      {
        ManufactureOrderInfo mo = getManufactureOrderInfo(ctx, new ObjectUuidPK(allIDs[i]));
        try
        {
          checkUnAuditInParam(ctx, mo);
        }
        catch (SCMBillException ex)
        {
          batchResults.addError(allIDs[i], ex.getMessage());
        }
      }
    }
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    StringBuffer selectSql = new StringBuffer();
    selectSql.append("select distinct FSrcObjectID from t_bot_Relation ").append("where FSrcObjectID in (").append(idStr).append(") ");
    
    IRowSet rs = DbUtil.executeQuery(ctx, selectSql.toString());
    try
    {
      String msg = null;
      while ((rs != null) && (rs.next()))
      {
        msg = getString(ctx, "HAS_FOLLOWBILL");
        batchResults.addError(rs.getString("FSrcObjectID"), msg);
      }
    }
    catch (SQLException e)
    {
      throw new SQLDataException(e);
    }
    StringBuffer sql = new StringBuffer();
    sql.append("select mo.FID,mo.FBirthType,mor.FChildId from T_MM_ManufactureOrder mo LEFT JOIN T_MM_MOSplitRecord mor ON mo.fid=mor.FParentId where mo.FID in (").append(idStr).append(") ");
    IRowSet iRowSet = DbUtil.executeQuery(ctx, sql.toString());
    try
    {
      String msg = null;
      while ((iRowSet != null) && (iRowSet.next()))
      {
        String id = iRowSet.getString("FID");
        int birthType = iRowSet.getInt("FBirthType");
        String childid = iRowSet.getString("FChildId");
        if ((birthType == 10) || (birthType == 20))
        {
          msg = getString(ctx, "SPLIT_BILL_NO_UNAUDIT");
          batchResults.addError(id, msg);
        }
        else if (!StringUtils.isEmpty(childid))
        {
          msg = getString(ctx, "HAS_SPLIT_BILL_NO_UNAUDIT");
          batchResults.addError(id, msg);
        }
      }
    }
    catch (SQLException e)
    {
      throw new SQLDataException(e);
    }
    batchResults = MOUtil.checkMOClose(ctx, batchResults, idStr, "T_MM_ManufactureOrder", BatchActionEnum.UNAUDIT);
  }
  
  private boolean checkUnAuditInParam(Context ctx, ManufactureOrderInfo mo)
    throws BOSException, EASBizException
  {
    if ((mo != null) && (mo.getBillType() != null))
    {
      String billTypeId = mo.getBillType().getId().toString();
      String orgUnitID = mo.getStorageOrgUnit().getId().toString();
      boolean isCanUnAudit = false;
      ISCMBillParam scmParam = SCMBillParamFactory.getLocalInstance(ctx);
      String strCanUnAudit = scmParam.getParamByBillTypeID("SCM_UnAudit_01", 4, orgUnitID, billTypeId);
      if ((strCanUnAudit != null) && (strCanUnAudit.trim().length() != 0) && (strCanUnAudit.trim().toLowerCase().equals("1"))) {
        isCanUnAudit = true;
      }
      if (!isCanUnAudit) {
        throw new SCMBillException(SCMBillException.CHECK_UNAUDIT_PARAM);
      }
    }
    return true;
  }
  
  public static String getString(Context ctx, String resourceName)
  {
    String path = "com.kingdee.eas.mm.mo.ManufactureOrderResource";
    String strTemp = ResourceBase.getString(path, resourceName, ctx.getLocale());
    if (strTemp.equals("Missing Resource")) {
      return "Missing Resource{" + resourceName + "}";
    }
    return strTemp;
  }
  
  private String getMessage(Context ctx, String key, String[] parameters)
  {
    String message = getString(ctx, key);
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < parameters.length; i++)
    {
      sb.setLength(0);
      message = message.replaceAll("\\{" + i + "\\}", parameters[i]);
    }
    return message;
  }
  
  public void batchExecute(Context ctx, BatchActionEnum batchAction, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    if (batchResults.getToDoIdsArray().length > 0)
    {
      Boolean isAutoAudit = (Boolean)ctx.get("isAutoAudit");
      if (batchAction.equals(BatchActionEnum.SUBMIT))
      {
        afterSubmit(ctx, batchResults.getToDoIdsArray());
        logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "5_ManufactureOrderControllerBean", ctx.getLocale()) + ctx.getContextID() + ",isAutoAudit is :" + isAutoAudit + "," + "ID ??" + StringUtils.arrayToString(batchResults.getToDoIdsArray(), ","));
        ctx.put("isFromList", Boolean.FALSE);
        if ((isAutoAudit != null) && (isAutoAudit.booleanValue() == true))
        {
          logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "6_ManufactureOrderControllerBean", ctx.getLocale()));
          afterAudit(ctx, batchResults);
          afterAuditWriteBackWBS(ctx, batchResults, 103);
          LotFacadeFactory.getLocalInstance(ctx).manufactuerOrderInsertLotSource(batchResults.getToDoIdsArray());
          ctx.put("isAutoAudit", null);
          logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "7_ManufactureOrderControllerBean", ctx.getLocale()) + ctx.getContextID() + ",isAutoAudit is :" + ctx.get("isAutoAudit"));
        }
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("ALERT"))
      {
        doAlert(ctx, batchResults);
      }
      else if (batchAction.equals(BatchActionEnum.AUDIT))
      {
        logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "8_ManufactureOrderControllerBean", ctx.getLocale()) + ctx.getContextID() + ",isAutoAudit is :" + isAutoAudit + "," + ",ID ??" + StringUtils.arrayToString(batchResults.getToDoIdsArray(), ","));
        if ((isAutoAudit == null) || (!isAutoAudit.booleanValue()))
        {
          logger.info(ResourceBase.getString("com.kingdee.eas.mm.mo.MOAutoGenerateResource", "9_ManufactureOrderControllerBean", ctx.getLocale()));
          afterAudit(ctx, batchResults);
          afterAuditWriteBackWBS(ctx, batchResults, 103);
          LotFacadeFactory.getLocalInstance(ctx).manufactuerOrderInsertLotSource(batchResults.getToDoIdsArray());
        }
      }
      else if (batchAction.equals(BatchActionEnum.UNAUDIT))
      {
        String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
        StringBuffer updateSql = new StringBuffer();
        updateSql.append("update T_MM_MFTOrderTechnics as t0  ").append("set (FIntoQty,FIntoBaseQty) = ").append("(select 0,0 ").append("from T_MM_ManufactureOrder t1 ").append("where t1.FFirstOperNo = t0.FOperationNo ").append("and t1.FID = t0.FParentID ").append("and t1.FID in (").append(idStr).append(") ").append(") ");
        
        DbUtil.execute(ctx, updateSql.toString());
        LotFacadeFactory.getLocalInstance(ctx).manufactureOrderDeleteLotSource(batchResults.getToDoIdsArray());
        
        MOCostObjectUtil.removeCostObject(ctx, idStr);
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("FINISH"))
      {
        MOFinish.manualFinished(ctx, batchResults.getToDoIdsArray());
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("UNFINISH"))
      {
        MOFinish.manualUnFinished(ctx, batchResults.getToDoIdsArray());
      }
      else if (batchAction.equals(BatchActionEnum.DELETE))
      {
        String[] ids = sortMoIdListByMoLongnumber(ctx, batchResults.getToDoIdsArray());
        for (int i = 0; i < ids.length; i++) {
          _delete(ctx, new ObjectUuidPK(ids[i]));
        }
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("CLOSED"))
      {
        afterClose(ctx, batchResults);
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("UNCLOSED"))
      {
        afterUnClose(ctx, batchResults);
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("UNRELEASED"))
      {
        afterUnReleased(ctx, batchResults);
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("FREEZING"))
      {
        afterFreezing(ctx, batchResults);
      }
      else if (batchAction.getBizAction().equalsIgnoreCase("THAWING"))
      {
        afterThawing(ctx, batchResults);
      }
      else if (batchAction.equals(BatchActionEnum.SAVE))
      {
        dealLotNumber(ctx, batchResults);
      }
    }
  }
  
  private String[] sortMoIdListByMoLongnumber(Context ctx, String[] toDoIds)
    throws BOSException
  {
    String idStr = SQLUtil.arrayToString(toDoIds);
    StringBuffer ksqlBuf = new StringBuffer();
    ksqlBuf.append(" SELECT  fid  ");
    ksqlBuf.append(" FROM  T_MM_ManufactureOrder  ");
    ksqlBuf.append(" WHERE  fid  IN   (").append(idStr).append(")  ");
    ksqlBuf.append("   ORDER  BY  flongnumber  DESC");
    String[] sortIDs = new String[toDoIds.length];
    IRowSet rs = DbUtil.executeQuery(ctx, ksqlBuf.toString());
    try
    {
      int i = 0;
      while (rs.next()) {
        sortIDs[(i++)] = rs.getString("fid");
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return sortIDs;
  }
  
  private void afterFreezing(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    String[] sqls = new String[1];
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filterInfo = new FilterInfo();
    filterInfo.getFilterItems().add(new FilterItemInfo("id", idStr, CompareType.INNER));
    viewInfo.setFilter(filterInfo);
    
    StringBuffer updateSql = new StringBuffer();
    
    updateSql.append("update T_MM_ManufactureOrder   ").append(" set FOldBaseStatus = FBaseStatus ,FBaseStatus = ").append(6).append(" where fid in (").append(idStr).append(")  ");
    
    sqls[0] = updateSql.toString();
    SQLUtil.batchExecuteSql(ctx, sqls);
  }
  
  private void afterThawing(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    String[] sqls = new String[1];
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filterInfo = new FilterInfo();
    filterInfo.getFilterItems().add(new FilterItemInfo("id", idStr, CompareType.INNER));
    viewInfo.setFilter(filterInfo);
    
    StringBuffer updateSql = new StringBuffer();
    
    updateSql.append("update T_MM_ManufactureOrder   ").append(" set FBaseStatus = FOldBaseStatus ").append(" where fid in (").append(idStr).append(")  ");
    
    sqls[0] = updateSql.toString();
    SQLUtil.batchExecuteSql(ctx, sqls);
  }
  
  private void afterUnReleased(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    String[] sqls = new String[1];
    StringBuffer updateSql = new StringBuffer();
    
    updateSql.append("update T_MM_ManufactureOrder   ").append(" set FBaseStatus = ").append(4).append(" where fid in (").append(idStr).append(")  ");
    
    sqls[0] = updateSql.toString();
    SQLUtil.batchExecuteSql(ctx, sqls);
  }
  
  private void afterUnClose(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    
    String[] sqlUpStatus = new String[2];
    sqlUpStatus[0] = ("update t_mm_manufactureorder set fbasestatus = 8 where fid in  ( select mo.fid from  t_mm_manufactureorder mo inner join T_MM_PRODUCTTRANSACTIONTYPE pt on mo.ftransactionTypeid = pt.fid  where mo.fid in ( " + idStr + " ) and pt.FIsWPManagement = 1 )");
    
    sqlUpStatus[1] = ("update t_mm_manufactureorder set fbasestatus = 5 , FActureEndDate = null  where fid in  ( select mo.fid from  t_mm_manufactureorder mo inner join T_MM_PRODUCTTRANSACTIONTYPE pt on mo.ftransactionTypeid = pt.fid  where mo.fid in ( " + idStr + " ) and pt.FIsWPManagement = 0 )");
    
    SQLUtil.batchExecuteSql(ctx, sqlUpStatus);
    
    String[] sqls = new String[1];
    StringBuffer updateSql = new StringBuffer();
    
    updateSql.append("update T_MM_MFTOrderStock   ").append("set FActureLossRatio = 0, ").append("FActLossQty = 0,").append("FActLossBaseQty = 0 ").append("where FParentID in (").append("select fid from T_MM_ManufactureOrder ").append("where fid in (").append(idStr).append(")  ").append(")");
    
    sqls[0] = updateSql.toString();
    SQLUtil.batchExecuteSql(ctx, sqls);
    
    LotFacadeFactory.getLocalInstance(ctx).manufactureOrderUnCloseLot(batchResults.getToDoIdsArray());
  }
  
  private void afterClose(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    MOAutoCloseUtil.executeClose(ctx, batchResults);
  }
  
  private void afterSubmit(Context ctx, String[] idarray)
    throws BOSException, EASBizException
  {
    int iner = 0;
    int allCnt = 0;
    
    StringBuffer sbf = new StringBuffer();
    for (int i = 0; i < idarray.length; i++)
    {
      iner++;
      allCnt++;
      if (iner == 1) {
        sbf.append("'").append(idarray[i]).append("'");
      } else {
        sbf.append(",'").append(idarray[i]).append("'");
      }
      if (((i == 300) && (allCnt < idarray.length)) || (allCnt == idarray.length))
      {
        String[] sqls = new String[5];
        
        StringBuffer updateSql = new StringBuffer();
        
        updateSql.append("update T_MM_ManufactureOrder as t0  ").append("set (FFirstOperNo,FLastOperNo) = ").append("(select firstOp,lastOp from ").append("(select t1.FParentID,min(FOperationNo) firstOp,max(FOperationNo) lastOp ").append("from T_MM_MFTOrderTechnics t1 ").append("where t1.FParentID in (").append(sbf.toString()).append(") ").append("group by t1.FParentID) t2 ").append("where t0.FID = t2.FParentID )");
        
        updateSql.append(" where  t0.FID in (").append(sbf.toString()).append(")").append(" and isnull(t0.fbirthtype, 0) = ").append(0);
        
        sqls[0] = updateSql.toString();
        
        updateSql.setLength(0);
        updateSql.append("update T_MM_ManufactureOrder as t0  ").append("set (FLackLowerLimitBase,FExtraUpperLimitBase,FDeliveryBaseQty ,FunRepairBaseQty) = ").append("(select round(decimal(t0.FLackLowerLimit * t1.FBaseConvsRate,21,8),t2.FQtyPrecision),").append("round(decimal(t0.FExtraUpperLimit * t1.FBaseConvsRate,21,8),t2.FQtyPrecision), ").append("round(decimal(t0.FDeliveryQty * t1.FBaseConvsRate,21,8),t2.FQtyPrecision), ").append("round(decimal(t0.FunRepairQty * t1.FBaseConvsRate,21,8),t2.FQtyPrecision)").append("from t_bd_multimeasureunit t1,t_bd_multimeasureunit t2 ").append("where t0.FMaterialID = t1.FMaterialID and t0.FUnitID = t1.fmeasureunitid ").append("and t0.FMaterialID = t2.FMaterialID and t0.FBaseUnitID = t2.fmeasureunitid) ");
        
        updateSql.append(" where t0.fid in(").append(sbf.toString()).append(")");
        sqls[1] = updateSql.toString();
        
        updateSql.setLength(0);
        updateSql.append("update T_MM_MFTOrderTechnics as t0  ").append("set (FBaseQty) = ").append("(select t1.FBaseQty ").append("from T_MM_ManufactureOrder t1 ").append("where t0.FParentID = t1.FID) ");
        
        updateSql.append("where exists(select 1 from T_MM_ManufactureOrder T1 WHERE t0.FParentID = t1.FID AND t1.FID IN (").append(sbf.toString()).append("))");
        sqls[2] = updateSql.toString();
        
        updateSql.setLength(0);
        updateSql.append("update T_MM_MFTOrderStock as t0  ").append("set (FBaseQty,FUnitbaseQty,FLossBaseQty,FPlannedBaseQty,FOriginalPlanBaseQty,FUnReceiptBaseQty,FTotalReceiptBaseQty,FPickExtraBaseQty,FPickLackBaseQty) = ").append("(select round(decimal(t0.FQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision),").append("round(decimal(t0.FUnitQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FLossQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FPlannedQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FOriginalPlanQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FUnReceiptQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FTotalReceiptQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FPickExtraQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ").append("round(decimal(t0.FPickLackQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision) ").append("from t_bd_multimeasureunit t2 , T_MM_ManufactureOrder t1 ,t_bd_multimeasureunit t3 ").append("where t0.FParentID = t1.FID ").append("and t0.FMaterialID = t2.FMaterialID and t0.FUnitID = t2.fmeasureunitid ").append(" and t0.FMaterialID = t3.FMaterialID and t0.FBaseUnitID = t3.fmeasureunitid ").append("and t1.FID in (").append(sbf.toString()).append(") ").append(")");
        
        updateSql.append(" where exists(select 1 from t_mm_manufactureorder t1 where t0.fparentid = t1.fid AND t1.FID IN (").append(sbf.toString()).append("))");
        sqls[3] = updateSql.toString();
        
        updateSql.setLength(0);
        updateSql.append("update T_MM_MFTOrderStock as t0  ").append("set (FWorkcenterID,FOperationID) = ").append("(select FWorkcenterID,FOperationID ").append("from T_MM_MFTOrderTechnics t1 ").append(" where t0.FOperationNo = t1.FOperationNo and t1.fparentid=t0.fparentid").append(")").append("where t0.FParentID in (").append(sbf.toString()).append(") ");
        
        sqls[4] = updateSql.toString();
        try
        {
          SQLUtil.batchExecuteSql(ctx, sqls);
        }
        catch (BOSException bosException)
        {
          Throwable throwable = bosException.getCause();
          if ((throwable instanceof SQLException))
          {
            String sqlState = ((SQLException)throwable).getSQLState();
            String message = ((SQLException)throwable).getMessage();
            if ((sqlState != null) && (sqlState.equalsIgnoreCase("22003"))) {
              throw new ManufactureOrderException(ManufactureOrderException.NUMERIC_VALUE_OUT_OF_RANGE);
            }
            if ((message != null) && (message.toLowerCase().indexOf("numeric") > -1)) {
              throw new ManufactureOrderException(ManufactureOrderException.NUMERIC_VALUE_OUT_OF_RANGE);
            }
          }
          throw bosException;
        }
        iner = 1;
        sbf.setLength(0);
      }
    }
  }
  
  private void afterAuditWriteBackWBS(Context ctx, BatchActionResults batchResults, int bizAction)
    throws BOSException, EASBizException
  {
    StringBuffer tempTableSql = new StringBuffer();
    tempTableSql.append("CREATE TABLE TEMP_WRITEBACKWBS (").append("FBizDate DATETIME,").append("FPROJECTID VARCHAR(44),").append("FMaterialID VARCHAR(44),").append("FTrackNumberID VARCHAR(44),").append("FStorageOrgUnitID VARCHAR(44) )");
    
    String tempTableName = "";
    try
    {
      try
      {
        tempTableName = TempTablePool.getInstance(ctx).createTempTable(tempTableSql.toString());
      }
      catch (Exception e)
      {
        throw new BOSException(e);
      }
      String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
      
      StringBuffer insertSql = new StringBuffer();
      insertSql.append("INSERT INTO ").append(tempTableName).append(" (FBizDate,FPROJECTID,FMaterialID,FTrackNumberID,FStorageOrgUnitID) ").append(" SELECT FAUDITTIME FBizDate,FProjectID,FMaterialID,FTrackID,FStorageOrgUnitID FROM T_MM_ManufactureOrder M ").append(" WHERE EXISTS(").append(" SELECT 1 fROM T_MM_ManufactureOrder M1 ").append(" WHERE M.FProjectID=M1.FProjectID AND M.FMaterialID=M1.FMaterialID AND M.FStorageOrgUnitID=M1.FStorageOrgUnitID ").append(" AND (M.FTrackID is null and M1.FTrackID is null or M.FTrackID=M1.FTrackID ) ").append(" AND M1.FID IN (").append(idStr).append(" )").append(" AND M.FBaseStatus=").append(4).append(" )");
      
      DbUtil.execute(ctx, insertSql.toString());
      
      WriteBackWBSFacadeControllerBean wbsFacade = new WriteBackWBSFacadeControllerBean();
      wbsFacade.batchWriteBackByDate(ctx, tempTableName, bizAction, WBSTypeEnum.MANUFACTURE);
    }
    finally
    {
      TempTablePool pool;
      if (tempTableName != null)
      {
         pool = TempTablePool.getInstance(ctx);
        pool.releaseTable(tempTableName);
      }
    }
  }
  
  private void afterAudit(Context ctx, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    String idStr = SQLUtil.arrayToString(batchResults.getToDoIdsArray());
    updateCostObject(ctx, batchResults);
    String[] sqls = new String[6];
    StringBuffer updateSql = new StringBuffer();
    
    updateSql.append("update T_MM_ManufactureOrder ").append("set FUnToStoreQty =  FExtraUpperLimit-FToStroreQty,FUnToStoreBaseQty = FExtraUpperLimitBase-FToStoreBaseQty ").append("where FID in (").append(idStr).append(") ").append("and FIsLimitedQty=1 ");
    
    sqls[0] = updateSql.toString();
    updateSql.setLength(0);
    
    updateSql.append("update T_MM_ManufactureOrder ").append("set FUnToStoreQty = FQty-FTotalSplitQty-FToStroreQty,FUnToStoreBaseQty = FBaseQty-FTotalSplitBaseQty-FToStoreBaseQty ").append("where FID in (").append(idStr).append(") ").append("and FIsLimitedQty=0 ");
    
    sqls[1] = updateSql.toString();
    
    updateSql.setLength(0);
    updateSql.append("update T_MM_ManufactureOrder ").append("set FUnRepairQty = FQty-FTotalSplitQty-FRepairQty,FUnRepairBaseQty = FBaseQty-FTotalSplitBaseQty-FRepairBaseQty ").append("where FID in (").append(idStr).append(") ");
    
    sqls[2] = updateSql.toString();
    
    updateSql.setLength(0);
    updateSql.append("update T_MM_MFTOrderStock as t0 ").append("set (FUnReceiptQty,FUnReceiptBaseQty,FUnIssueQty,FUnIssueBaseQty,FAssociateQty) = ").append("(select t0.FPlannedQty-t0.FTotalReceiptQty,t0.FPlannedBaseQty-t0.FTotalReceiptBaseQty,t0.FPlannedQty-t0.FActIssueQty+t0.FRejectedQty,t0.FPlannedBaseQty-t0.FActIssueBaseQty+t0.FRejectedBaseQty,").append(" case when t0.FIsQtyLimit=1 then ").append("round(to_decimal(t0.FPickExtraBaseQty,21,8),b1.FQtyPrecision)-t0.FActIssueBaseQty+t0.FRejectedBaseQty ").append(" else t0.FPlannedBaseQty-t0.FActIssueBaseQty+t0.FRejectedBaseQty ").append(" end ").append("from t_bd_multimeasureunit  b1 ").append("where t0.FMaterialID = b1.FMaterialID and t0.FBaseUnitID = b1.fmeasureunitid) ").append(" where t0.FParentID in (").append(idStr).append(") ");
    
    sqls[3] = updateSql.toString();
    
    updateSql.setLength(0);
    
    updateSql.append("update T_MM_MFTOrderTechnics as t0  ").append("set (FUnFinishQty,FUnFinishBaseQty,FUnMoveOutQty,FUnMoveOutBaseQty,FUnTestQty,FUnTestBaseQty,FUnDispatchQty,FUnDispatchBaseQty) = ").append("(select t0.FQty, t0.FBaseQty,t0.FQty,t0.FBaseQty,t0.FQty,t0.FBaseQty,").append("t0.FQTY - t0.FTotalSplitQty - t0.FTotalDispatchQty,").append("round(decimal((t0.FQTY - t0.FTotalSplitQty - t0.FTotalDispatchQty) * t2.FBaseConvsRate,21,8),t3.FQtyPrecision)").append(" from t_bd_multimeasureunit t2 , T_MM_ManufactureOrder t1 ,t_bd_multimeasureunit t3 ").append("where t0.FParentID = t1.FID ").append(" and t1.FMaterialID = t2.FMaterialID and t1.FUnitID = t2.fmeasureunitid ").append(" and t1.FMaterialID = t3.FMaterialID and t1.FBaseUnitID = t3.fmeasureunitid ").append("and t1.FID in (").append(idStr).append(") ").append(")");
    
    sqls[4] = updateSql.toString();
    
    updateSql.setLength(0);
    updateSql.append("update T_MM_MFTOrderTechnics as t0  ").append("set (FIntoQty,FIntoBaseQty) = ").append("(select t0.FQty,t0.FBaseQty ").append("from T_MM_ManufactureOrder t1 ").append("where t1.FFirstOperNo = t0.FOperationNo ").append("and t1.FID = t0.FParentID ").append("and t1.FID in (").append(idStr).append(") ").append(") ");
    
    sqls[5] = updateSql.toString();
    try
    {
      SQLUtil.batchExecuteSql(ctx, sqls);
    }
    catch (BOSException bosException)
    {
      Throwable throwable = bosException.getCause();
      if ((throwable instanceof SQLException))
      {
        String sqlState = ((SQLException)throwable).getSQLState();
        String message = ((SQLException)throwable).getMessage();
        if ((sqlState != null) && (sqlState.equalsIgnoreCase("22003"))) {
          throw new ManufactureOrderException(ManufactureOrderException.NUMERIC_VALUE_OUT_OF_RANGE);
        }
        if ((message != null) && (message.toLowerCase().indexOf("numeric") > -1)) {
          throw new ManufactureOrderException(ManufactureOrderException.NUMERIC_VALUE_OUT_OF_RANGE);
        }
      }
      throw bosException;
    }
  }
  
  protected Map _getMaterialRelationData(Context ctx, Map inParam, boolean getlot)
    throws BOSException, EASBizException
  {
    MaterialInfo materialInfo = (MaterialInfo)inParam.get("MATERIAL");
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    
    Map retData = new HashMap();
    if ((materialInfo != null) && (storageOrgUnit != null))
    {
      String materialID = materialInfo.getId().toString();
      String storageOrgUnitID = storageOrgUnit.getId().toString();
      ProductTransactionTypeInfo transInfo = (ProductTransactionTypeInfo)inParam.get("TRANSTYPE");
      if (inParam.get("BASEUNIT") == null) {
        inParam.put("BASEUNIT", materialInfo.getBaseUnit());
      }
      getMaterialPlanData(ctx, materialInfo, storageOrgUnit, inParam, retData, getlot);
      
      Object isBOMChangeObject = inParam.get("IsBOMChange");
      if ((isBOMChangeObject == null) || (!((Boolean)isBOMChangeObject).booleanValue())) {
        getBOMInfoInBomExpand(ctx, null, inParam);
      }
      MOUntil.getDefaultRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
      if (retData != null)
      {
        ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
        inParam.put("TECHNICS", techCol);
        retData.put("TECHNICS", techCol);
      }
      getDefaultBOM(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
      
      getExpectOutput(ctx, inParam, retData);
    }
    return retData;
  }
  
  protected Map _getMaterialRelationDataForLot(Context ctx, Map inParam, boolean getlot)
    throws BOSException, EASBizException
  {
    MaterialInfo materialInfo = (MaterialInfo)inParam.get("MATERIAL");
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    
    Map retData = new HashMap();
    if ((materialInfo != null) && (storageOrgUnit != null))
    {
      inParam.put("BASEUNIT", materialInfo.getBaseUnit());
      
      getMaterialPlanData(ctx, materialInfo, storageOrgUnit, inParam, retData, getlot);
    }
    return retData;
  }
  
  private void getMaterialPlanData(Context ctx, MaterialInfo materialInfo, StorageOrgUnitInfo storageOrgUnit, Map inParam, Map outParam, boolean getlot)
    throws BOSException, EASBizException
  {
    String materialID = materialInfo.getId().toString();
    String storageOrgUnitID = storageOrgUnit.getId().toString();
    MeasureUnitInfo baseUnit = (MeasureUnitInfo)inParam.get("BASEUNIT");
    Timestamp endDate = (Timestamp)inParam.get("ENDTIME");
    SCMEntryDataVO vo = new SCMEntryDataVO();
    SCMEntryDataVO voResult = new SCMEntryDataVO();
    vo.setMaterialInfos(new MaterialInfo[] { materialInfo });
    vo.setStorageOrgUnitInfos(new StorageOrgUnitInfo[] { storageOrgUnit });
    vo.setIsLoadingMaterialPlan(true);
    vo.setIsLoadingMaterialInventory(true);
    vo.setIsLoadingMaterialInfo(false);
    voResult = SCMGroupFacadeFactory.getLocalInstance(ctx).loadComplexData(vo);
    
    String param = "false";
    boolean isIsModifiable = false;
    
    Map miInfoMap = voResult.getMaterialInventoryInfos();
    
    Map mpInfoMap = voResult.getMaterialPlanInfos();
    String key = materialID + storageOrgUnitID;
    MeasureUnitInfo[] measureUnitInfos = new MeasureUnitInfo[1];
    if (inParam.get("BILL_UNIT") == null)
    {
      measureUnitInfos[0] = baseUnit;
      MaterialPlanInfo mpInfo = (MaterialPlanInfo)mpInfoMap.get(key);
      if ((mpInfo != null) && (mpInfo.getProductUnit() != null))
      {
        measureUnitInfos[0] = mpInfo.getProductUnit();
        measureUnitInfos[0] = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(measureUnitInfos[0].getId()));
        
        inParam.put("BILL_UNIT", measureUnitInfos[0]);
      }
    }
    else
    {
      measureUnitInfos[0] = ((MeasureUnitInfo)inParam.get("BILL_UNIT"));
    }
    if ((mpInfoMap != null) && (mpInfoMap.get(key) != null))
    {
      MaterialPlanInfo mpInfo = (MaterialPlanInfo)mpInfoMap.get(key);
      AdminOrgUnitInfo adminOrgInfo = (AdminOrgUnitInfo)inParam.get("adminOrgUnit");
      String adinOrgID = "";
      if (adminOrgInfo != null) {
        adinOrgID = adminOrgInfo.getId().toString();
      }
      if ((mpInfo.getDutyDepartment() != null) && (mpInfo.getDutyDepartment().getId() != null))
      {
        String strDutyId = mpInfo.getDutyDepartment().getId().toString();
        if ((mpInfo.getDutyDepartment().getName() == null) && (!adinOrgID.equals(strDutyId)))
        {
          IAdminOrgFacade adminOrgFacade = AdminOrgFacadeFactory.getLocalInstance(ctx);
          AdminOrgUnitInfo adminInfo = adminOrgFacade.getComByOrgId(mpInfo.getDutyDepartment().getId().toString());
          mpInfo.setDutyDepartment(adminInfo);
          inParam.put("adminOrgUnit", mpInfo.getDutyDepartment());
          outParam.put("adminOrgUnit", mpInfo.getDutyDepartment());
        }
        else
        {
          outParam.put("adminOrgUnit", adminOrgInfo);
        }
      }
      else
      {
        outParam.put("adminOrgUnit", adminOrgInfo);
      }
    }
    if ((miInfoMap != null) && (miInfoMap.get(key) != null))
    {
      MaterialInventoryInfo materialInv = (MaterialInventoryInfo)voResult.getMaterialInventoryInfos().get(key);
      if (materialInv.getDefaultWarehouse() != null)
      {
        SelectorItemCollection sic = new SelectorItemCollection();
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        WarehouseInfo defaultWarehouse = (WarehouseInfo)WarehouseFactory.getLocalInstance(ctx).getValue(new ObjectStringPK(materialInv.getDefaultWarehouse().getId().toString()), sic);
        
        outParam.put("DEFAULTWAREHOUSE", defaultWarehouse);
      }
      if (materialInv.isIsLotNumber())
      {
        param = "true";
        LotFrames lotFrame = null;
        Connection conn = null;
        try
        {
          conn = EJBFactory.getConnection(ctx);
          LotRuleInfo lotRule = getProperLotRule(ctx, conn, materialID, storageOrgUnitID);
          lotFrame = new LotFrames();
          lotFrame.setLotRule(lotRule);
          lotFrame.setSysDate(new java.util.Date());
          
          lotFrame.setBizDate(new java.util.Date());
          
          lotFrame.setMaterial(materialInfo.getNumber());
          
          lotFrame.setMfg(endDate);
          if ((lotRule != null) && (getlot))
          {
            long currentSerial = LotRuleServerUtils.updateLotRuleAssign(ctx, materialID, lotRule);
            lotFrame.setCurrentSerial(currentSerial);
          }
          outParam.put("lotRule", lotRule);
        }
        catch (SQLException e)
        {
          throw new BOSException(e);
        }
        finally
        {
          SQLUtils.cleanup(conn);
        }
        String lotnumber = null;
        if ((lotFrame != null) && (lotFrame.getLotRule() != null))
        {
          lotnumber = lotFrame.getLotNumber();
          
          isIsModifiable = lotFrame.getLotRule().isIsModifiable();
        }
        outParam.put("LOTNUMBER", lotnumber);
      }
    }
    outParam.put("COSTOBJECT", MOCostObjectUtil.getCostObject(ctx, materialInfo, storageOrgUnit, null, null, false, true));
    
    outParam.put("param", param);
    
    outParam.put("ISISMODIFIABLE", new Boolean(isIsModifiable));
    
    vo.setIsLoadingMou(true);
    vo.setIsLoadingMmuPrecision(true);
    vo.setIsLoadingMaterialPlan(false);
    vo.setIsLoadingMaterialInventory(false);
    vo.setMeasureUnitInfos(measureUnitInfos);
    vo.setBaseMeasureUnitInfos(new MeasureUnitInfo[] { baseUnit });
    vo.setAssistMeasureUnitInfos(new MeasureUnitInfo[] { null });
    voResult = SCMGroupFacadeFactory.getLocalInstance(ctx).loadComplexData(vo);
    voResult.setMaterialInventoryInfos(miInfoMap);
    voResult.setMaterialPlanInfos(mpInfoMap);
    
    outParam.put("VO_ENTRY", voResult);
    
    inParam.put("VO_ENTRY", voResult);
  }
  
  private void getSpecialRouting(Context ctx, String materialID, String storageOrgUnitID, ProductTransactionTypeInfo transInfo, Map inParam, Map outParam)
    throws BOSException, EASBizException
  {
    String tmpRouting = MOUntil.getMainRouting(ctx, materialID, storageOrgUnitID);
    if (tmpRouting != null)
    {
      outParam.put("ROUTING", StandardRootingFactory.getLocalInstance(ctx).getStandardRootingInfo(new ObjectUuidPK(tmpRouting)));
      inParam.put("ROUTINGID", tmpRouting);
      ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
      outParam.put("TECHNICS", techCol);
    }
    else
    {
      StandardRootingInfo rooting = MORootingUtil.getDefaultRooting(ctx, transInfo, storageOrgUnitID);
      if (rooting != null)
      {
        outParam.put("ROUTING", rooting);
        
        inParam.put("ROUTINGID", rooting.getId().toString());
        ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
        outParam.put("TECHNICS", techCol);
      }
    }
  }
  
  private void getDefaultBOM(Context ctx, String materialID, String storageOrgUnitID, ProductTransactionTypeInfo transInfo, Map inParam, Map outParam)
    throws BOSException, EASBizException
  {
    BomInfo bom = null;
    if (inParam.get("BOM") != null) {
      bom = (BomInfo)inParam.get("BOM");
    }
    if ((transInfo == null) || (transInfo.getBizType() == null)) {
      throw new ManufactureOrderException(ManufactureOrderException.NO_TRANINFO);
    }
    if ((transInfo.getBizType().getId().toString().equals("vGXRx5fFSsCYz9Zv7CzzgyQHQ1w=")) && (bom != null))
    {
      ManufactureOrderStockCollection stocks = _bomExpand(ctx, inParam);
      outParam.put("STOCKS", stocks);
    }
    else if (transInfo.getBizType().getId().toString().equals("yRPu9BAfSRuIIEu9QnyxviQHQ1w="))
    {
      SCMEntryDataVO voResult = (SCMEntryDataVO)inParam.get("VO_ENTRY");
      
      String key = materialID + storageOrgUnitID;
      MaterialPlanInfo mpInfo = (MaterialPlanInfo)voResult.getMaterialPlanInfos().get(key);
      
      MeasureUnitInfo bill_unit = (MeasureUnitInfo)inParam.get("BILL_UNIT");
      key = materialID + bill_unit.getId().toString();
      Integer unitPrec = new Integer(4);
      if ((voResult != null) && (voResult.getMmuPrecisions() != null) && (voResult.getMmuPrecisions().get(key) != null)) {
        unitPrec = (Integer)voResult.getMmuPrecisions().get(key);
      }
      inParam.put("UNITPREC", unitPrec);
      inParam.put("MATERIALPLAN", mpInfo);
      ManufactureOrderStockCollection stocks = productRepairExpand(ctx, inParam);
      ManufactureOrderStockCollection bomStocks = new ManufactureOrderStockCollection();
      if (((inParam.get("IsTransTypeChange") == null) || (!((Boolean)inParam.get("IsTransTypeChange")).booleanValue())) && (inParam.get("BOM") != null))
      {
        inParam.put("RECALC", Boolean.TRUE);
        bomStocks = _bomExpand(ctx, inParam);
        if (inParam.get("ROUTINGID") != null)
        {
          String tmpRouting = (String)inParam.get("ROUTINGID");
          outParam.put("ROUTING", StandardRootingFactory.getLocalInstance(ctx).getStandardRootingInfo(new ObjectUuidPK(tmpRouting)));
        }
        stocks.addCollection(bomStocks);
        inParam.put("RECALC", Boolean.FALSE);
      }
      outParam.put("STOCKS", stocks);
    }
    else if ((transInfo.getBizType().getId().toString().equals("kEpCaLX+s6fgQAB/AQBdzSQHQ1w=")) && (bom != null))
    {
      ManufactureOrderStockCollection stocks = _bomExpand(ctx, inParam);
      outParam.put("STOCKS", stocks);
    }
    if (inParam.get("ROUTINGID") != null)
    {
      String tmpRouting = (String)inParam.get("ROUTINGID");
      outParam.put("ROUTING", StandardRootingFactory.getLocalInstance(ctx).getStandardRootingInfo(new ObjectUuidPK(tmpRouting)));
    }
    outParam.put("BOM", bom);
    ManufactureOrderStockCollection stocks = (ManufactureOrderStockCollection)outParam.get("STOCKS");
    if (stocks != null)
    {
      stocks = getDistinctStocks(stocks);
      outParam.put("STOCKS", stocks);
    }
  }
  
  protected Map _getRoutingData(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    MaterialInfo materialInfo = (MaterialInfo)inParam.get("MATERIAL");
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    ProductTransactionTypeInfo transInfo = (ProductTransactionTypeInfo)inParam.get("TRANSTYPE");
    
    Map retData = new HashMap();
    if (inParam.get("ROUTINGID") != null)
    {
      if ((inParam.get("isReplaced") == null) || ((inParam.get("isReplaced") != null) && (!((Boolean)inParam.get("isReplaced")).booleanValue()))) {
        MOUntil.getDefaultRouting(ctx, materialInfo.getId().toString(), storageOrgUnit.getId().toString(), transInfo, inParam, retData);
      }
      if (retData != null)
      {
        ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
        inParam.put("TECHNICS", techCol);
        retData.put("TECHNICS", techCol);
      }
    }
    if ((inParam.get("BOM") != null) && (!((Boolean)inParam.get("IsRoutingChange")).booleanValue())) {
      if ((transInfo != null) && (transInfo.getBizType() != null) && (transInfo.getBizType().getId() != null) && (transInfo.getBizType().getId().toString().equals("vGXRx5fFSsCYz9Zv7CzzgyQHQ1w=")))
      {
        ManufactureOrderStockCollection stockCol = _bomExpand(ctx, inParam);
        if (stockCol != null) {
          stockCol = getDistinctStocks(stockCol);
        }
        retData.put("STOCKS", stockCol);
      }
    }
    if (!((Boolean)inParam.get("IsRoutingChange")).booleanValue()) {
      getExpectOutput(ctx, inParam, retData);
    }
    return retData;
  }
  
  protected ManufactureOrderTechnicsCollection _routingExpand(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    IOrgUnitRelation iUnitRel = OrgUnitRelationFactory.getLocalInstance(ctx);
    ManufactureOrderTechnicsCollection technicsCol = new ManufactureOrderTechnicsCollection();
    String routingID = (String)inParam.get("ROUTINGID");
    if (routingID == null) {
      return null;
    }
    StandardRootingInfo routing = StandardRootingFactory.getLocalInstance(ctx).getStandardRootingInfo(new ObjectStringPK(routingID));
    StorageOrgUnitInfo storageOrgUnitInfo = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    Timestamp beginDate = (Timestamp)inParam.get("BEGINTIME");
    Timestamp endDate = (Timestamp)inParam.get("ENDTIME");
    MeasureUnitInfo baseUnit = (MeasureUnitInfo)inParam.get("BASEUNIT");
    MeasureUnitInfo bill_unit = (MeasureUnitInfo)inParam.get("BILL_UNIT");
    BigDecimal bill_qty = (BigDecimal)inParam.get("BILL_QTY");
    MaterialInfo material = (MaterialInfo)inParam.get("MATERIAL");
    MaterialPlanInfo materialPlan = (MaterialPlanInfo)inParam.get("MATERIALPLAN");
    AdminOrgUnitInfo adminOrg = (AdminOrgUnitInfo)inParam.get("adminOrgUnit");
    
    SCMEntryDataVO voResult = (SCMEntryDataVO)inParam.get("VO_ENTRY");
    
    String key = material.getId().toString() + bill_unit.getId().toString();
    int unitPrec = 4;
    if ((voResult != null) && (voResult.getMmuPrecisions() != null) && (voResult.getMmuPrecisions().get(key) != null)) {
      unitPrec = ((Integer)voResult.getMmuPrecisions().get(key)).intValue();
    }
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filterInfo = new FilterInfo();
    filterInfo.getFilterItems().add(new FilterItemInfo("parent", "SELECT FMaterialRootingID FROM t_mm_standardrooting where fid = '" + routingID + "' ", CompareType.INNER));
    
    viewInfo.setFilter(filterInfo);
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("workCenter.id"));
    sic.add(new SelectorItemInfo("workCenter.number"));
    sic.add(new SelectorItemInfo("workCenter.name"));
    sic.add(new SelectorItemInfo("workCenter.classTeam.id"));
    sic.add(new SelectorItemInfo("workCenter.classTeam.number"));
    sic.add(new SelectorItemInfo("workCenter.adminOrgUnit.id"));
    sic.add(new SelectorItemInfo("workCenter.adminOrgUnit.name"));
    sic.add(new SelectorItemInfo("workCenter.adminOrgUnit.number"));
    sic.add(new SelectorItemInfo("controlStrategy.id"));
    sic.add(new SelectorItemInfo("controlStrategy.number"));
    sic.add(new SelectorItemInfo("controlStrategy.name"));
    sic.add(new SelectorItemInfo("controlStrategy.status"));
    sic.add(new SelectorItemInfo("controlStrategy.opCheckGenType"));
    sic.add(new SelectorItemInfo("controlStrategy.inWareHsGenType"));
    sic.add(new SelectorItemInfo("controlStrategy.entrustType"));
    sic.add(new SelectorItemInfo("controlStrategy.cooStorageOrgUnit.id"));
    sic.add(new SelectorItemInfo("controlStrategy.cooStorageOrgUnit.number"));
    sic.add(new SelectorItemInfo("controlStrategy.cooStorageOrgUnit.name"));
    sic.add(new SelectorItemInfo("operation.id"));
    sic.add(new SelectorItemInfo("operation.name"));
    sic.add(new SelectorItemInfo("operation.number"));
    sic.add(new SelectorItemInfo("operation.status"));
    
    sic.add(new SelectorItemInfo("entrustType"));
    
    sic.add(new SelectorItemInfo("entrustSupplier.id"));
    sic.add(new SelectorItemInfo("entrustSupplier.name"));
    sic.add(new SelectorItemInfo("entrustSupplier.number"));
    
    sic.add(new SelectorItemInfo("cooStorageOrgUnit.id"));
    sic.add(new SelectorItemInfo("cooStorageOrgUnit.number"));
    sic.add(new SelectorItemInfo("cooStorageOrgUnit.name"));
    
    sic.add(new SelectorItemInfo("childRooting.id"));
    sic.add(new SelectorItemInfo("childRooting.name"));
    sic.add(new SelectorItemInfo("childRooting.number"));
    
    sic.add(new SelectorItemInfo("operationRemark"));
    
    sic.add(new SelectorItemInfo("remark"));
    
    viewInfo.setSelector(sic);
    SorterItemCollection sor = new SorterItemCollection();
    sor.add(new SorterItemInfo("wpSeq"));
    viewInfo.setSorter(sor);
    IMRWorkProcesEntry iWorkprocess = MRWorkProcesEntryFactory.getLocalInstance(ctx);
    CoreBaseCollection wkCol = iWorkprocess.getCollection(viewInfo);
    if ((wkCol != null) && (wkCol.size() > 0))
    {
      Map operMap = new HashMap();
      
      WorkCenterCollection workCenters = null;
      for (int i = 0; i < wkCol.size(); i++)
      {
        MRWorkProcesEntryInfo wkInfo = (MRWorkProcesEntryInfo)wkCol.get(i);
        ManufactureOrderTechnicsInfo techInfo = new ManufactureOrderTechnicsInfo();
        techInfo.setEarlistWoktime(beginDate);
        techInfo.setEarlistCmpTime(endDate);
        techInfo.setLastWorktime(beginDate);
        techInfo.setLastCmpTime(endDate);
        if ((routing != null) && ("-".equalsIgnoreCase(routing.getNumber())))
        {
          if ((adminOrg == null) && (storageOrgUnitInfo != null))
          {
            OrgUnitCollection adminOrgCol = iUnitRel.getToUnit(storageOrgUnitInfo.getId().toString(), 4, 0);
            if ((adminOrgCol != null) && (adminOrgCol.size() > 0)) {
              adminOrg = (AdminOrgUnitInfo)adminOrgCol.get(0);
            }
          }
          techInfo.setOperationRemark(null);
          if ((material != null) && (materialPlan == null)) {
            materialPlan = getMaterialPlanInfo(ctx, material, storageOrgUnitInfo);
          }
          if (materialPlan != null)
          {
            if (materialPlan.isIsReportingLimit()) {
              techInfo.setOverrunMeasure(OverRunMeasureEnum.REFUSE);
            } else {
              techInfo.setOverrunMeasure(OverRunMeasureEnum.NOT_CONTROL);
            }
            techInfo.setTotalQtyUpper(NumericUtil.emptyToZero(materialPlan.getRptInHightLimit()));
            techInfo.setTotalQtyLower(NumericUtil.emptyToZero(materialPlan.getRptInLowLimit()));
          }
        }
        else
        {
          techInfo.setOverrunMeasure(wkInfo.getOverrunMeasure());
          techInfo.setTotalQtyUpper(wkInfo.getRealProductQtyHigh());
          techInfo.setTotalQtyLower(wkInfo.getRealProductQtyLow());
        }
        WorkCenterInfo workCenter = wkInfo.getWorkCenter();
        if ((workCenter == null) && (adminOrg != null))
        {
          EntityViewInfo workCenterView = new EntityViewInfo();
          FilterInfo workCenterFilter = new FilterInfo();
          workCenterFilter.getFilterItems().add(new FilterItemInfo("adminOrgUnit", adminOrg.getId().toString(), CompareType.EQUALS));
          
          workCenterFilter.getFilterItems().add(new FilterItemInfo("storageOrgUnit", storageOrgUnitInfo.getId().toString(), CompareType.EQUALS));
          
          workCenterFilter.getFilterItems().add(new FilterItemInfo("status", new Integer(20), CompareType.EQUALS));
          
          workCenterFilter.getFilterItems().add(new FilterItemInfo("isDepartment", "1", CompareType.EQUALS));
          
          SelectorItemCollection workCenterSic = new SelectorItemCollection();
          workCenterSic.add(new SelectorItemInfo("id"));
          workCenterSic.add(new SelectorItemInfo("number"));
          workCenterSic.add(new SelectorItemInfo("name"));
          workCenterSic.add(new SelectorItemInfo("status"));
          workCenterSic.add(new SelectorItemInfo("isDepartment"));
          workCenterSic.add(new SelectorItemInfo("adminOrgUnit.id"));
          workCenterSic.add(new SelectorItemInfo("adminOrgUnit.number"));
          workCenterSic.add(new SelectorItemInfo("adminOrgUnit.name"));
          workCenterSic.add(new SelectorItemInfo("storageOrgUnit.id"));
          workCenterSic.add(new SelectorItemInfo("storageOrgUnit.number"));
          workCenterSic.add(new SelectorItemInfo("storageOrgUnit.name"));
          workCenterView.setFilter(workCenterFilter);
          workCenterView.setSelector(workCenterSic);
          
          workCenters = WorkCenterFactory.getLocalInstance(ctx).getWorkCenterCollection(workCenterView);
          if ((workCenters != null) && (workCenters.size() > 0)) {
            workCenter = workCenters.get(0);
          }
        }
        techInfo.setWorkcenter(workCenter);
        if (workCenter != null) {
          adminOrg = workCenter.getAdminOrgUnit();
        }
        techInfo.setAdminOrgUnit(adminOrg);
        BigDecimal zero = SCMConstant.BIGDECIMAL_ZERO;
        techInfo.setFinishedQty(zero);
        techInfo.setIntoQty(zero);
        techInfo.setOutQty(zero);
        techInfo.setTestQty(zero);
        techInfo.setPassQty(zero);
        techInfo.setScrapQty(zero);
        techInfo.setRepairQty(zero);
        techInfo.setRepReportQty(zero);
        techInfo.setRepMoveInQty(zero);
        techInfo.setRepMoveOutQty(zero);
        
        BigDecimal totalQtyUpper = new BigDecimal("1.0").add(techInfo.getTotalQtyUpper().divide(new BigDecimal("100.00"), 4, 4)).setScale(unitPrec, 4);
        
        BigDecimal totalUpperQty = bill_qty.multiply(totalQtyUpper).setScale(unitPrec, 4);
        techInfo.setTotalUpperQty(totalUpperQty);
        
        techInfo.setConcessionQty(zero);
        techInfo.setConcessionBaseQty(zero);
        
        techInfo.setTotalMaterialScrapQty(zero);
        techInfo.setTotalManufactureScrapQty(zero);
        
        techInfo.setTotalSplitQty(zero);
        
        techInfo.setTotalDispatchQty(zero);
        
        techInfo.setUnDispatchQty(bill_qty);
        techInfo.setUnit(bill_unit);
        techInfo.setBaseUnit(baseUnit);
        
        techInfo.setQty(bill_qty);
        
        techInfo.setOperQty(bill_qty);
        
        techInfo.setEntrustType(wkInfo.getEntrustType() == null ? CSEntrustTypeEnum.NONE : wkInfo.getEntrustType());
        
        techInfo.setEntrustSupplier(wkInfo.getEntrustSupplier());
        
        techInfo.setSubRouting(wkInfo.getChildRooting());
        
        techInfo.setTheoreticalLaborCost(wkInfo.getLaborCost() == null ? zero : wkInfo.getLaborCost());
        techInfo.setActualLaborCost(techInfo.getTheoreticalLaborCost());
        techInfo.setTheoreticalScrapLaborCost(wkInfo.getScrapLaborCost() == null ? zero : wkInfo.getScrapLaborCost());
        techInfo.setActualScrapLaborCost(techInfo.getTheoreticalScrapLaborCost());
        techInfo.setTheoreticalMatScrapLaborCost(wkInfo.getMatScrapLaborCost() == null ? zero : wkInfo.getMatScrapLaborCost());
        techInfo.setActualMatScrapLaborCost(techInfo.getTheoreticalMatScrapLaborCost());
        techInfo.setValuationType(wkInfo.getValuationType());
        techInfo.setOperation(wkInfo.getOperation());
        techInfo.setOperationNo(wkInfo.getWpSeq());
        techInfo.setTimeUnit(wkInfo.getTimeUnit());
        techInfo.setIsCheckPoint(wkInfo.isIsCheckPoint());
        techInfo.setIsKeyOP(wkInfo.isIsImportantWP());
        
        techInfo.setIsReportPoint(wkInfo.isIsReportPoint());
        techInfo.setQueuingTime(wkInfo.getQueueTime());
        techInfo.setPrepareTime(wkInfo.getPreparedTime());
        techInfo.setWaitingTime(wkInfo.getWaittingTime());
        techInfo.setWorkTime(wkInfo.getMachiningTime());
        techInfo.setMovingTime(wkInfo.getTransferTime());
        techInfo.setProcessBatch(wkInfo.getProcessBatch());
        ControlStrategyInfo cs = wkInfo.getControlStrategy();
        techInfo.setControlStrategy(cs);
        
        techInfo.setOperationRemark(wkInfo.getOperationRemark(getLocale()), getLocale());
        
        techInfo.setRemark(wkInfo.getRemark());
        if ((techInfo.getEntrustType() == CSEntrustTypeEnum.NONE) || (techInfo.getEntrustType() == CSEntrustTypeEnum.OPERATIONENTRUST)) {
          techInfo.setStorageOrgUnit(storageOrgUnitInfo);
        } else {
          techInfo.setStorageOrgUnit(wkInfo.getCooStorageOrgUnit());
        }
        if ((routing != null) && ("-".equalsIgnoreCase(routing.getNumber())))
        {
          if ((techInfo.getAdminOrgUnit() == null) && (techInfo.getStorageOrgUnit() != null))
          {
            OrgUnitCollection adminOrgCol = iUnitRel.getToUnit(techInfo.getStorageOrgUnit().getId().toString(), 4, 0);
            if ((adminOrgCol != null) && (adminOrgCol.size() > 0))
            {
              AdminOrgUnitInfo adminOrgUnit = (AdminOrgUnitInfo)adminOrgCol.get(0);
              techInfo.setAdminOrgUnit(adminOrgUnit);
            }
          }
          techInfo.setOperationRemark(null);
          
          techInfo.setRemark(null);
        }
        technicsCol.add(techInfo);
        if (i == wkCol.size() - 1) {
          techInfo.setIsPickingPoint(true);
        } else {
          techInfo.setIsPickingPoint(false);
        }
        operMap.put(new Integer(techInfo.getOperationNo()), techInfo.getOperation());
      }
      inParam.put("OPERMAP", operMap);
    }
    MMCommonUtils.objectValueSort(technicsCol, true, "operationNo");
    return technicsCol;
  }
  
  private ManufactureOrderStockCollection productRepairExpand(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    String expandTablName = createTempTable(ctx);
    try
    {
      MaterialPlanInfo mpInfo = (MaterialPlanInfo)inParam.get("MATERIALPLAN");
      MaterialInfo materialInfo = (MaterialInfo)inParam.get("MATERIAL");
      MeasureUnitInfo bill_unit = (MeasureUnitInfo)inParam.get("BILL_UNIT");
      MeasureUnitInfo baseUnit = (MeasureUnitInfo)inParam.get("BASEUNIT");
      BigDecimal bill_qty = (BigDecimal)inParam.get("BILL_QTY");
      BigDecimal issInHightLimit = new BigDecimal(mpInfo.getIssInHightLimit().longValue());
      BigDecimal issInLowLimit = new BigDecimal(mpInfo.getIssInLowLimit().longValue());
      Integer unitPrec = (Integer)inParam.get("UNITPREC");
      StringBuffer sqlBuf = new StringBuffer();
      sqlBuf.append("insert into ").append(expandTablName).append(" ").append("\r\n").append("(fmaterialid,funitid,fbaseunitid,fPrec,FReplaceMode,").append("FIssMode,FIsBackFlush,FIsQuotaControl,FIssInHightLimit,FIssInLowLimit,FBlueprint,FBOMDefWarehouseID,").append("FRoutingItemID,FMaterialAttr,").append("funitQty,fQty,fPlannedQty,fscrapQty,fscrapRate,FScrapRateExpression,fid) ").append("\r\n").append("VALUES(").append("'").append(materialInfo.getId().toString()).append("',").append("'").append(bill_unit.getId().toString()).append("',").append("'").append(baseUnit.getId().toString()).append("',").append(unitPrec.intValue()).append(",0,").append(mpInfo.getIssMode().getValue()).append(",").append(mpInfo.isIsBackFlush() ? 1 : 0).append(",").append(mpInfo.isIsQuotaControl() ? 1 : 0).append(",").append(issInHightLimit).append(",").append(issInLowLimit).append(",NULL,NULL,NULL,").append(mpInfo.getMaterialAttr().getValue()).append(",").append("1,").append(bill_qty).append(",").append(bill_qty).append(",0,0,").append(mpInfo.getScrapRateExpression().getValue()).append(",newbosid('12345678'))");
      
      DbUtil.execute(ctx, sqlBuf.toString());
      inParam.put("RECALC", Boolean.FALSE);
      inParam.put("TABLENAME", expandTablName);
      TempTablePool pool;
      return buildStock(ctx, inParam);
    }
    finally
    {
      if (expandTablName != null)
      {
        TempTablePool pool = TempTablePool.getInstance(ctx);
        pool.releaseTable(expandTablName);
      }
    }
  }
  
  private String createTempTable(Context ctx)
    throws BOSException, EASBizException
  {
    String expandTablName = null;
    TempTablePool pool = TempTablePool.getInstance(ctx);
    try
    {
      StringBuffer sqlBuf = new StringBuffer();
      sqlBuf.append("create table bomexpand (").append("\r\n").append("fid varchar(44) not null,").append("\r\n").append("fmaterialid varchar(44) null,").append("\r\n").append("fbaseunitid varchar(44) null,").append("\r\n").append("funitQty numeric(21,8) not null default 0,").append("\r\n").append("FBomEntryID varchar(44) null, ").append("\r\n").append("FProvideType int, ").append("\r\n").append("FDemandTime datetime null ,").append("\r\n").append("FTrackNumberID varchar(44) null,").append("\r\n").append("FProjectID varchar(44) null, ").append("\r\n").append("FSupplyStorageId varchar(44) null, ").append("\r\n").append("funitid varchar(44) null,").append("\r\n").append("FReplaceMode int null, ").append("\r\n").append("FBlueprint nvarchar(1000) null, ").append("\r\n").append("FIsBackFlush int  null, ").append("\r\n").append("fscrapRate numeric(21,8) not null default 0,").append("\r\n").append("FIssMode int  null, ").append("\r\n").append("FNetWeight numeric(21,8) null, ").append("\r\n").append("FBOMDefWarehouseID varchar(44) null, ").append("\r\n").append("FLocationID varchar(44) null ,").append("\r\n").append("FBlkSize nvarchar(255) null, ").append("\r\n").append("FSpecifiedLength nvarchar(255) null, ").append("\r\n").append("FScrapRateExpression int null,").append("\r\n").append("FMaterialAttr int  not null default 0,").append("\r\n").append("FIsQuotaControl int  null, ").append("\r\n").append("FIssInHightLimit numeric(21,8) null, ").append("\r\n").append("FIssInLowLimit numeric(21,8) null, ").append("\r\n").append("fPrec int  not null default 0, ").append("\r\n").append("fQty numeric(21,8) not null default 0,").append("\r\n").append("fPlannedQty numeric(21,8) not null default 0,").append("\r\n").append("fscrapQty numeric(21,8) not null default 0, ").append("\r\n").append("FRoutingItemID varchar(44) null, ").append("\r\n").append("fOperationNo int null").append("\r\n").append(")");
      
      expandTablName = pool.createTempTable(sqlBuf.toString());
    }
    catch (Exception e1)
    {
      throw new BOSException(e1);
    }
    return expandTablName;
  }
  
  protected ManufactureOrderStockCollection _bomExpand(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    String locStr = LocaleUtils.getLocaleString(ctx.getLocale());
    StringBuffer sqlBuf = new StringBuffer();
    ManufactureOrderStockCollection materialStock = new ManufactureOrderStockCollection();
    
    String bomID = ((BomInfo)inParam.get("BOM")).getId().toString();
    
    BomInfo bomInfo = BomFactory.getLocalInstance(ctx).getBomInfo(new ObjectStringPK(bomID));
    BOMTypeEnum type = bomInfo.getBomType();
    
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    String storageOrgId = storageOrgUnit.getId().toString();
    
    String beginDate = null;
    if (inParam.get("BEGINTIME") != null)
    {
      beginDate = MRPUtil.dateToString((Timestamp)inParam.get("BEGINTIME"), "yyyy-MM-dd");
    }
    else
    {
      Calendar calDate = Calendar.getInstance();
      calDate.set(11, 0);
      calDate.set(12, 0);
      calDate.set(13, 0);
      calDate.set(14, 0);
      IFactoryCalendar calendarFactory = FactoryCalendarFactory.getLocalInstance(ctx);
      
      Timestamp workDate = setWorkDate(calendarFactory, storageOrgUnit.getId().toString(), new java.util.Date(calDate.getTimeInMillis()), true);
      beginDate = MRPUtil.dateToString(workDate, "yyyy-MM-dd");
    }
    if (inParam.get("ENDTIME") == null) {
      inParam.put("ENDTIME", inParam.get("BEGINTIME"));
    }
    String mainMaterial = ((MaterialInfo)inParam.get("MATERIAL")).getId().toString();
    
    MeasureUnitInfo mainUnitInfo = (MeasureUnitInfo)inParam.get("BILL_UNIT");
    
    MeasureUnitInfo mainBaseUnitInfo = (MeasureUnitInfo)inParam.get("BASEUNIT");
    
    String expandTablName = createTempTable(ctx);
    String inTableName = null;
    
    String projectID = null;
    String trackID = null;
    String tmp_projectID = null;
    String tmp_trackID = null;
    if (inParam.get("projectID") != null)
    {
      projectID = ((ProjectInfo)inParam.get("projectID")).getId().toString();
      tmp_projectID = projectID;
    }
    else
    {
      projectID = "999999999";
    }
    if (inParam.get("trackID") != null)
    {
      trackID = ((TrackNumberInfo)inParam.get("trackID")).getId().toString();
      tmp_trackID = trackID;
    }
    else
    {
      trackID = "999999999";
    }
    try
    {
      PBOMInfo pbomInfo = null;
      if (inParam.get("PBOMID") != null)
      {
        String pBOMID = (String)inParam.get("PBOMID");
        pbomInfo = (PBOMInfo)PBOMFactory.getLocalInstance(ctx).getObjectBaseInfo(new ObjectUuidPK(pBOMID));
      }
      String bomEntryID;
      BigDecimal bill_qty;
      if (pbomInfo != null)
      {
        Object isBOMChangeObject = inParam.get("IsBOMChange");
        if ((isBOMChangeObject != null) && (((Boolean)isBOMChangeObject).booleanValue()))
        {
          inParam.put("RECALC", Boolean.TRUE);
          BomInfo opbomInfo = (BomInfo)BomFactory.getLocalInstance(ctx).getObjectBaseInfo(new ObjectUuidPK(pbomInfo.getBom().getId().toString()));
          
          inParam.put("BOMMaterial", opbomInfo.getMaterial());
        }
        PBOMEntryCollection pBOMEntryCollection = pbomInfo.getPbomEntry();
        for (int i = 0; i < pBOMEntryCollection.size(); i++)
        {
          PBOMEntryInfo pBomEntryInfo = pBOMEntryCollection.get(i);
          bomEntryID = pBomEntryInfo.getId().toString();
          String bomItemID = pBomEntryInfo.getBomItem().getId().toString();
          String routingItemID = pBomEntryInfo.getRoutingItem().getId().toString();
          
          sqlBuf.setLength(0);
          sqlBuf.append("insert into " + expandTablName + " ").append("\r\n").append("(FID, fmaterialid, fbaseunitid, funitQty, FBomEntryID, FProvideType, FDemandTime, ").append("FTrackNumberID, FProjectID, FSupplyStorageId, ").append("\r\n").append("funitid, FReplaceMode, FBlueprint, FIsBackFlush, fscrapRate, FIssMode, FNetWeight, ").append("FBOMDefWarehouseID, FLocationID, FBlkSize, FSpecifiedLength, ").append("\r\n").append("FScrapRateExpression, FMaterialAttr, FIsQuotaControl, FIssInHightLimit, FIssInLowLimit, ").append("fPrec, FRoutingItemID) ").append("\r\n");
          
          sqlBuf.append("select newbosid('12345678'), T2.fmaterialid, T2.fbaseunitid, T1.funitQty, T2.FID, ").append("\tT2.FProvideType, to_date('" + beginDate + "'), '" + trackID + "', '" + projectID + "', ").append("\tT2.FSupplyStorageOrgUnitID, T2.funitid, T2.FReplaceMode, T2.FBlueprint_" + locStr + ", T2.FIsBackFlush, ").append("\tto_decimal(T2.FScrapRatio/100,21,8), T2.FIssMode, T2.FNetWeight, T2.FDefaultWarehouseID, ").append("\tT2.FLocationID, T2.FBlkSize, T2.FSpecifiedLength, T3.FScrapRateExpression, T3.FMaterialAttr, ").append("\tT3.FIsQuotaControl, T3.FIssInHightLimit, T3.FIssInLowLimit, T4.FQtyPrecision, '" + routingItemID + "'").append("\r\n").append("from (select T12.FTrackNumberID, T12.FProjectID, T11.funitQty, T11.FBomItemId, T11.fid, T11.FRoutingItemID ").append("\tfrom t_mm_pbomentry T11 inner join t_mm_pbom T12 on T11.FParentID=T12.Fid ").append("\twhere T11.fid = '" + bomEntryID + "') T1 ").append("\r\n").append("inner join (select T21.FID, T21.fmaterialid, T21.fbaseunitid, T21.FProvideType, T21.FSupplyStorageOrgUnitID, ").append("\tT21.funitid, T21.FReplaceMode, T21.FBlueprint_" + locStr + ", T21.FIsBackFlush, ").append("\tT21.FScrapRatio, T21.FIssMode, T21.FNetWeight, T21.FDefaultWarehouseID, ").append("\tT21.FLocationID, T21.FBlkSize, T21.FSpecifiedLength, T21.FEffectiveDate, ").append("\tT21.FDisableDate, T21.FLeadtime, T21.FOutputType ").append("\r\n").append("\tfrom t_mm_bomentry T21 left join t_mm_bom T22 on T21.fparentid = T22.fid ").append("\twhere T21.fid = '" + bomItemID + "') T2 ").append("\ton T1.FBomItemId = T2.FID ").append("\r\n").append("left join t_bd_materialplan T3 on T2.fmaterialid = T3.fmaterialid").append("\tand T3.forgunit = '" + storageOrgId + "' ").append("\r\n").append("left join T_BD_MultiMeasureUnit T4 on T2.fmaterialid = T4.fmaterialid and T2.funitid = T4.FMeasureUnitID ").append("\r\n").append("where T1.FRoutingItemID = '" + routingItemID + "'");
          
          sqlBuf.append("\tand T2.FOutputType in (10710,10740) ").append("\tand T2.FEffectiveDate <= to_date('" + beginDate + "')  ").append("\tand T2.FDisableDate > to_date('" + beginDate + "')  ").append("\r\n");
          
          DbUtil.execute(ctx, sqlBuf.toString());
        }
      }
      else
      {
        inTableName = createinTempTable(ctx);
        
        bill_qty = (BigDecimal)inParam.get("BILL_QTY");
        
        Object isBOMChangeObject = inParam.get("IsBOMChange");
        if ((isBOMChangeObject != null) && (((Boolean)isBOMChangeObject).booleanValue()))
        {
          inParam.put("RECALC", Boolean.TRUE);
          inParam.put("BOMMaterial", bomInfo.getMaterial());
        }
        if ((bill_qty == null) || (bill_qty.compareTo(new BigDecimal("0.00")) == 0)) {
          bill_qty = new BigDecimal("0.00");
        }
        BigDecimal unitBill_qty = SCMUtils.getExchangePrecisionQtyForServer(ctx, mainMaterial, mainUnitInfo, mainBaseUnitInfo, bill_qty);
        
        sqlBuf.setLength(0);
        if (isAppointBOM(inParam.get("IsAppointBOM"))) {
          sqlBuf.append("insert into " + inTableName + " ").append("(FStorageorgUnitID, FBOMID, FMaterialID, FDate, FBaseQty) ").append(" values ('" + storageOrgId + "', '" + bomID + "', '" + mainMaterial + "', to_date('" + beginDate + "'), ").append("to_decimal(" + unitBill_qty + ",21,8))");
        } else {
          sqlBuf.append("insert into " + inTableName + " ").append("(FStorageorgUnitID, FBOMID, FMaterialID, FDate, FBaseQty, FTraceID, FProjectID, FTrackNumberID) ").append(" values ('" + storageOrgId + "', '" + bomID + "', '" + mainMaterial + "', to_date('" + beginDate + "'), ").append("to_decimal(" + unitBill_qty + ",21,8), '" + tmp_trackID + "', '" + tmp_projectID + "', '" + tmp_trackID + "')");
        }
        DbUtil.execute(ctx, sqlBuf.toString());
        
        String outTableName = BOMExtendFacadeFactory.getLocalInstance(ctx).getBOMExpandResult(inTableName, true);
        if (outTableName == null)
        {
          TempTablePool pool;
          return null;
        }
        sqlBuf.setLength(0);
        sqlBuf.append("insert into " + expandTablName + " ").append("\r\n").append("(FID, fmaterialid, fbaseunitid, funitQty, FBomEntryID, FProvideType, FDemandTime, ").append("FTrackNumberID, FProjectID, FSupplyStorageId, ").append("\r\n").append("funitid, FReplaceMode, FBlueprint, FIsBackFlush, fscrapRate, FIssMode, FNetWeight, ").append("FBOMDefWarehouseID, FLocationID, FBlkSize, FSpecifiedLength, ").append("\r\n").append("FScrapRateExpression, FMaterialAttr, FIsQuotaControl, FIssInHightLimit, FIssInLowLimit, ").append("fPrec, FRoutingItemID, fOperationNo,fQty) ").append("\r\n");
        
        sqlBuf.append("select newbosid('12345678'), T1.FChildMaterialID, T1.fBaseUnitId, T1.FUnitQty, ").append("\r\n").append("\tT1.fBomEntryId, T1.FProvideType, T1.fDate, '" + trackID + "', '" + projectID + "', ").append("\tT1.FSupplyStorageOrgUnitID, T2.funitid, T2.FReplaceMode, T2.FBlueprint_" + locStr + ", T2.FIsBackFlush, ").append("\tto_decimal(T2.FScrapRatio/100,21,8), T2.FIssMode, T2.FNetWeight, T2.FDefaultWarehouseID, ").append("\tT2.FLocationID, T2.FBlkSize, T2.FSpecifiedLength, T3.FScrapRateExpression, T3.FMaterialAttr, ").append("\tT3.FIsQuotaControl, T3.FIssInHightLimit, T3.FIssInLowLimit, T4.FQtyPrecision, null, T1.fOperationNo, ").append("\tT1.FPerfectProductQty").append("\r\n").append("from " + outTableName + " T1 ").append("\r\n").append("inner join (select T21.FID, ").append("\tT21.FConsumeType, T21.FConsumeFixQty, T22.FPRODUCTBASEQTY, ").append("\tT21.fbaseproductrate, T21.FBASERATE, T21.FPROPORTION, T22.FPRODUCTQTY, ").append("\tT21.funitid, T21.FReplaceMode, T21.FBlueprint_" + locStr + ", T21.FIsBackFlush, ").append("\tT21.FScrapRatio, T21.FIssMode, T21.FNetWeight, T21.FDefaultWarehouseID, ").append("\tT21.FLocationID, T21.FBlkSize, T21.FSpecifiedLength, T21.FOutputType, ").append("\tT21.FEffectiveDate, T21.FDisableDate, T21.FLeadtime ").append("\r\n").append("\tfrom t_mm_bomentry T21 left join t_mm_bom T22 on T21.fparentid = T22.fid ").append("\twhere T22.FStorageOrgUnitID = '" + storageOrgId + "' ) T2 ").append("\ton T1.fBomEntryId = T2.FID ").append("\r\n").append("left join t_bd_materialplan T3 on T1.FChildMaterialID = T3.fmaterialid").append("\tand T3.forgunit = '" + storageOrgId + "' ").append("\r\n").append("left join T_BD_MultiMeasureUnit T4 on T1.FChildMaterialID = T4.fmaterialid and T2.funitid = T4.FMeasureUnitID ").append("\r\n").append("where T2.FOutputType in (10710,10740) ");
        if ((!isAppointBOM(inParam.get("IsAppointBOM"))) && 
          (type.getValue() != 40)) {
          sqlBuf.append(" and isnull(T1.FTraceID, '999999999')= '").append(trackID).append("' ");
        }
        sqlBuf.append("\tand T2.FEffectiveDate <= to_date('" + beginDate + "')  ").append("\tand T2.FDisableDate > to_date('" + beginDate + "')  ").append("\r\n");
        
        MRPUtil.executeUpdate(ctx, sqlBuf.toString());
      }
      inParam.put("TABLENAME", expandTablName);
      
      materialStock = buildStock(ctx, inParam);
      TempTablePool pool;
      return materialStock;
    }
    finally
    {
      TempTablePool pool = TempTablePool.getInstance(ctx);
      if (expandTablName != null) {
        pool.releaseTable(expandTablName);
      }
      if (inTableName != null) {
        pool.releaseTable(inTableName);
      }
    }
  }
  
  private BigDecimal calcCconvertRate(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    BigDecimal convertRate = new BigDecimal("1.00");
    
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    MaterialInfo parentMaterial = (MaterialInfo)inParam.get("MATERIAL");
    MeasureUnitInfo billUnit = (MeasureUnitInfo)inParam.get("BILL_UNIT");
    String prodUnitID = null;
    StringBuffer sql = new StringBuffer();
    sql.append("select FProductUnitID from t_bd_materialplan where fmaterialid = ? and forgunit = ?");
    
    Object isBOMChangeObject = inParam.get("IsBOMChange");
    if ((isBOMChangeObject != null) && (((Boolean)isBOMChangeObject).booleanValue()) && (inParam.get("BOMMaterial") != null))
    {
      MaterialInfo bomMaterial = (MaterialInfo)inParam.get("BOMMaterial");
      IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { bomMaterial.getId().toString(), storageOrgUnit.getId().toString() });
      try
      {
        if (rs.next()) {
          prodUnitID = rs.getString("FProductUnitID");
        }
      }
      catch (SQLException e)
      {
        throw new SQLDataException(e);
      }
      convertRate = MOMultiMeasureUnitUtil.getConvertRate(ctx, parentMaterial.getId().toString(), billUnit.getId().toString(), bomMaterial.getId().toString(), prodUnitID);
    }
    else
    {
      IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { parentMaterial.getId().toString(), storageOrgUnit.getId().toString() });
      try
      {
        if (rs.next()) {
          prodUnitID = rs.getString("FProductUnitID");
        }
      }
      catch (SQLException e)
      {
        throw new SQLDataException(e);
      }
      if (!prodUnitID.equals(billUnit.getId().toString()))
      {
        BigDecimal billunit_ConRate = null;
        BigDecimal produnit_ConRate = null;
        sql.setLength(0);
        sql.append("select FBaseConvsRate,FQtyPrecision,FMeasureUnitID ").append("from T_BD_MultiMeasureUnit ").append("where fmaterialid = ? and (FMeasureUnitID = ? or FMeasureUnitID = ?)");
        
        rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { parentMaterial.getId().toString(), billUnit.getId().toString(), prodUnitID });
        try
        {
          while (rs.next()) {
            if (rs.getString("FMeasureUnitID").equals(prodUnitID)) {
              produnit_ConRate = rs.getBigDecimal("FBaseConvsRate");
            } else {
              billunit_ConRate = rs.getBigDecimal("FBaseConvsRate");
            }
          }
        }
        catch (SQLException e)
        {
          throw new SQLDataException(e);
        }
        if ((billunit_ConRate != null) && (produnit_ConRate != null)) {
          convertRate = billunit_ConRate.divide(produnit_ConRate, 8, 4);
        }
      }
    }
    return convertRate;
  }
  
  private ManufactureOrderStockCollection buildStock(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    String locStr = LocaleUtils.getLocaleString(ctx.getLocale());
    String tableName = (String)inParam.get("TABLENAME");
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    Timestamp beginDate = (Timestamp)inParam.get("BEGINTIME");
    ProductTransactionTypeInfo transInfo = (ProductTransactionTypeInfo)inParam.get("TRANSTYPE");
    
    boolean reCalc = true;
    if (inParam.get("RECALC") != null) {
      reCalc = ((Boolean)inParam.get("RECALC")).booleanValue();
    }
    BigDecimal bill_qty = null;BigDecimal convertRate = null;
    if (reCalc)
    {
      bill_qty = (BigDecimal)inParam.get("BILL_QTY");
      convertRate = calcCconvertRate(ctx, inParam);
    }
    Map operMap = new HashMap();
    if (inParam.get("OPERMAP") != null) {
      operMap = (Map)inParam.get("OPERMAP");
    }
    ManufactureOrderStockCollection stockCol = new ManufactureOrderStockCollection();
    
    StringBuffer sqlBuf = new StringBuffer();
    sqlBuf.append("select t0.*, ").append("t1.fnumber fmaterialnumber,t1.fname_").append(locStr).append(" fmaterialname,fmodel,").append("t2.fnumber funitnumber,t2.fname_").append(locStr).append(" funitname, ").append("t6.FWpSeq, ").append("t0.FNETWEIGHT FNETWEIGHT,t0.FBlkSize FBlkSize,t0.FSpecifiedLength FSpecifiedLength, ").append("t7.FIsStockAllot FIsStockAllot, location.fid flocationid,location.fname_").append(locStr).append(" flocationname, ").append("location.fnumber flocationnumber ").append(", be.FProvideType as FBProvideType, t7.FProvideType as FMProvideType ").append(", be.FSupplyStorageOrgUnitID as FBSupplyStorageOrgUnitID, t7.FSupplyOrgUnit as FMSupplyOrgUnit ").append(", be.FIsStockTransfer FIsStockTransfer ").append(", be.FTransferOrgUnitID FTransferOrgUnitID, t7.FFromInvOrgID as FMFromInvOrgID ").append(", be.FTransferWarehouseID FTransferWarehouseID, t7.FFromWarehouseID as FMFromWarehouseID").append(", be.FDefaultWarehouseID FDefaultWarehouseID ").append(", t3.FDefaultWarehouseID materialWarehouseID ").append(", t4.FDefaultWarehouseID spanWarehouseID ").append(" from ").append(tableName).append(" t0 ").append("inner join t_bd_material t1 on t0.fmaterialid = t1.fid ").append("inner join T_BD_MeasureUnit t2 on t0.funitid = t2.fid ").append("left outer join T_MM_MaterialRWP t6 on t0.FRoutingItemID = t6.FID ").append("left outer join t_bd_materialinventory t3 ").append("on t0.fmaterialid = t3.fmaterialid and t3.FOrgUnit = '").append(storageOrgUnit.getId().toString()).append("' ").append("left outer join t_bd_materialinventory t4 ").append("on t0.fmaterialid = t4.fmaterialid and t4.FOrgUnit = t0.fsupplystorageId ").append("left outer join T_BD_MaterialPlan t7 on t0.fmaterialid = t7.fmaterialid and t7.FOrgUnit = '").append(storageOrgUnit.getId().toString()).append("' ").append("left outer join T_mm_bomentry be on be.fid = t0.FBOMEntryID ").append("left outer join T_DB_LOCATION location on location.fid = t0.FLocationID ").append("where t0.FMaterialAttr <> 10020");
    
    IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
    try
    {
      int firstWP = 1;
      if (inParam.get("ROUTINGID") != null)
      {
        sqlBuf.setLength(0);
        sqlBuf.append("select t1.FFirstWP ").append("from T_MM_StandardRooting t0,T_MM_MaterialRooting t1 ").append("where t0.FMaterialRootingID = t1.FID ").append("and t0.FID = ?");
        
        IRowSet rsFirstWP = DbUtil.executeQuery(ctx, sqlBuf.toString(), new Object[] { inParam.get("ROUTINGID") });
        if (rsFirstWP.next()) {
          firstWP = rsFirstWP.getInt("FFirstWP");
        }
      }
      Map materialWarehouseMap = new HashMap();
      Object isAfreshExtendObject = inParam.get("isAfreshExtend");
      
      int lineSeq = 0;
      
      Map storageMap = new HashMap();
      
      Map warehouseMap = new HashMap();
      
      Map storage2CompanyMap = new HashMap();
      
      SelectorItemCollection sic = getDefaultSelector();
      
      SelectorItemCollection wareHouseSic = new SelectorItemCollection();
      wareHouseSic.add(new SelectorItemInfo("id"));
      wareHouseSic.add(new SelectorItemInfo("number"));
      wareHouseSic.add(new SelectorItemInfo("name"));
      wareHouseSic.add(new SelectorItemInfo("hasLocation"));
      
      CompanyOrgUnitInfo receiptCompanyOrgUnit = getCompanyInfo(ctx, storageOrgUnit.getId().toString(), storage2CompanyMap);
      while (rs.next())
      {
        ManufactureOrderStockInfo entry = new ManufactureOrderStockInfo();
        String bomEntryId = rs.getString("FBomEntryID");
        String supplyStorageOrgUnitId = null;
        if (isAfreshExtendObject != null)
        {
          if (((Boolean)isAfreshExtendObject).booleanValue())
          {
            if (!StringUtil.isEmpty(bomEntryId))
            {
              entry.setProvideType(MaterialProvideTypeEnum.getEnum(rs.getInt("FBProvideType")));
              supplyStorageOrgUnitId = rs.getString("FBSupplyStorageOrgUnitID");
            }
            else
            {
              entry.setProvideType(MaterialProvideTypeEnum.getEnum(rs.getInt("FMProvideType")));
              supplyStorageOrgUnitId = rs.getString("FMSupplyOrgUnit");
            }
          }
          else
          {
            entry.setProvideType(MaterialProvideTypeEnum.getEnum(rs.getInt("FProvideType")));
            supplyStorageOrgUnitId = rs.getString("FSupplyStorageId");
          }
        }
        else
        {
          entry.setProvideType(MaterialProvideTypeEnum.getEnum(rs.getInt("FBProvideType")));
          supplyStorageOrgUnitId = rs.getString("FBSupplyStorageOrgUnitID");
        }
        StorageOrgUnitInfo supplyStorageOrgUnitInfo = getOrgUnitInfo(ctx, supplyStorageOrgUnitId, storageMap, sic);
        entry.setStorageOrgUnit(supplyStorageOrgUnitInfo);
        if (!StringUtil.isEmpty(bomEntryId))
        {
          entry.setIsStockAllot(rs.getBoolean("FIsStockTransfer"));
          entry.setReceiptStroageOrgUnit(getOrgUnitInfo(ctx, rs.getString("FTransferOrgUnitID"), storageMap, sic));
          entry.setReceiptStock(getWarehouseInfo(ctx, rs.getString("FTransferWarehouseID"), warehouseMap, wareHouseSic));
        }
        else
        {
          entry.setIsStockAllot(rs.getBoolean("FIsStockAllot"));
          entry.setReceiptStroageOrgUnit(getOrgUnitInfo(ctx, rs.getString("FMFromInvOrgID"), storageMap, sic));
          entry.setReceiptStock(getWarehouseInfo(ctx, rs.getString("FMFromWarehouseID"), warehouseMap, wareHouseSic));
        }
        if ((entry.isIsStockAllot()) && (entry.getReceiptStroageOrgUnit() != null))
        {
          StorageOrgUnitInfo issueStorageOrgUnit = entry.getReceiptStroageOrgUnit();
          if (storageOrgUnit.getId().toString().equals(issueStorageOrgUnit.getId().toString()))
          {
            entry.setTransferType(OrderStockTransferTypeEnum.WAREHOUSE);
          }
          else
          {
            CompanyOrgUnitInfo issueCompanyOrgUnit = getCompanyInfo(ctx, issueStorageOrgUnit.getId().toString(), storage2CompanyMap);
            if ((receiptCompanyOrgUnit != null) && (issueCompanyOrgUnit != null) && (receiptCompanyOrgUnit.getId().toString().equals(issueCompanyOrgUnit.getId().toString()))) {
              entry.setTransferType(OrderStockTransferTypeEnum.STORAGE);
            } else {
              entry.setTransferType(OrderStockTransferTypeEnum.FINANCE);
            }
          }
        }
        else
        {
          entry.setTransferType(OrderStockTransferTypeEnum.NULL);
        }
        entry.setBomEntryID(rs.getString("FBomEntryID"));
        if (rs.getObject("FWpSeq") != null)
        {
          entry.setOperationNo(rs.getInt("FWpSeq"));
        }
        else if ((entry.getBomEntryID() != null) && (inParam.get(entry.getBomEntryID()) != null))
        {
          Object[] opo = (Object[])inParam.get(entry.getBomEntryID());
          
          Integer operationNo = (Integer)opo[0];
          
          OperationInfo opInfo = (OperationInfo)opo[1];
          entry.setOperationNo(operationNo.intValue());
          entry.setOperation(opInfo);
        }
        else if (rs.getObject("fOperationNo") != null)
        {
          Integer operNo = new Integer(rs.getInt("fOperationNo"));
          if (operMap.containsKey(operNo)) {
            entry.setOperationNo(operNo.intValue());
          } else {
            entry.setOperationNo(firstWP);
          }
        }
        else
        {
          entry.setOperationNo(firstWP);
        }
        entry.setIssueMode(MaterialIssueModeEnum.getEnum(rs.getInt("FIssMode")));
        
        entry.setIsBackflush(rs.getBoolean("FIsBackflush"));
        if (inParam.get("TECHNICS") != null)
        {
          ManufactureOrderTechnicsCollection techCol = (ManufactureOrderTechnicsCollection)inParam.get("TECHNICS");
          ManufactureOrderTechnicsInfo tech = null;
          int i = 0;
          for (int size = techCol.size(); i < size; i++)
          {
            tech = techCol.get(i);
            if ((tech != null) && (tech.getOperationNo() == entry.getOperationNo()) && ((tech.getEntrustType() == CSEntrustTypeEnum.INNERCOOPERATE) || (tech.getEntrustType() == CSEntrustTypeEnum.OPERATIONENTRUST)))
            {
              entry.setIsBackflush(false);
              break;
            }
          }
        }
        WarehouseInfo warehouseInfo = new WarehouseInfo();
        String defaultWarehouseID = rs.getString("FDefaultWarehouseID");
        if ((defaultWarehouseID != null) && (defaultWarehouseID.length() > 0))
        {
          warehouseInfo = getWarehouseInfo(ctx, defaultWarehouseID, warehouseMap, wareHouseSic);
          entry.setWarehouse(warehouseInfo);
        }
        else if (entry.isIsBackflush())
        {
          if ((transInfo != null) && (transInfo.getDefaultBFWarehouse() != null))
          {
            warehouseInfo = getWarehouseInfo(ctx, transInfo.getDefaultBFWarehouse().getId().toString(), warehouseMap, wareHouseSic);
            entry.setWarehouse(warehouseInfo);
          }
        }
        else if ((MaterialProvideTypeEnum.SPANORGPROVIDE.equals(entry.getProvideType())) || (MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE.equals(entry.getProvideType())))
        {
          if ((rs.getString("spanWarehouseID") != null) && (rs.getString("spanWarehouseID").length() > 0))
          {
            warehouseInfo = getWarehouseInfo(ctx, rs.getString("spanWarehouseID"), warehouseMap, wareHouseSic);
            entry.setWarehouse(warehouseInfo);
          }
        }
        else if ((rs.getString("materialWarehouseID") != null) && (rs.getString("materialWarehouseID").length() > 0))
        {
          warehouseInfo = getWarehouseInfo(ctx, rs.getString("materialWarehouseID"), warehouseMap, wareHouseSic);
          entry.setWarehouse(warehouseInfo);
        }
        if (((entry.getProvideType() == MaterialProvideTypeEnum.CURRENTORGPROVIDE) || (entry.getProvideType() == MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE)) && (entry.getIssueMode() == MaterialIssueModeEnum.PRODUCEISSMODE))
        {
          entry.setPickType(PickTypeEnum.INNERORG);
        }
        else if (entry.getProvideType() == MaterialProvideTypeEnum.SPANORGPROVIDE)
        {
          CompanyOrgUnitInfo issueCompanyOrgUnit = getCompanyInfo(ctx, supplyStorageOrgUnitId, storage2CompanyMap);
          if (receiptCompanyOrgUnit.getId().toString().equals(issueCompanyOrgUnit.getId().toString())) {
            entry.setPickType(PickTypeEnum.OTHERSTORAGE);
          } else {
            entry.setPickType(PickTypeEnum.OTHERCOMPANY);
          }
        }
        else
        {
          entry.setPickType(PickTypeEnum.NULL);
        }
        if (rs.getTimestamp("FDemandTime") != null) {
          entry.setDemandTime(rs.getTimestamp("FDemandTime"));
        } else {
          entry.setDemandTime(beginDate);
        }
        MaterialInfo material = new MaterialInfo();
        material.setId(BOSUuid.read(rs.getString("fmaterialid")));
        material.setName(rs.getString("fmaterialname"));
        material.setNumber(rs.getString("fmaterialnumber"));
        material.setModel(rs.getString("fmodel"));
        entry.setMaterial(material);
        
        entry.setNewnetWeight(rs.getBigDecimal("FNETWEIGHT"));
        
        entry.setBlkSize(rs.getString("FBlkSize"));
        
        entry.setSpecifiedLength(rs.getString("FSpecifiedLength"));
        
        MeasureUnitInfo unit = new MeasureUnitInfo();
        unit.setId(BOSUuid.read(rs.getString("funitid")));
        unit.setName(rs.getString("funitname"));
        unit.setNumber(rs.getString("funitnumber"));
        entry.setUnit(unit);
        
        MeasureUnitInfo baseunit = new MeasureUnitInfo();
        baseunit.setId(BOSUuid.read(rs.getString("fbaseunitid")));
        entry.setBaseUnit(baseunit);
        
        entry.setScrapExpr(rs.getInt("FScrapRateExpression"));
        
        entry.setIsQtyLimit(rs.getBoolean("FIsQuotaControl"));
        if (rs.getBoolean("FIsQuotaControl")) {
          entry.setExtraRatio(rs.getBigDecimal("FIssInHightLimit"));
        } else {
          entry.setExtraRatio(new BigDecimal("0.0"));
        }
        entry.setLackRatio(rs.getBigDecimal("FIssInLowLimit"));
        
        entry.setAssyLocation(rs.getString("FBlueprint"));
        
        int prec = rs.getInt("fPrec");
        if (reCalc)
        {
          BigDecimal unitQty = rs.getBigDecimal("funitQty").multiply(convertRate).setScale(8, 2);
          
          entry.setUnitQty(unitQty);
          
          BigDecimal lossRatio = rs.getBigDecimal("fscrapRate").multiply(new BigDecimal("100.00")).setScale(2, 2);
          
          entry.setLossRatio(lossRatio);
          
          BigDecimal qty = unitQty.multiply(bill_qty).setScale(prec, 2);
          
          BigDecimal tempQty = rs.getBigDecimal("fQty");
          if ((new BigDecimal("1.0").compareTo(convertRate) == 0) && (!BigDecimal.ZERO.equals(tempQty))) {
            qty = rs.getBigDecimal("fQty").setScale(prec, 2);
          }
          entry.setQty(qty);
          
          BigDecimal planedQty = qty;
          
          boolean isLoss = true;
          if ((transInfo != null) && (!transInfo.isIsConsiderLossRatio())) {
            isLoss = false;
          }
          if (rs.getInt("FScrapRateExpression") == 10610) {
            planedQty = qty.divide(new BigDecimal("1.0").subtract(rs.getBigDecimal("fscrapRate")), prec, 2);
          } else {
            planedQty = qty.multiply(new BigDecimal("1.0").add(rs.getBigDecimal("fscrapRate"))).setScale(prec, 2);
          }
          BigDecimal extraRatio = new BigDecimal("1.0").add(entry.getExtraRatio().divide(new BigDecimal("100.00"), 4, 4).setScale(prec, 4));
          
          BigDecimal lackRatio = new BigDecimal("1.0").subtract(entry.getLackRatio().divide(new BigDecimal("100.00"), 4, 4).setScale(prec, 4));
          
          BigDecimal pickExtraQty = planedQty.multiply(extraRatio).setScale(prec, 4);
          BigDecimal pickLackQty = planedQty.multiply(lackRatio).setScale(prec, 4);
          entry.setPickExtraQty(pickExtraQty);
          entry.setPickLackQty(pickLackQty);
          entry.setPlannedQty(planedQty);
          entry.setTotalReceiptQty(SCMConstant.BIGDECIMAL_ZERO);
          entry.setUnReceiptQty(planedQty);
          
          entry.setLossQty(planedQty.subtract(qty));
        }
        else
        {
          entry.setUnitQty(rs.getBigDecimal("funitQty"));
          entry.setQty(rs.getBigDecimal("fQty").setScale(prec, 2));
          entry.setPlannedQty(rs.getBigDecimal("fPlannedQty").setScale(prec, 2));
          entry.setLossQty(rs.getBigDecimal("fscrapQty").setScale(prec, 2));
          entry.setLossRatio(rs.getBigDecimal("fscrapRate"));
          entry.setUnReceiptQty(NumericUtil.emptyToZero(entry.getPlannedQty()));
        }
        entry.setOriginalPlanQty(entry.getPlannedQty());
        
        LocationInfo locInfo = null;
        if (warehouseInfo != null)
        {
          String locationId = rs.getString("flocationid");
          if (!StringUtils.isEmpty(locationId))
          {
            locInfo = new LocationInfo();
            locInfo.setId(BOSUuid.read(locationId));
            locInfo.setName(rs.getString("flocationname"));
            locInfo.setNumber(rs.getString("flocationnumber"));
          }
          else
          {
            if (entry.isIsBackflush()) {
              if ((transInfo != null) && (transInfo.getDefaultBFLocation() != null) && (transInfo.getDefaultBFWarehouse().getId().toString().equals(warehouseInfo.getId().toString()))) {
                locInfo = transInfo.getDefaultBFLocation();
              }
            }
            if ((locInfo == null) && (warehouseInfo.isHasLocation())) {
              materialWarehouseMap.put(rs.getString("fmaterialid"), warehouseInfo.getId().toString());
            }
          }
        }
        entry.setLocation(locInfo);
        
        BigDecimal zero = SCMConstant.BIGDECIMAL_ZERO;
        
        entry.setActIssueQty(zero);
        
        entry.setActLossQty(zero);
        
        entry.setActureLossRatio(zero);
        
        entry.setRejectedQty(zero);
        
        entry.setFeedingQty(zero);
        
        entry.setMaterialFeedingQty(zero);
        
        entry.setScrapQty(zero);
        
        entry.setMaterialScrapQty(zero);
        
        entry.setWipQty(zero);
        
        entry.setTotalDirectReceiveQty(zero);
        
        entry.setTotalReceiptBaseQty(zero);
        
        entry.setReplaceRatio(SysConstant.BIGZERO);
        entry.setUnitReplaceQty(SysConstant.BIGZERO);
        entry.setMatReplaceType(MaterialReplaceTypeEnum.NONE);
        entry.setIsReplaced(false);
        
        lineSeq += 1;
        entry.setLineSeq(Integer.toString(lineSeq * 10));
        
        entry.setReplaceGroupFlag(0);
        
        stockCol.add(entry);
      }
      if (materialWarehouseMap.size() > 0)
      {
        Map retMap = getLocationMap(ctx, storageOrgUnit.getId().toString(), materialWarehouseMap);
        if ((retMap != null) && (retMap.size() > 0))
        {
          LocationInfo locInfo = null;
          for (int i = 0; i < stockCol.size(); i++)
          {
            MaterialInfo material = stockCol.get(i).getMaterial();
            WarehouseInfo warehouse = stockCol.get(i).getWarehouse();
            if ((material != null) && (warehouse != null))
            {
              String key = material.getId().toString() + warehouse.getId().toString();
              locInfo = (LocationInfo)retMap.get(key);
              if (stockCol.get(i).getLocation() == null) {
                stockCol.get(i).setLocation(locInfo);
              }
            }
          }
        }
      }
    }
    catch (SQLException e)
    {
      throw new SQLDataException(e);
    }
    setBaseUnitQtyForStock(ctx, stockCol);
    return stockCol;
  }
  
  private Map getLocationMap(Context ctx, String storageOrgId, Map map)
    throws EASBizException, BOSException
  {
    Map resultMap = new HashMap();
    Set keySet = map.keySet();
    for (Iterator iterator = keySet.iterator(); iterator.hasNext();)
    {
      String materialID = (String)iterator.next();
      String warehouseID = (String)map.get(materialID);
      LocationInfo loc = getDefaultLocation(ctx, storageOrgId, materialID, warehouseID);
      resultMap.put(materialID + warehouseID, loc);
    }
    return resultMap;
  }
  
  private LocationInfo getDefaultLocation(Context ctx, String storageOrgID, String materialID, String warehouseID)
    throws BOSException, EASBizException
  {
    if ((storageOrgID != null) && (materialID != null) && (warehouseID != null))
    {
      EntityViewInfo viewInfo = new EntityViewInfo();
      FilterInfo filterInfo = new FilterInfo();
      filterInfo.getFilterItems().add(new FilterItemInfo("STORAGEORG.ID", storageOrgID, CompareType.EQUALS));
      
      filterInfo.getFilterItems().add(new FilterItemInfo("isDefaultLocation", Boolean.TRUE));
      filterInfo.getFilterItems().add(new FilterItemInfo("WAREHOUSE.ID", warehouseID, CompareType.EQUALS));
      
      filterInfo.getFilterItems().add(new FilterItemInfo("MATERIAL.ID", materialID, CompareType.EQUALS));
      filterInfo.getFilterItems().add(new FilterItemInfo("storageAssignType", new Integer(0), CompareType.EQUALS));
      
      StringBuffer maskString = new StringBuffer("( ");
      
      MaterialGroupInfo materialGroupInfo = getMaterialGroupByMaterial(materialID, ctx);
      if (null != materialGroupInfo)
      {
        filterInfo.getFilterItems().add(new FilterItemInfo("materialGroup.id", materialGroupInfo.getId().toString(), CompareType.EQUALS));
        
        filterInfo.getFilterItems().add(new FilterItemInfo("storageAssignType", new Integer(1), CompareType.EQUALS));
        
        maskString.append(" #0 and #1 and #2  and (#3 and #4 or #5 and #6) ");
      }
      else
      {
        maskString.append(" #0 and #1 and #2  and #3 and #4");
      }
      maskString.append(" )");
      
      filterInfo.setMaskString(maskString.toString());
      viewInfo.setFilter(filterInfo);
      
      viewInfo.setFilter(filterInfo);
      SorterItemCollection sorter = new SorterItemCollection();
      SorterItemInfo item = new SorterItemInfo("material");
      item.setSortType(SortType.DESCEND);
      sorter.add(item);
      viewInfo.setSorter(sorter);
      IMaterialStorageAssign imsa = MaterialStorageAssignFactory.getLocalInstance(ctx);
      if (imsa != null)
      {
        IObjectPK[] pks = imsa.getPKList(filterInfo, null);
        ILocation il = LocationFactory.getLocalInstance(ctx);
        int recs = pks.length;
        if (recs > 0)
        {
          if (imsa.getMaterialStorageAssignInfo(pks[0]).getLocation() != null)
          {
            ObjectUuidPK pk = new ObjectUuidPK(imsa.getMaterialStorageAssignInfo(pks[0]).getLocation().getBOSUuid("id"));
            return il.getLocationInfo(pk);
          }
          return null;
        }
      }
    }
    return null;
  }
  
  public static MaterialGroupInfo getMaterialGroupByMaterial(String materialId, Context ctx)
    throws EASBizException, BOSException
  {
    MaterialInfo newMaterialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(materialId));
    if (null != newMaterialInfo) {
      return newMaterialInfo.getMaterialGroup();
    }
    return null;
  }
  
  private void setBaseUnitQtyForStock(Context ctx, ManufactureOrderStockCollection stockCol)
    throws BOSException
  {
    if ((stockCol == null) || (stockCol.size() == 0)) {
      return;
    }
    ManufactureOrderStockInfo stockInfo = null;
    HashSet keySet = new HashSet();
    String materialId = null;
    String unitId = null;
    String mmuKey = null;
    int filterIndex = 0;
    StringBuffer maskString = new StringBuffer();
    Map mmuMap = new HashMap();
    FilterInfo filter = new FilterInfo();
    
    int index = 0;
    for (int size = stockCol.size(); index < size; index++)
    {
      stockInfo = stockCol.get(index);
      materialId = stockInfo.getMaterial().getId().toString();
      unitId = stockInfo.getUnit().getId().toString();
      mmuKey = materialId + "!" + unitId;
      if (!keySet.contains(mmuKey))
      {
        filter.appendFilterItem("material", materialId);
        filter.appendFilterItem("measureUnit", unitId);
        keySet.add(mmuKey);
        if (filterIndex == 0) {
          maskString.append("(#").append(filterIndex++).append(" and #").append(filterIndex++).append(")");
        } else {
          maskString.append(" or (#").append(filterIndex++).append(" and #").append(filterIndex++).append(")");
        }
      }
    }
    EntityViewInfo view = new EntityViewInfo();
    filter.setMaskString(maskString.toString());
    view.setFilter(filter);
    view.getSelector().add("material");
    view.getSelector().add("measureUnit");
    view.getSelector().add("baseConvsRate");
    view.getSelector().add("qtyPrecision");
    MultiMeasureUnitCollection mmuCol = MultiMeasureUnitFactory.getLocalInstance(ctx).getMultiMeasureUnitCollection(view);
    
    int i = 0;
    for (int size = mmuCol.size(); i < size; i++)
    {
      MultiMeasureUnitInfo mmuInfo = mmuCol.get(i);
      mmuKey = mmuInfo.getMaterial().getId().toString() + "!" + mmuInfo.getMeasureUnit().getId().toString();
      mmuMap.put(mmuKey, mmuInfo);
    }
    index = 0;
    for (int size = stockCol.size(); index < size; index++)
    {
      stockInfo = stockCol.get(index);
      materialId = stockInfo.getMaterial().getId().toString();
      unitId = stockInfo.getUnit().getId().toString();
      mmuKey = materialId + "!" + unitId;
      MultiMeasureUnitInfo mmuInfo = (MultiMeasureUnitInfo)mmuMap.get(mmuKey);
      stockInfo.setUnitBaseQty(NumericUtil.emptyToZero(stockInfo.getUnitQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
      
      stockInfo.setBaseQty(NumericUtil.emptyToZero(stockInfo.getQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
      
      stockInfo.setPlannedBaseQty(NumericUtil.emptyToZero(stockInfo.getPlannedQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
      
      stockInfo.setLossBaseQty(NumericUtil.emptyToZero(stockInfo.getLossQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
      
      stockInfo.setUnReceiptBaseQty(NumericUtil.emptyToZero(stockInfo.getUnReceiptQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
      
      stockInfo.setPickExtraBaseQty(NumericUtil.emptyToZero(stockInfo.getPickExtraQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
      
      stockInfo.setPickLackBaseQty(NumericUtil.emptyToZero(stockInfo.getPickLackQty()).multiply(mmuInfo.getBaseConvsRate()).setScale(mmuInfo.getQtyPrecision(), 4));
    }
  }
  
  protected Map _getDefaultLocation(Context ctx, Map inParam)
    throws BOSException, EASBizException
  {
    String storageOrgID = (String)inParam.get("STORAGEORGID");
    Object[] materialIDs = (Object[])inParam.get("MATERIALIDS");
    Object[] warehouseIDs = (Object[])inParam.get("WAREHOUSEIDS");
    
    Map retParam = new HashMap();
    Map locMap = new HashMap();
    Map wareMap = new HashMap();
    if ((storageOrgID == null) || (materialIDs == null) || (warehouseIDs == null) || (materialIDs.length != warehouseIDs.length)) {
      return retParam;
    }
    wareMap = getWarehouse(ctx, warehouseIDs);
    StringBuffer sql = new StringBuffer();
    sql.append("select t0.FMaterialID,t0.FWarehouseID,t1.fid,t1.fnumber,t1.fname_").append(LocaleUtils.getLocaleString(ctx.getLocale())).append(" fname ").append("  from T_DB_MaterialStorageAssign t0,T_DB_LOCATION t1 ").append("where t1.fid = t0.FLocationID ").append("and t0.FStorageOrgID = '").append(storageOrgID).append("' ").append("and (");
    
    String conStr = "";
    for (int i = 0; i < materialIDs.length; i++)
    {
      sql.append(conStr).append("(t0.FMaterialID = '").append(materialIDs[i].toString()).append("' ").append("and t0.FWarehouseID = '").append(warehouseIDs[i].toString()).append("' ").append("and t0.FIsDefaultLocation = 1)");
      
      conStr = " or ";
    }
    sql.append(") ");
    IRowSet rsLoc = DbUtil.executeQuery(ctx, sql.toString());
    try
    {
      while (rsLoc.next())
      {
        LocationInfo locInfo = new LocationInfo();
        locInfo.setId(BOSUuid.read(rsLoc.getString("fid")));
        locInfo.setNumber(rsLoc.getString("fnumber"));
        locInfo.setName(rsLoc.getString("fname"));
        String key = rsLoc.getString("FMaterialID") + rsLoc.getString("FWarehouseID");
        locMap.put(key, locInfo);
      }
    }
    catch (SQLException e)
    {
      throw new SQLDataException(e);
    }
    retParam.put("location", locMap);
    retParam.put("warehouse", wareMap);
    return retParam;
  }
  
  private Map getWarehouse(Context ctx, Object[] warehouseIDs)
    throws BOSException, EASBizException
  {
    Map warehouse = new HashMap();
    String ids = "'null'";
    for (int i = 0; i < warehouseIDs.length; i++) {
      ids = ids + " , '" + warehouseIDs[i].toString() + "'";
    }
    WarehouseCollection warehouseCollection = WarehouseFactory.getLocalInstance(ctx).getWarehouseCollection(" where id in (" + ids + ")");
    for (Iterator iterator = warehouseCollection.iterator(); iterator.hasNext();)
    {
      WarehouseInfo wInfo = (WarehouseInfo)iterator.next();
      String key = wInfo.getId().toString();
      warehouse.put(key, wInfo);
    }
    return warehouse;
  }
  
  public void _handleAfterTransform(Context ctx, String action, IObjectCollection collection)
    throws EASBizException, BOSException
  {
    if ((null != collection) && (collection.size() > 0))
    {
      ManufactureOrderInfo mo = (ManufactureOrderInfo)collection.getObject(0);
      String sourceBillTypeID = mo.getSourceBillType().getId().toString();
      if ("9XXvbVGlRtym/0qtqeIXXrhE1B8=".equals(sourceBillTypeID)) {
        return;
      }
    }
    checkMaterilPlan(ctx, collection);
    for (int i = 0; i < collection.size(); i++)
    {
      ManufactureOrderInfo mo = (ManufactureOrderInfo)collection.getObject(i);
      String sourceBillTypeID = mo.getSourceBillType().getId().toString();
      String orgId = mo.getStorageOrgUnit().getId().toString();
      
      MaterialPlanInfo materialPlanInfo = getMaterialPlanInfo(ctx, mo.getMaterial(), mo.getStorageOrgUnit());
      
      SelectorItemCollection materialsic = new SelectorItemCollection();
      materialsic.add(new SelectorItemInfo("id"));
      materialsic.add(new SelectorItemInfo("number"));
      materialsic.add(new SelectorItemInfo("name"));
      MaterialInfo materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(mo.getMaterial().getId()), materialsic);
      mo.setMaterial(materialInfo);
      if (mo.getAdminOrgUnit() == null) {
        mo.setAdminOrgUnit(materialPlanInfo.getDutyDepartment());
      }
      if (mo.getDispatcher() == null) {
        mo.setDispatcher(materialPlanInfo.getPlanner());
      }
      if (mo.getPlanOrgUnit() == null) {
        mo.setPlanOrgUnit(materialPlanInfo.getPlanOrg());
      }
      ProductTransactionTypeInfo trnsType = null;
      if (sourceBillTypeID.equals("B2aZSVXaSx6qxdfekgCmrEY+1VI="))
      {
        ManufactureOrderInfo srcMOInfo = getManufactureOrderInfo(ctx, new ObjectUuidPK(BOSUuid.read(mo.getSourceBillId())));
        
        mo.setLongNumber(srcMOInfo.getLongNumber() + "!" + mo.getId().toString());
        trnsType = MOProductTransactionTypeUtil.getDefaultTransType(ctx, materialInfo, materialPlanInfo, mo.getStorageOrgUnit(), mo.getAdminOrgUnit(), "yRPu9BAfSRuIIEu9QnyxviQHQ1w=");
        
        mo.setTransactionType(trnsType);
        
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("material.id", mo.getMaterial().getId().toString(), CompareType.EQUALS));
        filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", mo.getStorageOrgUnit().getId().toString(), CompareType.EQUALS));
        EntityViewInfo viewer = new EntityViewInfo();
        viewer.setFilter(filter);
        
        SelectorItemCollection selector = new SelectorItemCollection();
        selector.add("isLotNumber");
        viewer.setSelector(selector);
        MaterialInventoryCollection inv = MaterialInventoryFactory.getLocalInstance(ctx).getMaterialInventoryCollection(viewer);
        if (inv.size() <= 0)
        {
          mo.setLot(null);
        }
        else
        {
          MaterialInventoryInfo invInfo = inv.get(0);
          if (!invInfo.isIsLotNumber())
          {
            mo.setLot(null);
          }
          else
          {
            LotParamValueInfo lotParamInfo = LotFacadeFactory.getLocalInstance(ctx).getLotParamValueByOrg(mo.getStorageOrgUnit().getId().toString());
            
            boolean isManufactureOrder = lotParamInfo.isManufactureOrder();
            
            boolean isPlanOrder = lotParamInfo.isManufacturePlan();
            if (isManufactureOrder)
            {
              if ((srcMOInfo.getLot() == null) || (srcMOInfo.getLot().trim().equals("")))
              {
                LotFrame lotFrame = LotRuleFactory.getLocalInstance(ctx).getLotFrameExtend(mo.getMaterial().getId().toString(), mo.getStorageOrgUnit().getId().toString());
                if ((lotFrame != null) && (lotFrame.getLotRule() != null))
                {
                  LotFrameManu lot = new LotFrameManu();
                  lot.setSeq(lotFrame.getSeq());
                  lot.setSysDate(lotFrame.getSysDate());
                  lot.setCurrentSerial(lotFrame.getCurrentSerial());
                  lot.setLotRule(lotFrame.getLotRule());
                  lot.setBillNumber(mo.getNumber());
                  lot.setMainBizOrg(mo.getStorageOrgUnit().getNumber());
                  lot.setMaterial(mo.getMaterial().getNumber());
                  
                  lot.setMfg(mo.getPlanEndDate());
                  String lotNo = lot.getLotNumber();
                  mo.setLot(lotNo);
                }
                else
                {
                  mo.setLot(null);
                }
              }
              else
              {
                mo.setLot(srcMOInfo.getLot().trim());
              }
            }
            else if (srcMOInfo.getLot() != null)
            {
              mo.setLot(srcMOInfo.getLot().trim());
            }
            else if (isPlanOrder)
            {
              LotFrame lotFrame = LotRuleFactory.getLocalInstance(ctx).getLotFrameExtend(mo.getMaterial().getId().toString(), mo.getStorageOrgUnit().getId().toString());
              if ((lotFrame != null) && (lotFrame.getLotRule() != null))
              {
                LotFrameManu lot = new LotFrameManu();
                lot.setSeq(lotFrame.getSeq());
                lot.setSysDate(lotFrame.getSysDate());
                lot.setCurrentSerial(lotFrame.getCurrentSerial());
                lot.setLotRule(lotFrame.getLotRule());
                lot.setBillNumber(mo.getNumber());
                lot.setMainBizOrg(mo.getStorageOrgUnit().getNumber());
                lot.setMaterial(mo.getMaterial().getNumber());
                
                lot.setMfg(mo.getPlanEndDate());
                String lotNo = lot.getLotNumber();
                mo.setLot(lotNo);
              }
              else
              {
                mo.setLot(null);
              }
            }
          }
        }
      }
      else if (sourceBillTypeID.equals("510b6503-0105-1000-e000-0113c0a812fd463ED552"))
      {
        trnsType = MOProductTransactionTypeUtil.getDefaultTransType(ctx, materialInfo, materialPlanInfo, mo.getStorageOrgUnit(), mo.getAdminOrgUnit(), "vGXRx5fFSsCYz9Zv7CzzgyQHQ1w=");
        
        mo.setTransactionType(trnsType);
        
        LotFrame lotFrame = new LotFrame();
        lotFrame.setMainBizOrg(mo.getStorageOrgUnit().getId().toString());
        lotFrame.setMaterial(mo.getMaterial().getId().toString());
        List<LotFrame> lotList = new ArrayList();
        lotList.add(lotFrame);
        lotList = LotRuleFactory.getLocalInstance(ctx).fillLotFramesNoSerial(lotList);
        if ((lotList != null) && (lotList.size() > 0)) {
          lotFrame = (LotFrame)lotList.get(0);
        }
        boolean isLotRule = false;
        if ((lotFrame != null) && (lotFrame.getLotRule() != null)) {
          isLotRule = true;
        }
        LotParamValueInfo lotParamInfo = LotFacadeFactory.getLocalInstance(ctx).getLotParamValueByOrg(mo.getStorageOrgUnit().getId().toString());
        
        boolean isManufacturePlan = lotParamInfo.isManufacturePlan();
        
        boolean isManufactureOrder = lotParamInfo.isManufactureOrder();
        if (isLotRule)
        {
          if (isManufactureOrder) {
            dealLotRule(ctx, mo);
          } else if (isManufacturePlan) {
            dealLotRule(ctx, mo);
          } else {
            mo.setLot(null);
          }
        }
        else {
          mo.setLot(null);
        }
        IFactoryCalendar calendarFactory = FactoryCalendarFactory.getLocalInstance(ctx);
        java.util.Date endDate = mo.getPlanEndDate();
        endDate.setDate(mo.getPlanEndDate().getDate() - materialPlanInfo.getRecevingLeadTime());
        
        mo.setPlanEndDate(setWorkDate(calendarFactory, mo.getStorageOrgUnit().getId().toString(), endDate, false));
        
        calculateDateUtil util = new calculateDateUtil();
        BigDecimal qty = mo.getQty() == null ? new BigDecimal("0.00") : mo.getQty();
        BigDecimal totalsplitQty = mo.getTotalSplitQty() == null ? new BigDecimal("0.00") : mo.getTotalSplitQty();
        Calendar calDate = Calendar.getInstance();
        calDate.set(11, 0);
        calDate.set(12, 0);
        calDate.set(13, 0);
        calDate.set(14, 0);
        java.util.Date nowDate = new java.util.Date(calDate.getTimeInMillis());
        if (mo.getPlanEndDate().before(nowDate))
        {
          mo.setPlanBeginDate(setWorkDate(calendarFactory, mo.getStorageOrgUnit().getId().toString(), nowDate, false));
          mo.setPlanEndDate(setWorkDate(calendarFactory, mo.getStorageOrgUnit().getId().toString(), nowDate, false));
        }
        else
        {
          java.util.Date startDate = util.getDate(ctx, mo.getStorageOrgUnit().getId().toString(), materialInfo.getId().toString(), null, mo.getPlanEndDate(), false, qty.subtract(totalsplitQty));
          
          Calendar calstartDate = Calendar.getInstance();
          calstartDate.setTime(startDate);
          calstartDate.set(11, 0);
          calstartDate.set(12, 0);
          calstartDate.set(13, 0);
          calstartDate.set(14, 0);
          mo.setPlanBeginDate(new Timestamp(calstartDate.getTimeInMillis()));
        }
      }
      else if (sourceBillTypeID.equals("9XXvbVGlRtym/0qtqeIXXrhE1B8="))
      {
        mo.setTransactionType(trnsType = MOProductTransactionTypeUtil.getDefaultTransType(ctx, materialInfo, materialPlanInfo, mo.getStorageOrgUnit(), mo.getAdminOrgUnit(), "vGXRx5fFSsCYz9Zv7CzzgyQHQ1w="));
      }
      if ((mo.getBizType() == null) && (trnsType != null))
      {
        if (trnsType.getBizType() == null) {
          trnsType = ProductTransactionTypeFactory.getLocalInstance(ctx).getProductTransactionTypeInfo(new ObjectUuidPK(trnsType.getId()));
        }
        mo.setBizType(trnsType.getBizType());
      }
      processBOTPDefault(ctx, mo, false);
    }
  }
  
  private void processBOTPDefault(Context ctx, ManufactureOrderInfo mo, boolean isimporData)
    throws EASBizException, BOSException
  {
    mo.setPlanBeginDate(MMCommonUtils.clearTime(mo.getPlanBeginDate()));
    mo.setPlanEndDate(MMCommonUtils.clearTime(mo.getPlanEndDate()));
    
    Map inParam = new HashMap();
    inParam.put("STORAGEORG", mo.getStorageOrgUnit());
    inParam.put("TRANSTYPE", mo.getTransactionType());
    inParam.put("MATERIAL", mo.getMaterial());
    inParam.put("BEGINTIME", mo.getPlanBeginDate());
    inParam.put("ENDTIME", mo.getPlanEndDate());
    inParam.put("BILL_UNIT", mo.getUnit());
    inParam.put("BASEUNIT", mo.getBaseUnit());
    inParam.put("BILL_QTY", mo.getQty());
    inParam.put("SPLIT_QTY", mo.getTotalSplitQty());
    inParam.put("LOTNUMBER", mo.getLot());
    
    inParam.put("adminOrgUnit", mo.getAdminOrgUnit());
    
    getBOMInfoInBomExpand(ctx, mo, inParam);
    
    String materialID = mo.getMaterial().getId().toString();
    String storageOrgUnitID = mo.getStorageOrgUnit().getId().toString();
    ProductTransactionTypeInfo transInfo = mo.getTransactionType();
    Map retData = new HashMap();
    
    getMaterialPlanData(ctx, mo.getMaterial(), mo.getStorageOrgUnit(), inParam, retData, false);
    
    String sourceBillTypeID = null;
    if (!isimporData)
    {
      sourceBillTypeID = mo.getSourceBillType().getId().toString();
      if ((sourceBillTypeID.equals("510b6503-0105-1000-e000-0113c0a812fd463ED552")) || (sourceBillTypeID.equals("B2aZSVXaSx6qxdfekgCmrEY+1VI=")))
      {
        if (sourceBillTypeID.equals("510b6503-0105-1000-e000-0113c0a812fd463ED552"))
        {
          BomInfo defaultBomInfo = (BomInfo)inParam.get("BOM");
          SCMEntryDataVO voEntryResult = (SCMEntryDataVO)inParam.get("VO_ENTRY");
          String matId = mo.getMaterial() != null ? mo.getMaterial().getId().toString() : "";
          String unitId = mo.getUnit() != null ? mo.getUnit().getId().toString() : "";
          int unitPrec = 4;
          if (defaultBomInfo != null)
          {
            BigDecimal deliveryQty = mo.getQty() != null ? mo.getQty() : new BigDecimal("0.00");
            
            mo.setYield(defaultBomInfo.getYield());
            
            String key = matId + unitId;
            if ((voEntryResult != null) && (voEntryResult.getMmuPrecisions() != null) && (voEntryResult.getMmuPrecisions().get(key) != null)) {
              unitPrec = ((Integer)voEntryResult.getMmuPrecisions().get(key)).intValue();
            }
            BigDecimal yield = defaultBomInfo.getYield().divide(new BigDecimal("100.00"), 4, 4);
            
            BigDecimal qty = deliveryQty.divide(yield, unitPrec, 4);
            mo.setQty(qty);
            inParam.put("BILL_QTY", qty);
            
            mo.setDeliveryQty(deliveryQty.setScale(unitPrec, 4));
          }
        }
        MOUntil.getDefaultRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
        if (retData != null)
        {
          ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
          inParam.put("TECHNICS", techCol);
          retData.put("TECHNICS", techCol);
        }
        getDefaultBOM(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
      }
      else if (sourceBillTypeID.equals("9XXvbVGlRtym/0qtqeIXXrhE1B8="))
      {
        String sourceBillId = mo.getSourceBillId();
        PlannedOrderInfo po = (PlannedOrderInfo)PlannedOrderFactory.getLocalInstance(ctx).getCoreBillBaseInfo("select id ,isAfreshExtend where id = '" + sourceBillId + "'");
        
        boolean isAfreshExtend = po.isIsAfreshExtend();
        
        inParam.put("isAfreshExtend", new Boolean(isAfreshExtend));
        
        String tmpBOMID = getBOMIDByPOID(ctx, sourceBillId);
        mo.setBomID(tmpBOMID);
        
        boolean isMaterialSubs = isMaterialSubsByPOID(ctx, sourceBillId);
        if (isAfreshExtend)
        {
          MOUntil.getDefaultRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
          if (retData != null)
          {
            ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
            retData.put("TECHNICS", techCol);
          }
          getDefaultBOM(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
          mo.setQty(mo.getQty());
          mo.setBaseQty(mo.getBaseQty());
          mo.setUnRepairQty(mo.getQty());
        }
        else if (isMaterialSubs)
        {
          getSpecialRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
          expandBOMFromPLannedOrder(ctx, inParam, retData, mo);
        }
        else
        {
          String bomID = ((BomInfo)inParam.get("BOM")).getId().toString();
          
          StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
          String storageOrgId = storageOrgUnit.getId().toString();
          
          Map tmpPBomMap = new HashMap();
          tmpPBomMap.put("storageOrgUnitID", storageOrgId);
          String mainRouting = MOUntil.getMainRouting(ctx, materialID, storageOrgUnitID);
          tmpPBomMap.put("routingID", mainRouting);
          tmpPBomMap.put("bomID", bomID);
          tmpPBomMap.put("pInfo", (ProjectInfo)inParam.get("projectID"));
          tmpPBomMap.put("tInfo", (TrackNumberInfo)inParam.get("trackID"));
          Map mapPBom = MOUntil.searchPBOM(ctx, tmpPBomMap);
          PBOMInfo pbomInfo = (PBOMInfo)mapPBom.get("pbomInfo");
          if (pbomInfo == null)
          {
            getSpecialRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
            expandBOMFromPLannedOrder(ctx, inParam, retData, mo);
          }
          else
          {
            MOUntil.getDefaultRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
            if (retData != null)
            {
              ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
              retData.put("TECHNICS", techCol);
            }
            getDefaultBOM(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
            mo.setQty(mo.getQty());
            mo.setBaseQty(mo.getBaseQty());
            mo.setUnRepairQty(mo.getQty());
          }
        }
      }
      else
      {
        MOUntil.getDefaultRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
        if (retData != null)
        {
          ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
          retData.put("TECHNICS", techCol);
        }
        getDefaultBOM(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
      }
    }
    else
    {
      MOUntil.getDefaultRouting(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
      if (retData != null)
      {
        ManufactureOrderTechnicsCollection techCol = _routingExpand(ctx, inParam);
        retData.put("TECHNICS", techCol);
      }
      getDefaultBOM(ctx, materialID, storageOrgUnitID, transInfo, inParam, retData);
    }
    SCMEntryDataVO voResult = (SCMEntryDataVO)retData.get("VO_ENTRY");
    BomInfo bomInfo = (BomInfo)retData.get("BOM");
    int unitPrec = 4;
    if (bomInfo != null)
    {
      mo.setBomID(bomInfo.getId().toString());
      mo.setBomNum(bomInfo.getNumber());
      
      mo.setYield(bomInfo.getYield());
      
      String key = materialID + mo.getUnit().getId().toString();
      if ((voResult != null) && (voResult.getMmuPrecisions() != null) && (voResult.getMmuPrecisions().get(key) != null)) {
        unitPrec = ((Integer)voResult.getMmuPrecisions().get(key)).intValue();
      }
      BigDecimal yield = bomInfo.getYield().divide(new BigDecimal("100.00"), 4, 4);
      if (sourceBillTypeID != null)
      {
        if (!sourceBillTypeID.equals("510b6503-0105-1000-e000-0113c0a812fd463ED552")) {
          if ((sourceBillTypeID.equals("B2aZSVXaSx6qxdfekgCmrEY+1VI=")) || (sourceBillTypeID.equals("9XXvbVGlRtym/0qtqeIXXrhE1B8=")))
          {
            BigDecimal deliveryQty = mo.getQty().multiply(yield).setScale(unitPrec, 4);
            mo.setDeliveryQty(deliveryQty);
          }
        }
      }
      else
      {
        mo.setYield(new BigDecimal("100.00"));
        mo.setDeliveryQty(mo.getQty());
      }
    }
    else
    {
      mo.setYield(new BigDecimal("100.00"));
      mo.setDeliveryQty(mo.getQty());
    }
    mo.setUnRepairQty(mo.getQty());
    if ((!isimporData) || (mo.getDefaultWarehous() == null)) {
      mo.setDefaultWarehous((WarehouseInfo)retData.get("DEFAULTWAREHOUSE"));
    }
    AdminOrgUnitInfo dutyDepartment = null;
    String key1 = materialID + storageOrgUnitID;
    if ((voResult != null) && (voResult.getMaterialPlanInfos() != null) && (voResult.getMaterialPlanInfos().get(key1) != null))
    {
      MaterialPlanInfo materialPlan = (MaterialPlanInfo)voResult.getMaterialPlanInfos().get(key1);
      
      dutyDepartment = materialPlan.getDutyDepartment();
      if (materialPlan.getRcvInHightLimit() != null)
      {
        mo.setExtraRatio(materialPlan.getRcvInHightLimit());
        BigDecimal extraRatio = materialPlan.getRcvInHightLimit().divide(new BigDecimal("100.00"), 4, 4).add(new BigDecimal("1.0"));
        
        BigDecimal extraQty = mo.getQty().multiply(extraRatio).setScale(unitPrec, 0);
        mo.setExtraUpperLimit(extraQty);
      }
      else
      {
        mo.setExtraRatio(SysConstant.BIGZERO);
        mo.setExtraUpperLimit(mo.getQty());
      }
      if (materialPlan.getRcvInLowLimit() != null)
      {
        mo.setLackRatio(materialPlan.getRcvInLowLimit());
        BigDecimal lackRatio = new BigDecimal("1.0").subtract(materialPlan.getRcvInLowLimit().divide(new BigDecimal("100.00"), 4, 4));
        
        BigDecimal lackQty = mo.getQty().multiply(lackRatio).setScale(unitPrec, 0);
        mo.setLackLowerLimit(lackQty);
      }
      else
      {
        mo.setLackRatio(SysConstant.BIGZERO);
        mo.setLackLowerLimit(mo.getQty());
      }
      if ((!materialPlan.isIsStorageLimit()) || (mo.getTransactionType().isIsWPManagement())) {
        mo.setIsLimitedQty(false);
      } else {
        mo.setIsLimitedQty(true);
      }
    }
    mo.setRouting((StandardRootingInfo)retData.get("ROUTING"));
    ManufactureOrderTechnicsCollection techCol = (ManufactureOrderTechnicsCollection)retData.get("TECHNICS");
    if (techCol != null)
    {
      mo.put("technics", techCol);
      
      int lastop = 0;
      for (int i = 0; i < techCol.size(); i++) {
        if (techCol.get(i).getOperationNo() > lastop) {
          lastop = techCol.get(i).getOperationNo();
        }
      }
      mo.setLastOperNo(lastop);
      
      int i = 0;
      for (int size = techCol.size(); i < size; i++)
      {
        ManufactureOrderTechnicsInfo info = techCol.get(i);
        if (info.getAdminOrgUnit() == null) {
          info.setAdminOrgUnit(mo.getAdminOrgUnit());
        }
        if (info.getAdminOrgUnit() == null) {
          info.setAdminOrgUnit(dutyDepartment);
        }
      }
    }
    else
    {
      mo.put("technics", new ManufactureOrderTechnicsCollection());
    }
    if (retData.get("STOCKS") != null) {
      mo.put("stocks", retData.get("STOCKS"));
    } else {
      mo.put("stocks", new ManufactureOrderStockCollection());
    }
    operationpSchedul(ctx, mo, isimporData);
    if (!isimporData)
    {
      operationpSchedul(ctx, mo, isimporData);
      if (sourceBillTypeID.equals("510b6503-0105-1000-e000-0113c0a812fd463ED552"))
      {
        inParam.put("LOTNUMBER", mo.getLot());
        getExpectOutput(ctx, inParam, retData);
        ManufactureOrderExpectOutputCollection expectOutputs = (ManufactureOrderExpectOutputCollection)retData.get("EXPECTOUTPUTS");
        mo.put("expectOutputs", expectOutputs);
      }
      else if (sourceBillTypeID.equals("9XXvbVGlRtym/0qtqeIXXrhE1B8="))
      {
        String sourceBillId = mo.getSourceBillId();
        PlannedOrderInfo po = (PlannedOrderInfo)PlannedOrderFactory.getLocalInstance(ctx).getCoreBillBaseInfo("select id ,isAfreshExtend where id = '" + sourceBillId + "'");
        
        boolean isAfreshExtend = po.isIsAfreshExtend();
        inParam.put("isAfreshExtend", new Boolean(isAfreshExtend));
        if (isAfreshExtend)
        {
          getExpectOutput(ctx, inParam, retData);
          ManufactureOrderExpectOutputCollection expectOutputs = (ManufactureOrderExpectOutputCollection)retData.get("EXPECTOUTPUTS");
          mo.put("expectOutputs", expectOutputs);
        }
        else
        {
          getExpectOutput(ctx, inParam, retData);
          ManufactureOrderExpectOutputCollection expectOutputs = (ManufactureOrderExpectOutputCollection)retData.get("EXPECTOUTPUTS");
          mo.put("expectOutputs", expectOutputs);
          setExpectOutputFormPO(ctx, po, mo);
        }
        dealMOLotFromPO(ctx, mo);
        dealExpectOutputLot(ctx, mo);
      }
    }
    else
    {
      inParam.put("LOTNUMBER", mo.getLot());
      getExpectOutput(ctx, inParam, retData);
      ManufactureOrderExpectOutputCollection expectOutputs = (ManufactureOrderExpectOutputCollection)retData.get("EXPECTOUTPUTS");
      mo.put("expectOutputs", expectOutputs);
    }
    updateStock(mo);
  }
  
  private void dealExpectOutputLot(Context ctx, ManufactureOrderInfo mo)
    throws EASBizException, BOSException
  {
    if (mo.get("expectOutputs") == null) {
      return;
    }
    ManufactureOrderExpectOutputCollection expectOutputs = (ManufactureOrderExpectOutputCollection)mo.get("expectOutputs");
    ManufactureOrderExpectOutputInfo expectOutput = null;
    for (int i = 0; i < expectOutputs.size(); i++)
    {
      expectOutput = expectOutputs.get(i);
      if (getIsIsLotNumber(ctx, expectOutput.getMaterial(), mo.getStorageOrgUnit())) {
        expectOutput.setLot(mo.getLot());
      } else {
        expectOutput.setLot(null);
      }
    }
    mo.put("expectOutputs", expectOutputs);
  }
  
  private void setExpectOutputFormPO(Context ctx, PlannedOrderInfo po, ManufactureOrderInfo mo)
    throws EASBizException, BOSException
  {
    ManufactureOrderExpectOutputCollection newExpectOutputs = new ManufactureOrderExpectOutputCollection();
    
    ManufactureOrderExpectOutputCollection moExpectOutputs = mo.getExpectOutputs();
    PlannedOrderOutputsEntryCollection poOutputEntries = po.getOutputEntries();
    
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    int lastOperNo = 0;
    OperationInfo lastOperationInfo = null;
    if ((technicsCol != null) && (technicsCol.size() > 0))
    {
      MMCommonUtils.objectValueSort(technicsCol, true, "operationNo");
      
      ManufactureOrderTechnicsInfo maxTechnicInfo = technicsCol.get(technicsCol.size() - 1);
      
      lastOperationInfo = maxTechnicInfo.getOperation();
      
      lastOperNo = maxTechnicInfo.getOperationNo();
    }
    for (int i = 0; i < poOutputEntries.size(); i++)
    {
      PlannedOrderOutputsEntryInfo poOutEntryInfo = poOutputEntries.get(i);
      if (poOutEntryInfo.getMaterial() != null)
      {
        String poMaterialId = poOutEntryInfo.getMaterial().getId().toString();
        if ((MaterialProductEnum.RELATEDPRODUCT.equals(poOutEntryInfo.getOutputType())) || (MaterialProductEnum.BYPRODUCT.equals(poOutEntryInfo.getOutputType())))
        {
          ManufactureOrderExpectOutputInfo moOutEntryInfo = null;
          boolean isExists = false;
          for (Iterator it = moExpectOutputs.iterator(); it.hasNext();)
          {
            moOutEntryInfo = (ManufactureOrderExpectOutputInfo)it.next();
            String moMaterialId = moOutEntryInfo.getMaterial().getId().toString();
            if (poMaterialId.equals(moMaterialId))
            {
              isExists = true;
              break;
            }
          }
          if (!isExists) {
            moOutEntryInfo = new ManufactureOrderExpectOutputInfo();
          }
          moOutEntryInfo.setMaterial(poOutEntryInfo.getMaterial());
          
          moOutEntryInfo.setOutputType(poOutEntryInfo.getOutputType());
          
          moOutEntryInfo.setOperationNo(!isExists ? lastOperNo : moOutEntryInfo.getOperationNo());
          
          moOutEntryInfo.setOperation(!isExists ? lastOperationInfo : moOutEntryInfo.getOperation());
          
          moOutEntryInfo.setUnit(poOutEntryInfo.getMaterial().getBaseUnit());
          
          moOutEntryInfo.setQty(poOutEntryInfo.getQty());
          
          moOutEntryInfo.setBaseUnit(poOutEntryInfo.getMaterial().getBaseUnit());
          
          moOutEntryInfo.setBaseQty(getBaseUnitQty(ctx, moOutEntryInfo.getMaterial(), moOutEntryInfo.getUnit(), poOutEntryInfo.getQty(), moOutEntryInfo.getBaseUnit()));
          
          moOutEntryInfo.setAssistUnit(poOutEntryInfo.getMaterial().getAssistUnit());
          
          moOutEntryInfo.setAssistQty(getAssistUnitQty(ctx, moOutEntryInfo.getMaterial(), moOutEntryInfo.getUnit(), moOutEntryInfo.getQty(), moOutEntryInfo.getAssistUnit()));
          
          moOutEntryInfo.setFinishedQty(SysConstant.BIGZERO);
          
          moOutEntryInfo.setPassQty(SysConstant.BIGZERO);
          
          moOutEntryInfo.setScrapQty(SysConstant.BIGZERO);
          
          moOutEntryInfo.setToStoreQty(SysConstant.BIGZERO);
          
          moOutEntryInfo.setDefaultWarehous(moOutEntryInfo.getDefaultWarehous());
          
          moOutEntryInfo.setCostObect(MOCostObjectUtil.getCostObject(ctx, poOutEntryInfo.getMaterial(), po.getStorageOrgUnit(), null, mo.getId().toString(), false, false));
          
          moOutEntryInfo.setRemark(moOutEntryInfo.getRemark());
          
          moOutEntryInfo.setLot(mo.getLot());
          
          newExpectOutputs.add(moOutEntryInfo);
        }
      }
    }
    mo.put("expectOutputs", newExpectOutputs);
  }
  
  private void dealMOLotFromPO(Context ctx, ManufactureOrderInfo mo)
    throws BOSException, EASBizException
  {
    FilterInfo filter = new FilterInfo();
    filter.getFilterItems().add(new FilterItemInfo("material.id", mo.getMaterial().getId().toString(), CompareType.EQUALS));
    filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", mo.getStorageOrgUnit().getId().toString(), CompareType.EQUALS));
    EntityViewInfo viewer = new EntityViewInfo();
    viewer.setFilter(filter);
    
    SelectorItemCollection selector = new SelectorItemCollection();
    selector.add("isLotNumber");
    viewer.setSelector(selector);
    MaterialInventoryCollection inv = MaterialInventoryFactory.getLocalInstance(ctx).getMaterialInventoryCollection(viewer);
    if (inv.size() <= 0) {
      return;
    }
    MaterialInventoryInfo invInfo = inv.get(0);
    if (!invInfo.isIsLotNumber()) {
      return;
    }
    LotParamValueInfo param = LotFacadeFactory.getLocalInstance(ctx).getLotParamValueByOrg(mo.getStorageOrgUnit().getId().toString());
    
    boolean isManufactureOrder = param.isManufactureOrder();
    
    boolean isManufacturePlan = param.isManufacturePlan();
    
    boolean isManufactureProseee = param.isManufactureProseee();
    
    PlannedOrderInfo po = PlannedOrderFactory.getLocalInstance(ctx).getPlannedOrderInfo(new ObjectUuidPK(mo.getSourceBillId()));
    if (po == null) {
      return;
    }
    if (isManufacturePlan)
    {
      if (isManufactureOrder)
      {
        if (isManufactureProseee)
        {
          if (po.getOrderType().equals(PlannedOrderTypeEnum.FABRICATED))
          {
            if (po.getLot() != null) {
              mo.setLot(po.getLot().trim());
            }
          }
          else {
            mo.setLot(null);
          }
        }
        else if (po.getOrderType().equals(PlannedOrderTypeEnum.FABRICATED)) {
          dealLotRule(ctx, mo);
        } else {
          mo.setLot(null);
        }
      }
      else if ((po.getOrderType().equals(PlannedOrderTypeEnum.FABRICATED)) && (po.getLot() != null)) {
        mo.setLot(po.getLot().trim());
      } else {
        mo.setLot(null);
      }
    }
    else if (isManufactureOrder) {
      if (po.getOrderType().equals(PlannedOrderTypeEnum.FABRICATED)) {
        dealLotRule(ctx, mo);
      }
    }
  }
  
  private void expandBOMFromPLannedOrder(Context ctx, Map inParam, Map outParam, ManufactureOrderInfo mo)
    throws EASBizException, BOSException
  {
    String expandTablName = createTempTable(ctx);
    try
    {
      SelectorItemCollection sic = new SelectorItemCollection();
      sic.add(new SelectorItemInfo("id"));
      sic.add(new SelectorItemInfo("number"));
      sic.add(new SelectorItemInfo("name"));
      sic.add(new SelectorItemInfo("yield"));
      BomInfo bom = null;
      if (mo.getBomID() != null) {
        bom = (BomInfo)BomFactory.getLocalInstance(ctx).getValue(new ObjectStringPK(mo.getBomID()), sic);
      }
      if (bom != null) {
        outParam.put("BOM", bom);
      }
      StorageOrgUnitInfo[] storages = new StorageOrgUnitInfo[mo.getStocks().size()];
      MaterialInfo[] materials = new MaterialInfo[mo.getStocks().size()];
      MeasureUnitInfo[] units = new MeasureUnitInfo[mo.getStocks().size()];
      for (int i = 0; i < mo.getStocks().size(); i++)
      {
        storages[i] = mo.getStorageOrgUnit();
        materials[i] = mo.getStocks().get(i).getMaterial();
        units[i] = mo.getStocks().get(i).getUnit();
      }
      SCMEntryDataVO vo = new SCMEntryDataVO();
      vo.setIsLoadingMmuPrecision(true);
      vo.setMaterialInfos(materials);
      vo.setMeasureUnitInfos(units);
      vo.setStorageOrgUnitInfos(storages);
      vo.setIsLoadingMaterialPlan(true);
      vo.setIsLoadingMaterialInventory(false);
      vo.setIsLoadingMaterialInfo(false);
      SCMEntryDataVO voResult = SCMGroupFacadeFactory.getLocalInstance(ctx).loadComplexData(vo);
      StringBuffer sqlBuf = new StringBuffer();
      String[] sqls = new String[mo.getStocks().size()];
      String key = null;
      String storageOrgId = mo.getStorageOrgUnit().getId().toString();
      MaterialPlanInfo mpInfo = null;
      if (bom != null) {
        inParam.put("BOM", bom);
      }
      Map bomMap = new HashMap();
      if (bom != null)
      {
        String locStr = LocaleUtils.getLocaleString(ctx.getLocale());
        
        sqlBuf.setLength(0);
        
        sqlBuf.append("select FSeq, FMaterialID, FBlueprint_").append(locStr).append(", FLocationID, FIsBackFlush ").append(" from t_mm_bomentry where FParentid = '").append(mo.getBomID()).append("'");
        
        IRowSet rowSet = DbUtil.executeQuery(ctx, sqlBuf.toString());
        try
        {
          while ((rowSet != null) && (rowSet.next()))
          {
            Integer seq = new Integer(rowSet.getInt("FSeq"));
            String materialID = rowSet.getString("FMaterialID");
            String blueprint = rowSet.getString("FBlueprint_" + locStr);
            
            String locationID = rowSet.getString("FLocationID");
            Boolean isBackFlush = new Boolean(rowSet.getBoolean("FIsBackFlush"));
            
            bomMap.put(seq.toString() + "-" + materialID, new Object[] { blueprint, locationID, isBackFlush });
          }
        }
        catch (SQLException e)
        {
          throw new BOSException(e);
        }
      }
      Connection conn = null;
      PreparedStatement ps = null;
      sqlBuf.setLength(0);
      sqlBuf.append("insert into ").append(expandTablName).append(" ").append("\r\n").append("(fid,fmaterialid,funitid,fbaseunitid,fPrec,FReplaceMode,").append("FIssMode,FIsQuotaControl,FIssInHightLimit,FIssInLowLimit,").append(" FBOMDefWarehouseID,FRoutingItemID,").append(" FMaterialAttr,").append("funitQty,fQty,fPlannedQty,fscrapQty,fscrapRate,FScrapRateExpression,FDemandTime,FNetWeight,FBlkSize,FSpecifiedLength, ").append(" FBomEntryId, FProvideType, FSupplyStorageId, ");
      
      sqlBuf.append(" FBlueprint, FLocationID, FIsBackFlush )");
      sqlBuf.append("\r\n").append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      try
      {
        conn = EJBFactory.getConnection(ctx);
        ps = conn.prepareStatement(sqlBuf.toString());
        for (int i = 0; i < mo.getStocks().size(); i++)
        {
          ManufactureOrderStockInfo entry = mo.getStocks().get(i);
          String materialId = entry.getMaterial() != null ? entry.getMaterial().getId().toString() : "";
          
          String unitId = entry.getUnit() != null ? entry.getUnit().getId().toString() : "";
          
          key = materialId + storageOrgId;
          mpInfo = (MaterialPlanInfo)voResult.getMaterialPlanInfos().get(key);
          
          key = materialId + unitId;
          int prec = 4;
          if (voResult.getMmuPrecisions().get(key) != null) {
            prec = ((Integer)voResult.getMmuPrecisions().get(key)).intValue();
          }
          BigDecimal extraRatio = mpInfo.getIssInHightLimit();
          if ((extraRatio == null) || (extraRatio.compareTo(new BigDecimal("0.00")) == 0)) {
            extraRatio = new BigDecimal("0.00");
          }
          BigDecimal lackRatio = mpInfo.getIssInLowLimit();
          if ((lackRatio == null) || (lackRatio.compareTo(new BigDecimal("0.00")) == 0)) {
            lackRatio = new BigDecimal("0.00");
          }
          BigDecimal newNetWeight = entry.getNewnetWeight();
          if ((null != newNetWeight) && (newNetWeight.compareTo(new BigDecimal("0.00")) != 0)) {
            newNetWeight = newNetWeight.setScale(8, 4);
          } else {
            newNetWeight = new BigDecimal("0.00");
          }
          BigDecimal unitQty = entry.getUnitQty();
          if ((null != unitQty) && (unitQty.compareTo(new BigDecimal("0.00")) != 0)) {
            unitQty = unitQty.setScale(8, 4);
          } else {
            unitQty = new BigDecimal("1");
          }
          BigDecimal planQty = entry.getPlannedQty();
          if ((planQty == null) || (planQty.compareTo(new BigDecimal("0.00")) == 0)) {
            planQty = new BigDecimal("0.00");
          } else {
            planQty = planQty.setScale(8, 4);
          }
          String blueprint = null;
          String locationID = null;
          Boolean isBackFlush = null;
          if ((bomMap != null) && (bomMap.size() > 0))
          {
            Set bomSet = bomMap.keySet();
            Iterator bomIt = bomSet.iterator();
            String pk = null;
            Object[] values = null;
            while (bomIt.hasNext())
            {
              pk = (String)bomIt.next();
              if (pk.indexOf("-" + materialId) > 0)
              {
                values = (Object[])bomMap.get(pk);
                blueprint = (String)values[0];
                locationID = (String)values[1];
                isBackFlush = (Boolean)values[2];
              }
            }
          }
          ps.setString(1, BOSUuid.create("12345678").toString());
          ps.setString(2, materialId);
          ps.setString(3, unitId);
          ps.setString(4, entry.getBaseUnit() != null ? entry.getBaseUnit().getId().toString() : "");
          
          ps.setInt(5, prec);
          ps.setInt(6, 0);
          ps.setInt(7, mpInfo.getIssMode().getValue());
          
          ps.setInt(8, mpInfo.isIsQuotaControl() ? 1 : 0);
          ps.setBigDecimal(9, extraRatio);
          ps.setBigDecimal(10, lackRatio);
          ps.setString(11, null);
          ps.setString(12, null);
          ps.setInt(13, mpInfo.getMaterialAttr().getValue());
          ps.setBigDecimal(14, unitQty);
          ps.setBigDecimal(15, planQty);
          ps.setBigDecimal(16, planQty);
          ps.setBigDecimal(17, new BigDecimal("0.00"));
          ps.setBigDecimal(18, new BigDecimal("0.00"));
          ps.setInt(19, mpInfo.getScrapRateExpression().getValue());
          ps.setDate(20, new java.sql.Date(entry.getDemandTime().getTime()));
          
          ps.setBigDecimal(21, newNetWeight);
          ps.setString(22, entry.getBlkSize() != null ? entry.getBlkSize() : "");
          
          ps.setString(23, entry.getSpecifiedLength() != null ? entry.getSpecifiedLength() : "");
          
          ps.setString(24, entry.getBomEntryID());
          
          ps.setInt(25, entry.getProvideType() != null ? entry.getProvideType().getValue() : 0);
          
          ps.setString(26, entry.getStorageOrgUnit() != null ? entry.getStorageOrgUnit().getId().toString() : null);
          
          ps.setString(27, bom != null ? blueprint : null);
          ps.setString(28, bom != null ? locationID : null);
          if ((bom != null) && (isBackFlush != null)) {
            ps.setInt(29, isBackFlush.booleanValue() ? 1 : 0);
          } else if ((bom != null) && (isBackFlush == null)) {
            ps.setInt(29, mpInfo.isIsBackFlush() ? 1 : 0);
          } else {
            ps.setInt(29, 0);
          }
          ps.addBatch();
        }
        ps.executeBatch();
      }
      catch (SQLException e)
      {
        throw new BOSException(e);
      }
      finally
      {
        SQLUtils.cleanup(conn);
      }
      inParam.put("RECALC", Boolean.FALSE);
      inParam.put("TABLENAME", expandTablName);
      ManufactureOrderStockCollection stocks = buildStock(ctx, inParam);
      outParam.put("STOCKS", stocks);
    }
    finally
    {
      TempTablePool pool;
      if (expandTablName != null)
      {
         pool = TempTablePool.getInstance(ctx);
        pool.releaseTable(expandTablName);
      }
    }
  }
  
  protected void _updateRemark(Context ctx, String moID, String remark)
    throws BOSException, EASBizException
  {
    if ((moID == null) || (remark == null)) {
      return;
    }
    String locStr = LocaleUtils.getLocaleString(ctx.getLocale());
    StringBuffer updateSql = new StringBuffer();
    
    updateSql.append("update T_MM_ManufactureOrder ").append("set FRemark_").append(locStr).append(" = ? ").append("where FID = ? ");
    
    DbUtil.execute(ctx, updateSql.toString(), new Object[] { remark, moID });
  }
  
  protected void _released(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    BatchExecuteParamsEntry[] entrys = { entry };
    
    BatchActionResults result = batchReleased(ctx, entrys);
    result.throwExceptions();
  }
  
  public BatchActionResults batchReleased(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("RELEASED"));
  }
  
  protected void _unreleased(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    BatchExecuteParamsEntry[] entrys = { entry };
    batchUnReleased(ctx, entrys);
  }
  
  public BatchActionResults batchUnReleased(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("UNRELEASED"));
  }
  
  protected void _finish(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    
    BatchExecuteParamsEntry[] entrys = { entry };
    batchFinish(ctx, entrys);
  }
  
  public BatchActionResults batchFinish(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("FINISH"));
  }
  
  protected IRowSet _getWIPMaterial(Context ctx, List moIDLst)
    throws EASBizException, BOSException
  {
    String locStr = LocaleUtils.getLocaleString(ctx.getLocale());
    String idStr = SQLUtil.arrayToString(moIDLst.toArray());
    StringBuffer sqlBuf = new StringBuffer();
    sqlBuf.append("select t0.FOperationNo,t0.FPlannedQty,t0.FActIssueQty,t0.FWipQty, ").append("t01.fid,t01.fnumber,").append("t1.fnumber fmaterialnumber,t1.fname_").append(locStr).append(" fmaterialname,t1.fmodel,").append("t2.fnumber funitnumber,t2.fname_").append(locStr).append(" funitname,t21.FQtyPrecision ").append("from T_MM_MFTOrderStock t0 ").append("inner join T_MM_ManufactureOrder t01 on t0.fparentid = t01.fid ").append("inner join t_bd_material t1 on t0.fmaterialid = t1.fid ").append("inner join T_BD_MeasureUnit t2 on t0.funitid = t2.fid ").append("inner join T_BD_MultiMeasureUnit t21 on t0.fmaterialid = t21.fmaterialid and t0.funitid = t21.FMeasureUnitID ").append("\r\n").append("where t01.FBasestatus = 4 and t0.fwipqty <> 0 ").append("and t01.fid in (").append(idStr).append(") ").append("order by t01.fnumber ");
    
    IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
    return rs;
  }
  
  protected void _revoke(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    
    BatchExecuteParamsEntry[] entrys = { entry };
    batchRevoke(ctx, entrys);
  }
  
  public BatchActionResults batchRevoke(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    BatchActionResults results = batchExecute(ctx, entries, new BatchActionEnum("REVOKE"));
    try
    {
      List ids = results.getToDoIdsList();
      if (ids.size() > 0)
      {
        IReqPlanReceiveReqDataFacade reqPlanReceiveReqDataFacade = ReqPlanReceiveReqDataFacadeFactory.getLocalInstance(ctx);
        reqPlanReceiveReqDataFacade.receiveReqPlanDate("B2aZSVXaSx6qxdfekgCmrEY+1VI=", MMUtils.listToString(ids), 108);
      }
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    return results;
  }
  
  protected void _unFinish(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    
    BatchExecuteParamsEntry[] entrys = { entry };
    batchUnFinish(ctx, entrys);
  }
  
  public BatchActionResults batchUnFinish(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("UNFINISH"));
  }
  
  protected void _asynchBackflush(Context ctx, String[] billIDs, BillTypeInfo billType)
    throws BOSException, EASBizException
  {
    BPOption bpOption = new BPOption();
    bpOption.setImmediately(true);
    DynamicBackground bd = new DynamicBackground(ctx);
    
    int isBackfrush = 2;
    boolean isFromReport = false;
    if (billType.getId().toString().equals("HxPKDRdzRpaqr31LD+3SBEY+1VI=")) {
      isFromReport = true;
    }
    MOMaterialBackFlush.setCompRepBackFlush(ctx, isFromReport, billIDs, isBackfrush);
    
    bd.invokeBackound(getBOSType(), "materialBackFlush", new Class[] { String[].class, BillTypeInfo.class }, new Object[] { billIDs, billType }, bpOption);
  }
  
  protected void _materialWithdrawal(Context ctx, String tempTableName, int bizAction, TransactionTypeInfo transTypeInfo)
    throws BOSException, EASBizException
  {
    MOMaterialWithdrawal billUpdater = new MOMaterialWithdrawal(ctx);
    billUpdater.setSourceDataTable(tempTableName);
    billUpdater.setAuditAction(bizAction == 103);
    billUpdater.setTransTypeInfo(transTypeInfo);
    billUpdater.execute();
  }
  
  /**
   * @deprecated
   */
  protected void _productReceipt(Context ctx, String tempTableName, int bizAction)
    throws BOSException, EASBizException
  {}
  
  protected void _calculateWIP(Context ctx, String tempTable)
    throws BOSException, EASBizException
  {
    CalculateWipUtil.updateWipByTemTable(ctx, tempTable);
  }
  
//  protected void _materialBackFlush(Context ctx, String[] billIDs, BillTypeInfo billType)
//    throws BOSException, EASBizException
//  {
//    Boolean boolean1 = (Boolean)ctx.get("backflush_delay");
//    try
//    {
//      if ((boolean1 != null) && (boolean1.booleanValue())) {
//        Thread.sleep(15000L);
//      }
//    }
//    catch (InterruptedException e)
//    {
//      logger.error(e);
//    }
//    MOMaterialBackFlush.backFlush(ctx, billIDs, billType, true);
//    ctx.put("backflush_delay", new Boolean(false));
//  }
  
  protected void _materialUnBackFlush(Context ctx, String[] billIDs)
    throws BOSException, EASBizException
  {
    if ((billIDs == null) || (billIDs.length == 0)) {
      return;
    }
    BOSObjectType bosType = BOSUuid.getBOSObjectType(billIDs[0], true);
    BillTypeInfo billType = new BillTypeInfo();
    if (bosType.toString().equals("DFBE5164")) {
      billType.setId(BOSUuid.read("HxPKDRdzRpaqr31LD+3SBEY+1VI="));
    } else {
      billType.setId(BOSUuid.read("50957179-0105-1000-e000-0167c0a812fd463ED552"));
    }
    MOMaterialBackFlush.unBackFlush(ctx, billIDs, billType);
  }
  
  protected void _close(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
    entry.add(pk);
    BatchExecuteParamsEntry[] entries = { entry };
    try
    {
      updateReqPlanData(ctx, entries, 201, null);
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
  }
  
  public BatchActionResults batchClose(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    BatchActionResults results = batchExecute(ctx, entries, new BatchActionEnum("CLOSED"));
    try
    {
      updateReqPlanData(ctx, results.getToDoIdsList(), 201, null);
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    return results;
  }
  
  protected void _unClose(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
    entry.add(pk);
    BatchExecuteParamsEntry[] entries = { entry };
    try
    {
      updateReqPlanData(ctx, entries, 303, null);
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
  }
  
  public BatchActionResults batchUnClose(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    BatchActionResults results = batchExecute(ctx, entries, new BatchActionEnum("UNCLOSED"));
    try
    {
      updateReqPlanData(ctx, results.getToDoIdsList(), 303, null);
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    return results;
  }
  
  private void checkMaterilPlan(Context ctx, IObjectCollection collection)
    throws BOSException, EASBizException
  {
    StringBuffer sql = new StringBuffer();
    sql.append("select fid from t_bd_materialplan  ");
    sql.append("where FOrgUnit = ? and  FMaterialID =? and fstatus=1");
    for (int i = 0; i < collection.size(); i++)
    {
      ManufactureOrderInfo mo = (ManufactureOrderInfo)collection.getObject(i);
      IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { mo.getStorageOrgUnit().getId().toString(), mo.getMaterial().getId().toString() });
      try
      {
        if (!rs.next())
        {
          sql.setLength(0);
          sql.append("select fnumber from t_bd_material where fid=?");
          IRowSet rs1 = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { mo.getMaterial().getId().toString() });
          if (rs1.next()) {
            throw new ManufactureOrderException(ManufactureOrderException.NO_PLAN, new Object[] { rs1.getString(1) });
          }
        }
      }
      catch (SQLException e)
      {
        throw new BOSException();
      }
    }
  }
  
  protected void _batchWriteBackByStockTransferBill(Context ctx, String tempTableName, int bizAction)
    throws BOSException, EASBizException
  {
    MOWriteBackByStockTransfer billUpdater = new MOWriteBackByStockTransfer(ctx);
    billUpdater.setSourceDataTable(tempTableName);
    billUpdater.setAuditAction(bizAction == 103);
    billUpdater.execute();
  }
  
  protected void _batchWriteBackByTransferOrder(Context ctx, String tempTableName, int bizAction)
    throws BOSException, EASBizException
  {
    MOWriteBackByTransferOrder billUpdater = new MOWriteBackByTransferOrder(ctx);
    billUpdater.setSourceDataTable(tempTableName);
    billUpdater.setAuditAction(bizAction == 103);
    billUpdater.execute();
  }
  
  protected IObjectPK _submitInBatch(Context ctx, IObjectValue model, IObjectCollection relations)
    throws BOSException, EASBizException
  {
    Boolean release = null;
    release = (Boolean)ctx.get("release");
    if ((release != null) && (release.booleanValue())) {
      return _submit(ctx, model);
    }
    return super._submitInBatch(ctx, model, relations);
  }
  
  private String createinTempTable(Context ctx)
    throws BOSException, EASBizException
  {
    String inTableName = null;
    TempTablePool pool = TempTablePool.getInstance(ctx);
    try
    {
      StringBuffer sqlBuf = new StringBuffer();
      sqlBuf.append("create table tttttt (").append("FStorageorgUnitID varchar(44) not null,").append("FBOMID varchar(44) not null,").append("FMaterialID varchar(44) null,").append("FDate datetime not null,").append("FBaseQty numeric(21,8) not null default 0,").append("FTraceID varchar(44) null, ").append("FProjectID varchar(44) null, ").append("FTrackNumberID varchar(44) null ").append(")");
      
      inTableName = pool.createTempTable(sqlBuf.toString());
    }
    catch (Exception e1)
    {
      throw new BOSException(e1);
    }
    return inTableName;
  }
  
  private LotRuleInfo getProperLotRule(Context ctx, Connection conn, String materialID, String souID)
    throws BOSException, EASBizException
  {
    PreparedStatement stmtMaterial = null;PreparedStatement stmtSou = null;
    Statement stmtRuleByMaterial = null;Statement stmtRuleByMGroup = null;
    ResultSet rsMaterial = null;ResultSet rsSou = null;ResultSet rsRuleByMaterial = null;ResultSet rsRuleByMGroup = null;
    try
    {
      StringBuffer sbSqlMaterial = new StringBuffer();
      
      sbSqlMaterial.append("SELECT mg.FLongNumber AS mgLongNumber ").append("FROM T_BD_Material m INNER JOIN T_BD_MaterialGroup mg ON m.FMaterialGroupID=mg.FID ").append("WHERE m.FID=?");
      
      stmtMaterial = conn.prepareStatement(sbSqlMaterial.toString());
      stmtMaterial.setString(1, materialID);
      rsMaterial = stmtMaterial.executeQuery();
      String mgLongNumber = null;
      if (rsMaterial.next()) {
        mgLongNumber = rsMaterial.getString("mgLongNumber");
      } else {
        return null;
      }
      StringBuffer sbSqlSou = new StringBuffer();
      sbSqlSou.append("SELECT FLongNumber FROM T_ORG_Storage WHERE FID=?");
      stmtSou = conn.prepareStatement(sbSqlSou.toString());
      stmtSou.setString(1, souID);
      rsSou = stmtSou.executeQuery();
      String souLongNumber = null;
      if (rsSou.next()) {
        souLongNumber = rsSou.getString("FLongNumber");
      } else {
        return null;
      }
      String[] mgLongNumbers = parseLongNumber(mgLongNumber);
      String[] souLongNumbers = parseLongNumber(souLongNumber);
      
      StringBuffer sbSqlRuleByMaterial = new StringBuffer();
      sbSqlRuleByMaterial.append("SELECT TOP 1 lr.FID AS ruleID ").append("FROM T_IN_LotRule lr INNER JOIN T_BD_Material m ON lr.FBusinessObjectID = m.FID ").append("INNER JOIN T_ORG_Storage s ON lr.FSouID = s.FID ").append("WHERE FEnabled = 2 AND m.FID='").append(materialID).append("' AND s.FLongNumber IN (").append(SQLUtil.arrayToString(souLongNumbers)).append(") ORDER BY s.FLongNumber DESC");
      
      stmtRuleByMaterial = conn.createStatement();
      rsRuleByMaterial = stmtRuleByMaterial.executeQuery(sbSqlRuleByMaterial.toString());
      if (rsRuleByMaterial.next())
      {
        String ruleID = rsRuleByMaterial.getString("ruleID");
        LotRuleInfo lotRule = LotRuleFactory.getLocalInstance(ctx).getLotRuleInfo(new ObjectUuidPK(ruleID));
        return lotRule;
      }
      StringBuffer sb = new StringBuffer();
      sb.append("SELECT TOP 1 lr.FID AS ruleID ").append("FROM T_IN_LotRule lr INNER JOIN T_BD_MaterialGroup mg ON lr.FBusinessObjectID = mg.FID ").append("INNER JOIN T_ORG_Storage s ").append("ON lr.FSouID = s.FID ").append("WHERE FEnabled = 2 AND mg.FLongNumber IN (").append(SQLUtil.arrayToString(mgLongNumbers)).append(") AND s.FLongNumber IN(").append(SQLUtil.arrayToString(souLongNumbers)).append(") ORDER BY mg.FLongNumber DESC, s.FLongNumber DESC");
      
      stmtRuleByMGroup = conn.createStatement();
      rsRuleByMGroup = stmtRuleByMGroup.executeQuery(sb.toString());
      if (rsRuleByMGroup.next())
      {
        String ruleID = rsRuleByMGroup.getString("ruleID");
        LotRuleInfo lotRule = LotRuleFactory.getLocalInstance(ctx).getLotRuleInfo(new ObjectUuidPK(ruleID));
        return lotRule;
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    finally
    {
      SQLUtils.cleanup(rsMaterial, stmtMaterial);
      SQLUtils.cleanup(rsSou, stmtSou);
      SQLUtils.cleanup(rsRuleByMaterial, stmtRuleByMaterial);
      SQLUtils.cleanup(rsRuleByMGroup, stmtRuleByMGroup);
    }
    return null;
  }
  
  private String[] parseLongNumber(String longNumber)
  {
    if (longNumber == null) {
      return null;
    }
    String split = "!";
    ArrayList list = new ArrayList();
    list.add(longNumber);
    while (longNumber.lastIndexOf(split) >= 0)
    {
      longNumber = longNumber.substring(0, longNumber.lastIndexOf(split));
      list.add(longNumber);
    }
    String[] longNumbers = new String[list.size()];
    list.toArray(longNumbers);
    return longNumbers;
  }
  
  protected void _asynchMaterialBackFlush(Context ctx, String[] billIDs, BillTypeInfo billType, Boolean isThrowExp)
    throws BOSException, EASBizException
  {
    MOMaterialBackFlush.backFlush(ctx, billIDs, billType, isThrowExp.booleanValue());
  }
  
  protected void _setCompRepBackFlush(Context ctx, List billIds, Integer updateState)
    throws BOSException, EASBizException
  {
    String idStr = "'null'";
    if ((billIds != null) && (billIds.size() > 0)) {
      for (int i = 0; i < billIds.size(); i++) {
        idStr = idStr + ",'" + (String)billIds.get(i) + "'";
      }
    }
    String updateSql = "update T_MM_CompletionReport set FIsBackfrush = " + updateState.intValue() + " where FID in (" + idStr + ")";
    
    DbUtil.execute(ctx, updateSql);
  }
  
  protected Map _operationpSchedul(Context ctx, Map param)
    throws BOSException, EASBizException
  {
    Map result = new HashMap();
    
    ScheduleTypeEnum scheduleType = (ScheduleTypeEnum)param.get("scheduleType");
    if ((scheduleType == null) || (scheduleType.getValue() == 10))
    {
      result.put("result", Integer.valueOf("0"));
      result.put("scheduleType", scheduleType);
    }
    else
    {
      ManufactureOrderInfo mo = (ManufactureOrderInfo)param.get("orderInfo");
      Map startTimeMap = new HashMap();
      Map endTimeMap = new HashMap();
      Map sumHoursMap = new HashMap();
      Map classTermMap = new HashMap();
      
      Map queuingTimeMap = new HashMap();
      Map workTimeMap = new HashMap();
      Map moveTimeMap = new HashMap();
      
      boolean hasCalendar = hasProjectCalendar(ctx, mo.getStorageOrgUnit().getId().toString());
      if (!hasCalendar)
      {
        result.put("result", Integer.valueOf("-2"));
        result.put("scheduleType", scheduleType);
        return result;
      }
      boolean noClassTerm = getClassTermSort(ctx, mo, classTermMap, startTimeMap, endTimeMap, sumHoursMap);
      if (!noClassTerm)
      {
        result.put("result", Integer.valueOf("-1"));
        result.put("scheduleType", scheduleType);
        return result;
      }
      getOperationTime(ctx, mo, queuingTimeMap, workTimeMap, moveTimeMap);
      
      IFactoryCalendar calendarFactory = FactoryCalendarFactory.getLocalInstance(ctx);
      if (scheduleType.getValue() == 20)
      {
        forwardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, null, workTimeMap, moveTimeMap);
        
        forwardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, queuingTimeMap, workTimeMap, moveTimeMap);
      }
      else
      {
        backWardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, null, workTimeMap, moveTimeMap);
        
        backWardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, queuingTimeMap, workTimeMap, moveTimeMap);
      }
      result.put("orderInfo", mo);
      result.put("result", Integer.valueOf("1"));
      result.put("scheduleType", scheduleType);
    }
    return result;
  }
  
  private boolean hasProjectCalendar(Context ctx, String storageOrgID)
    throws BOSException, EASBizException
  {
    String sql = "select FID from T_MM_FactoryCalendar where FStorageOrgUnitID = '" + storageOrgID + "'";
    
    IRowSet set = DbUtil.executeQuery(ctx, sql);
    try
    {
      if (set.next()) {
        return true;
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return false;
  }
  
  private void operationpSchedul(Context ctx, ManufactureOrderInfo mo, boolean isimporData)
    throws EASBizException, BOSException
  {
    ScheduleTypeEnum scheduleType = mo.getTransactionType().getScheduleType();
    if (isimporData) {
      scheduleType = mo.getScheduleType();
    }
    mo.setScheduleType(scheduleType);
    if ((scheduleType == null) || (scheduleType.getValue() == 10)) {
      return;
    }
    Map startTimeMap = new HashMap();
    Map endTimeMap = new HashMap();
    Map sumHoursMap = new HashMap();
    Map classTermMap = new HashMap();
    
    Map queuingTimeMap = new HashMap();
    Map workTimeMap = new HashMap();
    Map moveTimeMap = new HashMap();
    
    boolean hasCalendar = hasProjectCalendar(ctx, mo.getStorageOrgUnit().getId().toString());
    if (!hasCalendar) {
      return;
    }
    boolean noClassTerm = getClassTermSort(ctx, mo, classTermMap, startTimeMap, endTimeMap, sumHoursMap);
    if (!noClassTerm) {
      return;
    }
    getOperationTime(ctx, mo, queuingTimeMap, workTimeMap, moveTimeMap);
    
    IFactoryCalendar calendarFactory = FactoryCalendarFactory.getLocalInstance(ctx);
    if (scheduleType.getValue() == 20)
    {
      forwardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, null, workTimeMap, moveTimeMap);
      
      forwardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, queuingTimeMap, workTimeMap, moveTimeMap);
    }
    else
    {
      backWardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, null, workTimeMap, moveTimeMap);
      
      backWardSchedul(mo, calendarFactory, classTermMap, startTimeMap, endTimeMap, sumHoursMap, queuingTimeMap, workTimeMap, moveTimeMap);
    }
  }
  
  private void forwardSchedul(ManufactureOrderInfo mo, IFactoryCalendar workCalendarFactory, Map classTermMap, Map startTimeMap, Map endTimeMap, Map sumHoursMap, Map queuingTimeMap, Map workTimeMap, Map moveTimeMap)
    throws BOSException, EASBizException
  {
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    
    ManufactureOrderTechnicsInfo info = null;
    String operationId = null;
    String classTermId = null;
    Timestamp startTime = null;
    Timestamp firstTime = null;
    Timestamp planBeginDate = mo.getPlanBeginDate();
    if (!workCalendarFactory.isWorkDay(mo.getStorageOrgUnit().getId().toString(), mo.getPlanBeginDate())) {
      planBeginDate = setWorkDate(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), mo.getPlanBeginDate(), true);
    }
    Timestamp endTime = setDafultTime(mo.getPlanEndDate());
    startTime = setDafultTime(planBeginDate);
    firstTime = setDafultTime(planBeginDate);
    
    int index = -1;
    BigDecimal doHours = SCMConstant.BIGDECIMAL_ZERO;
    BigDecimal dototalHours = SCMConstant.BIGDECIMAL_ZERO;
    BigDecimal doQueuingHours = SCMConstant.BIGDECIMAL_ZERO;
    BigDecimal dosumHours = SCMConstant.BIGDECIMAL_ZERO;
    int leaddate = 0;
    int startLeaddate = 0;
    
    int i = 0;
    for (int n = technicsCol.size(); i < n; i++)
    {
      info = technicsCol.get(i);
      operationId = info.getOperation().getId().toString();
      classTermId = (String)classTermMap.get(info.getWorkcenter().getId().toString());
      
      index = findEndTime(classTermId, startTime, endTime, startTimeMap, endTimeMap);
      if (index != -1)
      {
        if (queuingTimeMap != null)
        {
          doQueuingHours = (BigDecimal)queuingTimeMap.get(operationId);
          dosumHours = new BigDecimal(DateMinus(startTime, endTime).doubleValue());
          for (;;)
          {
            if (doQueuingHours.compareTo(dosumHours) <= 0)
            {
              endTime = addTime(endTime, -dosumHours.subtract(doQueuingHours).doubleValue());
              if (!isZeroTime(endTime)) {
                break;
              }
              leaddate++;
              endTime = addTime(endTime, -24.0D);
              break;
            }
            index++;
            leaddate = calculateLead(classTermId, index, true, leaddate, startTimeMap);
            index = resetIndex(classTermId, index, true, startTimeMap);
            findTime(classTermId, index, startTime, endTime, startTimeMap, endTimeMap);
            dosumHours = dosumHours.add(new BigDecimal(DateMinus(startTime, endTime).doubleValue()));
          }
          startTime.setTime(endTime.getTime());
          index = findEndTime(classTermId, startTime, endTime, startTimeMap, endTimeMap);
        }
        firstTime.setTime(startTime.getTime());
        startLeaddate = leaddate;
        
        doHours = (BigDecimal)workTimeMap.get(operationId);
        dototalHours = new BigDecimal(DateMinus(startTime, endTime).doubleValue());
        for (;;)
        {
          if (doHours.compareTo(dototalHours) <= 0)
          {
            endTime = addTime(endTime, -dototalHours.subtract(doHours).doubleValue());
            if (isZeroTime(endTime))
            {
              leaddate++;
              endTime = addTime(endTime, -24.0D);
            }
            if (queuingTimeMap == null)
            {
              info.setEarlistWoktime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), planBeginDate, firstTime, 1, startLeaddate));
              
              info.setEarlistCmpTime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), planBeginDate, endTime, 1, leaddate));
              if (i != 0) {
                break;
              }
              break;
            }
            info.setLastWorktime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), planBeginDate, firstTime, 1, startLeaddate));
            
            info.setLastCmpTime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), planBeginDate, endTime, 1, leaddate));
            
            break;
          }
          index++;
          leaddate = calculateLead(classTermId, index, true, leaddate, startTimeMap);
          index = resetIndex(classTermId, index, true, startTimeMap);
          findTime(classTermId, index, startTime, endTime, startTimeMap, endTimeMap);
          dototalHours = dototalHours.add(new BigDecimal(DateMinus(startTime, endTime).doubleValue()));
        }
        if (i != n - 1)
        {
          startTime.setTime(endTime.getTime());
          index = findEndTime(classTermId, startTime, endTime, startTimeMap, endTimeMap);
          doHours = (BigDecimal)moveTimeMap.get(operationId);
          
          dototalHours = new BigDecimal(DateMinus(startTime, endTime).doubleValue());
          for (;;)
          {
            if (doHours.compareTo(dototalHours) <= 0)
            {
              endTime = addTime(endTime, -dototalHours.subtract(doHours).doubleValue());
              if (!isZeroTime(endTime)) {
                break;
              }
              leaddate++;
              endTime = addTime(endTime, -24.0D);
              break;
            }
            index++;
            leaddate = calculateLead(classTermId, index, true, leaddate, startTimeMap);
            index = resetIndex(classTermId, index, true, startTimeMap);
            findTime(classTermId, index, startTime, endTime, startTimeMap, endTimeMap);
            dototalHours = dototalHours.add(new BigDecimal(DateMinus(startTime, endTime).doubleValue()));
          }
          startTime.setTime(endTime.getTime());
        }
      }
    }
  }
  
  private void backWardSchedul(ManufactureOrderInfo mo, IFactoryCalendar workCalendarFactory, Map classTermMap, Map startTimeMap, Map endTimeMap, Map sumHoursMap, Map queuingTimeMap, Map workTimeMap, Map moveTimeMap)
    throws BOSException, EASBizException
  {
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    ManufactureOrderTechnicsInfo info = null;
    String operationId = null;
    String classTermId = null;
    Timestamp startTime = null;
    Timestamp endBeginDate = mo.getPlanEndDate();
    if (!workCalendarFactory.isWorkDay(mo.getStorageOrgUnit().getId().toString(), mo.getPlanEndDate())) {
      endBeginDate = setWorkDate(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), mo.getPlanEndDate(), false);
    }
    Timestamp endTime = setDafultTime(endBeginDate);
    startTime = setDafultTime(mo.getPlanBeginDate());
    Timestamp firstEndTime = setDafultTime(endBeginDate);
    
    int index = -1;
    BigDecimal doHours = SCMConstant.BIGDECIMAL_ZERO;
    BigDecimal dototalHours = SCMConstant.BIGDECIMAL_ZERO;
    BigDecimal doQueuingHours = SCMConstant.BIGDECIMAL_ZERO;
    BigDecimal dosumHours = SCMConstant.BIGDECIMAL_ZERO;
    int leaddate = 0;
    int endLeaddate = 0;
    
    int n = technicsCol.size();
    for (int i = n - 1; i >= 0; i--)
    {
      info = technicsCol.get(i);
      operationId = info.getOperation().getId().toString();
      classTermId = (String)classTermMap.get(info.getWorkcenter().getId().toString());
      if (isZeroTime(endTime))
      {
        endTime = addTime(endTime, 24.0D);
        leaddate += 1;
      }
      index = findStartTime(classTermId, startTime, endTime, startTimeMap, endTimeMap);
      if (index != -1)
      {
        if (i != n - 1)
        {
          dototalHours = new BigDecimal(DateMinus(startTime, endTime).doubleValue());
          doHours = (BigDecimal)moveTimeMap.get(operationId);
          for (;;)
          {
            if (doHours.compareTo(dototalHours) <= 0)
            {
              startTime = addTime(startTime, dototalHours.subtract(doHours).doubleValue());
              endTime.setTime(startTime.getTime());
              break;
            }
            index--;
            leaddate = calculateLead(classTermId, index, false, leaddate, startTimeMap);
            index = resetIndex(classTermId, index, false, startTimeMap);
            findTime(classTermId, index, startTime, endTime, startTimeMap, endTimeMap);
            dototalHours = dototalHours.add(new BigDecimal(DateMinus(startTime, endTime).doubleValue()));
          }
          if (isZeroTime(endTime))
          {
            endTime = addTime(endTime, 24.0D);
            leaddate += 1;
          }
          index = findStartTime(classTermId, startTime, endTime, startTimeMap, endTimeMap);
        }
        if (queuingTimeMap != null)
        {
          doQueuingHours = (BigDecimal)queuingTimeMap.get(operationId);
          dosumHours = new BigDecimal(DateMinus(startTime, endTime).doubleValue());
          for (;;)
          {
            if (doQueuingHours.compareTo(dosumHours) <= 0)
            {
              startTime = addTime(startTime, dosumHours.subtract(doQueuingHours).doubleValue());
              endTime.setTime(startTime.getTime());
              break;
            }
            index--;
            leaddate = calculateLead(classTermId, index, false, leaddate, startTimeMap);
            index = resetIndex(classTermId, index, false, startTimeMap);
            findTime(classTermId, index, startTime, endTime, startTimeMap, endTimeMap);
            dosumHours = dosumHours.add(new BigDecimal(DateMinus(startTime, endTime).doubleValue()));
          }
          if (isZeroTime(endTime))
          {
            endTime = addTime(endTime, 24.0D);
            leaddate += 1;
          }
          index = findStartTime(classTermId, startTime, endTime, startTimeMap, endTimeMap);
        }
        firstEndTime.setTime(endTime.getTime());
        if (isZeroTime(endTime)) {
          endLeaddate = leaddate - 1;
        } else {
          endLeaddate = leaddate;
        }
        dototalHours = new BigDecimal(DateMinus(startTime, endTime).doubleValue());
        doHours = (BigDecimal)workTimeMap.get(operationId);
        for (;;)
        {
          if (doHours.compareTo(dototalHours) <= 0)
          {
            startTime = addTime(startTime, dototalHours.subtract(doHours).doubleValue());
            if (queuingTimeMap == null)
            {
              info.setLastWorktime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), endBeginDate, startTime, 2, leaddate));
              
              info.setLastCmpTime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), endBeginDate, firstEndTime, 2, endLeaddate));
              if (i != n - 1) {}
            }
            else
            {
              info.setEarlistWoktime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), endBeginDate, startTime, 2, leaddate));
              
              info.setEarlistCmpTime(setWorkTime(workCalendarFactory, mo.getStorageOrgUnit().getId().toString(), endBeginDate, firstEndTime, 2, endLeaddate));
            }
            endTime.setTime(startTime.getTime());
            break;
          }
          index--;
          leaddate = calculateLead(classTermId, index, false, leaddate, startTimeMap);
          index = resetIndex(classTermId, index, false, startTimeMap);
          findTime(classTermId, index, startTime, endTime, startTimeMap, endTimeMap);
          dototalHours = dototalHours.add(new BigDecimal(DateMinus(startTime, endTime).doubleValue()));
        }
        if (i != 0) {}
      }
    }
  }
  
  private void getOperationTime(Context ctx, ManufactureOrderInfo mo, Map QueuingTimeMap, Map WorkTimeMap, Map MoveTimeMap)
  {
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    ManufactureOrderTechnicsInfo info = null;
    BigDecimal processBatchNum = new BigDecimal(0.0D);
    BigDecimal workTime = new BigDecimal(0.0D);
    BigDecimal qty = mo.getQty();
    String operationId = null;
    int i = 0;
    for (int n = technicsCol.size(); i < n; i++)
    {
      info = technicsCol.get(i);
      processBatchNum = info.getProcessBatch();
      operationId = info.getOperation().getId().toString();
      OprTimeUnitEnum unit = info.getTimeUnit();
      
      QueuingTimeMap.put(operationId, transferTime(unit, info.getQueuingTime()));
      if ((processBatchNum != null) && (processBatchNum.compareTo(new BigDecimal(0.0D)) > 0)) {
        workTime = info.getWorkTime().multiply(qty).divide(processBatchNum, 2, 4);
      } else {
        workTime = info.getWorkTime();
      }
      WorkTimeMap.put(operationId, transferTime(unit, info.getPrepareTime().add(workTime)));
      MoveTimeMap.put(operationId, transferTime(unit, info.getMovingTime().add(info.getWaitingTime())));
    }
  }
  
  private BigDecimal transferTime(OprTimeUnitEnum unit, BigDecimal time)
  {
    if ((unit != null) && (unit.getValue() == 3)) {
      return time.divide(new BigDecimal(60), 2, 4);
    }
    if ((unit != null) && (unit.getValue() == 4)) {
      return time.divide(new BigDecimal(3600), 2, 4);
    }
    return time;
  }
  
  private boolean isSupplyClassTerm(Context ctx, ManufactureOrderInfo mo)
    throws BOSException, EASBizException
  {
    Map classTermMap = new HashMap();
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    ManufactureOrderTechnicsInfo info = null;
    Set workCenterIds = new HashSet();
    int i = 0;
    for (int n = technicsCol.size(); i < n; i++)
    {
      info = technicsCol.get(i);
      if ((info.getWorkcenter() == null) || (info.getWorkcenter().getId() == null)) {
        return false;
      }
      workCenterIds.add(info.getWorkcenter().getId().toString());
    }
    StringBuffer sqlSB = new StringBuffer("");
    sqlSB.setLength(0);
    sqlSB.append(" select t1.fid,t1.FClassTeamID from T_MM_WorkCenter t1 ").append(" where t1.fid in ( ").append(SQLUtil.arrayToString(workCenterIds.toArray())).append(")");
    
    List paramLst = new ArrayList();
    paramLst.clear();
    IRowSet rs = null;
    rs = DbUtil.executeQuery(ctx, sqlSB.toString(), paramLst.toArray());
    try
    {
      while (rs.next())
      {
        if ((rs.getString("FClassTeamID") == null) || (rs.getString("FClassTeamID").length() == 0))
        {
          boolean bool = false;
          
          return bool;
        }
        classTermMap.put(rs.getString("fid"), rs.getString("FClassTeamID"));
      }
    }
    catch (SQLException sqlExp)
    {
      sqlExp = 
      
        sqlExp;throw new SQLDataException(sqlExp);
    }
    finally {}
    i = 0;
    for (int n = technicsCol.size(); i < n; i++)
    {
      info = technicsCol.get(i);
      if (!classTermMap.containsKey(info.getWorkcenter().getId().toString())) {
        return false;
      }
    }
    return true;
  }
  
  private boolean getClassTermSort(Context ctx, ManufactureOrderInfo mo, Map classTermMap, Map startTimeMap, Map endTimeMap, Map sumHoursMap)
    throws BOSException, EASBizException
  {
    boolean result = true;
    
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    Set classTermIds = new HashSet();
    ManufactureOrderTechnicsInfo info = null;
    Set workCenterIds = new HashSet();
    
    int i = 0;
    for (int n = technicsCol.size(); i < n; i++)
    {
      info = technicsCol.get(i);
      if ((info.getWorkcenter() == null) || (info.getWorkcenter().getId() == null)) {
        return false;
      }
      workCenterIds.add(info.getWorkcenter().getId().toString());
    }
    StringBuffer sqlSB = new StringBuffer("");
    sqlSB.setLength(0);
    sqlSB.append(" select t1.fid,t1.FClassTeamID from T_MM_WorkCenter t1 ").append(" where t1.fid in ( ").append(SQLUtil.arrayToString(workCenterIds.toArray())).append(")");
    
    List paramLst = new ArrayList();
    paramLst.clear();
    IRowSet rs = null;
    rs = DbUtil.executeQuery(ctx, sqlSB.toString(), paramLst.toArray());
    try
    {
      while (rs.next())
      {
        if ((rs.getString("FClassTeamID") == null) || (rs.getString("FClassTeamID").length() == 0))
        {
          boolean bool1 = false;
          
          return bool1;
        }
        classTermMap.put(rs.getString("fid"), rs.getString("FClassTeamID"));
      }
    }
    catch (SQLException sqlExp)
    {
      sqlExp = 
      
        sqlExp;throw new SQLDataException(sqlExp);
    }
    finally {}
    i = 0;
    for (int n = technicsCol.size(); i < n; i++)
    {
      info = technicsCol.get(i);
      if (!classTermMap.containsKey(info.getWorkcenter().getId().toString())) {
        return false;
      }
      classTermIds.add((String)classTermMap.get(info.getWorkcenter().getId().toString()));
    }
    sqlSB.setLength(0);
    sqlSB.append(" select t1.fid,t2.fstartTime,t2.fstartRestTime,t2.fendTime,t2.fendRestTime").append("  from T_MM_ClassTeam t1 inner join T_MM_ClassTeamEntry t2 on t1.fid=t2.FParentID ").append(" where t1.fid in ( ").append(SQLUtil.arrayToString(classTermIds.toArray())).append(")").append(" and FStorageOrgUnitID=?").append(" order by t2.fstarttime ");
    
    paramLst.clear();
    paramLst.add(mo.getStorageOrgUnit().getId().toString());
    rs = DbUtil.executeQuery(ctx, sqlSB.toString(), paramLst.toArray());
    try
    {
      String classTermId = null;
      Object startTimeList = null;
      List endTimeList = null;
      
      Timestamp startTime = null;
      Timestamp startRestTime = null;
      Timestamp endTime = null;
      Timestamp endRestTime = null;
      while (rs.next())
      {
        classTermId = rs.getString("fid");
        if (startTimeMap.containsKey(classTermId))
        {
          startTimeList = (ArrayList)startTimeMap.get(classTermId);
        }
        else
        {
          startTimeList = new ArrayList();
          startTimeMap.put(classTermId, startTimeList);
        }
        if (endTimeMap.containsKey(classTermId))
        {
          endTimeList = (ArrayList)endTimeMap.get(classTermId);
        }
        else
        {
          endTimeList = new ArrayList();
          endTimeMap.put(classTermId, endTimeList);
        }
        startTime = rs.getTimestamp("fstartTime");
        
        startRestTime = rs.getTimestamp("fstartRestTime");
        endTime = transTimeForEndTime(startTime, rs.getTimestamp("fendTime"));
        endRestTime = rs.getTimestamp("fendRestTime");
        if (startRestTime != null)
        {
          if (dateCompare(startTime, startRestTime) == 0)
          {
            ((List)startTimeList).add(endRestTime);
            endTimeList.add(endTime);
          }
          else
          {
            ((List)startTimeList).add(startTime);
            if (dateCompare(endRestTime, endTime) == 0)
            {
              endTimeList.add(transTime(startRestTime));
            }
            else
            {
              endTimeList.add(transTime(startRestTime));
              ((List)startTimeList).add(endRestTime);
              
              endTimeList.add(endTime);
            }
          }
        }
        else
        {
          ((List)startTimeList).add(startTime);
          
          endTimeList.add(endTime);
        }
      }
      Iterator iter = startTimeMap.keySet().iterator();
      Map startToEndTiemMap = null;
      while (iter.hasNext())
      {
        startToEndTiemMap = new HashMap();
        classTermId = (String)iter.next();
        startTimeList = (ArrayList)startTimeMap.get(classTermId);
        endTimeList = (ArrayList)endTimeMap.get(classTermId);
        
        i = 0;
        for (int n = ((List)startTimeList).size(); i < n; i++) {
          startToEndTiemMap.put(((List)startTimeList).get(i), endTimeList.get(i));
        }
        startTimeList = dateSort((List)startTimeList);
        startTimeMap.put(classTermId, startTimeList);
        endTimeList.clear();
        i = 0;
        for (int n = ((List)startTimeList).size(); i < n; i++) {
          endTimeList.add(startToEndTiemMap.get(((List)startTimeList).get(i)));
        }
        endTimeMap.put(classTermId, endTimeList);
      }
    }
    catch (SQLException sqlExp)
    {
      sqlExp = 
      
        sqlExp;throw new SQLDataException(sqlExp);
    }
    finally {}
    return result;
  }
  
  private List dateSort(List list)
  {
    List sortList = new ArrayList();
    Timestamp[] timeArray = new Timestamp[list.size()];
    
    int i = 0;
    for (int n = list.size(); i < n; i++) {
      if (i == 0)
      {
        timeArray[i] = ((Timestamp)list.get(i));
      }
      else
      {
        Timestamp temp = (Timestamp)list.get(i);
        for (int j = i - 1; j >= 0; j--) {
          if (dateCompare(temp, timeArray[j]) < 0)
          {
            timeArray[(j + 1)] = timeArray[j];
            timeArray[j] = temp;
          }
          else
          {
            timeArray[(j + 1)] = temp;
            break;
          }
        }
      }
    }
    i = 0;
    for (int n = timeArray.length; i < n; i++) {
      sortList.add(timeArray[i]);
    }
    return sortList;
  }
  
  private Timestamp setWorkDate(IFactoryCalendar workCalendarFactory, String orgID, java.util.Date date, boolean isForward)
    throws BOSException, EASBizException
  {
    int direct = 1;
    int daycount = 1;
    if (!isForward)
    {
      direct = 2;
      daycount = 0;
    }
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date);
    Calendar calendar2 = Calendar.getInstance();
    java.util.Date workDate = workCalendarFactory.findDateFromFCalendar(orgID, date, direct, daycount, 2);
    if (workDate != null) {
      calendar2.setTime(workDate);
    } else {
      calendar2.setTime(date);
    }
    calendar2.set(10, calendar1.get(10));
    calendar2.set(12, calendar1.get(12));
    calendar2.set(13, calendar1.get(13));
    return new Timestamp(calendar2.getTimeInMillis());
  }
  
  private Timestamp setWorkTime(IFactoryCalendar workCalendarFactory, String orgID, Timestamp date1, Timestamp date2, int direct, int leaddata)
    throws BOSException, EASBizException
  {
    Calendar calendar1 = Calendar.getInstance();
    java.util.Date workDate = workCalendarFactory.findDateFromFCalendar(orgID, date1, direct, leaddata, 2);
    if (workDate != null) {
      calendar1.setTime(workDate);
    } else {
      calendar1.setTime(date1);
    }
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(date2);
    calendar2.set(1, calendar1.get(1));
    calendar2.set(2, calendar1.get(2));
    calendar2.set(5, calendar1.get(5));
    return new Timestamp(calendar2.getTimeInMillis());
  }
  
  private BigDecimal DateMinus(java.util.Date date1, java.util.Date date2)
  {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date1);
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(date2);
    
    long datem1 = calendar1.getTimeInMillis();
    long datem2 = calendar2.getTimeInMillis();
    
    double times = (datem2 - datem1) / 3600000.0D;
    
    BigDecimal result = new BigDecimal(times);
    return result.setScale(2, 4);
  }
  
  private int findEndTime(String billID, Timestamp startTime, Timestamp endTime, Map startTimeMap, Map endTimeMap)
  {
    List startTimeList = null;
    List endTimeList = null;
    startTimeList = new ArrayList();
    endTimeList = new ArrayList();
    
    startTimeList = (List)startTimeMap.get(billID);
    endTimeList = (List)endTimeMap.get(billID);
    
    int i = 0;
    for (int n = endTimeList.size(); i < n; i++) {
      if (dateCompare(startTime, (Timestamp)endTimeList.get(i)) <= 0)
      {
        if (dateCompare(startTime, (Timestamp)startTimeList.get(i)) <= 0) {
          startTime.setTime(((Timestamp)startTimeList.get(i)).getTime());
        }
        endTime.setTime(((Timestamp)endTimeList.get(i)).getTime());
        return i;
      }
    }
    return -1;
  }
  
  private int findStartTime(String billID, Timestamp startTime, Timestamp endTime, Map startTimeMap, Map endTimeMap)
  {
    List startTimeList = null;
    List endTimeList = null;
    startTimeList = new ArrayList();
    endTimeList = new ArrayList();
    
    startTimeList = (List)startTimeMap.get(billID);
    endTimeList = (List)endTimeMap.get(billID);
    for (int i = startTimeList.size() - 1; i >= 0; i--) {
      if (dateCompare(endTime, (Timestamp)startTimeList.get(i)) >= 0)
      {
        if (dateCompare(endTime, (Timestamp)endTimeList.get(i)) >= 0) {
          endTime.setTime(((Timestamp)endTimeList.get(i)).getTime());
        }
        startTime.setTime(((Timestamp)startTimeList.get(i)).getTime());
        return i;
      }
    }
    return -1;
  }
  
  private void findTime(String billID, int index, Timestamp startTime, Timestamp endTime, Map startTimeMap, Map endTimeMap)
  {
    List startTimeList = null;
    List endTimeList = null;
    startTimeList = new ArrayList();
    endTimeList = new ArrayList();
    
    startTimeList = (List)startTimeMap.get(billID);
    endTimeList = (List)endTimeMap.get(billID);
    int i = index % startTimeList.size();
    startTime.setTime(((Timestamp)startTimeList.get(i)).getTime());
    endTime.setTime(((Timestamp)endTimeList.get(i)).getTime());
  }
  
  private int calculateLead(String billID, int index, boolean isForWard, int leaddata, Map timeMap)
  {
    int result = leaddata;
    if (!isForWard)
    {
      if (index < 0) {
        result++;
      }
    }
    else
    {
      List timeList = new ArrayList();
      timeList = (List)timeMap.get(billID);
      if (index == timeList.size()) {
        result++;
      }
    }
    return result;
  }
  
  private int resetIndex(String billID, int index, boolean isForWard, Map timeMap)
  {
    int result = index;
    List timeList = new ArrayList();
    timeList = (List)timeMap.get(billID);
    if (!isForWard)
    {
      if (index < 0) {
        result = timeList.size() - 1;
      }
    }
    else if (index == timeList.size()) {
      result = 0;
    }
    return result;
  }
  
  private int dateCompare(java.util.Date date1, java.util.Date date2)
  {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date1);
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(date2);
    int result = 0;
    if (calendar1.getTimeInMillis() > calendar2.getTimeInMillis()) {
      result = 1;
    } else if (calendar1.getTimeInMillis() == calendar2.getTimeInMillis()) {
      result = 0;
    } else {
      result = -1;
    }
    return result;
  }
  
  private Timestamp transTime(Timestamp date)
  {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date);
    if (calendar1.get(11) == 0) {
      calendar1.add(6, 1);
    }
    return new Timestamp(calendar1.getTimeInMillis());
  }
  
  private Timestamp transTimeForEndTime(Timestamp stDate, Timestamp endDate)
  {
    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    calendar1.setTime(stDate);
    calendar2.setTime(endDate);
    if (calendar1.getTimeInMillis() >= calendar2.getTimeInMillis()) {
      calendar2.add(6, 1);
    }
    return new Timestamp(calendar2.getTimeInMillis());
  }
  
  private Timestamp setDafultTime(Timestamp date)
  {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date);
    if (calendar1.get(1) != 1970)
    {
      calendar1.set(1, 1970);
      calendar1.set(2, 0);
      calendar1.set(5, 1);
    }
    return new Timestamp(calendar1.getTimeInMillis());
  }
  
  private boolean isZeroTime(Timestamp date)
  {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(date);
    if (calendar1.get(10) != 0) {
      return false;
    }
    if (calendar1.get(13) != 0) {
      return false;
    }
    if (calendar1.get(12) != 0) {
      return false;
    }
    return true;
  }
  
  private Timestamp addTime(Timestamp date, double lead)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    long datem = calendar.getTimeInMillis();
    long datem1 = (long) (datem + (lead * 3600000.0D));
    return new Timestamp(datem1);
  }
  
  protected void _processCheck(Context ctx, IObjectPK pk, IObjectCollection objectCollection)
    throws BOSException, EASBizException
  {
    if (objectCollection.size() <= 0) {
      return;
    }
    ManufactureOrderTechnicsInfo info = null;
    boolean hasValidEntry = false;
    for (int i = 0; i < objectCollection.size(); i++)
    {
      info = (ManufactureOrderTechnicsInfo)objectCollection.getObject(0);
      if (info.isIsCheckPoint()) {
        hasValidEntry = true;
      }
    }
    if (!hasValidEntry) {
      throw new ManufactureOrderException(ManufactureOrderException.TRANSFER_FAIL);
    }
    BOSObjectType soruceBOSType = new BOSObjectType("1D0D80DD");
    BOSObjectType destBOSType = new BOSObjectType("751CA7E1");
    
    ManufactureOrderCollection orderCollection = new ManufactureOrderCollection();
    IManufactureOrder order = ManufactureOrderFactory.getLocalInstance(ctx);
    
    ManufactureOrderInfo orderInfo = order.getManufactureOrderInfo(pk);
    orderInfo.put("technics", objectCollection);
    
    orderCollection.add(orderInfo);
    
    CommonUtils.mapppingToBills2(ctx, null, null, soruceBOSType, destBOSType, "42GnVN7kRJuRWNrap6GLrgRRIsQ=", orderCollection, true);
  }
  
  protected void _productCheck(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BOSObjectType soruceBOSType = new BOSObjectType("1D0D80DD");
    BOSObjectType destBOSType = new BOSObjectType("751CA7E1");
    
    ManufactureOrderCollection orderCollection = new ManufactureOrderCollection();
    IManufactureOrder order = ManufactureOrderFactory.getLocalInstance(ctx);
    
    ManufactureOrderInfo orderInfo = order.getManufactureOrderInfo(pk);
    orderCollection.add(orderInfo);
    
    CommonUtils.mapppingToBills2(ctx, null, null, soruceBOSType, destBOSType, "GxU3S1NlQFSqoMNp/jngCgRRIsQ=", orderCollection, true);
  }
  
  protected IObjectValue _importData(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo mo = (ManufactureOrderInfo)model;
    processBOTPDefault(ctx, mo, true);
    return mo;
  }
  
  protected IObjectCollection _getManOrderCollectionForTree(Context ctx, FilterInfo filterInfo)
    throws BOSException
  {
    EntityViewInfo viewInfo = new EntityViewInfo();
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("id"));
    sic.add(new SelectorItemInfo("longNumber"));
    viewInfo.setSelector(sic);
    viewInfo.setFilter(filterInfo);
    
    MetaDataPK mainQueryPK = MetaDataPK.create("com.kingdee.eas.mm.mo.app", "ManufactureOrderTreeQuery");
    IQueryExecutor exec = QueryExecutorFactory.getLocalInstance(ctx, mainQueryPK);
    exec.setObjectView(viewInfo);
    IRowSet queryRs = exec.executeQuery();
    
    ManufactureOrderCollection moCol = new ManufactureOrderCollection();
    ManufactureOrderCollection moColRtn = new ManufactureOrderCollection();
    ManufactureOrderInfo moInfo = null;
    String orderId = null;
    String longNumber = null;
    try
    {
      while (queryRs.next())
      {
        orderId = queryRs.getString("id");
        longNumber = queryRs.getString("longNumber");
        if ((longNumber != null) && (longNumber.equals(orderId)))
        {
          moInfo = new ManufactureOrderInfo();
          moInfo.setId(BOSUuid.read(orderId));
          moInfo.setLongNumber(longNumber);
          moCol.add(moInfo);
        }
      }
    }
    catch (SQLException e1)
    {
      throw new BOSException(e1);
    }
    if (moCol.size() > 0)
    {
      StringBuffer sql_getSubOrder = new StringBuffer();
      sql_getSubOrder.append("SELECT mo.FID,mo.FNumber,mo.FLongNumber,mo.FBirthType,mo.FTransactionTypeID,");
      sql_getSubOrder.append("project.FID AS ProjectID,project.FNumber AS ProjectNumber,");
      sql_getSubOrder.append("track.FID AS TrackID,track.FNumber AS TrackNumber,split.FSplitOperationNo ");
      sql_getSubOrder.append("FROM T_MM_ManufactureOrder AS mo ");
      sql_getSubOrder.append("LEFT OUTER JOIN T_MM_TrackNumber AS track ON mo.FTrackID = track.FID ");
      sql_getSubOrder.append("LEFT OUTER JOIN T_MM_Project AS project ON mo.FProjectID = project.FID ");
      sql_getSubOrder.append("LEFT OUTER JOIN  ");
      
      sql_getSubOrder.append("(SELECT max(FSplitOperationNo) AS FSplitOperationNo,FChildID ");
      sql_getSubOrder.append(" FROM T_MM_MOSplitRecord group by FChildID) AS split ON mo.FID = split.FChildID");
      
      StringBuffer whereStr = new StringBuffer();
      StringBuffer eachExcuteStr = new StringBuffer();
      int begin = 0;int end = 0;
      
      int i = 0;
      for (int time = moCol.size() % 2000 == 0 ? moCol.size() / 2000 : moCol.size() / 2000 + 1; i < time; i++)
      {
        begin = 2000 * i;
        if (i + 1 < time) {
          end = 2000 * (i + 1);
        } else {
          end = moCol.size();
        }
        eachExcuteStr.setLength(0);
        whereStr.setLength(0);
        String parentLN = "";
        String childrenLN = "";
        for (int idBegin = begin; idBegin < end; idBegin++) {
          if (moCol.get(idBegin) != null)
          {
            parentLN = moCol.get(idBegin).getId().toString();
            childrenLN = parentLN + "!%";
            if (idBegin == begin) {
              whereStr.append(" WHERE mo.FLongNumber like '").append(childrenLN).append("' or mo.FLongNumber = '").append(parentLN + "'");
            } else {
              whereStr.append(" OR mo.FLongNumber like '").append(childrenLN).append("' or mo.FLongNumber = '").append(parentLN + "'");
            }
          }
        }
        eachExcuteStr.append(sql_getSubOrder.toString()).append(whereStr);
        IRowSet rs = DbUtil.executeQuery(ctx, eachExcuteStr.toString());
        try
        {
          while (rs.next())
          {
            moInfo = new ManufactureOrderInfo();
            moInfo.setId(BOSUuid.read(rs.getString("FID")));
            moInfo.setNumber(rs.getString("FNumber"));
            moInfo.setLongNumber(rs.getString("FLongNumber"));
            moInfo.setBirthType(MOBirthTypeEnum.getEnum(rs.getInt("FBirthType")));
            moInfo.setSplitOperationNo(rs.getInt("FSplitOperationNo"));
            if (rs.getString("ProjectID") != null)
            {
              ProjectInfo projectInfo = new ProjectInfo();
              projectInfo.setId(BOSUuid.read(rs.getString("ProjectID")));
              projectInfo.setNumber(rs.getString("ProjectNumber"));
              moInfo.setProject(projectInfo);
            }
            if (rs.getString("TrackID") != null)
            {
              TrackNumberInfo trackInfo = new TrackNumberInfo();
              trackInfo.setId(BOSUuid.read(rs.getString("TrackID")));
              trackInfo.setNumber(rs.getString("TrackNumber"));
              moInfo.setTrackNumber(trackInfo);
            }
            if (rs.getString("FTransactionTypeID") != null)
            {
              ProductTransactionTypeInfo transInfo = new ProductTransactionTypeInfo();
              transInfo.setId(BOSUuid.read(rs.getString("FTransactionTypeID")));
              moColRtn.add(moInfo);
            }
          }
        }
        catch (SQLException e)
        {
          throw new BOSException(e);
        }
      }
    }
    return moColRtn;
  }
  
  protected ManufactureOrderCollection getSubManOrderByParent(Context ctx, ManufactureOrderCollection moCol)
    throws BOSException
  {
    StringBuffer oql = new StringBuffer();
    oql.append("select id,number,longNumber,trackNumber.number,projectNumber.number ");
    String childrenLN = null;
    String parentLN = null;
    if (moCol.size() > 0)
    {
      parentLN = moCol.get(0).getId().toString();
      childrenLN = parentLN + "!%";
      oql.append("where longNumber like '" + childrenLN + "' or longNumber = '" + parentLN + "'");
      int index = 1;
      for (int size = moCol.size(); index < size; index++)
      {
        parentLN = moCol.get(index).getId().toString();
        childrenLN = parentLN + "!%";
        oql.append(" or longNumber like '" + childrenLN + "' or longNumber = '" + parentLN + "'");
      }
      moCol = getManufactureOrderCollection(ctx, oql.toString());
    }
    return moCol;
  }
  
  protected void _batchWriteBackTotalDispatchQty(Context ctx, Map param, int flag)
    throws BOSException, EASBizException
  {
    Set parentSet = param.keySet();
    
    Iterator parentIt = parentSet.iterator();
    
    Map childMap = null;
    
    String pk = null;
    
    Set childSet = null;
    
    Iterator childIt = null;
    
    String operationNo = null;
    
    List list = new ArrayList();
    
    StringBuffer querySB = new StringBuffer();
    
    StringBuffer updateSB = new StringBuffer();
    
    NumberFormat myFormat = BOSLocaleUtil.getDecimalFormat();
    
    String oper = "+";
    
    String unOper = "-";
    if (flag == 0)
    {
      oper = "-";
      unOper = "-";
    }
    StringBuffer moIds = new StringBuffer();
    
    String errorMessage = null;
    
    Iterator moIdsIt = parentSet.iterator();
    while (moIdsIt.hasNext()) {
      moIds.append("'").append(moIdsIt.next().toString()).append("'").append(",");
    }
    moIds.append("'null'");
    if (flag == 1)
    {
      errorMessage = MOUtil.isManufactureOrderClosed(ctx, moIds.toString(), BatchActionEnum.AUDIT);
      if (!StringUtils.isEmpty(errorMessage)) {
        throw new ManufactureOrderException(ManufactureOrderException.AUDITUNSUCCESS, new String[] { errorMessage });
      }
    }
    else
    {
      errorMessage = MOUtil.isManufactureOrderClosed(ctx, moIds.toString(), BatchActionEnum.UNAUDIT);
      if (!StringUtils.isEmpty(errorMessage)) {
        throw new ManufactureOrderException(ManufactureOrderException.UNAUDITUNSUCCESS, new String[] { errorMessage });
      }
    }
    int isFirstLoadPK = 0;
    if (flag == 1) {
      querySB.append("select t0.FParentID FParentID, (select FNumber from T_MM_ManufactureOrder t1 where t1.FID = t0.FParentID) FNumber, ").append("t0.FOperationNo FOperationNo, t0.FQTY - FTotalSplitQty - FTotalDispatchQty FEnableDispatchQty").append(", FTotalDispatchQty , FFinishedQty ").append(" from T_MM_MFTOrderTechnics as t0 ");
    }
    while (parentIt.hasNext())
    {
      pk = (String)parentIt.next();
      childMap = (Map)param.get(pk);
      childSet = childMap.keySet();
      childIt = childSet.iterator();
      while (childIt.hasNext())
      {
        operationNo = (String)childIt.next();
        BigDecimal qty = (BigDecimal)childMap.get(operationNo);
        if (flag == 1)
        {
          if (isFirstLoadPK == 0)
          {
            querySB.append(" where (FParentID = '").append(pk).append("' ");
            isFirstLoadPK = 1;
          }
          else
          {
            querySB.append(" OR (FParentID = '").append(pk).append("' ");
          }
          querySB.append(" and FOperationNo = ").append(Integer.valueOf(operationNo));
          
          querySB.append(" and ( FQTY - FTotalSplitQty - FTotalDispatchQty < ").append(myFormat.format(qty));
          querySB.append(" or ( FFinishedQty > 0 and FTotalDispatchQty = 0 )))");
        }
        updateSB.append("update T_MM_MFTOrderTechnics as t0 ").append("set FTotalDispatchQty = ").append("t0.FTotalDispatchQty ").append(oper).append(myFormat.format(qty)).append(" where FParentID = '").append(pk).append("' and FOperationNo = ").append(Integer.valueOf(operationNo));
        
        list.add(updateSB.toString());
        updateSB.setLength(0);
        
        updateSB.append("update T_MM_MFTOrderTechnics as t0 ").append("set FUnDispatchQty = ").append("t0.FQTY - FTotalSplitQty ").append(unOper).append(" FTotalDispatchQty").append(" where FParentID = '").append(pk).append("' and FOperationNo = ").append(Integer.valueOf(operationNo));
        
        list.add(updateSB.toString());
        updateSB.setLength(0);
        
        updateSB.append("update T_MM_MFTOrderTechnics as t0 ").append("set (FUnDispatchBaseQty , FTotalDispatchBaseQty) = ").append("(select round(decimal(t0.FUnDispatchQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision),").append("round(decimal(t0.FTotalDispatchQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision) ").append(" from t_bd_multimeasureunit t2 , T_MM_ManufactureOrder t1 ,t_bd_multimeasureunit t3 ").append("where t0.FParentID = t1.FID ").append(" and t1.FMaterialID = t2.FMaterialID and t1.FUnitID = t2.fmeasureunitid ").append(" and t1.FMaterialID = t3.FMaterialID and t1.FBaseUnitID = t3.fmeasureunitid ").append(" and t1.FID = '").append(pk).append("' and t0.FOperationNo = ").append(Integer.valueOf(operationNo)).append(")");
        
        list.add(updateSB.toString());
        updateSB.setLength(0);
      }
    }
    if (flag == 1)
    {
      StringBuffer exceptionSB = new StringBuffer();
      IRowSet rs = DbUtil.executeQuery(ctx, querySB.toString());
      try
      {
        if (rs != null)
        {
          while (rs.next())
          {
            String exPK = rs.getString("FParentID");
            String exOperationNo = String.valueOf(rs.getInt("FOperationNo"));
            Map exChildMap = (Map)param.get(exPK);
            
            BigDecimal exQty = (BigDecimal)exChildMap.get(exOperationNo);
            
            BigDecimal enableDispatchQty = rs.getBigDecimal("FEnableDispatchQty");
            if (enableDispatchQty.compareTo(exQty) < 0)
            {
              String message = getMessage(ctx, "ORDERANDOPERATIONNO", new String[] { rs.getString("FNumber"), exOperationNo, String.valueOf(exQty), enableDispatchQty.signum() == 0 ? "0" : new DecimalFormat("#############.########").format(enableDispatchQty.doubleValue()) });
              
              exceptionSB.append(message).append("\r\n");
            }
            BigDecimal finishedQty = rs.getBigDecimal("FFinishedQty");
            BigDecimal totalDispatchQty = rs.getBigDecimal("FTotalDispatchQty");
            if ((finishedQty.compareTo(SysConstant.BIGZERO) > 0) && (totalDispatchQty.compareTo(SysConstant.BIGZERO) == 0))
            {
              String ms = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.mo.ManufactureOrderResource", "AllreadyReport", new String[] { rs.getString("FNumber"), String.valueOf(rs.getInt("FOperationNo")) });
              
              exceptionSB.append(ms).append("\r\n");
            }
          }
          if ((exceptionSB != null) && (exceptionSB.toString().length() > 0)) {
            throw new ManufactureOrderException(ManufactureOrderException.AUDITFAILURE, new String[] { exceptionSB.toString() });
          }
        }
      }
      catch (SQLException e)
      {
        throw new BOSException(e);
      }
    }
    String[] updateSqls = new String[list.size()];
    int i = 0;
    for (int size = updateSqls.length; i < size; i++) {
      updateSqls[i] = ((String)list.get(i));
    }
    SQLUtil.batchExecuteSql(ctx, updateSqls);
  }
  
  public Object _invoke(Context ctx, String signature, Object[] args)
    throws BOSException, EASBizException
  {
    if ((signature != null) && (signature.equalsIgnoreCase("getProperLotRule")))
    {
      Connection conn = null;
      try
      {
        conn = EJBFactory.getConnection(ctx);
        String materialID = (String)args[0];
        String storageOrgUnitID = (String)args[1];
        return getProperLotRule(ctx, conn, materialID, storageOrgUnitID);
      }
      catch (SQLException exc)
      {
        String storageOrgUnitID;
        return null;
      }
      finally
      {
        SQLUtils.cleanup(conn);
      }
    }
    if ((signature != null) && (signature.equalsIgnoreCase("doAfterSubmitAndAudit")))
    {
      afterSubmit(ctx, new String[] { (String)args[0] });
      
      BatchActionResults batchActionResults = BatchActionResults.populateActionResults(args);
      
      afterAudit(ctx, batchActionResults);
      
      return null;
    }
    if ((signature != null) && (signature.equalsIgnoreCase("lotNumberCheck")))
    {
      lotNumberCheck(ctx, (ManufactureOrderInfo)args[0]);
      return null;
    }
    return null;
  }
  
  protected IRowSet _getPrintDataSet(Context ctx, List moids, boolean subRoutingExpand, int index)
    throws BOSException, EASBizException
  {
    String moid = (String)moids.get(index);
    
    Locale locale = ctx.getLocale();
    
    StringBuffer sql = new StringBuffer();
    
    sql.append("create table Technics (");
    
    sql.append("fid varchar(44),");
    sql.append("foprtseqforsort int,");
    sql.append("foprtsubseqforsort int,");
    
    sql.append("fparentid varchar(44),");
    
    sql.append("foprtseq nvarchar(180),");
    
    sql.append("foprtnumber nvarchar(80),");
    
    sql.append("foprtname nvarchar(80),");
    
    sql.append("foprtdescription nvarchar(255),");
    
    sql.append("fworkcenter nvarchar(80),");
    
    sql.append("forganization nvarchar(80),");
    
    sql.append("fdepartment nvarchar(80),");
    
    sql.append("fiskeyoprt int,");
    
    sql.append("fentrusttype int,");
    
    sql.append("fpreparetime numeric(21,8),");
    
    sql.append("fworktime numeric(21,8),");
    
    sql.append("fqty numeric(21,8),");
    
    sql.append("fissubrouting int)");
    
    String table = null;
    try
    {
      table = TempTablePool.getInstance(ctx).createTempTable(sql.toString());
      sql.setLength(0);
      sql.append("insert into ").append(table).append(" ( ");
      sql.append("fid, fparentid, foprtseq, foprtseqforsort,foprtsubseqforsort,foprtnumber, foprtname, foprtdescription, fworkcenter, forganization, fdepartment, fiskeyoprt, fentrusttype, fpreparetime, fworktime, fqty, fissubrouting");
      sql.append(" ) ");
      sql.append(" select distinct ");
      sql.append(" technics.fid, ");
      sql.append(" technics.fparentid, ");
      sql.append(" to_char(technics.foperationno), ");
      sql.append(" technics.foperationno, ");
      sql.append(" -1, ");
      sql.append(" operation.fnumber, ");
      sql.append(" operation.fname_").append(locale).append(", ");
      sql.append(" technics.foperationremark_").append(locale).append(", ");
      sql.append(" workcenter.fname_").append(locale).append(", ");
      sql.append(" storageorgunit.fname_").append(locale).append(", ");
      sql.append(" adminorgunit.fname_").append(locale).append(", ");
      sql.append(" technics.fiskeyop, ");
      sql.append(" technics.fentrusttype, ");
      sql.append(" technics.fpreparetime, ");
      sql.append(" technics.fworktime, ");
      sql.append(" isnull(manufactureorder.fqty, 0) - isnull(manufactureorder.ftotalsplitqty, 0), ");
      sql.append(" 1 ");
      sql.append(" from t_mm_mftordertechnics as technics ");
      sql.append(" inner join t_mm_manufactureorder as manufactureorder on  technics.fparentid = manufactureorder.fid ");
      sql.append(" left outer join t_mm_operation as operation on technics.foperationid = operation.fid ");
      sql.append(" left outer join t_mm_workcenter as workcenter on technics.fworkcenterid = workcenter.fid ");
      sql.append(" left outer join t_org_storage as storageorgunit on technics.fstorageorgunitid = storageorgunit.fid ");
      sql.append(" left outer join t_org_admin as adminorgunit on technics.fadminorgunitid = adminorgunit.fid ");
      sql.append(" where technics.fparentid = '" + moid + "'");
      DbUtil.execute(ctx, sql.toString());
      EntityViewInfo entityViewInfo;
      if (subRoutingExpand == true)
      {
        entityViewInfo = new EntityViewInfo();
        SelectorItemCollection selectorItemCollection = new SelectorItemCollection();
        selectorItemCollection.add(new SelectorItemInfo("operationNo"));
        
        selectorItemCollection.add(new SelectorItemInfo("operation.id"));
        selectorItemCollection.add(new SelectorItemInfo("operation.name"));
        selectorItemCollection.add(new SelectorItemInfo("operation.number"));
        
        selectorItemCollection.add(new SelectorItemInfo("subRouting.id"));
        selectorItemCollection.add(new SelectorItemInfo("subRouting.name"));
        selectorItemCollection.add(new SelectorItemInfo("subRouting.number"));
        selectorItemCollection.add(new SelectorItemInfo("parent.qty"));
        selectorItemCollection.add(new SelectorItemInfo("parent.totalsplitqty"));
        
        selectorItemCollection.add(new SelectorItemInfo("storageOrgUnit.id"));
        selectorItemCollection.add(new SelectorItemInfo("earlistWoktime"));
        selectorItemCollection.add(new SelectorItemInfo("earlistCmpTime"));
        selectorItemCollection.add(new SelectorItemInfo("baseUnit.id"));
        selectorItemCollection.add(new SelectorItemInfo("unit.id"));
        selectorItemCollection.add(new SelectorItemInfo("qty"));
        selectorItemCollection.add(new SelectorItemInfo("parent.material.id"));
        
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.getFilterItems().add(new FilterItemInfo("parent.id", moid, CompareType.EQUALS));
        entityViewInfo.setFilter(filterInfo);
        entityViewInfo.setSelector(selectorItemCollection);
        CoreBaseCollection technics = ManufactureOrderTechnicsFactory.getLocalInstance(ctx).getCollection(entityViewInfo);
        if ((technics != null) && (technics.size() > 0))
        {
          List technicsList = new ArrayList();
          List subRoutingList = new ArrayList();
          int i = 0;
          for (int count = technics.size(); i < count; i++)
          {
            ManufactureOrderTechnicsInfo info = (ManufactureOrderTechnicsInfo)technics.get(i);
            if (info.getSubRouting() != null)
            {
              technicsList.add(info);
              subRoutingList.add(info.getSubRouting());
            }
          }
          insertSubRouting(ctx, table, moid, technicsList, subRoutingList);
        }
      }
      sql.setLength(0);
      sql.append(" select distinct ");
      sql.append(" technics.fparentid as fparentid, ");
      sql.append(" technics.fid as technicsid, ");
      sql.append(" technics.foprtseq as oprtseq, ");
      sql.append(" technics.foprtseqforsort as oprtseqforsort, ");
      sql.append(" technics.foprtsubseqforsort as oprtsubseqforsort, ");
      sql.append(" technics.foprtnumber as oprtnumber, ");
      sql.append(" technics.foprtname as oprtname, ");
      sql.append(" technics.foprtdescription as oprtdescription, ");
      sql.append(" technics.fworkcenter as workcenter, ");
      sql.append(" technics.forganization as organization, ");
      sql.append(" technics.fdepartment as department, ");
      sql.append(" technics.fiskeyoprt as iskeyoprt, ");
      sql.append(" technics.fentrusttype as entrusttype, ");
      sql.append(" technics.fpreparetime as preparetime, ");
      sql.append(" technics.fworktime as worktime, ");
      sql.append(" technics.fqty as qty, ");
      sql.append(" technics.fissubrouting as issubrouting ");
      sql.append(" from " + table + " as technics ");
      sql.append(" where technics.fparentid = '" + moid + "'");
      sql.append(" order by technics.foprtseqforsort, technics.foprtsubseqforsort");
      return DbUtil.executeQuery(ctx, sql.toString());
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    finally
    {
      TempTablePool.getInstance(ctx).releaseTable(table);
    }
  }
  
  protected IRowSet _getPrintHeadDataSet(Context ctx, List moids)
    throws BOSException
  {
    StringBuffer sql = new StringBuffer();
    
    Locale locale = ctx.getLocale();
    
    String table = null;
    
    sql.append("create table Head (");
    
    sql.append("fid varchar(44),");
    sql.append("findex int,");
    sql.append("fmaterialnumber nvarchar(80),");
    sql.append("fmaterialname nvarchar(80),");
    sql.append("fmaterialmodel nvarchar(80),");
    sql.append("fblankingsize nvarchar(80))");
    
    StringBuffer idBuffer = new StringBuffer();
    
    String[] args = null;
    try
    {
      table = TempTablePool.getInstance(ctx).createTempTable(sql.toString());
      List insertSqls = new ArrayList();
      for (int k = 0; k < moids.size(); k++)
      {
        String moid = (String)moids.get(k);
        idBuffer.append("'").append(moid).append("',");
        EntityViewInfo entityViewInfo = new EntityViewInfo();
        SelectorItemCollection selectorItemCollection = new SelectorItemCollection();
        selectorItemCollection.add(new SelectorItemInfo("material.id"));
        selectorItemCollection.add(new SelectorItemInfo("material.number"));
        selectorItemCollection.add(new SelectorItemInfo("material.name"));
        selectorItemCollection.add(new SelectorItemInfo("material.model"));
        selectorItemCollection.add(new SelectorItemInfo("blkSize"));
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.getFilterItems().add(new FilterItemInfo("parent.id", moid, CompareType.EQUALS));
        entityViewInfo.setFilter(filterInfo);
        entityViewInfo.setSelector(selectorItemCollection);
        CoreBaseCollection stocks = ManufactureOrderStockFactory.getLocalInstance(ctx).getCollection(entityViewInfo);
        if ((stocks != null) && (stocks.size() > 0))
        {
          MMCommonUtils.objectValueSort(stocks, true, "material");
          
          int i = 0;
          for (int count = stocks.size(); i < count; i++)
          {
            ManufactureOrderStockInfo info = (ManufactureOrderStockInfo)stocks.get(i);
            if (!StringUtils.isEmpty(info.getBlkSize()))
            {
              String name = info.getMaterial().getName();
              String number = info.getMaterial().getNumber();
              String model = info.getMaterial().getModel();
              String blankingSize = info.getBlkSize();
              args = new String[] { number, name, model == null ? " " : model, blankingSize == null ? "tttt" : blankingSize };
              break;
            }
          }
          if (args == null)
          {
            ManufactureOrderStockInfo info = (ManufactureOrderStockInfo)stocks.get(0);
            String name = info.getMaterial().getName();
            String number = info.getMaterial().getNumber();
            String model = info.getMaterial().getModel();
            args = new String[] { number, name, model == null ? " " : model, " " };
          }
        }
        else
        {
          args = new String[] { " ", " ", " ", " " };
        }
        sql.setLength(0);
        sql.append("insert into ").append(table).append(" ( ");
        sql.append("fid, findex, fmaterialnumber, fmaterialname, fmaterialmodel,fblankingsize");
        sql.append(" ) ");
        sql.append(" values( ");
        sql.append("'" + moid + "',");
        sql.append(k + ",");
        sql.append("'" + args[0] + "',");
        sql.append("'" + args[1] + "',");
        sql.append("'" + args[2] + "',");
        sql.append("'" + args[3] + "'");
        sql.append(")");
        insertSqls.add(sql.toString());
      }
      if (insertSqls.size() > 0) {
        DBBatchUtil.executeBatch(ctx, insertSqls);
      }
      idBuffer.replace(idBuffer.length() - 1, idBuffer.length(), "");
      
      sql.setLength(0);
      sql.append(" select distinct ");
      sql.append(" manufactureorder.fid as id, ");
      sql.append(" head.findex as kk, ");
      sql.append(" storageorgunit.fname_").append(locale).append(" as storageorgunit, ");
      sql.append(" manufactureorder.fnumber as billnumber, ");
      sql.append(" biztype.fname_").append(locale).append(" as biztype, ");
      sql.append(" material.fnumber as productnumber, ");
      sql.append(" material.fname_").append(locale).append(" as productname, ");
      sql.append(" material.fmodel as productmodel, ");
      sql.append(" material.fpicturenumber as picturenumber, ");
      sql.append(" trade.fname_").append(locale).append(" as brandnumber, ");
      sql.append(" isnull(manufactureorder.fqty, 0) - isnull(manufactureorder.ftotalsplitqty, 0) as qty, ");
      sql.append(" unit.fname_").append(locale).append(" as unit, ");
      sql.append(" multiunit.fqtyprecision").append(" as scale, ");
      sql.append(" manufactureorder.fplanbegindate as planbegindate, ");
      sql.append(" manufactureorder.fplanenddate as planenddate, ");
      sql.append(" head.fmaterialnumber as materialnumber, ");
      sql.append(" head.fmaterialname as materialname, ");
      sql.append(" head.fmaterialmodel as materialmodel, ");
      sql.append(" head.fblankingsize as blankingsize ");
      sql.append(" from t_mm_manufactureorder as manufactureorder ");
      sql.append(" left outer join " + table + " as head on manufactureorder.fid = head.fid ");
      sql.append(" left outer join t_bd_material as material on manufactureorder.fmaterialid = material.fid ");
      sql.append(" left outer join t_scm_biztype as biztype on manufactureorder.fbiztypeid = biztype.fid ");
      sql.append(" left outer join t_scm_billtype as billtype on manufactureorder.fbilltypeid = billtype.fid ");
      sql.append(" left outer join t_org_storage as storageorgunit on manufactureorder.fstorageorgunitid = storageorgunit.fid ");
      sql.append(" left outer join t_bd_measureunit as unit on manufactureorder.funitid = unit.fid ");
      sql.append(" left outer join t_bd_multimeasureunit as multiunit on manufactureorder.funitid = multiunit.fmeasureunitid and multiunit.fmaterialid = manufactureorder.fmaterialid");
      sql.append(" left outer join t_mm_materialtrademark as trade on material.fmaterialtrademark = trade.fid ");
      sql.append(" where manufactureorder.fid in (" + idBuffer.toString() + ")");
      sql.append(" order by head.findex");
      return DbUtil.executeQuery(ctx, sql.toString());
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    finally
    {
      TempTablePool.getInstance(ctx).releaseTable(table);
    }
  }
  
  private void insertSubRouting(Context ctx, String table, String moid, List technicsList, List subRoutingList)
    throws EASBizException, BOSException
  {
    StringBuffer insert = new StringBuffer();
    insert.append(" insert into ").append(table).append(" ( ");
    insert.append(" fid, fparentid, foprtseq,foprtseqforsort, foprtsubseqforsort, foprtnumber, foprtname, foprtdescription, fworkcenter, forganization, fdepartment, fiskeyoprt, fentrusttype, fpreparetime, fworktime, fqty, fissubrouting ) ");
    insert.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    
    Connection connection = null;
    PreparedStatement statement = null;
    try
    {
      connection = EJBFactory.getConnection(ctx);
      statement = connection.prepareStatement(insert.toString());
      if (subRoutingList != null)
      {
        Map params = new HashMap();
        int i = 0;
        for (int count = subRoutingList.size(); i < count; i++)
        {
          ManufactureOrderTechnicsInfo info = (ManufactureOrderTechnicsInfo)technicsList.get(i);
          BigDecimal qty = info.getParent().getQty();
          BigDecimal totalSplitQty = info.getParent().getTotalSplitQty();
          StandardRootingInfo routing = (StandardRootingInfo)subRoutingList.get(i);
          params.clear();
          
          int oprtSeq = info.getOperationNo();
          
          String oprtNumber = info.getOperation().getNumber();
          params.put("ROUTINGID", routing.getId().toString());
          params.put("STORAGEORG", info.getStorageOrgUnit());
          params.put("BEGINTIME", info.getEarlistWoktime());
          params.put("ENDTIME", info.getEarlistCmpTime());
          params.put("BASEUNIT", info.getBaseUnit());
          params.put("BILL_UNIT", info.getUnit());
          params.put("BILL_QTY", info.getQty());
          params.put("MATERIAL", info.getParent().getMaterial());
          ManufactureOrderTechnicsCollection technics = _routingExpand(ctx, params);
          if ((technics != null) && (technics.size() > 0))
          {
            int j = 0;
            for (int size = technics.size(); j < size; j++)
            {
              info = technics.get(j);
              
              statement.setString(1, BOSUuid.create(info.getBOSType()).toString());
              statement.setString(2, moid);
              statement.setString(3, oprtSeq + "." + info.getOperationNo());
              
              statement.setInt(4, oprtSeq);
              statement.setInt(5, info.getOperationNo());
              if (info.getOperation() != null)
              {
                statement.setString(6, oprtNumber + "-" + info.getOperation().getNumber());
                statement.setString(7, info.getOperation().getName());
              }
              else
              {
                statement.setString(6, oprtNumber + ".#");
                statement.setString(7, "");
              }
              statement.setString(8, info.getOperationRemark());
              if (info.getWorkcenter() != null) {
                statement.setString(9, info.getWorkcenter().getName());
              } else {
                statement.setString(9, "");
              }
              if (info.getStorageOrgUnit() != null) {
                statement.setString(10, info.getStorageOrgUnit().getName());
              } else {
                statement.setString(10, "");
              }
              if (info.getAdminOrgUnit() != null) {
                statement.setString(11, info.getAdminOrgUnit().getName());
              } else {
                statement.setString(11, "");
              }
              statement.setInt(12, info.isIsKeyOP() == true ? 1 : 0);
              statement.setInt(13, info.getEntrustType().getValue());
              statement.setBigDecimal(14, info.getPrepareTime());
              statement.setBigDecimal(15, info.getWorkTime());
              statement.setBigDecimal(16, qty.subtract(totalSplitQty));
              statement.setInt(17, 0);
              statement.addBatch();
            }
          }
        }
        statement.executeBatch();
      }
    }
    catch (Exception exc)
    {
      throw new BOSException(exc);
    }
    finally
    {
      SQLUtils.cleanup(statement, connection);
    }
  }
  
  protected IRowSet _getWpSeq(Context ctx, Map paraMap)
    throws BOSException, EASBizException
  {
    StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)paraMap.get("STORAGEORG");
    String routingID = (String)paraMap.get("ROUTINGID");
    BomInfo bom = (BomInfo)paraMap.get("BOM");
    
    StringBuffer querySB = new StringBuffer();
    
    querySB.append("SELECT T1.FBomItemID FBomItemID, T1.FUnitQty FUnitQty, T2.FWpSeq FWpSeq ,T2.FOperationID FOperationID ").append(" FROM T_MM_PBOM T0 ").append(" INNER JOIN T_MM_PBOMEntry T1 ").append(" ON T0.FID = T1.FParentID ").append(" INNER JOIN T_MM_MaterialRWP T2 ").append(" ON T1.FRoutingItemID = T2.FID ").append("WHERE T0.FStorageOrgUnitID = '").append(storageOrgUnit.getId().toString()).append("' AND t0.FBomID = '").append(bom.getId().toString()).append("' AND t0.FRoutingID = '").append(routingID).append("' ");
    
    return DbUtil.executeQuery(ctx, querySB.toString());
  }
  
  private void updateReqPlanData(Context ctx, BatchExecuteParamsEntry[] entries, int bizAction, String tempTableName)
    throws Exception
  {
    IObjectPK[] array = new IObjectPK[entries.length];
    int i = 0;
    for (int count = entries.length; i < count; i++)
    {
      BatchExecuteParamsEntry entry = entries[i];
      IObjectPK pk = (IObjectPK)entry.get(0);
      array[i] = pk;
    }
    String ids = StringUtils.arrayToString(array, "','");
    IReqPlanReceiveReqDataFacade reqPlanReceiveReqDataFacade = ReqPlanReceiveReqDataFacadeFactory.getLocalInstance(ctx);
    reqPlanReceiveReqDataFacade.receiveReqPlanDate("B2aZSVXaSx6qxdfekgCmrEY+1VI=", "'" + ids + "'", bizAction, tempTableName);
  }
  
  private void updateReqPlanData(Context ctx, List ids, int bizAction, String tempTableName)
    throws Exception
  {
    if (ids.size() <= 0) {
      return;
    }
    IReqPlanReceiveReqDataFacade reqPlanReceiveReqDataFacade = ReqPlanReceiveReqDataFacadeFactory.getLocalInstance(ctx);
    
    reqPlanReceiveReqDataFacade.receiveReqPlanDate("B2aZSVXaSx6qxdfekgCmrEY+1VI=", MMUtils.listToString(ids), bizAction, tempTableName);
  }
  
  private void releaseTempTable(Context ctx, String tableName)
  {
    TempTablePool pool = TempTablePool.getInstance(ctx);
    pool.releaseTable(tableName);
  }
  
  private void getExpectOutput(Context ctx, Map inParam, Map retData)
    throws EASBizException, BOSException
  {
    ManufactureOrderExpectOutputCollection expectOutputs = new ManufactureOrderExpectOutputCollection();
    retData.put("EXPECTOUTPUTS", expectOutputs);
    
    StorageOrgUnitInfo storageOrgUnitInfo = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
    
    MaterialInfo moMaterialInfo = (MaterialInfo)inParam.get("MATERIAL");
    
    BomInfo bomInfo = (BomInfo)inParam.get("BOM");
    if (bomInfo == null) {
      return;
    }
    String bomID = bomInfo.getId().toString();
    
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("entrys.*"));
    sic.add(new SelectorItemInfo("unit.*"));
    sic.add(new SelectorItemInfo("baseUnit.*"));
    sic.add(new SelectorItemInfo("storageOrgUnit.*"));
    sic.add(new SelectorItemInfo("material.*"));
    sic.add(new SelectorItemInfo("materialPlan.*"));
    sic.add(new SelectorItemInfo("entrys.material.*"));
    sic.add(new SelectorItemInfo("entrys.baseUnit.*"));
    sic.add(new SelectorItemInfo("entrys.unit.*"));
    sic.add(new SelectorItemInfo("entrys.materialInventory.*"));
    sic.add(new SelectorItemInfo("entrys.defaultWarehouse.*"));
    bomInfo = BomFactory.getLocalInstance(ctx).getBomInfo(new ObjectStringPK(bomID), sic);
    
    Timestamp moBeginDate = (Timestamp)inParam.get("BEGINTIME");
    
    Timestamp moEndDate = (Timestamp)inParam.get("ENDTIME");
    
    MeasureUnitInfo moBaseUnit = (MeasureUnitInfo)inParam.get("BASEUNIT");
    
    MeasureUnitInfo moUnit = (MeasureUnitInfo)inParam.get("BILL_UNIT");
    
    BigDecimal moQty = (BigDecimal)inParam.get("BILL_QTY");
    
    BigDecimal moSplitQty = (BigDecimal)inParam.get("SPLIT_QTY");
    if (moSplitQty == null) {
      moSplitQty = SysConstant.BIGZERO;
    }
    String lotNumber = (String)inParam.get("LOTNUMBER");
    
    ManufactureOrderTechnicsCollection technicsCol = (ManufactureOrderTechnicsCollection)retData.get("TECHNICS");
    int lastOperNo = 0;
    OperationInfo lastOperationInfo = null;
    if ((technicsCol != null) && (technicsCol.size() > 0))
    {
      MMCommonUtils.objectValueSort(technicsCol, true, "operationNo");
      
      ManufactureOrderTechnicsInfo maxTechnicInfo = technicsCol.get(technicsCol.size() - 1);
      
      lastOperationInfo = maxTechnicInfo.getOperation();
      
      lastOperNo = maxTechnicInfo.getOperationNo();
    }
    IRowSet rowSet = _getWpSeq(ctx, inParam);
    Map pBomMap = new HashMap();
    try
    {
      while ((rowSet != null) && (rowSet.next()))
      {
        String bomItemID = rowSet.getString("FBomItemID");
        Integer wpSeq = new Integer(rowSet.getInt("FWpSeq"));
        String operationID = rowSet.getString("FOperationID");
        OperationInfo operationInfo = OperationFactory.getLocalInstance(ctx).getOperationInfo(new ObjectStringPK(operationID));
        
        pBomMap.put(bomItemID, new Object[] { wpSeq, operationInfo });
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    BigDecimal orderBaseQty = SCMUtils.getExchangePrecisionQtyForServer(ctx, moMaterialInfo.getId().toString(), moUnit, moBaseUnit, moQty.subtract(moSplitQty));
    
    BigDecimal productBaseQty = bomInfo.getProductBaseQty();
    BomEntryCollection bomEntrys = bomInfo.getEntrys();
    for (Iterator itor = bomEntrys.iterator(); itor.hasNext();)
    {
      BomEntryInfo bomEntryInfo = (BomEntryInfo)itor.next();
      String bomEntryId = bomEntryInfo.getId().toString();
      
      Integer operationNo = null;
      
      OperationInfo opInfo = null;
      if (pBomMap.get(bomEntryId) != null)
      {
        Object[] opo = (Object[])pBomMap.get(bomEntryId);
        operationNo = (Integer)opo[0];
        opInfo = (OperationInfo)opo[1];
      }
      MaterialPlanInfo materialInventory = bomEntryInfo.getMaterialInventory();
      
      MaterialScrapRateExpressionEnum scrapRateExpression = materialInventory == null ? null : materialInventory.getScrapRateExpression();
      
      ConsumeTypeEnum consumeType = bomEntryInfo.getConsumeType();
      
      BigDecimal consumeFixBaseQty = bomEntryInfo.getConsumeFixBaseQty();
      
      BigDecimal baseProportion = bomEntryInfo.getBaseProportion();
      
      BigDecimal scrapRatio = bomEntryInfo.getScrapRatio();
      
      java.util.Date effectiveDate = bomEntryInfo.getEffectiveDate();
      
      java.util.Date disableDate = bomEntryInfo.getDisableDate();
      
      BigDecimal bomCoefficient = bomInfo.getBaseUnit().getCoefficient();
      
      BigDecimal bomEntryCoefficient = bomEntryInfo.getBaseUnit().getCoefficient();
      BigDecimal baseExchangeRate = bomCoefficient.divide(bomEntryCoefficient, 8, 4);
      if ((moEndDate != null) && (effectiveDate != null) && (moBeginDate != null) && (disableDate != null) && 
      
        (moEndDate != null) && (!moEndDate.before(effectiveDate)) && (!moBeginDate.after(disableDate)) && (!DateTimeUtils.dayEquals(moBeginDate, disableDate))) {
        if ((MaterialProductEnum.RELATEDPRODUCT.equals(bomEntryInfo.getOutputType())) || (MaterialProductEnum.BYPRODUCT.equals(bomEntryInfo.getOutputType())))
        {
          MaterialInfo expMaterial = bomEntryInfo.getMaterial();
          
          ManufactureOrderExpectOutputInfo outputInfo = new ManufactureOrderExpectOutputInfo();
          
          outputInfo.setMaterial(expMaterial);
          
          outputInfo.setOutputType(bomEntryInfo.getOutputType());
          
          outputInfo.setOperationNo(operationNo == null ? lastOperNo : operationNo.intValue());
          
          outputInfo.setOperation(opInfo == null ? lastOperationInfo : opInfo);
          
          outputInfo.setUnit(bomEntryInfo.getUnit());
          
          outputInfo.setBaseUnit(bomEntryInfo.getBaseUnit());
          
          BigDecimal tempQty = getExpectOutputQty(ctx, orderBaseQty, scrapRateExpression, productBaseQty, consumeType, consumeFixBaseQty, baseProportion, scrapRatio);
          
          outputInfo.setBaseQty(tempQty.divide(baseExchangeRate, 8, 4).multiply(baseExchangeRate));
          
          outputInfo.setQty(SCMUtils.getExchangePrecisionQtyForServer(ctx, outputInfo.getMaterial().getId().toString(), outputInfo.getBaseUnit(), outputInfo.getUnit(), outputInfo.getBaseQty()));
          
          outputInfo.setAssistUnit(expMaterial.getAssistUnit());
          
          outputInfo.setAssistQty(getAssistUnitQty(ctx, outputInfo.getMaterial(), outputInfo.getUnit(), outputInfo.getQty(), outputInfo.getAssistUnit()));
          
          outputInfo.setFinishedQty(SysConstant.BIGZERO);
          
          outputInfo.setPassQty(SysConstant.BIGZERO);
          
          outputInfo.setScrapQty(SysConstant.BIGZERO);
          
          outputInfo.setToStoreQty(SysConstant.BIGZERO);
          
          outputInfo.setDefaultWarehous(bomEntryInfo.getDefaultWarehouse());
          
          outputInfo.setCostObect(MOCostObjectUtil.getCostObject(ctx, outputInfo.getMaterial(), storageOrgUnitInfo, null, null, false, false));
          
          outputInfo.setRemark(outputInfo.getRemark());
          if (getIsIsLotNumber(ctx, expMaterial, storageOrgUnitInfo)) {
            outputInfo.setLot(lotNumber);
          } else {
            outputInfo.setLot(null);
          }
          expectOutputs.add(outputInfo);
        }
      }
    }
    retData.put("EXPECTOUTPUTS", expectOutputs);
  }
  
  private BigDecimal getExpectOutputQty(Context ctx, BigDecimal orderBaseQty, MaterialScrapRateExpressionEnum scrapRateExpression, BigDecimal productBaseQty, ConsumeTypeEnum consumeType, BigDecimal consumeFixBaseQty, BigDecimal baseProportion, BigDecimal scrapRatio)
    throws EASBizException, BOSException
  {
    BigDecimal outputBaseQty = SysConstant.BIGZERO;
    BigDecimal ONE = new BigDecimal("1.0");
    BigDecimal PERCENT = new BigDecimal("100.0");
    int PREC = 8;
    
    BigDecimal byDivide = ONE.subtract(scrapRatio.divide(PERCENT, PREC, 4));
    
    BigDecimal byMutiple = ONE.add(scrapRatio.divide(PERCENT, PREC, 4));
    
    baseProportion = baseProportion.divide(PERCENT, PREC, 4);
    if (consumeType.equals(ConsumeTypeEnum.VariableAmount))
    {
      if (scrapRateExpression.equals(MaterialScrapRateExpressionEnum.BYDIVIDE))
      {
        if ((!productBaseQty.equals(SysConstant.BIGZERO)) && (!byDivide.equals(SysConstant.BIGZERO))) {
          outputBaseQty = orderBaseQty.divide(productBaseQty, PREC, 4).multiply(consumeFixBaseQty).divide(byDivide, PREC, 4);
        }
      }
      else if (scrapRateExpression.equals(MaterialScrapRateExpressionEnum.MUTIPLE)) {
        if (!productBaseQty.equals(SysConstant.BIGZERO)) {
          outputBaseQty = orderBaseQty.divide(productBaseQty, PREC, 4).multiply(consumeFixBaseQty).multiply(byMutiple);
        }
      }
    }
    else if (consumeType.equals(ConsumeTypeEnum.Proportion)) {
      if (scrapRateExpression.equals(MaterialScrapRateExpressionEnum.BYDIVIDE))
      {
        if (!byDivide.equals(SysConstant.BIGZERO)) {
          outputBaseQty = orderBaseQty.multiply(baseProportion).divide(byDivide, PREC, 4);
        }
      }
      else if (scrapRateExpression.equals(MaterialScrapRateExpressionEnum.MUTIPLE)) {
        outputBaseQty = orderBaseQty.multiply(baseProportion).multiply(byMutiple);
      }
    }
    return outputBaseQty;
  }
  
  private BigDecimal getAssistUnitQty(Context ctx, MaterialInfo materialInfo, MeasureUnitInfo eoUnitInfo, BigDecimal qty, MeasureUnitInfo assistUnitInfo)
    throws EASBizException, BOSException
  {
    if ((isNullOrIdIsNull(materialInfo)) || (isNullOrIdIsNull(assistUnitInfo)) || (qty == null) || (qty.doubleValue() == 0.0D)) {
      return SysConstant.BIGZERO;
    }
    return SCMUtils.getExchangeQtyForServer(ctx, materialInfo.getId().toString(), eoUnitInfo, assistUnitInfo, qty);
  }
  
  private BigDecimal getBaseUnitQty(Context ctx, MaterialInfo materialInfo, MeasureUnitInfo eoUnitInfo, BigDecimal qty, MeasureUnitInfo baseUnitInfo)
    throws EASBizException, BOSException
  {
    if ((isNullOrIdIsNull(materialInfo)) || (isNullOrIdIsNull(baseUnitInfo)) || (qty == null) || (qty.doubleValue() == 0.0D)) {
      return SysConstant.BIGZERO;
    }
    return SCMUtils.getExchangeQtyForServer(ctx, materialInfo.getId().toString(), eoUnitInfo, baseUnitInfo, qty);
  }
  
  private static boolean isNullOrIdIsNull(Object obj)
  {
    if (obj == null) {
      return true;
    }
    if ((obj instanceof String)) {
      return StringUtils.isEmpty((String)obj);
    }
    if ((obj instanceof CoreBaseInfo)) {
      return ((CoreBaseInfo)obj).getId() == null;
    }
    return false;
  }
  
  protected void _addnew(Context ctx, IObjectPK pk, IObjectValue model)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    if (moInfo.getId() == null) {
      moInfo.setId(BOSUuid.create("1D0D80DD"));
    }
    if (moInfo.getLongNumber() == null) {
      moInfo.setLongNumber(moInfo.getId().toString());
    }
    updateStock(moInfo);
    
    super._addnew(ctx, pk, model);
  }
  
  protected IObjectPK _addnew(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    if (moInfo.getId() == null) {
      moInfo.setId(BOSUuid.create("1D0D80DD"));
    }
    if (moInfo.getLongNumber() == null) {
      moInfo.setLongNumber(moInfo.getId().toString());
    }
    updateStock(moInfo);
    
    return super._addnew(ctx, model);
  }
  
  protected void setAutoNumberByOrg(Context ctx, ObjectBaseInfo model, String orgType) {}
  
  protected boolean _checkOtherWhenDel(Context ctx, IObjectValue model)
    throws EASBizException, BOSException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    if (moInfo.getBaseStatus() != null)
    {
      if ((moInfo.getBaseStatus() != BillBaseStatusEnum.TEMPORARILYSAVED) && (moInfo.getBaseStatus() != BillBaseStatusEnum.SUBMITED)) {
        throw new SCMBillException(SCMBillException.EX_MSG_FOR_RPC, new String[] { ResourceBase.getString("com.kingdee.eas.mm.mo.ManufactureOrderResource.STATUS_NOT_ADD_AND_NOT_SAVE", ctx.getLocale()) });
      }
      String msg = null;
      List ids = new ArrayList();
      
      StringBuffer ksqlBuf = new StringBuffer();
      ksqlBuf.append("SELECT  mo.FID as FID, ");
      ksqlBuf.append("   mo.FBaseStatus as FBaseStatus, ");
      ksqlBuf.append("   mo.FBirthType as FBirthType, ");
      ksqlBuf.append("   bt.FDestObjectID  as FDestObjectID ");
      ksqlBuf.append("FROM  T_mm_manufactureorder  mo  ");
      ksqlBuf.append("   LEFT  JOIN  T_bot_Relation  bt  ");
      ksqlBuf.append("     ON  mo.fid = bt.FSrcObjectID  ");
      ksqlBuf.append("WHERE  mo.flongnumber  LIKE  '%").append(moInfo.getId().toString()).append("!%'");
      
      IRowSet rs = DbUtil.executeQuery(ctx, ksqlBuf.toString());
      try
      {
        while ((rs != null) && (rs.next()))
        {
          String childId = rs.getString("FID");
          int status = rs.getInt("FBaseStatus");
          int birthtype = rs.getInt("FBirthType");
          String destObjectID = rs.getString("FDestObjectID");
          if ((status != 1) && (status != 2))
          {
            msg = getString(ctx, "Exists_ModifiedChild_noDelete");
            break;
          }
          if (birthtype != 30)
          {
            msg = getString(ctx, "Exists_otherChild_noDelete");
            break;
          }
          if (!StringUtils.isEmpty(destObjectID))
          {
            msg = getString(ctx, "Exists_BOTPChild_noDelete");
            break;
          }
          ids.add(childId);
        }
      }
      catch (SQLException e)
      {
        throw new SQLDataException(e);
      }
      IManufactureOrder iManufactureOrder = ManufactureOrderFactory.getLocalInstance(ctx);
      if (StringUtils.isEmpty(msg))
      {
        CodingRulerSrvHelper codeHelper = new CodingRulerSrvHelper();
        for (int k = 0; k < ids.size(); k++)
        {
          IObjectPK moPK = new ObjectStringPK((String)ids.get(k));
          
          ManufactureOrderInfo mo = ManufactureOrderFactory.getLocalInstance(ctx).getManufactureOrderInfo(moPK);
          
          codeHelper.rollBackNumber(ctx, mo, mo.getStorageOrgUnit());
          iManufactureOrder.deleteNoCheck(moPK);
        }
      }
      else
      {
        throw new SCMBillException(SCMBillException.EX_MSG_FOR_RPC, new String[] { msg });
      }
    }
    return true;
  }
  
  protected void _syncStock(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("transactionType.*"));
    sic.add(new SelectorItemInfo("routing.*"));
    sic.add(new SelectorItemInfo("stocks.*"));
    sic.add(new SelectorItemInfo("stocks.unit.id"));
    sic.add(new SelectorItemInfo("stocks.unit.name"));
    sic.add(new SelectorItemInfo("stocks.unit.number"));
    sic.add(new SelectorItemInfo("expectOutputs.*"));
    sic.add(new SelectorItemInfo("expectOutputs.unit.id"));
    sic.add(new SelectorItemInfo("expectOutputs.unit.name"));
    sic.add(new SelectorItemInfo("expectOutputs.unit.number"));
    sic.add(new SelectorItemInfo("technics.*"));
    ManufactureOrderInfo moInfo = getManufactureOrderInfo(ctx, pk, sic);
    
    checkBeforeSyncStock(ctx, moInfo);
    
    MMCommonUtils.objectValueSort(moInfo.getTechnics(), true, "operationNo");
    
    ManufactureOrderStockCollection newStockCol = getLatestStockForSync(ctx, moInfo);
    if ((newStockCol == null) || (newStockCol.get(0) == null)) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.BOMEXPANDISNULL_CANNOTSYNCSTOCK);
    }
    ManufactureOrderStockCollection orderStockCol = moInfo.getStocks();
    
    Collection insertKeyCol = new ArrayList();
    Collection updateKeyCol = new ArrayList();
    Collection deleteKeyCol = new ArrayList();
    
    getStateList(ctx, newStockCol, orderStockCol, insertKeyCol, updateKeyCol, deleteKeyCol);
    
    syncStock_addRec(ctx, orderStockCol, newStockCol, insertKeyCol);
    
    syncStock_updateStock(ctx, orderStockCol, newStockCol, updateKeyCol);
    
    syncStock_deleteStock(ctx, orderStockCol, deleteKeyCol);
    
    reBuildStockLineSeq(moInfo);
    
    ManufactureOrderExpectOutputCollection newExpectOutputs = getExpectOutPutForSync(ctx, moInfo);
    
    ManufactureOrderExpectOutputCollection orderExpectOutputs = moInfo.getExpectOutputs();
    insertKeyCol = new ArrayList();
    updateKeyCol = new ArrayList();
    deleteKeyCol = new ArrayList();
    
    getStateList(ctx, newExpectOutputs, orderExpectOutputs, insertKeyCol, updateKeyCol, deleteKeyCol);
    
    syncStock_addRec(ctx, orderExpectOutputs, newExpectOutputs, insertKeyCol);
    
    syncStock_updateExpectOutput(ctx, orderExpectOutputs, newExpectOutputs, updateKeyCol);
    
    syncStock_deleteExpectOutput(ctx, orderExpectOutputs, deleteKeyCol);
    
    _update(ctx, pk, moInfo);
    
    afterSynchronization(ctx, new String[] { pk.toString() }, null, null);
    if ((moInfo.getBaseStatus() == BillBaseStatusEnum.SUBMITED) || (moInfo.getBaseStatus() == BillBaseStatusEnum.AUDITED))
    {
      int bizAction = moInfo.getBaseStatus() == BillBaseStatusEnum.AUDITED ? 701 : 102;
      try
      {
        BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
        entry.add(pk);
        BatchExecuteParamsEntry[] entries = { entry };
        
        updateReqPlanData(ctx, entries, bizAction, null);
      }
      catch (Exception exc)
      {
        throw new BOSException(exc);
      }
    }
  }
  
  protected ManufactureOrderStockCollection getLatestStockForSync(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    
    Map param = new HashMap();
    if (moInfo.getRouting() != null) {
      param.put("ROUTINGID", moInfo.getRouting().getId().toString());
    } else {
      param.put("ROUTINGID", null);
    }
    param.put("STORAGEORG", moInfo.getStorageOrgUnit());
    param.put("BASEUNIT", moInfo.getBaseUnit());
    param.put("BILL_UNIT", moInfo.getUnit());
    param.put("BILL_QTY", moInfo.getQty());
    param.put("BEGINTIME", moInfo.getPlanBeginDate());
    param.put("ENDTIME", moInfo.getPlanEndDate());
    
    BomInfo bom = new BomInfo();
    bom.setId(BOSUuid.read(moInfo.getBomID()));
    param.put("BOM", bom);
    param.put("projectID", moInfo.getProject());
    param.put("trackID", moInfo.getTrackNumber());
    param.put("MATERIAL", moInfo.getMaterial());
    param.put("TRANSTYPE", moInfo.getTransactionType());
    param.put("RECALC", Boolean.TRUE);
    
    param.put("IsRoutingChange", new Boolean(true));
    
    ManufactureOrderTechnicsCollection techCol = moInfo.getTechnics();
    Iterator iter = techCol.iterator();
    HashMap techMap = new HashMap();
    while (iter.hasNext())
    {
      ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)iter.next();
      techMap.put(new Integer(techInfo.getOperationNo()), techInfo);
    }
    param.put("OPERMAP", techMap);
    
    MOUntil.getDefaultRouting(ctx, moInfo.getMaterial().getId().toString(), moInfo.getStorageOrgUnit().getId().toString(), moInfo.getTransactionType(), param, null);
    
    ManufactureOrderStockCollection stocks = _bomExpand(ctx, param);
    if (stocks != null) {
      stocks = getDistinctStocks(stocks);
    }
    ProductTransactionTypeInfo transInfo = moInfo.getTransactionType();
    if ((transInfo != null) && (transInfo.getBizType() != null) && (transInfo.getBizType().getId().toString().equals("yRPu9BAfSRuIIEu9QnyxviQHQ1w=")))
    {
      ManufactureOrderStockCollection stockCol = moInfo.getStocks();
      if ((stockCol != null) && (stockCol.size() > 0)) {
        for (int i = 0; i < stockCol.size(); i++)
        {
          ManufactureOrderStockInfo stInfo = stockCol.get(i);
          if ((stInfo.getMaterial() != null) && (moInfo.getMaterial() != null) && (stInfo.getMaterial().getId().toString().equals(moInfo.getMaterial().getId().toString()))) {
            stocks.add(stInfo);
          }
        }
      }
    }
    if (stocks == null) {
      return new ManufactureOrderStockCollection();
    }
    int firstEffectOperNO = 0;
    if (moInfo.getBirthType() == MOBirthTypeEnum.REFORM)
    {
      int reformOper = getSplitOperNo(ctx, moInfo.getId().toString());
      int i = 0;
      for (int size = techCol.size(); i < size; i++) {
        if (techCol.get(i).getOperationNo() >= reformOper)
        {
          firstEffectOperNO = techCol.get(i).getOperationNo();
          break;
        }
      }
      for (iter = stocks.iterator(); iter.hasNext();)
      {
        ManufactureOrderStockInfo stockInfo = (ManufactureOrderStockInfo)iter.next();
        if (stockInfo.getOperationNo() < firstEffectOperNO) {
          iter.remove();
        }
      }
    }
    else
    {
      firstEffectOperNO = moInfo.getFirstOperNo();
    }
    updateStockOper(ctx, stocks, 0, firstEffectOperNO, techMap);
    
    updateStockPickDept(ctx, moInfo, stocks, 0, firstEffectOperNO, techMap);
    
    return stocks;
  }
  
  private void updateStockPickDept(Context ctx, ManufactureOrderInfo moInfo, ManufactureOrderStockCollection moStockCol, int startOperNO, int defaultOperNo, HashMap techMap)
  {
    ManufactureOrderStockInfo stockInfo = null;
    int i = 0;
    for (int size = moStockCol.size(); i < size; i++)
    {
      stockInfo = (ManufactureOrderStockInfo)moStockCol.getObject(i);
      int operationNo = stockInfo.getOperationNo();
      if (operationNo > startOperNO)
      {
        if (!techMap.containsKey(new Integer(operationNo))) {
          operationNo = defaultOperNo;
        }
        ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)techMap.get(new Integer(operationNo));
        stockInfo.setOperationNo(operationNo);
        stockInfo.setOperation(techInfo.getOperation());
        stockInfo.setWorkcenter(techInfo.getWorkcenter());
        if (!techInfo.getEntrustType().equals(EntrustTypeEnum.INNER)) {
          stockInfo.setPickDept(techInfo.getAdminOrgUnit());
        } else {
          stockInfo.setPickDept(moInfo.getAdminOrgUnit());
        }
      }
    }
  }
  
  protected ManufactureOrderExpectOutputCollection getExpectOutPutForSync(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    
    Map param = new HashMap();
    param.put("MATERIAL", moInfo.getMaterial());
    param.put("BASEUNIT", moInfo.getBaseUnit());
    param.put("STORAGEORG", moInfo.getStorageOrgUnit());
    param.put("BILL_QTY", moInfo.getQty());
    param.put("BILL_UNIT", moInfo.getUnit());
    param.put("BEGINTIME", moInfo.getPlanBeginDate());
    param.put("ENDTIME", moInfo.getPlanEndDate());
    
    param.put("SPLIT_QTY", new BigDecimal(0));
    BomInfo bom = new BomInfo();
    bom.setId(BOSUuid.read(moInfo.getBomID()));
    param.put("BOM", bom);
    if (moInfo.getRouting() != null) {
      param.put("ROUTINGID", moInfo.getRouting().getId().toString());
    } else {
      param.put("ROUTINGID", null);
    }
    Map retData = new HashMap();
    retData.put("LOTNUMBER", moInfo.getLot());
    retData.put("TECHNICS", moInfo.getTechnics());
    getExpectOutput(ctx, param, retData);
    ManufactureOrderExpectOutputCollection expectOutputs = (ManufactureOrderExpectOutputCollection)retData.get("EXPECTOUTPUTS");
    
    Iterator iter = null;
    
    ManufactureOrderTechnicsCollection techCol = moInfo.getTechnics();
    iter = techCol.iterator();
    HashMap techMap = new HashMap();
    while (iter.hasNext())
    {
      ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)iter.next();
      techMap.put(new Integer(techInfo.getOperationNo()), techInfo);
    }
    int firstEffectOperNO;
    if (moInfo.getBirthType() == MOBirthTypeEnum.REFORM)
    {
      int reformOper = getSplitOperNo(ctx, moInfo.getId().toString());
      
      firstEffectOperNO = reformOper;
      int i = 0;
      for (int size = techCol.size(); i < size; i++) {
        if (techCol.get(i).getOperationNo() >= reformOper)
        {
          firstEffectOperNO = techCol.get(i).getOperationNo();
          break;
        }
      }
      for (iter = expectOutputs.iterator(); iter.hasNext();)
      {
        ManufactureOrderExpectOutputInfo expectOutputInfo = (ManufactureOrderExpectOutputInfo)iter.next();
        if (expectOutputInfo.getOperationNo() < firstEffectOperNO) {
          iter.remove();
        }
      }
    }
    updateExpectOutputOper(ctx, expectOutputs, 0, moInfo.getLastOperNo(), techMap);
    return expectOutputs;
  }
  
  protected boolean checkBeforeSyncStock(Context ctx, IObjectValue model)
    throws EASBizException, BOSException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    if ((moInfo.getBaseStatus().getValue() != 2) && (moInfo.getBaseStatus().getValue() != 4) && (moInfo.getBaseStatus().getValue() != 5)) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.STATUSINVALID_CANNOTSYNCSTOCK);
    }
    if ((moInfo.getBomID() == null) || (moInfo.getBomID().equals(""))) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.BOMISNULL_CANNOTSYNCSTOCK);
    }
    IBom ibom = BomFactory.getLocalInstance(ctx);
    BomInfo bomInfo = ibom.getBomInfo(new ObjectUuidPK(moInfo.getBomID()));
    if (!bomInfo.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.BOMUNAUDITED_CANNOTSYNCSTOCK);
    }
    if (moInfo.getMaterial() == null) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.MATERIALISNULL_CANNOTSYNCSTOCK);
    }
    if (moInfo.getTransactionType() == null) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.TRANSACTIONTYPEISNULL_CANNOTSYNCSTOCK);
    }
    if (moInfo.getTotalSplitBaseQty().compareTo(SysConstant.BIGZERO) > 0) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.MOSPLITED_CANNOTSYNCSTOCK);
    }
    if (moInfo.getBirthType() == MOBirthTypeEnum.SPLIT) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.FROMSPLIT_CANNOTSYNCSTOCK);
    }
    return true;
  }
  
  protected void getStateList(Context ctx, IObjectCollection newStockCol, IObjectCollection oldStockCol, Collection insertKeyCol, Collection updateKeyCol, Collection deleteKeyCol)
    throws EASBizException, BOSException
  {
    String recKey = "";
    
    Set newStockSet = new HashSet();
    
    Set oldStockSet = new HashSet();
    
    IObjectValue model = null;
    Iterator iter = null;
    Iterator oldIter = null;
    
    iter = newStockCol.iterator();
    while (iter.hasNext())
    {
      model = (IObjectValue)iter.next();
      recKey = getRecKeyString(model);
      newStockSet.add(recKey);
    }
    iter = oldStockCol.iterator();
    while (iter.hasNext())
    {
      model = (IObjectValue)iter.next();
      recKey = getRecKeyString(model);
      oldStockSet.add(recKey);
    }
    iter = newStockSet.iterator();
    String oldRecKey = "";
    while (iter.hasNext())
    {
      boolean find = false;
      recKey = (String)iter.next();
      oldIter = oldStockSet.iterator();
      while (oldIter.hasNext())
      {
        oldRecKey = (String)oldIter.next();
        if (recKey.equals(oldRecKey)) {
          find = true;
        }
      }
      if (!find) {
        insertKeyCol.add(recKey);
      } else {
        updateKeyCol.add(recKey);
      }
    }
    oldIter = oldStockSet.iterator();
    while (oldIter.hasNext())
    {
      boolean find = false;
      oldRecKey = (String)oldIter.next();
      iter = newStockSet.iterator();
      while (iter.hasNext())
      {
        recKey = (String)iter.next();
        if (recKey.equals(oldRecKey)) {
          find = true;
        }
      }
      if (!find) {
        deleteKeyCol.add(oldRecKey);
      }
    }
  }
  
  protected void syncStock_addRec(Context ctx, IObjectCollection stockCol, IObjectCollection newStockCol, Collection insertKeyCol)
    throws EASBizException, BOSException
  {
    IObjectValue entryInfo = null;
    String recKey = "";
    int i = 0;
    for (int size = newStockCol.size(); i < size; i++)
    {
      entryInfo = newStockCol.getObject(i);
      recKey = getRecKeyString(entryInfo);
      if (insertKeyCol.contains(recKey))
      {
        if ((entryInfo instanceof ManufactureOrderStockInfo)) {
          ((ManufactureOrderStockInfo)entryInfo).setSourceBillEntrySeq(-99999);
        }
        stockCol.addObject(entryInfo);
      }
    }
  }
  
  private static void afterSynchronization(Context ctx, String[] orderIdArray, String[] stocksIdArray, String[] technicsIdArray)
    throws BOSException
  {
    StringBuffer stringBuffer = new StringBuffer();
    String[] batchUpdateSQLArray = new String[3];
    
    String orderIds = SQLUtil.arrayToString(orderIdArray);
    
    stringBuffer.setLength(0);
    stringBuffer.append("update T_MM_MFTOrderStock as t0  ");
    stringBuffer.append("set (FBaseQty,FLossBaseQty,FPlannedBaseQty,FOriginalPlanBaseQty,FUnReceiptBaseQty,FTotalReceiptBaseQty,FPickExtraBaseQty,FPickLackBaseQty) = ");
    stringBuffer.append("(select round(decimal(t0.FQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision),");
    stringBuffer.append("round(decimal(t0.FLossQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ");
    stringBuffer.append("round(decimal(t0.FPlannedQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ");
    stringBuffer.append("round(decimal(t0.FOriginalPlanQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ");
    stringBuffer.append("round(decimal(t0.FUnReceiptQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ");
    stringBuffer.append("round(decimal(t0.FTotalReceiptQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ");
    stringBuffer.append("round(decimal(t0.FPickExtraQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision), ");
    stringBuffer.append("round(decimal(t0.FPickLackQty * t2.FBaseConvsRate,21,8),t3.FQtyPrecision) ");
    stringBuffer.append("from t_bd_multimeasureunit t2 , t_bd_multimeasureunit t3 ");
    stringBuffer.append("where t0.FMaterialID = t2.FMaterialID and t0.FUnitID = t2.fmeasureunitid ");
    stringBuffer.append("and t0.FMaterialID = t3.FMaterialID and t0.FBaseUnitID = t3.fmeasureunitid ");
    stringBuffer.append("and t0.FParentID in (").append(orderIds).append(") ");
    stringBuffer.append("and t0.FSourceBillEntrySeq = ").append(-99999).append(")");
    batchUpdateSQLArray[0] = stringBuffer.toString();
    
    stringBuffer.setLength(0);
    stringBuffer.append("update T_MM_MFTOrderStock as t0 ");
    stringBuffer.append("set (FUnIssueQty,FUnIssueBaseQty,FAssociateQty) = ");
    
    stringBuffer.append("(select  t0.FPlannedQty-t0.FActIssueQty+t0.FRejectedQty,t0.FPlannedBaseQty-t0.FActIssueBaseQty+t0.FRejectedBaseQty,").append(" case when t0.FIsQtyLimit=1 then ").append("round(to_decimal(t0.FPickExtraBaseQty,21,8),b1.FQtyPrecision)-t0.FActIssueBaseQty+t0.FRejectedBaseQty ").append(" else t0.FPlannedBaseQty-t0.FActIssueBaseQty+t0.FRejectedBaseQty ").append(" end ");
    
    stringBuffer.append("from t_bd_multimeasureunit  b1 ");
    stringBuffer.append("where t0.FMaterialID = b1.FMaterialID and t0.FBaseUnitID = b1.fmeasureunitid ");
    stringBuffer.append("and t0.FParentID in (").append(orderIds).append(") ");
    stringBuffer.append("and t0.FSourceBillEntrySeq = ").append(-99999).append(") ");
    batchUpdateSQLArray[1] = stringBuffer.toString();
    
    stringBuffer.setLength(0);
    stringBuffer.append("update T_MM_MFTOrderStock set FSourceBillEntrySeq = 0 ");
    stringBuffer.append("where FParentID in (").append(orderIds).append(") ");
    stringBuffer.append("and FSourceBillEntrySeq = ").append(-99999);
    batchUpdateSQLArray[2] = stringBuffer.toString();
    
    SQLUtil.batchExecuteSql(ctx, batchUpdateSQLArray);
    
    CalculateWipUtil.updateWipForMoOrders(ctx, orderIdArray);
  }
  
  public String getRecKeyString(IObjectValue model)
  {
    String recKey = "";
    MaterialInfo materialInfo = (MaterialInfo)model.get("material");
    int operationNo = model.getInt("operationNo");
    if (materialInfo != null) {
      recKey = materialInfo.getId().toString();
    } else {
      recKey = "MATERIAL_NULL";
    }
    recKey = recKey + "!";
    recKey = recKey + operationNo;
    return recKey;
  }
  
  protected void syncStock_updateStock(Context ctx, ManufactureOrderStockCollection stockCol, ManufactureOrderStockCollection newStockCol, Collection updateKeyCol)
    throws EASBizException, BOSException
  {
    if (updateKeyCol.size() == 0) {
      return;
    }
    ManufactureOrderStockInfo newStockInfo = null;
    ManufactureOrderStockInfo stockInfo = null;
    String recKey = "";
    HashMap hm = new HashMap();
    ArrayList list = null;
    
    int index = 0;
    for (int size = stockCol.size(); index < size; index++)
    {
      stockInfo = stockCol.get(index);
      if (!stockInfo.isIsReplaced())
      {
        recKey = getRecKeyString(stockInfo);
        if (updateKeyCol.contains(recKey)) {
          if (hm.containsKey(recKey))
          {
            list = (ArrayList)hm.get(recKey);
            list.add(stockInfo);
          }
          else
          {
            list = new ArrayList();
            list.add(stockInfo);
            hm.put(recKey, list);
          }
        }
      }
    }
    for ( index = newStockCol.size() - 1; index >= 0; index--)
    {
      newStockInfo = newStockCol.get(index);
      recKey = getRecKeyString(newStockInfo);
      if ((updateKeyCol.contains(recKey)) && (hm.containsKey(recKey)))
      {
        list = (ArrayList)hm.get(recKey);
        int i = 0;
        for (int size = list.size(); i < size; i++)
        {
          stockInfo = (ManufactureOrderStockInfo)list.get(i);
          if (i == 0) {
            updateStockInfo(ctx, stockInfo, newStockInfo);
          } else {
            deleteRecFromStockCol(ctx, stockCol, stockInfo);
          }
        }
      }
    }
  }
  
  protected void syncStock_updateExpectOutput(Context ctx, ManufactureOrderExpectOutputCollection expectOutputCol, ManufactureOrderExpectOutputCollection newExpectOutputCol, Collection updateKeyCol)
    throws EASBizException, BOSException
  {
    if (updateKeyCol.size() == 0) {
      return;
    }
    ManufactureOrderExpectOutputInfo newExpectOutputInfo = null;
    ManufactureOrderExpectOutputInfo expectOutputInfo = null;
    String recKey = "";
    HashMap hm = new HashMap();
    ArrayList list = null;
    
    int index = 0;
    for (int size = expectOutputCol.size(); index < size; index++)
    {
      expectOutputInfo = expectOutputCol.get(index);
      recKey = getRecKeyString(expectOutputInfo);
      if (updateKeyCol.contains(recKey)) {
        if (hm.containsKey(recKey))
        {
          list = (ArrayList)hm.get(recKey);
          list.add(expectOutputInfo);
        }
        else
        {
          list = new ArrayList();
          list.add(expectOutputInfo);
          hm.put(recKey, list);
        }
      }
    }
    for ( index = newExpectOutputCol.size() - 1; index >= 0; index--)
    {
      newExpectOutputInfo = newExpectOutputCol.get(index);
      recKey = getRecKeyString(newExpectOutputInfo);
      if ((updateKeyCol.contains(recKey)) && (hm.containsKey(recKey)))
      {
        list = (ArrayList)hm.get(recKey);
        int i = 0;
        for (int size = list.size(); i < size; i++)
        {
          expectOutputInfo = (ManufactureOrderExpectOutputInfo)list.get(i);
          if (i == 0)
          {
            expectOutputInfo.setOutputType(newExpectOutputInfo.getOutputType());
            expectOutputInfo.setDefaultWarehous(newExpectOutputInfo.getDefaultWarehous());
            BigDecimal qty = NumericUtil.emptyToZero(newExpectOutputInfo.getQty());
            BigDecimal baseQty = NumericUtil.emptyToZero(newExpectOutputInfo.getBaseQty());
            
            baseQty = baseQty.max(expectOutputInfo.getFinishedBaseQty()).max(expectOutputInfo.getToStoreBaseQty());
            expectOutputInfo.setBaseQty(baseQty);
            if (!StringUtils.equalsIgnoreCase(expectOutputInfo.getUnit().getId().toString(), newExpectOutputInfo.getUnit().getId().toString()))
            {
              IMultiMeasureUnit multiUnit = MultiMeasureUnitFactory.getLocalInstance(ctx);
              MultiMeasureUnitInfo mmuInfo = multiUnit.getMultiUnit(expectOutputInfo.getMaterial().getId().toString(), expectOutputInfo.getUnit().getId().toString());
              
              qty = baseQty.divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4);
            }
            else
            {
              qty = qty.max(expectOutputInfo.getFinishedQty()).max(expectOutputInfo.getToStoreQty());
            }
            expectOutputInfo.setQty(qty);
          }
          else
          {
            deleteRecFromExpectOutputCol(ctx, expectOutputCol, expectOutputInfo);
          }
        }
      }
    }
  }
  
  protected void syncStock_deleteStock(Context ctx, ManufactureOrderStockCollection stockCol, Collection deleteKeyCol)
    throws EASBizException, BOSException
  {
    ManufactureOrderStockInfo stockInfo = null;
    
    String recKey = "";
    for (int index = stockCol.size() - 1; index >= 0; index--)
    {
      stockInfo = stockCol.get(index);
      if (!stockInfo.isIsReplaced())
      {
        recKey = getRecKeyString(stockInfo);
        if (deleteKeyCol.contains(recKey)) {
          deleteRecFromStockCol(ctx, stockCol, stockInfo);
        }
      }
    }
  }
  
  protected void syncStock_deleteExpectOutput(Context ctx, ManufactureOrderExpectOutputCollection expectOutputCol, Collection deleteKeyCol)
    throws EASBizException, BOSException
  {
    ManufactureOrderExpectOutputInfo expectOutputInfo = null;
    
    String recKey = "";
    for (int index = expectOutputCol.size() - 1; index >= 0; index--)
    {
      expectOutputInfo = expectOutputCol.get(index);
      recKey = getRecKeyString(expectOutputInfo);
      if (deleteKeyCol.contains(recKey)) {
        deleteRecFromExpectOutputCol(ctx, expectOutputCol, expectOutputInfo);
      }
    }
  }
  
  protected void deleteRecFromStockCol(Context ctx, ManufactureOrderStockCollection stockCol, ManufactureOrderStockInfo stockInfo)
    throws EASBizException, BOSException
  {
    HashSet destEntityHS = new HashSet();
    destEntityHS.add("500AB75E");
    destEntityHS.add("7606B3CD");
    destEntityHS.add("2239F30A");
    destEntityHS.add("5C2A1F0C");
    destEntityHS.add("76C9F8D8");
    destEntityHS.add("BFBCAD51");
    
    boolean isHasDest = checkEntryHasDestObject(ctx, stockInfo.getId().toString(), destEntityHS);
    if (!isHasDest)
    {
      stockCol.removeObject(stockInfo);
    }
    else
    {
      BigDecimal plannedQty = stockInfo.getPlannedQty();
      BigDecimal plannedBaseQty = stockInfo.getPlannedBaseQty();
      
      stockInfo.setPlannedQty(new BigDecimal(0));
      stockInfo.setPlannedBaseQty(new BigDecimal(0));
      
      stockInfo.setUnIssueQty(stockInfo.getUnIssueQty().subtract(plannedQty));
      stockInfo.setUnIssueBaseQty(stockInfo.getUnIssueBaseQty().subtract(plannedBaseQty));
      
      stockInfo.setUnReceiptQty(stockInfo.getPlannedQty().subtract(stockInfo.getTotalReceiptQty()));
      stockInfo.setUnReceiptBaseQty(stockInfo.getPlannedBaseQty().subtract(stockInfo.getTotalReceiptBaseQty()));
      
      stockInfo.setAssociateQty(stockInfo.getPlannedQty().subtract(stockInfo.getAssociateQty()));
    }
  }
  
  protected void deleteRecFromExpectOutputCol(Context ctx, ManufactureOrderExpectOutputCollection expectOutputCol, ManufactureOrderExpectOutputInfo expectOutputInfo)
    throws EASBizException, BOSException
  {
    HashSet destEntityHS = new HashSet();
    destEntityHS.add("FA1292B4");
    destEntityHS.add("DFBE5164");
    
    boolean isHasDest = checkEntryHasDestObject(ctx, expectOutputInfo.getId().toString(), destEntityHS);
    if (!isHasDest)
    {
      BigDecimal FIN_PAS_SCR = expectOutputInfo.getFinishedQty().add(expectOutputInfo.getPassQty()).add(expectOutputInfo.getScrapQty());
      if (FIN_PAS_SCR.compareTo(new BigDecimal(0)) == 0) {
        expectOutputCol.removeObject(expectOutputInfo);
      }
    }
    else
    {
      BigDecimal updateQty = expectOutputInfo.getFinishedQty();
      updateQty = updateQty.max(expectOutputInfo.getToStoreQty());
      expectOutputInfo.setQty(updateQty);
    }
  }
  
  protected void updateStockInfo(Context ctx, ManufactureOrderStockInfo oldStockInfo, ManufactureOrderStockInfo newStockInfo)
    throws EASBizException, BOSException
  {
    HashSet destEntityHS = new HashSet();
    destEntityHS.add("500AB75E");
    destEntityHS.add("7606B3CD");
    destEntityHS.add("2239F30A");
    destEntityHS.add("5C2A1F0C");
    destEntityHS.add("76C9F8D8");
    destEntityHS.add("BFBCAD51");
    
    boolean hasDestObject = checkEntryHasDestObject(ctx, oldStockInfo.getId().toString(), destEntityHS);
    
    BigDecimal oldPlannedQty = oldStockInfo.getPlannedQty();
    
    oldStockInfo.setUnitBaseQty(newStockInfo.getUnitBaseQty());
    
    oldStockInfo.setBaseQty(newStockInfo.getBaseQty());
    
    oldStockInfo.setLossBaseQty(newStockInfo.getLossBaseQty());
    
    oldStockInfo.setUnIssueBaseQty(oldStockInfo.getUnIssueBaseQty().add(newStockInfo.getPlannedBaseQty()).subtract(oldStockInfo.getPlannedBaseQty()));
    
    oldStockInfo.setPlannedBaseQty(newStockInfo.getPlannedBaseQty());
    
    oldStockInfo.setUnReceiptBaseQty(oldStockInfo.getPlannedBaseQty().subtract(oldStockInfo.getTotalReceiptBaseQty()));
    
    oldStockInfo.setIsQtyLimit(newStockInfo.isIsQtyLimit());
    
    oldStockInfo.setExtraRatio(newStockInfo.getExtraRatio());
    
    oldStockInfo.setLackRatio(newStockInfo.getLackRatio());
    
    oldStockInfo.setPickExtraBaseQty(newStockInfo.getPickExtraBaseQty());
    
    oldStockInfo.setPickLackBaseQty(newStockInfo.getPickLackBaseQty());
    if (StringUtils.equalsIgnoreCase(newStockInfo.getUnit().getId().toString(), oldStockInfo.getUnit().getId().toString()))
    {
      oldStockInfo.setUnitQty(newStockInfo.getUnitQty());
      
      oldStockInfo.setQty(newStockInfo.getQty());
      
      oldStockInfo.setLossQty(newStockInfo.getLossQty());
      
      oldStockInfo.setUnIssueQty(oldStockInfo.getUnIssueQty().add(newStockInfo.getPlannedQty()).subtract(oldPlannedQty));
      
      oldStockInfo.setPlannedQty(newStockInfo.getPlannedQty());
      
      oldStockInfo.setUnReceiptQty(oldStockInfo.getPlannedQty().subtract(oldStockInfo.getTotalReceiptQty()));
      
      oldStockInfo.setPickExtraQty(newStockInfo.getPickExtraQty());
      
      oldStockInfo.setPickLackQty(newStockInfo.getPickLackQty());
    }
    else
    {
      IMultiMeasureUnit immu = MultiMeasureUnitFactory.getLocalInstance(ctx);
      EntityViewInfo viewInfo = new EntityViewInfo();
      FilterInfo filter = new FilterInfo();
      filter.getFilterItems().add(new FilterItemInfo("material.id", oldStockInfo.getMaterial().getId().toString()));
      filter.getFilterItems().add(new FilterItemInfo("measureUnit.id", oldStockInfo.getUnit().getId().toString()));
      viewInfo.setFilter(filter);
      
      SelectorItemCollection sic = new SelectorItemCollection();
      sic.add(new SelectorItemInfo("*"));
      sic.add("baseConvsRate");
      sic.add("qtyPrecision");
      viewInfo.setSelector(sic);
      MultiMeasureUnitCollection coll = immu.getMultiMeasureUnitCollection(viewInfo);
      MultiMeasureUnitInfo mmuInfo = coll.get(0);
      
      oldStockInfo.setUnitQty(oldStockInfo.getUnitBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setQty(oldStockInfo.getBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setLossQty(oldStockInfo.getLossBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setUnIssueQty(oldStockInfo.getUnIssueBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setPlannedQty(oldStockInfo.getPlannedBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setUnReceiptQty(oldStockInfo.getUnReceiptBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setPickExtraQty(oldStockInfo.getPickExtraBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
      
      oldStockInfo.setPickLackQty(oldStockInfo.getPickLackBaseQty().divide(mmuInfo.getBaseConvsRate(), mmuInfo.getQtyPrecision(), 4));
    }
    oldStockInfo.setLossRatio(newStockInfo.getLossRatio());
    
    oldStockInfo.setAssociateQty(oldStockInfo.getAssociateQty().add(oldStockInfo.getPlannedQty().subtract(oldPlannedQty)));
    
    oldStockInfo.setMatReplaceType(newStockInfo.getMatReplaceType());
    oldStockInfo.setAssyLocation(newStockInfo.getAssyLocation());
    oldStockInfo.setBlkSize(newStockInfo.getBlkSize());
    oldStockInfo.setSpecifiedLength(newStockInfo.getSpecifiedLength());
    if (!hasDestObject)
    {
      oldStockInfo.setProvideType(newStockInfo.getProvideType());
      oldStockInfo.setStorageOrgUnit(newStockInfo.getStorageOrgUnit());
      oldStockInfo.setIssueMode(newStockInfo.getIssueMode());
      oldStockInfo.setPickType(newStockInfo.getPickType());
      oldStockInfo.setWarehouse(newStockInfo.getWarehouse());
      oldStockInfo.setLocation(newStockInfo.getLocation());
      
      oldStockInfo.setIsStockAllot(newStockInfo.isIsStockAllot());
      oldStockInfo.setReceiptStroageOrgUnit(newStockInfo.getReceiptStroageOrgUnit());
      oldStockInfo.setReceiptStock(newStockInfo.getReceiptStock());
      oldStockInfo.setTransferType(newStockInfo.getTransferType());
      
      oldStockInfo.setIsBackflush(newStockInfo.isIsBackflush());
    }
  }
  
  public boolean checkEntryHasDestObject(Context ctx, String srcEntryId, Set destTypes)
    throws BOSException
  {
    boolean hasDestObject = false;
    StringBuffer sql_botEntryRelation = new StringBuffer();
    sql_botEntryRelation.append("SELECT count(1) as COUNTNO FROM T_BOT_RELATIONENTRY AS botEntry ");
    sql_botEntryRelation.append("INNER JOIN T_BOT_RELATION AS bot on bot.FID = botEntry.FKeyID ");
    sql_botEntryRelation.append("WHERE botEntry.FSrcEntryID = '" + srcEntryId + "'");
    if ((destTypes != null) && (destTypes.size() > 0))
    {
      String destEntityType = StringUtils.arrayToString(destTypes.toArray(), "','");
      sql_botEntryRelation.append(" and bot.FDestEntityID in ('" + destEntityType + "')");
    }
    IRowSet rs = DbUtil.executeQuery(ctx, sql_botEntryRelation.toString());
    try
    {
      if ((rs.next()) && (rs.getInt("COUNTNO") > 0)) {
        hasDestObject = true;
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    if (!hasDestObject)
    {
      sql_botEntryRelation.setLength(0);
      sql_botEntryRelation.append("select count(1) as COUNTNO from T_IM_MaterialReqBillEntry where fcorebillentryid ='");
      sql_botEntryRelation.append(srcEntryId);
      sql_botEntryRelation.append("'");
      rs = DbUtil.executeQuery(ctx, sql_botEntryRelation.toString());
      try
      {
        if ((rs.next()) && (rs.getInt("COUNTNO") > 0)) {
          hasDestObject = true;
        }
      }
      catch (SQLException e)
      {
        throw new BOSException(e);
      }
    }
    return hasDestObject;
  }
  
  public Set getMOEntryWithDestObject(Context ctx, String id, Set destTypes)
    throws BOSException
  {
    Set returnSet = new HashSet();
    
    StringBuffer sql_botEntryRelation = new StringBuffer();
    sql_botEntryRelation.append(" SELECT distinct FSrcEntryID FROM T_BOT_RELATIONENTRY AS botEntry ");
    sql_botEntryRelation.append(" INNER JOIN T_BOT_RELATION AS bot on bot.FID = botEntry.FKeyID ");
    sql_botEntryRelation.append(" WHERE bot.FSrcEntityID = '1D0D80DD'");
    sql_botEntryRelation.append(" AND bot.FSRCOBJECTID = '" + id + "'");
    if (destTypes != null)
    {
      String destEntityType = StringUtils.arrayToString(destTypes.toArray(), "','");
      if (destTypes.size() > 1) {
        sql_botEntryRelation.append(" and bot.FDestEntityID in ('" + destEntityType + "')");
      } else {
        sql_botEntryRelation.append(" and bot.FDestEntityID ='" + destTypes.toArray()[0] + "'");
      }
    }
    IRowSet rs = null;
    rs = DbUtil.executeQuery(ctx, sql_botEntryRelation.toString());
    try
    {
      if (rs.next()) {
        returnSet.add(rs.getString("FSrcEntryID"));
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return returnSet;
  }
  
  public Set getTechsWithDestObject(Context ctx, String id)
    throws BOSException
  {
    Set returnSet = new HashSet();
    
    HashSet destTypes = new HashSet();
    destTypes.add("6F0D8519");
    destTypes.add("200BB61F");
    returnSet = getMOEntryWithDestObject(ctx, id, destTypes);
    
    StringBuffer sql_getReport = new StringBuffer();
    sql_getReport.append(" SELECT distinct rpt.FProcessID FROM T_MM_CompletionReport as rpt");
    sql_getReport.append(" INNER JOIN T_BOT_RELATION as bot on rpt.FID = bot.FDESTOBJECTID");
    sql_getReport.append(" WHERE bot.FSrcEntityID = '1D0D80DD'");
    sql_getReport.append(" AND bot.FSRCOBJECTID = '" + id + "'");
    IRowSet rs = DbUtil.executeQuery(ctx, sql_getReport.toString());
    try
    {
      while (rs.next()) {
        returnSet.add(rs.getString("FProcessID"));
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    StringBuffer sql_queryDispatch = new StringBuffer();
    sql_queryDispatch.append(" SELECT distinct disEntry.FSourceBillEntryID FROM T_MM_DisTaskDispatchEntry as disEntry ");
    sql_queryDispatch.append(" WHERE disEntry.FSourceBillID = '" + id + "'");
    rs = DbUtil.executeQuery(ctx, sql_queryDispatch.toString());
    try
    {
      while (rs.next()) {
        returnSet.add(rs.getString("FSourceBillEntryID"));
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return returnSet;
  }
  
  protected void _syncTechnics(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("transactionType.*"));
    sic.add(new SelectorItemInfo("routing.*"));
    sic.add(new SelectorItemInfo("stocks.*"));
    sic.add(new SelectorItemInfo("technics.*"));
    
    ManufactureOrderInfo moInfo = getManufactureOrderInfo(ctx, pk, sic);
    
    checkBeforeSyncTechs(ctx, moInfo);
    
    int startOperNO = getMaxDisSyncOperNo(ctx, moInfo);
    
    syncTechs(ctx, moInfo, startOperNO);
  }
  
  protected boolean checkBeforeSyncTechs(Context ctx, IObjectValue model)
    throws EASBizException, BOSException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    if ((moInfo.getBaseStatus().getValue() != 2) && (moInfo.getBaseStatus().getValue() != 4) && (moInfo.getBaseStatus().getValue() != 5)) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.STATUSINVALID_CANNOTSYNCTECH);
    }
    if (moInfo.getTotalSplitBaseQty().compareTo(SysConstant.BIGZERO) > 0) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.MOSPLITED_CANNOTSYNCTECH);
    }
    if (moInfo.getBirthType() == MOBirthTypeEnum.SPLIT) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.FROMSPLIT_CANNOTSYNCTECH);
    }
    if (moInfo.getTransactionType() == null) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.TRANSACTIONTYPEISNULL_CANNOTSYNCTECH);
    }
    if (moInfo.getRouting() == null) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.ROUTINGISNULL_CANNOTSYNCTECH);
    }
    if ((!moInfo.getTransactionType().isIsWPManagement()) && (moInfo.getRouting().getNumber().equals("-"))) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.DEFAULTROUTE_CANNOTSYNCTECH);
    }
    if (moInfo.getRouting().getStatus() != MMBasedataStatusEnum.AUDIT) {
      throw new ManufactureOrderSyncException(ManufactureOrderSyncException.ROUTINGUNAPPROVED_CANNOTSYNCTECH);
    }
    return true;
  }
  
  protected int getMaxDisSyncOperNo(Context ctx, IObjectValue model)
    throws EASBizException, BOSException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    int returnOperNo = 0;
    if ((moInfo.getBaseStatus() == BillBaseStatusEnum.TEMPORARILYSAVED) || (moInfo.getBaseStatus() == BillBaseStatusEnum.SUBMITED)) {
      return 0;
    }
    ManufactureOrderTechnicsCollection techCol = moInfo.getTechnics();
    ManufactureOrderTechnicsInfo techInfo = null;
    ManufactureOrderStockCollection stockCol = moInfo.getStocks();
    ManufactureOrderStockInfo stockInfo = null;
    
    Set disSyncTechSet = getTechsWithDestObject(ctx, moInfo.getId().toString());
    int i = 0;
    for (int size = techCol.size(); i < size; i++)
    {
      techInfo = techCol.get(i);
      if ((disSyncTechSet.contains(techInfo.getId().toString())) && (techInfo.getOperationNo() > returnOperNo)) {
        returnOperNo = techInfo.getOperationNo();
      }
    }
    Set destTypeHS = new HashSet();
    destTypeHS.add("500AB75E");
    destTypeHS.add("76C9F8D8");
    destTypeHS.add("BFBCAD51");
    
    Set disSyncStockSet = getMOEntryWithDestObject(ctx, moInfo.getId().toString(), destTypeHS);
     i = 0;
    for (int size = stockCol.size(); i < size; i++)
    {
      stockInfo = stockCol.get(i);
      if ((disSyncStockSet.contains(stockInfo.getId().toString())) && (stockInfo.getOperationNo() > returnOperNo)) {
        returnOperNo = stockInfo.getOperationNo();
      }
    }
    return returnOperNo;
  }
  
  private void synchronizeLaborCost(MRWorkProcesEntryInfo wkInfo, ManufactureOrderTechnicsInfo old, ManufactureOrderTechnicsInfo techInfo)
  {
    if (old != null)
    {
      if (NumericUtil.equals(old.getActualLaborCost(), old.getTheoreticalLaborCost()))
      {
        techInfo.setActualLaborCost(wkInfo.getLaborCost());
        techInfo.setTheoreticalLaborCost(wkInfo.getLaborCost());
      }
      else
      {
        techInfo.setActualLaborCost(old.getActualLaborCost());
        techInfo.setTheoreticalLaborCost(wkInfo.getLaborCost());
      }
      if (NumericUtil.equals(old.getActualScrapLaborCost(), old.getTheoreticalScrapLaborCost()))
      {
        techInfo.setActualScrapLaborCost(wkInfo.getScrapLaborCost());
        techInfo.setTheoreticalScrapLaborCost(wkInfo.getScrapLaborCost());
      }
      else
      {
        techInfo.setActualScrapLaborCost(old.getActualScrapLaborCost());
        techInfo.setTheoreticalScrapLaborCost(wkInfo.getScrapLaborCost());
      }
      if (NumericUtil.equals(old.getActualMatScrapLaborCost(), old.getTheoreticalMatScrapLaborCost()))
      {
        techInfo.setActualMatScrapLaborCost(wkInfo.getMatScrapLaborCost());
        techInfo.setTheoreticalMatScrapLaborCost(wkInfo.getMatScrapLaborCost());
      }
      else
      {
        techInfo.setActualMatScrapLaborCost(old.getActualMatScrapLaborCost());
        techInfo.setTheoreticalMatScrapLaborCost(wkInfo.getMatScrapLaborCost());
      }
    }
    else
    {
      techInfo.setActualLaborCost(SysConstant.BIGZERO);
      techInfo.setTheoreticalLaborCost(wkInfo.getLaborCost());
      techInfo.setActualScrapLaborCost(SysConstant.BIGZERO);
      techInfo.setTheoreticalScrapLaborCost(wkInfo.getScrapLaborCost());
      techInfo.setActualMatScrapLaborCost(SysConstant.BIGZERO);
      techInfo.setTheoreticalMatScrapLaborCost(wkInfo.getMatScrapLaborCost());
    }
    techInfo.setValuationType(wkInfo.getValuationType());
  }
  
  protected void syncTechs(Context ctx, IObjectValue model, int startOperNO)
    throws EASBizException, BOSException
  {
    ManufactureOrderInfo moInfo = (ManufactureOrderInfo)model;
    
    SCMEntryDataVO vo = new SCMEntryDataVO();
    vo.setMaterialInfos(new MaterialInfo[] { moInfo.getMaterial() });
    vo.setMeasureUnitInfos(new MeasureUnitInfo[] { moInfo.getUnit() });
    SCMEntryDataVO voResult = SCMGroupFacadeFactory.getLocalInstance(ctx).loadMmuPrecision(vo);
    String key1 = moInfo.getMaterial().getId().toString() + moInfo.getUnit().getId().toString();
    int unitPrec = 4;
    if ((voResult != null) && (voResult.getMmuPrecisions() != null) && (voResult.getMmuPrecisions().get(key1) != null)) {
      unitPrec = ((Integer)voResult.getMmuPrecisions().get(key1)).intValue();
    }
    ManufactureOrderTechnicsCollection techCol = moInfo.getTechnics();
    ManufactureOrderTechnicsInfo techInfo = null;
    
    boolean hasChange = false;
    
    int firstOperNo = startOperNO;
    
    Map techMap = new HashMap();
    
    int splitOperNo = 0;
    if (moInfo.getBirthType() == MOBirthTypeEnum.REFORM) {
      splitOperNo = getSplitOperNo(ctx, moInfo.getId().toString());
    }
    Map TRASHES = new HashMap();
    for (int i = techCol.size() - 1; i >= 0; i--)
    {
      techInfo = techCol.get(i);
      if (techInfo.getOperationNo() == startOperNO) {
        techMap.put(new Integer(firstOperNo), techInfo);
      }
      if ((techInfo.getOperationNo() > startOperNO) && (techInfo.getOperationNo() >= splitOperNo))
      {
        TRASHES.put(new Integer(techInfo.getOperationNo()), techInfo);
        techCol.removeObject(i);
        hasChange = true;
      }
    }
    Map REMAINS = new HashMap();
    int i = 0;
    for (int count = techCol.size(); i < count; i++)
    {
      techInfo = techCol.get(i);
      REMAINS.put(new Integer(techInfo.getOperationNo()), techInfo);
    }
    CoreBaseCollection wpCol = (CoreBaseCollection)getWorkProcess(ctx, moInfo.getRouting().getId().toString());
    MRWorkProcesEntryInfo wkInfo = null;
    
    boolean needsUpdate = false;
    if ((wpCol != null) && (wpCol.size() > 0))
    {
      int addCount = 0;
       i = 0;
      for (int size = wpCol.size(); i < size; i++)
      {
        wkInfo = (MRWorkProcesEntryInfo)wpCol.get(i);
        
        Integer key = new Integer(wkInfo.getWpSeq());
        if ((wkInfo.getWpSeq() > startOperNO) && (wkInfo.getWpSeq() >= splitOperNo))
        {
          addCount++;
          if (addCount == 1)
          {
            firstOperNo = wkInfo.getWpSeq();
            if (!hasChange) {
              techCol.get(techCol.size() - 1).setIsPickingPoint(false);
            }
          }
          hasChange = true;
          
          techMap.put(key, techInfo);
          
          techInfo = new ManufactureOrderTechnicsInfo();
          techInfo.setEarlistWoktime(moInfo.getPlanBeginDate());
          techInfo.setEarlistCmpTime(moInfo.getPlanEndDate());
          techInfo.setLastWorktime(moInfo.getPlanBeginDate());
          techInfo.setLastCmpTime(moInfo.getPlanEndDate());
          if (wkInfo.getWorkCenter() != null) {
            techInfo.setAdminOrgUnit(wkInfo.getWorkCenter().getAdminOrgUnit());
          }
          BigDecimal zero = SCMConstant.BIGDECIMAL_ZERO;
          techInfo.setFinishedQty(zero);
          techInfo.setIntoQty(zero);
          techInfo.setOutQty(zero);
          techInfo.setTestQty(zero);
          techInfo.setPassQty(zero);
          techInfo.setScrapQty(zero);
          techInfo.setRepairQty(zero);
          techInfo.setRepReportQty(zero);
          techInfo.setRepMoveInQty(zero);
          techInfo.setRepMoveOutQty(zero);
          
          techInfo.setConcessionQty(zero);
          techInfo.setConcessionBaseQty(zero);
          
          techInfo.setTotalMaterialScrapQty(zero);
          techInfo.setTotalManufactureScrapQty(zero);
          
          techInfo.setTotalSplitQty(zero);
          
          techInfo.setTotalDispatchQty(zero);
          
          techInfo.setUnDispatchQty(moInfo.getQty());
          techInfo.setUnit(moInfo.getUnit());
          techInfo.setBaseUnit(moInfo.getBaseUnit());
          techInfo.setQty(moInfo.getQty());
          techInfo.setOperQty(moInfo.getQty());
          techInfo.setWorkcenter(wkInfo.getWorkCenter());
          techInfo.setOperation(wkInfo.getOperation());
          techInfo.setOperationNo(wkInfo.getWpSeq());
          techInfo.setTimeUnit(wkInfo.getTimeUnit());
          techInfo.setIsCheckPoint(wkInfo.isIsCheckPoint());
          techInfo.setIsKeyOP(wkInfo.isIsImportantWP());
          techInfo.setIsReportPoint(wkInfo.isIsReportPoint());
          
          techInfo.setQueuingTime(wkInfo.getQueueTime());
          
          techInfo.setPrepareTime(wkInfo.getPreparedTime());
          
          techInfo.setWaitingTime(wkInfo.getWaittingTime());
          
          techInfo.setWorkTime(wkInfo.getMachiningTime());
          
          techInfo.setMovingTime(wkInfo.getTransferTime());
          techInfo.setOverrunMeasure(wkInfo.getOverrunMeasure());
          techInfo.setTotalQtyUpper(wkInfo.getRealProductQtyHigh());
          techInfo.setTotalQtyLower(wkInfo.getRealProductQtyLow());
          techInfo.setProcessBatch(wkInfo.getProcessBatch());
          
          BigDecimal totalQtyUpper = new BigDecimal("1.0").add(techInfo.getTotalQtyUpper().divide(new BigDecimal("100.00"), 4, 4)).setScale(unitPrec, 4);
          
          BigDecimal totalUpperQty = moInfo.getQty().multiply(totalQtyUpper).setScale(unitPrec, 4);
          techInfo.setTotalUpperQty(totalUpperQty);
          
          ControlStrategyInfo cs = wkInfo.getControlStrategy();
          techInfo.setControlStrategy(cs);
          
          techInfo.setEntrustType(wkInfo.getEntrustType() == null ? CSEntrustTypeEnum.NONE : wkInfo.getEntrustType());
          
          techInfo.setEntrustSupplier(wkInfo.getEntrustSupplier());
          
          techInfo.setSubRouting(wkInfo.getChildRooting());
          
          ManufactureOrderTechnicsInfo after = (ManufactureOrderTechnicsInfo)TRASHES.get(key);
          synchronizeLaborCost(wkInfo, after, techInfo);
          if ((techInfo.getEntrustType() == CSEntrustTypeEnum.NONE) || (techInfo.getEntrustType() == CSEntrustTypeEnum.OPERATIONENTRUST)) {
            techInfo.setStorageOrgUnit(moInfo.getStorageOrgUnit());
          } else {
            techInfo.setStorageOrgUnit(wkInfo.getCooStorageOrgUnit());
          }
          if (i == wpCol.size() - 1)
          {
            techInfo.setIsPickingPoint(true);
            techInfo.setIsReportPoint(true);
          }
          else
          {
            techInfo.setIsPickingPoint(false);
          }
          techInfo.setOperationRemark(wkInfo.getOperationRemark(getLocale()), getLocale());
          techCol.add(techInfo);
        }
        else
        {
          ManufactureOrderTechnicsInfo before = (ManufactureOrderTechnicsInfo)REMAINS.get(key);
          if (before != null)
          {
            needsUpdate = true;
            synchronizeLaborCost(wkInfo, before, before);
          }
        }
      }
    }
    if ((hasChange) || (needsUpdate))
    {
      MMCommonUtils.objectValueSort(techCol, true, "operationNo");
      
      moInfo.setFirstOperNo(techCol.get(0).getOperationNo());
      moInfo.setLastOperNo(techCol.get(techCol.size() - 1).getOperationNo());
      if ((moInfo.getBaseStatus().getValue() != 1) && (moInfo.getBaseStatus().getValue() != 2))
      {
        techCol.get(0).setIntoBaseQty(techCol.get(0).getBaseQty());
        techCol.get(0).setIntoQty(techCol.get(0).getQty());
      }
      updateStockOper(ctx, moInfo.getStocks(), startOperNO, firstOperNo, techMap);
      
      updateStock(moInfo);
      
      updateExpectOutputOper(ctx, moInfo.getExpectOutputs(), 0, moInfo.getLastOperNo(), techMap);
      
      _update(ctx, new ObjectUuidPK(moInfo.getId()), moInfo);
    }
  }
  
  protected void updateExpectOutputOper(Context ctx, ManufactureOrderExpectOutputCollection moExpectOutPutCol, int startOperNO, int defaultOperNo, Map techMap)
    throws EASBizException, BOSException
  {
    ManufactureOrderExpectOutputInfo entryInfo = null;
    int i = 0;
    for (int size = moExpectOutPutCol.size(); i < size; i++)
    {
      entryInfo = (ManufactureOrderExpectOutputInfo)moExpectOutPutCol.getObject(i);
      int operationNo = entryInfo.getOperationNo();
      if (operationNo > startOperNO) {
        if (techMap.containsKey(new Integer(operationNo)))
        {
          ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)techMap.get(new Integer(operationNo));
          entryInfo.setOperation(techInfo.getOperation());
        }
        else
        {
          entryInfo.setOperationNo(defaultOperNo);
          ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)techMap.get(new Integer(defaultOperNo));
          entryInfo.setOperation(techInfo.getOperation());
        }
      }
    }
  }
  
  protected void updateStockOper(Context ctx, ManufactureOrderStockCollection moStockCol, int startOperNO, int defaultOperNo, Map techMap)
    throws EASBizException, BOSException
  {
    ManufactureOrderStockInfo stockInfo = null;
    int i = 0;
    for (int size = moStockCol.size(); i < size; i++)
    {
      stockInfo = (ManufactureOrderStockInfo)moStockCol.getObject(i);
      int operationNo = stockInfo.getOperationNo();
      if (operationNo > startOperNO) {
        if (techMap.containsKey(new Integer(operationNo)))
        {
          ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)techMap.get(new Integer(operationNo));
          stockInfo.setOperation(techInfo.getOperation());
          stockInfo.setWorkcenter(techInfo.getWorkcenter());
          if (!techInfo.getEntrustType().equals(EntrustTypeEnum.ENTRUST)) {
            stockInfo.setPickDept(techInfo.getAdminOrgUnit());
          }
        }
        else
        {
          stockInfo.setOperationNo(defaultOperNo);
          ManufactureOrderTechnicsInfo techInfo = (ManufactureOrderTechnicsInfo)techMap.get(new Integer(defaultOperNo));
          stockInfo.setOperation(techInfo.getOperation());
          stockInfo.setWorkcenter(techInfo.getWorkcenter());
          if (!techInfo.getEntrustType().equals(EntrustTypeEnum.ENTRUST)) {
            stockInfo.setPickDept(techInfo.getAdminOrgUnit());
          }
        }
      }
    }
  }
  
  protected IObjectCollection getWorkProcess(Context ctx, String routingID)
    throws EASBizException, BOSException
  {
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filterInfo = new FilterInfo();
    filterInfo.getFilterItems().add(new FilterItemInfo("parent", "SELECT FMaterialRootingID FROM t_mm_standardrooting where fid = '" + routingID + "' ", CompareType.INNER));
    
    viewInfo.setFilter(filterInfo);
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("workCenter.id"));
    sic.add(new SelectorItemInfo("workCenter.number"));
    sic.add(new SelectorItemInfo("workCenter.name"));
    sic.add(new SelectorItemInfo("workCenter.classTeam.id"));
    sic.add(new SelectorItemInfo("workCenter.classTeam.number"));
    sic.add(new SelectorItemInfo("workCenter.adminOrgUnit.id"));
    sic.add(new SelectorItemInfo("workCenter.adminOrgUnit.name"));
    sic.add(new SelectorItemInfo("workCenter.adminOrgUnit.number"));
    sic.add(new SelectorItemInfo("controlStrategy.id"));
    sic.add(new SelectorItemInfo("controlStrategy.number"));
    sic.add(new SelectorItemInfo("controlStrategy.name"));
    sic.add(new SelectorItemInfo("controlStrategy.status"));
    sic.add(new SelectorItemInfo("controlStrategy.opCheckGenType"));
    sic.add(new SelectorItemInfo("controlStrategy.inWareHsGenType"));
    sic.add(new SelectorItemInfo("controlStrategy.entrustType"));
    sic.add(new SelectorItemInfo("controlStrategy.cooStorageOrgUnit.id"));
    sic.add(new SelectorItemInfo("controlStrategy.cooStorageOrgUnit.number"));
    sic.add(new SelectorItemInfo("controlStrategy.cooStorageOrgUnit.name"));
    sic.add(new SelectorItemInfo("operation.id"));
    sic.add(new SelectorItemInfo("operation.name"));
    sic.add(new SelectorItemInfo("operation.number"));
    sic.add(new SelectorItemInfo("operation.status"));
    
    sic.add(new SelectorItemInfo("entrustSupplier.id"));
    sic.add(new SelectorItemInfo("entrustSupplier.name"));
    sic.add(new SelectorItemInfo("entrustSupplier.number"));
    
    sic.add(new SelectorItemInfo("childRooting.id"));
    sic.add(new SelectorItemInfo("childRooting.name"));
    sic.add(new SelectorItemInfo("childRooting.number"));
    
    sic.add(new SelectorItemInfo("cooStorageOrgUnit.id"));
    sic.add(new SelectorItemInfo("cooStorageOrgUnit.number"));
    sic.add(new SelectorItemInfo("cooStorageOrgUnit.name"));
    
    viewInfo.setSelector(sic);
    SorterItemCollection sor = new SorterItemCollection();
    sor.add(new SorterItemInfo("wpSeq"));
    viewInfo.setSorter(sor);
    IMRWorkProcesEntry iWorkprocess = MRWorkProcesEntryFactory.getLocalInstance(ctx);
    CoreBaseCollection wkCol = iWorkprocess.getCollection(viewInfo);
    return wkCol;
  }
  
  protected int getSplitOperNo(Context ctx, String id)
    throws EASBizException, BOSException
  {
    int operNo = 0;
    String sql_getSplitOperNo = "SELECT distinct FSplitOperationNo FROM T_MM_MOSplitRecord WHERE FChildId = ?";
    
    IRowSet rs = DbUtil.executeQuery(ctx, sql_getSplitOperNo, new Object[] { id });
    try
    {
      if (rs.next()) {
        operNo = rs.getInt("FSplitOperationNo");
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return operNo;
  }
  
  protected String _genMnfOrder(Context ctx, ManufactureOrderInfo mnfOrderInfo)
    throws BOSException, EASBizException
  {
    mnfOrderInfo.setCreator(UserFactory.getLocalInstance(ctx).getUserInfo(ctx.getCaller()));
    
    mnfOrderInfo.setBaseStatus(BillBaseStatusEnum.ADD);
    
    mnfOrderInfo.setId(BOSUuid.create("1D0D80DD"));
    Calendar cal = Calendar.getInstance();
    java.util.Date curDate = cal.getTime();
    
    mnfOrderInfo.setBizDate(curDate);
    
    mnfOrderInfo.setCreateTime(new Timestamp(cal.getTimeInMillis()));
    
    IBillType iBillType = BillTypeFactory.getLocalInstance(ctx);
    BillTypeInfo billTypeInfo = iBillType.getBillTypeInfo(new ObjectUuidPK("B2aZSVXaSx6qxdfekgCmrEY+1VI="));
    mnfOrderInfo.setBillType(billTypeInfo);
    
    mnfOrderInfo.setLongNumber(mnfOrderInfo.getId().toString());
    if (mnfOrderInfo.getStorageOrgUnit() != null)
    {
      ProductTransactionTypeInfo trnsType = null;
      MaterialPlanInfo materialPlanInfo = getMaterialPlanInfo(ctx, mnfOrderInfo.getMaterial(), mnfOrderInfo.getStorageOrgUnit());
      
      mnfOrderInfo.setAdminOrgUnit(materialPlanInfo.getDutyDepartment());
      
      trnsType = MOProductTransactionTypeUtil.getDefaultTransType(ctx, mnfOrderInfo.getMaterial(), materialPlanInfo, mnfOrderInfo.getStorageOrgUnit(), mnfOrderInfo.getAdminOrgUnit() == null ? materialPlanInfo.getDutyDepartment() : mnfOrderInfo.getAdminOrgUnit(), "vGXRx5fFSsCYz9Zv7CzzgyQHQ1w=");
      if (trnsType != null)
      {
        mnfOrderInfo.setTransactionType(trnsType);
        mnfOrderInfo.setBizType(trnsType.getBizType());
        mnfOrderInfo.setScheduleType(trnsType.getScheduleType());
      }
    }
    lotNumberCheck(ctx, mnfOrderInfo);
    
    Map mapData = new HashMap();
    if (mnfOrderInfo.getBomID() != null) {
      mapData.put("BOM", (BomInfo)BomFactory.getLocalInstance(ctx).getValue(new ObjectUuidPK(BOSUuid.read(mnfOrderInfo.getBomID()))));
    }
    if (mnfOrderInfo.getRouting() != null) {
      mapData.put("ROUTINGID", mnfOrderInfo.getRouting().getId().toString());
    }
    mapData.put("STORAGEORG", mnfOrderInfo.getStorageOrgUnit());
    mapData.put("TRANSTYPE", mnfOrderInfo.getTransactionType());
    mapData.put("MATERIAL", mnfOrderInfo.getMaterial());
    mapData.put("BEGINTIME", mnfOrderInfo.getPlanBeginDate());
    mapData.put("ENDTIME", mnfOrderInfo.getPlanEndDate());
    mapData.put("BILL_UNIT", mnfOrderInfo.getUnit());
    mapData.put("BASEUNIT", mnfOrderInfo.getBaseUnit());
    mapData.put("BILL_QTY", mnfOrderInfo.getQty());
    mapData.put("SPLIT_QTY", new BigDecimal(0.0D));
    
    mapData.put("projectID", mnfOrderInfo.getProject());
    mapData.put("trackID", mnfOrderInfo.getTrackNumber());
    mapData.put("LOTNUMBER", mnfOrderInfo.getLot());
    
    mapData.put("adminOrgUnit", mnfOrderInfo.getAdminOrgUnit());
    
    Map retData = _getMaterialRelationData(ctx, mapData, false);
    
    BomInfo bomInfo = (BomInfo)retData.get("BOM");
    
    mnfOrderInfo.setYield(bomInfo.getYield());
    
    String key1 = mnfOrderInfo.getMaterial().getId().toString() + mnfOrderInfo.getStorageOrgUnit().getId().toString();
    if ((((SCMEntryDataVO)retData.get("VO_ENTRY")).getMaterialPlanInfos() != null) && ((MaterialPlanInfo)((SCMEntryDataVO)retData.get("VO_ENTRY")).getMaterialPlanInfos().get(key1) != null))
    {
      SCMEntryDataVO voResult = (SCMEntryDataVO)retData.get("VO_ENTRY");
      int unitPrec = 4;
      if ((bomInfo != null) && (mnfOrderInfo.getMaterial() != null) && (mnfOrderInfo.getMaterial().getId() != null) && (mnfOrderInfo.getUnit() != null) && (mnfOrderInfo.getUnit().getId() != null))
      {
        String key = mnfOrderInfo.getMaterial().getId().toString() + mnfOrderInfo.getUnit().getId().toString();
        if ((voResult != null) && (voResult.getMmuPrecisions() != null) && (voResult.getMmuPrecisions().get(key) != null)) {
          unitPrec = ((Integer)voResult.getMmuPrecisions().get(key)).intValue();
        }
      }
      mnfOrderInfo.setDeliveryQty(mnfOrderInfo.getQty().multiply(bomInfo.getYield()).divide(SCMConstant.BIGDECIMAL_ONEHUNDRED, unitPrec, 4));
      
      mnfOrderInfo.setDeliveryBaseQty(mnfOrderInfo.getBaseQty().multiply(bomInfo.getYield()).divide(SCMConstant.BIGDECIMAL_ONEHUNDRED, unitPrec, 4));
      
      MaterialPlanInfo materialPlan = (MaterialPlanInfo)((SCMEntryDataVO)retData.get("VO_ENTRY")).getMaterialPlanInfos().get(key1);
      if (materialPlan.getRcvInHightLimit() != null)
      {
        mnfOrderInfo.setExtraRatio(materialPlan.getRcvInHightLimit());
        BigDecimal extraRatio = materialPlan.getRcvInHightLimit().divide(new BigDecimal("100.00"), 4, 4).add(new BigDecimal("1.0"));
        
        BigDecimal extraQty = mnfOrderInfo.getQty().multiply(extraRatio).setScale(unitPrec, 0);
        mnfOrderInfo.setExtraUpperLimit(extraQty);
      }
      else
      {
        mnfOrderInfo.setExtraRatio(SysConstant.BIGZERO);
        mnfOrderInfo.setExtraUpperLimit(mnfOrderInfo.getQty());
      }
      if (materialPlan.getRcvInLowLimit() != null)
      {
        mnfOrderInfo.setLackRatio(materialPlan.getRcvInLowLimit());
        BigDecimal lackRatio = new BigDecimal("1.0").subtract(materialPlan.getRcvInLowLimit().divide(new BigDecimal("100.00"), 4, 4));
        
        BigDecimal lackQty = mnfOrderInfo.getQty().multiply(lackRatio).setScale(unitPrec, 0);
        mnfOrderInfo.setLackLowerLimit(lackQty);
      }
      else
      {
        mnfOrderInfo.setLackRatio(SysConstant.BIGZERO);
        mnfOrderInfo.setLackLowerLimit(mnfOrderInfo.getQty());
      }
      if (((mnfOrderInfo.getTransactionType() != null) && (mnfOrderInfo.getTransactionType().isIsWPManagement())) || (!materialPlan.isIsStorageLimit())) {
        mnfOrderInfo.setIsLimitedQty(false);
      } else {
        mnfOrderInfo.setIsLimitedQty(true);
      }
      MaterialIssueModeEnum issMode = materialPlan.getIssMode();
      if (11050 == issMode.getValue()) {
        mnfOrderInfo.setIsDirectSend(true);
      } else {
        mnfOrderInfo.setIsDirectSend(false);
      }
      if (mnfOrderInfo.getAdminOrgUnit() == null) {
        mnfOrderInfo.setAdminOrgUnit(materialPlan.getDutyDepartment());
      }
      if (mnfOrderInfo.getDispatcher() == null) {
        mnfOrderInfo.setDispatcher(materialPlan.getPlanner());
      }
      if (mnfOrderInfo.getPlanOrgUnit() == null) {
        mnfOrderInfo.setPlanOrgUnit(materialPlan.getPlanOrg());
      }
    }
    mnfOrderInfo.setDefaultWarehous((WarehouseInfo)retData.get("DEFAULTWAREHOUSE"));
    
    mnfOrderInfo.setRouting((StandardRootingInfo)retData.get("ROUTING"));
    
    ManufactureOrderTechnicsCollection techCol = (ManufactureOrderTechnicsCollection)retData.get("TECHNICS");
    if (techCol != null) {
      mnfOrderInfo.getTechnics().addCollection(techCol);
    }
    if (retData.get("STOCKS") != null) {
      mnfOrderInfo.getStocks().addCollection((ManufactureOrderStockCollection)retData.get("STOCKS"));
    }
    if (retData.get("EXPECTOUTPUTS") != null) {
      mnfOrderInfo.getExpectOutputs().addCollection((ManufactureOrderExpectOutputCollection)retData.get("EXPECTOUTPUTS"));
    }
    BatchExecuteResult result = null;
    try
    {
      BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { ManufactureOrderInfo.class, BOTRelationCollection.class }, new Object[] { mnfOrderInfo, null });
      
      BatchExecuteParamsEntry[] entrys = { entry };
      
      result = ManufactureOrderFactory.getLocalInstance(ctx).batchExecute("submitRelations", new Class[] { CoreBillBaseInfo.class, BOTRelationCollection.class }, entrys);
    }
    catch (BaseException e)
    {
      throw new BOSException(e);
    }
    BatchActionResults bar = (BatchActionResults)result.getBatchResult();
    if (bar.hasException(null)) {
      throw new ManufactureOrderException(ManufactureOrderException.COMMONEXCEPTION, new Object[] { bar.getActionResult(mnfOrderInfo.getId().toString()).getMessage() });
    }
    return mnfOrderInfo.getId().toString();
  }
  
  private static MaterialPlanInfo getMaterialPlanInfo(Context ctx, MaterialInfo material, StorageOrgUnitInfo storage)
    throws BOSException
  {
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    SelectorItemCollection selectorItemCollection = new SelectorItemCollection();
    selectorItemCollection.add(new SelectorItemInfo("*"));
    selectorItemCollection.add(new SelectorItemInfo("productTranType.*"));
    FilterInfo filterInfo = new FilterInfo();
    filterInfo.getFilterItems().add(new FilterItemInfo("material.id", material.getId().toString(), CompareType.EQUALS));
    filterInfo.getFilterItems().add(new FilterItemInfo("orgUnit.id", storage.getId().toString(), CompareType.EQUALS));
    entityViewInfo.setFilter(filterInfo);
    entityViewInfo.setSelector(selectorItemCollection);
    MaterialPlanCollection materialPlanCollection = MaterialPlanFactory.getLocalInstance(ctx).getMaterialPlanCollection(entityViewInfo);
    if ((materialPlanCollection != null) && (materialPlanCollection.size() > 0))
    {
      MaterialPlanInfo materialPlanInfo = materialPlanCollection.get(0);
      return materialPlanInfo;
    }
    return null;
  }
  
//  protected Map _manufactureOrderClosedCheck(Context ctx, BatchActionResults batchResults, ManufactureOrderInfo moInfo)
//    throws BOSException, EASBizException
//  {
//    MOAutoCloseUtil.moCloseCheck(ctx, batchResults);
//    Map map = new HashMap();
//    
//    map.put("results", batchResults);
//    return map;
//  }
  
  protected void _freezing(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    BatchExecuteParamsEntry[] entrys = { entry };
    batchFreezing(ctx, entrys);
  }
  
  protected void _thawing(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class }, new Object[] { pk });
    BatchExecuteParamsEntry[] entrys = { entry };
    batchThawing(ctx, entrys);
  }
  
  public BatchActionResults batchFreezing(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("FREEZING"));
  }
  
  public BatchActionResults batchThawing(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("THAWING"));
  }
  
  protected CostObjectInfo _getCostObjectForExp(Context ctx, MaterialInfo metarial, StorageOrgUnitInfo storageInfo, String lot)
    throws BOSException
  {
    try
    {
      return MOCostObjectUtil.getCostObject(ctx, metarial, storageInfo, lot, null, false, false);
    }
    catch (EASBizException e)
    {
      throw new BOSException(e);
    }
  }
  
  protected void synchronizeMOInfo(Context ctx, ManufactureOrderInfo mo)
    throws EASBizException, BOSException
  {
    ManufactureOrderInfo dbData = getManufactureOrderInfo(ctx, new ObjectUuidPK(mo.getId()));
    
    synchronizeHeadData(mo, dbData);
    
    ManufactureOrderStockCollection stockCol = mo.getStocks();
    ManufactureOrderStockCollection dbStockCol = dbData.getStocks();
    for (int i = 0; i < stockCol.size(); i++)
    {
      ManufactureOrderStockInfo stockInfo = stockCol.get(i);
      for (int j = 0; j < dbStockCol.size(); j++)
      {
        ManufactureOrderStockInfo dbStockData = dbStockCol.get(j);
        if (dbStockData.getId().equals(stockInfo.getId()))
        {
          synchronizeStockData(stockInfo, dbStockData);
          break;
        }
      }
    }
    ManufactureOrderTechnicsCollection technicsCol = mo.getTechnics();
    ManufactureOrderTechnicsCollection dbTechnicsCol = dbData.getTechnics();
    for (int i = 0; i < technicsCol.size(); i++)
    {
      ManufactureOrderTechnicsInfo technicsInfo = technicsCol.get(i);
      for (int j = 0; j < dbTechnicsCol.size(); j++)
      {
        ManufactureOrderTechnicsInfo dbTechnicsData = dbTechnicsCol.get(j);
        if (dbTechnicsData.getId().equals(technicsInfo.getId()))
        {
          synchronizeTechnicsData(technicsInfo, dbTechnicsData);
          break;
        }
      }
    }
    ManufactureOrderExpectOutputCollection outputCol = mo.getExpectOutputs();
    ManufactureOrderExpectOutputCollection dbOutputCol = dbData.getExpectOutputs();
    for (int i = 0; i < outputCol.size(); i++)
    {
      ManufactureOrderExpectOutputInfo outputInfo = outputCol.get(i);
      for (int j = 0; j < dbOutputCol.size(); j++)
      {
        ManufactureOrderExpectOutputInfo dbOutputData = dbOutputCol.get(j);
        if (dbOutputData.getId().equals(outputInfo.getId()))
        {
          synchronizeExpectOutputData(outputInfo, dbOutputData);
          break;
        }
      }
    }
  }
  
  protected void synchronizeHeadData(ManufactureOrderInfo mo, ManufactureOrderInfo dbData)
  {
    mo.setTotalSplitQty(dbData.getTotalSplitQty());
    mo.setTotalSplitBaseQty(dbData.getTotalSplitBaseQty());
    
    mo.setToStroreQty(dbData.getToStroreQty());
    mo.setToStoreBaseQty(dbData.getToStoreBaseQty());
    
    mo.setFinishedQty(dbData.getFinishedQty());
    mo.setFinishedBaseQty(dbData.getFinishedBaseQty());
    
    mo.setActureQty(dbData.getActureQty());
    mo.setActureBaseQty(dbData.getActureBaseQty());
    
    mo.setPassQty(dbData.getPassQty());
    mo.setPassBaseQty(dbData.getPassBaseQty());
    
    mo.setConcessionQty(dbData.getConcessionQty());
    mo.setConcessionBaseQty(dbData.getConcessionBaseQty());
    
    mo.setScrapQty(dbData.getScrapQty());
    mo.setScrapBaseQty(dbData.getScrapBaseQty());
    
    mo.setRepairQty(dbData.getRepairQty());
    mo.setRepairBaseQty(dbData.getRepairBaseQty());
    
    mo.setTotalDirectSendQty(dbData.getTotalDirectSendQty());
    mo.setTotalDirectSendBaseQty(dbData.getTotalDirectSendBaseQty());
    
    mo.setTestedQty(dbData.getTestedQty());
    mo.setTestedBaseQty(dbData.getTestedBaseQty());
    
    mo.setUnToStoreQty(dbData.getUnToStoreQty());
    mo.setUnToStoreBaseQty(dbData.getUnToStoreBaseQty());
    
    mo.setUnTestedQty(dbData.getUnToStoreQty());
    mo.setUnTestedBaseQty(dbData.getUnToStoreBaseQty());
    
    mo.setUnRepairQty(dbData.getUnRepairQty());
    mo.setUnRepairBaseQty(dbData.getUnRepairBaseQty());
  }
  
  protected void synchronizeStockData(ManufactureOrderStockInfo stockInfo, ManufactureOrderStockInfo dbStockData)
  {
    stockInfo.setActIssueQty(dbStockData.getActIssueQty());
    stockInfo.setActIssueBaseQty(dbStockData.getActIssueBaseQty());
    
    stockInfo.setRejectedQty(dbStockData.getRejectedQty());
    stockInfo.setRejectedBaseQty(dbStockData.getRejectedBaseQty());
    
    stockInfo.setUnIssueQty(dbStockData.getUnIssueQty());
    stockInfo.setUnIssueBaseQty(dbStockData.getUnIssueBaseQty());
    
    stockInfo.setScrapQty(dbStockData.getScrapQty());
    stockInfo.setScrapBaseQty(dbStockData.getScrapBaseQty());
    
    stockInfo.setMaterialScrapQty(dbStockData.getMaterialScrapQty());
    stockInfo.setMaterialScrapBaseQty(dbStockData.getMaterialScrapBaseQty());
    
    stockInfo.setFeedingQty(dbStockData.getFeedingQty());
    stockInfo.setFeedingBaseQty(dbStockData.getFeedingBaseQty());
    
    stockInfo.setMaterialFeedingQty(dbStockData.getMaterialFeedingQty());
    stockInfo.setMaterialFeedingBaseQty(dbStockData.getMaterialFeedingBaseQty());
    
    stockInfo.setTotalDirectReceiveQty(dbStockData.getTotalDirectReceiveQty());
    stockInfo.setTotalDirectReceiveBaseQty(dbStockData.getTotalDirectReceiveBaseQty());
    
    stockInfo.setTotalReceiptQty(dbStockData.getTotalReceiptQty());
    stockInfo.setTotalReceiptBaseQty(dbStockData.getTotalReceiptBaseQty());
    
    stockInfo.setUnReceiptQty(dbStockData.getUnReceiptQty());
    stockInfo.setUnReceiptBaseQty(dbStockData.getUnReceiptBaseQty());
    
    stockInfo.setToStoreQty(dbStockData.getToStoreQty());
    stockInfo.setToStoreBaseQty(dbStockData.getToStoreBaseQty());
    
    stockInfo.setTotalDSTransferQty(dbStockData.getTotalDSTransferQty());
    stockInfo.setTotalDSTransferBaseQty(dbStockData.getTotalDSTransferBaseQty());
    
    stockInfo.setAssociateQty(dbStockData.getAssociateQty());
  }
  
  protected void synchronizeTechnicsData(ManufactureOrderTechnicsInfo technicsInfo, ManufactureOrderTechnicsInfo dbTechnicsData)
  {
    technicsInfo.setTotalSplitQty(dbTechnicsData.getTotalSplitQty());
    technicsInfo.setTotalSplitBaseQty(dbTechnicsData.getTotalSplitBaseQty());
    
    technicsInfo.setTotalDispatchQty(dbTechnicsData.getTotalDispatchQty());
    technicsInfo.setTotalDispatchBaseQty(dbTechnicsData.getTotalDispatchBaseQty());
    
    technicsInfo.setUnDispatchQty(dbTechnicsData.getUnDispatchQty());
    technicsInfo.setUnDispatchBaseQty(dbTechnicsData.getUnDispatchBaseQty());
    
    technicsInfo.setFinishedQty(dbTechnicsData.getFinishedQty());
    technicsInfo.setFinishedBaseQty(dbTechnicsData.getFinishedBaseQty());
    
    technicsInfo.setRepReportQty(dbTechnicsData.getRepReportQty());
    technicsInfo.setRepReportBaseQty(dbTechnicsData.getRepReportBaseQty());
    
    technicsInfo.setTestQty(dbTechnicsData.getTestQty());
    technicsInfo.setTestBaseQty(dbTechnicsData.getTestBaseQty());
    
    technicsInfo.setPassQty(dbTechnicsData.getPassQty());
    technicsInfo.setPassBaseQty(dbTechnicsData.getPassBaseQty());
    
    technicsInfo.setConcessionQty(dbTechnicsData.getConcessionQty());
    technicsInfo.setConcessionBaseQty(dbTechnicsData.getConcessionBaseQty());
    
    technicsInfo.setScrapQty(dbTechnicsData.getScrapQty());
    technicsInfo.setScrapBaseQty(dbTechnicsData.getScrapBaseQty());
    
    technicsInfo.setTotalManufactureScrapQty(dbTechnicsData.getTotalManufactureScrapQty());
    technicsInfo.setTotalManufactureScrapBaseQty(dbTechnicsData.getTotalManufactureScrapBaseQty());
    
    technicsInfo.setTotalMaterialScrapQty(dbTechnicsData.getTotalMaterialScrapQty());
    technicsInfo.setTotalMaterialScrapBaseQty(dbTechnicsData.getTotalMaterialScrapBaseQty());
    
    technicsInfo.setRepairQty(dbTechnicsData.getRepairQty());
    technicsInfo.setRepairBaseQty(dbTechnicsData.getRepairBaseQty());
    
    technicsInfo.setIntoQty(dbTechnicsData.getIntoQty());
    technicsInfo.setIntoBaseQty(dbTechnicsData.getIntoBaseQty());
    
    technicsInfo.setRepMoveInQty(dbTechnicsData.getRepMoveInQty());
    technicsInfo.setRepMoveInBaseQty(dbTechnicsData.getRepMoveInBaseQty());
    
    technicsInfo.setOutQty(dbTechnicsData.getOutQty());
    technicsInfo.setOutBaseQty(dbTechnicsData.getOutBaseQty());
    
    technicsInfo.setRepMoveOutQty(dbTechnicsData.getRepMoveOutQty());
    technicsInfo.setRepMoveOutBaseQty(dbTechnicsData.getRepMoveOutBaseQty());
    
    technicsInfo.setAssociateQty(dbTechnicsData.getAssociateQty());
  }
  
  protected void synchronizeExpectOutputData(ManufactureOrderExpectOutputInfo outputInfo, ManufactureOrderExpectOutputInfo dbOutputData)
  {
    outputInfo.setFinishedQty(outputInfo.getFinishedQty());
    outputInfo.setFinishedBaseQty(outputInfo.getFinishedBaseQty());
    
    outputInfo.setPassQty(outputInfo.getPassQty());
    outputInfo.setPassBaseQty(outputInfo.getPassBaseQty());
    
    outputInfo.setScrapQty(outputInfo.getScrapQty());
    outputInfo.setScrapBaseQty(outputInfo.getScrapBaseQty());
    
    outputInfo.setToStoreQty(outputInfo.getToStoreQty());
    outputInfo.setToStoreBaseQty(outputInfo.getToStoreBaseQty());
    
    outputInfo.setAssociateQty(outputInfo.getAssociateQty());
  }
  
  private String getBOMIDByPOID(Context ctx, String sql)
    throws BOSException
  {
    StringBuffer sqlBuf = new StringBuffer();
    
    sqlBuf.append("select fid ,FBomInterID from t_mm_plannedorder where fid = '").append(sql).append("'");
    String bomID = null;
    IRowSet rowSet = DbUtil.executeQuery(ctx, sqlBuf.toString());
    try
    {
      while ((rowSet != null) && (rowSet.next())) {
        bomID = rowSet.getString("FBomInterID");
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return bomID;
  }
  
  private boolean isMaterialSubsByPOID(Context ctx, String sql)
    throws BOSException
  {
    StringBuffer sqlBuf = new StringBuffer();
    
    sqlBuf.append("select FMaterialSubsID from T_MM_PlannedOrderEntry where FParentID in ").append(" (select fid from T_MM_PlannedOrder where fid = '").append(sql).append("')");
    
    IRowSet rowSet = DbUtil.executeQuery(ctx, sqlBuf.toString());
    try
    {
      while ((rowSet != null) && (rowSet.next()))
      {
        String materialSubs = rowSet.getString("FMaterialSubsID");
        if ((materialSubs != null) && (materialSubs.length() > 0)) {
          return true;
        }
      }
    }
    catch (SQLException e)
    {
      throw new BOSException(e);
    }
    return false;
  }
  
  private boolean isAppointBOM(Object obj)
  {
    if ((obj != null) && (((Boolean)obj).booleanValue())) {
      return true;
    }
    return false;
  }
  
  private void getBOMInfoInBomExpand(Context ctx, ManufactureOrderInfo mo, Map inParam)
    throws BOSException, EASBizException
  {
    BomInfo bom = null;
    
    String projectID = null;
    if ((mo != null) && (mo.getProject() != null) && (mo.getProject().getId() != null))
    {
      projectID = mo.getProject().getId().toString();
      inParam.put("projectID", mo.getProject());
    }
    if ((mo == null) && (inParam.get("projectID") != null)) {
      projectID = ((ProjectInfo)inParam.get("projectID")).getId().toString();
    }
    String trackID = null;
    if ((mo != null) && (mo.getTrackNumber() != null) && (mo.getTrackNumber().getId() != null))
    {
      trackID = mo.getTrackNumber().getId().toString();
      inParam.put("trackID", mo.getTrackNumber());
    }
    if ((mo == null) && (inParam.get("trackID") != null)) {
      trackID = ((TrackNumberInfo)inParam.get("trackID")).getId().toString();
    }
    if ((mo != null) && (mo.getBomID() != null) && (mo.getBomID().length() > 0))
    {
      SelectorItemCollection sic = new SelectorItemCollection();
      sic.add(new SelectorItemInfo("id"));
      sic.add(new SelectorItemInfo("number"));
      sic.add(new SelectorItemInfo("name"));
      sic.add(new SelectorItemInfo("yield"));
      sic.add(new SelectorItemInfo("bomType"));
      
      bom = BomFactory.getLocalInstance(ctx).getBomInfo(new ObjectStringPK(mo.getBomID()), sic);
    }
    if ((mo == null) && (inParam.get("trackID") != null)) {
      bom = (BomInfo)inParam.get("BOM");
    }
    if (bom == null) {
      if (mo != null)
      {
        bom = BOMExtend2FacadeFactory.getLocalInstance(ctx).getBomByTrcAndPrjID(mo.getMaterial().getId().toString(), projectID, trackID, mo.getStorageOrgUnit().getId().toString());
      }
      else
      {
        MaterialInfo materialInfo = (MaterialInfo)inParam.get("MATERIAL");
        StorageOrgUnitInfo storageOrgUnit = (StorageOrgUnitInfo)inParam.get("STORAGEORG");
        if ((materialInfo != null) && (storageOrgUnit != null))
        {
          String materialID = materialInfo.getId().toString();
          String storageOrgUnitID = storageOrgUnit.getId().toString();
          bom = BOMExtend2FacadeFactory.getLocalInstance(ctx).getBomByTrcAndPrjID(materialID, projectID, trackID, storageOrgUnitID);
        }
      }
    }
    inParam.put("BOM", bom);
  }
  
  protected Map _getStockPickDept(Context ctx, List moStockDeptCalcVOList)
  {
    if ((moStockDeptCalcVOList == null) || (moStockDeptCalcVOList.size() <= 0)) {
      return null;
    }
    return MOStockUtil.getStockPickDept(moStockDeptCalcVOList);
  }
  
  private void updateStock(ManufactureOrderInfo moInfo)
  {
    if ((moInfo == null) || (moInfo.getStocks() == null) || (moInfo.getStocks().size() <= 0)) {
      return;
    }
    int stockCnt = moInfo.getStocks().size();
    for (int curStockIdx = 0; curStockIdx < stockCnt; curStockIdx++)
    {
      ManufactureOrderStockInfo curStockInfo = moInfo.getStocks().get(curStockIdx);
      curStockInfo.setPickDept(MOStockUtil.getDefaultPickDept(moInfo, curStockInfo));
      if (curStockInfo.isIsBackflush())
      {
        ManufactureOrderTechnicsInfo techInfo = MOStockUtil.getOwnedTechnicsInfo(moInfo, curStockInfo);
        
        CSEntrustTypeEnum entrustType = techInfo == null ? CSEntrustTypeEnum.NONE : techInfo.getEntrustType();
        if ((CSEntrustTypeEnum.OPERATIONENTRUST.equals(entrustType)) || (CSEntrustTypeEnum.INNERCOOPERATE.equals(entrustType))) {
          curStockInfo.setIsBackflush(false);
        }
      }
    }
  }
  
  protected IObjectPK _save(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    Boolean release = null;
    release = (Boolean)ctx.get("isPlannedOrderRelease");
    if ((release != null) && (release.booleanValue() == true)) {
      return new ObjectUuidPK(model.getBOSUuid("id"));
    }
    return super._save(ctx, model);
  }
  
  protected boolean _exists(Context ctx, IObjectPK pk)
    throws BOSException, EASBizException
  {
    Boolean release = null;
    release = (Boolean)ctx.get("isPlannedOrderRelease");
    if ((release != null) && (release.booleanValue() == true)) {
      return false;
    }
    return super._exists(ctx, pk);
  }
  
  private void reBuildStockLineSeq(ManufactureOrderInfo moInfo)
  {
    if ((moInfo == null) || (moInfo.getStocks() == null) || (moInfo.getStocks().size() <= 0)) {
      return;
    }
    HashMap lineSeqMap = new HashMap();
    ManufactureOrderStockCollection stocks = moInfo.getStocks();
    for (Iterator curIterator = stocks.iterator(); curIterator.hasNext();)
    {
      ManufactureOrderStockInfo curStockInfo = (ManufactureOrderStockInfo)curIterator.next();
      if (curStockInfo.isIsReplaced()) {
        lineSeqMap.put(curStockInfo.getLineSeq(), curStockInfo.getLineSeq());
      } else {
        curStockInfo.setLineSeq("0");
      }
    }
    int lineSeq = 0;
    int curIdx = 0;
    for (int stockCnt = stocks.size(); curIdx < stockCnt; curIdx++)
    {
      ManufactureOrderStockInfo curStockInfo = stocks.get(curIdx);
      if (!curStockInfo.isIsReplaced())
      {
        lineSeq += 1;
        while (lineSeqMap.containsKey(Integer.toString(lineSeq * 10))) {
          lineSeq += 1;
        }
        curStockInfo.setLineSeq(Integer.toString(lineSeq * 10));
      }
    }
  }
  
  protected void _alert(Context ctx, IObjectValue model)
    throws BOSException, EASBizException
  {
    BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectValue.class }, new Object[] { model });
    
    BatchExecuteParamsEntry[] entries = { entry };
    BatchActionResults result = batchAlert(ctx, entries);
    result.throwExceptions();
  }
  
  public BatchActionResults batchAlert(Context ctx, BatchExecuteParamsEntry[] entries)
    throws EASBizException, BOSException
  {
    return batchExecute(ctx, entries, new BatchActionEnum("ALERT"));
  }
  
  private void doAlert(Context ctx, BatchActionResults results)
    throws EASBizException, BOSException
  {
    IObjectCollection col = results.getObjCollection();
    ManufactureOrderInfo mo = null;
    if ((col != null) && (col.size() > 0)) {
      mo = (ManufactureOrderInfo)col.getObject(0);
    }
    IObjectPK[] pks = results.getToDoPkArray();
    IObjectPK pk = null;
    if ((pks != null) && (pks.length > 0)) {
      pk = pks[0];
    }
    if ((mo == null) || (pk == null)) {
      return;
    }
    BillBaseStatusEnum dbStatus = BillBaseStatusEnum.SUBMITED;
    BigDecimal alterBeforeQty = mo.getQty();
    BigDecimal alterBeforeBaseQty = mo.getBaseQty();
    
    updateStock(mo);
    
    UserInfo auditor = mo.getAuditor();
    Timestamp auditTime = mo.getAuditTime();
    
    ManufactureOrderInfo dbData = getManufactureOrderInfo(ctx, new ObjectUuidPK(mo.getId()));
    dbStatus = dbData.getBaseStatus();
    alterBeforeQty = dbData.getQty();
    alterBeforeBaseQty = dbData.getBaseQty();
    auditor = dbData.getAuditor();
    auditTime = dbData.getAuditTime();
    
    mo.setAuditor(auditor);
    mo.setAuditTime(auditTime);
    mo.setBaseStatus(dbStatus);
    
    IBillType iBillType = BillTypeFactory.getLocalInstance(ctx);
    BillTypeInfo billTypeInfo = iBillType.getBillTypeInfo(new ObjectUuidPK("B2aZSVXaSx6qxdfekgCmrEY+1VI="));
    mo.setBillType(billTypeInfo);
    if (mo.getLot() != null) {
      mo.setLot(mo.getLot().trim());
    }
    String tempTableName = null;
    TempTablePool pool = TempTablePool.getInstance(ctx);
    try
    {
      if (mo.getId() != null)
      {
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append("create table t_tmpstock(fid varchar(44),fstorageorgunitid varchar(44))");
        try
        {
          tempTableName = pool.createTempTable(sqlBuf.toString());
          StringBuffer insertSql = new StringBuffer();
          insertSql.append("insert into ").append(tempTableName).append("(fid,fstorageorgunitid)").append(" select fid,fstorageorgunitid from t_mm_mftorderstock where fparentid = ?");
          
          DbUtil.execute(ctx, insertSql.toString(), new Object[] { mo.getId().toString() });
        }
        catch (Exception e1)
        {
          throw new BOSException(e1);
        }
      }
      innerUpdate(ctx, pk, mo);
      
      afterSubmit(ctx, new String[] { mo.getId().toString() });
      
      LotFacadeFactory.getLocalInstance(ctx).manufactureOrderDeleteLotSource(new String[] { pk.toString() });
      LogControllManager.getInstance().enableLog();
      ServiceStateManager.getInstance().enableNextCallService("LOG_SERVICE");
      IObjectPK logPk = LogUtil.beginLog(ctx, "alter", mo.getBOSType(), pk, mo.getNumber(), "mm_manufactureOrder_alter");
      
      BigDecimal diffQty = alterBeforeQty.subtract(mo.getQty());
      BigDecimal diffBaseQty = alterBeforeBaseQty.subtract(mo.getBaseQty());
      if ((mo.getSourceBillType() != null) && ("510b6503-0105-1000-e000-0113c0a812fd463ED552".equals(mo.getSourceBillType().getId().toString())))
      {
        String srcBillEntryID = mo.getSrcBillEntryID();
        StringBuffer updateSql = new StringBuffer();
        updateSql.append(" UPDATE  t_sd_saleorderentry  ");
        updateSql.append(" SET  ");
        updateSql.append("   FTotalProductQty = FTotalProductQty - ?, ");
        updateSql.append("   FTotalunProductQty = FTotalunProductQty +? , ");
        updateSql.append("   FTotalBaseProductQty = FTotalBaseProductQty -? , ");
        updateSql.append("   FTotalBaseunProductQty = FTotalBaseunProductQty +?   ");
        updateSql.append("WHERE  t_sd_saleorderentry.fid =?");
        
        Object[] params = new Object[5];
        
        params[0] = diffQty;
        params[1] = diffQty;
        params[2] = diffBaseQty;
        params[3] = diffBaseQty;
        params[4] = srcBillEntryID;
        DbUtil.execute(ctx, updateSql.toString(), params);
      }
      else if ((mo.getSourceBillType() != null) && ("B2aZSVXaSx6qxdfekgCmrEY+1VI=".equals(mo.getSourceBillType().getId().toString())))
      {
        String sourceBillId = mo.getSourceBillId();
        StringBuffer updateSql = new StringBuffer();
        updateSql.append(" UPDATE  T_MM_ManufactureOrder  ");
        updateSql.append(" SET  ");
        updateSql.append("   FRepairQty = FRepairQty - ?, ");
        updateSql.append("   FunRepairQty = FunRepairQty +? , ");
        updateSql.append("   FRepairBaseQty = FRepairBaseQty -? , ");
        updateSql.append("   FunRepairBaseQty = FunRepairBaseQty +?   ");
        updateSql.append("WHERE  FID =?");
        
        Object[] params = new Object[5];
        params[0] = diffQty;
        params[1] = diffQty;
        params[2] = diffBaseQty;
        params[3] = diffBaseQty;
        params[4] = sourceBillId;
        DbUtil.execute(ctx, updateSql.toString(), params);
      }
      String moId = mo.getId().toString();
      String[] sqls = new String[4];
      StringBuffer updateSql = new StringBuffer();
      
      updateSql.append("update T_MM_ManufactureOrder as mo set").append(" (FPassQty,FPassBaseQty,FConcessionQty,FConcessionBaseQty,FFinishedQty,FFinishedBaseQty,FActureQty,FActureBaseQty)=").append(" (select isnull(mot.FPassQty,0),isnull(mot.FPassBaseQty,0),isnull(mot.FConcessionQty,0),isnull(mot.FConcessionBaseQty,0)").append(" ,isnull(mot.FPassQty+mot.FConcessionQty,0), isnull(mot.FPassBaseQty+mot.FConcessionBaseQty,0)").append(" ,isnull(mot.FPassQty+mot.FConcessionQty,0), isnull(mot.FPassBaseQty+mot.FConcessionBaseQty,0)").append(" from T_MM_MFTOrderTechnics mot where mot.FParentID=mo.FID and mot.FOperationNo=mo.FLastOperNo").append(" and mo.FID='").append(moId).append("')").append(" where mo.FID='").append(moId).append("'");
      
      sqls[0] = updateSql.toString();
      
      updateSql.setLength(0);
      updateSql.append("update T_MM_ManufactureOrder as mo set").append(" (FFinishedQty,FFinishedBaseQty,FActureQty,FActureBaseQty)=").append(" (select (case when ttype.FFinishedQty=10 then mo.FFinishedQty+mo.FScrapQty else mo.FFinishedQty end),").append(" (case when ttype.FFinishedQty=10 then mo.FFinishedBaseQty+mo.FScrapBaseQty else mo.FFinishedBaseQty end),").append(" mo.FActureQty+mo.FScrapQty, mo.FActureBaseQty+mo.FScrapBaseQty").append(" from T_MM_ProductTransactionType ttype where ttype.fid = mo.FTransactionTypeID").append(" and mo.FID='").append(moId).append("')").append(" where mo.FID='").append(moId).append("'");
      
      sqls[1] = updateSql.toString();
      
      updateSql.setLength(0);
      updateSql.append("delete from T_MM_CompletionRes where FParentID in (").append(" select rep.FID from T_MM_CompletionReport rep").append(" inner join T_MM_MFTOrderTechnics mot on mot.fid = rep.FProcessID ").append(" inner join T_MM_ManufactureOrder mo on mot.FParentID=mo.FID and mot.FOperationNo<>mo.FLastOperNo").append(" where rep.FSourceBillType1='10' and mo.FID='").append(moId).append("'").append(" )");
      
      sqls[2] = updateSql.toString();
      
      updateSql.setLength(0);
      updateSql.append("delete from T_MM_CompletionRes where FParentID in (").append(" select rep.FID from T_MM_CompletionReport rep").append(" inner join T_MM_DisTaskDispatchEntry dise on rep.FDispWorkProcessID = dise.FID").append(" inner join T_MM_MFTOrderTechnics mot on dise.FSourceBillEntryID = mot.FID ").append(" inner join T_MM_ManufactureOrder mo on mot.FParentID=mo.FID and mot.FOperationNo<>mo.FLastOperNo").append(" where rep.FSourceBillType1='20' and mo.FID='").append(moId).append("'").append(" )");
      
      sqls[3] = updateSql.toString();
      SQLUtil.batchExecuteSql(ctx, sqls);
      
      afterAudit(ctx, results);
      try
      {
        updateReqPlanData(ctx, results.getToDoIdsList(), 701, tempTableName);
      }
      catch (Exception e)
      {
        throw new BOSException(e);
      }
      LogUtil.afterLog(ctx, logPk);
      
      MOFinish.dealWithMOFinish(ctx, pk);
      
      String[] idStrArray = new String[1];
      idStrArray[0] = mo.getId().toString();
      CalculateWipUtil.updateWipForMoOrders(ctx, idStrArray);
    }
    finally
    {
      if (tempTableName != null) {
        pool.releaseTable(tempTableName);
      }
    }
  }
  
  private ManufactureOrderCollection getMMCollectionByIdSet(Context ctx, Set set)
    throws BOSException
  {
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filter = new FilterInfo();
    filter.getFilterItems().add(new FilterItemInfo("id", set, CompareType.INCLUDE));
    viewInfo.setFilter(filter);
    
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("*"));
    sic.add(new SelectorItemInfo("transactionType.*"));
    sic.add(new SelectorItemInfo("routing.*"));
    sic.add(new SelectorItemInfo("stocks.*"));
    sic.add(new SelectorItemInfo("expectOutputs.*"));
    sic.add(new SelectorItemInfo("technics.*"));
    viewInfo.setSelector(sic);
    ManufactureOrderCollection col = ManufactureOrderFactory.getLocalInstance(ctx).getManufactureOrderCollection(viewInfo);
    
    return col;
  }
  
  private boolean isFromListUI(Context ctx)
  {
    Object paramObj = ctx.get("isFromList");
    boolean isFromList = false;
    if (paramObj == null) {
      return isFromList;
    }
    Boolean paramBoolean = Boolean.valueOf(paramObj.toString());
    if (paramBoolean.booleanValue()) {
      isFromList = true;
    }
    return isFromList;
  }
  
  public IMMVerifyManager getVerifyManager(Context ctx, String verifyManagerName, Map paramMap, BatchActionResults batchResults)
    throws BOSException, EASBizException
  {
    return new MMVerifyManager(ctx, getVerifyXmlFile(), verifyManagerName, paramMap, batchResults);
  }
  
  public String getVerifyXmlFile()
  {
    return "com.kingdee.eas.mm.mo.app.verify.ManufactureOrderVerify";
  }
  
  private ManufactureOrderStockCollection getDistinctStocks(ManufactureOrderStockCollection stocks)
  {
    ManufactureOrderStockCollection newStocks = new ManufactureOrderStockCollection();
    Map stocksMap = new HashMap();
    ManufactureOrderStockInfo stockInfo = null;
    String key = null;
    for (Iterator iter = stocks.iterator(); iter.hasNext();)
    {
      stockInfo = (ManufactureOrderStockInfo)iter.next();
      key = getRecKeyString(stockInfo);
      if (stocksMap.containsKey(key))
      {
        ManufactureOrderStockInfo existStockInfo = (ManufactureOrderStockInfo)stocksMap.get(key);
        existStockInfo.setUnitBaseQty(existStockInfo.getUnitBaseQty().add(stockInfo.getUnitBaseQty()));
        existStockInfo.setUnitQty(existStockInfo.getUnitQty().add(stockInfo.getUnitQty()));
        existStockInfo.setBaseQty(existStockInfo.getBaseQty().add(stockInfo.getBaseQty()));
        existStockInfo.setQty(existStockInfo.getQty().add(stockInfo.getQty()));
        existStockInfo.setPlannedBaseQty(existStockInfo.getPlannedBaseQty().add(stockInfo.getPlannedBaseQty()));
        existStockInfo.setPlannedQty(existStockInfo.getPlannedQty().add(stockInfo.getPlannedQty()));
        existStockInfo.setLossBaseQty(existStockInfo.getLossBaseQty().add(stockInfo.getLossBaseQty()));
        existStockInfo.setLossQty(existStockInfo.getLossQty().add(stockInfo.getLossQty()));
        existStockInfo.setPickExtraBaseQty(existStockInfo.getPickExtraBaseQty().add(stockInfo.getPickExtraBaseQty()));
        existStockInfo.setPickExtraQty(existStockInfo.getPickExtraQty().add(stockInfo.getPickExtraQty()));
        existStockInfo.setPickLackBaseQty(existStockInfo.getPickLackBaseQty().add(stockInfo.getPickLackBaseQty()));
        existStockInfo.setPickLackQty(existStockInfo.getPickLackQty().add(stockInfo.getPickLackQty()));
      }
      else
      {
        stocksMap.put(key, stockInfo);
      }
    }
    Iterator iter = stocksMap.keySet().iterator();
    while (iter.hasNext())
    {
      key = (String)iter.next();
      newStocks.add((ManufactureOrderStockInfo)stocksMap.get(key));
    }
    return newStocks;
  }
  
  private StorageOrgUnitInfo getOrgUnitInfo(Context ctx, String orgUnitId, Map orgUnitMap, SelectorItemCollection sic)
    throws EASBizException, BOSException
  {
    if (StringUtil.isEmpty(orgUnitId)) {
      return null;
    }
    if (orgUnitMap.containsKey(orgUnitId)) {
      return (StorageOrgUnitInfo)orgUnitMap.get(orgUnitId);
    }
    if (sic == null) {
      sic = getDefaultSelector();
    }
    StorageOrgUnitInfo orgUnitInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectStringPK(orgUnitId), sic);
    
    orgUnitMap.put(orgUnitId, orgUnitInfo);
    return orgUnitInfo;
  }
  
  private WarehouseInfo getWarehouseInfo(Context ctx, String id, Map infoMap, SelectorItemCollection sic)
    throws EASBizException, BOSException
  {
    if (StringUtil.isEmpty(id)) {
      return null;
    }
    if (infoMap.containsKey(id)) {
      return (WarehouseInfo)infoMap.get(id);
    }
    if (sic == null) {
      sic = getDefaultSelector();
    }
    WarehouseInfo warehouseInfo = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectStringPK(id), sic);
    
    infoMap.put(id, warehouseInfo);
    return warehouseInfo;
  }
  
  private CompanyOrgUnitInfo getCompanyInfo(Context ctx, String storageId, Map storage2CompanyMap)
    throws EASBizException, BOSException
  {
    if (StringUtil.isEmpty(storageId)) {
      return null;
    }
    if (storage2CompanyMap.containsKey(storageId)) {
      return (CompanyOrgUnitInfo)storage2CompanyMap.get(storageId);
    }
    IOrgUnitRelation iUnitRel = OrgUnitRelationFactory.getLocalInstance(ctx);
    
    OrgUnitCollection companyOrgCol = iUnitRel.getToUnit(storageId, 4, 1);
    CompanyOrgUnitInfo companyOrgUnit = (CompanyOrgUnitInfo)companyOrgCol.get(0);
    
    storage2CompanyMap.put(storageId, companyOrgUnit);
    return companyOrgUnit;
  }
  
  private SelectorItemCollection getDefaultSelector()
  {
    SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("id"));
    sic.add(new SelectorItemInfo("number"));
    sic.add(new SelectorItemInfo("name"));
    return sic;
  }
  
  private void dealLotNumber(Context ctx, BatchActionResults batchResults)
    throws EASBizException, BOSException
  {
    IObjectPK[] pks = batchResults.getToDoPkArray();
    if ((pks == null) || (pks.length < 1)) {
      return;
    }
    IObjectCollection col = batchResults.getObjCollection();
    ManufactureOrderInfo moInfo = null;
    SelectorItemCollection sel = new SelectorItemCollection();
    sel.add(new SelectorItemInfo("lot"));
    int i = 0;
    for (int size = col.size(); i < size; i++)
    {
      moInfo = (ManufactureOrderInfo)col.getObject(i);
      if ((moInfo != null) && (StringUtils.isEmpty(moInfo.getLot())))
      {
        lotNumberCheck(ctx, moInfo);
        if (!StringUtils.isEmpty(moInfo.getLot())) {
          innerUpdatePartial(ctx, moInfo, sel);
        }
      }
    }
  }
  
  private boolean ifHaveDestBills(Context ctx, String billIdString, Set excludedDestEntity)
    throws BOSException
  {
    boolean rtn = false;
    StringBuffer selectSql = new StringBuffer();
    
    String excludedDest = "'null'";
    if ((excludedDestEntity != null) && (excludedDestEntity.size() > 0)) {
      excludedDest = SQLUtil.setToString(excludedDestEntity);
    }
    selectSql.append("select distinct FSrcObjectID from t_bot_Relation").append(" where (FSrcObjectID = '").append(billIdString).append("'").append(" or FSrcObjectID in").append(" (select FDestObjectID from t_bot_Relation where FSrcObjectID = '").append(billIdString).append("'").append(" and FDestEntityID in (").append(excludedDest).append(")))").append(" and FDestEntityID not in (").append(excludedDest).append(")");
    
    IRowSet rs = DbUtil.executeQuery(ctx, selectSql.toString());
    try
    {
      if ((rs != null) && (rs.next())) {
        rtn = true;
      }
    }
    catch (SQLException e)
    {
      throw new SQLDataException(e);
    }
    return rtn;
  }

@Override
protected boolean _chkSrcMoClosed(Context arg0) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	return false;
}

@Override
protected Map _manufactureOrderClosedCheck(Context arg0, BatchActionResults arg1)
		throws BOSException, EASBizException {
	// TODO Auto-generated method stub
	return null;
}

@Override
protected BatchActionResults _materialLoopBackFlush(Context arg0, String arg1,
		BillTypeInfo arg2) throws BOSException, EASBizException {
	// TODO Auto-generated method stub
	return null;
}

@Override
protected void _setCloseTime(Context arg0, BatchActionResults arg1)
		throws BOSException, EASBizException {
	// TODO Auto-generated method stub
	
}

@Override
protected BatchExecuteResult _materialBackFlush(Context arg0, String[] arg1,
		BillTypeInfo arg2) throws BOSException, EASBizException {
	// TODO Auto-generated method stub
	return null;
}
}
