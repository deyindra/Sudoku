package com.flurry.sudoku;


import com.flurry.sudoku.controller.ISudokuController;
import com.flurry.sudoku.controller.InMemorySudokuController;
import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.validator.constant.ValidatorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static void printUsage(){
        System.out.println(String.format("Usage : %s %s %s %s...", Main.class.getSimpleName(), "[length of side of the sudoku board]", "[file path]", "[optional validator strategy]"));
    }
    public static void main(String[] args){
        try {
            if(args.length==2 || args.length==3){
                int number = Integer.parseInt(args[0]);
                String filePath = args[1];
                ValidatorType type = ValidatorType.get();
                if(args.length==3){
                    type = ValidatorType.get(args[2]);
                }
                ISudokuController controller = new InMemorySudokuController(number,filePath, type);
                boolean result = controller.performValidation();
                if(result){
                    System.out.println("Sudoku is valid solution");
                }else{
                    System.out.println("Given Sudoku is invalid solution");
                }
            }else{
                printUsage();
            }
        }catch (SudokuException ex){
            LOGGER.error(ex.toString());
        }catch (Exception ex){
            printUsage();
            LOGGER.error(ex.toString());
        }
    }
}
