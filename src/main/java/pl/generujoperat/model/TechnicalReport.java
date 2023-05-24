package pl.generujoperat.model;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import lombok.Data;

@Data
public class TechnicalReport {
  private Long id;
  private String idReport;
  private String plotRegistrationNumber;

  public void styleText(XWPFRun run, Boolean bold, Boolean italic, Integer fontSize, String text, String fontFamily) {
    run.setBold(bold);
    run.setItalic(italic);
    run.setFontSize(fontSize);
    run.setText(text);
    run.setFontFamily(fontFamily);
  }

  public void styleTextAndAddBreak(XWPFRun run, Boolean bold, Boolean italic, Integer fontSize, String text,
      String fontFamily) {
    styleText(run, bold, italic, fontSize, text, fontFamily);
    run.addBreak();
  }

  public void createHeader(XWPFDocument doc, String idReport) {
    XWPFHeaderFooterPolicy headerFooterPolicy = doc.getHeaderFooterPolicy();
    if (headerFooterPolicy == null)
      headerFooterPolicy = doc.createHeaderFooterPolicy();
    XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
    XWPFParagraph paragraph = header.createParagraph();
    paragraph.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun run = paragraph.createRun();
    styleTextAndAddBreak(run, false, true, 11, "woj. ", "Times New Roman");
    styleTextAndAddBreak(run, false, true, 11, "powiat ", "Times New Roman");
    styleTextAndAddBreak(run, false, true, 11, "dzielnica ", "Times New Roman");
    styleTextAndAddBreak(run, false, true, 11, "obr. ", "Times New Roman");
    styleTextAndAddBreak(run, false, true, 11, "dz.ew. ", "Times New Roman");
    styleTextAndAddBreak(run, false, true, 11, "ul. ", "Times New Roman");
    XWPFRun runBG = paragraph.createRun();
    styleTextAndAddBreak(runBG, true, true, 11, idReport, "Times New Roman");
  }

  public void createContents(XWPFDocument document) {
    XWPFTable table = document.createTable();
    // Creating first Row
    XWPFTableRow row = table.getRow(0);
    XWPFParagraph paragraph = row.getCell(0).getParagraphs().get(0);
    XWPFRun run = paragraph.createRun();
    styleText(run, true, true, 11, "L.p.", "Arial");
    table.setWidth("100%");
    row.addNewTableCell();
    row.getCell(0).getParagraphArray(0).setSpacingAfter(0);
    row.getCell(1).getParagraphArray(0).setSpacingAfter(0);

    styleText(table.getRow(0).getCell(1).getParagraphs().get(0).createRun(),
        true, true, 11, "NAZWA DOKUMENTU", "Arial");
    row.addNewTableCell();
    row.getCell(2).getParagraphArray(0).setSpacingAfter(0);
    styleText(table.getRow(0).getCell(2).getParagraphs().get(0).createRun(),
        true, true, 11, "NR STRONY", "Arial");

    // Creating second Row
    // XWPFTableRow row2 = table.createRow();

    for (int i = 1; i < 5; i++) {
      XWPFTableRow row2 = table.createRow();
      row2.getCell(0).setText(String.valueOf(i));
      // row2.getCell(1).setText(String.valueOf(i));

      // getCell(i).setText("C, C ++");
    }
    // run.addBreak();
  }

}
