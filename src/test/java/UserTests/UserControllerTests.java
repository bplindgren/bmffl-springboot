package UserTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.Bmffl2018Application;
import com.brad.bmffl2018.TestUtil;
import com.entity.Role;
import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bmffl2018Application.class)
public class UserControllerTests {
	
	private static final String DEFAULT_USERNAME = "Brad";
    private static final String UPDATED_USERNAME = "Bradley";

    private static final Long DEFAULT_ID = 1L;

    private static final String DEFAULT_PASSWORD = "password";
    private static final String UPDATED_PASSWORD = "password123";

    private static final String DEFAULT_EMAIL = "bl@brad.com";
    private static final String UPDATED_EMAIL = "bl@brad.org";

    private static final String DEFAULT_FIRSTNAME = "Brad";
    private static final String UPDATED_FIRSTNAME = "Bradley";

    private static final String DEFAULT_LASTNAME = "lname";
    private static final String UPDATED_LASTNAME = "lastname";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EntityManager em;

    private MockMvc restUserMockMvc;

    private User user;
    
    public static User createEntity(EntityManager em) {
        User user = new User();
        user.setUsername(DEFAULT_USERNAME);
        user.setPassword(DEFAULT_PASSWORD);
        user.setActive(true);
        user.setEmail(DEFAULT_EMAIL);
        user.setFirstname(DEFAULT_FIRSTNAME);
        user.setLastname(DEFAULT_LASTNAME);
        return user;
    }

    @Before
    public void initTest() {
        user = createEntity(em);
        user.setUsername(DEFAULT_USERNAME);
        user.setEmail(DEFAULT_EMAIL);
    }

    @Test
    @Transactional
    public void createUser() throws Exception {
        int databaseSizeBeforeCreate = userRepository.findAll().size();

        // Create the User
        ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setUsername(DEFAULT_USERNAME);
        managedUserVM.setPassword(DEFAULT_PASSWORD);
        managedUserVM.setFirstname(DEFAULT_FIRSTNAME);
        managedUserVM.setLastname(DEFAULT_LASTNAME);
        managedUserVM.setEmail(DEFAULT_EMAIL);
        managedUserVM.setRole(Role.USER);

        restUserMockMvc.perform(post("/users/register")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(managedUserVM)))
            .andExpect(status().isCreated());

        // Validate the User in the database
        List<User> userList = userRepository.findAll();
        assertThat(userList).hasSize(databaseSizeBeforeCreate + 1);
        User testUser = userList.get(userList.size() - 1);
        assertThat(testUser.getUsername()).isEqualTo(DEFAULT_USERNAME);
        assertThat(testUser.getFirstname()).isEqualTo(DEFAULT_FIRSTNAME);
        assertThat(testUser.getLastname()).isEqualTo(DEFAULT_LASTNAME);
        assertThat(testUser.getEmail()).isEqualTo(DEFAULT_EMAIL);
    }
}
