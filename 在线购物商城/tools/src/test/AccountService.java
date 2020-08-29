package test;

import java.sql.SQLException;

import cn.itcast.jdbc.JdbcUtils;

public class AccountService {
	private AccountDao accountDao = new AccountDao();
	
	public Account findAccountByName(String name) {
		try {
			return accountDao.findAccountByName(name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 测试事务
	 * @param from
	 * @param to
	 * @param money
	 */
	public void transfer(Account from, Account to, double money) {
		try {
			System.out.println("转账前:"+from+to+"\n"+from.getName()+"给"+to.getName()+"转账金额:"+money+"\n");
			JdbcUtils.beginTransaction();
			from.setBalance(from.getBalance() - money);
			to.setBalance(to.getBalance() + money);
			accountDao.update(from);
			accountDao.update(to);
			if(from.getBalance() < 0) {
				throw new Exception("zs" + money + "!");
			}
			JdbcUtils.commitTransaction();
			System.out.println("转账后:"+from+to+"\n"+to.getName()+"收"+from.getName()+"转账金额:"+money+"\n");
		} catch(Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e);
		}
	}
}
