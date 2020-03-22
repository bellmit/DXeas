/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

import java.awt.Dimension;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;

import com.kingdee.eas.custom.szcount.ISzProdCount;
import com.kingdee.eas.custom.szcount.ISzSemiProduct;
import com.kingdee.eas.custom.szcount.SzCountPositionSetCollection;
import com.kingdee.eas.custom.szcount.SzCountPositionSetFactory;
import com.kingdee.eas.custom.szcount.SzCountPositionSetInfo;
import com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryCollection;
import com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryFactory;
import com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryInfo;
import com.kingdee.eas.custom.szcount.SzProdCountEntryCollection;
import com.kingdee.eas.custom.szcount.SzProdCountEntryInfo;
import com.kingdee.eas.custom.szcount.SzProdCountFactory;
import com.kingdee.eas.custom.szcount.SzProdCountInfo;
import com.kingdee.eas.custom.szcount.SzSemiProductEntryCollection;
import com.kingdee.eas.custom.szcount.SzSemiProductEntryInfo;
import com.kingdee.eas.custom.szcount.SzSemiProductFactory;
import com.kingdee.eas.custom.szcount.SzSemiProductInfo;
import com.kingdee.eas.custom.szcount.szClasses;
import com.kingdee.eas.farm.food.stocount.Classes;
import com.kingdee.eas.farm.food.stocount.PcakCountCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountFactory;
import com.kingdee.eas.farm.food.stocount.ProdCountCollection;
import com.kingdee.eas.farm.food.stocount.ProdCountFactory;
import com.kingdee.eas.farm.food.stocount.SemiProductCountCollection;
import com.kingdee.eas.farm.food.stocount.SemiProductCountFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */
public class SzSemiCountOperateUI extends AbstractSzSemiCountOperateUI
{
    @Override
	public void actionclselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		StringBuffer sql = new StringBuffer();

		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("t2.FLastUpdateTime bizdaste").append(sp);
		sql.append("from CT_SZC_SzCPSME t1").append(sp);
		sql.append("inner join CT_SZC_SzCountPositionSet t2").append(sp);
		sql.append("on t1.fparentid = t2.fid").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE t3").append(sp);
		sql.append("on t3.fparentid = t2.fid").append(sp);
		sql.append("inner join T_BD_Material t4").append(sp);
		sql.append("on t1.CFMaterialID = t4.fid").append(sp);
		sql.append("left join T_BD_Person t5").append(sp);
		sql.append("on t3.CFPersonID = t5.fid").append(sp);
		sql.append("inner join T_BD_MeasureUnit t6").append(sp);
		sql.append("on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup t7 ").append(sp);
		sql.append("on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("and t7.fnumber ='02010205'").append(sp);
		sql.append("or t7.fnumber ='02010105'").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		initselectTable(sql);
		System.out.println(sql.toString());
		super.actionclselect_actionPerformed(e);
	}


	@Override
	public void actionjjselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();

		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("t2.FLastUpdateTime bizdaste").append(sp);
		sql.append("from CT_SZC_SzCPSME t1").append(sp);
		sql.append("inner join CT_SZC_SzCountPositionSet t2").append(sp);
		sql.append("on t1.fparentid = t2.fid").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE t3").append(sp);
		sql.append("on t3.fparentid = t2.fid").append(sp);
		sql.append("inner join T_BD_Material t4").append(sp);
		sql.append("on t1.CFMaterialID = t4.fid").append(sp);
		sql.append("left join T_BD_Person t5").append(sp);
		sql.append("on t3.CFPersonID = t5.fid").append(sp);
		sql.append("inner join T_BD_MeasureUnit t6").append(sp);
		sql.append("on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup t7 ").append(sp);
		sql.append("on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("and t7.fnumber ='02010206'").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		initselectTable(sql);
		System.out.println(sql.toString());
		super.actionjjselect_actionPerformed(e);
	}


	@Override
	public void actionqtselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();

		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("t2.FLastUpdateTime bizdaste").append(sp);
		sql.append("from CT_SZC_SzCPSME t1").append(sp);
		sql.append("inner join CT_SZC_SzCountPositionSet t2").append(sp);
		sql.append("on t1.fparentid = t2.fid").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE t3").append(sp);
		sql.append("on t3.fparentid = t2.fid").append(sp);
		sql.append("inner join T_BD_Material t4").append(sp);
		sql.append("on t1.CFMaterialID = t4.fid").append(sp);
		sql.append("left join T_BD_Person t5").append(sp);
		sql.append("on t3.CFPersonID = t5.fid").append(sp);
		sql.append("inner join T_BD_MeasureUnit t6").append(sp);
		sql.append("on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup t7 ").append(sp);
		sql.append("on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("and t7.fnumber not in ('02010203','02010204','02010205','02010206')").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		initselectTable(sql);
		System.out.println(sql.toString());
		super.actionqtselect_actionPerformed(e);
	}


