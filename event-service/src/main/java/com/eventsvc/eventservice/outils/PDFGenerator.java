package com.eventsvc.eventservice.outils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eventsvc.eventservice.entities.Event;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;

public class PDFGenerator {

  private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

  public static ByteArrayInputStream customerPDFReport(List<Event> events) throws IOException {
    Document document = new Document(PageSize.A4, 10, 10, 10, 10);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {

      PdfWriter.getInstance(document, out);
      document.open();

      // Add Text to PDF file ->
      Font font = FontFactory.getFont(FontFactory.TIMES, 13, BaseColor.BLACK);

      Paragraph para = new Paragraph("Résumés des Evénements", font);
      para.setLeading(15);

      PdfPTable tableTest = new PdfPTable(3);

      tableTest.setWidthPercentage(100);
      tableTest.setWidths(new int[] { 1, 2, 1 });
      PdfPCell cellEmpt = new PdfPCell(new Paragraph(""));
      cellEmpt.setBorder(Rectangle.NO_BORDER);
      tableTest.addCell(cellEmpt);

      PdfPCell cellTitle = new PdfPCell(para);
      cellTitle.setBorder(Rectangle.NO_BORDER);
      cellTitle.setUseAscender(true);
      cellTitle.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
      cellTitle.setPaddingBottom(20);
      tableTest.addCell(cellTitle);

      PdfPCell cellAttache = new PdfPCell(new Paragraph(""));
      cellAttache.setBorder(Rectangle.NO_BORDER);
      cellAttache.setUseAscender(true);
      cellAttache.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellAttache.setHorizontalAlignment(Element.ALIGN_CENTER);

      tableTest.addCell(cellAttache);

      document.add(tableTest);
      document.add(Chunk.NEWLINE);

      PdfPTable table = new PdfPTable(4);
      table.setWidthPercentage(100);
      table.setWidths(new int[] { 3, 2, 5, 5 });

      // Add PDF Table Header ->
      // Stream.of("ID", "First Name", "Last Name")
      // .forEach(headerTitle -> {
      // PdfPCell header = new PdfPCell();
      // Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
      // header.setBackgroundColor(BaseColor.LIGHT_GRAY);
      // header.setHorizontalAlignment(Element.ALIGN_CENTER);
      // header.setBorderWidth(2);
      // header.setPhrase(new Phrase(headerTitle, headFont));
      // table.addCell(header);
      // });

      PdfPCell cellnum = new PdfPCell(new Phrase("Objet"));

      cellnum.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellnum.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellnum);

      PdfPCell cellDate = new PdfPCell(new Phrase("Date"));

      cellDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellDate.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellDate);

      PdfPCell cell = new PdfPCell(new Phrase("Activités"));

      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);

      table.addCell(cell);

      PdfPCell cellDatee = new PdfPCell(new Phrase("Suggestions"));

      cellDatee.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellDatee.setHorizontalAlignment(Element.ALIGN_CENTER);

      table.addCell(cellDatee);

      for (Event e : events) {

        PdfPCell idCell = new PdfPCell(new Phrase(e.getObjet(), font));

        idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        idCell.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(idCell);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        PdfPCell dateAc = new PdfPCell(new Phrase(df.format(e.getStartDate()), font));

        dateAc.setVerticalAlignment(Element.ALIGN_MIDDLE);
        dateAc.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(dateAc);

        PdfPCell autCell = new PdfPCell(new Phrase(e.getActivites(), font));
        autCell.setPadding(10);
        autCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        autCell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

        table.addCell(autCell);

        PdfPCell titreCell = new PdfPCell(new Phrase(e.getSuggestions(), font));
        titreCell.setPadding(10);
        titreCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        titreCell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

        table.addCell(titreCell);

      }

      document.add(table);
      document.close();
    } catch (DocumentException e) {
      logger.error(e.toString());
    }

    return new ByteArrayInputStream(out.toByteArray());
  }
}