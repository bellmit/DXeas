///**
// * output package name
// */
//package com.kingdee.eas.custom.taihe.vehicledetection.client;
//
//import java.awt.Color;
//import java.awt.GridLayout;
//import java.awt.Panel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import net.sf.json.JSONObject;
//
//import org.apache.log4j.Logger;
//
//import com.kingdee.bos.ctrl.swing.KDLayout;
//import com.kingdee.bos.dao.query.SQLExecutorFactory;
//import com.kingdee.bos.ui.face.CoreUIObject;
//import com.kingdee.eas.custom.taihe.vehicledetection.IVCFunctionFacade;
//import com.kingdee.eas.custom.taihe.vehicledetection.VCFunctionFacadeFactory;
//import com.kingdee.eas.custom.taihe.vehicledetection.func.IPlateCallback;
//import com.kingdee.eas.custom.taihe.vehicledetection.func.JNADll;
//import com.kingdee.eas.util.client.MsgBox;
//import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
//import com.kingdee.jdbc.rowset.IRowSet;
//import com.sun.jna.Memory;
//import com.sun.jna.Native;
//import com.sun.jna.Pointer;
//import com.sun.jna.platform.win32.WinDef;
//import com.sun.jna.ptr.IntByReference;
//
///**
// * output class name
// */
//public class VCControlPlatfromUI extends AbstractVCControlPlatfromUI
//{
//    private static final Logger logger = CoreUIObject.getLogger(VCControlPlatfromUI.class);
//	private static int channelCount=0;
//	private static int[] count ;
//	private static String[] strNumbers ;
//	private static String[] strColors ;   
//	private static int[] hSDK ;//操作标识位
//	private static Panel[] panel ;
//	private static String[] strIPs;//通道IP
//	private static int[] channelType;//通道类型
//	private static PlateCallback callback ;//= new PlateCallback();
//	private IVCFunctionFacade ivcs;
//	
//    /**
//     * output class constructor
//     */
//    public VCControlPlatfromUI() throws Exception
//    {
//        super();
//        this.setUITitle("车辆识别");
//        init();
//    }
//    
//    
//    @Override
//	public boolean destroyWindow() {
//		// TODO Auto-generated method stub
//    	relaseResource();
//		return super.destroyWindow();
//	}
//
//
//
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		relaseResource();
//		super.finalize();
//	}
//	
//	private void init() throws Exception {
////		strIPs=new String[]{"10.1.2.202","10.1.2.204"};
//		ivcs = VCFunctionFacadeFactory.getRemoteInstance();
//		String cpuID = ComReaderUtils.getLocalMac();
//		StringBuffer sql=new StringBuffer();
//		sql.append(" select FIp,FInOrOut from T_VEH_VdChannelSetting ")
//		.append(" where FCpuID='").append(cpuID).append("'")
//		.append(" order by fip ")
//		;
//		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
//		channelCount=rs.size();
//		if(channelCount<=0){
//			MsgBox.showWarning("本机尚未进行通道配置！");
//		}
//		
//		strIPs=new String[channelCount];
//		channelType=new int[channelCount];
//		count = new int[channelCount];
//		strNumbers = new String[channelCount];
//		strColors = new String[channelCount];   
//		hSDK = new int[channelCount];
//		panel = new Panel[channelCount];
//		
//		while(rs.next()) {
//			strIPs[rs.getRow()-1]=rs.getString("FIp");
//			channelType[rs.getRow()-1]=rs.getInt("FInOrOut");
//		}
//		initPanel();
//	}
//
//	private void initPanel() {
//		int x=0;
//		int y=2;
//		int width = 500;//(int) panelVedio.getBounds().getWidth();
//		int height=500;//(int) panelVedio.getBounds().getHeight();
//		/*if(width/2>height) {
//			width=width/2;
//			height=width;
//		}else {
//			width=height;
//		}*/
//		
//		panelVedio.setLayout(new GridLayout(2,2));
//		 for (int i = 0; i < channelCount; i++) {
//			x=(i % 2) *width+2;
//    		panel[i] = new Panel();
//            panel[i].setBounds(x,y, width, height);
//            panel[i].setBackground(Color.BLACK);
////	            panelVedio.add(panel[i]);
//            panelVedio.add(panel[i], new KDLayout.Constraints(x+2, y, width, height, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
//        }
//        this.btnOpen.addActionListener(new OpenGateListener());
//	}
//	
//	private void initJNA() throws Exception {
//		callback = new PlateCallback();
//		  /***********************画界面****************************/
//        JNADll.ICESDKInstance.ICE_IPCSDK_Init();//全局初始化
//        
//        try {
//	        for (int i = 0; i < strIPs.length; i++) {
//	        	hSDK[i] = JNADll.ICESDKInstance.ICE_IPCSDK_OpenPreview(strIPs[i], (byte)1, (byte)1, createHWNDByComponent(panel[i]), callback, i);//连接相机
//	        	if(hSDK[i] == 0) {
//	        		System.out.println(strIPs[i] + ": connect failed");
//		        	System.out.println(strIPs[i] + ": connect successed");
//		        	JNADll.ICESDKInstance.ICE_IPCSDK_EnableUTF8(hSDK[i], 1);//设置抓拍数据为utf8传输
//	        	}
//	        }
//        }catch(Exception err) {
//        	throw new Exception(err);
//        }
//	}
//	
//	
//	
//	 @Override
//	public void onShow() throws Exception {
//		// TODO Auto-generated method stub
//		super.onShow();
//		initJNA();
//	}
//	 
//
//	private static WinDef.HWND createHWNDByComponent(Panel panel) {
//	        return new WinDef.HWND(Native.getComponentPointer(panel));
//	    }
//
//	/**
//     * 释放资源
//     */
//    private void relaseResource() {
//      	for (int i = 0; i < channelCount; i++) {
//          	if (hSDK[i] != 0) {
//          		JNADll.ICESDKInstance.ICE_IPCSDK_Close(hSDK[i]);//断开连接
//          		hSDK[i] = 0;
//          	}
//      	}
//        JNADll.ICESDKInstance.ICE_IPCSDK_Fini();//全局释放
//    }
//    
//    class  PlateCallback  implements IPlateCallback {
//    	public void ICE_IPCSDK_Plate(int param, 
//    		String strIP, String strNumber, String strColor, 
//    		Pointer pPicData, int nLen, Pointer pCloseupData, int nCloseupLen, 
//    		int nPlatePosLeft, int nPlatePosTop, int nPlatePosRight, int nPlatePosBottom, 
//    		float fPlateConfidence, int nVehicleColor, int nPlateType, int nVehicleDir, 
//    		int nAlarmType, int nReserved1, int nReserved2, int nReserved3, int nReserved4)
//    		{
//				System.out.println("IP:"+strIP);
//				System.out.println("车牌号："+strNumber);
//				System.out.println("车牌号颜色："+strColor);
//	    		 if(!strNumber.equals("无牌车")) {
//	    			 txtCarNum.setText(strNumber);
//	    			JSONObject json=new JSONObject();
//	    			json.put("carNum", strNumber);
//	    			for(int index=0;index<strIPs.length;index++) {
//	    				if(strIP.equals(strIPs[index])) {
//	    					json.put("channelType", channelType[index]);
//	    					break;
//	    				}
//	    			}
//	    			try {
//	    				json=JSONObject.fromObject(ivcs .checkPermission(json.toString()));
//	    				if(json.getBoolean("canAcross")) {
//	    					lblInfo.setForeground(Color.green);
//	    					openGate();
//	    				}else {
//	    					lblInfo.setForeground(Color.red);
//	    				}
//	    				lblInfo.setText("信息："+json.getString("msg"));
//					} catch (Exception e) {
//					} 
//	    			 
//	    		 }else {
//	    			 txtCarNum.setText(null);
//	    			 lblInfo.setText("信息：");
//	    			 lblInfo.setForeground(Color.blue);
//	    		 }
//				count[param]++;
//				strNumbers[param] = strNumber;
//				strColors[param] = strColor;
//			
//			/*String strTitle = new String();
//			for (int i = 0; i < panelCount; i++) {
//				if (hSDK[i] == 0)
//					continue;
//				
//				strTitle += (i + 1) + "." + strIPs[i] + "," + count[i] + 
//						"," + strNumbers[i] + "," + strColors[i] + " ";
//			}
//			if(nLen > 0){
//				byte[] dst = new byte[nLen];
//				pPicData.read(0, dst, 0, nLen);
//				savePic(strIP, strNumber, dst, 0, 0);//存全景图
//			}
//			
//			if(nCloseupLen > 0){
//				byte[] dst = new byte[nCloseupLen];
//				pCloseupData.read(0, dst, 0, nCloseupLen);
//				savePic(strIP, strNumber, dst, 1, 0);//存车牌图
//			}*/
//		}
//	}
//    
//    //打开道闸
//	   public class OpenGateListener implements ActionListener{
//	        @Override
//	        public void actionPerformed(ActionEvent e) {	
//	        	for (int i = 0; i < channelCount; i++) {
//	            	if (hSDK[i] != 0) {
//	            		int success = 0;//
////	            		success=JNADll.ICESDKInstance.ICE_IPCSDK_OpenGate(hSDK[i]);
//	            		if(1 == success)
//	            			System.out.println("Camera" + (i+1) + ": openGate successed");
//	            		else
//	            			System.out.println("Camera" + (i+1) + ": openGate failed");
//
////	            		success = JNADll.ICESDKInstance.ICE_IPCSDK_BroadcastGroup(hSDK[i],"45");	            		
////	            		OfflineAoParam dd=new OfflineAoParam();
////	            		int success = JNADll.ICESDKInstance.ICE_IPCSDK_GetOfflineAoParam(hSDK[i],dd);
//	            		IntByReference count=new IntByReference();
//	            		success=JNADll.ICESDKInstance.ICE_IPCSDK_WhiteListGetCount(hSDK[i], count);
//	            		System.out.println("whilteCount:"+count.getValue());
////	            		success=JNADll.ICESDKInstance.ICE_IPCSDK_GetBlackCount(hSDK[i], count);
////	            		System.out.println("blackCount:"+count.getValue());
//	            		Pointer pcDateBegin=new Memory(20);
//	            		Pointer pcNumber=new Memory(20);
//	            		Pointer pcRsrv2=new Memory(20);
//	            		Pointer pcTimeBegin=new Memory(20);
//	            		Pointer pcRsrv4=new Memory(20);
//	            		Pointer pcTimeEnd=new Memory(20);
//	            		Pointer pcRsrv3=new Memory(20);
//	            		Pointer pcRsrv1=new Memory(20);
//	            		Pointer pcDateEnd=new Memory(20);
//						for(int index=0;index<count.getValue();index++) {
//							  success=JNADll.ICESDKInstance.ICE_IPCSDK_WhiteListGetItem(hSDK[i], index, pcNumber, pcDateBegin,
//		            			pcDateEnd, pcTimeBegin, pcTimeEnd, pcRsrv1, pcRsrv2, pcRsrv3, pcRsrv4);
//								System.out.println("白名单车牌号("+(index)+");Number:"+pcNumber.getString(0)+
//										";beginDate:"+pcDateBegin.getString(0)+";extParams:"+pcRsrv1.getString(0));
//						}
//	            		if(success==1)
//	            			System.out.println("test" + (i+1) + ": test successed");
//	            		else
//	            			System.out.println("test" + (i+1) + ": test failed");
//	            	}
//	        	}	 
//	        }
//	    }
//	   
//	   /**
//	    * 开门
//	    */
//	   private void openGate() {
//		   for (int i = 0; i < channelCount; i++) {
//           	if (hSDK[i] != 0) {
//           		int success=JNADll.ICESDKInstance.ICE_IPCSDK_OpenGate(hSDK[i]);
//           		if(1 == success)
//           			System.out.println("Camera" + (i+1) + ": openGate successed");
//           		else
//           			System.out.println("Camera" + (i+1) + ": openGate failed");
//           	}
//		   }
//	   }
//}