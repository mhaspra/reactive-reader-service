package ch.haspra.learn.reactivereaderservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Created by haa on 26.06.17.
 */
@Service
@AllArgsConstructor
public class PoemService {
    private final PoemRepository poemRepository;

    public Flux<Phrase> all(){
        return poemRepository.findAll();
    }


    public Flux<Phrase> characters(Phrase phrase) {
        return Flux.<Phrase>generate(sink -> sink.next(
                new Phrase(phrase.getId(), phrase.getPhrase(), phrase.getPhrase().length())))
                .delayElements(Duration.ofSeconds(5))
                .log()
                .take(1);
    }
}
