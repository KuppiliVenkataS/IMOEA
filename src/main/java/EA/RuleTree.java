package EA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * Created by santhilata on 25/05/16.
 */
public class RuleTree {
    private LinkedHashMap attributeList ;

    /**
     * Following methods are for training data
     * @param inputFile
     * @throws IOException
     */
    public void readData(File inputFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line = br.readLine(); // first line is always the names of attributes
        String[] classifiers = line.split(Pattern.quote(",")); // classifiers contains array of attribute names
        // by default always the last name is "Class" for the train data

        for (int i = 0; i < classifiers.length-1; i++) {
            Classifier classifier_new = new Classifier(classifiers[i]);

        }


        attributeList = new LinkedHashMap();
        ArrayList<String>[] attributeData = new ArrayList[classifiers.length-1];



        for (int i = 0; i < classifiers.length-1; i++) {
            ArrayList<String> temp = new ArrayList<>();
            attributeData[i] = temp;
        }

        while ((line = br.readLine()) != null){
            String[] attributes = line.split(Pattern.quote(","));
            for (int i = 0; i < classifiers.length-1; i++) {
                attributeData[i].add(attributes[i]);
            }
        }

        // setting attribute name and data(arraylist) in the linked hash map
        for (int i = 0; i < classifiers.length-1; i++) {
            attributeList.put(classifiers[i],attributeData[i]);
        }
    }

    public LinkedHashMap getAttributeList(){
        return attributeList;
    }



}
