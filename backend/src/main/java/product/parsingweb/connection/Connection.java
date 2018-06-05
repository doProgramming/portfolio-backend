package product.parsingweb.connection;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface Connection {
   Document parseWebSite() throws IOException;
}
