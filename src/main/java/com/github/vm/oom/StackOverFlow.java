package com.github.vm.oom;

/**
 * VM Args: -Xss128k
 * @author Kevin
 *
 */
public class StackOverFlow {

    int i = 0;
    public static void main(String[] args) {
        StackOverFlow sof = new StackOverFlow();
        try {
            sof.recursion();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(sof.i);
        }
    }
    
    private void recursion() {
        i++;
        recursion();
    }

}
