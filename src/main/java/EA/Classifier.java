package EA;

import java.util.ArrayList;

/**
 * Created by santhilata on 25/05/16.
 */
public class Classifier {
    String classifierName;
    Object dataType;
    ArrayList data;


    int numClasses;

    public Classifier(String classifierName){
        this.classifierName = classifierName;
    }

    public Object getMin(){
        double min =0.0;
        return min;
    }

    public Object getMax(){
        double max = 0.0;
        return max;
    }

}
