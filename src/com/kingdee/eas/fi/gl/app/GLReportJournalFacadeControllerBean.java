/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
/*      */ package com.kingdee.eas.fi.gl.app;
/*      */ 
/*      */ import com.kingdee.bos.BOSException;
/*      */ import com.kingdee.bos.SQLDataException;
/*      */ import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
/*      */ import com.kingdee.bos.metadata.entity.EntityViewInfo;
/*      */ import com.kingdee.bos.metadata.entity.FilterInfo;
/*      */ import com.kingdee.bos.metadata.entity.FilterItemCollection;
/*      */ import com.kingdee.bos.metadata.entity.FilterItemInfo;
/*      */ import com.kingdee.bos.metadata.entity.SelectorItemCollection;
/*      */ import com.kingdee.bos.metadata.entity.SelectorItemInfo;
/*      */ import com.kingdee.bos.metadata.query.util.CompareType;
/*      */ import com.kingdee.bos.util.BOSUuid;
/*      */ import com.kingdee.eas.base.param.IParamControl;
/*      */ import com.kingdee.eas.base.param.ParamControlFactory;
/*      */ import com.kingdee.eas.basedata.assistant.CurrencyInfo;
/*      */ import com.kingdee.eas.basedata.assistant.IPeriod;
/*      */ import com.kingdee.eas.basedata.assistant.PeriodCollection;
/*      */ import com.kingdee.eas.basedata.assistant.PeriodFactory;
/*      */ import com.kingdee.eas.basedata.assistant.PeriodInfo;
/*      */ import com.kingdee.eas.basedata.assistant.PeriodTypeInfo;
/*      */ import com.kingdee.eas.basedata.assistant.PeriodUtils;
/*      */ import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
/*      */ import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
/*      */ import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
/*      */ import com.kingdee.eas.common.EASBizException;
/*      */ import com.kingdee.eas.fi.gl.GLException;
/*      */ import com.kingdee.eas.fi.gl.GlUtils;
/*      */ import com.kingdee.eas.fi.gl.ReportConditionBase;
/*      */ import com.kingdee.eas.fi.gl.ReportConditionJournal;
/*      */ import com.kingdee.eas.fi.gl.ReportException;
/*      */ import com.kingdee.eas.fi.gl.ReportJournalException;
/*      */ import com.kingdee.eas.fi.gl.ReportLineKey;
/*      */ import com.kingdee.eas.fi.gl.ReportResultInfo;
/*      */ import com.kingdee.eas.fi.gl.ReportTableHeadInfo;
/*      */ import com.kingdee.eas.fi.gl.ReportTableHeadItemInfo;
/*      */ import com.kingdee.eas.fi.gl.common.GLResUtil;
/*      */ import com.kingdee.eas.fi.gl.common.SimpleCompanyUserObject;
/*      */ import com.kingdee.eas.fi.gl.common.SqlParameter2;
/*      */ import com.kingdee.eas.util.app.DbUtil;
/*      */ import com.kingdee.jdbc.rowset.IRowSet;
/*      */ import com.kingdee.util.StringUtils;
/*      */ import com.kingdee.util.db.SQLUtils;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Enumeration;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.log4j.Logger;
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
/*      */ public class GLReportJournalFacadeControllerBean extends AbstractGLReportJournalFacadeControllerBean
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   78 */   private static Logger logger = Logger.getLogger("com.kingdee.eas.fi.gl.app.GLReportJournalFacadeControllerBean");
/*      */
/*      */
/*      */	 protected Map actTypeMap ;
/*      */
/*   83 */   protected String strCompanyIds = null;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
///*      */   protected Object[] getLineObjects(ReportPartner partner, ResultSet rs)
///*      */     throws SQLException, EASBizException, BOSException
///*      */   {
///*   96 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
///*      */
///*      */
///*      */ 
///*  100 */     String strCurrencyId = condition.getCurrencyID();
///*  101 */     if (strCurrencyId == null)
///*      */     {
///*  103 */       throw new ReportException(ReportException.TODO_UNTYPE);
///*      */     }
///*      */ 
///*  106 */     boolean isShowForCurrency = isShowForCurrency(partner);
///*  107 */     boolean isShowLocalCurrency = isShowLocalCurrency(partner);
///*  108 */     boolean isShowReportCurrency = isShowReportCurrency(partner);
///*      */
///*      */ 
///*  111 */     int asstCount = 0;
///*  112 */     Object obj = partner.getVariable("MaxAsstItemCount");
///*  113 */     if ((obj != null) && (((Integer)obj).intValue() > 0)) {
///*  114 */       asstCount = ((Integer)obj).intValue();
///*      */     }
///*      */ 
///*  117 */     int index = 0;
///*  118 */     int currencyLie = 0;
///*  119 */     int tag = 0;
///*  120 */     tag = rs.getInt("FTag");
///*  121 */     if (partner.getFixCondition().isAllCurrency()) {
///*  122 */       currencyLie = 1;
///*      */     }
///*  124 */     int companyLie = 0;
///*  125 */     if (!(partner.getCompany().isIsBizUnit())) {
///*  126 */       companyLie = 1;
///*      */     }
///*      */ 
///*  129 */     int rowSize = 18 + asstCount + currencyLie + companyLie + 2 - ((isShowForCurrency) ? 0 : 4) - ((isShowLocalCurrency) ? 0 : 4) - ((isShowReportCurrency) ? 0 : 4);
///*  130 */     Object[] row = new Object[rowSize];
///*      */
///*      */ 
///*  133 */     String hgId = rs.getString("FAsstHgID");
///*  134 */     String faccountNumber = rs.getString("FAccountNumber");
///*  135 */     String faccountName = rs.getString("FAccountName");
///*  136 */     String expandAccount = (String)condition.getExpandInfo().get("AccountID");
///*  137 */     if (StringUtils.isEmpty(hgId)) {
///*  138 */       if (expandAccount == null)
///*  139 */         row[(index++)] = faccountNumber;
///*      */       else {
///*  141 */         row[(index++)] = "";
///*      */       }
///*      */ 
///*  144 */       if (tag == 2) {
///*  145 */         row[(index++)] = partner.TITLE_TOTAL;
///*      */       }
///*  147 */       else if (expandAccount == null)
///*  148 */         row[(index++)] = faccountName;
///*      */       else
///*  150 */         row[(index++)] = "";
///*      */     }
///*      */     else
///*      */     {
///*  154 */       row[(index++)] = null;
///*  155 */       row[(index++)] = null;
///*      */     }
///*      */ 
///*  158 */     int curPre = partner.getScaleFor();
///*  159 */     if (partner.getFixCondition().isAllCurrency()) {
///*  160 */       if ((tag == -1) || (tag == 0)) {
///*  161 */         row[(index++)] = rs.getString("FCurrencyName");
///*  162 */         if (rs.getString("FCurrencyID") != null)
///*  163 */           curPre = partner.getAmountScale(rs.getString("FCurrencyID"));
///*      */       }
///*  165 */       else if (tag == 1) {
///*  166 */         row[(index++)] = partner.TITLE_SUB_TOTAL;
///*  167 */       } else if (tag == 2) {
///*  168 */         String currencyName = rs.getString("FCurrencyName");
///*  169 */         if (currencyName != null) {
///*  170 */           row[(index++)] = rs.getString("FCurrencyName");
///*  171 */           if (rs.getString("FCurrencyID") != null)
///*  172 */             curPre = partner.getAmountScale(rs.getString("FCurrencyID"));
///*      */         }
///*      */         else {
///*  175 */           row[(index++)] = partner.TITLE_SUB_TOTAL;
///*      */         }
///*      */       }
///*      */ 
///*      */     }
///*      */ 
///*  181 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
///*  182 */       String companyId = rs.getString("FCompanyID");
///*  183 */       SimpleCompanyUserObject companyUserObject = partner.getCompanyUserObjectById(companyId);
///*  184 */       if (companyUserObject.isLeaf()) {
///*  185 */         ReportConditionJournal conditionNew = (ReportConditionJournal)partner.getFixCondition();
///*  186 */         if (conditionNew.isOptionShowAsstItem())
///*      */         {
///*  188 */           SimpleCompanyUserObject cloned = (SimpleCompanyUserObject)companyUserObject.clone();
///*  189 */           boolean isAccLeafNull = (conditionNew.getExpandInfo().get("AccountIsLeaf") != null) && (((Boolean)conditionNew.getExpandInfo().get("AccountIsLeaf")).booleanValue());
///*      */ 
///*  191 */           if ((rs.getString("FAsstHgID") == null) || (" ".endsWith(rs.getString("FAsstHgID"))))
///*      */           {
///*  193 */             if (!(isAccLeafNull)) {
///*  194 */               cloned.setLeaf(true);
///*  195 */               row[(index++)] = cloned;
///*      */             } else {
///*  197 */               cloned.setLeaf(false);
///*  198 */               row[(index++)] = cloned;
///*      */             }
///*      */           }
///*      */           else {
///*  202 */             cloned.setLeaf(true);
///*  203 */             cloned.setName("");
///*  204 */             cloned.setLevel(cloned.getLevel() + 1);
///*  205 */             row[(index++)] = null;
///*      */           }
///*      */         } else {
///*  208 */           row[(index++)] = companyUserObject.clone();
///*      */         }
///*      */       } else {
///*  211 */         row[(index++)] = companyUserObject.clone();
///*      */
///*      */       }
///*      */ 
///*      */     }
///*      */ 
///*  217 */     String asstNameL = rs.getString("FAsstName");
///*  218 */     String asstNameD = rs.getString("FdisplaynameGroup");
///*  219 */     String asstNameN = rs.getString("FNumberGroup");
///*  220 */     if (StringUtils.isEmpty(asstNameL)) {
///*  221 */       for (int i = 0; i < asstCount; ++i)
///*  222 */         row[(index++)] = null;
///*      */     }
///*      */     else
///*      */     {
///*  226 */       String[] strAsstNameL = asstNameL.trim().split(";");
///*  227 */       String[] strAsstNameD = asstNameD.trim().split(";");
///*  228 */       String[] strAsstNameN = asstNameN.trim().split(";");
///*  229 */       int splitLen = strAsstNameL.length;
///*  230 */       String number = null;
///*  231 */       int acctTypeFlag = 0;
///*  232 */       if (this.actTypeMap == null) {
///*  233 */         this.actTypeMap = GLRptHelper.initAcctTypeMap(partner.getContext());
///*      */       }
///*  235 */       for (int i = 0; i < asstCount; ++i) {
///*  236 */         if (i < splitLen) {
///*  237 */           if (number == null) {
///*  238 */             number = strAsstNameN[i].substring(0, strAsstNameN[i].indexOf("_!"));
///*      */ 
///*  240 */             if (this.actTypeMap.get(number) != null) {
///*  241 */               acctTypeFlag = ((Integer)this.actTypeMap.get(number)).intValue();
///*      */             }
///*      */           }
///*      */ 
///*  245 */           row[(index++)] = GLRptHelper.getAssDisplayName(partner.isParmAssitemShowNumber(), partner.isRptShowLongNameFromGeneral(), acctTypeFlag, strAsstNameL[i], strAsstNameD[i], strAsstNameN[i]);
///*      */
///*      */         }
///*      */         else
///*      */         {
///*  250 */           row[(index++)] = null;
///*      */         }
///*      */       }
///*      */ 
///*      */     }
///*      */ 
///*  256 */     int iDC = rs.getInt("FDC");
///*  257 */     BigDecimal beginBalanceFor = rs.getBigDecimal("FBeginBalanceFor");
///*  258 */     BigDecimal beginBalanceLocal = rs.getBigDecimal("FBeginBalanceLocal");
///*  259 */     BigDecimal beginBalanceRpt = rs.getBigDecimal("FBeginBalancerpt");
///*      */
///*      */ 
///*  262 */     if (tag == 2)
///*      */     {
///*  264 */       row[(index++)] = null;
///*      */ 
///*  266 */       if (isShowForCurrency)
///*  267 */         row[(index++)] = getBigDecimalForScale(beginBalanceFor, curPre);
///*  268 */       if (isShowLocalCurrency)
///*  269 */         row[(index++)] = getBigDecimalForScale(beginBalanceLocal, partner.getScaleLocal());
///*  270 */       if (isShowReportCurrency)
///*  271 */         row[(index++)] = getBigDecimalForScale(beginBalanceRpt, partner.getScaleRpt());
///*      */     }
///*      */     else {
///*  274 */       row[(index++)] = partner.getDCStringWithParm((isShowLocalCurrency) ? beginBalanceLocal : (isShowForCurrency) ? beginBalanceFor : beginBalanceRpt, iDC);
///*      */ 
///*  276 */       if (isShowForCurrency)
///*  277 */         row[(index++)] = getBigDecimalForScale(partner.getBalanceForDCWithParm(beginBalanceFor, iDC), curPre);
///*  278 */       if (isShowLocalCurrency)
///*  279 */         row[(index++)] = getBigDecimalForScale(partner.getBalanceForDCWithParm(beginBalanceLocal, iDC), partner.getScaleLocal());
///*  280 */       if (isShowReportCurrency) {
///*  281 */         row[(index++)] = getBigDecimalForScale(partner.getBalanceForDCWithParm(beginBalanceRpt, iDC), partner.getScaleRpt());
///*      */       }
///*      */     }
///*      */ 
///*  285 */     if (isShowForCurrency)
///*  286 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FDebitFor"), curPre);
///*  287 */     if (isShowLocalCurrency)
///*  288 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FDebitLocal"), partner.getScaleLocal());
///*  289 */     if (isShowReportCurrency) {
///*  290 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FDebitRpt"), partner.getScaleRpt());
///*      */     }
///*      */ 
///*  293 */     if (isShowForCurrency)
///*  294 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FCreditFor"), curPre);
///*  295 */     if (isShowLocalCurrency)
///*  296 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FCreditLocal"), partner.getScaleLocal());
///*  297 */     if (isShowReportCurrency) {
///*  298 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FCreditRpt"), partner.getScaleRpt());
///*      */     }
///*      */ 
///*  301 */     BigDecimal endBalanceFor = rs.getBigDecimal("FEndBalanceFor");
///*  302 */     BigDecimal endBalanceLocal = rs.getBigDecimal("FEndBalanceLocal");
///*  303 */     BigDecimal endBalanceRpt = rs.getBigDecimal("FEndBalanceRpt");
///*      */
///*      */ 
///*  306 */     if (tag == 2)
///*      */     {
///*  308 */       row[(index++)] = null;
///*      */ 
///*  310 */       if (isShowForCurrency)
///*  311 */         row[(index++)] = getBigDecimalForScale(endBalanceFor, curPre);
///*  312 */       if (isShowLocalCurrency)
///*  313 */         row[(index++)] = getBigDecimalForScale(endBalanceLocal, partner.getScaleLocal());
///*  314 */       if (isShowReportCurrency)
///*  315 */         row[(index++)] = getBigDecimalForScale(endBalanceRpt, partner.getScaleRpt());
///*      */     }
///*      */     else {
///*  318 */       row[(index++)] = partner.getDCStringWithParm((isShowLocalCurrency) ? endBalanceLocal : (isShowForCurrency) ? endBalanceFor : endBalanceRpt, iDC);
///*      */ 
///*  320 */       if (isShowForCurrency)
///*  321 */         row[(index++)] = getBigDecimalForScale(partner.getBalanceForDCWithParm(endBalanceFor, iDC), curPre);
///*  322 */       if (isShowLocalCurrency)
///*  323 */         row[(index++)] = getBigDecimalForScale(partner.getBalanceForDCWithParm(endBalanceLocal, iDC), partner.getScaleLocal());
///*  324 */       if (isShowReportCurrency) {
///*  325 */         row[(index++)] = getBigDecimalForScale(partner.getBalanceForDCWithParm(endBalanceRpt, iDC), partner.getScaleRpt());
///*      */       }
///*      */     }
///*      */ 
///*  329 */     int debitCount = rs.getInt("FDebitCount");
///*  330 */     int creditCount = rs.getInt("FCredtiCount");
///*  331 */     row[(index++)] = ((debitCount > 0) ? new Integer(debitCount) : null);
///*  332 */     row[(index++)] = ((creditCount > 0) ? new Integer(creditCount) : null);
///*  333 */     row[(index++)] = ((tag == 2) ? ReportResultInfo.LINE_TOTAL : (tag == 1) ? ReportResultInfo.LINE_YEAR_TOTAL : ReportResultInfo.LINE_NORMAL);
///*      */
///*      */ 
///*  336 */     ReportLineKey lineKey = new ReportLineKey();
///*  337 */     lineKey.setCompanyID(rs.getString("FCompanyID"));
///*  338 */     lineKey.setStrAccountID(rs.getString("FAccountID"));
///*  339 */     lineKey.setStrAccountNumber(faccountNumber);
///*  340 */     lineKey.setStrAccountName(faccountName);
///*  341 */     lineKey.setAccountLeaf(rs.getInt("FAccountIsLeaf") == 1);
///*      */ 
///*  343 */     if (condition.isOptionShowAsstItem()) {
///*  344 */       lineKey.setAssistghId(hgId);
///*      */     }
///*  346 */     if (condition.isAllCurrency()) {
///*  347 */       if ((tag == 2) && (" ".equals(rs.getString("fcurrencyid")))) {
///*  348 */         lineKey.setStrCurrencyId("AllCurrency");
///*  349 */         lineKey.setStrCurrencyName(GLResUtil.getRes("all_currency"));
///*  350 */       } else if ((tag == 1) && (" ".equals(rs.getString("fcurrencyid")))) {
///*  351 */         lineKey.setStrCurrencyId("AllCurrency");
///*      */       } else {
///*  353 */         lineKey.setStrCurrencyId(rs.getString("fcurrencyid"));
///*  354 */         lineKey.setStrCurrencyName(rs.getString("fcurrencyname"));
///*      */       }
///*      */     }
///*      */ 
///*  358 */     row[(index++)] = lineKey;
///*      */ 
///*  360 */     return row;
///*      */   }
/*      */
/*      */   protected Object[] getTotalLineObjects(ReportPartner partner, ResultSet rs)
/*      */     throws SQLException, EASBizException, BOSException
/*      */   {
/*  366 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*  367 */     String strCurrencyId = condition.getCurrencyID();
/*  368 */     if (strCurrencyId == null)
/*      */     {
/*  370 */       throw new ReportException(ReportException.TODO_UNTYPE);
/*      */     }
/*      */ 
/*  373 */     boolean isShowForCurrency = isShowForCurrency(partner);
/*  374 */     boolean isShowLocalCurrency = isShowLocalCurrency(partner);
/*  375 */     boolean isShowReportCurrency = isShowReportCurrency(partner);
/*      */
/*      */ 
/*  378 */     int asstCount = 0;
/*  379 */     Object obj = partner.getVariable("MaxAsstItemCount");
/*  380 */     if ((obj != null) && (((Integer)obj).intValue() > 0)) {
/*  381 */       asstCount = ((Integer)obj).intValue();
/*      */     }
/*  383 */     int index = 0;
/*      */ 
/*  385 */     int rowSize = 18 + asstCount + 2 - ((isShowForCurrency) ? 0 : 4) - ((isShowLocalCurrency) ? 0 : 4) - ((isShowReportCurrency) ? 0 : 4);
/*  386 */     Object[] row = new Object[rowSize];
/*      */
/*      */ 
/*  389 */     row[(index++)] = null;
/*      */
/*      */ 
/*  392 */     row[(index++)] = null;
/*      */
/*      */ 
/*  395 */     for (int i = 0; i < asstCount; ++i) {
/*  396 */       row[(index++)] = null;
/*      */
/*      */     }
/*      */ 
/*  400 */     row[(index++)] = null;
/*      */
/*      */ 
/*  403 */     if (isShowForCurrency)
/*  404 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FBeginBalanceFor"), partner.getScaleFor());
/*  405 */     if (isShowLocalCurrency)
/*  406 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FBeginBalanceLocal"), partner.getScaleLocal());
/*  407 */     if (isShowReportCurrency) {
/*  408 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FBeginBalancerpt"), partner.getScaleRpt());
/*      */     }
/*      */ 
/*  411 */     if (isShowForCurrency)
/*  412 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FDebitFor"), partner.getScaleFor());
/*  413 */     if (isShowLocalCurrency)
/*  414 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FDebitLocal"), partner.getScaleLocal());
/*  415 */     if (isShowReportCurrency) {
/*  416 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FDebitRpt"), partner.getScaleRpt());
/*      */     }
/*      */ 
/*  419 */     if (isShowForCurrency)
/*  420 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FCreditFor"), partner.getScaleFor());
/*  421 */     if (isShowLocalCurrency)
/*  422 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FCreditLocal"), partner.getScaleLocal());
/*  423 */     if (isShowReportCurrency) {
/*  424 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FCreditRpt"), partner.getScaleRpt());
/*      */     }
/*      */ 
/*  427 */     row[(index++)] = null;
/*      */
/*      */ 
/*  430 */     if (isShowForCurrency)
/*  431 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FEndBalanceFor"), partner.getScaleFor());
/*  432 */     if (isShowLocalCurrency)
/*  433 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FEndBalanceLocal"), partner.getScaleLocal());
/*  434 */     if (isShowReportCurrency) {
/*  435 */       row[(index++)] = getBigDecimalForScale(rs.getBigDecimal("FEndBalanceRpt"), partner.getScaleRpt());
/*      */     }
/*      */ 
/*  438 */     int debitCount = rs.getInt("FDebitCount");
/*  439 */     int creditCount = rs.getInt("FCredtiCount");
/*  440 */     row[(index++)] = ((debitCount > 0) ? new Integer(debitCount) : null);
/*  441 */     row[(index++)] = ((creditCount > 0) ? new Integer(creditCount) : null);
/*      */ 
/*  443 */     row[(index++)] = ReportResultInfo.LINE_TOTAL;
/*      */
/*      */ 
/*  446 */     row[(index++)] = null;
/*      */ 
/*  448 */     return row;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getSqlForDataSelect(ReportPartner partner)
/*      */     throws BOSException, EASBizException, ReportException
/*      */   {
/*  457 */     StringBuffer sqlSelect = new StringBuffer();
/*  458 */     sqlSelect.append(" T_Main.FAccountID AS FAccountID, \r\n");
/*  459 */     sqlSelect.append(" TA.FDC AS FDC, \r\n");
/*  460 */     sqlSelect.append(" TA.FIsLeaf AS FIsLeaf, \r\n");
/*  461 */     sqlSelect.append(" TA.FNumber AS FAccountNumber,\r\n");
/*      */
/*      */ 
/*  464 */     sqlSelect.append(getAccountName(partner));
/*  465 */     sqlSelect.append(partner.getFieldNameExtend());
/*  466 */     sqlSelect.append(" FAccountName, \r\n");
/*  467 */     sqlSelect.append(" TA.FLevel AS FLevel , \r\n");
/*  468 */     sqlSelect.append(" T_Main.FAsstHgID as FAsstHgID,\r\n");
/*  469 */     sqlSelect.append(" case when HG.FNumberGroup").append(partner.getFieldNameExtend());
/*  470 */     sqlSelect.append(" is null then N' ' else HG.FNumberGroup").append(partner.getFieldNameExtend());
/*  471 */     sqlSelect.append(" end as FAsstNumberGroup, \r\n");
/*      */
/*      */
/*      */ 
/*  475 */     boolean showLongNameFromGeneral = partner.isRptShowLongNameFromGeneral();
/*      */
/*      */
/*      */ 
/*  479 */     boolean parmAssitemShowNumber = partner.isParmAssitemShowNumber();
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
/*  494 */     sqlSelect.append(" HG.FdisplaynameGroup").append(partner.getFieldNameExtend()).append(" as  FdisplaynameGroup,\r\n");
/*      */ 
/*  496 */     sqlSelect.append(" HG.FNumberGroup").append(partner.getFieldNameExtend()).append(" as  FNumberGroup,\r\n");
/*      */ 
/*  498 */     sqlSelect.append(" HG.flongnamegroup").append(partner.getFieldNameExtend()).append(" as  FAsstName,\r\n");
/*      */ 
/*  500 */     if (partner.getFixCondition().isAllCurrency()) {
/*  501 */       sqlSelect.append(" currency.fname_l2 AS FCurrencyName,  \r\n");
/*  502 */       sqlSelect.append(" T_Main.FCurrencyID AS FCurrencyID,  \r\n");
/*      */     }
/*  504 */     sqlSelect.append(" T_Main.FCompanyID FCompanyID, \r\n");
/*  505 */     sqlSelect.append(" T_Main.FBeginBalanceFor AS FBeginBalanceFor,  \r\n");
/*  506 */     sqlSelect.append(" T_Main.FBeginBalanceLocal AS FBeginBalanceLocal, \r\n");
/*  507 */     sqlSelect.append(" T_Main.FBeginBalanceRpt AS FBeginBalanceRpt, \r\n");
/*  508 */     sqlSelect.append(" T_Main.FDebitFor AS FDebitFor, \r\n");
/*  509 */     sqlSelect.append(" T_Main.FDebitLocal AS FDebitLocal, \r\n");
/*  510 */     sqlSelect.append(" T_Main.FDebitRpt AS FDebitRpt, \r\n");
/*  511 */     sqlSelect.append(" T_Main.FCreditFor AS FCreditFor, \r\n");
/*  512 */     sqlSelect.append(" T_Main.FCreditLocal AS FCreditLocal, \r\n");
/*  513 */     sqlSelect.append(" T_Main.FCreditRpt AS FCreditRpt,\r\n");
/*  514 */     sqlSelect.append(" T_Main.FEndBalanceFor AS FEndBalanceFor, \r\n");
/*  515 */     sqlSelect.append(" T_Main.FEndBalanceLocal AS FEndBalanceLocal,\r\n");
/*  516 */     sqlSelect.append(" T_Main.FEndBalanceRpt AS FEndBalanceRpt, \r\n");
/*  517 */     sqlSelect.append(" T_Main.FDebitCount AS FDebitCount, \r\n");
/*  518 */     sqlSelect.append(" T_Main.FCredtiCount AS FCredtiCount \r\n");
/*  519 */     sqlSelect.append(" ,T_Main.FTag AS FTag \r\n");
/*  520 */     sqlSelect.append(" ,T_Main.FLineType AS FLineType \r\n");
/*  521 */     sqlSelect.append(" ,TA.FIsLeaf FAccountIsLeaf \r\n");
/*      */ 
/*  523 */     return sqlSelect.toString();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getAccountName(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  535 */     HashMap paramKeyMap = new HashMap();
/*  536 */     IParamControl iParamControl = ParamControlFactory.getLocalInstance(partner.getContext());
/*      */ 
/*  538 */     boolean isAccountShowLongName = false;
/*  539 */     paramKeyMap.put("GL_012", partner.getCompany().getId().toString());
/*  540 */     String strAccountShowLongName = (String)iParamControl.getParamHashMap(paramKeyMap).get("GL_012");
/*  541 */     if ((strAccountShowLongName != null) && (strAccountShowLongName.trim().length() > 0)) {
/*  542 */       isAccountShowLongName = Boolean.valueOf(strAccountShowLongName.trim()).booleanValue();
/*      */     }
/*  544 */     return ((isAccountShowLongName) ? " TA.FLongName" : " TA.FName");
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getSqlForDataFrom(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/*  553 */     StringBuffer sqlFrom = new StringBuffer();
/*  554 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*  555 */     boolean isNeedAccountID = ((Boolean)condition.getExpandInfo().get("isNeedAccountID")).booleanValue();
/*  556 */     sqlFrom.append(" from \r\n");
/*  557 */     sqlFrom.append(" (SELECT FAccountID AS FAccountID, \r\n");
/*  558 */     sqlFrom.append(" FAsstHgID as FAsstHgID, \r\n");
/*  559 */     sqlFrom.append(" FCurrencyID as FCurrencyID, \r\n");
/*  560 */     sqlFrom.append(" FCompanyID as FCompanyID,\r\n");
/*  561 */     sqlFrom.append(" SUM(FBeginBalanceFor) AS FBeginBalanceFor,\r\n");
/*  562 */     sqlFrom.append(" SUM(FBeginBalanceLocal) AS FBeginBalanceLocal,\r\n");
/*  563 */     sqlFrom.append(" SUM(FBeginBalanceRpt) AS FBeginBalanceRpt,\r\n");
/*  564 */     sqlFrom.append(" SUM(FDebitFor) AS FDebitFor, \r\n");
/*  565 */     sqlFrom.append(" SUM(FDebitLocal) AS FDebitLocal, \r\n");
/*  566 */     sqlFrom.append(" SUM(FDebitRpt) AS FDebitRpt,\r\n");
/*  567 */     sqlFrom.append(" SUM(FCreditFor) AS FCreditFor, \r\n");
/*  568 */     sqlFrom.append(" SUM(FCreditLocal) AS FCreditLocal,\r\n");
/*  569 */     sqlFrom.append(" SUM(FCreditRpt) AS FCreditRpt,\r\n");
/*  570 */     sqlFrom.append(" SUM(FEndBalanceFor) AS FEndBalanceFor, \r\n");
/*  571 */     sqlFrom.append(" SUM(FEndBalanceLocal) AS FEndBalanceLocal, \r\n");
/*  572 */     sqlFrom.append(" SUM(FEndBalanceRpt) AS FEndBalanceRpt,\r\n");
/*  573 */     sqlFrom.append(" SUM(FDebitCount) AS FDebitCount, \r\n");
/*  574 */     sqlFrom.append(" SUM(FCredtiCount) AS FCredtiCount,\r\n");
/*  575 */     sqlFrom.append(" FTag AS FTag,\r\n");
/*  576 */     sqlFrom.append(" FLineType AS FLineType \r\n");
/*  577 */     sqlFrom.append(" FROM ").append(partner.getTempTableName()).append(" \r\n");
/*  578 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/*  579 */       sqlFrom.append(" GROUP BY FAccountID,FCurrencyID,FCompanyID,FAsstHgID,FTag,FLineType ");
/*      */     else {
/*  581 */       sqlFrom.append(" GROUP BY FAccountID,FAsstHgID,FCurrencyID,FCompanyID,FTag,FLineType ");
/*      */     }
/*  583 */     sqlFrom.append(") AS T_Main \r\n");
/*  584 */     sqlFrom.append(" left JOIN T_BD_AccountView AS TA ON T_Main.FAccountID = TA.FID \r\n");
/*  585 */     String expandCurrency = (String)condition.getExpandInfo().get("CurrencyIDa");
/*  586 */     if ((expandCurrency != null) && (expandCurrency.trim().length() > 0) && (!(expandCurrency.equals("AllCurrency"))) && (isNeedAccountID)) {
/*  587 */       sqlFrom.append(" INNER JOIN t_BD_CURRENCY currency ON T_Main.FCurrencyID = currency.FID \r\n");
/*  588 */       sqlFrom.append(" and currency.FID = '").append(expandCurrency).append("' ");
/*      */     } else {
/*  590 */       sqlFrom.append(" LEFT JOIN T_BD_Currency AS currency ON T_Main.FCurrencyID = currency.FID \r\n");
/*      */
/*      */     }
/*      */ 
/*  594 */     sqlFrom.append(" LEFT JOIN T_BD_AssistantHG AS HG ON T_Main.FAsstHgID = HG.FID \r\n");
/*      */
/*      */ 
/*  597 */     sqlFrom.append(" LEFT JOIN T_org_company com ON T_Main.Fcompanyid = com.FID \r\n");
/*      */
/*      */
/*      */ 
/*  601 */     EntityViewInfo evi = partner.getCondition();
/*  602 */     ReportConditionBase customCondition = (ReportConditionBase)evi.get("GLFixCondition");
/*  603 */     String expandAccount = (String)customCondition.getExpandInfo().get("AccountID");
/*  604 */     if ((expandAccount != null) && 
/*  605 */       (expandAccount.trim().length() != 0) && 
/*  606 */       (isNeedAccountID)) {
/*  607 */       sqlFrom.append(" inner join t_bd_accountview D on D.fnumber=TA.fnumber and D.fid='").append(expandAccount).append("' \r\n");
/*      */
/*      */     }
/*      */ 
/*  611 */     return sqlFrom.toString();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getSqlForDataWhere(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/*  620 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*      */
/*      */ 
/*  623 */     StringBuffer sqlFrom = new StringBuffer();
/*  624 */     sqlFrom.append(" WHERE (\r\n");
/*      */ 
/*  626 */     sqlFrom.append(" ((TA.FAccountTableID = ?) AND ");
/*  627 */     sqlFrom.append("(TA.FLevel >=?) AND (TA.FLevel <= ?) \r\n");
/*  628 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/*  629 */       sqlFrom.append(" AND (TA.FNumber >= ?)  \r\n");
/*      */     }
/*  631 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/*  632 */       sqlFrom.append(" AND (TA.FNumber <= ?)  \r\n");
/*      */     }
/*  634 */     if ((condition.isAllCurrency()) || ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowTotal()))) {
/*  635 */       sqlFrom.append(" or (TA.fid is  null )  \r\n");
/*      */     }
/*  637 */     sqlFrom.append(")");
/*      */
/*      */
/*      */
/*      */ 
/*  642 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/*  643 */       boolean isShowForCurrency = isShowForCurrency(partner);
/*  644 */       boolean isShowLocalCurrency = isShowLocalCurrency(partner);
/*  645 */       boolean isShowReportCurrency = isShowReportCurrency(partner);
/*  646 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/*  647 */         sqlFrom.append(" and (1=0 ").append((isShowForCurrency) ? " or (T_Main.FEndBalanceFor <> 0)" : "").append((isShowLocalCurrency) ? " or (T_Main.FEndBalanceLocal <> 0)" : "").append((isShowReportCurrency) ? " or (T_Main.FEndBalanceRpt <> 0)" : "").append(") \r\n");
/*      */
/*      */
/*      */
/*      */       }
/*      */ 
/*  653 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/*  654 */         sqlFrom.append(" and (1=0 ").append((isShowForCurrency) ? " or (T_Main.FDebitFor <> 0) OR (T_Main.FCreditFor <> 0)" : "").append((isShowLocalCurrency) ? " or (T_Main.FDebitLocal <> 0) OR (T_Main.FCreditLocal <> 0)" : "").append((isShowReportCurrency) ? " or (T_Main.FDebitRpt <> 0) OR (T_Main.FCreditRpt <> 0)" : "").append(") \r\n");
/*      */
/*      */
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  661 */     sqlFrom.append(")");
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/*  670 */     if ((!(GlUtils.isCompanyUnion(partner.getCompany()))) && (condition.isOptionShowAsstItem())) {
/*  671 */       boolean isShowForCurrency = isShowForCurrency(partner);
/*  672 */       boolean isShowLocalCurrency = isShowLocalCurrency(partner);
/*  673 */       boolean isShowReportCurrency = isShowReportCurrency(partner);
/*      */ 
/*  675 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/*  676 */         sqlFrom.append(" AND (1=0 ").append((isShowForCurrency) ? " or (T_Main.FEndBalanceFor <> 0)" : "").append((isShowLocalCurrency) ? " or (T_Main.FEndBalanceLocal <> 0)" : "").append((isShowReportCurrency) ? " or (T_Main.FEndBalanceRpt <> 0)" : "");
/*      */
/*      */
/*      */ 
/*  680 */         if (condition.isAllCurrency()) {
/*  681 */           sqlFrom.append(" or (T_Main.FTag =2 and T_Main.FLineType =1) or (T_Main.FTag =2 and T_Main.FLineType =2) or (T_Main.FTag =1 and T_Main.FLineType =0) ");
/*      */         }
/*  683 */         sqlFrom.append(" ) \r\n");
/*      */       }
/*      */ 
/*  686 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/*  687 */         sqlFrom.append(" AND (1=0 ").append((isShowForCurrency) ? " or (T_Main.FDebitFor <> 0) OR (T_Main.FCreditFor <> 0)" : "").append((isShowLocalCurrency) ? " or (T_Main.FDebitLocal <> 0) OR (T_Main.FCreditLocal <> 0)" : "").append((isShowReportCurrency) ? " or (T_Main.FDebitRpt <> 0) OR (T_Main.FCreditRpt <> 0)" : "");
/*      */
/*      */
/*      */ 
/*  691 */         if (condition.isAllCurrency()) {
/*  692 */           sqlFrom.append(" or (T_Main.FTag =2 and T_Main.FLineType =1) or (T_Main.FTag =2 and T_Main.FLineType =2) or (T_Main.FTag =1 and T_Main.FLineType =0) ");
/*      */         }
/*  694 */         sqlFrom.append(" ) \r\n");
/*      */       }
/*      */     }
/*  697 */     SqlParameter2 parameter = new SqlParameter2();
/*      */
/*      */ 
/*  700 */     parameter.addValueChar(partner.getAccountTableId());
/*  701 */     parameter.addValue(new Integer(condition.getAccountLevelStart()));
/*  702 */     parameter.addValue(new Integer(condition.getAccountLevelEnd()));
/*      */ 
/*  704 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/*  705 */       parameter.addValueVarchar(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/*  708 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/*  709 */       parameter.addValueVarchar(condition.getAccountCodeEnd() + "~~");
/*      */     }
/*      */ 
/*  712 */     setParameters(partner, parameter);
/*      */ 
/*  714 */     return sqlFrom.toString();
/*      */   }
/*      */
/*      */   protected String getSqlForDataOrder(ReportPartner partner) throws BOSException, ReportException
/*      */   {
/*  719 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
/*  720 */       if (partner.getFixCondition().isAllCurrency()) {
/*  721 */         return " Order By T_Main.FLineType,TA.FLongNumber, T_Main.FTag,currency.fnumber,com.flongnumber,FAsstNumberGroup ASC";
/*      */       }
/*  723 */       return " Order By T_Main.FLineType,TA.FLongNumber,com.flongnumber,FAsstNumberGroup ASC";
/*      */     }
/*      */ 
/*  726 */     if (partner.getFixCondition().isAllCurrency()) {
/*  727 */       return " Order By T_Main.FLineType,TA.FLongNumber, T_Main.FTag,currency.fnumber,FAsstNumberGroup ASC";
/*      */     }
/*  729 */     return " Order By T_Main.FLineType,TA.FLongNumber,FAsstNumberGroup ASC";
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getReportName()
/*      */   {
/*  740 */     return "GLReportJournal";
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected String getAuthorityName()
/*      */   {
/*  749 */     return "GLReportJournal";
/*      */   }
/*      */
/*      */   protected String getQueryName()
/*      */   {
/*  754 */     return "com.kingdee.eas.fi.gl.app.GLReportJournalQuery";
/*      */   }
/*      */
/*      */   protected ReportTableHeadInfo getDefalutTableHeadInfo(ReportPartner partner) throws ReportException
/*      */   {
/*  759 */     List items = new ArrayList();
/*  760 */     items.add(addHeadItemInfo("FAccountNumber", 80, 0, true, true, true, new String[] { "AccountCode", "AccountCode" }, 0, 0, false));
/*  761 */     items.add(addHeadItemInfo("FAccountName", 160, 0, true, true, true, new String[] { "AccountName", "AccountName" }, 0, 0, false));
/*      */ 
/*  763 */     items.add(addHeadItemInfo("FCurrencyName", 80, 0, true, false, false, new String[] { "CurrencyName", "CurrencyName" }, 0, 0, false));
/*  764 */     items.add(addHeadItemInfo("FCompany", 200, 0, true, false, true, new String[] { "FCompany", "FCompany" }, 0, 0, false));
/*      */ 
/*  766 */     items.add(addHeadItemInfo("FBalBeginOritention", 30, 1, false, false, true, new String[] { "BalanceBegin", "Oriention" }, 0, 0, false));
/*  767 */     items.add(addHeadItemInfo("FBalanceBeginFor", 110, 2, false, false, true, new String[] { "BalanceBegin", "Amount" }, 1, 0, true));
/*  768 */     items.add(addHeadItemInfo("FBalanceBeginLocal", 0, 2, false, false, false, new String[] { "BalanceBegin", "Amount" }, 1, 0, true));
/*  769 */     items.add(addHeadItemInfo("FBalanceBeginRpt", 0, 2, false, false, false, new String[] { "BalanceBegin", "Amount" }, 1, 0, true));
/*  770 */     items.add(addHeadItemInfo("FDebitFor", 110, 2, false, false, true, new String[] { "Debit", "Debit" }, 1, 0, true));
/*  771 */     items.add(addHeadItemInfo("FDebitLocal", 0, 2, false, false, false, new String[] { "Debit", "Debit" }, 1, 0, true));
/*  772 */     items.add(addHeadItemInfo("FDebitRpt", 0, 2, false, false, false, new String[] { "Debit", "Debit" }, 1, 0, true));
/*  773 */     items.add(addHeadItemInfo("FCreditFor", 110, 2, false, false, true, new String[] { "Credit", "Credit" }, 1, 0, true));
/*  774 */     items.add(addHeadItemInfo("FCreditLocal", 0, 2, false, false, false, new String[] { "Credit", "Credit" }, 1, 0, true));
/*  775 */     items.add(addHeadItemInfo("FCreditRpt", 0, 2, false, false, false, new String[] { "Credit", "Credit" }, 1, 0, true));
/*      */ 
/*  777 */     items.add(addHeadItemInfo("FBalEndOritention", 30, 1, false, false, true, new String[] { "BalanceEnd", "Oriention" }, 0, 0, false));
/*  778 */     items.add(addHeadItemInfo("FBalanceEndFor", 110, 2, false, false, true, new String[] { "BalanceEnd", "Amount" }, 1, 0, true));
/*  779 */     items.add(addHeadItemInfo("FBalanceEndLocal", 0, 2, false, false, false, new String[] { "BalanceEnd", "Amount" }, 1, 0, true));
/*  780 */     items.add(addHeadItemInfo("FBalanceEndRpt", 0, 2, false, false, false, new String[] { "BalanceEnd", "Amount" }, 1, 0, true));
/*  781 */     items.add(addHeadItemInfo("FDebitNumber", 90, 2, false, false, true, new String[] { "DebitNumber", "DebitNumber" }, 0, 0, false));
/*  782 */     items.add(addHeadItemInfo("FCreditNumber", 90, 2, false, false, true, new String[] { "CreditNumber", "CreditNumber" }, 0, 0, false));
/*      */ 
/*  784 */     ReportTableHeadItemInfo[] columns = new ReportTableHeadItemInfo[items.size()];
/*  785 */     for (int i = 0; i < items.size(); ++i) {
/*  786 */       columns[i] = ((ReportTableHeadItemInfo)items.get(i));
/*      */     }
/*      */ 
/*  789 */     ReportTableHeadInfo head = new ReportTableHeadInfo(columns);
/*  790 */     head.setHeadMerge(true);
/*      */ 
/*  792 */     if (!(head.check()))
/*      */     {
/*  794 */       throw new ReportException(ReportException.TABLE_HEAD_ERROR);
/*      */     }
/*      */ 
/*  797 */     return head;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected void insertDataIntoTempTable(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/*  810 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*      */ 
/*  812 */     PeriodInfo theNearPeriod = getNearPeriod(partner);
/*  813 */     String strStructure = getTempTableStructure(partner);
/*  814 */     String strTempTable = partner.createTempTableAsynchronism("GLJUR", strStructure);
/*  815 */     partner.setTempTableName(strTempTable);
/*      */
/*      */
/*      */ 
/*  819 */     insertTempDataAcct(partner, strTempTable, theNearPeriod);
/*      */ 
/*  821 */     if (condition.isOptionShowAsstItem()) {
/*  822 */       insertTempDataAsst(partner, strTempTable, theNearPeriod);
/*      */     }
/*      */ 
/*  825 */     insertNotUseAccount(partner, strTempTable);
/*      */ 
/*  827 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
/*  828 */       if (partner.getFixCondition().isAllCurrency())
/*      */       {
/*  830 */         insertSumAccountCurrencyUnion(partner);
/*      */
/*      */       }
/*  833 */       else if (condition.isOptionShowTotal())
/*  834 */         insertSumAccountGroupByCurrencyUnion(partner);
/*      */     }
/*      */     else
/*      */     {
/*  838 */       if (!(partner.getFixCondition().isAllCurrency()))
/*      */         return;
/*  840 */       insertSumAccountCurrency(partner);
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
/*      */   private PeriodInfo getNearPeriod(ReportPartner partner)
/*      */     throws EASBizException, BOSException, ReportJournalException, ReportException
/*      */   {
/*  857 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*      */ 
/*  859 */     PeriodInfo theNearPeriod = getTheNearPeriod(partner, condition.getDateBegin());
/*  860 */     if (theNearPeriod == null)
/*      */     {
/*  862 */       throw new ReportJournalException(ReportJournalException.JOURNAL_PERIOD_NOTEXSITING);
/*      */     }
/*      */ 
/*  865 */     PeriodInfo currentPeriod = null;
/*  866 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/*  867 */       currentPeriod = getVirturePeriod(partner);
/*      */     else {
/*  869 */       currentPeriod = partner.getCurrentPeriod();
/*      */     }
/*      */ 
/*  872 */     if (currentPeriod == null) {
/*  873 */       throw new ReportException(ReportException.CURRENCY_PERIOD_ERROR);
/*      */     }
/*      */ 
/*  876 */     if ((currentPeriod.getNumber() < theNearPeriod.getNumber()) && (currentPeriod.getNumber() != 0)) {
/*  877 */       theNearPeriod = currentPeriod;
/*      */     }
/*      */ 
/*  880 */     for (int i = 0; (i < 2) && (theNearPeriod.isIsAdjustPeriod()); ++i) {
/*  881 */       PeriodInfo period = PeriodUtils.getPrePeriodInfo(partner.getContext(), theNearPeriod);
/*  882 */       if (period == null) break;
/*  883 */       theNearPeriod = period;
/*      */
/*      */     }
/*      */ 
/*  887 */     return theNearPeriod;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertNotUseAccount(ReportPartner partner, String strFirstTempTableName)
/*      */     throws EASBizException, BOSException
/*      */   {
/*  899 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*  900 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/*  901 */       return;
/*      */     }
/*  903 */     StringBuffer sql = new StringBuffer();
/*  904 */     sql.append(" INSERT INTO ").append(strFirstTempTableName).append(" \r\n");
/*  905 */     sql.append(" SELECT FID FAccountID, \r\n");
/*  906 */     sql.append("'");
/*  907 */     String currencyID = partner.getFixCondition().getCurrencyID();
/*  908 */     sql.append((currencyID == null) ? " " : currencyID);
/*  909 */     sql.append("' FCurrencyID, TA.FCompanyID,null FAsstHgID, \r\n");
/*  910 */     sql.append(" 0.0 FBeginBalanceFor, \r\n");
/*  911 */     sql.append(" 0.0 FBeginBalanceLocal, \r\n");
/*  912 */     sql.append(" 0.0 FBeginBalanceRpt, \r\n");
/*  913 */     sql.append(" 0.0 FDebitFor, \r\n");
/*  914 */     sql.append(" 0.0 FDebitLocal , \r\n");
/*  915 */     sql.append(" 0.0 FDebitRpt, \r\n");
/*  916 */     sql.append(" 0.0 FCreditFor, \r\n");
/*  917 */     sql.append(" 0.0 FCreditLocal, \r\n");
/*  918 */     sql.append(" 0.0 FCreditRpt, \r\n");
/*  919 */     sql.append(" 0.0 FEndBalanceFor, \r\n");
/*  920 */     sql.append(" 0.0 FEndBalanceLocal, \r\n");
/*  921 */     sql.append(" 0.0 FEndBalanceRpt, \r\n");
/*  922 */     sql.append(" 0 FDebitCount, \r\n");
/*  923 */     sql.append(" 0 FCredtiCount, \r\n");
/*  924 */     sql.append(" -1 FTag, \r\n");
/*  925 */     sql.append(" 0 FLineType \r\n");
/*  926 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/*  927 */       sql.append(" ,2 AS FAccountOrAssist \r\n");
/*      */     }
/*  929 */     sql.append(" FROM T_BD_AccountView TA \r\n");
/*  930 */     sql.append(" WHERE ");
/*  931 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/*  932 */       sql.append(" TA.FCompanyId in ").append(getStrCompanyIds(partner)).append(" \r\n");
/*      */     else {
/*  934 */       sql.append(" TA.FCompanyId = ? \r\n");
/*      */     }
/*  936 */     sql.append(" AND TA.FAccountTableId = ? \r\n");
/*  937 */     sql.append(" AND (TA.FLevel >=?) AND (TA.FLevel <= ?) \r\n");
/*      */ 
/*  939 */     if ((partner.getCurrencyType() == 0) && (!(condition.isAllCurrency())))
/*  940 */       sql.append(" AND (TA.FCurrencyID = ? OR TA.FCurrencyID IS NULL) \r\n");
/*  941 */     else if (condition.isAllCurrency()) {
/*  942 */       sql.append(" AND TA.FCurrencyID IS NOT NULL \r\n");
/*      */     }
/*      */ 
/*  945 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/*  946 */       sql.append(" AND (TA.FNumber >= ?) \r\n");
/*      */     }
/*      */ 
/*  949 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/*  950 */       sql.append(" AND (TA.FNumber <= ?) \r\n");
/*      */
/*      */     }
/*      */ 
/*  954 */     sql.append(" and not exists (select faccountid from ").append(strFirstTempTableName).append(" temp \r\n");
/*  955 */     sql.append(" where temp.faccountid = ta.fid)");
/*      */ 
/*  957 */     SqlParameter2 parameter = new SqlParameter2();
/*      */ 
/*  959 */     if (!(GlUtils.isCompanyUnion(partner.getCompany()))) {
/*  960 */       parameter.addValueChar(partner.getCompanyId());
/*      */     }
/*  962 */     parameter.addValueChar(partner.getAccountTableId());
/*  963 */     parameter.addValue(new Integer(condition.getAccountLevelStart()));
/*  964 */     parameter.addValue(new Integer(condition.getAccountLevelEnd()));
/*      */ 
/*  966 */     if ((partner.getCurrencyType() == 0) && (!(condition.isAllCurrency()))) {
/*  967 */       parameter.addValueChar(partner.getFixCondition().getCurrencyID());
/*      */     }
/*      */ 
/*  970 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/*  971 */       parameter.addValueVarchar(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/*  974 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/*  975 */       parameter.addValueVarchar(condition.getAccountCodeEnd() + "~~");
/*      */
/*      */     }
/*      */ 
/*  979 */     partner.executeSql(sql.toString(), parameter);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertTempDataAcct(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/*  988 */     if (theNearPeriod == null) {
/*  989 */       return;
/*      */     }
/*      */ 
/*  992 */     insertTempDataAcctBalance(partner, strFirstTempTableName, theNearPeriod);
/*      */ 
/*  994 */     insertTempDataAcctVoucher(partner, strFirstTempTableName, theNearPeriod);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertTempDataAcctBalance(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1007 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1008 */     StringBuffer strBuffer = new StringBuffer();
/*      */
/*      */ 
/* 1011 */     strBuffer.append(" SELECT tb.FAccountID AS FAccountID,tb.FCurrencyID as FCurrencyID,tb.forgunitID as FCompanyID , null as FAsstHgID, \r\n");
/* 1012 */     strBuffer.append(" tb.FBeginBalanceFor AS FBeginBalanceFor,\r\n");
/* 1013 */     strBuffer.append(" tb.FBeginBalanceLocal AS FBeginBalanceLocal,\r\n");
/* 1014 */     strBuffer.append(" tb.FBeginBalanceRpt AS FBeginBalanceRpt,\r\n");
/* 1015 */     strBuffer.append(" 0.0 AS FDebitFor, \r\n");
/* 1016 */     strBuffer.append(" 0.0 AS FDebitLocal, \r\n");
/* 1017 */     strBuffer.append(" 0.0 AS FDebitRpt, \r\n");
/* 1018 */     strBuffer.append(" 0.0 AS FCreditFor, \r\n");
/* 1019 */     strBuffer.append(" 0.0 AS FCreditLocal, \r\n");
/* 1020 */     strBuffer.append(" 0.0 AS FCreditRpt, \r\n");
/* 1021 */     strBuffer.append(" tb.FBeginBalanceFor AS FEndBalanceFor, \r\n");
/* 1022 */     strBuffer.append(" tb.FBeginBalanceLocal AS FEndBalanceLocal, \r\n");
/* 1023 */     strBuffer.append(" tb.FBeginBalanceRpt AS FEndBalanceRpt, \r\n");
/* 1024 */     strBuffer.append(" 0 AS FDebitCount, \r\n");
/* 1025 */     strBuffer.append(" 0 AS FCredtiCount, \r\n");
/* 1026 */     strBuffer.append(" -1 FTag , \r\n");
/* 1027 */     strBuffer.append(" 0 FLineType \r\n");
/* 1028 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/* 1029 */       strBuffer.append(" ,2 AS FAccountOrAssist  \r\n");
/*      */     }
/* 1031 */     strBuffer.append(" FROM T_GL_AccountBalance as tb \r\n");
/* 1032 */     strBuffer.append(" INNER JOIN T_BD_AccountView as ta ON tb.fAccountID = ta.fid \r\n");
/* 1033 */     strBuffer.append(" WHERE ");
/*      */ 
/* 1035 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/*      */     {
/* 1037 */       strBuffer.append("(( tb.FOrgUnitID in ").append(getStrCompanyIds(partner)).append(" AND tb.FPeriodID = ? ");
/*      */ 
/* 1039 */       strBuffer.append(" and tb.forgunitid not in (select sysctrl.FCompanyID from T_BD_SYSTEMSTATUSCTROL sysctrl \r\n");
/* 1040 */       strBuffer.append(" INNER JOIN T_BD_SYSTEMSTATUS tsst ON sysctrl.FSystemStatusID=tsst.FID \r\n");
/* 1041 */       strBuffer.append(" inner join t_bd_period p on sysctrl.FStartPeriodID = p.fid \r\n");
/* 1042 */       strBuffer.append(" where tsst.FName=6 AND sysctrl.FISSTART=1 and sysctrl.FCompanyID in ").append(getStrCompanyIds(partner));
/* 1043 */       strBuffer.append(" and p.fnumber > ? )) \r\n");
/*      */ 
/* 1045 */       strBuffer.append(" or exists (select 1 from T_BD_SYSTEMSTATUSCTROL sysctrl \r\n");
/* 1046 */       strBuffer.append(" INNER JOIN T_BD_SYSTEMSTATUS tsst ON sysctrl.FSystemStatusID=tsst.FID \r\n");
/* 1047 */       strBuffer.append(" inner join t_bd_period p on sysctrl.FStartPeriodID = p.fid \r\n");
/* 1048 */       strBuffer.append(" where tsst.FName=6 AND sysctrl.FISSTART=1 and sysctrl.FCompanyID in ").append(getStrCompanyIds(partner));
/* 1049 */       strBuffer.append(" and p.fnumber > ? and tb.FOrgUnitID=sysctrl.FCompanyID and tb.FPeriodID=sysctrl.FStartPeriodID)");
/* 1050 */       strBuffer.append(" )\r\n");
/*      */     } else {
/* 1052 */       strBuffer.append(" tb.FOrgUnitID = ? AND tb.FPeriodID = ? \r\n");
/*      */     }
/*      */ 
/* 1055 */     strBuffer.append(" AND tb.FBalType = ? \r\n");
/*      */ 
/* 1057 */     if ((condition.getCurrencyID() != null) && (condition.getCurrencyID().trim().length() != 0) && (!(condition.isAllCurrency())))
/* 1058 */       strBuffer.append(" AND tb.FCurrencyID = ?  \r\n");
/* 1059 */     else if (condition.isAllCurrency()) {
/* 1060 */       strBuffer.append(" AND tb.FCurrencyID <> ? and tb.FCurrencyID <> ?  \r\n");
/*      */     }
/*      */ 
/* 1063 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1064 */       strBuffer.append(" AND (TA.FNumber >= ?)  \r\n");
/*      */     }
/*      */ 
/* 1067 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1068 */       strBuffer.append(" AND (TA.FNumber <= ?)  \r\n");
/*      */     }
/*      */ 
/* 1071 */     SqlParameter2 parameter = new SqlParameter2();
/*      */
/*      */ 
/* 1074 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
/* 1075 */       parameter.addValueId(theNearPeriod);
/* 1076 */       parameter.addValue(theNearPeriod.getNumber());
/* 1077 */       parameter.addValue(theNearPeriod.getNumber());
/*      */     }
/*      */     else {
/* 1080 */       parameter.addValueChar(partner.getCompanyId());
/* 1081 */       parameter.addValueId(theNearPeriod);
/*      */     }
/*      */ 
/* 1084 */     parameter.addValue((condition.getOptionPosting()) ? 1 : 5);
/*      */ 
/* 1086 */     if ((condition.getCurrencyID() != null) && (condition.getCurrencyID().trim().length() != 0) && (!(condition.isAllCurrency()))) {
/* 1087 */       parameter.addValueChar(condition.getCurrencyID());
/* 1088 */     } else if (condition.isAllCurrency()) {
/* 1089 */       parameter.addValueChar("11111111-1111-1111-1111-111111111111DEB58FDC");
/* 1090 */       parameter.addValueChar("22222222-2222-2222-2222-222222222222DEB58FDC");
/*      */     }
/*      */ 
/* 1093 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1094 */       parameter.addValue(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/* 1097 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1098 */       parameter.addValue(condition.getAccountCodeEnd() + "~");
/*      */     }
/*      */ 
/* 1101 */     Connection cn = null;
/* 1102 */     PreparedStatement stmt = null;
/*      */     try {
/* 1104 */       cn = partner.getConnection();
/*      */ 
/* 1106 */       stmt = cn.prepareStatement(" insert into " + strFirstTempTableName + strBuffer.toString());
/* 1107 */       parameter.putToStatement(stmt);
/* 1108 */       stmt.executeUpdate();
/* 1109 */       stmt.close();
/*      */     }
/*      */     catch (SQLException e) {
/* 1112 */       throw new SQLDataException(e);
/*      */     } finally {
/* 1114 */       SQLUtils.cleanup(stmt);
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
/*      */   private void insertTempDataAcctVoucher(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1128 */     java.util.Date dateStart = theNearPeriod.getBeginDate();
/* 1129 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1130 */     java.util.Date dateEnd = condition.getDateBegin();
/* 1131 */     GregorianCalendar calendar = new GregorianCalendar();
/* 1132 */     calendar.setTime(dateEnd);
/* 1133 */     calendar.add(5, -1);
/* 1134 */     dateEnd = calendar.getTime();
/*      */
/*      */ 
/* 1137 */     String strTableVoucherToBegin = getVoucherTableForJournal(partner, dateStart, dateEnd);
/*      */
/*      */ 
/* 1140 */     StringBuffer sqlToBegin = new StringBuffer();
/* 1141 */     sqlToBegin.append(" SELECT FAccountID ,FCurrencyID, FCompanyID,null as FAsstHgID, \r\n");
/* 1142 */     sqlToBegin.append(" FDebitFor - FCreditFor AS FBeginBalanceFor, \r\n");
/* 1143 */     sqlToBegin.append(" FDebitLocal - FCreditLocal AS FBeginBalanceLocal, \r\n");
/* 1144 */     sqlToBegin.append(" FDebitRpt - FCreditRpt AS FBeginBalanceRpt, \r\n");
/* 1145 */     sqlToBegin.append(" 0.0 AS FDebitFor, \r\n");
/* 1146 */     sqlToBegin.append(" 0.0 AS FDebitLocal, \r\n");
/* 1147 */     sqlToBegin.append(" 0.0 AS FDebitRpt, \r\n");
/* 1148 */     sqlToBegin.append(" 0.0 AS FCreditFor, \r\n");
/* 1149 */     sqlToBegin.append(" 0.0 AS FCreditLocal, \r\n");
/* 1150 */     sqlToBegin.append(" 0.0 AS FCreditRpt, \r\n");
/* 1151 */     sqlToBegin.append(" FDebitFor - FCreditFor AS FEndBalanceFor, \r\n");
/* 1152 */     sqlToBegin.append(" FDebitLocal - FCreditLocal AS FEndBalanceLocal, \r\n");
/* 1153 */     sqlToBegin.append(" FDebitRpt - FCreditRpt AS FEndBalanceRpt, \r\n");
/* 1154 */     sqlToBegin.append(" 0 AS FDebitCount, \r\n");
/* 1155 */     sqlToBegin.append(" 0 AS FCredtiCount, \r\n");
/* 1156 */     sqlToBegin.append(" -1 as ftag, \r\n");
/* 1157 */     sqlToBegin.append(" 0 as FLineType \r\n");
/*      */ 
/* 1159 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/* 1160 */       sqlToBegin.append(" ,2 as FAccountOrAssist");
/*      */     }
/* 1162 */     sqlToBegin.append(" FROM " + strTableVoucherToBegin);
/*      */
/*      */
/*      */
/*      */ 
/* 1167 */     dateStart = condition.getDateBegin();
/* 1168 */     dateEnd = condition.getDateEnd();
/*      */
/*      */ 
/* 1171 */     String strTableVoucherToEnd = getVoucherTableForJournal(partner, dateStart, dateEnd);
/*      */ 
/* 1173 */     StringBuffer sqlToEnd = new StringBuffer();
/* 1174 */     sqlToEnd.append(" SELECT FAccountID ,FCurrencyID, FCompanyID,null as FAsstHgID, \r\n");
/* 1175 */     sqlToEnd.append(" 0.0 AS FBeginBalanceFor, \r\n");
/* 1176 */     sqlToEnd.append(" 0.0 AS FBeginBalanceLocal , \r\n");
/* 1177 */     sqlToEnd.append(" 0.0 AS FBeginBalanceRpt, \r\n");
/* 1178 */     sqlToEnd.append(" FDebitFor AS FDebitFor, \r\n");
/* 1179 */     sqlToEnd.append(" FDebitLocal AS FDebitLocal , \r\n");
/* 1180 */     sqlToEnd.append(" FDebitRpt AS FDebitRpt, \r\n");
/* 1181 */     sqlToEnd.append(" FCreditFor AS FCreditFor, \r\n");
/* 1182 */     sqlToEnd.append(" FCreditLocal AS FCreditLocal, \r\n");
/* 1183 */     sqlToEnd.append(" FCreditRpt AS FCreditRpt,\r\n");
/* 1184 */     sqlToEnd.append(" FDebitFor - FCreditFor AS FEndBalanceFor, \r\n");
/* 1185 */     sqlToEnd.append(" FDebitLocal - FCreditLocal AS FEndBalanceLocal,\r\n");
/* 1186 */     sqlToEnd.append(" FDebitRpt - FCreditRpt AS FEndBalanceRpt,  \r\n");
/* 1187 */     sqlToEnd.append(" FDebitCount AS FDebitCount,\r\n");
/* 1188 */     sqlToEnd.append(" FCreditCount AS FCredtiCount, \r\n");
/* 1189 */     sqlToEnd.append(" -1 as ftag, \r\n");
/* 1190 */     sqlToEnd.append(" 0 as FLineType \r\n");
/*      */ 
/* 1192 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/* 1193 */       sqlToEnd.append(" ,2 as FAccountOrAssist");
/*      */     }
/* 1195 */     sqlToEnd.append(" FROM " + strTableVoucherToEnd);
/*      */ 
/* 1197 */     Connection cn = null;
/* 1198 */     PreparedStatement stmtToBegin = null;
/* 1199 */     PreparedStatement stmtToEnd = null;
/*      */     try {
/* 1201 */       cn = partner.getConnection();
/* 1202 */       stmtToBegin = cn.prepareStatement(" insert into " + strFirstTempTableName + sqlToBegin.toString());
/* 1203 */       stmtToBegin.executeUpdate();
/* 1204 */       stmtToBegin.close();
/* 1205 */       stmtToEnd = cn.prepareStatement(" insert into " + strFirstTempTableName + sqlToEnd.toString());
/* 1206 */       stmtToEnd.executeUpdate();
/* 1207 */       stmtToEnd.close();
/*      */     }
/*      */     catch (SQLException e) {
/*      */     }
/*      */     finally {
/* 1212 */       SQLUtils.cleanup(stmtToBegin);
/* 1213 */       SQLUtils.cleanup(stmtToEnd);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */   private String getVoucherTableForJournal(ReportPartner partner, java.util.Date dateStart, java.util.Date dateEnd)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1221 */     String strTempTable = null;
/* 1222 */     String voucherTableCreateSql = getVoucherTableCreateSql();
/* 1223 */     String strFirstTempTable = partner.createTempTableAsynchronism("GLJUT1", voucherTableCreateSql, true);
/* 1224 */     StringBuffer strBuffer = new StringBuffer();
/*      */ 
/* 1226 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1227 */     String strCurrencyID = condition.getCurrencyID();
/* 1228 */     strBuffer.append(" SELECT D.FAccountID AS FAccountID,\r\n");
/*      */ 
/* 1230 */     if ((strCurrencyID != null) && (((strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString())) || (strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString())))) && (!(condition.isAllCurrency())))
/*      */
/*      */     {
/* 1233 */       strBuffer.append("'" + strCurrencyID + "'").append(" AS FCurrencyID,\r\n");
/*      */     }
/*      */     else strBuffer.append(" D.FCurrencyID AS FCurrencyID,\r\n");
/*      */ 
/* 1237 */     strBuffer.append(" M.FCompanyID AS FCompanyID,null as FAsstHgID, \r\n");
/*      */ 
/* 1239 */     if ((strCurrencyID != null) && (strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString()))) {
/* 1240 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 1241 */       strBuffer.append(" THEN D.FLocalAmount ELSE 0 END) AS FDebitFor, \r\n");
/* 1242 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 1243 */       strBuffer.append(" THEN D.FLocalAmount ELSE 0 END) AS FCreditFor, \r\n");
/* 1244 */     } else if ((strCurrencyID != null) && (strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString()))) {
/* 1245 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 1246 */       strBuffer.append(" THEN D.FReportingAmount ELSE 0 END) AS FDebitFor, \r\n");
/* 1247 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 1248 */       strBuffer.append(" THEN D.FReportingAmount ELSE 0 END) AS FCreditFor, \r\n");
/*      */     } else {
/* 1250 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 1251 */       strBuffer.append(" THEN D.FOriginalAmount ELSE 0 END) AS FDebitFor, \r\n");
/* 1252 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 1253 */       strBuffer.append(" THEN D.FOriginalAmount ELSE 0 END) AS FCreditFor, \r\n");
/*      */
/*      */     }
/*      */ 
/* 1257 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 1258 */     strBuffer.append(" THEN D.FLocalAmount ELSE 0 END) AS FDebitLocal, \r\n");
/* 1259 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 1260 */     strBuffer.append(" THEN D.FLocalAmount ELSE 0 END) AS FCreditLocal, \r\n");
/*      */
/*      */ 
/* 1263 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 1264 */     strBuffer.append(" THEN D.FReportingAmount ELSE 0 END) AS FDebitRpt, \r\n");
/* 1265 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 1266 */     strBuffer.append(" THEN D.FReportingAmount ELSE 0 END) AS FCreditRpt, \r\n");
/*      */
/*      */ 
/* 1269 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 1270 */     strBuffer.append(" THEN 1 ELSE 0 END) AS FDebitCount, \r\n");
/* 1271 */     strBuffer.append("(CASE D.FEntryDC WHEN ").append(0);
/* 1272 */     strBuffer.append(" THEN 1 ELSE 0 END) AS FCreditCount \r\n");
/*      */ 
/* 1274 */     strBuffer.append(" FROM T_GL_Voucher AS M  \r\n");
/* 1275 */     strBuffer.append(" INNER JOIN T_GL_VoucherEntry AS D ON M.FID = D.FBillID \r\n");
/* 1276 */     strBuffer.append(" inner join t_bd_accountview ta on ta.fid = D.faccountid");
/* 1277 */     strBuffer.append(" WHERE (M.FBizStatus = ? \r\n");
/*      */ 
/* 1279 */     if (condition.getOptionPosting()) {
/* 1280 */       strBuffer.append(" OR M.FBizStatus = ? \r\n");
/* 1281 */       strBuffer.append(" OR M.FBizStatus = ? \r\n");
/*      */     }
/* 1283 */     strBuffer.append(")  \r\n");
/*      */ 
/* 1285 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/* 1286 */       strBuffer.append("\tAND M.FCompanyID in ").append(getStrCompanyIds(partner)).append(" \r\n");
/*      */     else {
/* 1288 */       strBuffer.append("\tAND M.FCompanyID = ? \r\n");
/*      */     }
/* 1290 */     strBuffer.append(" AND TA.FACCOUNTTABLEID = ?");
/*      */
/*      */ 
/* 1293 */     if ((strCurrencyID != null) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString()))) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString()))) && (!(condition.isAllCurrency())))
/*      */     {
/* 1295 */       strBuffer.append(" AND D.FCurrencyID = ? \r\n");
/*      */     }
/*      */ 
/* 1298 */     strBuffer.append(" AND M.FBookedDate >= ? AND M.FBookedDate <= ? \r\n");
/*      */ 
/* 1300 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1301 */       strBuffer.append(" AND (TA.FNumber >= ?) \r\n");
/*      */     }
/*      */ 
/* 1304 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1305 */       strBuffer.append(" AND (TA.FNumber <= ?) \r\n");
/*      */     }
/* 1307 */     Connection cn = null;
/* 1308 */     PreparedStatement stmt = null;
/* 1309 */     String strInsert = "Insert into " + strFirstTempTable + " " + strBuffer.toString();
/*      */     try {
/* 1311 */       cn = partner.getConnection();
/* 1312 */       stmt = cn.prepareStatement(strInsert);
/*      */
/*      */ 
/* 1315 */       SqlParameter2 parameter = new SqlParameter2();
/*      */ 
/* 1317 */       parameter.addValue(5);
/* 1318 */       if (condition.getOptionPosting()) {
/* 1319 */         parameter.addValue(1);
/* 1320 */         parameter.addValue(3);
/*      */       }
/*      */ 
/* 1323 */       if (!(GlUtils.isCompanyUnion(partner.getCompany()))) {
/* 1324 */         parameter.addValueChar(partner.getCompanyId());
/*      */       }
/* 1326 */       parameter.addValueChar(partner.getAccountTableId());
/*      */ 
/* 1328 */       if ((strCurrencyID != null) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString()))) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString()))) && (!(condition.isAllCurrency())))
/*      */       {
/* 1330 */         parameter.addValueChar(condition.getCurrencyID());
/*      */       }
/* 1332 */       parameter.addValue(new java.sql.Date(dateStart.getTime()));
/* 1333 */       parameter.addValue(new java.sql.Date(dateEnd.getTime()));
/*      */
/*      */ 
/* 1336 */       if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1337 */         parameter.addValueChar(condition.getAccountCodeStart());
/*      */
/*      */       }
/*      */ 
/* 1341 */       if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1342 */         parameter.addValueChar(condition.getAccountCodeEnd() + "~");
/*      */
/*      */       }
/*      */ 
/* 1346 */       parameter.putToStatement(stmt);
/* 1347 */       stmt.executeUpdate();
/*      */
/*      */ 
/* 1350 */       stmt.close();
/*      */
/*      */ 
/* 1353 */       strTempTable = partner.createTempTableAsynchronism("GLJUT2", voucherTableCreateSql, true);
/*      */ 
/* 1355 */       strBuffer = new StringBuffer();
/* 1356 */       strBuffer.append(" SELECT Max(TA.Flevel)");
/* 1357 */       strBuffer.append(" FROM ").append(strFirstTempTable).append(" AS V \r\n");
/* 1358 */       strBuffer.append(" INNER JOIN T_BD_AccountView AS TA ON V.FAccountID = TA.FID \r\n");
/* 1359 */       strBuffer.append(" WHERE TA.FAccountTableId = ? ");
/*      */ 
/* 1361 */       cn = partner.getConnection();
/* 1362 */       parameter = new SqlParameter2();
/* 1363 */       stmt = cn.prepareStatement(strBuffer.toString());
/* 1364 */       parameter.addValueChar(partner.getAccountTableId());
/* 1365 */       parameter.putToStatement(stmt);
/*      */ 
/* 1367 */       ResultSet rs = stmt.executeQuery();
/* 1368 */       String firstTable = "T_BD_AccountView";
/* 1369 */       if ((rs.next()) && (rs.getObject(1) != null)) {
/* 1370 */         int maxLevel = rs.getInt(1);
/*      */
/*      */ 
/* 1373 */         StringBuffer sql = new StringBuffer();
/* 1374 */         sql.append("insert into ").append(strFirstTempTable);
/* 1375 */         sql.append(" \r\n select ");
/* 1376 */         sql.append(" C.fid,A.fcurrencyid, \r\n");
/* 1377 */         sql.append(" A.FCompanyID, \r\n");
/* 1378 */         sql.append(" null,sum(A.FDebitFor), \r\n");
/* 1379 */         sql.append(" sum(A.FCreditFor), \r\n");
/* 1380 */         sql.append(" sum(A.FDebitLocal), \r\n");
/* 1381 */         sql.append(" sum(A.FCreditLocal), \r\n");
/* 1382 */         sql.append(" sum(A.FDebitRpt), \r\n");
/* 1383 */         sql.append(" sum(A.FCreditRpt), \r\n");
/* 1384 */         sql.append(" sum(A.FDebitCount), \r\n");
/* 1385 */         sql.append(" sum(A.FCreditCount) \r\n");
/* 1386 */         sql.append(" from ").append(strFirstTempTable).append(" A \r\n");
/* 1387 */         sql.append(" inner join ").append(firstTable).append(" B on B.FID=A.FAccountID and B.FLevel=? \r\n");
/* 1388 */         sql.append(" inner join ").append(firstTable).append(" C on C.FID=B.FParentID \r\n");
/* 1389 */         sql.append("  group by C.fid,A.fcurrencyid,A.FCompanyID");
/* 1390 */         for (int i = maxLevel; i > 1; --i) {
/* 1391 */           parameter = new SqlParameter2();
/* 1392 */           parameter.addValue(i);
/* 1393 */           stmt = cn.prepareStatement(sql.toString());
/* 1394 */           parameter.putToStatement(stmt);
/* 1395 */           stmt.executeUpdate();
/*      */         }
/*      */       }
/* 1398 */       strInsert = "Insert into " + strTempTable + " select * from " + strFirstTempTable;
/* 1399 */       stmt = cn.prepareStatement(strInsert);
/* 1400 */       parameter.clear();
/* 1401 */       parameter.putToStatement(stmt);
/*      */ 
/* 1403 */       stmt.executeUpdate();
/* 1404 */       stmt.close();
/*      */     } catch (SQLException sqle) {
/* 1406 */       logger.error(sqle);
/*      */ 
/* 1408 */       throw new SQLDataException(sqle);
/*      */     } finally {
/* 1410 */       SQLUtils.cleanup(stmt);
/*      */
/*      */     }
/*      */ 
/* 1414 */     partner.dropTempTable(strFirstTempTable);
/* 1415 */     return strTempTable;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   private String getVoucherTableCreateSql()
/*      */   {
/* 1423 */     StringBuffer sql = new StringBuffer();
/* 1424 */     sql.append("(");
/* 1425 */     sql.append(" FAccountID varchar(44), \r\n");
/* 1426 */     sql.append(" FCurrencyID varchar(44), \r\n");
/* 1427 */     sql.append(" FCompanyID VARCHAR(44), \r\n");
/* 1428 */     sql.append(" FAsstHgID varchar(44), \r\n");
/* 1429 */     sql.append(" FDebitFor DECIMAL(28,10), \r\n");
/* 1430 */     sql.append(" FCreditFor DECIMAL(28,10), \r\n");
/* 1431 */     sql.append(" FDebitLocal DECIMAL(28,10), \r\n");
/* 1432 */     sql.append(" FCreditLocal DECIMAL(28,10), \r\n");
/* 1433 */     sql.append(" FDebitRpt DECIMAL(28,10), \r\n");
/* 1434 */     sql.append(" FCreditRpt DECIMAL(28,10), \r\n");
/* 1435 */     sql.append(" FDebitCount INT, \r\n");
/* 1436 */     sql.append(" FCreditCount INT ");
/* 1437 */     sql.append(" )");
/* 1438 */     return sql.toString();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   private PeriodInfo getTheNearPeriod(ReportPartner partner, java.util.Date date)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1447 */     SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
/* 1448 */     java.util.Date newDate = null;
/*      */     try {
/* 1450 */       newDate = f.parse(f.format(date));
/*      */     }
/*      */     catch (ParseException e) {
/* 1453 */       throw new ReportException(ReportException.TODO_UNTYPE, e);
/*      */     }
/*      */ 
/* 1456 */     IPeriod periodCtrl = PeriodFactory.getLocalInstance(partner.getContext());
/*      */ 
/* 1458 */     EntityViewInfo view = new EntityViewInfo();
/*      */ 
/* 1460 */     SelectorItemCollection sic = view.getSelector();
/* 1461 */     sic.add(new SelectorItemInfo("id"));
/* 1462 */     sic.add(new SelectorItemInfo("periodYear"));
/* 1463 */     sic.add(new SelectorItemInfo("periodQuarter"));
/* 1464 */     sic.add(new SelectorItemInfo("periodNumber"));
/* 1465 */     sic.add(new SelectorItemInfo("beginDate"));
/* 1466 */     sic.add(new SelectorItemInfo("endDate"));
/* 1467 */     sic.add(new SelectorItemInfo("Number"));
/*      */ 
/* 1469 */     FilterInfo filter = new FilterInfo();
/* 1470 */     view.setFilter(filter);
/*      */ 
/* 1472 */     FilterItemCollection fic = filter.getFilterItems();
/* 1473 */     fic.add(new FilterItemInfo("beginDate", newDate, CompareType.LESS_EQUALS));
/* 1474 */     fic.add(new FilterItemInfo("endDate", newDate, CompareType.GREATER_EQUALS));
/* 1475 */     fic.add(new FilterItemInfo("periodType", partner.getCompany().getAccountPeriodType().getId().toString(), CompareType.EQUALS));
/*      */ 
/* 1477 */     filter.setMaskString(" ( #0 ) and ( #1 ) and ( #2 ) ");
/*      */ 
/* 1479 */     PeriodCollection allFiscalTerms = periodCtrl.getPeriodCollection(view);
/*      */ 
/* 1481 */     if ((allFiscalTerms == null) || (allFiscalTerms.size() == 0)) {
/* 1482 */       return null;
/*      */     }
/*      */ 
/* 1485 */     return allFiscalTerms.get(0);
/*      */   }
/*      */
/*      */
/*      */
/*      */   private String getTempTableStructure(ReportPartner partner)
/*      */   {
/* 1492 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1493 */     StringBuffer sql = new StringBuffer();
/* 1494 */     sql.append(" ( ");
/* 1495 */     sql.append(" FAccountID VARCHAR(44), \r\n");
/* 1496 */     sql.append(" FCurrencyID VARCHAR(44), \r\n");
/* 1497 */     sql.append(" FCompanyID VARCHAR(44), \r\n");
/* 1498 */     sql.append(" FAsstHgID VARCHAR(44), \r\n");
/* 1499 */     sql.append(" FBeginBalanceFor DECIMAL(28,10), \r\n");
/* 1500 */     sql.append(" FBeginBalanceLocal DECIMAL(28,10), \r\n");
/* 1501 */     sql.append(" FBeginBalanceRpt DECIMAL(28,10), \r\n");
/* 1502 */     sql.append(" FDebitFor DECIMAL(28,10), \r\n");
/* 1503 */     sql.append(" FDebitLocal DECIMAL(28,10),  \r\n");
/* 1504 */     sql.append(" FDebitRpt DECIMAL(28,10), \r\n");
/* 1505 */     sql.append(" FCreditFor DECIMAL(28,10), \r\n");
/* 1506 */     sql.append(" FCreditLocal DECIMAL(28,10), \r\n");
/* 1507 */     sql.append(" FCreditRpt DECIMAL(28,10), \r\n");
/* 1508 */     sql.append(" FEndBalanceFor DECIMAL(28,10), \r\n");
/* 1509 */     sql.append(" FEndBalanceLocal DECIMAL(28,10), \r\n");
/* 1510 */     sql.append(" FEndBalanceRpt DECIMAL(28,10), \r\n");
/* 1511 */     sql.append(" FDebitCount INT, \r\n");
/* 1512 */     sql.append(" FCredtiCount INT, \r\n");
/*      */ 
/* 1514 */     sql.append(" FTag INT, \r\n");
/* 1515 */     sql.append(" FLineType INT  \r\n ");
/* 1516 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem()))
/*      */     {
/* 1518 */       sql.append("  ,FAccountOrAssist Int \r\n");
/*      */     }
/* 1520 */     sql.append(")");
/* 1521 */     return sql.toString();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   protected void doSomethingBeforeQuery(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1530 */     ReportConditionJournal fixCondition = (ReportConditionJournal)partner.getFixCondition();
/* 1531 */     SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
/* 1532 */     if ((fixCondition.getCurrencyID() == null) && (!(GlUtils.isCompanyUnion(partner.getCompany()))))
/* 1533 */       fixCondition.setCurrencyID("AllCurrency");
/*      */     try
/*      */     {
/* 1536 */       fixCondition.setDateBegin(f.parse(f.format(fixCondition.getDateBegin())));
/* 1537 */       fixCondition.setDateEnd(f.parse(f.format(fixCondition.getDateEnd())));
/*      */     }
/*      */     catch (ParseException e) {
/* 1540 */       throw new ReportException(ReportException.TODO_UNTYPE, e);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected void doSomethingBeforeExecuteSql(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1552 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1553 */     condition.getExpandInfo().put("isNeedAccountID", new Boolean(true));
/*      */ 
/* 1555 */     if (condition.isOptionShowAsstItem()) {
/* 1556 */       condition.getExpandInfo().put("isNeedAccountID", new Boolean(false));
/*      */
/*      */
/*      */ 
/* 1560 */       StringBuffer sqlMax = new StringBuffer();
/* 1561 */       sqlMax.append("Select max(hg.fcount) as fcount");
/* 1562 */       sqlMax.append("\r\n");
/* 1563 */       sqlMax.append(getSqlForDataFrom(partner));
/* 1564 */       sqlMax.append("\r\n");
/* 1565 */       sqlMax.append(getSqlForDataWhere(partner));
/* 1566 */       sqlMax.append("\r\n");
/* 1567 */       condition.getExpandInfo().put("isNeedAccountID", new Boolean(true));
/* 1568 */       PreparedStatement stmt = null;
/* 1569 */       ResultSet result = null;
/*      */       try {
/* 1571 */         stmt = partner.getConnection().prepareStatement(sqlMax.toString());
/* 1572 */         SqlParameter2 params = (SqlParameter2)partner.getVariable("SQL_PARAMETERS");
/* 1573 */         if (params != null) {
/* 1574 */           params.putToStatement(stmt);
/*      */         }
/* 1576 */         result = stmt.executeQuery();
/* 1577 */         result.next();
/* 1578 */         int maxCount = result.getInt("FCount");
/* 1579 */         partner.setVariable("MaxAsstItemCount", new Integer(maxCount));
/*      */       }
/*      */       catch (SQLException sqle) {
/* 1582 */         throw new SQLDataException(sqle);
/*      */       }
/*      */       finally
/*      */       {
/* 1586 */         SQLUtils.cleanup(result, stmt);
/*      */
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1592 */     String strCurrencyId = condition.getCurrencyID();
/* 1593 */     if (strCurrencyId == null)
/*      */     {
/* 1595 */       throw new ReportException(ReportException.TODO_UNTYPE);
/*      */     }
/*      */ 
/* 1598 */     setHeader(partner);
/*      */   }
/*      */
/*      */
/*      */   private void setHeader(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1605 */     List items = new ArrayList();
/*      */ 
/* 1607 */     items.add(addHeadItemInfo("FAccountNumber", 80, 0, true, true, true, new String[] { "AccountCode", "AccountCode" }, 0, 0, false));
/* 1608 */     items.add(addHeadItemInfo("FAccountName", 160, 0, true, true, true, new String[] { "AccountName", "AccountName" }, 0, 0, false));
/*      */ 
/* 1610 */     if (partner.getFixCondition().isAllCurrency()) {
/* 1611 */       items.add(addHeadItemInfo("FCurrencyName", 160, 0, true, true, true, new String[] { "Currency", "Currency" }, 0, 0, false));
/*      */     }
/*      */ 
/* 1614 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
/* 1615 */       items.add(addHeadItemInfo("FCompany", 200, 0, true, false, true, new String[] { "FCompany", "FCompany" }, 0, 0, false));
/*      */     }
/*      */ 
/* 1618 */     int asstCount = 0;
/* 1619 */     Object obj = partner.getVariable("MaxAsstItemCount");
/* 1620 */     if ((obj != null) && (((Integer)obj).intValue() > 0)) {
/* 1621 */       asstCount = ((Integer)obj).intValue();
/*      */     }
/* 1623 */     for (int i = 0; i < asstCount; ++i) {
/* 1624 */       items.add(addHeadItemInfo("FAsstItem" + i, 160, 0, false, false, true, new String[] { "AssistActName", "AssistActName" }, 0, 0, false));
/*      */
/*      */     }
/*      */ 
/* 1628 */     int scaleFor = partner.getScaleFor();
/* 1629 */     int scaleLocal = partner.getScaleLocal();
/* 1630 */     int scaleRpt = partner.getScaleRpt();
/*      */
/*      */ 
/* 1633 */     boolean isShowForCurrency = isShowForCurrency(partner);
/* 1634 */     boolean isShowLocalCurrency = isShowLocalCurrency(partner);
/* 1635 */     boolean isShowReportCurrency = isShowReportCurrency(partner);
/*      */
/*      */ 
/* 1638 */     boolean isSingleCurrency = ((isShowForCurrency) ? 1 : 0) + ((isShowLocalCurrency) ? 1 : 0) + ((isShowReportCurrency) ? 1 : 0) == 1;
/*      */
/*      */ 
/* 1641 */     items.add(addHeadItemInfo("FBalBeginOritention", 30, 1, false, false, true, new String[] { "BalanceBegin", "Oriention" }, 0, 0, false));
/* 1642 */     if (isShowForCurrency)
/* 1643 */       items.add(addHeadItemInfo("FBalanceBeginFor", 110, 2, false, false, true, new String[] { "BalanceBegin", (isSingleCurrency) ? "Amount" : "LabelFor" }, 2, scaleFor, true));
/* 1644 */     if (isShowLocalCurrency)
/* 1645 */       items.add(addHeadItemInfo("FBalanceBeginLocal", 110, 2, false, false, true, new String[] { "BalanceBegin", (isSingleCurrency) ? "Amount" : "LabelLocal" }, 1, scaleLocal, true));
/* 1646 */     if (isShowReportCurrency)
/* 1647 */       items.add(addHeadItemInfo("FBalanceBeginRpt", 110, 2, false, false, true, new String[] { "BalanceBegin", (isSingleCurrency) ? "Amount" : "LabelRpt" }, 1, scaleRpt, true));
/* 1648 */     if (isShowForCurrency)
/* 1649 */       items.add(addHeadItemInfo("FDebitFor", 110, 2, false, false, true, new String[] { "Debit", (isSingleCurrency) ? "Debit" : "LabelFor" }, 2, scaleFor, true));
/* 1650 */     if (isShowLocalCurrency)
/* 1651 */       items.add(addHeadItemInfo("FDebitLocal", 110, 2, false, false, true, new String[] { "Debit", (isSingleCurrency) ? "Debit" : "LabelLocal" }, 1, scaleLocal, true));
/* 1652 */     if (isShowReportCurrency)
/* 1653 */       items.add(addHeadItemInfo("FDebitRpt", 110, 2, false, false, true, new String[] { "Debit", (isSingleCurrency) ? "Debit" : "LabelRpt" }, 1, scaleRpt, true));
/* 1654 */     if (isShowForCurrency)
/* 1655 */       items.add(addHeadItemInfo("FCreditFor", 110, 2, false, false, true, new String[] { "Credit", (isSingleCurrency) ? "Credit" : "LabelFor" }, 2, scaleFor, true));
/* 1656 */     if (isShowLocalCurrency)
/* 1657 */       items.add(addHeadItemInfo("FCreditLocal", 110, 2, false, false, true, new String[] { "Credit", (isSingleCurrency) ? "Credit" : "LabelLocal" }, 1, scaleLocal, true));
/* 1658 */     if (isShowReportCurrency)
/* 1659 */       items.add(addHeadItemInfo("FCreditRpt", 110, 2, false, false, true, new String[] { "Credit", (isSingleCurrency) ? "Credit" : "LabelRpt" }, 1, scaleRpt, true));
/* 1660 */     items.add(addHeadItemInfo("FBalEndOritention", 30, 1, false, false, true, new String[] { "BalanceEnd", "Oriention" }, 0, 0, false));
/* 1661 */     if (isShowForCurrency)
/* 1662 */       items.add(addHeadItemInfo("FBalanceEndFor", 110, 2, false, false, true, new String[] { "BalanceEnd", (isSingleCurrency) ? "Amount" : "LabelFor" }, 2, scaleFor, true));
/* 1663 */     if (isShowLocalCurrency)
/* 1664 */       items.add(addHeadItemInfo("FBalanceEndLocal", 110, 2, false, false, true, new String[] { "BalanceEnd", (isSingleCurrency) ? "Amount" : "LabelLocal" }, 1, scaleLocal, true));
/* 1665 */     if (isShowReportCurrency)
/* 1666 */       items.add(addHeadItemInfo("FBalanceEndRpt", 110, 2, false, false, true, new String[] { "BalanceEnd", (isSingleCurrency) ? "Amount" : "LabelRpt" }, 1, scaleRpt, true));
/* 1667 */     items.add(addHeadItemInfo("FDebitNumber", 90, 2, false, false, true, new String[] { "DebitNumber", "DebitNumber" }, 0, 0, false));
/* 1668 */     items.add(addHeadItemInfo("FCreditNumber", 90, 2, false, false, true, new String[] { "CreditNumber", "CreditNumber" }, 0, 0, false));
/*      */
/*      */ 
/* 1671 */     ReportTableHeadInfo head = new ReportTableHeadInfo((ReportTableHeadItemInfo[])items.toArray(new ReportTableHeadItemInfo[0]));
/* 1672 */     head.setHeadMerge(true);
/* 1673 */     if (!(head.check()))
/*      */     {
/* 1675 */       throw new ReportException(ReportException.TABLE_HEAD_ERROR);
/*      */     }
/* 1677 */     partner.setTableHeadInfo(head);
/*      */   }
/*      */
/*      */
/*      */   protected Object[] getTotalLine(ReportPartner partner)
/*      */     throws SQLException, EASBizException, BOSException
/*      */   {
/* 1684 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1685 */     Object[] totalLineObj = null;
/* 1686 */     StringBuffer strBuffer = new StringBuffer();
/* 1687 */     strBuffer.append(" SELECT SUM(TS.FBeginBalanceFor) AS FBeginBalanceFor, \r\n");
/* 1688 */     strBuffer.append(" SUM(TS.FBeginBalanceLocal) AS FBeginBalanceLocal, \r\n");
/* 1689 */     strBuffer.append(" SUM(TS.FBeginBalanceRpt) AS FBeginBalanceRpt, \r\n");
/* 1690 */     strBuffer.append(" SUM(TS.FDebitFor) AS FDebitFor, \r\n");
/* 1691 */     strBuffer.append(" SUM(TS.FDebitLocal) AS FDebitLocal, \r\n");
/* 1692 */     strBuffer.append(" SUM(TS.FDebitRpt) AS FDebitRpt, \r\n");
/* 1693 */     strBuffer.append(" SUM(TS.FCreditFor) AS FCreditFor, \r\n");
/* 1694 */     strBuffer.append(" SUM(TS.FCreditLocal) AS FCreditLocal, \r\n");
/* 1695 */     strBuffer.append(" SUM(TS.FCreditRpt) AS FCreditRpt,\r\n");
/* 1696 */     strBuffer.append(" SUM(TS.FEndBalanceFor) AS FEndBalanceFor, \r\n");
/* 1697 */     strBuffer.append(" SUM(TS.FEndBalanceLocal) AS FEndBalanceLocal,\r\n");
/* 1698 */     strBuffer.append(" SUM(TS.FEndBalanceRpt) AS FEndBalanceRpt, \r\n");
/* 1699 */     strBuffer.append(" SUM(TS.FDebitCount) AS FDebitCount, \r\n");
/* 1700 */     strBuffer.append(" SUM(TS.FCredtiCount) AS FCredtiCount \r\n");
/* 1701 */     strBuffer.append(" from \r\n");
/* 1702 */     strBuffer.append(" (SELECT FAccountID AS FAccountID, \r\n");
/* 1703 */     strBuffer.append(" FAsstHgID as FAsstHgID, \r\n");
/* 1704 */     strBuffer.append(" SUM(FBeginBalanceFor) AS FBeginBalanceFor,\r\n");
/* 1705 */     strBuffer.append(" SUM(FBeginBalanceLocal) AS FBeginBalanceLocal,\r\n");
/* 1706 */     strBuffer.append(" SUM(FBeginBalanceRpt) AS FBeginBalanceRpt,\r\n");
/* 1707 */     strBuffer.append(" SUM(FDebitFor) AS FDebitFor, \r\n");
/* 1708 */     strBuffer.append(" SUM(FDebitLocal) AS FDebitLocal, \r\n");
/* 1709 */     strBuffer.append(" SUM(FDebitRpt) AS FDebitRpt,\r\n");
/* 1710 */     strBuffer.append(" SUM(FCreditFor) AS FCreditFor, \r\n");
/* 1711 */     strBuffer.append(" SUM(FCreditLocal) AS FCreditLocal,\r\n");
/* 1712 */     strBuffer.append(" SUM(FCreditRpt) AS FCreditRpt,\r\n");
/* 1713 */     strBuffer.append(" SUM(FEndBalanceFor) AS FEndBalanceFor, \r\n");
/* 1714 */     strBuffer.append(" SUM(FEndBalanceLocal) AS FEndBalanceLocal, \r\n");
/* 1715 */     strBuffer.append(" SUM(FEndBalanceRpt) AS FEndBalanceRpt,\r\n");
/* 1716 */     strBuffer.append(" SUM(FDebitCount) AS FDebitCount, \r\n");
/* 1717 */     strBuffer.append(" SUM(FCredtiCount) AS FCredtiCount\r\n");
/* 1718 */     strBuffer.append(" FROM  \r\n");
/* 1719 */     strBuffer.append(partner.getTempTableName());
/* 1720 */     strBuffer.append(" WHERE FAsstHgID is null \r\n");
/* 1721 */     strBuffer.append(" GROUP BY FAccountID,FAsstHgID) AS TS \r\n");
/* 1722 */     strBuffer.append(" INNER JOIN T_BD_AccountView AS TA \r\n");
/* 1723 */     strBuffer.append(" ON TS.FAccountID = TA.FID \r\n");
/*      */
/*      */ 
/* 1726 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/* 1727 */       boolean isShowForCurrency = isShowForCurrency(partner);
/* 1728 */       boolean isShowLocalCurrency = isShowLocalCurrency(partner);
/* 1729 */       boolean isShowReportCurrency = isShowReportCurrency(partner);
/*      */ 
/* 1731 */       strBuffer.append(" INNER JOIN \r\n");
/* 1732 */       strBuffer.append("(SELECT * FROM \r\n");
/* 1733 */       strBuffer.append(" (SELECT FAccountID AS FAccountID, \r\n");
/* 1734 */       strBuffer.append(" SUM(FBeginBalanceFor) AS FBeginBalanceFor,\r\n");
/* 1735 */       strBuffer.append(" SUM(FBeginBalanceLocal) AS FBeginBalanceLocal,\r\n");
/* 1736 */       strBuffer.append(" SUM(FBeginBalanceRpt) AS FBeginBalanceRpt,\r\n");
/* 1737 */       strBuffer.append(" SUM(FDebitFor) AS FDebitFor, \r\n");
/* 1738 */       strBuffer.append(" SUM(FDebitLocal) AS FDebitLocal, \r\n");
/* 1739 */       strBuffer.append(" SUM(FDebitRpt) AS FDebitRpt,\r\n");
/* 1740 */       strBuffer.append(" SUM(FCreditFor) AS FCreditFor, \r\n");
/* 1741 */       strBuffer.append(" SUM(FCreditLocal) AS FCreditLocal,\r\n");
/* 1742 */       strBuffer.append(" SUM(FCreditRpt) AS FCreditRpt,\r\n");
/* 1743 */       strBuffer.append(" SUM(FEndBalanceFor) AS FEndBalanceFor, \r\n");
/* 1744 */       strBuffer.append(" SUM(FEndBalanceLocal) AS FEndBalanceLocal, \r\n");
/* 1745 */       strBuffer.append(" SUM(FEndBalanceRpt) AS FEndBalanceRpt,\r\n");
/* 1746 */       strBuffer.append(" SUM(FDebitCount) AS FDebitCount, \r\n");
/* 1747 */       strBuffer.append(" SUM(FCredtiCount) AS FCredtiCount \r\n");
/* 1748 */       strBuffer.append(" FROM \r\n");
/* 1749 */       strBuffer.append(partner.getTempTableName());
/* 1750 */       strBuffer.append(" where FAsstHgID is null \r\n");
/*      */ 
/* 1752 */       strBuffer.append(" GROUP BY FAccountID) as T1 \r\n");
/* 1753 */       strBuffer.append(" where \r\n");
/* 1754 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 1755 */         strBuffer.append(" (1=0 ").append((isShowForCurrency) ? " or (FEndBalanceFor <> 0)" : "").append((isShowLocalCurrency) ? " or (FEndBalanceLocal <> 0)" : "").append((isShowReportCurrency) ? " or (FEndBalanceRpt <> 0)" : "").append(") \r\n");
/*      */
/*      */
/*      */
/*      */       }
/*      */ 
/* 1761 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 1762 */         if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 1763 */           strBuffer.append(" and ");
/*      */         }
/* 1765 */         strBuffer.append(" (1=0 ").append((isShowForCurrency) ? " or (FDebitFor <> 0) OR (FCreditFor <> 0)" : "").append((isShowLocalCurrency) ? " or (FDebitLocal <> 0) OR (FCreditLocal <> 0)" : "").append((isShowReportCurrency) ? " or (FDebitRpt <> 0) OR (FCreditRpt <> 0)" : "").append(") \r\n");
/*      */
/*      */
/*      */
/*      */       }
/*      */ 
/* 1771 */       strBuffer.append(" ) as T_Condition on TS.FAccountID = T_Condition.FAccountID \r\n");
/*      */     }
/* 1773 */     strBuffer.append(" WHERE \r\n");
/* 1774 */     strBuffer.append(" (TA.FAccountTableID = ?) AND (TA.FLevel >= ?) AND (TA.FLevel <= ?) \r\n");
/*      */ 
/* 1776 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1777 */       strBuffer.append(" AND (TA.FNumber >= ?) \r\n");
/*      */     }
/*      */ 
/* 1780 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1781 */       strBuffer.append(" AND (TA.FNumber <= ?) \r\n");
/*      */     }
/*      */ 
/* 1784 */     strBuffer.append(" AND (TA.Flevel = ? OR TA.FIsLeaf = 1)");
/*      */ 
/* 1786 */     Connection cn = null;
/* 1787 */     PreparedStatement stmt = null;
/* 1788 */     ResultSet rs = null;
/*      */     try {
/* 1790 */       cn = partner.getConnection();
/* 1791 */       stmt = cn.prepareStatement(strBuffer.toString());
/* 1792 */       SqlParameter2 parameter = new SqlParameter2();
/*      */ 
/* 1794 */       parameter.addValueChar(partner.getAccountTableId());
/* 1795 */       parameter.addValue(condition.getAccountLevelStart());
/* 1796 */       parameter.addValue(condition.getAccountLevelEnd());
/*      */ 
/* 1798 */       if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1799 */         parameter.addValueVarchar(condition.getAccountCodeStart());
/*      */       }
/*      */ 
/* 1802 */       if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1803 */         parameter.addValueVarchar(condition.getAccountCodeEnd() + "~~");
/*      */       }
/* 1805 */       parameter.addValue(condition.getAccountLevelEnd());
/*      */ 
/* 1807 */       parameter.putToStatement(stmt);
/* 1808 */       rs = stmt.executeQuery();
/* 1809 */       if (rs.next())
/* 1810 */         totalLineObj = getTotalLineObjects(partner, rs);
/*      */     }
/*      */     catch (SQLException sqle)
/*      */     {
/* 1814 */       throw new SQLDataException(sqle);
/*      */     } finally {
/* 1816 */       SQLUtils.cleanup(rs, stmt);
/*      */     }
/* 1818 */     if (totalLineObj != null) {
/* 1819 */       totalLineObj[1] = partner.TITLE_TOTAL;
/* 1820 */       totalLineObj[(totalLineObj.length - 2)] = ReportResultInfo.LINE_TOTAL;
/*      */     }
/* 1822 */     return totalLineObj;
/*      */   }
/*      */
/*      */
/*      */
/*      */   protected boolean isAddTotalLine(ReportPartner partner)
/*      */   {
/* 1829 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*      */ 
/* 1831 */     boolean bReturn = false;
/*      */ 
/* 1833 */     if (condition != null) {
/* 1834 */       bReturn = condition.isOptionShowTotal();
/*      */     }
/*      */ 
/* 1837 */     return bReturn;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   protected CompanyOrgUnitInfo getInitCompany(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 1849 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
/* 1850 */       throw new GLException(GLException.COMMUSTBEENTITY);
/*      */     }
/* 1852 */     return partner.getCompany();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertTempDataAsst(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1864 */     if (theNearPeriod == null) {
/* 1865 */       return;
/*      */     }
/*      */ 
/* 1868 */     insertTempDataAsstBalance(partner, strFirstTempTableName, theNearPeriod);
/*      */ 
/* 1870 */     insertTempDataAsstVoucher(partner, strFirstTempTableName, theNearPeriod);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertTempDataAsstBalance(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 1883 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 1884 */     StringBuffer sql = new StringBuffer();
/*      */ 
/* 1886 */     sql.append(" SELECT tb.FAccountID AS FAccountID, \r\n");
/* 1887 */     sql.append(" tb.FCurrencyID as FCurrencyID, \r\n");
/* 1888 */     sql.append(" tb.FOrgunitID AS FCompanyID, \r\n");
/* 1889 */     sql.append(" case when tb.FAssistGrpID is null then 'DefaultAssGrpID' else tb.FAssistGrpID end as FAsstHgID, \r\n");
/* 1890 */     sql.append(" tb.FBeginBalanceFor AS FBeginBalanceFor, \r\n");
/* 1891 */     sql.append(" tb.FBeginBalanceLocal AS FBeginBalanceLocal, \r\n");
/* 1892 */     sql.append(" tb.FBeginBalanceRpt AS FBeginBalanceRpt, \r\n");
/* 1893 */     sql.append(" 0.0 AS FDebitFor, \r\n");
/* 1894 */     sql.append(" 0.0 AS FDebitLocal, \r\n");
/* 1895 */     sql.append(" 0.0 AS FDebitRpt, \r\n");
/* 1896 */     sql.append(" 0.0 AS FCreditFor, \r\n");
/* 1897 */     sql.append(" 0.0 AS FCreditLocal, \r\n");
/* 1898 */     sql.append(" 0.0 AS FCreditRpt, \r\n");
/* 1899 */     sql.append(" tb.FBeginBalanceFor AS FEndBalanceFor, \r\n");
/* 1900 */     sql.append(" tb.FBeginBalanceLocal AS FEndBalanceLocal, \r\n");
/* 1901 */     sql.append(" tb.FBeginBalanceRpt AS FEndBalanceRpt, \r\n");
/* 1902 */     sql.append(" 0 AS FDebitCount, \r\n");
/* 1903 */     sql.append(" 0 AS FCredtiCount, \r\n");
/* 1904 */     sql.append(" 0 as FTag, \r\n");
/* 1905 */     sql.append(" 0 as FLineType ");
/* 1906 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/* 1907 */       sql.append(" ,1 AS FAccountOrAssist \r\n");
/*      */     }
/* 1909 */     sql.append(" FROM T_GL_AssistBalance as tb \r\n");
/* 1910 */     sql.append(" INNER JOIN T_BD_AccountView as tv ON tb.fAccountID = tv.fid \r\n");
/* 1911 */     sql.append(" WHERE ");
/*      */ 
/* 1913 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/*      */     {
/* 1915 */       sql.append("(( tb.FOrgUnitID in ").append(getStrCompanyIds(partner)).append(" AND tb.FPeriodID = ? \r\n");
/*      */ 
/* 1917 */       sql.append(" and tb.forgunitid not in (select sysctrl.FCompanyID from T_BD_SYSTEMSTATUSCTROL sysctrl \r\n");
/* 1918 */       sql.append(" INNER JOIN T_BD_SYSTEMSTATUS tsst ON sysctrl.FSystemStatusID=tsst.FID \r\n");
/* 1919 */       sql.append(" inner join t_bd_period p on sysctrl.FStartPeriodID = p.fid \r\n");
/* 1920 */       sql.append(" where tsst.FName=6 AND sysctrl.FISSTART=1 and sysctrl.FCompanyID in ").append(getStrCompanyIds(partner));
/* 1921 */       sql.append(" and p.fnumber > ? )) \r\n");
/*      */ 
/* 1923 */       sql.append(" or exists (select 1 from T_BD_SYSTEMSTATUSCTROL sysctrl INNER JOIN T_BD_SYSTEMSTATUS tsst ON sysctrl.FSystemStatusID=tsst.FID \r\n");
/* 1924 */       sql.append(" inner join t_bd_period p on sysctrl.FStartPeriodID = p.fid \r\n");
/* 1925 */       sql.append(" where tsst.FName=6 AND sysctrl.FISSTART=1 and sysctrl.FCompanyID in ").append(getStrCompanyIds(partner));
/* 1926 */       sql.append(" and p.fnumber > ? and tb.FOrgUnitID=sysctrl.FCompanyID and tb.FPeriodID=sysctrl.FStartPeriodID)");
/* 1927 */       sql.append(" )\r\n");
/*      */     } else {
/* 1929 */       sql.append(" tb.FOrgUnitID = ? AND tb.FPeriodID = ? \r\n");
/*      */     }
/*      */ 
/* 1932 */     sql.append(" AND tb.FBalType = ? \r\n");
/*      */ 
/* 1934 */     if ((condition.getCurrencyID() != null) && (condition.getCurrencyID().trim().length() != 0) && (!(condition.isAllCurrency())))
/* 1935 */       sql.append(" AND tb.FCurrencyID = ? \r\n");
/* 1936 */     else if (condition.isAllCurrency()) {
/* 1937 */       sql.append(" AND tb.FCurrencyID <> ? and tb.FCurrencyID <> ? \r\n");
/*      */     }
/*      */ 
/* 1940 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1941 */       sql.append(" AND (TV.FNumber >= ?) \r\n");
/*      */     }
/*      */ 
/* 1944 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1945 */       sql.append(" AND (TV.FNumber <= ?) \r\n");
/*      */
/*      */
/*      */     }
/*      */ 
/* 1950 */     SqlParameter2 parameter = new SqlParameter2();
/*      */
/*      */ 
/* 1953 */     if (GlUtils.isCompanyUnion(partner.getCompany())) {
/* 1954 */       parameter.addValueId(theNearPeriod);
/* 1955 */       parameter.addValue(theNearPeriod.getNumber());
/* 1956 */       parameter.addValue(theNearPeriod.getNumber());
/*      */     }
/*      */     else {
/* 1959 */       parameter.addValueChar(partner.getCompanyId());
/* 1960 */       parameter.addValueId(theNearPeriod);
/*      */     }
/*      */ 
/* 1963 */     parameter.addValue((condition.getOptionPosting()) ? 1 : 5);
/*      */ 
/* 1965 */     if ((condition.getCurrencyID() != null) && (condition.getCurrencyID().trim().length() != 0) && (!(condition.isAllCurrency()))) {
/* 1966 */       parameter.addValueChar(condition.getCurrencyID());
/* 1967 */     } else if (condition.isAllCurrency()) {
/* 1968 */       parameter.addValueChar("11111111-1111-1111-1111-111111111111DEB58FDC");
/* 1969 */       parameter.addValueChar("22222222-2222-2222-2222-222222222222DEB58FDC");
/*      */     }
/*      */ 
/* 1972 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 1973 */       parameter.addValue(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/* 1976 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 1977 */       parameter.addValue(condition.getAccountCodeEnd() + "~");
/*      */
/*      */
/*      */     }
/*      */ 
/* 1982 */     Connection cn = null;
/* 1983 */     PreparedStatement stmt = null;
/*      */     try {
/* 1985 */       cn = partner.getConnection();
/* 1986 */       stmt = cn.prepareStatement(" insert into " + strFirstTempTableName + sql.toString());
/*      */ 
/* 1988 */       parameter.putToStatement(stmt);
/* 1989 */       stmt.executeUpdate();
/* 1990 */       stmt.close();
/*      */     }
/*      */     catch (SQLException e) {
/* 1993 */       throw new SQLDataException(e);
/*      */     } finally {
/* 1995 */       SQLUtils.cleanup(stmt);
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
/*      */   private void insertTempDataAsstVoucher(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2009 */     insertTempDataAsstVoucherBeginToStart(partner, strFirstTempTableName, theNearPeriod);
/*      */ 
/* 2011 */     insertTempDataAsstVoucherStartToEnd(partner, strFirstTempTableName);
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
/*      */   private void insertTempDataAsstVoucherBeginToStart(ReportPartner partner, String strFirstTempTableName, PeriodInfo theNearPeriod)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2026 */     java.util.Date dateStart = theNearPeriod.getBeginDate();
/* 2027 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 2028 */     java.util.Date dateEnd = condition.getDateBegin();
/* 2029 */     GregorianCalendar calendar = new GregorianCalendar();
/* 2030 */     calendar.setTime(dateEnd);
/* 2031 */     calendar.add(5, -1);
/* 2032 */     dateEnd = calendar.getTime();
/*      */ 
/* 2034 */     String asstTableNameBegin = getVoucherAssistSQLForJournal(partner, dateStart, dateEnd);
/*      */ 
/* 2036 */     StringBuffer sqlToBegin = new StringBuffer();
/* 2037 */     sqlToBegin.append(" SELECT FAccountID, \r\n");
/* 2038 */     sqlToBegin.append(" FCurrencyID as FCurrencyID, \r\n");
/* 2039 */     sqlToBegin.append(" FCompanyID, \r\n");
/* 2040 */     sqlToBegin.append(" case when FAsstHgID is null then 'DefaultAssGrpID' else FAsstHgID end as FAsstHgID, \r\n");
/* 2041 */     sqlToBegin.append(" FDebitFor - FCreditFor AS FBeginBalanceFor, \r\n");
/* 2042 */     sqlToBegin.append(" FDebitLocal - FCreditLocal AS FBeginBalanceLocal ,\r\n");
/* 2043 */     sqlToBegin.append(" FDebitRpt - FCreditRpt AS FBeginBalanceRpt,\r\n");
/* 2044 */     sqlToBegin.append(" 0.0 AS FDebitFor, \r\n");
/* 2045 */     sqlToBegin.append(" 0.0 AS FDebitLocal, \r\n");
/* 2046 */     sqlToBegin.append(" 0.0 AS FDebitRpt, \r\n");
/* 2047 */     sqlToBegin.append(" 0.0 AS FCreditFor, \r\n");
/* 2048 */     sqlToBegin.append(" 0.0 AS FCreditLocal, \r\n");
/* 2049 */     sqlToBegin.append(" 0.0 AS FCreditRpt, \r\n");
/* 2050 */     sqlToBegin.append(" FDebitFor - FCreditFor AS FEndBalanceFor, \r\n");
/* 2051 */     sqlToBegin.append(" FDebitLocal - FCreditLocal AS FEndBalanceLocal, \r\n");
/* 2052 */     sqlToBegin.append(" FDebitRpt - FCreditRpt AS FEndBalanceRpt, \r\n");
/* 2053 */     sqlToBegin.append(" 0 AS FDebitCount, \r\n");
/* 2054 */     sqlToBegin.append(" 0 AS FCredtiCount, \r\n");
/* 2055 */     sqlToBegin.append(" 0 as FTag, \r\n");
/* 2056 */     sqlToBegin.append(" 0 as FLineType \r\n");
/* 2057 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/* 2058 */       sqlToBegin.append(" ,1 AS FAccountOrAssist \r\n");
/*      */     }
/* 2060 */     sqlToBegin.append(" FROM (" + asstTableNameBegin).append(") tmp ");
/* 2061 */     String strCurrencyID = condition.getCurrencyID();
/*      */ 
/* 2063 */     SqlParameter2 parameterBegin = new SqlParameter2();
/* 2064 */     parameterBegin.addValue(5);
/* 2065 */     if (condition.getOptionPosting()) {
/* 2066 */       parameterBegin.addValue(1);
/* 2067 */       parameterBegin.addValue(3);
/*      */     }
/* 2069 */     if (!(GlUtils.isCompanyUnion(partner.getCompany()))) {
/* 2070 */       parameterBegin.addValueChar(partner.getCompanyId());
/*      */     }
/* 2072 */     parameterBegin.addValueChar(partner.getAccountTableId());
/*      */ 
/* 2074 */     if ((!(strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString()))) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString()))) && (!(condition.isAllCurrency())))
/*      */
/*      */     {
/* 2077 */       parameterBegin.addValueChar(condition.getCurrencyID());
/*      */     }
/* 2079 */     parameterBegin.addValue(new java.sql.Date(dateStart.getTime()));
/* 2080 */     parameterBegin.addValue(new java.sql.Date(dateEnd.getTime()));
/*      */ 
/* 2082 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2083 */       parameterBegin.addValueChar(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/* 2086 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2087 */       parameterBegin.addValueChar(condition.getAccountCodeEnd() + "~~");
/*      */     }
/*      */ 
/* 2090 */     Connection cn = null;
/* 2091 */     cn = partner.getConnection();
/* 2092 */     PreparedStatement stmtToBegin = null;
/*      */     try {
/* 2094 */       stmtToBegin = cn.prepareStatement(" insert into " + strFirstTempTableName + sqlToBegin.toString());
/*      */ 
/* 2096 */       parameterBegin.putToStatement(stmtToBegin);
/* 2097 */       stmtToBegin.executeUpdate();
/* 2098 */       stmtToBegin.close();
/*      */     }
/*      */     catch (SQLException e) {
/* 2101 */       throw new SQLDataException(e);
/*      */     } finally {
/* 2103 */       SQLUtils.cleanup(stmtToBegin);
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
/*      */   private void insertTempDataAsstVoucherStartToEnd(ReportPartner partner, String strFirstTempTableName)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2117 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 2118 */     String strCurrencyID = condition.getCurrencyID();
/*      */ 
/* 2120 */     java.util.Date dateStart = condition.getDateBegin();
/* 2121 */     java.util.Date dateEnd = condition.getDateEnd();
/*      */ 
/* 2123 */     String asstTableNameEnd = getVoucherAssistSQLForJournal(partner, dateStart, dateEnd);
/*      */ 
/* 2125 */     StringBuffer sqlToEnd = new StringBuffer();
/* 2126 */     sqlToEnd.append(" SELECT FAccountID, \r\n");
/* 2127 */     sqlToEnd.append(" FCurrencyID, \r\n");
/* 2128 */     sqlToEnd.append(" FCompanyID, \r\n");
/* 2129 */     sqlToEnd.append(" case when FAsstHgID is null then 'DefaultAssGrpID' else FAsstHgID end as FAsstHgID, \r\n");
/* 2130 */     sqlToEnd.append(" 0.0 AS FBeginBalanceFor, \r\n");
/* 2131 */     sqlToEnd.append(" 0.0 AS FBeginBalanceLocal , \r\n");
/* 2132 */     sqlToEnd.append(" 0.0 AS FBeginBalanceRpt, \r\n");
/* 2133 */     sqlToEnd.append(" FDebitFor AS FDebitFor, \r\n");
/* 2134 */     sqlToEnd.append(" FDebitLocal AS FDebitLocal,\r\n");
/* 2135 */     sqlToEnd.append(" FDebitRpt AS FDebitRpt,\r\n");
/* 2136 */     sqlToEnd.append(" FCreditFor AS FCreditFor, \r\n");
/* 2137 */     sqlToEnd.append(" FCreditLocal AS FCreditLocal, \r\n");
/* 2138 */     sqlToEnd.append(" FCreditRpt AS FCreditRpt,\r\n");
/* 2139 */     sqlToEnd.append(" FDebitFor - FCreditFor AS FEndBalanceFor, \r\n");
/* 2140 */     sqlToEnd.append(" FDebitLocal - FCreditLocal AS FEndBalanceLocal,\r\n");
/* 2141 */     sqlToEnd.append(" FDebitRpt - FCreditRpt AS FEndBalanceRpt, \r\n");
/* 2142 */     sqlToEnd.append(" FDebitCount AS FDebitCount,\r\n");
/* 2143 */     sqlToEnd.append(" FCreditCount AS FCredtiCount, \r\n");
/* 2144 */     sqlToEnd.append(" 0 as FTag, \r\n");
/* 2145 */     sqlToEnd.append(" 0 as FLineType \r\n");
/* 2146 */     if ((GlUtils.isCompanyUnion(partner.getCompany())) && (condition.isOptionShowAsstItem())) {
/* 2147 */       sqlToEnd.append(" ,1 AS FAccountOrAssist \r\n");
/*      */     }
/* 2149 */     sqlToEnd.append(" FROM (" + asstTableNameEnd).append(") tmp ");
/*      */ 
/* 2151 */     SqlParameter2 parameterEnd = new SqlParameter2();
/*      */ 
/* 2153 */     parameterEnd.addValue(5);
/* 2154 */     if (condition.getOptionPosting()) {
/* 2155 */       parameterEnd.addValue(1);
/* 2156 */       parameterEnd.addValue(3);
/*      */     }
/* 2158 */     if (!(GlUtils.isCompanyUnion(partner.getCompany()))) {
/* 2159 */       parameterEnd.addValueChar(partner.getCompanyId());
/*      */     }
/* 2161 */     parameterEnd.addValueChar(partner.getAccountTableId());
/*      */ 
/* 2163 */     if ((!(strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString()))) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString()))) && (!(condition.isAllCurrency())))
/*      */
/*      */     {
/* 2166 */       parameterEnd.addValueChar(condition.getCurrencyID());
/*      */     }
/* 2168 */     parameterEnd.addValue(new java.sql.Date(dateStart.getTime()));
/* 2169 */     parameterEnd.addValue(new java.sql.Date(dateEnd.getTime()));
/*      */
/*      */ 
/* 2172 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2173 */       parameterEnd.addValueChar(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/* 2176 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2177 */       parameterEnd.addValueChar(condition.getAccountCodeEnd() + "~~");
/*      */     }
/*      */ 
/* 2180 */     Connection cn1 = null;
/* 2181 */     cn1 = partner.getConnection();
/* 2182 */     PreparedStatement stmtToEnd = null;
/*      */     try {
/* 2184 */       stmtToEnd = cn1.prepareStatement(" insert into " + strFirstTempTableName + sqlToEnd.toString());
/* 2185 */       parameterEnd.putToStatement(stmtToEnd);
/* 2186 */       stmtToEnd.executeUpdate();
/* 2187 */       stmtToEnd.close();
/*      */     }
/*      */     catch (SQLException e) {
/* 2190 */       throw new SQLDataException(e);
/*      */     } finally {
/* 2192 */       SQLUtils.cleanup(stmtToEnd);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */   private String getVoucherAssistSQLForJournal(ReportPartner partner, java.util.Date dateStart, java.util.Date dateEnd)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2201 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 2202 */     String strCurrencyID = condition.getCurrencyID();
/*      */ 
/* 2204 */     StringBuffer strBuffer = new StringBuffer();
/* 2205 */     strBuffer.append(" SELECT D.FAccountID AS FAccountID,\r\n");
/* 2206 */     if ((strCurrencyID != null) && (((strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString())) || (strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString())))) && (!(condition.isAllCurrency())))
/*      */
/*      */     {
/* 2209 */       strBuffer.append("'" + strCurrencyID + "'").append(" AS FCurrencyID,\r\n");
/*      */     }
/*      */     else strBuffer.append(" D.FCurrencyID AS FCurrencyID,\r\n");
/*      */ 
/* 2213 */     strBuffer.append(" M.FCompanyID,ASST.FAssGrpID AS FAsstHgID, \r\n");
/*      */
/*      */ 
/* 2216 */     if (strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString())) {
/* 2217 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 2218 */       strBuffer.append(" THEN ASST.FLocalAmount ELSE 0 END) AS FDebitFor, \r\n");
/* 2219 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 2220 */       strBuffer.append(" THEN ASST.FLocalAmount ELSE 0 END) AS FCreditFor, \r\n");
/* 2221 */     } else if (strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString())) {
/* 2222 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 2223 */       strBuffer.append(" THEN ASST.FReportingAmount ELSE 0 END) AS FDebitFor, \r\n");
/* 2224 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 2225 */       strBuffer.append(" THEN ASST.FReportingAmount ELSE 0 END) AS FCreditFor, \r\n");
/*      */     } else {
/* 2227 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 2228 */       strBuffer.append(" THEN ASST.FOriginalAmount ELSE 0 END) AS FDebitFor, \r\n");
/* 2229 */       strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 2230 */       strBuffer.append(" THEN ASST.FOriginalAmount ELSE 0 END) AS FCreditFor, \r\n");
/*      */
/*      */     }
/*      */ 
/* 2234 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 2235 */     strBuffer.append(" THEN ASST.FLocalAmount ELSE 0 END) AS FDebitLocal, \r\n");
/* 2236 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 2237 */     strBuffer.append(" THEN ASST.FLocalAmount ELSE 0 END) AS FCreditLocal, \r\n");
/*      */
/*      */ 
/* 2240 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 2241 */     strBuffer.append(" THEN ASST.FReportingAmount ELSE 0 END) AS FDebitRpt, \r\n");
/* 2242 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 2243 */     strBuffer.append(" THEN ASST.FReportingAmount ELSE 0 END) AS FCreditRpt, \r\n");
/*      */
/*      */ 
/* 2246 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(1);
/* 2247 */     strBuffer.append(" THEN 1 ELSE 0 END) AS FDebitCount, \r\n");
/* 2248 */     strBuffer.append(" (CASE D.FEntryDC WHEN ").append(0);
/* 2249 */     strBuffer.append(" THEN 1 ELSE 0 END) AS FCreditCount \r\n");
/*      */ 
/* 2251 */     strBuffer.append(" FROM T_GL_VoucherAssistRecord AS ASST  \r\n");
/* 2252 */     strBuffer.append(" INNER JOIN T_GL_VoucherEntry AS D ON ASST.FEntryID = D.FID \r\n");
/* 2253 */     strBuffer.append(" INNER JOIN T_GL_Voucher AS M ON M.FID = D.FBillID \r\n");
/* 2254 */     strBuffer.append(" inner join t_bd_accountview ta on ta.fid = D.faccountid \r\n");
/* 2255 */     strBuffer.append(" WHERE (M.FBizStatus = ? \r\n");
/*      */ 
/* 2257 */     if (condition.getOptionPosting()) {
/* 2258 */       strBuffer.append(" OR M.FBizStatus = ? \r\n");
/* 2259 */       strBuffer.append(" OR M.FBizStatus = ? \r\n");
/*      */     }
/* 2261 */     strBuffer.append(")  \r\n");
/* 2262 */     if (GlUtils.isCompanyUnion(partner.getCompany()))
/* 2263 */       strBuffer.append("\tAND M.FCompanyID in ").append(getStrCompanyIds(partner)).append(" \r\n");
/*      */     else {
/* 2265 */       strBuffer.append(" AND M.FCompanyID = ? \r\n");
/*      */     }
/* 2267 */     strBuffer.append(" AND TA.FACCOUNTTABLEID = ?");
/*      */ 
/* 2269 */     if ((!(strCurrencyID.equals(CurrencyInfo.GENERAL_LOCAL_CURRENCY_ID.toString()))) && (!(strCurrencyID.equals(CurrencyInfo.GENERAL_REPORT_CURRENCY_ID.toString()))) && (!(condition.isAllCurrency())))
/*      */
/*      */     {
/* 2272 */       strBuffer.append("\tAND\tD.FCurrencyID = ?  \r\n");
/*      */     }
/*      */ 
/* 2275 */     strBuffer.append(" AND M.FBookedDate >= ? AND M.FBookedDate <= ?  \r\n");
/*      */ 
/* 2277 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2278 */       strBuffer.append(" AND (TA.FNumber >= ?)  \r\n");
/*      */     }
/*      */ 
/* 2281 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2282 */       strBuffer.append(" AND (TA.FNumber <= ?)  \r\n");
/*      */     }
/* 2284 */     strBuffer.append(" AND ASST.FAssGrpID is not null  \r\n");
/*      */ 
/* 2286 */     return strBuffer.toString();
/*      */   }
/*      */
/*      */
/*      */   private ReportTableHeadItemInfo addHeadItemInfo(String colName, int width, int alignment, boolean isFreeze, boolean isMerge, boolean isVisible, String[] titles, int numberStyleType, int numberScale, boolean needKilobit)
/*      */   {
/* 2292 */     ReportTableHeadItemInfo item = new ReportTableHeadItemInfo();
/* 2293 */     item.setColumnName(colName);
/* 2294 */     item.setWidth(width);
/* 2295 */     item.setAlignment(alignment);
/* 2296 */     item.setFreeze(isFreeze);
/* 2297 */     item.setMerge(isMerge);
/* 2298 */     item.setVisible(isVisible);
/* 2299 */     item.setTitles(titles);
/* 2300 */     item.setNumberStyleType(numberStyleType);
/* 2301 */     item.setNumberScale(numberScale);
/* 2302 */     item.setNeedKilobit(needKilobit);
/* 2303 */     return item;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertSumAccountCurrency(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2314 */     insertSumCurrencyGroupByAccount(partner);
/*      */ 
/* 2316 */     insertSumAccountGroupByCurrency(partner);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertSumCurrencyGroupByAccount(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 2326 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 2327 */     StringBuffer sql = new StringBuffer();
/* 2328 */     sql.append("INSERT ");
/* 2329 */     sql.append(partner.getTempTableName());
/* 2330 */     sql.append(" \r\n");
/* 2331 */     sql.append(" (FAccountID, FCurrencyID, \r\n");
/* 2332 */     sql.append(" FCompanyID, \r\n");
/* 2333 */     sql.append(" FBeginBalanceFor, \r\n");
/* 2334 */     sql.append(" FBeginBalanceLocal, \r\n");
/* 2335 */     sql.append(" FBeginBalanceRpt, \r\n");
/* 2336 */     sql.append(" FDebitFor, \r\n");
/* 2337 */     sql.append(" FDebitLocal, \r\n");
/* 2338 */     sql.append(" FDebitRpt, \r\n");
/* 2339 */     sql.append(" FCreditFor, \r\n");
/* 2340 */     sql.append(" FCreditLocal, \r\n");
/* 2341 */     sql.append(" FCreditRpt, \r\n");
/* 2342 */     sql.append(" FEndBalanceFor, \r\n");
/* 2343 */     sql.append(" FEndBalanceLocal, \r\n");
/* 2344 */     sql.append(" FEndBalanceRpt, \r\n");
/* 2345 */     sql.append(" FDebitCount, \r\n");
/* 2346 */     sql.append(" FCredtiCount, \r\n");
/* 2347 */     sql.append(" FTag, \r\n");
/* 2348 */     sql.append(" FLineType \r\n");
/*      */ 
/* 2350 */     if (condition.isOptionShowAsstItem()) {
/* 2351 */       sql.append(" ,FAsstHgID \r\n");
/*      */     }
/* 2353 */     sql.append(")");
/* 2354 */     sql.append(" SELECT TP.FAccountID , ' ' FCurrencyID, TP.FCompanyID, \r\n");
/* 2355 */     sql.append(" 0.00 FBeginBalanceFor, \r\n");
/* 2356 */     sql.append(" SUM(ISNULL(FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2357 */     sql.append(" SUM(ISNULL(FBeginBalanceRpt,0)) FBeginBalanceRpt, \r\n");
/* 2358 */     sql.append(" 0.00 FDebitFor, \r\n");
/* 2359 */     sql.append(" SUM(ISNULL(tp.FDebitLocal,0)) FDebitLocal, \r\n");
/* 2360 */     sql.append(" SUM(ISNULL(FDebitRpt,0)) FDebitRpt, \r\n");
/* 2361 */     sql.append(" 0.00 FCreditFor, \r\n");
/* 2362 */     sql.append(" SUM(ISNULL(tp.FCreditLocal,0)) FCreditLocal, \r\n");
/* 2363 */     sql.append(" SUM(ISNULL(FCreditRpt,0)) FCreditRpt, \r\n");
/* 2364 */     sql.append(" 0.00 FEndBalanceFor, \r\n");
/* 2365 */     sql.append(" SUM(ISNULL(tp.FEndBalanceLocal,0)) FEndBalanceLocal, \r\n");
/* 2366 */     sql.append(" SUM(ISNULL(FEndBalanceRpt,0)) FEndBalanceRpt, \r\n");
/*      */ 
/* 2368 */     sql.append(" SUM(ISNULL(FDebitCount,0)) FDebitCount, \r\n");
/* 2369 */     sql.append(" SUM(ISNULL(FCredtiCount,0)) FCredtiCount, \r\n");
/* 2370 */     sql.append(" 1 FTag , \r\n");
/* 2371 */     sql.append(" 0 FLineType \r\n");
/*      */ 
/* 2373 */     if (condition.isOptionShowAsstItem()) {
/* 2374 */       sql.append(" , null FAsstHgID \r\n");
/*      */     }
/* 2376 */     sql.append(" FROM ").append(partner.getTempTableName()).append(" TP \r\n");
/* 2377 */     sql.append(" INNER JOIN T_BD_AccountView TA ON TP.FAccountID = TA.FID \r\n");
/*      */ 
/* 2379 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/* 2380 */       sql.append(" INNER JOIN \r\n");
/* 2381 */       sql.append("(SELECT * FROM \r\n");
/* 2382 */       sql.append(" (SELECT FAccountID AS FAccountID, \r\n");
/* 2383 */       sql.append(" FcurrencyID AS FcurrencyID,FCompanyID AS FCompanyID, \r\n");
/* 2384 */       sql.append(" SUM(FDebitlocal) AS FDebitlocal,\r\n");
/* 2385 */       sql.append(" SUM(FCreditlocal) AS FCreditlocal,\r\n");
/* 2386 */       sql.append(" SUM(FEndBalancelocal) AS FEndBalancelocal \r\n");
/* 2387 */       sql.append(" FROM  \r\n");
/* 2388 */       sql.append(partner.getTempTableName());
/* 2389 */       sql.append(" where FAsstHgID is null \r\n");
/*      */ 
/* 2391 */       sql.append(" GROUP BY FAccountID,FcurrencyID,FCompanyID) as T1 \r\n");
/* 2392 */       sql.append(" where \r\n");
/* 2393 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2394 */         sql.append(" (FEndBalancelocal <> 0 or FAccountID is null or FAccountID=' ')");
/*      */       }
/* 2396 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 2397 */         if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2398 */           sql.append(" and ");
/*      */         }
/* 2400 */         sql.append(" (FDebitlocal <> 0 or FCreditlocal <> 0 or FAccountID is null or FAccountID=' ')");
/*      */       }
/* 2402 */       sql.append("\r\n ) as T_Condition on T_Condition.FAccountID = tp.FAccountID and T_Condition.FcurrencyID = tp.FcurrencyID \r\n");
/*      */     }
/*      */ 
/* 2405 */     sql.append(" WHERE \r\n");
/* 2406 */     sql.append(" (ftag = -1) \r\n");
/* 2407 */     sql.append(" group by TP.FAccountID ,TP.FCompanyID ");
/* 2408 */     partner.executeSql(sql.toString(), null);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void insertSumAccountGroupByCurrency(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 2421 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 2422 */     StringBuffer sql = new StringBuffer();
/* 2423 */     sql.append("INSERT ");
/* 2424 */     sql.append(partner.getTempTableName());
/* 2425 */     sql.append(" \r\n");
/* 2426 */     sql.append(" (FAccountID, FCurrencyID,FCompanyID, \r\n");
/* 2427 */     sql.append(" FBeginBalanceFor, \r\n");
/* 2428 */     sql.append(" FBeginBalanceLocal, \r\n");
/* 2429 */     sql.append(" FBeginBalanceRpt, \r\n");
/* 2430 */     sql.append(" FDebitFor, \r\n");
/* 2431 */     sql.append(" FDebitLocal, \r\n");
/* 2432 */     sql.append(" FDebitRpt, \r\n");
/* 2433 */     sql.append(" FCreditFor, \r\n");
/* 2434 */     sql.append(" FCreditLocal, \r\n");
/* 2435 */     sql.append(" FCreditRpt, \r\n");
/* 2436 */     sql.append(" FEndBalanceFor, \r\n");
/* 2437 */     sql.append(" FEndBalanceLocal, \r\n");
/* 2438 */     sql.append(" FEndBalanceRpt, \r\n");
/* 2439 */     sql.append(" FDebitCount, \r\n");
/* 2440 */     sql.append(" FCredtiCount, \r\n");
/* 2441 */     sql.append(" FTag,FLineType\t\r\n");
/*      */ 
/* 2443 */     if (condition.isOptionShowAsstItem()) {
/* 2444 */       sql.append(" ,FAsstHgID \r\n");
/*      */     }
/* 2446 */     sql.append(")");
/* 2447 */     sql.append("SELECT ' ' FAccountID, Temp.FCurrencyID, Temp.FCompanyID, \r\n");
/* 2448 */     sql.append(" SUM(ISNULL(Temp.FBeginBalanceFor,0)) FBeginBalanceFor, \r\n");
/* 2449 */     sql.append(" SUM(ISNULL(Temp.FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2450 */     sql.append(" SUM(ISNULL(Temp.FBeginBalanceRpt,0)) FBeginBalanceRpt, \r\n");
/* 2451 */     sql.append(" SUM(ISNULL(Temp.FDebitFor,0)) FDebitFor, \r\n");
/* 2452 */     sql.append(" SUM(ISNULL(Temp.FDebitLocal,0)) FDebitLocal, \r\n");
/* 2453 */     sql.append(" SUM(ISNULL(Temp.FDebitRpt,0)) FDebitRpt, \r\n");
/* 2454 */     sql.append(" SUM(ISNULL(Temp.FCreditFor,0)) FCreditFor, \r\n");
/* 2455 */     sql.append(" SUM(ISNULL(Temp.FCreditLocal,0)) FCreditLocal, \r\n");
/* 2456 */     sql.append(" SUM(ISNULL(Temp.FCreditRpt,0)) FCreditRpt, \r\n");
/* 2457 */     sql.append(" SUM(ISNULL(Temp.FEndBalanceFor,0)) FEndBalanceFor, \r\n");
/* 2458 */     sql.append(" SUM(ISNULL(Temp.FEndBalanceLocal,0)) FEndBalanceLocal, \r\n");
/* 2459 */     sql.append(" SUM(ISNULL(Temp.FEndBalanceRpt,0)) FEndBalanceRpt, \r\n");
/* 2460 */     sql.append(" SUM(ISNULL(Temp.FDebitCount,0)) FDebitCount, \r\n");
/* 2461 */     sql.append(" SUM(ISNULL(Temp.FCredtiCount,0)) FCredtiCount, \r\n");
/* 2462 */     sql.append(" 2 FTag, \r\n");
/* 2463 */     sql.append(" case when Temp.FCurrencyID is null or Temp.FCurrencyID = ' ' then 2 else 1 end  FLineType \r\n");
/*      */ 
/* 2465 */     if (condition.isOptionShowAsstItem()) {
/* 2466 */       sql.append(" , null FAssistGrpID \r\n");
/*      */     }
/* 2468 */     sql.append(" FROM ");
/* 2469 */     sql.append(" (SELECT tp.FAccountID, TP.FCurrencyID, TP.FCompanyID, \r\n");
/* 2470 */     sql.append(" SUM(ISNULL(FBeginBalanceFor,0)) FBeginBalanceFor, \r\n");
/* 2471 */     sql.append(" SUM(ISNULL(FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2472 */     sql.append(" SUM(ISNULL(FBeginBalanceRpt,0)) FBeginBalanceRpt, \r\n");
/* 2473 */     sql.append(" SUM(ISNULL(tp.FDebitFor,0)) FDebitFor, \r\n");
/* 2474 */     sql.append(" SUM(ISNULL(tp.FDebitLocal,0)) FDebitLocal, \r\n");
/* 2475 */     sql.append(" SUM(ISNULL(FDebitRpt,0)) FDebitRpt, \r\n");
/* 2476 */     sql.append(" SUM(ISNULL(tp.FCreditFor,0)) FCreditFor, \r\n");
/* 2477 */     sql.append(" SUM(ISNULL(tp.FCreditLocal,0)) FCreditLocal, \r\n");
/* 2478 */     sql.append(" SUM(ISNULL(FCreditRpt,0)) FCreditRpt, \r\n");
/* 2479 */     sql.append(" SUM(ISNULL(tp.FEndBalanceFor,0)) FEndBalanceFor, \r\n");
/* 2480 */     sql.append(" SUM(ISNULL(tp.FEndBalanceLocal,0)) FEndBalanceLocal, \r\n");
/* 2481 */     sql.append(" SUM(ISNULL(FEndBalanceRpt,0)) FEndBalanceRpt, \r\n");
/* 2482 */     sql.append(" SUM(ISNULL(FDebitCount,0)) FDebitCount, \r\n");
/* 2483 */     sql.append(" SUM(ISNULL(FCredtiCount,0)) FCredtiCount,");
/* 2484 */     sql.append(" tp.ftag  from ").append(partner.getTempTableName()).append(" Tp \r\n");
/* 2485 */     sql.append(" INNER JOIN T_BD_AccountView TA ON TP.FAccountID = TA.FID \r\n");
/* 2486 */     sql.append(" where \r\n");
/* 2487 */     sql.append(" ftag<>0 and ta.flevel>=? and ta.flevel<=? and (ta.fisleaf = 1 or ta.flevel=?) \r\n");
/* 2488 */     sql.append(" group by tp.faccountid,tp.fcurrencyid,tp.fcompanyid,ftag) temp \r\n");
/* 2489 */     if ((condition.isOptionNOTDisplayIfNoAmount()) || (condition.isOptionNOTDisplayIfBalanceZero())) {
/* 2490 */       sql.append(" where (temp.ftag=1 and (temp.FCredtiCount <>0 or temp.FDebitCount<>0)) \r\n");
/* 2491 */       sql.append(" or ( \r\n");
/* 2492 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2493 */         sql.append(" (temp.FEndBalancelocal <> 0) ");
/*      */       }
/* 2495 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 2496 */         if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2497 */           sql.append(" and ");
/*      */         }
/* 2499 */         sql.append(" (temp.FDebitlocal <> 0 or temp.FCreditlocal <> 0 )");
/*      */       }
/* 2501 */       sql.append(" )");
/*      */     }
/* 2503 */     sql.append(" group by Temp.Fcurrencyid,Temp.FCompanyID\r\n");
/*      */ 
/* 2505 */     SqlParameter2 parameter = new SqlParameter2();
/*      */ 
/* 2507 */     parameter.addValue(partner.getFixCondition().getAccountLevelStart());
/* 2508 */     parameter.addValue(partner.getFixCondition().getAccountLevelEnd());
/* 2509 */     parameter.addValue(partner.getFixCondition().getAccountLevelEnd());
/*      */
/*      */ 
/* 2512 */     partner.executeSql(sql.toString(), parameter);
/*      */   }
/*      */
/*      */   private void insertSumAccountCurrencyUnion(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2518 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*      */ 
/* 2520 */     boolean isSameCurrencyLocal = true;
/* 2521 */     StringBuffer str = new StringBuffer();
/* 2522 */     str.append(" SELECT DISTINCT FBASECURRENCYID FROM T_ORG_COMPANY WHERE FID IN ");
/* 2523 */     str.append(partner.getPhysicalCompanyId(false));
/* 2524 */     IRowSet rs = DbUtil.executeQuery(partner.getContext(), str.toString());
/* 2525 */     if (rs.size() > 1) {
/* 2526 */       isSameCurrencyLocal = false;
/*      */     }
/* 2528 */     StringBuffer sql = new StringBuffer();
/* 2529 */     sql.append("INSERT ");
/* 2530 */     sql.append(partner.getTempTableName());
/* 2531 */     sql.append(" \r\n");
/*      */ 
/* 2533 */     sql.append(" (FAccountID, FCurrencyID, \t\t\t\r\n");
/* 2534 */     sql.append("  FCompanyID,\t\r\n");
/* 2535 */     sql.append("  FBeginBalanceFor,  \r\n");
/* 2536 */     sql.append("  FBeginBalanceLocal, \r\n");
/* 2537 */     sql.append("  FBeginBalanceRpt, \r\n");
/* 2538 */     sql.append("  FDebitFor,  FDebitLocal,  FDebitRpt, \r\n");
/* 2539 */     sql.append("  FCreditFor, FCreditLocal, FCreditRpt, \r\n");
/* 2540 */     sql.append("  FEndBalanceFor, FEndBalanceLocal, FEndBalanceRpt, \r\n");
/* 2541 */     sql.append("  FDebitCount,   FCredtiCount, \r\n");
/* 2542 */     sql.append("  FTag,  FLineType \t\r\n");
/*      */ 
/* 2544 */     if (condition.isOptionShowAsstItem()) {
/* 2545 */       sql.append("  ,FAsstHgID \t\t\t\t\t\t\r\n");
/* 2546 */       sql.append(" \t  ,  FAccountOrAssist  \r\n");
/*      */     }
/* 2548 */     sql.append(")");
/* 2549 */     sql.append("SELECT TP.FAccountID , ' ' FCurrencyID, TP.FCompanyID FCompanyID,\t\t\t\t\r\n");
/*      */ 
/* 2551 */     sql.append("\t0.00 FBeginBalanceFor, \t\r\n");
/* 2552 */     sql.append("\tSUM(ISNULL(TP.FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2553 */     sql.append("\tSUM(ISNULL(TP.FBeginBalanceRpt,0)) FBeginBalanceRpt, \t\t\t\r\n");
/* 2554 */     sql.append("\t0.00 FDebitFor, \t\t\t\r\n");
/* 2555 */     sql.append("\tSUM(ISNULL(tp.FDebitLocal,0)) FDebitLocal, \t\t\r\n");
/* 2556 */     sql.append("\tSUM(ISNULL(TP.FDebitRpt,0)) FDebitRpt, \t\r\n");
/* 2557 */     sql.append("\t0.00 FCreditFor, \t\r\n");
/* 2558 */     sql.append("\tSUM(ISNULL(tp.FCreditLocal,0)) FCreditLocal, \t\t\r\n");
/* 2559 */     sql.append("\tSUM(ISNULL(TP.FCreditRpt,0)) FCreditRpt, \t\t\t\t\r\n");
/* 2560 */     sql.append("\t0.00 FEndBalanceFor, \t\t\r\n");
/* 2561 */     sql.append("\tSUM(ISNULL(tp.FEndBalanceLocal,0)) FEndBalanceLocal, \t\t\r\n");
/* 2562 */     sql.append("\tSUM(ISNULL(TP.FEndBalanceRpt,0)) FEndBalanceRpt, \t\t\t\r\n");
/*      */ 
/* 2564 */     sql.append("\tSUM(ISNULL(FDebitCount,0)) FDebitCount, \t\t\t\r\n");
/* 2565 */     sql.append("\tSUM(ISNULL(FCredtiCount,0)) FCredtiCount, \t\t\r\n");
/* 2566 */     sql.append("   1 FTag  ,0 FLineType                                     \r\n");
/*      */ 
/* 2568 */     if (condition.isOptionShowAsstItem()) {
/* 2569 */       sql.append("\t, null FAsstHgID \t\t\t\t\t\t\t\t\r\n");
/* 2570 */       sql.append(" \t  ,2  FAccountOrAssist  \r\n");
/*      */     }
/*      */ 
/* 2573 */     sql.append(" FROM ");
/* 2574 */     sql.append(partner.getTempTableName());
/* 2575 */     sql.append(" TP \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
/* 2576 */     sql.append("\tINNER JOIN T_BD_AccountView TA ON TP.FAccountID = TA.FID \t\t\t\r\n");
/*      */ 
/* 2578 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/* 2579 */       sql.append(" INNER JOIN \r\n");
/* 2580 */       sql.append("(SELECT * FROM \r\n");
/* 2581 */       sql.append(" (SELECT FAccountID AS FAccountID, \r\n");
/* 2582 */       sql.append(" \t    FcurrencyID AS FcurrencyID,FCompanyID AS FCompanyID, \r\n");
/* 2583 */       sql.append("\t SUM(FDebitlocal) AS FDebitlocal,\r\n");
/* 2584 */       sql.append("     SUM(FCreditlocal) AS FCreditlocal,\r\n");
/* 2585 */       sql.append("     SUM(FEndBalancelocal) AS FEndBalancelocal \r\n");
/* 2586 */       sql.append("   FROM  \r\n");
/* 2587 */       sql.append(partner.getTempTableName());
/* 2588 */       sql.append("   where FAsstHgID is null  \r\n");
/*      */
/*      */ 
/* 2591 */       sql.append("   GROUP BY FAccountID,FcurrencyID,FCompanyID) as T1 \r\n");
/*      */ 
/* 2593 */       sql.append("  where \r\n");
/* 2594 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2595 */         sql.append(" (FEndBalancelocal <> 0 or FAccountID is null or FAccountID=' ')");
/*      */       }
/* 2597 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 2598 */         if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2599 */           sql.append(" and ");
/*      */         }
/* 2601 */         sql.append(" (FDebitlocal <> 0 or FCreditlocal <> 0 or FAccountID is null or FAccountID=' ')");
/*      */       }
/* 2603 */       sql.append("\r\n ) as T_Condition on T_Condition.FAccountID = tp.FAccountID and T_Condition.FcurrencyID = tp.FcurrencyID\r\n");
/*      */     }
/*      */ 
/* 2606 */     sql.append(" WHERE  \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
/* 2607 */     sql.append(" (ftag=-1 ) \t\t\t\t\t\r\n");
/*      */ 
/* 2609 */     if (condition.isOptionShowAsstItem()) {
/* 2610 */       sql.append("  and tp.FAccountOrAssist = 2 ");
/*      */     }
/*      */ 
/* 2613 */     sql.append(" group by TP.FAccountID ,TP.FCompanyID ");
/*      */
/*      */ 
/* 2616 */     SqlParameter2 parameter = new SqlParameter2();
/*      */ 
/* 2618 */     partner.executeSql(sql.toString(), parameter);
/*      */
/*      */ 
/* 2621 */     sql.setLength(0);
/* 2622 */     sql.append("INSERT ");
/* 2623 */     sql.append(partner.getTempTableName());
/* 2624 */     sql.append(" \r\n");
/*      */ 
/* 2626 */     sql.append(" (FAccountID, FCurrencyID, \tFCompanyID,\t\t\r\n");
/* 2627 */     sql.append("  FBeginBalanceFor,  \r\n");
/* 2628 */     sql.append("  FBeginBalanceLocal, \r\n");
/* 2629 */     sql.append("  FBeginBalanceRpt, \r\n");
/* 2630 */     sql.append("  FDebitFor,  FDebitLocal,  FDebitRpt, \r\n");
/* 2631 */     sql.append("  FCreditFor, FCreditLocal, FCreditRpt, \r\n");
/* 2632 */     sql.append("  FEndBalanceFor, FEndBalanceLocal, FEndBalanceRpt, \r\n");
/* 2633 */     sql.append("  FDebitCount,   FCredtiCount, \r\n");
/* 2634 */     sql.append("  FTag,FLineType\t\r\n");
/*      */
/*      */ 
/* 2637 */     if (condition.isOptionShowAsstItem()) {
/* 2638 */       sql.append(" \t,  FAccountOrAssist");
/* 2639 */       sql.append("  ,FAsstHgID \t\t\t\t\t\r\n");
/*      */     }
/* 2641 */     sql.append(")");
/* 2642 */     sql.append("SELECT ' ' FAccountID , Temp.FCurrencyID, \tTemp.FCompanyID FCompanyID,\t\t\t\r\n");
/* 2643 */     sql.append("\tsum(isnull(temp.fbeginbalancefor,0)) FBeginBalanceFor, \t\r\n");
/* 2644 */     sql.append("\tSUM(ISNULL(temp.FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2645 */     sql.append("\tSUM(ISNULL(temp.FBeginBalanceRpt,0)) FBeginBalanceRpt, \t\t\t\r\n");
/* 2646 */     sql.append("\tsum(isnull(temp.fdebitfor,0)) FDebitFor, \t\t\t\r\n");
/* 2647 */     sql.append("\tSUM(ISNULL(temp.FDebitLocal,0)) FDebitLocal, \t\t\r\n");
/* 2648 */     sql.append("\tSUM(ISNULL(temp.FDebitRpt,0)) FDebitRpt, \t\r\n");
/* 2649 */     sql.append("\tsum(isnull(temp.fcreditfor,0)) FCreditFor, \t\r\n");
/* 2650 */     sql.append("\tSUM(ISNULL(temp.FCreditLocal,0)) FCreditLocal, \t\t\r\n");
/* 2651 */     sql.append("\tSUM(ISNULL(temp.FCreditRpt,0)) FCreditRpt, \t\t\t\t\r\n");
/* 2652 */     sql.append("\tsum(isnull(temp.fendbalancefor,0)) FEndBalanceFor, \t\t\r\n");
/* 2653 */     sql.append("\tSUM(ISNULL(temp.FEndBalanceLocal,0)) FEndBalanceLocal, \t\t\r\n");
/* 2654 */     sql.append("\tSUM(ISNULL(temp.FEndBalanceRpt,0)) FEndBalanceRpt, \t\t\t\r\n");
/* 2655 */     sql.append("\tSUM(ISNULL(Temp.FDebitCount,0)) FDebitCount, \t\t\t\r\n");
/* 2656 */     sql.append("\tSUM(ISNULL(Temp.FCredtiCount,0)) FCredtiCount, \t\r\n");
/* 2657 */     sql.append("   \t2 FTag   ,case when Temp.FCurrencyID is null or Temp.FCurrencyID = ' ' then 2 else 1 end  FLineType        \r\n");
/*      */ 
/* 2659 */     if (condition.isOptionShowAsstItem()) {
/* 2660 */       sql.append(" \t, 3  FAccountOrAssist");
/* 2661 */       sql.append("\t, null FAssistGrpID \t\t\t\t\t\t\t\t\r\n");
/*      */     }
/* 2663 */     sql.append("\tFrom (");
/* 2664 */     sql.append("SELECT tp.FAccountID , TP.FCurrencyID, \tTb.FCompanyID FCompanyID,\t\t\t\r\n");
/* 2665 */     sql.append("\tsum(isnull(tp.fbeginbalancefor,0)) FBeginBalanceFor, \t\r\n");
/* 2666 */     sql.append("\tSUM(ISNULL(TP.FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2667 */     sql.append("\tSUM(ISNULL(TP.FBeginBalanceRpt,0)) FBeginBalanceRpt, \t\t\t\r\n");
/* 2668 */     sql.append("\tsum(isnull(tp.fdebitfor,0)) FDebitFor, \t\t\t\r\n");
/* 2669 */     sql.append("\tSUM(ISNULL(tp.FDebitLocal,0)) FDebitLocal, \t\t\r\n");
/* 2670 */     sql.append("\tSUM(ISNULL(TP.FDebitRpt,0)) FDebitRpt, \t\r\n");
/* 2671 */     sql.append("\tsum(isnull(tp.fcreditfor,0)) FCreditFor, \t\r\n");
/* 2672 */     sql.append("\tSUM(ISNULL(tp.FCreditLocal,0)) FCreditLocal, \t\t\r\n");
/* 2673 */     sql.append("\tSUM(ISNULL(TP.FCreditRpt,0)) FCreditRpt, \t\t\t\t\r\n");
/* 2674 */     sql.append("\tsum(isnull(tp.fendbalancefor,0)) FEndBalanceFor, \t\t\r\n");
/* 2675 */     sql.append("\tSUM(ISNULL(tp.FEndBalanceLocal,0)) FEndBalanceLocal, \t\t\r\n");
/* 2676 */     sql.append("\tSUM(ISNULL(TP.FEndBalanceRpt,0)) FEndBalanceRpt, \t\t\t\r\n");
/* 2677 */     sql.append("\tSUM(ISNULL(TP.FDebitCount,0)) FDebitCount, \t\t\t\r\n");
/* 2678 */     sql.append("\tSUM(ISNULL(TP.FCredtiCount,0)) FCredtiCount \t\t\r\n");
/*      */ 
/* 2680 */     sql.append("FROM ");
/* 2681 */     sql.append(partner.getTempTableName());
/* 2682 */     sql.append(" TP \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
/* 2683 */     sql.append("\tINNER JOIN T_BD_AccountView TA ON TP.FAccountID = TA.FID \t\t\t\r\n");
/* 2684 */     sql.append("  inner join V_BD_AccountView TB on TA.FNumber=TB.FNumber and TA.FAccountTableId=TB.FAccountTableId \r\n");
/*      */ 
/* 2686 */     sql.append("    and (TB.FCompanyId=TP.FCompanyId or TB.FCompanyId='").append(partner.getCompanyId()).append("')\r\n");
/* 2687 */     sql.append(" WHERE  ftag<>0\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
/*      */ 
/* 2689 */     sql.append(" and ( ta.flevel>=? and ta.flevel<=? and (ta.fisleaf = 1 or ta.flevel=?)  ) \t\t\t\t\t\r\n");
/*      */ 
/* 2691 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2692 */       sql.append("   AND (TA.FNumber >= ?)  \r\n");
/*      */
/*      */     }
/*      */ 
/* 2696 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2697 */       sql.append(" AND (TA.FNumber <= ?)  \r\n");
/*      */     }
/* 2699 */     if (condition.isOptionShowAsstItem()) {
/* 2700 */       sql.append("  and tp.FAccountOrAssist = 2 ");
/*      */     }
/*      */ 
/* 2703 */     sql.append(" group by tp.faccountid,TP.Fcurrencyid,TB.FCompanyID ) temp ");
/* 2704 */     sql.append("\twhere 1=1 \r\n");
/* 2705 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/* 2706 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2707 */         sql.append("  and (Temp.FEndBalancelocal <> 0 )");
/*      */       }
/* 2709 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 2710 */         sql.append(" and (Temp.FDebitlocal <> 0 or Temp.FCreditlocal <> 0 )");
/*      */       }
/*      */     }
/* 2713 */     sql.append(" group by temp.fcurrencyid,temp.fcompanyid");
/*      */ 
/* 2715 */     parameter = new SqlParameter2();
/*      */ 
/* 2717 */     parameter.addValue(partner.getFixCondition().getAccountLevelStart());
/* 2718 */     parameter.addValue(partner.getFixCondition().getAccountLevelEnd());
/* 2719 */     parameter.addValue(partner.getFixCondition().getAccountLevelEnd());
/*      */ 
/* 2721 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2722 */       parameter.addValueVarchar(condition.getAccountCodeStart());
/*      */     }
/*      */ 
/* 2725 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2726 */       parameter.addValueVarchar(condition.getAccountCodeEnd() + "~~");
/*      */     }
/*      */ 
/* 2729 */     partner.executeSql(sql.toString(), parameter);
/*      */ 
/* 2731 */     if (!(isSameCurrencyLocal))
/* 2732 */       partner.executeSql("update " + partner.getTempTableName() + " set FBeginBalanceLocal=0,FEndBalanceLocal=0,FDebitLocal=0,FCreditLocal=0 where ftag=2 and fcompanyid not in" + partner.getPhysicalCompanyId(false), null);
/*      */   }
/*      */
/*      */   private void insertSumAccountGroupByCurrencyUnion(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 2738 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/*      */ 
/* 2740 */     boolean isSameCurrencyLocal = true;
/* 2741 */     StringBuffer str = new StringBuffer();
/* 2742 */     str.append(" SELECT DISTINCT FBASECURRENCYID FROM T_ORG_COMPANY WHERE FID IN ");
/* 2743 */     str.append(partner.getPhysicalCompanyId(false));
/* 2744 */     IRowSet rs = DbUtil.executeQuery(partner.getContext(), str.toString());
/* 2745 */     if (rs.size() > 1) {
/* 2746 */       isSameCurrencyLocal = false;
/*      */     }
/* 2748 */     StringBuffer sql = new StringBuffer();
/*      */
/*      */ 
/* 2751 */     sql.setLength(0);
/* 2752 */     sql.append("INSERT ");
/* 2753 */     sql.append(partner.getTempTableName());
/* 2754 */     sql.append(" \r\n");
/*      */ 
/* 2756 */     sql.append(" (FAccountID, FCurrencyID, \tFCompanyID,\t\t\r\n");
/* 2757 */     sql.append("  FBeginBalanceFor,  \r\n");
/* 2758 */     sql.append("  FBeginBalanceLocal, \r\n");
/* 2759 */     sql.append("  FBeginBalanceRpt, \r\n");
/* 2760 */     sql.append("  FDebitFor,  FDebitLocal,  FDebitRpt, \r\n");
/* 2761 */     sql.append("  FCreditFor, FCreditLocal, FCreditRpt, \r\n");
/* 2762 */     sql.append("  FEndBalanceFor, FEndBalanceLocal, FEndBalanceRpt, \r\n");
/* 2763 */     sql.append("  FDebitCount,   FCredtiCount, \r\n");
/* 2764 */     sql.append("  FTag,FLineType\t\r\n");
/*      */
/*      */ 
/* 2767 */     if (condition.isOptionShowAsstItem()) {
/* 2768 */       sql.append(" \t,  FAccountOrAssist");
/* 2769 */       sql.append("  ,FAsstHgID \t\t\t\t\t\r\n");
/*      */     }
/* 2771 */     sql.append(")");
/* 2772 */     sql.append("SELECT ' ' FAccountID , Temp.FCurrencyID, \tTemp.FCompanyID FCompanyID,\t\t\t\r\n");
/* 2773 */     sql.append("\tsum(isnull(temp.fbeginbalancefor,0)) FBeginBalanceFor, \t\r\n");
/* 2774 */     sql.append("\tSUM(ISNULL(temp.FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2775 */     sql.append("\tSUM(ISNULL(temp.FBeginBalanceRpt,0)) FBeginBalanceRpt, \t\t\t\r\n");
/* 2776 */     sql.append("\tsum(isnull(temp.fdebitfor,0)) FDebitFor, \t\t\t\r\n");
/* 2777 */     sql.append("\tSUM(ISNULL(temp.FDebitLocal,0)) FDebitLocal, \t\t\r\n");
/* 2778 */     sql.append("\tSUM(ISNULL(temp.FDebitRpt,0)) FDebitRpt, \t\r\n");
/* 2779 */     sql.append("\tsum(isnull(temp.fcreditfor,0)) FCreditFor, \t\r\n");
/* 2780 */     sql.append("\tSUM(ISNULL(temp.FCreditLocal,0)) FCreditLocal, \t\t\r\n");
/* 2781 */     sql.append("\tSUM(ISNULL(temp.FCreditRpt,0)) FCreditRpt, \t\t\t\t\r\n");
/* 2782 */     sql.append("\tsum(isnull(temp.fendbalancefor,0)) FEndBalanceFor, \t\t\r\n");
/* 2783 */     sql.append("\tSUM(ISNULL(temp.FEndBalanceLocal,0)) FEndBalanceLocal, \t\t\r\n");
/* 2784 */     sql.append("\tSUM(ISNULL(temp.FEndBalanceRpt,0)) FEndBalanceRpt, \t\t\t\r\n");
/* 2785 */     sql.append("\tSUM(ISNULL(Temp.FDebitCount,0)) FDebitCount, \t\t\t\r\n");
/* 2786 */     sql.append("\tSUM(ISNULL(Temp.FCredtiCount,0)) FCredtiCount, \t\r\n");
/* 2787 */     sql.append("   \t2 FTag   ,case when Temp.FCurrencyID is null or Temp.FCurrencyID = ' ' then 2 else 1 end  FLineType        \r\n");
/*      */ 
/* 2789 */     if (condition.isOptionShowAsstItem()) {
/* 2790 */       sql.append(" \t, 3  FAccountOrAssist");
/* 2791 */       sql.append("\t, null FAssistGrpID \t\t\t\t\t\t\t\t\r\n");
/*      */     }
/* 2793 */     sql.append("\tFrom (");
/* 2794 */     sql.append("SELECT tp.FAccountID , TP.FCurrencyID, \tTb.FCompanyID FCompanyID,\t\t\t\r\n");
/* 2795 */     sql.append("\tsum(isnull(tp.fbeginbalancefor,0)) FBeginBalanceFor, \t\r\n");
/* 2796 */     sql.append("\tSUM(ISNULL(TP.FBeginBalanceLocal,0)) FBeginBalanceLocal, \r\n");
/* 2797 */     sql.append("\tSUM(ISNULL(TP.FBeginBalanceRpt,0)) FBeginBalanceRpt, \t\t\t\r\n");
/* 2798 */     sql.append("\tsum(isnull(tp.fdebitfor,0)) FDebitFor, \t\t\t\r\n");
/* 2799 */     sql.append("\tSUM(ISNULL(tp.FDebitLocal,0)) FDebitLocal, \t\t\r\n");
/* 2800 */     sql.append("\tSUM(ISNULL(TP.FDebitRpt,0)) FDebitRpt, \t\r\n");
/* 2801 */     sql.append("\tsum(isnull(tp.fcreditfor,0)) FCreditFor, \t\r\n");
/* 2802 */     sql.append("\tSUM(ISNULL(tp.FCreditLocal,0)) FCreditLocal, \t\t\r\n");
/* 2803 */     sql.append("\tSUM(ISNULL(TP.FCreditRpt,0)) FCreditRpt, \t\t\t\t\r\n");
/* 2804 */     sql.append("\tsum(isnull(tp.fendbalancefor,0)) FEndBalanceFor, \t\t\r\n");
/* 2805 */     sql.append("\tSUM(ISNULL(tp.FEndBalanceLocal,0)) FEndBalanceLocal, \t\t\r\n");
/* 2806 */     sql.append("\tSUM(ISNULL(TP.FEndBalanceRpt,0)) FEndBalanceRpt, \t\t\t\r\n");
/*      */ 
/* 2808 */     sql.append("\tSUM(ISNULL(TP.FDebitCount,0)) FDebitCount, \t\t\t\r\n");
/* 2809 */     sql.append("\tSUM(ISNULL(TP.FCredtiCount,0)) FCredtiCount \t\t\r\n");
/*      */ 
/* 2811 */     sql.append("FROM ");
/* 2812 */     sql.append(partner.getTempTableName());
/* 2813 */     sql.append(" TP \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
/* 2814 */     sql.append("\tINNER JOIN T_BD_AccountView TA ON TP.FAccountID = TA.FID \t\t\t\r\n");
/* 2815 */     sql.append("  inner join V_BD_AccountView TB on TA.FNumber=TB.FNumber and TA.FAccountTableId=TB.FAccountTableId \r\n");
/*      */ 
/* 2817 */     sql.append("    and (TB.FCompanyId=TP.FCompanyId or TB.FCompanyId='").append(partner.getCompanyId()).append("')\r\n");
/* 2818 */     sql.append(" WHERE  ftag<>0\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
/*      */ 
/* 2820 */     sql.append(" and ( ta.flevel>=? and ta.flevel<=? and (ta.fisleaf = 1 or ta.flevel=?)  ) \t\t\t\t\t\r\n");
/*      */ 
/* 2822 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2823 */       sql.append("   AND (TA.FNumber >= ?)  \r\n");
/*      */
/*      */     }
/*      */ 
/* 2827 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2828 */       sql.append(" AND (TA.FNumber <= ?)  \r\n");
/*      */     }
/* 2830 */     if (condition.isOptionShowAsstItem()) {
/* 2831 */       sql.append("  and tp.FAccountOrAssist = 2 ");
/*      */     }
/*      */ 
/* 2834 */     sql.append(" group by tp.faccountid,TP.Fcurrencyid,TB.FCompanyID ) temp ");
/* 2835 */     sql.append("\twhere 1=1 \r\n");
/* 2836 */     if ((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())) {
/* 2837 */       if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 2838 */         sql.append("  and (Temp.FEndBalancelocal <> 0 )");
/*      */       }
/* 2840 */       if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 2841 */         sql.append(" and (Temp.FDebitlocal <> 0 or Temp.FCreditlocal <> 0 )");
/*      */       }
/*      */     }
/* 2844 */     sql.append(" group by temp.fcurrencyid,temp.fcompanyid");
/*      */ 
/* 2846 */     SqlParameter2 parameter = new SqlParameter2();
/*      */ 
/* 2848 */     parameter.addValue(partner.getFixCondition().getAccountLevelStart());
/* 2849 */     parameter.addValue(partner.getFixCondition().getAccountLevelEnd());
/* 2850 */     parameter.addValue(partner.getFixCondition().getAccountLevelEnd());
/*      */
/*      */ 
/* 2853 */     if ((condition.getAccountCodeStart() != null) && (condition.getAccountCodeStart().trim().length() != 0)) {
/* 2854 */       parameter.addValueVarchar(condition.getAccountCodeStart());
/*      */
/*      */     }
/*      */ 
/* 2858 */     if ((condition.getAccountCodeEnd() != null) && (condition.getAccountCodeEnd().trim().length() != 0)) {
/* 2859 */       parameter.addValueVarchar(condition.getAccountCodeEnd() + "~~");
/*      */     }
/*      */ 
/* 2862 */     partner.executeSql(sql.toString(), parameter);
/*      */ 
/* 2864 */     if (!(isSameCurrencyLocal))
/* 2865 */       partner.executeSql("update " + partner.getTempTableName() + " set FBeginBalanceLocal=0,FEndBalanceLocal=0,FDebitLocal=0,FCreditLocal=0 where ftag=2 and fcompanyid not in" + partner.getPhysicalCompanyId(false), null);
/*      */   }
/*      */
/*      */
/*      */   protected boolean isSupportVirtual()
/*      */   {
/* 2871 */     return true; }
/*      */
/*      */   protected void insertTempTableForVirtual(ReportPartner partner, SimpleCompanyUserObject simpleCompanyUserObject) throws BOSException, EASBizException {
/* 2874 */     String companyId = simpleCompanyUserObject.getCompanyId();
/* 2875 */     String companyIdInClause = partner.getPhysicalCompanyIdByParent(simpleCompanyUserObject);
/* 2876 */     EntityViewInfo evi = partner.getCondition();
/* 2877 */     ReportConditionJournal customCondition = (ReportConditionJournal)evi.get("GLFixCondition");
/*      */ 
/* 2879 */     String expandAccount = (String)customCondition.getExpandInfo().get("AccountID");
/* 2880 */     String expandCurrency = (customCondition.getExpandInfo().get("CurrencyIDa") == null) ? null : (String)customCondition.getExpandInfo().get("CurrencyIDa");
/*      */
/*      */ 
/* 2883 */     boolean isSameCurrencyLocal = true;
/* 2884 */     StringBuffer str = new StringBuffer();
/* 2885 */     str.append(" \tSELECT DISTINCT FBASECURRENCYID FROM T_ORG_COMPANY WHERE FID IN \r\n");
/* 2886 */     str.append(" \t( select distinct com2.fid from t_org_company com1 \r\n");
/* 2887 */     str.append("\tinner join t_org_company com2 on charindex(com1.flongnumber,com2.flongnumber)=1 \r\n ");
/* 2888 */     str.append("\twhere com1.fid='").append(companyId).append("' ");
/* 2889 */     str.append("\tand com2.fid in \r\n");
/* 2890 */     str.append(partner.getPhysicalCompanyId(false));
/* 2891 */     str.append(" )");
/* 2892 */     IRowSet rs = DbUtil.executeQuery(partner.getContext(), str.toString());
/* 2893 */     if (rs.size() > 1) {
/* 2894 */       isSameCurrencyLocal = false;
/*      */     }
/*      */ 
/* 2897 */     StringBuffer sql = new StringBuffer();
/* 2898 */     if ((expandAccount == null) || (expandAccount.trim().length() > 0)) {
/* 2899 */       sql.append("INSERT ");
/* 2900 */       sql.append(partner.getTempTableName());
/* 2901 */       sql.append(" \r\n");
/* 2902 */       sql.append("\t(FACCOUNTID,FCURRENCYID,FCOMPANYID,FASSTHGID,  FBEGINBALANCEFOR,    \r\n");
/* 2903 */       sql.append("\tFBEGINBALANCELOCAL,      \r\n");
/* 2904 */       sql.append("\tFBEGINBALANCERPT,FDEBITFOR,FDEBITLOCAL,      \r\n");
/* 2905 */       sql.append("\tFDEBITRPT,FCREDITFOR,FCREDITLOCAL,      \r\n");
/* 2906 */       sql.append("\tFCREDITRPT,FENDBALANCEFOR,      \r\n");
/* 2907 */       sql.append("\tFENDBALANCELOCAL,FENDBALANCERPT,      \r\n");
/* 2908 */       sql.append("\tFDEBITCOUNT,FCREDTICOUNT,FTAG,FLINETYPE      \r\n");
/* 2909 */       if ((GlUtils.isCompanyUnion(partner.getCompany())) && (customCondition.isOptionShowAsstItem())) {
/* 2910 */         sql.append(" \t,FAccountOrAssist");
/*      */       }
/* 2912 */       sql.append("\t)");
/* 2913 */       if (isSameCurrencyLocal) {
/* 2914 */         sql.append("    SELECT TEMP.FACCOUNTID AS FACCOUNTID,TEMP.FCURRENCYID AS FCURRENCYID, \r\n").append("'" + companyId + "'");
/* 2915 */         sql.append("\tAS FCOMPANYID,NULL AS FASSTHGID, SUM(TEMP.FBEGINBALANCEFOR),     \r\n");
/* 2916 */         sql.append("\tSUM(TEMP.FBEGINBALANCELOCAL),SUM(TEMP.FBEGINBALANCERPT),      \r\n");
/* 2917 */         sql.append("\tSUM(TEMP.FDEBITFOR),SUM(TEMP.FDEBITLOCAL),SUM(TEMP.FDEBITRPT), \r\n ");
/* 2918 */         sql.append("\tSUM(TEMP.FCREDITFOR),SUM(TEMP.FCREDITLOCAL),SUM(TEMP.FCREDITRPT), \r\n ");
/* 2919 */         sql.append("\tSUM(TEMP.FENDBALANCEFOR),SUM(TEMP.FENDBALANCELOCAL),      \r\n");
/*      */       } else {
/* 2921 */         sql.append("    SELECT TEMP.FACCOUNTID AS FACCOUNTID,TEMP.FCURRENCYID AS FCURRENCYID, \r\n").append("'" + companyId + "'");
/* 2922 */         sql.append("\tAS FCOMPANYID,NULL AS FASSTHGID, SUM(TEMP.FBEGINBALANCEFOR),     \r\n");
/* 2923 */         sql.append("\t0.00,SUM(TEMP.FBEGINBALANCERPT),      \r\n");
/* 2924 */         sql.append("\tSUM(TEMP.FDEBITFOR),0.00,SUM(TEMP.FDEBITRPT), \r\n ");
/* 2925 */         sql.append("\tSUM(TEMP.FCREDITFOR),0.00,SUM(TEMP.FCREDITRPT), \r\n ");
/* 2926 */         sql.append("\tSUM(TEMP.FENDBALANCEFOR),0.00,      \r\n");
/*      */       }
/*      */ 
/* 2929 */       sql.append("\tSUM(TEMP.FENDBALANCERPT),SUM(TEMP.FDEBITCOUNT),SUM(TEMP.FCREDTICOUNT),      \r\n");
/* 2930 */       sql.append("\tFTag,FLineType\t \r\n");
/* 2931 */       if ((GlUtils.isCompanyUnion(partner.getCompany())) && (customCondition.isOptionShowAsstItem())) {
/* 2932 */         sql.append(" \t, 2 FAccountOrAssist");
/*      */       }
/* 2934 */       sql.append("\tFROM  (\r\n");
/* 2935 */       sql.append("    SELECT TB.FID AS FACCOUNTID,T.FCURRENCYID AS FCURRENCYID, \r\n");
/* 2936 */       sql.append("\tT.FCOMPANYID AS FCOMPANYID,\r\n");
/* 2937 */       sql.append("\tSUM(FBEGINBALANCEFOR) FBEGINBALANCEFOR,     \r\n");
/* 2938 */       sql.append("\tSUM(FBEGINBALANCELOCAL) FBEGINBALANCELOCAL,SUM(FBEGINBALANCERPT) FBEGINBALANCERPT,      \r\n");
/* 2939 */       sql.append("\tSUM(FDEBITFOR) FDEBITFOR,SUM(FDEBITLOCAL) FDEBITLOCAL,SUM(FDEBITRPT) FDEBITRPT,\r\n");
/* 2940 */       sql.append("\tSUM(FCREDITFOR) FCREDITFOR, SUM(FCREDITLOCAL) FCREDITLOCAL, \r\n ");
/* 2941 */       sql.append("\tSUM(FCREDITRPT) FCREDITRPT,SUM(FENDBALANCEFOR) FENDBALANCEFOR,SUM(FENDBALANCELOCAL) FENDBALANCELOCAL,      \r\n");
/* 2942 */       sql.append("\tSUM(FENDBALANCERPT) FENDBALANCERPT,SUM(FDEBITCOUNT) FDEBITCOUNT,SUM(FCREDTICOUNT) FCREDTICOUNT,      \r\n");
/* 2943 */       sql.append("\tFTag,FLineType\t \r\n");
/* 2944 */       sql.append("\tFROM \t\r\n");
/* 2945 */       sql.append(partner.getTempTableName());
/* 2946 */       sql.append("\tT INNER JOIN T_BD_ACCOUNTVIEW TA ON TA.FID= T.FACCOUNTID      \r\n");
/* 2947 */       sql.append("\tINNER JOIN T_BD_ACCOUNTVIEW TB ON TA.FNUMBER=TB.FNUMBER AND ");
/* 2948 */       sql.append(" \tTB.FCOMPANYID = '").append(companyId).append("'");
/* 2949 */       sql.append("\tAND TB.FACCOUNTTABLEID='").append(partner.getAccountTableId()).append("' \r\n");
/* 2950 */       if (expandAccount != null) {
/* 2951 */         sql.append("INNER JOIN T_BD_ACCOUNTVIEW TD ON TD.FNUMBER=TA.FNUMBER AND TD.FID='").append(expandAccount);
/* 2952 */         sql.append("'");
/*      */       }
/* 2954 */       sql.append("\tWHERE T.FCOMPANYID IN      \r\n");
/* 2955 */       sql.append(companyIdInClause);
/* 2956 */       if ((expandCurrency != null) && (expandCurrency.trim().length() > 0)) {
/* 2957 */         if (expandCurrency.equals("AllCurrency"))
/* 2958 */           sql.append(" and T.fcurrencyid = ' ' ");
/*      */         else {
/* 2960 */           sql.append(" and T.fcurrencyid = '").append(expandCurrency).append("' ");
/*      */         }
/*      */       }
/*      */ 
/* 2964 */       if ((GlUtils.isCompanyUnion(partner.getCompany())) && (customCondition.isOptionShowAsstItem())) {
/* 2965 */         sql.append(" \tAND T.FAccountOrAssist=2");
/*      */       }
/* 2967 */       sql.append("\tGROUP BY T.FCOMPANYID,TB.FID,T.FCURRENCYID,T.FTAG,T.FLINETYPE");
/* 2968 */       sql.append("\t) TEMP ");
/* 2969 */       sql.append("\tWHERE 1=1 ");
/* 2970 */       if ((customCondition.isOptionNOTDisplayIfBalanceZero()) || (customCondition.isOptionNOTDisplayIfNoAmount())) {
/* 2971 */         if (customCondition.isOptionNOTDisplayIfBalanceZero()) {
/* 2972 */           sql.append("  and (Temp.FEndBalancelocal <> 0 )");
/*      */         }
/* 2974 */         if (customCondition.isOptionNOTDisplayIfNoAmount()) {
/* 2975 */           sql.append(" and (Temp.FDebitlocal <> 0 or Temp.FCreditlocal <> 0 )");
/*      */         }
/*      */       }
/* 2978 */       sql.append("\tGROUP BY Temp.FAccountid,Temp.FCURRENCYID,Temp.FTAG,Temp.FLINETYPE");
/*      */     }
/*      */     else {
/* 2981 */       sql.setLength(0);
/* 2982 */       sql.append("INSERT ");
/* 2983 */       sql.append(partner.getTempTableName());
/* 2984 */       sql.append(" \r\n");
/* 2985 */       sql.append("\t(FACCOUNTID,FCURRENCYID,FCOMPANYID,FASSTHGID,      \r\n");
/* 2986 */       sql.append("\tFBEGINBALANCEFOR,FBEGINBALANCELOCAL,      \r\n");
/* 2987 */       sql.append("\tFBEGINBALANCERPT,FDEBITFOR,FDEBITLOCAL,      \r\n");
/* 2988 */       sql.append("\tFDEBITRPT,FCREDITFOR,FCREDITLOCAL,      \r\n");
/* 2989 */       sql.append("\tFCREDITRPT,FENDBALANCEFOR,      \r\n");
/* 2990 */       sql.append("\tFENDBALANCELOCAL,FENDBALANCERPT,      \r\n");
/* 2991 */       sql.append("\tFDEBITCOUNT,FCREDTICOUNT,FTAG,FLINETYPE      \r\n");
/* 2992 */       if ((GlUtils.isCompanyUnion(partner.getCompany())) && (customCondition.isOptionShowAsstItem())) {
/* 2993 */         sql.append(" \t,FAccountOrAssist");
/*      */       }
/* 2995 */       sql.append("\t)");
/* 2996 */       if (isSameCurrencyLocal) {
/* 2997 */         sql.append("    SELECT T.FACCOUNTID AS FACCOUNTID,T.FCURRENCYID AS FCURRENCYID, \r\n").append("'" + companyId + "'");
/* 2998 */         sql.append("\tAS FCOMPANYID,NULL AS FASSTHGID, SUM(FBEGINBALANCEFOR),     \r\n");
/* 2999 */         sql.append("\tSUM(FBEGINBALANCELOCAL),SUM(FBEGINBALANCERPT),      \r\n");
/* 3000 */         sql.append("\tSUM(FDEBITFOR),SUM(FDEBITLOCAL),SUM(FDEBITRPT),SUM(FCREDITFOR),      \r\n");
/* 3001 */         sql.append("\tSUM(FCREDITLOCAL),SUM(FCREDITRPT),SUM(FENDBALANCEFOR),SUM(FENDBALANCELOCAL),      \r\n");
/* 3002 */         sql.append("\tSUM(FENDBALANCERPT),SUM(FDEBITCOUNT),SUM(FCREDTICOUNT),      \r\n");
/* 3003 */         sql.append("\tFTag,FLineType\t \r\n");
/*      */       } else {
/* 3005 */         sql.append("    SELECT T.FACCOUNTID AS FACCOUNTID,T.FCURRENCYID AS FCURRENCYID, \r\n").append("'" + companyId + "'");
/* 3006 */         sql.append("\tAS FCOMPANYID,NULL AS FASSTHGID, SUM(FBEGINBALANCEFOR),     \r\n");
/* 3007 */         sql.append("\t0.0 FBEGINBALANCELOACL,SUM(FBEGINBALANCERPT), SUM(FDEBITFOR),     \r\n");
/* 3008 */         sql.append("\t0.0 FDEBITFOR,SUM(FDEBITRPT),SUM(FCREDITFOR),      \r\n");
/* 3009 */         sql.append("\t0.0 FCREDITLOCAL,SUM(FCREDITRPT),SUM(FENDBALANCEFOR), \r\n");
/* 3010 */         sql.append("    0.0 FENDBALANCELOCAL,      \r\n");
/* 3011 */         sql.append("\tSUM(FENDBALANCERPT),SUM(FDEBITCOUNT),SUM(FCREDTICOUNT),      \r\n");
/* 3012 */         sql.append("\tFTag,FLineType\t \r\n");
/*      */       }
/* 3014 */       if ((GlUtils.isCompanyUnion(partner.getCompany())) && (customCondition.isOptionShowAsstItem())) {
/* 3015 */         sql.append(" \t, 2 FAccountOrAssist");
/*      */       }
/* 3017 */       sql.append("\tFROM \t\r\n");
/* 3018 */       sql.append(partner.getTempTableName());
/*      */ 
/* 3020 */       sql.append("\tT WHERE T.FCOMPANYID IN      \r\n");
/* 3021 */       sql.append(companyIdInClause);
/* 3022 */       if ((expandCurrency != null) && (expandCurrency.trim().length() > 0)) {
/* 3023 */         if (expandCurrency.equals("AllCurrency"))
/* 3024 */           sql.append(" and T.fcurrencyid = ' ' ");
/*      */         else {
/* 3026 */           sql.append(" and T.fcurrencyid = '").append(expandCurrency).append("' ");
/*      */         }
/*      */       }
/* 3029 */       sql.append(" AND T.FTAG = 2 ");
/* 3030 */       sql.append("\tGROUP BY T.FACCOUNTID,T.FCURRENCYID,T.FTAG,T.FLINETYPE");
/*      */
/*      */     }
/*      */ 
/* 3034 */     partner.executeSql(sql.toString(), null);
/*      */   }
/*      */
/*      */
/*      */   protected String getQuerySql(ReportPartner partner)
/*      */     throws BOSException, EASBizException
/*      */   {
/* 3041 */     ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 3042 */     EntityViewInfo evi = partner.getCondition();
/* 3043 */     ReportConditionBase customCondition = (ReportConditionBase)evi.get("GLFixCondition");
/*      */
/*      */ 
/* 3046 */     String expandAccount = (String)customCondition.getExpandInfo().get("AccountID");
/* 3047 */     String expandCurrency = (customCondition.getExpandInfo().get("CurrencyIDa") == null) ? null : (String)customCondition.getExpandInfo().get("CurrencyIDa");
/* 3048 */     SimpleCompanyUserObject virtureCompany = new SimpleCompanyUserObject();
/* 3049 */     List userObjects = (List)evi.get("Companys");
/* 3050 */     StringBuffer inCompany = new StringBuffer("(");
/* 3051 */     for (int i = 0; i < userObjects.size(); ++i) {
/* 3052 */       virtureCompany = (SimpleCompanyUserObject)userObjects.get(i);
/* 3053 */       inCompany.append("'").append(virtureCompany.getCompanyId()).append("',");
/*      */     }
/* 3055 */     if (inCompany.length() > 1)
/* 3056 */       inCompany.replace(inCompany.length() - 1, inCompany.length(), ")");
/*      */     else {
/* 3058 */       inCompany.append(")");
/*      */     }
/* 3060 */     String sqlSelect = getSqlForDataSelect(partner);
/* 3061 */     String sqlFrom = getSqlForDataFrom(partner);
/* 3062 */     String sqlWhere = getSqlForDataWhere(partner);
/* 3063 */     String sqlOrder = getSqlForDataOrder(partner);
/* 3064 */     sqlWhere = sqlWhere + " and T_Main.FCompanyID in " + inCompany.toString();
/* 3065 */     if ((expandAccount != null) && (expandAccount.trim().length() == 0))
/*      */     {
/* 3067 */       sqlWhere = sqlWhere + " and FTag=2";
/*      */ 
/* 3069 */       if ((expandCurrency != null) && (expandCurrency.equals("AllCurrency")) && (partner.getFixCondition().isAllCurrency())) {
/* 3070 */         sqlWhere = sqlWhere + " and T_Main.FCurrencyID =' '";
/*      */       }
/*      */     }
/* 3073 */     else if ((expandAccount != null) && (expandAccount.trim().length() > 0) && (expandCurrency != null) && (expandCurrency.equals("AllCurrency")))
/*      */     {
/* 3075 */       sqlWhere = sqlWhere + " and T_Main.FCurrencyID = ' '";
/*      */     }
/*      */ 
/* 3078 */     Object selectedCompanyObj = partner.getCondition().get("SelectedCompany");
/* 3079 */     if ((selectedCompanyObj != null) && (selectedCompanyObj instanceof SimpleCompanyUserObject))
/*      */     {
/* 3081 */       CompanyOrgUnitInfo selectCompany = CompanyOrgUnitFactory.getLocalInstance(partner.getContext()).getCompanyOrgUnitInfo(new ObjectUuidPK(((SimpleCompanyUserObject)selectedCompanyObj).getCompanyId()));
/*      */ 
/* 3083 */       if (((virtureCompany != null) && (virtureCompany.isLeaf())) || ((!(GlUtils.isCompanyUnion(selectCompany))) && (((condition.isOptionNOTDisplayIfBalanceZero()) || (condition.isOptionNOTDisplayIfNoAmount())))))
/*      */
/*      */       {
/* 3086 */         if (condition.isOptionNOTDisplayIfBalanceZero()) {
/* 3087 */           sqlWhere = sqlWhere + " and (T_Main.FLineType =1 or (T_Main.FTag =2 and T_Main.FLineType =2) or T_Main.FEndBalancelocal <> 0 )";
/*      */         }
/* 3089 */         if (condition.isOptionNOTDisplayIfNoAmount()) {
/* 3090 */           sqlWhere = sqlWhere + " and (T_Main.FLineType =1 or (T_Main.FTag =2 and T_Main.FLineType =2) or T_Main.FDebitlocal <> 0 or T_Main.FCreditlocal <> 0 )";
/*      */         }
/*      */       }
/* 3093 */       if (condition.isOptionShowAsstItem())
/*      */       {
/* 3095 */         if (GlUtils.isCompanyUnion(selectCompany))
/* 3096 */           sqlWhere = sqlWhere + " and T_Main.FAsstHgID is null ";
/*      */         else {
/* 3098 */           sqlWhere = sqlWhere + " and T_Main.FAsstHgID is not null ";
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 3103 */     return "select " + sqlSelect + sqlFrom + sqlWhere + sqlOrder;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getStrCompanyIds(ReportPartner partner)
/*      */   {
/* 3112 */     if (this.strCompanyIds == null) {
/* 3113 */       ReportConditionJournal condition = (ReportConditionJournal)partner.getFixCondition();
/* 3114 */       StringBuffer result = new StringBuffer("(");
/* 3115 */       DefaultMutableTreeNode node = (DefaultMutableTreeNode)condition.getTreeModelOfCompany();
/* 3116 */       Enumeration e = node.depthFirstEnumeration();
/* 3117 */       while (e.hasMoreElements()) {
/* 3118 */         node = (DefaultMutableTreeNode)e.nextElement();
/* 3119 */         if (node.isLeaf());
/* 3120 */         SimpleCompanyUserObject userObject = (SimpleCompanyUserObject)node.getUserObject();
/* 3121 */         result.append("'").append(userObject.getCompanyId()).append("',");
/*      */       }
/*      */ 
/* 3124 */       if (result.length() > 1)
/* 3125 */         result.replace(result.length() - 1, result.length(), ")");
/*      */       else {
/* 3127 */         result.append(")");
/*      */       }
/* 3129 */       this.strCompanyIds = result.toString();
/*      */     }
/* 3131 */     return this.strCompanyIds;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private PeriodInfo getVirturePeriod(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 3143 */     StringBuffer sql = new StringBuffer();
/* 3144 */     sql.append(" SELECT top 1 p.fid FPeriodID,p.FPeriodYear FPeriodYear,p.FPeriodQuarter FPeriodQuarter,p.FBeginDate FBeginDate,p.FendDate FendDate,p.FPeriodNumber FPeriodNumber,p.FNumber FNumber \r\n");
/* 3145 */     sql.append(" FROM T_ORG_COMPANY com \r\n");
/* 3146 */     sql.append(" INNER JOIN T_BD_SYSTEMSTATUSCTROL sysctrl ON sysctrl.FCompanyID = com.FID \r\n");
/* 3147 */     sql.append(" INNER JOIN T_BD_SYSTEMSTATUS tsst ON sysctrl.FSystemStatusID=tsst.FID and tsst.FName=6 \r\n");
/* 3148 */     sql.append(" INNER JOIN T_BD_PERIOD p ON p.fid = sysctrl.FCurrentPeriodID AND sysctrl.FISSTART = 1 \r\n");
/* 3149 */     sql.append(" WHERE com.FID IN ").append(getStrCompanyIds(partner)).append(" \r\n");
/* 3150 */     sql.append(" order by p.fnumber asc ");
/* 3151 */     Connection cn = null;
/* 3152 */     PreparedStatement stmt = null;
/* 3153 */     ResultSet rs = null;
/* 3154 */     PeriodInfo theCurrentPeriod = new PeriodInfo();
/*      */     try {
/* 3156 */       cn = partner.getConnection();
/* 3157 */       stmt = cn.prepareStatement(sql.toString());
/* 3158 */       rs = stmt.executeQuery();
/* 3159 */       if (rs.next()) {
/* 3160 */         theCurrentPeriod.setId(BOSUuid.read(rs.getString("FPeriodID").toString()));
/* 3161 */         theCurrentPeriod.setPeriodYear(rs.getInt("FPeriodYear"));
/* 3162 */         theCurrentPeriod.setPeriodQuarter(rs.getInt("FPeriodQuarter"));
/* 3163 */         theCurrentPeriod.setBeginDate(rs.getDate("FBeginDate"));
/* 3164 */         theCurrentPeriod.setEndDate(rs.getTimestamp("FendDate"));
/* 3165 */         theCurrentPeriod.setPeriodNumber(rs.getInt("FPeriodNumber"));
/* 3166 */         theCurrentPeriod.setNumber(rs.getInt("FNumber"));
/*      */       }
/*      */     } catch (SQLException e) {
/*      */     }
/*      */     finally {
/* 3171 */       SQLUtils.cleanup(stmt);
/*      */     }
/* 3173 */     return theCurrentPeriod;
/*      */   }
/*      */
/*      */
/*      */   private boolean isShowForCurrency(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 3180 */     return ((partner.getCurrencyType() != 1) && (partner.getCurrencyType() != 2));
/*      */   }
/*      */
/*      */
/*      */
/*      */   private boolean isShowLocalCurrency(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 3188 */     return ((!(partner.isParmForeignCurrencySu())) && (((partner.getCurrencyType() == 1) || ((!(partner.isBaseCurrency())) && (partner.getCurrencyType() != 2)))));
/*      */   }
/*      */
/*      */   private boolean isShowReportCurrency(ReportPartner partner)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 3194 */     return ((!(partner.isParmForeignCurrencySu())) && (partner.isParmUseReportCurrency()) && (((partner.getCurrencyType() == 2) || ((!(partner.isReportingCurrency())) && (partner.getCurrencyType() != 1)))));
/*      */   }
/*      */
@Override
protected Object[] getLineObjects(ReportPartner arg0, ResultSet arg1)
		throws SQLException, BOSException, EASBizException {
	// TODO Auto-generated method stub
	return null;
} }


