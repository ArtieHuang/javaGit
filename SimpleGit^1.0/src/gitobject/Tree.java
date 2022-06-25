package gitobject;



import sha1.SHA1;

import zlib.ZLibUtils;
import fileoperation.FileReader;

import java.io.*;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.*;


public class Tree extends GitObject{
    protected ArrayList<GitObject> treeList;	//GitObjects in tree

    public ArrayList<GitObject> getTreeList(){
        return treeList;
    }

    public Tree(){}
    
    /**
     * Constructor
     * @param file
     * @throws Exception
     */
    public Tree(File file) throws Exception {
        this.treeList = new ArrayList<>();
        this.fmt = "tree";
        this.mode = "040000";
        this.value = "";
        genKey(file);
        compressWrite();
    }

    /**
     * Deserialize a tree object with treeId and its path.
     * @param Id
     * @param Id
     * @throws IOException
     */
    public static Tree deserialize(String Id) throws IOException {
        try{
            /**
             * Todo: Add your code here.
             */
        }catch (Exception e){
            e.printStackTrace();
        }
        /* Todo: You should delete the return statement before you start. */
        return new Tree();
    }


    /**
     * Sort the files in a certain order. You should consider whether it's a file or a directory.
     * @param fs
     * @return List
     */
    public List sortFile(File[] fs){
        List fileList = Arrays.asList(fs);
        Collections.sort(fileList, new Comparator<File>() {
            @Override //表示重写方法
            public int compare(File o1, File o2) {
                /* Todo: Add your code here. */

                return o1.compareTo(o2);

            }
        });
        return fileList;
    }

    /**
     * Generate the key of a tree object.
     * @param dir
     * @return String
     * @throws Exception
     */
    public String genKey(File dir) throws Exception{
        /* Todo: Add your code here. */

        return key;
    }

    @Override
    public String toString(){
        return "040000 tree " + key;
    }

}
