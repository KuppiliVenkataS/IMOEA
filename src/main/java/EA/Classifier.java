package EA;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by santhilata on 25/05/16.
 */
public class Classifier {
    String classifierName;
    String dataType;
    ArrayList data;


    int numClasses;

    public Classifier(String classifierName){
        this.classifierName = classifierName;
    }

    public Classifier(String classifierName, ArrayList data){
        this.classifierName = classifierName;
        this.data  = data;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Object getMin(){
        double min =0.0;
        return min;
    }

    public Object getMax(){
        double max = 0.0;
        return max;
    }
    /**
     * Following methods are for String type data attribute
     */
    public ArrayList<String> getDistinctValuesForStringData(){
        ArrayList<String> distinctValues = null;
        if (this.dataType instanceof String){
            distinctValues = new ArrayList<>();
            Iterator<String> itr = data.iterator();
            while(itr.hasNext()){
                String str = (String)itr.next();
                if (!distinctValues.contains(str))
                    distinctValues.add(str);
            }
        }
        this.numClasses = distinctValues.size();
        return distinctValues;
    }


}
