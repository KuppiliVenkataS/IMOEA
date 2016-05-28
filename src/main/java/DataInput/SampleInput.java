package DataInput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by santhilata on 25/05/16.
 * Following class consists of two methods to create sample inputs for training and testing
 */
public class SampleInput {

    File inputFile;

    public File getInputFile(){
        return inputFile;
    }

    public  void toTrainCreateData(int[] cacheSize) throws IOException {

        File inputFile = new File("input.csv");
        FileWriter fw = new FileWriter(inputFile);
        fw.flush();
        fw.write("id,uLoc,cLoc,size,time,freq,Class\n");
        for (int qid = 0; qid < 100; qid++) { // 100 queries       => 0
            fw.write(qid + ","); // enter qid
            int uLoc = new Random().nextInt(6);//user location       => 1
            while(uLoc == 0) uLoc = new Random().nextInt(6);
            fw.write("uLoc_" + uLoc + ",");

            int cLoc = new Random().nextInt(6); // cache location    =>2
            while(cLoc == 0) cLoc = new Random().nextInt(6);
            fw.write("cLoc_" + cLoc + ",");

            int freq = new Random().nextInt(20); // frequency of a query   =>3
            while(freq ==0)  freq = new Random().nextInt(20);
            fw.write(freq + ",");

            int timeWindows = new Random().nextInt(4);                // =>4
            while (timeWindows == 0) timeWindows = new Random().nextInt(4);
            fw.write(timeWindows + ",");

            int dataSize = new Random().nextInt(20);             // =>5
            while(dataSize ==0) dataSize = new Random().nextInt(20);
            fw.write(dataSize + ",");

            if (uLoc == cLoc)  fw.write("no"+"\n");           // => 6
            else {
                if (timeWindows >=2){
                    if (freq >10 ){

                        if (dataSize < cacheSize[uLoc-1] ){
                            fw.write("yes"+"\n");
                            cacheSize[uLoc-1] -= dataSize;
                        }
                        else fw.write("Maybe"+"\n");
                    }
                    else fw.write("no"+"\n");
                }
                else{

                    if (dataSize < cacheSize[uLoc-1] ){
                        fw.write("yes"+"\n");
                        cacheSize[uLoc-1] -= dataSize;
                    }
                    else fw.write("Maybe"+"\n");
                }
            }

        }
        fw.close();

        this.inputFile = inputFile;
    }//to test create data

    /**
     * The following is a sample raw data
     * @throws IOException
     */
    public static File toTrainCreateData() throws IOException {

        File inputFile = new File("raw_data_collected.csv");
        FileWriter fw = new FileWriter(inputFile);
        fw.flush();
        fw.write("id,uLoc,cLoc,size,time,freq\n");
        for (int qid = 0; qid < 100; qid++) { // 100 queries       => 0
            fw.write(qid + ","); // enter qid
            int uLoc = new Random().nextInt(6);//user location       => 1
            while(uLoc == 0) uLoc = new Random().nextInt(6);
            fw.write("uLoc_" + uLoc + ",");

            int cLoc = new Random().nextInt(6); // cache location    =>2
            while(cLoc == 0) cLoc = new Random().nextInt(6);
            fw.write("cLoc_" + cLoc + ",");

            int freq = new Random().nextInt(20); // frequency of a query   =>3
            while(freq ==0)  freq = new Random().nextInt(20);
            fw.write(freq + ",");

            int timeWindows = new Random().nextInt(4);                // =>4
            while (timeWindows == 0) timeWindows = new Random().nextInt(4);
            fw.write(timeWindows + ",");

            int dataSize = new Random().nextInt(20);             // =>5
            while(dataSize ==0) dataSize = new Random().nextInt(20);
            fw.write(dataSize + ",");

            fw.write("\n");

        }
        fw.close();

        return inputFile;
    }//to test create data
}
