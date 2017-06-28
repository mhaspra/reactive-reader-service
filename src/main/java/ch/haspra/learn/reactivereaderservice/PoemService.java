package ch.haspra.learn.reactivereaderservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

/**
 * Created by haa on 26.06.17.
 */
@Service
@AllArgsConstructor
public class PoemService {
    private final PoemRepository poemRepository;

    public Flux<Phrase> all(){
        return poemRepository.findAll().log("SERVICE");
    }

    public Flux<String> crazyPoet(){
        return Flux.<String>generate(sink -> sink.next("BibbidiBubbediBap"))
                .delayElements(Duration.ofSeconds(1))
                .log("CRAZY");
    }
}
