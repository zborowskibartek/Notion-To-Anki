package flashcardpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Note {

    private final String deckName;
    private final String modelName;
    private final Fields fields;
    private final Options options;

}
