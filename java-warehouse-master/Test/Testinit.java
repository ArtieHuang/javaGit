package Test;

import commander.CLI;
import core.JitInit;

import java.io.IOException;

public class Testinit {
    public static void main(String[] args){
        try{
            String[] s1 = {"jit", "init", "C:\\Users\\huang\\Desktop\\学习\\二学位\\Java"};
            String[] s2 = {"jit", "init", "-help"};

            CLI.jitInit(s1);
            CLI.jitInit(s2);


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

