package com.kingdee.eas.wlhlcomm;

import com.kingdee.bos.BOSException;

/**
 * ����ҵ�쳣
 * @author USER
 *
 */
public class FarmException extends BOSException {
	
	
	public FarmException(String message) {
		super(message);
	}

	public FarmException(String message, Throwable cause) {
		super(message, cause);
	}

	public FarmException(Throwable cause) {
		super(cause);
	}

}
