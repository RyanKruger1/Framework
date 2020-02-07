package Core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static Core.BaseFile.finalReportDir;

public class CommandLineExecutorInterface {

    public static String emulatorCMD = "";

    public static boolean runCommand() {
        try {
            List<String> awe = getListOfEmulators();

            Process p = Runtime.getRuntime().exec("cmd /c emulator -avd -nougat");

            BufferedReader inStreamReader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String output = inStreamReader.readLine();
            while (output != null) {
                output = inStreamReader.readLine();
            }


        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static List<String> getListOfEmulators() {
        List<String> awe = new ArrayList<String>();

        try {

            Process p = Runtime.getRuntime().exec("emulator -list-avds");

            BufferedReader inStreamReader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String output = inStreamReader.readLine();

            while (output != null) {
                output = inStreamReader.readLine();
                awe.add(output);
            }

        } catch (Exception ex) {
            return null;
        }
        return awe;

    }

    public static boolean createBat(){
        String output =  finalReportDir + "";
    }


}
