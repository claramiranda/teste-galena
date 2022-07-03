package com.cannamiranda.galena.controller;
import com.cannamiranda.galena.model.Galener;
import com.cannamiranda.galena.model.Grupo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TODO tratar data e formatos de celula diferentes de texto
@Controller
public class PlanilhaController {

    //private static String fileName = "resources/exemplo_galena.xlsx";
    private static String fileName = "resources/galena.xlsx";
    private int rowStart = 4;
    private FileInputStream arquivo;

    private XSSFSheet loadSheet() throws IOException {
        arquivo = new FileInputStream(new File(PlanilhaController.fileName));
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
        XSSFSheet sheetGaleners = workbook.getSheetAt(0);

        return sheetGaleners;
    }

    private Galener getGalenerFromRow(Row row){

        Galener galener = new Galener();
        int celMax = 7;

        //Iterator<Cell> cellIterator = row.cellIterator();
        //while (cellIterator.hasNext()){
        for(int celNum = 0; celNum <= celMax; celNum++){

            //Cell cell = cellIterator.next();
            //Cell cell = row.getCell(celNum,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            //Cell cell = row.getCell(celNum,Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
            Cell cell = row.getCell(celNum);

                switch (celNum){
                    case 0:
                        galener.setEmail(cell.getStringCellValue());
                        break;

                    case 1:
                        galener.setNome(cell.getStringCellValue());
                        break;

                    case 2:
                        galener.getGrupo().setId(cell.getStringCellValue());
                        break;

                    case 3:
                        galener.getGrupo().setNome(cell.getStringCellValue());
                        break;

                    case 4:
                        galener.setCpf(cell.getStringCellValue());
                        break;

                    case 5:
                        galener.setTelefone(cell.getStringCellValue());
                        break;

                    case 6:
                        galener.setDtNascimento(cell.getStringCellValue());
                        break;

                    case 7:
                        galener.setEndereco(cell.getStringCellValue());
                        break;
                }
        }

        return galener;
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


    //Rotas
    @RequestMapping("/galeners")
    @ResponseBody
    public List<Galener> readPlanilha() throws FileNotFoundException {
        List<Galener> galeners = new ArrayList<Galener>();

        try{
            XSSFSheet sheet = loadSheet();
            int rowEnd = getRowEnd(sheet);

            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++){

                Row row = sheet.getRow(rowNum);
                galeners.add(getGalenerFromRow(row));
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
