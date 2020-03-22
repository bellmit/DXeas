//package com.kingdee.eas.custom.taihe.vehicledetection.func;
//
//import com.sun.jna.Library;
//import com.sun.jna.Native;
//import com.sun.jna.Pointer;
//import com.sun.jna.platform.win32.WinDef;
//import com.sun.jna.ptr.IntByReference;
//
//public interface JNADll extends Library {
//	
//
//	String strdir = "C:\\Users\\lenovo\\Desktop\\SDK32\\ice_ipcsdk.dll";//System.getProperty("user.dir") + "\\ice_ipcsdk.dll";
//    JNADll ICESDKInstance = (JNADll) Native.loadLibrary(strdir, JNADll.class);
//    /**
//    *  @brief  全局初始化
//    *  @return void
//    */
//    public void ICE_IPCSDK_Init();
//    /**
//    *  @brief  视频接入
//    *  @param  [IN] pcIP                    相机ip
//    *  @param  [IN] u8OverTCP               是否使用tcp模式（1：使用tcp 0：不使用tcp，使用udp）
//    *  @param  [IN] u8MainStream            是否请求主码流（1：主码流 0：子码流）
//    *  @param  [IN] hWnd                    预览视频的窗口句柄
//    *  @param  [IN] pfOnPlate               车牌回调
//    *  @param  [IN] pvPlateParam            车牌回调参数，能区分开不同的使用者即可
//    *  @return sdk句柄(连接不成功时,返回值为null)
//    */
//    public int ICE_IPCSDK_OpenPreview(String ip, byte tcp, byte stream, 
//    		WinDef.HWND hWnd, IPlateCallback callback, int param);
//    
//    /**
//    *  @brief  连接设备，不带视频流
//    *  @param  [IN] pcIP      ip地址
//    *  @return sdk句柄(连接不成功时,返回值为null) 
//    */
//    public int ICE_IPCSDK_OpenDevice(String ip);
//    
//    /**
//    *  @brief  设置抓拍事件回调
//    *  @param  [IN] hSDK            sdk句柄
//    *  @param  [IN] pfOnPlate       车牌回调
//    *  @param  [IN] pvParam         车牌回调参数,能区分开不同的使用者即可
//    *　@return void
//    */
//    public void ICE_IPCSDK_SetPlateCallback(int hSDK, IPlateCallback callback, int param);
//    
//    /**
//    *  @brief  断开连接
//    *  @param  [IN] hSDK    sdk句柄
//    *  return void
//    */
//    public void ICE_IPCSDK_Close(int hSDK);
//    
//    /**
//    *  @brief  抓拍信息输出编码配置
//    *  @param  [IN] hSDK       sdk句柄
//    *  @param  [IN] enable     是否以UTF-8编码输出抓拍信息
//    *  @return void
//    */
//    public void ICE_IPCSDK_EnableUTF8(int hSDK, int enable);
//    
//    /**
//     * 语言播报
//     * @param hSDK sdk句柄
//     * @param pcIndex 语音列表序号 空格或分号分隔
//     * @return
//     */
//    public int ICE_IPCSDK_BroadcastGroup(int hSDK, String pcIndexs);
//    
//    /**
//     * 获取脱机语音播报配置
//     * @param hSDK sdk句柄
//     * @param pstParam 脱机语音播报参数（输出）
//     * @return
//     */
//    public int ICE_IPCSDK_GetOfflineAoParam(int hSDK, OfflineAoParam pstParam);
//
//    /**
//     * 设置脱机语音播报配置
//     * @param hSDK
//     * @param pstParam 脱机语音播报参数（输入）
//     * @return
//     */
//    public int ICE_IPCSDK_SetOfflineAoParam(int hSDK, OfflineAoParam pstParam);
//
//
//    
//    /**
//    *  @brief  软触发扩展接口
//    *  @param  [IN] hSDK          sdk句柄
//    *  @return 0 失败, 1 成功, 2 正在识别, 3 算法未启动
//    */
//    public int ICE_IPCSDK_TriggerExt(int hSDK);
//    
//    /**
//    *  @brief  打开道闸
//    *  @param  [IN] hSDK  连接相机时返回的sdk句柄
//    *  @return 1 打开成功 0 打开失败
//    */
//    public int ICE_IPCSDK_OpenGate(int hSDK);
//    
//    /**
//     * 获得白名单的总数 	new
//     * @param hSDK
//     * @param count
//     * @return
//     */
//    public int  ICE_IPCSDK_GetWhiteCount(int hSDK,IntByReference pu32Count);
//    
//    /**
//     * 获取黑名单总数
//     * @param hSDK
//     * @param pu32Count
//     * @return
//     */
//    public int  ICE_IPCSDK_GetBlackCount(int hSDK,IntByReference pu32Count);
//    
//    /**
//     * 获得白名单 new
//     * @param hSDK
//     * @param s32Index
//     * @param pcNumber
//     * @param pcDateBegin
//     * @param pcDateEnd
//     * @param pcTimeBegin
//     * @param pcTimeEnd
//     * @param pcRsrv1
//     * @param pcRsrv2
//     * @param pcRsrv3
//     * @param pcRsrv4
//     * @return
//     */
//    public int  ICE_IPCSDK_GetWhiteItem(int hSDK, int s32Index, Pointer pcNumber, 
//    		Pointer pcDateBegin, Pointer pcDateEnd, Pointer pcTimeBegin, Pointer pcTimeEnd, 
//    		Pointer pcRsrv1, Pointer  Pointer, Pointer pcRsrv3, Pointer pcRsrv4);
//
//
//    /**
//     * 获得白名单的总数 	old
//     * @param hSDK
//     * @param count
//     * @return
//     */
//    public int  ICE_IPCSDK_WhiteListGetCount(int hSDK, IntByReference pu32Count);
//
//    /**
//     * 获得白名单 Old
//     * @param hSDK
//     * @param s32Index
//     * @param pcNumber
//     * @param pcDateBegin
//     * @param pcDateEnd
//     * @param pcTimeBegin
//     * @param pcTimeEnd
//     * @param pcRsrv1
//     * @param pcRsrv2
//     * @param pcRsrv3
//     * @param pcRsrv4
//     * @return
//     */
//    public int  ICE_IPCSDK_WhiteListGetItem(int hSDK, int s32Index, Pointer pcNumber, 
//    		Pointer pcDateBegin, Pointer pcDateEnd, Pointer pcTimeBegin, Pointer pcTimeEnd, 
//    		Pointer pcRsrv1, Pointer  pcRsrv2, Pointer pcRsrv3, Pointer pcRsrv4);
//    /**
//    *  @brief  全局释放
//    *  @return void
//    */
//    public int ICE_IPCSDK_Fini();
//}
