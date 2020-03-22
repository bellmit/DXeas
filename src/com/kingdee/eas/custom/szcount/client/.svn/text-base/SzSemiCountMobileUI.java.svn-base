/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.MathUtilsComm;
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
import com.kingdee.eas.custom.szcount.szCountSet;
import com.kingdee.eas.farm.food.stocount.PcakCountCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountFactory;
import com.kingdee.eas.farm.food.stocount.ProdCountCollection;
import com.kingdee.eas.farm.food.stocount.ProdCountFactory;
import com.kingdee.eas.farm.food.stocount.SemiProductCountCollection;
import com.kingdee.eas.farm.food.stocount.SemiProductCountFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SzSemiCountMobileUI extends AbstractSzSemiCountMobileUI
{
    private static final Logger logger = CoreUIObject.getLogger(SzSemiCountMobileUI.class);
    
    /**
     * output class constructor
     */
    public SzSemiCountMobileUI() throws Exception
    {
        super();		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
//        setUITitle("123123");
    }
    ArrayList<String> List;
    ArrayList<String> List2;
    //Map<MaterialInfo,String> map = new HashMap<MaterialInfo,String>();
    Map<String,MaterialData> meterialdate = new  HashMap<String,MaterialData>();
    String materid = "";
    String materialInfoId = null;
    int todayAddUp = 0;
    int mouseChick = -1;
	String materialnumber = "";
	String countset = null;
	CostObjectInfo costobject = new CostObjectInfo();
	CostObjectFactory cost;
	IRowSet rs;
	@Override
	public void actionclselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
/*		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2	mname,").append(sp);
		sql.append("t2.fname_l2	countname,").append(sp);
		sql.append("t5.fname_l2	person,").append(sp);
		sql.append("t4.fnumber	mnumber,").append(sp);
		sql.append("t6.Fname_l2	mtype,").append(sp);
		sql.append("t4.fid  	id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)		CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2	assist,").append(sp);
		sql.append("t4.fmodel  	model,").append(sp);
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
		sql.append("inner join T_BD_MeasureUnit  t8  on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry	t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		sql.append("where t2.cfbasestatus = '0' ").append(sp);
		sql.append("and t5.fname_l2 = '").append(SysContext.getSysContext().getCurrentUserInfo().getNumber()).append("'").append(sp);
		sql.append("and t7.FNumber in ('02010105')").append(sp);
		sql.append("group by t4.fname_l2,t2.fname_l2,t5.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel,t2.FLastUpdateTime").append(sp);*/
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select b1.*,rownum from (").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		mname,").append(sp);
		sql.append("t4.fnumber		mnumber,").append(sp);
		sql.append("t6.Fname_l2		mtype,").append(sp);
		sql.append("t4.fid  			id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)	CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2		assist,").append(sp);
		sql.append("t4.fmodel  		model").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material 		  	 t4	").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		szCountSet szcsInfo = (szCountSet) strokePosts.getSelectedItem();
		sql.append("inner join CT_SZC_SzCountPositionSet  	 tt1	on tt1.CFCountSet = '").append(szcsInfo.getValue()).append("'").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("where   t7.flongnumber like '01!0101!010103%'").append(sp);
		sql.append("and tt2.CFMaterialID = t4.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel").append(sp);
		sql.append(")b1").append(sp);
		initselectTable(sql);
		super.actionclselect_actionPerformed(e);
	}
	@Override
	public void actionjjlselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select b1.*,rownum from (").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		mname,").append(sp);
		sql.append("t4.fnumber		mnumber,").append(sp);
		sql.append("t6.Fname_l2		mtype,").append(sp);
		sql.append("t4.fid  			id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)	CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2		assist,").append(sp);
		sql.append("t4.fmodel  		model").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material 		  	 t4	").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		szCountSet szcsInfo = (szCountSet) strokePosts.getSelectedItem();
		sql.append("inner join CT_SZC_SzCountPositionSet  	 tt1	on tt1.CFCountSet = '").append(szcsInfo.getValue()).append("'").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("where   t7.flongnumber like '01!0101!010105%'").append(sp);
		sql.append("and tt2.CFMaterialID = t4.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel").append(sp);
		sql.append(")b1").append(sp);
		initselectTable(sql);
		super.actionjjlselect_actionPerformed(e);
	}
	@Override
	public void actionqtselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select b1.*,rownum from (").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		mname,").append(sp);
		sql.append("t4.fnumber		mnumber,").append(sp);
		sql.append("t6.Fname_l2		mtype,").append(sp);
		sql.append("t4.fid  			id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)	CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2		assist,").append(sp);
		sql.append("t4.fmodel  		model").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material 		  	 t4	").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		szCountSet szcsInfo = (szCountSet) strokePosts.getSelectedItem();
		sql.append("inner join CT_SZC_SzCountPositionSet  	 tt1	on tt1.CFCountSet = '").append(szcsInfo.getValue()).append("'").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("where   (t7.flongnumber like '01!0101!010104%' or t7.flongnumber like '01!0101!010106%'or t7.flongnumber like '01!0101!010107%'or t7.flongnumber like '01!0101!010108%'or t7.flongnumber like '01!0101!010109%'or t7.flongnumber like '01!0101!0101010%')").append(sp);
		sql.append("and tt2.CFMaterialID = t4.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel").append(sp);
		sql.append(")b1").append(sp);
		initselectTable(sql);
		super.actionqtselect_actionPerformed(e);
	}
	@Override
	public void actiontlselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select b1.*,rownum from (").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		mname,").append(sp);
		sql.append("t4.fnumber		mnumber,").append(sp);
		sql.append("t6.Fname_l2		mtype,").append(sp);
		sql.append("t4.fid  			id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)	CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2		assist,").append(sp);
		sql.append("t4.fmodel  		model").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material 		  	 t4	").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		szCountSet szcsInfo = (szCountSet) strokePosts.getSelectedItem();
		sql.append("inner join CT_SZC_SzCountPositionSet  	 tt1	on tt1.CFCountSet = '").append(szcsInfo.getValue()).append("'").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("where   t7.flongnumber like '01!0101!010101%'").append(sp);
		sql.append("and tt2.CFMaterialID = t4.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel").append(sp);
		sql.append(")b1").append(sp);
		initselectTable(sql);
		super.actiontlselect_actionPerformed(e);
	}
	@Override
	public void actionxlselect_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select b1.*,rownum from (").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		mname,").append(sp);
		sql.append("t4.fnumber		mnumber,").append(sp);
		sql.append("t6.Fname_l2		mtype,").append(sp);
		sql.append("t4.fid  			id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)	CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2		assist,").append(sp);
		sql.append("t4.fmodel  		model").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material 		  	 t4	").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		szCountSet szcsInfo = (szCountSet) strokePosts.getSelectedItem();
		sql.append("inner join CT_SZC_SzCountPositionSet  	 tt1	on tt1.CFCountSet = '").append(szcsInfo.getValue()).append("'").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("where   t7.flongnumber like '01!0101!010102%'").append(sp);
		sql.append("and tt2.CFMaterialID = t4.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel").append(sp);
		sql.append(")b1").append(sp);
		initselectTable(sql);
		super.actionxlselect_actionPerformed(e);
	}
	MaterialInfo matet = new MaterialInfo(); 

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
        this.material.requestFocus();
    }
    @Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		
		super.onShow();
		initTable();
		this.material.requestFocus();
	}
    
   /* 
    private JTabbedPane jTabbedpane = new JTabbedPane();// 存放选项卡的组件  
    private String[] tabNames = { "选项1", "选项2" };  
    public void JTabbedPaneDemo() {  
        layoutComponents();  
    }  
  
    public void layoutComponents() {  
        int i = 0;  
        // 第一个标签下的JPanel  
        JPanel jpanelFirst = new JPanel();  
        // jTabbedpane.addTab(tabNames[i++],icon,creatComponent(),"first");//加入第一个页面  
        jTabbedpane.addTab(tabNames[i++], jpanelFirst);// 加入第一个页面  
        jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0);// 设置第一个位置的快捷键为0  
  
        // 第二个标签下的JPanel  
        JPanel jpanelSecond = new JPanel();  
        jTabbedpane.addTab(tabNames[i++], jpanelSecond);// 加入第一个页面  
        jTabbedpane.setMnemonicAt(1, KeyEvent.VK_1);// 设置快捷键为1  
        setLayout(new GridLayout(1, 1));  
        add(jTabbedpane);  
  
    }  
    
     JFrame frame = new JFrame();  
         frame.setLayout(null);  
         frame.setContentPane(new JTabbedPaneDemo());  
         frame.setSize(400, 400);  
         frame.setVisible(true);  
		JTabbedPane tabParent = new JTabbedPane();
			
			tabParent.setBounds(5, 5, 200, 200);
		   JTabbedPane tabSub1 = new JTabbedPane();
		   tabSub1.add("11", new JScrollPane(new JTextArea("11")));
		   tabSub1.add("12", new JScrollPane(new JTextArea("12")));
		   tabSub1.add("13", new JScrollPane(new JTextArea("13")));
		   tabParent.add("1", tabSub1);
		   tabParent.add("2", new JScrollPane(new JTextArea("2")));
		   tabParent.add("3", new JScrollPane(new JTextArea("3")));
		
    */
    
    
    
    
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		strokeCounters.setText(SysContext.getSysContext().getCurrentUserInfo().getName());
		strokeName.setValue(SysContext.getSysContext().getCurrentUserInfo().getPerson());
		QyBtn.setEnabled(true);
		HyBtn.setEnabled(true);
		xl.setEnabled(true);
		tl.setEnabled(true);
		cl.setEnabled(true);
		jjl.setEnabled(true);
		qt.setEnabled(true);
		this.kDTable1.getStyleAttributes().setLocked(true);
		this.kDTable2.getStyleAttributes().setLocked(true);
		this.kDTable3.getStyleAttributes().setLocked(true);
		this.kDTable4.getStyleAttributes().setLocked(true);
		this.kDTable5.getStyleAttributes().setLocked(true);
		this.kDTable6.getStyleAttributes().setLocked(true);
		
		kDTable1.checkParsed();
		kDTable2.checkParsed();
		kDTable3.checkParsed();
		kDTable4.checkParsed();
		kDTable5.checkParsed();
		kDTable6.checkParsed();
		//UIManager.put("kDTabbedPane1.selected", Color.ORANGE);
		
		
		kDTable2.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1){
					int row = e.getRowIndex();
					materials.setText(null);
					weight.setText(null);
					materials.setText((String) kDTable2.getRow(row).getCell("category").getValue());
					mouseChick = row;
					for(String key :meterialdate.keySet()){
						if(key.equals(kDTable2.getRow(row).getCell("category").getValue().toString())&&meterialdate.get(key).getQuantity().equals(kDTable2.getRow(row).getCell("quantity").getValue().toString())){
							materialInfoId =meterialdate.get(key).getMaterialInfo().getId().toString();
						}
					}
					
					/*
					Object[] options = {"修改","删除","取消"};
				    int n = JOptionPane.showOptionDialog(null, "修改or删除", "想咋？", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				    System.out.print(n);
				    int row = e.getRowIndex();
				    if(n==JOptionPane.YES_OPTION){
				    	materials.setText(null);
						weight.setText(null);
				    	materials.setText((String) kDTable2.getRow(row).getCell("column1").getValue());
						for(MaterialInfo key :map.keySet()){
							if(key.getName().toString()==kDTable2.getRow(row).getCell("column1").getValue().toString()&&map.get(key).toString()==kDTable2.getRow(row).getCell("column2").getValue().toString()){
								kDTable2.removeRow(row);
								String MaterialInfoId =key.getId().toString();
								try {
									affirm(null,MaterialInfoId);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}else if(n==JOptionPane.NO_OPTION){
						for(MaterialInfo key :map.keySet()){
							if(key.getName().toString().equals(kDTable2.getRow(row).getCell("column1").getValue().toString())&&map.get(key).toString().equals(kDTable2.getRow(row).getCell("column2").getValue().toString())){
								kDTable2.removeRow(row);
								map.remove(key);
							}
						}
					}else{
					}*/
				}
			}
		});
		kDTable1.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1){
					int row = e.getRowIndex();
					materid = List.get(row).toString();
					IObjectPK pk = new ObjectStringPK(materid);
					try {
						material.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
						materials.setStringValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk).getName());
						StringBuffer measureSql = new StringBuffer();
						String sp = "\n";
						measureSql.append("select").append(sp);
						measureSql.append("t6.FName_l2 	measureUnit").append(sp);
						measureSql.append("from ").append(sp);
						measureSql.append("T_BD_Material t4 ").append(sp);
						measureSql.append("inner join T_BD_MeasureUnit t6  on t4.FBaseUnit = t6.fid").append(sp);
						measureSql.append("and t4.fid ='").append(materid).append("'").append(sp);
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(measureSql.toString()).executeSQL();
						StringBuffer measure = new StringBuffer();
						while(rs.next()){
							measure.append(rs.getString("measureUnit"));
						}
						measureType.setText(measure.toString());
						finishedProductType.setText("鲜品");
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			}
		});
		kDTable3.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1){
					int row = e.getRowIndex();
					materid = List.get(row).toString();
					IObjectPK pk = new ObjectStringPK(materid);
					try {
						material.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
						materials.setStringValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk).getName());
						StringBuffer measureSql = new StringBuffer();
						String sp = "\n";
						measureSql.append("select").append(sp);
						measureSql.append("t8.FID 	id").append(sp);
						measureSql.append("from ").append(sp);
						measureSql.append("T_BD_Material t4 ").append(sp);
						measureSql.append("inner join T_BD_MeasureUnit t6  on t4.FBaseUnit = t6.fid").append(sp);
						measureSql.append("inner join T_BD_MaterialGroup t7  on t7.fid = t4.FMaterialGroupID").append(sp);
						measureSql.append("inner join T_BD_MeasureUnit  t8  on t8.FID = t4.FASSISTUNIT").append(sp);
						measureSql.append("and t4.fid ='").append(materid).append("'").append(sp);
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(measureSql.toString()).executeSQL();
						StringBuffer measure = new StringBuffer();
						while(rs.next()){
							measure.append(rs.getString("id"));
						}
						IMeasureUnit imu = MeasureUnitFactory.getRemoteInstance();
						MeasureUnitInfo msuInfoInventory = imu.getMeasureUnitInfo(new ObjectUuidPK(measure.toString()));
						measureType.setText(msuInfoInventory.getName());
						finishedProductType.setText("冻品");
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		kDTable4.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1){
					int row = e.getRowIndex();
					materid = List.get(row).toString();
					IObjectPK pk = new ObjectStringPK(materid);
					try {
						material.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
						materials.setStringValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk).getName());
						StringBuffer measureSql = new StringBuffer();
						String sp = "\n";
						measureSql.append("select").append(sp);
						measureSql.append("t6.FName_l2 	measureUnit").append(sp);
						measureSql.append("from ").append(sp);
						measureSql.append("T_BD_Material t4 ").append(sp);
						measureSql.append("inner join T_BD_MeasureUnit t6  on t4.FBaseUnit = t6.fid").append(sp);
						measureSql.append("and t4.fid ='").append(materid).append("'").append(sp);
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(measureSql.toString()).executeSQL();
						StringBuffer measure = new StringBuffer();
						while(rs.next()){
							measure.append(rs.getString("measureUnit"));
						}
						measureType.setText(measure.toString());
						finishedProductType.setText("退车间");
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		kDTable5.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1){
					int row = e.getRowIndex();
					materid = List.get(row).toString();
					IObjectPK pk = new ObjectStringPK(materid);
					try {
						material.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
						materials.setStringValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk).getName());
						StringBuffer measureSql = new StringBuffer();
						String sp = "\n";
						measureSql.append("select").append(sp);
						measureSql.append("t6.FName_l2 	measureUnit").append(sp);
						measureSql.append("from ").append(sp);
						measureSql.append("T_BD_Material t4 ").append(sp);
						measureSql.append("inner join T_BD_MeasureUnit t6  on t4.FBaseUnit = t6.fid").append(sp);
						measureSql.append("and t4.fid ='").append(materid).append("'").append(sp);
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(measureSql.toString()).executeSQL();
						StringBuffer measure = new StringBuffer();
						while(rs.next()){
							measure.append(rs.getString("measureUnit"));
						}
						measureType.setText(measure.toString());
						finishedProductType.setText("未冻好");
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		kDTable6.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1){
					int row = e.getRowIndex();
					materid = List.get(row).toString();
					IObjectPK pk = new ObjectStringPK(materid);
					try {
						material.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
						materials.setStringValue(MaterialFactory.getRemoteInstance().getMaterialInfo(pk).getName());
						StringBuffer measureSql = new StringBuffer();
						String sp = "\n";
						measureSql.append("select").append(sp);
						measureSql.append("t6.FName_l2 	measureUnit").append(sp);
						measureSql.append("from ").append(sp);
						measureSql.append("T_BD_Material t4 ").append(sp);
						measureSql.append("inner join T_BD_MeasureUnit t6  on t4.FBaseUnit = t6.fid").append(sp);
						measureSql.append("and t4.fid ='").append(materid).append("'").append(sp);
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(measureSql.toString()).executeSQL();
						StringBuffer measure = new StringBuffer();
						while(rs.next()){
							measure.append(rs.getString("measureUnit"));
						}
						measureType.setText(measure.toString());
						finishedProductType.setText("半件");
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		strokePosts.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				try {
					initTable();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
//
		initUI();
		initUIComp();
		//addListener();//添加监听

		
		//物料F7过滤
		String materialid="'";//过滤字符串
		this.weight.setText("");
		
	
	}

    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 物料选择功能
	 */
 /*   protected void selectmaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
		int row = -1;
    	row = this.kDTable1.getSelectManager().getActiveRowIndex();
    	//materid = this.kDTable1
    	if(row==-1){
			MsgBox.showInfo("未选中物料行");
			SysUtil.abort();
		}
    	materid = List.get(row).toString();
		IObjectPK pk = new ObjectStringPK(materid);
		maf.getRemoteInstance().getMaterialInfo(pk);
		this.material.setValue(maf.getRemoteInstance().getMaterialInfo(pk));
        super.selectmaterial_actionPerformed(e);
    }*/

    /**
     * output cancel_actionPerformed method
     */
    protected void cancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.cancel_actionPerformed(e);
        kDTable2.removeRows();
        material.setValue(null);
        materials.setText(null);
		weight.setText(null);
		meterialdate.clear();
       /* for(String key :meterialdate.keySet()){
        	meterialdate.remove(key);
			}*/
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
        String str = this.weight.getText();
		//this.materialunitf7.setValue(null);
		this.weight.setText(str.substring(0,str.length()-1));
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
		if(strokeName.getName().toString()==null){
				MsgBox.showWarning("计数人员不许为空");
				SysUtil.abort();
		}
		if(HouseName.getValue()==null){
			MsgBox.showWarning("仓库不许为空");
			SysUtil.abort();
		}
		if(kDTable2.getRowCount()==0){
			MsgBox.showWarning("没有数据可保存");
			SysUtil.abort();
		}	
		//岗位判断
		//BigDecimal w = new BigDecimal(this.weight.getText());
		//	if(countset.equals("0")){
				//将UI中各值添加在新增的成品计数上
					SzSemiProductInfo spinfo = new SzSemiProductInfo();			
					
					spinfo.setNumber(createSeNumber());
					spinfo.setBizDate(new Date());
					spinfo.setStatus(BillBaseStatusEnum.SUBMITED);
					spinfo.setPerson((PersonInfo) strokeName.getValue());
					spinfo.setCount((szCountSet) strokePosts.getSelectedItem());
					spinfo.setHouseName((WarehouseInfo) HouseName.getValue());
					
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
					for(String key :meterialdate.keySet()){
						MaterialInfo matet = meterialdate.get(key).getMaterialInfo();
						//定义分录
						SzSemiProductEntryCollection pinfoec= spinfo.getEntrys();
						SzSemiProductEntryInfo pinfoe = new SzSemiProductEntryInfo();
						pinfoe.setMaterial(matet);
						BigDecimal mnumber=new BigDecimal(meterialdate.get(key).getQuantity());
						System.out.print(matet.getMaterialGroup().getId());
						System.out.print(matet.getBaseUnit().getId());
						System.out.print(matet.getId());
						pinfoe.setMeasureUnit(meterialdate.get(key).getMaterialUnit());
						/*IMaterialGroup img = MaterialGroupFactory.getRemoteInstance();
						MaterialGroupInfo matetg = img.getMaterialGroupInfo(new ObjectUuidPK(matet.getMaterialGroup().getId()));
						pinfoe.setMaterialtype(matetg.getName());*/
						pinfoe.setMaterialtype(matet.getModel());
						IMeasureUnit imu = MeasureUnitFactory.getRemoteInstance();
						MeasureUnitInfo msuInfo =imu.getMeasureUnitInfo(new ObjectUuidPK(matet.getBaseUnit().getId()));
						pinfoe.setMbaseunit(msuInfo.getName());
						if(msuInfo.getName().equals(meterialdate.get(key).getMaterialUnit())){
							pinfoe.setWeight(mnumber);
						}else{
							StringBuffer weightsql = new StringBuffer();
							String sp = "\n";
							weightsql.append("select t2.Fcoefficient Fcoefficient from ").append(sp);
							weightsql.append("T_BD_Material	 	  t1").append(sp);
							weightsql.append("inner join T_BD_MeasureUnit  t2	on t2.FID = t1.FASSISTUNIT").append(sp);
							weightsql.append("where t1.Fid = '").append(meterialdate.get(key).getMaterialInfo().getId()).append("'").append(sp);
							IRowSet rs = SQLExecutorFactory.getRemoteInstance(weightsql.toString()).executeSQL();
							BigDecimal a = null;
							while(rs.next()){
								a=rs.getBigDecimal("Fcoefficient");
							}
							Double b=mnumber.doubleValue();
							Double c = a.doubleValue();
							BigDecimal pingoeWeight = new BigDecimal(Double.toString(b*c));
							pinfoe.setWeight(pingoeWeight);
						}
						/*StringBuffer inventorySql = new StringBuffer();
						String sp = "\n";

						inventorySql.append("select").append(sp);
						inventorySql.append("t8.FID 	id").append(sp);
						inventorySql.append("from ").append(sp);
						inventorySql.append("T_BD_Material t4 ").append(sp);
						inventorySql.append("inner join T_BD_MeasureUnit t6  on t4.FBaseUnit = t6.fid").append(sp);
						inventorySql.append("inner join T_BD_MaterialGroup t7  on t7.fid = t4.FMaterialGroupID").append(sp);
						inventorySql.append("inner join T_BD_MeasureUnit  t8  on t8.FID = t4.FASSISTUNIT").append(sp);
						inventorySql.append("and t4.fid ='").append(matet.getId()).append("'").append(sp);
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(inventorySql.toString()).executeSQL();
						StringBuffer inventory = new StringBuffer();
						while(rs.next()){
							inventory.append(rs.getString("id"));
						}
						MeasureUnitInfo msuInfoInventory = imu.getMeasureUnitInfo(new ObjectUuidPK(inventory.toString()));
						pinfoe.setMeasureUnit(msuInfoInventory.getName());*/
						pinfoe.setBatch(batch.toString());
						pinfoe.setMaterialnumber(matet.getNumber());
						pinfoe.setFinishedProductType(meterialdate.get(key).getFinishedProductType());
						System.out.println(this.material.getText()+"-----------------");
						pinfoec.add(pinfoe);
						
						
						
						
					}
					ISzSemiProduct isc = SzSemiProductFactory.getRemoteInstance();
					isc.save(spinfo);
					//IObjectPK spk=
					MsgBox.showWarning("保存完成！");
					kDTable2.removeRows();
					meterialdate.clear();
					 /* for(String key :meterialdate.keySet()){
				        	meterialdate.remove(key);
							}*/
					this.onShow();
					
		/*}else{
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
			pinfoe.setMnumber(null);
			
			pinfoe.setProductDate((Date)this.productDateF7.getValue());
		
			pinfoe.setBatch(batch.toString());
			pinfoe.setMaterialnumber(materialnumber);
			
			System.out.println(this.material.getText()+"-----------------");
			
			BigDecimal weight = new BigDecimal("0");
			
			pinfoe.setWeight((BigDecimal)weight);
			
			pinfoe.setCostobject(CostObjectFactory.getRemoteInstance().getCostObjectInfo("where StdProductID = '"+matet.getId()+"'"));
			pinfoe.setCostobjectnumber(materialnumber);
			pinfoec.add(pinfoe);
			
			pinfo.setNumber(createSeNumber());
			pinfo.setBizDate(new Date());
			
			pinfo.setStatus(BillBaseStatusEnum.AUDITED);
			
//			String userid=((UserInfo)this.countpersonf7.getValue()).getId().toString();
//			StringBuffer sql=new StringBuffer();
//			sql.append("select FPersonId from T_PM_User where  fid ='").append(userid).append("'");
//			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
//			if(rs.next()){
//				pinfo.setPerson(PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("FPersonId"))));
//			}
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
			MsgBox.showWarning("保存完成！");
			this.onShow();
		}*/
		
    }

	/**
	 * 成品编码
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
	
//传入sql 值存入kDTable
	private void initselectTable(StringBuffer sql) throws BOSException {
		rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		this.kDTable1.removeRows();
		this.kDTable3.removeRows();
		this.kDTable4.removeRows();
		this.kDTable5.removeRows();
		this.kDTable6.removeRows();
		int i = 0;
		List = new ArrayList<String>();
		kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable2.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable3.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable4.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable5.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable6.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		boolean bool = false;
		try {
			while (rs.next()) {
				IRow row = this.kDTable1.addRow();
				IRow row3 = this.kDTable3.addRow();
				IRow row4 = this.kDTable4.addRow();
				IRow row5 = this.kDTable5.addRow();
				IRow row6 = this.kDTable6.addRow();
				row.setHeight(30);
				row3.setHeight(30);
				row4.setHeight(30);
				row5.setHeight(30);
				row6.setHeight(30);
				if(bool){
					row.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row3.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row4.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row5.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row6.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					bool=false;
				}else{
					bool=true;
				}
				row.getCell("category").setValue(rs.getString("mname"));
				row.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row.getCell("basicUnit").setValue(rs.getString("mtype"));
				row.getCell("assistUnit").setValue(rs.getString("assist"));
				row.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row3.getCell("category").setValue(rs.getString("mname"));
				row3.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row3.getCell("basicUnit").setValue(rs.getString("mtype"));
				row3.getCell("assistUnit").setValue(rs.getString("assist"));
				row3.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row4.getCell("category").setValue(rs.getString("mname"));
				row4.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row4.getCell("basicUnit").setValue(rs.getString("mtype"));
				row4.getCell("assistUnit").setValue(rs.getString("assist"));
				row4.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row5.getCell("category").setValue(rs.getString("mname"));
				row5.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row5.getCell("basicUnit").setValue(rs.getString("mtype"));
				row5.getCell("assistUnit").setValue(rs.getString("assist"));
				row5.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row6.getCell("category").setValue(rs.getString("mname"));
				row6.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row6.getCell("basicUnit").setValue(rs.getString("mtype"));
				row6.getCell("assistUnit").setValue(rs.getString("assist"));
				row6.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				//fid[i] = rs.getString("fid");
			    //materid = rs.getString("id").toString();
				List.add(i, rs.getString("id").toString());
				//System.out.println(rs.getString("fid")+i);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//初始化分录
	private void initTable() throws BOSException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select b1.*,rownum from (").append(sp);
		sql.append("select").append(sp);
		sql.append("t4.fname_l2		mname,").append(sp);
		sql.append("t4.fnumber		mnumber,").append(sp);
		sql.append("t6.Fname_l2		mtype,").append(sp);
		sql.append("t4.fid  			id,").append(sp);
		sql.append("nvl(sum(t9.CFMNumber),0)	CFMNumber,").append(sp);
		sql.append("t8.FNAME_l2		assist,").append(sp);
		sql.append("t4.fmodel  		model").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material 		  	 t4	").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t6 	on t4.FBaseUnit = t6.fid").append(sp);
		sql.append("inner join T_BD_MaterialGroup		 t7 	on t7.fid = t4.FMaterialGroupID").append(sp);
		sql.append("inner join T_BD_MeasureUnit 		 t8	on t8.FID = t4.FASSISTUNIT").append(sp);
		sql.append("left join CT_SZC_SzsemiProductEntry		 t9	on t4.FNumber = t9.CFMaterialNumber").append(sp);
		sql.append("and t9.cfbatch = to_char(sysdate,'yyyyMMdd') ").append(sp);
		szCountSet szcsInfo = (szCountSet) strokePosts.getSelectedItem();
		sql.append("inner join CT_SZC_SzCountPositionSet  	 tt1	on tt1.CFCountSet = '").append(szcsInfo.getValue()).append("'").append(sp);
		sql.append("inner join CT_SZC_SzCPSME			 tt2	on	tt2.FParentID = tt1.FID").append(sp);
		sql.append("inner join CT_SZC_SzCPSOE			 tt3	on	tt3.FParentID = tt1.FID").append(sp);
		sql.append("where   t7.flongnumber like '01!0101!010102%'").append(sp);
		sql.append("and tt2.CFMaterialID = t4.FID").append(sp);
		sql.append("and tt3.CFPersonID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
		sql.append("group by t4.fname_l2,t4.fnumber,t6.Fname_l2,t4.fid,t8.FNAME_l2,t4.fmodel").append(sp);
		sql.append(")b1").append(sp);
		rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		this.kDTable1.removeRows();
		this.kDTable3.removeRows();
		this.kDTable4.removeRows();
		this.kDTable5.removeRows();
		this.kDTable6.removeRows();
		List = new ArrayList<String>();
		int i = 0;
		kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable3.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable4.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable5.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		kDTable6.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		boolean bool = false;
		try {
			while (rs.next()) {
				
				IRow row = this.kDTable1.addRow();
				IRow row3 = this.kDTable3.addRow();
				IRow row4 = this.kDTable4.addRow();
				IRow row5 = this.kDTable5.addRow();
				IRow row6 = this.kDTable6.addRow();
				row.setHeight(30);
				row3.setHeight(30);
				row4.setHeight(30);
				row5.setHeight(30);
				row6.setHeight(30);
				if(bool){
					row.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row3.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row4.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row5.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					row6.getStyleAttributes().setBackground(Color.getHSBColor(237,236,232));
					bool=false;
				}else{
					bool=true;
				}
				row.getCell("category").setValue(rs.getString("mname"));
				row.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row.getCell("basicUnit").setValue(rs.getString("mtype"));
				row.getCell("assistUnit").setValue(rs.getString("assist"));
				row.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row3.getCell("category").setValue(rs.getString("mname"));
				row3.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row3.getCell("basicUnit").setValue(rs.getString("mtype"));
				row3.getCell("assistUnit").setValue(rs.getString("assist"));
				row3.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row4.getCell("category").setValue(rs.getString("mname"));
				row4.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row4.getCell("basicUnit").setValue(rs.getString("mtype"));
				row4.getCell("assistUnit").setValue(rs.getString("assist"));
				row4.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row5.getCell("category").setValue(rs.getString("mname"));
				row5.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row5.getCell("basicUnit").setValue(rs.getString("mtype"));
				row5.getCell("assistUnit").setValue(rs.getString("assist"));
				row5.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				row6.getCell("category").setValue(rs.getString("mname"));
				row6.getCell("materialNumber").setValue(rs.getString("mnumber"));
				row6.getCell("basicUnit").setValue(rs.getString("mtype"));
				row6.getCell("assistUnit").setValue(rs.getString("assist"));
				row6.getCell("todayAddUp").setValue(rs.getString("CFMNumber"));
				//row.getCell("column7").setValue("0");
				//fid[i] = rs.getString("fid");
			    //materid = rs.getString("id").toString();
				List.add(i, rs.getString("id").toString());
				//System.out.println(rs.getString("fid")+i);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return 结果集
	 * @throws BOSException
	 */
/*	private IRowSet getExeQueryRowSet() throws BOSException {
		
		
		
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
	}*/
	
	
	//界面初始化
	//默认带出当前用户的信息和对应岗位信息
	private void initUI() {
		// TODO Auto-generated method stub
		
		

		//user和administrator没有员工内码所以不能进行岗位判断
		if(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("user")||com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("administrator")){
			MsgBox.showWarning("非企业内用户禁止编辑！");
			SysUtil.abort();
		}
		String userid = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString();
		//this.countpersonf7.setValue(SysContext.getSysContext().getCurrentUserInfo() );
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
			//this.countpointf7.setValue(cpinfo);
			this.material.setValue(null);
			//this.materialunitf7.setValue(null);
			this.weight.setText(null);
			//this.materialunittypef7.setValue(null);
			this.productDateF7.setValue(new Date());
			this.actionQY.setEnabled(true);	
			this.actionHY.setEnabled(true);	
			this.actionXlselect.setEnabled(true);
			this.actionTlselect.setEnabled(true);
			this.actionClselect.setEnabled(true);
			this.actionJjlselect.setEnabled(true);
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
	 * F7初始化
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private void initUIComp() throws BOSException, SQLException {
		// TODO Auto-generated method stub
//		this.countpersonf7.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
//		this.countpersonf7.setVisible(true);		
//		this.countpersonf7.setEditable(true);		
//		this.countpersonf7.setDisplayFormat("$name$");		
//		this.countpersonf7.setEditFormat("$number$");		
//		this.countpersonf7.setCommitFormat("$number$");		
//		this.countpersonf7.setRequired(false);
//		
//		
//
//		
//        // prmtsemcount		
//        this.countpointf7.setQueryInfo("com.kingdee.eas.custom.szcount.app.SzCountPositionSetQuery");		
//        this.countpointf7.setVisible(true);		
//        this.countpointf7.setEditable(true);		
//        this.countpointf7.setDisplayFormat("$name$");		
//        this.countpointf7.setEditFormat("$number$");		
//        this.countpointf7.setCommitFormat("$number$");		
//        this.countpointf7.setRequired(false);
//        
//        	countpointf7.addSelectorListener(new SelectorListener() {
//        		com.kingdee.eas.custom.szcount.client.SzCountPositionSetListUI prmtsemcount_F7ListUI = null;
//			public void willShow(SelectorEvent e) {
//				if (prmtsemcount_F7ListUI == null) {
//					try {
//						prmtsemcount_F7ListUI = new com.kingdee.eas.custom.szcount.client.SzCountPositionSetListUI();
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					HashMap ctx = new HashMap();
//					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsemcount_F7ListUI));
//					prmtsemcount_F7ListUI.setF7Use(true,ctx);
//					countpointf7.setSelector(prmtsemcount_F7ListUI);
//				}
//			}
//		});
////        	countpointf7.addCommitListener(new CommitListener(){
////				public void willCommit(CommitEvent paramCommitEvent) {
////					// TODO Auto-generated method stub
////					String mnumber = paramCommitEvent.getText();
////					System.out.println("--+++--"+mnumber);
////				}
////        		
////        	});
//        	
//        //班次	
//        this.classes.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szClasses").toArray());	
//        this.classes.setRequired(false);
        
        	
        // prmtmaterial		
        this.material.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");	
        this.strokeName.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");           
        //this.strokePosts.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szCountSet").toArray());
        //this.strokePosts.setRequired(false);
        finishedProductType.setVisible(false);
        StringBuffer strokePostsql = new StringBuffer();
		String sp = "\n";
        strokePostsql.append("select t1.CFCountset Countset from").append(sp);
        strokePostsql.append("CT_SZC_SzCountPositionSet	t1").append(sp);
        strokePostsql.append("inner join CT_SZC_SzCPSOE	t2 on t1.FID = t2.FParentID").append(sp);
        strokePostsql.append("where t2.CFPERSONID = '").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'").append(sp);
        IRowSet rs = SQLExecutorFactory.getRemoteInstance(strokePostsql.toString()).executeSQL();
        while(rs.next()){
        	this.strokePosts.addItem(szCountSet.getEnum(rs.getString("Countset")));
        }
        
        this.material.setVisible(false);		
        this.strokeName.setVisible(false);
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
		//materialunitf7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"baseUnit.name")));
		//materialunittypef7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"model")));
		materialnumber = com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"number")).toString();

	}
    
	
   

	@Override
	protected void bb0_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("0");
    	this.weight.setText(weight.toString());
		super.bb0_actionPerformed(e);
	}
	@Override
	protected void bb1_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("1");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb1_actionPerformed(e);
	}
	@Override
	protected void bb2_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("2");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb2_actionPerformed(e);
	}
	@Override
	protected void bb3_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("3");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb3_actionPerformed(e);
	}
	@Override
	protected void bb4_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("4");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb4_actionPerformed(e);
	}
	@Override
	protected void bb5_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("5");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb5_actionPerformed(e);
	}
	@Override
	protected void bb6_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("6");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb6_actionPerformed(e);
	}
	@Override
	protected void bb7_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("7");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb7_actionPerformed(e);
	}
	@Override
	protected void bb8_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("8");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb8_actionPerformed(e);
	}
	@Override
	protected void bb9_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append("9");
    	int index = weight.indexOf(".");
    	if(index<=0){
    		Integer nowWeight = new Integer(weight.toString());
        	this.weight.setText(nowWeight.toString());
    	}else{
	    	Double nowWeight = new Double(weight.toString());
	    	this.weight.setText(nowWeight.toString().substring(0, nowWeight.toString().length()));
    	}
		super.bb9_actionPerformed(e);
	}
	
	@Override
	protected void spot_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String str = this.weight.getText();
		int index = str.indexOf(".");
		if(index<=0){
		StringBuffer weight = new StringBuffer();
    	weight.append(this.weight.getText());
    	weight.append(".");
    	this.weight.setText(weight.toString());
		}
		super.spot_actionPerformed(e);
		
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
    public void actionCheck_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCheck_actionPerformed(e);
    }
	@Override
	//点击确定按钮
	protected void affirm_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.affirm_actionPerformed(e);
		affirm(e,null);		
	}
	//点击确定按钮具体方法
	public void affirm(ActionEvent e,String materialInfoId){
		if(materialInfoId!=null){
			if(StringUtils.isNotBlank(weight.getText())){
				IRow row =this.kDTable2.addRow();
				row.getCell("category").setValue(materials.getText());
				row.getCell("materialUnit").setValue(measureType.getText());
				row.getCell("quantity").setValue(weight.getText());
				IObjectPK pk = new ObjectStringPK(materid);
				try {
					MaterialData mt = new MaterialData();
					mt.setMaterialInfo(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
					mt.setMaterialUnit(measureType.getText());
					mt.setQuantity(weight.getText());
					mt.setFinishedProductType(finishedProductType.getText());
					meterialdate.put(materials.getText(), mt);
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				materialInfoId=null;
			}else{
				MsgBox.showWarning("产品数量不许为空");
				SysUtil.abort();
			}
		}
		else{
			if(StringUtils.isBlank(materials.getText())){
				MsgBox.showWarning("品类不许为空");
				SysUtil.abort();
			}
			if(StringUtils.isBlank(weight.getText())){
				MsgBox.showWarning("数量不许为空");
				SysUtil.abort();
			}
			
			if(StringUtils.isNotBlank(materials.getText())&&StringUtils.isNotBlank(weight.getText())){
				int	rowCount= this.kDTable2.getRowCount();
				if(rowCount==0){
					IRow row =this.kDTable2.addRow();
		/*			JPanel dd=new JPanel();
					dd.setBounds(0,0, 50, 20);
					dd.setLayout(new BorderLayout());
					KDButton ss=new KDButton("删除");
					ss.setBounds(0, 0, 50, 20);
					ss.setVisible(true);
					dd.add(ss,BorderLayout.CENTER);
					dd.setVisible(true);
					KDTDefaultCellEditor paramICellEditor=new KDTDefaultCellEditor(dd);
					row.getCell("delete").setEditor(paramICellEditor);*/
					row.getCell("category").setValue(materials.getText());
					row.getCell("materialUnit").setValue(measureType.getText());
					row.getCell("quantity").setValue(weight.getText());
					
					IObjectPK pk = new ObjectStringPK(materid);
					try {
						MaterialData mt = new MaterialData();
						mt.setMaterialInfo(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
						mt.setMaterialUnit(measureType.getText());
						mt.setQuantity(weight.getText());
						mt.setFinishedProductType(finishedProductType.getText());
						meterialdate.put(materials.getText(), mt);
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					materials.setText(null);
					weight.setText(null);
				}else{
					for(int i=0;i<rowCount;i++){
						System.out.print(this.kDTable2.getRow(i).getCell("category").getValue().toString());
						System.out.print(materials.getText());
						if((this.kDTable2.getRow(i).getCell("category").getValue().toString()).equals(materials.getText())){
							/*kDTable2.removeRow(i);
							IRow row =this.kDTable2.addRow();
							row.getCell("column1").setValue(materials.getText());
							row.getCell("column2").setValue(weight.getText());
							*/
							kDTable2.getRow(i).getCell("quantity").setValue(weight.getText());
							IObjectPK pk = new ObjectStringPK(materid);
							try {
								MaterialData mt = new MaterialData();
								mt.setMaterialInfo(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
								mt.setMaterialUnit(measureType.getText());
								mt.setQuantity(weight.getText());
								mt.setFinishedProductType(finishedProductType.getText());
								meterialdate.put(materials.getText(), mt);
							} catch (EASBizException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (BOSException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							materials.setText(null);
							weight.setText(null);
							material.setValue(null);
							break;
						}else{
							if(i==rowCount-1){
								IRow row =this.kDTable2.addRow();
								row.getCell("category").setValue(materials.getText());
								row.getCell("materialUnit").setValue(measureType.getText());
								row.getCell("quantity").setValue(weight.getText());
								
								IObjectPK pk = new ObjectStringPK(materid);
								try {
									MaterialData mt = new MaterialData();
									mt.setMaterialInfo(MaterialFactory.getRemoteInstance().getMaterialInfo(pk));
									mt.setMaterialUnit(measureType.getText());
									mt.setQuantity(weight.getText());
									mt.setFinishedProductType(finishedProductType.getText());
									meterialdate.put(materials.getText(), mt);
								} catch (EASBizException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (BOSException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								materials.setText(null);
								weight.setText(null);
								material.setValue(null);
								
							}else{
								continue;
							}
						}
					}		
				}
				
			}
		}
		kDTable2.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
	}
	@Override
	protected void deleteButton_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.deleteButton_actionPerformed(e);
		deleteButton(e,mouseChick);
	}
	//删除按钮功能
	public void deleteButton(ActionEvent e,int mouseChick){
		System.out.print(mouseChick);
		if(mouseChick!=-1){
			for(String key :meterialdate.keySet()){
				if(key.equals(kDTable2.getRow(mouseChick).getCell("category").getValue().toString())&&meterialdate.get(key).getQuantity().equals(kDTable2.getRow(mouseChick).getCell("quantity").getValue().toString())){
					kDTable2.removeRow(mouseChick);
					meterialdate.remove(key);
					mouseChick=-1;
					break;
				}
			}
		}else{
			SysUtil.abort();
		}
		kDTable2.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
	}
	@Override
	protected void minus_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(StringUtils.isNotBlank(weight.getText())){
    		Integer weightminus = new Integer(this.weight.getText());
    		weightminus = weightminus*-1;
    		this.weight.setText(weightminus.toString());
    		super.minus_actionPerformed(e);
    	}
		//PersonInfo psInfo = com.kingdee.eas.basedata.person.PersonFactory.getRemoteInstance().getPersonInfo(new com.kingdee.bos.dao.ormapping.ObjectUuidPK());
	}
	
}