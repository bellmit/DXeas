/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
/*      */ package com.kingdee.eas.mm.basedata.app;
/*      */ 
/*      */ import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.SQLDataException;
import com.kingdee.bos.ctrl.common.util.StringUtil;
import com.kingdee.bos.dao.DataLimitExceedException;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.db.TempTablePool;
import com.kingdee.bos.framework.batch.BatchExecuteParamsEntry;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.codingrule.RuleStatus;
import com.kingdee.eas.base.param.IParamControl;
import com.kingdee.eas.base.param.ParamControlFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.IsolatedRuleEnum;
import com.kingdee.eas.basedata.master.material.MaterialAttributeEnum;
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
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitCollection;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.ReplaceModeEnum;
import com.kingdee.eas.basedata.master.material.UsedStatusEnum;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.IBillType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.app.dao.ReferenceDAO;
import com.kingdee.eas.dynbusiness.IBatchExecute;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.batchaction.BatchActionEnum;
import com.kingdee.eas.framework.batchaction.BatchActionResults;
import com.kingdee.eas.mm.basedata.BOMFacadeFactory;
import com.kingdee.eas.mm.basedata.BOMPTCollection;
import com.kingdee.eas.mm.basedata.BOMTypeEnum;
import com.kingdee.eas.mm.basedata.BOMUsageEnum;
import com.kingdee.eas.mm.basedata.BomAgent;
import com.kingdee.eas.mm.basedata.BomCollection;
import com.kingdee.eas.mm.basedata.BomEntryCollection;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomException;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.BomSubstituteCollection;
import com.kingdee.eas.mm.basedata.BomSubstituteInfo;
import com.kingdee.eas.mm.basedata.ConsumeTypeEnum;
import com.kingdee.eas.mm.basedata.ManufactureStrategyGroup;
import com.kingdee.eas.mm.basedata.OrderBOMPTCollection;
import com.kingdee.eas.mm.basedata.OrderBOMPTInfo;
import com.kingdee.eas.mm.basedata.TrackNumberInfo;
import com.kingdee.eas.mm.common.app.SQLUtils;
import com.kingdee.eas.mm.common.util.MMConstant;
import com.kingdee.eas.mm.common.util.MMUtils;
import com.kingdee.eas.mm.common.util.ResourceUtils;
import com.kingdee.eas.mm.common.util.SQLUtil;
import com.kingdee.eas.mm.planning.PlanOrderException;
import com.kingdee.eas.mm.planning.SOPException;
import com.kingdee.eas.mm.project.ProjectInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillParam;
import com.kingdee.eas.scm.common.SCMBillException;
import com.kingdee.eas.scm.common.SCMBillParamFactory;
import com.kingdee.eas.scm.common.util.SCMUtils;
import com.kingdee.eas.util.BizReference;
import com.kingdee.eas.util.ResourceBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.UuidException;
/*      */ 
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ public class BomControllerBean extends AbstractBomControllerBean
/*      */   implements IBatchExecute
/*      */ {
/*      */   private static final long serialVersionUID = -4242154398906702311L;
/*  153 */   private static Logger logger = Logger.getLogger("com.kingdee.eas.mm.basedata.app.BomControllerBean");
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getXmlFileName(BatchActionEnum batchActionEnum)
/*      */   {
/*  186 */     return "com.kingdee.eas.mm.basedata.app.bizprocess.xml.bomprocessconfig.xml";
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected IObjectPK _save(Context ctx, IObjectValue model)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  196 */     BomInfo bomInfo = (BomInfo)model;
/*  197 */     if (!(isAddNew(ctx, bomInfo))) {
/*  198 */       checkSave(ctx, bomInfo);
/*      */     }
/*  200 */     IObjectPK pk = null;
/*      */     try
/*      */     {
/*  203 */       deleteBomPt(ctx, bomInfo);
/*  204 */       pk = super._save(ctx, bomInfo);
/*      */     }
/*      */     catch (BOSException e)
/*      */     {
/*  208 */       if (e.getCause() instanceof DataLimitExceedException) {
/*  209 */         throw new SOPException(BomException.VALUE_TOO_LARGE, new String[] { getFieldName(ctx, bomInfo) });
/*      */       }
/*      */ 
/*  212 */       throw e;
/*      */     }
/*      */ 
/*  215 */     return pk;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getFieldName(Context ctx, BomInfo info)
/*      */   {
/*  227 */     String fieldName = "";
/*      */ 
/*  229 */     if ((isTooBig(info.getProductQty())) || (isTooBig(info.getProductBaseQty())))
/*      */     {
/*  231 */       return getResource(ctx, "productQty");
/*      */     }
/*  233 */     BomEntryCollection entry = info.getEntrys();
/*  234 */     if ((entry == null) || (entry.size() == 0)) {
/*  235 */       return null;
/*      */     }
/*  237 */     BomEntryInfo entryInfo = null;
/*  238 */     String line = "";
/*  239 */     for (int i = 0; i < entry.size(); ++i) {
/*  240 */       entryInfo = entry.get(i);
/*  241 */       line = String.valueOf(i + 1);
/*      */ 
/*  243 */       if ((isTooBig(entryInfo.getProportion())) || (isTooBig(entryInfo.getBaseProportion())))
/*      */       {
/*  245 */         return getMessage(ctx, "entry_proportion", new String[] { line });
/*      */       }
/*      */ 
/*  248 */       if ((isTooBig(entryInfo.getConsumeFixQty())) || (isTooBig(entryInfo.getConsumeFixBaseQty())))
/*      */       {
/*  250 */         return getMessage(ctx, "entry_consumeFixQty", new String[] { line });
/*      */       }
/*      */ 
/*  253 */       if (isTooBig(entryInfo.getNetWeight())) {
/*  254 */         return getMessage(ctx, "entry_netWeight", new String[] { line });
/*      */       }
/*      */     }
/*  257 */     return fieldName;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean isTooBig(BigDecimal val)
/*      */   {
/*  269 */     BigDecimal bd = new BigDecimal("1.0E14");
/*  270 */     if (val == null) {
/*  271 */       return false;
/*      */     }
/*      */ 
/*  274 */     return (bd.compareTo(val) <= 0);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected IObjectValue _createNewData(Context ctx, boolean isUseAgent)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  289 */     BomInfo billInfo = null;
/*  290 */     if (isUseAgent)
/*  291 */       billInfo = BomAgent.create();
/*      */     else {
/*  293 */       billInfo = new BomInfo();
/*      */     }
/*      */ 
/*  296 */     Calendar cal = Calendar.getInstance();
/*  297 */     Date curDate = cal.getTime();
/*  298 */     billInfo.setBizDate(curDate);
/*  299 */     billInfo.setCreateTime(new Timestamp(cal.getTimeInMillis()));
/*      */
/*      */ 
/*  302 */     BomEntryInfo entry = new BomEntryInfo();
/*      */ 
/*  304 */     Calendar effectiveDate = Calendar.getInstance();
/*      */
/*      */ 
/*  307 */     effectiveDate.set(1900, 0, 1);
/*  308 */     effectiveDate.set(11, 0);
/*  309 */     effectiveDate.set(12, 0);
/*  310 */     effectiveDate.set(13, 0);
/*  311 */     effectiveDate.set(14, 0);
/*      */
/*      */ 
/*  314 */     Calendar disableDate = Calendar.getInstance();
/*  315 */     disableDate.set(2099, 11, 31);
/*  316 */     disableDate.set(11, 0);
/*  317 */     disableDate.set(12, 0);
/*  318 */     disableDate.set(13, 0);
/*  319 */     disableDate.set(14, 0);
/*  320 */     entry.setEffectiveDate(effectiveDate.getTime());
/*  321 */     entry.setDisableDate(disableDate.getTime());
/*  322 */     entry.setConsumeType(ConsumeTypeEnum.VariableAmount);
/*  323 */     billInfo.getEntrys().add(entry);
/*      */ 
/*  325 */     IBillType iBillType = BillTypeFactory.getLocalInstance(ctx);
/*  326 */     BillTypeInfo billTypeInfo = iBillType.getBillTypeInfo(new ObjectUuidPK("JeCqeo42zUqaIctYbVWT+UY+1VI="));
/*  327 */     billInfo.setBillType(billTypeInfo);
/*      */ 
/*  329 */     return billInfo;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected void _update(Context ctx, IObjectPK pk, IObjectValue model)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  343 */     BomInfo info = (BomInfo)model;
/*      */
/*      */ 
/*  346 */     deleteBomPt(ctx, info);
/*      */ 
/*  348 */     beforeSaveBom(ctx, model);
/*      */ 
/*  350 */     super._update(ctx, pk, model);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected IObjectPK _addnew(Context ctx, IObjectValue model)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  362 */     beforeSaveBom(ctx, model);
/*      */ 
/*  364 */     IObjectPK objectPK = super._addnew(ctx, model);
/*      */
/*      */
/*      */ 
/*  368 */     return objectPK;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected IObjectPK _submit(Context ctx, IObjectValue model)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  382 */     boolean isFromList = isFromListUI(ctx);
/*      */
/*      */ 
/*  385 */     if (isFromList)
/*      */
/*      */     {
/*  388 */       String id = ((BomInfo)model).getId().toString();
/*      */ 
/*  390 */       return new ObjectUuidPK(id);
/*      */     }
/*      */ 
/*  393 */     deleteBomPt(ctx, (BomInfo)model);
/*  394 */     IObjectPK pk = super._submit(ctx, model);
/*      */
/*      */ 
/*  397 */     BomInfo bom = (BomInfo)model;
/*  398 */     String storageUnitId = bom.getStorageOrgUnit().getId().toString();
/*  399 */     boolean isAutoAudit = isAutoAudit(ctx, storageUnitId);
/*  400 */     if (isAutoAudit)
/*      */     {
/*  402 */       String permissionName = "mm_bom_audit";
/*  403 */       String userId = ctx.getCaller().toString();
/*  404 */       MMUtils.checkPermission(ctx, userId, storageUnitId, permissionName);
/*      */ 
/*  406 */       BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
/*  407 */       entry.add(pk);
/*  408 */       BatchExecuteParamsEntry[] entrys = { entry };
/*  409 */       _batchAudit(ctx, entrys);
/*      */     }
/*  411 */     return pk;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean isAutoAudit(Context ctx, String orgUnitID)
/*      */   {
/*  425 */     boolean isAutoAudit = false;
/*  426 */     ISCMBillParam scmParam = null;
/*      */     try {
/*  428 */       scmParam = SCMBillParamFactory.getLocalInstance(ctx);
/*  429 */       String billTypeId = "JeCqeo42zUqaIctYbVWT+UY+1VI=";
/*  430 */       String strAutoAudit = scmParam.getParamByBillTypeID("SCM_Submit_01", 4, orgUnitID, billTypeId);
/*      */
/*      */
/*      */ 
/*  434 */       if ((MMUtils.isNotEmptyString(strAutoAudit)) && (strAutoAudit.trim().toLowerCase().equals("1")))
/*  435 */         isAutoAudit = true;
/*      */     }
/*      */     catch (BOSException e) {
/*  438 */       logger.error("error in isAutoAudit: ", e);
/*      */     } catch (EASBizException e) {
/*  440 */       logger.error("error in isAutoAudit: ", e);
/*      */     }
/*      */ 
/*  443 */     return isAutoAudit;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected Map _getBizParam(Context ctx, IObjectValue editData)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  456 */     BomInfo bomInfo = (BomInfo)editData;
/*  457 */     if (bomInfo == null) {
/*  458 */       return null;
/*      */     }
/*  460 */     HashMap map = new HashMap();
/*      */ 
/*  462 */     putMaterialPrecision(ctx, map, bomInfo);
/*      */
/*      */ 
/*  465 */     map.put("CURRENT_DATE", new Date());
/*      */     try
/*      */     {
/*  468 */       BOMTypeEnum bomType = bomInfo.getBomType();
/*      */ 
/*  470 */       if (BOMTypeEnum.CfgBOM.equals(bomType)) {
/*  471 */         putCfgBomPt(ctx, map, bomInfo);
/*      */ 
/*  473 */         String storageOrgId = bomInfo.getStorageOrgUnit().getId().toString();
/*      */ 
/*  475 */         String paramName = "ConfigBOM_Autosynchronous_SaleBOM";
/*  476 */         Boolean paramValue = getParamValue(ctx, storageOrgId, paramName);
/*  477 */         map.put("CONFIGBOM_SALEBOM", paramValue);
/*      */
/*      */ 
/*  480 */         map.put("CFGBOM_CREATE_ORDERBOM", hasOrderBomFormCfgBom(ctx, bomInfo.getId().toString()));
/*      */
/*      */       }
/*  483 */       else if (BOMTypeEnum.OrderBOM.equals(bomType)) {
/*  484 */         putOrderBomPt(ctx, map, bomInfo);
/*      */       }
/*      */     }
/*      */     catch (UuidException e) {
/*  488 */       throw new BOSException(e);
/*      */     } catch (SQLException e) {
/*  490 */       throw new SQLDataException(e);
/*      */     }
/*      */ 
/*  493 */     return map;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void putMaterialPrecision(Context ctx, Map paramMap, BomInfo bomInfo)
/*      */     throws BOSException
/*      */   {
/*  506 */     Set idSet = new HashSet();
/*  507 */     if (null != bomInfo.getUnit()) {
/*  508 */       idSet.add(bomInfo.getUnit().getId().toString());
/*      */     }
/*  510 */     if (null != bomInfo.getBaseUnit()) {
/*  511 */       idSet.add(bomInfo.getBaseUnit().getId().toString());
/*      */     }
/*  513 */     if (idSet.size() == 0) {
/*  514 */       return;
/*      */     }
/*  516 */     EntityViewInfo viewInfo = new EntityViewInfo();
/*  517 */     SelectorItemCollection sic = new SelectorItemCollection();
/*  518 */     sic.add(new SelectorItemInfo("measureUnit.id"));
/*  519 */     sic.add(new SelectorItemInfo("qtyPrecision"));
/*  520 */     FilterInfo filterInfo = new FilterInfo();
/*  521 */     filterInfo.getFilterItems().add(new FilterItemInfo("measureUnit.id", idSet, CompareType.INCLUDE));
/*  522 */     String materialId = bomInfo.getMaterial().getId().toString();
/*  523 */     filterInfo.getFilterItems().add(new FilterItemInfo("material.id", materialId, CompareType.EQUALS));
/*  524 */     viewInfo.setFilter(filterInfo);
/*  525 */     viewInfo.setSelector(sic);
/*  526 */     IMultiMeasureUnit imultiUnit = MultiMeasureUnitFactory.getLocalInstance(ctx);
/*  527 */     MultiMeasureUnitCollection mmuc = imultiUnit.getMultiMeasureUnitCollection(viewInfo);
/*  528 */     paramMap.put("MULTIUNIT", mmuc);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void putOrderBomPt(Context ctx, Map paramMap, BomInfo bomInfo)
/*      */     throws UuidException, SQLException, BOSException
/*      */   {
/*  545 */     String id = bomInfo.getId().toString();
/*  546 */     StringBuffer sb = new StringBuffer();
/*  547 */     Locale locale = ctx.getLocale();
/*  548 */     sb.append(" SELECT o.fprojectid projedctId");
/*  549 */     sb.append("       ,p.fnumber projedctNumber");
/*  550 */     sb.append("       ,p.fname_").append(locale).append(" projedctName");
/*  551 */     sb.append("  \t  ,o.ftrackid trackId");
/*  552 */     sb.append("  \t  ,t.fnumber trackNumber ");
/*  553 */     sb.append(" FROM  ");
/*  554 */     sb.append(" \t  t_mm_orderbompt o ");
/*  555 */     sb.append(" \t  LEFT JOIN t_mm_tracknumber t ON t.fid = o.ftrackid ");
/*  556 */     sb.append(" \t  LEFT JOIN t_mm_project p ON p.fid = o.fprojectId ");
/*  557 */     sb.append(" WHERE o.forderid = ? ");
/*  558 */     IRowSet rs = SQLUtils.executeQuery(ctx, sb.toString(), new Object[] { id });
/*  559 */     if ((rs == null) || (rs.size() == 0)) {
/*  560 */       return;
/*      */     }
/*  562 */     TrackNumberInfo tni = null;
/*  563 */     ProjectInfo pi = null;
/*  564 */     String trackId = null;
/*  565 */     String projId = null;
/*  566 */     List trackList = null;
/*  567 */     while (rs.next()) {
/*  568 */       if (MMUtils.isEmptyString(projId)) {
/*  569 */         projId = rs.getString("projedctId");
/*  570 */         if (MMUtils.isNotEmptyString(projId)) {
/*  571 */           pi = new ProjectInfo();
/*  572 */           pi.setId(BOSUuid.read(projId));
/*  573 */           pi.setNumber(rs.getString("projedctNumber"));
/*  574 */           pi.setName(rs.getString("projedctName"));
/*  575 */           paramMap.put("ORDERBOMPT_PROJECT", pi);
/*      */         }
/*      */       }
/*  578 */       trackId = rs.getString("trackId");
/*  579 */       if (MMUtils.isNotEmptyString(trackId));
/*  580 */       if (trackList == null) {
/*  581 */         trackList = new ArrayList();
/*      */       }
/*  583 */       tni = new TrackNumberInfo();
/*  584 */       tni.setId(BOSUuid.read(trackId));
/*  585 */       tni.setNumber(rs.getString("trackNumber"));
/*  586 */       trackList.add(tni);
/*      */     }
/*      */ 
/*  589 */     paramMap.put("ORDERBOMPT_TRACK", trackList);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void putCfgBomPt(Context ctx, Map paramMap, BomInfo bomInfo)
/*      */     throws BOSException, UuidException, SQLException
/*      */   {
/*  608 */     String id = bomInfo.getId().toString();
/*  609 */     StringBuffer sb = new StringBuffer();
/*  610 */     sb.append(" SELECT pt.fbomentryId bomentryId");
/*  611 */     sb.append("  \t  ,pt.ftrackid trackId ");
/*  612 */     sb.append("  \t  ,t.fnumber trackNumber ");
/*  613 */     sb.append(" FROM  ");
/*  614 */     sb.append(" \t  T_MM_BOMPT pt ");
/*  615 */     sb.append(" \t  LEFT JOIN t_mm_tracknumber t ON t.fid = pt.ftrackid ");
/*  616 */     sb.append(" \t  INNER JOIN t_mm_bomentry e ON e.fid = pt.fbomentryid ");
/*  617 */     sb.append(" WHERE e.fparentid = ? ");
/*  618 */     sb.append(" order by pt.fbomentryId ");
/*  619 */     IRowSet rs = SQLUtils.executeQuery(ctx, sb.toString(), new Object[] { id });
/*  620 */     if ((rs == null) || (rs.size() == 0)) {
/*  621 */       return;
/*      */     }
/*  623 */     TrackNumberInfo tni = null;
/*  624 */     String trackId = null;
/*      */ 
/*  626 */     Map entryIdTrackMap = new HashMap();
/*  627 */     List trackList = null;
/*  628 */     String entryId = null;
/*  629 */     while (rs.next()) {
/*  630 */       entryId = rs.getString("bomentryId");
/*  631 */       if (entryIdTrackMap.containsKey(entryId)) {
/*  632 */         trackList = (List)entryIdTrackMap.get(entryId);
/*      */       }
/*      */       else {
/*  635 */         trackList = new ArrayList();
/*      */       }
/*  637 */       trackId = rs.getString("trackId");
/*  638 */       tni = new TrackNumberInfo();
/*  639 */       tni.setId(BOSUuid.read(trackId));
/*  640 */       tni.setNumber(rs.getString("trackNumber"));
/*  641 */       trackList.add(tni);
/*  642 */       entryIdTrackMap.put(entryId, trackList);
/*      */     }
/*  644 */     paramMap.put("CFGBOMPT_TRACK", entryIdTrackMap);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected String _getLogInfo(Context ctx, IObjectPK pk)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  655 */     CoreBillBaseInfo info = (CoreBillBaseInfo)super._getValue(ctx, pk);
/*  656 */     return info.getLogInfo();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected boolean _getConfigBOMAutoSynchSaleBOMParam(Context ctx, String storageOrgId)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  666 */     String paramName = "ConfigBOM_Autosynchronous_SaleBOM";
/*  667 */     Boolean rst = getParamValue(ctx, storageOrgId, paramName);
/*  668 */     return rst.booleanValue();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected boolean _getConfigBOMAutoSynchSendSaleBOMParam(Context ctx, String storageOrgId)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  680 */     String paramName = "ConfigBOM_Autosynchronous_Send_SaleBOM";
/*  681 */     Boolean rst = getParamValue(ctx, storageOrgId, paramName);
/*  682 */     return rst.booleanValue();
/*      */   }
/*      */
/*      */   private Boolean getParamValue(Context ctx, String storageOrgId, String paramName) throws BOSException, EASBizException {
/*  686 */     IParamControl iParamControl = ParamControlFactory.getLocalInstance(ctx);
/*  687 */     IObjectPK orgPK = new ObjectUuidPK(storageOrgId);
/*  688 */     String paramValue = iParamControl.getParamValue(orgPK, paramName);
/*  689 */     if (StringUtil.isEmptyString(paramValue)) {
/*  690 */       return Boolean.FALSE;
/*      */     }
/*  692 */     return Boolean.valueOf(paramValue);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected Map _getCfgBomTracks(Context ctx, Set bomIdSet)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  704 */     Map rst = new HashMap();
/*  705 */     IRowSet rs = null;
/*  706 */     Locale locale = ctx.getLocale();
/*  707 */     StringBuffer sb = new StringBuffer();
/*  708 */     sb.append(" SELECT ");
/*  709 */     sb.append(" \t  b.fid bomId,b.fprojectid projectId,p.fnumber projectNumber, ");
/*  710 */     sb.append(" \t  p.fname_").append(locale).append(" projectName, ");
/*  711 */     sb.append(" \t  e.fid entryId,t.fid trackId,t.fnumber trackNumber ");
/*  712 */     sb.append(" FROM ");
/*  713 */     sb.append(" \t t_mm_bom b ");
/*  714 */     sb.append(" \t LEFT JOIN t_mm_bomentry e ON b.fid = e.fparentid ");
/*  715 */     sb.append(" \t LEFT JOIN t_mm_project p ON b.fprojectid = p.fid ");
/*  716 */     sb.append(" \t LEFT  JOIN T_MM_BOMPT PT ON e.fid = PT.Fbomentryid ");
/*  717 */     sb.append(" \t LEFT JOIN t_mm_tracknumber t ON PT.FTRACKID = T.Fid ");
/*  718 */     sb.append(" WHERE ");
/*  719 */     sb.append(" \t b.fbomtype = ").append(50);
/*  720 */     sb.append(" \t and b.fid in ( ").append(SQLUtil.arrayToString(bomIdSet.toArray())).append(") ");
/*      */ 
/*  722 */     rs = DbUtil.executeQuery(ctx, sb.toString());
/*      */     try
/*      */     {
/*  725 */       String bomId = null;
/*  726 */       String projectId = null;
/*  727 */       String trackId = null;
/*  728 */       String entryId = null;
/*  729 */       ProjectInfo pjInfo = null;
/*  730 */       TrackNumberInfo tni = null;
/*  731 */       List trackList = null;
/*  732 */       while (rs.next()) {
/*  733 */         bomId = rs.getString("bomId");
/*  734 */         projectId = rs.getString("projectId");
/*      */ 
/*  736 */         if ((!(rst.containsKey(bomId))) && 
/*  737 */           (MMUtils.isNotEmptyString(projectId))) {
/*  738 */           pjInfo = new ProjectInfo();
/*  739 */           pjInfo.setId(BOSUuid.read(projectId));
/*  740 */           pjInfo.setNumber(rs.getString("projectNumber"));
/*  741 */           pjInfo.setName(rs.getString("projectName"));
/*      */ 
/*  743 */           rst.put(bomId, pjInfo);
/*      */         }
/*      */ 
/*  746 */         trackId = rs.getString("trackId");
/*  747 */         if (MMUtils.isEmptyString(trackId)) {
/*      */           continue;
/*      */         }
/*  750 */         entryId = rs.getString("entryId");
/*  751 */         if (rst.containsKey(entryId)) {
/*  752 */           trackList = (List)rst.get(entryId);
/*      */         }
/*      */         else {
/*  755 */           trackList = new ArrayList();
/*      */         }
/*  757 */         tni = new TrackNumberInfo();
/*  758 */         tni.setId(BOSUuid.read(trackId));
/*  759 */         tni.setNumber(rs.getString("trackNumber"));
/*  760 */         trackList.add(tni);
/*      */ 
/*  762 */         rst.put(entryId, trackList);
/*      */       }
/*      */     } catch (SQLException e) {
/*  765 */       throw new SQLDataException(e);
/*      */     }
/*      */ 
/*  768 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected Map _getOrderBomTracks(Context ctx, Set bomIdSet)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  778 */     Map rst = new HashMap();
/*  779 */     IRowSet rs = null;
/*  780 */     Locale locale = ctx.getLocale();
/*  781 */     StringBuffer sb = new StringBuffer();
/*  782 */     sb.append(" SELECT");
/*  783 */     sb.append(" \t  b.fid bomId,p.fid projectId,p.fnumber projectNumber, ");
/*  784 */     sb.append(" \t  p.fname_").append(locale).append(" projectName, ");
/*  785 */     sb.append(" \t  t.fid trackId,t.fnumber trackNumber ");
/*  786 */     sb.append(" FROM ");
/*  787 */     sb.append("      T_MM_BOM B ");
/*  788 */     sb.append(" \t LEFT  JOIN T_MM_orderBOMPT PT ON pt.forderid = b.fid ");
/*  789 */     sb.append(" \t LEFT  JOIN T_MM_PROJECT P ON PT.Fprojectid = P.FID ");
/*  790 */     sb.append(" \t LEFT  JOIN T_MM_TRACKNUMBER T ON PT.Ftrackid = T.Fid ");
/*  791 */     sb.append(" WHERE ");
/*  792 */     sb.append(" \t b.fbomtype = ").append(45);
/*  793 */     sb.append(" \t and b.fid in ( ").append(SQLUtil.arrayToString(bomIdSet.toArray())).append(") ");
/*  794 */     rs = DbUtil.executeQuery(ctx, sb.toString());
/*      */     try {
/*  796 */       String bomId = null;
/*  797 */       String projectId = null;
/*  798 */       String trackId = null;
/*  799 */       ProjectInfo pjInfo = null;
/*  800 */       TrackNumberInfo tni = null;
/*  801 */       List trackList = null;
/*  802 */       String trackKey = null;
/*  803 */       while (rs.next()) {
/*  804 */         bomId = rs.getString("bomId");
/*  805 */         projectId = rs.getString("projectId");
/*      */ 
/*  807 */         if ((!(rst.containsKey(bomId))) && 
/*  808 */           (MMUtils.isNotEmptyString(projectId))) {
/*  809 */           pjInfo = new ProjectInfo();
/*  810 */           pjInfo.setId(BOSUuid.read(projectId));
/*  811 */           pjInfo.setNumber(rs.getString("projectNumber"));
/*  812 */           pjInfo.setName(rs.getString("projectName"));
/*      */ 
/*  814 */           rst.put(bomId, pjInfo);
/*      */         }
/*      */ 
/*  817 */         trackId = rs.getString("trackId");
/*  818 */         if (MMUtils.isEmptyString(trackId)) {
/*      */           continue;
/*      */         }
/*  821 */         trackKey = bomId + "_track";
/*  822 */         if (rst.containsKey(trackKey)) {
/*  823 */           trackList = (List)rst.get(trackKey);
/*      */         }
/*      */         else {
/*  826 */           trackList = new ArrayList();
/*      */         }
/*  828 */         tni = new TrackNumberInfo();
/*  829 */         tni.setId(BOSUuid.read(trackId));
/*  830 */         tni.setNumber(rs.getString("trackNumber"));
/*  831 */         trackList.add(tni);
/*      */ 
/*  833 */         rst.put(trackKey, trackList);
/*      */       }
/*      */     } catch (SQLException e) {
/*  836 */       throw new SQLDataException(e);
/*      */
/*      */     }
/*      */ 
/*  840 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private Boolean hasOrderBomFormCfgBom(Context ctx, String bomId)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  852 */     Boolean rst = Boolean.FALSE;
/*  853 */     StringBuffer sb = new StringBuffer();
/*  854 */     sb.append(" SELECT  ");
/*  855 */     sb.append("      top 1 fid ");
/*  856 */     sb.append(" FROM ");
/*  857 */     sb.append("     t_mm_bom t ");
/*  858 */     sb.append(" WHERE ");
/*  859 */     sb.append("     t.fbomtype = ").append(45);
/*  860 */     sb.append("     and t.fsourcecfgbomid = ? ");
/*      */ 
/*  862 */     IRowSet rs = DbUtil.executeQuery(ctx, sb.toString(), new Object[] { bomId });
/*      */     try {
/*  864 */       while (rs.next())
/*  865 */         rst = Boolean.TRUE;
/*      */     }
/*      */     catch (SQLException e) {
/*  868 */       throw new SQLDataException(e);
/*      */     }
/*      */ 
/*  871 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected boolean isVoucherFlag(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
/*  879 */     return false;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getBillTypeId()
/*      */   {
/*  888 */     return "JeCqeo42zUqaIctYbVWT+UY+1VI=";
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected void _submitForList(Context ctx, String id)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  903 */     ctx.put("isFromList", Boolean.TRUE);
/*  904 */     BatchExecuteParamsEntry entry = new BatchExecuteParamsEntry(new Class[] { IObjectPK.class });
/*  905 */     entry.add(new ObjectUuidPK(id));
/*  906 */     BatchExecuteParamsEntry[] entrys = { entry };
/*  907 */     batchExecute(ctx, entrys, BatchActionEnum.SUBMIT);
/*  908 */     ctx.put("isFromList", Boolean.FALSE);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected BatchActionResults _bomBatchCheck(Context ctx, IObjectCollection bomCollection, BatchActionEnum action)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  923 */     BatchActionResults actionResults = new BatchActionResults();
/*      */
/*      */ 
/*  926 */     BomCollection bomColls = (BomCollection)bomCollection;
/*  927 */     for (int i = 0; i < bomColls.size(); ++i) {
/*  928 */       if (bomColls.get(i) != null) {
/*  929 */         actionResults.addSuccess(getBomId(bomColls.get(i)));
/*      */       }
/*      */     }
/*      */ 
/*  933 */     actionResults.setObjCollection(bomCollection);
/*      */
/*      */ 
/*  936 */     batchCheck(ctx, action, actionResults);
/*      */ 
/*  938 */     return actionResults;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected BatchActionResults _batchSubmitForList(Context ctx, BatchExecuteParamsEntry[] paramEntries)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  953 */     ctx.put("isFromList", Boolean.TRUE);
/*  954 */     BatchActionResults batchActionResults = batchExecute(ctx, paramEntries, BatchActionEnum.SUBMIT);
/*  955 */     ctx.put("isFromList", Boolean.FALSE);
/*      */ 
/*  957 */     return batchActionResults;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected BatchActionResults _batchSubmit(Context ctx, BatchExecuteParamsEntry[] paramEntries)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  973 */     return batchExecute(ctx, paramEntries, BatchActionEnum.SUBMIT);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected BatchActionResults _batchAudit(Context ctx, BatchExecuteParamsEntry[] paramEntries)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  987 */     return batchExecute(ctx, paramEntries, BatchActionEnum.AUDIT);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected BatchActionResults _batchUnAudit(Context ctx, BatchExecuteParamsEntry[] paramEntries)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1000 */     return batchExecute(ctx, paramEntries, BatchActionEnum.UNAUDIT);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected BatchActionResults _batchDelete(Context ctx, BatchExecuteParamsEntry[] paramEntries)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1013 */     return batchExecute(ctx, paramEntries, BatchActionEnum.DELETE);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void batchCheck(Context ctx, BatchActionEnum batchAction, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1029 */     Set idSet = batchResults.getToDoIdsSet();
/* 1030 */     if (idSet.size() <= 0) {
/* 1031 */       return;
/*      */     }
/* 1033 */     BomCollection bomColls = null;
/*      */
/*      */
/*      */ 
/* 1037 */     boolean isFromList = isFromListUI(ctx);
/*      */
/*      */
/*      */
/*      */ 
/* 1042 */     if ((isFromList) || (batchResults.getObjCollection() == null) || (batchResults.getObjCollection().size() <= 0)) {
/* 1043 */       bomColls = getBomCollectionByIdSet(ctx, idSet);
/*      */     }
/*      */     else {
/* 1046 */       IObjectCollection coll = batchResults.getObjCollection();
/* 1047 */       if ((coll != null) && (coll.size() > 0)) {
/* 1048 */         if (coll instanceof BomCollection) {
/* 1049 */           bomColls = (BomCollection)batchResults.getObjCollection();
/*      */         }
/*      */         else
/*      */         {
/* 1053 */           bomColls = new BomCollection();
/* 1054 */           BomInfo bomInfo = null;
/* 1055 */           for (int i = 0; i < coll.size(); ++i) {
/* 1056 */             bomInfo = (BomInfo)coll.getObject(i);
/* 1057 */             bomColls.add(bomInfo);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1063 */     batchResults.setObjCollection(bomColls);
/*      */
/*      */
/*      */ 
/* 1067 */     if (batchAction.equals(BatchActionEnum.SUBMIT))
/* 1068 */       bomSubmitCheck(ctx, batchAction, batchResults);
/* 1069 */     else if (batchAction.equals(BatchActionEnum.AUDIT))
/* 1070 */       bomAuditCheck(ctx, batchResults, null, true);
/* 1071 */     else if (batchAction.equals(BatchActionEnum.UNAUDIT))
/* 1072 */       bomUnAuditCheck(ctx, batchResults);
/* 1073 */     else if (batchAction.equals(BatchActionEnum.DELETE))
/* 1074 */       bomDeleteCheck(ctx, batchResults);
/* 1075 */     else if (batchAction.getBizAction().equalsIgnoreCase("ALL"))
/* 1076 */       bomAllCheck(ctx, batchAction, batchResults);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void batchExecute(Context ctx, BatchActionEnum batchAction, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1092 */     if ((null == batchAction) || (null == batchResults))
/*      */       return;
/* 1094 */     if (batchAction.equals(BatchActionEnum.SUBMIT)) {
/* 1095 */       bomSubmitProcess(ctx, batchResults);
/*      */
/*      */     }
/* 1098 */     else if (batchAction.equals(BatchActionEnum.AUDIT)) {
///* 1099 */       bomAuditProcess(ctx, batchResults);
/*      */
/*      */     }
/* 1102 */     else if (batchAction.equals(BatchActionEnum.UNAUDIT)) {
///* 1103 */       bomUnAuditProcess(ctx, batchResults);
/*      */
/*      */     }
/* 1106 */     else if (batchAction.equals(BatchActionEnum.DELETE))
/* 1107 */       bomDeleteProcess(ctx, batchResults);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void bomSubmitCheck(Context ctx, BatchActionEnum batchAction, BatchActionResults batchResults)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1123 */     BomCollection bomColls = (BomCollection)batchResults.getObjCollection();
/*      */ 
/* 1125 */     if ((bomColls == null) || (bomColls.size() <= 0)) {
/* 1126 */       return;
/*      */     }
/*      */ 
/* 1129 */     checkBoms(ctx, bomColls, batchAction, batchResults);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void bomAuditCheck(Context ctx, BatchActionResults batchResults, String[] ids, boolean isBomCheck)
/*      */     throws BOSException, BomException
/*      */   {
/* 1146 */     String tableName = null;
/*      */     try
/*      */     {
/* 1149 */       tableName = createBomAuditCheckTable(ctx);
/*      */ 
/* 1151 */       String[] bomIds = getToDoIds(batchResults, ids);
/*      */ 
/* 1153 */       insertBomInfo(ctx, tableName, bomIds);
/*      */ 
/* 1155 */       checkBomForAudit(ctx, tableName);
/*      */ 
/* 1157 */       setErrorInfo(ctx, tableName, batchResults, isBomCheck);
/*      */     }
/*      */     catch (SQLException e)
/*      */     {
/*      */     }
/*      */     finally
/*      */     {
/* 1164 */       releaseTempTable(ctx, tableName);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void bomUnAuditCheck(Context ctx, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1178 */     if ((batchResults.getToDoIdsList() == null) || (batchResults.getToDoIdsList().size() <= 0))
/*      */       return;
/* 1180 */     List idList = batchResults.getToDoIdsList();
/* 1181 */     Set idSet = new HashSet();
/* 1182 */     for (int i = 0; i < idList.size(); ++i) {
/* 1183 */       if (idList.get(i) != null) {
/* 1184 */         idSet.add(idList.get(i).toString());
/*      */       }
/*      */     }
/*      */ 
/* 1188 */     EntityViewInfo view = new EntityViewInfo();
/* 1189 */     SelectorItemCollection selects = new SelectorItemCollection();
/* 1190 */     selects.add(new SelectorItemInfo("id"));
/* 1191 */     selects.add(new SelectorItemInfo("storageOrgUnit.id"));
/* 1192 */     view.setSelector(selects);
/* 1193 */     FilterInfo filter = new FilterInfo();
/* 1194 */     filter.getFilterItems().add(new FilterItemInfo("id", idSet, CompareType.INCLUDE));
/* 1195 */     view.setFilter(filter);
/*      */
/*      */ 
/* 1198 */     ISCMBillParam scmParam = SCMBillParamFactory.getLocalInstance(ctx);
/* 1199 */     String unAudit = null;
/* 1200 */     Map paramMap = new HashMap();
/* 1201 */     BomCollection bomCollection = BomFactory.getLocalInstance(ctx).getBomCollection(view);
/* 1202 */     for (int i = 0; i < bomCollection.size(); ++i)
/* 1203 */       if ((bomCollection.get(i) != null) && (bomCollection.get(i).getStorageOrgUnit() != null)) {
/* 1204 */         if (paramMap.get(bomCollection.get(i).getStorageOrgUnit().getId().toString()) != null) {
/* 1205 */           unAudit = (String)paramMap.get(bomCollection.get(i).getStorageOrgUnit().getId().toString());
/*      */         } else {
/* 1207 */           unAudit = scmParam.getParamByBillTypeID("SCM_UnAudit_01", 4, bomCollection.get(i).getStorageOrgUnit().getId().toString(), "JeCqeo42zUqaIctYbVWT+UY+1VI=");
/*      */
/*      */ 
/* 1210 */           if (unAudit == null) {
/* 1211 */             unAudit = "0";
/*      */           }
/*      */ 
/* 1214 */           paramMap.put(bomCollection.get(i).getStorageOrgUnit().getId().toString(), unAudit);
/*      */         }
/*      */ 
/* 1217 */         if (!("1".equals(unAudit))) {
/* 1218 */           String msg = getResource(ctx, "res_91");
/* 1219 */           batchResults.addError(bomCollection.get(i).getId().toString(), msg);
/*      */         }
/*      */       }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void bomDeleteCheck(Context ctx, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1238 */     BomCollection bomColls = (BomCollection)batchResults.getObjCollection();
/*      */ 
/* 1240 */     BomInfo bomInfo = null;
/* 1241 */     for (int i = 0; i < bomColls.size(); ++i) {
/* 1242 */       bomInfo = bomColls.get(i);
/* 1243 */       if ((bomInfo == null) || 
/* 1244 */         (bomInfo.getBaseStatus().getValue() != 4))
/*      */         continue;
/* 1246 */       batchResults.addError(bomInfo.getId().toString(), new SCMBillException(SCMBillException.CHECKAUDITEDOK, new Object[] { bomInfo.getString("number"), "" }));
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 1252 */     if (batchResults.getToDoIdsArray().length > 0) {
/* 1253 */       BizReference ref = null;
/*      */ 
/* 1255 */       String RESOURCE_PATH = "com.kingdee.eas.mm.basedata.BOMResource";
/* 1256 */       Locale locale = ctx.getLocale();
/*      */
/*      */ 
/* 1259 */       for (int j = 0; j < batchResults.getToDoIdsArray().length; ++j) {
/* 1260 */         String id = batchResults.getToDoIdsArray()[j];
/* 1261 */         if ((id != null) && (!(id.equals("NEWID")))) {
/* 1262 */           ref = ReferenceDAO.getReference(ctx, BOSUuid.read(id));
/* 1263 */           if (ref != null) {
/* 1264 */             String refEntityAlias = ref.getRefEntityAlias(locale);
/* 1265 */             String msg = ResourceUtils.getMessageForServer(RESOURCE_PATH, "be_referenced", new String[] { refEntityAlias });
/*      */
/*      */ 
/* 1268 */             if (ref != null)
/* 1269 */               batchResults.addError(id, msg);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void bomAllCheck(Context ctx, BatchActionEnum batchAction, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1287 */     BomCollection bomColls = (BomCollection)batchResults.getObjCollection();
/*      */ 
/* 1289 */     if ((bomColls == null) || (bomColls.size() <= 0)) {
/* 1290 */       return;
/*      */
/*      */     }
/*      */ 
/* 1294 */     checkBoms(ctx, bomColls, batchAction, batchResults);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void beforeSaveBom(Context ctx, IObjectValue model)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1307 */     BomInfo info = (BomInfo)model;
/*      */ 
/* 1309 */     setDefaultValue(info);
/*      */ 
/* 1311 */     if (null == info.getBizDate()) {
/* 1312 */       Calendar cal = Calendar.getInstance();
/* 1313 */       Date curDate = cal.getTime();
/* 1314 */       info.setBizDate(curDate);
/*      */     }
/*      */ 
/* 1317 */     setBomBaseQty(ctx, info);
/*      */ 
/* 1319 */     setBomConvRatesByMaterial(ctx, info);
/*      */ 
/* 1321 */     setBomBaseConvRatesByMaterial(ctx, info);
/*      */
/*      */ 
/* 1324 */     if (null == info.getBillType()) {
/* 1325 */       BillTypeInfo billType = new BillTypeInfo();
/* 1326 */       billType.setId(BOSUuid.read("JeCqeo42zUqaIctYbVWT+UY+1VI="));
/* 1327 */       billType.setNumber("640");
/* 1328 */       info.setBillType(billType);
/*      */
/*      */     }
/*      */ 
/* 1332 */     if ((info.getUnit() == null) || (info.getBaseUnit() == null))
/* 1333 */       fillBOMInfoForImportData(ctx, info);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void bomDeleteProcess(Context ctx, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1347 */     List idList = batchResults.getToDoIdsList();
/*      */ 
/* 1349 */     String ids = SQLUtil.arrayToString(idList.toArray());
/*      */
/*      */ 
/* 1352 */     String deleteSql = "delete T_MM_BOMPT  where FBomID in (" + ids + ")";
/* 1353 */     DbUtil.execute(ctx, deleteSql);
/*      */
/*      */ 
/* 1356 */     deleteSql = " delete T_MM_OrderBOMPT  where FOrderID in (" + ids + ")";
/* 1357 */     DbUtil.execute(ctx, deleteSql);
/*      */ 
/* 1359 */     _deleteBatchData(ctx, batchResults.getToDoPkArray());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void bomSubmitProcess(Context ctx, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1373 */     boolean isListSubmit = isFromListUI(ctx);
/*      */
/*      */
/*      */
/*      */ 
/* 1378 */     BomCollection bomColls = null;
/* 1379 */     Set idSet = batchResults.getToDoIdsSet();
/* 1380 */     if (idSet.size() <= 0) {
/* 1381 */       return;
/*      */     }
/* 1383 */     bomColls = getBomCollectionByIdSet(ctx, idSet);
/*      */
/*      */ 
/* 1386 */     if ((bomColls == null) || (bomColls.size() <= 0)) {
/* 1387 */       return;
/*      */     }
/*      */ 
/* 1390 */     BomInfo bomInfo = null;
/* 1391 */     for (int i = 0; i < bomColls.size(); ++i) {
/* 1392 */       bomInfo = bomColls.get(i);
/* 1393 */       if (bomInfo == null)
/*      */       {
/*      */         continue;
/*      */       }
/*      */ 
/* 1398 */       updateEntryBaseRate(ctx, bomInfo.getId().toString());
/* 1399 */       updateSubstituteMaterialOtherQty(ctx, bomInfo.getId().toString());
/*      */
/*      */
/*      */     }
/*      */ 
/* 1404 */     if (isListSubmit) {
/* 1405 */       String ids = SQLUtil.arrayToString(idSet.toArray());
/* 1406 */       String sql = "update T_MM_BOM bom set FBASESTATUS=2 where FID in (" + ids + ") ";
/*      */ 
/* 1408 */       DbUtil.execute(ctx, sql);
/*      */
/*      */ 
/* 1411 */       BomCollection coll = (BomCollection)batchResults.getObjCollection();
/* 1412 */       if ((coll == null) || (coll.size() == 0)) {
/* 1413 */         return;
/*      */       }
/* 1415 */       String storageUnitId = null;
/*      */ 
/* 1417 */       BomInfo bom = coll.get(0);
/* 1418 */       storageUnitId = bom.getStorageOrgUnit().getId().toString();
/* 1419 */       boolean isAutoAudit = isAutoAudit(ctx, storageUnitId);
/* 1420 */       if (!(isAutoAudit))
/*      */         return;
/* 1422 */       String permissionName = "mm_bom_audit";
/* 1423 */       String userId = ctx.getCaller().toString();
/* 1424 */       MMUtils.checkPermission(ctx, userId, storageUnitId, permissionName);
/*      */ 
/* 1426 */       _batchAudit(ctx, batchResults.getParamEntries());
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private Map getMaterialPlanMap(Context ctx, BomCollection bomColls)
/*      */     throws BOSException
/*      */   {
/* 1467 */     HashMap map = new HashMap();
/*      */
/*      */ 
/* 1470 */     Set materialSet = new HashSet();
/* 1471 */     Set orgSet = new HashSet();
/*      */ 
/* 1473 */     BomInfo bomInfo = null;
/* 1474 */     BomEntryInfo bomEntryInfo = null;
/* 1475 */     BomEntryCollection entryColls = null;
/* 1476 */     for (int i = 0; i < bomColls.size(); ++i) {
/* 1477 */       bomInfo = bomColls.get(i);
/* 1478 */       if (bomInfo != null) {
/* 1479 */         entryColls = bomInfo.getEntrys();
/* 1480 */         if ((entryColls != null) && (entryColls.size() > 0)) {
/* 1481 */           for (int j = 0; j < entryColls.size(); ++j) {
/* 1482 */             bomEntryInfo = entryColls.get(j);
/* 1483 */             if ((bomEntryInfo != null) && (bomEntryInfo.getMaterial() != null)) {
/* 1484 */               materialSet.add(bomEntryInfo.getMaterial().getId().toString());
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/* 1489 */         if (bomInfo.getMaterial() != null) {
/* 1490 */           materialSet.add(bomInfo.getMaterial().getId().toString());
/*      */         }
/*      */ 
/* 1493 */         if (bomInfo.getStorageOrgUnit() != null) {
/* 1494 */           orgSet.add(bomInfo.getStorageOrgUnit().getId().toString());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1499 */     if ((materialSet.size() > 0) && (orgSet.size() > 0)) {
/* 1500 */       EntityViewInfo viewInfo = new EntityViewInfo();
/* 1501 */       SelectorItemCollection sic = new SelectorItemCollection();
/* 1502 */       sic.add(new SelectorItemInfo("*"));
/* 1503 */       sic.add(new SelectorItemInfo("material.id"));
/* 1504 */       sic.add(new SelectorItemInfo("manufactureStrategy.id"));
/*      */ 
/* 1506 */       FilterInfo filterInfo = new FilterInfo();
/* 1507 */       filterInfo.getFilterItems().add(new FilterItemInfo("material.id", materialSet, CompareType.INCLUDE));
/* 1508 */       filterInfo.getFilterItems().add(new FilterItemInfo("orgUnit.id", orgSet, CompareType.INCLUDE));
/* 1509 */       filterInfo.getFilterItems().add(new FilterItemInfo("status", UsedStatusEnum.APPROVED, CompareType.EQUALS));
/* 1510 */       viewInfo.setFilter(filterInfo);
/* 1511 */       viewInfo.setSelector(sic);
/*      */ 
/* 1513 */       MaterialPlanCollection mpc = MaterialPlanFactory.getLocalInstance(ctx).getMaterialPlanCollection(viewInfo);
/* 1514 */       if ((mpc != null) && (mpc.size() > 0)) {
/* 1515 */         MaterialPlanInfo planInfo = null;
/* 1516 */         String tempId = null;
/* 1517 */         for (int i = 0; i < mpc.size(); ++i) {
/* 1518 */           planInfo = mpc.get(i);
/* 1519 */           tempId = planInfo.getOrgUnit().getId().toString() + "#" + planInfo.getMaterial().getId().toString();
/* 1520 */           map.put(tempId, planInfo);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1525 */     return map;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private Map getMaterialInvMap(Context ctx, BomCollection bomColls)
/*      */     throws BOSException
/*      */   {
/* 1538 */     HashMap map = new HashMap();
/*      */
/*      */ 
/* 1541 */     Set materialSet = new HashSet();
/* 1542 */     Set orgSet = new HashSet();
/*      */ 
/* 1544 */     BomInfo bomInfo = null;
/* 1545 */     BomEntryInfo bomEntryInfo = null;
/* 1546 */     BomEntryCollection entryColls = null;
/* 1547 */     for (int i = 0; i < bomColls.size(); ++i) {
/* 1548 */       bomInfo = bomColls.get(i);
/* 1549 */       if (bomInfo != null) {
/* 1550 */         entryColls = bomInfo.getEntrys();
/* 1551 */         if ((entryColls != null) && (entryColls.size() > 0)) {
/* 1552 */           for (int j = 0; j < entryColls.size(); ++j) {
/* 1553 */             bomEntryInfo = entryColls.get(j);
/* 1554 */             if ((bomEntryInfo != null) && (bomEntryInfo.getMaterial() != null)) {
/* 1555 */               materialSet.add(bomEntryInfo.getMaterial().getId().toString());
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/* 1560 */         if (bomInfo.getMaterial() != null) {
/* 1561 */           materialSet.add(bomInfo.getMaterial().getId().toString());
/*      */         }
/*      */ 
/* 1564 */         if (bomInfo.getStorageOrgUnit() != null) {
/* 1565 */           orgSet.add(bomInfo.getStorageOrgUnit().getId().toString());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1570 */     if ((materialSet.size() > 0) && (orgSet.size() > 0)) {
/* 1571 */       EntityViewInfo viewInfo = new EntityViewInfo();
/* 1572 */       SelectorItemCollection sic = new SelectorItemCollection();
/* 1573 */       sic.add(new SelectorItemInfo("*"));
/* 1574 */       sic.add(new SelectorItemInfo("material.id"));
/* 1575 */       sic.add(new SelectorItemInfo("manufactureStrategy.id"));
/*      */ 
/* 1577 */       FilterInfo filterInfo = new FilterInfo();
/* 1578 */       filterInfo.getFilterItems().add(new FilterItemInfo("material.id", materialSet, CompareType.INCLUDE));
/* 1579 */       filterInfo.getFilterItems().add(new FilterItemInfo("orgUnit.id", orgSet, CompareType.INCLUDE));
/* 1580 */       filterInfo.getFilterItems().add(new FilterItemInfo("status", UsedStatusEnum.APPROVED, CompareType.EQUALS));
/* 1581 */       viewInfo.setFilter(filterInfo);
/* 1582 */       viewInfo.setSelector(sic);
/*      */ 
/* 1584 */       MaterialInventoryCollection invColls = MaterialInventoryFactory.getLocalInstance(ctx).getMaterialInventoryCollection(viewInfo);
/*      */ 
/* 1586 */       if ((invColls != null) && (invColls.size() > 0)) {
/* 1587 */         MaterialInventoryInfo invInfo = null;
/* 1588 */         String tempId = null;
/* 1589 */         for (int i = 0; i < invColls.size(); ++i) {
/* 1590 */           invInfo = invColls.get(i);
/* 1591 */           tempId = invInfo.getOrgUnit().getId().toString() + "#" + invInfo.getMaterial().getId().toString();
/* 1592 */           map.put(tempId, invInfo);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1597 */     return map;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkMaterialduplicate(Context ctx, BomInfo bomInfo, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1613 */     BomEntryCollection bec = bomInfo.getEntrys();
/* 1614 */     BomEntryInfo beiOuter = null;
/* 1615 */     BomEntryInfo beiInner = null;
/* 1616 */     String materialIdOuter = null;
/* 1617 */     int leadTimeOuter = -1;
/*      */ 
/* 1619 */     Date effectiveDateOuter = null;
/*      */ 
/* 1621 */     Date disabledDateOuter = null;
/* 1622 */     String materialIdInner = null;
/* 1623 */     int leadTimeInner = -1;
/* 1624 */     Date effectiveDateInner = null;
/* 1625 */     Date disabledDateInner = null;
/* 1626 */     int compareValue1 = -1;
/* 1627 */     int compareValue2 = -1;
/*      */ 
/* 1629 */     int opNumInner = -1;
/* 1630 */     int opNumOuter = -1;
/* 1631 */     Map excludeedEntry = new HashMap();
/* 1632 */     List resultList = new ArrayList();
/* 1633 */     String tmp = "";
/* 1634 */     BOMPTCollection ptCollInner = null;
/* 1635 */     BOMPTCollection ptCollOuter = null;
/* 1636 */     boolean duplicate = false;
/* 1637 */     String trackId = null;
/* 1638 */     String trackId2 = null;
/* 1639 */     int i = 0; for (int count = bec.size(); i < count; ++i) {
/* 1640 */       beiOuter = bec.get(i);
/* 1641 */       materialIdOuter = beiOuter.getMaterial().getId().toString();
/* 1642 */       leadTimeOuter = beiOuter.getLeadtime();
/* 1643 */       opNumOuter = beiOuter.getOperationNo();
/* 1644 */       effectiveDateOuter = beiOuter.getEffectiveDate();
/* 1645 */       disabledDateOuter = beiOuter.getDisableDate();
/* 1646 */       tmp = String.valueOf(i + 1);
/* 1647 */       int j = i + 1; for (int count1 = bec.size(); j < count1; ++j) {
/* 1648 */         if (excludeedEntry.containsKey(String.valueOf(j))) {
/*      */           continue;
/*      */         }
/* 1651 */         beiInner = bec.get(j);
/* 1652 */         materialIdInner = beiInner.getMaterial().getId().toString();
/* 1653 */         leadTimeInner = beiInner.getLeadtime();
/* 1654 */         opNumInner = beiInner.getOperationNo();
/* 1655 */         effectiveDateInner = beiInner.getEffectiveDate();
/* 1656 */         disabledDateInner = beiInner.getDisableDate();
/*      */
/*      */ 
/* 1659 */         if ((!(materialIdOuter.equals(materialIdInner))) || (leadTimeOuter != leadTimeInner) || (opNumOuter != opNumInner))
/*      */           continue;
/* 1661 */         if (bomInfo.getBomType() == BOMTypeEnum.CfgBOM) {
/* 1662 */           ptCollInner = beiInner.getTrackNumbers();
/* 1663 */           ptCollOuter = beiOuter.getTrackNumbers();
/*      */
/*      */ 
/* 1666 */           duplicate = false;
/*      */
/*      */ 
/* 1669 */           if ((((ptCollInner == null) || (ptCollInner.size() == 0))) && (((ptCollOuter == null) || (ptCollOuter.size() == 0)))) {
/* 1670 */             duplicate = true;
/*      */
/*      */           }
/* 1673 */           else if ((ptCollOuter != null) && (ptCollInner != null) && (ptCollOuter.size() > 0) && (ptCollInner.size() > 0)) {
/* 1674 */             for (int m = 0; m < ptCollOuter.size(); ++m)
/*      */             {
/* 1676 */               trackId = ptCollOuter.get(m).getFTrackID();
/* 1677 */               if (trackId == null) {
/* 1678 */                 trackId = "999999999";
/*      */               }
/*      */ 
/* 1681 */               for (int n = 0; n < ptCollInner.size(); ++n)
/*      */               {
/* 1683 */                 trackId2 = ptCollInner.get(n).getFTrackID();
/* 1684 */                 if (trackId2 == null) {
/* 1685 */                   trackId2 = "999999999";
/*      */                 }
/*      */ 
/* 1688 */                 if (trackId.equals(trackId2)) {
/* 1689 */                   duplicate = true;
/* 1690 */                   break;
/*      */                 }
/*      */               }
/* 1693 */               if (duplicate)
/*      */
/*      */               {
/*      */                 break;
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/* 1704 */             duplicate = true;
/*      */
/*      */           }
/*      */ 
/* 1708 */           if (!(duplicate)) {
/*      */             continue;
/*      */           }
/*      */         }
/*      */ 
/* 1713 */         compareValue1 = converDateToInt(disabledDateInner) - converDateToInt(effectiveDateOuter);
/* 1714 */         compareValue2 = converDateToInt(effectiveDateInner) - converDateToInt(disabledDateOuter);
/*      */
/*      */
/*      */ 
/* 1718 */         if ((compareValue1 == 0) || (compareValue2 == 0)) { if (compareValue1 != 0) continue; if (compareValue2 != 0)
/*      */             continue;
/*      */         }
/* 1721 */         if ((compareValue1 == 0) && (compareValue2 == 0)) {
/* 1722 */           tmp = tmp + ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "res_92") + (j + 1);
/*      */ 
/* 1724 */           excludeedEntry.put(String.valueOf(j), null);
/*      */         }
/* 1726 */         compareValue1 = (compareValue1 < 0) ? -1 : 1;
/* 1727 */         compareValue2 = (compareValue2 < 0) ? -1 : 1;
/* 1728 */         if (compareValue1 * compareValue2 < 0) {
/* 1729 */           tmp = tmp + ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "res_92") + (j + 1);
/*      */ 
/* 1731 */           excludeedEntry.put(String.valueOf(j), null);
/*      */         }
/*      */       }
/*      */ 
/* 1735 */       if (!(String.valueOf(i + 1).equals(tmp))) {
/* 1736 */         resultList.add(tmp);
/*      */       }
/*      */     }
/* 1739 */     if (!(resultList.isEmpty())) {
/* 1740 */       StringBuffer sb = new StringBuffer();
/* 1741 */       for (Iterator i1 = resultList.iterator(); i1.hasNext(); ) {
/* 1742 */         sb.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.material.duplicate", new String[] { (String)i1.next() }));
/*      */
/*      */
/*      */
/*      */       }
/*      */ 
/* 1748 */       String bomId = getBomId(bomInfo);
/* 1749 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new Object[] { sb.toString() }));
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkSubstituteMaterial(Context ctx, BomInfo bomInfo, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1764 */     BomEntryCollection bec = bomInfo.getEntrys();
/* 1765 */     BomEntryInfo bei = null;
/* 1766 */     BomSubstituteCollection bsc = null;
/* 1767 */     BomSubstituteInfo bsi = null;
/*      */
/*      */ 
/* 1770 */     StringBuffer sbNull = new StringBuffer();
/*      */ 
/* 1772 */     StringBuffer sbOther = new StringBuffer();
/*      */ 
/* 1774 */     StringBuffer sb = new StringBuffer();
/*      */ 
/* 1776 */     StringBuffer errorBuffer = new StringBuffer();
/*      */ 
/* 1778 */     String strNo = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "Multi_No");
/*      */ 
/* 1780 */     String strRow = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "Multi_Row");
/* 1781 */     Map childMaterialsMap = new HashMap();
/* 1782 */     Map substituteSeqMap = new HashMap();
/* 1783 */     Map substituteEffectiveDateMap = new HashMap();
/* 1784 */     Map substituteInvalidDateMap = new HashMap();
/* 1785 */     Map substituteMaterialMap = new HashMap();
/* 1786 */     String seqNo = "";
/*      */ 
/* 1788 */     int i = 0; for (int count = bec.size(); i < count; ++i)
/*      */     {
/* 1790 */       bei = bec.get(i);
/* 1791 */       bsc = bei.getSubstituteEntry();
/* 1792 */       seqNo = String.valueOf(i + 1);
/* 1793 */       sb.setLength(0);
/*      */ 
/* 1795 */       int k = 0; for (int count1 = bsc.size(); k < count1; ++k)
/*      */       {
/* 1797 */         bsi = bsc.get(k);
/* 1798 */         sbNull.setLength(0);
/* 1799 */         if (null == bsi.getSubstituteMaterial()) {
/* 1800 */           sbNull.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.submaterial.notnull"));
/*      */         }
/*      */ 
/* 1803 */         if (null == bsi.getSubstituteUnit()) {
/* 1804 */           sbNull.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subunit.notnull"));
/*      */         }
/*      */ 
/* 1807 */         if ((null == bsi.getSubstituteQty()) && (null == bsi.getSubstituteProportion())) {
/* 1808 */           sbNull.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subcontent.notnull"));
/*      */         }
/*      */ 
/* 1811 */         if (null == bsi.getEffectiveDate()) {
/* 1812 */           sbNull.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subeffectivedate.notnull"));
/*      */         }
/*      */ 
/* 1815 */         if (null == bsi.getInvalidDate()) {
/* 1816 */           sbNull.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subinvaliddate.notnull"));
/*      */         }
/*      */ 
/* 1819 */         if (sbNull.length() > 0) {
/* 1820 */           if (sb.length() > 0) {
/* 1821 */             sb.append("\r\n");
/*      */           }
/* 1823 */           sb.append(strNo).append(k + 1).append(strRow).append(" ");
/* 1824 */           sb.append(sbNull.substring(0, sbNull.length() - 1));
/* 1825 */           sb.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.null"));
/*      */         }
/*      */       }
/*      */ 
/* 1829 */       if (sb.length() > 0) {
/* 1830 */         if (errorBuffer.length() > 0) {
/* 1831 */           errorBuffer.append("\r\n");
/*      */         }
/* 1833 */         errorBuffer.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.seq", new String[] { seqNo }));
/* 1834 */         errorBuffer.append(sb);
/*      */       }
/*      */     }
/*      */ 
/* 1838 */     String bomId = getBomId(bomInfo);
/* 1839 */     if (errorBuffer.length() > 0) {
/* 1840 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { errorBuffer.toString() }));
/*      */
/*      */     }
/*      */     else
/*      */     {
/* 1845 */       Integer substituteSeq = null;
/* 1846 */       MaterialInfo mi = null;
/* 1847 */       sb.setLength(0);
/* 1848 */       i = 0; for (int count = bec.size(); i < count; ++i) {
/* 1849 */         seqNo = String.valueOf(i + 1);
/*      */ 
/* 1851 */         bei = bec.get(i);
/* 1852 */         bsc = bei.getSubstituteEntry();
/*      */ 
/* 1854 */         if (ReplaceModeEnum.NONE == bei.getReplaceMode()) {
/* 1855 */           bsc.clear();
/*      */         }
/*      */ 
/* 1858 */         int k = 0; for (int count1 = bsc.size(); k < count1; ++k)
/*      */         {
/* 1860 */           bsi = bsc.get(k);
/* 1861 */           substituteSeq = new Integer(bsi.getSubstituteSeq());
/* 1862 */           mi = bsi.getSubstituteMaterial();
/*      */ 
/* 1864 */           if (substituteSeqMap.containsKey(substituteSeq)) {
/* 1865 */             substituteSeqMap.put(substituteSeq, new Integer(((Integer)substituteSeqMap.get(substituteSeq)).intValue() + 1));
/*      */           }
/*      */           else {
/* 1868 */             substituteSeqMap.put(substituteSeq, new Integer(1));
/*      */           }
/*      */ 
/* 1871 */           if (substituteMaterialMap.containsKey(substituteSeq)) {
/* 1872 */             ((Set)substituteMaterialMap.get(substituteSeq)).add(mi.getId().toString());
/*      */           } else {
/* 1874 */             Set set = new HashSet();
/* 1875 */             set.add(mi.getId().toString());
/* 1876 */             substituteMaterialMap.put(substituteSeq, set);
/* 1877 */             set = null;
/*      */           }
/*      */ 
/* 1880 */           if (substituteEffectiveDateMap.containsKey(substituteSeq)) {
/* 1881 */             ((Set)substituteEffectiveDateMap.get(substituteSeq)).add(bsi.getEffectiveDate());
/*      */           } else {
/* 1883 */             Set set = new HashSet();
/* 1884 */             set.add(bsi.getEffectiveDate());
/* 1885 */             substituteEffectiveDateMap.put(substituteSeq, set);
/* 1886 */             set = null;
/*      */           }
/*      */ 
/* 1889 */           if (substituteInvalidDateMap.containsKey(substituteSeq)) {
/* 1890 */             ((Set)substituteInvalidDateMap.get(substituteSeq)).add(bsi.getInvalidDate());
/*      */           } else {
/* 1892 */             Set set = new HashSet();
/* 1893 */             set.add(bsi.getInvalidDate());
/* 1894 */             substituteInvalidDateMap.put(substituteSeq, set);
/* 1895 */             set = null;
/*      */           }
/*      */ 
/* 1898 */           if ((null != bsi.getSubstituteProportion()) && (MMConstant.BIGDECIMAL_ZERO.compareTo(bsi.getSubstituteProportion()) != 0)) {
/* 1899 */             childMaterialsMap.put(mi.getId().toString(), null);
/*      */           }
/*      */         }
/*      */ 
/* 1903 */         String[] childMaterials = (String[])(String[])childMaterialsMap.keySet().toArray(new String[0]);
/* 1904 */         String[] invalidMaterials = null;
/*      */ 
/* 1906 */         invalidMaterials = BOMFacadeFactory.getLocalInstance(ctx).findChildMaterialIdNoSameGroupWithParent(bei.getMaterial().getId().toString(), childMaterials);
/*      */
/*      */
/*      */ 
/* 1910 */         childMaterialsMap.clear();
/* 1911 */         for (k = 0; k < invalidMaterials.length; ++k) {
/* 1912 */           childMaterialsMap.put(invalidMaterials[k], null);
/*      */         }
/*      */ 
/* 1915 */         k = 0; for (int count1 = bsc.size(); k < count1; ++k)
/*      */         {
/* 1917 */           bsi = bsc.get(k);
/* 1918 */           if ((null != bsi.getSubstituteProportion()) && (MMConstant.BIGDECIMAL_ZERO.compareTo(bsi.getSubstituteProportion()) != 0) && 
/* 1919 */             (childMaterialsMap.containsKey(bsi.getSubstituteMaterial().getId().toString()))) {
/* 1920 */             sbOther.append(strNo).append(k + 1).append(strRow).append(" ");
/* 1921 */             sbOther.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subunit.notinsamegroup")).append("\r\n");
/*      */
/*      */
/*      */           }
/*      */ 
/* 1926 */           if (bsi.getEffectiveDate().compareTo(bsi.getInvalidDate()) >= 0) {
/* 1927 */             sbOther.append(strNo).append(k + 1).append(strRow).append(" ");
/* 1928 */             sbOther.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.sub2date.bigger")).append("\r\n");
/*      */           }
/*      */         }
/*      */ 
/* 1932 */         Integer[] seq = (Integer[])(Integer[])substituteSeqMap.keySet().toArray(new Integer[0]);
/* 1933 */         Integer temp = null;
/* 1934 */         int seqCount = 0;
/* 1935 */         int tmpCount = 0;
/*      */ 
/* 1937 */         for (k = 0; k < seq.length; ++k) {
/* 1938 */           temp = seq[k];
/* 1939 */           seqCount = ((Integer)substituteSeqMap.get(temp)).intValue();
/* 1940 */           tmpCount = ((Set)substituteMaterialMap.get(temp)).size();
/* 1941 */           if (seqCount != tmpCount) {
/* 1942 */             sbOther.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subseqcheck.materialRepeat", new String[] { temp.toString() })).append("\r\n");
/*      */
/*      */           }
/*      */ 
/* 1946 */           tmpCount = ((Set)substituteEffectiveDateMap.get(temp)).size();
/* 1947 */           if (tmpCount > 1) {
/* 1948 */             sbOther.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subseqcheck.effectivedatediff", new String[] { temp.toString() })).append("\r\n");
/*      */
/*      */           }
/*      */ 
/* 1952 */           tmpCount = ((Set)substituteInvalidDateMap.get(temp)).size();
/* 1953 */           if (tmpCount > 1) {
/* 1954 */             sbOther.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "subsentry.subseqcheck.invaliddatediff", new String[] { temp.toString() })).append("\r\n");
/*      */
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 1960 */         if (sbOther.length() > 0) {
/* 1961 */           errorBuffer.append(ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.seq", new String[] { seqNo }));
/*      */ 
/* 1963 */           errorBuffer.append(sbOther);
/*      */
/*      */         }
/*      */ 
/* 1967 */         childMaterialsMap.clear();
/* 1968 */         substituteSeqMap.clear();
/* 1969 */         substituteEffectiveDateMap.clear();
/* 1970 */         substituteInvalidDateMap.clear();
/* 1971 */         substituteMaterialMap.clear();
/* 1972 */         sbOther.setLength(0);
/*      */
/*      */       }
/*      */ 
/* 1976 */       if (errorBuffer.length() > 0)
/* 1977 */         batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { errorBuffer.toString() }));
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomParent(Context ctx, BomInfo bomInfo, Map planMap, Map invMap, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1994 */     String msg = null;
/* 1995 */     String bomId = getBomId(bomInfo);
/*      */
/*      */ 
/* 1998 */     if (bomInfo.getNumber() == null)
/*      */     {
/* 2000 */       ICodingRuleManager codingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
/* 2001 */       RuleStatus ruleStatus = codingRuleManager.getRuleStatus(bomInfo, bomInfo.getStorageOrgUnit().getId().toString());
/*      */ 
/* 2003 */       if (!(ruleStatus.isExist()))
/*      */       {
/* 2005 */         msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "number_Required");
/* 2006 */         batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */
/*      */
/*      */       }
/*      */       else
/*      */       {
/* 2014 */         String storageOrgUnitId = bomInfo.getStorageOrgUnit().getId().toString();
/* 2015 */         String newNumber = codingRuleManager.getNumber(bomInfo, storageOrgUnitId);
/* 2016 */         bomInfo.setNumber(newNumber);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2021 */     if (bomInfo.getBomGroup() == null) {
/* 2022 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "bomGroup_notnull");
/* 2023 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */     }
/*      */ 
/* 2028 */     if (bomInfo.getBomType() == null) {
/* 2029 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "bomType_Required");
/* 2030 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */     }
/*      */ 
/* 2035 */     if (bomInfo.getUsageType() == null) {
/* 2036 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "usageType_Required");
/* 2037 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 2049 */     if (bomInfo.getProductQty() == null) {
/* 2050 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "productQty_Required");
/* 2051 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */     }
/* 2055 */     else if (bomInfo.getProductQty().floatValue() <= 0.0F) {
/* 2056 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "productQty_MustBigThan0");
/* 2057 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 2063 */     if (bomInfo.getYield() == null) {
/* 2064 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "fatherBOM_Yield_Required");
/* 2065 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */     }
/* 2069 */     else if (bomInfo.getYield().floatValue() <= 0.0F) {
/* 2070 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "fatherBOM_Yield_MustBigThan0");
/* 2071 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 2078 */     if ((bomInfo.getBomType().equals(BOMTypeEnum.CfgBOM)) && (bomInfo.isIsProjectManu())) {
/* 2079 */       ProjectInfo pInfo = bomInfo.getProject();
/* 2080 */       if ((pInfo == null) || (pInfo.getId() == null)) {
/* 2081 */         msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "not_null_project");
/* 2082 */         batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2089 */     if (bomInfo.getMaterial() == null) {
/* 2090 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "fatherMaterial_Required");
/* 2091 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */ 
/* 2093 */       return;
/*      */     }
/*      */ 
/* 2096 */     String orgId = bomInfo.getStorageOrgUnit().getId().toString();
/* 2097 */     String mateialId = bomInfo.getMaterial().getId().toString();
/* 2098 */     MaterialPlanInfo plnInfo = (MaterialPlanInfo)planMap.get(orgId + "#" + mateialId);
/* 2099 */     MaterialInventoryInfo invInfo = (MaterialInventoryInfo)invMap.get(orgId + "#" + mateialId);
/*      */
/*      */ 
/* 2102 */     if ((!(bomId.equals("NEWID"))) && 
/* 2103 */       (bomInfo.getProductBaseQty().floatValue() == 0.0F)) {
/* 2104 */       msg = bomInfo.getMaterial().getNumber();
/* 2105 */       batchResults.addError(bomId, new BomException(BomException.HEADBASEQTYZERO, new Object[] { msg }));
/*      */
/*      */
/*      */     }
/*      */ 
/* 2110 */     if (plnInfo == null) {
/* 2111 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "fatherMaterial_MaterialPlanNone");
/* 2112 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */     }
/*      */ 
/* 2116 */     if (invInfo == null) {
/* 2117 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "fatherMaterial_MaterialInventoryNone");
/* 2118 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */     }
/*      */ 
/* 2122 */     if (plnInfo == null)
/*      */       return;
/* 2124 */     if (bomInfo.getBomType() == BOMTypeEnum.CfgBOM) {
/* 2125 */       if (!(plnInfo.isIsConfigable())) {
/* 2126 */         msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "res_192");
/* 2127 */         batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */       }
/* 2129 */       if (bomInfo.getUsageType() != BOMUsageEnum.Master) {
/* 2130 */         msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "res_193");
/* 2131 */         batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */       }
/* 2133 */     } else if ((bomInfo.getBomType() == BOMTypeEnum.MfgBOM) && 
/*      */
/* 2135 */       (plnInfo.isIsConfigable())) {
/* 2136 */       msg = ResourceBase.getString("com.kingdee.eas.mm.basedata.BASEDATAAutoGenerateResource", "1_BomControllerBean", ctx.getLocale());
/*      */ 
/* 2138 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */     }
/*      */ 
/* 2143 */     if (MaterialAttributeEnum.OTHER.equals(plnInfo.getMaterialAttr())) {
/* 2144 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "fatherMaterial_Type_Error");
/* 2145 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */     }
/*      */ 
/* 2149 */     if ((bomInfo.getBomType().equals(BOMTypeEnum.MfgBOM)) && 
/* 2150 */       (MaterialAttributeEnum.SCHEDULEPART.equals(plnInfo.getMaterialAttr()))) {
/* 2151 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "parent_cannotBeSchedulePartInMafBOM");
/*      */ 
/* 2153 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 2159 */     if (!(bomInfo.getBomType().equals(BOMTypeEnum.OrderBOM)))
/*      */       return;
/* 2161 */     checkOrderBomProjectTrack(batchResults, bomInfo, plnInfo);
/*      */
/*      */ 
/* 2164 */     StringBuffer sql = new StringBuffer();
/* 2165 */     sql.append(" SELECT b.fid,pt.fprojectid,pt.ftrackid from t_mm_bom b ");
/* 2166 */     sql.append(" inner join t_mm_orderbompt pt ON b.fid = pt.forderid ");
/* 2167 */     sql.append(" WHERE b.fstorageorgunitid = '").append(bomInfo.getStorageOrgUnit().getId().toString()).append("' ");
/*      */ 
/* 2169 */     sql.append("  AND b.fusagetype = ").append(10);
/* 2170 */     sql.append("  AND b.fbomtype = ").append(45);
/* 2171 */     sql.append("  AND b.fmaterialid = '").append(bomInfo.getMaterial().getId().toString()).append("' ");
/* 2172 */     sql.append("  AND b.fbasestatus = ").append(4);
/* 2173 */     IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
/* 2174 */     Set set = new HashSet();
/*      */     try {
/* 2176 */       String currId = null;
/* 2177 */       if (bomInfo.getId() == null)
/* 2178 */         currId = "999999999";
/*      */       else {
/* 2180 */         currId = bomInfo.getId().toString();
/*      */       }
/*      */ 
/* 2183 */       String id = "999999999";
/* 2184 */       String projectId = "999999999";
/* 2185 */       String trackId = "999999999";
/* 2186 */       while (rs.next()) {
/* 2187 */         id = rs.getString("fid");
/* 2188 */         if (id == null) {
/* 2189 */           id = "999999999";
/*      */         }
/*      */ 
/* 2192 */         if (!(currId.equals(id)));
/* 2193 */         projectId = rs.getString("fprojectid");
/* 2194 */         if (projectId == null) {
/* 2195 */           projectId = "999999999";
/*      */         }
/* 2197 */         trackId = rs.getString("ftrackid");
/* 2198 */         if (trackId == null) {
/* 2199 */           trackId = "999999999";
/*      */         }
/* 2201 */         set.add(projectId + "#" + trackId);
/*      */       }
/*      */     }
/*      */     catch (SQLException e) {
/* 2205 */       throw new BOSException(e);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkOrderBomProjectTrack(BatchActionResults batchResults, BomInfo bomInfo, MaterialPlanInfo materialPlan)
/*      */   {
/* 2224 */     OrderBOMPTCollection bomptColl = bomInfo.getOrderBomTP();
/* 2225 */     OrderBOMPTInfo ptInfo = null;
/* 2226 */     if ((bomptColl == null) || (bomptColl.size() == 0)) {
/* 2227 */       ptInfo = new OrderBOMPTInfo();
/*      */     }
/*      */     else {
/* 2230 */       ptInfo = bomInfo.getOrderBomTP().get(0);
/*      */     }
/* 2232 */     String bomId = getBomId(bomInfo);
/* 2233 */     String strategyId = materialPlan.getManufactureStrategy().getId().toString();
/* 2234 */     Set projectTrackStrategySet = ManufactureStrategyGroup.getProjectTrackOrderBomStrategyIdSet();
/* 2235 */     Set trackStrategySet = ManufactureStrategyGroup.getTrackOrderBomStrategyIdSet();
/* 2236 */     String projectId = ptInfo.getProjectId();
/* 2237 */     String trackId = ptInfo.getTrackId();
/* 2238 */     if (projectTrackStrategySet.contains(strategyId)) {
/* 2239 */       IsolatedRuleEnum isolatedRule = materialPlan.getIsolatedRule();
/*      */ 
/* 2241 */       if (IsolatedRuleEnum.ITEM_TRACKNO.equals(isolatedRule)) {
/* 2242 */         if ((MMUtils.isEmptyString(projectId)) || (MMUtils.isEmptyString(trackId))) {
/* 2243 */           String msg = getResource("projectAndTrackNumCanNotNull");
/* 2244 */           addError(batchResults, bomId, msg);
/*      */         }
/*      */ 
/*      */       }
/* 2248 */       else if ((IsolatedRuleEnum.ITEM.equals(isolatedRule)) && 
/* 2249 */         (MMUtils.isEmptyString(projectId))) {
/* 2250 */         String msg = getResource("proNumCanNotNull");
/* 2251 */         addError(batchResults, bomId, msg);
/*      */       }
/*      */     }
/*      */     else {
/* 2255 */       if ((!(trackStrategySet.contains(strategyId))) || 
/*      */
/* 2257 */         (!(MMUtils.isEmptyString(trackId)))) return;
/* 2258 */       String msg = getResource("trackNumCanNotNull");
/* 2259 */       addError(batchResults, bomId, msg);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void addError(BatchActionResults batchResults, String id, String errorMsg)
/*      */   {
/* 2275 */     BomException bomException = createBomException(errorMsg);
/* 2276 */     batchResults.addError(id, bomException);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private BomException createBomException(String message)
/*      */   {
/* 2288 */     Object[] params = { message };
/* 2289 */     BomException bomException = new BomException(BomException.BLANKEXCEPTION, params);
/* 2290 */     return bomException;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomEntry(Context ctx, BomInfo bomInfo, Map planMap, Map invMap, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 2304 */     String msg = null;
/* 2305 */     String bomId = getBomId(bomInfo);
/* 2306 */     BomEntryCollection bomEntryCollection = bomInfo.getEntrys();
/* 2307 */     if ((bomEntryCollection != null) && (bomEntryCollection.size() <= 0))
/*      */     {
/* 2309 */       msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys_Required");
/* 2310 */       batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */     }
/*      */     else
/*      */     {
/* 2314 */       Map map = null;
/* 2315 */       List materialIdListForPropertion = new ArrayList();
/* 2316 */       for (int jj = 0; jj < bomEntryCollection.size(); ++jj) {
/* 2317 */         BomEntryInfo bomEntryInfo = bomEntryCollection.get(jj);
/* 2318 */         if ((!(ConsumeTypeEnum.Proportion.equals(bomEntryInfo.getConsumeType()))) || 
/* 2319 */           (bomEntryInfo.getMaterial() == null)) continue;
/* 2320 */         materialIdListForPropertion.add(bomEntryInfo.getMaterial().getId().toString());
/*      */
/*      */
/*      */       }
/*      */ 
/* 2325 */       if ((null != bomInfo.getMaterial()) && (null != bomInfo.getMaterial().getId()) && (!("".equals(bomInfo.getMaterial().getId().toString()))) && 
/*      */
/* 2327 */         (!(materialIdListForPropertion.isEmpty()))) {
/* 2328 */         String parentMaterialId = bomInfo.getMaterial().getId().toString();
/* 2329 */         map = getChildMaterialIdNoSameGroupWithParent(ctx, (String[])(String[])materialIdListForPropertion.toArray(new String[0]), parentMaterialId);
/*      */
/*      */
/*      */       }
/*      */ 
/* 2334 */       String orgId = bomInfo.getStorageOrgUnit().getId().toString();
/*      */
/*      */       try
/*      */       {
/* 2338 */         int i = 1;
/* 2339 */         BomEntryInfo bomEntryInfo = null;
/* 2340 */         String materialId = null;
/*      */ 
/* 2342 */         MaterialPlanInfo planInfo = null;
/* 2343 */         MaterialInventoryInfo invInfo = null;
/* 2344 */         String seqNo = null;
/* 2345 */         String seqRes = null;
/* 2346 */         String nullRes = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.null");
/* 2347 */         for (int jj = 0; jj < bomEntryCollection.size(); ++jj) {
/* 2348 */           bomEntryInfo = bomEntryCollection.get(jj);
/*      */
/*      */ 
/* 2351 */           seqNo = String.valueOf(i + jj);
/*      */ 
/* 2353 */           seqRes = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.seq", new String[] { seqNo });
/*      */
/*      */
/*      */ 
/* 2357 */           if (bomEntryInfo.getMaterial() == null) {
/* 2358 */             msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.material_Required");
/* 2359 */             batchResults.addError(bomId, seqRes + msg + nullRes);
/*      */
/*      */           }
/*      */           else
/*      */           {
/* 2364 */             if (null == bomInfo.getMaterial())
/*      */             {
/*      */               continue;
/*      */             }
/*      */ 
/* 2369 */             if (bomEntryInfo.getMaterial().getId().equals(bomInfo.getMaterial().getId())) {
///* 2370 */               batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "parent.Child.Material.IsEqual", new String[] { seqNo }));
/*      */
/*      */             }
/*      */ 
/* 2374 */             materialId = bomEntryInfo.getMaterial().getId().toString();
/*      */
/*      */ 
/* 2377 */             planInfo = (MaterialPlanInfo)planMap.get(orgId + "#" + materialId);
/* 2378 */             invInfo = (MaterialInventoryInfo)invMap.get(orgId + "#" + materialId);
/*      */
/*      */ 
/* 2381 */             if (null == planInfo) {
/* 2382 */               batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.MaterialPlanNone", new String[] { seqNo }));
/*      */
/*      */
/*      */             }
/*      */ 
/* 2387 */             if ((null == invInfo) && 
/*      */
/* 2389 */               (null != planInfo)) {
/* 2390 */               MaterialAttributeEnum materialAttributeEnum = planInfo.getMaterialAttr();
/* 2391 */               if (!(MaterialAttributeEnum.PHANTOMPART.equals(materialAttributeEnum))) {
/* 2392 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.MaterialInventoryNone", new String[] { seqNo }));
/*      */
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2399 */             if (MaterialProductEnum.MASTERPRODUCT.equals(bomEntryInfo.getOutputType())) {
/* 2400 */               batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.outPutType.noMaster", new String[] { seqNo }));
/*      */
/*      */
/*      */             }
/*      */ 
/* 2405 */             if (bomEntryInfo.getEffectiveDate() == null) {
/* 2406 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.effectiveDate_Required");
/* 2407 */               msg = msg.substring(0, msg.length() - 1);
/* 2408 */               batchResults.addError(bomId, seqRes + msg + nullRes);
/*      */
/*      */             }
/*      */ 
/* 2412 */             if (bomEntryInfo.getDisableDate() == null) {
/* 2413 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.disableDate_Required");
/* 2414 */               msg = msg.substring(0, msg.length() - 1);
/* 2415 */               batchResults.addError(bomId, seqRes + msg + nullRes);
/*      */
/*      */             }
/*      */ 
/* 2419 */             if ((bomEntryInfo.getEffectiveDate() != null) && (bomEntryInfo.getDisableDate() != null)) {
/* 2420 */               SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
/* 2421 */               Date disableDate = sdt.parse(sdt.format(bomEntryInfo.getDisableDate()));
/* 2422 */               Date effectiveDate = sdt.parse(sdt.format(bomEntryInfo.getEffectiveDate()));
/* 2423 */               if (effectiveDate.compareTo(disableDate) > 0) {
/* 2424 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.disableDate_mustbigthan_effectiveDate", new String[] { seqNo }));
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2430 */             if (ConsumeTypeEnum.VariableAmount.equals(bomEntryInfo.getConsumeType()))
/*      */             {
/* 2432 */               if (bomEntryInfo.getConsumeFixQty() == null) {
/* 2433 */                 msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.consumeFixQty_Required");
/*      */ 
/* 2435 */                 msg = msg.substring(0, msg.length() - 1);
/* 2436 */                 batchResults.addError(bomId, seqRes + msg + nullRes);
/* 2437 */               } else if (bomEntryInfo.getConsumeFixQty().floatValue() <= 0.0F) {
/* 2438 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.consumeFixQty_MustBigThan0", new String[] { seqNo }));
/*      */
/*      */
/*      */
/*      */
/*      */               }
/*      */ 
/* 2445 */               if (bomEntryInfo.getId() != null)
/*      */               {
/* 2447 */                 if (bomEntryInfo.getConsumeFixBaseQty() == null) {
/* 2448 */                   msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.consumeFixBaseQty_Required");
/*      */ 
/* 2450 */                   msg = msg.substring(0, msg.length() - 1);
/* 2451 */                   batchResults.addError(bomId, seqRes + msg + nullRes);
/* 2452 */                 } else if (bomEntryInfo.getConsumeFixBaseQty().floatValue() <= 0.0F) {
/* 2453 */                   batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.consumeFixBaseQty_MustBigThan0", new String[] { seqNo }));
/*      */                 }
/*      */ 
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2460 */             if (ConsumeTypeEnum.Proportion.equals(bomEntryInfo.getConsumeType())) {
/* 2461 */               if (bomEntryInfo.getProportion() == null) {
/* 2462 */                 msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.proportion_Required");
/*      */ 
/* 2464 */                 msg = msg.substring(0, msg.length() - 1);
/* 2465 */                 batchResults.addError(bomId, seqRes + msg + nullRes);
/* 2466 */               } else if (bomEntryInfo.getProportion().floatValue() <= 0.0F) {
/* 2467 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.proportion_MustBigThan0", new String[] { seqNo }));
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2473 */             if (bomEntryInfo.getOutputType() == null) {
/* 2474 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.outputtype_Require");
/*      */ 
/* 2476 */               msg = msg.substring(0, msg.length() - 1);
/* 2477 */               batchResults.addError(bomId, seqRes + msg + nullRes);
/*      */
/*      */             }
/*      */ 
/* 2481 */             if (bomEntryInfo.getScrapRatio() == null)
/*      */             {
/* 2483 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.scrapRatio_CannotBeNull");
/*      */ 
/* 2485 */               msg = msg.substring(0, msg.length() - 1);
/* 2486 */               batchResults.addError(bomId, seqRes + msg + nullRes);
/* 2487 */             } else if (bomEntryInfo.getScrapRatio().floatValue() == 100.0F)
/*      */             {
/* 2489 */               batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.scrapRatio_is100", new String[] { seqNo }));
/*      */
/*      */             }
/*      */ 
/* 2493 */             if (null == bomEntryInfo.getSupplyOrgUnit()) {
/* 2494 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.supplyOrgUnit_Required");
/*      */ 
/* 2496 */               msg = msg.substring(0, msg.length() - 1);
/* 2497 */               batchResults.addError(bomId, seqRes + msg + nullRes);
/*      */
/*      */             }
/*      */ 
/* 2501 */             if ((null == bomEntryInfo.getProvideType()) || (MaterialProvideTypeEnum.NONE.equals(bomEntryInfo.getProvideType())))
/*      */             {
/* 2503 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.provideType_Required");
/*      */ 
/* 2505 */               msg = msg.substring(0, msg.length() - 1);
/* 2506 */               batchResults.addError(bomId, seqRes + msg + nullRes);
/*      */             }
/*      */ 
/* 2509 */             if ((null != bomEntryInfo.getProvideType()) && (null != bomEntryInfo.getSupplyOrgUnit()) && (null != bomInfo.getStorageOrgUnit()))
/*      */
/*      */
/*      */             {
/* 2513 */               if ((MaterialProvideTypeEnum.CURRENTORGPROVIDE.equals(bomEntryInfo.getProvideType())) && 
/* 2514 */                 (!(bomEntryInfo.getSupplyOrgUnit().getId().toString().equals(bomInfo.getStorageOrgUnit().getId().toString()))))
/*      */               {
/* 2516 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.provideTypeIsCurrentSupplyOrgUnitCannotBeOther", new String[] { seqNo }));
/*      */
/*      */
/*      */
/*      */
/*      */               }
/*      */ 
/* 2523 */               if ((MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE.equals(bomEntryInfo.getProvideType())) && 
/* 2524 */                 (bomEntryInfo.getSupplyOrgUnit().getId().toString().equals(bomInfo.getStorageOrgUnit().getId().toString())))
/*      */               {
/* 2526 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.provideTypeIsOtherSupplyOrgUnitOnlyBeOther", new String[] { seqNo }));
/*      */
/*      */
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2534 */             if ((((MaterialProvideTypeEnum.CURRENTORGPROVIDE.equals(bomEntryInfo.getProvideType())) || (MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE.equals(bomEntryInfo.getProvideType())))) && 
/*      */
/* 2536 */               (bomEntryInfo.getDefaultWarehouse() != null) && (bomEntryInfo.getTransferWarehouse() != null)) {
/* 2537 */               String warehouseId1 = bomEntryInfo.getDefaultWarehouse().getId().toString();
/* 2538 */               String warehouseId2 = bomEntryInfo.getTransferWarehouse().getId().toString();
/* 2539 */               if (warehouseId1.equals(warehouseId2)) {
/* 2540 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.provideTypeIsCurrAndSpanWarehouseNotSame", new String[] { seqNo }));
/*      */
/*      */
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2548 */             if ((((MaterialProvideTypeEnum.SPANORGPROVIDE.equals(bomEntryInfo.getProvideType())) || (MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE.equals(bomEntryInfo.getProvideType())))) && 
/*      */
/* 2550 */               (MaterialIssueModeEnum.STRAIGHT.equals(bomEntryInfo.getIssMode()))) {
/* 2551 */               batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.provideTypeIsSpanIssueModeNotStraight", new String[] { seqNo }));
/*      */
/*      */
/*      */
/*      */             }
/*      */ 
/* 2557 */             if ((bomEntryInfo.isIsStockTransfer()) && 
/* 2558 */               (bomEntryInfo.getTransferOrgUnit() == null)) {
/* 2559 */               batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.transferOrgIsNotNull", new String[] { seqNo }));
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */             }
/*      */ 
/* 2572 */             if (bomEntryInfo.isIsBackFlush()) {
/* 2573 */               if (bomEntryInfo.getDefaultWarehouse() == null) {
/* 2574 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.backflushNeedDefaultWarehouse", new String[] { seqNo }));
/*      */               }
/* 2576 */               else if ((bomEntryInfo.getDefaultWarehouse().isHasLocation()) && (bomEntryInfo.getLocation() == null))
/*      */               {
/* 2578 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.backflushNeedLocation", new String[] { seqNo }));
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2584 */             if ((null != planInfo) && (BOMTypeEnum.MfgBOM.equals(bomInfo.getBomType())))
/*      */             {
/* 2586 */               if (MaterialAttributeEnum.SCHEDULEPART.equals(planInfo.getMaterialAttr())) {
/* 2587 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.cannotBeScheduleInMafBOM", new String[] { seqNo }));
/*      */
/*      */
/*      */               }
/*      */ 
/* 2592 */               if (planInfo.isIsConfigable()) {
/* 2593 */                 batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.cannotBeConfig", new String[] { seqNo }));
/*      */
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/* 2599 */             if ((null == materialId) || (null == map) || (!(map.containsKey(materialId))) || (bomEntryInfo.getConsumeType() != ConsumeTypeEnum.Proportion))
/*      */               continue;
/* 2601 */             batchResults.addError(bomId, ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "entrys.childbaseunitnotinsamegroupwithparent", new String[] { seqNo }));
/*      */           }
/*      */         }
/*      */       }
/*      */       catch (ParseException e) {
/* 2606 */         throw new BOSException(e);
/*      */
/*      */       }
/*      */ 
/* 2610 */       if ((bomInfo.getBomType() != BOMTypeEnum.OrderBOM) || 
/* 2611 */         (bomInfo.getMaterial() == null)) return;
/* 2612 */       String key = orgId + "#" + bomInfo.getMaterial().getId().toString();
/* 2613 */       MaterialPlanInfo planInfo = (MaterialPlanInfo)planMap.get(key);
/*      */ 
/* 2615 */       if ((planInfo != null) && (!(planInfo.isIsConfigable()))) {
/* 2616 */         MaterialInfo materialInfo = null;
/* 2617 */         MaterialPlanInfo entryPlanInfo = null;
/* 2618 */         for (int ii = 0; ii < bomEntryCollection.size(); ++ii) {
/* 2619 */           materialInfo = bomEntryCollection.get(ii).getMaterial();
/* 2620 */           if (materialInfo != null) {
/* 2621 */             key = orgId + "#" + materialInfo.getId().toString();
/* 2622 */             entryPlanInfo = (MaterialPlanInfo)planMap.get(key);
/* 2623 */             if ((entryPlanInfo != null) && (entryPlanInfo.isIsConfigable())) {
/* 2624 */               msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "orderbom_material_not_config");
/*      */ 
/* 2626 */               batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */ 
/* 2628 */               return;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBoms(Context ctx, BomCollection bomColls, BatchActionEnum batchAction, BatchActionResults batchResults)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 2651 */     boolean isFromList = isFromListUI(ctx);
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 2657 */     Map planMap = getMaterialPlanMap(ctx, bomColls);
/*      */
/*      */ 
/* 2660 */     Map invMap = getMaterialInvMap(ctx, bomColls);
/*      */ 
/* 2662 */     String msg = null;
/*      */ 
/* 2664 */     BomInfo bomInfo = null;
/* 2665 */     String bomId = null;
/*      */ 
/* 2667 */     BillBaseStatusEnum status = null;
/* 2668 */     boolean isCheck = false;
/* 2669 */     for (int i = 0; i < bomColls.size(); ++i) {
/* 2670 */       bomInfo = bomColls.get(i);
/*      */ 
/* 2672 */       if (bomInfo == null)
/*      */         continue;
/* 2674 */       bomId = getBomId(bomInfo);
/*      */ 
/* 2676 */       isCheck = false;
/* 2677 */       if (BatchActionEnum.SUBMIT.equals(batchAction))
/*      */
/*      */       {
/* 2680 */         status = bomInfo.getBaseStatus();
/* 2681 */         if ((BillBaseStatusEnum.ADD.equals(status)) || (BillBaseStatusEnum.TEMPORARILYSAVED.equals(status)) || (BillBaseStatusEnum.SUBMITED.equals(status)))
/*      */
/*      */         {
/* 2684 */           isCheck = true;
/*      */         }
/*      */         else
/*      */         {
/* 2688 */           msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "cannot_batchsubmit");
/* 2689 */           batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */         }
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 2696 */         isCheck = true;
/*      */
/*      */ 
/* 2699 */         if (isCheck) {
/* 2700 */           if ((BatchActionEnum.SUBMIT.equals(batchAction)) && 
/* 2701 */             (!(isFromList)))
/*      */
/*      */
/*      */           {
/* 2705 */             beforeSaveBom(ctx, bomInfo);
/*      */
/*      */
/*      */           }
/*      */ 
/* 2710 */           if (bomInfo.getStorageOrgUnit() == null) {
/* 2711 */             msg = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", "storageOrgUnit_Required");
/* 2712 */             batchResults.addError(bomId, new BomException(BomException.BLANKEXCEPTION, new String[] { msg }));
/*      */
/*      */
/*      */
/*      */           }
/*      */           else
/*      */           {
/* 2719 */             checkBomParent(ctx, bomInfo, planMap, invMap, batchResults);
/*      */
/*      */ 
/* 2722 */             checkBomEntry(ctx, bomInfo, planMap, invMap, batchResults);
/*      */
/*      */ 
/* 2725 */             checkMaterialduplicate(ctx, bomInfo, batchResults);
/*      */
/*      */ 
/* 2728 */             checkSubstituteMaterial(ctx, bomInfo, batchResults); }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */   private SelectorItemCollection getSelectors() {
/* 2735 */     SelectorItemCollection selector = new SelectorItemCollection();
/* 2736 */     selector.add(new SelectorItemInfo("*"));
/* 2737 */     selector.add(new SelectorItemInfo("entrys.*"));
/* 2738 */     selector.add(new SelectorItemInfo("unit.id"));
/* 2739 */     selector.add(new SelectorItemInfo("unit.name"));
/* 2740 */     selector.add(new SelectorItemInfo("unit.number"));
/* 2741 */     selector.add(new SelectorItemInfo("baseUnit.id"));
/* 2742 */     selector.add(new SelectorItemInfo("baseUnit.name"));
/* 2743 */     selector.add(new SelectorItemInfo("baseUnit.number"));
/* 2744 */     selector.add(new SelectorItemInfo("storageOrgUnit.id"));
/* 2745 */     selector.add(new SelectorItemInfo("storageOrgUnit.name"));
/* 2746 */     selector.add(new SelectorItemInfo("storageOrgUnit.number"));
/* 2747 */     selector.add(new SelectorItemInfo("material.*"));
/* 2748 */     selector.add(new SelectorItemInfo("materialPlan.*"));
/* 2749 */     selector.add(new SelectorItemInfo("entrys.material.*"));
/* 2750 */     selector.add(new SelectorItemInfo("entrys.materialInventory.*"));
/* 2751 */     selector.add(new SelectorItemInfo("orderBomTP.*"));
/* 2752 */     selector.add(new SelectorItemInfo("entrys.trackNumbers.*"));
/* 2753 */     selector.add(new SelectorItemInfo("entrys.trackNumbers.id"));
/* 2754 */     selector.add(new SelectorItemInfo("entrys.trackNumbers.FProjectID"));
/* 2755 */     selector.add(new SelectorItemInfo("entrys.trackNumbers.FTrackID"));
/* 2756 */     selector.add(new SelectorItemInfo("entrys.trackNumbers.FBomEntryId"));
/* 2757 */     selector.add(new SelectorItemInfo("entrys.trackNumbers.FBomID"));
/* 2758 */     selector.add(new SelectorItemInfo("entrys.defaultWarehouse.id"));
/* 2759 */     selector.add(new SelectorItemInfo("entrys.defaultWarehouse.name"));
/* 2760 */     selector.add(new SelectorItemInfo("entrys.defaultWarehouse.number"));
/*      */ 
/* 2762 */     selector.add(new SelectorItemInfo("entrys.defaultWarehouse.hasLocation"));
/*      */
/*      */ 
/* 2765 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.*"));
/*      */
/*      */ 
/* 2768 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.substituteUnit.id"));
/* 2769 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.substituteUnit.number"));
/* 2770 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.substituteUnit.name"));
/*      */
/*      */ 
/* 2773 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.substituteMaterial.id"));
/* 2774 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.substituteMaterial.number"));
/* 2775 */     selector.add(new SelectorItemInfo("entrys.substituteEntry.substituteMaterial.name"));
/*      */ 
/* 2777 */     return selector;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private BomCollection getBomCollectionByIdSet(Context ctx, Set set)
/*      */     throws BOSException
/*      */   {
/* 2791 */     EntityViewInfo view = new EntityViewInfo();
/* 2792 */     FilterInfo filter = new FilterInfo();
/* 2793 */     filter.getFilterItems().add(new FilterItemInfo("id", set, CompareType.INCLUDE));
/* 2794 */     view.setFilter(filter);
/*      */ 
/* 2796 */     SelectorItemCollection selector = getSelectors();
/* 2797 */     view.setSelector(selector);
/*      */ 
/* 2799 */     BomCollection bomColls = BomFactory.getLocalInstance(ctx).getBomCollection(view);
/* 2800 */     return bomColls;
/*      */   }
/*      */
/*      */   private Map getChildBaseConvertion2ParentBaseConvertion(Context ctx, String[] materialIds, String parentMaterialId) throws BOSException
/*      */   {
/* 2805 */     StringBuffer sb = new StringBuffer();
/* 2806 */     Map map = new HashMap();
/* 2807 */     if (materialIds.length == 0) {
/* 2808 */       return map;
/*      */     }
/* 2810 */     sb.append(" select childbasemeasureunit.childmaterialid childmaterialid, isnull(mu.fcoefficient,1)/isnull(parentbasemeasureunit.relativerate4base_parent,1) child2parentrate ");
/*      */ 
/* 2812 */     sb.append(" from ");
/* 2813 */     sb.append("     ( ");
/* 2814 */     sb.append("     select mmu_parent.fmeasureunitid basemeasureunit_parent ,mug.fid baseunitgroupid_parent ,mu.fcoefficient relativerate4base_parent ");
/*      */ 
/* 2816 */     sb.append("     from t_bd_multimeasureunit mmu_parent ,t_bd_measureunit mu, t_bd_measureunitgroup mug ");
/* 2817 */     sb.append("     where mmu_parent.fmaterialid = '").append(parentMaterialId).append("' and mmu_parent.fisbasicunit = 1 ");
/*      */ 
/* 2819 */     sb.append("     and mu.fgroupid = mug.fid ");
/* 2820 */     sb.append("     and mmu_parent.fmeasureunitid = mu.fid ");
/* 2821 */     sb.append("     ) parentbasemeasureunit, ");
/* 2822 */     sb.append("     ( ");
/* 2823 */     sb.append("     select mmu_child.fmeasureunitid basemeasureunit_child ,mmu_child.fmaterialid childmaterialid ");
/* 2824 */     sb.append("     from t_bd_multimeasureunit mmu_child  ");
/* 2825 */     sb.append("     where mmu_child.fmaterialid in (").append(arrayToStringWithSingleQuotes(materialIds)).append(") and mmu_child.fisbasicunit = 1  ");
/*      */ 
/* 2827 */     sb.append("     ) childbasemeasureunit, ");
/* 2828 */     sb.append("     t_bd_measureunit mu, t_bd_measureunitgroup mug ");
/* 2829 */     sb.append(" where childBasemeasureunit.basemeasureunit_child = mu.fid ");
/* 2830 */     sb.append(" and mu.fgroupid = mug.fid ");
/* 2831 */     sb.append(" and mug.fid = parentbasemeasureunit.baseunitgroupid_parent ");
/*      */     try {
/* 2833 */       IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
/* 2834 */       String str = null;
/* 2835 */       BigDecimal dec = null;
/* 2836 */       while (rs.next()) {
/* 2837 */         str = rs.getString("childmaterialid");
/* 2838 */         dec = rs.getBigDecimal("child2parentrate");
/* 2839 */         map.put(str, dec);
/*      */       }
/*      */     } catch (Exception e) {
/* 2842 */       throw new BOSException(e);
/*      */     }
/* 2844 */     return map;
/*      */   }
/*      */
/*      */   private Map getChildMaterialIdNoSameGroupWithParent(Context ctx, String[] materialIds, String parentMaterialId) throws BOSException
/*      */   {
/* 2849 */     StringBuffer sb = new StringBuffer();
/* 2850 */     Map map = new HashMap();
/* 2851 */     if (materialIds.length == 0) {
/* 2852 */       return map;
/*      */     }
/* 2854 */     sb.append("  select mmu.fmaterialid materialid,mug.fid materialgroupid ");
/* 2855 */     sb.append("  from t_bd_measureunit mu,  t_bd_measureunitgroup mug, t_bd_multimeasureunit mmu ");
/* 2856 */     sb.append("  where mu.fgroupid = mug.fid and mmu.fmeasureunitid = mu.fid and mmu.fisbasicunit = 1 ");
/* 2857 */     sb.append("  and mmu.fmaterialid in ( ");
/* 2858 */     sb.append(arrayToStringWithSingleQuotes(materialIds));
/* 2859 */     sb.append("  ) ");
/* 2860 */     sb.append("  and mug.fid != ( ");
/* 2861 */     sb.append("    select mug.fid ");
/* 2862 */     sb.append("    from t_bd_measureunit mu, t_bd_measureunitgroup mug,t_bd_multimeasureunit mmu ");
/* 2863 */     sb.append("    where mu.fgroupid = mug.fid and mmu.fmeasureunitid = mu.fid and mmu.fisbasicunit = 1 ");
/* 2864 */     sb.append("    and mmu.fmaterialid = '").append(parentMaterialId).append("' ) ");
/*      */     try {
/* 2866 */       IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
/* 2867 */       String str = null;
/* 2868 */       while (rs.next()) {
/* 2869 */         str = rs.getString("materialid");
/* 2870 */         map.put(str, null);
/*      */       }
/*      */     } catch (Exception e) {
/* 2873 */       throw new BOSException(e);
/*      */     }
/* 2875 */     return map;
/*      */   }
/*      */
/*      */   private String arrayToStringWithSingleQuotes(String[] bomIDs)
/*      */   {
/* 2880 */     StringBuffer ret = new StringBuffer();
/* 2881 */     for (int i = 0; i < bomIDs.length; ++i)
/* 2882 */       ret.append("'").append(bomIDs[i]).append("',");
/* 2883 */     return ret.deleteCharAt(ret.length() - 1).toString();
/*      */   }
/*      */   private BomInfo setBomConvRatesByMaterial(Context ctx, BomInfo bomInfo)/*      */     throws BOSException, EASBizException/*      */   {/*      */     String materialId;/*      */     String measureUnitId;
/*      */     Iterator ite;
/* 2887 */     if ((bomInfo.getMaterial() != null) && (bomInfo.getUnit() != null)) {
/* 2888 */       materialId = bomInfo.getMaterial().getId().toString();
/* 2889 */       measureUnitId = bomInfo.getUnit().getId().toString();
/* 2890 */       BomEntryCollection bomEntryCollection = bomInfo.getEntrys();
/* 2891 */       if ((bomEntryCollection != null) && (bomEntryCollection.size() > 0)) {
/* 2892 */         for (ite = bomEntryCollection.iterator(); ite.hasNext(); ) {
/* 2893 */           BomEntryInfo bomEntryInfo = (BomEntryInfo)ite.next();
/*      */ 
/* 2895 */           if ((bomEntryInfo.getMaterial() != null) && (bomEntryInfo.getUnit() != null)) {
/* 2896 */             String childMaterialUnitId = bomEntryInfo.getUnit().getId().toString();
/* 2897 */             BigDecimal productRate = SCMUtils.getExchangeQtyForServer(ctx, materialId, measureUnitId, new BigDecimal("1.0"), childMaterialUnitId);
/*      */ 
/* 2899 */             if (productRate != null)
/* 2900 */               bomEntryInfo.setProductRate(productRate);
/*      */             else {
/* 2902 */               bomEntryInfo.setProductRate(new BigDecimal("1.0"));
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 2909 */     return bomInfo;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private BomInfo setBomBaseConvRatesByMaterial(Context ctx, BomInfo bomInfo)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 2931 */     BomEntryCollection bomEntryCollection = bomInfo.getEntrys();
/* 2932 */     List materialIdListForPropertion = new ArrayList();
/* 2933 */     if ((bomEntryCollection != null) && (bomEntryCollection.size() > 0)) {
/* 2934 */       Iterator it = bomEntryCollection.iterator();
/* 2935 */       MaterialInfo material = null;
/* 2936 */       while (it.hasNext()) {
/* 2937 */         BomEntryInfo bomEntryInfo = (BomEntryInfo)it.next();
/*      */ 
/* 2939 */         material = bomEntryInfo.getMaterial();
/* 2940 */         if (material == null) continue; if (material.getId() == null) {
/*      */           continue;
/*      */         }
/* 2943 */         if (ConsumeTypeEnum.Proportion.equals(bomEntryInfo.getConsumeType())) {
/* 2944 */           materialIdListForPropertion.add(material.getId().toString());
/*      */         }
/*      */       }
/* 2947 */       if ((null != bomInfo.getMaterial()) && (null != bomInfo.getMaterial().getId()) && (!("".equals(bomInfo.getMaterial().getId().toString()))))
/*      */       {
/* 2949 */         Map map = null;
/* 2950 */         if (!(materialIdListForPropertion.isEmpty())) {
/* 2951 */           String parentMaterialId = bomInfo.getMaterial().getId().toString();
/* 2952 */           map = getChildBaseConvertion2ParentBaseConvertion(ctx, (String[])(String[])materialIdListForPropertion.toArray(new String[0]), parentMaterialId);
/*      */         }
/*      */ 
/* 2955 */         if ((null != map) && (!(map.isEmpty()))) {
/* 2956 */           BomEntryInfo tmp = null;
/* 2957 */           BigDecimal tmpBd = null;
/* 2958 */           for (int k = 0; k < bomEntryCollection.size(); ++k) {
/* 2959 */             tmp = bomEntryCollection.get(k);
/* 2960 */             if (null != tmp.getMaterial()) {
/* 2961 */               if (map.containsKey(tmp.getMaterial().getId().toString())) {
/* 2962 */                 tmpBd = (BigDecimal)map.get(tmp.getMaterial().getId().toString());
/*      */ 
/* 2964 */                 if ((tmpBd == null) || (tmpBd.compareTo(MMConstant.BIGDECIMAL_ZERO) == 0)) {
/* 2965 */                   tmpBd = new BigDecimal("1.00");
/*      */                 }
/* 2967 */                 tmp.setBaseProductRate(tmpBd);
/*      */               } else {
/* 2969 */                 tmp.setBaseProductRate(new BigDecimal("1.00"));
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2976 */     return bomInfo;
/*      */   }
/*      */
/*      */   private BomInfo setBomBaseQty(Context ctx, BomInfo bomInfo) throws BOSException, EASBizException {
/* 2980 */     if (bomInfo == null) {
/* 2981 */       return null;
/*      */
/*      */
/*      */     }
/*      */ 
/* 2986 */     Set materialSet = new HashSet();
/* 2987 */     Map multiUnitMap = new HashMap();
/* 2988 */     if (bomInfo.getMaterial() != null) {
/* 2989 */       materialSet.add(bomInfo.getMaterial().getId().toString());
/*      */     }
/* 2991 */     BomEntryCollection bec = bomInfo.getEntrys();
/* 2992 */     if ((null != bec) && (bec.size() > 0)) {
/* 2993 */       Iterator it1 = bec.iterator();
/* 2994 */       while (it1.hasNext()) {
/* 2995 */         BomEntryInfo bomEntryInfo = (BomEntryInfo)it1.next();
/* 2996 */         if (bomEntryInfo.getMaterial() != null) {
/* 2997 */           materialSet.add(bomEntryInfo.getMaterial().getId().toString());
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 3002 */     if (!(materialSet.isEmpty())) {
/* 3003 */       EntityViewInfo viewInfo = new EntityViewInfo();
/* 3004 */       SelectorItemCollection sic = new SelectorItemCollection();
/* 3005 */       sic.add("material.id");
/* 3006 */       sic.add("measureUnit.id");
/* 3007 */       sic.add("baseConvsRate");
/* 3008 */       sic.add("qtyPrecision");
/* 3009 */       FilterInfo filterInfo = new FilterInfo();
/* 3010 */       filterInfo.getFilterItems().add(new FilterItemInfo("material.id", materialSet, CompareType.INCLUDE));
/* 3011 */       viewInfo.setFilter(filterInfo);
/* 3012 */       viewInfo.setSelector(sic);
/* 3013 */       IMultiMeasureUnit multiUnit = MultiMeasureUnitFactory.getLocalInstance(ctx);
/* 3014 */       MultiMeasureUnitCollection mltmuc = multiUnit.getMultiMeasureUnitCollection(viewInfo);
/*      */ 
/* 3016 */       String tmpKey = null;
/* 3017 */       for (int i = 0; i < mltmuc.size(); ++i) {
/* 3018 */         tmpKey = mltmuc.get(i).getMaterial().getId().toString() + mltmuc.get(i).getMeasureUnit().getId().toString();
/*      */ 
/* 3020 */         multiUnitMap.put(tmpKey, mltmuc.get(i));
/*      */       }
/*      */ 
/* 3023 */       BigDecimal bigQty = bomInfo.getProductQty();
/*      */
/*      */
/*      */ 
/* 3027 */       if (bomInfo.getUnit().getId().toString().equals(bomInfo.getBaseUnit().getId().toString())) {
/* 3028 */         bomInfo.setProductBaseQty(bigQty);
/*      */       }
/* 3030 */       else if ((bomInfo.getMaterial() != null) && (bigQty != null)) {
/* 3031 */         String strMatId = bomInfo.getMaterial().getId().toString();
/* 3032 */         BigDecimal bigBaseQty = getExchangePrecisionQtyForServer(ctx, strMatId, bomInfo.getUnit(), bomInfo.getBaseUnit(), bigQty, multiUnitMap);
/*      */ 
/* 3034 */         if (bigBaseQty == null) {
/* 3035 */           bigBaseQty = bigQty;
/*      */         }
/* 3037 */         bomInfo.setProductBaseQty(bigBaseQty);
/*      */
/*      */       }
/*      */ 
/* 3041 */       BomEntryCollection entrys = bomInfo.getEntrys();
/* 3042 */       for (int i = 0; i < entrys.size(); ++i) {
/* 3043 */         BomEntryInfo entryInfo = entrys.get(i);
/* 3044 */         if (entryInfo.getMaterial() != null) {
/* 3045 */           if (entryInfo.getConsumeType().equals(ConsumeTypeEnum.Proportion)) {
/* 3046 */             bigQty = entryInfo.getProportion();
/* 3047 */             if (bigQty == null) {
/*      */               continue;
/*      */             }
/* 3050 */             if (entryInfo.getUnit().getId().toString().equals(entryInfo.getBaseUnit().getId().toString()))
/*      */             {
/* 3052 */               entryInfo.setBaseProportion(bigQty);
/*      */             } else {
/* 3054 */               String strMatId = entryInfo.getMaterial().getId().toString();
/* 3055 */               BigDecimal bigBaseQty = getExchangePrecisionQtyForServer(ctx, strMatId, entryInfo.getUnit(), entryInfo.getBaseUnit(), bigQty, multiUnitMap);
/*      */ 
/* 3057 */               bigBaseQty = bigQty;
/* 3058 */               entryInfo.setBaseProportion(bigBaseQty);
/*      */             }
/*      */           }
/*      */           else {
/* 3062 */             bigQty = entryInfo.getConsumeFixQty();
/* 3063 */             if (bigQty == null) {
/*      */               continue;
/*      */             }
/* 3066 */             if (entryInfo.getUnit().getId().toString().equals(entryInfo.getBaseUnit().getId().toString()))
/*      */             {
/* 3068 */               entryInfo.setConsumeFixBaseQty(bigQty);
/*      */             } else {
/* 3070 */               String strMatId = entryInfo.getMaterial().getId().toString();
/* 3071 */               BigDecimal bigBaseQty = getExchangePrecisionQtyForServer(ctx, strMatId, entryInfo.getUnit(), entryInfo.getBaseUnit(), bigQty, multiUnitMap);
/*      */
/*      */ 
/* 3074 */               entryInfo.setConsumeFixBaseQty(bigBaseQty);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3082 */     return bomInfo;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private BigDecimal getExchangePrecisionQtyForServer(Context ctx, String materialID, MeasureUnitInfo unitInfo, MeasureUnitInfo otherUnitInfo, BigDecimal qty, Map multiUnitMap)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 3100 */     if (materialID == null) {
/* 3101 */       throw new IllegalArgumentException();
/*      */     }
/* 3103 */     BigDecimal targetQty = null;
/* 3104 */     MultiMeasureUnitInfo multiUnifInfo = (MultiMeasureUnitInfo)multiUnitMap.get(materialID + unitInfo.getId().toString());
/*      */ 
/* 3106 */     MultiMeasureUnitInfo othermultiUnifInfo = (MultiMeasureUnitInfo)multiUnitMap.get(materialID + otherUnitInfo.getId().toString());
/*      */ 
/* 3108 */     if ((multiUnifInfo != null) && (othermultiUnifInfo != null)) {
/* 3109 */       BigDecimal baseExchangeRate1 = multiUnifInfo.getBaseConvsRate();
/* 3110 */       BigDecimal baseExchangeRate2 = othermultiUnifInfo.getBaseConvsRate();
/*      */ 
/* 3112 */       if (baseExchangeRate1 == null) {
/* 3113 */         baseExchangeRate1 = new BigDecimal("1.00");
/*      */       }
/* 3115 */       if (baseExchangeRate2 == null) {
/* 3116 */         baseExchangeRate2 = new BigDecimal("1.00");
/*      */       }
/* 3118 */       BigDecimal baseQty = qty.multiply(baseExchangeRate1);
/* 3119 */       targetQty = baseQty.divide(baseExchangeRate2, othermultiUnifInfo.getQtyPrecision(), 4);
/*      */     }
/*      */ 
/* 3122 */     return targetQty;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void updateSubstituteMaterialOtherQty(Context ctx, String pk)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 3132 */     StringBuffer sb = new StringBuffer();
/*      */ 
/* 3134 */     sb.append("UPDATE T_MM_BOMSUBSTITUTE AS BS SET (FTOBASEUNITQTY,FTOBASEUNITRATE) = ");
/* 3135 */     sb.append("( ");
/* 3136 */     sb.append("SELECT ROUND(BOMSUBSTITUTE.FSUBSTITUTEQTY * MU.FBASECONVSRATE,MU.FQTYPRECISION) AS TOBASEUNITQTY, ");
/* 3137 */     sb.append("MU.FBASECONVSRATE AS TOBASEUNITRATE ");
/* 3138 */     sb.append("FROM T_MM_BOM AS BOM,T_MM_BOMENTRY AS BOMENTRY,T_MM_BOMSUBSTITUTE AS BOMSUBSTITUTE,T_BD_MULTIMEASUREUNIT AS MU ");
/*      */ 
/* 3140 */     sb.append("WHERE BOM.FID = BOMENTRY.FPARENTID AND BOMENTRY.FID = BOMSUBSTITUTE.FPARENTID ");
/* 3141 */     sb.append("AND BOMSUBSTITUTE.FSUBSTITUTEUNITID = MU.FMEASUREUNITID  AND BOMSUBSTITUTE.FSUBSTITUTEMATERIALID = MU.FMATERIALID ");
/*      */
/*      */
/*      */ 
/* 3145 */     sb.append("AND BOM.FID = ? AND BS.FID = BOMSUBSTITUTE.FID ");
/* 3146 */     sb.append(") ");
/* 3147 */     DbUtil.execute(ctx, sb.toString(), new Object[] { pk });
/*      */ 
/* 3149 */     sb.setLength(0);
/* 3150 */     sb.append("UPDATE T_MM_BOMSUBSTITUTE AS BS SET (FTOPARENTBASEUNITRATE) = ");
/* 3151 */     sb.append("   (");
/* 3152 */     sb.append("   SELECT ");
/* 3153 */     sb.append("          ISNULL(MU.FCOEFFICIENT,1)/ISNULL(PARENTBASEMEASUREUNIT.RELATIVERATE4BASE_PARENT,1) ");
/* 3154 */     sb.append("   FROM");
/* 3155 */     sb.append("     ( ");
/* 3156 */     sb.append("     SELECT MMU_PARENT.FMEASUREUNITID AS BASEMEASUREUNIT_PARENT,MUG.FID BASEUNITGROUPID_PARENT, ");
/* 3157 */     sb.append("            MU.FCOEFFICIENT AS RELATIVERATE4BASE_PARENT,BOMENTRY.FID AS BOMENTRYID ");
/* 3158 */     sb.append("     FROM T_BD_MULTIMEASUREUNIT AS MMU_PARENT,T_BD_MEASUREUNIT AS MU,T_BD_MEASUREUNITGROUP AS MUG, ");
/*      */ 
/* 3160 */     sb.append("          T_MM_BOM AS BOM,T_MM_BOMENTRY AS BOMENTRY ");
/* 3161 */     sb.append("     WHERE BOM.FID = ? AND BOM.FID = BOMENTRY.FPARENTID ");
/* 3162 */     sb.append("           AND MMU_PARENT.FMATERIALID = BOMENTRY.FMATERIALID AND MMU_PARENT.FISBASICUNIT = 1");
/* 3163 */     sb.append("           AND MU.FGROUPID = MUG.FID AND MMU_PARENT.FMEASUREUNITID = MU.FID ");
/* 3164 */     sb.append("     ) AS PARENTBASEMEASUREUNIT, ");
/* 3165 */     sb.append("     ( ");
/* 3166 */     sb.append("     SELECT MMU_CHILD.FMEASUREUNITID AS BASEMEASUREUNIT_CHILD,MMU_CHILD.FMATERIALID AS CHILDMATERIALID, ");
/*      */ 
/* 3168 */     sb.append("            BOMSUBSTITUTE.FID AS BOMSUBSTITUTEID,BOMENTRY.FID AS BOMENTRYID ");
/* 3169 */     sb.append("     FROM T_BD_MULTIMEASUREUNIT AS MMU_CHILD, T_MM_BOM AS BOM,T_MM_BOMENTRY AS BOMENTRY,T_MM_BOMSUBSTITUTE AS BOMSUBSTITUTE ");
/*      */ 
/* 3171 */     sb.append("     WHERE BOM.FID = ? AND BOM.FID = BOMENTRY.FPARENTID AND BOMENTRY.FID = BOMSUBSTITUTE.FPARENTID ");
/*      */ 
/* 3173 */     sb.append("           AND MMU_CHILD.FMATERIALID = BOMSUBSTITUTE.FSUBSTITUTEMATERIALID AND MMU_CHILD.FISBASICUNIT = 1 ");
/*      */ 
/* 3175 */     sb.append("           AND BOMSUBSTITUTE.FISSUBSTITUTEQTY = 0 ");
/* 3176 */     sb.append("     ) AS CHILDBASEMEASUREUNIT, ");
/* 3177 */     sb.append("     T_BD_MEASUREUNIT AS MU,T_BD_MEASUREUNITGROUP AS MUG ");
/* 3178 */     sb.append("   WHERE CHILDBASEMEASUREUNIT.BASEMEASUREUNIT_CHILD = MU.FID AND MU.FGROUPID = MUG.FID ");
/* 3179 */     sb.append("         AND MUG.FID = PARENTBASEMEASUREUNIT.BASEUNITGROUPID_PARENT ");
/* 3180 */     sb.append("         AND PARENTBASEMEASUREUNIT.BOMENTRYID = CHILDBASEMEASUREUNIT.BOMENTRYID ");
/* 3181 */     sb.append("         AND CHILDBASEMEASUREUNIT.BOMSUBSTITUTEID = BS.FID ");
/* 3182 */     sb.append("   )");
/* 3183 */     DbUtil.execute(ctx, sb.toString(), new Object[] { pk, pk });
/*      */ 
/* 3185 */     sb.setLength(0);
/* 3186 */     sb.append("UPDATE T_MM_BOMSUBSTITUTE AS BS SET (FCOMPUTEDQTY) =  ");
/* 3187 */     sb.append("(");
/* 3188 */     sb.append("SELECT ");
/* 3189 */     sb.append("CASE WHEN BOMSUBSTITUTE.FISSUBSTITUTEQTY = 1 THEN BOMSUBSTITUTE.FSUBSTITUTEQTY ");
/* 3190 */     sb.append("ELSE ROUND(TO_NUMBER(BOMSUBSTITUTE.FSUBSTITUTEPROPORTION*0.01)/TO_NUMBER(BOMSUBSTITUTE.FTOPARENTBASEUNITRATE) / BOMSUBSTITUTE.FTOBASEUNITRATE*BOMENTRY.FBASERATE ,MU.FQTYPRECISION) ");
/*      */ 
/* 3192 */     sb.append("END ");
/* 3193 */     sb.append("FROM T_MM_BOM AS BOM,T_MM_BOMENTRY AS BOMENTRY,T_MM_BOMSUBSTITUTE AS BOMSUBSTITUTE,T_BD_MULTIMEASUREUNIT AS MU ");
/*      */ 
/* 3195 */     sb.append("WHERE BOM.FID = BOMENTRY.FPARENTID AND BOMENTRY.FID = BOMSUBSTITUTE.FPARENTID ");
/* 3196 */     sb.append("AND BOMSUBSTITUTE.FSUBSTITUTEUNITID = MU.FMEASUREUNITID  AND BOMSUBSTITUTE.FSUBSTITUTEMATERIALID = MU.FMATERIALID ");
/*      */ 
/* 3198 */     sb.append("AND BOM.FID = ? AND BS.FID = BOMSUBSTITUTE.FID ");
/* 3199 */     sb.append(") ");
/* 3200 */     DbUtil.execute(ctx, sb.toString(), new Object[] { pk });
/*      */   }
/*      */
/*      */   public void updateEntryBaseRate(Context ctx, String bomId)
/*      */     throws BOSException, EASBizException
/*      */   {
/*      */     try
/*      */     {
/* 3208 */       StringBuffer sql = new StringBuffer();
/*      */ 
/* 3210 */       sql.append("update t_mm_bomentry as bomentry set (fbaserate) = ");
/* 3211 */       sql.append(" ( ");
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 3217 */       sql.append(" select 1/isnull(m.fbaseConvsRate,1) ");
/* 3218 */       sql.append(" FROM T_BD_MULTIMEASUREUNIT as m ");
/* 3219 */       sql.append(" INNER JOIN T_MM_BOMENTRY as e ON e.FUNITID = m.fmeasureUnitId ");
/* 3220 */       sql.append(" \t\t\t\t\t          and e.fmaterialId = m.fmaterialId ");
/* 3221 */       sql.append(" where e.fid = bomentry.fid ");
/* 3222 */       sql.append("   and bomentry.fparentid = ? ");
/* 3223 */       sql.append(" and bomentry.fid = e.fid ");
/* 3224 */       sql.append(" ) ");
/* 3225 */       DbUtil.execute(ctx, sql.toString(), new Object[] { bomId });
/*      */     } catch (Exception e) {
/* 3227 */       logger.error("error in updateEntryBaseRate: ", e);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String createTempTable(Context ctx, String createTableSQL)
/*      */     throws Exception
/*      */   {
/* 3241 */     TempTablePool pool = TempTablePool.getInstance(ctx);
/* 3242 */     return pool.createTempTable(createTableSQL);
/*      */   }
/*      */
/*      */   private void releaseTempTable(Context ctx, String tableName) {
/* 3246 */     if (MMUtils.isEmptyString(tableName)) {
/* 3247 */       return;
/*      */     }
/* 3249 */     TempTablePool pool = TempTablePool.getInstance(ctx);
/* 3250 */     pool.releaseTable(tableName);
/*      */   }
/*      */
/*      */   private void fillBOMInfoForImportData(Context ctx, BomInfo bomInfo)
/*      */     throws BOSException, BomException
/*      */   {
/* 3256 */     Set materialIdSet = new HashSet();
/* 3257 */     if (bomInfo.getMaterial() != null) {
/* 3258 */       materialIdSet.add(bomInfo.getMaterial().getId().toString());
/*      */     }
/* 3260 */     BomEntryCollection bomEntryCollection = bomInfo.getEntrys();
/*      */     Iterator ite;/* 3261 */     if ((bomEntryCollection != null) && (bomEntryCollection.size() > 0)) {
/* 3262 */       for (ite = bomEntryCollection.iterator(); ite.hasNext(); ) {
/* 3263 */         BomEntryInfo bomEntryInfo = (BomEntryInfo)ite.next();
/* 3264 */         if (bomEntryInfo.getMaterial() != null) {
/* 3265 */           materialIdSet.add(bomEntryInfo.getMaterial().getId().toString());
/*      */         }
/*      */       }
/*      */     }
/* 3269 */     if (materialIdSet.isEmpty()) {
/* 3270 */       return;
/*      */     }
/*      */ 
/* 3273 */     IMultiMeasureUnit multiMeasureUnit = MultiMeasureUnitFactory.getLocalInstance(ctx);
/* 3274 */     EntityViewInfo view = new EntityViewInfo();
/* 3275 */     SelectorItemCollection sic = new SelectorItemCollection();
/* 3276 */     sic.add(new SelectorItemInfo("*"));
/* 3277 */     sic.add(new SelectorItemInfo("measureUnit.*"));
/* 3278 */     sic.add(new SelectorItemInfo("material.id"));
/* 3279 */     view.setSelector(sic);
/* 3280 */     FilterInfo fi = new FilterInfo();
/* 3281 */     fi.getFilterItems().add(new FilterItemInfo("material.id", materialIdSet, CompareType.INCLUDE));
/* 3282 */     fi.getFilterItems().add(new FilterItemInfo("isBasicUnit", Boolean.TRUE, CompareType.EQUALS));
/* 3283 */     view.setFilter(fi);
/* 3284 */     MultiMeasureUnitCollection multiMeasureUnits = multiMeasureUnit.getMultiMeasureUnitCollection(view);
/*      */ 
/* 3286 */     Map map = new HashMap();
/* 3287 */     int j = 0; for (int count = multiMeasureUnits.size(); j < count; ++j) {
/* 3288 */       map.put(multiMeasureUnits.get(j).getMaterial().getId().toString(), multiMeasureUnits.get(j).getMeasureUnit());
/*      */     }
/*      */ 
/* 3291 */     if (bomInfo.getMaterial() != null) {
/* 3292 */       bomInfo.setBaseUnit((MeasureUnitInfo)map.get(bomInfo.getMaterial().getId().toString()));
/*      */     }
/* 3294 */     for (ite = bomEntryCollection.iterator(); ite.hasNext(); ) {
/* 3295 */       BomEntryInfo bomEntryInfo = (BomEntryInfo)ite.next();
/* 3296 */       if (bomEntryInfo.getMaterial() != null)
/* 3297 */         bomEntryInfo.setBaseUnit((MeasureUnitInfo)map.get(bomEntryInfo.getMaterial().getId().toString()));
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void deleteOrderBomPt(Context ctx, BomInfo bomInfo)
/*      */     throws BOSException
/*      */   {
/* 3314 */     String bomId = bomInfo.getId().toString();
/* 3315 */     StringBuffer sb = new StringBuffer();
/* 3316 */     sb.append(" delete from t_mm_orderbompt where forderId = ? ");
/* 3317 */     int executeNum = 0;
/* 3318 */     executeNum += SQLUtils.execute(ctx, sb.toString(), new Object[] { bomId });
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void deleteCfgBomPt(Context ctx, BomInfo bomInfo)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 3332 */     String bomId = bomInfo.getId().toString();
/*      */ 
/* 3334 */     StringBuffer sb = new StringBuffer();
/* 3335 */     sb.append(" delete from T_MM_BOMPT ");
/* 3336 */     sb.append(" where exists (");
/* 3337 */     sb.append("     select e.fid ");
/* 3338 */     sb.append("     from t_mm_bomentry as e ");
/* 3339 */     sb.append("     where e.fparentId = ? ");
/* 3340 */     sb.append("       and e.fid = T_MM_BOMPT.fbomentryId ");
/* 3341 */     sb.append("    )");
/* 3342 */     int executeNum = 0;
/* 3343 */     executeNum += SQLUtils.execute(ctx, sb.toString(), new Object[] { bomId });
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void deleteBomPt(Context ctx, BomInfo bomInfo)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 3357 */     Object obj = ctx.get("isFromList");
/*      */ 
/* 3359 */     if ((obj != null) && (Boolean.valueOf(obj.toString()).booleanValue())) {
/* 3360 */       return;
/*      */     }
/* 3362 */     if ((bomInfo.getId() == null) || (bomInfo.getId().toString().equals("NEWID"))) {
/* 3363 */       return;
/*      */     }
/* 3365 */     BOMTypeEnum bomType = bomInfo.getBomType();
/* 3366 */     if (BOMTypeEnum.OrderBOM.equals(bomType)) {
/* 3367 */       deleteOrderBomPt(ctx, bomInfo);
/*      */     }
/* 3369 */     else if (BOMTypeEnum.CfgBOM.equals(bomType))
/* 3370 */       deleteCfgBomPt(ctx, bomInfo);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setDefaultValue(BomInfo bomInfo)
/*      */   {
/* 3384 */     BigDecimal zeroBigDecimal = new BigDecimal("0");
/* 3385 */     BomEntryCollection entryColl = bomInfo.getEntrys();
/* 3386 */     BomEntryInfo entryInfo = null;
/* 3387 */     for (int i = 0; i < entryColl.size(); ++i) {
/* 3388 */       entryInfo = entryColl.get(i);
/* 3389 */       if (entryInfo == null) {
/*      */         continue;
/*      */       }
/* 3392 */       if (entryInfo.getConsumeFixBaseQty() == null) {
/* 3393 */         entryInfo.setConsumeFixBaseQty(zeroBigDecimal);
/*      */       }
/* 3395 */       if (entryInfo.getNetWeight() == null)
/* 3396 */         entryInfo.setNetWeight(zeroBigDecimal);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */   public int converDateToInt(Date date)
/*      */   {
/* 3403 */     int rst = 0;
/*      */     try {
/* 3405 */       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 3406 */       String str = df.format(date);
/* 3407 */       str = str.replaceAll("-", "");
/* 3408 */       rst = Integer.parseInt(str);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */     }
/*      */ 
/* 3414 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public static String getResource(Context ctx, String resourceName)
/*      */   {
/* 3425 */     String strTemp = ResourceBase.getString("com.kingdee.eas.mm.basedata.BOMResource", resourceName, ctx.getLocale());
/*      */ 
/* 3427 */     if (strTemp.equals("Missing Resource")) {
/* 3428 */       return "Missing Resource{" + resourceName + "}";
/*      */     }
/* 3430 */     return strTemp;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getResource(String key)
/*      */   {
/* 3443 */     String rst = ResourceUtils.getMessageForServer("com.kingdee.eas.mm.basedata.BOMResource", key);
/* 3444 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getMessage(Context ctx, String key, String[] parameters)
/*      */   {
/* 3457 */     String message = getResource(ctx, key);
/* 3458 */     StringBuffer sb = new StringBuffer();
/*      */ 
/* 3460 */     for (int i = 0; i < parameters.length; ++i) {
/* 3461 */       sb.setLength(0);
/* 3462 */       message = message.replaceAll(sb.append("\\{").append(i).append("\\}").toString(), parameters[i]);
/*      */
/*      */     }
/*      */ 
/* 3466 */     return message;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getBomId(BomInfo bomInfo)
/*      */   {
/* 3478 */     BOSUuid bosUuid = bomInfo.getId();
/* 3479 */     if (bosUuid == null) {
/* 3480 */       return "NEWID";
/*      */     }
/* 3482 */     return bosUuid.toString();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkSave(Context ctx, BomInfo bomInfo)
/*      */     throws EASBizException
/*      */   {
/* 3495 */     BillBaseStatusEnum status = bomInfo.getBaseStatus();
/*      */ 
/* 3497 */     if (BillBaseStatusEnum.SUBMITED.equals(status))
/* 3498 */       throw new PlanOrderException(PlanOrderException.SUBMITED_SAVE_INFORMATION);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean isFromListUI(Context ctx)
/*      */   {
/* 3511 */     Object paramObj = ctx.get("isFromList");
/* 3512 */     boolean isFromList = false;
/* 3513 */     if (paramObj == null) {
/* 3514 */       return isFromList;
/*      */     }
/* 3516 */     Boolean paramBoolean = Boolean.valueOf(paramObj.toString());
/* 3517 */     if (paramBoolean.booleanValue()) {
/* 3518 */       isFromList = true;
/*      */     }
/* 3520 */     return isFromList;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String createBomAuditCheckTable(Context ctx)
/*      */     throws BOSException
/*      */   {
/* 3532 */     StringBuffer sql = new StringBuffer();
/* 3533 */     sql.append("CREATE TABLE CHECKBOM (");
/*      */ 
/* 3535 */     sql.append("FSTORAGEORGUNITID VARCHAR(44), ");
/*      */ 
/* 3537 */     sql.append("FID VARCHAR(44), ");
/*      */ 
/* 3539 */     sql.append("FNUMBER NVARCHAR(80), ");
/*      */ 
/* 3541 */     sql.append("FSTATUS INT, ");
/*      */ 
/* 3543 */     sql.append("FUSAGETYPE INT, ");
/*      */ 
/* 3545 */     sql.append("FBOMTYPE INT, ");
/*      */ 
/* 3547 */     sql.append("FMATERIALID VARCHAR(44), ");
/*      */ 
/* 3549 */     sql.append("FISPROJECTMANU INT, ");
/*      */ 
/* 3551 */     sql.append("FPROJECTID VARCHAR(44), ");
/*      */ 
/* 3553 */     sql.append("FTRACKID VARCHAR(44), ");
/*      */ 
/* 3555 */     sql.append("FFLAG INT DEFAULT 0 NOT NULL ");
/* 3556 */     sql.append(")");
/* 3557 */     String tableName = null;
/*      */     try {
/* 3559 */       tableName = createTempTable(ctx, sql.toString());
/*      */     } catch (Exception e) {
/* 3561 */       throw new BOSException(e);
/*      */     }
/* 3563 */     return tableName;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String[] getToDoIds(BatchActionResults batchResults, String[] ids)
/*      */   {
/* 3575 */     String[] bomIDArray = null;
/* 3576 */     if (ids == null)
/* 3577 */       bomIDArray = batchResults.getToDoIdsArray();
/*      */     else {
/* 3579 */       bomIDArray = ids;
/*      */     }
/* 3581 */     return bomIDArray;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertBomInfo(Context ctx, String tableName, String[] ids)
/*      */     throws BOSException
/*      */   {
/* 3595 */     StringBuffer sql = new StringBuffer();
/* 3596 */     sql.append(" INSERT INTO  ").append(tableName);
/* 3597 */     sql.append(" (FSTORAGEORGUNITID,FID,FNUMBER,FSTATUS,FUSAGETYPE,FBOMTYPE,FMATERIALID,FISPROJECTMANU,FPROJECTID,FTRACKID) ");
/* 3598 */     sql.append(" SELECT b.fstorageorgunitid,b.fid,b.fnumber,b.fbasestatus,b.fusagetype,b.fbomtype,b.fmaterialid, b.fisprojectmanu, ");
/* 3599 */     sql.append(" \t\tCASE WHEN b.fbomtype = 45 THEN isnull(pt.fprojectid,'999999999') ");
/* 3600 */     sql.append(" \t\t\t ELSE isnull(b.fprojectid,'999999999') ");
/* 3601 */     sql.append(" \t\tEND projectid, ");
/* 3602 */     sql.append(" \t\tCASE WHEN b.fbomtype = 45 THEN isnull(pt.ftrackid,'999999999') ");
/* 3603 */     sql.append(" \t\t\t ELSE '999999999' ");
/* 3604 */     sql.append(" \t\tEND trackId ");
/* 3605 */     sql.append(" FROM t_mm_bom b  LEFT JOIN t_mm_orderbompt pt ON pt.forderid = b.fid ");
/* 3606 */     sql.append(" WHERE b.fid in ( ").append(SQLUtil.arrayToString(ids)).append(")");
/* 3607 */     DbUtil.execute(ctx, sql.toString());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomForAudit(Context ctx, String tableName)
/*      */     throws BOSException
/*      */   {
/* 3621 */     checkBomByUsageType(ctx, tableName);
/*      */ 
/* 3623 */     checkSelectedBomForAudit(ctx, tableName);
/*      */ 
/* 3625 */     checkBomByBomType(ctx, tableName);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomByUsageType(Context ctx, String tableName)
/*      */     throws BOSException
/*      */   {
/* 3638 */     StringBuffer sql = new StringBuffer();
/* 3639 */     sql.append(" update ").append(tableName);
/* 3640 */     sql.append(" set FFLAG = 1 ");
/* 3641 */     sql.append(" where FUSAGETYPE <> ").append(10);
/* 3642 */     DbUtil.execute(ctx, sql.toString());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkSelectedBomForAudit(Context ctx, String tableName)
/*      */     throws BOSException
/*      */   {
/* 3655 */     StringBuffer sql = new StringBuffer();
/* 3656 */     sql.append(" update ").append(tableName);
/* 3657 */     sql.append(" set FFLAG = 1 ");
/*      */ 
/* 3659 */     sql.append(" where FFLAG = 0 ");
/* 3660 */     sql.append("   and FUSAGETYPE = ").append(10);
/* 3661 */     sql.append("   and FNUMBER in (");
/* 3662 */     sql.append("\t   select min(t.fnumber) from ").append(tableName).append(" as t ");
/* 3663 */     sql.append("\t   group by FSTORAGEORGUNITID,FUSAGETYPE,FBOMTYPE,FMATERIALID,FISPROJECTMANU,FPROJECTID,FTRACKID ) ");
/* 3664 */     DbUtil.execute(ctx, sql.toString());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomByBomType(Context ctx, String tableName)
/*      */     throws BOSException
/*      */   {
/* 3678 */     checkBomForOrderBom(ctx, tableName);
/*      */ 
/* 3680 */     checkBomForOtherBom(ctx, tableName);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomForOrderBom(Context ctx, String tableName)
/*      */     throws BOSException
/*      */   {
/* 3692 */     StringBuffer sql = new StringBuffer();
/*      */ 
/* 3694 */     sql.append(" update ").append(tableName);
/* 3695 */     sql.append(" set FFLAG = 0 ");
/*      */ 
/* 3697 */     sql.append(" where FFLAG = 1 ");
/* 3698 */     sql.append("   and FUSAGETYPE = ").append(10);
/* 3699 */     sql.append("   and fbomtype = 45 and FNUMBER in ( ");
/* 3700 */     sql.append(" select t.fnumber from ").append(tableName).append(" as t where t.fflag = 0 )");
/* 3701 */     DbUtil.execute(ctx, sql.toString());
/*      */
/*      */ 
/* 3704 */     sql.setLength(0);
/* 3705 */     sql.append(" update ").append(tableName).append(" as tmp ");
/* 3706 */     sql.append(" set FFLAG = 0 ");
/*      */ 
/* 3708 */     sql.append(" where FFLAG = 1 ");
/* 3709 */     sql.append("   and FUSAGETYPE = ").append(10);
/* 3710 */     sql.append("   AND FNUMBER in ( ");
/* 3711 */     sql.append("\t   SELECT t.fnumber from ").append(tableName).append(" as t ");
/* 3712 */     sql.append("\t   inner join t_mm_bom b ON b.fstorageorgunitid = t.fstorageorgunitid ");
/* 3713 */     sql.append(" \t\t\t\t\t\t   AND b.fusagetype = t.fusagetype ");
/* 3714 */     sql.append(" \t\t\t\t\t\t   AND b.fbomtype = t.fbomtype ");
/* 3715 */     sql.append(" \t\t\t\t\t\t   AND b.fmaterialid = t.fmaterialid ");
/* 3716 */     sql.append(" \t\t\t\t\t\t   AND b.fbasestatus = ").append(4);
/* 3717 */     sql.append("\t   inner join t_mm_orderbompt pt ON b.fid = pt.forderid ");
/* 3718 */     sql.append(" \t\t\t\t\t\t\t\t   AND isnull(pt.fprojectid,'999999999') = t.fprojectid ");
/* 3719 */     sql.append(" \t\t\t\t\t\t\t\t   AND isnull(pt.ftrackid,'999999999') = t.ftrackid ");
/* 3720 */     sql.append(" \t   WHERE t.FUSAGETYPE = ").append(10);
/* 3721 */     sql.append("\t   group by t.fnumber ");
/* 3722 */     sql.append(" )");
/* 3723 */     sql.append(" and fbomtype = 45 ");
/* 3724 */     DbUtil.execute(ctx, sql.toString());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkBomForOtherBom(Context ctx, String tableName)
/*      */     throws BOSException
/*      */   {
/* 3737 */     StringBuffer sql = new StringBuffer();
/*      */ 
/* 3739 */     sql.setLength(0);
/* 3740 */     sql.append(" update ").append(tableName);
/* 3741 */     sql.append(" set FFLAG = 0 ");
/*      */ 
/* 3743 */     sql.append(" where FFLAG = 1 ");
/* 3744 */     sql.append("   and FUSAGETYPE = ").append(10);
/* 3745 */     sql.append("   AND FNUMBER in ( ");
/* 3746 */     sql.append("\t   SELECT t.fnumber from ").append(tableName).append(" as t ");
/* 3747 */     sql.append(" \t   inner JOIN T_MM_BOM B ON B.FSTORAGEORGUNITID = t.FSTORAGEORGUNITID ");
/* 3748 */     sql.append(" \t                        AND B.FUSAGETYPE = t.FUSAGETYPE ");
/* 3749 */     sql.append(" \t                        AND B.FBOMTYPE = t.FBOMTYPE ");
/* 3750 */     sql.append(" \t                        AND B.FMATERIALID = t.FMATERIALID ");
/* 3751 */     sql.append(" \t                        AND isnull(B.FPROJECTID, '999999999') = t.FPROJECTID ");
/* 3752 */     sql.append(" \t                        AND b.fbasestatus = ").append(4);
/* 3753 */     sql.append(" \t   WHERE t.FUSAGETYPE = ").append(10);
/* 3754 */     sql.append("\t   group by t.fnumber ");
/* 3755 */     sql.append(" )");
/* 3756 */     sql.append(" and fbomtype <> 45 ");
/* 3757 */     DbUtil.execute(ctx, sql.toString());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setErrorInfo(Context ctx, String tableName, BatchActionResults batchResults, boolean isBomCheck)
/*      */     throws BOSException, BomException, SQLException
/*      */   {
/* 3774 */     StringBuffer sql = new StringBuffer();
/*      */ 
/* 3776 */     sql.setLength(0);
/* 3777 */     sql.append(" SELECT t.fid,t.fbomtype,t.fisprojectmanu ");
/* 3778 */     sql.append(" FROM ").append(tableName).append(" as t ");
/* 3779 */     sql.append(" WHERE t.fflag = 0 GROUP BY t.fid,t.fbomtype,t.fisprojectmanu ");
/* 3780 */     IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
/* 3781 */     while (rs.next()) {
/* 3782 */       if (isBomCheck) {
/* 3783 */         addDetailError(rs, batchResults);
/*      */       }
/*      */ 
/* 3786 */       throwError(rs);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void addDetailError(IRowSet rs, BatchActionResults batchResults)
/*      */     throws SQLException
/*      */   {
/* 3800 */     String bomId = rs.getString("fid");
/* 3801 */     int bomType = rs.getInt("fbomtype");
/* 3802 */     BomException bomException = null;
/*      */ 
/* 3804 */     if (bomType == 40) {
/* 3805 */       bomException = new BomException(BomException.NEWMASTERBOMEXCEPTION);
/*      */
/*      */     }
/* 3808 */     else if (bomType == 50) {
/* 3809 */       int isProjectManu = rs.getInt("fisprojectmanu");
/*      */ 
/* 3811 */       if (isProjectManu == 1) {
/* 3812 */         bomException = new BomException(BomException.CFGBOMWITHPROJECTEXCEPTION);
/*      */       }
/*      */       else
/*      */       {
/* 3816 */         bomException = new BomException(BomException.CFGBOMWITHOUTPROJECTEXCEPTION);
/*      */       }
/*      */ 
/*      */     }
/* 3820 */     else if (bomType == 45) {
/* 3821 */       bomException = new BomException(BomException.MASTERORDERBOMEXCEPTION);
/*      */     }
/* 3823 */     batchResults.addError(bomId, bomException);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void throwError(IRowSet rs)
/*      */     throws SQLException, BomException
/*      */   {
/* 3835 */     int bomType = rs.getInt("fbomtype");
/*      */ 
/* 3837 */     if (bomType == 40) {
/* 3838 */       throw new BomException(BomException.NEWMASTERBOMEXCEPTION);
/*      */     }
/*      */ 
/* 3841 */     if (bomType == 50) {
/* 3842 */       int isProjectManu = rs.getInt("fisprojectmanu");
/*      */ 
/* 3844 */       if (isProjectManu == 1) {
/* 3845 */         throw new BomException(BomException.CFGBOMWITHPROJECTEXCEPTION);
/*      */
/*      */       }
/*      */ 
/* 3849 */       throw new BomException(BomException.CFGBOMWITHOUTPROJECTEXCEPTION);
/*      */
/*      */     }
/*      */ 
/* 3853 */     if (bomType == 45)
/* 3854 */       throw new BomException(BomException.MASTERORDERBOMEXCEPTION);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   protected boolean isSameNumber(Context ctx, IObjectPK pk, IObjectValue model)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 3863 */     return super.isSameNumber(ctx, pk, model);
/*      */   }
/*      */
@Override
protected List _Extend(Context arg0, HashMap arg1) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	return null;
}
@Override
protected List _ExtendProCheck(Context arg0, HashMap arg1) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	return null;
}
@Override
protected void _auditBatchTree(Context arg0, List arg1) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	
}
@Override
protected void _bomCopy(Context arg0, HashMap arg1) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	
}
@Override
protected Set _expandBOM(Context arg0, String arg1, Set arg2)
		throws BOSException, EASBizException {
	// TODO Auto-generated method stub
	return null;
}
@Override
protected void _submitBatchTree(Context arg0, List arg1) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	
}
@Override
protected void _unAuditBatchTree(Context arg0, List arg1) throws BOSException,
		EASBizException {
	// TODO Auto-generated method stub
	
} }
