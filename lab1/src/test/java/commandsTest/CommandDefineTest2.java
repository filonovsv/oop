package commandsTest;

import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.commands.CommandDefine;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandDefineTest2 {

    @Test
    void execute() {

        Command command = new CommandDefine();
        Context context = new Context();
        String param = "1 5";

        assertThrows(InvalidCommandException.class, ()-> command.execute(context, param.split(" ", 2)), "create constant with double name") ;
    }
}
