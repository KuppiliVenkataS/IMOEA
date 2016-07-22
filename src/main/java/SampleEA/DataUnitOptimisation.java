package SampleEA;
import java.util.ArrayList;

/**
 * Created by santhilata on 18/07/16.
 * This class has optimization method which follows Genetic algorithm.
 *
 */
public class DataUnitOptimisation implements CacheProperties {
    public static ArrayList<QueryData>[] testData = new ArrayList[upperTime_WindowLimit]; // this list is used to store 5 windows of incoming data
    ArrayList<QueryData> trainData ;// all queries sent to query analyser per one epoch



   // public void createInput()
    public void createInput(){

    }

    public static void main(String[] args) {
        HeuristicApproach ea = new HeuristicApproach();
        ea.createEpochWiseTestData(upperTime_WindowLimit);

    }
}
