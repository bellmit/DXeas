/**
 * output package name
 */
package com.kingdee.eas.farm.food.stocount.client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.swing.StringUtils;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.food.stocount.Classes;
import com.kingdee.eas.farm.food.stocount.CountPositionSetCollection;
import com.kingdee.eas.farm.food.stocount.CountPositionSetFactory;
import com.kingdee.eas.farm.food.stocount.CountPositionSetInfo;
import com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryCollection;
import com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryFactory;
import com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryInfo;
import com.kingdee.eas.farm.food.stocount.IPcakCount;
import com.kingdee.eas.farm.food.stocount.IProdCount;
import com.kingdee.eas.farm.food.stocount.PcakCountCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountEntryCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountEntryInfo;
import com.kingdee.eas.farm.food.stocount.PcakCountFactory;
import com.kingdee.eas.farm.food.stocount.PcakCountInfo;
import com.kingdee.eas.farm.food.stocount.ProdCountCollection;
import com.kingdee.eas.farm.food.stocount.ProdCountEntryCollection;
import com.kingdee.eas.farm.food.stocount.ProdCountEntryInfo;
import com.kingdee.eas.farm.food.stocount.ProdCountFactory;
import com.kingdee.eas.farm.food.stocount.ProdCountInfo;
import com.kingdee.eas.farm.food.stocount.SemiProductCountCollection;
import com.kingdee.eas.farm.food.stocount.SemiProductCountFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */

public class SemiCountOperateUI extends AbstractSemiCountOperateUI
{
	
	private static final Logger logger = CoreUIObject.getLogger(SemiCountOperateUI.class);
    
    /**
     * output class constructor
     */
	ArrayList List;
	String materialnumber = "";
	String countset = null;
    public SemiCountOperateUI() throws Exception
    {
        super();
        

    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
        this.material.requestFocus();
        
    }

    
    
    @Override
	public void loadFields() {
		// TODO Auto-generated method stub
		super.loadFields();
		this.material.requestFocus();
	}

