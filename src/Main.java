import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        // Exercise-5
        try {
            String fileText = readTextFile("files/Players.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exercise-6
        String sentence = "Hello, i'm the doctor";
        String fileName = "files/doctor.txt";
        try {
            writeTextToFile(fileName,sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exercise-8
        try {
            archiveTextFile("files/bigFile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exercise-9
        String siteAddress = "https://www.google.com";
        try {
            saveHTMLtoTextFile(siteAddress);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTextFile(String filepath) throws IOException {
        File file = new File(filepath);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }

        br.close();
        return sb.toString();
    }

    private static void writeTextToFile(String fileName, String sentence) throws IOException {
        Path path = Paths.get(fileName);
        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        writer.write(sentence);
        writer.close();
    }

    private static void archiveTextFile(String filePath) throws IOException {
        File file = new File("files/zippedFile.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        ZipEntry zipEntry = new ZipEntry(filePath);
        zipOutputStream.putNextEntry(zipEntry);
        byte[] data = readTextFile(filePath).getBytes();
        zipOutputStream.write(data,0,data.length);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }

    private static void saveHTMLtoTextFile(String siteAddress) throws IOException {
        URL site = new URL(siteAddress);
        BufferedReader br = new BufferedReader(new InputStreamReader(site.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("files/SiteText.txt"));
        String inputLine;
        while ((inputLine = br.readLine()) != null){
            writer.write(inputLine);
        }
        br.close();
        writer.close();
    }
}
