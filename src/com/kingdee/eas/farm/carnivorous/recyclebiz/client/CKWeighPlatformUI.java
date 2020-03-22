/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingConstants;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetail;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetailCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetailFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetailInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail;
import com.kingdee.eas.fi.gl.InitException;
import com.kingdee.eas.fm.fs.client.AmusementUI.WeightBall;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.IBTPBillEdit;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.publicdata.CarType;
import com.kingdee.eas.publicdata.CardReaderFactory;
import com.kingdee.eas.publicdata.CardReaderInfo;
import com.kingdee.eas.publicdata.CardRelationCollection;
import com.kingdee.eas.publicdata.CardRelationFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.F7SelectBillInfo;
import com.kingdee.eas.weighbridge.ICommSqlFacade;

import com.kingdee.eas.weighbridge.WSWeighbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBaseType;
import com.kingdee.eas.weighbridge.WeighBillType;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.WeighBridgeFactory;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;
import com.kingdee.eas.weighbridge.WeighLogInfo;
import com.kingdee.eas.weighbridge.WeighType;
import com.kingdee.eas.weighbridge.weightbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import com.kingdee.eas.weighbridge.client.F7TransOrderListUI;
import com.kingdee.eas.weighbridge.client.SelectSourceOrderUI;
import com.kingdee.eas.weighbridge.comm.BTPBillEditImplEx;
import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CKWeighPlatformUI extends AbstractCKWeighPlatformUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKWeighPlatformUI.class);
	public static String recCK_bill = "CSlaughterBill";//ë����������
	private CKWeightBillInfo editData;// ���񵥻�������
	public final static String billTable = "CT_FM_CKWeightBill";// ���񵥱�
	public final static String billEntryTable = "CT_FM_CKWeightBillEntry";// ���񵥷�¼��
	public final static String billDetailTable = "CT_FM_CKWeightBillEntryDetail";// ������ϸ��
	private final static String carTable = "CT_PUB_Car";// ���񵥷�¼��
	private KDWorkButton btnBeginRead;
	private KDWorkButton btnEndRead;
	//private KDWorkButton btnModifyImpurity;
	private WeighBaseStatus oldBillStatus;
	private IBTPBillEdit billEdit;
	private Boolean isWeighted;//�Ƿ����
	private HashMap<String, Object> initParams;//��ʼ������
	private HashSet<String> weighTypeSet;//ҵ�����ͼ���

	private carDataChangeListenerClass carDataChangeListener;
	private IBTPManager iBTPManager;
	private ExecutorService pool;//com��ȡ�̳߳�
	private Boolean isNeedRead;
	private Boolean isNeedExit;
	//�޸� ���ػ���
	BigDecimal oldImpurity;
	BigDecimal oldSuttle;
	BigDecimal OldImpurity2;
	String oldRemark;
	// ��¼�Ƿ�ʧȥ���� ���ⶩ�� �س��� �����ť �ظ������¼�
	private boolean orderFocusLost = false;
	WeighBridgeInfo bridgeInfo ;
	// ������ֵ��ÿ�γ���ȷ�Ϻ���� ���ֶ�ֵΪ������ʾ��ֵ
	private BigDecimal weightValue;
	
	/**
	 * output class constructor
	 */
	public CKWeighPlatformUI() throws Exception{
		super();
		btnBeginRead = new KDWorkButton("��ȡ");
		btnBeginRead.setName("btnBegin");
		btnBeginRead.setEnabled(true);
		btnEndRead = new KDWorkButton("ֹͣ");
		btnEndRead.setName("btnEnd");
		btnEndRead.setEnabled(false);
	}

	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		StorageOrgUnitInfo storageUnitOrg = SysContext.getSysContext().getCurrentStorageUnit();
		if(storageUnitOrg!=null&&!storageUnitOrg.isIsBizUnit()) {
			MsgBox.showWarning("��ʵ������֯�����������");
			SysUtil.abort();
		}
		initData();
		initControl();
		beginComReaderNew();
	}

	/**
	 * ��ʼ��׃��
	 */
	private void initData() throws Exception {
		editData = null;
		isWeighted=false;
		isNeedRead=true;
		isNeedExit=false;
		carDataChangeListener=new carDataChangeListenerClass();
		pool=Executors.newCachedThreadPool();

		iBTPManager = null;
		if (getMainOrgContext() == null) {
			iBTPManager = BTPManagerFactory.getRemoteInstance();
		} else {
			iBTPManager = BTPManagerFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
		}
		billEdit = new BTPBillEditImplEx(this);
		billEdit.init();
		String settingID=null;
		settingID=setComReadPort();

		weighTypeSet=new HashSet<String>();
		initParams=new HashMap<String,Object>();
		initParams.put("weighBaseType",null);//������ʽ
		initParams.put("weighBizType",null);//ҵ������
		if(StringUtils.isNotBlank(settingID)) {//���ò�Ϊ��
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.CFDefaultWeighType,tentry.CFDefaultBizType,tentry.CFIsAuto2Inv,tmentry.CFMaterialID,");
			sql.append(" tentry.CFIsAuto2Inv");
			sql.append(" from CT_WHB_SettingEntrys tentry ");
			sql.append(" left join CT_WHB_SettingMaterialEntrys tmentry on tmentry.FParentID=tentry.FID");
			sql.append(" where tentry.FParentID=? and tentry.CFWeighBillType=?");
			IRowSet rs=getSqlInstance().executeQuery(sql.toString(), new Object[]{settingID,WeighBillType.ckWeightBill.getValue()});
			while(rs.next()){
				if(rs.getRow()==1) {
					initParams.put("weighBaseType", rs.getString("CFDefaultWeighType"));
					initParams.put("weighBizType", rs.getString("CFDefaultBizType"));
				}
				weighTypeSet.add(rs.getString("CFDefaultBizType"));
			}
			rs.close();
		}
	}

	/**
	 * �O��COMͨӍ�
	 * 
	 * @throws UnknownHostException
	 * @throws SocketException
	 * */
	private String setComReadPort() throws Exception {
		String id=null;//����id
		String macAddress = ComReaderUtils.getLocalMac();
		final IRowSet rs = getSqlInstance().executeQuery(" select * from CT_WHB_Setting where CFmac=?",
				new Object[] { macAddress });
		if (rs.next()) {
			id=rs.getString("fid");
			bridgeInfo = WeighBridgeFactory.getRemoteInstance().getWeighBridgeInfo(new ObjectUuidPK(rs.getString("CFWeighbridgeID")));
			pool.execute(new Thread(){
				WeighBridgeInfo info = WeighBridgeFactory.getRemoteInstance().getWeighBridgeInfo(new ObjectUuidPK(rs.getString("CFWeighbridgeID")));
				ComReaderUtils cr=new ComReaderUtils(info,rs.getInt("FMaxCount"));
				String returnValue;
				public void run() {
					while (true) {
						try {
							Thread.currentThread().sleep(400);
							if(isNeedRead) {
								//�򿪶˿�
								if(cr!=null&&!cr.isOpened()){
									try {
										cr.openPort();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								//��ȡ����
								returnValue=cr.getPortData();
								if (StringUtils.isNotBlank(returnValue)) {
									ChangeShowLable(returnValue);
								}
							}else {
								ChangeShowLable("����ȡ");
								if(cr!=null&&cr.isOpened()){
									try {
										cr.closePort();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(isNeedExit) {
								Thread.currentThread().destroy();
							}
						} catch (BOSException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		} else {
			MsgBox.showWarning("������ֵʧ�ܣ��������ã�");
		}
		rs.close();
		return id;
	}



	public Boolean getIsNeedRead() {
		return isNeedRead;
	}

	public synchronized void setIsNeedRead(Boolean isNeedRead) {
		this.isNeedRead = isNeedRead;
	}


	/**
	 * ���ݵ��ݱ������ó����ֶ�
	 * @throws BOSException 
	 */
	public synchronized void ChangeCarBycardNumber(String cardNumber) throws BOSException {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number",cardNumber,CompareType.EQUALS));
		filter.setMaskString("#0");
		ev.setFilter(filter);
		CardRelationCollection cardCol=CardRelationFactory.getRemoteInstance().getCardRelationCollection(ev);
		if(cardCol!=null&&cardCol.size()>0) {
			loadDataByCar(cardCol.get(0).getBaseData());
		}else {
			MsgBox.showWarning("û�ж�Ӧ�ĳ�����Ϣ��");
		}
	}
	/**
	 * ���ݳ���id�������һ�Ÿĳ�û����ɵĹ���
	 */
	private void loadDataByCar(CarInfo carInfo) {
		try {
			OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
			IRowSet rs=getExeQueryRowSet(orgInfo,null,carInfo.getId().toString()," and CFBillStatus<3",this.txtCarNum.getText());
			if(rs.next()) {
				setNewBillInfo(rs.getString("FID"));
				LoadFields(null);
			}else {
				editData = new CKWeightBillInfo();
				HashMap map=new HashMap();
				map.put("carInfo", CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(carInfo.getId())));
				LoadFields(map);
				initControlDeafultValue();
			}
			rs.next();
		}catch(Exception e) {
			super.handleException(e);
		}
	}

	/**
	 * ���ݵ��ݱ������ó���
	 * @throws BOSException 
	 */
	private synchronized  void ChangeShowLable(String value) throws BOSException {
		this.labShowWeight.setText(value);
	}


	/**
	 * �õ�SQLִ�ж���
	 * 
	 * @return
	 * @throws BOSException
	 */
	private ICommSqlFacade getSqlInstance() throws BOSException {
		return CommSqlFacadeFactory.getRemoteInstance();
	}

	/**
	 * �Q��
	 */
	protected void btnWeight_actionPerformed(ActionEvent e) throws Exception {

		String txtShow =this.labShowWeight.getText();
		//����ʱ
		//txtShow ="390000";
		if (StringUtils.isBlank(txtShow)) {
			MsgBox.showWarning("������ֵʧ�ܣ��������ã�");
			SysUtil.abort();
		}
		try {
			Double.parseDouble(txtShow);
		} catch (Exception ee) {
			MsgBox.showWarning("������ֵʧ�ܣ��������ã�");
			SysUtil.abort();
		}
		BigDecimal nowWeigh = new BigDecimal(txtShow);
		if (editData!=null&&editData.getId() != null) {// �ѱ��浥�� ���ݵ���״̬�͹�����ʽ�ж�
			BigDecimal grossQty=this.txtGross.getBigDecimalValue();
			if(grossQty==null) {
				grossQty=BigDecimal.ZERO;
			}
			BigDecimal tareQty=this.txtTare.getBigDecimalValue();
			if(tareQty==null) {
				tareQty=BigDecimal.ZERO;
			}
			if (editData.getWeighType().equals(WeighBaseType.Tare2Gross)) {// ������ʽ
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// ����{
					this.txtTare.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {// �ѹ�Ƥ��
					this.txtGross.setValue(nowWeigh);
					this.txtSuttle.setValue(nowWeigh.subtract(tareQty));
				} 
			} else if (editData.getWeighType().equals(WeighBaseType.Gross2Tare)) {
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// ����{
					this.txtGross.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {// �ѹ�ë��
					this.txtTare.setValue(nowWeigh);
					this.txtSuttle.setValue(grossQty.subtract(nowWeigh));
				}
			} 
		} else {// �µ��� ���ݹ�����ʽ�ж�
			if (this.cmbWeightType.getSelectedItem()==WeighBaseType.Tare2Gross) {
				this.txtTare.setValue(nowWeigh);
			} else if (this.cmbWeightType.getSelectedItem()==WeighBaseType.Gross2Tare) {
				this.txtGross.setValue(nowWeigh);
			}
		}
		isWeighted=true;

		// �ݴ������ֵ
		weightValue = nowWeigh.add(BigDecimal.ZERO);
	}

	/**
	 * ����
	 */

	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		this.execQuery();
		this.resetBill();
		this.setNextMessageText("����");
		showMessage();
	}

	/**
	 * ��ʼ���ؼ�
	 * 
	 * @throws BOSException
	 */
	private void initControl() throws BOSException {

		this.setUITitle("��˾��������ƽ̨");
		this.setIsShowTextOnly(true);
		setShowMessagePolicy(2);

		this.dpInTime.setTimeEnabled(true);
		this.dpOutTime.setTimeEnabled(true);
		this.txtNumber.setEnabled(false);
		this.dpBizDate.setEnabled(false);
		this.txtTare.setEnabled(false);
		this.txtGross.setEnabled(false);
		this.txtSuttle.setEnabled(false);
		this.QBeginDate.setDatePattern("yyyy-MM-dd");
		this.QEndDate.setDatePattern("yyyy-MM-dd");
		this.QBeginDate.setSupportedEmpty(false);
		this.QEndDate.setSupportedEmpty(false);

		this.cmbBizType.removeAllItems();
		for(String set:weighTypeSet){
			this.cmbBizType.addItem(WeighBizType.getEnum(set));
		}
		this.txtTare.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtGross.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtSuttle.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtTare.setDataType(1);
		this.txtTare.setPrecision(4);
		this.txtGross.setDataType(1);
		this.txtGross.setPrecision(4);
		this.txtSuttle.setDataType(1);
		this.txtSuttle.setPrecision(4);

		this.prmtCar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
		this.prmtCar.setRequired(true);
		this.prmtCar.setEditFormat("$number$");
		this.prmtCar.setCommitFormat("$number$");
		this.prmtCar.setDisplayFormat("$number$");
		this.prmtCar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.publicdata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.publicdata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner", javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true, ctx);
					prmtCar.setSelector(prmtcar_F7ListUI);
				}
			}
		});

		this.tbList.checkParsed();
		this.tbList.getStyleAttributes().setLocked(true);
		this.tbList.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.tbList.addKDTMouseListener(new KDTMouseListener() {
			public void tableClicked(KDTMouseEvent e) {
				if (e.getClickCount() == 2) {
					tbList_clicked(e);
				}
			}
		});

		this.kDSeparator2.setVisible(true);

		this.cmbWeightType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (cmbWeightType.getSelectedItem().equals(WeighBaseType.Tare2Gross)) {
					txtTare.setValue(BigDecimal.ZERO);
					txtGross.setValue(BigDecimal.ZERO);
					txtSuttle.setValue(BigDecimal.ZERO);
				} else if (cmbWeightType.getSelectedItem().equals(WeighBaseType.Gross2Tare)) {
					txtTare.setValue(BigDecimal.ZERO);
					txtGross.setValue(BigDecimal.ZERO);
					txtSuttle.setValue(BigDecimal.ZERO);
				} 
			}
		});

		this.menuItemEdit.setVisible(false);
		this.menuItemRemove.setVisible(false);
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			if (!(this.toolBar.getComponent(i) instanceof KDWorkButton)) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnAddNew")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnSave")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnPrint")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnPrintPreview")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("cancel")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnTraceUp")) {
				this.btnTraceUp.setEnabled(true);
				this.btnTraceUp.setVisible(true);
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnTraceDown")) {
				this.btnTraceDown.setEnabled(true);
				this.btnTraceDown.setVisible(true);
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnCreateFrom")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnCreateTo")) {
				this.btnCreateTo.setVisible(true);
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnSaveWeigh")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnCancel")) {
				this.btnCancel.setVisible(true);
				this.btnCancel.setEnabled(true);
				this.btnCancel.setToolTipText("����");
				this.btnCancel.setText("����");
				continue;
			}
			this.toolBar.getComponent(i).setVisible(false);
		}

		btnBeginRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					beginComReaderNew();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEndRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//stopComReader();
				stopComReaderNew(false);
			}
		});

		this.toolBar.add(btnBeginRead);
		this.toolBar.add(btnEndRead);
		this.cmbQueryBillStatus.addItem("ȫ��");
		this.cmbQueryBillStatus.setSelectedIndex(-1);

		this.txtCarNum.setRequired(true);

		this.chkIsTemp.setEnabled(true);
		this.chkIsTemp.setVisible(true);
		this.chkIsTemp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				isTempChanged();
			}});

		this.cmbBizType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				cmbBizType_changed();
			}
		});
		initWeighBillEntry();
	}

	//ҵ�����͸ı䷽��
	private void cmbBizType_changed() {
		initWeighBillEntry();
		if(cmbBizType.getSelectedItem()!=null){
			try {
				String	macAddress = ComReaderUtils.getLocalMac();
				WeighBaseType weighType = WeighbridgeCommUtils.getWeighType(null, macAddress, WeighBillType.ckWeightBill, (WeighBizType)cmbBizType.getSelectedItem());
				cmbWeightType.setSelectedItem(weighType);
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

		}
	}

	//�Ƿ���ʱ�����ı��¼�
	private void isTempChanged(){
		if(this.chkIsTemp.isSelected()) {//ѡ��
			this.prmtCar.setValue(null);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
		}else {
			this.txtCarNum.setText(null);
			this.contCar.setVisible(true);
			this.contCarNum.setVisible(false);
		}
	};

	/**
	 * �����ɹ��������б�
	 */
	protected void btnShowOrder_actionPerformed(ActionEvent e) throws Exception {
		if (cmbBizType.getSelectedItem()==null) {
			MsgBox.showWarning("ҵ�����Ͳ���Ϊ�գ�");
			SysUtil.abort();
		}
		if (!this.chkIsTemp.isSelected()&&this.prmtCar.getValue() == null) {
			MsgBox.showWarning("��������Ϊ�գ�");
			SysUtil.abort();
		}
		if (this.chkIsTemp.isSelected()&&StringUtils.isBlank(this.txtCarNum.getText())) {
			MsgBox.showWarning("���ƺŲ���Ϊ�գ�");
			SysUtil.abort();
		}
		// �س� ������  ����ִ�� ��� ����
		if(e == null || (e != null && !orderFocusLost)){
			String carNumber = this.txtCarNum.getText();
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date curDate = sdf.parse(sdf.format(new Date()));
				String endDateStr = sdf.format(curDate);
				if(cmbBizType.getSelectedItem()==WeighBizType.RecCK){
					Calendar endCal = Calendar.getInstance();
					endCal.setTime(curDate);
					endCal.add(Calendar.DATE, 7);
					endDateStr=sdf.format(endCal.getTime());
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(curDate);
				cal.add(Calendar.DATE, -7);
				Date beginDate = cal.getTime();
				String beginDateStr = sdf.format(beginDate);

				Map<String,OrderWeightInfo> orderMaps = null;
				Map conditions=new HashMap<String, Object>();
				conditions.put("carNumber", carNumber);
				conditions.put("beginDateStr", beginDateStr);
				conditions.put("endDateStr", endDateStr);
				if(this.cmbBizType.getSelectedItem().equals(WeighBizType.RecCK)){
//					orderMaps = weightbridgeFacadeFactory.getRemoteInstance().getBillOrOrder(recCK_bill,conditions);
				}else{
					//��������					
				}	
				ArrayList orderInfoList = getWeightOrder(orderMaps);
				if (orderInfoList != null && orderInfoList.size() > 0) {
					// ���� ��˾��������
					if (this.editData == null) {
						this.setOprtState(OprtState.ADDNEW);
					} else {
						this.setOprtState(OprtState.EDIT);
					}
					this.editData = getNewWeightInBill(this.editData,orderInfoList);
				}
			}catch(BOSException bose){
				bose.printStackTrace();
				MsgBox.showWarning(bose.getMessage());
			}finally{
				orderFocusLost = false;
			}
			orderFocusLost = false;
		}
	}

	/**
	 * ���ֻ��һ�� ��ֱ�ӷ��� ���򵯳����˽��� ���û�ѡ��
	 * 
	 * @param orderMaps
	 * @return
	 * @throws UIException
	 */
	private ArrayList getWeightOrder(Map orderMaps) throws UIException {
		// ֻ��һ��ʱ ֱ�ӷ��� ���򵯳�����ѡ�񣬻������²�ѯ
		String carNumber = this.txtCarNum.getText();
		if (orderMaps != null && orderMaps.size() == 1) {
			ArrayList orderInfoList = new ArrayList();
			orderInfoList.add(orderMaps.values().toArray()[0]);
			return orderInfoList;
		}
		if (orderMaps == null || orderMaps.size() != 1) {
			Date curDate = new Date();
			UIContext uiContext = new UIContext(ui);
			uiContext.put("orderMaps", orderMaps);
			uiContext.put("curDate", curDate);
			uiContext.put("carNumber", carNumber);
			//ë������
			if(cmbBizType.getSelectedItem()==WeighBizType.RecCK){			
				uiContext.put("orderType", SelectSourceOrderUI.recCK_bill);
			}
			IUIWindow window = null;
			window = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.weighbridge.client.SelectSourceOrderUI",uiContext, null, OprtState.ADDNEW);
			window.show();
			Map selectUICtx = window.getUIObject().getUIContext();
			if (selectUICtx != null) {
				return (ArrayList) selectUICtx.get("orderInfoList");
			}
		}
		return null;
	}
	/**
	 * ���ݶ�����װ ��������� �����µ���
	 * @return
	 */
	private CKWeightBillInfo getNewWeightInBill(CKWeightBillInfo oldInfo,ArrayList orderInfoList) {
		CKWeightBillInfo ckWeightBillInfo = null;
		CKWeightBillEntryInfo entryInfo = null;
		if (oldInfo != null) {
			ckWeightBillInfo = oldInfo;
			if (oldInfo.getEntrys().size() > 0) {
				entryInfo = oldInfo.getEntrys().get(0);
			} else {
				entryInfo = new CKWeightBillEntryInfo();
			}
		} else {
			ckWeightBillInfo = new CKWeightBillInfo();
			ckWeightBillInfo.setId(BOSUuid.create(ckWeightBillInfo.getBOSType().toString()));//
			ckWeightBillInfo.setNumber(getAutoNumberByOrg("NONE"));
			ckWeightBillInfo.setCompany(SysContext.getSysContext().getCurrentFIUnit());
			ckWeightBillInfo.setBizDate((Date) this.dpBizDate.getValue());
			ckWeightBillInfo.setBillStatus(WeighBaseStatus.save);
			ckWeightBillInfo.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
			ckWeightBillInfo.setWeighman(SysContext.getSysContext().getCurrentUserInfo().getPerson());

			ckWeightBillInfo.setWeighType((WeighBaseType) cmbWeightType.getSelectedItem());
			ckWeightBillInfo.setBizType((WeighBizType) cmbBizType.getSelectedItem());

			ckWeightBillInfo.setCar((CarInfo) this.prmtCar.getValue());
			if (this.txtCarNum.getText() != null) {
				ckWeightBillInfo.setCarNum(this.txtCarNum.getText());
			}
			Date date = new Date();
			ckWeightBillInfo.setInTime(date);
			ckWeightBillInfo.setOutTime(date);
			entryInfo = new CKWeightBillEntryInfo();
			ckWeightBillInfo.getEntrys().add(entryInfo);
		}

		if (entryInfo.getDetail().size() > 0) {
			entryInfo.getDetail().clear();
		}
		if(cmbBizType.getSelectedItem()==WeighBizType.RecCK){	
			for (Object tempInfo : orderInfoList) {
				CSlaughterBillInfo weighInfo=(CSlaughterBillInfo) tempInfo;
				CKWeightBillEntryDetailInfo detailInfo = new CKWeightBillEntryDetailInfo();
				detailInfo.setSourceBillID(weighInfo.getId().toString());
				detailInfo.setSourceBillNum(weighInfo.getNumber());
				// ������ϸ��¼
				entryInfo.getDetail().add(detailInfo);
			}
		}
		//��ʼ���������ݷ�¼
		initWeighBillEntry();
		//���������ݷ�¼
		setWeighBillEntry(orderInfoList);
		return ckWeightBillInfo;
	}

	//��ʼ���������ݷ�¼
	private void initWeighBillEntry() {
		kdtBillEntrys.removeHeadRows();
		kdtBillEntrys.removeRows();
		kdtBillEntrys.removeColumns();
		kdtBillEntrys.getStyleAttributes().setLocked(true);
		if(cmbBizType.getSelectedItem()==WeighBizType.RecCK){				
			IRow headRow = kdtBillEntrys.addHeadRow();
			//ҵ�񵥺�
			IColumn billNumberCol = kdtBillEntrys.addColumn();
			billNumberCol.setKey("number");
			headRow.getCell("number").setValue("ҵ�񵥺�");
			//ҵ������
			IColumn bizDateCol = kdtBillEntrys.addColumn();
			bizDateCol.setKey("bizDate");
			headRow.getCell("bizDate").setValue("ҵ������");
			//��ֳ��
			IColumn farmerCol = kdtBillEntrys.addColumn();
			farmerCol.setKey("farmer");
			headRow.getCell("farmer").setValue("��ֳ��");
			//��ֳ��
			IColumn farmCol = kdtBillEntrys.addColumn();
			farmCol.setKey("farm");
			headRow.getCell("farm").setValue("��ֳ��");
			//���κ�ͬ
			IColumn contractCol = kdtBillEntrys.addColumn();
			contractCol.setKey("batchContract");
			headRow.getCell("batchContract").setValue("���κ�ͬ");
			//Ʒ��
			IColumn breedDataCol = kdtBillEntrys.addColumn();
			breedDataCol.setKey("breedData");
			headRow.getCell("breedData").setValue("Ʒ��");
			//��ǰ����
			IColumn prehouseWgtCol = kdtBillEntrys.addColumn();
			prehouseWgtCol.setKey("prehouseWgt");
			headRow.getCell("prehouseWgt").setValue("��ǰ����");
			//����
			IColumn carCol = kdtBillEntrys.addColumn();
			carCol.setKey("car");
			headRow.getCell("car").setValue("����");
			//˾��
			IColumn driverCol = kdtBillEntrys.addColumn();
			driverCol.setKey("driver");
			headRow.getCell("driver").setValue("˾��");
		}
	}


	//���������ݷ�¼
	private void setWeighBillEntry(ArrayList orderInfoList) {
		kdtBillEntrys.removeRows();
		if(cmbBizType.getSelectedItem()==WeighBizType.RecCK){		
			for (Object tempInfo : orderInfoList) {
				CSlaughterBillInfo weighInfo=(CSlaughterBillInfo) tempInfo;
				IRow newRow = kdtBillEntrys.addRow();
				newRow.getCell("number").setValue(weighInfo.getNumber());
				newRow.getCell("bizDate").setValue(weighInfo.getBizDate());
				newRow.getCell("farmer").setValue(weighInfo.getFarmer());
				newRow.getCell("farm").setValue(weighInfo.getFarm());
				newRow.getCell("batchContract").setValue(weighInfo.getBatchContract().getNumber());
				newRow.getCell("breedData").setValue(weighInfo.getBreedData());
				newRow.getCell("prehouseWgt").setValue(weighInfo.getPreHouseSuttle());
				newRow.getCell("car").setValue(weighInfo.getCar().getNumber());
				newRow.getCell("driver").setValue(weighInfo.getDriver().getDrivername());
			}
		}
	}


	public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception {
		this.setOprtState(STATUS_ADDNEW);
		this.billEdit.createFrom(getMainOrgContext());
		try{
			IObjectCollection destBillCols = (IObjectCollection) this.getUIContext().get("destBillCols");
			if(destBillCols!=null&&destBillCols.size()>0) {
				String entryID=null;
				CKWeightBillInfo head = (CKWeightBillInfo) destBillCols.getObject(0);
				if(head.getEntrys().size()>0) {
					entryID=head.getEntrys().get(head.getEntrys().size()-1).getId().toString();
				}
				this.editData=head;
				this.LoadFields(null);
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData==null||this.editData.getId()==null) {
			return;
		}
		billEdit.CreateTo(this.editData);
	}


	public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData==null||this.editData.getId()==null) {
			return;
		}
		this.billEdit.traceDown(editData);
	}


	public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData==null||this.editData.getId()==null) {
			return;
		}
		this.billEdit.traceUp(editData);
	}


	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData==null||this.editData.getId()==null)
			return;
		if(MsgBox.showConfirm2("�Ƿ����Ϲ��񵥣�")==MsgBox.OK) {
			IObjectPK pk = new ObjectUuidPK(this.editData.getId());
			getBizInterface().cancel(pk, this.editData);
			MsgBox.showInfo("�������");
		}
		this.execQuery();
	}


	/**
	 * �����ı�
	 * @param e
	 */
	private void prmtCar_Changed(DataChangeEvent e) {
		if (this.prmtCar.getValue() != null) {
			SelectorItemCollection slor =new SelectorItemCollection();
			slor.add("*");
			slor.add("Entry.*");
			slor.add("Entry.driver.*");
			try {
				CarInfo	car = CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)prmtCar.getValue()).getString("id")), slor);
				this.txtCarNum.setText(car.getNumber());
				CarEntryCollection carEntry=car.getEntry();
				for(int i=0;i<carEntry.size();i++){
					CarEntryInfo entry =carEntry.get(i);
					if(entry.isIsDefault()){
						txtDriver.setText(entry.getDriver().getDrivername());
						break;
					}
				}
			} catch (EASBizException e1) {
				e1.printStackTrace();
			} catch (BOSException e1) {
				e1.printStackTrace();
			}
		} else {
			this.txtCarNum.setText(null);
			txtDriver.setText(null);
		}
	}

	/**
	 * ���ص���
	 */
	protected void tbList_clicked(KDTMouseEvent e) {
		try {
			if (e.getRowIndex() < 0) {
				MsgBox.showWarning("��ѡ���¼��");
				return;
			}
			IRow row = this.tbList.getRow(e.getRowIndex());

			this.setNewBillInfo( row.getCell("id").getValue().toString());

			this.LoadFields(null);
			this.setMessageBarText("�鿴");
		} catch (Exception ee) {
			MsgBox.showError(ee.getMessage());
		}

	}

	/**
	 * �õ��I�ղ�������
	 * 
	 * @return
	 * @throws BOSException
	 */
	private ICKWeightBill getBizInstance() throws BOSException {
		return CKWeightBillFactory.getRemoteInstance();
	}

	private ICKWeightBillEntry getBizEntryInstance() throws BOSException {
		return CKWeightBillEntryFactory.getRemoteInstance();
	}

	private ICKWeightBillEntryDetail getBizEntryDetailInstance() throws BOSException {
		return CKWeightBillEntryDetailFactory.getRemoteInstance();
	}

	protected void btnAllSave_actionPerformed(ActionEvent e) throws Exception {
		btnSave_actionPerformed(e);
		execQuery();
	}

	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		this.btnSave_actionPerformed(e);
		execQuery();
	}

	/**
	 * ���õ��ݶ���ͽ���
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void resetBill() throws Exception {
		this.editData = null;
		this.LoadFields(null);
		initWeighBillEntry();	
		this.setSaved(false);
		this.setMessageBarText("����");
	}

	/**
	 * �����¼�
	 */
	protected void btnSave_actionPerformed(ActionEvent e) throws Exception {
		this.VerifyInput();
		//this.oldData=this.editData;
		this.StoreFields();
		try {
			IObjectPK pk=null;
			if(editData.getBillStatus().equals(WeighBaseStatus.finish)) {
				pk= this.getBizInstance().submit(editData);
			}else {
				pk = this.getBizInstance().save(this.editData);
			}		
			logger.info("NewCKWeightBillID:::::::"+pk);
			this.setSaved(true);
			saveWeighLog("��˾������-ҵ�����");
			MsgBox.showInfo("����ɹ���");
		} catch (Exception e1) {
			editData.setBillStatus(this.oldBillStatus);
			iBTPManager.removeAllRelation(this.editData);
			throw new BOSException(e1);
		}
		this.LoadFields(null);
		this.setMessageBarText("�鿴");
	}

	public synchronized void LoadFields(HashMap params) throws BOSException, EASBizException {
		isWeighted=false;
		this.removeDataChangeListeners();
		if (editData != null && editData.getId() != null) {
			this.txtNumber.setText(this.editData.getNumber());
			//�޸�-------���ع�������
			this.dpBizDate.setValue(this.editData.getBizDate());
			this.prmtCar.setValue(editData.getCar());
			this.txtCarNum.setText(editData.getCarNum());
			if(editData.getCar()==null){
				chkIsTemp.setSelected(true);
			}else{
				chkIsTemp.setSelected(false);
			}	
			
			this.txtDriver.setText(editData.getDriver());
			this.dpInTime.setValue(null);
			this.dpOutTime.setValue(null);
			this.cmbBizType.setSelectedItem(editData.getBizType());// ����ҵ������
			this.cmbBillStatus.setSelectedItem(editData.getBillStatus());
			if (editData.getWeighType()!=null) {// ������ʽ
				this.cmbWeightType.setSelectedItem(editData.getWeighType());
			}
			this.txtRemark.setText(this.editData.getDescription());


			ArrayList orderInfoList=new ArrayList();
			//������¼���ϡ��ۼӾ��غϼ�
			CKWeightBillEntryCollection entryCol = this.editData.getEntrys();
			BigDecimal sumSuttle=BigDecimal.ZERO;
			for(int i=0;i<entryCol.size();i++) {
				if(i==0) {
					this.txtMaterial.setText(entryCol.get(i).getMateiralName());

					this.txtTare.setValue(entryCol.get(i).getTare());
					this.txtGross.setValue(entryCol.get(i).getGross());
					if(entryCol.get(i).getSuttle()!=null) {
						sumSuttle=sumSuttle.add(entryCol.get(i).getSuttle());
					}
					if(entryCol.get(i).getWeighTime()!=null&&entryCol.get(i).getWeighTimeGross()!=null) {
						if(entryCol.get(i).getWeighTime().before(entryCol.get(i).getWeighTimeGross())) {
							this.dpInTime.setValue(entryCol.get(i).getWeighTime());
							this.dpOutTime.setValue(entryCol.get(i).getWeighTimeGross());
						}else {
							this.dpOutTime.setValue(entryCol.get(i).getWeighTime());
							this.dpInTime.setValue(entryCol.get(i).getWeighTimeGross());
						}
					}else {
						if(entryCol.get(i).getWeighTime()!=null) {
							this.dpInTime.setValue(entryCol.get(i).getWeighTime());
						}else {
							this.dpInTime.setValue(entryCol.get(i).getWeighTimeGross());
						}
					}

					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("farmer.*");
					slor.add("farm.*");
					slor.add("batchContract.*");
					slor.add("car.*");
					slor.add("driver.*");
					slor.add("breedData.*");
					for(int j=0;j<entryCol.get(i).getDetail().size();j++){
						String srcBillID=entryCol.get(i).getDetail().get(j).getSourceBillID();
						if(cmbBizType.getSelectedItem()==WeighBizType.RecCK){
							CSlaughterBillInfo info=CSlaughterBillFactory.getRemoteInstance().getCSlaughterBillInfo(new ObjectUuidPK(srcBillID),slor);
							orderInfoList.add(info);
						}
					}

				}
			}
			if(entryCol.size()<=0) {
				this.txtTare.setValue(BigDecimal.ZERO);
				this.txtGross.setValue(BigDecimal.ZERO);
			}
			this.txtSuttle.setValue(sumSuttle);

			//���ع������ݷ�¼
			setWeighBillEntry(orderInfoList);
		} else {
			this.txtNumber.setText(null);// ****��ȡ�µĵ��ݱ��룿
			this.dpBizDate.setValue(new java.util.Date());
			this.prmtCar.setValue(null);
			this.txtCarNum.setText(null);
			this.txtDriver.setText(null);
			this.txtMaterial.setText(null);
			this.chkIsTemp.setSelected(false);

			if(params!=null) {
				this.prmtCar.setValue(params.get("carInfo"));
				this.txtCarNum.setText(((CoreBaseInfo) params.get("carInfo")).getString("number"));
			}
			this.dpInTime.setValue(null);
			this.dpOutTime.setValue(null);
			this.cmbBillStatus.setSelectedItem(null);
			this.txtTare.setValue(BigDecimal.ZERO);
			this.txtGross.setValue(BigDecimal.ZERO);
			this.txtSuttle.setValue(BigDecimal.ZERO);
			this.txtRemark.setText(null);
		}

		selectControlLocked();
		this.addDataChangeListeners();
	}

	/**
	 * ɾ��������
	 */
	private void removeDataChangeListeners() {
		this.prmtCar.removeDataChangeListener(carDataChangeListener);
	}
	/**
	 * �����ı��¼�
	 */
	private class carDataChangeListenerClass implements DataChangeListener {
		public void dataChanged(DataChangeEvent e) {
			prmtCar_Changed(e);
		}
	}

	/* 
	 * ���Ӽ�����
	 */
	private void addDataChangeListeners(){
		this.prmtCar.addDataChangeListener(carDataChangeListener);	
	}

	/**
	 * �õ���ǰ��¼����
	 * @param entryID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void setNewBillInfo(String billID) throws EASBizException, BOSException {
		editData = null;
		if (StringUtils.isBlank(billID)) {
			editData = new CKWeightBillInfo();
			editData.setId(BOSUuid.create(editData.getBOSType().toString()));
			editData.setNumber(getAutoNumberByOrg("NONE"));
			editData.setCompany(SysContext.getSysContext().getCurrentFIUnit());
			editData.setId(BOSUuid.create(editData.getBOSType().toString()));
			editData.setBizDate((Date) this.dpBizDate.getValue());
			editData.setBillStatus(WeighBaseStatus.save);
			editData.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
			editData.setWeighman(SysContext.getSysContext().getCurrentUserInfo().getPerson());
		} else {
			SelectorItemCollection slors = new SelectorItemCollection();
			slors.add(new SelectorItemInfo("*"));
			slors.add(new SelectorItemInfo("car.*"));
			slors.add(new SelectorItemInfo("entrys.*"));
			slors.add(new SelectorItemInfo("entrys.Detail.*"));
			editData = this.getBizInstance().getCKWeightBillInfo(new ObjectUuidPK(billID), slors);
		}
	}

	/**
	 * ���ÿؼ�Ĭ��ֵ
	 */
	private synchronized void initControlDeafultValue() {
		if (this.initParams.get("weighBizType") != null) {// Ĭ��ҵ������ 
			this.cmbBizType.setSelectedItem(WeighBizType.getEnum(this.initParams.get("weighBizType").toString()));// ����Ĭ��ֵ
		}
		if (this.initParams.get("weighBaseType") != null) {// Ĭ�Ϲ�����ʽ
			this.cmbWeightType.setSelectedItem(WeighBaseType.getEnum((String) initParams.get("weighBaseType")));
		}
	}
	/*
	 * ���ÿؼ�������״̬
	 */
	private void selectControlLocked() {
		Boolean flag = true;
		if (this.editData != null && this.editData.getId() != null) {
			if(editData.getBillStatus()!=null&&!editData.getBillStatus().equals(WeighBaseStatus.save)) {//����״̬���ݿ��޸�
				flag=false;
			}
			if (editData.getBillStatus().equals(WeighBaseStatus.finish)||editData.getBillStatus().equals(WeighBaseStatus.qcFinish)||editData.getBillStatus().equals(WeighBaseStatus.audit)) {// �Ѿ������������
				this.txtRemark.setEnabled(false);
				this.btnWeight.setEnabled(false);
				this.btnSave.setEnabled(false);
				this.btnAllSave.setEnabled(false);
				this.cmbBizType.setEnabled(false);
				this.cmbWeightType.setEnabled(false);
			} else {
				this.txtRemark.setEnabled(true);
				this.btnWeight.setEnabled(true);
				this.btnSave.setEnabled(true);
				this.btnAllSave.setEnabled(true);		
				this.cmbBizType.setEnabled(true);
			}
		} else {
			this.txtRemark.setEnabled(true);
			this.btnWeight.setEnabled(true);
			this.btnSave.setEnabled(true);
			this.btnAllSave.setEnabled(true);
			this.cmbBizType.setEnabled(true);
		}
		if(this.editData != null && this.editData.getId() != null&&editData.getCar()==null) {
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
		}else {
			this.contCar.setVisible(true);
			this.contCarNum.setVisible(false);
		}
		this.cmbBizType.setEnabled(flag);
		this.chkIsTemp.setEnabled(flag);
		this.txtCarNum.setEnabled(flag);
		this.prmtCar.setEnabled(flag);
		this.txtDriver.setEnabled(flag);
		this.txtMaterial.setEnabled(flag);

		this.btnTraceUp.setEnabled(true);
		this.btnTraceDown.setEnabled(true);
		this.dpOutTime.setEnabled(false);
		this.dpInTime.setEnabled(false);
	}

	/**
	 * ������ֵ
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws SQLException
	 */
	public void StoreFields() throws EASBizException, BOSException, SQLException {
		if (editData == null || editData.getId() == null) {
			this.setNewBillInfo(null);
		}
		this.oldBillStatus=editData.getBillStatus();//����ɵĵ���״̬������ʧ�ܲ�����״̬����
		if(StringUtils.isBlank(editData.getNumber())) {
			editData.setNumber(getAutoNumberByOrg("NONE"));
		}

		editData.setCar((CarInfo) this.prmtCar.getValue());
		editData.setCarNum(this.txtCarNum.getText());
		editData.setDriver(txtDriver.getText());
		editData.setBizType((WeighBizType) this.cmbBizType.getSelectedItem());
		editData.setDescription(this.txtRemark.getText());
		if(editData.getStorageOrgUnit()==null) {
			editData.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		}
		if(SysContext.getSysContext().getCurrentFIUnit()==null) {
			editData.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		}
		if (cmbWeightType.getSelectedItem()!=null) {
			editData.setWeighType((WeighBaseType) cmbWeightType.getSelectedItem());
		}

		Date weighTime = new java.util.Date();
		if(editData.getInTime()==null){
			editData.setInTime(weighTime);
		}else{
			editData.setOutTime(weighTime);
		}
		
		String timeFlag="time";
		if (cmbWeightType.getSelectedItem()==WeighBaseType.Tare2Gross) {// Ƥ��-ë��
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.tare);
				timeFlag="weighTime";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
				editData.setBillStatus(WeighBaseStatus.finish);
				timeFlag="weighTimeGross";
			}
		}
		if (cmbWeightType.getSelectedItem()==WeighBaseType.Gross2Tare) {// ë��-Ƥ��
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.gross);
				timeFlag="weighTimeGross";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
				editData.setBillStatus(WeighBaseStatus.finish);
				timeFlag="weighTime";
			}
		}

		BigDecimal suttleQty=this.txtSuttle.getBigDecimalValue();
		if(suttleQty==null)
			suttleQty=BigDecimal.ZERO;
		if (this.editData.getEntrys().size() <= 0) {
			CKWeightBillEntryInfo entryInfo = new CKWeightBillEntryInfo();
			entryInfo.setMateiralName(txtMaterial.getText());
			entryInfo.setDate(timeFlag, new java.util.Date());
			entryInfo.setTare(this.txtTare.getBigDecimalValue());
			entryInfo.setGross(this.txtGross.getBigDecimalValue());
			entryInfo.setSuttle(suttleQty);
			this.editData.getEntrys().add(entryInfo);
		} else {				
			BigDecimal tempQty, weighQty, remainQty,orderQty,entryAddQty;
			remainQty = suttleQty;
			for (int i = 0; i < this.editData.getEntrys().size(); i++) {
				this.editData.getEntrys().get(i).setDate(timeFlag, weighTime);
				this.editData.getEntrys().get(i).setTare(this.txtTare.getBigDecimalValue());
				this.editData.getEntrys().get(i).setGross(this.txtGross.getBigDecimalValue());
				this.editData.getEntrys().get(i).setSuttle(suttleQty);
				/***********************wgj add У�����ι���ʱ�� ���ܼ��̫�̣��Ƿ���Ҫ����У�飿**************************/
				//				Date weighTime = this.editData.getEntrys().get(i).getWeighTime();
				//				Date weighTime2 = this.editData.getEntrys().get(i).getWeighTime2();
				//				Date weighTimeGross = this.editData.getEntrys().get(i).getWeighTimeGross();
				//				boolean isTooShort = WeighbridgeCommUtils.isWeightTimeTooShort(weighTime, weighTime2, weighTimeGross, WeighbridgeCommUtils.shortestMinutesBetweenTwoWeigh);
				//				
				//				if(isTooShort && MsgBox.showConfirm2("�ó������ι����������10���ӣ��Ƿ����������������������") != MsgBox.YES){
				//					SysUtil.abort();
				//				}
				/***********************wgj add У�����ι���ʱ�� ���ܼ��̫��**************************/
			}
		}
	}


	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		this.execQuery();
		this.resetBill();
	}

	public void onShow() throws Exception {
		super.onShow();
		this.execQuery();
		this.resetBill();
		initControlDeafultValue();
	}

	/**
	 * �������ݺϷ��Խ���
	 */
	protected void VerifyInput() throws Exception {
		if(cmbWeightType.getSelectedItem()==null){
			MsgBox.showWarning("�������Ͳ���Ϊ�գ�");
			SysUtil.abort();
		}
		if (cmbBizType.getSelectedItem()==null) {
			MsgBox.showWarning("ҵ�����Ͳ���Ϊ�գ�");
			SysUtil.abort();
		}
		if (!this.chkIsTemp.isSelected()&&this.prmtCar.getValue() == null) {
			MsgBox.showWarning("��������Ϊ�գ�");
			SysUtil.abort();
		}
		if (this.chkIsTemp.isSelected()&&StringUtils.isBlank(this.txtCarNum.getText())) {
			MsgBox.showWarning("���ƺŲ���Ϊ�գ�");
			SysUtil.abort();
		}

		if(WeighBizType.RecCK==cmbBizType.getSelectedItem()&&cmbBillStatus.getSelectedItem()!=null&&cmbBillStatus.getSelectedItem().equals(WeighBaseStatus.gross)){
			if(kdtBillEntrys.getRowCount()<=0){
				MsgBox.showWarning("ë����������ѡ�񵥾ݽ��й�����");
				SysUtil.abort();
			}
		}
		KDDatePicker dpDate1 = null, dpDate2 = null;
		String lblDate1 = null, lblDate2 = null;
		// ���˵ĳ�
		dpDate2 = this.dpOutTime;
		dpDate1 = this.dpInTime;
		lblDate2 = "����ʱ�䲻��Ϊ�գ�";
		lblDate1 = "�볧ʱ�䲻��Ϊ�գ�";
		//		if(!this.chkIsTemp.isSelected()) {
		//			CarType carType = ((CarInfo) this.prmtCar.getValue()).getCarType();
		//			if (carType.equals(CarType.ownCar)) {// �Լ��ĳ�
		//				dpDate1 = this.dpOutTime;
		//				dpDate2 = this.dpInTime;
		//				lblDate1 = "����ʱ�䲻��Ϊ�գ�";
		//				lblDate2 = "�볧ʱ�䲻��Ϊ�գ�";
		//			} else {// ���˵ĳ�
		//	//			dpDate2 = this.dpOutTime;
		//	//			dpDate1 = this.dpInTime;
		//	//			lblDate2 = "����ʱ�䲻��Ϊ�գ�";
		//	//			lblDate1 = "�볧ʱ�䲻��Ϊ�գ�";
		//			}
		//		}

		if (this.editData == null || this.editData.getId() == null) {
			if (StringUtils.isBlank(dpDate1.getText())) {
				//MsgBox.showWarning(lblDate1);
				//SysUtil.abort();
			}
		} else {
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				if (StringUtils.isBlank(dpDate1.getText())) {
					//MsgBox.showWarning(lblDate1 );
					//SysUtil.abort();
				}
			}
			if (this.cmbWeightType.getSelectedItem()==WeighBaseType.Tare2Gross) {// Ƥ��-ë��
				if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2);
						//SysUtil.abort();
					}
					//					this.checkOrderQty();
				}
			}
			if (this.cmbWeightType.getSelectedItem()==WeighBaseType.Gross2Tare) {// ë��-Ƥ��
				if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2 );
						//SysUtil.abort();
					}
					//					this.checkOrderQty();
				}
			}
		}
		if (!isWeighted) {
			MsgBox.showWarning("���ȳ��أ�");
			SysUtil.abort();
		}

	}

	/**
	 * ��������������
	 * 
	 * @throws SQLException
	 * @throws BOSException
	 */
	private void checkOrderQty() throws BOSException, SQLException {
		/**
		 * ���ѡ�񵥾ݲ�Ϊ�� ������������ʾ
		 */			
		Boolean  isExitSourceBill=false;
		BigDecimal suttleQty = this.txtSuttle.getBigDecimalValue();
		BigDecimal sumOrderQty = BigDecimal.ZERO;//��Դ�����ۼ�����
		if (suttleQty == null)
			suttleQty = BigDecimal.ZERO;
		for (int j = 0; j < this.editData.getEntrys().size(); j++) {
			CKWeightBillEntryDetailCollection detailCol = this.editData.getEntrys().get(j).getDetail();
			if (detailCol == null || detailCol.size() <= 0) {
				continue;
			}
			isExitSourceBill=true;
			BigDecimal weighQty, baseQty;
			for (int index = 0; index < detailCol.size(); index++) {
				baseQty = detailCol.get(index).getSourceEntryQty();// ��Դ���ݹ�������
				weighQty = WeighbridgeCommUtils.getWeighQty(detailCol.get(index).getSourceBillID(), detailCol
						.get(index).getSourceEntryID());// �ѹ�������
				if (baseQty == null) {
					baseQty = BigDecimal.ZERO;
				}
				sumOrderQty = baseQty.subtract(weighQty).add(sumOrderQty);
			}
		}
		if (isExitSourceBill&&sumOrderQty.compareTo(suttleQty) < 0) {
			if(MsgBox.showConfirm2("�����������ڹ������ݿɹ�����������ȷ�Ϲ�����") != MsgBox.YES){
				SysUtil.abort();
			}
		}
	}

	/**
	 * ���в�ԃ
	 * 
	 * @throws BOSException
	 * @throws SQLException
	 */
	private void execQuery() throws BOSException, SQLException {
		//this.btnModifyImpurity.setText("�޸Ŀ���");
		this.tbList.removeRows();
		OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		String beginDate = this.QBeginDate.getText();
		String endDate = this.QEndDate.getText();
		String carNumber=null;

		if(this.txtQcarnumber!=null) {
			carNumber=txtQcarnumber.getText();
		}
		String conditionStr=null;
		if(this.cmbQueryBillStatus.getSelectedIndex()>(-1)&&!this.cmbQueryBillStatus.getSelectedItem().toString().equals("ȫ��")) {
			conditionStr=new StringBuffer().append(" and tb.CFBillStatus=").append(((WeighBaseStatus)this.cmbQueryBillStatus.getSelectedItem()).getValue()).toString();
		}
		IRowSet rs=getExeQueryRowSet(orgInfo,beginDate,endDate,conditionStr,carNumber);
		IRow row;
		String billStatus;
		while (rs.next()) {
			row = this.tbList.addRow();
			row.getCell("id").setValue(rs.getString("FID"));
			row.getCell("orderNumber").setValue(rs.getString("orderNumber"));
			row.getCell("number").setValue(rs.getString("FNumber"));
			row.getCell("car").setValue(rs.getString("FCarNum"));
			row.getCell("storageOrgUnit").setValue(rs.getString("FStorageName"));
			row.getCell("supplier").setValue(rs.getString("FSupplierName"));

			if(rs.getString("CFInTime")!=null&&rs.getString("CFOutTime")!=null) {
				if(rs.getDate("CFInTime").before(rs.getDate("CFOutTime"))) {
					row.getCell("inTime").setValue(rs.getString("CFInTime"));
					row.getCell("outTime").setValue(rs.getString("CFOutTime"));
				}else {
					row.getCell("outTime").setValue(rs.getString("CFInTime"));
					row.getCell("inTime").setValue(rs.getString("CFOutTime"));
				}
			}else {
				if(rs.getString("CFInTime")!=null) {
					row.getCell("inTime").setValue(rs.getString("CFInTime"));
				}else {
					row.getCell("inTime").setValue(rs.getString("CFOutTime"));
				}
			}

			billStatus=rs.getString("CFBillStatus");
			row.getCell("billStatus").setValue(WeighBaseStatus.getEnum(billStatus).getAlias());
			row.getCell("materialName").setValue(rs.getString("FMaterialName"));
			row.getCell("tare").setValue(rs.getBigDecimal("CFTare"));
			row.getCell("gross").setValue(rs.getBigDecimal("CFGross"));
			row.getCell("driver").setValue(rs.getString("driver"));
			row.getCell("bizType").setValue(WeighBizType.getEnum(rs.getString("bizType")));
			row.getCell("weighType").setValue(WeighBaseType.getEnum(rs.getString("weighType")));
			row.getCell("remark").setValue(rs.getString("remark"));
			row.getCell("tare2").setValue(rs.getBigDecimal("CFTare2"));
			row.getCell("impurity").setValue(rs.getBigDecimal("CFImpurity"));
			row.getCell("impurity2").setValue(rs.getBigDecimal("CFImpurity2"));
			row.getCell("suttle").setValue(rs.getBigDecimal("CFSuttle"));
			row.getCell("bizDate").setValue(rs.getString("FBizDate").substring(0, 10));
			row.getCell("materialID").setValue(rs.getString("FMaterialID"));
			row.getCell("materialNum").setValue(rs.getString("FMaterialNum"));
			row.getCell("entryID").setValue(rs.getString("FEntryID"));
			if(WeighBaseStatus.getEnum(billStatus).getAlias().endsWith("���")) {
				row.getStyleAttributes().setBackground(new Color(165,231,92));
			}
		}
		rs.close();
	}

	private IRowSet getExeQueryRowSet(OrgUnitInfo orgInfo,String beginDate,String endDate,String otherCondition,String carNumber) throws BOSException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select tb.cfpurordernumber orderNumber,tb.FID,te.FID FEntryID,tm.FID FMaterialID,tm.FNumber FMaterialNum,te.CFMateiralName FMaterialName,tm.FModel,");
		sql.append(" tb.FBizDate,tcar.FNumber FCarNum,te.CFTare,te.CFGross,te.CFSuttle,tb.FNumber,");
		sql.append(" tb.CFDriver driver,tb.CFBizType bizType,tb.CFWeighType weighType,tb.FDescription remark,");
		sql.append(" te.CFTare2,te.CFImpurity,tsupplier.FName_l2 FSupplierName,te.CFWeighTime CFInTime,");
		sql.append(" te.CFWeighTimeGross CFOutTime,tb.CFBillStatus,tCurStorage.Fname_l2 FStorageName,te.CFImpurity2");
		sql.append(" from ").append(billTable).append(" tb");
		sql.append(" left join t_bd_supplier tSupplier on tSupplier.FID=tb.CFSupplierID");
		sql.append(" left join t_org_storage tCurStorage on tCurStorage.FID=tb.CFStorageOrgUnitID");
		sql.append(" inner join ").append(billEntryTable).append(" te on te.FParentID=tb.FID");
		sql.append(" inner join ").append(carTable).append(" tcar on tcar.FID=tb.CFCarID");
		sql.append(" left join t_bd_material tm on tm.FID=te.CFMaterialID");
		sql.append(" where (CFStorageOrgUnitID=?");
		if(orgInfo.isIsCompanyOrgUnit())
			sql.append(" or CFCompanyID='").append( orgInfo.getId().toString()).append("'");
		sql.append(" )");
		sql.append(" and tb.CFBillStatus!=3 ");//�����ϵ��� ,��һ�з�¼����
		if(StringUtils.isNotBlank(beginDate)) {
			sql.append(" and FBizDate>={ts '").append(beginDate).append(" 00:00:00'} ");
		}
		if(StringUtils.isNotBlank(endDate)) {
			sql.append(" and FBizDate<={ts '").append(endDate).append(" 23:59:59'} ");
		}

		if(StringUtils.isNotBlank(carNumber)) {
			sql.append(" and tb.CFCarNum like'%").append(carNumber).append("%'");;
		}
		if(StringUtils.isNotBlank(otherCondition)) {
			sql.append(otherCondition);
		}
		//sql.append(" order by tb.FBizDate desc,te.FSeq asc");
		//add 20150730
		sql.append(" union all");
		sql.append(" select tb.cfpurordernumber orderNumber,tb.FID,te.FID FEntryID,tm.FID FMaterialID,tm.FNumber FMaterialNum,te.CFMateiralName FMateiralName,tm.FModel,");
		sql.append(" tb.FBizDate,tb.CFCarNum FCarNum,te.CFTare,te.CFGross,te.CFSuttle,tb.FNumber,");
		sql.append(" tb.CFDriver driver,tb.CFBizType bizType,tb.CFWeighType weighType,tb.FDescription remark,");
		sql.append(" te.CFTare2,te.CFImpurity,tsupplier.FName_l2 FSupplierName,te.CFWeighTime CFInTime,");
		sql.append(" te.CFWeighTimeGross CFOutTime,tb.CFBillStatus,tCurStorage.Fname_l2 FStorageName,te.CFImpurity2");
		sql.append(" from ").append(billTable).append(" tb");
		sql.append(" left join t_bd_supplier tSupplier on tSupplier.FID=tb.CFSupplierID");
		sql.append(" left join t_org_storage tCurStorage on tCurStorage.FID=tb.CFStorageOrgUnitID");
		sql.append(" inner join ").append(billEntryTable).append(" te on te.FParentID=tb.FID");
		//		sql.append(" inner join ").append(carTable).append(" tcar on tcar.FID=tb.CFCarID");
		sql.append(" left join t_bd_material tm on tm.FID=te.CFMaterialID");
		sql.append(" where (CFStorageOrgUnitID=?");
		if(orgInfo.isIsCompanyOrgUnit())
			sql.append(" or CFCompanyID='").append( orgInfo.getId().toString()).append("'");
		sql.append(" )");
		sql.append(" and tb.CFBillStatus!=3 ");//�����ϵ��� ,��һ�з�¼����
		if(StringUtils.isNotBlank(beginDate)) {
			sql.append(" and FBizDate>={ts '").append(beginDate).append(" 00:00:00'} ");
		}
		if(StringUtils.isNotBlank(endDate)) {
			sql.append(" and FBizDate<={ts '").append(endDate).append(" 23:59:59'} ");
		}
		if(StringUtils.isNotBlank(carNumber)) {
			sql.append(" and tb.CFCarNum like '%").append(carNumber).append("%'");;
		}

		if(StringUtils.isNotBlank(otherCondition)) {
			sql.append(otherCondition);
		}
		sql.append(" and tb.CFCarID is null");
		sql.append(" order by FBizDate desc");
		//
		System.out.println(sql.toString());
		IRowSet rs = getSqlInstance().executeQuery(sql.toString(), new Object[] { orgInfo.getId().toString(),orgInfo.getId().toString() });
		return rs;
	}

	protected void disposeUIWindow() {
		// TODO Auto-generated method stub
		stopComReaderNew(true);
		super.disposeUIWindow();
	}

	private void stopComReaderNew(Boolean isClose) {
		setIsNeedRead(false);
		if(isClose&&pool!=null) {
			this.isNeedExit=true;
			this.pool.shutdown();
		}
		this.btnBeginRead.setEnabled(true);// ���ö�ȡ
		this.btnEndRead.setEnabled(false);
	}

	private void beginComReaderNew() {
		setIsNeedRead(true);
		this.btnBeginRead.setEnabled(false);// ���ö�ȡ
		this.btnEndRead.setEnabled(true);
	}


	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * output actionPrint_actionPerformed method
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		this.editData = this.editData;
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
			if(editData.getBillStatus()!=WeighBaseStatus.finish){
				MsgBox.showWarning("ֻ�ܴ�ӡ������ɵĵ��ݣ�");
				SysUtil.abort();
			}
			idList.add(editData.getString("id"));
		}
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
			return;
		com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(
				idList, getTDQueryPK());
		com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
		appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	/**
	 * output actionPrintPreview_actionPerformed method
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
		this.editData = this.editData;
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
			if(editData.getBillStatus()!=WeighBaseStatus.finish){
				MsgBox.showWarning("ֻ�ܴ�ӡ������ɵĵ��ݣ�");
				SysUtil.abort();
			}
			idList.add(editData.getString("id"));
		}
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
			return;
		com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(
				idList, getTDQueryPK());
		com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
		appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	protected String getTDFileName() {
		return "/bim/weighbridge/CKWeightBill";
	}

	protected IMetaDataPK getTDQueryPK() {
		return new MetaDataPK("com.kingdee.eas.weighbridge.app.CKWeightBillQuery");
	}

	public static void model_show(KDBizPromptBox promptBox, KDComboBox bizType) {
		String UICLASSNAME = "com.kingdee.eas.weighbridge.client.F7TransOrderListUI";
		Map map = new UIContext();
		if (bizType.getSelectedItem().equals(WeighBizType.Pur)) {
			map.put("BizBillType", F7TransOrderListUI.PURORDER_VALUE);
		} else {
			map.put("BizBillType", F7TransOrderListUI.TRANSIN_VALUE);
		}
		map.put("orgUnitID", SysContext.getSysContext().getCurrentPurchaseUnit() == null ? "" : SysContext
				.getSysContext().getCurrentPurchaseUnit().getId().toString());
		String type = OprtState.VIEW;
		try {
			IUIWindow uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(UICLASSNAME, map, null, type);
			promptBox.setSelector((F7TransOrderListUI) uiWindow.getUIObject());
			uiWindow.show();
			F7SelectBillInfo[] returnData = (F7SelectBillInfo[]) ((F7TransOrderListUI) uiWindow.getUIObject())
			.getData();
			promptBox.setValue(returnData);
		} catch (UIException e) {
			e.printStackTrace();
		}
	}

	protected String getAutoNumberByOrg(String orgType) {
		String number=null;
		editData=editData;
		if (editData == null) return number;
		if (editData.getNumber() == null) {
			try {
				String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
				}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if (iCodingRuleManager.isExist(editData, companyID)) {
					if (iCodingRuleManager.isAddView(editData, companyID)) {
						//editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
						editData.setCU(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentCtrlUnit());
						return iCodingRuleManager.getNumber(editData,companyID);
					}
					//txtNumber.setEnabled(false);
				}
			}
			catch (Exception e) {
				handUIException(e);
				this.oldData = editData;
				com.kingdee.eas.util.SysUtil.abort();
			} 
		} 
		else {
			if (editData.getNumber().trim().length() > 0) {
				// txtNumber.setText(editData.getNumber());
				number=editData.getNumber();
			}
		}
		return number;
	}


	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return CKWeightBillFactory.getRemoteInstance();
	}


	public ICoreBase getBillInterface() throws Exception {
		// TODO Auto-generated method stub
		return super.getBillInterface();
	}


	protected KDBizPromptBox getMainBizOrg() {
		return super.getMainBizOrg();
	}


	public CoreBillBaseInfo getEditData() {
		// TODO Auto-generated method stub
		return this.editData;
	}




	/**
	 * ������ؼ�¼
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void saveWeighLog(String dataSource) throws EASBizException, BOSException{

		try{
			WeighLogInfo logInfo = new WeighLogInfo();
			logInfo.setWeight(weightValue);
			logInfo.setCarNumber((CarInfo) this.prmtCar.getValue());
			logInfo.setOtherCarInfo(this.txtCarNum.getText());
			logInfo.setCompany(SysContext.getSysContext().getCurrentFIUnit());
			logInfo.setUser(SysContext.getSysContext().getCurrentUserInfo());
			logInfo.setDataSource(dataSource);
			logInfo.setPlatform(bridgeInfo);
			WeighbridgeCommUtils.addWeighLog(null, logInfo);
			weightValue = BigDecimal.ZERO;
		}catch(Exception e){
			e.printStackTrace();

		}
	}

	/**
	 * ������ؼ�¼
	 */
	protected void btnSaveWeigh_actionPerformed(ActionEvent e)throws Exception {
		String txtShow = this.labShowWeight.getText();
		if (StringUtils.isBlank(txtShow)) {
			MsgBox.showWarning("������ֵʧ�ܣ��������ã�");
			SysUtil.abort();
		}
		try {
			Double.parseDouble(txtShow);
		} catch (Exception ee) {
			MsgBox.showWarning("������ֵʧ�ܣ��������ã�");
			SysUtil.abort();
		}
		// ����
		weightValue = new BigDecimal(txtShow);

		// ��
		CarInfo carInfo = (CarInfo) this.prmtCar.getValue();
		String carNumber = this.txtCarNum.getText();
		if(carInfo == null && StringUtils.isBlank(carNumber)){
			MsgBox.showWarning("����д������Ϣ��");
			SysUtil.abort();
		}

		if(MsgBox.showConfirm2("ȷ�ϱ������������"+weightValue.toPlainString() + "?") == MsgBox.OK){
			saveWeighLog("��˾������-��������");
			MsgBox.showInfo("�����������");
		}

	}
}