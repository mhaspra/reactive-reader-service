package ch.haspra.learn.reactivereaderservice;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Created by haa on 27.06.17.
 */
public class PoemServiceTest {

    @Test
    public void testCrazyPoetFastConsumer(){
        PoemService poemService = new PoemService(null);

        poemService.crazyPoet().log().blockLast();

    }

    @Test
    public void testCrazyPoetSlowConsumer(){
        PoemService poemService = new PoemService(null);

        poemService.crazyPoet().delayElements(Duration.ofSeconds(5)).log().blockLast();

    }
}
