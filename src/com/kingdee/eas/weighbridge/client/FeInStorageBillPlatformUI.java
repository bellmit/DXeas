/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
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
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
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
//import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.IBTPBillEdit;
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
import com.kingdee.eas.weighbridge.FeInStorageBillEntryCollection;
import com.kingdee.eas.weighbridge.FeInStorageBillEntryDetailCollection;
import com.kingdee.eas.weighbridge.FeInStorageBillEntryDetailFactory;
import com.kingdee.eas.weighbridge.FeInStorageBillEntryFactory;
import com.kingdee.eas.weighbridge.FeInStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.FeInStorageBillFactory;
import com.kingdee.eas.weighbridge.FeInStorageBillInfo;
import com.kingdee.eas.weighbridge.ICommSqlFacade;
import com.kingdee.eas.weighbridge.IFeInStorageBill;
import com.kingdee.eas.weighbridge.IFeInStorageBillEntry;
import com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail;
import com.kingdee.eas.weighbridge.WSWeighbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBaseType;
import com.kingdee.eas.weighbridge.WeighBillType;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.WeighBridgeFactory;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;
import com.kingdee.eas.weighbridge.WeighLogInfo;
import com.kingdee.eas.weighbridge.weightbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import com.kingdee.eas.weighbridge.comm.BTPBillEditImplEx;
import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FeInStorageBillPlatformUI extends AbstractFeInStorageBillPlatformUI
{
	private static final Logger logger = CoreUIObject.getLogger(InStorageBillPlatformUI.class);
	private FeInStorageBillInfo editData;// ���񵥻�������
	public final static String billTable = "CT_WHB_FeInStorageBill";// ���񵥱�
	public final static String billEntryTable = "CT_WHB_FeInStorageBillEntry";// ���񵥷�¼��
	public final static String billDetailTable = "CT_WHB_FeInSBED";// ������ϸ��
	private final static String carTable = "CT_PUB_Car";// ���񵥷�¼��
	private KDWorkButton btnBeginRead;
	private KDWorkButton btnEndRead;
	//private KDWorkButton btnModifyImpurity;
	private WeighBaseStatus oldBillStatus;
	private IBTPBillEdit billEdit;
	private Boolean isWeighted;//�Ƿ����
	private HashMap<String, Object> initParams;//��ʼ������
	private carDataChangeListenerClass carDataChangeListener;
	private imputityDataChangeListenerClass imputityDataChangeListener;
	private materialDataChangeListenerClass materialDataChangeListener;
	private IBTPManager iBTPManager;
	private ExecutorService pool;//com��ȡ�̳߳�
	private Boolean isNeedRead;
	private WeighBizType bizType=null;
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
	public FeInStorageBillPlatformUI() throws Exception {
		super();
		btnBeginRead = new KDWorkButton("��ȡ");
		btnBeginRead.setName("btnBegin");
		btnBeginRead.setEnabled(true);
		btnEndRead = new KDWorkButton("ֹͣ");
		btnEndRead.setName("btnEnd");
		btnEndRead.setEnabled(false);
//		btnModifyImpurity= new KDWorkButton("�޸Ŀ���");
//		btnModifyImpurity.setName("btnModifyImpurity");
//		btnModifyImpurity.setEnabled(true);
		//btnModifyImpurity.setIcon(EASResource.getIcon("imgTbtn_edit"));
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
		
		//yumingxu
		//this.prmtMaterial.setEditable(false);
		this.kDLabelContainer2.setEnabled(false);
		//yumingxu
		//this.contSupplier.setEditable(false);
		this.contSupplier.setEnabled(false);
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
		imputityDataChangeListener=new imputityDataChangeListenerClass();
		materialDataChangeListener=new materialDataChangeListenerClass();
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
		setCardReadComPort();
		
		initParams=new HashMap<String,Object>();
		initParams.put("weighBaseType",null);//������ʽ
		initParams.put("weighBizType",null);//ҵ������
		initParams.put("materialSet", null);//�����б�
		initParams.put("isAutoCreateToInvBill", false);//�Ƿ��Զ����ɳ����
		if(StringUtils.isNotBlank(settingID)) {//���ò�Ϊ��
			HashSet materialIDsSet=null;
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 tentry.CFDefaultWeighType,tentry.CFDefaultBizType,tentry.CFIsAuto2Inv,tmentry.CFMaterialID,");
			sql.append(" tentry.CFIsAuto2Inv");
			sql.append(" from CT_WHB_SettingEntrys tentry ");
			sql.append(" left join CT_WHB_SettingMaterialEntrys tmentry on tmentry.FParentID=tentry.FID");
			sql.append(" where tentry.FParentID=? and tentry.CFWeighBillType=?");
			IRowSet rs=getSqlInstance().executeQuery(sql.toString(), new Object[]{settingID,WeighBillType.inStorage.getValue()});
			while(rs.next()){
				if(rs.getRow()==1) {
					initParams.put("weighBaseType", rs.getString("CFDefaultWeighType"));
					initParams.put("weighBizType", rs.getString("CFDefaultBizType"));
					initParams.put("isAutoCreateToInvBill",rs.getBoolean("CFIsAuto2Inv"));
				}
				if(StringUtils.isNotBlank(rs.getString("CFMaterialID"))) {
					if(materialIDsSet==null)
						materialIDsSet=new HashSet();
					materialIDsSet.add(rs.getString("CFMaterialID"));
				}
			}
			rs.close();
			initParams.put("materialSet", materialIDsSet);//�����б�
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
				ComReaderUtils cr=new ComReaderUtils(info,1);
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
	 * �O��COMͨӍ�  ������
	 * 
	 * @throws UnknownHostException
	 * @throws SocketException
	 * */
	private String setCardReadComPort() throws Exception {
		String macAddress = ComReaderUtils.getLocalMac();
		final IRowSet rs = getSqlInstance().executeQuery(" select t2.CFCardID FID from CT_PUB_CardSetting t1 inner join CT_PUB_CardSettingEntry t2 on t2.FParentID=t1.FID where t1.CFmac=?",
				new Object[] { macAddress });
		while(rs.next()) {
			pool.execute(new Thread(){
				CardReaderInfo cardReaderInfo=CardReaderFactory.getRemoteInstance().getCardReaderInfo(new ObjectUuidPK(rs.getString("fid")));
				com.kingdee.eas.wlhlcomm.client.BaseComReaderUtils cr=new com.kingdee.eas.wlhlcomm.client.BaseComReaderUtils(cardReaderInfo);
				String returnValue;
				public void run() {
					while(true) {
						if(isNeedRead) {
							//�򿪶˿�
							if(cr!=null&&!cr.getIsOpened()){
								try {
									cr.openPortAutoRead();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							//��ȡ����
							returnValue=cr.getReturnValue();
							if (StringUtils.isNotBlank(returnValue)) {
								try {
									cr.setReturnValue(null);
									ChangeCarBycardNumber(returnValue);
								} catch (BOSException e) {
									e.printStackTrace();
								}
							}
						}else {
							if(cr!=null&&cr.getIsOpened()){
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
					}
				}
			});
		}
		rs.close();
		return null;
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
		  IRowSet rs=getExeQueryRowSet(orgInfo,null,null,null,carInfo.getId().toString()," and CFBillStatus<3",this.txtCarNum.getText());
		  if(rs.next()) {
			  setNewBillInfo(rs.getString("FID"));
			  LoadFields(null);
		  }else {
			  	editData = new FeInStorageBillInfo();
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
		//txtShow ="20";
		
		//txtShow ="50"; 
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
			BigDecimal impurityQty=this.txtImpurity.getBigDecimalValue();
			BigDecimal impurityQty2=this.txtImpurity2.getBigDecimalValue();
			BigDecimal QCQty=this.txtQCwgt.getBigDecimalValue();
			BigDecimal OtherWgt=this.txtOtherWgt.getBigDecimalValue();
			BigDecimal grossQty=this.txtGross.getBigDecimalValue();
			if(grossQty==null) {
				grossQty=BigDecimal.ZERO;
			}
			BigDecimal tareQty=this.txtTare.getBigDecimalValue();
			if(tareQty==null) {
				tareQty=BigDecimal.ZERO;
			}
			if(impurityQty==null) {
				impurityQty=BigDecimal.ZERO;
			}
			if(impurityQty2==null) {
				impurityQty2=BigDecimal.ZERO;
			}
			if (editData.getWeighType().equals(WeighBaseType.Tare2Gross)) {// ������ʽ
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// ����{
					this.txtTare.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {// �ѹ�Ƥ��
					this.txtGross.setValue(nowWeigh);
					this.txtSuttle.setValue((nowWeigh.subtract(tareQty)).subtract(impurityQty).subtract(impurityQty2).subtract(QCQty).subtract(OtherWgt));
				} 
			} else if (editData.getWeighType().equals(WeighBaseType.Gross2Tare)) {
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// ����{
					this.txtGross.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {// �ѹ�ë��
					this.txtTare.setValue(nowWeigh);
					//�����ʼ����
					//��׼������������14ˮ��=ʪ��������-��ʪ��������*��ʪ����ˮ��-��׼ˮ��*1.2/100��
					if(this.cmbBizType.getSelectedItem().equals(WeighBizType.localPur)){
						if(this.txtQCRate.getBigDecimalValue()!=null){	
						BigDecimal Suttle = BigDecimal.ZERO;
						BigDecimal GSuttle = BigDecimal.ZERO;
						BigDecimal SSuttle = BigDecimal.ZERO;
						Suttle = (grossQty.subtract(nowWeigh)).subtract(impurityQty).subtract(impurityQty2);
						SSuttle = Suttle.multiply(this.txtQCRate.getBigDecimalValue());
						GSuttle = Suttle.subtract(SSuttle).subtract(OtherWgt).setScale(0, BigDecimal.ROUND_HALF_UP);
						this.txtQCwgt.setValue(SSuttle);
						this.txtSuttle.setValue(GSuttle);
						}
					}else{
						this.txtSuttle.setValue((grossQty.subtract(nowWeigh)).subtract(impurityQty).subtract(impurityQty2).subtract(QCQty).subtract(OtherWgt));

					}
				}

			} else if (editData.getWeighType().equals(WeighBaseType.Tare2Gross2Tare)) {
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// ����{
					this.txtTare.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {// �ѹ�Ƥ��
					this.txtGross.setValue(nowWeigh);
				} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {// �ѹ�ë��
					this.txtTare2.setValue(nowWeigh);//���ξ���
					this.txtSuttle.setValue((grossQty.subtract(nowWeigh)).subtract(impurityQty).subtract(impurityQty2).subtract(QCQty).subtract(OtherWgt));
				}
			}
		} else {// �µ��� ���ݹ�����ʽ�ж�
			if (this.rdoTare2Gross.isSelected()) {
				this.txtTare.setValue(nowWeigh);
			} else if (this.rdoGross2Tare.isSelected()) {
				this.txtGross.setValue(nowWeigh);
			} else if (this.rdoTare2Gross2Tare.isSelected()) {
				this.txtTare.setValue(nowWeigh);
			}
		}
		isWeighted=true;
		
		// �ݴ������ֵ
		weightValue = nowWeigh.add(BigDecimal.ZERO);
		// this.impirityChanged();//���¼��㾻��
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
	 *  ʳƷ�� �ͻ��Զ���ؼ�����
	 */
	/**
	 * 
	 */
	private void customInitControl() {
		String orgName = SysContext.getSysContext().getCurrentOrgUnit().getName();
		if(orgName.indexOf("ʳƷ")==(-1)) {
			return;
		}
		this.contImpurity.setBoundLabelText("��������");
		this.contImpurity2.setBoundLabelText("��ɼ�����");
		this.contRemark.setBoundLabelText("��ɼ�����");
		this.txtRemark.setHorizontalAlignment(SwingConstants.RIGHT);
		this.tbList.checkParsed();
		this.tbList.getHead().getRow(0).getCell(this.tbList.getColumnIndex("impurity")).setValue("��������");
		this.tbList.getHead().getRow(0).getCell(this.tbList.getColumnIndex("impurity2")).setValue("��ɼ�����");
		this.txtRemark.setText("0");
		//ʳƷ�� ë��ר�� ��ֻ��¼������ ��С���� ��backspace
		this.txtRemark.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)||keyChar==46||keyChar==8){  
                      
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        });  
		this.txtRemark.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					try {
						impirityChanged(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			
		});
	}
	/**
	 * ��ʼ���ؼ�
	 * 
	 * @throws BOSException
	 */
	private void initControl() throws BOSException {
		
		this.setUITitle("������");
		this.cmbIsAuto2Inv.setVisible(false);
		this.setIsShowTextOnly(true);
		setShowMessagePolicy(2);

		this.dpInTime.setTimeEnabled(true);
		this.dpOutTime.setTimeEnabled(true);
		this.txtNumber.setEnabled(false);
		this.dpBizDate.setEnabled(false);
		this.txtTare.setEnabled(false);
		this.txtGross.setEnabled(false);
		this.txtSuttle.setEnabled(false);
//		this.txtModel.setEnabled(false);
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setSupportedEmpty(false);
		this.dpEndDate.setSupportedEmpty(false);

		this.txtTare.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtGross.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtSuttle.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtTare2.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtImpurity.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtImpurity2.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtQCwgt.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtOtherWgt.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtTare.setDataType(1);
		this.txtTare.setPrecision(4);
		this.txtGross.setDataType(1);
		this.txtGross.setPrecision(4);
		this.txtSuttle.setDataType(1);
		this.txtSuttle.setPrecision(4);
		this.txtTare2.setDataType(1);
		this.txtTare2.setPrecision(4);
		this.txtImpurity.setDataType(1);
		this.txtImpurity.setPrecision(4);
		this.txtImpurity2.setDataType(1);
		this.txtImpurity2.setPrecision(4);
		this.txtQCwgt.setEnabled(false);
		this.txtOtherWgt.setEnabled(true);
		F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, prmtMaterial);
		m7.setBaseFilter(new FilterInfo());
		this.prmtMaterial.setSelector(m7);
		this.prmtMaterial.setEditFormat("$number$");
		this.prmtMaterial.setCommitFormat("$number$");
		this.prmtMaterial.setDisplayFormat("$name$");
		this.prmtMaterial.setRequired(true);
		//yumingxu
		this.prmtMaterial.setEditable(false);
		this.prmtMaterial.setEnabled(false);
		
		this.prmtQueryMaterial.setSelector(m7);
		this.prmtQueryMaterial.setEditFormat("$number$");
		this.prmtQueryMaterial.setCommitFormat("$number$");
		this.prmtQueryMaterial.setDisplayFormat("$name$");
		
		this.prmtCar.setRequired(true);
		this.prmtCar.setEditFormat("$number$");
		this.prmtCar.setCommitFormat("$number$");
		this.prmtCar.setDisplayFormat("$number$");
		this.prmtCar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.publicdata.client.CarListUI prmtcar_F7ListUI = null;
			@Override
			public void willShow(SelectorEvent arg0) {
				// TODO Auto-generated method stub
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
		
		this.prmtQueryCar.setEditFormat("$number$");
		this.prmtQueryCar.setCommitFormat("$number$");
		this.prmtQueryCar.setDisplayFormat("$number$");
		this.prmtQueryCar.addSelectorListener(new SelectorListener() {
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
					prmtQueryCar.setSelector(prmtcar_F7ListUI);
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

		StorageBizUnitF7 storageUnitOrgF7 = new StorageBizUnitF7();
		this.prmtOrderStorageOrgUnit.setSelector(storageUnitOrgF7);
		this.prmtOrderStorageOrgUnit.setDisplayFormat("$name$");
		this.prmtOrderStorageOrgUnit.setEditFormat("$number$");
		this.prmtOrderStorageOrgUnit.setCommitFormat("$number$");
		this.prmtOrderStorageOrgUnit.setRequired(true);

		this.prmtSupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierQuery");
		this.prmtSupplier.setDisplayFormat("$name$");
		this.prmtSupplier.setEditFormat("$number$");
		this.prmtSupplier.setCommitFormat("$number$");
		this.prmtSupplier.setRequired(true);
		//yumingxu
		this.prmtSupplier.setEditable(false);
		this.prmtSupplier.setEnabled(false);
		this.contOrderStorageOrgUnit.setVisible(false);
		//this.contSupplier.setVisible(true);
		
		this.kDSeparator2.setVisible(true);

		this.cmbBizType.removeItem(WeighBizType.Sale);// �Ƴ����۵�ѡ��
		this.cmbBizType.removeItem(WeighBizType.TransOut);// �Ƴ����۵�ѡ��
		this.cmbBizType.removeItem(WeighBizType.GroupSale);// �Ƴ����۵�ѡ��
		this.cmbBizType.removeItem(WeighBizType.PUR_VALUE);// �Ƴ��ɹ��˻���ѡ��
		this.cmbBizType.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cmbBizType_changed(e);
					}
				});
		
		//��ȡ�˵�����
		Object obj = getUIContext().get("UIClassParam") ;
		if("1".equals(UIRuleUtil.getString(obj))){ 
			bizType=WeighBizType.Pur;
		}else if("2".equals(UIRuleUtil.getString(obj))){
			bizType=WeighBizType.localPur;
			this.prmtMaterial.setEnabled(true);
			this.prmtSupplier.setEnabled(true);
			
		}
		this.cmbBizType.setSelectedItem(bizType);
		
		this.rdoTare2Gross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editData != null && editData.getId() != null)
					return;
				// TODO Auto-generated method stub
				txtTare.setValue(BigDecimal.ZERO);
				txtGross.setValue(BigDecimal.ZERO);
				txtTare2.setValue(BigDecimal.ZERO);
				txtSuttle.setValue(BigDecimal.ZERO);
				txtImpurity.setValue(BigDecimal.ZERO);
				txtImpurity2.setValue(BigDecimal.ZERO);
				txtQCwgt.setValue(BigDecimal.ZERO);
				txtOtherWgt.setValue(BigDecimal.ZERO);
			}
		});
		this.rdoGross2Tare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTare.setValue(BigDecimal.ZERO);
				txtGross.setValue(BigDecimal.ZERO);
				txtTare2.setValue(BigDecimal.ZERO);
				txtSuttle.setValue(BigDecimal.ZERO);
				txtImpurity.setValue(BigDecimal.ZERO);
				txtImpurity2.setValue(BigDecimal.ZERO);
				txtQCwgt.setValue(BigDecimal.ZERO);
				txtOtherWgt.setValue(BigDecimal.ZERO);

			}
		});
		this.rdoTare2Gross2Tare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (editData != null && editData.getId() != null)
					return;
				txtTare.setValue(BigDecimal.ZERO);
				txtGross.setValue(BigDecimal.ZERO);
				txtTare2.setValue(BigDecimal.ZERO);
				txtSuttle.setValue(BigDecimal.ZERO);
				txtImpurity.setValue(BigDecimal.ZERO);
				txtImpurity2.setValue(BigDecimal.ZERO);
				txtQCwgt.setValue(BigDecimal.ZERO);
				txtOtherWgt.setValue(BigDecimal.ZERO);

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
		//this.toolBar.add(btnModifyImpurity);
		this.toolBar.add(btnBeginRead);
		this.toolBar.add(btnEndRead);
		this.cmbQueryBillStatus.addItem("ȫ��");
		this.cmbQueryBillStatus.setSelectedIndex(-1);
		//�Ƿ���ʱ�����ı��¼� add 20150730
		this.txtCarNum.setRequired(true);
		//yumingxu 
		//this..setEditable(false);
		this.chkIsTemp.setEnabled(true);
		this.chkIsTemp.setVisible(false);
		this.chkIsTemp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isTempChanged();
			}});
		
