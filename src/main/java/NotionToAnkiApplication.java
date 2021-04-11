import flashcard.domain.FlashCardService;

import java.io.IOException;
import java.net.URISyntaxException;

public class NotionToAnkiApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        FlashCardService flashCardService = new FlashCardService();
        flashCardService.run();
    }
}
