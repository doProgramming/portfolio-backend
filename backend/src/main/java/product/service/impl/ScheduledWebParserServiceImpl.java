package product.service.impl;

import product.parsingweb.impl.ConnectionImpl;
import product.parsingweb.Connection;
import product.parsingweb.dto.WebsiteDTO;
import product.service.ScheduledWebParserService;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


@Service
public class ScheduledWebParserServiceImpl implements ScheduledWebParserService {

    private BufferedWriter writer = null;
    private String paragraph;
    private String nameOfFile;

    @Autowired
    ScheduledWebParserService scheduledWebParserService;

    @Autowired
    Connection parserWebsite;

    @Autowired
    ConnectionImpl parser;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledWebParserServiceImpl.class);

    @Override
    //@Scheduled(fixedRate = 25000)
    public Date setAndGetDate (){
        Date currentDate = new Date();
        currentDate.getTime();
        Date timeStamp = currentDate;
        logger.info("set date");
        try{
            //setDate(currentDate.toString() ,"");
        }catch (Exception e){}
        logger.info("date is" + timeStamp);
        return timeStamp;
    }

    @Override
    public WebsiteDTO getAndParseBody(String firstParametar, String urlConnection) throws IOException{
        //set url where connection need to be open, get that value from 1st parametar
        parser.setUrlForParsing(urlConnection);
        logger.info("url for connection is: " + urlConnection);
        String bodyText;
        Elements body = parserWebsite
                .parseWebSite()
                .select("body");
        if( body.select("p").text() != null){
        bodyText = body.select("p").text().toString();}
        else {bodyText = "Error while writeing body text";}
        WebsiteDTO websiteDTO = new WebsiteDTO(firstParametar, urlConnection,bodyText);
        nameOfFile = firstParametar;
        scheduledWebParserService.printBody();
        return websiteDTO;
    }

    @Override
    public WebsiteDTO getAndParseBodyGoogle(String firstParametar, String urlConnection) throws IOException{
        //set url where connection need to be open, get that value from 1st parametar
        parser.setUrlForParsing(urlConnection);
        logger.info("url for connection is: " + urlConnection);
        String bodyText;
        //click submit button labelled "Google Search"
        Elements body = parserWebsite
                .parseWebSite()
                .select("body");
        if( body.select("p").text() != null){
            bodyText = body.select("p").text().toString();}
        else {bodyText = "Error while writeing body text";}
        WebsiteDTO websiteDTO = new WebsiteDTO(firstParametar, urlConnection,bodyText);
        nameOfFile = firstParametar;
        scheduledWebParserService.printBody();
        return websiteDTO;
    }

    @Scheduled(fixedRate = 155500)
    public String printBody () throws IOException{
        logger.info("Web parser started");
        Elements body = parserWebsite
                .parseWebSite()
                .select("body");

        if(body != null){
            makeFile(body);
            //write in console output
                //System.out.println( paragraph.replaceAll("\\.",".\n"));
        }
        logger.info("Web parser finished");
        return body.toString(); }

    private void makeFile(Elements body) throws IOException{
        writer = new BufferedWriter(new FileWriter("C:\\Users\\StrahinjaSSD\\Desktop\\"+nameOfFile+".txt"));
        paragraph = body.select("p").text().toString();
        writer.append(paragraph);
        writer.close();
    }

}
