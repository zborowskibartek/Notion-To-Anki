package flashcard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlashCard {

    private final String question;
    private final String answer;

}
