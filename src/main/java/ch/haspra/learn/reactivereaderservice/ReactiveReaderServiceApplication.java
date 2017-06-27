package ch.haspra.learn.reactivereaderservice;

import com.sun.tools.javac.util.Name;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Log
@SpringBootApplication
@RequiredArgsConstructor
public class ReactiveReaderServiceApplication implements CommandLineRunner {
	private final PoemRepository poemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveReaderServiceApplication.class, args);
	}



	@Override
	public void run(String... strings) throws Exception {

		this.poemRepository
				.deleteAll()
				.thenMany(Flux.just(
						"Wir sind, ein Stromarm, aus dem All geflossen",
						"und kehren wachsend in das All zurück;",
						"Wir sind in schwere Erde eingeschlossen;",
						"Doch vor uns schwebt ein Traum, der Ferne Glück.",
						"\n",
						"Und weil wir viele Fernen zwingen müssen,",
						"sind noch viel Worte unserm Leid bereit:",
						"Zwiespalt und Not und Tod und Einsamkeit",
						"hält uns zurück in alten Finsternissen."))
				.map(phrase -> new Phrase(UUID.randomUUID().toString(), phrase, 0))
				.flatMap(phrase -> poemRepository.save(phrase))
				.doOnNext(phrase -> log.info("Saved phrase \u001B[32m" + phrase.getPhrase() + "\u001B[0m (id=" + phrase.getId() + ")"))
				.blockLast();

		System.out.println("Happily saving phrases \\ö/");
	}
}
