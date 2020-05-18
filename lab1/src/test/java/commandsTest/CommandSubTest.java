package commandsTest;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandSub;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandSubTest {

    @Test
    void execute() throws ContextEmptyStackException, InvalidCommandException {
        Command command = new CommandSub();
        Context context = new Context();
        context.pushToStack(4.0);
        context.pushToStack(4.5);
        String param = "It will be ignored";

        command.execute(context, param.split(" "));
        assertEquals(context.popFromStack(), 0.5);
        assertThrows(ContextEmptyStackException.class,context::popFromStack);
    }
}