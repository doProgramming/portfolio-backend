package product.service;


import product.parsingweb.dto.WebsiteDTO;

import java.io.IOException;
import java.util.Date;

public interface ScheduledWebParserService {

    Date setAndGetDate();
    WebsiteDTO getAndParseBody(String month, String url) throws IOException;
    WebsiteDTO getAndParseBodyGoogle(String month, String url) throws IOException;
    String printBody() throws IOException;
}
