package com.javapro.costs.service;

import com.javapro.costs.config.AppConfigTest;
import com.javapro.costs.model.Purchase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static com.javapro.costs.service.PurchaseTestData.*;

/**
 * Created by Vladimir_Vysokomorny on 29-Jun-17.
 */
@ContextConfiguration(
        classes = AppConfigTest.class,
        loader = AnnotationConfigContextLoader.class
)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populate_db_test.sql", config = @SqlConfig(encoding = "UTF-8"))
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService service;

    @Before
    public void setUp() {
        service.save(new Purchase(MONEY1, CREATED_DATE1, CATEGORY1, COMMENT1));
        service.save(new Purchase(MONEY2, CREATED_DATE2, CATEGORY2, COMMENT2));
        service.save(new Purchase(MONEY3, CREATED_DATE3, CATEGORY3, COMMENT3));
    }


    @Test
    public void get() {
        Purchase actualPurchase = service.get(1);
        MATCHER.assertEquals(EXPECTED_PURCHASE2, actualPurchase);
    }

    @Test
    public void getAll() throws Exception {
        MATCHER.assertCollectionEquals(
                Arrays.asList(EXPECTED_PURCHASE1, EXPECTED_PURCHASE2, EXPECTED_PURCHASE3),
                service.getAll());
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        MATCHER.assertCollectionEquals(
                Arrays.asList(EXPECTED_PURCHASE2, EXPECTED_PURCHASE3),
                service.getBetweenDateTimes(
                        LocalDate.of(2018, 1, 10),
                        LocalDate.of(2018, 3, 15)
                ).stream().sorted(Comparator.comparing(Purchase::getCreatedDate)).collect(Collectors.toList()));
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {
    }

}