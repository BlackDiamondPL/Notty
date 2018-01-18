package org.notty;

import java.io.File;
import java.util.ArrayList;

public class APPDATA {

    public static final String OSNAME = System.getProperty("os.name");
    public static final String APP_VERSION = "1.0.9ALPHA";
    public static String currentFile;
    public static ArrayList<String> tmp_fileCtn;
    public static File opnFile;
    public static boolean fileSaved = true;
    public static String[] cargs;
}
