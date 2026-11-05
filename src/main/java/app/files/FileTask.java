package main.java.app.files;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class FileTask {
    public static void runFileSystemTask(){
        String surname = "Ivanov";
        String name = "Ivan";

        Path baseDir = Paths.get(surname);

        try{
            System.out.println("    Создание структуры     ");
            // Создаем директорию
            Files.createDirectories(baseDir);

            // Создаем внутри файла <name>
            Path nameFile = baseDir.resolve(name + ".txt");
            Files.createFile(nameFile);
            System.out.println("Создан файл: " + nameFile);

            //Создаем вложеные директории dir1 di2 dir3
            Path nestedDirs = baseDir.resolve("dir1/dir2/dir3");
            Files.createDirectories(nestedDirs);
            System.out.println("Созданы директории: " + nestedDirs);

            //Копируем  файл <name> в dir1
            Path copiedFile = baseDir.resolve("dir1").resolve(name + ".txt");
            Files.copy(nameFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл скопирован в: " + copiedFile);

            //Создаем file1 в dir1 и file2 в dir2
            Path file1 = baseDir.resolve("dir1/file1.txt");
            Path file2 = baseDir.resolve("dir1/dir2/file2.txt");
            Files.createFile(file1);
            Files.createFile(file2);

            System.out.println("   Рекурсивны обход     ");
            try(Stream<Path> paths = Files.walk(baseDir)){
                paths.forEach(path -> {
                    String prefix = Files.isDirectory(path) ? "D: " : "F: ";
                    System.out.println(prefix + path.getFileName());
                });
            }
            System.out.println("\n     Удаление dir1    ");

            Path dirToDelete = baseDir.resolve("dir1");

            try(Stream<Path> pathsToDelete = Files.walk(dirToDelete)){
                pathsToDelete.sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(java.io.File::delete);
            }
            System.out.println("Директория dir1 успешно удалена");
        } catch (IOException e){
            System.err.println("Ошибка файловой системы: " + e.getMessage());
        }
    }

}
