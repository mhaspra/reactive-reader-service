package ch.haspra.learn.reactivereaderservice;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Created by haa on 26.06.17.
 */
@RestController
@RequestMapping("/poem")
@AllArgsConstructor
public class PoemRestController {
    private final PoemService poemService;

    @GetMapping
    public Flux<Phrase> all() {
        return poemService.all();
    }

    @GetMapping(value = "/slow", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Phrase> allSlow() {
        return poemService.all().delayElements(Duration.ofSeconds(5)).log();
    }
}
