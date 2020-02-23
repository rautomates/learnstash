package jcg.zheng.demo.spring.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcg.zheng.demo.spring.entity.Account;
import jcg.zheng.demo.spring.entity.RewardTransaction;
import jcg.zheng.demo.spring.repository.AccountRepository;
import jcg.zheng.demo.spring.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository acctDao;

	@Override
	public Account findByUsername(String username) {
		return acctDao.findByUserName(username);
	}

	@Override
	public Account save(Account accout) {
		Random rand = new Random();
		accout.addTransactions(createTransaction("Shop&Save", "Food items", new BigDecimal(rand.nextInt(100))));
		accout.addTransactions(createTransaction("Webster", "School supplies", new BigDecimal(rand.nextInt(260))));
		accout.addTransactions(createTransaction("KOHL", "Birthday gifts", new BigDecimal(rand.nextInt(300))));
		accout.addTransactions(createTransaction("Macy", "Allen clothes", new BigDecimal(rand.nextInt(100))));
		accout.addTransactions(createTransaction("Home Depot", "Household items", new BigDecimal(rand.nextInt(1000))));
		accout.addTransactions(createTransaction("Wal-mart", "Small items", new BigDecimal(rand.nextInt(60))));
	
		return acctDao.save(accout);
	}
	
	private RewardTransaction createTransaction(String payee, String desp, BigDecimal amount) {
		RewardTransaction trans = new RewardTransaction();
		trans.setCreatedDate(new Date());
		trans.setDescription(desp);
		trans.setAmount(amount);
		trans.setPayeeName(payee);
		return trans;
	}
}
