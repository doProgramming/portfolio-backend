package product.parsingweb.impl;

import product.parsingweb.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ConnectionImpl implements Connection {

    private int i;
    private String urlForParsing;

    public String getUrlForParsing() {
        return urlForParsing;
    }

    public void setUrlForParsing(String urlForParsing) {
        this.urlForParsing = urlForParsing;
    }

    @Override
    public Document parseWebSite()throws IOException{
        Document doc = null;
        try{
            if(urlForParsing != null){
            //doc = Jsoup.connect("http://nationalinterest.org/feature/serbia-kosovo-could-clash-amid-increasing-tensions-25386").followRedirects(false).get();
            doc = Jsoup.connect(urlForParsing).followRedirects(false).get();
            }
        }
        catch (Exception e){
    }
    if(doc!=null){return doc;}
    else return new Document("");
    }

}
