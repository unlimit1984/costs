package com.javapro.costs.service;

import com.javapro.costs.config.AppConfigTest;
import com.javapro.costs.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(
        classes = AppConfigTest.class,
        loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populate_db_test.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = mock(UserService.class);
    }

    @Test
    public void get_returnsUserTest() {
        User user = new User();
        user.setEmail("tom@google.com");
        user.setName("Tom");
        user.setCreatedDate(LocalDate.now());

        when(userService.get(999999)).thenReturn(user);
        User fetchedUser = userService.get(999999);
        assertEquals(fetchedUser.getName(), "Tom");
        assertEquals(fetchedUser.getEmail(), "tom@google.com");
        assertEquals(fetchedUser.getCreatedDate(), LocalDate.now());
    }

    @Test
    public void getAllReturnAllUsers() {
        when(userService.getAll()).thenReturn(Arrays.asList(new User(), new User()));
        List<User> users = userService.getAll();
        assertTrue(users.size() == 2);
    }

    @Test
    public void save_savesUsersToDb() {
        User user = new User();
        user.setEmail("tom@google.com");
        user.setName("Tom");
        user.setCreatedDate(LocalDate.now());

        when(userService.save(user)).thenReturn(user);
        when(userService.get(user.getId())).thenReturn(user);
        User savedUser = userService.save(user);
        User fetchedUser = userService.get(savedUser.getId());
        assertTrue(user.equals(fetchedUser));
    }

}