	@Override
	public void actiontlselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();

		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("t2.FLastUpdateTime bizdaste").append(sp);
		sql.append("from CT_SZC_SzCPSME t1").append(sp);
		sql.append("inner join CT_SZC_SzCountPositionSet t2").append(sp);
		sql.append("on t1.fparentid = t2.fid").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE t3").append(sp);
		sql.append("on t3.fparentid = t2.fid").append(sp);
		sql.append("inner join T_BD_Material t4").append(sp);
		sql.append("on t1.CFMaterialID = t4.fid").append(sp);
		sql.append("left join T_BD_Person t5").append(sp);
		sql.append("on t3.CFPersonID = t5.fid").append(sp);
		sql.append("inner join T_BD_MeasureUnit t6").append(sp);
		sql.append("on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup t7 ").append(sp);
		sql.append("on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("and t7.fnumber ='02010203'").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		initselectTable(sql);
		System.out.println(sql.toString());
		super.actiontlselect_actionPerformed(e);
	}


	@Override
	public void actionxlselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();

		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("t2.FLastUpdateTime bizdaste").append(sp);
		sql.append("from CT_SZC_SzCPSME t1").append(sp);
		sql.append("inner join CT_SZC_SzCountPositionSet t2").append(sp);
		sql.append("on t1.fparentid = t2.fid").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE t3").append(sp);
		sql.append("on t3.fparentid = t2.fid").append(sp);
		sql.append("inner join T_BD_Material t4").append(sp);
		sql.append("on t1.CFMaterialID = t4.fid").append(sp);
		sql.append("left join T_BD_Person t5").append(sp);
		sql.append("on t3.CFPersonID = t5.fid").append(sp);
		sql.append("inner join T_BD_MeasureUnit t6").append(sp);
		sql.append("on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup t7 ").append(sp);
		sql.append("on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("and t7.fnumber ='02010204'").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		initselectTable(sql);
		System.out.println(sql.toString());
		super.actionxlselect_actionPerformed(e);
	}

	private static final Logger logger = CoreUIObject.getLogger(SzSemiCountOperateUI.class);
    
    /**
     * output class constructor
     */
    public SzSemiCountOperateUI() throws Exception
    {
        super();
    }

    ArrayList List;
    String materid = "";
	String materialnumber = "";
	String countset = null;
	CostObjectInfo costobject = new CostObjectInfo();
	CostObjectFactory cost;
	MaterialInfo matet = new MaterialInfo(); 
	MaterialFactory maf;
	
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
        this.material.requestFocus();
    }
    

    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 作废功能
	 */
    protected void cancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	super.cancel_actionPerformed(e);
    	int row = this.kDTable1.getSelectManager().getActiveRowIndex();
    	
    	System.out.println(row);
    	String sfid = List.get(row).toString();
    	if(countset.equals("0")){
		String sql  = "update CT_FM_SemiProductCount set CFStatus = 3 where fid = '"+sfid+"'";
	
		System.out.println(sql);
		try {
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
			this.onShow();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	}else{
    		if(countset.equals("1")){
    			String sql  = "update CT_FM_ProdCount set CFStatus = 3 where fid = '"+sfid+"'";
        		System.out.println(sql);
        		try {
        			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
        			this.onShow();
        		} catch (BOSException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
    		}else{
    			String sql  = "update CT_FM_PcakCount set CFStatus = 3 where fid = '"+sfid+"'";
        		System.out.println(sql);
        		String sql1 = "select CFIsPackAcceptance from CT_FM_PcakCount where fid = '"+sfid+"'";
        		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql1.toString()).executeSQL();
        		if(rs.first()){
        			MsgBox.showInfo("已生成下游单据，不能作废");
        			SysUtil.abort();
    			}else{
        		try {
        			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
        			this.onShow();
        		} catch (BOSException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
    			}
    		}
    	}
    }

    /**
     * output QyBtn_actionPerformed method
     */
    protected void QyBtn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.QyBtn_actionPerformed(e);
    }

    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 清空按钮功能
	 */
    protected void clear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	super.clear_actionPerformed(e);
		this.material.setValue(null);
		this.materialunitf7.setValue(null);
		this.weight.setText(null);
		
    }

    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 打印+保存功能
	 */
    protected void print_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	
    	this.loadFields();
    	
		//控制中断
		if(this.material.getData()==null){
			MsgBox.showInfo("物料不能为空，请检查");
			SysUtil.abort();
		}
		BigDecimal w = new BigDecimal(this.weight.getText());
		BigDecimal n = new BigDecimal(TypeNumber());
		
		//岗位判断
		if(countset.equals("0")){
		//将UI中各值添加在新增的半成品计数上
			SzSemiProductInfo spinfo = new SzSemiProductInfo();			
			IObjectPK spk=null;
			spinfo.setNumber(createSeNumber());
			spinfo.setBizDate(new Date());
			
			
			
			//生成批次存入
			String batch1 = this.productDateF7.getText().toString();
			String batch2 = this.productDateF7.getText().toString();
			String batch3 = this.productDateF7.getText().toString();
			batch1 = batch1.substring(0, 4);
			batch2 = batch2.substring(5, 7);
			batch3 = batch3.substring(8, 10);
			StringBuffer batch = new StringBuffer();
			batch.append(batch1);
			batch.append(batch2);
			batch.append(batch3);
			
			matet = (MaterialInfo)this.material.getData();
			//定义分录
			SzSemiProductEntryCollection pinfoec= spinfo.getEntrys();
			SzSemiProductEntryInfo pinfoe = new SzSemiProductEntryInfo();
			pinfoe.setMaterial((MaterialInfo)this.material.getData());
			pinfoe.setMbaseunit(this.materialunitf7.getText());
			pinfoe.setMaterialtype(this.materialunittypef7.getText());
		
			pinfoe.setBatch(batch.toString());
			pinfoe.setMaterialnumber(materialnumber);
			
			System.out.println(this.material.getText()+"-----------------");
			//pinfoe.setInventoryUnit((MeasureUnitInfo) this.inventoryUnitF7.getData());
			BigDecimal weight = new BigDecimal("0");
			weight = w.multiply(n);
			pinfoe.setWeight((BigDecimal)weight);
			
			
			pinfoec.add(pinfoe);
			
			spinfo.setStatus(BillBaseStatusEnum.AUDITED);
			
//			System.out.println("+++++"+batch1+"+++++"+batch2+"++++"+batch3);
			spinfo.setClasses((szClasses)this.classes.getSelectedItem());
			String userid=((UserInfo)this.countpersonf7.getValue()).getId().toString();
			
			StringBuffer sql=new StringBuffer();
			sql.append("select FPersonId from T_PM_User where  fid ='").append(userid).append("'");
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				spinfo.setPerson(PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("FPersonId"))));
			}
			
			ISzSemiProduct isc = SzSemiProductFactory.getRemoteInstance();
			/*20170609 add B*/
			
			
			if(isc.exists(new ObjectUuidPK(spinfo.getId()))){
				spk=isc.save(spinfo);
			}else{
				spk=isc.save(spinfo);
			}
			
