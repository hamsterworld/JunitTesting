package junit.testing.ch4;

import junit.testing.ch4.subrenderer.BodyRenderer;
import junit.testing.ch4.subrenderer.FooterRenderer;
import junit.testing.ch4.subrenderer.HeaderRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageRendererTest {

    @Test
    void MessageRenderer_uses_correct_sub_renderers() {

        MessageRenderer sut = new MessageRenderer();

        List<IRenderer> subRenderers = sut.getSubRenderers();

        assertEquals(3,subRenderers.size());
        assertTrue(subRenderers.get(0).getClass().isInstance(new HeaderRenderer()));
        assertTrue(subRenderers.get(1).getClass().isInstance(new BodyRenderer()));
        assertTrue(subRenderers.get(2).getClass().isInstance(new FooterRenderer()));
        // 하위 랜더링 클래스의 순서가 올바르고, 예상한 타입들이 오는가?
        // false positive 를 발생시킬 가능성이 높다.
    }

    @Test
    void Rendering_a_message() {
        MessageRenderer sut = new MessageRenderer();

        Message message = new Message("헤더","바디","푸터");
        String html = sut.Render(message);

        assertEquals("<h>헤더</h><b>바디</b><f>푸터</f>",html);
    }
}