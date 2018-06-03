package com.javapro.costs.service;

import com.javapro.costs.config.AppConfigTest;
import com.javapro.costs.model.Purchase;
import com.javapro.costs.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import static org.junit.Assert.fail;

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

    private static final Logger LOG = LoggerFactory.getLogger(PurchaseServiceTest.class);

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
        Purchase actualPurchase = service.get(PURCHASE2_ID);
        MATCHER.assertEquals(EXPECTED_PURCHASE2, actualPurchase);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        service.get(PURCHASE_NOT_FOUND_ID);
    }

    @Test
    public void getAll() {
        MATCHER.assertCollectionEquals(
                Arrays.asList(EXPECTED_PURCHASE1, EXPECTED_PURCHASE2, EXPECTED_PURCHASE3),
                service.getAll());
    }

    @Test
    public void getBetweenDateTimes() {
        MATCHER.assertCollectionEquals(
                Arrays.asList(EXPECTED_PURCHASE2, EXPECTED_PURCHASE3),
                service.getBetweenDateTimes(
                        LocalDate.of(2018, 1, 10),
                        LocalDate.of(2018, 3, 15)
                ).stream().sorted(Comparator.comparing(Purchase::getCreatedDate)).collect(Collectors.toList()));
    }

    @Test
    public void update() {

        Purchase updated = new Purchase(
                1000,
                LocalDate.of(3000, 1, 1),
                "myCategory",
                "myComment");
        updated.setId(PURCHASE1_ID);

        service.save(updated);
        MATCHER.assertEquals(updated, service.get(PURCHASE1_ID));


    }

    @Test
    public void delete() {
        service.delete(PURCHASE2_ID);

        MATCHER.assertCollectionEquals(
                Arrays.asList(EXPECTED_PURCHASE1, EXPECTED_PURCHASE3),
                service.getAll()
                        .stream()
                        .sorted(Comparator.comparing(Purchase::getCreatedDate)).collect(Collectors.toList()));
    }

    @Test
    public void testDeleteNotFound() {
        try {
            service.delete(PURCHASE_NOT_FOUND_ID);
            fail("Should call NotFoundException during deleting not existing Purchase");
        } catch (Exception e) {
            //TODO I want NotFoundException here
            LOG.info("Should cause NotFoundException");
            //} catch (NotFoundException e){
        }
    }

}