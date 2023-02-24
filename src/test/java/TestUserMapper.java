import io.n0sense.myexam.config.MySpringConfiguration;
import io.n0sense.myexam.entity.User;
import io.n0sense.myexam.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfiguration.class)
@Transactional
public class TestUserMapper {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testInsert() {
        User user = User.builder()
                .username("TEST")
                .password("1234")
                .build();
        userMapper.save(user);
    }
    @Test
    public void testExists() {
        System.out.println(userMapper.existsByUsername("demo"));
    }
}
