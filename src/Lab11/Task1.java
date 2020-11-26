package Lab11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Task1 {
    final static String data = "src/Lab11/movementList.csv";
    static ArrayList<Element> parseData;
    //static ArrayList<String> listOfComp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        parseData = parseCSV();

        Double sumPrihod = 0.0;
        Double sumRashod = 0.0;

        for (int i = 1; i < parseData.size(); i++) {
            sumPrihod += Double.parseDouble(parseData.get(i).prihod);
        }
        System.out.println("Сумма приходов: " + sumPrihod);

        for (int i = 1; i < parseData.size(); i++) {
            System.out.println(i);
            sumRashod += Double.parseDouble(parseData.get(i).rashod);
        }
        System.out.println("Сумма расходов: " + sumRashod);

        formatComp();
        Map<String, Integer> map = new HashMap();
        for (int i = 1; i < parseData.size(); i++) {
                if (!map.containsKey(parseData.get(i).view))
                    map.put(parseData.get(i).view, 0);
        }

        for (int i = 1; i < parseData.size(); i++) {
            if (map.containsKey(parseData.get(i).view))
                map.replace(parseData.get(i).view, map.get(parseData.get(i).view) + (int) Double.parseDouble(parseData.get(i).rashod));
        }

        System.out.println("Сумма расходов по организации:");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void formatComp(){
        for (int i = 1; i < parseData.size(); i++){
            String str = parseData.get(i).view.replace("    ","");
            str = str.replace(" ", "");
            if (str.contains("CARD2CARD"))
                str = "/RU/CARD2CARD ALFA_MOBILE>MOSCOW";
            if (!str.contains("CARD2CARD"))
                str = str.replaceAll("[^A-z]", "");
            parseData.get(i).view = str;
        }
    }

    private static ArrayList<Element> parseCSV() throws IOException {
        ArrayList <Element> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(data));

        String str = "";
        while ((str = fileReader.readLine()) != null) {
            String[] splitedStr = str.split(";");
            Element elem = new Element();
            elem.type = splitedStr[0];
            elem.number = splitedStr[1];
            elem.valute = splitedStr[2];
            elem.date = splitedStr[3];
            elem.reference = splitedStr[4];
            elem.view = splitedStr[5];
            elem.prihod = splitedStr[6].replace("\"", "");
            elem.rashod = splitedStr[7].replace("\"", "");
            list.add(elem);
        }

        fileReader.close();
        return list;
    }
}

class Element{
    String type;
    String number;
    String valute;
    String date;
    String reference;
    String view;
    String prihod;
    String rashod;
}
