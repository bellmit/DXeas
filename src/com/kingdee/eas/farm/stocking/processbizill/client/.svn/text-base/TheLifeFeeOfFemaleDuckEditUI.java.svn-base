/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDProgressBar;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckInfo;
import com.kingdee.eas.fi.cas.PaymentBill;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

import freemarker.template.SimpleDate;

/**
 * output class name
 */
public class TheLifeFeeOfFemaleDuckEditUI extends AbstractTheLifeFeeOfFemaleDuckEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(TheLifeFeeOfFemaleDuckEditUI.class);

	/**
	 * output class constructor
	 */
	public TheLifeFeeOfFemaleDuckEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		prmtoutAreas.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		prmtoutAreas.setVisible(true);
		prmtoutAreas.setEditable(true);
		prmtoutAreas.setDisplayFormat("$name$");
		prmtoutAreas.setEditFormat("$name$");
		prmtoutAreas.setCommitFormat("$name$");
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnCreateTo.setVisible(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		//		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);


		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		UIUtil.apendFootRow(kdtEntrys, new String[]{"femaleQty","lifeFeeAll","settleAmt"});
		txttotalAmt.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("lifeFeeAll").getValue()));
		txtsettleAmt.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("settleAmt").getValue()));
		txtfemaleQty.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("femaleQty").getValue()));

		kdtEntrys.getColumn("femaleQty").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("lifeFeeAvg").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("lifeFeeAll").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(kdtEntrys, new String[]{"femaleQty","lifeFeeAll"});
				txttotalAmt.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("lifeFeeAll").getValue()));
				txtsettleAmt.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("settleAmt").getValue()));
				txtfemaleQty.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("femaleQty").getValue()));
			}});

		btnSearch.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(prmtoutAreas.getValue()==null||prmtperiod.getValue()==null||prmtcompany.getValue()==null)
					commUtils.giveUserTipsAndRetire("期间或者片区或公司不能为空");
				kdtEntrys.removeRows();
				AddRowsAccordingToOutAreaAndPeriod();
			}
		});

		//修改图标
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		TheLifeFeeOfFemaleDuckInfo objectValue = new TheLifeFeeOfFemaleDuckInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		//set period =last month's period
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		try {
			objectValue.setPeriod(DateUtilsComm.getUpperPeriodInfo(PeriodFactory.getRemoteInstance().getPeriodCollection("where number='"+ sdf.format(new Date())+"'").get(0)));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objectValue;
	}

	/**
	 * 添加行数
	 */
	private void AddRowsAccordingToOutAreaAndPeriod()  {
		// TODO Auto-generated method stub
		FarmersTreeInfo outAreaInfo = (FarmersTreeInfo) prmtoutAreas.getValue();
		PeriodInfo periodInfo = (PeriodInfo)prmtperiod.getValue();
		CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo)prmtcompany.getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal=Calendar.getInstance();
		cal.set(periodInfo.getPeriodYear(), periodInfo.getPeriodNumber(), 15);
		String sp="\n";
		String str="" +
		"/*dialect*/select"+sp+
		" t6.FID                                  farmerID,"+sp+
		" t5.FID                                  stockID, "+sp+
		" t10.FAvgFemaleFee                       lifeFeeA"+sp+
		//		" sum(nvl(t2.FFemaleBreedkingStock,0))    stocking"+sp+
		" from "+sp+
		" T_FM_StockingBreedDaily               t1"+sp+
		"inner join T_FM_StockingBDAE           t2 on t1.FID=t2.FParentID"+sp+
		"       and t1.CFBaseStatus in (4,7)"+sp+
		"       and to_char(t1.FBizDate,'yyyyMMdd')='"+sdf.format(periodInfo.getEndDate())+"'"+sp+
		"inner join T_FM_StockingBatch          t3 on t3.FID=t1.CFStockingBatchID"+sp+
		"inner join T_FM_Farm                   t4 on t4.FID=t1.CFFarmID"+sp+
		"      and t4.FFarmType not in (1)--非公司自养和股东自养"+sp+
		"inner join T_FM_StockingBatch          t5 on t5.FID=t1.CFStockingBatchID"+sp+
		"      and t5.FFormalDate is not null "+sp+
		"      and to_char(t5.FFormalDate,'yyyyMMdd')<='"+sdf.format(cal.getTime())+"'"+sp+
		"inner join T_FM_Farmers                t6 on t6.FID=t1.FFarmerID"+sp+
		"inner join T_FM_FarmersTREE            t7 on t7.FID=t6.FTreeID"+sp+
		"      and t7.FID='"+outAreaInfo.getString("id")+"'"+sp+
		"inner join T_ORG_Company               t8 on t8.FId=t5.FCompanyID"+sp+
		"      and t8.FID='"+companyInfo.getString("id")+"'"+sp+
		"inner join T_FM_BatchContract          t9 on t9.FID=t5.FBatchContractID"+sp+
		"inner join T_FM_StatementsPolicy       t10 on t10.FID=t9.FSettlementPolicyI"+sp+
		//		"GROUP by t6.FID,t5.FID,t10.FAvgFemaleFee"+sp+
		"group by t6.FID,t5.FID,t10.FAvgFemaleFee ";

		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			while(rs.next()){
				kdtEntrys.addRow();
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "farmer").setValue(rs.getString("farmerID")==null?null:(FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(rs.getString("farmerID")))));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "stockingBatch").setValue(rs.getString("stockID")==null?null:(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("stockID")))));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "initDate").setValue(rs.getString("stockID")==null?null:StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("stockID"))).getInDate());
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "dayAge").setValue(rs.getString("stockID")==null?null:DateUtilsComm.getDiffBetweenTwoDays(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("stockID"))).getInDate(),periodInfo.getEndDate()));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "lifeFeeAvg").setValue(rs.getBigDecimal("lifeFeeA")==null?null:rs.getBigDecimal("lifeFeeA"));

			}
			setFemaleQty(companyInfo);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void setFemaleQty(CompanyOrgUnitInfo companyInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		IRowSet rs=null;
		for(int queryNum=0;queryNum<kdtEntrys.getRowCount();queryNum++){
			System.out.println((queryNum+1)+"/"+kdtEntrys.getRowCount());
			if(kdtEntrys.getCell(queryNum, "stockingBatch").getValue()!=null&&prmtperiod.getValue()!=null){
				StockingBatchInfo stockingBatchInfo = (StockingBatchInfo)kdtEntrys.getCell(queryNum, "stockingBatch").getValue();
				String endDate;
				try {
					endDate = (new SimpleDateFormat("yyyy-MM-dd")).format(UIRuleUtil.getProperty((IObjectValue) prmtperiod.getValue(),"endDate"));
					sb=getStringBuffer(stockingBatchInfo.getString("id"),endDate,companyInfo.getString("id"));
					rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
					if(rs.next()){
						kdtEntrys.getCell(queryNum, "femaleQty").setValue(rs.getInt("FFemaleQty")-rs.getInt("FFemaleDeathQty")-rs.getInt("FFemaleCullQty")+rs.getInt("FadjustFemaleQty"));
						kdtEntrys.getCell(queryNum, "lifeFeeAll").setValue((UIRuleUtil.getBigDecimal(kdtEntrys.getCell(queryNum, "femaleQty").getValue())).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(queryNum, "lifeFeeAvg").getValue())));
						BigDecimal amt=(BigDecimal) kdtEntrys.getCell(queryNum, "lifeFeeAll").getValue();
						amt=amt.divide(new BigDecimal(100),0,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100));
						kdtEntrys.getCell(queryNum, "lifeFeeAll").setValue(amt);
					}
				} catch (DataAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}  

		//		LongTimeDialog dialog = new LongTimeDialog((Frame) SwingUtilities    
		//				.getWindowAncestor(this));    
		//		dialog.setLongTimeTask(new ILongTimeTask() {
		//			StockingBatchInfo stockingBatchInfo;
		//			String endDate;
		//			IRowSet rs;
		//			StringBuffer sb=new StringBuffer();
		//			public Object exec() throws Exception {    
		//				for(int queryNum=0;queryNum<kdtEntrys.getRowCount();queryNum++){
		//					System.out.println((queryNum+1)+"/"+kdtEntrys.getRowCount());
		//					if(kdtEntrys.getCell(queryNum, "stockingBatch").getValue()!=null&&prmtperiod.getValue()!=null){
		//						stockingBatchInfo=(StockingBatchInfo)kdtEntrys.getCell(queryNum, "stockingBatch").getValue();
		//						endDate=(new SimpleDateFormat("yyyy-MM-dd")).format(UIRuleUtil.getProperty((IObjectValue) prmtperiod.getValue(),"endDate"));
		//						sb=getStringBuffer(stockingBatchInfo.getString("id"),endDate);
		//						rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
		//						if(rs.next()){
		//							kdtEntrys.getCell(queryNum, "femaleQty").setValue(rs.getInt("SFEMALEQTY")-rs.getInt("SHENDEATHQTY")-rs.getInt("SHENCULLQTY")+rs.getInt("SHENADJUSTQTY"));
		//							kdtEntrys.getCell(queryNum, "lifeFeeAll").setValue((UIRuleUtil.getBigDecimal(kdtEntrys.getCell(queryNum, "femaleQty").getValue())).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(queryNum, "lifeFeeAvg").getValue())));
		//							BigDecimal amt=(BigDecimal) kdtEntrys.getCell(queryNum, "lifeFeeAll").getValue();
		//							amt=amt.divide(new BigDecimal(100),0,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100));
		//							kdtEntrys.getCell(queryNum, "lifeFeeAll").setValue(amt);
		//						}
		//					}
		//				}  
		//				return null;    
		//			}    
		//
		//			public void afterExec(Object result) throws Exception {    
		//			}    
		//		});    
		//		Component[] cps=dialog.getContentPane().getComponents();    
		//		for(Component cp:cps){    
		//			if(cp instanceof JLabel){    
		//				((JLabel) cp).setText("数据查询中....");    
		//			}    
		//		}    
		//		dialog.show();    
	}
	private StringBuffer getStringBuffer(String stockingBacthID, String endDate, String companyOrgUnitID) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();

		String sp="\n";
		sb.append("/*dialect*/").append(sp);
		sb.append("SELECT tb.fid,TB.Fnumber,to_char(FInDate,'yyyy-MM-dd') FInDate,max(tb.FBatchQty) FBatchQty,max(tb.FFemaleQty) FFemaleQty,sum(tde.CFDeathQty) FDeathQty,sum(tde.CFCullQty) FCullQty,sum(FFemaleDeathQty) FFemaleDeathQty,sum(FFemaleCullQty) FFemaleCullQty,sum(FadjustQty) FadjustQty,sum(FadjustFemaleQty) FadjustFemaleQty").append(sp);
		sb.append("FROM T_FM_StockingBreedDaily td").append(sp);
		sb.append("inner join t_fm_stockingBatch tb on tb.fid=td.cfstockingbatchid").append(sp);
		sb.append("inner join T_FM_StockingBDAE tde on tde.fparentid=td.fid").append(sp);
		sb.append("where td.fcompanyid='").append(companyOrgUnitID).append("'").append(sp);
		//		--and td.CFBaseStatus=4
		sb.append("and td.fbizDate<{d '").append(endDate).append("'}+1").append(sp);
		sb.append("and tb.fid='").append(stockingBacthID).append("'").append(sp);
		sb.append("group by tb.fid,tb.fnumber,tb.FinDate").append(sp);
		sb.append("order by tb.findate desc").append(sp);

		//		sb.append("select").append(sp);
		//		sb.append(" t3.FName_l2                               farmerName, ").append(sp);
		//		sb.append(" t1.CFWeek                                 weekAge,").append(sp);
		//		sb.append(" t1.CFWeekDay                              dayAge,").append(sp);
		//		sb.append(" to_char(t1.FBizDate,'yyyy-MM-dd')         bizDate,").append(sp);
		//		sb.append(" sum(nvl(t2.CFBreekingStock,0))            cockQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FFemaleBreedkingStock,0))      henQty,").append(sp);
		//		sb.append(" sum(nvl(t2.CFDeathQty,0))                 cockDeathQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FFemaleDeathQty,0))            henDeathQty,").append(sp);
		//		sb.append(" sum(nvl(t2.CFCullQty,0))                  cockCullQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FFemaleCullQty,0))             henCullQty,").append(sp);
		//		sb.append(" nvl(tt0.FAllQty,0)                        eggQty,").append(sp);
		//		sb.append(" nvl(tt1.FTransQty,0)                      transQty,").append(sp);
		//		sb.append(" nvl(tt2.feeQty,0)                         feeQty,").append(sp);
		//		sb.append(" nvl(tt3.cockAdjust,0)                     scockAdjust,").append(sp);
		//		sb.append(" nvl(tt3.femaleAdjust,0)                   sfemaleAdjust,").append(sp);
		//		sb.append(" nvl(tt3.cockDeathQty,0)                   scockDeathQty,").append(sp);
		//		sb.append(" nvl(tt3.henDeathQty,0)                    shenDeathQty,").append(sp);
		//		sb.append(" nvl(tt3.cockCullQty,0)                    scockCullQty,").append(sp);
		//		sb.append(" nvl(tt3.henCullQty,0)                     shenCullQty,").append(sp);
		//		sb.append(" nvl(tt3.cockAdjustQty,0)                  scockAdjustQty,").append(sp);
		//		sb.append(" nvl(tt3.henAdjustQty,0)                   shenAdjustQty,").append(sp);
		//		sb.append(" nvl(tt3.transQty,0)                       stransQty,").append(sp);
		//		sb.append(" nvl(tt3.femaleQty,0)                      sfemaleQty,").append(sp);
		//		sb.append(" nvl(tt3.batchQty,0)                       sbatchQty").append(sp);
		//		sb.append(" from ").append(sp);
		//		sb.append("T_FM_StockingBreedDaily                     t1").append(sp);
		//		sb.append("inner join T_FM_StockingBDAE                t2 on t1.FID=t2.FParentID").append(sp);
		//		sb.append("      and t1.CFStockingBatchID='").append(stockingBacthID).append("'").append(sp);
		//		sb.append("inner join T_FM_Farmers                     t3 on t3.FID=t1.FFarmerID").append(sp);
		//		sb.append("inner join T_FM_FarmersTREE                 t4 on t4.FID=t3.FTreeID").append(sp);
		//		sb.append("      and to_char(t1.FBizDate,'yyyy-MM-dd')='").append(endDate).append("'").append(sp);
		//		sb.append("----------------------产蛋数-----------------------------").append(sp);
		//		sb.append("left  join(").append(sp);
		//		sb.append("select").append(sp);
		//		sb.append(" t1.FID                                     dailyID,").append(sp);
		//		sb.append(" sum(t2.FAllQty)                            FAllQty ").append(sp);
		//		sb.append(" from ").append(sp);
		//		sb.append(" T_FM_StockingBreedDaily                    t1").append(sp);
		//		sb.append("inner join T_FM_StockingBDEE                t2 on t1.FID=t2.FParentID").append(sp);
		//		sb.append("inner join T_FM_Farmers                     t3 on t3.FID=t1.FFarmerID").append(sp);
		//		sb.append("inner join T_FM_FarmersTREE                 t4 on t4.FID=t3.FTreeID").append(sp);
		//		sb.append("      and to_char(t1.FBizDate,'yyyy-MM-dd')='").append(endDate).append("'").append(sp);
		//		sb.append("GROUP by t1.FID").append(sp);
		//		sb.append(") tt0 on tt0.dailyID=t1.FID").append(sp);
		//		sb.append("--------------------------转入公鸡数---------------------------").append(sp);
		//		sb.append("left join(").append(sp);
		//		sb.append("select ").append(sp);
		//		sb.append(" t1.FID                                     dailyID,").append(sp);
		//		sb.append(" sum(nvl(t2.FTransQty,0))                          FTransQty").append(sp);
		//		sb.append("from ").append(sp);
		//		sb.append("T_FM_StockingBreedDaily                     t1").append(sp);
		//		sb.append("inner join T_FM_StockingBDTE                t2 on t1.FID=t2.FParentID").append(sp);
		//		sb.append("inner join T_FM_Farmers                     t3 on t3.FID=t1.FFarmerID").append(sp);
		//		sb.append("inner join T_FM_FarmersTREE                 t4 on t4.FID=t3.FTreeID").append(sp);
		//		sb.append("      and to_char(t1.FBizDate,'yyyy-MM-dd')='").append(endDate).append("'").append(sp);
		//		sb.append("GROUP by t1.FID").append(sp);
		//		sb.append(") tt1 on tt1.dailyID=t1.FID").append(sp);
		//		sb.append("--------------------------日喂料量---------------------------").append(sp);
		//		sb.append("left join(").append(sp);
		//		sb.append("select ").append(sp);
		//		sb.append(" t1.FID                                        dailyID,").append(sp);
		//		sb.append(" sum(nvl(t2.FFemaleDailyQty,0))+sum(nvl(t2.CFDailyQtyAll,0)) feeQty").append(sp);
		//		sb.append("from ").append(sp);
		//		sb.append("T_FM_StockingBreedDaily                     t1").append(sp);
		//		sb.append("inner join T_FM_StockingBreedDailyEntry                t2 on t1.FID=t2.FParentID").append(sp);
		//		sb.append("inner join T_FM_Farmers                     t3 on t3.FID=t1.FFarmerID").append(sp);
		//		sb.append("inner join T_FM_FarmersTREE                 t4 on t4.FID=t3.FTreeID").append(sp);
		//		sb.append("      and to_char(t1.FBizDate,'yyyy-MM-dd')='").append(endDate).append("'").append(sp);
		//		sb.append("GROUP by t1.FID").append(sp);
		//		sb.append(") tt2 on tt2.dailyID=t1.FID").append(sp);
		//		sb.append("").append(sp);
		//		sb.append("--------------------------------------").append(sp);
		//		sb.append("left join(").append(sp);
		//		sb.append("select").append(sp);
		//		sb.append(" t3.FName_l2                               farmerName,").append(sp);
		//		sb.append(" t4.FName_l2                               batchName, ").append(sp);
		//		sb.append(" t1.CFWeek                                 weekAge,").append(sp);
		//		sb.append(" t1.CFWeekDay                              dayAge,").append(sp);
		//		sb.append(" to_char(t1.FBizDate,'yyyy-MM-dd')         bizDate,").append(sp);
		//		sb.append(" t2.FAdjustQty                             cockAdjust,").append(sp);
		//		sb.append(" t2.FAdjustFemaleQty                       femaleAdjust,").append(sp);
		//		sb.append(" sum(nvl(t2.CFDeathQty,0))        OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)           cockDeathQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FFemaleDeathQty,0))   OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)           henDeathQty,").append(sp);
		//		sb.append(" sum(nvl(t2.CFCullQty,0))         OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)           cockCullQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FFemaleCullQty,0))    OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)           henCullQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FAdjustQty,0))        OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)           cockAdjustQty,").append(sp);
		//		sb.append(" sum(nvl(t2.FAdjustFemaleQty,0))  OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)           henAdjustQty,").append(sp);
		//		sb.append(" sum(nvl(tt1.FTransQty,0))        OVER (PARTITION by t3.FName_l2 order by t4.FName_l2,t3.FName_l2,t1.CFWeek,t1.CFWeekDay,t1.FBizDate,t4.FFemaleQty,t4.FBatchQty)                                  transQty,").append(sp);
		//		sb.append(" t4.FFemaleQty                             femaleQty,").append(sp);
		//		sb.append(" t4.FBatchQty                              batchQty").append(sp);
		//		sb.append(" ").append(sp);
		//		sb.append(" from ").append(sp);
		//		sb.append("T_FM_StockingBreedDaily                     t1").append(sp);
		//		sb.append("inner join T_FM_StockingBDAE                t2 on t1.FID=t2.FParentID").append(sp);
		//		sb.append("inner join T_FM_Farmers                     t3 on t3.FID=t1.FFarmerID").append(sp);
		//		sb.append("inner join T_FM_StockingBatch               t4 on t4.FID=t1.CFStockingBatchID").append(sp);
		//		sb.append("inner join T_FM_FarmersTREE                 t5 on t5.FID=t3.FTreeID").append(sp);
		//		sb.append("").append(sp);
		//		sb.append("--------------------------转入公鸡数---------------------------").append(sp);
		//		sb.append("left join(").append(sp);
		//		sb.append("select ").append(sp);
		//		sb.append(" t1.FID                                     dailyID,").append(sp);
		//		sb.append(" sum(nvl(t2.FTransQty,0))                          FTransQty").append(sp);
		//		sb.append("from ").append(sp);
		//		sb.append("T_FM_StockingBreedDaily                     t1").append(sp);
		//		sb.append("inner join T_FM_StockingBDTE                t2 on t1.FID=t2.FParentID").append(sp);
		//		sb.append("inner join T_FM_Farmers                     t3 on t3.FID=t1.FFarmerID").append(sp);
		//		sb.append("inner join T_FM_FarmersTREE                 t5 on t5.FID=t3.FTreeID").append(sp);
		//		sb.append("GROUP by t1.FID").append(sp);
		//		sb.append(") tt1 on tt1.dailyID=t1.FID").append(sp);
		//		sb.append(") tt3 on tt3.farmerName=t3.FName_l2 and to_char(t1.FBizDate,'yyyy-MM-dd')=tt3.BizDate").append(sp);
		//		sb.append("").append(sp);
		//		sb.append("").append(sp);
		//		sb.append("GROUP by  to_char(t1.FBizDate,'yyyy-MM-dd'),t3.FName_l2,t1.CFWeek,t1.CFWeekDay,tt0.FAllQty,tt1.FTransQty,tt2.feeQty, nvl(tt3.cockAdjust,0),nvl(tt3.femaleAdjust,0),nvl(tt3.cockDeathQty,0),nvl(tt3.henDeathQty,0),nvl(tt3.cockCullQty,0),nvl(tt3.henCullQty,0),nvl(tt3.cockAdjustQty,0),nvl(tt3.henAdjustQty,0),nvl(tt3.transQty,0),nvl(tt3.femaleQty,0),nvl(tt3.batchQty,0)").append(sp);
		//		sb.append("order by to_char(t1.FBizDate,'yyyy-MM-dd'),t3.FName_l2,t1.CFWeek,t1.CFWeekDay,tt0.FAllQty,tt1.FTransQty,tt2.feeQty").append(sp);



		return sb;
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		MsgBox.showInfo("审核成功");
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		MsgBox.showInfo("反审核成功");
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionEdit_actionPerformed(e);
		kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		//		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		UIUtil.refreshEditUI(this);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
	}
	//	@Override
	//	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
	//		// TODO Auto-generated method stub
	//		super.actionCreateTo_actionPerformed(e);
	//		if(editData.getId()==null)
	//			return;
	//		//校验生成付款单
	//		ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "40284E81");
	//		if(destObejctIDs.size()>0)
	//			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_TheLifeFeeOfFemaleDuck set FHasCasPaymentBill=1 where fid='"+editData.getString("id")+"'");
	//		
	//		UIUtil.refreshEditUI(this);
	//	}

}