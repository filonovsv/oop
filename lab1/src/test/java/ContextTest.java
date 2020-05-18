import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.ContextNotSetConstantException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextTest {
    @Test
    public void testContextPushPop() throws ContextEmptyStackException {
        Context t = new Context();
        t.pushToStack(4);
        t.pushToStack(214.123);
        assertEquals(214.123, t.popFromStack(), 0);
        assertEquals(4, t.popFromStack(), 0);
    }

    @Test
    public void testContextPeek() throws ContextEmptyStackException {
        Context t = new Context();
        t.pushToStack(4);
        t.pushToStack(214.123);
        assertEquals(214.123, t.peekAtStack(), 0);
        assertEquals(214.123, t.popFromStack(), 0);
    }

    @Test
    public void testContextDefs() throws ContextNotSetConstantException {
        Context t = new Context();
        t.setConstant("Any", 22.54);
        t.setConstant("Ololo", 999.);
        t.setConstant("a", 141.);
        assertEquals(22.54, t.getConstant("Any"), 0);
        assertEquals(141., t.getConstant("a"), 0);
        assertEquals(999., t.getConstant("Ololo"), 0);
        assertEquals(22.54, t.getConstant("Any"), 0);
    }

}

