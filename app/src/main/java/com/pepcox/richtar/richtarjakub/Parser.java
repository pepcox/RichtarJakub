package com.pepcox.richtar.richtarjakub;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser extends AsyncTask<Void, Void, Void> {

    private final String awesomeBeerUrl = "http://www.richtarjakub.sk/hostinec/piva-na-vycape/";

    @Override
    protected Void doInBackground(final Void... voids) {
        Document doc = null;
        try {
            doc = Jsoup.connect(awesomeBeerUrl).get();
            Log.d("DEVELOP", doc.title());
            Elements newsHeadlines = doc.select(".beerItem");
            for (Element headline : newsHeadlines) {

                Log.d("DEVELOP", "Title: " + headline.select("a").get(1).text());
//                log("%s\n\t%s",
//                        headline.attr("title"), headline.absUrl("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
