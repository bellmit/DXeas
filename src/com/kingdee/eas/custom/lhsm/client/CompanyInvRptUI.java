/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.Icon;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.org.OrgTypeForOrgSwitchingEnum;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.lhsm.ForecastOrderFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
/**
 * 查看库存
 * @author lenovo
 *
 */
public class CompanyInvRptUI extends AbstractCompanyInvRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(CompanyInvRptUI.class);
    public String cuid="";
    public String orgidsall = "";
    /**
     * output class constructor
     */
    public CompanyInvRptUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionDelLine_actionPerformed
     */
    public void actionDelLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelLine_actionPerformed(e);
    }

	public Icon getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		cuid = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
//		if (cuid.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
//			MsgBox.showInfo("当前公司为虚体，不允许使用该功能。请选择实体公司！");
//			SysUtil.abort();
//		}
        initAction();
        
        this.cbByMaterial.setSelected(true);
        this.cbCumulativeCompany.setSelected(true);
        this.cbCumulativeCompany.setEnabled(true);
        this.cbCumulativeCompany.setVisible(true);
        this.setUITitle("查看库存");
        
        CompanyF7 cf7=new CompanyF7();
        prmtCompany.setSelector(cf7);
        prmtCompany.setValue(SysContext.getSysContext().getCurrentCompany());
	}
	public void initAction()throws Exception{
		this.btnQuery.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionQuery_actionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}	
		});
		this.btnCal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionCal_actionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}	
		});
		
		OrgTypeForOrgSwitchingEnum curEnum = OrgTypeForOrgSwitchingEnum.COMPANY;
		// 获取所有财务组织
