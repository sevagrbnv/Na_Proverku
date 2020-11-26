package Lab11;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task2 {
    public final static String url = "https://www.mirea.ru";
    public static ArrayList<String> sources = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements elem = doc.select("img");
        elem.forEach(element -> {
            String src;
            if(!(src = element.attr("abs:src")).equals("")) {
                sources.add(src);
            }
        });
        ImagesLoader imagesLoader = new ImagesLoader(sources,"images");
        imagesLoader.download().forEach(System.out::println);
    }
}

class ImagesLoader {
    private final ArrayList<String> urlSourses;
    private final String path;

    public ImagesLoader(ArrayList<String> urlSourses, String pathToDir) {
        this.urlSourses = urlSourses;
        this.path = pathToDir;
    }

    public ArrayList<String> download() throws IOException{
        ArrayList<String> listOfName = new ArrayList<>();
        for(String imageUrl: urlSourses) {
            byte[] bytes = Jsoup.connect(imageUrl)
                    .ignoreContentType(true)
                    .execute().bodyAsBytes();

            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            String fileName = getNameFromUrl(imageUrl);

            if(setBuffer(buffer, fileName)) {
                listOfName.add(fileName);
            }
        }
        return listOfName;
    }

    private boolean setBuffer(ByteBuffer imageDataBytes, String fileName) throws IOException {
        final String pathToImage = path + "/" +fileName;
        File dir = new File(path);

        if(!dir.exists()) {
            boolean res = dir.mkdir();
        }

        File image = new File(pathToImage);
        BufferedImage bufferedImage;

        String[] parts = fileName.split("\\.");
        String format = parts[parts.length-1];

        InputStream in = new ByteArrayInputStream(imageDataBytes.array());
        bufferedImage = ImageIO.read(in);
        return ImageIO.write(bufferedImage, format, image);
    }

    private static String getNameFromUrl(String url) {
        final String regex = "[a-zA-Z0-9._-]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if(matcher.find())
            return matcher.group();
        return "";
    }
}