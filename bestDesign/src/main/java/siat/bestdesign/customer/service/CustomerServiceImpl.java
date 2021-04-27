package siat.bestdesign.customer.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.customer.dao.CustomerDAOImpl;
import siat.bestdesign.customer.domain.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAOImpl customerDAO;

	@Override
	public CustomerVO mapToCustomer(Map<String, Object> map) {
		CustomerVO vo = new CustomerVO((String)map.get("userID"), (String)map.get("userPassword"), (String)map.get("userName"), (String)map.get("userEmail"), (String)map.get("userBirth"), (String)map.get("userPhone"));
		return vo;
	}

	@Override
	public void insertCustomer(CustomerVO vo) {
		customerDAO.insertCustomer(vo);
		
	}

	@Override
	public int selectLogin(CustomerVO vo) {
		CustomerVO vo2 = customerDAO.selectLogin(vo);
		if(vo2!=null) {
			if(vo2.getCustomerPwd().equals(vo.getCustomerPwd())) {
				return 1;//성공
			}
			return 2;//비밀번호 틀릭
		}else {
			return 0;//사용자 존재하지 않음
		}
	}

	@Override
	public int checkId(CustomerVO vo) {
		CustomerVO result = customerDAO.selectLogin(vo);
		if(result!=null){
			return 1;//존재
		}else{
			if(vo.getCustomerId().length()==0){
				return 2;//아이디 먼저 입력해
			}else{
				return 0;//사용 가능
			}
		}
	}

}
