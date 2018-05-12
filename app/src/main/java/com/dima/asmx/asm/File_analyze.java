package com.dima.asmx.asm;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class File_analyze {
    static private String input_text = "";
    static private List<String> output_text =new ArrayList<String>();
    private static String name;
    private ArrayList<String> strings;
    public File_analyze(String _name){
        //output_text.add("this");
        name = _name;
        analyze();
    }
    public void analyze(){
/*    try(FileReader reader = new FileReader(name))
    {
        strings = new ArrayList<>();
        Scanner sc = new Scanner(reader);
        int i = 0;
        while(sc.hasNextLine()){

                strings.add(sc.nextLine());
                if(strings.get(strings.size() - 1).trim().length() == 0){
                    strings.remove(strings.size() - 1);
                }
            i++;
        }
        reader.close();

    }
    catch(IOException ex){

        System.out.println(ex.getMessage());
    }*/
        strings = new ArrayList<String>();
        /*StringBuilder buf = new StringBuilder();
        for (int j = 0; j < input_text.length(); j++) {
            Log.d("DOD", "" + input_text.charAt(j));
            if((input_text.charAt(j))=='\n') {
                strings.add(buf.toString());
                buf = new StringBuilder();
            }else {
                buf.append(input_text.charAt(j));
            }
        }*/
        String[] lines = input_text.split("\\r?\\n");
        strings.addAll(Arrays.asList(lines));
        for (int i = 0; i < strings.size(); i++) {
            Log.d("DOD",strings.get(i));
        }
    }


    public void  createListing (ArrayList<Sentence> _sentences) throws Exception{
        output_text = new ArrayList<String>();
        Sentence buf;
        String s;
        /*File newfile = new File("/Users/dima/Desktop/Test55.lst");
        if (!newfile.exists()) {

            newfile.createNewFile();
            newfile.setWritable(true);
        }
        FileWriter fw = new FileWriter(newfile);
        BufferedWriter fileWriter = new BufferedWriter(fw);*/

        for (int i = 0; i < _sentences.size(); i++) {
            Log.d("DOD","SENTENCE" + i);
            buf = _sentences.get(i);
            s = strings.get(i);
            if(s.equals("end")) {
                output_text.add("                             end");
            }
            else if (ERROR.error.contains(i + 1)) {
                output_text.add(String.format("%-5d %-5s %-16s %-20s %-50s",buf.getSentence().get(0).x, formHEX(Integer.toHexString(buf.getNON_STATIC_OFFSET())),buf.struct, s,"\n error"));
            }else {
                output_text.add(String.format("%-5d %-5s %-16s %-10s",buf.getSentence().get(0).x, formHEX(Integer.toHexString(buf.getNON_STATIC_OFFSET())),buf.struct, s));
            }
            //fileWriter.newLine();
        }
        // fileWriter.write(String.format);
        ArrayList<String> table = List_table.create_table();
        for (String buf1 : table) {
            output_text.add(buf1);
        }
        if (!ERROR.error.isEmpty()) {
            output_text.add("ERRORS:");
            Iterator<Integer> integerIterator = ERROR.error.iterator();
            while (integerIterator.hasNext()){
                output_text.add("line " + integerIterator.next().toString());
            }
        }else {
            output_text.add("SUCCESSESFUL RUN(NO ERRORS)");
        }
        for (int i = 0; i < output_text.size(); i++) {
            Log.d("DOD",output_text.get(i));
        }
    }

    public ArrayList<String> getStrings() {
        return strings;
    }
    static public String formHEX(String s){
        String buf;
        if(s.length() == 1){
            buf = "000" + s;
            return buf.toUpperCase();
        }
        else if(s.length() == 2){
            buf = "00" + s;
            return buf.toUpperCase();
        }
        else if(s.length() == 3){
            buf = "0" + s;
            return buf.toUpperCase();
        }
        return s.toUpperCase();
    }

    public static void setInput_text(String input_text) {
        File_analyze.input_text = input_text;
    }

    public static List<String> getOutput_text() {
        return output_text;
    }
}
