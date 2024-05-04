package homework.generator;

import homework.generator.model.HabiticaTask;
import homework.generator.model.HabiticaUser;
import homework.generator.model.jaxb.Tasks;
import homework.generator.model.jaxb.Users;
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

    private enum EntityType {
        TASK("task"),
        USER("user");
        private final String name;

        EntityType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static EntityType getEntityType(String name) {
            for (EntityType type : EntityType.values()) {
                if (type.getName().equals(name)) {
                    return type;
                }
            }
            throw new RuntimeException("There is no any entity type " + name);
        }
    }

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        switch (EntityType.getEntityType(type)) {
            case TASK -> generateForTasks(count, filename, format);
            case USER -> generateForUsers(filename, format);
        }
    }

    private static void generateForTasks(int count, String filename, String format) {
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

    private static void generateForUsers(String filename, String format) {
        List<HabiticaUser> users = new LinkedList<>();
        users.add(new HabiticaUser("daniils1406@mail.ru", "Landrover2013", "https://habitica.com"));
        users.add(new HabiticaUser("daniils1406@mail.ru", "Landrover20134", "https://habitica.com"));
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(SOURCE + "/" + filename + "." + format)) {
                writeUsersToXmlFile(users, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writeUsersToXmlFile(List<HabiticaUser> userList, FileWriter fileWriter) {
        try {
            Users users = new Users();
            users.setUsers(userList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(users, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
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