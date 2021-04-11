package flashcardpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DuplicateScopeOptions {

    private final String deckName;
    private final boolean checkChildren;

}
