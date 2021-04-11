package flashcardpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class FlashCardPojo {

    private final String action;
    private final int version;
    private final Params params;
}
