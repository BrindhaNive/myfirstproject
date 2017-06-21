package com.epyloc.pacs.constants;

public enum TxnTypeEnum {

	FD_INT_CREDIT("FD INTREST CREDIT"), 
	FD_INT_DEBIT("FD INTREST PAYMENT");

	private String txnTypName;

	private TxnTypeEnum(String txnTypName) {
		this.setTxnTypName(txnTypName);
	}

	public String getTxnTypName() {
		return txnTypName;
	}

	public void setTxnTypName(String txnTypName) {
		this.txnTypName = txnTypName;
	}

	public static TxnTypeEnum getEnumByPrivilegeName(String txnTypName) {
		for (TxnTypeEnum value : TxnTypeEnum.values()) {
			if (value.getTxnTypName().equalsIgnoreCase(txnTypName)) {
				return value;
			}
		}
		return null;
	}

}
