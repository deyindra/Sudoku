package com.flurry.sudoku;


import com.flurry.sudoku.controller.ISudokuController;
import com.flurry.sudoku.controller.InMemorySudokuController;
import com.flurry.sudoku.exception.SudokuException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static void printUsage(){
        System.out.println(String.format("Usage : %s %s %s...", Main.class.getSimpleName(), "[length of side of the sudoku board]", "[file path]"));
    }
    public static void main(String[] args){
        try {
            if (args.length != 2) {
                printUsage();
            } else {
                int number = Integer.parseInt(args[0]);
                String filePath = args[1];
                ISudokuController controller = new InMemorySudokuController(number,filePath);
                boolean result = controller.performValidation();
                if(result){
                    System.out.println("Sudoku is valid solution");
                }else{
                    System.out.println("Given Sudoku is invalid solution");
                }
            }
        }catch (SudokuException ex){
            LOGGER.error(ex.toString());
        }catch (Exception ex){
            printUsage();
            LOGGER.error(ex.toString());
        }
    }
}
