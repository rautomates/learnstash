package jcg.zheng.demo.spring;

import java.math.BigDecimal;
import java.util.Date;

import jcg.zheng.demo.spring.entity.Account;
import jcg.zheng.demo.spring.entity.RewardTransaction;

public class TestData {
	public static Account createDummy(String login, String firstNm, String lastNm) {
		Account dummyAccount = new Account();
		dummyAccount.setFirstname(firstNm);
		dummyAccount.setLastname(lastNm);
		dummyAccount.setUsername(login);

		return dummyAccount;
	}

	public static RewardTransaction createTransaction(String payee, String desp, BigDecimal amount) {
		RewardTransaction trans = new RewardTransaction();
		trans.setCreatedDate(new Date());
		trans.setDescription(desp);
		trans.setAmount(amount);
		trans.setPayeeName(payee);
		return trans;
	}

}
