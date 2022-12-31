package junit.testing.ch4.subrenderer;

import junit.testing.ch4.IRenderer;
import junit.testing.ch4.Message;

public class HeaderRenderer implements IRenderer {
    @Override
    public String Render(Message message) {
        return "<h>"+ message.getHeader()+"</h>";
    }
}