	/**
	 *<p>Custom: ����Ͽ</p>
	 *<p>Company: �ൺδ������</p>
	 * @author ������
	 * ���Ϲ���
	 */
    @Override
	protected void cancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
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
    			String sql  = "update CT_FM_ProductCount set CFStatus = 3 where fid = '"+sfid+"'";
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
        			MsgBox.showInfo("���������ε��ݣ���������");
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
	 *<p>Custom: ����Ͽ</p>
	 *<p>Company: �ൺδ������</p>
	 * @author ������
	 * ��հ�ť����
	 */
	@Override
	protected void clear_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.clear_actionPerformed(e);
		this.material.setValue(null);
		this.materialunitf7.setValue(null);
		this.weight.setText(null);
		this.warehouse.setText(null);

	}
	/**
	 *<p>Custom: ����Ͽ</p>
	 *<p>Company: �ൺδ������</p>
	 * @author ������
	 * ��ӡ+���湦��
	 */
	protected void print_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		this.loadFields();
	
		//�����ж�
		if(this.material.getData()==null){
			MsgBox.showInfo("���ϲ���Ϊ�գ�����");
			SysUtil.abort();
		}
		BigDecimal w = new BigDecimal(this.weight.getText());
		//��λ�ж�
		if(countset.equals("0")){
//		//��UI�и�ֵ����������İ��Ʒ������
//			SemiProductCountInfo spinfo = new SemiProductCountInfo();			
//			IObjectPK spk=null;
//			spinfo.setNumber(createSeNumber());
//			spinfo.setBizDate(new Date());
//			spinfo.setProductDate((Date)this.productDateF7.getValue());
//			
//			
//			//�������δ���
//			String batch1 = this.productDateF7.getText().toString();
//			String batch2 = this.productDateF7.getText().toString();
//			String batch3 = this.productDateF7.getText().toString();
//			batch1 = batch1.substring(0, 4);
//			batch2 = batch2.substring(5, 7);
//			batch3 = batch3.substring(8, 10);
//			StringBuffer batch = new StringBuffer();
//			batch.append(batch1);
//			batch.append(batch2);
//			batch.append(batch3);
//			spinfo.setBatch(batch.toString());
////			System.out.println("+++++"+batch1+"+++++"+batch2+"++++"+batch3);
//			spinfo.setClasses((Classes)this.classes.getSelectedItem());
//			String userid=((UserInfo)this.countpersonf7.getValue()).getId().toString();
//			
//			StringBuffer sql=new StringBuffer();
//			sql.append("select FPersonId from T_PM_User where  fid ='").append(userid).append("'");
//			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
//			if(rs.next()){
//				spinfo.setPerson(PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("FPersonId"))));
//			}
//			spinfo.setMaterial((MaterialInfo)this.material.getData());
//			spinfo.setSemcount((CountPositionSetInfo)this.countpointf7.getData());
//			spinfo.setMnumber(w);
//			spinfo.setMbaseunit(this.materialunitf7.getText());
//			spinfo.setMaterialtype(this.materialunittypef7.getText());
//			spinfo.setStatus(BillBaseStatusEnum.SUBMITED);
//			ISemiProductCount isc = SemiProductCountFactory.getRemoteInstance();
//			/*20170609 add B*/
//			
//			
//			if(isc.exists(new ObjectUuidPK(spinfo.getId()))){
//				spk=isc.save(spinfo);
//			}else{
//				spk=isc.save(spinfo);
//			}
//			
////			ArrayList idList = new ArrayList();
////			if(UIRuleUtil.isNotNull(spk)){
////				spinfo=isc.getSemiProductCountInfo(spk);
////			}
////	    	if (spinfo != null && !StringUtils.isEmpty(spinfo.getString("id"))) {
////	    		idList.add(spinfo.getString("id"));
////	    	}
////	        if (idList == null || idList.size() == 0)
////	            return;
//	        //��ӡ
////	        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,new MetaDataPK("com.kingdee.eas.farm.food.stocount.app.SemiProductCountQuery"));
////	        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
////	        appHlp.print("/bim/farm/food/stocount/SemiProductCount",data, javax.swing.SwingUtilities.getWindowAncestor(this));
//			
//			/*20170609  E*/
//			MsgBox.showWarning("������ɣ�");
//			this.onLoad();
//			this.onShow();
			
		}else{
			if(countset.equals("1")){	
			if(this.warehouse.getStringValue()==null){
				MsgBox.showInfo("��Ʒ�����ֿ�Ų���Ϊ�գ�����");
				SysUtil.abort();
			}else{
			//��Ʒ����
			ProdCountInfo pinfo = new ProdCountInfo();
			//�������δ���
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
			//�����¼
			ProdCountEntryCollection pinfoec= pinfo.getEntrys();
			ProdCountEntryInfo pinfoe = new ProdCountEntryInfo();
			pinfoe.setMaterial((MaterialInfo)this.material.getData());
			pinfoe.setMnumber(w);
			pinfoe.setMbaseunit(this.materialunitf7.getText());
			pinfoe.setMaterialtype(this.materialunittypef7.getText());
			pinfoe.setProductDate((Date)this.productDateF7.getValue());
			pinfoe.setWarehouse(this.warehouse.getText());
			pinfoe.setBatch(batch.toString());
			pinfoe.setMaterialnumber(materialnumber);
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
			pinfo.setSemcount((CountPositionSetInfo)this.countpointf7.getData());
			IProdCount isc = ProdCountFactory.getRemoteInstance();
			IObjectPK pk=null;
			if(isc.exists(new ObjectUuidPK(pinfo.getId()))){
				pk=isc.save(pinfo);
				StringBuffer upsql=new StringBuffer();
				upsql.append("update CT_FM_ProductCount set CFStatus = 4 where fid = '"+pk+"'");
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(upsql.toString());
			}else{
				pk=isc.save(pinfo);
				StringBuffer upsql=new StringBuffer();
				upsql.append("update CT_FM_ProductCount set CFStatus = 4 where fid = '"+pk+"'");
			
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(upsql.toString());
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
//		        //��ӡ
//		        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,new MetaDataPK("com.kingdee.eas.farm.food.stocount.app.ProductCountQuery"));
//		        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
//		        appHlp.print("/bim/farm/food/stocount/ProductCount",data, javax.swing.SwingUtilities.getWindowAncestor(this));
			
			MsgBox.showWarning("������ɣ�");
			this.onLoad();
			this.onShow();
			}
		}else{
			//��װ����
			PcakCountInfo pinfo = new PcakCountInfo();
			//�������δ���
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
			//�����¼
			PcakCountEntryCollection pinfoec = pinfo.getEntrys();
			PcakCountEntryInfo pinfoe = new PcakCountEntryInfo();//
			pinfoe.setMaterial((MaterialInfo)this.material.getData());
			pinfoe.setMnumber(w);
			pinfoe.setMbaseunit(this.materialunitf7.getText());
			pinfoe.setMaterialtype(this.materialunittypef7.getText());
			pinfoe.setProductDate((Date)this.productDateF7.getValue());
			pinfoe.setBatch(batch.toString());
			pinfoe.setMaterialnumber(materialnumber);
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
			pinfo.setSemcount((CountPositionSetInfo)this.countpointf7.getData());
			IPcakCount isc = PcakCountFactory.getRemoteInstance();
			IObjectPK pk=null;
			if(isc.exists(new ObjectUuidPK(pinfo.getId()))){
				pk=isc.save(pinfo); 
				StringBuffer upsql=new StringBuffer();
				upsql.append("update CT_FM_PcakCount set CFStatus = 4 where fid = '"+pk+"'");
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(upsql.toString());
			}else{
				pk=isc.save(pinfo);
				StringBuffer upsql=new StringBuffer();
				upsql.append("update CT_FM_PcakCount set CFStatus = 4 where fid = '"+pk+"'");
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(upsql.toString());
			}
//			IObjectPK pk1 = isc.addnew(pinfo);
			
				ArrayList idList = new ArrayList();
				if(UIRuleUtil.isNotNull(pk)){
					pinfo=isc.getPcakCountInfo(pk);
				}
		    	if (pinfo != null && !StringUtils.isEmpty(pinfo.getString("id"))) {
		    		idList.add(pinfo.getString("id"));
		    	}
		        if (idList == null || idList.size() == 0)
		            return;
		        //��ӡ
		        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,new MetaDataPK("com.kingdee.eas.farm.food.stocount.app.PcakCountQuery"));
		        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
		        appHlp.print("/bim/farm/food/stocount/PcakCount",data, javax.swing.SwingUtilities.getWindowAncestor(this));
			
			MsgBox.showWarning("������ɣ�");
			this.onLoad();
			this.onShow();
		}
		}
		
		
