package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.shopping.exception.EmailException;
import com.academy.shopping.exception.OrderDetailException;
import com.academy.shopping.exception.OrderSummaryException;
import com.academy.shopping.model.domain.OrderDetail;
import com.academy.shopping.model.domain.OrderSummary;
import com.academy.shopping.model.util.MailFormReader;
import com.academy.shopping.model.util.MailSender;

@Service
public class OrderSummaryServiceImpl implements OrderSummaryService {

	// 주문 요약관련DAO
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;

	@Autowired
	private MailSender mailSender;
	@Autowired
	private MailFormReader mailFormReader;

	// 주문 상세 관련 DAO
	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public void order(OrderSummary orderSummary) throws OrderDetailException, OrderSummaryException, EmailException {
		// insert 호출 전 ordersummary dto안의 ordersymmary_id의 값은 0
		orderSummaryDAO.insert(orderSummary);
		// insert 호출 이후에 OrderSummary DTO안의 ordersummary_id 값은? 가장 최근에 일으킨 시퀀스 값으로 대체

		// 구매한 물건 수 만큼 반복문 돌린다.

		for (int i = 0; i < orderSummary.getOrderDetailList().size(); i++) {
			OrderDetail orderDetail = orderSummary.getOrderDetailList().get(i);

			// OrderDetail이 필요로 하는 부모의 foreign key 값을 대입해주자.
			orderDetail.setOrdersummary_id(orderSummary.getOrdersummary_id());
			orderDetailDAO.insert(orderDetail);

		}
		System.out.println("서비스에서의 mailform 경로" + mailFormReader.getPath());

		// 이메일 발송
		String content = mailFormReader.getStringFromMailForm("뭘 봐?");
		mailSender.send(content);

	}

	@Override
	public List selectAll() {

		return null;
	}

	@Override
	public OrderSummary select(int ordersummary_id) {

		return null;
	}

	@Override
	public OrderSummary selectByCustomerId(int ordersummary_id) {

		return null;
	}

	@Override
	public void update(OrderSummary ordersummary) {
	}

	@Override
	public void delete(OrderSummary ordersummary) {
	}

}
