package commandsTest;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandPop;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandPopTest {

    @Test
    void execute() throws InvalidCommandException {
        Command command = new CommandPop();
        Context context = new Context();
        String param = "It will be ignored";
        context.pushToStack(4.0);

        command.execute(context,  param.split(" "));
        assertThrows(ContextEmptyStackException.class, context::popFromStack);
    }
}