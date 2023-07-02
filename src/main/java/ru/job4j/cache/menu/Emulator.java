package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Emulator {

    public static void main(String[] args) throws IOException {
        String directory = "C:\\projects\\job4j_grabber\\src\\main\\java\\ru\\job4j\\cache\\files";
        DirFileCache cache = new DirFileCache(directory);
        cache.put("Names.txt", Files.readString(Path.of(directory + "\\Names.txt")));
        cache.put("Address.txt", Files.readString(Path.of(directory + "\\Address.txt")));
        System.out.println(cache.get("Names.txt"));
        System.out.println(cache.get("Address.txt"));
    }

}
