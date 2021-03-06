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
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class DbLoad implements CommandLineRunner {

//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private StateRepository stateRepository;
//    @Autowired
//    private CityRepository cityRepository;
//    @Autowired
//    private ClientRepository clientRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private BuyOrderRepository buyOrderRepository;
//    @Autowired
//    private PaymentRepository paymentRepository;
//    @Autowired
//    private ItemBuyOrderRepository itemBuyOrderRepository;

    @Override
    public void run(String... args) throws Exception {
//
//        Category cat1 = new Category(null, "INFORMATICA");
//        Category cat2 = new Category(null, "ESCRITORIO");
//        Category cat3 = new Category(null, "Cama mesa e banho");
//        Category cat4 = new Category(null, "DB load category 4");
//        Category cat5 = new Category(null, "DB load category 5");
//        Category cat6 = new Category(null, "DB load category 6");
//        Category cat7 = new Category(null, "DB load category 7");
//        Category cat8 = new Category(null, "DB load category 8");
//
//        Product prod1 = new Product(null, "Computador", 2000.0);
//        Product prod2 = new Product(null, "Impressora", 800.0);
//        Product prod3 = new Product(null, "Mouse", 150.0);
//        Product prod4 = new Product(null, "prod4", 150.0);
//        Product prod5 = new Product(null, "prod5", 150.0);
//        Product prod6 = new Product(null, "prod6", 150.0);
//        Product prod7 = new Product(null, "prod7", 150.0);
//        Product prod8 = new Product(null, "prod8", 150.0);
//        Product prod9 = new Product(null, "prod9", 150.0);
//        Product prod10 = new Product(null, "prod10", 150.0);
//        Product prod11 = new Product(null, "prod11", 150.0);
//        Product prod12 = new Product(null, "prod12", 150.0);
//        Product prod13 = new Product(null, "prod13", 150.0);
//        Product prod14 = new Product(null, "prod14", 150.0);
//        Product prod15 = new Product(null, "prod15", 150.0);
//        Product prod16 = new Product(null, "prod16", 150.0);
//        Product prod17 = new Product(null, "prod17", 150.0);
//        Product prod18 = new Product(null, "prod18", 150.0);
//        Product prod19 = new Product(null, "prod19", 150.0);
//
//        cat1.getProducts().addAll((Arrays.asList(prod1,prod2,prod3)));
//        cat2.getProducts().addAll((Arrays.asList(prod4, prod14,prod11)));
//        cat3.getProducts().addAll((Arrays.asList(prod5, prod15)));
//        cat4.getProducts().addAll((Arrays.asList(prod6, prod16, prod13)));
//        cat5.getProducts().addAll((Arrays.asList(prod7, prod17)));
//        cat6.getProducts().addAll((Arrays.asList(prod8, prod18)));
//        cat7.getProducts().addAll((Arrays.asList(prod9, prod19)));
//        cat8.getProducts().addAll((Arrays.asList(prod10, prod12)));
//
//
//        prod1.getCategories().addAll(Arrays.asList(cat1));
//        prod2.getCategories().addAll(Arrays.asList(cat1));
//        prod3.getCategories().addAll(Arrays.asList(cat1));
//        prod4.getCategories().addAll(Arrays.asList(cat2));
//        prod5.getCategories().addAll(Arrays.asList(cat3));
//        prod6.getCategories().addAll(Arrays.asList(cat4));
//        prod7.getCategories().addAll(Arrays.asList(cat5));
//        prod8.getCategories().addAll(Arrays.asList(cat6));
//        prod9.getCategories().addAll(Arrays.asList(cat7));
//        prod10.getCategories().addAll(Arrays.asList(cat8));
//        prod11.getCategories().addAll(Arrays.asList(cat2));
//        prod12.getCategories().addAll(Arrays.asList(cat8));
//        prod13.getCategories().addAll(Arrays.asList(cat4));
//        prod14.getCategories().addAll(Arrays.asList(cat2));
//        prod15.getCategories().addAll(Arrays.asList(cat3));
//        prod16.getCategories().addAll(Arrays.asList(cat4));
//        prod17.getCategories().addAll(Arrays.asList(cat5));
//        prod18.getCategories().addAll(Arrays.asList(cat6));
//        prod19.getCategories().addAll(Arrays.asList(cat7));
//
//        categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7,cat8));
//        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7,
//                prod8,prod9,prod10,prod11,prod12,prod13,prod14,prod15,prod16,prod17,prod18,prod19));
//
//        State st1 = new State(null, "Alagoas");
//        State st2 = new State(null, "São Paulo");
//
//        City city1 = new City(null, "Maceió", st1);
//        City city2 = new City(null, "São Paulo", st2);
//        City city3 = new City(null, "Campinas", st2);
//
//        st1.getCidades().addAll(Arrays.asList(city1));
//        st2.getCidades().addAll(Arrays.asList(city2, city3));
//
//        stateRepository.saveAll(Arrays.asList(st1, st2));
//        cityRepository.saveAll(Arrays.asList(city1,city2,city3));
//
//        Client cli1 = new Client(null, "Chuck Norris", "CN@hotmail.com", "000.000.001-01", ClientType.PHYSICALPERSON );
//        cli1.getPhones().addAll(Arrays.asList("000000001", "000000002"));
//
//        Address address1 = new Address(null, "Rua Chuck","1", "The Home", "The District", "00001-001", cli1, city1);
//        Address address2 = new Address(null, "Vera Arruda","175", "Apartamento", "Ponta verde", "00001-001", cli1, city1);
//        cli1.getAddress().addAll(Arrays.asList(address1,address2));
//
//        clientRepository.saveAll(Arrays.asList(cli1));
//        addressRepository.saveAll(Arrays.asList(address1, address2));
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        BuyOrder bo1 = new BuyOrder(null, sdf.parse("30/09/2017 10:32"), cli1, address1 );
//        BuyOrder bo2 = new BuyOrder(null, sdf.parse("02/10/2017 09:02"), cli1, address2 );
//
//        Payment pay1 = new PaymentCard(null, StatePayment.PAID, bo1, 6);
//        bo1.setPayment(pay1);
//
//        Payment pay2 = new PaymentSlip(null, StatePayment.PENDING, bo2, sdf.parse("20/10/2017 00:00"), null);
//        bo2.setPayment(pay2);
//
//        cli1.getBuyOrder().addAll(Arrays.asList(bo1, bo2));
//
//        buyOrderRepository.saveAll(Arrays.asList(bo1,bo2));
//        paymentRepository.saveAll(Arrays.asList(pay1,pay2));
//
//        ItemBuyOrder oi1 = new ItemBuyOrder(bo1, prod1, 0.00, 1, 2000.00);
//        ItemBuyOrder oi2 = new ItemBuyOrder(bo1, prod3, 0.00, 2, 80.00);
//        ItemBuyOrder oi3 = new ItemBuyOrder(bo2, prod2, 100.00, 1, 800.00);
//
//        bo1.getOrderItemSet().addAll(Arrays.asList(oi1, oi2));
//        bo2.getOrderItemSet().addAll(Arrays.asList(oi3));
//
//        prod1.getItemBuyOrder().addAll(Arrays.asList(oi1));
//        prod2.getItemBuyOrder().addAll(Arrays.asList(oi3));
//        prod3.getItemBuyOrder().addAll(Arrays.asList(oi2));
//
//        itemBuyOrderRepository.saveAll(Arrays.asList(oi1,oi2,oi3));















        Category cat1 = new Category(null, "INFORMATICA");
        Category cat2 = new Category(null, "ESCRITORIO");
        Category cat3 = new Category(null, "Cama mesa e banho");
        Category cat4 = new Category(null, "DB load category 4");
        Category cat5 = new Category(null, "DB load category 5");
        Category cat6 = new Category(null, "DB load category 6");
        Category cat7 = new Category(null, "DB load category 7");
        Category cat8 = new Category(null, "DB load category 8");

        Product prod1 = new Product(null, "Computador", 2000.0);
        Product prod2 = new Product(null, "Impressora", 800.0);
        Product prod3 = new Product(null, "Mouse", 150.0);
        Product prod4 = new Product(null, "prod4", 150.0);
        Product prod5 = new Product(null, "prod5", 150.0);
        Product prod6 = new Product(null, "prod6", 150.0);
        Product prod7 = new Product(null, "prod7", 150.0);
        Product prod8 = new Product(null, "prod8", 150.0);
        Product prod9 = new Product(null, "prod9", 150.0);
        Product prod10 = new Product(null, "prod10", 150.0);
        Product prod11 = new Product(null, "prod11", 150.0);
        Product prod12 = new Product(null, "prod12", 150.0);
        Product prod13 = new Product(null, "prod13", 150.0);
        Product prod14 = new Product(null, "prod14", 150.0);
        Product prod15 = new Product(null, "prod15", 150.0);
        Product prod16 = new Product(null, "prod16", 150.0);
        Product prod17 = new Product(null, "prod17", 150.0);
        Product prod18 = new Product(null, "prod18", 150.0);
        Product prod19 = new Product(null, "prod19", 150.0);

        cat1.getProducts().addAll((Arrays.asList(prod1,prod2,prod3)));
        cat2.getProducts().addAll((Arrays.asList(prod4, prod14,prod11)));
        cat3.getProducts().addAll((Arrays.asList(prod5, prod15)));
        cat4.getProducts().addAll((Arrays.asList(prod6, prod16, prod13)));
        cat5.getProducts().addAll((Arrays.asList(prod7, prod17)));
        cat6.getProducts().addAll((Arrays.asList(prod8, prod18)));
        cat7.getProducts().addAll((Arrays.asList(prod9, prod19)));
        cat8.getProducts().addAll((Arrays.asList(prod10, prod12)));


        prod1.getCategories().addAll(Arrays.asList(cat1));
        prod2.getCategories().addAll(Arrays.asList(cat1));
        prod3.getCategories().addAll(Arrays.asList(cat1));
        prod4.getCategories().addAll(Arrays.asList(cat2));
        prod5.getCategories().addAll(Arrays.asList(cat3));
        prod6.getCategories().addAll(Arrays.asList(cat4));
        prod7.getCategories().addAll(Arrays.asList(cat5));
        prod8.getCategories().addAll(Arrays.asList(cat6));
        prod9.getCategories().addAll(Arrays.asList(cat7));
        prod10.getCategories().addAll(Arrays.asList(cat8));
        prod11.getCategories().addAll(Arrays.asList(cat2));
        prod12.getCategories().addAll(Arrays.asList(cat8));
        prod13.getCategories().addAll(Arrays.asList(cat4));
        prod14.getCategories().addAll(Arrays.asList(cat2));
        prod15.getCategories().addAll(Arrays.asList(cat3));
        prod16.getCategories().addAll(Arrays.asList(cat4));
        prod17.getCategories().addAll(Arrays.asList(cat5));
        prod18.getCategories().addAll(Arrays.asList(cat6));
        prod19.getCategories().addAll(Arrays.asList(cat7));

//        categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7,cat8));
//        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7,
//                prod8,prod9,prod10,prod11,prod12,prod13,prod14,prod15,prod16,prod17,prod18,prod19));
//
//        State st1 = new State(null, "Alagoas");
//        State st2 = new State(null, "São Paulo");
//
//        City city1 = new City(null, "Maceió", st1);
//        City city2 = new City(null, "São Paulo", st2);
//        City city3 = new City(null, "Campinas", st2);
//
//        st1.getCidades().addAll(Arrays.asList(city1));
//        st2.getCidades().addAll(Arrays.asList(city2, city3));
//
//        stateRepository.saveAll(Arrays.asList(st1, st2));
//        cityRepository.saveAll(Arrays.asList(city1,city2,city3));
//
//        Client cli1 = new Client(null, "Chuck Norris", "CN@hotmail.com", "000.000.001-01", ClientType.PHYSICALPERSON );
//        cli1.getPhones().addAll(Arrays.asList("000000001", "000000002"));
//
//        Client cli2 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICALPERSON);
//        cli2.getPhones().addAll(Arrays.asList("000000001", "000000002"));
//
//        Address address1 = new Address(null, "Rua Chuck","1", "The Home", "The District", "00001-001", cli1, city1);
//        Address address2 = new Address(null, "Vera Arruda","175", "Apartamento", "Ponta verde", "00001-001", cli1, city1);
//
//        cli1.getAddress().addAll(Arrays.asList(address1,address2));
//        cli2.getAddress().addAll(Arrays.asList(address1, address2));
//
//        clientRepository.saveAll(Arrays.asList(cli1));
//        addressRepository.saveAll(Arrays.asList(address1, address2));
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        BuyOrder bo1 = new BuyOrder(null, sdf.parse("30/09/2017 10:32"), cli1, address1 );
//        BuyOrder bo2 = new BuyOrder(null, sdf.parse("02/10/2017 09:02"), cli1, address2 );
//        BuyOrder bo3 = new BuyOrder(null, sdf.parse("30/09/2017 10:32"), cli2, address1 );
//        BuyOrder bo4 = new BuyOrder(null, sdf.parse("02/10/2017 09:02"), cli2, address2 );
//
//        Payment pay1 = new PaymentCard(null, StatePayment.PAID, bo1, 6);
//        bo1.setPayment(pay1);
//
//        Payment pay2 = new PaymentSlip(null, StatePayment.PENDING, bo2, sdf.parse("20/10/2017 00:00"), null);
//        bo2.setPayment(pay2);
//
//        Payment pay3 = new PaymentCard(null, StatePayment.PAID, bo3, 6);
//        bo3.setPayment(pay3);
//
//        Payment pay4 = new PaymentSlip(null, StatePayment.PENDING, bo4, sdf.parse("20/10/2017 00:00"), null);
//        bo4.setPayment(pay4);
//
//        cli1.getBuyOrder().addAll(Arrays.asList(bo1, bo2));
//        cli2.getBuyOrder().addAll(Arrays.asList(bo3, bo4));
//
//        buyOrderRepository.saveAll(Arrays.asList(bo1,bo2,bo3,bo4));
//        paymentRepository.saveAll(Arrays.asList(pay1,pay2,pay3,pay4));
//
//        ItemBuyOrder oi1 = new ItemBuyOrder(bo1, prod1, 0.00, 1, 2000.00);
//        ItemBuyOrder oi2 = new ItemBuyOrder(bo1, prod3, 0.00, 2, 80.00);
//        ItemBuyOrder oi3 = new ItemBuyOrder(bo2, prod2, 100.00, 1, 800.00);
//
//        ItemBuyOrder oi4 = new ItemBuyOrder(bo3, prod1, 0.00, 1, 2000.00);
//        ItemBuyOrder oi5 = new ItemBuyOrder(bo3, prod3, 0.00, 2, 80.00);
//        ItemBuyOrder oi6 = new ItemBuyOrder(bo4, prod2, 100.00, 1, 800.00);
//
//        bo1.getOrderItemSet().addAll(Arrays.asList(oi1, oi2));
//        bo2.getOrderItemSet().addAll(Arrays.asList(oi3));
//        bo3.getOrderItemSet().addAll(Arrays.asList(oi4, oi5));
//        bo4.getOrderItemSet().addAll(Arrays.asList(oi6));
//
//        prod1.getItemBuyOrder().addAll(Arrays.asList(oi1));
//        prod2.getItemBuyOrder().addAll(Arrays.asList(oi3));
//        prod3.getItemBuyOrder().addAll(Arrays.asList(oi2));
//
//        prod1.getItemBuyOrder().addAll(Arrays.asList(oi4));
//        prod2.getItemBuyOrder().addAll(Arrays.asList(oi5));
//        prod3.getItemBuyOrder().addAll(Arrays.asList(oi6));
//
//        itemBuyOrderRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5,oi6));


    }
}
