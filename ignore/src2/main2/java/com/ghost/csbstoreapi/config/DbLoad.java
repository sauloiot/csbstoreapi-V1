package com.ghost.csbstoreapi.config;

import com.ghost.csbstoreapi.model.Category;
import com.ghost.csbstoreapi.model.Product;
import com.ghost.csbstoreapi.model.enums.ClientType;
import com.ghost.csbstoreapi.model.enums.StatePayment;
import com.ghost.csbstoreapi.model.location.City;
import com.ghost.csbstoreapi.model.location.State;
import com.ghost.csbstoreapi.model.purchase.*;
import com.ghost.csbstoreapi.model.user.Address;
import com.ghost.csbstoreapi.model.user.Client;
import com.ghost.csbstoreapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
@Profile({"test"})
public class DbLoad implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BuyOrderRepository buyOrderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "INFORMATICA");
        Category cat2 = new Category(null, "ESCRITORIO");

        Product prod1 = new Product(null, "Computador", 2000.0);
        Product prod2 = new Product(null, "Impressora", 800.0);
        Product prod3 = new Product(null, "Mouse", 150.0);

        cat1.getProducts().addAll((Arrays.asList(prod1,prod2,prod3)));
        cat2.getProducts().addAll((Arrays.asList(prod2)));

        prod1.getCategories().addAll(Arrays.asList(cat1));
        prod2.getCategories().addAll(Arrays.asList(cat1,cat2));
        prod3.getCategories().addAll(Arrays.asList(cat1));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3));

        State st1 = new State(null, "Alagoas");
        State st2 = new State(null, "São Paulo");

        City city1 = new City(null, "Maceió", st1);
        City city2 = new City(null, "São Paulo", st2);
        City city3 = new City(null, "Campinas", st2);

        st1.getCityList().addAll(Arrays.asList(city1));
        st2.getCityList().addAll(Arrays.asList(city2, city3));

        stateRepository.saveAll(Arrays.asList(st1, st2));
        cityRepository.saveAll(Arrays.asList(city1,city2,city3));

        Client cli1 = new Client(null, "Chuck Norris", "CN@hotmail.com", "000.000.001-01", ClientType.PHYSICALPERSON );
        cli1.getPhones().addAll(Arrays.asList("000000001", "000000002"));

        Address address1 = new Address(null, "Rua Chuck","1", "The Home", "The District", "00001-001", cli1, city1);
        Address address2 = new Address(null, "Vera Arruda","175", "Apartamento", "Ponta verde", "00001-001", cli1, city1);
        cli1.getAddressList().addAll(Arrays.asList(address1,address2));

        clientRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(address1, address2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        BuyOrder bo1 = new BuyOrder(null, sdf.parse("30/09/2017 10:32"), cli1, address1 );
        BuyOrder bo2 = new BuyOrder(null, sdf.parse("02/10/2017 09:02"), cli1, address2 );

        Payment pay1 = new PaymentCard(null, StatePayment.PAID, bo1, 6);
        bo1.setPayment(pay1);

        Payment pay2 = new PaymentSlip(null, StatePayment.PENDING, bo2, sdf.parse("20/10/2017 00:00"), null);
        bo2.setPayment(pay2);

        cli1.getOrderList().addAll(Arrays.asList(bo1, bo2));

        buyOrderRepository.saveAll(Arrays.asList(bo1,bo2));
        paymentRepository.saveAll(Arrays.asList(pay1,pay2));

        OrderItem oi1 = new OrderItem(bo1, prod1, 0.00, 1, 2000.00);
        OrderItem oi2 = new OrderItem(bo1, prod3, 0.00, 2, 80.00);
        OrderItem oi3 = new OrderItem(bo2, prod2, 100.00, 1, 800.00);

        bo1.getOrderItemSet().addAll(Arrays.asList(oi1, oi2));
        bo2.getOrderItemSet().addAll(Arrays.asList(oi3));

        prod1.getOrderItemSet().addAll(Arrays.asList(oi1));
        prod2.getOrderItemSet().addAll(Arrays.asList(oi3));
        prod3.getOrderItemSet().addAll(Arrays.asList(oi2));

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));





    }
}
