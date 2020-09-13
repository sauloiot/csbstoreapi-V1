package com.ghost.csbstoreapi.services;

import java.util.Date;
import java.util.Optional;

import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.models.enums.StatePayment;
import com.ghost.csbstoreapi.models.purchase.ItemBuyOrder;
import com.ghost.csbstoreapi.models.purchase.PaymentSlip;
import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.repositories.ItemBuyOrderRepository;
import com.ghost.csbstoreapi.repositories.PaymentRepository;
import com.ghost.csbstoreapi.security.UserSS;
import com.ghost.csbstoreapi.services.Email.EmailService;
import com.ghost.csbstoreapi.services.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import com.ghost.csbstoreapi.repositories.BuyOrderRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;

import javax.transaction.Transactional;

@Service
public class BuyOrderService {
	
	@Autowired
	private BuyOrderRepository repo;

	@Autowired
	private SlipService slipService;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ItemBuyOrderRepository itemBuyOrderRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private EmailService emailService;
	
	public BuyOrder find(Integer id) {
		Optional<BuyOrder> obj = repo.findById(id);
		//send email on find
		//emailService.sendBuyOrderConfirmationEmail(obj.get());
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto not found! Id: " + id + ", Type: " + BuyOrder.class.getName()));

	}

	@Transactional
	public BuyOrder insert(BuyOrder obj){
		obj.setId(null);
		obj.setInstant(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		obj.getPayment().setStatePayment(StatePayment.PENDING);
		obj.getPayment().setBuyOrder(obj);
		if (obj.getPayment() instanceof PaymentSlip){
			PaymentSlip paymentSlip = (PaymentSlip) obj.getPayment();
			slipService.fillPaymentSlip(paymentSlip, obj.getInstant());
		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		for (ItemBuyOrder ibo : obj.getOrderItemSet()){
			ibo.setDiscount(0.0);
			ibo.setProduct(productService.find(ibo.getProduct().getId()));
			ibo.setPrice(productService.find(ibo.getProduct().getId()).getPrice());
			ibo.setBuyOrder(obj);

		}
		itemBuyOrderRepository.saveAll(obj.getOrderItemSet());
//		emailService.sendBuyOrderConfirmationEmail(obj);
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}

	public Page<BuyOrder> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Access denied");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
				orderBy);
		Client client = clientService.find(user.getId());
		return repo.findByClient(client, pageRequest);
	}

}
