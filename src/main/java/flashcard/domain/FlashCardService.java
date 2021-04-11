package flashcard.domain;

import com.google.gson.Gson;
import flashcardpojo.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpMethod;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FlashCardService {

    public static void main(String[] args) throws IOException, URISyntaxException {

        List<FlashCard> flashCardList = new ArrayList<>();
        Document doc = Jsoup.parse(new File("data/Dictionary 30cae5936b354243bf40837c0e0bc324.html"), "UTF-8");
        Elements table = doc.select(".collection-content tr");
        int index = 0;

        for (Element el : table) {
            String answer = el.getElementsByClass("cell-d|mU").text();
            if (el.getElementsByClass("cell-vozL").select("div.checkbox.checkbox-off").first() == null || answer.isEmpty()) {
                continue;
            }
            String question = el.getElementsByClass("cell-title").text();
            System.out.println(question + " === " + answer);

            flashCardList.add(new FlashCard(question, answer));
            index++;
        }
        System.out.println(index);
        HttpEntityEnclosingRequestBase httpEntity = new HttpEntityEnclosingRequestBase() {
            @Override
            public String getMethod() {
                return HttpMethod.POST.name();
            }
        };
        for (FlashCard flashCard : flashCardList) {
            FlashCardPojo flashCardPojo = new FlashCardPojo("addNote", 6,
                    new Params(new Note("tst",
                            "Basic (and reversed card)",
                            new Fields(flashCard.getQuestion(), flashCard.getAnswer()),
                            new Options(false, "deck", new DuplicateScopeOptions("tst", false)))));
            Gson gson = new Gson();
            String jsonString = gson.toJson(flashCardPojo);
            URI uri = new URI("http://localhost:8765/");
            httpEntity.setURI(uri);
            httpEntity.setEntity(new StringEntity(jsonString, org.apache.http.entity.ContentType.APPLICATION_JSON));
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(httpEntity);
            StringBuilder responseString = new StringBuilder();
            for (int i = 0; i < response.getEntity().getContentLength(); i++) {
                responseString.append((char) response.getEntity().getContent().read());
            }
            System.out.println();
            System.out.println(responseString);
        }
    }
}
