import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.InputStreamReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) {

        // convertring byte to char stream

        // try (InputStreamReader isr = new InputStreamReader(System.in)){
        //     System.out.print("Enter Some letters: ");
        //     int letters = isr.read();
        //     while (isr.ready()) {
        //         System.out.println((char) letters);
        //         letters = isr.read();
        //     }
        //     // isr.close();
        //     System.out.println();
        // } catch (IOException e ){
        //     System.out.println(e.getMessage());
        // }

        // try (FileReader fr = new FileReader("note.txt")){
        //     int letters = fr.read();
        //     while (letters != -1) {
        //         System.out.println((char) letters);
        //         letters = fr.read();
        //     }
        //     // isr.close();
        //     System.out.println();
        // } catch (IOException e ){
        //     System.out.println(e.getMessage());
        // }
        

        // // reading a character stream
        // // byte to char stream and then reading char stream
        // try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
        //     System.out.println("You typed: " + br.readLine());
        // } catch (Exception e) {
        //     System.err.println(e.getMessage());
        // }


        // try(BufferedReader br = new BufferedReader(new FileReader("note.txt"));) {
        //     while (br.ready()) {
        //         System.out.println(br.readLine());
        //     }
        // } catch (Exception e) {
        //     System.err.println(e.getMessage());
        // }

        // output 

        OutputStream os = System.out;
        // os.write(😁); /  range exceed

        // try (OutputStreamWriter osw = new OutputStreamWriter(System.out)){
        //     osw.write("hello everyone");
        //     osw.write(97);
        //     osw.write(10); // 10 is a new line in ASCII
        //     osw.write('A');
        //     osw.write('\n');
        //     char[] arr = "hello world".toCharArray();
        //     osw.write(arr);
        //     // osw.write(😁);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }


        // if you want to append to the exisiting just add true
        try (FileWriter fw = new FileWriter("note.txt", true)){
            // over rides the already writtem note.txt
            fw.write(" this should append it"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))){
            bw.write(" text has been changed "); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
