package junit.testing.ch4;

public class Message {

    private String Header;
    private String Body;
    private String Footer;

    public Message(String header, String body, String footer) {
        Header = header;
        Body = body;
        Footer = footer;
    }

    public String getHeader() {
        return Header;
    }



    public String getBody() {
        return Body;
    }



    public String getFooter() {
        return Footer;
    }

}
