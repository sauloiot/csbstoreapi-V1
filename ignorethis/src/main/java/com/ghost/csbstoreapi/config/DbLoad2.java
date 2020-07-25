package com.ghost.csbstoreapi.config;

import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.models.Product;
import com.ghost.csbstoreapi.models.enums.ClientType;
import com.ghost.csbstoreapi.models.enums.StatePayment;
import com.ghost.csbstoreapi.models.location.City;
import com.ghost.csbstoreapi.models.location.State;
import com.ghost.csbstoreapi.models.purchase.*;
import com.ghost.csbstoreapi.models.user.Address;
import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class DbLoad2 implements CommandLineRunner {

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
    private ItemBuyOrderRepository itemBuyOrderRepository;

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

        st1.getCidades().addAll(Arrays.asList(city1));
        st2.getCidades().addAll(Arrays.asList(city2, city3));

        stateRepository.saveAll(Arrays.asList(st1, st2));
        cityRepository.saveAll(Arrays.asList(city1,city2,city3));
        Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICALPERSON);

        cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

        Address e1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, city1);
        Address e2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, city2);

        cli1.getAddress().addAll(Arrays.asList(e1, e2));

        clientRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        BuyOrder ped1 = new BuyOrder(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        BuyOrder ped2 = new BuyOrder(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        Payment pagto1 = new PaymentCard(null, StatePayment.PAID, ped1, 6);
        ped1.setPayment(pagto1);

        Payment pagto2 = new PaymentSlip(null, StatePayment.PAID, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPayment(pagto2);

        cli1.getBuyOrder().addAll(Arrays.asList(ped1, ped2));

        buyOrderRepository.saveAll(Arrays.asList(ped1, ped2));
        paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemBuyOrder ip1 = new ItemBuyOrder(ped1, prod1, 0.00, 1, 2000.00);
        ItemBuyOrder ip2 = new ItemBuyOrder(ped1, prod2, 0.00, 2, 80.00);
        ItemBuyOrder ip3 = new ItemBuyOrder(ped2, prod3, 100.00, 1, 800.00);

        ped1.getOrderItemSet().addAll(Arrays.asList(ip1, ip2));
        ped2.getOrderItemSet().addAll(Arrays.asList(ip3));

        prod1.getItemBuyOrder().addAll(Arrays.asList(ip1));
        prod2.getItemBuyOrder().addAll(Arrays.asList(ip3));
        prod3.getItemBuyOrder().addAll(Arrays.asList(ip2));

        itemBuyOrderRepository.saveAll(Arrays.asList(ip1, ip2, ip3));


    }
}