//		PurRequestEntryInfo s = new PurRequestEntryInfo();
//		s.setPrice(item)
		
		
		super.print_actionPerformed(e);
	}

	/**
	 * ���Ʒ����
	 * ����һ������,��ʽΪ"yyyyMM"+"Seq"
	 * @return ���ݱ��
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
		//���ó�ʼ����¼
		initTable();
		this.material.requestFocus();
		
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		
		initUI();
		initUIComp();
		addListener();//��Ӽ���
		super.onLoad();
		this.setPreferredSize(new Dimension(1200,629));
		
		//����F7����
		String materialid="'";//�����ַ���
		//���˵�ǰ�û���Ӧ�ļ�����Ʒ��¼
		StringBuffer sql=new StringBuffer();
		sql.append("select s.cfmaterialid,s.cfdefaultqty from CT_FM_CountPositionSet o ");
		sql.append("inner join CT_FM_CountPSOE   t on t.fparentid=o.fid ");
		sql.append("inner join CT_FM_CountPSME   s on s.fparentid=o.fid ");
		sql.append("where   t.cfpersonid='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString()).append("'");
	
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		
		
		while(rs.next()){
			//��������ַ���
//			HashMap<String, Object> map=new HashMap<String, Object>();
//			map.put("material", rs.getString("cfmaterialid"));
//			map.put("amount", rs.getBigDecimal("cfdefaultqty"));
//			list.add(map);
			materialid=materialid+rs.getString("cfmaterialid")+"','";
		}
		materialid=materialid.substring(0,materialid.length()-2);
		//����F7
		 EntityViewInfo ev = new EntityViewInfo();
    	 FilterInfo filterInfo = new FilterInfo();
    	 filterInfo.getFilterItems().add(new FilterItemInfo("id",materialid,CompareType.INNER));
    	 ev.setFilter(filterInfo);
    	 material.setEntityViewInfo(ev);
    	
    	 this.QyBtn.setEnabled(true);
    	 this.HyBtn.setEnabled(true);
	}
	
	/**
	 * ���ϼ�����ȡĬ������
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
	
	
	
	//��ʼ����¼
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
				row.getCell("column2").setValue(rs.getString("countname"));
				row.getCell("column3").setValue(rs.getString("person"));
				row.getCell("column4").setValue(rs.getString("mnumber"));
				row.getCell("column5").setValue(rs.getString("mtype"));
				row.getCell("column6").setValue(rs.getString("bizdaste"));	
				//row.getCell("column7").setValue("0");
				//fid[i] = rs.getString("fid");
				List.add(rs.getString("fid").toString());
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
	 * @return �����
	 * @throws BOSException
	 */
	private IRowSet getExeQueryRowSet() throws BOSException {
		StringBuffer sql = new StringBuffer();
		StringBuffer sql1 = new StringBuffer();
		StringBuffer sqlp = new StringBuffer();
		String sp = "\n";
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
		sql.append("where SEMIPRODUCTCOUNT.CFStatus = 4 ").append(sp);
		sql.append("and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("order by bizdaste desc").append(sp);
		
		
		//��Ʒ����sql
		sql1.append("select").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sql1.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql1.append("CONTSET.fname_l2                    countname,").append(sp);
		sql1.append("CREATOR.fnumber                     person,").append(sp);
		sql1.append("ENTRYS.cfmnumber                    mnumber,").append(sp);
		sql1.append("ENTRYS.cfmaterialtype               mtype,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.CFStatus           status,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql1.append("FROM CT_FM_ProductCount AS SEMIPRODUCTCOUNT").append(sp);
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
		sql1.append("where SEMIPRODUCTCOUNT.CFStatus = 4").append(sp);
		sql1.append("and CREATOR.fnumber='").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql1.append("order by bizdaste desc").append(sp);
		
	
		
		//��װ����sql
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
				System.out.println(sql1.toString());
				IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql1.toString()).executeSQL();
				return rs;
			}else{
				System.out.println(sqlp.toString());
				IRowSet rs =SQLExecutorFactory.getRemoteInstance(sqlp.toString()).executeSQL();
				return rs;
			}
			
		}
	}
	
