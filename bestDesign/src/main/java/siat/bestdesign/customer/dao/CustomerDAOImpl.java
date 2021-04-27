package siat.bestdesign.customer.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.customer.domain.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertCustomer(CustomerVO vo) {
		mybatis.insert("customer.customerInsert", vo);
	}

	@Override
	public CustomerVO selectLogin(CustomerVO vo) {
		return mybatis.selectOne("customer.customerLogin",vo);
	}

}
