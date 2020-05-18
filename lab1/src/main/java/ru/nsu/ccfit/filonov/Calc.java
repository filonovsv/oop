package ru.nsu.ccfit.filonov;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import ru.nsu.ccfit.filonov.exceptions.FactoryGetInstanceException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calc {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Calc.class);

    public static void main(String args[]) {


        Factory factory = new Factory();
        Context context = new Context();

        InputStream in;
        BufferedReader br;

        try {
            in = Calc.class.getResourceAsStream("in.txt");
            br = new BufferedReader(new InputStreamReader(in));
            log.info("Reading from file");
        }catch (NullPointerException exception) {
            in = System.in;
            br = new BufferedReader(new InputStreamReader(in));
            log.info("Reading from console");
        }

        String line;
        String[] parsedLine;

        Command command;
        try {
            while ((line = br.readLine()) != null) {

                log.info("The following command was read");

                parsedLine = line.split(" ", 2);
                try {
                    command = factory.getInstance(parsedLine[0]);
                    log.info("Received an instance of the class by command");
                }catch (FactoryGetInstanceException e){
                    log.info("Entered an invalid command");
                    System.out.println("Invalid command, please try again");
                    continue;
                }
                try {
                    if (parsedLine.length > 1) {
                        log.info("Executing a command with a single argument");
                        command.execute(context, parsedLine[1].split(" "));
                    } else {
                        log.info("Executing a command with multiple arguments");
                        String[] string = new String[0];
                        command.execute(context, string);
                    }
                    log.info("Execution was successful");

                }catch (InvalidCommandException e){
                    log.info("This command is not valid in the current context");
                    continue;
                }
            }
            log.info("Run out of read data");
            if (in.getClass() != System.in.getClass()) {
                log.info("Closed a text file");
                in.close();
            }
        }catch (IOException e){
            log.info("Input error");
            return;
        }
    }
}
