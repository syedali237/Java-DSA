import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OtherMain {

    public static void main(String[] args) {

        // creating the file
        try {
            File fo = new File("new-file.txt");
            fo.createNewFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // wrtie in the file
        try (FileWriter fw = new FileWriter("new-file.txt")){
            fw.write("جن آنکھوں سے مجھے تم دیکھتے ہو \n" + //
                                "\n" + //
                                "میں ان آنکھوں سے دنیا دیکھتا ہوں "); 
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

                // reading from a file
        try (BufferedReader br = new BufferedReader(new FileReader("new-file.txt"))) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());      
        }

        // create
        try {
            File fo = new File("random.txt");
            fo.createNewFile();
            if(fo.delete()) {
                System.out.println(fo.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        }

}