//			ArrayList idList = new ArrayList();
//			if(UIRuleUtil.isNotNull(spk)){
//				spinfo=isc.getSemiProductCountInfo(spk);
//			}
//	    	if (spinfo != null && !StringUtils.isEmpty(spinfo.getString("id"))) {
//	    		idList.add(spinfo.getString("id"));
//	    	}
//	        if (idList == null || idList.size() == 0)
//	            return;
	        //打印
//	        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,new MetaDataPK("com.kingdee.eas.farm.food.stocount.app.SemiProductCountQuery"));
//	        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
//	        appHlp.print("/bim/farm/food/stocount/SemiProductCount",data, javax.swing.SwingUtilities.getWindowAncestor(this));
			
			/*20170609  E*/
			MsgBox.showWarning("保存完成！");
			
			this.onShow();
			
		}else{
			if(countset.equals("1")){	
			
			//成品计数
			SzProdCountInfo pinfo = new SzProdCountInfo();
			//生成批次存入
			String batch1 = this.productDateF7.getText().toString();
			String batch2 = this.productDateF7.getText().toString();
			String batch3 = this.productDateF7.getText().toString();
			batch1 = batch1.substring(0, 4);
			batch2 = batch2.substring(5, 7);
			batch3 = batch3.substring(8, 10);
			StringBuffer batch = new StringBuffer();
			batch.append(batch1);
			batch.append(batch2);
			batch.append(batch3);
			
			matet = (MaterialInfo)this.material.getData();
			//定义分录
			SzProdCountEntryCollection pinfoec= pinfo.getEntrys();
			SzProdCountEntryInfo pinfoe = new SzProdCountEntryInfo();
			pinfoe.setMaterial((MaterialInfo)this.material.getData());
			pinfoe.setMnumber(w);
			pinfoe.setMbaseunit(this.materialunitf7.getText());
			pinfoe.setMaterialtype(this.materialunittypef7.getText());
			pinfoe.setProductDate((Date)this.productDateF7.getValue());
		
			pinfoe.setBatch(batch.toString());
			pinfoe.setMaterialnumber(materialnumber);
			
			System.out.println(this.material.getText()+"-----------------");
			pinfoe.setTypenumber(new BigDecimal(TypeNumber()));
			pinfoe.setInventoryUnit((MeasureUnitInfo) this.inventoryUnitF7.getData());
			BigDecimal weight = new BigDecimal("0");
			weight = w.multiply(n);
			pinfoe.setWeight((BigDecimal)weight);
			
			pinfoe.setCostobject(cost.getRemoteInstance().getCostObjectInfo("where StdProductID = '"+matet.getId()+"'"));
			pinfoe.setCostobjectnumber(materialnumber);
			pinfoec.add(pinfoe);
			
			pinfo.setNumber(createSeNumber());
			pinfo.setBizDate(new Date());
			pinfo.setClasses((Classes)this.classes.getSelectedItem());
			pinfo.setStatus(BillBaseStatusEnum.AUDITED);
			
			String userid=((UserInfo)this.countpersonf7.getValue()).getId().toString();
			StringBuffer sql=new StringBuffer();
			sql.append("select FPersonId from T_PM_User where  fid ='").append(userid).append("'");
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				pinfo.setPerson(PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("FPersonId"))));
			}
			//!!!!
			//pinfo.setSemcount((SzCountPositionSetInfo)this.countpointf7.getData());
			ISzProdCount isc = SzProdCountFactory.getRemoteInstance();
			IObjectPK pk=null;
			
			
				pk=isc.save(pinfo);
				StringBuffer upsql=new StringBuffer();
				StringBuffer upsql1=new StringBuffer();
				upsql.append("update CT_FM_ProdCount set CFStatus = 4 where fid = '"+pk+"'");
				
				//commFacadeFactory.getRemoteInstance().excuteUpdateSql(upsql.toString());
				
			}
