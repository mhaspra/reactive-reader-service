package ch.haspra.learn.reactivereaderservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by haa on 26.06.17.
 */
@AllArgsConstructor
@Data
@Document
public class Phrase {
    @Id
    private String id;
    private String phrase;
    private Integer length;

}
