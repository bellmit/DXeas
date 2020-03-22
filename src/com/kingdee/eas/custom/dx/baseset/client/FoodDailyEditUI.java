/**
 * output package name
 */
package com.kingdee.eas.custom.dx.baseset.client;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDWorkButton;

/**
 * output class name
 */
public class FoodDailyEditUI extends AbstractFoodDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FoodDailyEditUI.class);
    BigDecimal ProductWet = BigDecimal.ZERO;
    /**
     * output class constructor
     */
    public FoodDailyEditUI() throws Exception
    {
        super();
        setUITitle("食品厂经营日报");
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        addTableQuerySearchPanel(kdtEntry);
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

  /* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//this.kdtEntry.getColumn("qty").getDataStyle().getEditor().getFocusComponent().StyleAttributes().		
	}
	//分录新增按钮
	private void addTableQuerySearchPanel(final KDTable table) {
		KDWorkButton jb=new KDWorkButton("获取数据");
		jb.setBounds(152,0,100, 27);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getMaterial();
				
			}

			});

		JPanel controlPanel = (JPanel) table.getParent().getParent();
		if(controlPanel instanceof DetailPanel ){
			for(int index=0;index<controlPanel.getComponentCount();index++) {
				if(controlPanel.getComponent(index).getName().equalsIgnoreCase("controlPanel")) {
					JPanel  d = (JPanel )controlPanel.getComponent(index);
					Rectangle rect = table.getBounds();
					int x = rect.width - (jb.getWidth() + 86 + 30);
					d.add(jb,new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x-215, 5, jb.getWidth(), 19, 9));
					break;
				}
			}
		}
		
	}
	//加载单据是获取单日毛鸡结算金额
	private void getRealWeight() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
    	String sp = "\n";
    	sql.append("/*dialect*/").append(sp);
    	sql.append("select  ").append(sp);
    	sql.append("sum(t1.CFSettleAmount) realWeight").append(sp);
    	sql.append(" from CT_DX_SettleBill t1").append(sp);
    	//sql.append("inner join CT_DX_SettleRe t2 on t2.CFCarSendID=t1.CFCarSendID ").append(sp);
    	sql.append("where to_char(t1.FBizdate,'yyyy-MM-dd') = '"+this.pkBizDate.getSqlDate()+"'").append(sp);	
    	sql.append("and t1.CFBillStatus = 2").append(sp);
    	try {
			IRowSet  rs = CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
			BigDecimal GrossWeight = BigDecimal.ZERO;
			while(rs.next()){
				if(rs.getString("realWeight")!=null){
					GrossWeight = new BigDecimal(rs.getString("realWeight"));
				}
				
			}
			this.txtGrossWeight.setValue(GrossWeight);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
	private void getMaterial() {
		// TODO Auto-generated method stub
		getRealWeight();
		final BigDecimal GrossWeight = this.txtGrossWeight.getBigDecimalValue();
		  
		LongTimeDialog dialog = new LongTimeDialog( (Frame) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
			public Object exec() throws Exception { 
				Object result = "12345"; 
				
				
		try {
			String sql = getMaterialSql();
			IRowSet rs;
			IRow row = null;
			IMaterial iMaterial = MaterialFactory.getRemoteInstance();
			CoreBaseCollection coll = null;
			rs = CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql);
			if(rs.size() > 0){
				kdtEntry.removeRows();
			}
			BigDecimal basqty =  BigDecimal.ZERO;
			BigDecimal amount =  BigDecimal.ZERO;
			ProductWet = BigDecimal.ZERO;
			while(rs.next()){
				
				row = kdtEntry.addRow();
				coll = iMaterial.getCollection("where number='"+rs.getString("MNumber")+"'");
				if(coll.size() > 0){
					row.getCell("materialNum").setValue((MaterialInfo)coll.get(0));
					row.getCell("materialName").setValue(((MaterialInfo)coll.get(0)).getString("name"));
					row.getCell("model").setValue(((MaterialInfo)coll.get(0)).getString("model"));
				}
				row.getCell("materialGroup").setValue(rs.getString("dx"));
				basqty = new BigDecimal(rs.getString("FQty"));
				ProductWet = ProductWet.add(basqty);
				//数量
				row.getCell("qty").setValue(basqty);
				amount = new BigDecimal(rs.getString("FPrice"));
				//单价
				row.getCell("price").setValue(amount);
				//新的单价逻辑
				String fprice = getMaterialPrice((MaterialInfo)coll.get(0));
				if(fprice!=null){
					row.getCell("price").setValue(new BigDecimal(fprice));
					//产值
					row.getCell("amount").setValue(basqty.multiply(new BigDecimal(fprice)).setScale(2, BigDecimal.ROUND_HALF_UP));
				}else{
					row.getCell("price").setValue(amount);
					//产值
					row.getCell("amount").setValue(amount.multiply(basqty).setScale(2, BigDecimal.ROUND_HALF_UP));
				}

				basqty = basqty.divide(GrossWeight, 4, BigDecimal.ROUND_HALF_UP);
				basqty = basqty.multiply(new BigDecimal("100"));
				row.getCell("ccRate").setValue(basqty);
			}
			
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
			} 
			
			public void afterExec(Object result) throws Exception {
				MsgBox.showInfo("引入完成");
				
			} 
		}); 
		
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("数据引入中..."); 
			} 
		}
		
		dialog.show(); 
		this.txtslaughterAmt.setValue(ProductWet);
		
	}
	//根据物料获取单价
	private String getMaterialPrice(MaterialInfo materialInfo) {
		// TODO Auto-generated method stub
		String mid = materialInfo.getId().toString();
		StringBuffer Sql = new StringBuffer();
		String price = null;
		String sp = "\n";
		Sql.append("/*dialect*/").append(sp);
		Sql.append("select ").append(sp);
		Sql.append("t2.FName_l2	MName,").append(sp);
		Sql.append("t2.FNumber	Mnumber, ").append(sp);
		Sql.append("sum(t3.FRecievePayAmount)/sum(t3.FQuantity)	FPrice ").append(sp);
		Sql.append("from ").append(sp);
		Sql.append("T_AR_OtherBill 		t1 ").append(sp);
		Sql.append("inner join T_AR_OtherBillentry t3 on t3.FParentID = t1.FID ").append(sp);
		Sql.append("inner join T_BD_Material  		t2	on t2.FID = t3.FMaterialID ").append(sp);
		Sql.append("where ").append(sp);
		Sql.append(" t1.FSaleOrgID = 'fwetFukdS+ijv1dvsPdMncznrtQ=' ").append(sp);
		Sql.append("--and t1.FBaseStatus > 4 ").append(sp);
//		Sql.append("and t1.FPeriod >= to_char(to_date('"+this.pkBizDate.getSqlDate()+"','yyyy-MM-dd'),'MM') ").append(sp);
//		Sql.append("and t1.FYear = to_char(to_date('"+this.pkBizDate.getSqlDate()+"','yyyy-MM-dd'),'yyyy') ").append(sp);
		
		Sql.append("and to_char(t1.FBizdate,'yyyy-MM-dd') >= to_char(to_date('"+this.pkBizDate.getSqlDate()+"','yyyy-MM-dd')-1,'yyyy-MM-dd') ").append(sp);
		Sql.append("and to_char(t1.FBizdate,'yyyy-MM-dd') <= '"+this.pkBizDate.getSqlDate()+"' ").append(sp);
		
		Sql.append("and t2.FID = '"+mid+"' ").append(sp);
		Sql.append("group by t2.FName_l2,t2.FNumber ").append(sp);
		Sql.append("order by t2.FNumber ").append(sp);
		IRowSet rs;
		try {
			rs = CommSqlFacadeFactory.getRemoteInstance().executeQuery(Sql.toString());
			while(rs.next()){
				price = rs.getString("FPrice");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
		
		
	}
	
    private String getMaterialSql() {
		// TODO Auto-generated method stub
    	StringBuffer sql = new StringBuffer();
    	String sp = "\n";
    	sql.append("/*dialect*/").append(sp);
    	sql.append("select  ").append(sp);
    	sql.append("to_char(t1.FBizdate,'yyyy-MM-dd') FBizdate, ").append(sp);
    	sql.append("t3.FName_l2 MName, ").append(sp);
    	sql.append("t3.FNUMBER MNumber, ").append(sp);
    	sql.append("t3.FModel FModel, ").append(sp);	
    	//sql.append("nvl((case when t9.FPrice !=null then t9.FPrice else t10.FPrice end ),0)  FPrice,").append(sp);
    	sql.append(" nvl(t10.FPrice,0) FPrice,").append(sp);
    	sql.append("(case when t7.FLevel=4 then t7.FName_l2 else t8.FName_l2 end  )  dx,").append(sp);
    	sql.append("(case when t6.FLevel=5 then t6.FName_l2 else t7.FName_l2 end  )  xl,").append(sp);
    	sql.append("(case when t6.FLevel=5 then t6.FNumber else t7.FNumber end  )  xlnumber,").append(sp);
    	sql.append("sum(t2.FQty) FQty,").append(sp);
    	sql.append("sum(t2.FAssistQty) asQty ").append(sp);
    	sql.append("from T_IM_ManufactureRecBill t1").append(sp);
    	sql.append("inner join T_IM_ManufactureRecBillEntry t2 on t2.FParentID = t1.FID ").append(sp);
    	sql.append("inner join T_BD_Material t3 on t3.FID = t2.FMaterialID").append(sp);
    	sql.append("inner join T_BD_MaterialGroup t6 on t6.FID = t3.FMaterialGroupID").append(sp);
    	sql.append("left join T_BD_MaterialGroup t7 on t7.FID = t6.FParentID").append(sp);
    	sql.append("left join T_BD_MaterialGroup t8 on t8.FID = t7.FParentID").append(sp);   	
    	//sql.append("left join T_STO_SalesPriceEntry  t9 on t9.FMaterialID  = t3.FID").append(sp);
    	sql.append("left join T_SD_MaterialBasePrice t10 on t10.FMaterialID = t3.FID").append(sp); 	
    	sql.append("where").append(sp);
    	sql.append("to_char(t1.FBizdate,'yyyy-MM-dd') = '"+this.pkBizDate.getSqlDate()+"'").append(sp);
    	sql.append("and t1.FBaseStatus = 4").append(sp);
    	sql.append("group by t1.FBizdate,t3.FName_l2,t3.FNUMBER,t3.FModel,t6.FName_l2,t6.FName_l2,t7.FName_l2,t6.FLevel,t7.FLevel,t8.FName_l2,t8.FLevel,t7.FNumber,t6.FNumber,t10.FPrice").append(sp);
    	sql.append("order  by FQty desc").append(sp);
		return sql.toString();
	}
	/**
     * output actionAudit_actionPerformed
    */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }

    /**
     * output actionGetData_actionPerformed
     */
    public void actionGetData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionGetData_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.baseset.FoodDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.baseset.FoodDailyInfo objectValue = new com.kingdee.eas.custom.dx.baseset.FoodDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}