//	/**
//	 * @return ���ϸ���
//	 * @throws BOSException
//	 */
//	private IRowSet getUPExeQueryRowSet() throws BOSException {
//		StringBuffer sql = new StringBuffer();
//		String sp = "\n";
//		//sql.append("/*dialect*/").append(sp);
//		
//		
//		//System.out.println(sql.toString());
//		//IRowSet rs = DbUtil.executeQuery(arg0, arg1)
//		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
//		return rs;
//	}


	//�����ʼ��
	//Ĭ�ϴ�����ǰ�û�����Ϣ�Ͷ�Ӧ��λ��Ϣ
	private void initUI() {
		// TODO Auto-generated method stub
		
		
		this.kDTable1.getStyleAttributes().setLocked(true);
		//user��administratorû��Ա���������Բ��ܽ��и�λ�ж�
		if(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("user")||com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("administrator")){
			MsgBox.showWarning("����ҵ���û���ֹ�༭��");
			SysUtil.abort();
		}
		String userid = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString();
		this.countpersonf7.setValue(SysContext.getSysContext().getCurrentUserInfo() );
		//com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getId()
		CountPositionSetOperatorEntryCollection cpso;
		CountPositionSetCollection cp;
		CountPositionSetInfo cpinfo;
		CountPositionSetOperatorEntryInfo  cpsoeinfo;
		try {
			//�жϵ�ǰ�û��Ƿ��ڼ�����λ��
			cpso = CountPositionSetOperatorEntryFactory.getRemoteInstance().getCountPositionSetOperatorEntryCollection("where Person = '"+userid+"'");
			
			if(cpso.size()==0){
				MsgBox.showWarning("��ǰ�û�û�м�����λȨ�ޣ��޷�����������棡");
				SysUtil.abort();
			}
			cpsoeinfo = CountPositionSetOperatorEntryFactory.getRemoteInstance().getCountPositionSetOperatorEntryInfo("where Person = '"+userid+"'");
			cpinfo = CountPositionSetFactory.getRemoteInstance().getCountPositionSetInfo("where id = '"+cpsoeinfo.getParent().getId()+"'");
			if(cpinfo.getCountset() != null){
				countset = cpinfo.getCountset().getValue().toString();
			}
			System.out.println("��ǣ�"+cpinfo.getName());
			this.countpointf7.setValue(cpinfo);
			this.material.setValue(null);
			this.materialunitf7.setValue(null);
			this.weight.setText(null);
			this.materialunittypef7.setValue(null);
			this.productDateF7.setValue(new Date());
			
			if(countset.equals("1")){
				this.warehouse.setEnabled(true);
				this.warehouse.setVisible(true);
				this.kDLabel3.setEnabled(true);
				this.kDLabel3.setVisible(true);
			}
			if(countset.equals("2")){
				this.kDWorkButton2.setText("��ӡ");
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
	 * ��ȡĬ�����������ÿ�������λ
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
		    //����number��ȡ
		    String newmaterialid = materialid.substring(0, 10);
		    //System.out.println("-----------"+newmaterialid);
			String personid=SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString();
			//���ݵ�ǰ�����ߺ��������ƻ�ȡ����Ĭ������
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
		//����Ѿ�ά����������λ����
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
	
	protected void material_Changed() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("prmtmaterial_Changed() Function is executed!");
		materialunitf7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"baseUnit.name")));
		materialunittypef7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"model")));
		materialnumber = com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"number")).toString();
	}

	/**
	 * F7��ʼ��
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
		
		
		//��������λ
		this.inventoryUnitF7.setQueryInfo("com.kingdee.eas.basedata.assistant.app.MeasureUnitQuery");		
		this.inventoryUnitF7.setVisible(true);		
		this.inventoryUnitF7.setEditable(true);		
		this.inventoryUnitF7.setDisplayFormat("$name$");		
		this.inventoryUnitF7.setEditFormat("$number$");		
		this.inventoryUnitF7.setCommitFormat("$number$");		
		this.inventoryUnitF7.setRequired(false);
		
		
		
        // prmtsemcount		
        this.countpointf7.setQueryInfo("com.kingdee.eas.farm.food.stocount.app.CountPositionSetQuery");		
        this.countpointf7.setVisible(true);		
        this.countpointf7.setEditable(true);		
        this.countpointf7.setDisplayFormat("$name$");		
        this.countpointf7.setEditFormat("$number$");		
        this.countpointf7.setCommitFormat("$number$");		
        this.countpointf7.setRequired(false);
        
        	countpointf7.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.food.stocount.client.CountPositionSetListUI prmtsemcount_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsemcount_F7ListUI == null) {
					try {
						prmtsemcount_F7ListUI = new com.kingdee.eas.farm.food.stocount.client.CountPositionSetListUI();
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
        	
        //���	
        this.classes.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.food.stocount.Classes").toArray());	
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

	/**
	 * ���ں�һ
	 */
	@Override
	public void actionHY_actionPerformed(ActionEvent e) throws Exception {
		if(this.productDateF7.getValue() != null){
			Date date=(Date)this.productDateF7.getValue();
			Date HyDate=new Date();
			
			Calendar calendar = Calendar.getInstance(); //�õ�����
			calendar.setTime(date);//�ѵ�ǰʱ�丳������
			calendar.add(Calendar.DAY_OF_MONTH, +1);  //����Ϊ��һ��
			HyDate = calendar.getTime();   //�õ���һ���ʱ��
			
			this.productDateF7.setValue(HyDate);
		}
		super.actionHY_actionPerformed(e);
	}
