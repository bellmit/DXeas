package com.kingdee.eas.WSInterface.common;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;

public class TextFilter implements NodeFilter {

	public TextFilter() {
	}

	public short acceptNode(Node n) {
		if (n.getNodeType() == 3)
			return 1;
		return (short) (n.getNodeType() != 8 ? 3 : 2);
	}
}