package ua.nure.strebkov.SummaryTask3.util;
import ua.nure.strebkov.SummaryTask3.entity.TouristVousher;
import ua.nure.strebkov.SummaryTask3.handlers.SAXHandler;
public class Main {
    public static void usage() {
        System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
        System.out.println("java ua.nure.strebkov.SummaryTask3.Main xmlFileName");
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            usage();
            return;
        }
        String xmlFileName = args[0];
        System.out.println("Input ==> " + xmlFileName);


        SAXHandler saxController = new SAXHandler("input.xml");
        saxController.parse(true);
        TouristVousher saxTest = saxController.getTouristVousher();
    }
}