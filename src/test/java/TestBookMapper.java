import io.n0sense.myexam.config.MySpringConfiguration;
import io.n0sense.myexam.repository.BookMapper;
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
public class TestBookMapper {
    @Autowired
    BookMapper bookMapper;
    @Test
    public void testFindAll() {
        System.out.println(bookMapper.findAll());
    }
}
