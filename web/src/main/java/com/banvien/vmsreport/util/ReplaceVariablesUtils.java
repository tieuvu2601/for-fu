package com.banvien.vmsreport.util;
import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/23/15
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReplaceVariablesUtils{
    public static void replace(String docx, String outputDocx, HashMap<String, String> variableMappings, List<String[]> resultLabelHeader, Object[] resultMap) {
        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(docx));
            VariablePrepare.prepare(wordMLPackage);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            documentPart.variableReplace(variableMappings);
            for (int i = 0; i < resultMap.length; i++){
                if (resultMap[i] != null){
                    List<Map<String, String>> textToAdd = (List<Map<String, String>>) resultMap[i];
                    String[] labelHeader = resultLabelHeader.get(i);
                    replaceTable(labelHeader, textToAdd, wordMLPackage);
                    AddColumn(labelHeader, textToAdd, wordMLPackage);
                }
            }

//            List<String> list = new ArrayList<>();
//            list.add("nhaThau1");
//            list.add("nhaThau2");
//            list.add("nhaThau3");
//            list.add("nhaThau4");
//            list.add("nhaThau5");
//
//            replaceBulletList("listNhaThauCT", list, documentPart);
            wordMLPackage.save(new File(outputDocx));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replace(String docx, String outputDocx, HashMap<String, String> variableMappings) {
        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(docx));
            VariablePrepare.prepare(wordMLPackage);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            documentPart.variableReplace(variableMappings);
            wordMLPackage.save(new File(outputDocx));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AddColumn(String[] placeholders, List<Map<String, String>> listText,
                                 WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {
        String xpath = "//w:tr[w:tc[w:p[w:r[w:t[contains(text(),'" + placeholders[0] + "')]]]]]";
        List<Object> objectsContent = wordMLPackage.getMainDocumentPart().getJAXBNodesViaXPath(xpath, false);
        for (Object obj : objectsContent){
            Object tbl = ((Tr)obj).getParent();
            List<Object> contentTbl = ((Tbl)tbl).getContent();
            Boolean flag =true;
            int width = 0;
            for (Map<String, String> mapText : listText){
                int indexText = 0;
                for (int i = 0; i < contentTbl.size(); i++){
                    try {
                        List<Object> contentTr = ((Tr)contentTbl.get(i)).getContent();
                        if (width == 0){
                            width = ((Tc)((JAXBElement)contentTr.get(2)).getValue()).getTcPr().getTcW().getW().intValue();
                        }
                        P p = (P)(((Tc)((JAXBElement)contentTr.get(2)).getValue()).getContent().get(0));
                        R r = (R)p.getContent().get(0);
                        Text t = (Text)((JAXBElement)r.getContent().get(0)).getValue();
                        Tc tc = createTc(mapText, t.getValue(), (int)width/listText.size());
//                        tc.setTcPr(((Tc)((JAXBElement)contentTr.get(1)).getValue()).getTcPr());
                        if (listText.indexOf(mapText) == listText.size() - 1){
                            contentTr.remove(2);
                        }
                        contentTr.add(tc);

                    }catch (Exception e){}
                }
                flag = false;
            }
        }
    }

    public static void replaceBulletList(String placeholders, List<String> textToAdd,
                                         WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {

        String xpath = "//w:p[w:r[w:t[contains(text(),'" + placeholders + "')]]]";
        List<Object> objectsContent = wordMLPackage.getMainDocumentPart().getJAXBNodesViaXPath(xpath, false);
        for (Object obj : objectsContent){
            List<Object> parentContent = ((Tc)((P)obj).getParent()).getContent();
            ((P)obj).getContent().clear();
            for (int i = 0; i < textToAdd.size(); i++){
                P p  = createUnnumberedList(textToAdd, i);
                p.setPPr(((P) obj).getPPr());
                parentContent.add(p);
            }
            parentContent.remove(0);
        }

    }
    private static Tc createTc(Map<String, String> mapText, String headerlabel, int width) throws JAXBException, Docx4JException {
        ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
        Tc tc = factory.createTc();
        P  p = factory.createP();

        org.docx4j.wml.Text  t = factory.createText();
        t.setValue(mapText.get(headerlabel));

        org.docx4j.wml.R  run = factory.createR();
        run.getContent().add(t);

        p.getContent().add(run);

        org.docx4j.wml.PPr ppr = factory.createPPr();

        p.setPPr( ppr );

        BigInteger w = BigInteger.valueOf(width);
        TblWidth tblWidth = factory.createTblWidth();
        tblWidth.setW(w);

        TcPr tcPr = factory.createTcPr();
        tcPr.setTcW(tblWidth);

        tc.setTcPr(tcPr);
        tc.getContent().add(p);
        return tc;
    }

    public static P createUnnumberedList(List<String> list, int i) throws Docx4JException, JAXBException {
        ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
        P  p = factory.createP();

        org.docx4j.wml.Text  t = factory.createText();
        t.setValue(list.get(i));

        org.docx4j.wml.R  run = factory.createR();
        run.getContent().add(t);

        p.getContent().add(run);

        org.docx4j.wml.PPr ppr = factory.createPPr();

        p.setPPr( ppr );

        return p;
    }

    public static void replaceTable(String[] placeholders, List<Map<String, String>> textToAdd,
                                     WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {

        List<Object> tables = getAllElementFromObject(wordMLPackage.getMainDocumentPart(), Tbl.class);

        // 1. find the table
        Tbl tempTable = getTemplateTable(tables, placeholders[0]);
        List<Object> rows = new ArrayList<>();
        if (tempTable != null ){
            rows = getAllElementFromObject(tempTable, Tr.class);
        }

        // first row is header, second row is content
        if (rows.size() == 2) {
            // this is our template row
            Tr templateRow = (Tr) rows.get(1);

            for (Map<String, String> replacements : textToAdd) {
                // 2 and 3 are done in this method
                addRowToTable(tempTable, templateRow, replacements);
            }

            // 4. remove the template row
            tempTable.getContent().remove(templateRow);
        }
    }

    private static Tc createTc(String s) {
        ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
        Tc tc = factory.createTc();
        P  p = factory.createP();

        org.docx4j.wml.Text  t = factory.createText();
        t.setValue(s);

        org.docx4j.wml.R  run = factory.createR();
        run.getContent().add(t);

        p.getContent().add(run);

        org.docx4j.wml.PPr ppr = factory.createPPr();

        p.setPPr( ppr );
        tc.getContent().add(p);

        return tc;
    }

    private static Tbl getTemplateTable(List<Object> tables, String templateKey) throws Docx4JException, JAXBException {
        for (Iterator<Object> iterator = tables.iterator(); iterator.hasNext();) {
            Object tbl = iterator.next();
            List<?> textElements = getAllElementFromObject(tbl, Text.class);
            for (Object text : textElements) {
                Text textElement = (Text) text;
                if (textElement.getValue() != null && textElement.getValue().equals(templateKey))
                    return (Tbl) tbl;
            }
        }
        return null;
    }

    private static void addRowToTable(Tbl reviewtable, Tr templateRow, Map<String, String> replacements) {
        Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
        List<?> textElements = getAllElementFromObject(workingRow, Text.class);
        for (Object object : textElements) {
            Text text = (Text) object;
            String replacementValue = (String) replacements.get(text.getValue());
            if (replacementValue != null)
                text.setValue(replacementValue);
        }
        reviewtable.getContent().add(workingRow);
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

    public static Tbl createTable(int rows, int cols, int cellWidthTwips, Tbl tbl) {

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
