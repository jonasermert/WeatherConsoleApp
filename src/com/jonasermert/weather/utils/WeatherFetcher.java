package com.jonasermert.weather.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.jonasermert.weather.WeatherInfo;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherFetcher {

    private static WeatherFetcher instance;

    private WeatherFetcher() {}

    public static WeatherFetcher getInstance() {
        if (instance == null) {
            instance = new WeatherFetcher();
        }
        return instance;
    }

    public WeatherInfo[] fetch(String city) throws Exception {
        String uri = "http://api.openweathermap.org/data/2.5/forecast?q="+ city +"&mode=xml&appid=454fb5d5537b1b8beca4e85edb867d17";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse(uri);
        NodeList times = document.getElementsByTagName("time");

        WeatherInfo[] weatherInfos = new WeatherInfo[times.getLength()];

        for (int x = 0; x < times.getLength(); x++) {
            Node time = times.item(x);
            NamedNodeMap timeAttributes = time.getAttributes();
            String timestamp = timeAttributes.getNamedItem("from").getNodeValue();

            NodeList children = time.getChildNodes();
            for (int y = 0; y < children.getLength(); y++) {
                Node child = children.item(y);
                if (child.getNodeName() == "temperature") {
                    String temperature = child.getAttributes().getNamedItem("value").getNodeValue();
                    weatherInfos[x] = new WeatherInfo(timestamp, temperature);
                }
            }
        }

        return weatherInfos;
    }
}
