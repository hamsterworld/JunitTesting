package junit.testing.ch4.subrenderer;

import junit.testing.ch4.IRenderer;
import junit.testing.ch4.Message;

public class BodyRenderer implements IRenderer {
    @Override
    public String Render(Message message) {
        return "<b>"+ message.getBody()+"</b>";
    }
}
