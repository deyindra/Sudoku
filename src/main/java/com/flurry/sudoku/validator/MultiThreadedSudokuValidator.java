package com.flurry.sudoku.validator;

import com.flurry.sudoku.exception.SudokuException;
import com.flurry.sudoku.reader.ISudokuReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

final class MultiThreadedSudokuValidator extends AbstractSudokuValidator{
    private AtomicBoolean result;
    private static final Logger LOG = LoggerFactory.getLogger(MultiThreadedSudokuValidator.class);

    public MultiThreadedSudokuValidator(ISudokuReader reader) throws SudokuException {
        super(reader);
        result = new AtomicBoolean(true);
    }

    @Override
    public boolean checkSudoku() throws SudokuException {
        try{
            Thread rowThread = new Thread(new RowCheckRunnable());
            Thread colThread = new Thread(new ColCheckRunnable());
            Thread blockThread = new Thread(new BlockCheckRunnable());
            rowThread.start();
            colThread.start();
            blockThread.start();
            rowThread.join();
            colThread.join();
            blockThread.join();
        }catch (Exception ex){
            throw new SudokuException(ex.getMessage());
        }
        return result.get();
    }


    private class RowCheckRunnable implements Runnable{
        @Override
        public void run() {
            try {
                LOG.info("Row Checker started.....");
                for (int row = 1; result.get() && row <= totalLength; row++) {
                    AbstractSudokuValidator validator = new RowSudokuValidator(reader, row);
                    result.getAndSet(validator.checkSudoku());
                }
            }catch (SudokuException ex){
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    private class ColCheckRunnable implements Runnable{
        @Override
        public void run() {
            try {
                LOG.info("Col Checker started.....");
                for(int col=1;result.get() && col<=totalLength;col++){
                    AbstractSudokuValidator validator = new ColSudokuValidator(reader,col);
                    result.getAndSet(validator.checkSudoku());
                }
            }catch (SudokuException ex){
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    private class BlockCheckRunnable implements Runnable{
        @Override
        public void run() {
            try {
                LOG.info("Block Checker started.....");
                int squareRootLength = (int)Math.sqrt(totalLength);
                for(int row=1;result.get() && row<=totalLength;row+=squareRootLength){
                    for(int col=1;result.get() && col<=totalLength;col+=squareRootLength){
                        AbstractSudokuValidator validator = new BlockSudokuValidator(reader,row,col);
                        result.getAndSet(validator.checkSudoku());
                    }
                }
            }catch (SudokuException ex){
                throw new RuntimeException(ex.getMessage());
            }
        }
    }


}
