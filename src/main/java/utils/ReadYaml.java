package utils;


import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class ReadYaml {
    Yaml yaml = new Yaml();
    TestCaseRootHolder ymlH = null;
    String resourcesPath = "src\\test\\resources\\";
    String fileName ="Config.yaml";

    public TestCaseRootHolder readTestData(String testDataName) throws FileNotFoundException {
        String path = resourcesPath + "test-data\\" + testDataName + ".yaml";
        try {
            FileInputStream file = new FileInputStream(new File(path));
            ymlH = yaml.loadAs(new FileReader(new File(path)), TestCaseRootHolder.class);
             } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ymlH;

    }

    public Map<String, String> readConfig() throws FileNotFoundException {
        Map<String, String> dict = yaml.load(new FileReader(new File(resourcesPath + fileName)));
        return dict;
    }

}
