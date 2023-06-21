package pl.generujoperat.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


import pl.generujoperat.model.TechnicalReport;

public class WordHelper {


  public static ByteArrayInputStream generateWord(String idReport, String companyName, String myDzialkaEwid)
      throws FileNotFoundException, IOException,
      InvalidFormatException {

    try (XWPFDocument doc = new XWPFDocument()) {
      TechnicalReport techReport=new TechnicalReport();
      techReport.createHeader(doc, idReport, myDzialkaEwid);

      XWPFParagraph p1 = doc.createParagraph();
      p1.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun r1 = p1.createRun();
      techReport.styleTextAndAddBreak(r1, true, false, 28, "OPERAT TECHNICZNY", "Times New Roman");


      XWPFParagraph p2 = doc.createParagraph();
      p2.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun r2 = p2.createRun();
      techReport.styleTextAndAddBreak(r2, false, true, 18, "mapa z projektem podziału nieruchomości", "Arial");
      techReport.styleTextAndAddBreak(r2, false, true, 18, "KW WA5M/00000/9", "Arial");

      XWPFParagraph p3 = doc.createParagraph();
      p3.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun r3 = p3.createRun();
      techReport.styleText(r3, false, true, 22, "Spis treści", "Times New Roman");

      techReport.createContents(doc);
      r3.addBreak();


     
      XWPFParagraph p4 = doc.createParagraph();
            p4.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun r4 = p4.createRun();
            r4.addBreak();
            techReport.styleText(r4, false, true, 13, "sporządził: geodeta uprawniony  nr 111 ", "Arial");
            techReport.styleText(r4, false, true, 13, "Jan Nowak ", "Arial");
            r4.addBreak();
            techReport.styleText(r4, false, true, 13, "wykonawca:"+companyName, "Arial");
            r4.addBreak();
            techReport.styleText(r4, false, true, 13, "data:", "Arial");



      ByteArrayOutputStream b = new ByteArrayOutputStream();
      doc.write(b);
      return new ByteArrayInputStream(b.toByteArray());
    }

  }
}
