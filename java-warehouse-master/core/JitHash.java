package core;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import gitobject.GitObject;
import gitobject.Blob;
import gitobject.Tree;
import fileoperation.*;
import repository.Repository;
import sha1.SHA1;

public class JitHash {

    private static String path;

    /**
     * Init repository in your working area.
     *
     * @param filename 文件名绝对路径
     * @throws IOException 抛出IOE异常
     */

    public static void hash(String filename) throws Exception {
        /* Todo: You should pass the filename in this function, and generate a hash file in your repository.
         *   Add your code here.*/
        File file = new File(path + File.separator + filename);
        if (!file.exists()) {
            System.out.println("file not exists");
            return;
        }
        String append = new String();
        if (file.isDirectory()) {
            Tree tree = new Tree(file);
            append = tree.toString();
            tree.writeObject();
        } else {
            Blob blob = new Blob(file);
            append = blob.toString();
            blob.writeObject();
        }
    }
}






