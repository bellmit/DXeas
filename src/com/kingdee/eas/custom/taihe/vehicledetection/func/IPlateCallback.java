package com.kingdee.eas.custom.taihe.vehicledetection.func;

import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface IPlateCallback extends StdCallCallback {
		public void ICE_IPCSDK_Plate(int param, 
			String strIP, String strNumber, String strColor, 
			Pointer pPicData, int nLen, Pointer pCloseupData, int nCloseupLen, 
			int nPlatePosLeft, int nPlatePosTop, int nPlatePosRight, int nPlatePosBottom, 
			float fPlateConfidence, int nVehicleColor, int nPlateType, int nVehicleDir, 
			int nAlarmType, int nReserved1, int nReserved2, int nReserved3, int nReserved4);
		
}
