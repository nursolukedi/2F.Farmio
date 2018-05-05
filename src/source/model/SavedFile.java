package src.source.model;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SavedFile {

    File file;

    Date date;

    String name;

    SimpleDateFormat dtf;

    Calendar cal;

    int current_index;

    public SavedFile(int index)
    {
        dtf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            file = new File("src/data/savedFiles/file_" + index + ".ser");
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {

        }
        cal = Calendar.getInstance();
        System.out.println(dtf.format(cal.getTime()));

        date = new Date();
        try {
            date = dtf.parse(dtf.format(cal.getTime()));
        } catch (ParseException e) {

        }
        this.current_index = index;
    }

    public File getFile() {
        return file;
    }


    public int getCurrent_index()
    {
        return current_index;
    }

}
