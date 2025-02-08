package eve.util;

import eve.exception.DataFileWriteException;
import eve.exception.EveException;
import eve.task.Deadline;
import eve.task.Event;
import eve.task.Task;
import eve.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Utility class to handle storage of data to a data file.
 */
public class Storage {
    private final String DIRECTORY_PATH;
    private final String FILE_NAME;

    public Storage(String DIRECTORY_PATH, String FILE_NAME) {
        this.DIRECTORY_PATH = DIRECTORY_PATH;
        this.FILE_NAME = FILE_NAME;
    }

    /**
     * Returns an ArrayList of Task that is loaded from the data file.
     *
     * @throws EveException Custom exceptions with custom error messages.
     */
    public TaskList load() throws EveException {
        TaskList taskList = new TaskList();
        try {
            File file = new File(DIRECTORY_PATH + FILE_NAME);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                taskList.add(this.parseStringIntoTask(line));
            }
        } catch (FileNotFoundException e) {
            // Running for first time
            try {
                Files.createDirectories(Paths.get(this.DIRECTORY_PATH));
                Files.createFile(Paths.get(DIRECTORY_PATH + FILE_NAME));
            } catch (IOException e1) {
                throw new DataFileWriteException();
            }
        }
        return taskList;
    }

    /**
     * Parses a string into a Task object.
     *
     * @param line String obtained from the data file.
     * @return Task parsed from the string.
     * @throws DateTimeParseException If a string from the data file cannot be parsed into LocalDateTime object.
     */
    public Task parseStringIntoTask(String line) throws DateTimeParseException {
        String[] parts = line.split(" \\| ");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        Task task;
        switch (parts[0]) {
        case "D":
            task = new Deadline(parts[2], DateTimeUtil.parseString(parts[3]));
            break;
        case "E":
            task = new Event(parts[2], DateTimeUtil.parseString(parts[3]), DateTimeUtil.parseString(parts[4]));
            break;
        // "T"
        default:
            task = new ToDo(parts[2]);
            break;
        }
        if (parts[1].equals("X")) {
            task.markAsDone();
        }
        return task;
    }

    /**
     * Writes the tasks in the taskList to the data file.
     *
     * @param taskList ArrayList containing all the tasks.
     * @throws EveException Custom exceptions with custom error messages.
     */
    public void writeToFile(TaskList taskList) throws EveException {
        StringBuilder dataToWrite = new StringBuilder();
        for (Task task: taskList) {
            dataToWrite.append(task.toDataString()).append("\n");
        }
        try {
            Files.writeString(Paths.get(DIRECTORY_PATH + FILE_NAME), dataToWrite.toString());
        } catch (IOException ex) {
            throw new DataFileWriteException();
        }
    }
}
