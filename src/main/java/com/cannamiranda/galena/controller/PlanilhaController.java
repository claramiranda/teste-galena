package com.cannamiranda.galena.controller;
import com.cannamiranda.galena.model.Galener;
import com.cannamiranda.galena.model.Grupo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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


//TODO - Tratar celulas em branco
//TODO - Tratar todas as celulas pra texto



@Controller
public class PlanilhaController {

    //private static String fileName = "C:/Users/Clara/Documents/projetinhos/galena/sample_galena1.xlsx";
    private static String fileName = "resources/exemplo_galena.xlsx";
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

        Iterator<Cell> cellIterator = row.cellIterator();

        //while (cellIterator.hasNext()){
        for(int celNum = 0; celNum <= celMax; celNum++){

            //Cell cell = cellIterator.next();
            Cell cell = row.getCell(celNum,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            //Cell cell = row.getCell(celNum,Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
            //Cell cell = row.getCell(celNum);

            if( cell == null) {
                System.out.println("Vazio na celula: " + celNum);
                if (celNum == 0){
                    continue;
                }

            }

            //filtrando email vazio
            if (celNum == 0){
                String email = cell.getStringCellValue();
                System.out.println("Entrou no if. email: " + email);
            }


            switch (celNum){

                case 0:
                    galener.setEmail(cell.getStringCellValue());
                    if (galener.getEmail() == null){
                        System.out.println("Email Vazio dentro do laço");
                        //continue;
                        //return galener;
                    }
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

        System.out.println(galener);

        return galener;
    }

    @RequestMapping("/galeners")
    @ResponseBody
    public List<Galener> readPlanilha() throws FileNotFoundException {
        List<Galener> galeners = new ArrayList<Galener>();

        try{
            XSSFSheet sheet = loadSheet();

            int rowStart = 4;
            //int rowEnd = sheet.getLastRowNum();
            int rowEnd = 20;


            //Iterator<Row> rowIterator = sheet.iterator();

            //while (rowIterator.hasNext()){
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++){

                //Row row = rowIterator.next();
                //int rowNum = row.getRowNum();
                Row row = sheet.getRow(rowNum);
                galeners.add(getGalenerFromRow(row));
            }
            arquivo.close();
            //System.out.println(galeners.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return galeners;
    }
}