/**
 * ����ǰһ
 */
	@Override
	public void actionQY_actionPerformed(ActionEvent e) throws Exception {
		if(this.productDateF7.getValue() != null){
			Date date=(Date)this.productDateF7.getValue();
			Date QyDate=new Date();
			
			Calendar calendar = Calendar.getInstance(); //�õ�����
			calendar.setTime(date);//�ѵ�ǰʱ�丳������
			calendar.add(Calendar.DAY_OF_MONTH, -1);  //����Ϊǰһ��
			QyDate = calendar.getTime();   //�õ�ǰһ���ʱ��
			
			this.productDateF7.setValue(QyDate);
		}
		super.actionQY_actionPerformed(e);
	}

	
/**
 * ��ѯ
 */
@Override
public void actionCheck_actionPerformed(ActionEvent e) throws Exception {
	
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
	 * ��ѯ�����
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
		
		
		//��Ʒ����sql
		sql1.append("select").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sql1.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql1.append("CONTSET.fname_l2                    countname,").append(sp);
		sql1.append("CREATOR.fnumber                     person,").append(sp);
		sql1.append("ENTRYS.cfmnumber                    mnumber,").append(sp);
		sql1.append("ENTRYS.cfmaterialtype               mtype,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.CFStatus           status,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql1.append("FROM CT_FM_ProductCount AS SEMIPRODUCTCOUNT").append(sp);
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
		
		//��װ����
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