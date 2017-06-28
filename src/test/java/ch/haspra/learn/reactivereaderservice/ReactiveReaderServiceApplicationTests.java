package ch.haspra.learn.reactivereaderservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveReaderServiceApplicationTests {
	@Autowired
	private PoemService poemService;

	@Test
	public void contextLoads() {
		poemService.crazyPoet().subscribe(System.out::println);

	}

}
