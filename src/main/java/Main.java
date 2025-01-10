import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            File file = new File("C:\\Users\\macov\\Desktop\\java_laboratoare\\lab5ex2\\src\\main\\resources\\mobilier.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Mobilier> citire() {
        try {
            File file = new File("C:\\Users\\macov\\Desktop\\java_laboratoare\\lab5ex2\\src\\main\\resources\\mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<Mobilier>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Mobilier> mobila = citire();
        if (mobila != null) {
            mobila.forEach(System.out::println);

            System.out.println("\nDetalii despre placi:");
            mobila.forEach(m -> m.getPlaci().forEach(System.out::println));
        } else {
            System.out.println("Eroare la citirea fișierului JSON.");
        }
    }
}
