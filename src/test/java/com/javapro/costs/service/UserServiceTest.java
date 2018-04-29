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
import static org.mockito.Mockito.*;

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
    public void getReturnsUserTest() {
        User user = getNewUser();

        when(userService.get(999999)).thenReturn(user);
        User fetchedUser = userService.get(999999);
        assertEquals(fetchedUser.getName(), "Tom");
        assertEquals(fetchedUser.getEmail(), "tom@google.com");
        assertEquals(fetchedUser.getCreatedDate(), LocalDate.now());
    }

    @Test
    public void getAllReturnAllUsersTest() {
        when(userService.getAll()).thenReturn(Arrays.asList(new User(), new User()));
        List<User> users = userService.getAll();
        assertTrue(users.size() == 2);
    }

    @Test
    public void saveUsersToDbTest() throws Exception {
        User user = getNewUser();
        when(userService.save(user)).thenReturn(user);
        when(userService.get(user.getId())).thenReturn(user);
        User savedUser = userService.save(user);
        User fetchedUser = userService.get(savedUser.getId());
        assertTrue(user.equals(fetchedUser));
    }

    @Test
    public void deleteUserTest() {
        User user = getNewUser();
        userService.delete(user.getId());
        verify(userService).delete(user.getId());
    }

    private User getNewUser() {
        User user = new User();
        user.setId(100L);
        user.setEmail("tom@google.com");
        user.setName("Tom");
        user.setCreatedDate(LocalDate.now());
        return user;
    }
}
