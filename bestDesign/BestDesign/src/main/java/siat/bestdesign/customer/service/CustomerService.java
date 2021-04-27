package siat.bestdesign.customer.service;

import java.util.Map;


import siat.bestdesign.customer.domain.CustomerVO;

public interface CustomerService {

	CustomerVO mapToCustomer(Map<String, Object> map);

	void insertCustomer(CustomerVO vo);

	int selectLogin(CustomerVO vo);

	int checkId(CustomerVO vo);




}
