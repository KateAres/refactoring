package ru.esphere.school.service;

import ru.esphere.school.data.Member;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс чтения данных их файла
 */
public class FileDataReader {

    /**
     * инициализация логгера
     */
    private static final Logger log = Logger.getLogger(FileDataReader.class.getName());

    /**
     * Чтение данных из файла
     *
     * @param filePath путь к файлу
     * @return содержимое файла в виде списка
     */
    public List<String> getDataFromFile(String filePath) {
        URL fileURL = null;
        try {
            fileURL = getClass().getClassLoader().getResource(filePath);
            return collectData(filePath, fileURL);
        } catch (IOException ex) {
            log.warning("Can't read the file: " + filePath);
            throw new IllegalArgumentException("Can't read the file: " + filePath, ex);
        } catch (URISyntaxException ex) {
            log.warning("Can't covert URL:" + fileURL + "to valid URI");
            throw new IllegalArgumentException("Can't covert URL:" + fileURL + "to valid URI", ex);
        }
    }

    /**
     * Чтение данных из файла members.txt
     *
     * @param filePath путь к файлу
     * @return списочный массив с объектами класса Member
     */
    public List<Member> collectMembers(String filePath) {
        int nameIndex = 0;
        int ageIndex = 1;
        int groupIndex = 2;
        List<String> membersList = getDataFromFile(filePath);
        List<Member> members = new ArrayList<>();
        for (String member : membersList) {
            String[] currentMember = member.split(",");
            members.add(new Member(currentMember[nameIndex].trim(), Integer.parseInt(currentMember[ageIndex].trim()),
                    currentMember[groupIndex].trim()));
        }
        return members;
    }

    /**
     * Чтение данных из файла
     *
     * @param filePath путь к файлу
     * @param fileURL  URL файла
     * @return содержимое файла в виде списка
     */
    private List<String> collectData(String filePath, URL fileURL) throws URISyntaxException, IOException {
        if (fileURL == null) {
            throw new IllegalArgumentException("URL of the file " + filePath + " is empty");
        }
        URI fileUri = fileURL.toURI();
        File file = Paths.get(fileUri).toFile();
        try (Stream<String> dataStream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            return dataStream.collect(Collectors.toList());
        }
    }
}
