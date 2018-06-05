package product.parsingweb.dto;

public class WebsiteDTO {
    private String url;
    private String timeStamp;
    private String bodyText;

    public WebsiteDTO(String url, String timeStamp,String bodyText) {
        this.bodyText = bodyText;
        this.url = url;
        this.timeStamp = timeStamp;
    }
    public WebsiteDTO(String timeStamp,String bodyText) {
        this.bodyText = bodyText;
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBodyText() { return bodyText;
    }

    public void setBodyText(String bodyText) { this.bodyText = bodyText;
    }
}
