package commandsTest;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandDefine;
import ru.nsu.ccfit.filonov.commands.CommandPush;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandDefineTest {

    @Test
    void execute() throws InvalidCommandException, ContextEmptyStackException {

        Command command = new CommandDefine();
        Context context = new Context();
        String param = "a 5";

        command.execute(context, param.split(" ", 2));

        Command command1 = new CommandPush();
        param = "a";
        command1.execute(context, param.split(" ", 2));
        assertEquals(context.popFromStack(), 5.0);
        String finalParam = "b";
        assertThrows(ContextEmptyStackException.class, context::popFromStack);
    }
}