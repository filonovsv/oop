package commandsTest;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandAdd;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandAddTest {

    @Test
    void execute() throws InvalidCommandException, ContextEmptyStackException {
        Command command = new CommandAdd();
        Context context = new Context();
        context.pushToStack(4.0);
        context.pushToStack(5.0);
        String param = "bla bla bal";

        command.execute(context, param.split(" "));
        assertEquals(context.popFromStack(), 9.0);
        assertThrows(ContextEmptyStackException.class, context::popFromStack);

    }
}