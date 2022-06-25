package gitobject;
import repository.Repository;
import zlib.ZLibUtils;

import java.io.*;


public class GitObject {

    protected String fmt;                  //type of object
    protected String key;                  //key of object
    protected String mode;                 //mode of object
    protected static String path = Repository.getGitDir() + File.separator + "objects";          //absolute path of objects
    protected String value;                //value of object

    public String getFmt(){
        return fmt;
    }
    public String getKey() { return key; }
    public String getMode(){
        return mode;
    }
    public String getPath() {
        return path;
    }
    public String getValue(){
        return value;
    }


    public GitObject(){}
    /**
     * Get the value(content) of file
     * @param file
     * @return String
     * @throws IOException
     */
    public static String getValue(File file) throws IOException {
        /* Todo: Add your code here
        *   You should delete the return statement below before coding.  */

        return new String();
    }
    /**
     * Todo: Serialize the object to the local repository.
     * @throws Exception
     */
    public void writeObject() throws Exception{
        /**
         * Add your code here.
         */
    }

    /**
     * Todo: Serialize the object and compress with zlib.
     * @throws Exception
     */
    public void compressWrite() throws Exception{
        /**
         * Add your code here.
         */
    }

}
