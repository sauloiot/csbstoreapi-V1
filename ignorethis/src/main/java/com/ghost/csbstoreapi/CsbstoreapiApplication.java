package com.ghost.csbstoreapi;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.ghost.csbstoreapi.models.enums.StatePayment;
import com.ghost.csbstoreapi.models.enums.ClientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.models.location.City;
import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.models.user.Address;
import com.ghost.csbstoreapi.models.location.State;
import com.ghost.csbstoreapi.models.purchase.ItemBuyOrder;
import com.ghost.csbstoreapi.models.purchase.Payment;
import com.ghost.csbstoreapi.models.purchase.PaymentSlip;
import com.ghost.csbstoreapi.models.purchase.PaymentCard;
import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import com.ghost.csbstoreapi.models.Product;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import com.ghost.csbstoreapi.repositories.CityRepository;
import com.ghost.csbstoreapi.repositories.ClientRepository;
import com.ghost.csbstoreapi.repositories.AddressRepository;
import com.ghost.csbstoreapi.repositories.StateRepository;
import com.ghost.csbstoreapi.repositories.ItemBuyOrderRepository;
import com.ghost.csbstoreapi.repositories.PaymentRepository;
import com.ghost.csbstoreapi.repositories.BuyOrderRepository;
import com.ghost.csbstoreapi.repositories.ProductRepository;

@SpringBootApplication
public class CsbstoreapiApplication {



	public static void main(String[] args) {
		SpringApplication.run(CsbstoreapiApplication.class, args);
	}


}
