package week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static IPAddress[] readFile(String filePath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while((line=reader.readLine())!=null){
            lines.add(line);
        }
        IPAddress[] addresses = new IPAddress[4637053];
        for(int i = 0; i<4637053;i++){
            String[] splitLine = lines.get(i).split(";");
            addresses[i] = new IPAddress(
                    Long.parseLong(splitLine[0]),
                    Long.parseLong(splitLine[1]),
                    splitLine[2],
                    splitLine[3],
                    splitLine[4],
                    splitLine[5]);
        }


        return addresses;
    }
}
