package com.banvien.vmsreport.common.utils;

import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocReplaceVariables {

    public static void replace(String docx, String outputDocx, HashMap<String, String> mapValue) {

        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(docx));
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            documentPart.variableReplace(mapValue);
            wordMLPackage.save(new File(outputDocx));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<Object>();
        if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();

        if (obj.getClass().equals(toSearch))
            result.add(obj);
        else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }

        }
        return result;
    }

    public static Tbl createTable(int rows, int cols, Tbl tbl, int cellWidthTwips, MainDocumentPart documentPart) {
        // w:tblPr
        String strTblPr =  "<w:tblPr " + Namespaces.W_NAMESPACE_DECLARATION + ">"
                + "<w:tblStyle w:val=\"TableGrid\"/>"
                + 	"<w:tblW w:w=\"0\" w:type=\"auto\"/>"
                +   "<w:tblLook w:val=\"04A0\"/>"
                + "</w:tblPr>";
        TblPr tblPr = null;
        try {
            tblPr = (TblPr) XmlUtils.unmarshalString(strTblPr);
        } catch (JAXBException e) {
            // Shouldn't happen
            e.printStackTrace();
        }
        tbl.setTblPr(tblPr);

        // <w:tblGrid><w:gridCol w:w="4788"/>
        TblGrid tblGrid = Context.getWmlObjectFactory().createTblGrid();
        tbl.setTblGrid(tblGrid);
        // Add required <w:gridCol w:w="4788"/>
        for (int i = 1 ; i <= cols; i++) {
            TblGridCol gridCol = Context.getWmlObjectFactory().createTblGridCol();
            gridCol.setW(BigInteger.valueOf(cellWidthTwips));
            tblGrid.getGridCol().add(gridCol);
        }

        // Now the rows
        for (int j = 1 ; j <= rows; j++) {
            Tr tr = Context.getWmlObjectFactory().createTr();
            tbl.getEGContentRowContent().add(tr);

            // The cells
            for (int i = 1 ; i <= cols; i++) {

                Tc tc = Context.getWmlObjectFactory().createTc();
                tr.getEGContentCellContent().add(tc);

                TcPr tcPr = Context.getWmlObjectFactory().createTcPr();
                tc.setTcPr(tcPr);
                // <w:tcW w:w="4788" w:type="dxa"/>
                TblWidth cellWidth = Context.getWmlObjectFactory().createTblWidth();
                tcPr.setTcW(cellWidth);
                cellWidth.setType("dxa");
                cellWidth.setW(BigInteger.valueOf(cellWidthTwips));

                // Cell content - an empty <w:p/>
                tc.getEGBlockLevelElts().add(
                        Context.getWmlObjectFactory().createP()
                );
            }

        }
        return tbl;
    }

}
