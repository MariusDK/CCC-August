import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MariusDK on 19.08.2017.
 */
public class CitireFisier {
        public String readFile() {
            String fileName = "level1-4.in";
            String line = null;
            StringBuffer stringBuffer = new StringBuffer();
            try{
                FileReader fileReader=new FileReader(fileName);
                BufferedReader bufferedReader=new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine())!=null)
                {
                    stringBuffer.append(line);

                }
                bufferedReader.close();
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("Unable to open file '"+fileName+"'");
            }
            catch (IOException ex)
            {
                System.out.println("Error reading file '"+fileName+"'");
            }
            return stringBuffer.toString();
        }

}
