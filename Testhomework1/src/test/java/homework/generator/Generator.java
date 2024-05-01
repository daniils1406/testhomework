package homework.generator;

import homework.generator.model.HabiticaTask;
import homework.generator.model.jaxb.Tasks;
import org.apache.commons.lang3.RandomStringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Generator {
    public static final String SOURCE = "/C:/Users/daniil/Desktop";

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (Objects.equals(type, "task")) GenerateForGroups(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void GenerateForGroups(int count, String filename, String format) {
        List<HabiticaTask> tasks = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            tasks.add(new HabiticaTask(generateString(10)));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(SOURCE + "/" + filename + "." + format)) {
                writePostsToXmlFile(tasks, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writePostsToXmlFile(List<HabiticaTask> taskList, FileWriter fileWriter) {
        try {
            Tasks tasks = new Tasks();
            tasks.setTasks(taskList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Tasks.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(tasks, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateString(int length) {
        return RandomStringUtils.random(length, true, true);
    }
}