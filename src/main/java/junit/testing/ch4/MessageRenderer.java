package junit.testing.ch4;

import junit.testing.ch4.subrenderer.BodyRenderer;
import junit.testing.ch4.subrenderer.FooterRenderer;
import junit.testing.ch4.subrenderer.HeaderRenderer;

import java.util.ArrayList;
import java.util.List;

public class MessageRenderer implements IRenderer{

    private List<IRenderer> subRenderers;

    public MessageRenderer() {
        List<IRenderer> RenderersList = new ArrayList<>();
        RenderersList.add(new HeaderRenderer());
        RenderersList.add(new BodyRenderer());
        RenderersList.add(new FooterRenderer());
        this.subRenderers = RenderersList;
    }

    @Override
    public String Render(Message message) {
        String Render = "";
        for (IRenderer subRenderer : subRenderers) {
            Render += subR enderer.Render(message);
        }
        return Render;
    }

    public List<IRenderer> getSubRenderers() {
        return subRenderers;
    }

}
