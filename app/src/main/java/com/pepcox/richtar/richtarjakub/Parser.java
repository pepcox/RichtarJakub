package com.pepcox.richtar.richtarjakub;

import android.os.AsyncTask;
import android.util.Log;

import com.pepcox.richtar.richtarjakub.data.Beer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Parser extends AsyncTask<Void, Void, List<Beer>> {

    private final String awesomeBeerUrl = "http://www.richtarjakub.sk/hostinec/piva-na-vycape/";
    private OnParseDoneCallback onParseDoneCallback;

    public Parser(final OnParseDoneCallback onParseDoneCallback) {
        super();
        this.onParseDoneCallback = onParseDoneCallback;
    }

    @Override
    protected List<Beer> doInBackground(final Void... voids) {
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

    public void clearCallback() {
        onParseDoneCallback = null;
    }

    @Override
    protected void onPostExecute(final List<Beer> aVoid) {
        super.onPostExecute(aVoid);
        if (onParseDoneCallback != null) {
            onParseDoneCallback.onParsingDone(aVoid);
        }
    }

    public interface OnParseDoneCallback {
        void onParsingDone(List<Beer> beers);
    }
}
