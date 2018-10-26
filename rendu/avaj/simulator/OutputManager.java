package avaj.simulator;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.exceptions.DefaultException;

public class OutputManager {

    private static final String FILE_NAME    = "simulation.txt";
    private static final Path FILE_PATH      = Paths.get(FILE_NAME);

    static void createOutputFile() throws AvajException, IOException {
        if ( checkFile() )
            Files.delete(FILE_PATH);

        if ( Files.notExists(FILE_PATH) )
            Files.createFile(FILE_PATH);
        else
            throw ( new DefaultException() );
    }

    private static boolean checkFile() throws AvajException {
        if ( Files.exists(FILE_PATH) ) {
            if ( !( Files.isRegularFile(FILE_PATH) && Files.isWritable(FILE_PATH) ) )
                throw ( new DefaultException() );
            return (true);
        }
        return (false);
    }

    public static void writeToFile(String message) throws AvajException, IOException {
        if ( checkFile() ) {
            final BufferedWriter writer = Files.newBufferedWriter(FILE_PATH, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(message, 0, message.length());
            writer.newLine();
            writer.close();
        } else {
            throw (new DefaultException() );
        }
    }

}