import io.n0sense.myexam.config.MySpringConfiguration;
import io.n0sense.myexam.entity.Book;
import io.n0sense.myexam.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfiguration.class)
@Transactional
public class TestBookRepository {
    @Autowired
    BookRepository bookRepository;
    @Test
    public void testInsert() {
        bookRepository.save(
                Book.builder()
                        .b_name("DEMO")
                        .b_author("DEMO")
                        .b_price(new BigDecimal("105.3"))
                        .b_press("DEMO")
                        .build()
        );
    }

    @Test
    public void testDelete() {
        bookRepository.deleteById(1L);
    }

    @Test
    public void testUpdate() {
        Book book = new Book(1L, "DEMO2", "DEMO2", new BigDecimal("42.3"), "DEMO2");
        bookRepository.save(book);
    }

    @Test
    public void testFindAll() {
        bookRepository.findAll();
    }
}
