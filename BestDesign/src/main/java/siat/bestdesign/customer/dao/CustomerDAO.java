package siat.bestdesign.customer.dao;

import siat.bestdesign.customer.domain.CustomerVO;

public interface CustomerDAO {

	void insertCustomer(CustomerVO vo);
	
	CustomerVO selectLogin(CustomerVO vo);
}
