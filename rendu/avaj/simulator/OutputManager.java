package avaj.simulator;

import avaj.exceptions.DefaultException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;

import avaj.exceptions.AvajException;
import java.io.IOException;

public class OutputManager {

    private static final String fileName    = "simulation.txt";
    private static final Path filePath      = Paths.get(fileName);

    static void createOutputFile() throws AvajException, IOException {

        if ( checkFile() ) {
            Files.delete(filePath);
        }

        if ( Files.notExists(filePath) ) {
            Files.createFile(filePath);
        } else {
            throw ( new DefaultException() );
        }

    }

    private static boolean checkFile() throws AvajException {
        if ( Files.exists(filePath) ) {
            if (
                !( Files.isRegularFile(filePath)
                   && Files.isWritable(filePath) )
            ) {
                throw ( new DefaultException() );
            }
            return (true);
        }
        return (false);
    }

    public static void writeToFile(String message) throws AvajException, IOException {
        if ( checkFile() ) {
            BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(message, 0, message.length());
            writer.newLine();
            writer.close();
        } else {
            throw (new DefaultException() );
        }
    }

}