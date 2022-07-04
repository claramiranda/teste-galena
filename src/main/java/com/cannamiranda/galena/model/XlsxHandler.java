package com.cannamiranda.galena.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsxHandler {
    private static String fileName;
    private int rowStart;
    private int cellMax;
    private int rowEnd;
    private FileInputStream arquivo;


    public XlsxHandler(String fileName, int rowStart, int cellMax) throws IOException {
        //todo tratar o filename pra sempre incluir a pasta antes
        this.fileName = fileName;

        this.rowStart = rowStart;
        this.cellMax = cellMax;

    }

    private XSSFSheet loadSheet() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
        XSSFSheet sheetGaleners = workbook.getSheetAt(0);
        return sheetGaleners;
    }

    private int getRowEnd(Sheet sheet){
        int maxRow = 0;
        int rowEnd = sheet.getLastRowNum();

        for (int rowNum = rowStart; rowNum <= rowEnd; rowNum++){

            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(0,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (cell == null){
                //System.out.println("Email vazio na linha " + rowNum);
                continue;
            }
            else {
                maxRow++;
            }
        }

        System.out.println("Quantidade de linhas validas: " + maxRow);
        return rowStart + maxRow;
    }

    private Galener getGalenerFromRow(Row row){

        Galener galener = new Galener();

        for(int cellNum = 0; cellNum <= cellMax; cellNum++){

            Cell cell = row.getCell(cellNum);

            switch (cellNum){
                case 0:
                    galener.setEmail(cell.getStringCellValue());
                    break;

                case 1:
                    galener.setNome(cell.getStringCellValue());
                    break;

                case 2:
                    galener.setGrupoid((cell.getStringCellValue()));
                    break;

                case 3:
                    galener.setGruponome((cell.getStringCellValue()));
                    break;

                case 4:
                    galener.setCpf(cell.getStringCellValue());
                    break;

                case 5:
                    galener.setTelefone(cell.getStringCellValue());
                    break;

                case 6:
                    galener.setDtnascimento(cell.getStringCellValue());
                    break;

                case 7:
                    galener.setEndereco(cell.getStringCellValue());
                    break;
            }
        }

        return galener;
    }

    public List<Galener> getGalenerListFromXlsxData() throws FileNotFoundException {
        List<Galener> galeners = new ArrayList<Galener>();
        this.arquivo = new FileInputStream(new File(XlsxHandler.fileName));

        try{
            XSSFSheet sheet = loadSheet();
            this.rowEnd = getRowEnd(sheet);

            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++){

                Row row = sheet.getRow(rowNum);
                Galener galener = getGalenerFromRow(row);
                galeners.add(galener);
            }

            arquivo.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return galeners;
    }

}
