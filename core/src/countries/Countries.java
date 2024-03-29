package countries;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Countries {
    //Variables for reading from file
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;
    //Variable for data holder, an ArrayList that uses the Country object only
    private static ArrayList<Country> data = new ArrayList<>();
    //Variable for csv file name
    private static final String CSV_FILE_PATH = "C:\\Users\\csipro\\Desktop\\Countries.csv";
    //Instance of data holder
    private static Countries instance;
    //Private constructor
    private Countries(){
        try {
            populate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static synchronized Countries getInstance() {
        if(instance == null){
            instance = new Countries();
        }
        return instance;
    }

    public List<String> getCountriesByContinent(String cont){
        List<String> countries = new ArrayList<>();
        for(Country c : data){
            if(c.continent.equals(cont)){
                countries.add(c.name);
            }
        }
        return countries;
    }
    public List<String> getCountriesByLang(String lang){
        List<String> countries = new ArrayList<>();
        for(Country c : data){
            if(c.lang.equals(lang)){
                countries.add(c.name);
            }
        }
        return countries;
    }
    public static List<String> getAllContinents(){
        List<String> conts = new ArrayList<>();
        HashMap<String, Integer> tempList = new HashMap<>();
        for(int i = 0; i < data.size(); i++){
            tempList.put(data.get(i).continent, i);
        }
        System.out.println(tempList.keySet());
        conts.addAll(tempList.keySet());
        return conts;
    }
    public static List<String> getAllLangs(){
        List<String> langs = new ArrayList<>();
        HashMap<String, Integer> tempList = new HashMap<>();
        for(int i = 0; i < data.size(); i++){
            tempList.put(data.get(i).lang, i);
        }
        langs.addAll(tempList.keySet());
        return langs;
    }

    public static List<String> getAllCountries(){
        List<String> all = new ArrayList<>();
        for(Country c : data){
            StringBuilder sb = new StringBuilder();
            sb.append(c.continent + ", ");
            sb.append(c.name + ", ");
            sb.append(c.size + ", ");
            sb.append(c.lang);
            all.add(sb.toString());
        }
        return all;
    }

    public List<String> getCountriesBySize(int size){
        List<String> countries = new ArrayList<>();
        for(Country c : data){
            if(c.size >= size){
                countries.add(c.name);
            }
        }
        return countries;
    }

    private void populate() throws Exception {
        bufferedReader = new BufferedReader(new FileReader(new File(CSV_FILE_PATH)));
        String s = "";
        int i = 0;
        while((s = bufferedReader.readLine()) != null){
            if(i != 0) {
                String[] parts = s.split(",");
                for(String t : parts){
                    t.replaceAll(" ","");
                }
                Country country = new Country(parts[0],parts[1],Integer.valueOf(parts[2]),parts[3]);
                data.add(country);
                System.out.println("Loaded one country");
            }
            i++;
        }
    }

    public static void addNewCountry(String continent, String name, int size, String lang) {
        Country c = new Country(continent, name, size, lang);
        data.add(c);
    }

    //Inner private class used to create an object for each country
    private static class Country{
        //Country variables
        private String continent;
        private String name;
        private int size;
        private String lang;
        //Country constructor which is used in first boot and when added new countries
        public Country(String continent, String name, int size, String lang){
            this.continent = continent;
            this.name = name;
            this.size = size;
            this.lang = lang;
        }
        public String getContinent() {
            return continent;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        public String getLang() {
            return lang;
        }

    }
}
