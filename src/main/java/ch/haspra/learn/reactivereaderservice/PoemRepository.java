package ch.haspra.learn.reactivereaderservice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by haa on 26.06.17.
 */
public interface PoemRepository extends ReactiveMongoRepository<Phrase, String> {
}