//			IObjectPK pk = isc.addnew(pinfo);
			
//				ArrayList idList = new ArrayList();
//				if(UIRuleUtil.isNotNull(pk)){
//					pinfo=isc.getProductCountInfo(pk);
//				}
//		    	if (pinfo != null && !StringUtils.isEmpty(pinfo.getString("id"))) {
//		    		idList.add(pinfo.getString("id"));
//		    	}
//		        if (idList == null || idList.size() == 0)
//		            return;
//		        //打印
//		        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,new MetaDataPK("com.kingdee.eas.farm.food.stocount.app.ProductCountQuery"));
//		        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
//		        appHlp.print("/bim/farm/food/stocount/ProductCount",data, javax.swing.SwingUtilities.getWindowAncestor(this));
			
			MsgBox.showWarning("保存完成！");
			
			this.onShow();
			
		}
    	  
    	
    }

    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 物料选择功能
	 */
	protected void selectmaterial_actionPerformed(java.awt.event.ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
			int row = this.kDTable1.getSelectManager().getActiveRowIndex();
			materid = List.get(row).toString();
			IObjectPK pk = new ObjectStringPK(materid);
			maf.getRemoteInstance().getMaterialInfo(pk);
			this.material.setValue(maf.getRemoteInstance().getMaterialInfo(pk));
		super.selectmaterial_actionPerformed(e);
	}


	/**
	 * 半成品编码
	 * 创建一个编码,格式为"yyyyMM"+"Seq"
	 * @return 单据编号
	 */
	private String createSeNumber() {
		// TODO Auto-generated method stub
		String str="";
		try {
			int num=1;
			SemiProductCountCollection coll;
			ProdCountCollection pcoll;
			PcakCountCollection pll;
			do{
				str=MathUtilsComm.getStringByNumber(4, num);
				str = (new SimpleDateFormat("yyyyMMdd")).format(new Date())+str;
				if(countset.equals("0")){
					str = "BCPJS"+str;
					coll = SemiProductCountFactory.getRemoteInstance().getSemiProductCountCollection("where number='"+str+"'");
					if(coll.size()==0)
						return str;
					else
						++num;
				}else{
					if(countset.equals("1")){
						str = "CPJS"+str;
						pcoll = ProdCountFactory.getRemoteInstance().getProdCountCollection("where number='"+str+"'");
						
						if(pcoll.size()==0)
							return str;
						else
							++num;
					}else{
						str = "BZJS"+str;
						pll = PcakCountFactory.getRemoteInstance().getPcakCountCollection("where number='"+str+"'");
						if(pll.size()==0)
							return str;
						else
							++num;
					}
				}
				
			}while(1==1);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return str;
	} 
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		
		super.onShow();
		//调用初始化分录
		initTable();
		this.material.requestFocus();
		
	}

	/**
	 * 规格单位
	 * 从规格中取得数字
	 * @return 数字
	 */
	private String TypeNumber() {
		//测试
		String str = "";
		String str2="";
		if(this.inventoryUnitF7.getText()!= null){
			
			str = this.inventoryUnitF7.getText();
			str=str.trim();
		
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)==46){
					str2+=str.charAt(i);
				}else{
					if(str.charAt(i)>=48 && str.charAt(i)<=57 ){
						str2+=str.charAt(i);
					}
				}
			}
			System.out.println(str2);
			return str2;
			}else{
				str2 = "1";
				return str2;
		}
	
	}
    
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		
		initUI();
		initUIComp();
		addListener();//添加监听
		super.onLoad();
		this.setPreferredSize(new Dimension(1200,629));
		this.kDTable1.checkParsed();
		//物料F7过滤
		String materialid="'";//过滤字符串
		IRow NOWrOW=this.kDTable1.addRow();
		NOWrOW.getCell("column1").setValue("123");
		
		
	
	}
	
	/**
	 * 物料监听获取默认数量
	 */
	private  void addListener(){
		material.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				try {
					getDefaultNum(e);
				} catch (BOSException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (EASBizException e3) {
					e3.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	private void initselectTable(StringBuffer sql) throws BOSException {
		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		this.kDTable1.removeRows();
		
		List = new ArrayList();
		kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		int i = 0;
		IRow row;
		try {
			while (rs.next()) {
				row = this.kDTable1.addRow();
				row.getCell("column1").setValue(rs.getString("mname"));
				row.getCell("column2").setValue(rs.getString("mnumber"));
				row.getCell("column3").setValue(rs.getString("mtype"));
				row.getCell("column4").setValue(rs.getString("bizdaste"));
				//row.getCell("column5").setValue(rs.getString("mtype"
				//row.getCell("column6").setValue(rs.getString("bizdaste"));	
				//row.getCell("column7").setValue(rs.getString("mid"));	
				//row.getCell("column7").setValue("0");
				//fid[i] = rs.getString("fid");
				//materid = rs.getString("id").toString();
				List.add(i, rs.getString("id").toString());
				//System.out.println(rs.getString("fid")+i);
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	


	//初始化分录
	private void initTable() throws BOSException {
		// TODO Auto-generated method stub
		
		IRowSet rs=getExeQueryRowSet();
		
		this.kDTable1.removeRows();
		List = new ArrayList();
		kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		IRow row;
		
	
		int i = 0;
		try {
			while (rs.next()) {
				row = this.kDTable1.addRow();
				row.getCell("column1").setValue(rs.getString("mname"));
				row.getCell("column2").setValue(rs.getString("mnumber"));
				row.getCell("column3").setValue(rs.getString("mtype"));
				row.getCell("column4").setValue(rs.getString("bizdaste"));
				//row.getCell("column5").setValue(rs.getString("mtype"));
				//row.getCell("column6").setValue(rs.getString("bizdaste"));	
				//row.getCell("column7").setValue(rs.getString("mid"));	
				//row.getCell("column7").setValue("0");
				//fid[i] = rs.getString("fid");
				List.add(i, rs.getString("id").toString());
				
				//System.out.println(rs.getString("fid")+i);
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @return 结果集
	 * @throws BOSException
	 */
	private IRowSet getExeQueryRowSet() throws BOSException {
		StringBuffer sql = new StringBuffer();
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sqlp = new StringBuffer();
		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("t2.FLastUpdateTime bizdaste").append(sp);
		sql.append("from CT_SZC_SzCPSME t1").append(sp);
		sql.append("inner join CT_SZC_SzCountPositionSet t2").append(sp);
		sql.append("on t1.fparentid = t2.fid").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE t3").append(sp);
		sql.append("on t3.fparentid = t2.fid").append(sp);
		sql.append("inner join T_BD_Material t4").append(sp);
		sql.append("on t1.CFMaterialID = t4.fid").append(sp);
		sql.append("left join T_BD_Person t5").append(sp);
		sql.append("on t3.CFPersonID = t5.fid").append(sp);
		sql.append("inner join T_BD_MeasureUnit t6").append(sp);
		sql.append("on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		
		
		//成品计数sql
		sql1.append("select").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sql1.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql1.append("CONTSET.fname_l2                    countname,").append(sp);
		sql1.append("CREATOR.fnumber                     person,").append(sp);
		sql1.append("ENTRYS.cfmnumber                    mnumber,").append(sp);
		sql1.append("ENTRYS.cfmaterialtype               mtype,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.CFStatus           status,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql1.append("FROM CT_FM_ProdCount AS SEMIPRODUCTCOUNT").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS AUDITOR").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FAuditorID = AUDITOR.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS LASTUPDATEUSER").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FLastUpdateUserID = LASTUPDATEUSER.FID").append(sp);
		sql1.append("LEFT OUTER JOIN CT_FM_ProductCountEntry AS ENTRYS").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sql1.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS CONTSET").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFSemcountID = CONTSET.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_BD_Person AS CONTPERSON").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFPersonID = CONTPERSON.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sql1.append("ON ENTRYS.CFMaterialID = MATERIAL.FID").append(sp);
		sql1.append("where SEMIPRODUCTCOUNT.CFStatus = 4").append(sp);
		sql1.append("and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql1.append("order by bizdaste desc").append(sp);
		
	
		
		//包装计数sql
		sqlp.append("select").append(sp);
		sqlp.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sqlp.append("MATERIAL.fname_l2                   mname,").append(sp);
		sqlp.append("CONTSET.fname_l2                    countname,").append(sp);
		sqlp.append("CREATOR.fnumber                     person,").append(sp);
		sqlp.append("ENTRYS.cfmnumber                    mnumber,").append(sp);
		sqlp.append("ENTRYS.cfmaterialtype               mtype,").append(sp);
		sqlp.append("SEMIPRODUCTCOUNT.CFStatus           status,").append(sp);
		sqlp.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sqlp.append("FROM CT_FM_PcakCount AS SEMIPRODUCTCOUNT").append(sp);
		sqlp.append("LEFT OUTER JOIN T_PM_User AS AUDITOR").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FAuditorID = AUDITOR.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_PM_User AS LASTUPDATEUSER").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FLastUpdateUserID = LASTUPDATEUSER.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN CT_FM_PcakCountEntry AS ENTRYS").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS CONTSET").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.CFSemcountID = CONTSET.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_BD_Person AS CONTPERSON").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.CFPersonID = CONTPERSON.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sqlp.append("ON ENTRYS.CFMaterialID = MATERIAL.FID").append(sp);
		sqlp.append("where SEMIPRODUCTCOUNT.CFStatus = 4").append(sp);
		sqlp.append("and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sqlp.append("order by bizdaste desc").append(sp);
		
		
		
		if((countset).equals("0")){
			System.out.println(sql.toString());
			IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			return rs;
		}else{
			if((countset).equals("1")){
				System.out.println(sql.toString());
				IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				return rs;
			}else{
				System.out.println(sql.toString());
				IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				return rs;
			}
			
		}
	}
	
	//界面初始化
	//默认带出当前用户的信息和对应岗位信息
	private void initUI() {
		// TODO Auto-generated method stub
		
		
		this.kDTable1.getStyleAttributes().setLocked(true);
		//user和administrator没有员工内码所以不能进行岗位判断
		if(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("user")||com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("administrator")){
			MsgBox.showWarning("非企业内用户禁止编辑！");
			SysUtil.abort();
		}
		String userid = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString();
		this.countpersonf7.setValue(SysContext.getSysContext().getCurrentUserInfo() );
		//com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getId()
		
		
		SzCountPositionSetOperatorEntryCollection cpso;
		SzCountPositionSetCollection cp;
		SzCountPositionSetInfo cpinfo;
		SzCountPositionSetOperatorEntryInfo  cpsoeinfo;
		try {
			//判断当前用户是否在计数岗位中
			cpso = SzCountPositionSetOperatorEntryFactory.getRemoteInstance().getSzCountPositionSetOperatorEntryCollection("where Person = '"+userid+"'");
			
			if(cpso.size()==0){
				MsgBox.showWarning("当前用户没有计数岗位权限，无法进入计数界面！");
				SysUtil.abort();
			}
			cpsoeinfo = SzCountPositionSetOperatorEntryFactory.getRemoteInstance().getSzCountPositionSetOperatorEntryInfo("where Person = '"+userid+"'");
			cpinfo = SzCountPositionSetFactory.getRemoteInstance().getSzCountPositionSetInfo("where id = '"+cpsoeinfo.getParent().getId()+"'");
			if(cpinfo.getCountset() != null){
				countset = cpinfo.getCountset().getValue().toString();
			}
			System.out.println("标记！"+cpinfo.getName());
			this.countpointf7.setValue(cpinfo);
			this.material.setValue(null);
			this.materialunitf7.setValue(null);
			this.weight.setText(null);
			this.materialunittypef7.setValue(null);
			this.productDateF7.setValue(new Date());
			this.actionQY.setEnabled(true);	
			this.actionHY.setEnabled(true);	
			this.actionXlselect.setEnabled(true);
			this.actionTlselect.setEnabled(true);
			this.actionClselect.setEnabled(true);
			this.actionJjselect.setEnabled(true);
			this.actionQtselect.setEnabled(true);
			if(countset.equals("2")){
				this.kDWorkButton2.setText("打印");
			}
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 获取默认数量，设置库存计量单位
	 * @param e
	 * @throws BOSException
	 * @throws SQLException
	 * @throws EASBizException 
	 */
	private  void getDefaultNum(DataChangeEvent e) throws BOSException, SQLException, EASBizException{
		String materialid="";
		if(((MaterialInfo)e.getNewValue()) != null){
		    materialid=((MaterialInfo)e.getNewValue()).getId().toString();
		    //batch1 = batch1.substring(0, 4);
		    //物料number截取
		    String newmaterialid = materialid.substring(0, 10);
		    //System.out.println("-----------"+newmaterialid);
			String personid=SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString();
			//根据当前操作者和物料名称获取物料默认数量
			StringBuffer sql=new  StringBuffer();
			sql.append("select s.cfdefaultqty from CT_FM_CountPositionSet o ");
			sql.append("inner join CT_FM_CountPSOE   t on t.fparentid=o.fid ");
			sql.append("inner join CT_FM_CountPSME   s on s.fparentid=o.fid ");
			sql.append("where o.CFBaseStatus='0' and   t.cfpersonid='").append(personid).append("' and ");
			sql.append(" s.cfmaterialid='").append(materialid).append("'");
			
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			System.out.println(sql.toString());
			if(rs.first()){
				if(rs.getBigDecimal("cfdefaultqty")==null){
					weight.setText(null);
				}else{
					weight.setText(rs.getBigDecimal("cfdefaultqty").toString());
				}
				
			}
//			if(rs.next()){
//				weight.setText(rs.getBigDecimal("cfdefaultqty").toString());
//			}else{
//				weight.setText(null);
//			}
			
		}
		//如果已经维护库存计量单位带出
		String storId=SysContext.getSysContext().getCurrentStorageUnit().getId().toString();
	    		EntityViewInfo ev=new EntityViewInfo();
	    		FilterInfo filterInfo=new FilterInfo();
	    		filterInfo.getFilterItems().add(new FilterItemInfo("orgunit.id",storId,CompareType.EQUALS));
	    		filterInfo.getFilterItems().add(new FilterItemInfo("material.id",materialid,CompareType.EQUALS));
	    		ev.setFilter(filterInfo);
	    		MaterialInventoryCollection collection=MaterialInventoryFactory.getRemoteInstance().getMaterialInventoryCollection(ev);
	    		if(collection.size()>0){
	    			MaterialInventoryInfo info=collection.get(0);
	    			if(info.getUnit()!= null){
	    				inventoryUnitF7.setValue(MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(info.getUnit().getId().toString())));
	    			}
	    		}
	    
		
		
	}
	
	/**
	 * F7初始化
	 */
	private void initUIComp() {
		// TODO Auto-generated method stub
		

		this.countpersonf7.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
		this.countpersonf7.setVisible(true);		
		this.countpersonf7.setEditable(true);		
		this.countpersonf7.setDisplayFormat("$name$");		
		this.countpersonf7.setEditFormat("$number$");		
		this.countpersonf7.setCommitFormat("$number$");		
		this.countpersonf7.setRequired(false);
		
		
		
		//库存计量单位
		this.inventoryUnitF7.setQueryInfo("com.kingdee.eas.basedata.assistant.app.MeasureUnitQuery");		
		this.inventoryUnitF7.setVisible(true);		
		this.inventoryUnitF7.setEditable(true);		
		this.inventoryUnitF7.setDisplayFormat("$name$");		
		this.inventoryUnitF7.setEditFormat("$number$");		
		this.inventoryUnitF7.setCommitFormat("$number$");		
		this.inventoryUnitF7.setRequired(false);
		
        // prmtsemcount		
        this.countpointf7.setQueryInfo("com.kingdee.eas.custom.szcount.app.SzCountPositionSetQuery");		
        this.countpointf7.setVisible(true);		
        this.countpointf7.setEditable(true);		
        this.countpointf7.setDisplayFormat("$name$");		
        this.countpointf7.setEditFormat("$number$");		
        this.countpointf7.setCommitFormat("$number$");		
        this.countpointf7.setRequired(false);
        
        	countpointf7.addSelectorListener(new SelectorListener() {
        		com.kingdee.eas.custom.szcount.client.SzCountPositionSetListUI prmtsemcount_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsemcount_F7ListUI == null) {
					try {
						prmtsemcount_F7ListUI = new com.kingdee.eas.custom.szcount.client.SzCountPositionSetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsemcount_F7ListUI));
					prmtsemcount_F7ListUI.setF7Use(true,ctx);
					countpointf7.setSelector(prmtsemcount_F7ListUI);
				}
			}
		});
//        	countpointf7.addCommitListener(new CommitListener(){
//				public void willCommit(CommitEvent paramCommitEvent) {
//					// TODO Auto-generated method stub
//					String mnumber = paramCommitEvent.getText();
//					System.out.println("--+++--"+mnumber);
//				}
//        		
//        	});
        	
        //班次	
        this.classes.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szClasses").toArray());	
        this.classes.setRequired(false);
        
        	
        // prmtmaterial		
        this.material.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.material.setVisible(true);		
        this.material.setEditable(true);		
        this.material.setDisplayFormat("$name$");		
        this.material.setEditFormat("$number$");		
        this.material.setCommitFormat("$number$");		
        this.material.setRequired(false);
        material.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				material_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});			
	}
	protected void material_Changed() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("prmtmaterial_Changed() Function is executed!");
		materialunitf7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"baseUnit.name")));
		materialunittypef7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"model")));
		materialnumber = com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"number")).toString();
		
		
		
		
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
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * 日期前一
     */
    public void actionQY_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.productDateF7.getValue() != null){
			Date date=(Date)this.productDateF7.getValue();
			Date QyDate=new Date();
			
			Calendar calendar = Calendar.getInstance(); //得到日历
			calendar.setTime(date);//把当前时间赋给日历
			calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
			QyDate = calendar.getTime();   //得到前一天的时间
			
			this.productDateF7.setValue(QyDate);
		}
		super.actionQY_actionPerformed(e);
    }

    /**
	 * 日期后一
	 */
    public void actionHY_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.productDateF7.getValue() != null){
			Date date=(Date)this.productDateF7.getValue();
			Date HyDate=new Date();
			
			Calendar calendar = Calendar.getInstance(); //得到日历
			calendar.setTime(date);//把当前时间赋给日历
			calendar.add(Calendar.DAY_OF_MONTH, +1);  //设置为后一天
			HyDate = calendar.getTime();   //得到后一天的时间
			
			this.productDateF7.setValue(HyDate);
		}
		super.actionHY_actionPerformed(e);
    }

    /**
     * output actionCheck_actionPerformed
     */
    public void actionCheck_actionPerformed(ActionEvent e) throws Exception{
    	IRowSet rs=getQuery();
    	
    	this.kDTable1.removeRows();
    	List = new ArrayList();
    	kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
    	IRow row;
    	

    	int i = 0;
    	try {
    		while (rs.next()) {
    			row = this.kDTable1.addRow();
    			row.getCell("column1").setValue(rs.getString("mname"));
    			row.getCell("column2").setValue(rs.getString("countname"));
    			row.getCell("column3").setValue(rs.getString("person"));
    			row.getCell("column4").setValue(rs.getString("mnumber"));
    			row.getCell("column5").setValue(rs.getString("mtype"));
    			row.getCell("column6").setValue(rs.getString("bizdaste"));	
    			List.add(rs.getString("fid").toString());
    			i++;
    		}
    		rs.close();
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
    	super.actionCheck_actionPerformed(e);
    }
    

	/**
	 * 查询结果集
	 * @return
	 * @throws BOSException 
	 */
	private IRowSet getQuery() throws BOSException{
		StringBuffer sql = new StringBuffer();
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sqlp = new StringBuffer();
		String sp = "\n";
		
		Date beginDate=(Date)this.kDDatePicker2.getValue();
		Date endDate=(Date)this.kDDatePicker3.getValue();
		String SDate=new SimpleDateFormat("yyyy-MM-dd").format(beginDate);
		String EDate=new SimpleDateFormat("yyyy-MM-dd").format(endDate);
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sql.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql.append("SEMCOUNT.fname_l2                   countname,").append(sp);
		sql.append("CREATOR.fnumber                     person,").append(sp);
		sql.append("SEMIPRODUCTCOUNT.cfmnumber          mnumber,").append(sp);
		sql.append("SEMIPRODUCTCOUNT.cfmaterialtype     mtype,").append(sp);
		sql.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql.append("FROM CT_FM_SemiProductCount AS SEMIPRODUCTCOUNT").append(sp);
		sql.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sql.append("LEFT OUTER JOIN CT_FM_SemiProductCountEntry AS ENTRYS").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sql.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sql.append("LEFT OUTER JOIN T_BD_Person AS PERSON").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.CFPersonID = PERSON.FID").append(sp);
		sql.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS SEMCOUNT").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.CFSemcountID = SEMCOUNT.FID").append(sp);
		sql.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.CFMaterialID = MATERIAL.FID").append(sp);
		sql.append("where SEMIPRODUCTCOUNT.CFStatus is null ").append(sp);
		sql.append("or SEMIPRODUCTCOUNT.CFStatus = 4 and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append(" and to_char(SEMIPRODUCTCOUNT.fbizdate,'yyyy-MM-dd')>='").append(SDate).append("' and to_char(SEMIPRODUCTCOUNT.fbizdate,'yyyy-MM-dd')<='").append(EDate).append("'").append(sp);
		
		
		//成品计数sql
		sql1.append("select").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sql1.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql1.append("CONTSET.fname_l2                    countname,").append(sp);
		sql1.append("CREATOR.fnumber                     person,").append(sp);
		sql1.append("ENTRYS.cfmnumber                    mnumber,").append(sp);
		sql1.append("ENTRYS.cfmaterialtype               mtype,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.CFStatus           status,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql1.append("FROM CT_FM_ProdCount AS SEMIPRODUCTCOUNT").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS AUDITOR").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FAuditorID = AUDITOR.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS LASTUPDATEUSER").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FLastUpdateUserID = LASTUPDATEUSER.FID").append(sp);
		sql1.append("LEFT OUTER JOIN CT_FM_ProductCountEntry AS ENTRYS").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sql1.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS CONTSET").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFContsetID = CONTSET.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_BD_Person AS CONTPERSON").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFContpersonID = CONTPERSON.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sql1.append("ON ENTRYS.CFMaterialID = MATERIAL.FID").append(sp);
		sql1.append("where SEMIPRODUCTCOUNT.CFStatus is null").append(sp);
		sql1.append("or SEMIPRODUCTCOUNT.CFStatus = 4  and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql1.append(" and to_char(SEMIPRODUCTCOUNT.fbizdate),'yyyy-MM-dd')>='").append(SDate).append("' and to_char(SEMIPRODUCTCOUNT.fbizdate,'yyyy-MM-dd')<='").append(EDate).append("'").append(sp);
		
		//包装计数
		sqlp.append("select").append(sp);
		sqlp.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sqlp.append("MATERIAL.fname_l2                   mname,").append(sp);
		sqlp.append("SEMCOUNT.fname_l2                   countname,").append(sp);
		sqlp.append("CREATOR.fnumber                     person,").append(sp);
		sqlp.append("ENTRYS.cfmnumber                    mnumber,").append(sp);
		sqlp.append("ENTRYS.cfmaterialtype               mtype,").append(sp);
		sqlp.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sqlp.append("FROM CT_FM_PcakCount AS SEMIPRODUCTCOUNT").append(sp);
		sqlp.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN CT_FM_PcakCountEntry AS ENTRYS").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_BD_Person AS PERSON").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.CFPersonID = PERSON.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS SEMCOUNT").append(sp);
		sqlp.append("ON SEMIPRODUCTCOUNT.CFSemcountID = SEMCOUNT.FID").append(sp);
		sqlp.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sqlp.append("ON ENTRYS.CFMaterialID = MATERIAL.FID").append(sp);
		sqlp.append("where SEMIPRODUCTCOUNT.CFStatus is null ").append(sp);
		sqlp.append("or SEMIPRODUCTCOUNT.CFStatus = 4 and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sqlp.append(" and to_char(SEMIPRODUCTCOUNT.fbizdate,'yyyy-MM-dd')>='").append(SDate).append("' and to_char(SEMIPRODUCTCOUNT.fbizdate,'yyyy-MM-dd')<='").append(EDate).append("'").append(sp);
		

		//System.out.println(sql.toString());
		if(countset.equals("0")){
			IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			return rs;
		}else{
			if(countset.equals("1")){
				IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql1.toString()).executeSQL();
				return rs;
			}else{
				IRowSet rs =SQLExecutorFactory.getRemoteInstance(sqlp.toString()).executeSQL();
				return rs;
			}
		}
	}

}