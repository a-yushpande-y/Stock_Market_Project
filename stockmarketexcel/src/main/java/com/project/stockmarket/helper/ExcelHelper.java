package com.project.stockmarket.helper;

import java.io.ByteArrayInputStream;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*; 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.project.stockmarket.dto.StockPriceRequestDto;

public class ExcelHelper {
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Company Code", "Stock Exchange", "Price Per Share(in Rs)", "Date","Time" };
 // static String SHEET = "Sh";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

 
  public static List<StockPriceRequestDto> excelToStock(InputStream is) throws ParseException {
	  try {
      Workbook workbook = new XSSFWorkbook(is);
     // LOGGER.log(Level.INFO, Integer.toString(workbook.getNumberOfSheets()));
      Sheet sheet = workbook.getSheetAt(0);
     // LOGGER.log(Level.INFO, sheet.getSheetName() );
      Iterator<Row> rows = sheet.iterator();

      List<StockPriceRequestDto> dtos = new ArrayList<StockPriceRequestDto>();

      int rowNumber = 0;
      loop:
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        StockPriceRequestDto dto = new StockPriceRequestDto();

        int cellIdx = 0;
        String s="";
        
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
          case 0:
        	  s = currentCell.getStringCellValue();
        	 // s= s.replaceAll("[^0-9]", "");
        	  LOGGER.log(Level.INFO, s );
        	 if(s.length()==0)
        		 break loop;
            dto.setCompanyCode(Integer.valueOf(s));
            break;

          case 1:
        	   s= currentCell.getStringCellValue();
        	  LOGGER.log(Level.INFO, s );
            dto.setStockExchange(s);
            break;

          case 2:
        	  Double d= currentCell.getNumericCellValue();
        	  LOGGER.log(Level.INFO, Double.toString(d));
            dto.setPrice(d);
            break;

          case 3:
        	 s= currentCell.getStringCellValue();
        	 LOGGER.log(Level.INFO, s );
        	 Date initDate = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        	 s = formatter.format(initDate);
            dto.setDate(s);
            break;
            
          case 4:
        	  s= currentCell.getStringCellValue();
        	  LOGGER.log(Level.INFO, s );
              dto.setTime(s);
              break;

          default:
            break;
          }

          cellIdx++;
        }

        dtos.add(dto);
      }

      workbook.close();

      return dtos;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}

