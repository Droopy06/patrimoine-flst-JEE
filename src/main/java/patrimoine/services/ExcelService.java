package patrimoine.services;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.IOException;

/**
 * Created by LAMOOT Alexandre on 24/11/2016.
 */
public interface ExcelService{

    void loadFileExcelCollectionImport(String name) throws IOException, BiffException;
    void readFileExcelCollectionImport(String object) throws IOException, BiffException;
    void readFileExcelHeaderImport(String object) throws IOException, BiffException;
    void readFileExcelHerbiers() throws IOException, BiffException;
    void readFileExcelInstruments() throws IOException, BiffException;
    void readFileExcelJardinBotanique() throws IOException, BiffException;
    void readFileExcelMaterielPedagogique() throws IOException, BiffException;
    void readFileExcelMineralogieCristallographie() throws IOException, BiffException;
    void readFileExcelOuvragesCartesDocuments() throws IOException, BiffException;
    void readFileExcelPaleontologieAnimale() throws IOException, BiffException;
    void readFileExcelPaleontologieVegetale() throws IOException, BiffException;
    void readFileExcelPedagogique() throws IOException, BiffException;
    void readFileExcelPetrographie() throws IOException, BiffException;
    void readFileExcelPhysique() throws IOException, BiffException;
    void readFileExcelTypotheque() throws IOException, BiffException;
    void readFileExcelZoologieInvertebresAutres() throws IOException, BiffException;
    void readFileExcelZoologieInvertebresInsectes() throws IOException, BiffException;
    void readFileExcelZoologieInvertebresMollusque() throws IOException, BiffException;
    void readFileExcelZoologieVertebresAutres() throws IOException, BiffException;
    void readFileExcelZoologieVertebresMammiferes() throws IOException, BiffException;
    void readFileExcelZoologieVertebresOiseaux() throws IOException, BiffException;
    void readFileExcelZoologieVertebresPoissons() throws IOException, BiffException;
    void readFileExcelZoologieVertebresPrimates() throws IOException, BiffException;
    void readFileExcelZoologieVertebresReptile() throws IOException, BiffException;
    void writeFileExcelExport(String object) throws IOException, BiffException, WriteException;
    void writeFileExcelHeaderExport(String object) throws IOException, BiffException, WriteException;
    void writeFileExcelHerbiers() throws IOException, BiffException, WriteException;
    void writeFileExcelInstruments() throws IOException, BiffException, WriteException;
    void writeFileExcelJardinBotanique() throws IOException, BiffException, WriteException;
    void writeFileExcelMaterielPedagogique() throws IOException, BiffException, WriteException;
    void writeFileExcelMineralogieCristallographie() throws IOException, BiffException, WriteException;
    void writeFileExcelOuvragesCartesDocuments() throws IOException, BiffException, WriteException;
    void writeFileExcelPaleontologieAnimale() throws IOException, BiffException, WriteException;
    void writeFileExcelPaleontologieVegetale() throws IOException, BiffException, WriteException;
    void writeFileExcelPedagogique() throws IOException, BiffException, WriteException;
    void writeFileExcelPetrographie() throws IOException, BiffException, WriteException;
    void writeFileExcelPhysique() throws IOException, BiffException, WriteException;
    void writeFileExcelTypotheque() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieInvertebresAutres() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieInvertebresInsectes() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieInvertebresMollusque() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieVertebresAutres() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieVertebresMammiferes() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieVertebresOiseaux() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieVertebresPoissons() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieVertebresPrimates() throws IOException, BiffException, WriteException;
    void writeFileExcelZoologieVertebresReptile() throws IOException, BiffException, WriteException;
}
