package gitobject;



import sha1.SHA1;

import zlib.ZLibUtils;
import fileoperation.FileReader;

import java.io.*;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.*;


public class Tree extends GitObject{
    protected ArrayList<GitObject> treeList;
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
            Tree tree = new Tree();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Id));
            tree.key = SHA1.getHash(Id);
        }catch (Exception e){
            e.printStackTrace();
        }
        /* Todo: You should delete the return statement before you start. */
        return new Tree();
    }


    /**
     * Sort the files in a certain order. You should consider whether it's a file or a directory.
     * @param fs 入参为文件夹列表
     * @return List
     */
    public static List sortFile(File[] fs) {
        List fileList = Arrays.asList(fs);
        Collections.sort(fileList, new Comparator<File>() {
            @Override // 表示重写方法
            public int compare(File o1, File o2) {
                /* Todo: Add your code here. */
                if (o1.isDirectory()) {
                    sortFile(o1.listFiles());
                }
                if (o2.isDirectory()) {
                    sortFile(o2.listFiles());
                }
                return (o1.getName()).compareTo(o2.getName());// 按照o1、o2的名称排序

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
        File[] fs =dir.listFiles();
        List<File> fileList=sortFile(fs);
        StringBuilder stringBuilder=new StringBuilder();
        for (File file : fileList) {
            if (file.isFile()) {
                stringBuilder.append(GitObject.getValue(file));
            }else if (file.isDirectory()){
                stringBuilder.append(genKey(file));
            }
        }

        String value=stringBuilder.toString();
        String content="040000 tree"+" "+value;
        key= SHA1.getHash(content);
        return key;
    }

    @Override
    public String toString(){
        return "040000 tree " + key;
    }

}
