package banking.accounts;

import java.io.Serializable;
import java.util.Observable;

import banking.exceptions.WithdrawalException;

public abstract class Account extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -932976978376848164L;
	private int accountId;
	private double balance;

	public abstract void deposit(double sum);

	public abstract void withdraw(double sum) throws WithdrawalException;

	public Account(int accId) {
		setAccountId(accId);
		setBalance(0);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {

			System.out.println(getClass() + " " + obj.getClass());
			return false;
		}

		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balane=" + balance + "]";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balane) {
		this.balance = balane;
	}

}