//		this.customInitControl();
		this.btnShowOrder.setText("...");
		
	}
	//�Ƿ���ʱ�����ı��¼�
	private void isTempChanged(){
		if(this.chkIsTemp.isSelected()) {//ѡ��
			this.prmtCar.setValue(null);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
		}else {
			this.txtCarNum.setText(null);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(false);
		}
	};
	
	
	/**
	 * ��������Ķ�������ʾ��������
	 */
	protected void btnShowOrder_actionPerformed(ActionEvent e) throws Exception {
		// �س� ������  ����ִ�� ��� ����
		if(e == null || (e != null && !orderFocusLost)){
			String orderNum=this.txtOrderNum.getText();
			String carnumber = this.txtCarNum.getText();
//			if(StringUtils.isBlank(orderNum) && StringUtils.isBlank(carnumber)) {
//				MsgBox.showWarning("���������붩���Ż��߳��ƺ�����һ��ֵ���в�ѯ");
//				return;
//			}else{
				try{
					Date currDate = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String endDateStr = sdf.format(currDate);
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(currDate);
					//cal.add(Calendar.DATE, -1);
					cal.set(Calendar.DAY_OF_MONTH, -7);
					Date beginDate = cal.getTime();
					String beginDateStr = sdf.format(beginDate);
					
					Map<String,OrderWeightInfo> orderMaps = null;
					if(this.cmbBizType.getSelectedItem().equals(WeighBizType.localPur)){
						orderMaps = weightbridgeFacadeFactory.getRemoteInstance().getQCInfoByNumber(orderNum,carnumber,beginDateStr,endDateStr);
					}else{
						orderMaps = weightbridgeFacadeFactory.getRemoteInstance().getNewPurorderInfoByNumber(orderNum,carnumber,beginDateStr,endDateStr);
					}	
					
					if(orderMaps != null && orderMaps.size() >0 ){
						// ��ȡҪ�����Ķ���
						OrderWeightInfo orderInfo = getWeightOrder(orderMaps);
						if(orderInfo != null){
						
							// ���� ��������
							this.editData = getNewWeightInBill(orderInfo);
							// ����������������
							this.LoadFields(null);
							MaterialInfo materialInfo = new MaterialInfo();
							materialInfo.setId(BOSUuid.read(orderInfo.getMaterialID()));
							materialInfo.setNumber(orderInfo.getMaterialNumber());
							materialInfo.setName(orderInfo.getMaterialName());
							this.prmtMaterial.setValue(materialInfo);
						}
					}else{
						MsgBox.showWarning("������δ��ѯ�� ������Ϣ����˶�");
	//					this.txtOrderNum.requestFocus();
					}
				}catch(BOSException bose){
					bose.printStackTrace();
					MsgBox.showWarning(bose.getMessage());
	//				this.txtOrderNum.requestFocus();
				}finally{
					orderFocusLost = false;
				}
			//}
			
			orderFocusLost = false;
		}
	}
	/**
	 * ���ֻ��һ��  ��ֱ�ӷ��� ���򵯳����˽��� ���û�ѡ��
	 * @param orderMaps
	 * @return
	 * @throws UIException 
	 */
	private OrderWeightInfo getWeightOrder(Map<String,OrderWeightInfo> orderMaps) throws UIException{
		if(orderMaps != null && orderMaps.size() > 0){
			// ֻ��һ��ʱ  ֱ�ӷ���  ���򵯳�����ѡ�񣬻������²�ѯ
			if(orderMaps.size() == 1){
				return (OrderWeightInfo) orderMaps.values().toArray()[0];
			}else{
				String searchOrderNum = this.txtOrderNum.getText();
//				Date endDate = new Date();
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(endDate);
//				cal.add(Calendar.DATE, -1);
//				Date beginDate = cal.getTime();
				Date currDate = new Date();
				UIContext uiContext = new UIContext(ui);
		    	uiContext.put("searchOrderNum", searchOrderNum);
		    	uiContext.put("orderMaps", orderMaps);
		    	uiContext.put("currDate", currDate);
		    	if(this.cmbBizType.getSelectedItem().equals(WeighBizType.localPur)){
			    	uiContext.put("orderType", SelectSourceOrderUI.QC_bill);
		    	}else{
			    	uiContext.put("orderType", SelectSourceOrderUI.PUR_ORDER);

		    	}
		    	
		    	IUIWindow window = null;
		    	window = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.weighbridge.client.SelectSourceOrderUI", uiContext, null, OprtState.ADDNEW);
		    	window.show();
		    	Map selectUICtx = window.getUIObject().getUIContext();
		    	
		    	if(selectUICtx != null){
		    		return (OrderWeightInfo) selectUICtx.get("OrderInfo");
		    	}
			}
		}
		
		return null;
	}
	/**
	 * ���ݶ�����װ ��������� �����µ���
	 * @return
	 */
	private FeInStorageBillInfo getNewWeightInBill(OrderWeightInfo orderInfo){
		FeInStorageBillInfo inStorageBillInfo = new FeInStorageBillInfo();
		inStorageBillInfo.setId(BOSUuid.create(inStorageBillInfo.getBOSType().toString()));
		inStorageBillInfo.setNumber(getAutoNumberByOrg("NONE"));
		inStorageBillInfo.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		inStorageBillInfo.setId(BOSUuid.create(inStorageBillInfo.getBOSType().toString()));
		inStorageBillInfo.setBizDate((Date) this.dpBizDate.getValue());
		inStorageBillInfo.setBillStatus(WeighBaseStatus.save);
		inStorageBillInfo.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		inStorageBillInfo.setOrderStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		inStorageBillInfo.setWeighman(SysContext.getSysContext().getCurrentUserInfo().getPerson());
		inStorageBillInfo.setTareWeight(orderInfo.getOrderBaseQty());
		inStorageBillInfo.setWeighType(WeighBaseType.Gross2Tare);
		
		//inStorageBillInfo.setBizType(orderInfo.getWeighBizType());
		if(this.cmbBizType.getSelectedItem().equals(WeighBizType.localPur)){
			inStorageBillInfo.setBizType(WeighBizType.localPur);
		}else{
			inStorageBillInfo.setBizType(WeighBizType.Pur);
		}
		//this.cmbBizType.setSelectedItem(bizType);
		SupplierInfo supplierInfo = new SupplierInfo();
		supplierInfo.setId(BOSUuid.read(orderInfo.getCusSuppID()));
		supplierInfo.setNumber(orderInfo.getCusSuppNumber());
		supplierInfo.setName(orderInfo.getCusSuppName());
		
		inStorageBillInfo.setSupplier(supplierInfo);
		inStorageBillInfo.setCarNum(orderInfo.getCarNumber());
		MaterialInfo materialInfo = new MaterialInfo();
		materialInfo.setId(BOSUuid.read(orderInfo.getMaterialID()));
		materialInfo.setNumber(orderInfo.getMaterialNumber());
		materialInfo.setName(orderInfo.getMaterialName());
		Date date = new Date();
		inStorageBillInfo.setInTime(date);
		inStorageBillInfo.setOutTime(date);
		inStorageBillInfo.setPurnumber(orderInfo.getOrderNumber());
		return inStorageBillInfo;
	}
	
	public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception {
		this.setOprtState(STATUS_ADDNEW);
		this.billEdit.createFrom(getMainOrgContext());
		try{
			IObjectCollection destBillCols = (IObjectCollection) this.getUIContext().get("destBillCols");
			if(destBillCols!=null&&destBillCols.size()>0) {
				String entryID=null;
				FeInStorageBillInfo head = (FeInStorageBillInfo) destBillCols.getObject(0);
				if(head.getEntrys().size()>0) {
					entryID=head.getEntrys().get(head.getEntrys().size()-1).getId().toString();
				}
				this.editData=head;
				
			/*	if(info.getEntrys().size()>1) {//�����˶�����¼
					InStorageBillEntryCollection entryInfosClone = (InStorageBillEntryCollection) info.getEntrys().clone();
					for(int i=1;i<info.getEntrys().size();i++) {//ɾ��>��һ����¼
						
						info.getEntrys().removeObject(i);
					}
					for(int i=1;i<entryInfosClone.size();i++){
					}
					BOTRelationCollection mr = getMakeRelations();
					for(int i=0;i<mr.size();i++) {
						mr.get(i).setDestEntityID();
					}
				}*/
				
				//setNowBillInfo(billID);
				//this.detailCol.sort("sourceBillNum");//������Դ���ݱ�������
				
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
	 * Ŀ����Ӹı� ���㾻��
	 */
	private void impirityChanged(DataChangeEvent e) {
		BigDecimal tare = this.txtTare.getBigDecimalValue();
		if(tare==null) {
			tare=BigDecimal.ZERO;
		}
		BigDecimal gross = this.txtGross.getBigDecimalValue();
		if(gross==null) {
			gross=BigDecimal.ZERO;
		}
		BigDecimal imprity =BigDecimal.ZERO;
		BigDecimal imprity2=BigDecimal.ZERO;
		if(e.getSource()==this.txtImpurity) {
			if(e.getNewValue()!=null) {
				imprity=new BigDecimal(e.getNewValue().toString());
			} 
			if(this.txtImpurity2.getBigDecimalValue()!=null)
				imprity2=this.txtImpurity2.getBigDecimalValue();
			
		}else if(e.getSource()==this.txtImpurity2) {
			if(e.getNewValue()!=null) {
				imprity2=new BigDecimal(e.getNewValue().toString());
			}
			if(this.txtImpurity.getBigDecimalValue()!=null)
				imprity=this.txtImpurity.getBigDecimalValue();
		}
		BigDecimal tare2 = this.txtTare2.getBigDecimalValue();
		if(tare2==null) {
			tare2=BigDecimal.ZERO;
		}
		if (this.rdoTare2Gross2Tare.isSelected())
			this.txtSuttle.setValue((gross.subtract(tare2)).subtract(imprity).subtract(imprity2));
		else
			this.txtSuttle.setValue((gross.subtract(tare)).subtract(imprity).subtract(imprity2));
	}
	/**
	 * ҵ�����͸ı� �ͻ�/�����֯ �ı�
	 * 
	 * @param e
	 */
	private void cmbBizType_changed(ActionEvent e) {
		if (this.cmbBizType.getSelectedItem().equals(WeighBizType.Pur)) {
			//this.contSupplier.setVisible(true);
			//this.prmtOrderStorageOrgUnit.setValue(null);
			this.contOrderStorageOrgUnit.setVisible(false);
		} else if (this.cmbBizType.getSelectedItem().equals(WeighBizType.TransIn)||this.cmbBizType.getSelectedItem().equals(WeighBizType.GroupPur)) {
			//this.prmtSupplier.setValue(null);
			this.contSupplier.setVisible(false);
			this.contOrderStorageOrgUnit.setVisible(true);
		}else if (this.cmbBizType.getSelectedItem().equals(WeighBizType.localPur)){
			//this.prmtOrderStorageOrgUnit.setValue(null);
			this.contOrderStorageOrgUnit.setVisible(false);
			//this.txtOrderNum.setText(null);
			//btnShowOrder.setEnabled(false);
			this.prmtMaterial.setEnabled(true);
			//this.prmtMaterial.setValue(null);
			this.txtOrderNum.setEnabled(false);
			this.chkIsTemp.setSelected(true);
			this.contSupplier.setVisible(true);
			this.prmtSupplier.setEnabled(true);
			this.prmtMaterial.setRequired(true);
			this.prmtSupplier.setRequired(true);
		}else if (this.cmbBizType.getSelectedItem().equals(WeighBizType.Other)){
			//this.prmtOrderStorageOrgUnit.setValue(null);
			this.contOrderStorageOrgUnit.setVisible(false);
			this.txtOrderNum.setText(null);
			//btnShowOrder.setEnabled(false);
			this.prmtMaterial.setEnabled(true);
			//this.prmtMaterial.setValue(null);
			this.prmtMaterial.setRequired(false);
			this.txtOrderNum.setEnabled(false);
			this.chkIsTemp.setSelected(true);
			this.contSupplier.setVisible(true);
			this.prmtSupplier.setEnabled(true);
			this.prmtSupplier.setRequired(false);
		}
	}
	/**
	 * ���ϸı��¼�
	 */
	private class materialDataChangeListenerClass implements DataChangeListener {
		public void dataChanged(DataChangeEvent e) {
			materialChanged(e);
		}
	}
	private void materialChanged(DataChangeEvent e) {
		String companyID = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		//txtPrice.setValue(BigDecimal.ZERO);
		if(prmtMaterial.getValue()!=null){
			String materialID=((IPropertyContainer)prmtMaterial.getValue()).getString("id");
//			LocalPurMATPriceEntryInfo localPurPriceEntry = WeighbridgeCommUtils.getLocalPurPrice(null, companyID, materialID);
//			if(localPurPriceEntry!=null){
//				BigDecimal price = localPurPriceEntry.getPrice();
//				txtPrice.setValue(price);
//				SupplierInfo supplier = localPurPriceEntry.getSupplier();
//				prmtSupplier.setValue(supplier);
//			}
		}
	}
	
	/**
	 * �����ı䣬����Ƥ��
	 * 
	 * @param e
	 */
	private void prmtCar_Changed(DataChangeEvent e) {
		if (this.prmtCar.getValue() != null) {
			CarInfo carInfo = (CarInfo)e.getNewValue();
			//this.txtTare.setValue(carInfo.getTare());
			if(carInfo.getCarType().equals(CarType.ownCar)) {
				//this.dpOutTime.setValue(new java.util.Date());
			}else{
				//this.dpInTime.setValue(new java.util.Date());
			}
			this.txtCarNum.setText(carInfo.getNumber());//add 20150730
		} else {
			//this.txtTare.setValue(BigDecimal.ZERO);
			this.txtCarNum.setText(null);
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
	private IFeInStorageBill getBizInstance() throws BOSException {
		return FeInStorageBillFactory.getRemoteInstance();
	}

	private IFeInStorageBillEntry getBizEntryInstance() throws BOSException {
		return FeInStorageBillEntryFactory.getRemoteInstance();
	}

	private IFeInStorageBillEntryDetail getBizEntryDetailInstance() throws BOSException {
		return FeInStorageBillEntryDetailFactory.getRemoteInstance();
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
		initControlDeafultValue();
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
			iBTPManager.saveRelations(this.editData, getMakeRelations());//����BOTP	
			logger.info("NewInStorageBillID:::::::"+pk);
			this.setSaved(true);
			/************************************************wgj add save log start 20160828******************/
			saveWeighLog("��������-ҵ�����");
			/************************************************wgj add save log end   20160828******************/
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
			this.txtOrderNum.setText(this.editData.getPurnumber());
			this.dpBizDate.setValue(this.editData.getBizDate());
			this.prmtCar.setValue(editData.getCar());
			this.txtCarNum.setText(editData.getCarNum());//add 20150730
			this.prmtSupplier.setValue(editData.getSupplier());
			this.prmtOrderStorageOrgUnit.setValue(editData.getOrderStorageOrgUnit());
//			this.dpInTime.setValue(editData.getInTime());
//			this.dpOutTime.setValue(editData.getOutTime());
			this.dpInTime.setValue(null);
			this.dpOutTime.setValue(null);
			this.cmbBizType.setSelectedItem(editData.getBizType());// ����ҵ������
			this.cmbBillStatus.setSelectedItem(editData.getBillStatus());
			if (editData.getWeighType()!=null&&editData.getWeighType().equals(WeighBaseType.Tare2Gross)) {// ������ʽ
				this.rdoTare2Gross.setSelected(true);
			} else if (editData.getWeighType()!=null&&editData.getWeighType().equals(WeighBaseType.Gross2Tare)) {
				this.rdoGross2Tare.setSelected(true);
			} else if (editData.getWeighType()!=null&&editData.getWeighType().equals(WeighBaseType.Tare2Gross2Tare)) {
				this.rdoTare2Gross2Tare.setSelected(true);
			}
			this.txtRemark.setText(this.editData.getDescription());
			//������¼���ϡ��ۼӾ��غϼ�
			FeInStorageBillEntryCollection entryCol = this.editData.getEntrys();
			BigDecimal sumSuttle=BigDecimal.ZERO;
			this.txtQCRate.setValue(this.editData.getTareWeight());
			//this.txtQCRate.setValue(editData.getTareWeight());
			for(int i=0;i<entryCol.size();i++) {
				if(i==0) {
					this.prmtMaterial.setValue(entryCol.get(i).getMaterial());
					if(entryCol.get(i).getMaterial()!=null) {
//						this.txtModel.setText(entryCol.get(i).getMaterial().getModel());
					}
					this.txtTare.setValue(entryCol.get(i).getTare());
					this.txtGross.setValue(entryCol.get(i).getGross());
					this.txtTare2.setValue(entryCol.get(i).getTare2());
					this.txtImpurity.setValue(entryCol.get(i).getImpurity());
					this.txtImpurity2.setValue(entryCol.get(i).getImpurity2());
					
					this.txtQCwgt.setValue(BigDecimal.ZERO);
					this.txtOtherWgt.setValue(entryCol.get(i).getOtherWeight());

					
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
					
					
				}
			}
			if(entryCol.size()<=0) {
				this.prmtMaterial.setValue(null);
				this.txtTare.setValue(BigDecimal.ZERO);
				this.txtGross.setValue(BigDecimal.ZERO);
				this.txtTare2.setValue(BigDecimal.ZERO);
				this.txtImpurity.setValue(BigDecimal.ZERO);
				this.txtImpurity2.setValue(BigDecimal.ZERO);
				this.txtQCwgt.setValue(BigDecimal.ZERO);
				this.txtOtherWgt.setValue(BigDecimal.ZERO);
			}
			this.txtSuttle.setValue(sumSuttle);
		} else {
			this.txtNumber.setText(null);// ****��ȡ�µĵ��ݱ��룿
			this.dpBizDate.setValue(new java.util.Date());
			this.prmtCar.setValue(null);
			this.txtCarNum.setText(null);
			if(params!=null) {
				this.prmtCar.setValue(params.get("carInfo"));
				this.txtCarNum.setText(((CoreBaseInfo) params.get("carInfo")).getString("number"));
			}
			this.prmtMaterial.setValue(null);
			this.prmtSupplier.setValue(null);
			this.prmtOrderStorageOrgUnit.setValue(null);
			this.dpInTime.setValue(null);
			this.dpOutTime.setValue(null);
			this.cmbBillStatus.setSelectedItem(null);
			this.txtTare.setValue(BigDecimal.ZERO);
			this.txtGross.setValue(BigDecimal.ZERO);
			this.txtSuttle.setValue(BigDecimal.ZERO);
			this.txtTare2.setValue(BigDecimal.ZERO);
			this.txtImpurity.setValue(BigDecimal.ZERO);
			this.txtImpurity2.setValue(BigDecimal.ZERO);
			this.txtQCwgt.setValue(BigDecimal.ZERO);
			this.txtOtherWgt.setValue(BigDecimal.ZERO);
			this.txtRemark.setText(null);
			this.rdoGross2Tare.setSelected(true);
			//��ն���
			this.txtOrderNum.setText(null);
			
			
		}
		selectControlLocked();
		// �ɹ�ֻ�� ë��Ƥ��ģʽ
		this.rdoTare2Gross.setEnabled(false);
		this.addDataChangeListeners();
	}

	/**
	 * ɾ��������
	 */
	private void removeDataChangeListeners() {
		this.prmtCar.removeDataChangeListener(carDataChangeListener);
		this.txtImpurity.removeDataChangeListener(imputityDataChangeListener);
		this.txtImpurity2.removeDataChangeListener(imputityDataChangeListener);
		this.prmtMaterial.removeDataChangeListener(materialDataChangeListener);
	}
	/**
	 * �����ı��¼�
	 */
	private class carDataChangeListenerClass implements DataChangeListener {
		public void dataChanged(DataChangeEvent e) {
			prmtCar_Changed(e);
		}
	}
	/**
	 * ���ʸı��¼�
	 */
	private class imputityDataChangeListenerClass implements DataChangeListener {
		public void dataChanged(DataChangeEvent e) {
			impirityChanged(e);
		}
	}
	/*
	 /* 
	 * ���Ӽ�����
	 */
	private void addDataChangeListeners(){
		this.prmtCar.addDataChangeListener(carDataChangeListener);	
		this.txtImpurity.addDataChangeListener(imputityDataChangeListener);
		this.txtImpurity2.addDataChangeListener(imputityDataChangeListener);
	}
	/**
	 */
	/**
	 * �õ���ǰ��¼����
	 * 
	 * @param entryID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void setNewBillInfo(String billID) throws EASBizException, BOSException {
		editData = null;
		if (StringUtils.isBlank(billID)) {
			editData = new FeInStorageBillInfo();
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
			slors.add(new SelectorItemInfo("supplier.*"));
			slors.add(new SelectorItemInfo("orderStorageOrgUnit.*"));
			slors.add(new SelectorItemInfo("entrys.*"));
			slors.add(new SelectorItemInfo("entrys.material.*"));
			slors.add(new SelectorItemInfo("entrys.Detail.*"));
			editData = this.getBizInstance().getFeInStorageBillInfo(new ObjectUuidPK(billID), slors);
		}
	}
	
	/**
	 * ���ÿؼ�Ĭ��ֵ
	 */
	private synchronized void initControlDeafultValue() {
		
		if (this.initParams.get("weighBizType") != null) {// Ĭ��ҵ������ 
			this.cmbBizType.setSelectedItem(WeighBizType.getEnum(this.initParams.get("weighBizType").toString()));// ����Ĭ��ֵ
			this.cmbBizType_changed(null);
		}

		if (this.initParams.get("weighBaseType") != null) {// Ĭ�Ϲ�����ʽ
			String weighType=this.initParams.get("weighBaseType").toString();
			if(weighType.equalsIgnoreCase(WeighBaseType.Tare2Gross.getValue())) {
				this.rdoTare2Gross.setSelected(true);
			}else if(weighType.equalsIgnoreCase(WeighBaseType.Gross2Tare.getValue())) {
				this.rdoGross2Tare.setSelected(true);
			}else{
				this.rdoTare2Gross2Tare.setSelected(true);
			}
		}
		this.cmbIsAuto2Inv.setSelected((Boolean) initParams.get("isAutoCreateToInvBill"));
		//����Ĭ������
		if(this.initParams.get("materialSet")!=null) {
			HashSet set=(HashSet) this.initParams.get("materialSet");
			if(set.size()==1) {
				try {
					Iterator it = set.iterator();
					this.prmtMaterial.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK((String) it.next())));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}
	/*
	 * ���ÿؼ�������״̬
	 */
	private void selectControlLocked() {
		Boolean flag = true;
		if (this.editData != null && this.editData.getId() != null) {
			//flag = false;
			if(editData.getBillStatus()!=null&&!editData.getBillStatus().equals(WeighBaseStatus.save)) {//����״̬���ݿ��޸�
				flag=false;
			}
			if (editData.getBillStatus().equals(WeighBaseStatus.finish)||editData.getBillStatus().equals(WeighBaseStatus.qcFinish)||editData.getBillStatus().equals(WeighBaseStatus.audit)) {// �Ѿ������������
				this.txtImpurity.setEnabled(false);
				this.txtImpurity2.setEnabled(false);
				this.txtRemark.setEnabled(false);
				this.btnWeight.setEnabled(false);
				this.btnSave.setEnabled(false);
				this.btnAllSave.setEnabled(false);
				
//				this.dpOutTime.setEnabled(false);
//				this.dpInTime.setEnabled(false);
				
				//modify 20150912
				this.cmbBizType.setEnabled(false);
				this.rdoTare2Gross.setEnabled(false);
				this.rdoGross2Tare.setEnabled(false);
				this.rdoTare2Gross2Tare.setEnabled(false);
				this.prmtSupplier.setEnabled(false);
				this.prmtOrderStorageOrgUnit.setEnabled(false);
			} else {
				this.txtImpurity.setEnabled(true);
				this.txtImpurity2.setEnabled(true);
				this.txtRemark.setEnabled(true);
				this.btnWeight.setEnabled(true);
				this.btnSave.setEnabled(true);
				this.btnAllSave.setEnabled(true);		
//				
//				this.dpOutTime.setEnabled(true);
//				this.dpInTime.setEnabled(true);
				
				this.cmbBizType.setEnabled(true);
				this.rdoTare2Gross.setEnabled(true);
				this.rdoGross2Tare.setEnabled(true);
				this.rdoTare2Gross2Tare.setEnabled(true);
				//this.prmtSupplier.setEnabled(true);
				this.prmtOrderStorageOrgUnit.setEnabled(true);

			}

		} else {
			this.txtImpurity.setEnabled(true);
			this.txtImpurity2.setEnabled(true);
			this.txtRemark.setEnabled(true);
			this.btnWeight.setEnabled(true);
			this.btnSave.setEnabled(true);
			this.btnAllSave.setEnabled(true);
//			this.dpInTime.setEnabled(true);
//			this.dpOutTime.setEnabled(true);
			
			this.cmbBizType.setEnabled(true);
			this.rdoTare2Gross.setEnabled(true);
			this.rdoGross2Tare.setEnabled(true);
			this.rdoTare2Gross2Tare.setEnabled(true);
			//this.prmtSupplier.setEnabled(true);
			this.prmtOrderStorageOrgUnit.setEnabled(true);
		}

		//modify 20150912
		this.cmbBizType.setEnabled(flag);
		this.rdoTare2Gross.setEnabled(flag);
		this.rdoGross2Tare.setEnabled(flag);
		this.rdoTare2Gross2Tare.setEnabled(flag);
		//yumingxu
		this.chkIsTemp.setEnabled(flag);//add 20150730
		this.txtCarNum.setEnabled(flag);
		
		if(this.editData != null && this.editData.getId() != null&&editData.getCar()==null) {
			//this.chkIsTemp.setSelected(true);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
			
		}else {
			//this..setSelected(true);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
		}
		//mofify 20150820 flag��Ϊtrue
		this.prmtCar.setEnabled(flag);
//		this.prmtSupplier.setEnabled(true);
//		this.prmtOrderStorageOrgUnit.setEnabled(true);
		//this.prmtMaterial.setEnabled(flag);
		this.cmbIsAuto2Inv.setEnabled(flag);
		
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
//		editData.setInTime((Date) this.dpInTime.getValue());
//		editData.setOutTime((Date) this.dpOutTime.getValue());
		editData.setCar((CarInfo) this.prmtCar.getValue());
		editData.setCarNum(this.txtCarNum.getText());//add 20150730
		editData.setTareWeight(this.txtTare.getBigDecimalValue());
		editData.setBizType((WeighBizType) this.cmbBizType.getSelectedItem());
		editData.setSupplier((SupplierInfo) this.prmtSupplier.getValue());
		editData.setDescription(this.txtRemark.getText());
		editData.setTareWeight(this.txtQCRate.getBigDecimalValue());
		if(editData.getStorageOrgUnit()==null) {
			editData.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		}
		if(SysContext.getSysContext().getCurrentFIUnit()==null) {
			editData.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		}
		StorageOrgUnitInfo storageUnit = (StorageOrgUnitInfo) this.prmtOrderStorageOrgUnit.getValue();
		editData.setOrderStorageOrgUnit(storageUnit);
		if(storageUnit!=null) {
			try{
				//Ŀ������֯������֯
				editData.setCompany(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(WeighbridgeCommUtils.getOrgIDByRelation(storageUnit.getId().toString(), 4, 1))));
			}catch(Exception e){e.printStackTrace();}
		}

		if (this.rdoTare2Gross.isSelected()) {
			editData.setWeighType(WeighBaseType.Tare2Gross);
		}
		if (this.rdoGross2Tare.isSelected()) {
			editData.setWeighType(WeighBaseType.Gross2Tare);
		}
		if (this.rdoTare2Gross2Tare.isSelected()) {
			editData.setWeighType(WeighBaseType.Tare2Gross2Tare);
		}

		String timeFlag="time";
		if (this.rdoTare2Gross.isSelected()) {// Ƥ��-ë��
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.tare);
				timeFlag="weighTime";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
				editData.setBillStatus(WeighBaseStatus.finish);
				 timeFlag="weighTimeGross";
			}
		}
		if (this.rdoGross2Tare.isSelected()) {// ë��-Ƥ��
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.gross);
				timeFlag="weighTimeGross";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
				editData.setBillStatus(WeighBaseStatus.finish);
				timeFlag="weighTime";
			}
		}
		if (this.rdoTare2Gross2Tare.isSelected()) {// Ƥ��-ë��-Ƥ��
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.tare);
				timeFlag="weighTime";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
				editData.setBillStatus(WeighBaseStatus.gross);
				timeFlag="weighTimeGross";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
				editData.setBillStatus(WeighBaseStatus.finish);
				timeFlag="weighTime2";
			}
		}

		BigDecimal suttleQty=this.txtSuttle.getBigDecimalValue();
		if(suttleQty==null)
			suttleQty=BigDecimal.ZERO;
		if (this.editData.getEntrys().size() <= 0) {
			FeInStorageBillEntryInfo entryInfo = new FeInStorageBillEntryInfo();
			entryInfo.setMaterial((MaterialInfo) this.prmtMaterial.getValue());
			entryInfo.setMateiralName(((MaterialInfo) this.prmtMaterial.getValue()).getName());
			entryInfo.setModel(((MaterialInfo) this.prmtMaterial.getValue()).getModel());
			entryInfo.setUnit(((MaterialInfo) this.prmtMaterial.getValue()).getBaseUnit());
			entryInfo.setDate(timeFlag, new java.util.Date());
			entryInfo.setTare(this.txtTare.getBigDecimalValue());
			entryInfo.setTare2(this.txtTare2.getBigDecimalValue());
			entryInfo.setGross(this.txtGross.getBigDecimalValue());
			entryInfo.setImpurity(this.txtImpurity.getBigDecimalValue());
			entryInfo.setImpurity2(this.txtImpurity2.getBigDecimalValue());
			entryInfo.setQcWeight(this.txtQCwgt.getBigDecimalValue());
			entryInfo.setOtherWeight(this.txtOtherWgt.getBigDecimalValue());
			entryInfo.setSuttle(suttleQty);
			this.editData.getEntrys().add(entryInfo);
		} else {				
			BigDecimal tempQty, weighQty, remainQty,orderQty,entryAddQty;
			remainQty = suttleQty;
			for (int i = 0; i < this.editData.getEntrys().size(); i++) {
				this.editData.getEntrys().get(i).setMaterial((MaterialInfo) this.prmtMaterial.getValue());
				this.editData.getEntrys().get(i).setDate(timeFlag, new java.util.Date());
				this.editData.getEntrys().get(i).setTare(this.txtTare.getBigDecimalValue());
				this.editData.getEntrys().get(i).setTare2(this.txtTare2.getBigDecimalValue());
				this.editData.getEntrys().get(i).setGross(this.txtGross.getBigDecimalValue());
				this.editData.getEntrys().get(i).setImpurity(this.txtImpurity.getBigDecimalValue());
				this.editData.getEntrys().get(i).setImpurity2(this.txtImpurity2.getBigDecimalValue());
				this.editData.getEntrys().get(i).setQcWeight(this.txtQCwgt.getBigDecimalValue());
				this.editData.getEntrys().get(i).setOtherWeight(this.txtOtherWgt.getBigDecimalValue());
				
				/***********************wgj add У�����ι���ʱ�� ���ܼ��̫�̣��Ƿ���Ҫ����У�飿**************************/
				Date weighTime = this.editData.getEntrys().get(i).getWeighTime();
				Date weighTime2 = this.editData.getEntrys().get(i).getWeighTime2();
				Date weighTimeGross = this.editData.getEntrys().get(i).getWeighTimeGross();
				 
//				boolean isTooShort = WeighbridgeCommUtils.isWeightTimeTooShort(weighTime, weighTime2, weighTimeGross, WeighbridgeCommUtils.shortestMinutesBetweenTwoWeigh);
//				
//				if(isTooShort && MsgBox.showConfirm2("�ó������ι����������10���ӣ��Ƿ����������������������") != MsgBox.YES){
//					SysUtil.abort();
//				}
				/***********************wgj add У�����ι���ʱ�� ���ܼ��̫��**************************/
				
				entryAddQty=BigDecimal.ZERO;
				FeInStorageBillEntryDetailCollection detailCol = this.editData.getEntrys().get(i).getDetail();
				for (int j = 0; j < detailCol.size(); j++) {
					//�ѹ�������
					weighQty = WeighbridgeCommUtils.getWeighQty(detailCol.get(j).getSourceBillID(),detailCol.get(j).getSourceEntryID());
					//��������
					orderQty= detailCol.get(j).getSourceEntryQty();
					if(orderQty==null) 
						orderQty=BigDecimal.ZERO;
					// ʣ�����������
					tempQty = orderQty.subtract(weighQty);
					if (remainQty.compareTo(tempQty) > 0) {
						detailCol.get(j).setWeighQty(tempQty);
						detailCol.get(j).setWeighQty(tempQty);
						entryAddQty=entryAddQty.add(tempQty);
						remainQty = remainQty.subtract(tempQty);
					} else if (remainQty.compareTo(tempQty) <= 0) {
						detailCol.get(j).setWeighQty(remainQty);
						detailCol.get(j).setWeighQty(remainQty);
						entryAddQty=entryAddQty.add(remainQty);
						remainQty = BigDecimal.ZERO;
					}
				}
				if(detailCol.size()<=0)
					entryAddQty=suttleQty;
				this.editData.getEntrys().get(i).setSuttle(entryAddQty);
			}
		}
	}

	/**
	 * �õ���¼������Դ���ݵ�������
	 * @param entryInfo
	 * @return
	 */
	private BigDecimal getDetailQty(FeInStorageBillEntryInfo entryInfo) {
		BigDecimal qty=BigDecimal.ZERO;
		for(int i=0;i<entryInfo.getDetail().size();i++) {
			if(entryInfo.getDetail().get(i).getSourceEntryQty()!=null) {
				qty=qty.add(entryInfo.getDetail().get(i).getSourceEntryQty());
			}
		}
		return qty;
	}
	
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		this.execQuery();
		this.resetBill();
	}

	public void onShow() throws Exception {
		super.onShow();
		this.execQuery();
		this.resetBill();
	}

	/**
	 * �������ݺϷ��Խ���
	 */
	protected void VerifyInput() throws Exception {
		if (this.txtGross.getText().equals("0")) {
			MsgBox.showWarning("ë��Ϊ0�������棡");
			SysUtil.abort();
		}
		
		/********************************************20160424 WGJ ADD BEGIN �����ڲɹ�ʱ�����Դ�����֯ �ڽ����һ�γ��֣�����ʾ�û�ȷ�Ϻ��ٱ���**********************/
		if (this.cmbBizType.getSelectedItem().equals(WeighBizType.GroupPur)) {
			StorageOrgUnitInfo currStorageInfo = (StorageOrgUnitInfo) this.prmtOrderStorageOrgUnit.getValue();
			CtrlUnitInfo currCtrl = SysContext.getSysContext().getCurrentCtrlUnit();
			Date bizDate = this.dpBizDate.getSqlDate();
			if(currStorageInfo != null && currCtrl != null && bizDate != null){
				boolean isExist = WSWeighbridgeFacadeFactory.getRemoteInstance().isStorageOrgIsFirstIn(currCtrl.getId().toString(), currStorageInfo.getId().toString(), bizDate);
				if(!isExist){
					if(MsgBox.showConfirm2("��ǰ��Դ�����֯�ǵ����һ�ι��������ٴκ˶�ȷ��������ȷ�ϱ��������Ϣ��������ȡ��") != MsgBox.OK){
						SysUtil.abort();
					}
				}
			}
		}
		
		/********************************************20160424 WGJ ADD END �����ڲɹ�ʱ�����Դ�����֯ �ڽ����һ�γ��֣�����ʾ�û�ȷ�Ϻ��ٱ���  **********************/

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
			if (this.rdoTare2Gross.isSelected()) {// Ƥ��-ë��
				if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2);
						//SysUtil.abort();
					}
					this.checkOrderQty();
				}
			}
			if (this.rdoGross2Tare.isSelected()) {// ë��-Ƥ��
				if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2 );
						//SysUtil.abort();
					}
					this.checkOrderQty();
				}
			}

			if (this.rdoTare2Gross2Tare.isSelected()) {// Ƥ��-ë��-Ƥ��
				if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2 );
						//SysUtil.abort();
					}
				} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
					this.checkOrderQty();
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
		//���һ�� 
		if(this.prmtMaterial.getValue()!=null&&((MaterialInfo)this.prmtMaterial.getValue()).getName().endsWith("��")) {
			if((StringUtils.isBlank(this.txtImpurity.getText())||this.txtImpurity.getBigDecimalValue().compareTo(BigDecimal.ZERO)<=0)&&MsgBox.showConfirm2("�ֹ�����Ϊ0���Ƿ񱣴棿")!=MsgBox.OK)
			{
				SysUtil.abort();
			}
		}
		/**
		 * ���ѡ�񵥾ݲ�Ϊ�� ������������ʾ
		 */			
		Boolean  isExitSourceBill=false;
		BigDecimal suttleQty = this.txtSuttle.getBigDecimalValue();
		BigDecimal sumOrderQty = BigDecimal.ZERO;//��Դ�����ۼ�����
		if (suttleQty == null)
			suttleQty = BigDecimal.ZERO;
		for (int j = 0; j < this.editData.getEntrys().size(); j++) {
			FeInStorageBillEntryDetailCollection detailCol = this.editData.getEntrys().get(j).getDetail();
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
	 * @throws SQLException
	 */
	private void execQuery() throws BOSException, SQLException{
		//this.btnModifyImpurity.setText("�޸Ŀ���");
		this.tbList.removeRows();
		OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		String beginDate = this.dpBeginDate.getText();
		String endDate = this.dpEndDate.getText();
		String materialID=null;
		String carID=null;
		String carNumber=null;
		if(this.prmtQueryMaterial.getValue()!=null) {
			materialID=((AbstractCoreBaseInfo) this.prmtQueryMaterial.getValue()).getId().toString();
		}
		if(this.prmtQueryCar.getValue()!=null) {
			carID=((AbstractCoreBaseInfo) this.prmtQueryCar.getValue()).getId().toString();
		}
		if(this.txtQcarnumber!=null) {
			carNumber=txtQcarnumber.getText();
		}
		String conditionStr=null;
		if(this.cmbQueryBillStatus.getSelectedIndex()>(-1)&&!this.cmbQueryBillStatus.getSelectedItem().toString().equals("ȫ��")) {
			conditionStr=new StringBuffer().append(" and tb.CFBillStatus=").append(((WeighBaseStatus)this.cmbQueryBillStatus.getSelectedItem()).getValue()).toString();
		}
		IRowSet rs=getExeQueryRowSet(orgInfo,beginDate,endDate,materialID,carID,conditionStr,carNumber);
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
			row.getCell("orderStorageOrgUnit").setValue(rs.getString("FOrderStorageOrgUnitName"));
			
//			row.getCell("inTime").setValue(rs.getString("CFInTime"));
//			row.getCell("outTime").setValue(rs.getString("CFOutTime"));
			
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
			row.getCell("tare2").setValue(rs.getBigDecimal("CFTare2"));
			row.getCell("impurity").setValue(rs.getBigDecimal("CFImpurity"));
			row.getCell("impurity2").setValue(rs.getBigDecimal("CFImpurity2"));
			row.getCell("suttle").setValue(rs.getBigDecimal("CFSuttle"));
			row.getCell("bizDate").setValue(rs.getString("FBizDate").substring(0, 10));
			row.getCell("materialID").setValue(rs.getString("FMaterialID"));
			row.getCell("materialNum").setValue(rs.getString("FMaterialNum"));
//			row.getCell("model").setValue(rs.getString("FModel"));
			row.getCell("entryID").setValue(rs.getString("FEntryID"));
			if(WeighBaseStatus.getEnum(billStatus).getAlias().endsWith("���")) {
				row.getStyleAttributes().setBackground(new Color(165,231,92));
			}
		}
		rs.close();
		// this.resetBill();
	}

	private IRowSet getExeQueryRowSet(OrgUnitInfo orgInfo,String beginDate,String endDate,String materialID,String carID,String otherCondition,String carNumber) throws BOSException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select tb.CFPurnumber orderNumber,tb.FID,te.FID FEntryID,tm.FID FMaterialID,tm.FNumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,");
		sql.append(" tb.FBizDate,tcar.FNumber FCarNum,te.CFTare,te.CFGross,te.CFSuttle,tb.FNumber,");
		sql.append(" te.CFTare2,te.CFImpurity,tsupplier.FName_l2 FSupplierName,tStorage.fname_l2 FOrderStorageOrgUnitName,te.CFWeighTime CFInTime,");
		sql.append(" te.CFWeighTimeGross CFOutTime,tb.CFBillStatus,tCurStorage.Fname_l2 FStorageName,te.CFImpurity2");
		sql.append(" from ").append(billTable).append(" tb");
		sql.append(" left join t_bd_supplier tSupplier on tSupplier.FID=tb.CFSupplierID");
		sql.append(" left join t_org_storage tCurStorage on tCurStorage.FID=tb.CFStorageOrgUnitID");
		sql.append(" left join t_org_storage tStorage on tStorage.FID=tb.CFOrderStorageOrgU");
		sql.append(" inner join ").append(billEntryTable).append(" te on te.FParentID=tb.FID");
		sql.append(" inner join ").append(carTable).append(" tcar on tcar.FID=tb.CFCarID");
		sql.append(" inner join t_bd_material tm on tm.FID=te.CFMaterialID");
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
		if(StringUtils.isNotBlank(carID)) {
			sql.append(" and tb.CFCarID='").append(carID).append("'");;
		}
		if(StringUtils.isNotBlank(carNumber)) {
			sql.append(" and tb.CFCarNum like'%").append(carNumber).append("%'");;
		}
		if(StringUtils.isNotBlank(materialID)) {
			sql.append(" and te.CFMaterialID='").append(materialID).append("'");
		}
		if(StringUtils.isNotBlank(otherCondition)) {
			sql.append(otherCondition);
		}
		//sql.append(" order by tb.FBizDate desc,te.FSeq asc");
		//add 20150730
		sql.append(" union all");
		sql.append(" select tb.CFPurnumber orderNumber,tb.FID,te.FID FEntryID,tm.FID FMaterialID,tm.FNumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,");
		sql.append(" tb.FBizDate,tb.CFCarNum FCarNum,te.CFTare,te.CFGross,te.CFSuttle,tb.FNumber,");
		sql.append(" te.CFTare2,te.CFImpurity,tsupplier.FName_l2 FSupplierName,tStorage.fname_l2 FOrderStorageOrgUnitName,te.CFWeighTime CFInTime,");
		sql.append(" te.CFWeighTimeGross CFOutTime,tb.CFBillStatus,tCurStorage.Fname_l2 FStorageName,te.CFImpurity2");
		sql.append(" from ").append(billTable).append(" tb");
		sql.append(" left join t_bd_supplier tSupplier on tSupplier.FID=tb.CFSupplierID");
		sql.append(" left join t_org_storage tCurStorage on tCurStorage.FID=tb.CFStorageOrgUnitID");
		sql.append(" left join t_org_storage tStorage on tStorage.FID=tb.CFOrderStorageOrgU");
		sql.append(" inner join ").append(billEntryTable).append(" te on te.FParentID=tb.FID");
