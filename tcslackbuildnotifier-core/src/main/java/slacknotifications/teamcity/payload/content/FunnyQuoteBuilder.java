package slacknotifications.teamcity.payload.content;

import jetbrains.buildServer.messages.Status;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.Random;

class FunnyQuoteBuilder {

    String getFunnyQuote(Status buildResult, boolean isYodaChosen) {

        String msg;
        final String character = getCharacter(isYodaChosen);
        final String quote = getRandomQuote(getQuotesFileName(isYodaChosen));
        if (buildResult == Status.FAILURE) {
            msg = character + " disapproves build and remember that " + quote;
        } else {
            msg = character + " approves build and remember that " + quote;
        }

        return msg;
    }

    private String getCharacter(boolean isYodaChosen) {
        return isYodaChosen ? "Yoda" : "Chuck Norris";
    }

    private String getQuotesFileName(boolean isYodaChosen) {
        return isYodaChosen ? "/yoda_quotes.txt" : "/chuck_quotes.txt";
    }

    private String getRandomQuote(String fileName) {
        String quote = "All is Well";
        try {
            List<String> quotes = IOUtils.readLines(
                    getClass().getResourceAsStream(fileName), "UTF-8");

            quote = quotes.get((new Random()).nextInt(quotes.size()));
        } catch (IOException e) {
            jetbrains.buildServer.log.Loggers.SERVER.error("Failed to load quotes", e);
        }
        return quote;
    }

}
