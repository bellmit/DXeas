/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.eventbus.event.component.MouseClickEvent;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;

/**
 * output class name
 */
public class LifeFeeEditUI extends AbstractLifeFeeEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(LifeFeeEditUI.class);

	/**
	 * output class constructor
	 */
	public LifeFeeEditUI() throws Exception
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
		return com.kingdee.eas.farm.breed.layegg.LifeFeeFactory.getRemoteInstance();
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
		kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		UIUtil.apendFootRow(kdtEntrys, new String[]{"femaleQty","lifeFeeAvg","lifeFeeAll"});
		kdtEntrys.getColumn("femaleQty").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("lifeFeeAvg").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("lifeFeeAll").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		
		kdtEntrys.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(kdtEntrys, new String[]{"femaleQty","lifeFeeAvg","lifeFeeAll"});
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
		com.kingdee.eas.farm.breed.layegg.LifeFeeInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LifeFeeInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());

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
		" t10.FAvgFemaleFee                       lifeFeeA,"+sp+
		" sum(nvl(t2.FFemaleBreedkingStock,0))    stocking"+sp+
		" from "+sp+
		" T_FM_StockingBreedDaily               t1"+sp+
		"inner join T_FM_StockingBDAE           t2 on t1.FID=t2.FParentID"+sp+
		"       and t1.CFBaseStatus in (4,7)"+sp+
		"       and to_char(t1.FBizDate,'yyyyMMdd')='"+sdf.format(periodInfo.getEndDate())+"'"+sp+
		"inner join T_FM_StockingBatch          t3 on t3.FID=t1.CFStockingBatchID"+sp+
		"inner join T_FM_Farm                   t4 on t4.FID=t1.CFFarmID"+sp+
		"      and t4.FFarmType not in (1,2)--非公司自养和股东自养"+sp+
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
		"GROUP by t6.FID,t5.FID,t10.FAvgFemaleFee"+sp;

		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			while(rs.next()){
				if(rs.getInt("stocking")==0)
					continue;
				kdtEntrys.addRow();
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "farmer").setValue(rs.getString("farmerID")==null?null:(FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(rs.getString("farmerID")))));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "stockingBatch").setValue(rs.getString("stockID")==null?null:(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("stockID")))));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "initDate").setValue(rs.getString("stockID")==null?null:StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("stockID"))).getInDate());
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "dayAge").setValue(rs.getString("stockID")==null?null:DateUtilsComm.getDiffBetweenTwoDays(StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(rs.getString("stockID"))).getInDate(),periodInfo.getEndDate()));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "femaleQty").setValue(rs.getInt("stocking"));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "lifeFeeAvg").setValue(rs.getBigDecimal("lifeFeeA")==null?null:rs.getBigDecimal("lifeFeeA"));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "lifeFeeAll").setValue(new BigDecimal(rs.getInt("stocking")).multiply(rs.getBigDecimal("lifeFeeA")==null?BigDecimal.ZERO:rs.getBigDecimal("lifeFeeA")));
				BigDecimal amt=(BigDecimal) kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "lifeFeeAll").getValue();
				amt=amt.divide(new BigDecimal(100),0,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100));
				kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "lifeFeeAll").setValue(amt);
			}
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
		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
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

}