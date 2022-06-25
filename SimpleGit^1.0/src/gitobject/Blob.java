package gitobject;

import sha1.SHA1;
import zlib.ZLibUtils;

import java.io.*;

public class Blob extends GitObject{
    
	public String getFmt(){
        return fmt;
    }
    public String getMode(){
        return mode;
    }
    public String getPath() {
        return path;
    }
    public String getValue(){
        return value;
    }
    public String getKey() { return key; }
    public Blob(){};
    /**
     * Constructing blob object from a file
     * @param file
     * @throws Exception
     */
    public Blob(File file) throws Exception {
        fmt = "blob";
        mode = "100644";
        value = getValue(file);
        genKey(file);
        compressWrite();
    }

    /**
     * Deserialize a blob object from an existed hash file in .jit/objects.
     * @param Id
     * @throws IOException
     */
    public static Blob deserialize(String Id) throws IOException {
        try{
        /**
         * Todo: Add your code here.
         */
        }catch (Exception e){
            e.printStackTrace();
        }
        /* Todo: You should delete the return statement before you start. */
        return new Blob();
    }

    /**
     * Generate key from file.
     * @param file
     * @return String
     * @throws Exception
     */
    public String genKey(File file) throws Exception {
        /**
         * Add your code here.
         */
        return key;
    }
    @Override
    public String toString(){
        return "100644 blob " + key;
    }
}
