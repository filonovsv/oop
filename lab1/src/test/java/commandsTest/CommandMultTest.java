package commandsTest;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandMult;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandMultTest {

    @Test
    void execute() throws InvalidCommandException, ContextEmptyStackException {
        Command command = new CommandMult();
        Context context = new Context();
        context.pushToStack(4.0);
        context.pushToStack(4.5);
        String param = "It will be ignored";

        command.execute(context, param.split(" "));
        assertEquals(context.popFromStack(), 18.0);
        assertThrows(ContextEmptyStackException.class,context::popFromStack);
    }
}