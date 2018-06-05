package product.parsingweb;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface Connection {
   Document parseWebSite() throws IOException;
}
