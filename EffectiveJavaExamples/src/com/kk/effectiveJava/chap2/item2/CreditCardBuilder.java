package com.kk.effectiveJava.chap2.item2;

public class CreditCardBuilder {

	private String cardNo;
	private String month;
	private String year;
	private String cvv;

	public CreditCardBuilder(String cardNo, String cvv) {
		this.cardNo = cardNo;
		this.cvv = cvv;
	}

	public CreditCardBuilder year(String year) {
		this.year = year;
		return this;
	}

	public CreditCardBuilder month(String month) {
		this.month = month;
		return this;
	}

	public CreditCard build() {
		return new CreditCard(this);
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
	
	
}
