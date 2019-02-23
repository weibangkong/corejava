package com.kwb.try_catch;

public class Main {
    public static void main(String[] args) throws Exception{
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance annoyance) {
                System.out.println("catch the execption of type Annoyance");
                throw annoyance;
            }
        } catch (Sneeze s) {
            System.out.println("catch the execption of type Sneeze");
            return ;
        }finally {
            System.out.println("Hello world");
        }
    }
}
