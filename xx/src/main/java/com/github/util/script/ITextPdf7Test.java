package com.github.util.script;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.File;
import java.io.IOException;

public class ITextPdf7Test {

    public static void main(String[] args) {
        String inputTemplatePath = "D://tmp/test.pdf";
        String outputFilledPath = "D://tmp/xx.pdf";

        try {
            // 加载 PDF 文件
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(inputTemplatePath), new PdfWriter(outputFilledPath));
            Document doc = new Document(pdfDoc);

            // 获取 PDF 表单
            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

            // 获取文本域并填充数据
            PdfFormField nameField = form.getField("venueName");
            PdfFormField addressField = form.getField("address");

            // 设置文本域的字体
//            PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", true);


//            nameField.setFont(font);
//            addressField.setFont(font);

            // 填充数据
            nameField.setValue("John Doe");
            addressField.setValue("123 Main Street, City");

            doc.close();
            System.out.println("PDF文本域填充完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replacePlaceholder(Document doc, String placeholder, String value, PdfFont font) {
        // 创建一个段落并添加到文档中
        Paragraph p = new Paragraph(value).setFont(font);
        doc.add(p);
    }
}