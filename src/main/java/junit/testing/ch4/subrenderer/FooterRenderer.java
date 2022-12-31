package junit.testing.ch4.subrenderer;

import junit.testing.ch4.IRenderer;
import junit.testing.ch4.Message;

public class FooterRenderer implements IRenderer {
    @Override
    public String Render(Message message) {
        return "<f>"+ message.getFooter()+"</f>";
    }
}
