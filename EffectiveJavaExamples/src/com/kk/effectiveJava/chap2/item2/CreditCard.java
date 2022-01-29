package com.kk.effectiveJava.chap2.item2;

public class CreditCard {

	private String cardNo;
	private String month;
	private String year;
	private String cvv;
	
	protected CreditCard(CreditCardBuilder builder) {
		super();
		this.cardNo = builder.getCardNo();
		this.month = builder.getMonth();
		this.year = builder.getYear();
		this.cvv = builder.getCvv();
	}

	public String getCardNo() {
		return cardNo;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getCvv() {
		return cvv;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Builder ornegi
		sb.append("Card No: ").append(cardNo).append(", month: ").append(month).append(", year: ").append(year).append(", cvv: ").append(cvv);
		return sb.toString();
	}
	
	
}
