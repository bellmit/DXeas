///**
// * output package name
// */
//package com.kingdee.eas.farm.stocking.assistfunction.client;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Rectangle;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//
//import com.kingdee.bos.ctrl.kdf.table.IRow;
//import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
//import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
//import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
//import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
//import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
//import com.kingdee.bos.dao.query.SQLExecutorFactory;
//import com.kingdee.bos.metadata.IMetaDataPK;
//import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.SelectorItemCollection;
//import com.kingdee.bos.ui.face.AbstractUIFactory;
//import com.kingdee.bos.ui.face.CoreUIObject;
//import com.kingdee.bos.ui.face.IUIWindow;
//import com.kingdee.bos.ui.face.UIException;
//import com.kingdee.bos.ui.face.UIFactory;
//import com.kingdee.bos.ui.face.UIRuleUtil;
//import com.kingdee.eas.common.client.OprtState;
//import com.kingdee.eas.common.client.UIContext;
//import com.kingdee.eas.common.client.UIFactoryName;
//import com.kingdee.eas.farm.stocking.assistfunction.ISettleBillPrintCount;
//import com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountFactory;
//import com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountInfo;
//import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
//import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
//import com.kingdee.eas.farm.stocking.hatch.client.EggSettleBillEditUI;
//import com.kingdee.eas.framework.client.CoreUI;
//import com.kingdee.eas.util.client.MsgBox;
//import com.kingdee.jdbc.rowset.IRowSet;
//
///**
// * output class name
// */
//public class SelfHelpSettleBillPrintPlatformUI extends AbstractSelfHelpSettleBillPrintPlatformUI
//{
//	private static final Logger logger = CoreUIObject.getLogger(SelfHelpSettleBillPrintPlatformUI.class);
//	private boolean isOpened=false;
//	private EggSettleBillInfo editData;
//	private NativeUtils nUtils;
//	private Thread readerThread=null;
//	private String oldIdentityID="",identityID="",personName="";//身份证号
//	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private int printCount=1;//允许打印次数
//	private ISettleBillPrintCount iss;
//	private ArrayList<String> hasPrintIDs;
//
//	/**
//	 * output class constructor
//	 */
//	public SelfHelpSettleBillPrintPlatformUI() throws Exception
//	{
//		super();
//		this.setUITitle("种蛋结算自助打印平台");
//		Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setPreferredSize(dd);//new Dimension((int)(dd.getWidth()*0.8),(int)(dd.getHeight()*0.8)));
//	}
//
//
//	@Override
//	public void onLoad() throws Exception {
//		super.onLoad();
//		this.pkBizDate.setSupportedEmpty(false);
//		this.pkEndDate.setSupportedEmpty(false);
//
//		setQueryDate();
//		iss = SettleBillPrintCountFactory.getRemoteInstance();
//		hasPrintIDs=new ArrayList<String>();
//
//		this.kDTable1.checkParsed();
//		this.kDTable1.getStyleAttributes().setLocked(true);
//		this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
//		this.kDTable1.getStyleAttributes().setFontSize(12);
//
//		kDTable1.addKDTSelectListener(new KDTSelectListener(){
//			public void tableSelectChanged(KDTSelectEvent e) {
//				loadBillToPanel(e.getSelectBlock().getBeginRow());
//			}});
//
//		nUtils=new NativeUtils();
//		readerThread=new Thread(new ReadTimer());
//		readerThread.start();
//	}
//
//	private void setQueryDate() {
//		Date nowDate=new Date();
//		Calendar cal=Calendar.getInstance();
//		cal.setTime(nowDate);
//		cal.set(Calendar.MILLISECOND, 0);
//		cal.set(Calendar.SECOND, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.HOUR, 0);
//		cal.add(Calendar.DAY_OF_MONTH, 1);
//		cal.add(Calendar.MILLISECOND, -1);
//		pkEndDate.setValue(cal.getTime());
//		cal.set(Calendar.MILLISECOND, 0);
//		cal.set(Calendar.SECOND, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.HOUR, 0);
//		cal.add(Calendar.DAY_OF_MONTH, -16);
//		pkBizDate.setValue(cal.getTime());
//	}
//
//	/**
//	 * 加载单据
//	 * @param rowIndex
//	 */
//	private void loadBillToPanel(int rowIndex) {
//		String billID=null;
//		if(rowIndex>=0) {
//			billID=kDTable1.getCell(rowIndex,"id").getValue().toString();
//		}
//		//注销ui
//		for(int index=0;index<kDPanelBill.getComponentCount();index++) {
//			if(kDPanelBill.getComponent(index) instanceof CoreUI) {
//				((CoreUI)kDPanelBill.getComponent(index)).destroyWindow();
//				kDPanelBill.remove(index);
//			}
//		}
//		try {
//			if(StringUtils.isNotEmpty(billID)) {
//				SelectorItemCollection slor=new SelectorItemCollection();
//				slor.add("*");
//				slor.add("entrys.*");
//				slor.add("entrys.farmer.*");
//				slor.add("entrys.farm.*");
//				slor.add("entrys.stockingBatch.*");
//				slor.add("entrys.house.*");
//				slor.add("entrys.settleItem.*");
//				slor.add("entrys.unit.*");
//				slor.add("entrys.wareHouse.*");
//				slor.add("entrys.costItem.*");
//				slor.add("company.*");
//				slor.add("storageOrgUnit.*");
//				slor.add("farmer.*");
//				slor.add("entrys.priceEntry.*");
//				editData=EggSettleBillFactory.getRemoteInstance().getEggSettleBillInfo(new ObjectUuidPK(billID),slor);
//				EggSettleBillEditUI tempUI = (EggSettleBillEditUI) AbstractUIFactory.createUIObjectNoInit("com.kingdee.eas.farm.stocking.hatch.client.EggSettleBillEditUI");
//				tempUI.initLayout();
//				this.getUIContext().put("InitDataObject", editData);
//				tempUI.getUIContext().putAll(this.getUIContext());
//				tempUI.setOprtState(OprtState.VIEW);
//				tempUI.setBounds(new Rectangle(0, 0, 989, 462));
//				tempUI.onLoad();
//				//				tempUI.loadFields();
//				tempUI.repaint();
//				this.kDPanelBill.add(tempUI,BorderLayout.CENTER);
//			}
//		}catch(Exception err) {
//			handleException(err);
//		}
//		this.kDPanelBill.repaint();
//		this.kDPanelBill.updateUI();
//	}
//
//
//	@Override
//	protected void btnPrint_actionPerformed(ActionEvent e) throws Exception {
//		if(!checkPrint()) {
//			return;
//		}
//		ArrayList idList = new ArrayList();
//		if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
//			idList.add(editData.getString("id"));
//		}
//		if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
//			return;
//		com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
//		com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
//		appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
//		insertPrintRecord();
//	}
//	/**
//	 * 插入打印记录
//	 */
//	private void insertPrintRecord() {
//		IRow row = KDTableUtil.getSelectedRow(kDTable1);
//		if(row==null) {
//			return;
//		}
//		if(row.getCell("number").getValue()!=null) {
//			SettleBillPrintCountInfo info=new SettleBillPrintCountInfo();
//			info.setSourceBillId((String)row.getCell("id").getValue());
//			info.setNumber((String)row.getCell("number").getValue());
//			info.setBizDate(new Date());
//			info.setPersonName(personName);
//			info.setIdentityID(identityID);
//			try {
//				iss.addnew(info);
//			} catch (Exception e) {
//				handleException(e);
//			} 
//		}
//		row.getStyleAttributes().setBackground(Color.LIGHT_GRAY);
//		hasPrintIDs.add((String)row.getCell("id").getValue());
//	}
//
//	protected String getTDFileName() {
//		return "/bim/farm/stocking/hatch/EggSettleBillPlatform";
//	}
//
//	protected IMetaDataPK getTDQueryPK() {
//		return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillQuery");
//	}
//
//	private boolean  checkPrint() {
//		IRow row = KDTableUtil.getSelectedRow(kDTable1);
//		if(row==null) {
//			return false;
//		}
//		if(printCount<=UIRuleUtil.getIntValue(row.getCell("count").getValue())) {
//			MsgBox.showWarning("打印次数已达上限，禁止打印！");
//			return false;
//		}
//		if(hasPrintIDs.contains((String)row.getCell("id").getValue())) {
//			MsgBox.showWarning("打印次数已达上限，禁止打印！");
//			return false;
//		}
//		String  bizDateStr=row.getCell("bizDate").getValue().toString();
//		try {
//			Date bizDate=sdf.parse(bizDateStr);
//			Date ocDate=sdf.parse("2017-10-01");
//			if(bizDate.before(ocDate)) {
//				MsgBox.showWarning("10月份之前数据禁止打印，禁止打印！");
//				return false;
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
//
//	@Override
//	protected void btnPrintPreview_actionPerformed(ActionEvent e) throws Exception {
//		if(!checkPrint()) {
//			return;
//		}
//		ArrayList idList = new ArrayList();
//		if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
//			idList.add(editData.getString("id"));
//		}
//		if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
//			return;
//		com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
//		com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
//		appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
//	}
//
//	@Override
//	public boolean destroyWindow() {
//		UIContext uiContext = new UIContext(this);
//		IUIWindow uiWindow = null ;
//		// UIFactoryName.MODEL 为弹出模式
//		try {
//			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.farm.stocking.assistfunction.client.PwdVerifyUI", uiContext, null,OprtState.VIEW);
//		} catch (UIException e) {
//			e.printStackTrace();
//		}
//		//开始展现UI
//		uiWindow.show();
//		if((Boolean)uiWindow.getUIObject().getUIContext().get("isCancel")) {
//			return false;
//		}
//		closePort();
//		return super.destroyWindow();
//	}
//
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		closePort();
//		super.finalize();
//	}
//
//	@Override
//	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
//		exeQuery(false);
//	}
//
//	private void exeQuery(boolean isAutoLoad) {
//		System.out.println("old:"+oldIdentityID+";new:"+identityID);
//		if(isAutoLoad){
//			if(!oldIdentityID.equals(identityID)) {
//				if(StringUtils.isEmpty(identityID)){
//					this.kDTable1.removeRows();
//					editData=null;
//					loadBillToPanel(-1);
//					oldIdentityID=identityID;
//					return;
//				}
//			}else {
//				oldIdentityID=identityID;
//				return;
//			}
//		}
//		oldIdentityID=identityID;
//		//		identityID="37092119890227271X";
//		if(StringUtils.isNotEmpty(identityID)&&identityID.equals("371325199312170519"))
//			identityID="342724196207071911";
//		this.kDTable1.removeRows();
//		editData=null;
//		hasPrintIDs.clear();
//		StringBuffer sql=new StringBuffer();
//		sql.append(" select tbill.fid,tbill.fnumber,to_char(tbill.FbizDate,'yyyy-MM-dd') FbizDate,tf.fname_l2 fname,")
//		.append(" isnull(tbill.FAmount,0) FAmount,isnull(tbill.FQualityRate,0) FQualityRate,isnull(tbill.FBadRate,0) FBadRate,")
//		.append(" isnull(ttemp.fcount,0) fcount")
//		.append(" from T_FM_EggSettleBill tbill")
//		.append(" inner join t_fm_farmers tf on tf.fid=tbill.FFarmerID")
//		.append(" left join (")
//		.append(" select FSourceBillID,count(1) FCount from  T_FM_SettleBillPrintCount where FSourceBillID in (")
//		.append(" select tbill.fid from T_FM_EggSettleBill tbill")
//		.append(" inner join t_fm_farmers tf on tf.fid=tbill.FFarmerID")
//		.append(" where tf.FIdentity='").append(identityID).append("'")
//		.append(" and tbill.fbizDate>{ ts'").append(sdf.format(pkBizDate.getValue())).append("'}")
//		.append(" and tbill.fbizDate<={ ts'").append(sdf.format(pkEndDate.getValue())).append("'}")
//		.append(" )")
//		.append(" and (FIsCancel is null or FIsCancel!=1)")
//		.append(" group by FSourceBillID")
//		.append(" ) ttemp on ttemp.fsourcebillid=tbill.fid")
//		.append(" where ucase(tf.FIdentity)='").append(identityID.toUpperCase()).append("'")
//		.append(" and tbill.fbizDate>{ ts'").append(sdf.format(pkBizDate.getValue())).append("'}")
//		.append(" and tbill.fbizDate<={ ts'").append(sdf.format(pkEndDate.getValue())).append("'}")
//		.append(" and FBillStatus=4")
//		.append(" order by tbill.fbizdate desc,tbill.fcreatetime desc");
//		IRowSet rs;
//		try {
//			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
//			IRow row;
//			while(rs.next()) {
//				row=kDTable1.addRow();
//				row.getCell("id").setValue(rs.getString("fid"));
//				row.getCell("number").setValue(rs.getString("fnumber"));
//				row.getCell("bizDate").setValue(rs.getString("fbizdate"));
//				row.getCell("farmer").setValue(rs.getString("fname"));
//				row.getCell("amount").setValue(rs.getBigDecimal("FAmount").setScale(2,BigDecimal.ROUND_HALF_UP));
//				row.getCell("qcRate").setValue(rs.getBigDecimal("FQualityRate").setScale(2,BigDecimal.ROUND_HALF_UP));
//				row.getCell("brokenRate").setValue(rs.getBigDecimal("FBadRate").setScale(2,BigDecimal.ROUND_HALF_UP));
//				row.getCell("count").setValue(rs.getInt("fcount"));
//				if(printCount<=rs.getInt("fcount")) {
//					row.getStyleAttributes().setBackground(Color.LIGHT_GRAY);
//				}
//				//行高
//				this.kDTable1.getBody().setRowHeight(row.getRowIndex(), 30);
//			}
//			if(rs.size()>0){
//				loadBillToPanel(0);
//				//				MsgBox.showInfo("查询完成！");
//			}else {
//				MsgBox.showInfo("未查询到相关数据！");
//			}
//		} catch (Exception e) {
//			handleException(e);
//		}
//
//	}
//
//	/**
//	 * 定时任务
//	 * @author Administrator
//	 *
//	 */
//	private class ReadTimer implements Runnable{
//		private int ret;
//		public void run() {
//			if(!isOpened) {
//				while(true) {
//					if(opPort()==1){
//						break;
//					}
//					try {
//						Thread.currentThread().sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			while(true) {
//				try {
//					ret=nUtils.CVR_Authenticate();
//				} catch (Exception e) {
//					handleException(e);
//				}
//				System.out.println("身份认证："+ret);
//				//端口没打开
//				if(ret==4) {
//					opPort();
//					continue;
//				}
//				//没有身份证
//				if(ret==0) {
//					setQueryDate();
//				}
//				try {
//					ret=nUtils.CVR_Read_Content(2);
//				} catch (Exception e) {
//					handleException(e);
//				}
//				System.out.println("读卡："+ret);
//				try {
//					ret = nUtils.GetPeopleIDCode();//
//				} catch (Exception e) {
//					handleException(e);
//				}
//				identityID=nUtils.getStrTmp().trim();
//				System.out.println("获取身份证号："+ret+","+identityID);
//				if(org.apache.commons.lang.StringUtils.isNotBlank(nUtils.getStrTmp())) {
//					exeQuery(true);
//				}
//				try {
//					ret = nUtils.GetPeopleName();//
//				} catch (Exception e) {
//					handleException(e);
//				}
//				personName=nUtils.getStrTmp().trim();
//				System.out.println("获取姓名："+ret+","+identityID);
//				try {
//					Thread.currentThread().sleep(300);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	/**
//	 * 打开端口
//	 */
//	private int opPort() {
//		int ret=0;
//		try {
//			ret=nUtils.CVR_InitComm(1001);
//			if(ret==1) {
//				isOpened=true;
//			}
//		} catch (Exception e) {
//			handleException(e);
//		} 
//		System.out.println("打开端口："+ret);
//		return ret;
//	}
//
//	/**
//	 * 打开端口
//	 */
//	private void closePort() {
//		readerThread.suspend();
//		int ret=0;
//		try {
//			if(isOpened) {
//				ret=nUtils.CVR_CloseComm();
//			}
//		} catch (Exception e) {
//			handleException(e);
//		} 
//		isOpened=false;
//		System.out.println("关闭端口："+ret);
//	}
//}