//		String orgs = getUserOrgRangeOUsByOrgType(curEnum);
		
		
        this.prmtMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");		
        prmtMaterial.setVisible(true);		
        prmtMaterial.setEditable(true);		
        prmtMaterial.setDisplayFormat("$company.number$");		
        prmtMaterial.setEditFormat("$company.number$");		
        prmtMaterial.setCommitFormat("$company.number$");		
        prmtMaterial.setRequired(false);
        prmtMaterial.setEnabledMultiSelection(true);
        
        FullOrgUnitCollection foc = new FullOrgUnitCollection() ;
		UserInfo userinfo = SysContext.getSysContext().getCurrentUserInfo();
		if(userinfo != null){
			foc = OrgSwitchFacadeFactory.getRemoteInstance().getSimpleOrgRanges(new ObjectUuidPK(BOSUuid.read(userinfo.getId().toString())));
		}
		//Comm comm = new Comm();
		//orgidsall = comm.getOrgIdRange(foc);
        
        Set materialsID = new LinkedHashSet();
        StringBuffer sql=new StringBuffer();
		String materialid="";
		sql=new StringBuffer();
		sql.append(" select fnumber,cforgidid fid from T_LHS_SSorgList   ");
		//sql.append(" where cforgidid in ("+orgidsall+") ");
		sql.append(" order by fnumber  ");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		while(rs.next()){
			String  companyid=rs.getString("fid");
			materialsID.add(companyid);
			if(orgidsall.equals("")){
				orgidsall="'"+companyid+"'";
			}else{
				orgidsall=orgidsall+",'"+companyid+"'";
			}
		}
        this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
        prmtCompany.setVisible(true);		
        prmtCompany.setEditable(true);		
        prmtCompany.setDisplayFormat("$number$");		
        prmtCompany.setEditFormat("$number$");		
        prmtCompany.setCommitFormat("$number$");		
        prmtCompany.setRequired(false);
        FilterInfo filterInfo=new FilterInfo();
		//filterInfo.getFilterItems().add(new FilterItemInfo("parent.id",cuid,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);	
		prmtCompany.setEntityViewInfo(evi);
		prmtCompany.setEnabledMultiSelection(true);
	}
	
	public void actionCal_actionPerformed(ActionEvent e) throws Exception {
		StringBuffer sql=new StringBuffer();
		String materialid="";
		sql=new StringBuffer();
		Object[] sous =null;
		String materialids="";
		if(this.prmtMaterial.getValue()!=null){
			sous = (Object[])this.prmtMaterial.getValue();
			for(int m=0;m<sous.length;m++){
					MaterialInfo fou = (MaterialInfo)sous[m];
					if(fou!=null){
						if(materialids.equals("")){
							materialids="'"+fou.getId().toString()+"'";
						}else{
							materialids=materialids+",'"+fou.getId().toString()+"'";
						}
					}
			}
		}
		String companyids="";
		if(this.prmtCompany.getValue()!=null){
			sous = (Object[])this.prmtCompany.getValue();
			for(int m=0;m<sous.length;m++){
					SaleOrgUnitInfo fou = (SaleOrgUnitInfo)sous[m];
					if(fou!=null){
						if(companyids.equals("")){
							companyids="'"+fou.getId().toString()+"'";
						}else{
							companyids=companyids+",'"+fou.getId().toString()+"'";
						}
					}
			}
		}else{
			companyids = orgidsall;
		}
		
		ForecastOrderFacadeFactory.getRemoteInstance().companyInv(companyids,materialids);
		initTableDataA(this.kdtEntry,materialids);
	}
	public void actionQuery_actionPerformed(ActionEvent e) throws Exception {
		StringBuffer sql=new StringBuffer();
		String materialid="";
//		if(this.prmtMaterial.getValue()!=null){
//			MaterialInfo materialinfo=(MaterialInfo)this.prmtMaterial.getValue();
//			materialid=materialinfo.getId().toString();
//		}
		Object[] sous =null;
		String materialids="";
		if(this.prmtMaterial.getValue()!=null){
			sous = (Object[])this.prmtMaterial.getValue();
			for(int m=0;m<sous.length;m++){
					MaterialInfo fou = (MaterialInfo)sous[m];
					if(fou!=null){
						if(materialids.equals("")){
							materialids="'"+fou.getId().toString()+"'";
						}else{
							materialids=materialids+",'"+fou.getId().toString()+"'";
						}
					}
			}
		}
		initTableDataA(this.kdtEntry,materialids);
	}
	public void initTableDataA(KDTable kdTable,String materialid) throws EASBizException, BOSException, SQLException{
		java.awt.Color rowColor=new Color(255,128,0);
		kdTable.checkParsed();
		kdTable.removeRows();
		//SaleOrgUnitInfo saleinfo=(SaleOrgUnitInfo)this.prmtCompany.getValue();
		Object[] sous =null;
		String companyids="";
		if(this.prmtCompany.getValue()!=null){
			sous = (Object[])this.prmtCompany.getValue();
			for(int m=0;m<sous.length;m++){
					SaleOrgUnitInfo fou = (SaleOrgUnitInfo)sous[m];
					if(fou!=null){
						if(companyids.equals("")){
							companyids="'"+fou.getId().toString()+"'";
						}else{
							companyids=companyids+",'"+fou.getId().toString()+"'";
						}
					}
			}
		}
		if(companyids.equals("")){
			companyids = orgidsall;
		}
		sous =null;
		
    	String cuid;
		cuid = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		IRow row;
		ICell cell;
		StringBuffer sql=new StringBuffer();
		sql.append("select ");
		sql.append(" t1.fid,t1.fnumber,t2.fname_l2 fcompanyname,t3.fname_l2 fmaterialname, ");
		sql.append(" isnull(t1.cfqty,0) fqty,isnull(t1.cfqty1,0) fqty1,case when t1.cfqty2 is null then t1.cfqty else t1.cfqty2  end fqty2 ");
		sql.append(" from CT_LHS_CompanyInv t1");
		sql.append(" inner join t_org_company t2 on t2.fid=t1.cfcompanyid ");
		sql.append(" inner join t_bd_material t3 on t3.fid=t1.cfmaterialid ");
		if(!materialid.equals("")){
			
			sql.append(" where cfmaterialid in("+materialid+") ");
			if(!companyids.equals("")){
				sql.append(" and t2.fid in("+companyids+") ");
			}
//			if(this.prmtCompany.getValue()!=null){
//				SaleOrgUnitInfo corginfo=(SaleOrgUnitInfo)this.prmtCompany.getValue();
//				sql.append(" and t2.fid='"+corginfo.getId().toString()+"' ");
//				
////				PurContractJFacadeFactory.getRemoteInstance().companyInv(corginfo.getId().toString(),materialid);
//			}
		}else{
			if(!companyids.equals("")){
				sql.append(" where t2.fid in("+companyids+") ");
			}else{
				
			}
		}
		String orderSql = " order by t2.fnumber,t3.fnumber";
		if(this.cbByMaterial.isSelected()){
			orderSql = " order by t3.fnumber,t2.fnumber";
		}
		sql.append(orderSql);
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		int m= 0;
		// 保存当前操作的公司名称
		String currColumnName = StringUtils.EMPTY;
		BigDecimal currQtySum = BigDecimal.ZERO;
		BigDecimal currQty1Sum = BigDecimal.ZERO;
		BigDecimal currQty2Sum = BigDecimal.ZERO;
		// 总和
		BigDecimal qtySum = BigDecimal.ZERO;
		BigDecimal qty1Sum = BigDecimal.ZERO;
		BigDecimal qty2Sum = BigDecimal.ZERO;
		
		String totalColumnName = "";
		kdTable.getColumn("material").getStyleAttributes().setHided(false);
		kdTable.getColumn("company").getStyleAttributes().setHided(false);
		while(rs.next()){
			double i1 = rs.getDouble("fqty");
			double i2 = rs.getDouble("fqty1");
			if(i1 == 0 &&i2==0 ){
				continue;
			}
			String columnNameStr = "fcompanyname";
			if(this.cbByMaterial.isSelected()){
				columnNameStr = "fmaterialname";
			}
			currColumnName = rs.getString(columnNameStr);
			
			// 公司名称变化 则添加合计行
			
			if(!(this.cbByMaterial.isSelected() && this.cbCumulativeCompany.isSelected()) && 
					(this.cbByMaterial.isSelected() || this.cbCumulativeCompany.isSelected()) &&
					StringUtils.isNotBlank(currColumnName) && 
					currColumnName.compareTo(totalColumnName) != 0 && 
					StringUtils.isNotBlank(totalColumnName)){
				kdTable.getColumn("material").getStyleAttributes().setHided(true);
				kdTable.getColumn("company").getStyleAttributes().setHided(true);
				row = kdTable.addRow();
//				row.getStyleAttributes().setBackground(Color.ORANGE);
				if(this.cbByMaterial.isSelected()){
					kdTable.getColumn("material").getStyleAttributes().setHided(false);
					cell = row.getCell(kdTable.getColumnIndex("material"));
					cell.setValue(totalColumnName);//i
				}else{
					kdTable.getColumn("company").getStyleAttributes().setHided(false);
					cell = row.getCell(kdTable.getColumnIndex("company"));
					cell.setValue(totalColumnName);//i
				}
				
				
//				cell.getStyleAttributes().setHorizontalAlign(com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment.CENTER);
				cell = row.getCell(kdTable.getColumnIndex("qty"));
				cell.setValue(currQtySum);//i
				currQtySum = BigDecimal.ZERO;
				cell = row.getCell(kdTable.getColumnIndex("qty1"));
				cell.setValue(currQty1Sum);//i
				currQty1Sum = BigDecimal.ZERO;
				cell = row.getCell(kdTable.getColumnIndex("qty2"));
				cell.setValue(currQty2Sum);//i
				currQty2Sum = BigDecimal.ZERO;
			}
			
			totalColumnName = currColumnName;
			
			BigDecimal fqty = rs.getBigDecimal("fqty")==null?BigDecimal.ZERO:rs.getBigDecimal("fqty");
			currQtySum = currQtySum.add(fqty);
			qtySum = qtySum.add(fqty);
			
			
			BigDecimal fqty1 = rs.getBigDecimal("fqty1")==null?BigDecimal.ZERO:rs.getBigDecimal("fqty1");
			currQty1Sum = currQty1Sum.add(fqty1);
			qty1Sum = qty1Sum.add(fqty1);
			
			BigDecimal fqty2 = rs.getBigDecimal("fqty2")==null?BigDecimal.ZERO:rs.getBigDecimal("fqty2");
			currQty2Sum = currQty2Sum.add(fqty2);
			qty2Sum = qty2Sum.add(fqty2);
			// 只有两个都选才显示明细
			if(this.cbByMaterial.isSelected() && this.cbCumulativeCompany.isSelected()){
				row = kdTable.addRow();
				
				//
				cell = row.getCell(kdTable.getColumnIndex("id"));
				cell.setValue(rs.getString("fid"));//id
				
				cell = row.getCell(kdTable.getColumnIndex("number"));
				cell.setValue(rs.getString("fnumber"));//id
				
				cell = row.getCell(kdTable.getColumnIndex("company"));
				cell.setValue(rs.getString("fcompanyname"));//id
				
				cell = row.getCell(kdTable.getColumnIndex("material"));
				cell.setValue(rs.getString("fmaterialname"));//id
				
				cell = row.getCell(kdTable.getColumnIndex("qty"));
				cell.setValue(fqty);//i
				
				cell = row.getCell(kdTable.getColumnIndex("qty1"));
				cell.setValue(fqty1);//i
				
				cell = row.getCell(kdTable.getColumnIndex("qty2"));
				cell.setValue(fqty2);//i
			}
			
		}
		
		if( StringUtils.isNotBlank(totalColumnName) && 
				!(this.cbByMaterial.isSelected() && this.cbCumulativeCompany.isSelected()) && 
				(this.cbByMaterial.isSelected() || this.cbCumulativeCompany.isSelected()) ){
			row = kdTable.addRow();
//			row.getStyleAttributes().setBackground(Color.ORANGE);
			if( this.cbByMaterial.isSelected()){
				cell = row.getCell(kdTable.getColumnIndex("material"));
				cell.setValue(totalColumnName);//i
			}else{
				cell = row.getCell(kdTable.getColumnIndex("company"));
				cell.setValue(totalColumnName);//i
			}
			
//			cell.getStyleAttributes().setHorizontalAlign(com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment.CENTER);
			cell = row.getCell(kdTable.getColumnIndex("qty"));
			cell.setValue(currQtySum);//i
			cell = row.getCell(kdTable.getColumnIndex("qty1"));
			cell.setValue(currQty1Sum);//i
			cell = row.getCell(kdTable.getColumnIndex("qty2"));
			cell.setValue(currQty2Sum);//i
		}
		if(!this.cbByMaterial.isSelected() && !this.cbCumulativeCompany.isSelected()){
			kdTable.getColumn("material").getStyleAttributes().setHided(true);
			// 添加最后合计行
			row = kdTable.addRow();
			row.getStyleAttributes().setBackground(Color.ORANGE);
			
			cell = row.getCell(kdTable.getColumnIndex("company"));		
			cell.setValue("总计");//i
			cell.getStyleAttributes().setHorizontalAlign(com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment.CENTER);
			cell = row.getCell(kdTable.getColumnIndex("qty"));
			cell.setValue(qtySum);//i
			cell = row.getCell(kdTable.getColumnIndex("qty1"));
			cell.setValue(qty1Sum);//i
			cell = row.getCell(kdTable.getColumnIndex("qty2"));
			cell.setValue(qty2Sum);//i
			
		}
		
		// 设置table锁定
		kdTable.getStyleAttributes().setLocked(true);
		
	}
}