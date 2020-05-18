package commandsTest;

import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandDiv;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandDivTest {

    @Test
    void execute() throws ContextEmptyStackException, InvalidCommandException {
        Command command = new CommandDiv();
        Context context = new Context();
        context.pushToStack(4.0);
        context.pushToStack(2.0);
        String param = "It will be ignored";

        command.execute(context, param.split(" "));
        assertEquals(context.popFromStack(), 0.5);
        assertThrows(ContextEmptyStackException.class,context::popFromStack);

        context.pushToStack(0.0);
        context.pushToStack(4.0);

        assertThrows(InvalidCommandException.class, () -> command.execute(context, param.split(" ")), "Division by zero");
    }
}
