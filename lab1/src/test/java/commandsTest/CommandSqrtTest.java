package commandsTest;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandSqrt;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandSqrtTest {

    @Test
    void execute() throws InvalidCommandException, ContextEmptyStackException {

        Command command = new CommandSqrt();
        Context context = new Context();
        context.pushToStack(4.0);
        String param = "It will be ignored";

        command.execute(context, param.split(" "));
        assertEquals(context.popFromStack(), 2.0);
        assertThrows(ContextEmptyStackException.class,context::popFromStack);

        context.pushToStack(-4.0);
        assertThrows(InvalidCommandException.class, () -> command.execute(context, param.split(" ")));

    }
}