package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Core.BaseFile.emulatorLocationFolder;
import static Core.BaseFile.finalReportDir;

public class CommandLineExecutorInterface {

    public static String emulatorCMD = "";

    public static boolean StartEmulator() {
        try {
            List<String> awe = getListOfEmulators();

            if(!createBat()){
                System.out.println("Could not create bat");
               return false;
            }
            if(!StartEmulatorCMD()){
                System.out.println("Could not run command.");
                return false;
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

    public static boolean createBat() {
        String output = finalReportDir + "\\EmulatorStarter.bat";


        try {
            String commands = "";
            PrintWriter pw = new PrintWriter(new File(output));
            pw.write("cd " + emulatorLocationFolder +"\n " + "emulator @Nougat");
            pw.close();
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public static boolean StartEmulatorCMD(){
        try{
            Process p = Runtime.getRuntime().exec("cmd /c " +finalReportDir+"\\EmulatorStarter.bat");
        }catch(Exception ex){
            String message = ex.getMessage();
            return false;
        }
        return true;
    }



}