//		sql.append(" inner join ").append(carTable).append(" tcar on tcar.FID=tb.CFCarID");
		sql.append(" inner join t_bd_material tm on tm.FID=te.CFMaterialID");
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
		if(StringUtils.isNotBlank(carID)) {
//			sql.append(" and tb.CFCarID='").append(carID).append("'");;
		}
		if(StringUtils.isNotBlank(carNumber)) {
			sql.append(" and tb.CFCarNum like '%").append(carNumber).append("%'");;
		}
		if(StringUtils.isNotBlank(materialID)) {
			sql.append(" and te.CFMaterialID='").append(materialID).append("'");
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
//				MsgBox.showWarning("ֻ�ܴ�ӡ������ɵĵ��ݣ�");
//				SysUtil.abort();
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
//				MsgBox.showWarning("ֻ�ܴ�ӡ������ɵĵ��ݣ�");
//				SysUtil.abort();
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
		return "/bim/weighbridge/FeInStorageBill";
	}

	protected IMetaDataPK getTDQueryPK() {
		return new MetaDataPK("com.kingdee.eas.weighbridge.app.FeInStorageBillQuery");
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
		return FeInStorageBillFactory.getRemoteInstance();
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
	@Override
	protected void btnSaveWeigh_actionPerformed(ActionEvent e)
			throws Exception {
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
			
			
			saveWeighLog("��������-��������");
			MsgBox.showInfo("�����������");
		}
		
	}
	
}